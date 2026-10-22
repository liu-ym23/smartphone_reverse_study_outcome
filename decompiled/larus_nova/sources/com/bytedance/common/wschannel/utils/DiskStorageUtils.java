package com.bytedance.common.wschannel.utils;

import android.content.Context;
import com.bytedance.common.utility.Logger;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.File;

/* JADX INFO: loaded from: classes15.dex */
public class DiskStorageUtils {
    private static final String TAG = null;
    private static File sPersistentFile;
    private static File sWorkingDirectory;

    public DiskStorageUtils() {
    }

    static {
        TAG = "DiskStorageUtils";
    }

    public static synchronized File getPersistentFile(Context r100) {
        monitor-enter(DiskStorageUtils.class);
        File r101 = sPersistentFile;     // Catch: Throwable -> L20
        if (r101 == null) goto L23;
        monitor-exit(DiskStorageUtils.class);
        return r101;
    L23:
        PolarisFileWrapper r102 = new PolarisFileWrapper(getWorkingDirectory(r100), Utils.getCurProcessName(r100).replace(".", "_").replace(":", "-") + "_frontier.bin");     // Catch: Exception -> L15 Throwable -> L20
        if (r102.exists() == true) goto L11;
        r102.createNewFile();     // Catch: Exception -> L15 Throwable -> L20
    L11:
        sPersistentFile = r102;     // Catch: Exception -> L15 Throwable -> L20
        if (Logger.debug() == false) goto L17;
        Logger.d(TAG, "prepare PersistentFile success. fileName=" + sPersistentFile);     // Catch: Exception -> L15 Throwable -> L20
    L17:
        File r103 = sPersistentFile;     // Catch: Throwable -> L20
        monitor-exit(DiskStorageUtils.class);
        return r103;
    L15:
        e = move-exception;
        Logger.e(TAG, "prepare PersistentFile fail.", e);     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        throw th;
    }

    private static File getWorkingDirectory(Context r100) {
        File r101 = sWorkingDirectory;
        if (r101 == null) goto L5;
        return r101;
    L5:
        PolarisFileWrapper r102 = new PolarisFileWrapper(r100.getFilesDir(), "wschannel");
        sWorkingDirectory = r102;
        if (r102.exists() == true) goto L9;
        sWorkingDirectory.mkdirs();
    L9:
        return sWorkingDirectory;
    }
}
