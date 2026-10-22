package com.bytedance.ies.xelement;

import android.content.Context;
import android.view.MotionEvent;
import android.widget.HorizontalScrollView;
import java.util.Iterator;

/* JADX INFO: loaded from: classes19.dex */
public final class b extends HorizontalScrollView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AndroidNestedScrollView f249773a;

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r100) {
        if (this.f249773a.f249572f == true) goto L5;
        return false;
    L5:
        return super.onInterceptTouchEvent(r100);
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public final boolean onTouchEvent(MotionEvent r100) {
        AndroidNestedScrollView r101 = this.f249773a;
        if (r101.f249572f == false) goto L12;
        r101.e(r100);
        if (r100.getAction() != 0) goto L8;
        AndroidNestedScrollView r102 = this.f249773a;
        r102.f(r102.f249583q);
    L8:
        if (r100.getAction() != 1) goto L11;
        AndroidNestedScrollView r103 = this.f249773a;
        r103.f249580n = r103.getScrollY();
        r103.f249581o = r103.f249569c.getScrollX();
        r103.postDelayed(r103.f249579m, r103.f249582p);
    L11:
        return super.onTouchEvent(r100);
    L12:
        return false;
    }

    public b(AndroidNestedScrollView r100, Context r101) {
        this.f249773a = r100;
        super(r101);
    }

    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.View
    public final void onMeasure(int r100, int r101) {
        super.onMeasure(r100, r101);
    }

    @Override // android.view.View
    public final void onScrollChanged(int r100, int r101, int r102, int r103) {
        super.onScrollChanged(r100, r101, r102, r103);
        AndroidNestedScrollView r104 = this.f249773a;
        if (r100 != r104.f249571e) goto L6;
        return;
    L6:
        if (r104.f249575i == true) goto L8;
    L13:
        r104.f(r104.f249583q);
        Iterator<AndroidNestedScrollView.a> r105 = r104.f249577k.iterator();
    L15:
        if (r105.hasNext() == false) goto L18;
        r105.next().onScrollChanged(r100, r101, r102, r103);
    L18:
        if (this.f249773a.f249571e == getScrollX()) goto L23;
        AndroidNestedScrollView r106 = this.f249773a;
        r106.f249571e = getScrollX();
        return;
    L23:
        return;
    L8:
        if (r104.f249576j == true) goto L13;
        r104.f249576j = true;
        r104.f(1);
        Iterator<AndroidNestedScrollView.a> r107 = r104.f249577k.iterator();
    L11:
        if (r107.hasNext() == false) goto L18;
        r107.next().a();
        goto L11
    }
}
