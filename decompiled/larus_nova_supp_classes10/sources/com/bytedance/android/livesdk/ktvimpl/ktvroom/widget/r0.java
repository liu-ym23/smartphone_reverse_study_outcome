package com.bytedance.android.livesdk.ktvimpl.ktvroom.widget;

import com.bytedance.android.live.ktv.common.midi.MidiContext;
import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class r0<T> implements Observer {
    public final /* synthetic */ KtvOpusMidiWidget a;

    public r0(KtvOpusMidiWidget r1) {
        this.a = r1;
    }

    public final void onChanged(Object r3) {
        com.bytedance.android.live.ktv.common.model.api.g0 r4 = (com.bytedance.android.live.ktv.common.model.api.g0) r3;
        KtvOpusMidiWidget r0 = this.a;
        r0.getClass();
        if (r4 == null) goto L15;
        MidiContext r1 = MidiContext.Companion.getContext();
        if (r1 == null) goto L10;
        com.bytedance.live.datacontext.j r2 = r1.getMidiConfig();
        if (r2 == null) goto L10;
        r2.d(r4);
    L10:
        com.bytedance.android.livesdk.ktvimpl.ktvroom.view.b r5 = r0.c;
        if (r5 == null) goto L14;
        r5.setConfig(r4);
        return;
    L14:
        return;
    }
}
