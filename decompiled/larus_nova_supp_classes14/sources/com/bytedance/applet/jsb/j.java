package com.bytedance.applet.jsb;

import com.ivy.ivykit.api.bridge.core.model.IvyBridgePlatformType;
import java.util.LinkedHashMap;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class j extends bx7.c {
    public final String getName() {
        return "applet.closeFloatingWidget";
    }

    public j() {
    }

    public final void a(dx7.b r3, ux7.d.d r4, IvyBridgePlatformType r5) {
        Intrinsics.checkNotNullParameter(r3, "params");
        Intrinsics.checkNotNullParameter(r4, "callback");
        Intrinsics.checkNotNullParameter(r5, "type");
        String r6 = r3.getString("viewId");
        Lazy r7 = i2.f.i;
        i2.f r8 = i2.f.a.a();
        if (r8 != null) goto L5;
        bx7.c.c(this, r4, 0, "FloatingViewManager unavailable", 8);
        return;
    L5:
        if (r8.g(r6) == false) goto L7;
        bx7.c.d(this, r4, new LinkedHashMap());
        return;
    L7:
        bx7.c.c(this, r4, 0, "closeFloatingWidget failed", 8);
    }
}
