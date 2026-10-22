package com.ss.ttm.player;

import android.content.Context;
import android.util.Base64;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileReaderWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWriterWrapper;
import com.ss.ttm.utils.AVTime;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Locale;
import java.util.zip.GZIPOutputStream;

/* JADX INFO: loaded from: classes40.dex */
public final class TTCrashUtil {
    public TTCrashUtil() {
    }

    public static void checkLogDir(String r100) {
        int r101 = 0;
        PolarisFileWrapper r102 = new PolarisFileWrapper(String.format("%s/ttplayer_logs", new Object[]{r100}));
        if (r102.exists() == false) goto L18;
        if (r102.isDirectory() == false) goto L24;
        File[] r103 = r102.listFiles();
        if (r103 == null) goto L15;
        int r104 = r103.length;
    L9:
        if (r101 >= r104) goto L15;
        File r105 = r103[r101];
        if (r105.delete() == true) goto L13;
        r105.getName();
    L13:
        r101 = r101 + 1;
    L15:
        if (r102.delete() == true) goto L25;
        r102.getName();
        return;
    L25:
        return;
    L24:
        return;
    L18:
        if (r102.mkdir() == true) goto L27;
        r102.getName();
        return;
    }

    public static void checkTrackDir(String r100) {
        PolarisFileWrapper r101 = new PolarisFileWrapper(String.format("%s/ttplayer_logs", new Object[]{r100}));
        if (r101.exists() == true) goto L6;
        r101.mkdir();
        return;
    }

    private static void deleteTrackFile(String r100) {
        PolarisFileWrapper r101 = new PolarisFileWrapper(r100);
        if (r101.exists() == false) goto L6;
        r101.delete();
        return;
    }

    public static final String existsCrashFilePath(Context r100) {
        if (TTPlayerConfiger.getValue(18, 1) != 1) goto L10;
        String r101 = TTPlayerConfiger.getAppCrashFilePath(r100);
        if (r101 != null) goto L7;
    L9:
        return null;
    L7:
        if (new PolarisFileWrapper(r101).exists() == false) goto L9;
        return r101;
    L10:
        String r102 = TTPlayerConfiger.getAppCrashFilePath2(r100);
        if (r102 != null) goto L13;
    L15:
        String r103 = TTPlayerConfiger.getPlugerCrashFilePath(r100);
        if (r103 != null) goto L18;
    L20:
        String r104 = TTPlayerConfiger.getExternalStorageDirectoryCrashFilePath(r100);
        if (r104 == null) goto L26;
        if (new PolarisFileWrapper(r104).exists() == true) goto L26;
        return null;
    L26:
        return r104;
    L18:
        if (new PolarisFileWrapper(r103).exists() == false) goto L20;
        return r103;
    L13:
        if (new PolarisFileWrapper(r102).exists() == false) goto L15;
        return r102;
    }

    public static String getBase64SampleCrash(String r100) {
        return Base64.encodeToString(r100.getBytes(), 0);
    }

    public static void compress(InputStream r100, OutputStream r101) throws Exception {
        GZIPOutputStream r102 = new GZIPOutputStream(r101);
        byte[] r103 = new byte[10240];
    L3:
        int r104 = r100.read(r103, 0, 10240);
        if (r104 == (-1)) goto L6;
        r102.write(r103, 0, r104);
        goto L3
    L6:
        r102.flush();
        r102.finish();
        r102.close();
    }

    public static void deleteCrashFile(Context r100, String r101) {
        PolarisFileWrapper r102 = new PolarisFileWrapper(r101);
        if (r102.exists() == false) goto L6;
        r102.delete();
        return;
    }

    public static void deleteDebugTrackFile(long r100, String r101) {
        deleteTrackFile(getDebugTrackFilePath(r100, r101));
    }

    public static void deleteTrackFile(long r100, String r101) {
        deleteTrackFile(getTrackFilePath(r100, r101));
    }

    public static boolean existLogsFile(long r100, String r101) {
        String r102 = String.valueOf(r100);
        PolarisFileWrapper r103 = new PolarisFileWrapper(String.format("%s/ttplayer_logs", new Object[]{r101}));
        if (r103.exists() == true) goto L5;
    L17:
        return false;
    L5:
        if (r103.isDirectory() == false) goto L17;
        File[] r104 = r103.listFiles();
        if (r104 != null) goto L9;
        return false;
    L9:
        int r105 = r104.length;
        int r106 = 0;
    L10:
        if (r106 >= r105) goto L17;
        String r107 = r104[r106].getName();
        if (r107 == null) goto L16;
        if (r107.startsWith(r102) == true) goto L16;
        return true;
    L16:
        r106 = r106 + 1;
        goto L10
    }

    public static boolean existsCrashFile(Context r100, String r101) {
        if (r100 != null) goto L7;
        if (r101 != null) goto L7;
        return false;
    L7:
        return new PolarisFileWrapper(r101).exists();
    }

    public static boolean existsTrackFile(long r100, String r101) {
        return new PolarisFileWrapper(getTrackFilePath(r100, r101)).exists();
    }

    private static String getDebugTrackFilePath(long r100, String r101) {
        return String.format(Locale.US, "%s/ttplayer_logs/%d_d.log", new Object[]{r101, Long.valueOf(r100)});
    }

    private static boolean getTrackFileInfos(String r100, StringBuilder r101) {
        PolarisFileReaderWrapper r102 = null;
        PolarisFileWrapper r103 = new PolarisFileWrapper(r100);     // Catch: Throwable -> L16
        if (r103.exists() == true) goto L7;
        r101.append("path");     // Catch: Throwable -> L16
        r101.append(r100);     // Catch: Throwable -> L16
        r101.append(" not exists.\r\n");     // Catch: Throwable -> L16
        return false;
    L7:
        char[] r104 = new char[1024];     // Catch: Throwable -> L16
        PolarisFileReaderWrapper r105 = new PolarisFileReaderWrapper(r103);     // Catch: Throwable -> L16
    L25:
        int r106 = r105.read(r104);     // Catch: Throwable -> L14
        if (r106 <= 0) goto L12;
        r101.append(r104, 0, r106);     // Catch: Throwable -> L14
        if (r106 >= 1024) goto L25;
    L12:
        r105.close();     // Catch: Throwable -> L14
        return true;
    L14:
        th = th;
        r102 = r105;
    L17:
        if (r102 != null) goto L23;
    L19:
        r101.append("track message:");
        r101.append(th.getMessage());
        r101.append("\r\n");
        return true;
    L23:
        r102.close();     // Catch: Exception -> L22
    L16:
        th = th;
        goto L17
    }

    public static String getTrackFilePath(long r100, String r101) {
        return String.format(Locale.US, "%s/ttplayer_logs/%d.log", new Object[]{r101, Long.valueOf(r100)});
    }

    public static final void saveException(Throwable r100, String r101) {
        if (r101 != null) goto L4;
        return;
    L4:
        PolarisFileWrapper r102 = new PolarisFileWrapper(r101);
        if (r102.exists() == false) goto L7;
        return;
    L7:
        PrintStream r103 = null;
        PolarisFileOutputStreamWrapper r104 = new PolarisFileOutputStreamWrapper(r102);     // Catch: Throwable -> L20 Exception -> L30
        PrintStream r105 = new PrintStream(r104);     // Catch: Throwable -> L17 Exception -> L19
        r105.write("EXCE".getBytes());     // Catch: Throwable -> L14 Exception -> L16
        r100.printStackTrace(r105);     // Catch: Throwable -> L14 Exception -> L16
        r105.close();
        r104.close();     // Catch: Exception -> L36
    L39:
        return;
    L16:
        r103 = r105;
    L14:
        th = th;
        r103 = r105;
    L22:
        if (r103 == null) goto L24;
        r103.close();
    L24:
        if (r104 != null) goto L42;
    L29:
        throw th;
    L42:
        r104.close();     // Catch: Exception -> L27
    L27:
        e = move-exception;
        e.printStackTrace();
        goto L29
    L17:
        th = th;
    L31:
        if (r103 == null) goto L33;
        r103.close();
    L33:
        if (r104 == null) goto L50;
        r104.close();     // Catch: Exception -> L36
        goto L39
    L50:
        return;
    L36:
        e = move-exception;
        e.printStackTrace();
        return;
    L30:
        r104 = null;
    L20:
        th = th;
        r104 = null;
        goto L22
    }

    public static void saveLowMemoryInfo(int r100, String r101) {
        PolarisFileWrapper r102 = new PolarisFileWrapper(r101);
        if (r102.exists() == false) goto L5;
        return;
    L5:
        PolarisFileWriterWrapper r103 = null;
        PolarisFileWriterWrapper r104 = new PolarisFileWriterWrapper(r102);     // Catch: Throwable -> L14 IOException -> L16
        r104.write("LOWM\r\nrecv low memory warring info.level:" + r100);     // Catch: Throwable -> L10 IOException -> L12
        r104.close();     // Catch: IOException -> L21
    L30:
        return;
    L12:
        e = e;
        r103 = r104;
    L17:
        e.printStackTrace();     // Catch: Throwable -> L14
        if (r103 == null) goto L40;
        r103.close();     // Catch: IOException -> L21
        goto L30
    L40:
        return;
    L10:
        th = th;
        r103 = r104;
    L24:
        if (r103 != null) goto L33;
    L29:
        throw th;
    L33:
        r103.close();     // Catch: IOException -> L27
    L27:
        e = move-exception;
        e.printStackTrace();
    L21:
        e = move-exception;
        e.printStackTrace();
        return;
    L16:
        e = e;
    L14:
        th = th;
        goto L24
    }

    public static void saveStopInfo(String r100, String r101) {
        PolarisFileWrapper r102 = new PolarisFileWrapper(r100);
        if (r102.exists() == false) goto L31;
        return;
    L31:
        PolarisFileWriterWrapper r103 = new PolarisFileWriterWrapper(r102);     // Catch: Throwable -> L12 IOException -> L14
        r103.write("STOP recv stop info:" + r101 + ".time:" + AVTime.getFormatNow() + "\r\n");     // Catch: IOException -> L10 Throwable -> L23
        r103.close();     // Catch: IOException -> L20
    L30:
        return;
    L10:
        IOException e100 = e;
    L16:
        e100.printStackTrace();     // Catch: Throwable -> L23
        if (r103 == null) goto L40;
        r103.close();     // Catch: IOException -> L20
        goto L30
    L40:
        return;
    L23:
        Throwable th10 = th;
    L24:
        if (r103 != null) goto L35;
    L29:
        throw th10;
    L35:
        r103.close();     // Catch: IOException -> L27
    L27:
        e = move-exception;
        e.printStackTrace();
        goto L29
    L20:
        e = move-exception;
        e.printStackTrace();
        return;
    L14:
        e = move-exception;
        r103 = null;
        e100 = e;
    L12:
        th = move-exception;
        r103 = null;
        th10 = th;
        goto L24
    }

    private static boolean getTrackFileInfos(File r100, StringBuilder r101) {
        PolarisFileReaderWrapper r102 = null;
    L15:
        th = th;
    L16:
        if (r102 != null) goto L26;
    L18:
        r101.append("track message:");
        r101.append(th.getMessage());
        r101.append("\r\n");
        return true;
    L26:
        r102.close();     // Catch: Exception -> L21
        goto L18
    L4:
        if (r100.exists() == true) goto L6;
        return false;
    L6:
        char[] r103 = new char[1024];     // Catch: Throwable -> L15
        PolarisFileReaderWrapper r104 = new PolarisFileReaderWrapper(r100);     // Catch: Throwable -> L15
    L22:
        int r105 = r104.read(r103);     // Catch: Throwable -> L13
        if (r105 <= 0) goto L11;
        r101.append(r103, 0, r105);     // Catch: Throwable -> L13
        if (r105 >= 1024) goto L22;
    L11:
        r104.close();     // Catch: Throwable -> L13
        return true;
    L13:
        th = th;
        r102 = r104;
        goto L16
    }

    public static void addTrackInfo(long r100, String r101, String r102) {
        appendTrackInfo(getTrackFilePath(r100, r101), true, r102);
    }

    private static void appendTrackInfo(String r100, boolean r101, String r102) {
        PolarisFileWriterWrapper r103 = null;
        PolarisFileWriterWrapper r104 = new PolarisFileWriterWrapper(r100, r101);     // Catch: Throwable -> L10 Exception -> L21
        r104.write(r102);     // Catch: Throwable -> L7 Exception -> L9
        r104.close();     // Catch: Exception -> L18
    L22:
        return;
    L9:
        r103 = r104;
    L7:
        th = th;
        r103 = r104;
    L25:
        r103.close();     // Catch: Exception -> L13
    L15:
        throw th;
    L13:
        e = move-exception;
        e.printStackTrace();
        goto L15
    L18:
        e = move-exception;
        e.printStackTrace();
        return;
    L10:
        th = th;
    L16:
        r103.close();     // Catch: Exception -> L18
        goto L22
    }

    public static String getCrashFileContext(Context r100, String r101, StringBuilder r102) {
        if (r100 != null) goto L7;
        if (r101 != null) goto L7;
        r102.append("context or path is null.\r\n");
        return null;
    L7:
        PolarisFileWrapper r103 = new PolarisFileWrapper(r101);
        if (r103.exists() == true) goto L12;
        r102.append("file not exist.path:");
        r102.append(r101);
        r102.append("\r\n");
        return null;
    L12:
        if (r103.length() != 0) goto L15;
        r102.append("file size is zore.");
        r102.append("\r\n");
        return null;
    L15:
        ByteArrayOutputStream r104 = new ByteArrayOutputStream();
        PolarisFileInputStreamWrapper r105 = new PolarisFileInputStreamWrapper(r103);     // Catch: Exception -> L21
        compress(r105, r104);     // Catch: Exception -> L19
        r105.close();     // Catch: Exception -> L19
        String r106 = Base64.encodeToString(r104.toByteArray(), 0);     // Catch: Exception -> L19
        r104.close();     // Catch: Exception -> L19
        return r106;
    L19:
        e = e;
    L23:
        e.printStackTrace();
        if (r105 != null) goto L35;
    L33:
        r104.close();     // Catch: IOException -> L32
    L30:
        r102.append("gzip file is error.error:");
        r102.append(e.getMessage());
        return null;
    L35:
        r105.close();     // Catch: IOException -> L27
    L27:
        e = move-exception;
        e.printStackTrace();
    L21:
        e = e;
        r105 = null;
        goto L23
    }

    public static final boolean moveFile(String r100, String r101, boolean r102) {
        return copyFile(r100, r101, r102, true);
    }

    public static boolean moveTrackFile(long r100, long r101, String r102) {
        return new PolarisFileWrapper(getTrackFilePath(r100, r102)).renameTo(new PolarisFileWrapper(getTrackFilePath(r101, r102)));
    }

    public static boolean readDebugTrackInfos(long r100, String r101, StringBuilder r102) {
        return getTrackFileInfos(getDebugTrackFilePath(r100, r101), r102);
    }

    public static boolean readLogsInfo(long r100, String r101, StringBuilder r102) {
        String r103 = String.valueOf(r100);
        PolarisFileWrapper r104 = new PolarisFileWrapper(String.format("%s/ttplayer_logs", new Object[]{r101}));
        if (r104.exists() == true) goto L5;
    L22:
        return false;
    L5:
        if (r104.isDirectory() == false) goto L22;
        File[] r105 = r104.listFiles();
        if (r105 != null) goto L9;
        return false;
    L9:
        int r106 = r105.length;
        int r107 = 0;
    L10:
        if (r107 >= r106) goto L22;
        File r108 = r105[r107];
        String r109 = r108.getName();
        if (r109 == null) goto L21;
        if (r109.startsWith(r103) == true) goto L21;
        if (getTrackFileInfos(r108, r102) == false) goto L21;
        boolean r110 = r108.delete();
        if (r110 == true) goto L20;
        r108.getName();
    L20:
        return r110;
    L21:
        r107 = r107 + 1;
        goto L10
    }

    public static boolean readTrackInfos(long r100, String r101, StringBuilder r102) {
        return getTrackFileInfos(getTrackFilePath(r100, r101), r102);
    }

    public static void addDebugTrackInfo(long r100, String r101, String r102, boolean r103) {
        appendTrackInfo(getDebugTrackFilePath(r100, r101), r103, r102);
    }

    public static void addTrackInfo(long r100, String r101, String r102, boolean r103) {
        appendTrackInfo(getTrackFilePath(r100, r101), r103, r102);
    }

    public static final boolean copyFile(String r100, String r101, boolean r102, boolean r103) {
        PolarisFileWrapper r104 = new PolarisFileWrapper(r101);
        if (r104.exists() == true) goto L6;
        return false;
    L6:
        if (r104.isFile() == true) goto L8;
        return false;
    L8:
        PolarisFileWrapper r105 = new PolarisFileWrapper(r100);
        if (r105.exists() == false) goto L13;
        if (r102 == false) goto L17;
        new PolarisFileWrapper(r100).delete();
    L17:
        PolarisFileOutputStreamWrapper r106 = null;
        PolarisFileInputStreamWrapper r107 = new PolarisFileInputStreamWrapper(r104);     // Catch: Throwable -> L39 IOException -> L51 FileNotFoundException -> L61
        PolarisFileOutputStreamWrapper r108 = new PolarisFileOutputStreamWrapper(r105);     // Catch: Throwable -> L37 IOException -> L71 FileNotFoundException -> L72
    L83:
        byte[] r109 = new byte[1024];     // Catch: Throwable -> L33 IOException -> L35 FileNotFoundException -> L36
    L22:
        int r110 = r107.read(r109);     // Catch: Throwable -> L33 IOException -> L35 FileNotFoundException -> L36
        if (r110 == (-1)) goto L25;
        r108.write(r109, 0, r110);     // Catch: Throwable -> L33 IOException -> L35 FileNotFoundException -> L36
        goto L22
    L25:
        if (r103 == false) goto L75;
        r104.delete();     // Catch: Throwable -> L33 IOException -> L35 FileNotFoundException -> L36
    L75:
        r108.close();     // Catch: IOException -> L29
        r107.close();     // Catch: IOException -> L29
        return true;
    L29:
        e = move-exception;
        e.printStackTrace();
        return true;
    L36:
        r106 = r108;
    L35:
        r106 = r108;
    L33:
        Throwable th10 = th;
    L42:
        if (r108 != null) goto L79;
    L46:
        if (r107 == null) goto L50;
        r107.close();     // Catch: IOException -> L44
    L44:
        e = move-exception;
        e.printStackTrace();
    L50:
        throw th10;
    L79:
        r108.close();     // Catch: IOException -> L44
    L37:
        th = th;
        r108 = null;
    L41:
        th10 = th;
    L62:
        if (r106 != null) goto L77;
    L66:
        if (r107 == null) goto L70;
        r107.close();     // Catch: IOException -> L64
    L64:
        e = move-exception;
        e.printStackTrace();
    L70:
        return false;
    L77:
        r106.close();     // Catch: IOException -> L64
    L52:
        if (r106 != null) goto L73;
    L56:
        if (r107 == null) goto L60;
        r107.close();     // Catch: IOException -> L54
    L54:
        e = move-exception;
        e.printStackTrace();
    L60:
        return false;
    L73:
        r106.close();     // Catch: IOException -> L54
        goto L56
    L61:
        r107 = null;
    L51:
        r107 = null;
    L39:
        th = th;
        r107 = null;
        r108 = null;
        goto L41
    L13:
        if (r105.getParentFile().exists() == true) goto L17;
        if (r105.getParentFile().mkdirs() == true) goto L17;
        return false;
    }
}
