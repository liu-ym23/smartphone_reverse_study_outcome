package com.ss.android.lark.widget.util;

import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;

/* JADX INFO: loaded from: classes38.dex */
public abstract class b implements View.OnTouchListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f449062a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f449063b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f449064c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f449065d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f449066e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f449067f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f449068g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public VelocityTracker f449069h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f449070i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f449071j;

    public abstract boolean a();

    public abstract boolean b(int r100, int r101, MotionEvent r102);

    public abstract boolean c(int r100, MotionEvent r101);

    public b() {
        d(-1, -1);
    }

    public final void d(int r100, int r101) {
        this.f449063b = r100;
        this.f449064c = r101;
        this.f449065d = r100;
        this.f449066e = r101;
        this.f449067f = 0;
        this.f449068g = 0;
        VelocityTracker r102 = this.f449069h;
        if (r102 == null) goto L6;
        r102.clear();
        return;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View r100, MotionEvent r101) {
        if (this.f449062a != 0) goto L6;
        this.f449062a = ViewConfiguration.get(r100.getContext()).getScaledTouchSlop();
    L6:
        if (this.f449070i != 0) goto L9;
        this.f449070i = ViewConfiguration.get(r100.getContext()).getScaledMaximumFlingVelocity();
    L9:
        if (this.f449071j != 0) goto L12;
        this.f449071j = ViewConfiguration.get(r100.getContext()).getScaledMinimumFlingVelocity();
    L12:
        if (this.f449069h != null) goto L14;
        this.f449069h = VelocityTracker.obtain();
    L14:
        this.f449069h.addMovement(r101);
        int r102 = r101.getAction();
        if (r102 != 0) goto L17;
        d((int) r101.getRawX(), (int) r101.getRawY());
        r100.setPressed(true);
        return a();
    L17:
        if (r102 != 1) goto L19;
    L45:
        r101.getRawX();
        r101.getRawY();
        VelocityTracker r103 = this.f449069h;
        if (r103 == null) goto L48;
        r103.computeCurrentVelocity(1000, this.f449070i);
        int r104 = (int) this.f449069h.getXVelocity();
        int r105 = (int) this.f449069h.getYVelocity();
        this.f449069h.recycle();
        Math.abs(r104);
        Math.abs(r105);
        this.f449069h = null;
    L48:
        r100.setPressed(false);
        boolean r106 = c(this.f449068g, r101);
        if (r101.getAction() == 1) goto L51;
    L56:
        d(-1, -1);
        return r106;
    L51:
        if (this.f449067f != 0) goto L56;
        if ((r101.getEventTime() - r101.getDownTime()) > 1000) goto L55;
        r100.performClick();
        goto L56
    L55:
        r100.performLongClick();
        goto L56
    L19:
        if (r102 != 2) goto L21;
        int r107 = (int) r101.getRawX();
        int r108 = (int) r101.getRawY();
        if (this.f449063b != (-1)) goto L27;
        r100.setPressed(true);
        d(r107, r108);
    L27:
        if (this.f449067f != 1) goto L29;
    L43:
        boolean r109 = b(this.f449068g, r108 - this.f449064c, r101);
        this.f449065d = r107;
        this.f449066e = r108;
        return r109;
    L29:
        if (Math.abs(r107 - this.f449065d) < this.f449062a) goto L31;
    L33:
        this.f449067f = 1;
        if (Math.abs(r107 - this.f449065d) < Math.abs(r108 - this.f449066e)) goto L40;
        if ((r107 - this.f449065d) >= 0) goto L38;
        this.f449068g = 1;
        goto L43
    L38:
        this.f449068g = 4;
        goto L43
    L40:
        if ((r108 - this.f449066e) >= 0) goto L42;
        this.f449068g = 2;
        goto L43
    L42:
        this.f449068g = 8;
        goto L43
    L31:
        if (Math.abs(r108 - this.f449066e) >= this.f449062a) goto L33;
        return true;
    L21:
        if (r102 == 3) goto L45;
        return false;
    }
}
