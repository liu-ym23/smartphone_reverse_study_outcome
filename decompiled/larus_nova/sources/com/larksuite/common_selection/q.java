package com.larksuite.common_selection;

import android.content.Context;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;

/* JADX INFO: loaded from: classes24.dex */
public final class q extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f282912a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Rect f282913b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f282914c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f282915d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f282916e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f282917f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final /* synthetic */ r f282918g;

    @Override // android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r100) {
        if (r100 != null) goto L5;
        return false;
    L5:
        int r101 = r100.getAction();
        if (r101 == 0) goto L25;
        if (r101 == 1) goto L22;
        if (r101 == 2) goto L15;
        if (r101 != 3) goto L30;
        this.f282916e = false;
    L30:
        if (this.f282912a == false) goto L32;
        return false;
    L32:
        this.f282912a = true;
        this.f282918g.f282921c.dispatchTouchEvent(r100);
        this.f282912a = false;
        return true;
    L15:
        if (this.f282916e == false) goto L30;
        float r102 = Math.abs(r100.getX() - this.f282914c);
        float r103 = Math.abs(r100.getY() - this.f282915d);
        int r104 = this.f282917f;
        if (r102 <= r104) goto L19;
    L20:
        this.f282916e = false;
        goto L30
    L19:
        if (r103 <= r104) goto L30;
    L22:
        if (this.f282916e == false) goto L30;
        this.f282916e = false;
        this.f282918g.f282920b.invoke();
        return true;
    L25:
        this.f282918g.f282919a.getHitRect(this.f282913b);
        if (this.f282913b.contains((int) r100.getX(), (int) r100.getY()) == true) goto L28;
        this.f282916e = true;
        this.f282914c = r100.getX();
        this.f282915d = r100.getY();
        goto L30
    L28:
        this.f282916e = false;
        goto L30
    }

    public q(r r100, Context r101) {
        this.f282918g = r100;
        super(r101);
        this.f282913b = new Rect();
        this.f282917f = ViewConfiguration.get(getContext()).getScaledTouchSlop();
    }

    @Override // android.view.View
    public final void onMeasure(int r100, int r101) {
        int r102 = getSuggestedMinimumWidth();
        int r103 = View.MeasureSpec.getMode(r100);
        int r104 = View.MeasureSpec.getSize(r100);
        if (r103 == Integer.MIN_VALUE) goto L7;
        if (r103 != 1073741824) goto L8;
        r102 = r104;
    L8:
        int r105 = getSuggestedMinimumHeight();
        int r106 = View.MeasureSpec.getMode(r101);
        int r107 = View.MeasureSpec.getSize(r101);
        if (r106 == Integer.MIN_VALUE) goto L13;
        if (r106 != 1073741824) goto L14;
        r105 = r107;
    L14:
        setMeasuredDimension(r102, r105);
        return;
    L13:
        r105 = (int) Math.min(r105, r107);
        goto L14
    L7:
        r102 = (int) Math.min(r102, r104);
        goto L8
    }
}
