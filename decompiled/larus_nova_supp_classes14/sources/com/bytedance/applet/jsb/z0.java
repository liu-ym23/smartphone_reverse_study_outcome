package com.bytedance.applet.jsb;

import com.ivy.ivykit.api.bridge.core.model.IvyBridgePlatformType;
import com.larus.audioplayer.api.music.MusicPlayManagerDelegate;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class z0 extends bx7.c {
    public final String getName() {
        return "applet.stopMusic";
    }

    public z0() {
    }

    public final void a(dx7.b r3, ux7.d.d r4, IvyBridgePlatformType r5) {
        Intrinsics.checkNotNullParameter(r3, "params");
        Intrinsics.checkNotNullParameter(r4, "callback");
        Intrinsics.checkNotNullParameter(r5, "type");
        String r6 = c0.b;
        if (r6 == null) goto L14;
        MusicPlayManagerDelegate r0 = MusicPlayManagerDelegate.b;
        a88.e r1 = r0.a();
        if (r1 == null) goto L7;
        String r2 = r1.a;
    L9:
        if (Intrinsics.areEqual(r6, r2) == false) goto L14;
        if (r0.c(r6) == false) goto L14;
        bx7.c.d(this, r4, new LinkedHashMap());
        return;
    L7:
        r2 = null;
    L14:
        bx7.c.c(this, r4, 0, null, 12);
    }
}
