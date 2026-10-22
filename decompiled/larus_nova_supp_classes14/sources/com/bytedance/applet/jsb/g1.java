package com.bytedance.applet.jsb;

import com.bytedance.keva.Keva;
import com.ivy.ivykit.api.bridge.core.model.IvyBridgePlatformType;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class g1 extends bx7.c {
    public final String getName() {
        return "x.getStorageItem";
    }

    public g1() {
    }

    public final void a(dx7.b r5, ux7.d.d r6, IvyBridgePlatformType r7) {
        Intrinsics.checkNotNullParameter(r5, "params");
        Intrinsics.checkNotNullParameter(r6, "callback");
        Intrinsics.checkNotNullParameter(r7, "type");
        p56.b r8 = (p56.b) e(p56.b.class);
        if (r8 == null) goto L5;
        r8.provideContainerID();
    L5:
        String r9 = r5.getString("key");
        String r0 = "";
        if (r9 != null) goto L8;
        r9 = "";
    L8:
        String r10 = r5.getString("biz");
        if (r10 == null) goto L12;
        r0 = r10;
    L12:
        ((d1) d1.a.getValue()).getClass();
        Intrinsics.checkNotNullParameter(r0, "biz");
        Keva r11 = d1.a(r0);
        Object r1 = null;
        String r12 = r11.getString(r9, null);
        if (r12 == null) goto L16;
        r1 = d1.b(r12);
    L16:
        if (r1 == null) goto L18;
        r6.invoke(MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("code", 1), TuplesKt.to("data", MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("data", r1)}))}));
        return;
    L18:
        r6.invoke(MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("code", 0)}));
    }
}
