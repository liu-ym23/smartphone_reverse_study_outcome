package com.bytedance.locallife.live.experiment;

import com.bytedance.locallife.live.util.LiveLifeSaaSUtil;

/* JADX INFO: loaded from: classes21.dex */
public final class w {
    static {
    }

    public static boolean a() {
        Class r100 = Integer.TYPE;     // Catch: Throwable -> L17
        if (LiveLifeSaaSUtil.y().containsKey("local_life_expound_card_type") == false) goto L12;
        Object r101 = LiveLifeSaaSUtil.y().get("local_life_expound_card_type");     // Catch: Throwable -> L17
        if (r101 != null) goto L9;
        Object r102 = null;
    L13:
        Integer r103 = (Integer) r102;     // Catch: Throwable -> L17
        if (r103 == null) goto L18;
        int r104 = r103.intValue();     // Catch: Throwable -> L17
    L19:
        if (1 == r104) goto L25;
        return false;
    L25:
        return true;
    L9:
        if ((r101 instanceof Integer) == true) goto L11;
        r102 = LiveLifeSaaSUtil.a("local_life_expound_card_type", r100, 1);     // Catch: Throwable -> L17
        goto L13
    L11:
        r102 = (Integer) r101;     // Catch: Throwable -> L17
        goto L13
    L12:
        r102 = LiveLifeSaaSUtil.a("local_life_expound_card_type", r100, 1);     // Catch: Throwable -> L17
    L18:
        r104 = 1;
        goto L19
    }
}
