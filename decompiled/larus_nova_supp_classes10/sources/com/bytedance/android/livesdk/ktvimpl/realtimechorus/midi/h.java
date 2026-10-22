package com.bytedance.android.livesdk.ktvimpl.realtimechorus.midi;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.view.midi.KtvComponentMidiView;
import com.bytedance.android.livesdk.ktvimpl.realtimechorus.w;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import java.util.List;
import kotlin.Pair;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class h<T> implements Observer {
    public final /* synthetic */ RealTimeChorusMidiWidget a;

    public h(RealTimeChorusMidiWidget r1) {
        this.a = r1;
    }

    public final void onChanged(Object r4) {
        RealTimeChorusMidiWidget r0 = this.a;
        int r1 = RealTimeChorusMidiWidget.p;
        r0.getClass();
        List r5 = (List) r4;
        if (r5 != null) goto L5;
    L8:
        boolean r6 = true;
    L9:
        if (r6 == false) goto L11;
        ALogger.i(bb0.b.b(), "handleMidiResDone fail, invoke class :RealTimeChorusMidiWidget");
        return;
    L11:
        RealTimeChorusMidiViewModel r7 = r0.b;
        if (r7 == null) goto L14;
        Pair<Integer, Integer> r8 = r7.calcToneRange();
    L15:
        w.a("RealTimeChorusMidiWidget", "handleMidiResDone toneRange " + r8);
        KtvComponentMidiView r2 = r0.c;
        if (r2 == null) goto L20;
        r2.xc(r8);
        return;
    L20:
        return;
    L14:
        r8 = null;
        goto L15
    L5:
        if (r5.isEmpty() == true) goto L8;
        r6 = false;
        goto L9
    }
}
