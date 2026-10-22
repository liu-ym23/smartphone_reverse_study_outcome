package com.bytedance.android.livesdk.ktvimpl.realtimechorus;

import com.bytedance.android.livesdk.ktvimpl.base.lyrics.KtvSingAndListenerLyricViewV2;
import com.bytedance.android.livesdk.ktvimpl.realtimechorus.midi.RealTimeChorusMidiWidget;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class j0 implements KtvSingAndListenerLyricViewV2.a {
    public final /* synthetic */ RealTimeChorusMainViewWidget a;

    public j0(RealTimeChorusMainViewWidget r1) {
        this.a = r1;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.lyrics.KtvSingAndListenerLyricViewV2.a
    public final void a(long r3) {
        RealTimeChorusMidiWidget r0 = this.a.J;
        if (r0 == null) goto L5;
        r0.xq(Long.valueOf(r3));
    L5:
        this.a.G2 = r3;
    }
}
