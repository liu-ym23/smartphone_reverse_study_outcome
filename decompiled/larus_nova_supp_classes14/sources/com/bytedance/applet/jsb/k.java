package com.bytedance.applet.jsb;

import com.ivy.ivykit.api.bridge.core.model.IvyBridgePlatformType;
import java.util.LinkedHashMap;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class k extends bx7.c {
    public final String getName() {
        return "applet.displayFloatingMask";
    }

    public k() {
    }

    public final void a(dx7.b r4, ux7.d.d r5, IvyBridgePlatformType r6) {
        Intrinsics.checkNotNullParameter(r4, "params");
        Intrinsics.checkNotNullParameter(r5, "callback");
        Intrinsics.checkNotNullParameter(r6, "type");
        String r7 = r4.getString("viewId");
        boolean r8 = r4.getBoolean("show");
        Lazy r0 = i2.f.i;
        i2.f r1 = i2.f.a.a();
        if (r1 != null) goto L5;
        bx7.c.c(this, r5, 0, "FloatingViewManager unavailable", 8);
        return;
    L5:
        if (r1.n(r7, r8) == false) goto L7;
        bx7.c.d(this, r5, new LinkedHashMap());
        return;
    L7:
        bx7.c.c(this, r5, 0, "displayFloatingMask failed", 8);
    }
}
