package com.bytedance.security.android.polaris;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import f06.b;
import f06.d;
import g06.a;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.util.ArrayList;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import kotlin.Metadata;
import kotlin.io.ByteStreamsKt;
import kotlin.io.FilesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes22.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0015\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0000¢\u0006\u0002\b\u0007J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0002J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\tH\u0007J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u0006H\u0007J\u001c\u0010\u000f\u001a\u0004\u0018\u00010\t2\b\u0010\u0010\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0011\u001a\u00020\u0006H\u0007J\u001c\u0010\u000f\u001a\u0004\u0018\u00010\t2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0011\u001a\u00020\u0006H\u0007J\u001a\u0010\u0012\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\tH\u0007J\u001a\u0010\u0012\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u000e\u001a\u00020\tH\u0007J\u001a\u0010\u0012\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u000e\u001a\u00020\u0006H\u0007J\u001a\u0010\u0012\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\tH\u0007J\u001a\u0010\u0012\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u0006H\u0007J\u0018\u0010\u0016\u001a\u00020\u00172\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\tH\u0007J \u0010\u0016\u001a\u00020\u00172\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\tH\u0007J \u0010\u0016\u001a\u00020\u00172\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0006H\u0007J\u0018\u0010\u0016\u001a\u00020\u00172\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u0006H\u0007J\u0018\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\tH\u0007J\u0018\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u0006H\u0007J\u0018\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\tH\u0007J \u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\tH\u0007J \u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0006H\u0007J\u0018\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u0006H\u0007J\u0018\u0010\u001e\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u001f\u001a\u00020 H\u0007J\u0018\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020 H\u0007J\u0018\u0010!\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u001f\u001a\u00020 H\u0007J\u0018\u0010!\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020 H\u0007J\u0018\u0010\"\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u001f\u001a\u00020 H\u0007J\u0018\u0010\"\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020 H\u0007J\u001d\u0010#\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t2\u0006\u0010$\u001a\u00020\tH\u0000¢\u0006\u0002\b%J\u001d\u0010#\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t2\u0006\u0010$\u001a\u00020\u0006H\u0000¢\u0006\u0002\b%J\u001d\u0010#\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u00062\u0006\u0010$\u001a\u00020\u0006H\u0000¢\u0006\u0002\b%J\u0018\u0010&\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020'2\u0006\u0010\u001f\u001a\u00020 H\u0007J\u001a\u0010(\u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020 2\b\u0010)\u001a\u0004\u0018\u00010*H\u0002J\u0018\u0010+\u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010\u0013\u001a\u00020'H\u0002J\u0018\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020\t2\u0006\u0010/\u001a\u00020\tH\u0007J\u0018\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020\t2\u0006\u0010/\u001a\u00020\u0006H\u0007J\u0018\u0010,\u001a\u00020-2\u0006\u00100\u001a\u0002012\u0006\u0010/\u001a\u00020\tH\u0007J\u0018\u0010,\u001a\u00020-2\u0006\u00102\u001a\u00020\u00062\u0006\u0010/\u001a\u00020\tH\u0007J\u0018\u0010,\u001a\u00020-2\u0006\u00102\u001a\u00020\u00062\u0006\u0010/\u001a\u00020\u0006H\u0007¨\u00063"}, d2 = {"Lcom/bytedance/security/android/polaris/PolarisFile;", "", "()V", "containsMaliciousPath", "", "path", "", "containsMaliciousPath$polaris_release", "getFinalCanonicalFile", "Ljava/io/File;", "file", "getSafeFileInputStreamUnderAllowedFolder", "Ljava/io/FileInputStream;", "name", "allowedFolder", "getSafeFileOrNull", "parent", MapBundleKey.OfflineMapKey.OFFLINE_CHILD, "getSafeFileOrNullUnderAllowedFolder", "uri", "Ljava/net/URI;", "pathname", "getSafeFileOutputStreamUnderAllowedFolder", "Ljava/io/FileOutputStream;", "append", "getSafeFileReaderUnderAllowedFolder", "Ljava/io/FileReader;", "fileName", "getSafeFileWriterUnderAllowedFolder", "Ljava/io/FileWriter;", "isFileInAppExternalSandbox", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "isFileInAppInternalSandbox", "isFileInAppSandbox", "isFileInTargetDir", "targetDir", "isFileInTargetDir$polaris_release", "isFileSafeToUpload", "Landroid/net/Uri;", "isInternalFile", "fileDescriptor", "Landroid/os/ParcelFileDescriptor;", "isInternalUri", "safeUnzip", "", "zipFile", "destFolder", "inputStream", "Ljava/io/InputStream;", "zipPath", "polaris_release"}, k = 1, mv = {1, 1, 15})
public final class PolarisFile {
    public static final PolarisFile INSTANCE = null;

    private PolarisFile() {
    }

    static {
        INSTANCE = new PolarisFile();
    }

    private final File getFinalCanonicalFile(String r100) {
        return getFinalCanonicalFile(new File(r100));
    }

    public final boolean containsMaliciousPath$polaris_release(String r100) {
        return StringsKt.contains$default(r100, DownloadConstants.VULNERABILITY_PATH + File.separator, false, 2, null);
    }

    private final File getFinalCanonicalFile(File r100) {
        return r100.getCanonicalFile().getCanonicalFile();
    }

    @JvmStatic
    public static final FileInputStream getSafeFileInputStreamUnderAllowedFolder(String r100, File r101) throws FileNotFoundException {
        PolarisFile r102 = INSTANCE;
        File r103 = r102.getFinalCanonicalFile(new File(r100));
        if (r102.containsMaliciousPath$polaris_release(r100) == true) goto L9;
        if (r102.isFileInTargetDir$polaris_release(r103, r102.getFinalCanonicalFile(r101)) == false) goto L9;
        return new FileInputStream(r103);
    L9:
        throw new FileNotFoundException("Malicious file path");
    }

    @JvmStatic
    public static final File getSafeFileOrNull(String r100, String r101) {
        if (r100 != null) goto L23;
    L8:
        boolean r102 = true;
    L9:
        if (r102 == true) goto L11;
        PolarisFile r103 = INSTANCE;     // Catch: IOException -> L22
        if (r103.containsMaliciousPath$polaris_release(r100) == false) goto L16;
        return null;
    L16:
        if (r103.containsMaliciousPath$polaris_release(r101) == false) goto L18;
        return null;
    L18:
        File r104 = r103.getFinalCanonicalFile(new File(r100, r101));     // Catch: IOException -> L22
        if (r103.isFileInTargetDir$polaris_release(r104, r100) == true) goto L21;
        return null;
    L21:
        return r104;
    L11:
        return INSTANCE.getFinalCanonicalFile(new File(r100, r101));
    L23:
        if (r100.length() == 0) goto L8;
        r102 = false;
        goto L9
    L25:
        return null;
    }

    @JvmStatic
    public static final File getSafeFileOrNullUnderAllowedFolder(File r100, File r101) {
        PolarisFile r102 = INSTANCE;     // Catch: IOException -> L7
        File r103 = r102.getFinalCanonicalFile(r100);     // Catch: IOException -> L7
        if (r102.isFileInTargetDir$polaris_release(r103, r102.getFinalCanonicalFile(r101)) == true) goto L6;
        return null;
    L6:
        return r103;
    L11:
        return null;
    }

    @JvmStatic
    public static final FileOutputStream getSafeFileOutputStreamUnderAllowedFolder(String r100, String r101) throws FileNotFoundException {
        return getSafeFileOutputStreamUnderAllowedFolder(r100, false, new File(r101));
    }

    @JvmStatic
    public static final FileReader getSafeFileReaderUnderAllowedFolder(String r100, File r101) throws FileNotFoundException {
        PolarisFile r102 = INSTANCE;
        File r103 = r102.getFinalCanonicalFile(new File(r100));
        if (r102.containsMaliciousPath$polaris_release(r100) == true) goto L9;
        if (r102.isFileInTargetDir$polaris_release(r103, r102.getFinalCanonicalFile(r101)) == false) goto L9;
        return new FileReader(r103);
    L9:
        throw new FileNotFoundException("Malicious file path");
    }

    @JvmStatic
    public static final FileWriter getSafeFileWriterUnderAllowedFolder(String r100, String r101) throws IOException {
        return getSafeFileWriterUnderAllowedFolder(r100, false, new File(r101));
    }

    @JvmStatic
    public static final boolean isFileInAppExternalSandbox(File r100, Context r101) throws NullPointerException {
        File r102 = r101.getExternalFilesDir(null);     // Catch: NullPointerException -> L11
        if (r102 != null) goto L6;
        Intrinsics.throwNpe();     // Catch: NullPointerException -> L11
    L6:
        String r103 = r102.getParent();     // Catch: NullPointerException -> L11
        if (r103 != null) goto L9;
        Intrinsics.throwNpe();     // Catch: NullPointerException -> L11
    L9:
        String r104 = new File(r103).getCanonicalPath();     // Catch: NullPointerException -> L11
        return StringsKt.startsWith$default(INSTANCE.getFinalCanonicalFile(r100).getCanonicalPath(), r104, false, 2, null);
    L11:
        e = move-exception;
        throw e;
    }

    @JvmStatic
    public static final boolean isFileInAppInternalSandbox(File r100, Context r101) {
        String r102 = new File(r101.getApplicationInfo().dataDir).getCanonicalPath();
        return StringsKt.startsWith$default(INSTANCE.getFinalCanonicalFile(r100).getCanonicalPath(), r102, false, 2, null);
    }

    @JvmStatic
    public static final boolean isFileInAppSandbox(File r100, Context r101) throws NullPointerException {
        File r102 = r101.getExternalFilesDir(null);     // Catch: NullPointerException -> L12
        if (r102 != null) goto L6;
        Intrinsics.throwNpe();     // Catch: NullPointerException -> L12
    L6:
        String r103 = r102.getParent();     // Catch: NullPointerException -> L12
        if (r103 != null) goto L9;
        Intrinsics.throwNpe();     // Catch: NullPointerException -> L12
    L9:
        String r104 = new File(r103).getCanonicalPath();     // Catch: NullPointerException -> L12
        String r105 = new File(r101.getApplicationInfo().dataDir).getCanonicalPath();     // Catch: NullPointerException -> L12
        String r106 = INSTANCE.getFinalCanonicalFile(r100).getCanonicalPath();     // Catch: NullPointerException -> L12
        boolean r107 = StringsKt.startsWith$default(r106, r104, false, 2, null);     // Catch: NullPointerException -> L12
        return StringsKt.startsWith$default(r106, r105, false, 2, null) | r107;
    L12:
        e = move-exception;
        throw e;
    }

    @JvmStatic
    public static final boolean isFileSafeToUpload(Uri r100, Context r101) throws NullPointerException, IOException {
    L17:
        e = move-exception;
        throw e;
    L3:
        if (Intrinsics.areEqual(r100.getScheme(), "file") == false) goto L12;
        if (r100.getPath() == null) goto L12;
        String r102 = r100.getPath();     // Catch: IOException -> L17
        if (r102 != null) goto L10;
        Intrinsics.throwNpe();     // Catch: IOException -> L17
    L10:
        return !isFileInAppSandbox(r102, r101);
    L12:
        if (Intrinsics.areEqual(r100.getScheme(), "content") == true) goto L15;
        return true;
    L15:
        return !INSTANCE.isInternalUri(r101, r100);
    }

    private final boolean isInternalFile(Context r100, ParcelFileDescriptor r101) throws IOException {
        if (r101 == null) goto L10;
        String r102 = new File("/proc/self/fd/" + r101.getFd()).getCanonicalPath();
        String r103 = new File(r100.getApplicationInfo().dataDir).getCanonicalPath();
        String r104 = File.separator;
        if (StringsKt.endsWith$default(r103, r104, false, 2, null) == true) goto L8;
        r103 = r103 + r104;
    L8:
        return StringsKt.startsWith$default(r102, r103, false, 2, null);
    L10:
        throw new IOException("File descriptor is null");
    }

    private final boolean isInternalUri(Context r100, Uri r101) throws IOException {
        return isInternalFile(r100, com_bytedance_security_android_polaris_PolarisFile_android_content_ContentResolver_openFileDescriptor(r100.getContentResolver(), r101, "r"));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [T, java.util.zip.ZipEntry] */
    @JvmStatic
    public static final void safeUnzip(InputStream r100, File r101) throws IOException {
        ZipInputStream r102 = new ZipInputStream(r100);     // Catch: IOException -> L26
        Ref.ObjectRef r103 = new Ref.ObjectRef();     // Catch: IOException -> L26
    L3:
        ?? r104 = r102.getNextEntry();     // Catch: IOException -> L26
        r103.element = r104;     // Catch: IOException -> L26
        if (r104 == 0) goto L24;
        ZipEntry r105 = (ZipEntry) r104;     // Catch: IOException -> L26
        if (r104 == 0) goto L3;
        String r106 = r104.getName();     // Catch: IOException -> L26
        if (r106 == null) goto L3;
        if (INSTANCE.containsMaliciousPath$polaris_release(r106) == true) goto L11;
        File r107 = new File(r101, r106);     // Catch: IOException -> L26
        ZipEntry r108 = (ZipEntry) r103.element;     // Catch: IOException -> L26
        if (r108 != null) goto L15;
    L17:
        File r109 = r107.getParentFile();     // Catch: IOException -> L26
        if (r109 != null) goto L20;
    L22:
        FileOutputStream r110 = new FileOutputStream(r107);     // Catch: IOException -> L26
        ByteStreamsKt.copyTo$default(r102, r110, 0, 2, null);     // Catch: IOException -> L26
        r110.close();     // Catch: IOException -> L26
    L23:
        r102.closeEntry();     // Catch: IOException -> L26
        goto L3
    L20:
        if (r109.exists() == true) goto L22;
        r109.mkdirs();     // Catch: IOException -> L26
        goto L22
    L15:
        if (r108.isDirectory() != true) goto L17;
        r107.mkdirs();     // Catch: IOException -> L26
        goto L23
    L11:
        r102.closeEntry();     // Catch: IOException -> L26
        goto L3
    L24:
        r102.close();     // Catch: IOException -> L26
        return;
    L26:
        e = move-exception;
        throw e;
    }

    public final boolean isFileInTargetDir$polaris_release(File r100, File r101) {
        return (!Intrinsics.areEqual(r100, r101)) & FilesKt.startsWith(r100, new File(r101, HTTP.URL_DEFAULT));
    L4:
        return false;
    }

    @JvmStatic
    public static final FileInputStream getSafeFileInputStreamUnderAllowedFolder(String r100, String r101) throws FileNotFoundException {
        return getSafeFileInputStreamUnderAllowedFolder(r100, new File(r101));
    }

    @JvmStatic
    public static final File getSafeFileOrNull(File r100, String r101) {
        if (r100 == null) goto L4;
        String r102 = r100.getPath();
    L6:
        return getSafeFileOrNull(r102, r101);
    L4:
        r102 = null;
        goto L6
    }

    @JvmStatic
    public static final File getSafeFileOrNullUnderAllowedFolder(String r100, String r101) {
        return getSafeFileOrNullUnderAllowedFolder(new File(r100), new File(r101));
    }

    @JvmStatic
    public static final FileOutputStream getSafeFileOutputStreamUnderAllowedFolder(String r100, File r101) throws FileNotFoundException {
        return getSafeFileOutputStreamUnderAllowedFolder(r100, false, r101);
    }

    @JvmStatic
    public static final FileReader getSafeFileReaderUnderAllowedFolder(String r100, String r101) throws FileNotFoundException {
        return getSafeFileReaderUnderAllowedFolder(r100, new File(r101));
    }

    @JvmStatic
    public static final FileWriter getSafeFileWriterUnderAllowedFolder(String r100, File r101) throws IOException {
        return getSafeFileWriterUnderAllowedFolder(r100, false, r101);
    }

    @JvmStatic
    public static final boolean isFileInAppExternalSandbox(String r100, Context r101) throws NullPointerException {
        return isFileInAppExternalSandbox(new File(r100), r101);
    }

    @JvmStatic
    public static final boolean isFileInAppInternalSandbox(String r100, Context r101) {
        return isFileInAppInternalSandbox(new File(r100), r101);
    }

    @JvmStatic
    public static final boolean isFileInAppSandbox(String r100, Context r101) throws NullPointerException {
        return isFileInAppSandbox(new File(r100), r101);
    }

    @JvmStatic
    public static final void safeUnzip(File r100, String r101) throws IOException {
        safeUnzip(new FileInputStream(r100), new File(r101));
    }

    public final boolean isFileInTargetDir$polaris_release(String r100, String r101) {
        return isFileInTargetDir$polaris_release(getFinalCanonicalFile(r100), getFinalCanonicalFile(r101));
    }

    @JvmStatic
    public static final File getSafeFileOrNullUnderAllowedFolder(URI r100, String r101) {
        return getSafeFileOrNullUnderAllowedFolder(new File(r100), new File(r101));
    }

    @JvmStatic
    public static final void safeUnzip(String r100, String r101) throws IOException {
        safeUnzip(new FileInputStream(r100), new File(r101));
    }

    public final boolean isFileInTargetDir$polaris_release(File r100, String r101) {
        return isFileInTargetDir$polaris_release(r100, getFinalCanonicalFile(r101));
    }

    @JvmStatic
    public static final File getSafeFileOrNullUnderAllowedFolder(String r100, File r101) {
        return getSafeFileOrNullUnderAllowedFolder(new File(r100), r101);
    }

    @JvmStatic
    public static final void safeUnzip(File r100, File r101) throws IOException {
        safeUnzip(new FileInputStream(r100), r101);
    }

    @JvmStatic
    public static final File getSafeFileOrNullUnderAllowedFolder(URI r100, File r101) {
        return getSafeFileOrNullUnderAllowedFolder(new File(r100), r101);
    }

    @JvmStatic
    public static final void safeUnzip(String r100, File r101) throws IOException {
        safeUnzip(new FileInputStream(r100), r101);
    }

    private static ParcelFileDescriptor com_bytedance_security_android_polaris_PolarisFile_android_content_ContentResolver_openFileDescriptor(ContentResolver r110, Uri r111, String r210) throws IOException {
        ArrayList r100 = new ArrayList();
        Object[] r101 = {r111, r210};
        b r112 = new b();
        a r102 = ApiHookConfig.f245611b.get(240020);
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
        d r107 = r106.preInvoke(240020, "android/content/ContentResolver", "openFileDescriptor", r110, r101, "android.os.ParcelFileDescriptor", r112);     // Catch: Exception -> L22
        if (r107.f474982a == true) goto L17;
        r100.add(r106);     // Catch: Exception -> L22
    L17:
        if (r107.f474982a == false) goto L21;
        return (ParcelFileDescriptor) r107.f474983b;
    L21:
        return r110.openFileDescriptor(r111, r210);
    L14:
        r105 = r114 + 1;
        r104 = r115;
        goto L8
    L15:
        r107 = new d(false, null);
        goto L17
    L5:
        r103 = ApiHookConfig.f245613d;
        goto L6
    }

    @JvmStatic
    public static final FileOutputStream getSafeFileOutputStreamUnderAllowedFolder(String r100, boolean r101, File r102) throws FileNotFoundException {
        PolarisFile r103 = INSTANCE;
        File r104 = r103.getFinalCanonicalFile(new File(r100));
        if (r103.containsMaliciousPath$polaris_release(r100) == true) goto L9;
        if (r103.isFileInTargetDir$polaris_release(r104, r103.getFinalCanonicalFile(r102)) == false) goto L9;
        return new FileOutputStream(r104, r101);
    L9:
        throw new FileNotFoundException("Malicious file path");
    }

    @JvmStatic
    public static final FileWriter getSafeFileWriterUnderAllowedFolder(String r100, boolean r101, File r102) throws IOException {
        PolarisFile r103 = INSTANCE;
        File r104 = r103.getFinalCanonicalFile(new File(r100));
        if (r103.containsMaliciousPath$polaris_release(r100) == true) goto L9;
        if (r103.isFileInTargetDir$polaris_release(r104, r103.getFinalCanonicalFile(r102)) == false) goto L9;
        return new FileWriter(r104, r101);
    L9:
        throw new FileNotFoundException("Malicious file path");
    }

    @JvmStatic
    public static final FileOutputStream getSafeFileOutputStreamUnderAllowedFolder(String r100, boolean r101, String r102) throws FileNotFoundException {
        return getSafeFileOutputStreamUnderAllowedFolder(r100, r101, new File(r102));
    }

    @JvmStatic
    public static final FileWriter getSafeFileWriterUnderAllowedFolder(String r100, boolean r101, String r102) throws IOException {
        return getSafeFileWriterUnderAllowedFolder(r100, r101, new File(r102));
    }
}
