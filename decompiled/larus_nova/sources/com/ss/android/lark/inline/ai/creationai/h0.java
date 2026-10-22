package com.ss.android.lark.inline.ai.creationai;

import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import androidx.core.view.MarginLayoutParamsCompat;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes36.dex */
public final class h0 implements ViewTreeObserver.OnGlobalLayoutListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ g0 f427134a;

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        this.f427134a.f427121l.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        int r100 = cu5.c.d();
        if (this.f427134a.f427119j.getVisibility() != 0) goto L9;
        int r101 = this.f427134a.f427119j.getWidth();
        ViewGroup.LayoutParams r102 = this.f427134a.f427119j.getLayoutParams();
        if ((r102 instanceof ViewGroup.MarginLayoutParams) == false) goto L7;
        int r103 = MarginLayoutParamsCompat.getMarginStart((ViewGroup.MarginLayoutParams) r102);
    L8:
        int r104 = r101 + r103;
    L11:
        if (this.f427134a.f427120k.getVisibility() != 0) goto L17;
        int r105 = this.f427134a.f427120k.getWidth();
        ViewGroup.LayoutParams r106 = this.f427134a.f427120k.getLayoutParams();
        if ((r106 instanceof ViewGroup.MarginLayoutParams) == false) goto L15;
        int r107 = MarginLayoutParamsCompat.getMarginEnd((ViewGroup.MarginLayoutParams) r106);
    L16:
        int r108 = r105 + r107;
    L18:
        int r109 = (((r100 - r104) - r108) - this.f427134a.f427121l.getPaddingStart()) - this.f427134a.f427121l.getPaddingEnd();
        this.f427134a.f427121l.setMaxWidth(RangesKt.coerceAtLeast(r109, 0));
        return;
    L15:
        r107 = 0;
        goto L16
    L17:
        r108 = 0;
        goto L18
    L7:
        r103 = 0;
        goto L8
    L9:
        r104 = 0;
        goto L11
    }

    public h0(g0 r100) {
        this.f427134a = r100;
    }
}
