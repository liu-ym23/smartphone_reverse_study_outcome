package com.larus.bmhome.chat.component.bottom.core.inputtext.panel;

import android.graphics.Rect;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.larus.common_ui.view.GradientMaskView;
import com.larus.input.impl.databinding.LarusWidgetInputBinding;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes25.dex */
public final class a implements ViewTreeObserver.OnPreDrawListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LarusWidgetInputBinding f299057a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f299058b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final GradientMaskView f299059c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ConstraintLayout.LayoutParams f299060d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Rect f299061e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f299062f;

    public final void a() {
        ViewTreeObserver r100 = this.f299057a.f351491a.getViewTreeObserver();
        if (r100.isAlive() == true) goto L6;
        r100 = null;
    L6:
        if (r100 == null) goto L8;
        r100.removeOnPreDrawListener(this);
    L8:
        ViewGroup.LayoutParams r101 = this.f299059c.getLayoutParams();
        Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.LayoutParams r102 = (ConstraintLayout.LayoutParams) r101;
        ConstraintLayout.LayoutParams r103 = this.f299060d;
        r102.topToTop = r103.topToTop;
        r102.topToBottom = r103.topToBottom;
        r102.bottomToTop = r103.bottomToTop;
        r102.bottomToBottom = r103.bottomToBottom;
        ((ViewGroup.MarginLayoutParams) r102).topMargin = ((ViewGroup.MarginLayoutParams) r103).topMargin;
        ((ViewGroup.MarginLayoutParams) r102).bottomMargin = ((ViewGroup.MarginLayoutParams) r103).bottomMargin;
        this.f299059c.setLayoutParams(r102);
        this.f299059c.setClipBounds(this.f299061e);
        this.f299059c.setImportantForAccessibility(this.f299062f);
    }

    public final boolean b() {
        ViewGroup.LayoutParams r100 = this.f299059c.getLayoutParams();
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.LayoutParams r101 = (ConstraintLayout.LayoutParams) r100;
        int r102 = RangesKt.coerceAtLeast((this.f299057a.I.getHeight() - this.f299057a.H.getTop()) + this.f299058b, 0) + ((ViewGroup.MarginLayoutParams) this.f299060d).bottomMargin;
        if (r101.topToTop == (-1)) goto L5;
    L15:
        r101.topToTop = -1;
        r101.topToBottom = -1;
        r101.bottomToTop = -1;
        r101.bottomToBottom = this.f299057a.I.getId();
        ((ViewGroup.MarginLayoutParams) r101).topMargin = 0;
        ((ViewGroup.MarginLayoutParams) r101).bottomMargin = r102;
        this.f299059c.setLayoutParams(r101);
        return true;
    L5:
        if (r101.topToBottom != (-1)) goto L15;
        if (r101.bottomToTop != (-1)) goto L15;
        if (r101.bottomToBottom != this.f299057a.I.getId()) goto L15;
        if (((ViewGroup.MarginLayoutParams) r101).bottomMargin != r102) goto L15;
        if (((ViewGroup.MarginLayoutParams) r101).topMargin != 0) goto L15;
        return false;
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public final boolean onPreDraw() {
        if (b() == false) goto L5;
        return false;
    L5:
        int r100 = RangesKt.coerceIn(this.f299057a.I.getTop() - this.f299059c.getTop(), 0, this.f299059c.getHeight());
        this.f299059c.setClipBounds(new Rect(0, 0, this.f299059c.getWidth(), r100));
        GradientMaskView r101 = this.f299059c;
        if (r100 != 0) goto L8;
        int r102 = 4;
    L9:
        r101.setImportantForAccessibility(r102);
        return true;
    L8:
        r102 = this.f299062f;
        goto L9
    }

    public a(LarusWidgetInputBinding r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "binding");
        this.f299057a = r100;
        this.f299058b = r101;
        GradientMaskView r102 = r100.f351495e;
        this.f299059c = r102;
        ViewGroup.LayoutParams r103 = r102.getLayoutParams();
        Intrinsics.checkNotNull(r103, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        this.f299060d = new ConstraintLayout.LayoutParams((ConstraintLayout.LayoutParams) r103);
        Rect r104 = r102.getClipBounds();
        if (r104 == null) goto L5;
        Rect r105 = new Rect(r104);
    L6:
        this.f299061e = r105;
        this.f299062f = r102.getImportantForAccessibility();
        b();
        r100.f351491a.getViewTreeObserver().addOnPreDrawListener(this);
        return;
    L5:
        r105 = null;
        goto L6
    }
}
