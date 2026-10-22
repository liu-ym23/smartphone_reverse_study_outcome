package com.bytedance.locallife.poi.dito.util;

import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f262558a = 0;

    static {
    }

    public static void a(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "optAction");
        int r102 = com.bytedance.locallife.biz.mob.a.f256703c;
        int r103 = 3;
        Pair[] r104 = new Pair[3];
        if (r100 != null) goto L5;
        r100 = "";
    L5:
        r104[0] = TuplesKt.to("type", r100);
        r104[1] = TuplesKt.to("opt_type", String.valueOf(0));
        int r105 = r101.hashCode();
        if (r105 == 669881) goto L21;
        if (r105 == 900599) goto L17;
        if (r105 == 98586933) goto L13;
    L24:
        r104[2] = TuplesKt.to("opt_action", String.valueOf(r103));
        com.bytedance.locallife.biz.mob.a.C3646a.c("POI_VIEW_LAZY_LOAD", MapsKt.mutableMapOf(r104));
        return;
    L13:
        if (r101.equals("fmp结束") == false) goto L24;
        r103 = 0;
        goto L24
    L17:
        if (r101.equals("滑动") == false) goto L24;
        r103 = 2;
        goto L24
    L21:
        if (r101.equals("兜底") == false) goto L24;
        r103 = 1;
        goto L24
    }
}
