package com.bytedance.ee.bear.edit.toolbar.toolbar2.insertblock;

import android.animation.ValueAnimator;
import android.view.MotionEvent;
import android.view.View;

/* JADX INFO: loaded from: classes16.dex */
public final class d implements View.OnTouchListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f226322a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f226323b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f226324c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f226325d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f226326e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ View f226327f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final /* synthetic */ e f226328g;

    public final String toString() {
        return "$classname{orgY=" + this.f226322a + ", offsetY=" + this.f226323b + ", orgDeltaY=" + this.f226324c + ", deltaY=" + this.f226325d + '}';
    }

    public d(e r100, View r101) {
        this.f226328g = r100;
        this.f226327f = r101;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View r210, MotionEvent r211) {
        int r100 = r211.getAction();
        if (r100 != 0) goto L5;
        this.f226322a = r211.getRawY();
        this.f226324c = this.f226328g.f226330b.getHeight();
        this.f226326e = 0.0f;
        return true;
    L5:
        if (r100 == 1) goto L16;
        if (r100 != 2) goto L8;
        tt5.a.h("DragPopupWindow", "on  move event.getY():" + r211.getY());
        float r101 = this.f226322a - r211.getRawY();
        this.f226323b = r101;
        this.f226326e += Math.abs(r101);
        e r102 = this.f226328g;
        if (r102.f226334f == false) goto L13;
    L14:
        float r103 = this.f226324c + this.f226323b;
        this.f226325d = r103;
        r102.a(r103);
        return true;
    L13:
        if (this.f226323b < 0.0f) goto L14;
        return true;
    L8:
        if (r100 == 3) goto L18;
        return true;
    L18:
        final e r104 = this.f226328g;
        if (this.f226323b >= 0.0f) goto L21;
        boolean r105 = true;
    L22:
        int r106 = r104.f226330b.getLayoutParams().height;
        int r107 = r104.f226330b.getLayoutParams().height;
        int r110 = 0;
    L23:
        float[] r111 = r104.f226329a;
        if (r110 >= r111.length) goto L29;
        if (r107 < r111[r110]) goto L30;
        r110 = r110 + 1;
    L30:
        if (r110 != (-1)) goto L32;
        float r108 = (int) r111[r111.length - 1];
        r106 = r106;
    L47:
        tt5.a.h("DragPopupWindow", "position:" + r110);
        tt5.a.h("DragPopupWindow", "targetHeight:" + r108);
        int r109 = 0;
    L48:
        float[] r112 = r104.f226329a;
        if (r109 >= r112.length) goto L54;
        if (r108 <= r112[r109]) goto L54;
        r109 = r109 + 1;
    L54:
        ValueAnimator r113 = r104.f226331c;
        if (r113 == null) goto L57;
        r113.cancel();
    L57:
        float r114 = Math.abs(r106 - r108) / r104.f226332d;
        ValueAnimator r115 = ValueAnimator.ofInt(new int[]{r106, (int) r108});
        r104.f226331c = r115;
        r115.setDuration((long) r114);
        r104.f226331c.addUpdateListener(new c(r104));
        r104.f226331c.start();
        this.f226325d = 0.0f;
        this.f226324c = 0.0f;
        this.f226323b = 0.0f;
        this.f226322a = 0.0f;
        return true;
    L32:
        if (r110 != 0) goto L34;
        r106 = r106;
    L46:
        r108 = 0.0f;
        goto L47
    L34:
        float r116 = r111[r110];
        float r117 = r111[r110 - 1];
        float r118 = r116 - r117;
        if (r107 >= ((0.1f * r118) + r117)) goto L38;
        r108 = r117;
    L45:
        if (r108 > r111[0]) goto L47;
    L38:
        boolean r119 = r105;
        if (r107 > (((double) r117) + (((double) r118) * 0.9d))) goto L43;
        if (r119 == false) goto L43;
        r116 = r117;
    L43:
        r108 = r116;
        goto L45
    L29:
        r110 = -1;
        goto L30
    L21:
        r105 = false;
        goto L22
    L16:
        if (Math.abs(this.f226326e) >= 30.0f) goto L18;
        this.f226327f.performClick();
        return true;
    }
}
