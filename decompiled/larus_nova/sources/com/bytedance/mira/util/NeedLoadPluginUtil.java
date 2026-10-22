package com.bytedance.mira.util;

import com.bytedance.mira.plugin.Plugin;
import java.util.Iterator;

/* JADX INFO: loaded from: classes3.dex */
public class NeedLoadPluginUtil {
    private static boolean sUsedOpt;

    public NeedLoadPluginUtil() {
    }

    public static void initConfig(boolean r100) {
        sUsedOpt = r100;
    }

    private static boolean isPrefixWithDot(String r100, String r101) {
        if (sUsedOpt == false) goto L7;
        return isPrefixWithDotNew(r100, r101);
    L7:
        return isPrefixWithDotOld(r100, r101);
    }

    private static boolean isPrefixWithDotNew(String r100, String r101) {
        int r102 = r101.length();
        if (r100.length() >= (r102 + 1)) goto L5;
    L9:
        return false;
    L5:
        if (r100.charAt(r102) != '.') goto L9;
        if (r100.startsWith(r101) == false) goto L9;
        return true;
    }

    private static boolean isPrefixWithDotOld(String r100, String r101) {
        return r100.startsWith(r101 + ".");
    }

    public static boolean needLoadPlugin(Plugin r100, String r101) {
        if (r100 != null) goto L6;
        return false;
    L6:
        if (isPrefixWithDot(r101, r100.mPackageName) == false) goto L8;
        return true;
    L8:
        Iterator<String> r102 = r100.mExtraPackages.iterator();
    L10:
        if (r102.hasNext() == false) goto L14;
        if (isPrefixWithDot(r101, r102.next()) == false) goto L10;
        return true;
    L14:
        return false;
    }
}
