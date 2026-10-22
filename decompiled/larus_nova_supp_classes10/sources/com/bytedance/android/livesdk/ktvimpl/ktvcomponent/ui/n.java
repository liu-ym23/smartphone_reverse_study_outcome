package com.bytedance.android.livesdk.ktvimpl.ktvcomponent.ui;

import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.live.ktv.common.midi.KtvMidiView;
import com.bytedance.android.live.ktv.common.midi.MidiContext;
import com.bytedance.android.livesdk.ktvimpl.base.KtvContext;
import com.bytedance.android.livesdk.ktvimpl.ktvcomponent.ui.viewmodel.KtvComponentMidiViewModel;
import com.bytedance.bpea.cert.token.TokenCert;
import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class n<T> implements Observer {
    public final /* synthetic */ KtvComponentUIWidget a;

    public n(KtvComponentUIWidget r1) {
        this.a = r1;
    }

    public final void onChanged(Object r4) {
        Boolean r5 = (Boolean) r4;
        if (r5 == null) goto L5;
        boolean r6 = r5.booleanValue();
    L6:
        if (r6 == false) goto L11;
        LifecycleOwner r1 = this.a;
        KtvComponentMidiViewModel r2 = r1.N;
        if (r2 == null) goto L11;
        r2.attach(r1);
    L11:
        if (MidiContext.Companion.d() == false) goto L13;
        KtvComponentUIWidget.zq(this.a, r6);
    L29:
        KtvComponentUIWidget r0 = this.a;
        TokenCert r3 = KtvComponentUIWidget.y1;
        r0.gr(r6);
        return;
    L13:
        KtvComponentUIWidget r7 = this.a;
        if (r6 == false) goto L23;
        TokenCert r8 = KtvComponentUIWidget.y1;
        r7.getClass();
        KtvContext.Companion.getClass();
        if (KtvContext.a.g().isCurrentUserIsSinger() == false) goto L22;
        b r9 = r7.T;
        if (r9 == null) goto L22;
        KtvMidiView r10 = r9.k;
        if (r10 == null) goto L22;
        r10.setVisibility(0);
    L22:
        r7.Nq();
        goto L29
    L23:
        b r11 = r7.T;
        if (r11 == null) goto L28;
        KtvMidiView r12 = r11.k;
        if (r12 == null) goto L28;
        r12.setVisibility(8);
    L28:
        r7.Rq();
        goto L29
    L5:
        r6 = false;
        goto L6
    }
}
