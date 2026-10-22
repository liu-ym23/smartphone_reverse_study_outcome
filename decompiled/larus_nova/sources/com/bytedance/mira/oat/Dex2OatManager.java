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

/* JADX INFO: loaded from: classes.dex */
public class Dex2OatManager {
    private static Context sContext;

    public Dex2OatManager() {
    }

    private static void removeReporter() {
        if (OSUtil.isAndroidOHigher() == false) goto L6;
        Dex2OatImpl.removeReporter();
        return;
    }

    public static void init(Context r100) {
        sContext = r100;
        Dex2OatImpl.init(r100);
        removeReporter();
    }

    public static void fastDex2oat(String r100, int r101) {
        MiraParam r102 = MiraManager.getInstance().getParam();
        if (r102 != null) goto L5;
        return;
    L5:
        if (r102.fastDex2Oat() == true) goto L7;
        return;
    L7:
        if (r102.isInSkipWhenPluginInstallDex2Oat(r100) == true) goto L27;
        String r103 = PluginDirHelper.getSourceFile(r100, r101);
        String r104 = PluginDirHelper.getDalvikCacheDir(r100, r101);
        String r105 = r104 + File.separator + Dex2OatHelper.getOatFileName(r103);
        if (OSUtil.isAndroidLLower() == false) goto L13;
        new PathClassLoader(r103, r104, ClassLoader.getSystemClassLoader());
        return;
    L13:
        if (OSUtil.isAndroidLP() == false) goto L16;
        Dex2OatHelper.execFastDex2OatCmd(r103, r105);
        return;
    L16:
        if (r102.withImageOpt() == true) goto L18;
        return;
    L18:
        if (r102.isInOptPlugins(r100) == false) goto L26;
        Dex2OatImpl.dexOptQuicken(r100, r101);
        return;
    L26:
        return;
    }

    public static void fullDex2Oat(String r100, int r101) {
        MiraParam r102 = MiraManager.getInstance().getParam();
        if (r102 != null) goto L5;
        return;
    L5:
        if (r102.fastDex2Oat() == true) goto L7;
        return;
    L7:
        if (r102.withImageOpt() == true) goto L9;
        return;
    L9:
        if (r102.isInOptPlugins(r100) == false) goto L32;
        String r103 = PluginDirHelper.getSourceFile(r100, r101);
        String r104 = PluginDirHelper.getDalvikCacheDir(r100, r101);
        String r105 = r104 + File.separator + Dex2OatHelper.getOatFileName(r103);
        if (OSUtil.isAndroidLLower() == false) goto L15;
        return;
    L15:
        if (OSUtil.isAndroidLP() == true) goto L17;
        Dex2OatImpl.dexOptSpeed(r100, r101);
        return;
    L17:
        if (OSUtil.isAndroidLO() == false) goto L25;
        Dex2OatHelper.execFullDex2OatCmd(r103, r105);
        return;
    L25:
        MiraLogger.i(MiraLogger.TAG_INSTALL, "fullDex2Oat >>> result=" + Deximage.compose(sContext, r103, r104, "PCL[]", false));     // Catch: Exception -> L21
        return;
    L21:
        e = move-exception;
        MiraLogger.e(MiraLogger.TAG_INSTALL, "fullDex2Oat >>> error=" + Log.getStackTraceString(e));
        return;
    }
}
