package com.bytedance.applet.jsb;

import com.ivy.ivykit.api.bridge.core.model.IvyBridgePlatformType;
import com.larus.audioplayer.api.music.MusicPlayManagerDelegate;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class q0 extends bx7.c {
    public final String getName() {
        return "applet.setMusicPlaybackTime";
    }

    public q0() {
    }

    public final void a(dx7.b r4, ux7.d.d r5, IvyBridgePlatformType r6) {
        Intrinsics.checkNotNullParameter(r4, "params");
        Intrinsics.checkNotNullParameter(r5, "callback");
        Intrinsics.checkNotNullParameter(r6, "type");
        int r7 = cx7.a.c(r4, "playback_time");
        String r8 = c0.b;
        if (r8 == null) goto L11;
        MusicPlayManagerDelegate r1 = MusicPlayManagerDelegate.b;
        a88.e r2 = r1.a();
        if (r2 == null) goto L7;
        String r3 = r2.a;
    L9:
        if (Intrinsics.areEqual(r8, r3) == false) goto L11;
        r1.o(r8, r7, new p0(this, r5));
        return;
    L7:
        r3 = null;
    L11:
        bx7.c.c(this, r5, 0, null, 12);
    }
}
