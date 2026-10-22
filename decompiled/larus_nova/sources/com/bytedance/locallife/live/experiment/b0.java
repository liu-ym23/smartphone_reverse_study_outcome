package com.bytedance.locallife.live.experiment;

import com.bytedance.locallife.live.util.LiveLifeSaaSUtil;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes21.dex */
public final class b0 {
    static {
    }

    @JvmStatic
    public static final int a() {
        Class r100 = Integer.TYPE;     // Catch: Throwable -> L17
        if (LiveLifeSaaSUtil.y().containsKey("agg_card_dynamic_type_control") == false) goto L12;
        Object r101 = LiveLifeSaaSUtil.y().get("agg_card_dynamic_type_control");     // Catch: Throwable -> L17
        if (r101 != null) goto L9;
        Object r102 = null;
    L13:
        Integer r103 = (Integer) r102;     // Catch: Throwable -> L17
        if (r103 == null) goto L20;
        return r103.intValue();
    L20:
        return 1;
    L9:
        if ((r101 instanceof Integer) == true) goto L11;
        r102 = LiveLifeSaaSUtil.a("agg_card_dynamic_type_control", r100, 1);     // Catch: Throwable -> L17
        goto L13
    L11:
        r102 = (Integer) r101;     // Catch: Throwable -> L17
        goto L13
    L12:
        r102 = LiveLifeSaaSUtil.a("agg_card_dynamic_type_control", r100, 1);     // Catch: Throwable -> L17
    L21:
        return 1;
    }
}
