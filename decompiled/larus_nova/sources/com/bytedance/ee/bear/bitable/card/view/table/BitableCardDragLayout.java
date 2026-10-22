package com.bytedance.ee.bear.bitable.card.view.table;

import android.content.Context;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import androidx.core.view.ViewCompat;
import androidx.customview.widget.ViewDragHelper;

/* JADX INFO: loaded from: classes15.dex */
public class BitableCardDragLayout extends ViewGroup {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f208799a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ViewDragHelper f208800b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public RectF f208801c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f208802d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f208803e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f208804f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final float f208805g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f208806h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f208807i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f208808j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public b f208809k;

    public interface a {
        void a(float r100);

        void onFinish();
    }

    public interface b {
        void onIntercept();
    }

    public class c extends ViewDragHelper.Callback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BitableCardDragLayout f208810a;

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public final boolean tryCaptureView(View r100, int r101) {
            return true;
        }

        public c(BitableCardDragLayout r100) {
            this.f208810a = r100;
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public final int getViewVerticalDragRange(View r100) {
            return this.f208810a.f208802d;
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public final void onViewDragStateChanged(int r100) {
            if (r100 != 0) goto L7;
            BitableCardDragLayout r101 = this.f208810a;
            if (r101.f208804f != r101.f208802d) goto L8;
            r101.getClass();
            return;
        L8:
            return;
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public final int clampViewPositionVertical(View r100, int r101, int r102) {
            if (r101 >= 0) goto L6;
            return 0;
        L6:
            return Math.min(Math.max(r101, this.f208810a.getPaddingTop()), this.f208810a.f208802d);
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public final void onViewReleased(View r100, float r101, float r102) {
            BitableCardDragLayout r103 = this.f208810a;
            int r104 = r103.f208804f;
            if (r104 == 0) goto L18;
            int r105 = r103.f208802d;
            if (r104 != r105) goto L8;
            return;
        L8:
            if (r104 < r103.f208803e) goto L10;
            boolean r106 = true;
        L11:
            if (r106 == true) goto L15;
            r105 = 0;
        L15:
            if (r103.f208800b.settleCapturedViewAt(0, r105) == false) goto L19;
            ViewCompat.postInvalidateOnAnimation(this.f208810a);
            return;
        L19:
            return;
        L10:
            r106 = false;
            goto L11
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public final void onViewPositionChanged(View r100, int r101, int r102, int r103, int r104) {
            BitableCardDragLayout r105 = this.f208810a;
            r105.f208804f = Math.abs(r102);
            BitableCardDragLayout r106 = this.f208810a;
            int r107 = r106.f208804f;
            int r108 = r106.f208802d;
            r106.getClass();
        }
    }

    public void setOnDragListener(a r100) {
    }

    @Override // android.view.View
    public final void computeScroll() {
        if (this.f208800b.continueSettling(true) == false) goto L6;
        ViewCompat.postInvalidateOnAnimation(this);
        return;
    }

    public BitableCardDragLayout(Context r100) {
        this(r100, null);
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r100) {
        this.f208808j = false;
        RectF r101 = this.f208801c;
        if (r101 == null) goto L13;
        if (r101.contains(r100.getRawX(), r100.getRawY()) == false) goto L13;
        if (this.f208799a == false) goto L13;
        if (this.f208800b.shouldInterceptTouchEvent(r100) == false) goto L13;
        this.f208808j = true;
        return true;
    L13:
        if (this.f208809k != null) goto L15;
    L26:
        return false;
    L15:
        if (r100.getAction() != 0) goto L18;
        this.f208806h = r100.getX();
        goto L26
    L18:
        if (r100.getAction() != 2) goto L26;
        if (this.f208806h != (-2.1474836E9f)) goto L23;
        this.f208806h = r100.getX();
    L23:
        if (Math.abs(r100.getX() - this.f208806h) <= this.f208805g) goto L26;
        this.f208807i = true;
        return true;
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r100) {
        if (this.f208808j == false) goto L6;
        this.f208800b.processTouchEvent(r100);
    L6:
        if (this.f208807i == false) goto L12;
        this.f208807i = false;
        b r101 = this.f208809k;
        if (r101 == null) goto L13;
        r101.onIntercept();
        return true;
    L13:
        return true;
    L12:
        return true;
    }

    public void setDragArea(View r100) {
        if (r100 == null) goto L5;
        int[] r101 = new int[2];
        r100.getLocationOnScreen(r101);
        int r102 = r101[0];
        this.f208801c = new RectF(r102, r101[1], r102 + r100.getMeasuredWidth(), r101[1] + r100.getMeasuredHeight());
        return;
    }

    @Override // android.view.View
    public void setEnabled(boolean r100) {
        this.f208799a = r100;
    }

    public void setScrollInterceptor(b r100) {
        this.f208809k = r100;
    }

    public BitableCardDragLayout(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.f208806h = -2.1474836E9f;
        this.f208800b = ViewDragHelper.create(this, new c(this));
        this.f208805g = ViewConfiguration.get(getContext()).getScaledPagingTouchSlop();
    }

    @Override // android.view.View
    public final void onMeasure(int r100, int r101) {
        super.onMeasure(r100, r101);
        if (getChildCount() > 1) goto L9;
        if (getChildCount() <= 0) goto L10;
        int r102 = View.MeasureSpec.makeMeasureSpec((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), 1073741824);
        int r103 = View.MeasureSpec.makeMeasureSpec((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), 1073741824);
        getChildAt(0).measure(r102, r103);
        return;
    L10:
        return;
    L9:
        throw new IllegalStateException("BitableCardDragLayout can host only one direct child.");
    }

    @Override // android.view.View
    public final void onSizeChanged(int r100, int r101, int r102, int r103) {
        super.onSizeChanged(r100, r101, r102, r103);
        this.f208802d = r101;
        this.f208803e = r101 * 0.35f;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r100, int r101, int r102, int r103, int r104) {
        if (getChildCount() != 0) goto L5;
        return;
    L5:
        View r105 = getChildAt(0);
        int r106 = (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
        int r107 = (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
        int r108 = getPaddingLeft();
        int r109 = getPaddingTop();
        r105.layout(r108, r109, r106 + r108, r107 + r109);
    }
}
