package com.larus.common_ui.refresh;

import android.R;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.ListView;
import androidx.core.view.NestedScrollingChild;
import androidx.core.view.NestedScrollingChildHelper;
import androidx.core.view.NestedScrollingParent;
import androidx.core.view.NestedScrollingParentHelper;
import androidx.core.view.ViewCompat;
import androidx.core.widget.ListViewCompat;
import com.larus.utils.logger.FLogger;

/* JADX INFO: loaded from: classes27.dex */
public class SuperSwipeRefreshLayout extends ViewGroup implements NestedScrollingParent, NestedScrollingChild {

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final int[] f327777x = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public View f327778a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public AbsRefreshHeaderLayout f327779b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f327780c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f327781d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public e f327782e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f327783f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f327784g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f327785h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final NestedScrollingParentHelper f327786i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final NestedScrollingChildHelper f327787j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int[] f327788k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final int[] f327789l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f327790m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f327791n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public float f327792o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public float f327793p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public float f327794q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f327795r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f327796s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f327797t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final DecelerateInterpolator f327798u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public ValueAnimator f327799v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public ValueAnimator f327800w;

    public class a extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SuperSwipeRefreshLayout f327801a;

        public a(SuperSwipeRefreshLayout r100) {
            this.f327801a = r100;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            super.onAnimationEnd(r100);
            SuperSwipeRefreshLayout r101 = this.f327801a;
            if (r101.f327781d == false) goto L5;
            FLogger.f375446a.d("SuperSwipeRefreshLayout", "still scrolling，pending again");
            return;
        L5:
            r101.f327779b.a(r101, new q19.c(r101));
        }
    }

    public class b extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SuperSwipeRefreshLayout f327802a;

        public b(SuperSwipeRefreshLayout r100) {
            this.f327802a = r100;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            super.onAnimationEnd(r100);
            this.f327802a.g();
        }
    }

    public class c implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SuperSwipeRefreshLayout f327803a;

        public c(SuperSwipeRefreshLayout r100) {
            this.f327803a = r100;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r100) {
            int r101 = ((Integer) r100.getAnimatedValue()).intValue() - this.f327803a.getTargetView().getTop();
            this.f327803a.setTargetTopAndBottomOffset(r101);
        }
    }

    public interface d {
    }

    public interface e {
        void a(boolean r100);
    }

    static {
        f327777x = new int[]{R.attr.enabled};
    }

    public void setOnChildScrollUpCallback(d r100) {
    }

    public final void c() {
        ValueAnimator r100 = this.f327800w;
        if (r100 != null) goto L5;
    L8:
        ValueAnimator r101 = getToStartPositionAnimator();
        this.f327800w = r101;
        if (r101 == null) goto L12;
        r101.start();
        return;
    L12:
        return;
    L5:
        if (r100.isRunning() == false) goto L8;
        FLogger.f375446a.d("SuperSwipeRefreshLayout", "animateOffsetToStartPosition: animation is running");
    }

    public final void e() {
        FLogger.f375446a.d("SuperSwipeRefreshLayout", "finishSpinner,top = " + getTargetView().getTop() + ", mTriggerRefreshDistance = " + this.f327785h + ",isCancelPending = " + this.f327780c);
        if (this.f327780c == false) goto L9;
        if (getTargetView().getTop() <= this.f327785h) goto L7;
        b(new a(this));
        return;
    L7:
        this.f327779b.a(this, new q19.c(this));
        return;
    L9:
        if (getTargetView().getTop() > this.f327785h) goto L11;
        c();
        return;
    L11:
        if (this.f327783f == false) goto L13;
        b(null);
        return;
    L13:
        h(true, true);
    }

    @Override // android.view.ViewGroup, androidx.core.view.NestedScrollingParent
    public int getNestedScrollAxes() {
        return this.f327786i.getNestedScrollAxes();
    }

    public View getTargetView() {
        if (this.f327778a != null) goto L12;
        int r100 = 0;
    L6:
        if (r100 >= getChildCount()) goto L12;
        View r101 = getChildAt(r100);
        if (r101 != this.f327779b) goto L9;
        r100 = r100 + 1;
        goto L6
    L9:
        this.f327778a = r101;
    L12:
        return this.f327778a;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public final boolean hasNestedScrollingParent() {
        return this.f327787j.hasNestedScrollingParent();
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public final boolean isNestedScrollingEnabled() {
        return this.f327787j.isNestedScrollingEnabled();
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public final void stopNestedScroll() {
        this.f327787j.stopNestedScroll();
    }

    public final boolean d() {
        View r100 = getTargetView();
        if ((r100 instanceof ListView) == false) goto L7;
        return ListViewCompat.canScrollList((ListView) r100, -1);
    L7:
        return r100.canScrollVertically(-1);
    }

    public final void g() {
        setTargetTopAndBottomOffset(-getTargetView().getTop());
        this.f327795r = false;
        this.f327790m = false;
        this.f327792o = -1.0f;
        this.f327793p = -1.0f;
        this.f327797t = 0;
        this.f327780c = false;
        this.f327781d = false;
        this.f327779b.d();
        FLogger.f375446a.d("SuperSwipeRefreshLayout", "swipe reset");
    }

    public ValueAnimator getToStartPositionAnimator() {
        int r100 = getTargetView().getTop();
        FLogger.f375446a.d("SuperSwipeRefreshLayout", "animateOffsetToStartPosition, startOffset = " + r100);
        ValueAnimator r101 = ValueAnimator.ofInt(new int[]{r100, 0});
        r101.setInterpolator(this.f327798u);
        r101.setDuration(400);
        r101.addListener(new b(this));
        r101.addUpdateListener(new c(this));
        return r101;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        g();
    }

    public SuperSwipeRefreshLayout(Context r100) {
        this(r100, null);
    }

    public static String a(int r100) {
        switch(r100) {
            case 0: goto L20;
            case 1: goto L18;
            case 2: goto L16;
            case 3: goto L14;
            case 4: goto L12;
            case 5: goto L3;
            case 6: goto L3;
            case 7: goto L10;
            case 8: goto L8;
            case 9: goto L6;
            case 10: goto L4;
            default: goto L3;
        };
    L3:
        int r101 = (65280 & r100) >> 8;
        int r102 = r100 & 255;
        if (r102 == 5) goto L31;
        if (r102 == 6) goto L29;
        return MotionEvent.actionToString(r100);
    L29:
        return "ACTION_POINTER_UP(" + r101 + ")";
    L31:
        return "ACTION_POINTER_DOWN(" + r101 + ")";
    L4:
        return "ACTION_HOVER_EXIT";
    L6:
        return "ACTION_HOVER_ENTER";
    L8:
        return "ACTION_SCROLL";
    L10:
        return "ACTION_HOVER_MOVE";
    L12:
        return "ACTION_OUTSIDE";
    L14:
        return "ACTION_CANCEL";
    L16:
        return "ACTION_MOVE";
    L18:
        return "ACTION_UP";
    L20:
        return "ACTION_DOWN";
    }

    public final void b(a r100) {
        ValueAnimator r101 = this.f327799v;
        if (r101 != null) goto L5;
    L8:
        int r102 = getTargetView().getTop();
        FLogger.f375446a.d("SuperSwipeRefreshLayout", "animateOffsetToCorrectPosition, startOffset = " + r102);
        ValueAnimator r103 = ValueAnimator.ofInt(new int[]{r102, this.f327785h});
        r103.setInterpolator(this.f327798u);
        r103.setDuration(300);
        if (r100 == null) goto L11;
        r103.addListener(r100);
    L11:
        r103.addUpdateListener(new q19.d(this));
        this.f327799v = r103;
        r103.start();
        return;
    L5:
        if (r101.isRunning() == false) goto L8;
        FLogger.f375446a.d("SuperSwipeRefreshLayout", "animateOffsetToCorrectPosition: animation is running");
    }

    public final boolean f(int r100) {
        FLogger.f375446a.d("SuperSwipeRefreshLayout", "moveSpinner, offset = " + r100);
        if (r100 <= 0) goto L7;
        setTargetTopAndBottomOffset((int) (r100 * 0.6f));
        return true;
    L7:
        if (r100 >= 0) goto L16;
        View r101 = getTargetView();
        if (r101.getTop() > 0) goto L12;
        return false;
    L12:
        if ((r101.getTop() + r100) < 0.0f) goto L14;
        setTargetTopAndBottomOffset(r100);
    L15:
        return true;
    L14:
        setTargetTopAndBottomOffset(-r101.getTop());
        goto L15
    L16:
        return false;
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r100) {
        FLogger r101 = FLogger.f375446a;
        r101.d("SuperSwipeRefreshLayout", "onInterceptTouchEvent , MotionEvent = " + a(r100.getAction()) + ",mIsBeingDragged = " + this.f327795r);
        int r102 = r100.getActionMasked();
        int r103 = 0;
        if (r100.getActionMasked() != 1) goto L5;
    L7:
        boolean r104 = false;
    L8:
        this.f327781d = r104;
        if (isEnabled() == true) goto L11;
    L45:
        r101.d("SuperSwipeRefreshLayout", "onInterceptTouchEvent , canChildScrollUp = " + d() + ",mRefreshing = " + this.f327783f + ", mNestedScrollInProgress = " + this.f327790m);
        return false;
    L11:
        if (d() == true) goto L45;
        if (this.f327790m == true) goto L45;
        if (r102 != 0) goto L17;
        int r105 = r100.getPointerId(0);
        this.f327796s = r105;
        this.f327795r = false;
        int r106 = r100.findPointerIndex(r105);
        if (r106 >= 0) goto L42;
        return false;
    L42:
        this.f327792o = r100.getY(r106);
        this.f327793p = r100.getX(r106);
    L44:
        return this.f327795r;
    L17:
        if (r102 != 1) goto L19;
    L38:
        this.f327795r = false;
        this.f327796s = -1;
        goto L44
    L19:
        if (r102 == 2) goto L29;
        if (r102 == 3) goto L38;
        if (r102 != 6) goto L44;
        int r107 = r100.getActionIndex();
        if (r100.getPointerId(r107) != this.f327796s) goto L44;
        if (r107 != 0) goto L28;
        r103 = 1;
    L28:
        this.f327796s = r100.getPointerId(r103);
        goto L44
    L29:
        int r108 = this.f327796s;
        if (r108 != (-1)) goto L33;
        r101.e("SuperSwipeRefreshLayout", "Got ACTION_MOVE event but don't have an active pointer id.");
        return false;
    L33:
        int r109 = r100.findPointerIndex(r108);
        if (r109 >= 0) goto L37;
        r101.d("SuperSwipeRefreshLayout", "onInterceptTouchEvent ACTION_MOVE - pointerIndex = " + r109);
        return false;
    L37:
        i(r100.getY(r109), r100.getX(r109));
        r101.d("SuperSwipeRefreshLayout", "onInterceptTouchEvent ACTION_MOVE - mIsBeingDragged - " + this.f327795r);
        goto L44
    L5:
        if (r100.getActionMasked() == 3) goto L7;
        r104 = true;
        goto L8
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public final void onStopNestedScroll(View r100) {
        FLogger.f375446a.d("SuperSwipeRefreshLayout", "onStopNestedScroll - mRefreshing = " + this.f327783f + ",mIsBeingDragged = " + this.f327795r + "mNestedScrollInProgress=" + this.f327790m);
        this.f327786i.onStopNestedScroll(r100);
        this.f327790m = false;
        if (this.f327791n == false) goto L7;
        this.f327791n = false;
        if (getTargetView().getTop() <= 0) goto L7;
        e();
    L7:
        stopNestedScroll();
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r100) {
        int r101 = 0;
        if (r100.getActionMasked() != 1) goto L5;
    L7:
        boolean r102 = false;
    L8:
        this.f327781d = r102;
        int r103 = r100.getActionMasked();
        FLogger r104 = FLogger.f375446a;
        r104.d("SuperSwipeRefreshLayout", "onTouchEvent , MotionEvent = " + a(r100.getAction()) + ",mIsBeingDragged = " + this.f327795r);
        r104.d("SuperSwipeRefreshLayout", "onTouchEvent allowInterceptAll = false");
        if (isEnabled() == true) goto L11;
    L55:
        r104.d("SuperSwipeRefreshLayout", "onTouchEvent , isEnabled = " + isEnabled() + ", canChildScrollUp = " + d() + ", mNestedScrollInProgress = " + this.f327790m);
        return false;
    L11:
        if (d() == true) goto L55;
        if (this.f327790m == true) goto L55;
        if (r103 == 0) goto L53;
        if (r103 == 1) goto L45;
        if (r103 == 2) goto L36;
        if (r103 != 3) goto L21;
        return false;
    L21:
        if (r103 != 5) goto L23;
        int r105 = r100.getActionIndex();
        if (r105 >= 0) goto L34;
        r104.d("SuperSwipeRefreshLayout", "Got ACTION_POINTER_DOWN event but have an invalid action index.");
        return false;
    L34:
        this.f327796s = r100.getPointerId(r105);
    L54:
        return true;
    L23:
        if (r103 == 6) goto L25;
        return true;
    L25:
        int r106 = r100.getActionIndex();
        if (r100.getPointerId(r106) != this.f327796s) goto L54;
        if (r106 != 0) goto L29;
        r101 = 1;
    L29:
        this.f327796s = r100.getPointerId(r101);
        goto L54
    L36:
        int r107 = r100.findPointerIndex(this.f327796s);
        if (r107 >= 0) goto L40;
        r104.d("SuperSwipeRefreshLayout", "Got ACTION_MOVE event but have an invalid active pointer id.");
        return false;
    L40:
        float r108 = r100.getY(r107);
        i(r108, r100.getX(r107));
        if (this.f327795r == false) goto L54;
        int r109 = (int) (r108 - this.f327794q);
        this.f327794q = r108;
        return f(r109);
    L45:
        if (r100.findPointerIndex(this.f327796s) >= 0) goto L49;
        r104.e("SuperSwipeRefreshLayout", "Got ACTION_UP event but don't have an active pointer id.");
        return false;
    L49:
        if (this.f327795r == false) goto L51;
        this.f327795r = false;
        e();
    L51:
        this.f327796s = -1;
        return false;
    L53:
        this.f327796s = r100.getPointerId(0);
        this.f327795r = false;
        goto L54
    L5:
        if (r100.getActionMasked() == 3) goto L7;
        r102 = true;
        goto L8
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void requestDisallowInterceptTouchEvent(boolean r100) {
        if (this.f327795r == false) goto L5;
        return;
    L5:
        View r101 = getTargetView();
        if (r101 != null) goto L8;
    L10:
        boolean r102 = false;
    L11:
        if (r102 == false) goto L13;
        return;
    L13:
        super.requestDisallowInterceptTouchEvent(r100);
        return;
    L8:
        if (ViewCompat.isNestedScrollingEnabled(r101) == true) goto L10;
        r102 = true;
        goto L11
    }

    @Override // android.view.View
    public void setEnabled(boolean r100) {
        super.setEnabled(r100);
        if (r100 == true) goto L6;
        g();
        return;
    }

    public void setIsUserTouching(boolean r100) {
        this.f327781d = r100;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public void setNestedScrollingEnabled(boolean r100) {
        this.f327787j.setNestedScrollingEnabled(r100);
    }

    public void setOnRefreshListener(e r100) {
        this.f327782e = r100;
    }

    public void setRefreshHeader(AbsRefreshHeaderLayout r100) {
        removeViewAt(0);
        this.f327779b = r100;
        addView(r100);
    }

    public void setRefreshing(boolean r100) {
        h(r100, false);
    }

    public void setRefreshingForce(boolean r100) {
        this.f327781d = false;
        setRefreshing(r100);
    }

    public void setTargetTopAndBottomOffset(int r100) {
        View r101 = getTargetView();
        if (r101 == null) goto L15;
        FLogger.f375446a.d("SuperSwipeRefreshLayout", "setTargetTopAndBottomOffset , offset = " + r100 + ", top = " + r101.getTop());
        if (r100 > 0) goto L7;
    L13:
        if (r100 == 0) goto L17;
        ViewCompat.offsetTopAndBottom(r101, r100);
        this.f327779b.c(this, r100);
        this.f327797t += r100;
        return;
    L17:
        return;
    L7:
        if (r101.getTop() <= this.f327785h) goto L13;
        if (r101.getTop() <= (this.f327785h * 2)) goto L11;
        float r102 = r100;
        float r103 = 0.2f;
    L12:
        r100 = (int) (r102 * r103);
        goto L13
    L11:
        r102 = r100;
        r103 = 0.5f;
        goto L12
    L15:
        FLogger.f375446a.d("SuperSwipeRefreshLayout", "setTargetTopDistance ,mTarget is null, offset = " + r100);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public final boolean startNestedScroll(int r100) {
        return this.f327787j.startNestedScroll(r100);
    }

    public SuperSwipeRefreshLayout(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.f327780c = false;
        this.f327781d = false;
        this.f327783f = false;
        this.f327785h = -1;
        this.f327788k = new int[2];
        this.f327789l = new int[2];
        this.f327792o = -1.0f;
        this.f327793p = -1.0f;
        this.f327796s = -1;
        this.f327797t = 0;
        this.f327799v = null;
        this.f327800w = null;
        setWillNotDraw(false);
        this.f327784g = ViewConfiguration.get(r100).getScaledTouchSlop();
        this.f327798u = new DecelerateInterpolator(2.0f);
        this.f327786i = new NestedScrollingParentHelper(this);
        this.f327787j = new NestedScrollingChildHelper(this);
        setNestedScrollingEnabled(true);
        setChildrenDrawingOrderEnabled(true);
        TypedArray r102 = r100.obtainStyledAttributes(r101, f327777x);
        setEnabled(r102.getBoolean(0, true));
        r102.recycle();
        RefreshHeaderLayout r103 = new RefreshHeaderLayout(r100);
        this.f327779b = r103;
        addView(r103);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public final boolean dispatchNestedPreFling(float r100, float r101) {
        return this.f327787j.dispatchNestedPreFling(r100, r101);
    }

    public final void h(boolean r100, boolean r101) {
        if (this.f327783f != r100) goto L6;
        FLogger.f375446a.d("SuperSwipeRefreshLayout", "refresh status consistent，do not need refresh，refreshing = " + r100);
        return;
    L6:
        FLogger.f375446a.d("SuperSwipeRefreshLayout", "refresh status，refreshing = " + r100 + ", mIsBeingDragged=" + this.f327795r + ",mIsNestedScrollReallyHappened=" + this.f327791n + ",isUserTouching=" + this.f327781d);
        this.f327783f = r100;
        if (r100 == false) goto L13;
        e r102 = this.f327782e;
        if (r102 == null) goto L11;
        r102.a(r101);
    L11:
        this.f327779b.b(this);
        b(null);
        return;
    L13:
        if (this.f327781d == false) goto L16;
        this.f327780c = true;
        return;
    L16:
        this.f327779b.a(this, new q19.c(this));
    }

    public final void i(float r100, float r101) {
        if (this.f327792o >= 0.0f) goto L5;
        this.f327792o = (r100 - this.f327784g) - 1.0f;
    L5:
        float r102 = r100 - this.f327792o;
        float r103 = r101 - this.f327793p;
        if (Math.abs(r102) > this.f327784g) goto L8;
        return;
    L8:
        if (Math.abs(r102) > Math.abs(r103)) goto L10;
        return;
    L10:
        if (this.f327795r == false) goto L12;
        return;
    L12:
        if (r102 <= 0.0f) goto L15;
        this.f327794q = this.f327792o + this.f327784g;
        this.f327795r = true;
    L19:
        FLogger.f375446a.d("SuperSwipeRefreshLayout", "startDragging, y = " + r100 + ", yDiff = " + r102 + ",mIsBeingDragged = " + this.f327795r);
        return;
    L15:
        if (r102 >= 0.0f) goto L19;
        this.f327794q = this.f327792o - this.f327784g;
        this.f327795r = true;
        if (getTargetView().getTop() > 0) goto L19;
        this.f327795r = false;
        goto L19
    }

    @Override // android.view.View
    public final void onMeasure(int r100, int r101) {
        super.onMeasure(r100, r101);
        if (getTargetView() != null) goto L5;
        return;
    L5:
        int r102 = (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
        int r103 = (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
        int r104 = View.MeasureSpec.makeMeasureSpec(r102, 1073741824);
        int r105 = View.MeasureSpec.makeMeasureSpec(r103, 1073741824);
        getTargetView().measure(r104, r105);
        int r106 = View.MeasureSpec.makeMeasureSpec(r102, 1073741824);
        int r107 = View.MeasureSpec.makeMeasureSpec(r103, Integer.MIN_VALUE);
        this.f327779b.measure(r106, r107);
        if (this.f327785h > 0) goto L9;
        this.f327785h = this.f327779b.getMeasuredHeight();
        return;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public final boolean dispatchNestedFling(float r100, float r101, boolean r102) {
        return this.f327787j.dispatchNestedFling(r100, r101, r102);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public final boolean onNestedPreFling(View r100, float r101, float r102) {
        if (isEnabled() == false) goto L11;
        if (getTargetView() == null) goto L11;
        if (getTargetView().getTop() <= 0) goto L11;
        return true;
    L11:
        return dispatchNestedPreFling(r101, r102);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public final void onNestedScrollAccepted(View r100, View r101, int r102) {
        this.f327786i.onNestedScrollAccepted(r100, r101, r102);
        startNestedScroll(r102 & 2);
        this.f327790m = true;
        FLogger.f375446a.d("SuperSwipeRefreshLayout", "onNestedScrollAccepted");
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public final boolean onStartNestedScroll(View r100, View r101, int r102) {
        if (isEnabled() == true) goto L5;
    L9:
        boolean r103 = false;
    L10:
        FLogger.f375446a.d("SuperSwipeRefreshLayout", "onStartNestedScroll top = " + getTargetView().getTop() + " axes = " + (r102 & 2) + ", result = " + r103);
        return r103;
    L5:
        if (getTargetView().getTop() < 0) goto L9;
        if ((r102 & 2) == 0) goto L9;
        r103 = true;
        goto L10
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public final boolean dispatchNestedPreScroll(int r100, int r101, int[] r102, int[] r103) {
        return this.f327787j.dispatchNestedPreScroll(r100, r101, r102, r103);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public final boolean onNestedFling(View r100, float r101, float r102, boolean r103) {
        return dispatchNestedFling(r101, r102, r103);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public final void onNestedPreScroll(View r100, int r101, int r110, int[] r111) {
        this.f327791n = true;
        int r102 = getTargetView().getTop();
        if (r110 <= 0) goto L9;
        if (r102 <= 0) goto L9;
        if ((r102 - r110) < 0) goto L8;
        f(-r110);
        r111[1] = r110;
        goto L9
    L8:
        int r103 = -r102;
        r111[1] = r103;
        f(r103);
    L9:
        int r104 = r111[1];
        int[] r105 = this.f327788k;
        if (dispatchNestedPreScroll(r101 - r111[0], r110 - r104, r105, null) == false) goto L12;
        r111[0] = r111[0] + r105[0];
        r111[1] = r111[1] + r105[1];
    L12:
        FLogger.f375446a.d("SuperSwipeRefreshLayout", "onNestedPreScroll, dx = " + r101 + ", dy = " + r110 + " ,targetTop = " + r102 + ",beforeY=" + r104 + ",afterY=" + r111[1]);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public final boolean dispatchNestedScroll(int r100, int r101, int r102, int r110, int[] r111) {
        return this.f327787j.dispatchNestedScroll(r100, r101, r102, r110, r111);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r100, int r101, int r102, int r103, int r104) {
        int r105 = getMeasuredWidth();
        int r106 = getMeasuredHeight();
        if (getChildCount() != 0) goto L5;
        return;
    L5:
        View r107 = getTargetView();
        int r108 = getPaddingLeft();
        int r109 = getPaddingTop() + this.f327797t;
        int r110 = ((r105 - getPaddingLeft()) - getPaddingRight()) + r108;
        r107.layout(r108, r109, r110, ((r106 - getPaddingTop()) - getPaddingBottom()) + r109);
        AbsRefreshHeaderLayout r111 = this.f327779b;
        r111.layout(r108, r109 - r111.getMeasuredHeight(), r110, r109);
        FLogger.f375446a.d("SuperSwipeRefreshLayout", "onLayout changed = " + r100 + ",top = " + r102);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public final void onNestedScroll(View r100, int r101, int r102, int r110, int r111) {
        this.f327791n = true;
        dispatchNestedScroll(r101, r102, r110, r111, this.f327789l);
        int r103 = this.f327789l[1] + r111;
        FLogger.f375446a.d("SuperSwipeRefreshLayout", "onNestedScroll, dyConsumed = " + r102 + ", dyUnconsumed = " + r111 + ", dy = " + r103 + ", canChildScrollUp = %s" + d());
        if (r103 < 0) goto L5;
        return;
    L5:
        if (d() == true) goto L9;
        f(Math.abs(r103));
        return;
    }
}
