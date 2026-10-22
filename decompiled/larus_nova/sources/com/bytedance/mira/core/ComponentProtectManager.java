package com.bytedance.mira.core;

import android.app.Activity;
import com.bytedance.mira.MiraManager;
import com.bytedance.mira.MiraParam;

/* JADX INFO: loaded from: classes21.dex */
public class ComponentProtectManager {
    private static final ClassLoader sBootClassLoader = null;
    private static final ClassLoader sHostClassLoader = null;
    private static volatile ComponentProtectManager sInstance;

    public interface IComponentProtect {
        boolean executeComponentProtectActionForActivity(String r100);
    }

    static {
        sHostClassLoader = ComponentProtectManager.class.getClassLoader();
        sBootClassLoader = Class.class.getClassLoader();
    }

    public static ComponentProtectManager getInst() {
        if (sInstance != null) goto L15;
        monitor-enter(ComponentProtectManager.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sInstance != null) goto L9;
        sInstance = new ComponentProtectManager();     // Catch: Throwable -> L11
    L9:
        monitor-exit(ComponentProtectManager.class);     // Catch: Throwable -> L11
    L15:
        return sInstance;
    }

    private ComponentProtectManager() {
    }

    public boolean tryExecuteProtect(String r100) {
        if (r100 != null) goto L5;
        return false;
    L5:
        MiraParam r101 = MiraManager.getInstance().getParam();
        if (r101 != null) goto L8;
    L17:
        return false;
    L8:
        if (r101.enableOptRecovery() == false) goto L17;
        if (r101.getComponentProtect() == null) goto L17;
        if (MultiProcessManagerExt.getInst().getPluginActivityClassName().contains(r100) == true) goto L16;
        return false;
    L16:
        return r101.getComponentProtect().executeComponentProtectActionForActivity(r100);
    }

    public void setLastRunInPluginActivityClassName(String r100, Activity r101) {
        if (r100 == null) goto L20;
        if (r101 == null) goto L26;
        MiraParam r102 = MiraManager.getInstance().getParam();
        if (r102 != null) goto L8;
        return;
    L8:
        if (r102.enableOptRecovery() == true) goto L10;
        return;
    L10:
        if (r102.getComponentProtect() == null) goto L27;
        ClassLoader r103 = r101.getClass().getClassLoader();
        if (r103 != null) goto L15;
        return;
    L15:
        if (r103 != sBootClassLoader) goto L17;
        return;
    L17:
        if (r103 == sHostClassLoader) goto L25;
        MultiProcessManagerExt.getInst().addPluginActivityClassName(r100);
        return;
    L25:
        return;
    L27:
        return;
    L26:
        return;
    }
}
