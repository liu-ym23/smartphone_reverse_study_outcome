package com.bytedance.applet.jsb;

import com.ivy.ivykit.api.bridge.core.model.IvyBridgePlatformType;
import com.larus.platform.api.l1;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class i extends bx7.c {
    public final String getName() {
        return "applet.finishNavigation";
    }

    public i() {
    }

    public final void a(dx7.b r2, ux7.d.d r3, IvyBridgePlatformType r4) {
        Intrinsics.checkNotNullParameter(r2, "params");
        Intrinsics.checkNotNullParameter(r3, "callback");
        Intrinsics.checkNotNullParameter(r4, "type");
        l1 r5 = com.larus.platform.service.b.a();
        if (r5 == null) goto L5;
        r5.c();
    L5:
        r3.invoke(MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("code", 1)}));
    }
}
