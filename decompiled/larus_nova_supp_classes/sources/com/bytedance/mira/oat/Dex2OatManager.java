package com.bytedance.mira.oat;

import android.content.Context;
import android.util.Log;
import com.bytedance.common.profilesdk.deximage.Deximage;
import com.bytedance.mira.MiraManager;
import com.bytedance.mira.MiraParam;
import com.bytedance.mira.helper.PluginDirHelper;
import com.bytedance.mira.log.MiraLogger;
import com.bytedance.mira.util.OSUtil;
import dalvik.system.PathClassLoader;
import java.io.File;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public class Dex2OatManager {
    private static Context sContext;

    public Dex2OatManager() {
    }

    private static void removeReporter() {
        if (OSUtil.isAndroidOHigher() == false) goto L6;
        Dex2OatImpl.removeReporter();
        return;
    }

    public static void init(Context r0) {
        sContext = r0;
        Dex2OatImpl.init(r0);
        removeReporter();
    }

    public static void fastDex2oat(String r5, int r6) {
        MiraParam r0 = MiraManager.getInstance().getParam();
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.fastDex2Oat() == true) goto L7;
        return;
    L7:
        if (r0.isInSkipWhenPluginInstallDex2Oat(r5) == true) goto L27;
        String r1 = PluginDirHelper.getSourceFile(r5, r6);
        String r2 = PluginDirHelper.getDalvikCacheDir(r5, r6);
        String r3 = r2 + File.separator + Dex2OatHelper.getOatFileName(r1);
        if (OSUtil.isAndroidLLower() == false) goto L13;
        new PathClassLoader(r1, r2, ClassLoader.getSystemClassLoader());
        return;
    L13:
        if (OSUtil.isAndroidLP() == false) goto L16;
        Dex2OatHelper.execFastDex2OatCmd(r1, r3);
        return;
    L16:
        if (r0.withImageOpt() == true) goto L18;
        return;
    L18:
        if (r0.isInOptPlugins(r5) == false) goto L26;
        Dex2OatImpl.dexOptQuicken(r5, r6);
        return;
    L26:
        return;
    }

    public static void fullDex2Oat(String r6, int r7) {
        MiraParam r2 = MiraManager.getInstance().getParam();
        if (r2 != null) goto L5;
        return;
    L5:
        if (r2.fastDex2Oat() == true) goto L7;
        return;
    L7:
        if (r2.withImageOpt() == true) goto L9;
        return;
    L9:
        if (r2.isInOptPlugins(r6) == false) goto L32;
        String r3 = PluginDirHelper.getSourceFile(r6, r7);
        String r4 = PluginDirHelper.getDalvikCacheDir(r6, r7);
        String r5 = r4 + File.separator + Dex2OatHelper.getOatFileName(r3);
        if (OSUtil.isAndroidLLower() == false) goto L15;
        return;
    L15:
        if (OSUtil.isAndroidLP() == true) goto L17;
        Dex2OatImpl.dexOptSpeed(r6, r7);
        return;
    L17:
        if (OSUtil.isAndroidLO() == false) goto L25;
        Dex2OatHelper.execFullDex2OatCmd(r3, r5);
        return;
    L25:
        MiraLogger.i(MiraLogger.TAG_INSTALL, "fullDex2Oat >>> result=" + Deximage.compose(sContext, r3, r4, "PCL[]", false));     // Catch: Exception -> L21
        return;
    L21:
        e = move-exception;
        MiraLogger.e(MiraLogger.TAG_INSTALL, "fullDex2Oat >>> error=" + Log.getStackTraceString(e));
        return;
    }
}
