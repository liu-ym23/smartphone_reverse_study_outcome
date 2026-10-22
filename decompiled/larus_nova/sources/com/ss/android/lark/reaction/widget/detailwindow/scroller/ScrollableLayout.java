package com.ss.android.lark.reaction.widget.detailwindow.scroller;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.FloatEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewTreeObserver;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.ss.android.lark.utils.UIHelper;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes37.dex */
public class ScrollableLayout extends FrameLayout {
    public static final /* synthetic */ int G = 0;
    public d A;
    public int B;
    public int C;
    public View D;
    public final a E;
    public final b F;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Rect f439268a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<com.ss.android.lark.reaction.widget.detailwindow.scroller.i> f439269b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public k f439270c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public GestureDetector f439271d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public GestureDetector f439272e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public com.ss.android.lark.reaction.widget.detailwindow.scroller.a f439273f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f439274g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f439275h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f439276i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public f f439277j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public com.ss.android.lark.reaction.widget.detailwindow.scroller.b f439278k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public ValueAnimator f439279l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public ValueAnimator.AnimatorUpdateListener f439280m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f439281n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f439282o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f439283p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public com.ss.android.lark.reaction.widget.detailwindow.scroller.d f439284q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public com.ss.android.lark.reaction.widget.detailwindow.scroller.c f439285r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public View f439286s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f439287t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public long f439288u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f439289v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public float f439290w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public float f439291x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public com.ss.android.lark.reaction.widget.detailwindow.scroller.h f439292y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public boolean f439293z;

    public static class ScrollableLayoutSavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<ScrollableLayoutSavedState> CREATOR = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f439294a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f439295b;

        public class a implements Parcelable.Creator<ScrollableLayoutSavedState> {
            public a() {
            }

            @Override // android.os.Parcelable.Creator
            public final ScrollableLayoutSavedState createFromParcel(Parcel r100) {
                return new ScrollableLayoutSavedState(r100);
            }

            @Override // android.os.Parcelable.Creator
            public final ScrollableLayoutSavedState[] newArray(int r100) {
                return new ScrollableLayoutSavedState[r100];
            }
        }

        static {
            CREATOR = new a();
        }

        public ScrollableLayoutSavedState(Parcel r100) {
            super(r100);
            this.f439294a = r100.readInt();
            boolean r101 = true;
            if (r100.readByte() == 1) goto L6;
            r101 = false;
        L6:
            this.f439295b = r101;
        }

        public ScrollableLayoutSavedState(Parcelable r100) {
            super(r100);
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public final void writeToParcel(Parcel r100, int r101) {
            super.writeToParcel(r100, r101);
            r100.writeInt(this.f439294a);
            r100.writeByte(this.f439295b ? 1 : 0);
        }
    }

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ScrollableLayout f439296a;

        @Override // java.lang.Runnable
        public final void run() {
            boolean r100 = this.f439296a.f439270c.a();     // Catch: Throwable -> L9
            ScrollableLayout r101 = this.f439296a;     // Catch: Throwable -> L9
            r101.f439282o = r100;     // Catch: Throwable -> L9
            if (r100 == false) goto L12;
            int r102 = r101.f439270c.f439327m;     // Catch: Throwable -> L9
            if ((r102 - r101.getScrollY()) == 0) goto L7;
            this.f439296a.scrollTo(0, r102);     // Catch: Throwable -> L9
        L7:
            this.f439296a.post(this);     // Catch: Throwable -> L9
            return;
        L12:
            return;
        L9:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L16;
            throw th;
        }

        public a(ScrollableLayout r100) {
            this.f439296a = r100;
        }
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ScrollableLayout f439297a;

        public class a implements ValueAnimator.AnimatorUpdateListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ int f439298a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ int f439299b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ b f439300c;

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator r100) {
                this.f439300c.f439297a.scrollTo(0, (int) ((this.f439298a + (this.f439299b * r100.getAnimatedFraction())) + 0.5f));
            }

            public a(b r100, int r101, int r102) {
                this.f439300c = r100;
                this.f439298a = r101;
                this.f439299b = r102;
            }
        }

        public final void a() {
            ScrollableLayout r100 = this.f439297a;
            ValueAnimator r101 = r100.f439279l;
            if (r101 != null) goto L5;
        L10:
            ScrollableLayout r102 = this.f439297a;
            if (r102.f439281n == false) goto L13;
            return;
        L13:
            if (r102.f439282o == true) goto L43;
            int r103 = r102.getScrollY();
            if (r103 == 0) goto L42;
            ScrollableLayout r104 = this.f439297a;
            int r105 = r104.f439274g;
            if (r103 == r105) goto L44;
            int r106 = r104.f439278k.b(r103, r105);
            if (r103 != r106) goto L23;
            return;
        L23:
            ScrollableLayout r107 = this.f439297a;
            ValueAnimator r108 = r107.f439279l;
            if (r108 != null) goto L26;
            r107.f439279l = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
            this.f439297a.f439279l.setEvaluator(new FloatEvaluator());
            this.f439297a.f439279l.addListener(new i(this.f439297a));
        L32:
            ScrollableLayout r109 = this.f439297a;
            a r110 = new a(this, r103, r106 - r103);
            r109.f439280m = r110;
            r109.f439279l.addUpdateListener(r110);
            ScrollableLayout r111 = this.f439297a;
            com.ss.android.lark.reaction.widget.detailwindow.scroller.d r112 = r111.f439284q;
            if (r112 == null) goto L35;
            long r113 = ((l) r112).f439341a;
        L36:
            r111.f439279l.setDuration(r113);
            ScrollableLayout r114 = this.f439297a;
            com.ss.android.lark.reaction.widget.detailwindow.scroller.c r115 = r114.f439285r;
            if (r115 == null) goto L39;
            r114.f439279l.setInterpolator(((com.ss.android.lark.reaction.widget.detailwindow.scroller.g) r115).f439312a);
        L39:
            this.f439297a.f439279l.start();
            return;
        L35:
            r113 = 200;
            goto L36
        L26:
            ValueAnimator.AnimatorUpdateListener r116 = r107.f439280m;
            if (r116 == null) goto L30;
            r108.removeUpdateListener(r116);
        L30:
            if (this.f439297a.f439279l.isRunning() == false) goto L32;
            this.f439297a.f439279l.end();
            goto L32
        L44:
            return;
        L42:
            return;
        L43:
            return;
        L5:
            if (r101.isRunning() == false) goto L10;
            ValueAnimator.AnimatorUpdateListener r117 = r100.f439280m;
            if (r117 == null) goto L9;
            r100.f439279l.removeUpdateListener(r117);
        L9:
            r100.f439279l.end();
            goto L10
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public b(ScrollableLayout r100) {
            this.f439297a = r100;
        }
    }

    public class c implements g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ScrollableLayout f439301a;

        public c(ScrollableLayout r100) {
            this.f439301a = r100;
        }
    }

    public class d implements ViewTreeObserver.OnGlobalLayoutListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f439302a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ScrollableLayout f439303b;

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public final void onGlobalLayout() {
            ScrollableLayout r100 = this.f439303b;
            r100.f439274g = this.f439302a.getMeasuredHeight();
        }

        public d(ScrollableLayout r100, View r101) {
            this.f439303b = r100;
            this.f439302a = r101;
        }
    }

    public class e extends com.ss.android.lark.reaction.widget.detailwindow.scroller.f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f439304a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final float f439305b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ ScrollableLayout f439306c;

        public e(ScrollableLayout r100, Context r101) {
            this.f439306c = r100;
            this.f439304a = UIHelper.dp2px(12.0f);
            this.f439305b = ViewConfiguration.get(r101).getScaledMinimumFlingVelocity();
        }

        @Override // com.ss.android.lark.reaction.widget.detailwindow.scroller.f, android.view.GestureDetector.OnGestureListener
        public final boolean onFling(MotionEvent r110, MotionEvent r111, float r112, float r113) {
            if (Math.abs(r113) >= this.f439305b) goto L6;
            return false;
        L6:
            if (Math.abs(r112) <= Math.abs(r113)) goto L8;
            return false;
        L8:
            int r114 = this.f439306c.getScrollY();
            if (r114 < 0) goto L46;
            ScrollableLayout r115 = this.f439306c;
            int r116 = r115.f439274g;
            if (r114 > r116) goto L50;
            int r100 = -((int) (0.5f + r113));
            if (r115.f439287t == false) goto L16;
        L26:
            ScrollableLayout r117 = this.f439306c;
            r117.f439270c.b(r114, r100, r117.f439274g);
            if (this.f439306c.f439270c.a() == false) goto L47;
            int r118 = this.f439306c.f439270c.f439321g;
            if (Math.abs(r114 - r118) >= this.f439304a) goto L32;
            k r119 = this.f439306c.f439270c;
            r119.f439326l = r119.f439320f;
            r119.f439327m = r119.f439321g;
            r119.f439331q = true;
            return false;
        L32:
            if (r118 == r114) goto L41;
            ScrollableLayout r120 = this.f439306c;
            com.ss.android.lark.reaction.widget.detailwindow.scroller.b r121 = r120.f439278k;
            if (r121 == null) goto L41;
            if ((r118 - r114) >= 0) goto L39;
            boolean r122 = true;
        L40:
            r118 = r121.a(r122, r114, r120.f439274g);
            k r123 = this.f439306c.f439270c;
            r123.f439321g = r118;
            r123.f439330p = r118 - r123.f439319e;
            r123.f439331q = false;
            goto L41
        L39:
            r122 = false;
        L41:
            int r124 = this.f439306c.b(r118);
            if (r118 == r114) goto L48;
            if (r124 < 0) goto L49;
            return true;
        L49:
            return false;
        L48:
            return false;
        L47:
            return false;
        L16:
            if (r115.f439292y == null) goto L26;
            if (r116 == r115.getScrollY()) goto L26;
            if (r100 <= 0) goto L26;
            if (((n2c.h) this.f439306c.f439273f).a(1) == false) goto L26;
            this.f439306c.f439270c.b(r114, r100, Integer.MAX_VALUE);
            k r125 = this.f439306c.f439270c;
            int r126 = r125.f439321g;
            Math.exp(Math.log((Math.abs(r113) * 0.35f) / (r125.f439336v * r125.f439338x)) / (((double) k.f439314z) - 1.0d));
            ScrollableLayout r127 = this.f439306c;
            com.ss.android.lark.reaction.widget.detailwindow.scroller.h r128 = r127.f439292y;
            int r129 = r126 - r127.f439274g;
            RecyclerView r130 = ((n2c.i) r128).f516849a.f439221r;
            if (r130 == null) goto L25;
            r130.smoothScrollBy(0, r129);
        L25:
            k r131 = this.f439306c.f439270c;
            r131.f439326l = r131.f439320f;
            r131.f439327m = r131.f439321g;
            r131.f439331q = true;
            goto L26
        L50:
            return false;
        L46:
            return false;
        }
    }

    public static class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final g f439307a;

        public f(c r100) {
            this.f439307a = r100;
        }
    }

    public interface g {
    }

    public class h extends com.ss.android.lark.reaction.widget.detailwindow.scroller.f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f439308a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ScrollableLayout f439309b;

        public h(ScrollableLayout r100) {
            this.f439309b = r100;
            this.f439308a = ViewConfiguration.get(r100.getContext()).getScaledTouchSlop();
        }

        @Override // com.ss.android.lark.reaction.widget.detailwindow.scroller.f, android.view.GestureDetector.OnGestureListener
        public final boolean onScroll(MotionEvent r100, MotionEvent r101, float r102, float r103) {
            float r104 = Math.abs(r102);
            if (r104 <= Math.abs(r103)) goto L5;
            return false;
        L5:
            if (r104 > this.f439308a) goto L13;
            int r105 = this.f439309b.getScrollY();
            int r106 = (int) (r103 + 0.5f);
            ScrollableLayout r107 = this.f439309b;
            int r108 = ScrollableLayout.G;
            r107.getClass();
            this.f439309b.scrollTo(0, r106 + r105);
            if (r105 == this.f439309b.getScrollY()) goto L12;
            return true;
        L12:
            return false;
        L13:
            return false;
        }
    }

    public class i extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f439310a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ScrollableLayout f439311b;

        public i(ScrollableLayout r100) {
            this.f439311b = r100;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator r100) {
            ScrollableLayout r101 = this.f439311b;
            r101.f439281n = this.f439310a;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            ScrollableLayout r101 = this.f439311b;
            r101.f439281n = this.f439310a;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r100) {
            ScrollableLayout r101 = this.f439311b;
            this.f439310a = r101.f439281n;
            r101.f439281n = true;
        }
    }

    @Override // android.view.View
    public final boolean canScrollHorizontally(int r100) {
        return false;
    }

    public void setOverScrollListener(j r100) {
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        ValueAnimator r100 = this.f439279l;
        if (r100 != null) goto L5;
    L7:
        super.onDetachedFromWindow();
        return;
    L5:
        if (r100.isRunning() == false) goto L7;
        this.f439279l.cancel();
        goto L7
    }

    @Override // android.view.View
    public final void onFinishInflate() {
        super.onFinishInflate();
        if (this.f439293z == false) goto L5;
        d(true);
    L5:
        int r100 = this.C;
        if (r100 == 0) goto L9;
        View r101 = findViewById(r100);
    L12:
        this.D = r101;
        return;
    L9:
        if (getChildCount() <= 0) goto L11;
        r101 = getChildAt(0);
        goto L12
    L11:
        r101 = null;
        goto L12
    }

    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        ScrollableLayoutSavedState r100 = new ScrollableLayoutSavedState(super.onSaveInstanceState());
        r100.f439294a = getScrollY();
        r100.f439295b = this.f439293z;
        return r100;
    }

    @Override // android.view.View
    public final int computeVerticalScrollRange() {
        return this.f439274g;
    }

    public long getConsiderIdleMillis() {
        return this.f439288u;
    }

    public int getMaxScrollY() {
        return this.f439274g;
    }

    public ScrollableLayout(Context r100) {
        super(r100);
        this.f439268a = new Rect();
        this.f439269b = new ArrayList(3);
        this.E = new a(this);
        this.F = new b(this);
        c(r100, null);
    }

    public final int b(int r100) {
        int r101 = getScrollY();
        if (r101 != r100) goto L5;
        return -1;
    L5:
        int r102 = r100 - r101;
        boolean r103 = true;
        if (r102 >= 0) goto L8;
        boolean r104 = true;
    L9:
        com.ss.android.lark.reaction.widget.detailwindow.scroller.a r105 = this.f439273f;
        if (r105 == null) goto L35;
        if (r104 == false) goto L20;
        if (this.f439287t == true) goto L35;
        if (this.f439281n == true) goto L35;
        if (((n2c.h) r105).a(r102) == false) goto L35;
        return -1;
    L20:
        if (this.f439287t == true) goto L31;
        if (this.f439281n == true) goto L31;
        View r106 = this.D;
        if (r106 != null) goto L26;
    L28:
        r103 = false;
    L29:
        if (r103 == false) goto L31;
    L34:
        return -1;
    L26:
        if (r106.canScrollVertically(r102) == false) goto L28;
    L31:
        if (r101 != this.f439274g) goto L35;
        if (((n2c.h) this.f439273f).a(r102) == false) goto L34;
    L35:
        if (r100 >= 0) goto L37;
        return 0;
    L37:
        int r107 = this.f439274g;
        if (r100 > r107) goto L40;
        return r100;
    L40:
        return r107;
    L8:
        r104 = false;
        goto L9
    }

    @Override // android.view.View
    public final boolean canScrollVertically(int r100) {
        if (r100 < 0) goto L4;
    L5:
        if (r100 > 0) goto L7;
    L9:
        return false;
    L7:
        if (((n2c.h) this.f439273f).a(r100) == false) goto L9;
    L8:
        return true;
    L4:
        if (getScrollY() > 0) goto L8;
        goto L5
    }

    public final void d(boolean r100) {
        if (getChildCount() != 0) goto L5;
        return;
    L5:
        int r101 = this.B;
        if (r101 == 0) goto L8;
        View r102 = findViewById(r101);
    L9:
        if (r102 != null) goto L11;
        return;
    L11:
        if (r100 == true) goto L20;
        d r103 = this.A;
        if (r103 == null) goto L23;
        ViewTreeObserver r104 = r102.getViewTreeObserver();
        if (r104.isAlive() == false) goto L18;
        r104.removeOnGlobalLayoutListener(r103);
    L18:
        this.A = null;
        return;
    L23:
        return;
    L20:
        if (this.A != null) goto L25;
        this.A = new d(this, r102);
        r102.getViewTreeObserver().addOnGlobalLayoutListener(this.A);
        return;
    L25:
        return;
    L8:
        r102 = getChildAt(0);
        goto L9
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r100) {
        if (this.f439281n == false) goto L6;
        this.f439283p = false;
        this.f439287t = false;
        this.f439275h = false;
        this.f439276i = false;
        removeCallbacks(this.F);
        removeCallbacks(this.E);
        return super.dispatchTouchEvent(r100);
    L6:
        int r101 = r100.getActionMasked();
        if (r101 != 0) goto L14;
        this.f439283p = true;
        k r102 = this.f439270c;
        r102.f439326l = r102.f439320f;
        r102.f439327m = r102.f439321g;
        r102.f439331q = true;
        View r103 = this.f439286s;
        if (r103 != null) goto L11;
    L13:
        this.f439287t = false;
    L26:
        boolean r104 = this.f439275h;
        boolean r105 = this.f439276i;
        this.f439276i = this.f439272e.onTouchEvent(r100);
        this.f439275h = this.f439271d.onTouchEvent(r100);
        removeCallbacks(this.E);
        post(this.E);
        if (this.f439275h == false) goto L29;
    L32:
        boolean r106 = true;
    L33:
        if (r104 == true) goto L37;
        if (r105 == true) goto L37;
        boolean r107 = false;
    L39:
        if (r101 != 2) goto L45;
        if (r106 == true) goto L45;
        if (r107 == false) goto L45;
        if (getScrollY() != this.f439274g) goto L45;
        boolean r108 = true;
    L46:
        if (r106 == true) goto L48;
        if (r107 == true) goto L48;
    L51:
        if (r108 == false) goto L53;
        f r109 = this.f439277j;
        r109.getClass();
        int r110 = r100.getAction();
        r100.setAction(0);
        a(((c) r109.f439307a).f439301a, r100);
        r100.setAction(r110);
        this.f439290w = r100.getRawY();
        this.f439289v = true;
    L53:
        super.dispatchTouchEvent(r100);
        return true;
    L48:
        f r111 = this.f439277j;
        r111.getClass();
        int r112 = r100.getAction();
        r100.setAction(3);
        a(((c) r111.f439307a).f439301a, r100);
        r100.setAction(r112);
        if (r107 == true) goto L51;
        return true;
    L45:
        r108 = false;
    L37:
        r107 = true;
        goto L39
    L29:
        if (this.f439276i == true) goto L32;
        r106 = false;
        goto L33
    L11:
        if (r103.getGlobalVisibleRect(this.f439268a) == false) goto L13;
        int r113 = (int) (r100.getRawX() + 0.5f);
        int r114 = (int) (r100.getRawY() + 0.5f);
        this.f439287t = this.f439268a.contains(r113, r114);
        goto L26
    L14:
        if (r101 == 1) goto L16;
        if (r101 != 3) goto L26;
    L16:
        this.f439283p = false;
        if (this.f439278k == null) goto L20;
        removeCallbacks(this.F);
        postDelayed(this.F, this.f439288u);
    L20:
        if (this.f439289v == false) goto L26;
        if (r101 == 1) goto L23;
    L25:
        this.f439289v = false;
        goto L26
    L23:
        if (Float.compare(Math.abs(r100.getRawY() - this.f439290w), this.f439291x) >= 0) goto L25;
        r100.setAction(3);
        goto L25
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable r100) {
        if ((r100 instanceof ScrollableLayoutSavedState) == true) goto L6;
        super.onRestoreInstanceState(r100);
        return;
    L6:
        ScrollableLayoutSavedState r101 = (ScrollableLayoutSavedState) r100;
        super.onRestoreInstanceState(r101.getSuperState());
        setScrollY(r101.f439294a);
        boolean r102 = r101.f439295b;
        this.f439293z = r102;
        d(r102);
    }

    public void setAutoMaxScroll(boolean r100) {
        this.f439293z = r100;
        d(r100);
    }

    public void setCanScrollVerticallyDelegate(com.ss.android.lark.reaction.widget.detailwindow.scroller.a r100) {
        this.f439273f = r100;
    }

    public void setCloseAnimatorConfigurator(com.ss.android.lark.reaction.widget.detailwindow.scroller.c r100) {
        this.f439285r = r100;
    }

    public void setCloseUpAlgorithm(com.ss.android.lark.reaction.widget.detailwindow.scroller.b r100) {
        this.f439278k = r100;
    }

    public void setCloseUpIdleAnimationTime(com.ss.android.lark.reaction.widget.detailwindow.scroller.d r100) {
        this.f439284q = r100;
    }

    public void setConsiderIdleMillis(long r100) {
        this.f439288u = r100;
    }

    public void setDraggableView(View r100) {
        this.f439286s = r100;
    }

    public void setFriction(float r100) {
        k r101 = this.f439270c;
        r101.f439337w = (r101.f439316b * 386.0878f) * r100;
        r101.f439336v = r100;
    }

    public void setMaxScrollY(int r100) {
        this.f439274g = r100;
        d(false);
    }

    public void setOnFlingOverListener(com.ss.android.lark.reaction.widget.detailwindow.scroller.h r100) {
        this.f439292y = r100;
    }

    public void setOnScrollChangedListener(com.ss.android.lark.reaction.widget.detailwindow.scroller.i r100) {
        ((ArrayList) this.f439269b).clear();
        if (r100 == null) goto L6;
        ((ArrayList) this.f439269b).add(r100);
        return;
    }

    public void setSelfUpdateScroll(boolean r100) {
        this.f439281n = r100;
    }

    public ScrollableLayout(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.f439268a = new Rect();
        this.f439269b = new ArrayList(3);
        this.E = new a(this);
        this.F = new b(this);
        c(r100, r101);
    }

    public static /* synthetic */ void a(ScrollableLayout r100, MotionEvent r101) {
        super.dispatchTouchEvent(r101);
    }

    public final void c(Context r100, AttributeSet r101) {
        TypedArray r102 = r100.obtainStyledAttributes(r101, new int[]{R.attr.scrollable_autoMaxScroll, R.attr.scrollable_autoMaxScrollViewId, R.attr.scrollable_closeUpAnimationMillis, R.attr.scrollable_closeUpAnimatorInterpolator, R.attr.scrollable_considerIdleMillis, R.attr.scrollable_defaultCloseUp, R.attr.scrollable_friction, R.attr.scrollable_maxScroll, R.attr.scrollable_scrollerFlywheel, R.attr.scrollable_scrollingHeaderId, R.attr.tabs_marginTop});
        this.f439270c = new k(r100, r102.getBoolean(8, false));     // Catch: Throwable -> L19
        setFriction(r102.getFloat(6, 0.0565f));     // Catch: Throwable -> L19
        int r103 = r102.getDimensionPixelSize(7, 0);     // Catch: Throwable -> L19
        this.f439274g = r103;     // Catch: Throwable -> L19
        if (r103 != 0) goto L6;
        boolean r104 = true;
    L7:
        this.f439293z = r102.getBoolean(0, r104);     // Catch: Throwable -> L19
        this.B = r102.getResourceId(1, 0);     // Catch: Throwable -> L19
        setConsiderIdleMillis(r102.getInteger(4, 100));     // Catch: Throwable -> L19
        if (r102.getBoolean(5, false) == false) goto L10;
        setCloseUpAlgorithm(new com.ss.android.lark.reaction.widget.detailwindow.scroller.e());     // Catch: Throwable -> L19
    L10:
        int r105 = r102.getInteger(2, -1);     // Catch: Throwable -> L19
        if (r105 == (-1)) goto L13;
        setCloseUpIdleAnimationTime(new l(r105));     // Catch: Throwable -> L19
    L13:
        int r106 = r102.getResourceId(3, 0);     // Catch: Throwable -> L19
        if (r106 == 0) goto L16;
        setCloseAnimatorConfigurator(new com.ss.android.lark.reaction.widget.detailwindow.scroller.g(AnimationUtils.loadInterpolator(r100, r106)));     // Catch: Throwable -> L19
    L16:
        this.C = r102.getResourceId(9, 0);     // Catch: Throwable -> L19
        r102.recycle();
        this.f439271d = new GestureDetector(r100, new h(this));
        this.f439272e = new GestureDetector(r100, new e(this, r100));
        this.f439277j = new f(new c(this));
        this.f439291x = ViewConfiguration.get(r100).getScaledTouchSlop();
        return;
    L6:
        r104 = false;
    L19:
        th = move-exception;
        r102.recycle();
        throw th;
    }

    @Override // android.view.View
    public final void scrollTo(int r100, int r101) {
        int r102 = b(r101);
        if (r102 >= 0) goto L5;
        return;
    L5:
        super.scrollTo(0, r102);
    }

    public ScrollableLayout(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f439268a = new Rect();
        this.f439269b = new ArrayList(3);
        this.E = new a(this);
        this.F = new b(this);
        c(r100, r101);
    }

    @Override // android.view.View
    public final void onScrollChanged(int r100, int r101, int r102, int r103) {
        int r104 = 0;
        if (r101 == r103) goto L5;
        boolean r105 = true;
    L6:
        if (r105 == false) goto L8;
        int r106 = ((ArrayList) this.f439269b).size();
    L9:
        if (r106 <= 0) goto L13;
    L10:
        if (r104 >= r106) goto L13;
        ((com.ss.android.lark.reaction.widget.detailwindow.scroller.i) ListProtector.get(this.f439269b, r104)).a(r101, this.f439274g);
        r104 = r104 + 1;
    L13:
        if (this.f439278k == null) goto L20;
        removeCallbacks(this.F);
        if (this.f439281n == true) goto L20;
        if (r105 == false) goto L20;
        if (this.f439283p == true) goto L20;
        postDelayed(this.F, this.f439288u);
    L20:
        super.onScrollChanged(r100, r101, r102, r103);
        return;
    L8:
        r106 = 0;
        goto L9
    L5:
        r105 = false;
        goto L6
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r100, int r101, int r102, int r103, int r104) {
        int r105 = getChildCount();
        if (r105 <= 0) goto L7;
        int r106 = 0;
        int r107 = 0;
    L5:
        if (r106 >= r105) goto L9;
        View r108 = getChildAt(r106);
        r108.layout(r101, r107, r103, r108.getMeasuredHeight() + r107);
        r107 = r107 + r108.getMeasuredHeight();
        r106 = r106 + 1;
        goto L5
    L9:
        return;
    }
}
