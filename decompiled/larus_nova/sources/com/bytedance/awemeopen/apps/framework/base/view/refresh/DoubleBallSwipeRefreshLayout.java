package com.bytedance.awemeopen.apps.framework.base.view.refresh;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Transformation;
import android.widget.Scroller;
import androidx.camera.video.AudioStats;
import androidx.core.content.ContextCompat;
import androidx.core.view.MotionEventCompat;
import androidx.core.view.NestedScrollingChild;
import androidx.core.view.NestedScrollingChildHelper;
import androidx.core.view.NestedScrollingParent;
import androidx.core.view.NestedScrollingParentHelper;
import androidx.core.view.ViewCompat;
import com.bytedance.awemeopen.apps.framework.utils.n0;
import com.bytedance.awemeopen.servicesapi.context.AoHostService;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import java.util.Objects;

/* JADX INFO: loaded from: classes14.dex */
public class DoubleBallSwipeRefreshLayout extends ViewGroup implements NestedScrollingParent, NestedScrollingChild, i {
    public static final int[] L = null;
    public com.bytedance.awemeopen.apps.framework.base.view.refresh.e A;
    public boolean B;
    public int C;
    public final int D;
    public final int E;
    public h F;
    public boolean G;
    public final a H;
    public final c I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public final d f193298J;
    public final e K;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public View f193299a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public g f193300b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f193301c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f193302d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f193303e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f193304f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Scroller f193305g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f193306h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final NestedScrollingParentHelper f193307i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final NestedScrollingChildHelper f193308j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int[] f193309k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final int[] f193310l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f193311m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final int f193312n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public float f193313o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public float f193314p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public float f193315q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f193316r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f193317s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final DecelerateInterpolator f193318t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public DoubleColorBallAnimationView f193319u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final int f193320v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final int f193321w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public MaterialProgressDrawable f193322x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public com.bytedance.awemeopen.apps.framework.base.view.refresh.c f193323y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public com.bytedance.awemeopen.apps.framework.base.view.refresh.e f193324z;

    public class a implements Animation.AnimationListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DoubleBallSwipeRefreshLayout f193325a;

        @Override // android.view.animation.Animation.AnimationListener
        public final void onAnimationRepeat(Animation r100) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public final void onAnimationStart(Animation r100) {
        }

        public a(DoubleBallSwipeRefreshLayout r100) {
            this.f193325a = r100;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public final void onAnimationEnd(Animation r100) {
            DoubleBallSwipeRefreshLayout r101 = this.f193325a;
            if (r101.f193301c == false) goto L9;
            r101.K.b(false);
            MaterialProgressDrawable r102 = this.f193325a.f193322x;
            r102.f193384b.f193414u = 255;
            r102.start();
            DoubleBallSwipeRefreshLayout r103 = this.f193325a;
            if (r103.B == false) goto L11;
            g r104 = r103.f193300b;
            if (r104 == null) goto L12;
            r104.onRefresh();
            return;
        L12:
            return;
        L11:
            return;
        L9:
            r101.d();
        }
    }

    public class b implements Animation.AnimationListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DoubleBallSwipeRefreshLayout f193326a;

        @Override // android.view.animation.Animation.AnimationListener
        public final void onAnimationRepeat(Animation r100) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public final void onAnimationStart(Animation r100) {
        }

        public b(DoubleBallSwipeRefreshLayout r100) {
            this.f193326a = r100;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public final void onAnimationEnd(Animation r100) {
            this.f193326a.getClass();
            DoubleBallSwipeRefreshLayout r101 = this.f193326a;
            r101.getClass();
            com.bytedance.awemeopen.apps.framework.base.view.refresh.d r102 = new com.bytedance.awemeopen.apps.framework.base.view.refresh.d(r101);
            r101.getClass();
            r102.setDuration(150);
        }
    }

    public class c extends Animation {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DoubleBallSwipeRefreshLayout f193327a;

        public c(DoubleBallSwipeRefreshLayout r100) {
            this.f193327a = r100;
        }

        @Override // android.view.animation.Animation
        public final void applyTransformation(float r100, Transformation r101) {
            this.f193327a.getClass();
            DoubleBallSwipeRefreshLayout r102 = this.f193327a;
            int r103 = r102.f193321w;
            Math.abs(r102.f193320v);
            float r104 = 1.0f - r100;
            MaterialProgressDrawable.c r105 = this.f193327a.f193322x.f193384b;
            if (r104 == r105.f193410q) goto L6;
            r105.f193410q = r104;
            r105.a();
            return;
        }
    }

    public class d extends Animation {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DoubleBallSwipeRefreshLayout f193328a;

        public d(DoubleBallSwipeRefreshLayout r100) {
            this.f193328a = r100;
        }

        @Override // android.view.animation.Animation
        public final void applyTransformation(float r100, Transformation r101) {
            this.f193328a.getClass();
        }
    }

    public class e extends t {
        @Override // com.bytedance.awemeopen.apps.framework.base.view.refresh.t
        public final void a() {
        }

        public e() {
        }
    }

    public interface f {
    }

    public interface g {
        void onRefresh();
    }

    public interface h {
        void onOverScroll(float r100, float r101);

        void onRefreshFinish();

        void onRefreshStartManually();

        void onReleaseAndRefresh();

        void onReleaseAndScrollBack();
    }

    public void setAnimationProgress(float r100) {
    }

    public void setColorScheme(int... r100) {
    }

    public void setOnChildScrollUpCallback(f r100) {
    }

    static {
        n0.a(((AoHostService) j64.a.a(AoHostService.class)).getHostApplication(), 16.0f);
        n0.a(((AoHostService) j64.a.a(AoHostService.class)).getHostApplication(), 20.0f);
        L = new int[]{R.attr.enabled};
    }

    public final void a() {
        if (this.f193299a != null) goto L11;
        int r100 = 0;
    L6:
        if (r100 >= getChildCount()) goto L15;
        View r101 = getChildAt(r100);
        if (r101.equals(this.f193319u) == false) goto L9;
        r100 = r100 + 1;
        goto L6
    L9:
        this.f193299a = r101;
        return;
    L15:
        return;
    }

    @Override // android.view.View
    public final void computeScroll() {
        if (this.f193305g.computeScrollOffset() == false) goto L6;
        scrollTo(this.f193305g.getCurrX(), this.f193305g.getCurrY());
        invalidate();
        return;
    }

    public final void d() {
        this.K.b(true);
        this.f193322x.stop();
        setColorViewAlpha(255);
    }

    @Override // android.view.ViewGroup, androidx.core.view.NestedScrollingParent
    public int getNestedScrollAxes() {
        return this.f193307i.getNestedScrollAxes();
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public final boolean hasNestedScrollingParent() {
        return this.f193308j.hasNestedScrollingParent();
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public final boolean isNestedScrollingEnabled() {
        return this.f193308j.isNestedScrollingEnabled();
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public final void stopNestedScroll() {
        this.f193308j.stopNestedScroll();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        d();
    }

    public int getProgressCircleDiameter() {
        return this.C;
    }

    public int getProgressViewEndOffset() {
        return this.f193321w;
    }

    public int getProgressViewStartOffset() {
        return this.f193320v;
    }

    @Override // com.bytedance.awemeopen.apps.framework.base.view.refresh.i
    public final boolean isRefreshing() {
        return this.f193301c;
    }

    public DoubleBallSwipeRefreshLayout(Context r100) {
        this(r100, null);
    }

    private void setColorViewAlpha(int r100) {
        this.f193322x.f193384b.f193414u = r100;
    }

    public final void b(float r100) {
        if (r100 <= this.f193303e) goto L5;
        e(true, true);
        return;
    L5:
        this.f193301c = false;
        MaterialProgressDrawable r101 = this.f193322x;
        MaterialProgressDrawable.c r102 = r101.f193384b;
        r102.f193398e = 0.0f;
        r102.a();
        MaterialProgressDrawable.c r103 = r101.f193384b;
        r103.f193399f = 0.0f;
        r103.a();
        b r104 = new b(this);
        e r105 = this.K;
        r105.getClass();
        s r106 = new s(r105, r104);
        e r107 = this.K;
        r107.getClass();
        Objects.toString(r106);
        r107.b(false);
        this.f193298J.reset();
        this.f193298J.setDuration(200);
        this.f193298J.setInterpolator(this.f193318t);
        r106.onAnimationEnd(this.I);
        MaterialProgressDrawable.c r108 = this.f193322x.f193384b;
        if (r108.f193408o == false) goto L8;
        r108.f193408o = false;
        r108.a();
    L8:
        h r109 = this.F;
        if (r109 != null) goto L11;
        this.f193305g.startScroll(0, getScrollY(), 0, -getScrollY(), Math.abs(getScrollY() * 2));
        invalidate();
        this.f193319u.d();
        return;
    L11:
        r109.onReleaseAndScrollBack();
    }

    public final void c(float r110) {
        MaterialProgressDrawable.c r100 = this.f193322x.f193384b;
        boolean r101 = true;
        if (r100.f193408o == true) goto L5;
        r100.f193408o = true;
        r100.a();
    L5:
        float r102 = r110 / this.f193303e;
        float r103 = (((float) Math.max(((double) Math.min(1.0f, Math.abs(r102))) - 0.4d, AudioStats.AUDIO_AMPLITUDE_NONE)) * 5.0f) / 3.0f;
        float r104 = Math.abs(r110) - this.f193303e;
        float r105 = this.f193321w;
        double r106 = Math.max(0.0f, Math.min(r104, r105 * 2.0f) / r105) / 4.0f;
        float r107 = ((float) (r106 - Math.pow(r106, 2.0d))) * 2.0f;
        if (r110 >= this.f193303e) goto L20;
        if (this.f193322x.f193384b.f193414u <= 76) goto L31;
        com.bytedance.awemeopen.apps.framework.base.view.refresh.e r108 = this.f193324z;
        if (r108 != null) goto L12;
    L16:
        r101 = false;
    L17:
        if (r101 == true) goto L31;
        com.bytedance.awemeopen.apps.framework.base.view.refresh.e r109 = new com.bytedance.awemeopen.apps.framework.base.view.refresh.e(this, this.f193322x.f193384b.f193414u, 76);
        r109.setDuration(300);
        this.f193324z = r109;
        goto L31
    L12:
        if (r108.hasStarted() == false) goto L16;
        if (r108.hasEnded() == true) goto L16;
    L31:
        h r111 = this.F;
        if (r111 != null) goto L34;
        float r112 = (float) Math.atan(r102);
        scrollTo(0, (int) ((-this.f193303e) * r112));
        this.f193319u.setProgress(Math.max(0.0f, Math.min(1.0f, r112 - 0.5f)));
    L35:
        MaterialProgressDrawable r113 = this.f193322x;
        float r114 = Math.min(0.8f, r103 * 0.8f);
        MaterialProgressDrawable.c r115 = r113.f193384b;
        r115.f193398e = 0.0f;
        r115.a();
        MaterialProgressDrawable.c r116 = r113.f193384b;
        r116.f193399f = r114;
        r116.a();
        MaterialProgressDrawable r117 = this.f193322x;
        float r118 = Math.min(1.0f, r103);
        MaterialProgressDrawable.c r119 = r117.f193384b;
        if (r118 == r119.f193410q) goto L38;
        r119.f193410q = r118;
        r119.a();
    L38:
        MaterialProgressDrawable.c r120 = this.f193322x.f193384b;
        r120.f193400g = (((r103 * 0.4f) - 0.25f) + (r107 * 2.0f)) * 0.5f;
        r120.a();
        e r121 = this.K;
        r121.getClass();
        r121.b(false);
        return;
    L34:
        r111.onOverScroll(Math.min(r110, this.f193303e), Math.min(r102, 1.0f));
        goto L35
    L20:
        if (this.f193322x.f193384b.f193414u >= 255) goto L31;
        com.bytedance.awemeopen.apps.framework.base.view.refresh.e r122 = this.A;
        if (r122 != null) goto L24;
    L28:
        r101 = false;
    L29:
        if (r101 == true) goto L31;
        com.bytedance.awemeopen.apps.framework.base.view.refresh.e r123 = new com.bytedance.awemeopen.apps.framework.base.view.refresh.e(this, this.f193322x.f193384b.f193414u, 255);
        r123.setDuration(300);
        this.A = r123;
        goto L31
    L24:
        if (r122.hasStarted() == false) goto L28;
        if (r122.hasEnded() == true) goto L28;
        goto L28
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent r100) {
        a();
        int r101 = MotionEventCompat.getActionMasked(r100);
        int r102 = 0;
        if (isEnabled() == true) goto L5;
    L40:
        return false;
    L5:
        if (ViewCompat.canScrollVertically(this.f193299a, -1) == true) goto L40;
        if (this.f193301c == true) goto L40;
        if (this.f193311m == true) goto L40;
        if (r101 != 0) goto L13;
        int r103 = r100.getPointerId(0);
        this.f193317s = r103;
        this.f193316r = false;
        int r104 = r100.findPointerIndex(r103);
        if (r104 >= 0) goto L37;
        return false;
    L37:
        this.f193314p = r100.getY(r104);
        this.f193315q = r100.getX(r104);
    L39:
        return this.f193316r;
    L13:
        if (r101 != 1) goto L15;
    L33:
        this.f193316r = false;
        this.f193317s = -1;
        goto L39
    L15:
        if (r101 != 2) goto L17;
        int r105 = this.f193317s;
        if (r105 != (-1)) goto L29;
        return false;
    L29:
        int r106 = r100.findPointerIndex(r105);
        if (r106 >= 0) goto L32;
        return false;
    L32:
        f(r100.getX(r106), r100.getY(r106));
        goto L39
    L17:
        if (r101 == 3) goto L33;
        if (r101 != 6) goto L39;
        int r107 = MotionEventCompat.getActionIndex(r100);
        if (r100.getPointerId(r107) != this.f193317s) goto L39;
        if (r107 != 0) goto L25;
        r102 = 1;
    L25:
        this.f193317s = r100.getPointerId(r102);
        goto L39
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public final void onStopNestedScroll(View r100) {
        this.f193307i.onStopNestedScroll(r100);
        this.f193311m = false;
        float r101 = this.f193306h;
        if (r101 <= 0.0f) goto L5;
        b(r101);
        this.f193306h = 0.0f;
    L5:
        stopNestedScroll();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent r100) {
        int r101 = MotionEventCompat.getActionMasked(r100);
        int r102 = 0;
        if (isEnabled() == true) goto L5;
    L53:
        return false;
    L5:
        if (ViewCompat.canScrollVertically(this.f193299a, -1) == true) goto L53;
        if (this.f193301c == true) goto L53;
        if (this.f193311m == true) goto L53;
        if (r101 != 0) goto L14;
        this.f193317s = r100.getPointerId(0);
        this.f193316r = false;
    L52:
        return true;
    L14:
        if (r101 != 1) goto L16;
    L43:
        int r103 = r100.findPointerIndex(this.f193317s);
        if (r103 >= 0) goto L47;
        return false;
    L47:
        if (this.f193316r == false) goto L49;
        float r104 = (r100.getY(r103) - this.f193313o) * 0.5f;
        this.f193316r = false;
        b(r104);
    L49:
        this.f193317s = -1;
        return false;
    L16:
        if (r101 != 2) goto L18;
        int r105 = r100.findPointerIndex(this.f193317s);
        if (r105 >= 0) goto L36;
        return false;
    L36:
        float r106 = r100.getX(r105);
        float r107 = r100.getY(r105);
        f(r106, r107);
        if (this.f193316r == false) goto L52;
        float r108 = (r107 - this.f193313o) * 0.5f;
        if (r108 <= 0.0f) goto L41;
        c(r108);
        goto L52
    L41:
        c(0.0f);
        return false;
    L18:
        if (r101 == 3) goto L43;
        if (r101 != 5) goto L22;
        int r109 = MotionEventCompat.getActionIndex(r100);
        if (r109 >= 0) goto L32;
        return false;
    L32:
        this.f193317s = r100.getPointerId(r109);
        goto L52
    L22:
        if (r101 != 6) goto L52;
        int r110 = MotionEventCompat.getActionIndex(r100);
        if (r100.getPointerId(r110) != this.f193317s) goto L52;
        if (r110 != 0) goto L28;
        r102 = 1;
    L28:
        this.f193317s = r100.getPointerId(r102);
        goto L52
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void requestDisallowInterceptTouchEvent(boolean r100) {
        super.requestDisallowInterceptTouchEvent(r100);
    }

    public void setColorSchemeColors(int... r100) {
        a();
        MaterialProgressDrawable.c r101 = this.f193322x.f193384b;
        r101.f193403j = r100;
        r101.f193404k = 0;
        r101.f193404k = 0;
    }

    public void setColorSchemeResources(int... r100) {
        Context r101 = getContext();
        int[] r102 = new int[r100.length];
        int r103 = 0;
    L4:
        if (r103 >= r100.length) goto L6;
        r102[r103] = ContextCompat.getColor(r101, r100[r103]);
        r103 = r103 + 1;
        goto L4
    L6:
        setColorSchemeColors(r102);
    }

    public void setDistanceToTriggerSync(int r100) {
        this.f193303e = r100;
    }

    public void setDoNotCatchException(boolean r100) {
        this.f193304f = r100;
    }

    public void setEnableDeltaX(boolean r100) {
        this.G = r100;
    }

    @Override // android.view.View
    public void setEnabled(boolean r100) {
        super.setEnabled(r100);
        if (r100 == true) goto L6;
        d();
        return;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public void setNestedScrollingEnabled(boolean r100) {
        this.f193308j.setNestedScrollingEnabled(r100);
    }

    public void setOnRefreshListener(g r100) {
        this.f193300b = r100;
    }

    public void setOnSwipeChangeListener(h r100) {
        this.F = r100;
    }

    public void setProgressBackgroundColor(int r100) {
        setProgressBackgroundColorSchemeResource(r100);
    }

    public void setProgressBackgroundColorSchemeColor(int r100) {
        this.f193322x.f193384b.f193416w = r100;
    }

    public void setProgressBackgroundColorSchemeResource(int r100) {
        setProgressBackgroundColorSchemeColor(ContextCompat.getColor(getContext(), r100));
    }

    public void setRefreshing(boolean r100) {
        if (r100 == true) goto L5;
    L13:
        e(r100, false);
        return;
    L5:
        if (this.f193301c == r100) goto L13;
        this.f193301c = r100;
        this.B = false;
        h r101 = this.F;
        if (r101 == null) goto L9;
        r101.onRefreshStartManually();
        return;
    L9:
        a r102 = this.H;
        this.f193322x.f193384b.f193414u = 255;
        com.bytedance.awemeopen.apps.framework.base.view.refresh.c r103 = new com.bytedance.awemeopen.apps.framework.base.view.refresh.c(this);
        this.f193323y = r103;
        r103.setDuration(this.f193312n);
        if (r102 == null) goto L12;
        r102.onAnimationEnd(this.f193323y);
    L12:
        this.f193319u.c();
        this.f193305g.startScroll(0, getScrollY(), 0, (int) (-this.f193303e));
    }

    public void setSize(int r100) {
        if (r100 != 0) goto L4;
    L6:
        Resources r101 = getResources();
        DisplayMetrics r102 = WindowDisplayMetricsOverride.apply(r101, r101.getDisplayMetrics());
        if (r100 != 0) goto L9;
        this.C = (int) (r102.density * 56.0f);
    L10:
        this.f193322x.b(r100);
        return;
    L9:
        this.C = (int) (r102.density * 40.0f);
        goto L10
    L4:
        if (r100 == 1) goto L6;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public final boolean startNestedScroll(int r100) {
        return this.f193308j.startNestedScroll(r100);
    }

    public DoubleBallSwipeRefreshLayout(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.f193301c = false;
        this.f193303e = -1.0f;
        this.f193304f = true;
        this.f193309k = new int[2];
        this.f193310l = new int[2];
        this.f193317s = -1;
        this.G = false;
        this.H = new a(this);
        this.I = new c(this);
        this.f193298J = new d(this);
        this.K = new e();
        this.f193302d = ViewConfiguration.get(r100).getScaledTouchSlop();
        this.f193305g = new Scroller(r100, new AccelerateDecelerateInterpolator());
        this.f193312n = getResources().getInteger(R.integer.config_mediumAnimTime);
        setWillNotDraw(false);
        this.f193318t = new DecelerateInterpolator(2.0f);
        Resources r102 = getResources();
        DisplayMetrics r103 = WindowDisplayMetricsOverride.apply(r102, r102.getDisplayMetrics());
        float r104 = r103.density;
        this.C = (int) (40.0f * r104);
        this.D = (int) (r104 * 56.0f);
        this.E = (int) (r104 * 32.0f);
        MaterialProgressDrawable r105 = new MaterialProgressDrawable(getContext(), this);
        this.f193322x = r105;
        r105.f193384b.f193416w = -328966;
        ViewCompat.setChildrenDrawingOrderEnabled(this, true);
        int r106 = (int) (r103.density * 56.0f);
        this.f193321w = r106;
        this.f193303e = r106;
        this.f193307i = new NestedScrollingParentHelper(this);
        this.f193308j = new NestedScrollingChildHelper(this);
        setNestedScrollingEnabled(true);
        this.f193320v = -this.C;
        TypedArray r107 = r100.obtainStyledAttributes(r101, L);
        setEnabled(r107.getBoolean(0, true));
        r107.recycle();
        DoubleColorBallAnimationView r108 = new DoubleColorBallAnimationView(getContext());
        this.f193319u = r108;
        addView(r108);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public final boolean dispatchNestedPreFling(float r100, float r101) {
        return this.f193308j.dispatchNestedPreFling(r100, r101);
    }

    public final void e(boolean r100, boolean r101) {
        this.K.getClass();
        if (this.f193301c == r100) goto L17;
        this.B = r101;
        a();
        this.f193301c = r100;
        if (r100 == false) goto L12;
        a r102 = this.H;
        e r103 = this.K;
        r103.getClass();
        Objects.toString(r102);
        r103.b(false);
        this.I.reset();
        this.I.setDuration(200);
        this.I.setInterpolator(this.f193318t);
        h r104 = this.F;
        if (r104 != null) goto L9;
        this.f193319u.setCycleBias(1);
        this.f193319u.c();
        this.f193305g.startScroll(0, getScrollY(), 0, (-getScrollY()) - this.D, Math.abs(((-getScrollY()) - this.D) * 2));
        invalidate();
    L10:
        if (r102 == null) goto L18;
        r102.onAnimationEnd(this.I);
        return;
    L18:
        return;
    L9:
        r104.onReleaseAndRefresh();
        goto L10
    L12:
        h r105 = this.F;
        if (r105 != null) goto L15;
        this.f193305g.forceFinished(true);
        this.f193305g.startScroll(0, getScrollY(), 0, -getScrollY(), Math.abs(getScrollY() * 2));
        invalidate();
        this.f193319u.d();
        return;
    L15:
        r105.onRefreshFinish();
        return;
    }

    public final void f(float r100, float r101) {
        float r102 = r101 - this.f193314p;
        float r103 = Math.abs(r100 - this.f193315q);
        if (this.G == true) goto L5;
    L8:
        boolean r104 = true;
    L9:
        int r105 = this.f193302d;
        if (r102 > r105) goto L12;
        return;
    L12:
        if (this.f193316r == true) goto L17;
        if (r104 == false) goto L18;
        this.f193313o = this.f193314p + r105;
        this.f193316r = true;
        this.f193322x.f193384b.f193414u = 76;
        return;
    L18:
        return;
    L17:
        return;
    L5:
        if ((r103 / r102) < 1.0f) goto L8;
        r104 = false;
        goto L9
    }

    @Override // android.view.View
    public final void onMeasure(int r100, int r101) {
        super.onMeasure(r100, r101);
        if (this.f193299a != null) goto L5;
        a();
    L5:
        View r102 = this.f193299a;
        if (r102 != null) goto L17;
        return;
    L17:
        r102.measure(View.MeasureSpec.makeMeasureSpec((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), 1073741824), View.MeasureSpec.makeMeasureSpec((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), 1073741824));     // Catch: IllegalStateException -> L11
    L14:
        this.f193319u.measure(View.MeasureSpec.makeMeasureSpec(this.E, 1073741824), View.MeasureSpec.makeMeasureSpec(this.E, 1073741824));
        return;
    L11:
        e = move-exception;
        if (this.f193304f == false) goto L14;
        throw e;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public final boolean dispatchNestedFling(float r100, float r101, boolean r102) {
        return this.f193308j.dispatchNestedFling(r100, r101, r102);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public final boolean onNestedPreFling(View r100, float r101, float r102) {
        return dispatchNestedPreFling(r101, r102);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public final void onNestedScrollAccepted(View r100, View r101, int r102) {
        this.f193307i.onNestedScrollAccepted(r100, r101, r102);
        startNestedScroll(r102 & 2);
        this.f193306h = 0.0f;
        this.f193311m = true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public final boolean onStartNestedScroll(View r100, View r101, int r102) {
        if (isEnabled() == true) goto L5;
    L9:
        return false;
    L5:
        if (this.f193301c == true) goto L9;
        if ((r102 & 2) == 0) goto L9;
        return true;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public final boolean dispatchNestedPreScroll(int r100, int r101, int[] r102, int[] r103) {
        return this.f193308j.dispatchNestedPreScroll(r100, r101, r102, r103);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public final boolean onNestedFling(View r100, float r101, float r102, boolean r103) {
        return dispatchNestedFling(r101, r102, r103);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public final void onNestedPreScroll(View r100, int r101, int r102, int[] r103) {
        if (r102 <= 0) goto L11;
        float r104 = this.f193306h;
        if (r104 <= 0.0f) goto L11;
        float r105 = r102;
        if (r105 <= r104) goto L9;
        r103[1] = r102 - ((int) r104);
        this.f193306h = 0.0f;
    L10:
        c(this.f193306h);
        goto L11
    L9:
        this.f193306h = r104 - r105;
        r103[1] = r102;
    L11:
        int[] r106 = this.f193309k;
        if (dispatchNestedPreScroll(r101 - r103[0], r102 - r103[1], r106, null) == false) goto L15;
        r103[0] = r103[0] + r106[0];
        r103[1] = r103[1] + r106[1];
        return;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public final boolean dispatchNestedScroll(int r100, int r101, int r102, int r110, int[] r111) {
        return this.f193308j.dispatchNestedScroll(r100, r101, r102, r110, r111);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r100, int r101, int r102, int r103, int r104) {
        int r105 = getMeasuredWidth();
        int r106 = getMeasuredHeight();
        if (getChildCount() != 0) goto L6;
        return;
    L6:
        if (this.f193299a != null) goto L8;
        a();
    L8:
        View r107 = this.f193299a;
        if (r107 != null) goto L11;
        return;
    L11:
        int r108 = getPaddingLeft();
        int r109 = getPaddingTop();
        int r110 = (r105 - getPaddingLeft()) - getPaddingRight();
        r107.layout(r108, r109, r110 + r108, ((r106 - getPaddingTop()) - getPaddingBottom()) + r109);     // Catch: Exception -> L14
    L17:
        int r111 = this.f193319u.getMeasuredWidth();
        int r112 = this.f193319u.getMeasuredHeight();
        int r113 = (r105 - r111) / 2;
        int r114 = (this.D + r112) / 2;
        this.f193319u.layout(r113, -r114, r111 + r113, 0);
        return;
    L14:
        e = move-exception;
        if (this.f193304f == false) goto L17;
        throw e;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public final void onNestedScroll(View r100, int r101, int r102, int r110, int r111) {
        dispatchNestedScroll(r101, r102, r110, r111, this.f193310l);
        int r112 = r111 + this.f193310l[1];
        if (r112 < 0) goto L5;
        return;
    L5:
        if (ViewCompat.canScrollVertically(this.f193299a, -1) == true) goto L9;
        float r103 = this.f193306h + Math.abs(r112);
        this.f193306h = r103;
        c(r103);
        return;
    }
}
