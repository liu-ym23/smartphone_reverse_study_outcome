package com.bytedance.applet.aibridge;

import com.larus.platform.api.l0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class l implements l0 {
    public final /* synthetic */ f3.h<AbsSetAudioPlaybackTimeMethod.b> a;

    public l(f3.h<AbsSetAudioPlaybackTimeMethod.b> r1) {
        this.a = r1;
    }

    public final void onCompletion(boolean r4) {
        if (r4 == false) goto L4;
        f3.h<AbsSetAudioPlaybackTimeMethod.b> r5 = this.a;
        Intrinsics.checkNotNullParameter(AbsSetAudioPlaybackTimeMethod.b.class, "<this>");
        f3.h.a.b(r5, k3.c.a(AbsSetAudioPlaybackTimeMethod.b.class));
        return;
    L4:
        f3.h.a.a(this.a, "setAudioCurrentPlaybackTime failed", null, null, 14);
    }
}
