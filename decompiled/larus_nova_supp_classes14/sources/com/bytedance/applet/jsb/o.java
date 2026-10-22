package com.bytedance.applet.jsb;

import com.ivy.ivykit.api.bridge.core.model.IvyBridgePlatformType;
import com.larus.audioplayer.api.news.NewsUrlAudioManagerDelegate;
import com.larus.audioplayer.api.news.SOURCE_TYPE;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class o extends bx7.c {
    public final String getName() {
        return "applet.getAudioPlayStatus";
    }

    public o() {
    }

    public final void a(dx7.b r3, ux7.d.d r4, IvyBridgePlatformType r5) {
        Intrinsics.checkNotNullParameter(r3, "params");
        Intrinsics.checkNotNullParameter(r4, "callback");
        Intrinsics.checkNotNullParameter(r5, "type");
        bx7.c.d(this, r4, MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("value", NewsUrlAudioManagerDelegate.b.h(r3.getString("url"), Integer.valueOf(SOURCE_TYPE.URL.getValue()), "").getValue())}));
    }
}
