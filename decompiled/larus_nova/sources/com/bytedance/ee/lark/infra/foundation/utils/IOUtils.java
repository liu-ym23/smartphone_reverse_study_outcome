package com.bytedance.ee.lark.infra.foundation.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.os.StatFs;
import android.text.TextUtils;
import androidx.camera.video.AudioStats;
import androidx.collection.SieveCacheKt;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.ee.bear.libarchive.Archive;
import com.bytedance.ee.lark.infra.foundation.log.AppBrandLogger;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWriterWrapper;
import com.bytedance.security.android.aopcheck.PolarisZipFileWrapper;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.text.DecimalFormat;
import java.util.Enumeration;
import java.util.LinkedList;
import java.util.Locale;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import kotlin.io.FilesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public class IOUtils {
    private static final String EXTERNAL_STORAGE_PERMISSION = "android.permission.WRITE_EXTERNAL_STORAGE";
    public static final int FILE_LENGTH_CALCULATION_TIMEOUT = 5000;
    private static final long MB = 1048576;
    private static final String[] PATH_PROJECTION = null;
    private static final String PATH_SELECTION = "kind = 1 AND video_id = ?";
    private static final String TAG = "IOUtils";

    public IOUtils() {
    }

    static {
        PATH_PROJECTION = new String[]{"_data"};
    }

    private static MessageDigest getMessageDigest() {
        return MessageDigest.getInstance("MD5");
    L4:
        e = move-exception;
        AppBrandLogger.e(TAG, new Object[]{"Exception while getting digest", e});
        return null;
    }

    public static String calculateMD5(File r100) {
        return calculateMD5(r100, 1024);
    }

    public static void clearDir(String r100) throws Exception {
        PolarisFileWrapper r101 = a.a(r100);
        if (r101.exists() == true) goto L5;
        return;
    L5:
        File[] r102 = r101.listFiles();
        int r103 = r102.length;
        int r104 = 0;
    L6:
        if (r104 >= r103) goto L14;
        if (r102[r104].isDirectory() == false) goto L11;
        removeDir(r102[r104].getAbsolutePath());
    L13:
        r104 = r104 + 1;
        goto L6
    L11:
        if (r102[r104].isFile() == false) goto L13;
        r102[r104].delete();
        goto L13
    }

    public static void close(Closeable r100) {
        if (r100 == null) goto L10;
        r100.close();     // Catch: IOException -> L5
        return;
    L5:
        e = move-exception;
        AppBrandLogger.eWithThrowable(TAG, "", e);
        return;
    }

    public static boolean createFile(String r100) {
        return a.a(r100).createNewFile();
    L4:
        e = move-exception;
        e.printStackTrace();
        return false;
    }

    public static Bitmap decodeFile(File r100) {
        PolarisFileInputStreamWrapper r101 = null;
        Bitmap r102 = null;
        r102 = null;
        r102 = null;
        BitmapFactory.Options r103 = new BitmapFactory.Options();     // Catch: Throwable -> L11 FileNotFoundException -> L13
        int r104 = a.f242800a;     // Catch: Throwable -> L11 FileNotFoundException -> L13
        PolarisFileInputStreamWrapper r105 = new PolarisFileInputStreamWrapper(r100);     // Catch: Throwable -> L11 FileNotFoundException -> L13
        r102 = BitmapFactory.decodeStream(r105, null, r103);     // Catch: FileNotFoundException -> L9 Throwable -> L22
        r105.close();     // Catch: Exception -> L7
    L21:
        return r102;
    L7:
        e = move-exception;
        AppBrandLogger.stacktrace(6, TAG, e.getStackTrace());
    L9:
        e = e;
    L15:
        AppBrandLogger.stacktrace(6, TAG, e.getStackTrace());     // Catch: Throwable -> L22
        if (r105 == null) goto L21;
        r105.close();     // Catch: Exception -> L19
    L19:
        e = move-exception;
        AppBrandLogger.stacktrace(6, TAG, e.getStackTrace());
    L22:
        th = th;
        r101 = r105;
    L24:
        if (r101 != null) goto L34;
    L29:
        throw th;
    L34:
        r101.close();     // Catch: Exception -> L27
    L27:
        e = move-exception;
        AppBrandLogger.stacktrace(6, TAG, e.getStackTrace());
        goto L29
    L13:
        e = e;
        r105 = null;
    L11:
        th = th;
        goto L24
    }

    public static boolean delete(File r100) {
        AppBrandLogger.e(TAG, new Object[]{"delete", r100.getName()});
        if (r100.isFile() == false) goto L7;
        return r100.delete();
    L7:
        if (r100.isDirectory() == false) goto L24;
        File[] r101 = r100.listFiles();
        if (r101 == null) goto L23;
        if (r101.length == 0) goto L23;
        int r102 = 0;
        boolean r103 = true;
    L15:
        if (r102 >= r101.length) goto L21;
        boolean r104 = delete(r101[r102]);
        r103 = r103 & r104;
        if (r104 == true) goto L19;
        AppBrandLogger.e(TAG, new Object[]{"failed to delete file: ", r101[r102]});
    L19:
        r102 = r102 + 1;
        goto L15
    L21:
        return r100.delete() & r103;
    L23:
        return r100.delete();
    L24:
        AppBrandLogger.e(TAG, new Object[]{"invalid path: ", r100});
        return false;
    }

    public static boolean exists(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L7;
        AppBrandLogger.i(TAG, new Object[]{"exists->path is empty!"});
        return false;
    L7:
        return a.a(r100).exists();
    }

    public static long fileLength(File r110) {
        long r100 = 0;
        if (r110 != null) goto L6;
        return 0;
    L6:
        if (r110.isDirectory() == false) goto L8;
        long r101 = System.currentTimeMillis();
        LinkedList r102 = new LinkedList();
        r102.offer(r110);
        int r103 = 0;
        int r104 = 0;
    L11:
        if (r102.isEmpty() == true) goto L26;
        long r105 = System.currentTimeMillis() - r101;
        if (r105 > 5000) goto L14;
        int r106 = r102.size();
        r103 = r103 + 1;
    L17:
        if (r106 <= 0) goto L25;
        r106 = r106 - 1;
        File r107 = (File) r102.poll();
        r100 = r100 + r107.length();
        if (r107.isDirectory() == false) goto L17;
        File[] r108 = r107.listFiles();
        if (r108 == null) goto L17;
        int r109 = r108.length;
        int r111 = 0;
    L23:
        if (r111 >= r109) goto L17;
        r102.offer(r108[r111]);
        r111 = r111 + 1;
        goto L23
    L25:
        r104 = r104 + 1;
        goto L11
    L14:
        AppBrandLogger.e(TAG, new Object[]{"file length calculation timeout, cost:" + r105 + " current file count:" + (r103 + r102.size()) + " current depth:" + r104});
        return -1;
    L26:
        return r100;
    L8:
        return r110.length();
    }

    public static String fileSize(long r100) {
        if (r100 > 0) goto L6;
        return "0";
    L6:
        double r101 = r100;
        int r102 = (int) (Math.log10(r101) / Math.log10(1024.0d));
        return new DecimalFormat("#,##0.#").format(r101 / Math.pow(1024.0d, r102)) + " " + new String[]{"B", "kB", "MB", "GB", "TB"}[r102];
    }

    public static long getAvailSpace(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L6;
        AppBrandLogger.e(TAG, new Object[]{"getAvailSpace path is emtpy!"});
        return 0;
    L6:
        StatFs r101 = new StatFs(r100);
        return r101.getBlockSizeLong() * r101.getAvailableBlocksLong();
    }

    public static File getCacheDirectory(Context r100) {
        return getCacheDirectory(r100, true);
    }

    public static long getDirSizeNonRecursive(File r100) {
        long r101 = 0;
        if (r100 != null) goto L5;
    L12:
        return r101;
    L5:
        if (r100.exists() == false) goto L12;
        if (r100.isDirectory() == false) goto L12;
        File[] r102 = r100.listFiles();
        int r103 = r102.length;
        int r104 = 0;
    L10:
        if (r104 >= r103) goto L12;
        r101 = r101 + r102[r104].length();
        r104 = r104 + 1;
        goto L10
    }

    public static File getExternalCacheDir(Context r100) {
        String r101 = Environment.getExternalStorageState();     // Catch: Exception -> L4
    L6:
        if ("mounted".equals(r101) == false) goto L8;
        File r102 = r100.getExternalCacheDir();
    L9:
        if (r102 != null) goto L11;
        AppBrandLogger.e(TAG, new Object[]{"appDir null. mounted:" + r101});
    L11:
        return r102;
    L8:
        r102 = null;
    L4:
        r101 = "";
        goto L6
    }

    public static String getFileExtension(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return "";
    L5:
        int r101 = r100.lastIndexOf(".");
        if (r101 > 0) goto L8;
        return "";
    L8:
        return r100.substring(r101);
    }

    private static InputStream getInputStream(File r100) {
        int r101 = a.f242800a;     // Catch: FileNotFoundException -> L4
        return new PolarisFileInputStreamWrapper(r100);
    L4:
        e = move-exception;
        AppBrandLogger.e(TAG, new Object[]{"Exception while getting FileInputStream", e});
        return null;
    }

    public static String getSizeByUnit(double r100) {
        if (r100 != AudioStats.AUDIO_AMPLITUDE_NONE) goto L7;
        return "0K";
    L7:
        if (r100 < 1048576.0d) goto L11;
        return String.format(Locale.getDefault(), "%.1f", new Object[]{Double.valueOf(r100 / 1048576.0d)}) + "M";
    L11:
        return String.format(Locale.getDefault(), "%.1f", new Object[]{Double.valueOf(r100 / 1024.0d)}) + "K";
    }

    public static long getZipTrueSize(String r100) {
        long r101 = 0;
        Enumeration<? extends ZipEntry> r102 = new PolarisZipFileWrapper(r100).entries();     // Catch: IOException -> L8
    L5:
        if (r102.hasMoreElements() == false) goto L10;
        r101 = r101 + r102.nextElement().getSize();
    L10:
        return r101;
    L8:
        e = move-exception;
        AppBrandLogger.eWithThrowable(TAG, "", e);
        goto L10
    }

    private static boolean hasExternalStoragePermission(Context r100) {
        if (r100.checkCallingOrSelfPermission(EXTERNAL_STORAGE_PERMISSION) != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static boolean mkdir(String r100) {
        return a.a(r100).mkdirs();
    }

    public static byte[] readBytes(String r100) {
        int r101 = a.f242800a;     // Catch: Exception -> L4
        PolarisFileInputStreamWrapper r102 = new PolarisFileInputStreamWrapper(r100);     // Catch: Exception -> L4
        byte[] r103 = new byte[r102.available()];     // Catch: Exception -> L4
        r102.read(r103);     // Catch: Exception -> L4
        r102.close();     // Catch: Exception -> L4
        return r103;
    L4:
        e = move-exception;
        AppBrandLogger.eWithThrowable(TAG, "", e);
        return null;
    }

    public static void removeDir(String r100) throws Exception {
        delete(a.a(r100));
    }

    public static byte[] toByteArray(InputStream r100) throws IOException {
        ByteArrayOutputStream r101 = new ByteArrayOutputStream();
        copy(r100, r101);
        return r101.toByteArray();
    }

    public static void clearDir(File r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r100.exists() == true) goto L6;
        return;
    L6:
        if (r100.isDirectory() == false) goto L12;
        delete(r100);
        return;
    }

    public static String calculateMD5(File r100, int r101) {
        MessageDigest r102 = getMessageDigest();
        if (r102 != null) goto L6;
        AppBrandLogger.e(TAG, new Object[]{"digest is null"});
        return null;
    L6:
        InputStream r103 = getInputStream(r100);
        if (r103 != null) goto L27;
        AppBrandLogger.e(TAG, new Object[]{"inputStream is null"});
        return null;
    L27:
        String r104 = getMD5Str(r102, r103, new byte[r101]);     // Catch: Throwable -> L17 IOException -> L19
    L32:
        r103.close();     // Catch: IOException -> L14
    L16:
        return r104;
    L14:
        e = move-exception;
        AppBrandLogger.eWithThrowable(TAG, "", e);
    L19:
        e = move-exception;
        throw new RuntimeException("Unable to process file for MD5", e);     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        r103.close();     // Catch: IOException -> L24
    L26:
        throw th;
    L24:
        e = move-exception;
        AppBrandLogger.eWithThrowable(TAG, "", e);
        goto L26
    }

    public static boolean checkMD5(String r100, File r101) {
        if (TextUtils.isEmpty(r100) == true) goto L11;
        if (r101 == null) goto L11;
        String r102 = calculateMD5(r101);
        if (r102 != null) goto L10;
        return false;
    L10:
        return r102.toLowerCase().startsWith(r100.toLowerCase());
    L11:
        return false;
    }

    public static int copy(InputStream r100, OutputStream r101) throws IOException {
        long r102 = copyLarge(r100, r101);
        if (r102 <= SieveCacheKt.NodeLinkMask) goto L7;
        return -1;
    L7:
        return (int) r102;
    }

    private static void copyFile(InputStream r100, OutputStream r101) throws IOException {
        byte[] r102 = new byte[4096];
    L3:
        int r103 = r100.read(r102);
        if (r103 == (-1)) goto L6;
        r101.write(r102, 0, r103);
        goto L3
    }

    public static boolean copyFolder(File r100, File r101) {
        if (r100.isDirectory() == true) goto L5;
        PolarisFileInputStreamWrapper r102 = null;
        PolarisFileOutputStreamWrapper r103 = null;
        PolarisFileOutputStreamWrapper r104 = null;
        r102 = null;
        int r105 = a.f242800a;     // Catch: Throwable -> L40 IOException -> L42
        PolarisFileInputStreamWrapper r106 = new PolarisFileInputStreamWrapper(r100);     // Catch: Throwable -> L40 IOException -> L42
        PolarisFileOutputStreamWrapper r107 = a.b(r101);     // Catch: Throwable -> L36 IOException -> L38
    L86:
        byte[] r108 = new byte[1024];     // Catch: Throwable -> L32 IOException -> L34
    L19:
        int r109 = r106.read(r108);     // Catch: Throwable -> L32 IOException -> L34
        if (r109 <= 0) goto L80;
        r107.write(r108, 0, r109);     // Catch: Throwable -> L32 IOException -> L34
    L80:
        r106.close();     // Catch: IOException -> L25
    L74:
        r107.close();     // Catch: IOException -> L29
    L31:
        return true;
    L29:
        e = move-exception;
        AppBrandLogger.eWithThrowable(TAG, "", e);
    L25:
        e = move-exception;
        AppBrandLogger.eWithThrowable(TAG, "", e);
    L34:
        IOException e100 = e;
        r103 = r107;
    L39:
        PolarisFileOutputStreamWrapper r110 = r103;
        r102 = r106;
    L72:
        AppBrandLogger.eWithThrowable(TAG, "", e100);     // Catch: Throwable -> L56
        if (r102 != null) goto L68;
    L50:
        if (r110 != null) goto L76;
    L55:
        return false;
    L76:
        r110.close();     // Catch: IOException -> L53
    L53:
        e = move-exception;
        AppBrandLogger.eWithThrowable(TAG, "", e);
        goto L55
    L68:
        r102.close();     // Catch: IOException -> L48
    L48:
        e = move-exception;
        AppBrandLogger.eWithThrowable(TAG, "", e);
    L56:
        Throwable th10 = th;
    L57:
        if (r102 != null) goto L78;
    L62:
        if (r110 == null) goto L91;
        r110.close();     // Catch: IOException -> L65
        throw th10;
    L65:
        e = move-exception;
        AppBrandLogger.eWithThrowable(TAG, "", e);
        throw th10;
    L91:
        throw th10;
    L78:
        r102.close();     // Catch: IOException -> L60
    L60:
        e = move-exception;
        AppBrandLogger.eWithThrowable(TAG, "", e);
    L32:
        th10 = th;
        r104 = r107;
    L37:
        r110 = r104;
        r102 = r106;
    L38:
        e100 = e;
    L36:
        th10 = th;
        goto L37
    L42:
        e = move-exception;
        e100 = e;
        r110 = null;
    L40:
        th = move-exception;
        th10 = th;
        r110 = null;
        goto L57
    L5:
        if (r101.exists() == true) goto L7;
        r101.mkdirs();
    L7:
        String[] r111 = r100.list();
        int r112 = r111.length;
        int r113 = 0;
    L8:
        if (r113 >= r112) goto L13;
        String r114 = r111[r113];
        int r115 = a.f242800a;
        Intrinsics.checkNotNullParameter(r114, MapBundleKey.OfflineMapKey.OFFLINE_CHILD);
        PolarisFileWrapper r116 = new PolarisFileWrapper(r100, r114);
        Intrinsics.checkNotNullParameter(r114, MapBundleKey.OfflineMapKey.OFFLINE_CHILD);
        if (copyFolder(r116, new PolarisFileWrapper(r101, r114)) == false) goto L11;
        r113 = r113 + 1;
        goto L8
    L11:
        return false;
    L13:
        return true;
    }

    public static long copyLarge(InputStream r100, OutputStream r101) throws IOException {
        byte[] r102 = new byte[4096];
        long r103 = 0;
    L3:
        int r104 = r100.read(r102);
        if ((-1) == r104) goto L6;
        r101.write(r102, 0, r104);
        r103 = r103 + ((long) r104);
        goto L3
    L6:
        return r103;
    }

    public static File getCacheDirectory(Context r100, boolean r101) {
        String r102 = Environment.getExternalStorageState();     // Catch: Throwable -> L4
    L5:
        if (r101 == true) goto L7;
    L11:
        File r103 = null;
    L12:
        if (r103 != null) goto L14;
        r103 = r100.getCacheDir();
    L14:
        if (r103 == null) goto L16;
        return r103;
    L16:
        return a.a("/data/data/" + r100.getPackageName() + "/cache/");
    L7:
        if ("mounted".equals(r102) == false) goto L11;
        if (hasExternalStoragePermission(r100) == false) goto L11;
        r103 = getExternalCacheDir(r100);
    L4:
        r102 = "";
        goto L5
    }

    public static String getFromAssets(Context r100, String r101) {
        BufferedReader r102 = new BufferedReader(new InputStreamReader(r100.getResources().getAssets().open(r101)));     // Catch: Exception -> L9
        String r103 = "";
    L4:
        String r104 = r102.readLine();     // Catch: Exception -> L9
        if (r104 == null) goto L8;
        r103 = r103 + r104;     // Catch: Exception -> L9
        goto L4
    L8:
        return r103;
    L9:
        e = move-exception;
        AppBrandLogger.eWithThrowable(TAG, "", e);
        return "";
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r2v2 */
    public static byte[] getFromAssetsByte(Context r100, String r101) {
        ?? r102 = 0;
        InputStream r103 = r100.getResources().getAssets().open(r101);     // Catch: Throwable -> L12 Exception -> L14
        byte[] r104 = new byte[r103.available()];     // Catch: Exception -> L10 Throwable -> L23
        r103.read(r104);     // Catch: Exception -> L10 Throwable -> L23
        r103.close();     // Catch: Exception -> L7
    L9:
        return r104;
    L7:
        e = move-exception;
        AppBrandLogger.eWithThrowable(TAG, "", e);
    L10:
        e = e;
    L16:
        e.printStackTrace();     // Catch: Throwable -> L23
        if (r103 != null) goto L38;
    L22:
        return null;
    L38:
        r103.close();     // Catch: Exception -> L20
    L20:
        e = move-exception;
        AppBrandLogger.eWithThrowable(TAG, "", e);
        goto L22
    L23:
        th = th;
        r102 = r100;
    L25:
        if (r102 != 0) goto L31;
    L30:
        throw th;
    L31:
        r102.close();     // Catch: Exception -> L28
    L28:
        e = move-exception;
        AppBrandLogger.eWithThrowable(TAG, "", e);
    L14:
        e = e;
        r103 = null;
    L12:
        th = th;
        goto L25
    }

    public static boolean isSubPath(File r100, File r101) {
        if (r100 == null) goto L15;
        if (r101 == null) goto L15;
        File r102 = r101.getParentFile();
    L7:
        if (r102 == null) goto L15;
        if (FilesKt.startsWith(r102, r100) == false) goto L15;
        if (r102.equals(r100) == true) goto L12;
        r102 = r102.getParentFile();
        goto L7
    L12:
        return true;
    L15:
        return false;
    }

    public static String readString(String r100, String r101) {
        return new String(readBytes(r100), r101);
    L5:
        e = move-exception;
        AppBrandLogger.eWithThrowable(TAG, "", e);
        return null;
    }

    public static boolean setPermissions(String r100, int r101) {
        Object r102 = b.b(b.a(), new Object[]{r100, Integer.valueOf(r101), -1, -1});     // Catch: Exception -> L5
    L6:
        if (r102 == null) goto L8;
        return true;
    L8:
        AppBrandLogger.e(TAG, new Object[]{"setPermissions failed-->Path:" + r100});
        return false;
    L5:
        r102 = null;
        goto L6
    }

    public static int un7ZipFolder(String r100, String r101) throws Exception {
        if (TextUtils.isEmpty(r100) == false) goto L5;
    L11:
        AppBrandLogger.e(TAG, new Object[]{"SrcFile or destFold is empty"});
        return -1;
    L5:
        if (TextUtils.isEmpty(r101) == true) goto L11;
        if (r101.endsWith(HTTP.URL_DEFAULT) == true) goto L9;
        r101 = r101 + File.separator;
    L9:
        AppBrandLogger.i(TAG, new Object[]{"extract7z extractAll"});
        return Archive.extractAll(r100, r101, null, 0);
    }

    public static void unZipFolder(String r100, String r101) throws Exception {
        int r102 = a.f242800a;
        unZipFolder(new PolarisFileInputStreamWrapper(r100), r101, false);
    }

    public static void writeBytes(String r100, byte[] r101) throws IOException {
        if (r101 != null) goto L4;
        return;
    L4:
        if (r101.length == 0) goto L9;
        int r102 = a.f242800a;
        Intrinsics.checkNotNullParameter(r100, "name");
        Intrinsics.checkNotNullParameter(r100, "name");
        PolarisFileOutputStreamWrapper r103 = new PolarisFileOutputStreamWrapper(r100, false);
        DataOutputStream r104 = new DataOutputStream(r103);
        r104.write(r101, 0, r101.length);
        r104.close();
        r103.close();
        return;
    }

    public static boolean isSubPath(String r100, String r101) {
        if (r100 == null) goto L7;
        if (r101 != null) goto L6;
        return false;
    L6:
        return isSubPath(a.a(r100), a.a(r101));
    L7:
        return false;
    }

    public static void unZipFolder(InputStream r100, String r101) throws Exception {
        unZipFolder(r100, r101, false);
    }

    public static boolean copyAssets(Context r100, String r101, String r102) {
        InputStream r103 = null;
        PolarisFileOutputStreamWrapper r104 = null;
        r104 = null;
        r103 = null;
        InputStream r105 = r100.getAssets().open(r101);     // Catch: Throwable -> L23 IOException -> L25
        PolarisFileWrapper r106 = a.a(r102);     // Catch: Throwable -> L19 IOException -> L21
        if (r106.getParentFile().exists() == true) goto L7;
        r106.getParentFile().mkdirs();     // Catch: Throwable -> L19 IOException -> L21
    L7:
        r104 = a.b(r106);     // Catch: Throwable -> L19 IOException -> L21
        copyFile(r105, r104);     // Catch: Throwable -> L19 IOException -> L21
        if (r105 != null) goto L62;
    L52:
        r104.close();     // Catch: IOException -> L15
        return true;
    L15:
        e = move-exception;
        AppBrandLogger.eWithThrowable(TAG, "", e);
        return true;
    L62:
        r105.close();     // Catch: IOException -> L11
    L11:
        e = move-exception;
        AppBrandLogger.eWithThrowable(TAG, "", e);
        goto L52
    L21:
        e = e;
        PolarisFileOutputStreamWrapper r107 = r104;
        r103 = r105;
        PolarisFileOutputStreamWrapper r108 = r107;
    L58:
        AppBrandLogger.eWithThrowable(TAG, "copyAssets error: " + e.getMessage(), e);     // Catch: Throwable -> L40
        if (r103 != null) goto L54;
    L33:
        if (r108 == null) goto L73;
        r108.close();     // Catch: IOException -> L36
        return false;
    L36:
        e = move-exception;
        AppBrandLogger.eWithThrowable(TAG, "", e);
        return false;
    L73:
        return false;
    L54:
        r103.close();     // Catch: IOException -> L31
    L31:
        e = move-exception;
        AppBrandLogger.eWithThrowable(TAG, "", e);
    L40:
        th = th;
    L41:
        if (r103 != null) goto L64;
    L46:
        if (r108 == null) goto L70;
        r108.close();     // Catch: IOException -> L49
        throw th;
    L49:
        e = move-exception;
        AppBrandLogger.eWithThrowable(TAG, "", e);
        throw th;
    L70:
        throw th;
    L64:
        r103.close();     // Catch: IOException -> L44
    L44:
        e = move-exception;
        AppBrandLogger.eWithThrowable(TAG, "", e);
    L19:
        th = th;
        PolarisFileOutputStreamWrapper r109 = r104;
        r103 = r105;
        r108 = r109;
        goto L41
    L25:
        e = e;
        r108 = null;
    L23:
        th = th;
        r108 = null;
        goto L41
    }

    public static int copyFile(File r100, File r110, boolean r111) {
        if (TextUtils.equals(r100.getAbsolutePath(), r110.getAbsolutePath()) == false) goto L7;
        AppBrandLogger.e(TAG, new Object[]{"copy file is same"});
        return 0;
    L7:
        if (r110.getParentFile().exists() == false) goto L9;
    L11:
        PolarisFileInputStreamWrapper r101 = null;
        PolarisFileOutputStreamWrapper r102 = null;
        r102 = null;
        r101 = null;
        int r103 = a.f242800a;     // Catch: Throwable -> L34 Exception -> L36
        PolarisFileInputStreamWrapper r104 = new PolarisFileInputStreamWrapper(r100);     // Catch: Throwable -> L34 Exception -> L36
    L64:
        r102 = a.b(r110);     // Catch: Throwable -> L30 Exception -> L32
        byte[] r112 = new byte[4096];     // Catch: Throwable -> L30 Exception -> L32
    L14:
        int r105 = r104.read(r112);     // Catch: Throwable -> L30 Exception -> L32
        if (r105 <= 0) goto L17;
        r102.write(r112, 0, r105);     // Catch: Throwable -> L30 Exception -> L32
        goto L14
    L17:
        if (r111 == true) goto L19;
    L54:
        r104.close();     // Catch: Exception -> L23
    L60:
        r102.close();     // Catch: Exception -> L27
    L29:
        return 0;
    L27:
        e = move-exception;
        AppBrandLogger.e(TAG, new Object[]{"fosto close exception", e});
    L23:
        e = move-exception;
        AppBrandLogger.e(TAG, new Object[]{"fosfrom close exception", e});
        goto L60
    L19:
        if (r100.delete() == true) goto L54;
        AppBrandLogger.i(TAG, new Object[]{"cannot delete from file:" + r100.getPath()});     // Catch: Throwable -> L30 Exception -> L32
    L32:
        e = e;
        PolarisFileOutputStreamWrapper r113 = r102;
        r101 = r104;
    L52:
        AppBrandLogger.e(TAG, new Object[]{"copy file exception:", e});     // Catch: Throwable -> L40
        throw new RuntimeException(e);     // Catch: Throwable -> L40
    L40:
        th = th;
    L41:
        if (r101 != null) goto L58;
    L46:
        if (r113 == null) goto L67;
        r113.close();     // Catch: Exception -> L49
        throw th;
    L49:
        e = move-exception;
        AppBrandLogger.e(TAG, new Object[]{"fosto close exception", e});
        throw th;
    L67:
        throw th;
    L58:
        r101.close();     // Catch: Exception -> L44
    L44:
        e = move-exception;
        AppBrandLogger.e(TAG, new Object[]{"fosfrom close exception", e});
    L30:
        th = th;
        r113 = r102;
        r101 = r104;
    L36:
        e = e;
        r113 = null;
    L34:
        th = th;
        r113 = null;
        goto L41
    L9:
        if (r110.getParentFile().mkdirs() == true) goto L11;
        AppBrandLogger.i(TAG, new Object[]{"cannot mkdirs for parentFile:" + r110.getParentFile().getPath()});
        goto L11
    }

    private static String getMD5Str(MessageDigest r100, InputStream r101, byte[] r102) throws IOException {
        AppBrandLogger.i(TAG, new Object[]{"getMD5Str start"});
    L3:
        int r103 = r101.read(r102);
        if (r103 <= 0) goto L6;
        r100.update(r102, 0, r103);
        goto L3
    L6:
        String r104 = String.format("%32s", new Object[]{new BigInteger(1, r100.digest()).toString(16)}).replace(' ', '0');
        AppBrandLogger.i(TAG, new Object[]{"getMD5Str end"});
        return r104;
    }

    public static int readInt(String r100, String r101, int r102) {
        String r103 = new String(readBytes(r100), r101);     // Catch: Exception -> L7
        if (TextUtils.isEmpty(r103) == true) goto L12;
        return CastIntegerProtector.parseInt(r103);
    L12:
        return r102;
    L7:
        e = move-exception;
        AppBrandLogger.eWithThrowable(TAG, "", e);
        return r102;
    }

    public static void unZipFolder(InputStream r100, String r101, boolean r102) throws Exception {
        ZipInputStream r103 = new ZipInputStream(r100);
    L3:
        ZipEntry r104 = r103.getNextEntry();
        if (r104 == null) goto L21;
        String r105 = r104.getName();
        if (TextUtils.isEmpty(r105) == true) goto L3;
        if (r105.contains("../") == true) goto L3;
        if (r104.isDirectory() == true) goto L12;
        PolarisFileWrapper r106 = a.a(r101 + File.separator + r105);
        if (r106.getParentFile().exists() == true) goto L16;
        r106.getParentFile().mkdirs();
    L16:
        r106.createNewFile();
        PolarisFileOutputStreamWrapper r107 = a.b(r106);
        byte[] r108 = new byte[1024];
    L17:
        int r109 = r103.read(r108);
        if (r109 == (-1)) goto L20;
        r107.write(r108, 0, r109);
        r107.flush();
        goto L17
    L20:
        r107.close();
        goto L3
    L12:
        a.a(r101 + File.separator + r105.substring(0, r105.length() - 1)).mkdirs();
        goto L3
    L21:
        r103.close();
    }

    public static boolean writeStringToFile(String r100, String r101, String r102) throws Exception {
        if (TextUtils.isEmpty(r100) == false) goto L6;
        return false;
    L6:
        PolarisFileWrapper r103 = a.a(r100);
        if (r103.exists() == true) goto L9;
        r103.createNewFile();
    L9:
        BufferedWriter r104 = new BufferedWriter(new PolarisFileWriterWrapper(r103));
        r104.write(r101);
        r104.flush();
        r104.close();
        return true;
    }

    public static void unZipFolder(String r100, String r101, boolean r102) throws Exception {
        int r103 = a.f242800a;
        unZipFolder(new PolarisFileInputStreamWrapper(r100), r101, r102);
    }
}
