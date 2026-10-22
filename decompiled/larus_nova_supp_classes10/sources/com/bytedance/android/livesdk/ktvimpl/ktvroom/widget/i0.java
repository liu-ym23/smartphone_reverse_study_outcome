package com.bytedance.android.livesdk.ktvimpl.ktvroom.widget;

import com.bytedance.android.live.ktv.common.midi.AbsKtvMidiView;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.vm.KtvChallengeDataContext;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import kotlin.Pair;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class i0<T> implements Observer {
    public final /* synthetic */ KtvMvMidiWidget a;

    public i0(KtvMvMidiWidget r1) {
        this.a = r1;
    }

    public final void onChanged(Object r4) {
        Pair r5 = (Pair) r4;
        KtvMvMidiWidget r0 = this.a;
        r0.getClass();
        com.bytedance.android.live.ktv.common.midi.k r1 = null;
        if (r5 == null) goto L5;
        Long r2 = (Long) r5.getFirst();
    L6:
        if (r5 == null) goto L8;
        r1 = (com.bytedance.android.live.ktv.common.midi.k) r5.getSecond();
    L8:
        AbsKtvMidiView r6 = r0.c;
        if (r6 != null) goto L11;
        return;
    L11:
        if (r6.getVisibility() != 0) goto L25;
        if (r1 == null) goto L19;
        AbsKtvMidiView r7 = r0.c;
        if (r7 == null) goto L16;
        r7.S5(r1, r2);
    L16:
        com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.a r8 = KtvChallengeDataContext.Companion.a();
        if (r8 == null) goto L19;
        r8.onMidiScoreChanged(r1);
    L19:
        if (r2 == null) goto L26;
        r2.longValue();
        AbsKtvMidiView r9 = r0.c;
        if (r9 == null) goto L27;
        r9.R2(r2.longValue());
        return;
    L27:
        return;
    L26:
        return;
    L25:
        return;
    L5:
        r2 = null;
        goto L6
    }
}
