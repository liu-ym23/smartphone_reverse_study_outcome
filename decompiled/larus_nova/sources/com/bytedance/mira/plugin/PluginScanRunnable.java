package com.bytedance.mira.plugin;

import android.text.TextUtils;
import com.bytedance.mira.MiraManager;
import com.bytedance.mira.MiraParam;
import com.bytedance.mira.helper.PluginDirHelper;
import com.bytedance.mira.log.MiraLogger;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.apm.impl.protector.RunnableProtector;
import java.io.File;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes3.dex */
class PluginScanRunnable implements Runnable {
    private static final long DOWNLOAD_TEMP_FILE_PAST_TIME = 259200000;
    private static final String TAG = "PluginScanRunnable";

    public PluginScanRunnable() {
    }

    @Override // java.lang.Runnable
    public void run() {
        com_bytedance_mira_plugin_PluginScanRunnable_com_larus_apm_impl_protector_RunnableLancet_run(this);
    }

    public void com_bytedance_mira_plugin_PluginScanRunnable__run$___twin___() {
        listAvailable(new PolarisFileWrapper(PluginDirHelper.getDownloadDir()));
        String r100 = PluginDirHelper.getPushDir();
        if (TextUtils.isEmpty(r100) == true) goto L6;
        listAvailable(new PolarisFileWrapper(r100));
        return;
    }

    @Skip({"com.ss.android.ugc.bytex.pthread+"})
    public static void com_bytedance_mira_plugin_PluginScanRunnable_com_larus_apm_impl_protector_RunnableLancet_run(PluginScanRunnable r100) {
        r100.com_bytedance_mira_plugin_PluginScanRunnable__run$___twin___();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    private void listAvailable(File r100) {
        MiraParam r101 = MiraManager.getInstance().getParam();
        if (r101 != null) goto L5;
    L7:
        listAvailableOld(r100);
        return;
    L5:
        if (r101.isEnableDiffStorageOpt() == false) goto L7;
        listAvailableNew(r100);
    }

    private void listAvailableNew(File r100) {
        MiraLogger.i(MiraLogger.TAG_INIT, "PluginScanRunnable listPluginDownloadDir, dir = " + r100);
        r100.listFiles(new AnonymousClass1(this));
    }

    private void listAvailableOld(File r100) {
        MiraLogger.i(MiraLogger.TAG_INIT, "PluginScanRunnable listPluginDownloadDir, dir = " + r100);
        r100.listFiles(new AnonymousClass2(this));
    }
}
