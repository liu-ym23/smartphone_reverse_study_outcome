package com.bytedance.applet.jsb;

import com.ivy.ivykit.api.bridge.core.model.IvyBridgePlatformType;
import com.larus.audioplayer.api.music.MusicPlayManagerDelegate;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class u extends bx7.c {
    public final String getName() {
        return "applet.getMusicStatus";
    }

    public u() {
    }

    public final void a(dx7.b r3, ux7.d.d r4, IvyBridgePlatformType r5) {
        Intrinsics.checkNotNullParameter(r3, "params");
        Intrinsics.checkNotNullParameter(r4, "callback");
        Intrinsics.checkNotNullParameter(r5, "type");
        a88.e r6 = MusicPlayManagerDelegate.b.a();
        if (r6 == null) goto L9;
        String r7 = r6.a;
        if (r7 == null) goto L9;
        if (Intrinsics.areEqual(r7, c0.b) == false) goto L9;
        String r8 = c0.c;
    L10:
        bx7.c.d(this, r4, MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("music_id", r7), TuplesKt.to("status", r8)}));
        return;
    L9:
        r7 = "";
        r8 = "stopped";
        goto L10
    }
}
