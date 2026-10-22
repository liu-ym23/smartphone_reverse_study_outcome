package com.bytedance.common.profilesdk.deximage;

import android.content.Context;
import android.os.SystemClock;
import com.bytedance.common.profilesdk.AppContext;
import com.bytedance.common.profilesdk.DexImageLoader;
import com.bytedance.common.profilesdk.DeximageMonitor;
import com.bytedance.common.profilesdk.ProfileManager;
import com.bytedance.common.profilesdk.core.DexOptimizer;
import com.bytedance.common.profilesdk.util.FileUtils;
import com.bytedance.common.profilesdk.util.Logger;
import com.bytedance.common.profilesdk.util.PathUtils;
import com.bytedance.common.profilesdk.util.VersionUtils;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import com.ss.android.ugc.bytex.thread_rename.base.DefaultThreadFactory;
import dalvik.system.DexFile;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes15.dex */
public class Deximage {
    private static boolean sEnabled;
    public static Executor sExecutor;

    public static String composeMessage(int r100) {
        if (r100 != 0) goto L4;
        return "success: no need to compose";
    L4:
        if (r100 != 1) goto L6;
        return "success: compiled with speed-profile";
    L6:
        if (r100 != 2) goto L8;
        return "success: compiled with speed";
    L8:
        if (r100 != 3) goto L10;
        return "success: compiled with 2dy dex";
    L10:
        if (r100 == 999) goto L16;
        switch(r100) {
            case 100: goto L15;
            case 101: goto L14;
            case 102: goto L13;
            default: goto L12;
        };
    L12:
        return "unknown";
    L13:
        return "failed: failed to register 2dy dex";
    L14:
        return "failed: failed to compile 2dy dex";
    L15:
        return "failed: unsupported OS version";
    L16:
        return "disabled";
    }

    static {
        sExecutor = PThreadExecutorsUtils.newCachedThreadPool(new DefaultThreadFactory("mage/Deximage"));
        sEnabled = true;
    }

    public static boolean compileSecondaryDex() {
        return DexOptimizer.compileAllSecondaryDex();
    }

    public static boolean supportVersion() {
        return VersionUtils.supportVersion();
    }

    public static int compose(Context r100, String r101, String r102, String r103, boolean r104) throws IOException {
        long r105 = SystemClock.uptimeMillis();
        int r106 = composeInternal(r100, r101, r102, r103, r104);
        DeximageMonitor.monitorCompose(SystemClock.uptimeMillis() - r105, r106);
        return r106;
    }

    private static int composeInternal(Context r100, String r101, String r102, String r103, boolean r104) throws IOException {
        Logger.d("Deximage.compose dex=" + r101 + " optimizedDirectory=" + r102 + " classLoaderContext=" + r103);
        if (sEnabled == true) goto L6;
        Logger.d("Deximage Disable");
        return 999;
    L6:
        AppContext.init(r100);
        if (supportVersion() == true) goto L11;
        Logger.d("Current OS version not support");
        return 100;
    L11:
        if (FileUtils.fileExists(r101) == false) goto L40;
        boolean r105 = false;
        if (r104 == false) goto L15;
    L18:
        String r106 = DexImageLoader.getSecondaryProfilePath(r101);
        if (VersionUtils.isPQR() == false) goto L23;
        r105 = ProfileManager.createProfileForSourceDex(r101, r106);
        if (r105 == true) goto L23;
        Logger.d("Failed to create all-class profile, try to dex2oat with speed");
    L23:
        String r107 = PathUtils.getOatDir(r101, r102);
        if (r105 == true) goto L28;
        r106 = null;
    L28:
        if (DexOptimizer.makeImage(r101, r107, r103, r106) == false) goto L34;
        if (r105 == false) goto L31;
        return 1;
    L31:
        return 2;
    L34:
        if (compileSecondaryDex() == false) goto L37;
        return 3;
    L37:
        return 101;
    L15:
        if (DexFile.isDexOptNeeded(r101) == true) goto L18;
        Logger.d("No need to compose " + r101 + ", skip!");
        return 0;
    L40:
        throw new FileNotFoundException("File not found: " + r101);
    }
}
