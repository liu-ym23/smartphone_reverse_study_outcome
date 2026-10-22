package com.bytedance.livesdk.ktvcommon.midi.view;

import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import com.bytedance.livesdk.ktvcommon.midi.view.midihitanim.KtvMidiHitParticleView;
import com.bytedance.livesdk.ktvcommon.midi.view.midiplayerview.KtvMidiPlayerView;
import kotlin.Pair;

/* JADX INFO: loaded from: classes20.dex */
public final class h implements ViewTreeObserver.OnGlobalLayoutListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ KtvMidiView f256089a;

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        KtvMidiPlayerView r100 = this.f256089a.f256051b;
        if (r100 == null) goto L19;
        Pair<Long, Long> r101 = r100.getTimeRange();
        if (r101 == null) goto L19;
        long r102 = r101.component1().longValue();
        long r103 = r101.component2().longValue();
        KtvMidiView r104 = this.f256089a;
        Integer r105 = Integer.valueOf(r104.getWidth());
        if (r105.intValue() <= 0) goto L9;
        boolean r106 = true;
    L10:
        if (r106 == true) goto L13;
        r105 = null;
    L13:
        if (r105 == null) goto L19;
        int r107 = (int) ((r105.intValue() * r102) / r103);
        KtvMidiHitParticleView r108 = r104.f256052c;
        if (r108 == null) goto L19;
        ViewGroup.LayoutParams r109 = r108.getLayoutParams();
        if (r109 == null) goto L19;
        r109.width = r107;
        goto L19
    L9:
        r106 = false;
    L19:
        this.f256089a.getViewTreeObserver().removeOnGlobalLayoutListener(this);
    }

    public h(KtvMidiView r100) {
        this.f256089a = r100;
    }
}
