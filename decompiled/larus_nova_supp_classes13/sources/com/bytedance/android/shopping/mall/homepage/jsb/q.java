package com.bytedance.android.shopping.mall.homepage.jsb;

import com.bytedance.android.ec.hybrid.card.event.ECEventCenter;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class q {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void a(String r11, String r12, String r13) {
        Intrinsics.checkNotNullParameter(r11, "sceneID");
        long r3 = System.currentTimeMillis();
        String r10 = "";
        if (r12 != null) goto L5;
        String r1 = "";
    L6:
        ECEventCenter.c(new com.bytedance.android.ec.hybrid.card.event.b("ec.feedItemClicked", r3, r11, false, MapsKt.mapOf(TuplesKt.to("uuid", r1)), false, 32));
        long r4 = System.currentTimeMillis();
        if (r13 == null) goto L10;
        r10 = r13;
    L10:
        ECEventCenter.c(new com.bytedance.android.ec.hybrid.card.event.b("ec.gylCardClicked", r4, r11, false, MapsKt.mapOf(TuplesKt.to("itemId", r10)), false, 32));
        return;
    L5:
        r1 = r12;
        goto L6
    }
}
