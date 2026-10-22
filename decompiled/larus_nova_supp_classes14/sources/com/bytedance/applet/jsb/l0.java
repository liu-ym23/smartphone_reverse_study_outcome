package com.bytedance.applet.jsb;

import com.ivy.ivykit.api.bridge.core.model.IvyBridgePlatformType;
import com.larus.audioplayer.api.news.NewsUrlAudioManagerDelegate;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class l0 extends bx7.c {
    public final String getName() {
        return "applet.resumeAudio";
    }

    public l0() {
    }

    public final void a(dx7.b r12, ux7.d.d r13, IvyBridgePlatformType r14) {
        Intrinsics.checkNotNullParameter(r12, "params");
        Intrinsics.checkNotNullParameter(r13, "callback");
        Intrinsics.checkNotNullParameter(r14, "type");
        String r15 = r12.getString("url");
        if (r15 != null) goto L5;
        r15 = "";
    L5:
        int r2 = r12.getInt("sourceType");
        b88.d r16 = new b88.d("old_version", r2, r15, r12.getString("videoModel"), "", "", null, null, null, null);
        NewsUrlAudioManagerDelegate.b.i(r16, a.a);
    }
}
