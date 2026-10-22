package com.bytedance.android.livesdk.ktvimpl.ktvroom.view;

import android.view.View;
import com.bytedance.android.live.ktv.common.model.api.g0;
import com.bytedance.android.livesdkapi.depend.message.MidiSkinDressInfo;
import kotlin.Pair;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public interface b extends com.bytedance.android.live.ktv.common.util.c {
    void A1();

    void F9(com.bytedance.android.live.ktv.common.midi.k r1, Long r2, boolean r3);

    void Gk(db0.a r1, com.bytedance.android.live.ktv.common.midi.g r2);

    void R2(long r1);

    View asView();

    void onDetach();

    void qc(com.bytedance.android.live.ktv.common.midi.f r1);

    void reset();

    void setConfig(g0 r1);

    void setContainerVisibility(int r1);

    void setPerformStrategy(com.bytedance.android.live.ktv.common.midi.g r1);

    void xc(Pair<Integer, Integer> r1);

    void y(MidiSkinDressInfo r1);
}
