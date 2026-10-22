package com.bytedance.mira.plugin;

import android.content.pm.PackageInfo;
import com.bytedance.mira.log.MiraLogger;
import com.bytedance.mira.pm.packageinfo.PackageInfoUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import java.io.File;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes21.dex */
class PluginInstallCompatRunnable implements Runnable {
    private static final String TAG = "PluginInstallCompatRunnable";
    private File mApkFile;
    private String mMd5;
    private File mSoDirFile;

    @Override // java.lang.Runnable
    public void run() {
        com_bytedance_mira_plugin_PluginInstallCompatRunnable_com_larus_apm_impl_protector_RunnableLancet_run(this);
    }

    public void com_bytedance_mira_plugin_PluginInstallCompatRunnable__run$___twin___() {
        install(this.mApkFile, this.mSoDirFile, this.mMd5, true);
    }

    @Skip({"com.ss.android.ugc.bytex.pthread+"})
    public static void com_bytedance_mira_plugin_PluginInstallCompatRunnable_com_larus_apm_impl_protector_RunnableLancet_run(PluginInstallCompatRunnable r100) {
        r100.com_bytedance_mira_plugin_PluginInstallCompatRunnable__run$___twin___();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public PluginInstallCompatRunnable(File r100, File r101, String r102) {
        this.mApkFile = r100;
        this.mSoDirFile = r101;
        this.mMd5 = r102;
    }

    public static boolean install(File r100, File r101, String r102, boolean r103) {
        PackageInfo r104 = PackageInfoUtils.getPackageInfo(r100);
        if (r104 == null) goto L9;
        Plugin r105 = PluginManager.getInstance().getPlugin(r104.packageName);
        if (r105 != null) goto L7;
        MiraLogger.w(MiraLogger.TAG_INSTALL, "PluginInstallCompatRunnable cannot query valid plugin !!!");
        return false;
    L7:
        return r105.installCompat(r100, r101, r102, r104, r103);
    L9:
        MiraLogger.w(MiraLogger.TAG_INSTALL, "PluginInstallCompatRunnable read local file package info failed !!!");
        return false;
    }
}
