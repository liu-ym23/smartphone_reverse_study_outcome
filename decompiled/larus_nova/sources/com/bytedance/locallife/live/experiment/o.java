package com.bytedance.locallife.live.experiment;

import com.bytedance.locallife.live.util.LiveLifeSaaSUtil;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes21.dex */
public final class o {
    static {
    }

    @JvmStatic
    public static final boolean a() {
        Class r100 = Integer.TYPE;     // Catch: Throwable -> L17
        if (LiveLifeSaaSUtil.y().containsKey("live_life_shelf_reuse") == false) goto L12;
        Object r101 = LiveLifeSaaSUtil.y().get("live_life_shelf_reuse");     // Catch: Throwable -> L17
        if (r101 != null) goto L9;
        Object r102 = null;
    L13:
        Integer r103 = (Integer) r102;     // Catch: Throwable -> L17
        if (r103 == null) goto L18;
        int r104 = r103.intValue();     // Catch: Throwable -> L17
    L19:
        if (r104 == 1) goto L25;
        return false;
    L25:
        return true;
    L9:
        if ((r101 instanceof Integer) == true) goto L11;
        r102 = LiveLifeSaaSUtil.a("live_life_shelf_reuse", r100, 1);     // Catch: Throwable -> L17
        goto L13
    L11:
        r102 = (Integer) r101;     // Catch: Throwable -> L17
        goto L13
    L12:
        r102 = LiveLifeSaaSUtil.a("live_life_shelf_reuse", r100, 1);     // Catch: Throwable -> L17
    L18:
        r104 = 1;
        goto L19
    }
}
