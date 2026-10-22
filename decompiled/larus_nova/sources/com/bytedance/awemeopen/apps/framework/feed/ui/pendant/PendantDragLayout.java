package com.bytedance.awemeopen.apps.framework.feed.ui.pendant;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

/* JADX INFO: loaded from: classes14.dex */
public class PendantDragLayout extends RelativeLayout {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final /* synthetic */ int f196579m = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f196580a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f196581b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f196582c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f196583d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f196584e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f196585f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f196586g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f196587h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f196588i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f196589j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f196590k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f196591l;

    public interface a {
    }

    public void setPendantClickListener(a r100) {
    }

    public PendantDragLayout(Context r100) {
        super(r100);
        this.f196582c = false;
        this.f196583d = false;
        this.f196584e = 0;
        this.f196585f = 0;
        this.f196586g = 0;
        this.f196587h = true;
        this.f196588i = true;
        this.f196590k = 0;
        this.f196591l = 0;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r100) {
        super.dispatchTouchEvent(r100);
        getParent().requestDisallowInterceptTouchEvent(true);
        return true;
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r110) {
        ViewGroup r100 = (ViewGroup) getParent();
        if (this.f196588i == false) goto L38;
        float r101 = r110.getRawX();
        float r102 = r110.getRawY();
        int r103 = r110.getAction();
        if (r103 == 0) goto L36;
        if (r103 == 1) goto L26;
        if (r103 == 2) goto L11;
        if (r103 == 3) goto L26;
    L11:
        if (r101 < 0.0f) goto L38;
        if (r101 > this.f196584e) goto L38;
        int r104 = this.f196586g;
        if (r102 < r104) goto L38;
        if (r102 > (this.f196585f + r104)) goto L38;
        float r105 = r101 - this.f196580a;
        float r106 = r102 - this.f196581b;
        if (this.f196582c == false) goto L21;
    L24:
        a(getTranslationX() + r105, getTranslationY() + r106);
        this.f196580a = r101;
        this.f196581b = r102;
        goto L38
    L21:
        if (Math.sqrt((r105 * r105) + (r106 * r106)) >= 2.0d) goto L23;
        this.f196582c = false;
        goto L24
    L23:
        this.f196582c = true;
        this.f196583d = r100.isMotionEventSplittingEnabled();
        r100.setMotionEventSplittingEnabled(false);
    L26:
        if (this.f196587h == false) goto L34;
        if (this.f196582c == false) goto L34;
        if (this.f196580a > (this.f196584e / 2)) goto L32;
        animate().setDuration(200).x(this.f196589j).start();
        this.f196580a = this.f196589j;
        goto L34
    L32:
        animate().setDuration(200).x((this.f196584e - getWidth()) - this.f196589j).start();
        this.f196580a = (this.f196584e - getWidth()) - this.f196589j;
    L34:
        if (this.f196582c == false) goto L38;
        r100.setMotionEventSplittingEnabled(this.f196583d);
        goto L38
    L36:
        this.f196582c = false;
        this.f196580a = r101;
        this.f196581b = r102;
        int[] r107 = new int[2];
        r100.getLocationInWindow(r107);
        this.f196585f = (r100.getMeasuredHeight() - r100.getPaddingTop()) - r100.getPaddingBottom();
        this.f196584e = (r100.getMeasuredWidth() - r100.getPaddingLeft()) - r100.getPaddingRight();
        this.f196586g = r107[1];
    L38:
        if (this.f196582c == false) goto L40;
    L43:
        boolean r108 = true;
    L45:
        if (this.f196588i == true) goto L47;
    L50:
        this.f196582c = false;
    L51:
        return r108;
    L47:
        if (r110.getAction() == 1) goto L50;
        if (r110.getAction() != 3) goto L51;
    L40:
        if (super.onTouchEvent(r110) == true) goto L43;
        r108 = false;
        goto L45
    }

    public void setBottomBound(int r100) {
        this.f196590k = r100;
    }

    public void setDragEnable(boolean r100) {
        this.f196588i = r100;
    }

    public void setHorizontalMargin(int r100) {
        this.f196589j = r100;
    }

    @Override // android.view.View
    public void setOnClickListener(final View.OnClickListener r100) {
        if (r100 != null) goto L4;
        super.setOnClickListener(null);
        return;
    L4:
        super.setOnClickListener(new com.bytedance.awemeopen.apps.framework.feed.ui.pendant.a(this, r100));
    }

    public void setTopBound(int r100) {
        this.f196591l = r100;
    }

    public PendantDragLayout(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.f196582c = false;
        this.f196583d = false;
        this.f196584e = 0;
        this.f196585f = 0;
        this.f196586g = 0;
        this.f196587h = true;
        this.f196588i = true;
        this.f196590k = 0;
        this.f196591l = 0;
    }

    public final void a(float r100, float r101) {
        if (this.f196584e != 0) goto L5;
    L6:
        ViewGroup r102 = (ViewGroup) getParent();
        if (r102 == null) goto L9;
        r102.getLocationInWindow(new int[2]);
        this.f196585f = (r102.getMeasuredHeight() - r102.getPaddingTop()) - r102.getPaddingBottom();
        this.f196584e = (r102.getMeasuredWidth() - r102.getPaddingLeft()) - r102.getPaddingRight();
    L9:
        float r103 = this.f196584e - getWidth();
        float r104 = (this.f196585f - getHeight()) - this.f196590k;
        float r105 = this.f196591l;
        float r106 = 0.0f;
        if (r100 < 0.0f) goto L14;
        r106 = Math.min(r100, r103);
    L14:
        if (r101 < r105) goto L17;
        r105 = Math.min(r101, r104);
    L17:
        setTranslationX(r106);
        setTranslationY(r105);
        return;
    L5:
        if (this.f196585f != 0) goto L9;
        goto L6
    }

    public PendantDragLayout(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f196582c = false;
        this.f196583d = false;
        this.f196584e = 0;
        this.f196585f = 0;
        this.f196586g = 0;
        this.f196587h = true;
        this.f196588i = true;
        this.f196590k = 0;
        this.f196591l = 0;
    }
}
