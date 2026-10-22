package com.bytedance.mira.helper;

import com.bytedance.mira.Mira;
import com.bytedance.mira.plugin.trip.natvierutime.utils.UtilsExt;
import java.io.File;

/* JADX INFO: loaded from: classes3.dex */
public class FastPluginDirHelperV3 {
    private static String sBaseDir;

    public FastPluginDirHelperV3() {
    }

    public static void init() {
        if (sBaseDir != null) goto L6;
        String r100 = buildPath(Mira.getAppContext().getFilesDir().getPath(), "plugins-fake");
        sBaseDir = r100;
        mkdir(r100);
        return;
    }

    private static String buildBakName(String r100) {
        StringBuilder r101 = new StringBuilder(64);
        r101.append(r100);
        r101.append(".apk.bak");
        return r101.toString();
    }

    private static String buildName(String r100) {
        StringBuilder r101 = new StringBuilder(64);
        r101.append(r100);
        r101.append(".apk");
        return r101.toString();
    }

    public static String getFakeSourceBakFile(String r100) {
        return buildPath(sBaseDir, buildBakName(r100));
    }

    public static String getFakeSourceFile(String r100) {
        return buildPath(sBaseDir, buildName(r100));
    }

    private static boolean mkdir(String r100) {
        return UtilsExt.mkdir(r100, 511);
    }

    private static String buildPath(String r100, String r101) {
        StringBuilder r102 = new StringBuilder(128);
        r102.append(r100);
        r102.append(File.separator);
        r102.append(r101);
        return r102.toString();
    }
}
