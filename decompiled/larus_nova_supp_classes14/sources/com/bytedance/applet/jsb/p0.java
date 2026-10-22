package com.bytedance.applet.jsb;

import com.ivy.ivykit.api.bridge.core.IvyBridgeMethod;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class p0 implements com.larus.platform.api.l0 {
    public final /* synthetic */ q0 a;
    public final /* synthetic */ IvyBridgeMethod.a b;

    public final void onCompletion(boolean r5) {
        bx7.c.d(this.a, this.b, MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("result", Boolean.valueOf(r5))}));
    }

    public p0(q0 r1, ux7.d.d r2) {
        this.a = r1;
        this.b = r2;
    }
}
