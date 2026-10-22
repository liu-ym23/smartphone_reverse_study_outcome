package com.volcengine.zeus.plugin;

import com.bytedance.mira.conig.Constants;
import com.volcengine.zeus.log.ZeusLogger;
import java.io.File;
import java.io.FileFilter;

/* JADX INFO: loaded from: classes5.dex */
public final class j implements FileFilter {
    public j() {
    }

    @Override // java.io.FileFilter
    public final boolean accept(File r100) {
        if (r100 != null) goto L6;
        return false;
    L6:
        if (r100.getName().endsWith(".apk") == false) goto L8;
    L19:
        PluginManager.getInstance().asyncInstall(null, r100, "hot_update_after_reboot");
        return true;
    L8:
        if (r100.getName().endsWith(".jar") == true) goto L19;
        if (r100.getAbsolutePath().endsWith(".temp") == true) goto L15;
        if (r100.getAbsolutePath().endsWith(".tp") == true) goto L15;
    L17:
        mqc.i.e(r100);
        ZeusLogger.w(ZeusLogger.TAG_INIT, "ZeusScanRunnable installPluginDir deleted : " + r100);
    L18:
        return false;
    L15:
        if ((System.currentTimeMillis() - r100.lastModified()) >= Constants.DOWNLOAD_TEMP_FILE_PAST_TIME) goto L17;
        ZeusLogger.w(ZeusLogger.TAG_INIT, "ZeusScanRunnable installPluginDir find : " + r100);
        goto L18
    }
}
