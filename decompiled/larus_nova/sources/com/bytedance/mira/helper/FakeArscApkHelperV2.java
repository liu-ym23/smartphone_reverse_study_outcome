package com.bytedance.mira.helper;

import android.content.Context;
import android.system.Os;
import com.bytedance.mira.Mira;
import com.bytedance.mira.util.FastFileUtils;
import com.bytedance.mira.util.FileUtils;
import com.bytedance.mira.util.IOUtils;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.bytedance.security.android.aopcheck.PolarisZipFileWrapper;
import java.io.File;
import java.io.InputStream;
import java.util.zip.CRC32;

/* JADX INFO: loaded from: classes3.dex */
public class FakeArscApkHelperV2 {
    private static final String ASSET_FILE_NAME = "fake_plugin_arsc.zip";
    private static final String BASE_FAKE_APK_PACKAGE = "base";
    private static final long FAILED_CRC32 = -1;
    private static final int MAX_RETRY = 3;
    private static final String ZIP_ENTRY_ASSET_PATH = "assets/fake_plugin_arsc.zip";
    private static String sBaseFakeApkPath;
    private static boolean sInit;
    private static boolean sInitResult;

    /* JADX INFO: loaded from: classes21.dex */
    public static class FileResult {
        public final boolean copiedResult;
        public final long crc32;

        public FileResult(boolean r100, long r101) {
            this.copiedResult = r100;
            this.crc32 = r101;
        }
    }

    public FakeArscApkHelperV2() {
    }

    public static boolean init() {
        if (sInit == true) goto L12;
        String r100 = FastPluginDirHelperV3.getFakeSourceFile("base");
        if (FastFileUtils.isExist(r100) == true) goto L7;
    L9:
        sInitResult = initInternal(r100, FastPluginDirHelperV3.getFakeSourceBakFile("base"), 3);
    L10:
        sBaseFakeApkPath = r100;
        sInit = true;
        goto L12
    L7:
        if (isCompleteApk(r100) == false) goto L9;
        sInitResult = true;
    L12:
        return sInitResult;
    }

    public static boolean buildFakeApk(String r100) {
    L9:
        return false;
    L4:
        if (init() == true) goto L6;
        return false;
    L6:
        Os.symlink(sBaseFakeApkPath, r100);     // Catch: Throwable -> L9
        return true;
    }

    private static long calculationFileCrc32(File r100) {
        CRC32 r101 = new CRC32();
        PolarisFileInputStreamWrapper r102 = null;
        PolarisFileInputStreamWrapper r103 = new PolarisFileInputStreamWrapper(r100);     // Catch: Throwable -> L15
        byte[] r104 = new byte[1024];     // Catch: Throwable -> L12
    L6:
        int r105 = r103.read(r104);     // Catch: Throwable -> L12
        if (r105 == (-1)) goto L9;
        r101.update(r104, 0, r105);     // Catch: Throwable -> L12
        goto L6
    L9:
        long r106 = r101.getValue();     // Catch: Throwable -> L12
        IOUtils.closeSilently(r103);
        return r106;
    L12:
        r102 = r103;
    L13:
        IOUtils.closeSilently(r102);
        return -1;
    }

    private static boolean isCompleteApk(String r100) {
        return isCompleteApk(r100, -1);
    }

    private static FileResult initBaseApk(Context r100, String r101) {
        CRC32 r102 = new CRC32();
        InputStream r103 = null;
        PolarisFileOutputStreamWrapper r104 = new PolarisFileOutputStreamWrapper(r101);     // Catch: Throwable -> L11
        r103 = r100.getAssets().open(ASSET_FILE_NAME);     // Catch: Throwable -> L17
        byte[] r105 = new byte[1024];     // Catch: Throwable -> L17
    L5:
        int r106 = r103.read(r105);     // Catch: Throwable -> L17
        if (r106 == (-1)) goto L8;
        r104.write(r105, 0, r106);     // Catch: Throwable -> L17
        r102.update(r105, 0, r106);     // Catch: Throwable -> L17
        goto L5
    L8:
        FileResult r107 = new FileResult(true, r102.getValue());     // Catch: Throwable -> L17
    L9:
        IOUtils.closeSilently(r103);
        IOUtils.closeSilently(r104);
        return r107;
    L18:
        r107 = new FileResult(false, -1);     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        IOUtils.closeSilently(r103);
        IOUtils.closeSilently(r104);
        throw th;
    L11:
        r104 = null;
        goto L18
    }

    private static boolean isCompleteApk(String r100, long r101) {
        boolean r102 = false;
        PolarisZipFileWrapper r103 = null;
        PolarisZipFileWrapper r104 = new PolarisZipFileWrapper(Mira.getAppContext().getApplicationInfo().sourceDir);     // Catch: Throwable -> L17
        long r105 = r104.getEntry(ZIP_ENTRY_ASSET_PATH).getCrc();     // Catch: Throwable -> L14
        if (r101 != (-1)) goto L8;
        r101 = calculationFileCrc32(new PolarisFileWrapper(r100));     // Catch: Throwable -> L14
    L8:
        if (r101 != (-1)) goto L10;
    L12:
        IOUtils.closeSilently(r104);
        return r102;
    L10:
        if (r101 != r105) goto L12;
        r102 = true;
    L14:
        r103 = r104;
    L15:
        IOUtils.closeSilently(r103);
        return false;
    }

    private static boolean initInternal(String r100, String r101, int r102) {
        FileUtils.deleteDir(r100);
        FileUtils.deleteDir(r101);
        FileResult r103 = initBaseApk(Mira.getAppContext(), r101);
        boolean r104 = r103.copiedResult;
        if (r104 == false) goto L5;
        r104 = FileUtils.safeRename(r101, r100);
    L5:
        if (r104 == false) goto L7;
        r104 = isCompleteApk(r100, r103.crc32);
    L7:
        if (r104 == true) goto L11;
        if (r102 > 0) goto L10;
        return r104;
    L10:
        return initInternal(r100, r101, r102 - 1);
    L11:
        return r104;
    }
}
