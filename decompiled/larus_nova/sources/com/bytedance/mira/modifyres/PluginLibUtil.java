package com.bytedance.mira.modifyres;

import com.bytedance.mira.Mira;
import com.bytedance.mira.log.MiraLogger;

/* JADX INFO: loaded from: classes21.dex */
public class PluginLibUtil {
    public PluginLibUtil() {
    }

    public static int mapRes(int r100, String r101, String r102) {
        if (r100 >= 2130706432) goto L5;
        return r100;
    L5:
        int r103 = Mira.getAppContext().getResources().getIdentifier(r102, r101, Mira.getAppContext().getPackageName());
        if (r103 != 0) goto L8;
        r103 = Mira.getAppContext().getResources().getIdentifier(r102.replace("_", "."), r101, Mira.getAppContext().getPackageName());
    L8:
        StringBuilder r104 = new StringBuilder("mapRes:");
        r104.append(r100);
        r104.append(" newId:");
        r104.append(r103);
        r104.append(" ");
        r104.append(r101);
        r104.append(" ");
        r104.append(r102);
        r104.append(" same:");
        if (r103 != r100) goto L11;
        boolean r105 = true;
    L12:
        r104.append(r105);
        MiraLogger.d(MiraLogger.TAG, r104.toString());
        if (r103 != 0) goto L15;
        MiraLogger.d(MiraLogger.TAG, "Cant find res, resName = " + r102 + ", pluginResId = " + r100);
    L15:
        return r103;
    L11:
        r105 = false;
        goto L12
    }
}
