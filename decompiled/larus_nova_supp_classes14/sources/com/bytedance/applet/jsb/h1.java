package com.bytedance.applet.jsb;

import com.ivy.ivykit.api.bridge.core.model.IvyBridgePlatformType;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class h1 extends bx7.c {
    public final String getName() {
        return "x.removeStorageItem";
    }

    public h1() {
    }

    public final void a(dx7.b r3, ux7.d.d r4, IvyBridgePlatformType r5) {
        Intrinsics.checkNotNullParameter(r3, "params");
        Intrinsics.checkNotNullParameter(r4, "callback");
        Intrinsics.checkNotNullParameter(r5, "type");
        String r6 = r3.getString("key");
        String r0 = "";
        if (r6 != null) goto L5;
        r6 = "";
    L5:
        String r7 = r3.getString("biz");
        if (r7 == null) goto L9;
        r0 = r7;
    L9:
        ((d1) d1.a.getValue()).getClass();
        Intrinsics.checkNotNullParameter(r0, "biz");
        d1.a(r0).erase(r6);
        r4.invoke(MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("code", 1)}));
    }
}
