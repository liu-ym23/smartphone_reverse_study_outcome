package com.bytedance.applet.jsb;

import com.ivy.ivykit.api.bridge.core.model.IvyBridgePlatformType;
import com.larus.audioplayer.api.music.MusicPlayManagerDelegate;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class q extends bx7.c {
    public final String getName() {
        return "applet.getMusicDuration";
    }

    public q() {
    }

    public final void a(dx7.b r2, ux7.d.d r3, IvyBridgePlatformType r4) {
        Intrinsics.checkNotNullParameter(r2, "params");
        Intrinsics.checkNotNullParameter(r3, "callback");
        Intrinsics.checkNotNullParameter(r4, "type");
        bx7.c.d(this, r3, MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("duration", Integer.valueOf(MusicPlayManagerDelegate.b.f()))}));
    }
}
