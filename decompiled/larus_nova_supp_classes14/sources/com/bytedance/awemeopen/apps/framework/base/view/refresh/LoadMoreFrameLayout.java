package com.bytedance.awemeopen.apps.framework.base.view.refresh;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.bytedance.android.shopping.store.hybrid.jsbcheck.ECStoreJsbErrorCode;
import com.bytedance.awemeopen.apps.framework.AosSeriesRefactorService;
import com.bytedance.awemeopen.apps.framework.base.view.verticalviewPager.VerticalViewPager;
import com.bytedance.bdp.bdpbase.manager.BdpManager;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public class LoadMoreFrameLayout extends FrameLayout {
    public DmtStatusView a;
    public VerticalViewPager b;
    public i c;
    public int d;
    public boolean e;
    public float f;
    public float g;
    public com.bytedance.awemeopen.apps.framework.base.view.refresh.g h;
    public com.bytedance.awemeopen.apps.framework.base.view.refresh.g i;
    public com.bytedance.awemeopen.apps.framework.base.view.refresh.g j;
    public int k;
    public int l;
    public int m;
    public int n;
    public ValueAnimator o;
    public long p;
    public String q;
    public boolean r;
    public Drawable s;
    public View t;
    public f u;
    public boolean v;
    public boolean w;

    public class a implements View.OnClickListener {
        public final /* synthetic */ LoadMoreFrameLayout a;

        public a(LoadMoreFrameLayout r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r1) {
            com.bytedance.awemeopen.apps.framework.base.view.refresh.g r2 = this.a.h;
            if (r2 == null) goto L6;
            r2.onLoadMore();
            return;
        }
    }

    public class b implements View.OnClickListener {
        public final /* synthetic */ LoadMoreFrameLayout a;

        public b(LoadMoreFrameLayout r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r1) {
            com.bytedance.awemeopen.apps.framework.base.view.refresh.g r2 = this.a.h;
            if (r2 == null) goto L6;
            r2.onLoadMore();
            return;
        }
    }

    public class c implements ValueAnimator.AnimatorUpdateListener {
        public final /* synthetic */ int a;
        public final /* synthetic */ LoadMoreFrameLayout b;

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r7) {
            float r8 = r7.getAnimatedFraction();
            int r0 = LoadMoreFrameLayout.a(this.b);
            LoadMoreFrameLayout r1 = this.b;
            if (r8 != 1.0f) goto L5;
            int r9 = -r0;
        L6:
            LoadMoreFrameLayout.b(r1, r9);
            return;
        L5:
            r9 = (int) (((1.0d - Math.pow(r8, 3.0d)) * ((double) this.a)) - ((double) LoadMoreFrameLayout.a(this.b)));
            goto L6
        }

        public c(LoadMoreFrameLayout r1, int r2) {
            this.b = r1;
            this.a = r2;
        }
    }

    public class d implements Animator.AnimatorListener {
        public final /* synthetic */ LoadMoreFrameLayout a;

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator r1) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationRepeat(Animator r1) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r1) {
        }

        public d(LoadMoreFrameLayout r1) {
            this.a = r1;
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r2) {
            this.a.setBackground(null);
        }
    }

    public interface e {
    }

    public interface f {
        void onHide();

        void onShow();
    }

    public interface g {
    }

    public interface h {
    }

    public final void c() {
        this.o = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        int r0 = getViewPagerMarginTop();
        int r1 = (r0 * ECStoreJsbErrorCode.EMPTY_JSB_NAME) / this.l;
        if (r1 >= 0) goto L5;
        r1 = 200;
    L5:
        this.o.setDuration(r1);
        this.o.addUpdateListener(new c(this, r0));
        this.o.addListener(new d(this));
        this.o.start();
        DmtStatusView r2 = e(false);
        if (r2 == null) goto L8;
        r2.setVisibility(8);
    L8:
        f r3 = this.u;
        if (r3 == null) goto L12;
        r3.onHide();
        return;
    }

    public final void f() {
        DmtStatusView r0 = e(false);
        if (r0 == null) goto L5;
        r0.c();
    L5:
        this.k = -1;
        if (this.b == null) goto L9;
        c();
    L9:
        if (this.p != (-1)) goto L11;
        return;
    L11:
        if (TextUtils.isEmpty(this.q) == true) goto L15;
        this.p = -1;
        return;
    }

    public final void g() {
        DmtStatusView r1 = e(true);
        if (r1 == null) goto L5;
        r1.setVisibility(0);
        r1.setStatus(1);
    L5:
        this.k = 1;
        if (this.b == null) goto L9;
        c();
    L9:
        if (this.p != (-1)) goto L11;
        return;
    L11:
        if (TextUtils.isEmpty(this.q) == true) goto L15;
        this.p = -1;
        return;
    }

    public void setInterceptPredicate(j r1) {
    }

    public void setOnLoadMoreShowingListener(e r1) {
    }

    public void setOnScrolledListener(g r1) {
    }

    public void setReleaseListener(h r1) {
    }

    private int getViewPagerMarginTop() {
        VerticalViewPager r0 = this.b;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return ((ViewGroup.MarginLayoutParams) r0.getLayoutParams()).topMargin;
    }

    @Override // android.view.View
    public final void onFinishInflate() {
        super.onFinishInflate();     // Catch: Exception -> L4
        this.r = true;     // Catch: Exception -> L4
        return;
    }

    public boolean getIsDragged() {
        return this.e;
    }

    public LoadMoreFrameLayout(Context r2) {
        this(r2, null);
    }

    public static /* synthetic */ int a(LoadMoreFrameLayout r0) {
        return r0.getViewPagerMarginTop();
    }

    private void setViewPagerMarginTopByDelta(int r3) {
        VerticalViewPager r0 = this.b;
        if (r0 != null) goto L5;
        return;
    L5:
        ViewGroup.MarginLayoutParams r1 = (ViewGroup.MarginLayoutParams) r0.getLayoutParams();
        int r2 = r1.topMargin + r3;
        r1.topMargin = r2;
        r1.bottomMargin = -r2;
        this.b.setLayoutParams(r1);
    }

    public final DmtStatusView e(boolean r7) {
        boolean r1 = false;
        if (this.a != null) goto L28;
        if (r7 == false) goto L28;
        if (this.r == false) goto L28;
        boolean r0 = TextUtils.equals("series", this.q);     // Catch: Exception -> L27
        this.a = new DmtStatusView(getContext());     // Catch: Exception -> L27
        FrameLayout.LayoutParams r3 = new FrameLayout.LayoutParams(-1, x54.a.a(60));     // Catch: Exception -> L27
        r3.gravity = 80;     // Catch: Exception -> L27
        if (r0 == false) goto L11;
        int r4 = 0;
    L12:
        r3.setMargins(0, 0, 0, r4);     // Catch: Exception -> L27
        addView(this.a, 0, r3);     // Catch: Exception -> L27
        if (this.t != null) goto L16;
        TextView r5 = (TextView) LayoutInflater.from(getContext()).inflate(2131558701, null);     // Catch: Exception -> L27
        r5.setGravity(17);     // Catch: Exception -> L27
        r5.setTextColor(getContext().getResources().getColor(2131100273));     // Catch: Exception -> L27
        this.t = r5;     // Catch: Exception -> L27
    L16:
        if ((this.t.getParent() instanceof ViewGroup) == true) goto L18;
    L20:
        if (r0 == false) goto L22;
        DmtStatusView r2 = this.a;     // Catch: Exception -> L27
        DmtStatusView.a r6 = new DmtStatusView.a(getContext());     // Catch: Exception -> L27
        View r8 = ((AosSeriesRefactorService) BdpManager.getInst().getService(AosSeriesRefactorService.class)).q2();     // Catch: Exception -> L27
        r6.b = r8;     // Catch: Exception -> L27
        r8.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));     // Catch: Exception -> L27
        r6.c(new a(this));     // Catch: Exception -> L27
        r6.b(this.t);     // Catch: Exception -> L27
        r2.setBuilder(r6);     // Catch: Exception -> L27
    L23:
        Drawable r9 = this.s;     // Catch: Exception -> L27
        if (r9 == null) goto L28;
        this.a.setBackgroundDrawable(r9);     // Catch: Exception -> L27
        goto L28
    L22:
        DmtStatusView r10 = this.a;     // Catch: Exception -> L27
        DmtStatusView.a r11 = DmtStatusView.a.a(getContext());     // Catch: Exception -> L27
        r11.c(new b(this));     // Catch: Exception -> L27
        r11.b(this.t);     // Catch: Exception -> L27
        r10.setBuilder(r11);     // Catch: Exception -> L27
        goto L23
    L18:
        if (((ViewGroup) this.t.getParent()).indexOfChild(this.t) == (-1)) goto L20;
        ((ViewGroup) this.t.getParent()).removeView(this.t);     // Catch: Exception -> L27
        goto L20
    L11:
        r4 = x54.a.a(49);     // Catch: Exception -> L27
    L27:
        this.a = null;
        this.s = null;
    L28:
        DmtStatusView r12 = this.a;
        if (r12 != null) goto L31;
    L35:
        return r12;
    L31:
        if (r12.b != (-1)) goto L33;
        r1 = true;
    L33:
        if (r1 == false) goto L35;
        this.k = -1;
        goto L35
    }

    @Override // android.view.View
    public final void onDraw(Canvas r1) {
        super.onDraw(r1);
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r6) {
        VerticalViewPager r0 = this.b;
        if (r0 != null) goto L5;
    L48:
        return false;
    L5:
        if (r0.getAdapter() == null) goto L48;
        if (this.b.getAdapter().getCount() == 0) goto L48;
        if ((this.b.getAdapter().getCount() - 1) != this.b.getCurrentItem()) goto L48;
        VerticalViewPager r1 = this.b;
        if (r1.P0 == true) goto L48;
        if (this.w == true) goto L15;
    L16:
        i r2 = this.c;
        if (r2 != null) goto L19;
    L20:
        int r3 = r6.getAction();
        if (r3 == 0) goto L45;
        if (r3 != 1) goto L24;
    L44:
        this.e = false;
    L47:
        return this.e;
    L24:
        if (r3 != 2) goto L26;
        float r7 = r6.getY();
        float r4 = this.f;
        float r5 = r4 - r7;
        float r8 = this.d;
        if (r5 <= r8) goto L36;
        if (this.e == true) goto L36;
        this.e = true;
        ValueAnimator r9 = this.o;
        if (r9 == null) goto L47;
        r9.cancel();
    L36:
        if ((r7 - r4) <= r8) goto L47;
        if (this.e == true) goto L47;
        if (this.b.getTop() >= 0) goto L47;
        this.e = true;
        ValueAnimator r10 = this.o;
        if (r10 == null) goto L47;
        r10.cancel();
        goto L47
    L26:
        if (r3 == 3) goto L44;
    L45:
        this.e = false;
        float r11 = r6.getY();
        this.f = r11;
        this.g = r11;
        goto L47
    L19:
        if (r2.isRefreshing() == true) goto L48;
    L15:
        if (d(r1, (int) r6.getX(), (int) r6.getY()) == true) goto L48;
        goto L16
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r7) {
        DmtStatusView r1 = e(true);
        if (r1 == null) goto L83;
        VerticalViewPager r3 = this.b;
        if (r3 == null) goto L83;
        if (r3.getAdapter() == null) goto L83;
        if (this.b.getAdapter().getCount() == 0) goto L83;
        if ((this.b.getAdapter().getCount() - 1) != this.b.getCurrentItem()) goto L83;
        if (this.b.P0 == true) goto L83;
        i r4 = this.c;
        if (r4 != null) goto L17;
    L19:
        int r5 = r7.getAction();
        if (r5 != 0) goto L22;
        this.e = false;
    L82:
        return super.onTouchEvent(r7);
    L22:
        if (r5 == 1) goto L53;
        if (r5 == 2) goto L31;
        if (r5 != 3) goto L82;
        if (this.e == false) goto L82;
        c();
        this.e = false;
        goto L82
    L31:
        if (this.e == false) goto L82;
        float r6 = r7.getY();
        int r8 = (int) ((r6 - this.g) / 1.0f);
        this.g = r6;
        int r9 = getViewPagerMarginTop();
        int r10 = r9 + r8;
        if (r10 <= 0) goto L36;
        r8 = -r9;
    L36:
        if (r10 < (-this.l)) goto L82;
        if (this.v == false) goto L41;
        setViewPagerMarginTopByDelta(r8);
    L41:
        if (r1.b != (-1)) goto L43;
        boolean r11 = true;
    L44:
        if (r11 == false) goto L46;
        r1.e();
        goto L82
    L46:
        DmtStatusView r0 = e(true);
        if (r0 == null) goto L49;
        r0.setVisibility(0);
    L49:
        setBackgroundColor(getContext().getResources().getColor(2131100268));
        f r2 = this.u;
        if (r2 == null) goto L82;
        r2.onShow();
        goto L82
    L43:
        r11 = false;
        goto L44
    L53:
        if (this.e == false) goto L82;
        if (this.j != null) goto L57;
    L61:
        boolean r12 = false;
    L62:
        if (r12 == false) goto L64;
    L79:
        this.e = false;
        goto L82
    L64:
        if (getViewPagerMarginTop() > (-this.m)) goto L73;
        int r13 = this.k;
        if (r13 == 1) goto L73;
        if (r13 == 2) goto L73;
        this.o = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        int r14 = getViewPagerMarginTop();
        int r15 = ((this.m + r14) * ECStoreJsbErrorCode.EMPTY_JSB_NAME) / this.l;
        if (r15 >= 0) goto L72;
        r15 = 200;
    L72:
        this.o.setDuration(r15);
        this.o.addUpdateListener(new k(this, r14));
        this.o.addListener(new l(this));
        this.o.start();
    L73:
        com.bytedance.awemeopen.apps.framework.base.view.refresh.g r16 = this.i;
        if (r16 != null) goto L76;
    L78:
        c();
        goto L79
    L76:
        if (this.k != 1) goto L78;
        r16.onLoadMore();
        goto L78
    L57:
        if (this.k != 1) goto L61;
        if (getViewPagerMarginTop() >= (-this.n)) goto L61;
        this.j.onLoadMore();
        r12 = true;
        goto L62
    L17:
        if (r4.isRefreshing() == false) goto L19;
    L83:
        return false;
    }

    public void setBottomViewBackground(Drawable r2) {
        DmtStatusView r0 = e(false);
        if (r0 == null) goto L5;
        r0.setBackgroundDrawable(r2);
        return;
    L5:
        this.s = r2;
    }

    public void setCheckChildCanScroll(boolean r1) {
        this.w = r1;
    }

    public void setEnableMoveViewPager(boolean r1) {
        this.v = r1;
    }

    public void setLabel(String r1) {
        this.q = r1;
    }

    public void setLoadMoreEmptyView(View r2) {
        this.t = r2;
        DmtStatusView r3 = this.a;
        if (r3 == null) goto L10;
        Intrinsics.checkNotNullParameter(this, "<this>");
        Intrinsics.checkNotNullParameter(r3, "child");
        if (indexOfChild(r3) == (-1)) goto L7;
        boolean r4 = true;
    L8:
        if (r4 == false) goto L10;
        removeView(this.a);
        goto L10
    L7:
        r4 = false;
    L10:
        this.a = null;
    }

    public void setLoadMoreListener(com.bytedance.awemeopen.apps.framework.base.view.refresh.g r1) {
        this.h = r1;
    }

    public void setLoadMoreWithEmptyStatusListener(com.bytedance.awemeopen.apps.framework.base.view.refresh.g r1) {
        this.i = r1;
    }

    public void setOnLoadMoreUiListener(f r1) {
        this.u = r1;
    }

    public void setPullUp2LeaveListener(com.bytedance.awemeopen.apps.framework.base.view.refresh.g r1) {
        this.j = r1;
    }

    public LoadMoreFrameLayout(Context r2, AttributeSet r3) {
        this(r2, r3, 0);
    }

    public static /* synthetic */ void b(LoadMoreFrameLayout r0, int r1) {
        r0.setViewPagerMarginTopByDelta(r1);
    }

    public LoadMoreFrameLayout(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        this.k = -1;
        this.p = -1;
        this.r = false;
        this.s = null;
        this.v = true;
        this.w = false;
        this.d = ViewConfiguration.get(r1).getScaledTouchSlop();
        Resources r4 = getContext().getResources();
        this.m = (int) (WindowDisplayMetricsOverride.apply(r4, r4.getDisplayMetrics()).density * 109.0f);
        Resources r5 = getContext().getResources();
        this.l = (int) (WindowDisplayMetricsOverride.apply(r5, r5.getDisplayMetrics()).density * 218.0f);
        Resources r6 = getContext().getResources();
        this.n = (int) (WindowDisplayMetricsOverride.apply(r6, r6.getDisplayMetrics()).density * 100.0f);
    }

    public static boolean d(View r9, int r10, int r11) {
        if ((r9 instanceof ViewGroup) == false) goto L19;
        ViewGroup r0 = (ViewGroup) r9;
        int r2 = r9.getScrollX();
        int r3 = r9.getScrollY();
        int r4 = r0.getChildCount() - 1;
    L5:
        if (r4 < 0) goto L19;
        View r5 = r0.getChildAt(r4);
        int r6 = r10 + r2;
        if (r6 < r5.getLeft()) goto L17;
        if (r6 >= r5.getRight()) goto L17;
        int r7 = r11 + r3;
        if (r7 < r5.getTop()) goto L17;
        if (r7 >= r5.getBottom()) goto L17;
        if (d(r5, r6 - r5.getLeft(), r7 - r5.getTop()) == false) goto L17;
        return true;
    L17:
        r4 = r4 - 1;
    L19:
        if (r9.canScrollVertically(1) == true) goto L30;
        return false;
    L30:
        return true;
    }
}
