package com.bytedance.applet.jsb;

import com.ivy.ivykit.api.bridge.core.model.IvyBridgePlatformType;
import com.larus.platform.api.l1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class b0 extends bx7.c {
    public final String getName() {
        return "applet.jumpToNavigation";
    }

    public b0() {
    }

    public final void a(dx7.b r2, ux7.d.d r3, IvyBridgePlatformType r4) {
        Intrinsics.checkNotNullParameter(r2, "params");
        Intrinsics.checkNotNullParameter(r3, "callback");
        Intrinsics.checkNotNullParameter(r4, "type");
        l1 r5 = com.larus.platform.service.b.a();
        if (r5 == null) goto L6;
        r5.b();
        return;
    }
}
