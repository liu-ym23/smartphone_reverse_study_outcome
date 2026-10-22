package com.bytedance.locallife.live.util;

import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes21.dex */
public final class a0 {
    public static Integer a(String r100, Integer r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter("", "businessTag");
        Integer r102 = StringsKt.toIntOrNull(r100, 10);
        if (r102 != null) goto L5;
        int r103 = com.bytedance.locallife.biz.mob.a.f256703c;
        com.bytedance.locallife.biz.mob.a.C3646a.c("local_live_number_convert_error", MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("scene", "safeToInt"), TuplesKt.to("tag", "")}));
    L5:
        if (r102 != null) goto L8;
        return r101;
    L8:
        return r102;
    }

    public static Long b(String r100, String r101, int r102) {
        if ((r102 & 2) == 0) goto L5;
        boolean r103 = true;
    L7:
        if ((r102 & 4) == 0) goto L9;
        r101 = "";
    L9:
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "businessTag");
        Long r104 = StringsKt.toLongOrNull(r100, 10);
        if (r104 != null) goto L13;
        if (r103 == false) goto L13;
        int r105 = com.bytedance.locallife.biz.mob.a.f256703c;
        com.bytedance.locallife.biz.mob.a.C3646a.c("local_live_number_convert_error", MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("scene", "safeToLong"), TuplesKt.to("tag", r101)}));
    L13:
        if (r104 != null) goto L16;
        return null;
    L16:
        return r104;
    L5:
        r103 = false;
        goto L7
    }
}
