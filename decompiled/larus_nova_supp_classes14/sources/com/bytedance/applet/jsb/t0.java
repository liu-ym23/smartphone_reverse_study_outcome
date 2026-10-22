package com.bytedance.applet.jsb;

import com.ivy.ivykit.api.bridge.core.model.IvyBridgePlatformType;
import com.larus.platform.api.ISdkDouyinAuth;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class t0 extends bx7.c {
    public final String getName() {
        return "applet.startDouyinOpenAuth";
    }

    public t0() {
    }

    public final void a(dx7.b r4, ux7.d.d r5, IvyBridgePlatformType r6) {
        Intrinsics.checkNotNullParameter(r4, "params");
        Intrinsics.checkNotNullParameter(r5, "callback");
        Intrinsics.checkNotNullParameter(r6, "type");
        String r7 = r4.getString("client_key");
        String r0 = r4.getString("scope");
        String r8 = r4.getString("state");
        ISdkDouyinAuth r1 = com.larus.platform.service.i0.a();
        if (r1 == null) goto L6;
        r1.f(r7, r0, r8, new s0(this, r5));
        return;
    }
}
