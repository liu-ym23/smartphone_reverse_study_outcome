package com.bytedance.mira.plugin;

import com.bytedance.mira.Mira;
import com.bytedance.mira.helper.PluginDirHelper;
import com.bytedance.mira.log.MiraLogger;
import com.bytedance.mira.util.FileUtils;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.apm.impl.protector.RunnableProtector;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes21.dex */
class PluginDeleteRunnable implements Runnable {
    private static final String TAG = "PluginDeleteRunnable";
    private final List<String> mWhiteList;

    @Override // java.lang.Runnable
    public void run() {
        com_bytedance_mira_plugin_PluginDeleteRunnable_com_larus_apm_impl_protector_RunnableLancet_run(this);
    }

    public PluginDeleteRunnable() {
        ArrayList r100 = new ArrayList();
        this.mWhiteList = r100;
        r100.add("host");
        r100.add("fake");
        if (Mira.getAppContext() == null) goto L6;
        r100.add(Mira.getAppContext().getPackageName());
        return;
    }

    public void com_bytedance_mira_plugin_PluginDeleteRunnable__run$___twin___() {
        final List<Plugin> r100 = PluginManager.getInstance().listPluginConfigs();
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.size() <= 0) goto L15;
        File[] r101 = new PolarisFileWrapper(PluginDirHelper.getBaseDir()).listFiles(new AnonymousClass1(this, r100));
        if (r101 != null) goto L9;
        return;
    L9:
        if (r101.length <= 0) goto L17;
        int r102 = r101.length;
        int r103 = 0;
    L11:
        if (r103 >= r102) goto L18;
        File r104 = r101[r103];
        FileUtils.deleteFile(r104);
        MiraLogger.e(MiraLogger.TAG_INIT, "PluginDeleteRunnable delete undeclared plugin : " + r104.getAbsolutePath());
        r103 = r103 + 1;
        goto L11
    L18:
        return;
    L17:
        return;
    }

    @Skip({"com.ss.android.ugc.bytex.pthread+"})
    public static void com_bytedance_mira_plugin_PluginDeleteRunnable_com_larus_apm_impl_protector_RunnableLancet_run(PluginDeleteRunnable r100) {
        r100.com_bytedance_mira_plugin_PluginDeleteRunnable__run$___twin___();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    private boolean isEndsWithWhiteList(String r100) {
        Iterator<String> r101 = this.mWhiteList.iterator();
    L4:
        if (r101.hasNext() == false) goto L9;
        if (r100.endsWith(r101.next()) == false) goto L4;
        return true;
    L9:
        return false;
    }

    public static /* synthetic */ boolean access$100(PluginDeleteRunnable r100, String r101) {
        return r100.isEndsWithWhiteList(r101);
    }

    private boolean isEndsWithPluginPackageName(List<Plugin> r100, String r101) {
        Iterator<Plugin> r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L9;
        if (r101.endsWith(r102.next().mPackageName) == false) goto L4;
        return true;
    L9:
        return false;
    }

    public static /* synthetic */ boolean access$000(PluginDeleteRunnable r100, List r101, String r102) {
        return r100.isEndsWithPluginPackageName(r101, r102);
    }
}
