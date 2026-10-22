package com.ttnet.org.chromium.base;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.os.Environment;
import android.os.storage.StorageManager;
import android.provider.MediaStore;
import android.system.Os;
import android.text.TextUtils;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.ss.bduploader.BDVideoUploaderBase;
import com.ttnet.org.chromium.base.annotations.MainDex;
import com.ttnet.org.chromium.base.compat.ApiHelperForM;
import com.ttnet.org.chromium.base.compat.ApiHelperForQ;
import com.ttnet.org.chromium.base.compat.ApiHelperForR;
import com.ttnet.org.chromium.base.task.AsyncTask;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes41.dex */
@MainDex
public abstract class PathUtils {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final int CACHE_DIRECTORY = 2;
    private static final int DATA_DIRECTORY = 0;
    private static final int NUM_DIRECTORIES = 3;
    private static final String TAG = "PathUtils";
    private static final int THUMBNAIL_DIRECTORY = 1;
    private static final String THUMBNAIL_DIRECTORY_NAME = "textures";
    private static String sCacheSubDirectory;
    private static String sDataDirectorySuffix;
    private static FutureTask<String[]> sDirPathFetchTask;
    private static final AtomicBoolean sInitializationStarted = null;

    private PathUtils() {
    }

    public static /* synthetic */ String[] a() {
        return setPrivateDataDirectorySuffixInternal();
    }

    public static String getCacheDirectory() {
        return getDirectoryPath(2);
    }

    public static String getDataDirectory() {
        return getDirectoryPath(0);
    }

    public static String getThumbnailCacheDirectory() {
        return getDirectoryPath(1);
    }

    private static String[] setPrivateDataDirectorySuffixInternal() {
        String[] r100 = new String[3];
        Context r101 = ContextUtils.getApplicationContext();
        String r102 = r101.getDir(sDataDirectorySuffix, 0).getPath();
        r100[0] = r102;
        chmod(r102, BDVideoUploaderBase.KeyIsDynamicSliceLowSize);
        r100[1] = r101.getDir(THUMBNAIL_DIRECTORY_NAME, 0).getPath();
        if (r101.getCacheDir() != null) goto L5;
    L8:
        return r100;
    L5:
        if (sCacheSubDirectory != null) goto L7;
        r100[2] = r101.getCacheDir().getPath();
        goto L8
    L7:
        PolarisFileWrapper r103 = new PolarisFileWrapper(r101.getCacheDir(), sCacheSubDirectory);
        r103.mkdir();
        String r104 = r103.getPath();
        r100[2] = r104;
        chmod(r104, 1472);
        goto L8
    }

    static {
        sInitializationStarted = new AtomicBoolean();
    }

    public static String[] getAllPrivateDownloadsDirectories() {
        List r100 = new ArrayList();
        StrictModeContext r101 = StrictModeContext.allowDiskWrites();
        File[] r102 = ContextUtils.getApplicationContext().getExternalFilesDirs(Environment.DIRECTORY_DOWNLOADS);     // Catch: Throwable -> L11
        if (r102 == null) goto L7;
        r100 = Arrays.asList(r102);     // Catch: Throwable -> L11
    L7:
        if (r101 == null) goto L10;
        r101.close();
    L10:
        return toAbsolutePathStrings(r100);
    L11:
        th = move-exception;
        if (r101 != null) goto L20;
    L17:
        throw th;
    L20:
        r101.close();     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        th.addSuppressed(th);
        goto L17
    }

    public static String[] getExternalDownloadVolumesNames() {
        ArrayList r100 = new ArrayList();
        Iterator<String> r101 = ApiHelperForQ.getExternalVolumeNames(ContextUtils.getApplicationContext()).iterator();
    L4:
        if (r101.hasNext() == false) goto L14;
        String r102 = r101.next();
        if (TextUtils.isEmpty(r102) == true) goto L4;
        if (r102.contains("external_primary") == true) goto L4;
        File r103 = ApiHelperForR.getVolumeDir((StorageManager) ApiHelperForM.getSystemService(ContextUtils.getApplicationContext(), StorageManager.class), MediaStore.Files.getContentUri(r102));
        PolarisFileWrapper r104 = new PolarisFileWrapper(r103, Environment.DIRECTORY_DOWNLOADS);
        if (r104.isDirectory() == true) goto L12;
        Log.w(TAG, "Download dir missing: %s, parent dir:%s, isDirectory:%s", new Object[]{r104.getAbsolutePath(), r103.getAbsolutePath(), Boolean.valueOf(r103.isDirectory())});
    L12:
        r100.add(r104);
        goto L4
    L14:
        return toAbsolutePathStrings(r100);
    }

    private static String[] getOrComputeDirectoryPaths() {
        if (sDirPathFetchTask.isDone() == true) goto L20;
        StrictModeContext r100 = StrictModeContext.allowDiskWrites();
        sDirPathFetchTask.run();     // Catch: Throwable -> L8
        if (r100 == null) goto L20;
        r100.close();
    L8:
        th = move-exception;
        if (r100 != null) goto L24;
    L14:
        throw th;
    L24:
        r100.close();     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        th.addSuppressed(th);
    L20:
        return sDirPathFetchTask.get();
    L17:
        e = move-exception;
        throw new RuntimeException(e);
    }

    public static void resetForTesting() {
        sInitializationStarted.set(false);
        sDirPathFetchTask = null;
        sDataDirectorySuffix = null;
        sCacheSubDirectory = null;
    }

    public static String getAppExternalCacheDirectory() {
        File r100 = ContextUtils.getApplicationContext().getExternalCacheDir();
        if (r100 != null) goto L6;
        return "";
    L6:
        return r100.getAbsolutePath();
    }

    public static String getDownloadsDirectory() {
        StrictModeContext r100 = StrictModeContext.allowDiskReads();
    L16:
        th = move-exception;
        if (r100 != null) goto L23;
    L22:
        throw th;
    L23:
        r100.close();     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        th.addSuppressed(th);
        goto L22
    L4:
        if (Build.VERSION.SDK_INT < 29) goto L12;
        String[] r101 = getAllPrivateDownloadsDirectories();     // Catch: Throwable -> L16
        if (r101.length != 0) goto L8;
        String r102 = "";
    L9:
        if (r100 == null) goto L11;
        r100.close();
    L11:
        return r102;
    L8:
        r102 = r101[0];     // Catch: Throwable -> L16
        goto L9
    L12:
        String r103 = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).getPath();     // Catch: Throwable -> L16
        if (r100 == null) goto L15;
        r100.close();
    L15:
        return r103;
    }

    public static String getExternalStorageDirectory() {
        return Environment.getExternalStorageDirectory().getAbsolutePath();
    }

    private static String getNativeLibraryDirectory() {
        ApplicationInfo r100 = ContextUtils.getApplicationContext().getApplicationInfo();
        int r101 = r100.flags;
        if ((r101 & 128) != 0) goto L10;
        if ((r101 & 1) == 0) goto L10;
        return "/system/lib/";
    L10:
        return r100.nativeLibraryDir;
    }

    private static String getDirectoryPath(int r100) {
        return getOrComputeDirectoryPaths()[r100];
    }

    public static void setPrivateDataDirectorySuffix(String r100) {
        setPrivateDataDirectorySuffix(r100, null);
    }

    private static String[] toAbsolutePathStrings(List<File> r100) {
        ArrayList r101 = new ArrayList();
        Iterator<File> r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L12;
        File r103 = r102.next();
        if (r103 == null) goto L4;
        if (TextUtils.isEmpty(r103.getAbsolutePath()) == true) goto L4;
        r101.add(r103.getAbsolutePath());
        goto L4
    L12:
        return (String[]) r101.toArray(new String[r101.size()]);
    }

    private static void chmod(String r100, int r101) {
        Os.chmod(r100, r101);     // Catch: Exception -> L4
        return;
    L4:
        Log.e(TAG, "Failed to set permissions for path \"" + r100 + "\"", new Object[0]);
    }

    public static void setPrivateDataDirectorySuffix(String r100, String r101) {
        if (sInitializationStarted.getAndSet(true) == true) goto L6;
        sDataDirectorySuffix = r100;
        sCacheSubDirectory = r101;
        sDirPathFetchTask = new FutureTask(new d());
        AsyncTask.THREAD_POOL_EXECUTOR.execute(sDirPathFetchTask);
        return;
    }
}
