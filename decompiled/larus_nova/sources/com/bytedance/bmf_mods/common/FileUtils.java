package com.bytedance.bmf_mods.common;

import android.content.Context;
import com.bytedance.ee.bear.drive.biz.upload.filepicker.model.BlockDevice;
import com.bytedance.ee.bear.drive.biz.upload.filepicker.model.CharacterDevice;
import com.bytedance.ee.bear.drive.biz.upload.filepicker.model.Directory;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.bytedance.security.android.aopcheck.PolarisZipFileWrapper;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.security.DigestInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.io.FilesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0019\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ\u0010\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\nH\u0002J\u0010\u0010\r\u001a\u00020\u000e2\b\u0010\u0007\u001a\u0004\u0018\u00010\bJ\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u001a\u0010\u0011\u001a\u00020\b2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\nH\u0007J\u0010\u0010\u0015\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bJ\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\bJ\u0018\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\bH\u0007J\u0018\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\bH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/bytedance/bmf_mods/common/FileUtils;", "", "()V", "HEX_DIGITS_LOWER", "", "checkFileReady", "", "file", "Ljava/io/File;", "md5", "", "containsMaliciousPath", "path", "deleteIfExist", "", "getFileMd5", "", "getModelDownloadDir", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "dirName", "isFileValid", "unzipFile", "sourceFile", "destPath", "unzipFileWithConfig", "bmf_mods_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class FileUtils {
    private static final char[] HEX_DIGITS_LOWER = null;
    public static final FileUtils INSTANCE = null;

    private FileUtils() {
    }

    static {
        INSTANCE = new FileUtils();
        HEX_DIGITS_LOWER = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', BlockDevice.UNIX_ID, CharacterDevice.UNIX_ID, Directory.UNIX_ID, 'e', 'f'};
    }

    private final boolean containsMaliciousPath(String r100) {
        return StringsKt.contains$default(r100, DownloadConstants.VULNERABILITY_PATH + File.separator, false, 2, null);
    }

    /* JADX WARN: Not initialized variable reg: 2, insn: 0x0042: MOVE (r0 I:??[OBJECT, ARRAY]) = (r2 I:??[OBJECT, ARRAY]) (LINE:16777282), block:B:30:0x0042 */
    private final byte[] getFileMd5(File r100) {
        DigestInputStream r101 = null;
        DigestInputStream r102 = new DigestInputStream(new PolarisFileInputStreamWrapper(r100), MessageDigest.getInstance("MD5"));     // Catch: Throwable -> L15 IOException -> L17 NoSuchAlgorithmException -> L23
    L44:
    L11:
        e = e;
    L19:
        e.printStackTrace();     // Catch: Throwable -> L29
        if (r102 != null) goto L42;
    L28:
        return null;
    L42:
        r102.close();     // Catch: IOException -> L35
    L13:
        e = e;
    L25:
        e.printStackTrace();     // Catch: Throwable -> L29
        if (r102 == null) goto L28;
    L7:
        if (r102.read(new byte[262144]) > 0) goto L7;
        byte[] r103 = r102.getMessageDigest().digest();     // Catch: IOException -> L11 NoSuchAlgorithmException -> L13 Throwable -> L29
        r102.close();     // Catch: IOException -> L34
    L10:
        return r103;
    L29:
        th = th;
        r101 = r2;
    L31:
        if (r101 != null) goto L38;
    L33:
        throw th;
    L38:
        r101.close();     // Catch: IOException -> L36
    L17:
        e = e;
        r102 = null;
    L23:
        e = e;
        r102 = null;
    L15:
        th = th;
        goto L31
    }

    public final void deleteIfExist(File r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r100.isFile() == true) goto L6;
        return;
    L6:
        if (r100.exists() == false) goto L11;
        r100.delete();
        return;
    }

    public final boolean isFileValid(File r100) {
        if (r100 != null) goto L4;
    L10:
        return false;
    L4:
        if (r100.exists() == false) goto L10;
        if (r100.isFile() == false) goto L10;
        if (r100.length() <= 0) goto L10;
        return true;
    }

    public final String md5(File r100) {
        Intrinsics.checkNotNullParameter(r100, "file");
        if (isFileValid(r100) == true) goto L5;
        return "";
    L5:
        byte[] r101 = getFileMd5(r100);
        if (r101 != null) goto L8;
        return "";
    L8:
        int r102 = r101.length;
        if (r102 > 0) goto L11;
        return "";
    L11:
        char[] r103 = new char[r102 << 1];
        int r104 = 0;
        int r105 = 0;
    L12:
        if (r104 >= r102) goto L15;
        int r106 = r105 + 1;
        char[] r107 = HEX_DIGITS_LOWER;
        byte r108 = r101[r104];
        r103[r105] = r107[(r108 >> 4) & 15];
        r105 = r106 + 1;
        r103[r106] = r107[r108 & 15];
        r104 = r104 + 1;
        goto L12
    L15:
        return new String(r103);
    }

    @JvmStatic
    public static final File getModelDownloadDir(Context r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "dirName");
        if (r100 == null) goto L6;
        return new PolarisFileWrapper(r100.getFilesDir().toString() + File.separator + "bmf_mods_lite_models", r101);
    L6:
        return new PolarisFileWrapper(new PolarisFileWrapper("/data/local/tmp/bmf_mods_lite_models"), r101);
    }

    @JvmStatic
    public static final boolean unzipFile(File r110, File r111) {
        Intrinsics.checkNotNullParameter(r110, "sourceFile");
        Intrinsics.checkNotNullParameter(r111, "destPath");
        if (r111.exists() == true) goto L61;
        r111.mkdirs();
    L61:
        PolarisZipFileWrapper r100 = new PolarisZipFileWrapper(r110);     // Catch: SecurityException -> L50 IOException -> L52
        Enumeration<? extends ZipEntry> r101 = r100.entries();     // Catch: SecurityException -> L50 IOException -> L52
    L8:
        if (r101.hasMoreElements() == false) goto L48;
        ZipEntry r102 = r101.nextElement();     // Catch: SecurityException -> L50 IOException -> L52
        if (StringsKt.contains$default(r102.getName(), "__MACOSX", false, 2, null) == true) goto L8;
        if (INSTANCE.containsMaliciousPath(r102.getName()) == true) goto L47;
        PolarisFileWrapper r103 = new PolarisFileWrapper(r111, r102.getName());     // Catch: SecurityException -> L50 IOException -> L52
        if (StringsKt.startsWith$default(r103.getCanonicalPath(), r111.getCanonicalPath() + File.separator, false, 2, null) == false) goto L45;
        if (r102.isDirectory() == true) goto L18;
        InputStream r104 = r100.getInputStream(r102);     // Catch: IOException -> L41 SecurityException -> L50
        PolarisFileOutputStreamWrapper r105 = new PolarisFileOutputStreamWrapper(r103);     // Catch: Throwable -> L36
        byte[] r106 = new byte[8192];     // Catch: Throwable -> L31
    L24:
        int r107 = r104.read(r106);     // Catch: Throwable -> L31
        if (r107 <= 0) goto L27;
        r105.write(r106, 0, r107);     // Catch: Throwable -> L31
        goto L24
    L27:
        r105.flush();     // Catch: Throwable -> L31
        Unit r108 = Unit.INSTANCE;     // Catch: Throwable -> L31
        CloseableKt.closeFinally(r105, null);     // Catch: Throwable -> L36
        CloseableKt.closeFinally(r104, null);     // Catch: IOException -> L41 SecurityException -> L50
        goto L8
    L31:
        th = move-exception;
        throw th;     // Catch: Throwable -> L33
    L33:
        th = move-exception;
        CloseableKt.closeFinally(r105, th);     // Catch: Throwable -> L36
        throw th;     // Catch: Throwable -> L36
    L36:
        th = move-exception;
        throw th;     // Catch: Throwable -> L38
    L38:
        th = move-exception;
        CloseableKt.closeFinally(r104, th);     // Catch: IOException -> L41 SecurityException -> L50
        throw th;     // Catch: IOException -> L41 SecurityException -> L50
    L41:
        e = move-exception;
        Logging.e("unzip model " + r110.getName() + " failed, " + e.getMessage());     // Catch: SecurityException -> L50 IOException -> L52
        return false;
    L18:
        r103.mkdirs();     // Catch: SecurityException -> L50 IOException -> L52
        goto L8
    L45:
        throw new SecurityException("unzip file contains malicious path 2");     // Catch: SecurityException -> L50 IOException -> L52
    L47:
        throw new SecurityException("unzip file contains malicious path 2");     // Catch: SecurityException -> L50 IOException -> L52
    L48:
        r100.close();     // Catch: SecurityException -> L50 IOException -> L52
        Logging.d("unzip model " + r110.getName() + " success");     // Catch: SecurityException -> L50 IOException -> L52
        return true;
    L50:
        e = move-exception;
        Logging.e("unzip model file " + r110.getAbsolutePath() + " aborted due to security reason, message: " + e.getMessage());
        return false;
    L52:
        e = move-exception;
        Logging.e("unzip model " + r110.getName() + " failed, " + e.getMessage());
        return false;
    }

    @JvmStatic
    public static final boolean unzipFileWithConfig(File r110, File r111) {
        r111 = r111;
        Intrinsics.checkNotNullParameter(r110, "sourceFile");
        Intrinsics.checkNotNullParameter(r111, "destPath");
        if (r111.exists() == true) goto L5;
        r111.mkdirs();
    L5:
        File r100 = FilesKt.resolveSibling(r110, r110.getName() + "_config.json");
        Object r101 = null;
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L12
        if (r100.exists() == false) goto L9;
        JSONObject r103 = new JSONObject(FilesKt.readText$default(r100, null, 1, null));     // Catch: Throwable -> L12
    L10:
        Object r104 = Result.m9449constructorimpl(r103);     // Catch: Throwable -> L12
    L14:
        JSONObject r105 = new JSONObject();
        if (Result.m9455isFailureimpl(r104) == false) goto L17;
        r104 = r105;
    L17:
        JSONObject r106 = (JSONObject) r104;
        boolean r107 = false;
        String r108 = INSTANCE.md5(r110);     // Catch: SecurityException -> L93 IOException -> L95
        if (r106.has(r110.getName()) == true) goto L22;
    L23:
        r106.put(r110.getName(), r108);     // Catch: SecurityException -> L93 IOException -> L95
        r106.remove("file_list");     // Catch: SecurityException -> L93 IOException -> L95
    L24:
        JSONObject r109 = r106.optJSONObject("file_list");     // Catch: SecurityException -> L93 IOException -> L95
        if (r109 != null) goto L27;
        r109 = new JSONObject();     // Catch: SecurityException -> L93 IOException -> L95
    L27:
        PolarisZipFileWrapper r112 = new PolarisZipFileWrapper(r110);     // Catch: SecurityException -> L93 IOException -> L95
        Enumeration<? extends ZipEntry> r113 = r112.entries();     // Catch: SecurityException -> L93 IOException -> L95
    L29:
        if (r113.hasMoreElements() == false) goto L90;
        ZipEntry r114 = r113.nextElement();     // Catch: SecurityException -> L93 IOException -> L95
        if (StringsKt.contains$default(r114.getName(), "__MACOSX", r107, 2, r101) == true) goto L29;
        FileUtils r115 = INSTANCE;     // Catch: SecurityException -> L93 IOException -> L95
        if (r115.containsMaliciousPath(r114.getName()) == true) goto L88;
        PolarisFileWrapper r116 = new PolarisFileWrapper(r111, r114.getName());     // Catch: SecurityException -> L93 IOException -> L95
        Enumeration<? extends ZipEntry> r117 = r113;
        if (StringsKt.startsWith$default(r116.getCanonicalPath(), r111.getCanonicalPath() + File.separator, false, 2, null) == false) goto L86;
        if (r114.isDirectory() == false) goto L45;
        if (r116.exists() == true) goto L45;
        r116.mkdirs();     // Catch: SecurityException -> L93 IOException -> L95
    L42:
        r101 = null;
        r113 = r117;
        r107 = false;
    L45:
        if (r109.has(r114.getName()) == false) goto L50;
        Object r118 = r109.get(r114.getName());     // Catch: SecurityException -> L93 IOException -> L95
        Intrinsics.checkNotNull(r118, "null cannot be cast to non-null type kotlin.String");     // Catch: SecurityException -> L93 IOException -> L95
        if (r115.checkFileReady(r116, (String) r118) == true) goto L42;
    L50:
        if (r109.has(r114.getName()) == false) goto L54;
        Object r119 = r109.get(r114.getName());     // Catch: SecurityException -> L93 IOException -> L95
        Intrinsics.checkNotNull(r119, "null cannot be cast to non-null type kotlin.String");     // Catch: SecurityException -> L93 IOException -> L95
        if (r115.checkFileReady(r116, (String) r119) == true) goto L54;
        r109.remove(r114.getName());     // Catch: SecurityException -> L93 IOException -> L95
    L54:
        r115.deleteIfExist(r116);     // Catch: SecurityException -> L93 IOException -> L95
        InputStream r120 = r112.getInputStream(r114);     // Catch: IOException -> L82 SecurityException -> L93
        PolarisFileOutputStreamWrapper r121 = new PolarisFileOutputStreamWrapper(r116);     // Catch: Throwable -> L75
        byte[] r122 = new byte[8192];     // Catch: Throwable -> L68
    L59:
        int r123 = r120.read(r122);     // Catch: Throwable -> L68
        if (r123 <= 0) goto L62;
        r121.write(r122, 0, r123);     // Catch: Throwable -> L68
        goto L59
    L62:
        r121.flush();     // Catch: Throwable -> L68
        Unit r124 = Unit.INSTANCE;     // Catch: Throwable -> L68
        CloseableKt.closeFinally(r121, null);     // Catch: Throwable -> L75
        CloseableKt.closeFinally(r120, null);     // Catch: IOException -> L82 SecurityException -> L93
        r109.put(r114.getName(), INSTANCE.md5(r116));     // Catch: SecurityException -> L93 IOException -> L95
        goto L42
    L68:
        th = move-exception;
        throw th;     // Catch: Throwable -> L71
    L71:
        th = move-exception;
        CloseableKt.closeFinally(r121, th);     // Catch: Throwable -> L75
        throw th;     // Catch: Throwable -> L75
    L75:
        th = move-exception;
        throw th;     // Catch: Throwable -> L78
    L78:
        th = move-exception;
        CloseableKt.closeFinally(r120, th);     // Catch: IOException -> L82 SecurityException -> L93
        throw th;     // Catch: IOException -> L82 SecurityException -> L93
    L82:
        e = move-exception;
        Logging.e("unzip model " + r110.getName() + " failed, " + e.getMessage());     // Catch: SecurityException -> L93 IOException -> L95
        return false;
    L86:
        throw new SecurityException("unzip file contains malicious path");     // Catch: SecurityException -> L93 IOException -> L95
    L88:
        throw new SecurityException("unzip file contains malicious path");     // Catch: SecurityException -> L93 IOException -> L95
    L90:
        r112.close();     // Catch: SecurityException -> L93 IOException -> L95
        r106.put("file_list", r109);     // Catch: SecurityException -> L93 IOException -> L95
        FilesKt.writeText$default(r100, r106.toString(), null, 2, null);     // Catch: SecurityException -> L93 IOException -> L95
        Logging.d("unzip model " + r110.getName() + " success");     // Catch: SecurityException -> L93 IOException -> L95
        return true;
    L22:
        if (Intrinsics.areEqual(r106.get(r110.getName()), r108) == true) goto L24;
    L95:
        e = move-exception;
        Logging.e("unzip model " + r110.getName() + " failed, " + e.getMessage());
        return false;
    L93:
        e = move-exception;
        Logging.e("unzip model file " + r110.getAbsolutePath() + " aborted due to security reason, message: " + e.getMessage());
        return false;
    L9:
        r103 = new JSONObject();     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        Result.Companion r125 = Result.Companion;
        r104 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L14
    }

    public final boolean checkFileReady(File r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "file");
        Intrinsics.checkNotNullParameter(r101, "md5");
        if (isFileValid(r100) == true) goto L5;
    L7:
        return false;
    L5:
        if (Intrinsics.areEqual(md5(r100), r101) == false) goto L7;
        return true;
    }
}
