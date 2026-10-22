package com.bytedance.android.livesdk.ktvimpl.ktvroom.widget;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.ktv.common.midi.AbsKtvMidiView;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.stage.KtvMidiStageViewModel;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import java.util.List;
import kotlin.Pair;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class g0<T> implements Observer {
    public final /* synthetic */ KtvMvMidiWidget a;

    public g0(KtvMvMidiWidget r1) {
        this.a = r1;
    }

    public final void onChanged(Object r4) {
        KtvMvMidiWidget r0 = this.a;
        r0.getClass();
        List r5 = (List) r4;
        if (r5 != null) goto L5;
    L8:
        boolean r6 = true;
    L9:
        if (r6 == false) goto L11;
        ALogger.i(bb0.b.b(), "handleMidiResDone fail, invoke class :KtvMvMidiWidget");
        return;
    L11:
        KtvMidiStageViewModel r7 = r0.b;
        Pair<Integer, Integer> r2 = null;
        if ((r7 instanceof KtvMidiStageViewModel) == true) goto L14;
        r7 = null;
    L14:
        if (r7 == null) goto L16;
        r2 = r7.calcToneRange();
    L16:
        AbsKtvMidiView r8 = r0.c;
        if (r8 == null) goto L21;
        r8.xc(r2);
        return;
    L21:
        return;
    L5:
        if (r5.isEmpty() == true) goto L8;
        r6 = false;
        goto L9
    }
}
