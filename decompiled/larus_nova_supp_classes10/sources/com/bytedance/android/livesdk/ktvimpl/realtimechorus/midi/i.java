package com.bytedance.android.livesdk.ktvimpl.realtimechorus.midi;

import com.bytedance.android.live.ktv.common.model.api.g0;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.view.midi.KtvComponentMidiView;
import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class i<T> implements Observer {
    public final /* synthetic */ RealTimeChorusMidiWidget a;

    public i(RealTimeChorusMidiWidget r1) {
        this.a = r1;
    }

    public final void onChanged(Object r2) {
        g0 r3 = (g0) r2;
        RealTimeChorusMidiWidget r0 = this.a;
        if (r3 != null) goto L5;
        int r4 = RealTimeChorusMidiWidget.p;
        r0.getClass();
        return;
    L5:
        KtvComponentMidiView r1 = r0.c;
        if (r1 == null) goto L10;
        r1.setConfig(r3);
        return;
    }
}
