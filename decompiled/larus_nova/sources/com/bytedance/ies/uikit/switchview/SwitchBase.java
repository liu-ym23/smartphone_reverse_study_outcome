package com.bytedance.ies.uikit.switchview;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;
import android.widget.CompoundButton;

/* JADX INFO: loaded from: classes19.dex */
public class SwitchBase extends CompoundButton {

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final int[] f249219t = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Drawable f249220a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Drawable f249221b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f249222c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f249223d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f249224e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f249225f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f249226g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f249227h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final VelocityTracker f249228i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f249229j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public float f249230k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f249231l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f249232m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f249233n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f249234o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f249235p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f249236q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f249237r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final Rect f249238s;

    static {
        f249219t = new int[]{R.attr.state_checked};
    }

    private boolean getTargetCheckedState() {
        if (this.f249230k < (getThumbScrollRange() / 2)) goto L5;
        return true;
    L5:
        return false;
    }

    private int getThumbScrollRange() {
        Drawable r100 = this.f249221b;
        if (r100 != null) goto L6;
        return 0;
    L6:
        r100.getPadding(this.f249238s);
        int r101 = this.f249231l - this.f249233n;
        Rect r102 = this.f249238s;
        return (r101 - r102.left) - r102.right;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        int[] r100 = getDrawableState();
        Drawable r101 = this.f249220a;
        if (r101 == null) goto L5;
        r101.setState(r100);
    L5:
        Drawable r102 = this.f249221b;
        if (r102 == null) goto L8;
        r102.setState(r100);
    L8:
        invalidate();
    }

    @Override // android.widget.CompoundButton, android.widget.TextView
    public int getCompoundPaddingLeft() {
        int r100 = super.getCompoundPaddingLeft() + this.f249231l;
        if (TextUtils.isEmpty(getText()) == false) goto L5;
        return r100;
    L5:
        return r100 + this.f249223d;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView
    public int getCompoundPaddingRight() {
        int r100 = super.getCompoundPaddingRight() + this.f249231l;
        if (TextUtils.isEmpty(getText()) == false) goto L5;
        return r100;
    L5:
        return r100 + this.f249223d;
    }

    public Drawable getThumbDrawable() {
        return this.f249220a;
    }

    public Drawable getTrackDrawable() {
        return this.f249221b;
    }

    public SwitchBase(Context r100) {
        this(r100, null);
    }

    private void setThumbPosition(boolean r100) {
        if (r100 == false) goto L4;
        float r101 = getThumbScrollRange();
    L5:
        this.f249230k = r101;
        return;
    L4:
        r101 = 0.0f;
        goto L5
    }

    public void a(boolean r100) {
        setChecked(r100);
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final int[] onCreateDrawableState(int r100) {
        int[] r101 = super.onCreateDrawableState(r100 + 1);
        if (isChecked() == false) goto L5;
        CompoundButton.mergeDrawableStates(r101, f249219t);
    L5:
        return r101;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final void onDraw(Canvas r100) {
        super.onDraw(r100);
        int r101 = this.f249234o;
        int r102 = this.f249235p;
        int r103 = this.f249236q;
        int r104 = this.f249237r;
        this.f249221b.setBounds(r101, r102, r103, r104);
        this.f249221b.draw(r100);
        r100.save();
        this.f249221b.getPadding(this.f249238s);
        Rect r105 = this.f249238s;
        int r106 = r101 + r105.left;
        r100.clipRect(r106, r102, r103 - r105.right, r104);
        this.f249220a.getPadding(this.f249238s);
        int r107 = (int) (this.f249230k + 0.5f);
        Rect r108 = this.f249238s;
        int r109 = (r106 - r108.left) + r107;
        int r110 = ((r106 + r107) + this.f249233n) + r108.right;
        this.f249220a.setBounds(r109, r102, r110, r104);
        this.f249220a.draw(r100);
        r100.restore();
    }

    @Override // android.widget.TextView, android.view.View
    public final boolean onTouchEvent(MotionEvent r110) {
        this.f249228i.addMovement(r110);
        int r100 = r110.getActionMasked();
        boolean r101 = false;
        if (r100 != 0) goto L5;
        getParent().requestDisallowInterceptTouchEvent(true);
        float r102 = r110.getX();
        float r111 = r110.getY();
        if (isEnabled() == false) goto L65;
        this.f249220a.getPadding(this.f249238s);
        int r103 = this.f249235p;
        int r104 = this.f249225f;
        int r105 = r103 - r104;
        int r106 = (this.f249234o + ((int) (this.f249230k + 0.5f))) - r104;
        int r107 = this.f249233n + r106;
        Rect r108 = this.f249238s;
        int r109 = ((r107 + r108.left) + r108.right) + r104;
        int r112 = this.f249237r + r104;
        if (r102 > r106) goto L53;
    L59:
        boolean r113 = false;
    L60:
        if (r113 == false) goto L62;
        this.f249224e = 1;
    L63:
        this.f249226g = r102;
        this.f249227h = r111;
        goto L65
    L62:
        this.f249224e = 3;
        goto L63
    L53:
        if (r102 >= r109) goto L59;
        if (r111 <= r105) goto L59;
        if (r111 >= r112) goto L59;
        r113 = true;
    L65:
        if (this.f249224e == 0) goto L68;
        return true;
    L68:
        return false;
    L5:
        if (r100 == 1) goto L23;
        if (r100 == 2) goto L9;
        if (r100 == 3) goto L23;
    L9:
        int r114 = this.f249224e;
        if (r114 == 1) goto L17;
        if (r114 != 2) goto L65;
        float r115 = r110.getX();
        float r116 = Math.max(0.0f, Math.min(this.f249230k + (r115 - this.f249226g), getThumbScrollRange()));
        if (r116 == this.f249230k) goto L16;
        this.f249230k = r116;
        this.f249226g = r115;
        invalidate();
    L16:
        return true;
    L17:
        float r117 = r110.getX();
        float r118 = r110.getY();
        if (Math.abs(r117 - this.f249226g) <= this.f249225f) goto L20;
    L21:
        this.f249224e = 2;
        this.f249226g = r117;
        this.f249227h = r118;
        return true;
    L20:
        if (Math.abs(r118 - this.f249227h) <= this.f249225f) goto L65;
    L23:
        int r119 = this.f249224e;
        if (r119 != 2) goto L42;
        this.f249224e = 0;
        if (r110.getAction() == 1) goto L28;
    L30:
        boolean r120 = false;
    L31:
        MotionEvent r121 = MotionEvent.obtain(r110);
        r121.setAction(3);
        super.onTouchEvent(r121);
        r121.recycle();
        if (r120 == false) goto L40;
        this.f249228i.computeCurrentVelocity(1000);
        float r122 = this.f249228i.getXVelocity();
        if (Math.abs(r122) > this.f249229j) goto L36;
        r101 = getTargetCheckedState();
    L39:
        a(r101);
    L41:
        return true;
    L36:
        if (r122 <= 0.0f) goto L39;
        r101 = true;
        goto L39
    L40:
        a(isChecked());
        goto L41
    L28:
        if (isEnabled() == false) goto L30;
        r120 = true;
        goto L31
    L42:
        if (r119 == 1) goto L46;
        if (r119 == 3) goto L46;
        this.f249224e = 0;
        this.f249228i.clear();
    L46:
        this.f249224e = 0;
        this.f249228i.clear();
        toggle();
        return true;
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void setChecked(boolean r100) {
        super.setChecked(r100);
        setThumbPosition(isChecked());
        invalidate();
    }

    public void setSwitchPadding(int r100) {
        this.f249223d = r100;
        requestLayout();
    }

    public void setThumbDrawable(Drawable r100) {
        this.f249220a = r100;
        requestLayout();
    }

    public void setThumbResource(int r100) {
        setThumbDrawable(getContext().getResources().getDrawable(r100));
    }

    public void setTrackDrawable(Drawable r100) {
        this.f249221b = r100;
        requestLayout();
    }

    public void setTrackResource(int r100) {
        setTrackDrawable(getContext().getResources().getDrawable(r100));
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final boolean verifyDrawable(Drawable r100) {
        if (super.verifyDrawable(r100) == false) goto L5;
    L10:
        return true;
    L5:
        if (r100 == this.f249220a) goto L10;
        if (r100 == this.f249221b) goto L10;
        return false;
    }

    public SwitchBase(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    @Override // android.widget.TextView, android.view.View
    public final void onMeasure(int r100, int r101) {
        int r102 = this.f249221b.getIntrinsicWidth();
        int r103 = Math.max(this.f249222c, r102);
        int r104 = this.f249221b.getIntrinsicHeight();
        this.f249233n = this.f249220a.getIntrinsicWidth();
        this.f249231l = r103;
        this.f249232m = r104;
        setMeasuredDimension(r103, r104);
    }

    public SwitchBase(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f249228i = VelocityTracker.obtain();
        this.f249238s = new Rect();
        TypedArray r103 = r100.obtainStyledAttributes(r101, new int[]{com.larus.nova.R.attr.ms_switchMinWidth, com.larus.nova.R.attr.ms_switchPadding, com.larus.nova.R.attr.ms_thumb, com.larus.nova.R.attr.ms_track}, r102, 0);
        this.f249220a = r103.getDrawable(2);
        this.f249221b = r103.getDrawable(3);
        this.f249222c = r103.getDimensionPixelSize(0, 0);
        this.f249223d = r103.getDimensionPixelSize(1, 0);
        r103.recycle();
        ViewConfiguration r104 = ViewConfiguration.get(r100);
        this.f249225f = r104.getScaledTouchSlop();
        this.f249229j = r104.getScaledMinimumFlingVelocity();
        refreshDrawableState();
        setChecked(isChecked());
    }

    @Override // android.widget.TextView, android.view.View
    public final void onLayout(boolean r100, int r101, int r102, int r103, int r104) {
        super.onLayout(r100, r101, r102, r103, r104);
        setThumbPosition(isChecked());
        int r105 = getWidth() - getPaddingRight();
        int r106 = r105 - this.f249231l;
        int r107 = getGravity() & 112;
        if (r107 != 16) goto L5;
        int r108 = ((getPaddingTop() + getHeight()) - getPaddingBottom()) / 2;
        int r109 = this.f249232m;
        int r110 = r108 - (r109 / 2);
    L9:
        int r111 = r109 + r110;
    L10:
        this.f249234o = r106;
        this.f249235p = r110;
        this.f249237r = r111;
        this.f249236q = r105;
        return;
    L5:
        if (r107 == 80) goto L7;
        r110 = getPaddingTop();
        r109 = this.f249232m;
        goto L9
    L7:
        r111 = getHeight() - getPaddingBottom();
        r110 = r111 - this.f249232m;
        goto L10
    }
}
