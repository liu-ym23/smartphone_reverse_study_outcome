package com.bytedance.locallife.live.experiment;

import com.bytedance.locallife.live.util.LiveLifeSaaSUtil;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes21.dex */
public final class r {
    static {
    }

    @JvmStatic
    public static final int a() {
        Class r100 = Integer.TYPE;     // Catch: Throwable -> L17
        if (LiveLifeSaaSUtil.y().containsKey("live_life_anim_opt") == false) goto L12;
        Object r101 = LiveLifeSaaSUtil.y().get("live_life_anim_opt");     // Catch: Throwable -> L17
        if (r101 != null) goto L9;
        Object r102 = null;
    L13:
        Integer r103 = (Integer) r102;     // Catch: Throwable -> L17
        if (r103 == null) goto L20;
        return r103.intValue();
    L20:
        return 0;
    L9:
        if ((r101 instanceof Integer) == true) goto L11;
        r102 = LiveLifeSaaSUtil.a("live_life_anim_opt", r100, 0);     // Catch: Throwable -> L17
        goto L13
    L11:
        r102 = (Integer) r101;     // Catch: Throwable -> L17
        goto L13
    L12:
        r102 = LiveLifeSaaSUtil.a("live_life_anim_opt", r100, 0);     // Catch: Throwable -> L17
    L21:
        return 0;
    }
}
