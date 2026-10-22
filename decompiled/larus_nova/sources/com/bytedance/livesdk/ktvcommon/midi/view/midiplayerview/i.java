package com.bytedance.livesdk.ktvcommon.midi.view.midiplayerview;

import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes20.dex */
public final class i implements ViewTreeObserver.OnGlobalLayoutListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ KtvMidiPlayerView f256245a;

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        if (this.f256245a.getWidth() > 0) goto L5;
        return;
    L5:
        if (this.f256245a.getHeight() <= 0) goto L56;
        KtvMidiPlayerView r100 = this.f256245a;
        boolean r101 = true;
        r100.f256204y = true;
        com.bytedance.livesdk.ktvcommon.midi.view.j r102 = r100.f256191l;
        int r103 = 0;
        if (r102 != null) goto L10;
    L12:
        r101 = false;
    L13:
        KtvMidiDataProcessor r104 = this.f256245a.f256188i;
        if (r104 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("dataProcessor");
    L16:
        if (r101 == false) goto L18;
        Pair<Long, Long> r105 = r104.f256177c.f256214b;
    L19:
        long r106 = r105.component1().longValue();
        long r107 = r105.component2().longValue();
        KtvMidiPlayerView r108 = this.f256245a;
        if (r108.f256204y == false) goto L53;
        long r109 = r107 + r106;
        float r110 = r108.getWidth();
        if (r110 <= 0) goto L53;
        float r111 = (r110 * r106) / r109;
        ImageView r112 = r108.f256181b;
        if (r112 == null) goto L28;
        r103 = r112.getWidth();
    L28:
        ImageView r113 = r108.f256181b;
        ViewGroup.LayoutParams r114 = null;
        if (r113 == null) goto L31;
        ViewGroup.LayoutParams r115 = r113.getLayoutParams();
    L33:
        if ((r115 instanceof ConstraintLayout.LayoutParams) == true) goto L35;
        r115 = null;
    L35:
        ConstraintLayout.LayoutParams r116 = (ConstraintLayout.LayoutParams) r115;
        if (r116 == null) goto L40;
        r116.setMarginStart((int) (r111 - (r103 / 2)));
        ImageView r117 = r108.f256181b;
        if (r117 == null) goto L40;
        r117.setLayoutParams(r116);
    L40:
        ImageView r118 = r108.f256182c;
        if (r118 == null) goto L43;
        ViewGroup.LayoutParams r119 = r118.getLayoutParams();
    L45:
        if ((r119 instanceof ConstraintLayout.LayoutParams) == false) goto L48;
        r114 = r119;
    L48:
        ConstraintLayout.LayoutParams r120 = (ConstraintLayout.LayoutParams) r114;
        if (r120 == null) goto L53;
        r120.setMarginStart((int) (r111 - r108.E.f256218f));
        ImageView r121 = r108.f256182c;
        if (r121 == null) goto L53;
        r121.setLayoutParams(r120);
        goto L53
    L43:
        r119 = null;
        goto L45
    L31:
        r115 = null;
    L53:
        this.f256245a.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        return;
    L18:
        r105 = r104.f256177c.f256213a;
        goto L19
    L10:
        if (r102.getCurrentMode() != 1) goto L12;
    }

    public i(KtvMidiPlayerView r100) {
        this.f256245a = r100;
    }
}
