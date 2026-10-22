package com.ttnet.org.chromium.base;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import android.provider.DocumentsContract;
import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.security.android.aopcheck.ContentResolverWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes41.dex */
public abstract class ContentUriUtils {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final String TAG = "ContentUriUtils";
    private static FileProviderUtil sFileProviderUtil;
    private static final Object sLock = null;

    public interface FileProviderUtil {
        Uri getContentUriFromFile(File r100);
    }

    private ContentUriUtils() {
    }

    static {
        sLock = new Object();
    }

    public static boolean contentUriExists(String r100) {
        AssetFileDescriptor r101 = getAssetFileDescriptor(r100);     // Catch: Throwable -> L9
        if (r101 == null) goto L5;
        boolean r102 = true;
    L6:
        if (r101 != null) goto L12;
    L8:
        return r102;
    L12:
        r101.close();     // Catch: IOException -> L11
        goto L8
    L5:
        r102 = false;
    L9:
        th = move-exception;
        throw th;
    }

    public static boolean delete(String r100) {
        Uri r101 = UriProtector.parse(r100);
        if (com_ttnet_org_chromium_base_ContentUriUtils_android_content_ContentResolver_delete(ContextUtils.getApplicationContext().getContentResolver(), r101, null, null) <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    private static AssetFileDescriptor getAssetFileDescriptor(String r110) {
        ContentResolver r100 = ContextUtils.getApplicationContext().getContentResolver();
        Uri r101 = UriProtector.parse(r110);
    L23:
        e = move-exception;
        Log.w(TAG, "Cannot open content uri: %s", new Object[]{r110, e});
    L25:
        return null;
    L4:
        if (isVirtualDocument(r101) == false) goto L19;
        String[] r102 = r100.getStreamTypes(r101, "*/*");     // Catch: Exception -> L23
        if (r102 == null) goto L25;
        if (r102.length <= 0) goto L25;
        AssetFileDescriptor r103 = r100.openTypedAssetFileDescriptor(r101, r102[0], null);     // Catch: Exception -> L23
        if (r103 != null) goto L13;
    L18:
        return r103;
    L13:
        if (r103.getStartOffset() == 0) goto L18;
        r103.close();     // Catch: IOException -> L26 Exception -> L23
    L17:
        throw new SecurityException("Cannot open files with non-zero offset type.");     // Catch: Exception -> L23
    L19:
        ParcelFileDescriptor r104 = com_ttnet_org_chromium_base_ContentUriUtils_android_content_ContentResolver_openFileDescriptor(r100, r101, "r");     // Catch: Exception -> L23
        if (r104 == null) goto L25;
        return new AssetFileDescriptor(r104, 0, -1);
    }

    public static Uri getContentUriFromFile(File r100) {
        Object r101 = sLock;
        monitor-enter(r101);
        FileProviderUtil r102 = sFileProviderUtil;     // Catch: Throwable -> L12
        if (r102 == null) goto L9;
        Uri r103 = r102.getContentUriFromFile(r100);     // Catch: Throwable -> L12
        monitor-exit(r101);     // Catch: Throwable -> L12
        return r103;
    L9:
        monitor-exit(r101);     // Catch: Throwable -> L12
        return null;
    L12:
        th = move-exception;
        throw th;
    }

    public static String getContentUriFromFilePath(String r100) {
        Uri r101 = getContentUriFromFile(new PolarisFileWrapper(r100));     // Catch: IllegalArgumentException -> L6
        if (r101 == null) goto L12;
        return r101.toString();
    L12:
        return null;
    L6:
        e = move-exception;
        Log.e(TAG, "Cannot retrieve content uri from file: %s", new Object[]{r100, e});
        return null;
    }

    public static String getMimeType(String r100) {
        ContentResolver r101 = ContextUtils.getApplicationContext().getContentResolver();
        Uri r102 = UriProtector.parse(r100);
        if (isVirtualDocument(r102) == false) goto L12;
        String[] r103 = r101.getStreamTypes(r102, "*/*");
        if (r103 != null) goto L7;
    L9:
        return null;
    L7:
        if (r103.length <= 0) goto L9;
        return r103[0];
    L12:
        return r101.getType(r102);
    }

    private static boolean hasVirtualFlag(Cursor r100) {
        if (Build.VERSION.SDK_INT >= 24) goto L5;
        return false;
    L5:
        int r101 = r100.getColumnIndex("flags");
        if (r101 > (-1)) goto L8;
        return false;
    L8:
        if ((r100.getLong(r101) & 512) == 0) goto L12;
        return true;
    L12:
        return false;
    }

    public static boolean isContentUri(String r100) {
        if (r100 != null) goto L5;
        return false;
    L5:
        Uri r101 = UriProtector.parse(r100);
        if (r101 != null) goto L8;
        return false;
    L8:
        if ("content".equals(r101.getScheme()) == false) goto L12;
        return true;
    L12:
        return false;
    }

    private static boolean isVirtualDocument(Uri r100) {
        if (r100 != null) goto L6;
        return false;
    L6:
        if (DocumentsContract.isDocumentUri(ContextUtils.getApplicationContext(), r100) == true) goto L30;
        return false;
    L30:
        Cursor r101 = com_ttnet_org_chromium_base_ContentUriUtils_android_content_ContentResolver_query(ContextUtils.getApplicationContext().getContentResolver(), r100, null, null, null, null);     // Catch: NullPointerException -> L25
        if (r101 != null) goto L26;
    L22:
        if (r101 == null) goto L24;
        r101.close();     // Catch: NullPointerException -> L25
        goto L24
    L26:
    L16:
        th = move-exception;
        r101.close();     // Catch: Throwable -> L19
    L21:
        throw th;     // Catch: NullPointerException -> L25
    L19:
        th = move-exception;
        th.addSuppressed(th);     // Catch: NullPointerException -> L25
        goto L21
    L12:
        if (r101.getCount() < 1) goto L22;
        r101.moveToFirst();     // Catch: Throwable -> L16
        boolean r102 = hasVirtualFlag(r101);     // Catch: Throwable -> L16
        r101.close();     // Catch: NullPointerException -> L25
        return r102;
    L24:
        return false;
    }

    public static String maybeGetDisplayName(String r100) {
        String r101 = getDisplayName(UriProtector.parse(r100), ContextUtils.getApplicationContext(), "_display_name");     // Catch: Exception -> L8
        if (TextUtils.isEmpty(r101) == false) goto L7;
        return null;
    L7:
        return r101;
    L8:
        e = move-exception;
        Log.w(TAG, "Cannot open content uri: %s", new Object[]{r100, e});
        return null;
    }

    public static int openContentUriForRead(String r100) {
        AssetFileDescriptor r101 = getAssetFileDescriptor(r100);
        if (r101 != null) goto L5;
        return -1;
    L5:
        return r101.getParcelFileDescriptor().detachFd();
    }

    public static void setFileProviderUtil(FileProviderUtil r100) {
        Object r101 = sLock;
        monitor-enter(r101);
        sFileProviderUtil = r100;     // Catch: Throwable -> L7
        monitor-exit(r101);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private static ParcelFileDescriptor com_ttnet_org_chromium_base_ContentUriUtils_android_content_ContentResolver_openFileDescriptor(ContentResolver r110, Uri r111, String r210) {
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

    public static String getDisplayName(Uri r100, Context r101, String r102) {
        if (r100 != null) goto L5;
        return "";
    L5:
        ContentResolver r103 = r101.getContentResolver();
        Cursor r104 = com_ttnet_org_chromium_base_ContentUriUtils_android_content_ContentResolver_query(r103, r100, null, null, null, null);     // Catch: NullPointerException -> L35
        if (r104 != null) goto L36;
    L32:
        if (r104 == null) goto L34;
        r104.close();     // Catch: NullPointerException -> L35
        goto L34
    L36:
    L26:
        th = move-exception;
        r104.close();     // Catch: Throwable -> L29
    L31:
        throw th;     // Catch: NullPointerException -> L35
    L29:
        th = move-exception;
        th.addSuppressed(th);     // Catch: NullPointerException -> L35
        goto L31
    L9:
        if (r104.getCount() < 1) goto L32;
        r104.moveToFirst();     // Catch: Throwable -> L26
        int r105 = r104.getColumnIndex(r102);     // Catch: Throwable -> L26
        if (r105 != (-1)) goto L15;
        r104.close();     // Catch: NullPointerException -> L35
        return "";
    L15:
        String r106 = r104.getString(r105);     // Catch: Throwable -> L26
        if (hasVirtualFlag(r104) == false) goto L24;
        String[] r107 = r103.getStreamTypes(r100, "*/*");     // Catch: Throwable -> L26
        if (r107 == null) goto L24;
        if (r107.length <= 0) goto L24;
        String r108 = MimeTypeMap.getSingleton().getExtensionFromMimeType(r107[0]);     // Catch: Throwable -> L26
        if (r108 == null) goto L24;
        r106 = r106 + "." + r108;     // Catch: Throwable -> L26
    L24:
        r104.close();     // Catch: NullPointerException -> L35
        return r106;
    L34:
        return "";
    }

    private static int com_ttnet_org_chromium_base_ContentUriUtils_android_content_ContentResolver_delete(ContentResolver r110, Uri r111, String r210, String[] r211) {
        ArrayList r100 = new ArrayList();
        Object[] r101 = {r111, r210, r211};
        f06.b r112 = new f06.b();
        g06.a r102 = ApiHookConfig.f245611b.get(240019);
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
        f06.d r107 = r106.preInvoke(240019, "android/content/ContentResolver", "delete", r110, r101, "int", r112);     // Catch: Exception -> L22
        if (r107.f474982a == true) goto L17;
        r100.add(r106);     // Catch: Exception -> L22
    L17:
        if (r107.f474982a == false) goto L21;
        return ((Integer) r107.f474983b).intValue();
    L21:
        return r110.delete(r111, r210, r211);
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

    private static Cursor com_ttnet_org_chromium_base_ContentUriUtils_android_content_ContentResolver_query(ContentResolver r110, Uri r111, String[] r112, String r113, String[] r114, String r115) {
        f06.c r100 = new f06.c();
        Object[] r101 = {r111, r112, r113, r114, r115};
        f06.b r116 = new f06.b();
        f06.d r117 = r100.b(240004, "android/content/ContentResolver", "query", r110, r101, "android.database.Cursor", r116);
        if (r117.f474982a == false) goto L6;
        r100.a(240004, "android/content/ContentResolver", "query", r110, r101, null, r116, false);
        return (Cursor) r117.f474983b;
    L6:
        Cursor r118 = r110.query(r111, r112, r113, r114, r115);
        r100.a(240004, "android/content/ContentResolver", "query", r110, r101, r118, r116, true);
        return r118;
    }
}
