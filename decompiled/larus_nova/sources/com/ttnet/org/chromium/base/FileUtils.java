package com.ttnet.org.chromium.base;

import android.content.ContentResolver;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.bytedance.security.android.aopcheck.ContentResolverWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.facebook.cache.disk.DefaultDiskStorage;
import com.ttnet.org.chromium.base.annotations.JNINamespace;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileDescriptor;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: classes41.dex */
@JNINamespace("base::android")
public class FileUtils {
    public static Function<String, Boolean> DELETE_ALL = null;
    private static final String TAG = "FileUtils";

    public interface Natives {
        String getAbsoluteFilePath(String r100);
    }

    public FileUtils() {
    }

    public static /* synthetic */ Boolean a(String r100) {
        return lambda$static$0(r100);
    }

    static {
        DELETE_ALL = new c();
    }

    public static String getAbsoluteFilePath(String r100) {
        return FileUtilsJni.get().getAbsoluteFilePath(r100);
    }

    public static String getExtension(String r100) {
        int r101 = r100.lastIndexOf(47);
        int r102 = r100.lastIndexOf(46);
        if (r101 < r102) goto L7;
        return "";
    L7:
        return r100.substring(r102 + 1).toLowerCase(Locale.US);
    }

    public static long getFileSizeBytes(File r100) {
        long r101 = 0;
        if (r100 != null) goto L6;
        return 0;
    L6:
        if (r100.isDirectory() == false) goto L15;
        File[] r102 = r100.listFiles();
        if (r102 != null) goto L10;
        return 0;
    L10:
        int r103 = r102.length;
        int r104 = 0;
    L11:
        if (r104 >= r103) goto L13;
        r101 = r101 + getFileSizeBytes(r102[r104]);
        r104 = r104 + 1;
        goto L11
    L13:
        return r101;
    L15:
        return r100.length();
    }

    public static Uri getUriForFile(File r100) {
        Uri r101 = ContentUriUtils.getContentUriFromFile(r100);     // Catch: IllegalArgumentException -> L4
    L6:
        if (r101 == null) goto L8;
        return r101;
    L8:
        return Uri.fromFile(r100);
    L4:
        e = move-exception;
        Log.e(TAG, "Could not create content uri: " + e, new Object[0]);
        r101 = null;
        goto L6
    }

    private static /* synthetic */ Boolean lambda$static$0(String r100) {
        return Boolean.TRUE;
    }

    public static byte[] readStream(InputStream r100) throws IOException {
        ByteArrayOutputStream r101 = new ByteArrayOutputStream();
        copyStream(r100, r101);
        return r101.toByteArray();
    }

    public static void batchDeleteFiles(List<String> r100, Function<String, Boolean> r101) {
        Iterator<String> r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L16;
        String r103 = r102.next();
        if (r101 == null) goto L11;
        if (r101.apply(r103).booleanValue() == false) goto L4;
    L11:
        if (ContentUriUtils.isContentUri(r103) == true) goto L12;
        PolarisFileWrapper r104 = new PolarisFileWrapper(r103);
        if (r104.exists() == false) goto L4;
        recursivelyDeleteFile(r104, r101);
        goto L4
    L12:
        ContentUriUtils.delete(r103);
        goto L4
    }

    public static void copyStream(InputStream r100, OutputStream r101) throws IOException {
        byte[] r102 = new byte[8192];
    L3:
        int r103 = r100.read(r102);
        if (r103 == (-1)) goto L6;
        r101.write(r102, 0, r103);
        goto L3
    }

    public static void copyStreamToFile(InputStream r100, File r101) throws IOException {
        PolarisFileWrapper r102 = new PolarisFileWrapper(r101.getPath() + DefaultDiskStorage.FileType.TEMP);
        PolarisFileOutputStreamWrapper r103 = new PolarisFileOutputStreamWrapper(r102);
        Log.i(TAG, "Writing to %s", new Object[]{r101});     // Catch: Throwable -> L9
        copyStream(r100, r103);     // Catch: Throwable -> L9
        r103.close();
        if (r102.renameTo(r101) == false) goto L8;
        return;
    L8:
        throw new IOException();
    L9:
        th = move-exception;
        r103.close();     // Catch: Throwable -> L12
    L14:
        throw th;
    L12:
        th = move-exception;
        th.addSuppressed(th);
        goto L14
    }

    public static Bitmap queryBitmapFromContentProvider(Context r100, Uri r101) {
        ParcelFileDescriptor r102 = com_ttnet_org_chromium_base_FileUtils_android_content_ContentResolver_openFileDescriptor(r100.getContentResolver(), r101, "r");     // Catch: IOException -> L28
        if (r102 != null) goto L9;
        Log.w(TAG, "Null ParcelFileDescriptor from uri " + r101, new Object[0]);     // Catch: Throwable -> L21
        if (r102 == null) goto L8;
        r102.close();     // Catch: IOException -> L28
    L8:
        return null;
    L9:
        FileDescriptor r103 = r102.getFileDescriptor();     // Catch: Throwable -> L21
        if (r103 != null) goto L14;
        Log.w(TAG, "Null FileDescriptor from uri " + r101, new Object[0]);     // Catch: Throwable -> L21
        r102.close();     // Catch: IOException -> L28
        return null;
    L14:
        Bitmap r104 = BitmapFactory.decodeFileDescriptor(r103);     // Catch: Throwable -> L21
        if (r104 != null) goto L19;
        Log.w(TAG, "Failed to decode image from uri " + r101, new Object[0]);     // Catch: Throwable -> L21
        r102.close();     // Catch: IOException -> L28
        return null;
    L19:
        r102.close();     // Catch: IOException -> L28
        return r104;
    L21:
        th = move-exception;
        if (r102 != null) goto L32;
    L27:
        throw th;     // Catch: IOException -> L28
    L32:
        r102.close();     // Catch: Throwable -> L25
    L25:
        th = move-exception;
        th.addSuppressed(th);     // Catch: IOException -> L28
    L28:
        Log.w(TAG, "IO exception when reading uri " + r101, new Object[0]);
        return null;
    }

    public static boolean recursivelyDeleteFile(File r100, Function<String, Boolean> r101) {
        if (r100.exists() == true) goto L6;
        r100.delete();
        return true;
    L6:
        if (r101 == null) goto L11;
        if (r101.apply(r100.getPath()).booleanValue() == true) goto L11;
        return true;
    L11:
        if (r100.isDirectory() == false) goto L17;
        File[] r102 = r100.listFiles();
        if (r102 == null) goto L17;
        int r103 = r102.length;
        int r104 = 0;
    L15:
        if (r104 >= r103) goto L17;
        recursivelyDeleteFile(r102[r104], r101);
        r104 = r104 + 1;
    L17:
        boolean r105 = r100.delete();
        if (r105 == true) goto L20;
        Log.e(TAG, "Failed to delete: %s", new Object[]{r100});
    L20:
        return r105;
    }

    private static ParcelFileDescriptor com_ttnet_org_chromium_base_FileUtils_android_content_ContentResolver_openFileDescriptor(ContentResolver r110, Uri r111, String r210) {
        ArrayList r100 = new ArrayList();
        Object[] r101 = {r111, r210};
        f06.b r112 = new f06.b();
        g06.a r102 = ApiHookConfig.f245611b.get(240020);
        if (r102 == null) goto L5;
        f06.a[] r103 = r102.f479473i;
    L6:
        f06.a[] r113 = r103;
        int r104 = r113.length;
        int r105 = 0;
    L8:
        if (r105 >= r104) goto L15;
        f06.a r106 = r113[r105];
        int r114 = r105;
        int r115 = r104;
        f06.d r107 = r106.preInvoke(240020, "android/content/ContentResolver", "openFileDescriptor", r110, r101, "android.os.ParcelFileDescriptor", r112);     // Catch: Exception -> L22
        if (r107.f474982a == true) goto L17;
        r100.add(r106);     // Catch: Exception -> L22
    L17:
        if (r107.f474982a == false) goto L21;
        return (ParcelFileDescriptor) r107.f474983b;
    L21:
        return ContentResolverWrapper.openFileDescriptor(r110, r111, r210);
    L14:
        r105 = r114 + 1;
        r104 = r115;
        goto L8
    L15:
        r107 = new f06.d(false, null);
        goto L17
    L5:
        r103 = ApiHookConfig.f245613d;
        goto L6
    }
}
