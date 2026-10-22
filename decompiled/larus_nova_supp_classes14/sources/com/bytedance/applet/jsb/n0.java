package com.bytedance.applet.jsb;

import com.ivy.ivykit.api.bridge.core.model.IvyBridgePlatformType;
import com.larus.audioplayer.api.news.NewsUrlAudioManagerDelegate;
import com.larus.audioplayer.api.news.SOURCE_TYPE;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class n0 extends bx7.c {
    public final String getName() {
        return "applet.setAudioPlaybackTime";
    }

    public n0() {
    }

    public final void a(dx7.b r8, ux7.d.d r9, IvyBridgePlatformType r10) {
        Intrinsics.checkNotNullParameter(r8, "params");
        Intrinsics.checkNotNullParameter(r9, "callback");
        Intrinsics.checkNotNullParameter(r10, "type");
        String r2 = cx7.a.d(r8, "url", "");
        int r5 = cx7.a.c(r8, "playback_time");
        if (NewsUrlAudioManagerDelegate.b.b(r2, Integer.valueOf(SOURCE_TYPE.URL.getValue()), "", r5, new m0(this, r9)) == true) goto L6;
        bx7.c.d(this, r9, MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("result", Boolean.FALSE)}));
        return;
    }
}
