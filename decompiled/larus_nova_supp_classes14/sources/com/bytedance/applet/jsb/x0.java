package com.bytedance.applet.jsb;

import com.ivy.ivykit.api.bridge.core.model.IvyBridgePlatformType;
import com.larus.audioplayer.api.news.NewsUrlAudioManagerDelegate;
import com.larus.audioplayer.api.news.SOURCE_TYPE;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class x0 extends bx7.c {
    public final String getName() {
        return "applet.stopAudio";
    }

    public x0() {
    }

    public final void a(dx7.b r2, ux7.d.d r3, IvyBridgePlatformType r4) {
        Intrinsics.checkNotNullParameter(r2, "params");
        Intrinsics.checkNotNullParameter(r3, "callback");
        Intrinsics.checkNotNullParameter(r4, "type");
        String r5 = r2.getString("url");
        NewsUrlAudioManagerDelegate.b.d(r5, Integer.valueOf(SOURCE_TYPE.URL.getValue()), "");
    }
}
