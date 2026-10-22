package com.bytedance.android.livesdk.ktvimpl.ktvcomponent.ui;

import android.view.animation.AnimationSet;
import android.widget.ImageView;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.live.ktv.common.midi.KtvHitAnimationView;
import com.bytedance.android.live.ktv.common.midi.KtvMidiView;
import com.bytedance.android.live.ktv.common.midi.MidiContext;
import com.bytedance.android.livesdk.config.a51;
import com.bytedance.android.livesdk.ktvimpl.base.KtvContext;
import com.bytedance.android.livesdk.ktvimpl.ktvcomponent.ui.viewmodel.KtvComponentUIContext;
import com.bytedance.bpea.cert.token.TokenCert;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Pair;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class w<T> implements Observer {
    public final /* synthetic */ KtvComponentUIWidget a;

    public w(KtvComponentUIWidget r1) {
        this.a = r1;
    }

    public final void onChanged(Object r9) {
        Pair r10 = (Pair) r9;
        if (MidiContext.Companion.d() == false) goto L5;
        KtvComponentUIWidget.yq(this.a, r10);
        return;
    L5:
        KtvComponentUIWidget r0 = this.a;
        com.bytedance.android.live.ktv.common.midi.k r11 = (com.bytedance.android.live.ktv.common.midi.k) r10.getSecond();
        TokenCert r1 = KtvComponentUIWidget.y1;
        r0.getClass();
        KtvContext.Companion.getClass();
        if (KtvContext.a.g().isCurrentUserIsSinger() == false) goto L8;
        int r2 = r11.e;
        if (r2 <= r0.I) goto L13;
        boolean r3 = true;
    L14:
        if (r3 == false) goto L36;
        r0.I = r2;
        int r4 = (int) r11.d;
        Map<String, Integer> r5 = ge2.b.a;
        Integer r6 = null;
        Iterator<T> r7 = ((List) vm2.h.J2.getValue(null, vm2.h.a[190(0xbe, float:2.66E-43)])).iterator();
    L17:
        if (r7.hasNext() == false) goto L23;
        a51 r8 = (a51) r7.next();
        float r12 = r4;
        if (r12 > r8.c()) goto L17;
        if (r12 < r8.d()) goto L17;
        r6 = ge2.b.a.get(r8.e());
    L23:
        ImageView r13 = r0.T.m;
        if (r13 == null) goto L28;
        r13.clearAnimation();
        if (r6 == null) goto L28;
        r6.intValue();
        r13.setImageResource(r6.intValue());
        r13.startAnimation((AnimationSet) r0.p1.getValue());
    L28:
        r0.pr(r11.d);
        KtvComponentUIContext r14 = r0.s;
        if (r14 == null) goto L34;
        MutableLiveData<Boolean> r15 = r14.getScoreOpen();
        if (r15 == null) goto L34;
        Boolean r16 = (Boolean) r15.getValue();
        if (r16 == null) goto L34;
    L35:
        r0.fr(com.bytedance.android.livesdk.ktvimpl.base.sei.t.d(1002, r11.d, Integer.valueOf(r11.e), Boolean.valueOf(r16.booleanValue())));
    L34:
        r16 = Boolean.FALSE;
    L36:
        KtvMidiView r17 = r0.T.k;
        if (r17 == null) goto L39;
        int r18 = r17.c(r11.a);
    L40:
        float r19 = r11.a;
        float r20 = 0;
        if (r19 <= r20) goto L64;
        float r21 = r11.b;
        if (r21 > r20) goto L45;
        return;
    L45:
        if (Math.abs(r19 - r21) >= r0.F) goto L66;
        KtvMidiView r22 = r0.T.k;
        if (r22 == null) goto L49;
        r22.d();
    L49:
        long r23 = r0.B % ((long) r0.E);
        r0.B = 1 + r23;
        if (r23 != 0) goto L67;
        KtvHitAnimationView r24 = r0.T.n;
        if (r24 == null) goto L68;
        r24.post(new e(r0, r18));
        return;
    L68:
        return;
    L67:
        return;
    L66:
        return;
    L64:
        return;
    L39:
        r18 = 0;
        goto L40
    L13:
        r3 = false;
        goto L14
    L8:
        if (r11.e < 0) goto L62;
        r0.pr(r11.d);
        return;
    }
}
