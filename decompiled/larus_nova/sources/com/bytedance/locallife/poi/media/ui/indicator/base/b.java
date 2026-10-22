package com.bytedance.locallife.poi.media.ui.indicator.base;

import kotlin.math.MathKt;

/* JADX INFO: loaded from: classes21.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f262919a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f262920b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f262921c;

    public abstract void a(int r100);

    public abstract void c(int r100, int r101, float r102, int r103);

    public b() {
        this.f262919a = PageSwipeDirection.PAGE_SWIPE_DIRECTION_IDLE.getDirection();
    }

    public final void b(int r100, float r101) {
        int r102 = r100 + 1;
        if (r100 == this.f262920b) goto L7;
        this.f262920b = r100;
        this.f262921c = 0;
        int r103 = PageSwipeDirection.PAGE_SWIPE_DIRECTION_IDLE.getDirection();
        this.f262919a = r103;
        c(r100, r102, r101, r103);
        return;
    L7:
        if (this.f262919a == PageSwipeDirection.PAGE_SWIPE_DIRECTION_IDLE.getDirection()) goto L9;
    L13:
        c(r100, r102, r101, this.f262919a);
        return;
    L9:
        if (MathKt.roundToInt(r101) != 0) goto L11;
        int r104 = PageSwipeDirection.PAGE_SWIPE_DIRECTION_LEFT.getDirection();
    L12:
        this.f262919a = r104;
        goto L13
    L11:
        r104 = PageSwipeDirection.PAGE_SWIPE_DIRECTION_RIGHT.getDirection();
        goto L12
    }
}
