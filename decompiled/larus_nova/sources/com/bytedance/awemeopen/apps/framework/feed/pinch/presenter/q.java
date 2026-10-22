package com.bytedance.awemeopen.apps.framework.feed.pinch.presenter;

import android.view.MotionEvent;
import android.view.View;

/* JADX INFO: loaded from: classes14.dex */
public final class q extends com.bytedance.awemeopen.apps.framework.feed.pinch.utils.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ u f195734a;

    public q(u r100) {
        this.f195734a = r100;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public final boolean onFling(MotionEvent r100, MotionEvent r101, float r102, float r103) {
        if (r100 == null) goto L7;
        if (r101 != null) goto L6;
        return false;
    L6:
        return this.f195734a.f195739a.onFling(r100, r101, r102, r103);
    L7:
        return false;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public final boolean onScroll(MotionEvent r100, MotionEvent r101, float r102, float r103) {
        if (this.f195734a.f195745g == true) goto L11;
        if (r101 != null) goto L6;
    L8:
        boolean r104 = false;
    L9:
        if (r104 == false) goto L11;
        u.a(this.f195734a);
        goto L11
    L6:
        if (r101.getPointerCount() != 2) goto L8;
        r104 = true;
    L11:
        if (r101 == null) goto L13;
        int r105 = r101.getPointerCount();
    L14:
        if (r105 <= 2) goto L16;
        return false;
    L16:
        u r106 = this.f195734a;
        if (r106.f195745g == true) goto L22;
        if (r106.f195759u == true) goto L22;
        return false;
    L22:
        if (r106.f195759u == false) goto L31;
        if (r101 != null) goto L25;
    L27:
        boolean r107 = false;
    L28:
        if (r107 == false) goto L31;
        return false;
    L25:
        if (r101.getPointerCount() != 2) goto L27;
        r107 = true;
    L31:
        if (Math.abs(r102) <= 400.0f) goto L33;
    L63:
        return false;
    L33:
        if (Math.abs(r103) > 400.0f) goto L63;
        u r108 = this.f195734a;
        View r109 = r108.f195741c;
        float r110 = 0.0f;
        if (r109 == null) goto L38;
        float r111 = r109.getTranslationX();
    L39:
        r108.f195748j = r111 - r102;
        u r112 = this.f195734a;
        View r113 = r112.f195741c;
        if (r113 == null) goto L42;
        float r114 = r113.getTranslationY();
    L43:
        r112.f195749k = r114 - r103;
        this.f195734a.getClass();
        this.f195734a.getClass();
        View r115 = this.f195734a.f195741c;
        if (r115 == null) goto L46;
        float r116 = r115.getTranslationX();
    L47:
        View r117 = this.f195734a.f195741c;
        if (r117 == null) goto L51;
        r110 = r117.getTranslationY();
    L51:
        if (Math.abs(this.f195734a.f195748j - r116) < 4.0f) goto L53;
    L55:
        u r118 = this.f195734a;
        View r119 = r118.f195741c;
        if (r119 == null) goto L59;
        r119.setTranslationX(r118.f195748j);
    L59:
        if (r119 == null) goto L62;
        r119.setTranslationY(r118.f195749k);
    L62:
        return true;
    L53:
        if (Math.abs(this.f195734a.f195749k - r110) >= 4.0f) goto L55;
        return false;
    L46:
        r116 = 0.0f;
        goto L47
    L42:
        r114 = 0.0f;
        goto L43
    L38:
        r111 = 0.0f;
        goto L39
    L13:
        r105 = 0;
        goto L14
    }
}
