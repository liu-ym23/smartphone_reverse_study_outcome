package com.bytedance.android.livesdk.ktvimpl.ktvroom.widget;

import android.view.View;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.vm.KtvChallengeDataContext;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import kotlin.Pair;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class s0<T> implements Observer {
    public final /* synthetic */ KtvOpusMidiWidget a;

    public s0(KtvOpusMidiWidget r1) {
        this.a = r1;
    }

    public final void onChanged(Object r5) {
        Pair r6 = (Pair) r5;
        KtvOpusMidiWidget r0 = this.a;
        com.bytedance.android.livesdk.ktvimpl.ktvroom.view.b r1 = r0.c;
        if (r1 == null) goto L26;
        View r2 = r1.asView();
        if (r2 != null) goto L7;
        return;
    L7:
        if (r2.getVisibility() != 0) goto L28;
        com.bytedance.android.live.ktv.common.midi.k r3 = null;
        if (r6 == null) goto L11;
        Long r4 = (Long) r6.getFirst();
    L12:
        if (r6 == null) goto L14;
        r3 = (com.bytedance.android.live.ktv.common.midi.k) r6.getSecond();
    L14:
        if (r3 == null) goto L21;
        com.bytedance.android.livesdk.ktvimpl.ktvroom.view.b r7 = r0.c;
        if (r7 == null) goto L18;
        r7.F9(r3, r4, false);
    L18:
        com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.a r8 = KtvChallengeDataContext.Companion.a();
        if (r8 == null) goto L21;
        r8.onMidiScoreChanged(r3);
    L21:
        if (r4 == null) goto L29;
        r4.longValue();
        com.bytedance.android.livesdk.ktvimpl.ktvroom.view.b r9 = r0.c;
        if (r9 == null) goto L30;
        r9.R2(r4.longValue());
        return;
    L30:
        return;
    L29:
        return;
    L11:
        r4 = null;
        goto L12
    L28:
        return;
    }
}
