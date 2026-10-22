package com.bytedance.android.livesdk.ktvimpl.ktvroom.widget;

import com.bytedance.android.livesdk.ktvimpl.ktvroom.view.midi.KtvMvMidiMicLabelAnim;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class a2 implements te2.a {
    public final /* synthetic */ KtvStageWidget a;

    @Override // te2.a
    public final void a() {
        KtvMvMidiMicLabelAnim r0 = this.a.k;
        if (r0 == null) goto L6;
        r0.setVisibility(8);
        return;
    }

    @Override // te2.a
    public final void b() {
        KtvMvMidiMicLabelAnim r0 = this.a.k;
        if (r0 == null) goto L6;
        r0.setVisibility(0);
        return;
    }

    public a2(KtvStageWidget r1) {
        this.a = r1;
    }
}
