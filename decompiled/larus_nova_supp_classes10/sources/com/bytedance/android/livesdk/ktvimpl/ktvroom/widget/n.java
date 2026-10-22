package com.bytedance.android.livesdk.ktvimpl.ktvroom.widget;

import com.bytedance.android.livesdk.ktvimpl.ktvroom.view.midi.KtvOpusMicLabelAnim;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class n implements te2.a {
    public final /* synthetic */ KtvInteractElementWidget a;

    @Override // te2.a
    public final void a() {
        KtvOpusMicLabelAnim r0 = this.a.x;
        if (r0 == null) goto L6;
        r0.setVisibility(8);
        return;
    }

    @Override // te2.a
    public final void b() {
        KtvOpusMicLabelAnim r0 = this.a.x;
        if (r0 == null) goto L6;
        r0.setVisibility(0);
        return;
    }

    public n(KtvInteractElementWidget r1) {
        this.a = r1;
    }
}
