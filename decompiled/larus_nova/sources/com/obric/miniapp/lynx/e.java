package com.obric.miniapp.lynx;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public final class e extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f398069a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final d f398070b;

    @Override // android.view.View, android.view.ViewParent
    public final void requestLayout() {
        super.requestLayout();
        if (getWidth() > 0) goto L5;
        return;
    L5:
        if (getHeight() > 0) goto L7;
        return;
    L7:
        if (isInLayout() == true) goto L12;
        removeCallbacks(this.f398070b);
        post(this.f398070b);
        return;
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [com.obric.miniapp.lynx.d] */
    public e(Context r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        this.f398069a = r101;
        this.f398070b = new d(this);
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int r100, int r110) {
        View r101 = getChildAt(0);
        if (r101 != null) goto L5;
    L28:
        setMeasuredDimension(View.resolveSize(getSuggestedMinimumWidth(), r100), View.resolveSize(Math.max(getSuggestedMinimumHeight(), this.f398069a), r110));
        return;
    L5:
        if (r101.getVisibility() == 8) goto L28;
        int r102 = View.MeasureSpec.getMode(r100);
        int r103 = View.MeasureSpec.getSize(r100);
        int r104 = View.MeasureSpec.getMode(r110);
        int r111 = View.MeasureSpec.getSize(r110);
        int r105 = Math.max(getSuggestedMinimumHeight(), this.f398069a);
        if (r102 == Integer.MIN_VALUE) goto L11;
        if (r102 == 1073741824) goto L11;
        r103 = Math.max(getSuggestedMinimumWidth(), (r101.getMeasuredWidth() + getPaddingLeft()) + getPaddingRight());
    L11:
        if (r104 != 1073741824) goto L14;
        if (r111 != 0) goto L14;
    L21:
        r111 = r105;
    L22:
        int r106 = View.MeasureSpec.makeMeasureSpec(Math.max(0, (r103 - getPaddingLeft()) - getPaddingRight()), 1073741824);
        if (r101.getLayoutParams().height != (-2)) goto L25;
        int r107 = View.MeasureSpec.makeMeasureSpec(0, 0);
    L26:
        r101.measure(r106, r107);
        setMeasuredDimension(r103, r111);
        return;
    L25:
        r107 = View.MeasureSpec.makeMeasureSpec(Math.max(0, (r111 - getPaddingTop()) - getPaddingBottom()), 1073741824);
    L14:
        if (r104 == 1073741824) goto L22;
        if (r104 != Integer.MIN_VALUE) goto L19;
        if (r111 == 0) goto L21;
    L19:
        if (r104 != Integer.MIN_VALUE) goto L21;
        r111 = Math.min(r105, r111);
        goto L22
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r100, int r101, int r102, int r103, int r104) {
        View r105 = getChildAt(0);
        if (r105 != null) goto L5;
        return;
    L5:
        int r106 = getPaddingTop() + r105.getMeasuredHeight();
        r105.layout(getPaddingLeft(), getPaddingTop(), (r103 - r101) - getPaddingRight(), r106);
    }
}
