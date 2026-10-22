package com.bytedance.applet.jsb;

import com.ivy.ivykit.api.bridge.core.model.IvyBridgePlatformType;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class r0 extends bx7.c {
    public final String getName() {
        return "applet.setMusicVolume";
    }

    public r0() {
    }

    public final void a(dx7.b r5, ux7.d.d r6, IvyBridgePlatformType r7) {
        Intrinsics.checkNotNullParameter(r5, "params");
        Intrinsics.checkNotNullParameter(r6, "callback");
        Intrinsics.checkNotNullParameter(r7, "type");
    L8:
        bx7.c.c(this, r6, 0, null, 12);
        return;
    L4:
        if (d0.a((int) r5.get("volume").c()) == false) goto L6;
        bx7.c.d(this, r6, new LinkedHashMap());     // Catch: Exception -> L8
    L10:
        return;
    L6:
        bx7.c.c(this, r6, 0, null, 12);     // Catch: Exception -> L8
        goto L10
    }
}
