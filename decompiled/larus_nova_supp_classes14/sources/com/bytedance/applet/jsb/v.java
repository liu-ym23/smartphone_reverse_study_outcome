package com.bytedance.applet.jsb;

import com.ivy.ivykit.api.bridge.core.model.IvyBridgePlatformType;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class v extends bx7.c {
    public final String getName() {
        return "applet.getNavigationData";
    }

    public v() {
    }

    public final void a(dx7.b r3, ux7.d.d r4, IvyBridgePlatformType r5) {
        Intrinsics.checkNotNullParameter(r3, "params");
        Intrinsics.checkNotNullParameter(r4, "callback");
        Intrinsics.checkNotNullParameter(r5, "type");
        r4.invoke(MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("code", 1), TuplesKt.to("data", h.a.toString())}));
    }
}
