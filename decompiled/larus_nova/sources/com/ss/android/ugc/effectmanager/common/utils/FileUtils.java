package com.ss.android.ugc.effectmanager.common.utils;

import android.os.Environment;
import android.text.TextUtils;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.byted.cast.common.Constants;
import com.bytedance.ee.docsdk.impl.base.DocumentType;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileReaderWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.ss.android.ugc.effectmanager.common.cachemanager.TotalLengthOutputStream;
import com.ss.android.ugc.effectmanager.common.download.DownloadListener;
import com.ss.android.ugc.effectmanager.common.exception.UnzipException;
import com.ss.android.ugc.effectmanager.common.logger.EPLog;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.StringWriter;
import java.nio.charset.Charset;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.io.FilesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0011\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0014\u001a\u0004\u0018\u00010\b2\b\u0010\u0015\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0016\u001a\u00020\bJ\u0010\u0010\u0017\u001a\u00020\u00112\b\u0010\u0018\u001a\u0004\u0018\u00010\bJ\u0010\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cJ\u0016\u0010\u001d\u001a\u00020\b2\u0006\u0010\u001e\u001a\u00020\b2\u0006\u0010\u001f\u001a\u00020\bJ\u0016\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%J(\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020!2\b\u0010'\u001a\u0004\u0018\u00010(J\u001a\u0010)\u001a\u0004\u0018\u00010*2\b\u0010\u0018\u001a\u0004\u0018\u00010\b2\u0006\u0010+\u001a\u00020\u0011J\u0010\u0010,\u001a\u00020\u001a2\b\u0010-\u001a\u0004\u0018\u00010*J\u0010\u0010.\u001a\u00020\u00112\b\u0010-\u001a\u0004\u0018\u00010*J\u000e\u0010/\u001a\u00020\u00112\u0006\u0010-\u001a\u00020*J\u000e\u00100\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\bJ\u0012\u00101\u001a\u0004\u0018\u00010%2\b\u0010\u0018\u001a\u0004\u0018\u00010\bJ\u0012\u00102\u001a\u0004\u0018\u00010#2\b\u0010\u0018\u001a\u0004\u0018\u00010\bJ\u0010\u00103\u001a\u00020!2\b\u00104\u001a\u0004\u0018\u00010*J\u000e\u00105\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\bJ\u000e\u00106\u001a\u00020\b2\u0006\u00107\u001a\u000208J\u0010\u00109\u001a\u00020\u001a2\b\u0010:\u001a\u0004\u0018\u00010*J\u0010\u00109\u001a\u00020\u001a2\b\u0010:\u001a\u0004\u0018\u00010\bJ\u0010\u0010;\u001a\u00020\u00112\b\u0010\u0018\u001a\u0004\u0018\u00010\bJ$\u0010<\u001a\u00020\u001a2\b\u0010=\u001a\u0004\u0018\u00010*2\b\u0010>\u001a\u0004\u0018\u00010*2\b\b\u0002\u0010?\u001a\u00020\u0011J.\u0010<\u001a\u00020\u001a2\b\u0010=\u001a\u0004\u0018\u00010*2\b\u0010>\u001a\u0004\u0018\u00010*2\b\b\u0002\u0010?\u001a\u00020\u00112\b\b\u0002\u0010@\u001a\u00020\u0011J$\u0010<\u001a\u00020\u001a2\b\u0010A\u001a\u0004\u0018\u00010\b2\b\u0010B\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010?\u001a\u00020\u0011J.\u0010<\u001a\u00020\u001a2\b\u0010A\u001a\u0004\u0018\u00010\b2\b\u0010B\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010?\u001a\u00020\u00112\b\b\u0002\u0010@\u001a\u00020\u0011J\u001a\u0010C\u001a\u00020\u001a2\b\u0010D\u001a\u0004\u0018\u00010\b2\b\u0010E\u001a\u0004\u0018\u00010\bJ\u0018\u0010F\u001a\u00020!2\u0006\u0010G\u001a\u00020#2\b\u0010\u0018\u001a\u0004\u0018\u00010\bJ\u0016\u0010F\u001a\u00020!2\u0006\u0010H\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\bR\u0014\u0010\u0003\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u0019\u0010\t\u001a\n \u000b*\u0004\u0018\u00010\n0\n¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0019\u0010\u000e\u001a\n \u000b*\u0004\u0018\u00010\n0\n¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0011\u0010\u0010\u001a\u00020\u00118F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0012R\u0011\u0010\u0013\u001a\u00020\u00118F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0012¨\u0006I"}, d2 = {"Lcom/ss/android/ugc/effectmanager/common/utils/FileUtils;", "", "()V", "BUFFER_SIZE", "", "getBUFFER_SIZE", "()I", "TAG", "", "US_ASCII", "Ljava/nio/charset/Charset;", "kotlin.jvm.PlatformType", "getUS_ASCII", "()Ljava/nio/charset/Charset;", "UTF_8", "getUTF_8", "isSdcardAvailable", "", "()Z", "isSdcardWritable", "addPathSuffix", "originPath", "suffix", "checkFileExists", "path", "closeQuietly", "", "closeable", "Ljava/io/Closeable;", "combineFilePath", "path1", "path2", "copyStream", "", "source", "Ljava/io/InputStream;", Constants.ROLE_SINK, "Ljava/io/OutputStream;", "contentLength", "listener", "Lcom/ss/android/ugc/effectmanager/common/download/DownloadListener;", "createFile", "Ljava/io/File;", "isFile", "deleteContents", MapBundleKey.MapObjKey.OBJ_DIR, "deleteDir", "ensureDirExists", "getFileContent", "getFileOutputStream", "getFileStream", "getFolderSize", DocumentType.FOLDER_NAME, "joinSeparator", "readFully", "reader", "Ljava/io/Reader;", "removeDir", "fileOrDirectory", "removeFile", "rename", "from", RemoteMessageConst.TO, "deleteIfExists", "deleteAfterRename", "fromPath", "toPath", "unZip", "zipFilePath", "outPath", "writeToExternal", "inputStream", "cache", "effectmanager_release"}, k = 1, mv = {1, 1, 16})
public final class FileUtils {
    private static final int BUFFER_SIZE = 8192;
    public static final FileUtils INSTANCE = null;
    private static final String TAG = "FileUtils";
    private static final Charset US_ASCII = null;
    private static final Charset UTF_8 = null;

    private FileUtils() {
    }

    static {
        INSTANCE = new FileUtils();
        US_ASCII = Charset.forName("US-ASCII");
        UTF_8 = Charset.forName("UTF-8");
        BUFFER_SIZE = 8192;
    }

    public final boolean isSdcardWritable() {
        return Intrinsics.areEqual("mounted", Environment.getExternalStorageState());
    L4:
        return false;
    }

    public final boolean isSdcardAvailable() {
        String r100 = Environment.getExternalStorageState();
        if (Intrinsics.areEqual("mounted", r100) == false) goto L5;
    L8:
        return true;
    L5:
        if (Intrinsics.areEqual("mounted_ro", r100) == true) goto L8;
        return false;
    }

    public final int getBUFFER_SIZE() {
        return BUFFER_SIZE;
    }

    public final Charset getUS_ASCII() {
        return US_ASCII;
    }

    public final Charset getUTF_8() {
        return UTF_8;
    }

    public final boolean checkFileExists(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L6;
        return false;
    L6:
        return new PolarisFileWrapper(r100).exists();
    }

    public final void closeQuietly(Closeable r100) {
        if (r100 != null) goto L10;
        return;
    L10:
        r100.close();     // Catch: Exception -> L5 RuntimeException -> L7
    L13:
        return;
    L7:
        e = move-exception;
        throw e;
    L5:
        e = move-exception;
        e.printStackTrace();
    }

    public final void deleteContents(File r100) throws IOException {
        if (r100 == null) goto L18;
        File[] r101 = r100.listFiles();
        if (r101 == null) goto L17;
        int r102 = r101.length;
        int r103 = 0;
    L6:
        if (r103 >= r102) goto L15;
        File r104 = r101[r103];
        if (r104.isDirectory() == false) goto L11;
        deleteContents(r104);
    L11:
        if (r104.delete() == false) goto L14;
        r103 = r103 + 1;
        goto L6
    L14:
        throw new IOException("failed to delete file: " + r104);
    L15:
        return;
    L17:
        throw new IOException("not a readable directory: " + r100);
    }

    public final boolean deleteDir(File r100) {
        deleteContents(r100);     // Catch: IOException -> L7
        if (r100 != null) goto L6;
        return false;
    L6:
        return r100.delete();
    L11:
        return false;
    }

    public final boolean ensureDirExists(File r100) {
        if (r100.exists() == true) goto L6;
        r100.mkdirs();
    L6:
        return r100.exists();
    }

    public final String getFileContent(String r100) {
        PolarisFileWrapper r101 = new PolarisFileWrapper(r100);
        String r102 = "";
        if (checkFileExists(r101.getPath()) == true) goto L58;
        return "";
    L58:
        PolarisFileReaderWrapper r103 = new PolarisFileReaderWrapper(r101);     // Catch: Throwable -> L25 Exception -> L27
        BufferedReader r104 = new BufferedReader(r103);     // Catch: Throwable -> L21 Exception -> L23
        String r105 = r104.readLine();     // Catch: Exception -> L19 Throwable -> L38
    L8:
        if (r105 == null) goto L51;
        r102 = r102 + r105;     // Catch: Exception -> L19 Throwable -> L38
        r105 = r104.readLine();     // Catch: Exception -> L19 Throwable -> L38
        goto L8
    L51:
        r103.close();     // Catch: IOException -> L13
    L15:
        r104.close();     // Catch: IOException -> L17
    L57:
    L37:
        return r102;
    L13:
        e = move-exception;
        e.printStackTrace();
    L19:
        Exception e100 = e;
    L29:
        e100.printStackTrace();     // Catch: Throwable -> L38
        if (r103 != null) goto L53;
    L35:
        if (r104 == null) goto L37;
        r104.close();     // Catch: IOException -> L17
        goto L57
    L53:
        r103.close();     // Catch: IOException -> L33
    L33:
        e = move-exception;
        e.printStackTrace();
    L38:
        Throwable th10 = th;
    L39:
        if (r103 != null) goto L55;
    L44:
        if (r104 == null) goto L69;
        r104.close();     // Catch: IOException -> L47
        throw th10;
    L47:
        e = move-exception;
        e.printStackTrace();
        throw th10;
    L69:
        throw th10;
    L55:
        r103.close();     // Catch: IOException -> L42
    L42:
        e = move-exception;
        e.printStackTrace();
        goto L44
    L23:
        e = move-exception;
        r104 = null;
        e100 = e;
    L21:
        th = move-exception;
        r104 = null;
        th10 = th;
        goto L39
    L17:
        e = move-exception;
        e.printStackTrace();
    L27:
        e = move-exception;
        r103 = null;
        e100 = e;
        r104 = null;
    L25:
        th = move-exception;
        r103 = null;
        th10 = th;
        r104 = null;
        goto L39
    }

    public final OutputStream getFileOutputStream(String r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        File r101 = new PolarisFileWrapper(r100).getParentFile();
        if (r101.exists() == true) goto L13;
        r101.mkdirs();
    L13:
        return new PolarisFileOutputStreamWrapper(r100);
    L10:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    public final InputStream getFileStream(String r100) {
        if (r100 == null) goto L13;
        PolarisFileWrapper r101 = new PolarisFileWrapper(r100);
        if (checkFileExists(r101.getPath()) == false) goto L14;
        return new PolarisFileInputStreamWrapper(r101);
    L8:
        e = move-exception;
        e.printStackTrace();
        return null;
    L14:
        return null;
    L13:
        return null;
    }

    public final long getFolderSize(File r100) {
        long r101 = 0;
        if (r100 == null) goto L13;
        File[] r102 = r100.listFiles();
        if (r102 == null) goto L13;
        int r103 = r102.length;
        int r104 = 0;
    L7:
        if (r104 >= r103) goto L13;
        if (r102[r104].isFile() == false) goto L11;
        long r105 = r102[r104].length();
    L12:
        r101 = r101 + r105;
        r104 = r104 + 1;
        goto L7
    L11:
        r105 = getFolderSize(r102[r104]);
    L13:
        return r101;
    }

    public final String joinSeparator(String r100) {
        String r101 = File.separator;
        if (StringsKt.endsWith$default(r100, r101, false, 2, null) == false) goto L6;
        return r100;
    L6:
        return r100 + r101;
    }

    public final String readFully(Reader r100) throws IOException {
        StringWriter r101 = new StringWriter();     // Catch: Throwable -> L9
        char[] r102 = new char[1024];     // Catch: Throwable -> L9
        int r103 = r100.read(r102);     // Catch: Throwable -> L9
    L4:
        if (r103 == (-1)) goto L6;
        r101.write(r102, 0, r103);     // Catch: Throwable -> L9
        r103 = r100.read(r102);     // Catch: Throwable -> L9
        goto L4
    L6:
        String r104 = r101.toString();     // Catch: Throwable -> L9
        CloseableKt.closeFinally(r100, null);
        return r104;
    L9:
        th = move-exception;
        throw th;     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        CloseableKt.closeFinally(r100, th);
        throw th;
    }

    public final void removeDir(File r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r100.exists() == true) goto L6;
        return;
    L6:
        if (r100.isDirectory() == false) goto L27;
        File[] r101 = r100.listFiles();
        if (r101 != null) goto L10;
        return;
    L10:
        if (r101.length != 0) goto L13;
        r100.delete();
        return;
    L13:
        int r102 = r101.length;
        int r103 = 0;
    L14:
        if (r103 >= r102) goto L20;
        File r104 = r101[r103];
        if (r104.isDirectory() == false) goto L18;
        removeDir(r104);
    L19:
        r103 = r103 + 1;
        goto L14
    L18:
        r104.delete();
        goto L19
    L20:
        r100.delete();
        return;
    }

    public final boolean removeFile(String r100) {
        if (r100 == null) goto L12;
        PolarisFileWrapper r101 = new PolarisFileWrapper(r100);
        if (r101.exists() == true) goto L7;
        return false;
    L7:
        if (r101.canWrite() == true) goto L9;
        return false;
    L9:
        if (r101.delete() == false) goto L15;
        return true;
    L15:
        return false;
    L12:
        return false;
    }

    public final synchronized void removeDir(String r100) {
        monitor-enter(this);
        if (r100 != null) goto L12;
        monitor-exit(this);
        return;
    L12:
        removeDir(new PolarisFileWrapper(r100));     // Catch: Throwable -> L7
        monitor-exit(this);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public final String addPathSuffix(String r100, String r101) {
        if (r100 == null) goto L9;
        String r102 = File.separator;
        if (StringsKt.endsWith$default(r100, r102, false, 2, null) == false) goto L8;
        return StringsKt.dropLast(r100, 1) + r101 + r102;
    L8:
        return r100 + r101;
    L9:
        return null;
    }

    public final String combineFilePath(String r100, String r101) {
        StringBuilder r102 = new StringBuilder();
        if (TextUtils.isEmpty(r100) == false) goto L6;
        r100 = "";
    L6:
        r102.append(r100);
        if (TextUtils.isEmpty(r101) == false) goto L10;
        r101 = "";
    L10:
        r102.append(r101);
        return r102.toString();
    }

    public final long copyStream(InputStream r100, OutputStream r101) throws IOException {
        return copyStream(r100, r101, 0, null);
    }

    public final File createFile(String r100, boolean r101) {
        PolarisFileWrapper r102 = null;
        if (r100 != null) goto L5;
    L19:
        return r102;
    L5:
        if (TextUtils.isEmpty(r100) == true) goto L19;
        r102 = new PolarisFileWrapper(r100);
        if (r102.exists() == true) goto L19;
        if (r101 == true) goto L20;
        r102.mkdirs();
        goto L19
    L20:
        File r103 = r102.getParentFile();     // Catch: IOException -> L17
        if (r103 != null) goto L13;
    L15:
        r102.createNewFile();     // Catch: IOException -> L17
        goto L19
    L13:
        if (r103.exists() == true) goto L15;
        r103.mkdirs();     // Catch: IOException -> L17
    L17:
        e = move-exception;
        e.printStackTrace();
        goto L19
    }

    public final void unZip(String r100, String r110) throws UnzipException {
        if (r100 == null) goto L60;
        if (r110 == null) goto L77;
        Closeable r101 = null;
        File r102 = new PolarisFileWrapper(r110);     // Catch: Throwable -> L49 Exception -> L51
        if (r102.exists() == false) goto L9;
        removeDir(r102);     // Catch: Throwable -> L49 Exception -> L51
    L9:
        String r111 = r102.getCanonicalPath();     // Catch: Throwable -> L49 Exception -> L51
        ZipInputStream r103 = new ZipInputStream(new BufferedInputStream(new PolarisFileInputStreamWrapper(r100)));     // Catch: Throwable -> L49 Exception -> L51
        ZipEntry r104 = r103.getNextEntry();     // Catch: Throwable -> L45 Exception -> L47
    L11:
        if (r104 == null) goto L43;
        String r105 = r104.getName();     // Catch: Throwable -> L45 Exception -> L47
        if (StringsKt.contains$default(r105, "../", false, 2, null) == true) goto L15;
        PolarisFileWrapper r106 = new PolarisFileWrapper(r102, r105);     // Catch: Throwable -> L45 Exception -> L47
        if (StringsKt.startsWith$default(r106.getCanonicalPath(), r111, false, 2, null) == false) goto L42;
        if (r104.isDirectory() == true) goto L21;
        File r107 = r106.getParentFile();     // Catch: Throwable -> L45 Exception -> L47
        if (r107 == null) goto L32;
        if (r107.exists() == true) goto L32;
        if (r107.mkdirs() == true) goto L36;
        EPLog.e(TAG, "parent mkdir failed! file name:" + r107.getName());     // Catch: Throwable -> L45 Exception -> L47
    L36:
        BufferedOutputStream r108 = new BufferedOutputStream(new PolarisFileOutputStreamWrapper(r106));     // Catch: Throwable -> L45 Exception -> L47
        Ref.IntRef r109 = new Ref.IntRef();     // Catch: Throwable -> L45 Exception -> L47
        byte[] r112 = new byte[BUFFER_SIZE];     // Catch: Throwable -> L45 Exception -> L47
    L37:
        int r113 = r103.read(r112);     // Catch: Throwable -> L45 Exception -> L47
        r109.element = r113;     // Catch: Throwable -> L45 Exception -> L47
        if (r113 == (-1)) goto L40;
        r108.write(r112, 0, r113);     // Catch: Throwable -> L45 Exception -> L47
        goto L37
    L40:
        r108.flush();     // Catch: Throwable -> L45 Exception -> L47
        r108.close();     // Catch: Throwable -> L45 Exception -> L47
        r103.closeEntry();     // Catch: Throwable -> L45 Exception -> L47
        r104 = r103.getNextEntry();     // Catch: Throwable -> L45 Exception -> L47
    L32:
        if (r106.exists() == false) goto L36;
        if (r106.delete() == true) goto L36;
        EPLog.e(TAG, "delete file failed! file name:" + r106.getName());     // Catch: Throwable -> L45 Exception -> L47
        goto L36
    L21:
        if (r106.mkdirs() == true) goto L23;
        EPLog.e(TAG, "mkdir failed! file name:" + r106.getName());     // Catch: Throwable -> L45 Exception -> L47
    L23:
        r103.closeEntry();     // Catch: Throwable -> L45 Exception -> L47
        r104 = r103.getNextEntry();     // Catch: Throwable -> L45 Exception -> L47
        goto L11
    L42:
        throw new UnzipException("Entry is outside of the target dir: " + r104.getName());     // Catch: Throwable -> L45 Exception -> L47
    L15:
        EPLog.e(TAG, "file name contains illegal pattern with ..!");     // Catch: Throwable -> L45 Exception -> L47
        r103.closeEntry();     // Catch: Throwable -> L45 Exception -> L47
        r104 = r103.getNextEntry();     // Catch: Throwable -> L45 Exception -> L47
        goto L11
    L43:
        closeQuietly(r103);
        return;
    L47:
        e = e;
        r101 = r103;
    L52:
        String r114 = e.getMessage();     // Catch: Throwable -> L49
        if (r114 != null) goto L57;
        r114 = "";
    L57:
        throw new UnzipException(r114);     // Catch: Throwable -> L49
    L45:
        th = th;
        r101 = r103;
    L58:
        closeQuietly(r101);
        throw th;
    L51:
        e = e;
    L49:
        th = th;
        goto L58
    L77:
        return;
    }

    public final long writeToExternal(String r100, String r101) {
        monitor-enter(FileUtils.class);
        PolarisFileWrapper r102 = new PolarisFileWrapper(r101);     // Catch: Throwable -> L45
        if (r102.exists() == true) goto L7;
        INSTANCE.createFile(r102.getPath(), true);     // Catch: Throwable -> L45
    L7:
        PolarisFileOutputStreamWrapper r103 = null;
        PolarisFileOutputStreamWrapper r104 = new PolarisFileOutputStreamWrapper(r102);     // Catch: Throwable -> L27 Exception -> L29
        OutputStreamWriter r105 = new OutputStreamWriter(r104);     // Catch: Throwable -> L23 Exception -> L25
        r105.write(r100);     // Catch: Throwable -> L18
        r105.flush();     // Catch: Throwable -> L18
        Unit r106 = Unit.INSTANCE;     // Catch: Throwable -> L18
        CloseableKt.closeFinally(r105, null);     // Catch: Throwable -> L23 Exception -> L25
        long r107 = r100.length();     // Catch: Throwable -> L23 Exception -> L25
        r104.close();     // Catch: IOException -> L15 Throwable -> L45
    L37:
        monitor-exit(FileUtils.class);
        return r107;
    L15:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L45
        goto L37
    L18:
        th = move-exception;
        throw th;     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        CloseableKt.closeFinally(r105, th);     // Catch: Throwable -> L23 Exception -> L25
        throw th;     // Catch: Throwable -> L23 Exception -> L25
    L25:
        e = e;
        r103 = r104;
    L30:
        e.printStackTrace();     // Catch: Throwable -> L27
        if (r103 != null) goto L50;
    L36:
        r107 = 0;
        goto L37
    L50:
        r103.close();     // Catch: IOException -> L34 Throwable -> L45
    L34:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L45
    L23:
        th = th;
        r103 = r104;
    L39:
        if (r103 != null) goto L54;
    L44:
        throw th;     // Catch: Throwable -> L45
    L54:
        r103.close();     // Catch: IOException -> L42 Throwable -> L45
    L42:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L45
    L29:
        e = e;
    L27:
        th = th;
    L45:
        th = move-exception;
        throw th;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r8v13 */
    /* JADX WARN: Type inference failed for: r8v14 */
    /* JADX WARN: Type inference failed for: r8v15 */
    /* JADX WARN: Type inference failed for: r8v2 */
    /* JADX WARN: Type inference failed for: r8v3 */
    /* JADX WARN: Type inference failed for: r8v4, types: [java.io.FileOutputStream] */
    /* JADX WARN: Type inference failed for: r8v7 */
    /* JADX WARN: Type inference failed for: r8v8 */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final long writeToExternal(InputStream r100, String r101) {
        long r102 = 0;
        if (r101 != null) goto L5;
        return 0;
    L5:
        monitor-enter(FileUtils.class);
        PolarisFileWrapper r103 = new PolarisFileWrapper(r101);     // Catch: Throwable -> L38
        if (r103.exists() == true) goto L9;
        INSTANCE.createFile(r103.getPath(), true);     // Catch: Throwable -> L38
    L9:
        ?? r104 = 0;
        PolarisFileOutputStreamWrapper r105 = null;
        PolarisFileOutputStreamWrapper r106 = new PolarisFileOutputStreamWrapper(r103);     // Catch: Throwable -> L21 Exception -> L23
        TotalLengthOutputStream r107 = new TotalLengthOutputStream(r106);     // Catch: Throwable -> L17 Exception -> L19
        INSTANCE.copyStream(r100, r107);     // Catch: Throwable -> L17 Exception -> L19
        r107.flush();     // Catch: Throwable -> L17 Exception -> L19
        r107.close();     // Catch: Throwable -> L17 Exception -> L19
        r102 = r107.getLength();     // Catch: Throwable -> L17 Exception -> L19
        r106.close();     // Catch: IOException -> L14 Throwable -> L38
        r104 = r107;
    L45:
    L30:
        monitor-exit(FileUtils.class);
        return r102;
    L14:
        e = e;
    L15:
        e.printStackTrace();     // Catch: Throwable -> L38
        goto L30
    L19:
        e = e;
        r105 = r106;
    L24:
        e.printStackTrace();     // Catch: Throwable -> L21
        r104 = r105;
        if (r105 == null) goto L45;
        r105.close();     // Catch: IOException -> L28 Throwable -> L38
        r104 = r105;
    L28:
        e = e;
    L17:
        th = th;
        r104 = r106;
    L32:
        if (r104 != 0) goto L51;
    L37:
        throw th;     // Catch: Throwable -> L38
    L51:
        r104.close();     // Catch: IOException -> L35 Throwable -> L38
    L35:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L38
    L21:
        th = th;
    L23:
        e = e;
    L38:
        th = move-exception;
        throw th;
    }

    public final synchronized void rename(File r100, File r101, boolean r102) throws IOException {
        monitor-enter(this);
        if (r100 == null) goto L21;
        if (r101 == null) goto L19;
        if (r102 == false) goto L11;
    L16:
        th = move-exception;
        throw th;
    L8:
        if (r101.exists() == false) goto L11;
        FilesKt.deleteRecursively(r101);     // Catch: Throwable -> L16
    L11:
        if (r100.renameTo(r101) == false) goto L14;
        monitor-exit(this);
        return;
    L14:
        EPLog.e(TAG, "rename " + r100.getName() + " to " + r101.getName() + " failed!");     // Catch: Throwable -> L16
        throw new IOException();     // Catch: Throwable -> L16
    L19:
        monitor-exit(this);
        return;
    L21:
        monitor-exit(this);
    }

    public final synchronized void rename(String r100, String r101, boolean r102) throws IOException {
        monitor-enter(this);
        if (r100 == null) goto L13;
        if (r101 != null) goto L15;
        monitor-exit(this);
        return;
    L15:
        rename$default(this, new PolarisFileWrapper(r100), new PolarisFileWrapper(r101), false, 4, null);     // Catch: Throwable -> L8
        monitor-exit(this);
        return;
    L8:
        th = move-exception;
        throw th;
    L13:
        monitor-exit(this);
    }

    public final long copyStream(InputStream r110, OutputStream r111, long r112, DownloadListener r113) throws IOException {
        byte[] r100 = new byte[BUFFER_SIZE];
        int r101 = r110.read(r100);
        long r102 = 0;
    L4:
        if (r101 <= 0) goto L14;
        if (r111 == null) goto L7;
        r111.write(r100, 0, r101);
    L7:
        r102 = r102 + ((long) r101);
        if (r102 >= r112) goto L13;
        if (r112 <= 0) goto L13;
        if (r113 == null) goto L13;
        r113.onProgress((int) ((r102 / r112) * 100), r112);
    L13:
        r101 = r110.read(r100);
        goto L4
    L14:
        if (r113 == null) goto L16;
        r113.onProgress(100, r112);
    L16:
        return r102;
    }

    public final synchronized void rename(File r100, File r101, boolean r102, boolean r103) throws IOException {
        monitor-enter(this);
        if (r100 == null) goto L29;
        if (r101 == null) goto L27;
        if (r102 == false) goto L12;
        if (r103 == true) goto L12;
    L24:
        th = move-exception;
        throw th;
    L9:
        if (r101.exists() == false) goto L12;
        FilesKt.deleteRecursively(r101);     // Catch: Throwable -> L24
    L12:
        if (r100.renameTo(r101) == true) goto L22;
        if (r103 == false) goto L20;
        if (r102 == false) goto L20;
        FilesKt.deleteRecursively(r101);     // Catch: Throwable -> L24
        if (r100.renameTo(r101) == true) goto L22;
        EPLog.e(TAG, "rename " + r100.getName() + " to " + r101.getName() + " failed!");     // Catch: Throwable -> L24
        throw new IOException();     // Catch: Throwable -> L24
    L20:
        EPLog.e(TAG, "rename " + r100.getName() + " to " + r101.getName() + " failed!");     // Catch: Throwable -> L24
        throw new IOException();     // Catch: Throwable -> L24
    L22:
        monitor-exit(this);
        return;
    L27:
        monitor-exit(this);
        return;
    L29:
        monitor-exit(this);
    }

    public final synchronized void rename(String r100, String r101, boolean r102, boolean r103) throws IOException {
        monitor-enter(this);
        if (r100 == null) goto L13;
        if (r101 != null) goto L15;
        monitor-exit(this);
        return;
    L15:
        rename(new PolarisFileWrapper(r100), new PolarisFileWrapper(r101), r102, r103);     // Catch: Throwable -> L8
        monitor-exit(this);
        return;
    L8:
        th = move-exception;
        throw th;
    L13:
        monitor-exit(this);
    }

    public static /* synthetic */ void rename$default(FileUtils r100, File r101, File r102, boolean r103, int r104, Object r105) throws IOException {
        if ((r104 & 4) == 0) goto L5;
        r103 = true;
    L5:
        r100.rename(r101, r102, r103);
    }

    public static /* synthetic */ void rename$default(FileUtils r100, String r101, String r102, boolean r103, int r104, Object r105) throws IOException {
        if ((r104 & 4) == 0) goto L5;
        r103 = true;
    L5:
        r100.rename(r101, r102, r103);
    }

    public static /* synthetic */ void rename$default(FileUtils r100, File r101, File r102, boolean r103, boolean r104, int r105, Object r106) throws IOException {
        if ((r105 & 4) == 0) goto L6;
        r103 = true;
    L6:
        if ((r105 & 8) == 0) goto L8;
        r104 = false;
    L8:
        r100.rename(r101, r102, r103, r104);
    }

    public static /* synthetic */ void rename$default(FileUtils r100, String r101, String r102, boolean r103, boolean r104, int r105, Object r106) throws IOException {
        if ((r105 & 4) == 0) goto L6;
        r103 = true;
    L6:
        if ((r105 & 8) == 0) goto L8;
        r104 = false;
    L8:
        r100.rename(r101, r102, r103, r104);
    }
}
