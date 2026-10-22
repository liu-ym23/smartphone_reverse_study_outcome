package com.bytedance.awemeopen.apps.framework.feed.follow;

import android.R;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.SoundEffectConstants;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.Interpolator;
import android.widget.EdgeEffect;
import android.widget.Scroller;
import androidx.camera.video.AudioStats;
import androidx.core.content.ContextCompat;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.customview.view.AbsSavedState;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.bytedance.awemeopen.infra.base.env.AoEnv;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* JADX INFO: loaded from: classes14.dex */
public class DmtViewPager extends ViewGroup {
    public static final int[] V0 = null;

    /* JADX INFO: renamed from: b1, reason: collision with root package name */
    public static final a f194662b1 = null;

    /* JADX INFO: renamed from: g1, reason: collision with root package name */
    public static final b f194663g1 = null;
    public boolean A;
    public boolean B;
    public int C;
    public boolean D;
    public boolean E;
    public int F;
    public int G;
    public int H;
    public final c H0;
    public float I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public float f194664J;
    public float K;
    public float L;
    public int L0;
    public int M;
    public VelocityTracker N;
    public int O;
    public int P;
    public int P0;
    public int Q;
    public int R;
    public EdgeEffect S;
    public EdgeEffect T;
    public boolean U;
    public boolean V;
    public int W;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f194665a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f194666b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f194667c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f194668d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public double f194669e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public double f194670f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f194671g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final ArrayList<e> f194672h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final e f194673i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Rect f194674j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public PagerAdapter f194675k;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public List<ViewPager.OnPageChangeListener> f194676k0;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f194677l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f194678m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public Parcelable f194679n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public ClassLoader f194680o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public Scroller f194681p;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    public ViewPager.OnPageChangeListener f194682p0;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f194683q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public g f194684r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f194685s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public Drawable f194686t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f194687u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f194688v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public float f194689w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public float f194690x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f194691y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public boolean f194692z;

    @Target({ElementType.TYPE})
    @Inherited
    @Retention(RetentionPolicy.RUNTIME)
    public @interface DecorView {
    }

    public static class LayoutParams extends ViewGroup.LayoutParams {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f194693a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f194694b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public float f194695c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f194696d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f194697e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f194698f;

        public LayoutParams() {
            super(-1, -1);
            this.f194695c = 0.0f;
        }

        public LayoutParams(Context r100, AttributeSet r101) {
            super(r100, r101);
            this.f194695c = 0.0f;
            TypedArray r102 = r100.obtainStyledAttributes(r101, DmtViewPager.V0);
            this.f194694b = r102.getInteger(0, 48);
            r102.recycle();
        }
    }

    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f194699a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Parcelable f194700b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final ClassLoader f194701c;

        public static class a implements Parcelable.ClassLoaderCreator<SavedState> {
            public a() {
            }

            @Override // android.os.Parcelable.Creator
            public final Object createFromParcel(Parcel r100) {
                return new SavedState(r100, null);
            }

            @Override // android.os.Parcelable.Creator
            public final Object[] newArray(int r100) {
                return new SavedState[r100];
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            public final SavedState createFromParcel(Parcel r100, ClassLoader r101) {
                return new SavedState(r100, r101);
            }
        }

        static {
            CREATOR = new a();
        }

        public final String toString() {
            return "FragmentPager.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " position=" + this.f194699a + com.alipay.sdk.m.u.i.f25855d;
        }

        public SavedState(Parcelable r100) {
            super(r100);
        }

        public SavedState(Parcel r100, ClassLoader r101) {
            super(r100, r101);
            if (r101 != null) goto L5;
            r101 = getClass().getClassLoader();
        L5:
            this.f194699a = r100.readInt();
            this.f194700b = r100.readParcelable(r101);
            this.f194701c = r101;
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public final void writeToParcel(Parcel r100, int r101) {
            super.writeToParcel(r100, r101);
            r100.writeInt(this.f194699a);
            r100.writeParcelable(this.f194700b, r101);
        }
    }

    public static class a implements Comparator<e> {
        public a() {
        }

        @Override // java.util.Comparator
        public final int compare(e r100, e r101) {
            return r100.f194706b - r101.f194706b;
        }
    }

    public static class b implements Interpolator {
        public b() {
        }

        @Override // android.animation.TimeInterpolator
        public final float getInterpolation(float r100) {
            float r101 = r100 - 1.0f;
            return ((((r101 * r101) * r101) * r101) * r101) + 1.0f;
        }
    }

    public class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DmtViewPager f194702a;

        @Override // java.lang.Runnable
        public final void run() {
            this.f194702a.setScrollState(0);     // Catch: Throwable -> L4
            this.f194702a.v();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public c(DmtViewPager r100) {
            this.f194702a = r100;
        }
    }

    public class d implements OnApplyWindowInsetsListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Rect f194703a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ DmtViewPager f194704b;

        public d(DmtViewPager r100) {
            this.f194704b = r100;
            this.f194703a = new Rect();
        }

        @Override // androidx.core.view.OnApplyWindowInsetsListener
        public final WindowInsetsCompat onApplyWindowInsets(View r100, WindowInsetsCompat r101) {
            WindowInsetsCompat r102 = ViewCompat.onApplyWindowInsets(r100, r101);
            if (r102.isConsumed() == false) goto L5;
            return r102;
        L5:
            Rect r103 = this.f194703a;
            r103.left = r102.getSystemWindowInsetLeft();
            r103.top = r102.getSystemWindowInsetTop();
            r103.right = r102.getSystemWindowInsetRight();
            r103.bottom = r102.getSystemWindowInsetBottom();
            int r104 = this.f194704b.getChildCount();
            int r105 = 0;
        L6:
            if (r105 >= r104) goto L9;
            WindowInsetsCompat r106 = ViewCompat.dispatchApplyWindowInsets(this.f194704b.getChildAt(r105), r102);
            r103.left = Math.min(r106.getSystemWindowInsetLeft(), r103.left);
            r103.top = Math.min(r106.getSystemWindowInsetTop(), r103.top);
            r103.right = Math.min(r106.getSystemWindowInsetRight(), r103.right);
            r103.bottom = Math.min(r106.getSystemWindowInsetBottom(), r103.bottom);
            r105 = r105 + 1;
            goto L6
        L9:
            return r102.replaceSystemWindowInsets(r103.left, r103.top, r103.right, r103.bottom);
        }
    }

    public static class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f194705a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f194706b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f194707c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public float f194708d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public float f194709e;

        public e() {
        }
    }

    public class f extends AccessibilityDelegateCompat {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DmtViewPager f194710a;

        public f(DmtViewPager r100) {
            this.f194710a = r100;
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public final void onInitializeAccessibilityEvent(View r100, AccessibilityEvent r101) {
            super.onInitializeAccessibilityEvent(r100, r101);
            r101.setClassName(f.class.getName());
            PagerAdapter r102 = this.f194710a.f194675k;
            if (r102 == null) goto L7;
            boolean r103 = true;
            if (r102.getCount() <= 1) goto L7;
        L8:
            r101.setScrollable(r103);
            if (r101.getEventType() != 4096) goto L14;
            PagerAdapter r104 = this.f194710a.f194675k;
            if (r104 == null) goto L15;
            r101.setItemCount(r104.getCount());
            r101.setFromIndex(this.f194710a.f194677l);
            r101.setToIndex(this.f194710a.f194677l);
            return;
        L15:
            return;
        L14:
            return;
        L7:
            r103 = false;
            goto L8
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public final void onInitializeAccessibilityNodeInfo(View r100, AccessibilityNodeInfoCompat r101) {
            super.onInitializeAccessibilityNodeInfo(r100, r101);
            r101.setClassName(f.class.getName());
            PagerAdapter r102 = this.f194710a.f194675k;
            if (r102 != null) goto L5;
        L7:
            boolean r103 = false;
        L8:
            r101.setScrollable(r103);
            if (this.f194710a.canScrollHorizontally(1) == false) goto L12;
            r101.addAction(4096);
        L12:
            if (this.f194710a.canScrollHorizontally(-1) == false) goto L15;
            r101.addAction(8192);
            return;
        L15:
            return;
        L5:
            if (r102.getCount() <= 1) goto L7;
            r103 = true;
            goto L8
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public final boolean performAccessibilityAction(View r100, int r101, Bundle r102) {
            if (super.performAccessibilityAction(r100, r101, r102) == false) goto L6;
            return true;
        L6:
            if (r101 == 4096) goto L16;
            if (r101 == 8192) goto L11;
            return false;
        L11:
            if (this.f194710a.canScrollHorizontally(-1) == false) goto L14;
            DmtViewPager r103 = this.f194710a;
            r103.setCurrentItem(r103.f194677l - 1);
            return true;
        L14:
            return false;
        L16:
            if (this.f194710a.canScrollHorizontally(1) == false) goto L19;
            DmtViewPager r104 = this.f194710a;
            r104.setCurrentItem(r104.f194677l + 1);
            return true;
        L19:
            return false;
        }
    }

    public class g extends DataSetObserver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DmtViewPager f194711a;

        @Override // android.database.DataSetObserver
        public final void onChanged() {
            this.f194711a.g();
        }

        @Override // android.database.DataSetObserver
        public final void onInvalidated() {
            this.f194711a.g();
        }

        public g(DmtViewPager r100) {
            this.f194711a = r100;
        }
    }

    static {
        V0 = new int[]{R.attr.layout_gravity};
        f194662b1 = new a();
        f194663g1 = new b();
    }

    @Override // android.view.View
    public final void computeScroll() {
        this.f194683q = true;
        if (this.f194681p.isFinished() == false) goto L5;
    L14:
        f(true);
        return;
    L5:
        if (this.f194681p.computeScrollOffset() == false) goto L14;
        int r100 = getScrollX();
        int r101 = getScrollY();
        int r102 = this.f194681p.getCurrX();
        int r103 = this.f194681p.getCurrY();
        if (r100 != r102) goto L9;
        if (r101 != r103) goto L9;
    L12:
        ViewCompat.postInvalidateOnAnimation(this);
        return;
    L9:
        scrollTo(r102, r103);
        if (t(r102) == true) goto L12;
        this.f194681p.abortAnimation();
        scrollTo(0, r103);
        goto L12
    }

    public void d(View r100) {
    }

    public int getCurrentDragLeftBoundPosition() {
        return 0;
    }

    public final void m() {
        setWillNotDraw(false);
        setDescendantFocusability(262144);
        setFocusable(true);
        Context r100 = getContext();
        this.f194681p = new Scroller(r100, f194663g1);
        ViewConfiguration r101 = ViewConfiguration.get(r100);
        Resources r102 = r100.getResources();
        float r103 = WindowDisplayMetricsOverride.apply(r102, r102.getDisplayMetrics()).density;
        this.H = r101.getScaledPagingTouchSlop();
        this.O = (int) (400.0f * r103);
        this.P = r101.getScaledMaximumFlingVelocity();
        this.S = new EdgeEffect(r100);
        this.T = new EdgeEffect(r100);
        this.Q = (int) (25.0f * r103);
        this.R = (int) (2.0f * r103);
        this.F = (int) (r103 * 16.0f);
        ViewCompat.setAccessibilityDelegate(this, new f(this));
        if (ViewCompat.getImportantForAccessibility(this) != 0) goto L5;
        ViewCompat.setImportantForAccessibility(this, 1);
    L5:
        ViewCompat.setOnApplyWindowInsetsListener(this, new d(this));
        if (r100.getResources() != null) goto L8;
        return;
    L8:
        if (r100.getResources().getConfiguration() == null) goto L12;
        this.P0 = r100.getResources().getConfiguration().screenWidthDp;
        return;
    }

    public boolean n() {
        return false;
    }

    public void q() {
    }

    public final boolean y() {
        this.M = -1;
        this.D = false;
        this.E = false;
        VelocityTracker r100 = this.N;
        if (r100 == null) goto L5;
        r100.recycle();
        this.N = null;
    L5:
        this.S.onRelease();
        this.T.onRelease();
        if (this.S.isFinished() == false) goto L8;
    L9:
        return true;
    L8:
        if (this.T.isFinished() == true) goto L9;
        return false;
    }

    public final void g() {
        int r100 = this.f194675k.getCount();
        this.f194671g = r100;
        if (this.f194672h.size() < ((this.C * 2) + 1)) goto L5;
    L7:
        boolean r101 = false;
    L8:
        int r102 = this.f194677l;
        int r103 = 0;
        boolean r104 = false;
    L10:
        if (r103 >= this.f194672h.size()) goto L30;
        e r105 = (e) ListProtector.get(this.f194672h, r103);
        int r106 = this.f194675k.getItemPosition(r105.f194705a);
        if (r106 == (-1)) goto L29;
        if (r106 != (-2)) goto L22;
        ListProtector.remove(this.f194672h, r103);
        r103 = r103 - 1;
        if (r104 == true) goto L19;
        this.f194675k.startUpdate(this);
        r104 = true;
    L19:
        this.f194675k.destroyItem(this, r105.f194706b, r105.f194705a);
        int r107 = this.f194677l;
        if (r107 != r105.f194706b) goto L28;
        r102 = Math.max(0, Math.min(r107, (-1) + r100));
    L28:
        r101 = true;
        goto L29
    L22:
        int r108 = r105.f194706b;
        if (r108 == r106) goto L29;
        if (r108 != this.f194677l) goto L27;
        r102 = r106;
    L27:
        r105.f194706b = r106;
    L29:
        r103 = r103 + 1;
        goto L10
    L30:
        if (r104 == false) goto L32;
        this.f194675k.finishUpdate(this);
    L32:
        Collections.sort(this.f194672h, f194662b1);
        if (r101 == false) goto L49;
        int r109 = getChildCount();
        int r110 = 0;
    L35:
        if (r110 >= r109) goto L40;
        LayoutParams r111 = (LayoutParams) getChildAt(r110).getLayoutParams();
        if (r111.f194693a == true) goto L39;
        r111.f194695c = 0.0f;
    L39:
        r110 = r110 + 1;
        goto L35
    L40:
        B(r102, false, true, 0);
        new Throwable();
        requestLayout();
        return;
    L49:
        return;
    L5:
        if (this.f194672h.size() >= r100) goto L7;
        r101 = true;
        goto L8
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        removeCallbacks(this.H0);
        Scroller r100 = this.f194681p;
        if (r100 != null) goto L5;
    L7:
        super.onDetachedFromWindow();
        return;
    L5:
        if (r100.isFinished() == true) goto L7;
        this.f194681p.abortAnimation();
        goto L7
    }

    public final boolean s() {
        PagerAdapter r100 = this.f194675k;
        if (r100 != null) goto L5;
        return false;
    L5:
        if (this.f194677l >= (r100.getCount() - 1)) goto L10;
        A(this.f194677l + 1, true);
        return true;
    L10:
        return false;
    }

    public final void v() {
        w(this.f194677l);
    }

    private int getClientWidth() {
        return (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable r100 = this.f194686t;
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.isStateful() == false) goto L9;
        r100.setState(getDrawableState());
        return;
    }

    public final e k() {
        int r100 = getClientWidth();
        float r101 = 0.0f;
        if (r100 <= 0) goto L5;
        float r102 = getScrollX() / r100;
    L6:
        if (r100 <= 0) goto L8;
        float r103 = this.f194685s / r100;
    L9:
        e r104 = null;
        float r105 = 0.0f;
        int r106 = -1;
        int r107 = 0;
        boolean r108 = true;
    L11:
        if (r107 >= this.f194672h.size()) goto L30;
        e r110 = (e) ListProtector.get(this.f194672h, r107);
        if (r108 == true) goto L17;
        int r109 = r106 + 1;
        if (r110.f194706b == r109) goto L17;
        r110 = this.f194673i;
        r110.f194709e = (r101 + r105) + r103;
        r110.f194706b = r109;
        r110.f194708d = this.f194675k.getPageWidth(r109);
        r107 = r107 - 1;
    L17:
        e r111 = r110;
        r101 = r111.f194709e;
        float r112 = (r111.f194708d + r101) + r103;
        if (r108 == true) goto L24;
        if (r102 >= r101) goto L24;
        return r104;
    L24:
        if (r102 < r112) goto L29;
        if (r107 == (this.f194672h.size() - 1)) goto L29;
        int r113 = r111.f194706b;
        float r114 = r111.f194708d;
        r107 = r107 + 1;
        r108 = false;
        r106 = r113;
        r105 = r114;
        r104 = r111;
    L29:
        return r111;
    L30:
        return r104;
    L8:
        r103 = 0.0f;
        goto L9
    L5:
        r102 = 0.0f;
        goto L6
    }

    public final void o() {
        PagerAdapter r100 = getAdapter();
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.getCount() != 3) goto L21;
        this.f194672h.size();
        getScrollX();
        getX();
        getChildCount();
        int r101 = 0;
    L8:
        if (r101 >= this.f194672h.size()) goto L22;
        ((e) ListProtector.get(this.f194672h, r101)).f194705a.getClass().toString();
        float r102 = ((e) ListProtector.get(this.f194672h, r101)).f194709e;
        if ((((e) ListProtector.get(this.f194672h, r101)).f194705a instanceof Fragment) == false) goto L15;
        View r103 = ((Fragment) ((e) ListProtector.get(this.f194672h, r101)).f194705a).getView();
        if (r103 == null) goto L15;
        LayoutParams r104 = (LayoutParams) r103.getLayoutParams();
        r103.getLeft();
        int r105 = r104.f194697e;
    L15:
        r101 = r101 + 1;
        goto L8
    L22:
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.U = true;
    }

    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        Parcelable r100 = super.onSaveInstanceState();
        if (AoEnv.j() == false) goto L5;
        return r100;
    L5:
        SavedState r101 = new SavedState(r100);
        r101.f194699a = getPositionForSaveInstanceState();
        PagerAdapter r102 = this.f194675k;
        if (r102 == null) goto L8;
        r101.f194700b = r102.saveState();
    L8:
        return r101;
    }

    public boolean e() {
        return this.B;
    }

    public PagerAdapter getAdapter() {
        return this.f194675k;
    }

    public int getCurrentItem() {
        return this.f194677l;
    }

    public int getOffscreenPageLimit() {
        return this.C;
    }

    public int getPageMargin() {
        return this.f194685s;
    }

    public int getPositionForSaveInstanceState() {
        return this.f194677l;
    }

    public DmtViewPager(Context r100) {
        super(r100);
        this.f194665a = true;
        this.f194666b = true;
        this.f194667c = 0.5f;
        this.f194668d = 0.5f;
        this.f194669e = -1.0d;
        this.f194670f = 1.0d;
        this.f194672h = new ArrayList();
        this.f194673i = new e();
        this.f194674j = new Rect();
        this.f194678m = -1;
        this.f194679n = null;
        this.f194680o = null;
        this.f194689w = -3.4028235E38f;
        this.f194690x = Float.MAX_VALUE;
        this.C = 1;
        this.M = -1;
        this.U = true;
        this.H0 = new c(this);
        this.L0 = 0;
        this.P0 = 0;
        m();
    }

    private void setScrollingCacheEnabled(boolean r100) {
        if (this.A == r100) goto L6;
        this.A = r100;
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void addTouchables(ArrayList<View> r100) {
        int r101 = 0;
    L4:
        if (r101 >= getChildCount()) goto L13;
        View r102 = getChildAt(r101);
        if (r102.getVisibility() != 0) goto L12;
        e r103 = j(r102);
        if (r103 == null) goto L12;
        if (r103.f194706b != this.f194677l) goto L12;
        r102.addTouchables(r100);
    L12:
        r101 = r101 + 1;
        goto L4
    }

    public final boolean b(int r100) {
        View r101 = findFocus();
        boolean r102 = true;
        boolean r103 = false;
        if (r101 == this) goto L19;
        if (r101 == null) goto L20;
        ViewParent r104 = r101.getParent();
    L8:
        if ((r104 instanceof ViewGroup) == false) goto L12;
        if (r104 == this) goto L10;
        r104 = r104.getParent();
        goto L8
    L10:
        boolean r105 = true;
    L13:
        if (r105 == true) goto L20;
        ViewParent r106 = r101.getParent();
    L16:
        if ((r106 instanceof ViewGroup) == false) goto L19;
        r106.getClass();
        r106 = r106.getParent();
        goto L16
    L12:
        r105 = false;
    L20:
        View r107 = FocusFinder.getInstance().findNextFocus(this, r101, r100);
        if (r107 == null) goto L38;
        if (r107 == r101) goto L38;
        if (r100 != 17) goto L32;
        int r108 = i(this.f194674j, r107).left;
        int r109 = i(this.f194674j, r101).left;
        if (r101 == null) goto L30;
        if (r108 < r109) goto L30;
        int r110 = this.f194677l;
        if (r110 <= 0) goto L48;
        A(r110 - 1, true);
    L49:
        r103 = r102;
    L50:
        if (r103 == false) goto L52;
        playSoundEffect(SoundEffectConstants.getContantForFocusDirection(r100));
    L52:
        return r103;
    L48:
        r102 = false;
    L30:
        boolean r111 = r107.requestFocus();
    L31:
        r103 = r111;
        goto L50
    L32:
        if (r100 != 66) goto L50;
        int r112 = i(this.f194674j, r107).left;
        int r113 = i(this.f194674j, r101).left;
        if (r101 == null) goto L37;
        if (r112 > r113) goto L37;
        r111 = s();
    L37:
        r111 = r107.requestFocus();
    L38:
        if (r100 == 17) goto L45;
        if (r100 == 1) goto L45;
        if (r100 != 66) goto L43;
    L44:
        r103 = s();
        goto L50
    L43:
        if (r100 != 2) goto L50;
    L45:
        int r114 = this.f194677l;
        if (r114 <= 0) goto L48;
        A(r114 - 1, true);
    L19:
        r101 = null;
        goto L20
    }

    @Override // android.view.View
    public boolean canScrollHorizontally(int r100) {
        if (this.f194675k != null) goto L5;
        return false;
    L5:
        int r101 = getClientWidth();
        int r102 = getScrollX();
        if (r100 < 0) goto L8;
        if (r100 > 0) goto L13;
        return false;
    L13:
        if (r102 >= ((int) (r101 * this.f194690x))) goto L18;
        return true;
    L18:
        return false;
    L8:
        if (r102 <= ((int) (r101 * this.f194689w))) goto L16;
        return true;
    L16:
        return false;
    }

    @Override // android.view.ViewGroup
    public final boolean checkLayoutParams(ViewGroup.LayoutParams r100) {
        if ((r100 instanceof LayoutParams) == true) goto L5;
    L7:
        return false;
    L5:
        if (super.checkLayoutParams(r100) == false) goto L7;
        return true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchKeyEvent(KeyEvent r100) {
        if (super.dispatchKeyEvent(r100) == false) goto L5;
        return true;
    L5:
        if (r100.getAction() != 0) goto L29;
        int r101 = r100.getKeyCode();
        if (r101 == 21) goto L24;
        if (r101 == 22) goto L20;
        if (r101 != 61) goto L29;
        if (r100.hasNoModifiers() == false) goto L17;
        boolean r102 = b(2);
    L30:
        if (r102 == true) goto L35;
        return false;
    L35:
        return true;
    L17:
        if (r100.hasModifiers(1) == false) goto L29;
        r102 = b(1);
        goto L30
    L20:
        if (r100.hasModifiers(2) == false) goto L22;
        r102 = s();
        goto L30
    L22:
        r102 = b(66);
        goto L30
    L24:
        if (r100.hasModifiers(2) == false) goto L28;
        int r103 = this.f194677l;
        if (r103 <= 0) goto L29;
        A(r103 - 1, true);
        r102 = true;
        goto L30
    L28:
        r102 = b(17);
    L29:
        r102 = false;
        goto L30
    }

    @Override // android.view.View
    public final boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent r100) {
        if (r100.getEventType() == 4096) goto L5;
        int r101 = getChildCount();
        int r102 = 0;
    L7:
        if (r102 >= r101) goto L19;
        View r103 = getChildAt(r102);
        if (r103.getVisibility() != 0) goto L18;
        e r104 = j(r103);
        if (r104 == null) goto L18;
        if (r104.f194706b != this.f194677l) goto L18;
        if (r103.dispatchPopulateAccessibilityEvent(r100) == false) goto L18;
        return true;
    L18:
        r102 = r102 + 1;
        goto L7
    L19:
        return false;
    L5:
        return super.dispatchPopulateAccessibilityEvent(r100);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent r100) {
        if (r100.getPointerCount() <= 1) goto L8;
        if (this.f194665a == true) goto L8;
        r100.setAction(1);
    L8:
        if (this.f194665a == true) goto L11;
        return true;
    L11:
        return super.dispatchTouchEvent(r100);
    }

    @Override // android.view.View
    public final void draw(Canvas r100) {
        super.draw(r100);
        int r101 = getOverScrollMode();
        boolean r102 = false;
        if (r101 == 0) goto L13;
        if (r101 != 1) goto L11;
        PagerAdapter r103 = this.f194675k;
        if (r103 == null) goto L11;
        if (r103.getCount() > 1) goto L13;
    L11:
        this.S.finish();
        this.T.finish();
    L18:
        if (r102 == false) goto L21;
        ViewCompat.postInvalidateOnAnimation(this);
        return;
    L21:
        return;
    L13:
        if (this.S.isFinished() == true) goto L16;
        int r104 = r100.save();
        int r105 = (getHeight() - getPaddingTop()) - getPaddingBottom();
        int r106 = getWidth();
        r100.rotate(270.0f);
        r100.translate((-r105) + getPaddingTop(), this.f194689w * r106);
        this.S.setSize(r105, r106);
        r102 = false | this.S.draw(r100);
        r100.restoreToCount(r104);
    L16:
        if (this.T.isFinished() == true) goto L18;
        int r107 = r100.save();
        int r108 = getWidth();
        int r109 = (getHeight() - getPaddingTop()) - getPaddingBottom();
        r100.rotate(90.0f);
        r100.translate(-getPaddingTop(), (-(this.f194690x + 1.0f)) * r108);
        this.T.setSize(r109, r108);
        r102 = r102 | this.T.draw(r100);
        r100.restoreToCount(r107);
        goto L18
    }

    public final void f(boolean r100) {
        if (this.L0 != 2) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == false) goto L20;
        setScrollingCacheEnabled(false);
        if ((!this.f194681p.isFinished()) == false) goto L16;
        this.f194681p.abortAnimation();
        int r102 = getScrollX();
        int r103 = getScrollY();
        int r104 = this.f194681p.getCurrX();
        int r105 = this.f194681p.getCurrY();
        if (r102 != r104) goto L12;
        if (r103 == r105) goto L20;
    L12:
        scrollTo(r104, r105);
        if (r104 == r102) goto L20;
        t(r104);
        goto L20
    L16:
        if (this.f194681p.getCurrX() == getScrollX()) goto L20;
        if ((getScrollX() % getMeasuredWidth()) == 0) goto L20;
        scrollTo(this.f194681p.getCurrX(), this.f194681p.getCurrY());
    L20:
        this.B = false;
        int r106 = 0;
    L22:
        if (r106 >= this.f194672h.size()) goto L27;
        e r107 = (e) ListProtector.get(this.f194672h, r106);
        if (r107.f194707c == false) goto L26;
        r107.f194707c = false;
        r101 = true;
    L26:
        r106 = r106 + 1;
        goto L22
    L27:
        if (r101 == false) goto L35;
        if (r100 == false) goto L30;
        ViewCompat.postOnAnimation(this, this.H0);
        return;
    L30:
        this.H0.run();
        return;
    L35:
        return;
    L5:
        r101 = false;
        goto L6
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet r100) {
        return new LayoutParams(getContext(), r100);
    }

    public final void h(int r100) {
        ViewPager.OnPageChangeListener r101 = this.f194682p0;
        if (r101 == null) goto L5;
        r101.onPageSelected(r100);
    L5:
        List<ViewPager.OnPageChangeListener> r102 = this.f194676k0;
        if (r102 == null) goto L13;
        int r103 = ((ArrayList) r102).size();
        int r104 = 0;
    L8:
        if (r104 >= r103) goto L17;
        ViewPager.OnPageChangeListener r105 = (ViewPager.OnPageChangeListener) ListProtector.get(this.f194676k0, r104);
        if (r105 == null) goto L12;
        r105.onPageSelected(r100);
    L12:
        r104 = r104 + 1;
        goto L8
    L17:
        return;
    }

    public final e j(View r100) {
        int r101 = 0;
    L4:
        if (r101 >= this.f194672h.size()) goto L9;
        e r102 = (e) ListProtector.get(this.f194672h, r101);
        if (this.f194675k.isViewFromObject(r100, r102.f194705a) == true) goto L7;
        r101 = r101 + 1;
        goto L4
    L7:
        return r102;
    L9:
        return null;
    }

    public final e l(int r100) {
        int r101 = 0;
    L4:
        if (r101 >= this.f194672h.size()) goto L9;
        e r102 = (e) ListProtector.get(this.f194672h, r101);
        if (r102.f194706b == r100) goto L7;
        r101 = r101 + 1;
        goto L4
    L7:
        return r102;
    L9:
        return null;
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration r100) {
        super.onConfigurationChanged(r100);
        int r101 = this.P0;
        int r102 = r100.screenWidthDp;
        if (r101 == r102) goto L6;
        this.P0 = r102;
        q();
    L6:
        if (Build.BRAND.equalsIgnoreCase("VIVO") == true) goto L8;
        return;
    L8:
        if (Build.MODEL.equalsIgnoreCase("V2178A") == false) goto L12;
        z(this.f194677l, false, 0, false);
        return;
    }

    @Override // android.view.View
    public final void onDraw(Canvas r110) {
        super.onDraw(r110);
        if (this.f194685s > 0) goto L5;
        return;
    L5:
        if (this.f194686t != null) goto L7;
        return;
    L7:
        if (this.f194672h.size() > 0) goto L9;
        return;
    L9:
        if (this.f194675k == null) goto L34;
        int r100 = getScrollX();
        int r101 = getWidth();
        float r102 = r101;
        float r103 = this.f194685s / r102;
        int r104 = 0;
        e r105 = (e) ListProtector.get(this.f194672h, 0);
        float r106 = r105.f194709e;
        int r107 = this.f194672h.size();
        int r108 = r105.f194706b;
        int r111 = ((e) ListProtector.get(this.f194672h, r107 - 1)).f194706b;
    L11:
        if (r108 >= r111) goto L35;
    L12:
        int r112 = r105.f194706b;
        if (r108 <= r112) goto L16;
        if (r104 >= r107) goto L16;
        r104 = r104 + 1;
        r105 = (e) ListProtector.get(this.f194672h, r104);
    L16:
        if (r108 != r112) goto L18;
        float r109 = r105.f194709e;
        float r113 = r105.f194708d;
        float r114 = (r109 + r113) * r102;
        r106 = (r109 + r113) + r103;
    L20:
        if ((this.f194685s + r114) <= r100) goto L24;
        this.f194686t.setBounds(Math.round(r114), this.f194687u, Math.round(this.f194685s + r114), this.f194688v);
        this.f194686t.draw(r110);
    L24:
        if (r114 > (r100 + r101)) goto L36;
        r108 = r108 + 1;
        r103 = r103;
        goto L11
    L36:
        return;
    L18:
        float r115 = this.f194675k.getPageWidth(r108);
        r114 = (r106 + r115) * r102;
        r106 = r106 + (r115 + r103);
        goto L20
    L35:
        return;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent r110) {
        int r100 = r110.getAction() & 255;
        if (r100 != 3) goto L5;
    L82:
        y();
        return false;
    L5:
        if (r100 == 1) goto L82;
        if (r100 == 0) goto L15;
        if (this.D == false) goto L12;
        return true;
    L12:
        if (this.E == false) goto L15;
        return false;
    L15:
        if (r100 == 0) goto L68;
        if (r100 != 2) goto L18;
        int r101 = this.M;
        if (r101 == (-1)) goto L78;
        int r102 = r110.findPointerIndex(r101);
        float r111 = r110.getX(r102);
        float r103 = r111 - this.I;
        float r112 = Math.abs(r103);
        float r113 = r110.getY(r102);
        float r114 = Math.abs(r113 - this.L);
        if (this.f194669e <= AudioStats.AUDIO_AMPLITUDE_NONE) goto L29;
        float r104 = (float) this.f194670f;
    L27:
        float r115 = r104;
        if (r103 == 0.0f) goto L48;
        float r105 = this.I;
        if (r105 >= this.G) goto L38;
        if (r103 <= 0.0f) goto L38;
    L41:
        boolean r106 = true;
    L43:
        if (r106 == true) goto L48;
        if (c(this, false, (int) r103, (int) r111, (int) r113) == false) goto L48;
        this.I = r111;
        this.f194664J = r113;
        this.E = true;
        return false;
    L38:
        if (r105 > (getWidth() - this.G)) goto L40;
    L42:
        r106 = false;
        goto L43
    L40:
        if (r103 >= 0.0f) goto L42;
    L48:
        float r107 = this.H;
        if (r112 <= r107) goto L61;
        if ((r112 * r115) <= r114) goto L61;
        this.D = true;
        ViewParent r108 = getParent();
        if (r108 == null) goto L55;
        r108.requestDisallowInterceptTouchEvent(true);
    L55:
        setScrollState(1);
        float r109 = this.K;
        float r116 = this.H;
        if (r103 <= 0.0f) goto L58;
        float r117 = r109 + r116;
    L59:
        this.I = r117;
        this.f194664J = r113;
        setScrollingCacheEnabled(true);
    L64:
        if (this.D == false) goto L78;
        if (u(r111) == false) goto L78;
        ViewCompat.postInvalidateOnAnimation(this);
        goto L78
    L58:
        r117 = r109 - r116;
    L61:
        if (r114 <= r107) goto L64;
        this.E = true;
        goto L64
    L29:
        if (r103 <= 0.0f) goto L31;
        r104 = this.f194667c;
        goto L27
    L31:
        r104 = this.f194668d;
    L78:
        if (this.N != null) goto L80;
        this.N = VelocityTracker.obtain();
    L80:
        this.N.addMovement(r110);
        return this.D;
    L18:
        if (r100 != 6) goto L78;
        r(r110);
        goto L78
    L68:
        float r118 = r110.getX();
        this.K = r118;
        this.I = r118;
        float r119 = r110.getY();
        this.L = r119;
        this.f194664J = r119;
        this.M = r110.getPointerId(0);
        this.E = false;
        this.f194683q = true;
        this.f194681p.computeScrollOffset();
        if (this.L0 == 2) goto L71;
    L76:
        f(false);
        this.D = false;
        goto L78
    L71:
        if (Math.abs(this.f194681p.getFinalX() - this.f194681p.getCurrX()) <= this.R) goto L76;
        this.f194681p.abortAnimation();
        this.B = false;
        v();
        this.D = true;
        ViewParent r120 = getParent();
        if (r120 == null) goto L75;
        r120.requestDisallowInterceptTouchEvent(true);
    L75:
        setScrollState(1);
        goto L78
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable r100) {
        if ((r100 instanceof SavedState) == true) goto L6;
        super.onRestoreInstanceState(r100);
        return;
    L6:
        SavedState r101 = (SavedState) r100;
        super.onRestoreInstanceState(r101.getSuperState());
        PagerAdapter r102 = this.f194675k;
        if (r102 == null) goto L9;
        r102.restoreState(r101.f194700b, r101.f194701c);
        B(r101.f194699a, false, true, 0);
        new Throwable();
        return;
    L9:
        this.f194678m = r101.f194699a;
        this.f194679n = r101.f194700b;
        this.f194680o = r101.f194701c;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent r110) {
        boolean r100 = false;
        if (r110.getAction() == 0) goto L5;
    L7:
        PagerAdapter r101 = this.f194675k;
        if (r101 != null) goto L10;
    L84:
        return false;
    L10:
        if (r101.getCount() == 0) goto L84;
        if (this.N != null) goto L15;
        this.N = VelocityTracker.obtain();
    L15:
        this.N.addMovement(r110);
        int r102 = r110.getAction() & 255;
        if (r102 != 0) goto L18;
        this.f194681p.abortAnimation();
        this.B = false;
        v();
        float r103 = r110.getX();
        this.K = r103;
        this.I = r103;
        float r104 = r110.getY();
        this.L = r104;
        this.f194664J = r104;
        this.M = r110.getPointerId(0);
    L81:
        if (r100 == false) goto L83;
        ViewCompat.postInvalidateOnAnimation(this);
    L83:
        return true;
    L18:
        if (r102 == 1) goto L63;
        if (r102 == 2) goto L34;
        if (r102 == 3) goto L31;
        if (r102 != 5) goto L26;
        int r105 = r110.getActionIndex();
        this.I = r110.getX(r105);
        this.M = r110.getPointerId(r105);
        goto L81
    L26:
        if (r102 != 6) goto L81;
        r(r110);
        this.I = r110.getX(r110.findPointerIndex(this.M));
        goto L81
    L31:
        if (this.D == false) goto L81;
        z(this.f194677l, true, 0, false);
        r100 = y();
        goto L81
    L34:
        if (this.D == true) goto L60;
        int r106 = r110.findPointerIndex(this.M);
        if (r106 != (-1)) goto L38;
        r100 = y();
        goto L81
    L38:
        float r107 = r110.getX(r106);
        float r108 = Math.abs(r107 - this.I);
        float r109 = r110.getY(r106);
        float r111 = Math.abs(r109 - this.f194664J);
        if (this.f194669e <= AudioStats.AUDIO_AMPLITUDE_NONE) goto L42;
        float r112 = (float) this.f194670f;
    L46:
        if (r108 <= this.H) goto L60;
        if ((r108 * r112) <= r111) goto L60;
        this.D = true;
        ViewParent r113 = getParent();
        if (r113 == null) goto L52;
        r113.requestDisallowInterceptTouchEvent(true);
    L52:
        float r114 = this.K;
        if ((r107 - r114) <= 0.0f) goto L55;
        float r115 = r114 + this.H;
    L56:
        this.I = r115;
        this.f194664J = r109;
        setScrollState(1);
        setScrollingCacheEnabled(true);
        ViewParent r116 = getParent();
        if (r116 == null) goto L60;
        r116.requestDisallowInterceptTouchEvent(true);
        goto L60
    L55:
        r115 = r114 - this.H;
        goto L56
    L42:
        if ((r107 - this.I) <= 0.0f) goto L44;
        r112 = this.f194667c;
        goto L46
    L44:
        r112 = this.f194668d;
    L60:
        if (this.D == false) goto L81;
        r100 = false | u(r110.getX(r110.findPointerIndex(this.M)));
        goto L81
    L63:
        if (this.D == false) goto L81;
        VelocityTracker r117 = this.N;
        r117.computeCurrentVelocity(1000, this.P);
        int r118 = (int) r117.getXVelocity(this.M);
        this.B = true;
        int r119 = getClientWidth();
        int r120 = getScrollX();
        e r121 = k();
        float r122 = r119;
        float r123 = this.f194685s / r122;
        int r124 = r121.f194706b;
        float r125 = ((r120 / r122) - r121.f194709e) / (r121.f194708d + r123);
        if (Math.abs((int) (r110.getX(r110.findPointerIndex(this.M)) - this.K)) <= this.Q) goto L72;
        if (Math.abs(r118) <= this.O) goto L72;
        if (r118 > 0) goto L77;
        r124 = r124 + 1;
    L77:
        if (this.f194672h.size() <= 0) goto L79;
        e r126 = (e) ListProtector.get(this.f194672h, 0);
        ArrayList<e> r127 = this.f194672h;
        r124 = Math.max(r126.f194706b, Math.min(r124, ((e) ListProtector.get(r127, r127.size() - 1)).f194706b));
    L79:
        B(r124, true, true, r118);
        r100 = y();
    L72:
        if (r124 < this.f194677l) goto L74;
        float r128 = 0.4f;
    L75:
        r124 = r124 + ((int) (r125 + r128));
        goto L77
    L74:
        r128 = 0.6f;
        goto L75
    L5:
        if (r110.getEdgeFlags() == 0) goto L7;
        return false;
    }

    public final void r(MotionEvent r100) {
        int r101 = r100.getActionIndex();
        if (r100.getPointerId(r101) != this.M) goto L11;
        if (r101 != 0) goto L6;
        int r102 = 1;
    L7:
        this.I = r100.getX(r102);
        this.M = r100.getPointerId(r102);
        VelocityTracker r103 = this.N;
        if (r103 == null) goto L12;
        r103.clear();
        return;
    L12:
        return;
    L6:
        r102 = 0;
        goto L7
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public final void removeView(View r100) {
        if (this.f194692z == false) goto L8;
        removeViewInLayout(r100);
        return;
    L8:
        super.removeView(r100);     // Catch: IllegalStateException -> L7
        return;
    }

    public void setAdapter(PagerAdapter r100) {
        PagerAdapter r101 = this.f194675k;
        if (r101 == null) goto L16;
        C(r101, null);
        this.f194675k.startUpdate(this);
        int r102 = 0;
    L6:
        if (r102 >= this.f194672h.size()) goto L8;
        e r103 = (e) ListProtector.get(this.f194672h, r102);
        this.f194675k.destroyItem(this, r103.f194706b, r103.f194705a);
        r102 = r102 + 1;
        goto L6
    L8:
        this.f194675k.finishUpdate(this);
        this.f194672h.clear();
        int r104 = 0;
    L10:
        if (r104 >= getChildCount()) goto L15;
        if (((LayoutParams) getChildAt(r104).getLayoutParams()).f194693a == true) goto L14;
        removeViewAt(r104);
        r104 = r104 - 1;
    L14:
        r104 = r104 + 1;
        goto L10
    L15:
        this.f194677l = 0;
        scrollTo(0, 0);
    L16:
        this.f194675k = r100;
        this.f194671g = 0;
        if (r100 != null) goto L19;
        return;
    L19:
        if (this.f194684r != null) goto L21;
        this.f194684r = new g(this);
    L21:
        C(this.f194675k, this.f194684r);
        this.B = false;
        boolean r105 = this.U;
        this.U = true;
        this.f194671g = this.f194675k.getCount();
        if (this.f194678m < 0) goto L24;
        this.f194675k.restoreState(this.f194679n, this.f194680o);
        B(this.f194678m, false, true, 0);
        new Throwable();
        this.f194678m = -1;
        this.f194679n = null;
        this.f194680o = null;
        return;
    L24:
        if (r105 == true) goto L26;
        v();
        return;
    L26:
        requestLayout();
    }

    public void setCanTouchBeforeScrollIdle(boolean r100) {
        this.f194666b = r100;
    }

    public void setCurrentItem(int r100) {
        this.B = false;
        B(r100, !this.U, false, 0);
        new Throwable();
    }

    public void setCurrentItemWithoutScroll(int r100) {
        this.f194677l = r100;
    }

    public void setDefaultGutterSize(int r100) {
        this.F = r100;
    }

    public void setLivePreviewScrollableAngle(double r100) {
        if (r100 > AudioStats.AUDIO_AMPLITUDE_NONE) goto L5;
    L7:
        this.f194669e = -1.0d;
        this.f194670f = 1.0d;
        return;
    L5:
        if (r100 >= 180.0d) goto L7;
        this.f194669e = r100;
        this.f194670f = Math.tan(Math.toRadians(90.0d - (r100 / 2.0d)));
    }

    public void setOffscreenPageLimit(int r100) {
        if (r100 >= 1) goto L6;
        r100 = 1;
    L6:
        if (r100 == this.C) goto L9;
        this.C = r100;
        v();
        return;
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener r100) {
        this.f194682p0 = r100;
    }

    public void setOptPagerDegreeFraction(float r100) {
        this.f194667c = r100;
        this.f194668d = r100;
    }

    public void setPageMargin(int r100) {
        int r101 = this.f194685s;
        this.f194685s = r100;
        int r102 = getWidth();
        x(r102, r102, r100, r101);
        requestLayout();
    }

    public void setPageMarginDrawable(Drawable r100) {
        this.f194686t = r100;
        if (r100 == null) goto L5;
        refreshDrawableState();
    L5:
        if (r100 != null) goto L7;
        boolean r101 = true;
    L8:
        setWillNotDraw(r101);
        invalidate();
        return;
    L7:
        r101 = false;
        goto L8
    }

    public void setScrollState(int r100) {
        if (this.L0 != r100) goto L5;
        return;
    L5:
        this.L0 = r100;
        if (r100 != 0) goto L8;
        this.f194665a = true;
    L8:
        ViewPager.OnPageChangeListener r101 = this.f194682p0;
        if (r101 == null) goto L11;
        r101.onPageScrollStateChanged(r100);
    L11:
        List<ViewPager.OnPageChangeListener> r102 = this.f194676k0;
        if (r102 == null) goto L19;
        int r103 = ((ArrayList) r102).size();
        int r104 = 0;
    L14:
        if (r104 >= r103) goto L23;
        ViewPager.OnPageChangeListener r105 = (ViewPager.OnPageChangeListener) ListProtector.get(this.f194676k0, r104);
        if (r105 == null) goto L18;
        r105.onPageScrollStateChanged(r100);
    L18:
        r104 = r104 + 1;
        goto L14
    L23:
        return;
    }

    public void setScroller(Scroller r100) {
        this.f194681p = r100;
    }

    public final boolean t(int r100) {
        if (this.f194672h.size() == 0) goto L5;
        e r101 = k();
        int r102 = getClientWidth();
        int r103 = this.f194685s;
        int r104 = r102 + r103;
        float r105 = r102;
        int r106 = r101.f194706b;
        float r107 = ((r100 / r105) - r101.f194709e) / (r101.f194708d + (r103 / r105));
        this.V = false;
        p(r106, r107, (int) (r104 * r107));
        if (this.V == false) goto L17;
        return true;
    L17:
        throw new IllegalStateException("onPageScrolled did not call superclass implementation");
    L5:
        if (this.U == false) goto L7;
        return false;
    L7:
        this.V = false;
        p(0, 0.0f, 0);
        if (this.V == false) goto L11;
        return false;
    L11:
        throw new IllegalStateException("onPageScrolled did not call superclass implementation");
    }

    public final boolean u(float r110) {
        float r100 = this.I - r110;
        this.I = r110;
        float r111 = getScrollX() + r100;
        int r101 = getClientWidth();
        float r102 = this.f194689w;
        int r103 = getCurrentDragLeftBoundPosition();
        boolean r104 = false;
        if (r103 > 0) goto L5;
    L7:
        r103 = 0;
    L8:
        float r105 = r101;
        float r106 = r102 * r105;
        float r107 = this.f194690x * r105;
        e r108 = (e) ListProtector.get(this.f194672h, r103);
        ArrayList<e> r109 = this.f194672h;
        e r112 = (e) ListProtector.get(r109, r109.size() - 1);
        if (r108.f194706b == r103) goto L11;
        r106 = r108.f194709e * r105;
        boolean r113 = false;
    L13:
        if (r112.f194706b == (this.f194675k.getCount() - 1)) goto L15;
        r107 = r112.f194709e * r105;
        boolean r114 = false;
    L17:
        if (r111 >= r106) goto L22;
        if (r113 == false) goto L20;
        this.S.onPull(Math.abs(r106 - r111) / r105);
        r104 = true;
    L20:
        r111 = r106;
    L26:
        int r115 = (int) r111;
        this.I += r111 - r115;
        scrollTo(r115, getScrollY());
        t(r115);
        return r104;
    L22:
        if (r111 <= r107) goto L26;
        if (r114 == false) goto L25;
        this.T.onPull(Math.abs(r111 - r107) / r105);
        r104 = true;
    L25:
        r111 = r107;
        goto L26
    L15:
        r114 = true;
        goto L17
    L11:
        r113 = true;
        goto L13
    L5:
        if (r103 >= this.f194672h.size()) goto L7;
        r102 = ((e) ListProtector.get(this.f194672h, r103)).f194709e;
        goto L8
    }

    @Override // android.view.View
    public final boolean verifyDrawable(Drawable r100) {
        if (super.verifyDrawable(r100) == false) goto L5;
    L8:
        return true;
    L5:
        if (r100 == this.f194686t) goto L8;
        return false;
    }

    public final void w(int r110) {
        int r100 = this.f194677l;
        if (r100 == r110) goto L5;
        e r101 = l(r100);
        this.f194677l = r110;
    L7:
        if (this.f194675k != null) goto L10;
        return;
    L10:
        if (e() == false) goto L13;
        return;
    L13:
        if (getWindowToken() != null) goto L15;
        return;
    L15:
        this.f194675k.startUpdate(this);
        int r102 = this.C;
        int r103 = Math.max(0, this.f194677l - r102);
        int r104 = this.f194675k.getCount();
        int r105 = Math.min(r104 - 1, this.f194677l + r102);
        if (r104 != this.f194671g) goto L218;
        int r106 = 0;
    L19:
        if (r106 >= this.f194672h.size()) goto L25;
        e r107 = (e) ListProtector.get(this.f194672h, r106);
        int r108 = r107.f194706b;
        int r111 = this.f194677l;
        if (r108 >= r111) goto L22;
        r106 = r106 + 1;
        goto L19
    L22:
        if (r108 != r111) goto L25;
    L26:
        if (r107 != null) goto L29;
        if (r104 <= 0) goto L29;
        r107 = a(this.f194677l, r106);
    L29:
        o();
        if (r107 == null) goto L170;
        int r112 = r106 - 1;
        if (r112 < 0) goto L34;
        e r113 = (e) ListProtector.get(this.f194672h, r112);
    L35:
        int r114 = getClientWidth();
        if (r114 > 0) goto L38;
        float r115 = 0.0f;
    L39:
        int r109 = this.f194677l - 1;
        float r116 = 0.0f;
    L40:
        if (r109 < 0) goto L65;
        if (r116 < r115) goto L53;
        if (r109 >= r103) goto L53;
        if (r113 == null) goto L65;
        if (r109 != r113.f194706b) goto L64;
        if (r113.f194707c == true) goto L64;
        ListProtector.remove(this.f194672h, r112);
        this.f194675k.destroyItem(this, r109, r113.f194705a);
        r112 = r112 - 1;
        r106 = r106 - 1;
        if (r112 < 0) goto L62;
        e r117 = (e) ListProtector.get(this.f194672h, r112);
    L63:
        r113 = r117;
    L62:
        r117 = null;
    L64:
        r109 = r109 - 1;
    L53:
        if (r113 != null) goto L55;
    L59:
        r116 = r116 + a(r109, r112 + 1).f194708d;
        r106 = r106 + 1;
        if (r112 < 0) goto L62;
        r117 = (e) ListProtector.get(this.f194672h, r112);
        goto L63
    L55:
        if (r109 != r113.f194706b) goto L59;
        r116 = r116 + r113.f194708d;
        r112 = r112 - 1;
        if (r112 < 0) goto L62;
        r117 = (e) ListProtector.get(this.f194672h, r112);
    L65:
        float r118 = r107.f194708d;
        int r119 = r106 + 1;
        if (r118 < 2.0f) goto L68;
    L99:
        o();
        int r120 = this.f194675k.getCount();
        int r121 = getClientWidth();
        if (r121 <= 0) goto L102;
        float r122 = this.f194685s / r121;
    L103:
        if (r101 == null) goto L135;
        int r123 = r101.f194706b;
        int r124 = r107.f194706b;
        if (r123 >= r124) goto L121;
        float r125 = (r101.f194709e + r101.f194708d) + r122;
        int r126 = r123 + 1;
        int r127 = 0;
    L108:
        if (r126 > r107.f194706b) goto L135;
        if (r127 >= this.f194672h.size()) goto L135;
        Object r128 = ListProtector.get(this.f194672h, r127);
    L112:
        e r129 = (e) r128;
        if (r126 <= r129.f194706b) goto L118;
        if (r127 >= (this.f194672h.size() - 1)) goto L118;
        r127 = r127 + 1;
        r128 = ListProtector.get(this.f194672h, r127);
    L118:
        if (r126 >= r129.f194706b) goto L120;
        r125 = r125 + (this.f194675k.getPageWidth(r126) + r122);
        r126 = r126 + 1;
        goto L118
    L120:
        r129.f194709e = r125;
        r125 = r125 + (r129.f194708d + r122);
        r126 = r126 + 1;
        goto L108
    L121:
        if (r123 <= r124) goto L135;
        int r130 = this.f194672h.size() - 1;
        float r131 = r101.f194709e;
    L123:
        r123 = r123 - 1;
        if (r123 < r107.f194706b) goto L135;
        if (r130 < 0) goto L135;
        Object r132 = ListProtector.get(this.f194672h, r130);
    L127:
        e r133 = (e) r132;
        if (r123 >= r133.f194706b) goto L132;
        if (r130 <= 0) goto L132;
        r130 = r130 - 1;
        r132 = ListProtector.get(this.f194672h, r130);
    L132:
        if (r123 <= r133.f194706b) goto L134;
        r131 = r131 - (this.f194675k.getPageWidth(r123) + r122);
        r123 = r123 - 1;
        goto L132
    L134:
        r131 = r131 - (r133.f194708d + r122);
        r133.f194709e = r131;
    L135:
        int r134 = this.f194672h.size();
        float r135 = r107.f194709e;
        int r136 = r107.f194706b;
        int r137 = r136 - 1;
        if (r136 != 0) goto L138;
        float r138 = r135;
    L139:
        this.f194689w = r138;
        int r139 = r120 - 1;
        if (r136 != r139) goto L142;
        float r140 = (r107.f194708d + r135) - 1.0f;
    L143:
        this.f194690x = r140;
        int r141 = r106 - 1;
    L144:
        if (r141 < 0) goto L153;
        e r142 = (e) ListProtector.get(this.f194672h, r141);
    L146:
        int r143 = r142.f194706b;
        if (r137 <= r143) goto L149;
        r135 = r135 - (this.f194675k.getPageWidth(r137) + r122);
        r137 = r137 - 1;
        goto L146
    L149:
        r135 = r135 - (r142.f194708d + r122);
        r142.f194709e = r135;
        if (r143 != 0) goto L152;
        this.f194689w = r135;
    L152:
        r141 = r141 - 1;
        r137 = r137 - 1;
        goto L144
    L153:
        float r144 = (r107.f194709e + r107.f194708d) + r122;
        int r145 = r107.f194706b;
    L154:
        r145 = r145 + 1;
        if (r119 >= r134) goto L163;
        e r146 = (e) ListProtector.get(this.f194672h, r119);
    L157:
        int r147 = r146.f194706b;
        if (r145 >= r147) goto L160;
        r144 = r144 + (this.f194675k.getPageWidth(r145) + r122);
        r145 = r145 + 1;
        goto L157
    L160:
        if (r147 != r139) goto L162;
        this.f194690x = (r146.f194708d + r144) - 1.0f;
    L162:
        r146.f194709e = r144;
        r144 = r144 + (r146.f194708d + r122);
        r119 = r119 + 1;
        goto L154
    L163:
        o();
        Object r148 = r107.f194705a;
        if ((r148 instanceof Fragment) == false) goto L170;
        View r149 = ((Fragment) r148).getView();
        if (r149 == null) goto L170;
        if (r149.isLayoutRequested() == false) goto L170;
        requestLayout();
        goto L170
    L142:
        r140 = Float.MAX_VALUE;
        goto L143
    L138:
        r138 = -3.4028235E38f;
        goto L139
    L102:
        r122 = 0.0f;
        goto L103
    L68:
        if (r119 >= this.f194672h.size()) goto L70;
        e r150 = (e) ListProtector.get(this.f194672h, r119);
    L71:
        if (r114 > 0) goto L73;
        float r151 = 0.0f;
    L74:
        int r152 = this.f194677l + 1;
        int r153 = r119;
    L75:
        if (r152 >= r104) goto L99;
        if (r118 < r151) goto L88;
        if (r152 <= r105) goto L88;
        if (r150 == null) goto L99;
        if (r152 != r150.f194706b) goto L98;
        if (r150.f194707c == true) goto L98;
        ListProtector.remove(this.f194672h, r153);
        this.f194675k.destroyItem(this, r152, r150.f194705a);
        if (r153 >= this.f194672h.size()) goto L97;
        r150 = (e) ListProtector.get(this.f194672h, r153);
    L97:
        r150 = null;
    L98:
        r152 = r152 + 1;
    L88:
        if (r150 != null) goto L90;
    L94:
        e r154 = a(r152, r153);
        r153 = r153 + 1;
        r118 = r118 + r154.f194708d;
        if (r153 >= this.f194672h.size()) goto L97;
        r150 = (e) ListProtector.get(this.f194672h, r153);
        goto L98
    L90:
        if (r152 != r150.f194706b) goto L94;
        r118 = r118 + r150.f194708d;
        r153 = r153 + 1;
        if (r153 >= this.f194672h.size()) goto L97;
        r150 = (e) ListProtector.get(this.f194672h, r153);
        goto L98
    L73:
        r151 = (getPaddingRight() / r114) + 2.0f;
        goto L74
    L70:
        r150 = null;
        goto L71
    L38:
        r115 = (2.0f - r107.f194708d) + (getPaddingLeft() / r114);
        goto L39
    L34:
        r113 = null;
    L170:
        PagerAdapter r155 = this.f194675k;
        int r156 = this.f194677l;
        if (r107 == null) goto L173;
        Object r157 = r107.f194705a;
    L174:
        r155.setPrimaryItem(this, r156, r157);
        this.f194675k.finishUpdate(this);
        int r158 = getChildCount();
        int r159 = 0;
    L175:
        if (r159 >= r158) goto L186;
        View r160 = getChildAt(r159);
        LayoutParams r161 = (LayoutParams) r160.getLayoutParams();
        r161.f194698f = r159;
        if (r161.f194693a == true) goto L184;
        if (r161.f194695c != 0.0f) goto L184;
        e r162 = j(r160);
        if (r162 == null) goto L184;
        r161.f194695c = r162.f194708d;
        r161.f194697e = r162.f194706b;
    L184:
        r159 = r159 + 1;
        goto L175
    L186:
        if (hasFocus() == false) goto L212;
        View r163 = findFocus();
        if (r163 == null) goto L197;
    L189:
        Object r164 = r163.getParent();
        if (r164 == this) goto L196;
        if (r164 == null) goto L197;
        if ((r164 instanceof View) == false) goto L197;
        r163 = (View) r164;
        goto L189
    L196:
        e r165 = j(r163);
    L198:
        if (r165 != null) goto L200;
    L201:
        int r166 = 0;
    L203:
        if (r166 >= getChildCount()) goto L270;
        View r167 = getChildAt(r166);
        e r168 = j(r167);
        if (r168 == null) goto L211;
        if (r168.f194706b != this.f194677l) goto L211;
        if (r167.requestFocus(2) == false) goto L211;
        return;
    L211:
        r166 = r166 + 1;
        goto L203
    L270:
        return;
    L200:
        if (r165.f194706b != this.f194677l) goto L201;
        return;
    L197:
        r165 = null;
        goto L198
    L212:
        return;
    L173:
        r157 = null;
    L25:
        r107 = null;
        goto L26
    L218:
        String r169 = getResources().getResourceName(getId());     // Catch: Resources.NotFoundException -> L215
    L217:
        throw new IllegalStateException("The application's PagerAdapter changed the adapter's contents without calling PagerAdapter#notifyDataSetChanged! Expected adapter item count: " + this.f194671g + ", found: " + r104 + " Pager id: " + r169 + " Pager class: " + getClass() + " Problematic adapter: " + this.f194675k.getClass());
    L215:
        r169 = Integer.toHexString(getId());
        goto L217
    L5:
        r101 = null;
        goto L7
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams r100) {
        return generateDefaultLayoutParams();
    }

    public void setPageMarginDrawable(int r100) {
        setPageMarginDrawable(ContextCompat.getDrawable(getContext(), r100));
    }

    public DmtViewPager(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.f194665a = true;
        this.f194666b = true;
        this.f194667c = 0.5f;
        this.f194668d = 0.5f;
        this.f194669e = -1.0d;
        this.f194670f = 1.0d;
        this.f194672h = new ArrayList();
        this.f194673i = new e();
        this.f194674j = new Rect();
        this.f194678m = -1;
        this.f194679n = null;
        this.f194680o = null;
        this.f194689w = -3.4028235E38f;
        this.f194690x = Float.MAX_VALUE;
        this.C = 1;
        this.M = -1;
        this.U = true;
        this.H0 = new c(this);
        this.L0 = 0;
        this.P0 = 0;
        m();
    }

    public static void C(PagerAdapter r100, g r101) {
        Method r102 = PagerAdapter.class.getDeclaredMethod("setViewPagerObserver", new Class[]{DataSetObserver.class});     // Catch: Exception -> L4
        r102.setAccessible(true);     // Catch: Exception -> L4
        r102.invoke(r100, new Object[]{r101});     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
    }

    public void A(int r100, boolean r101) {
        this.B = false;
        B(r100, r101, false, 0);
        new Throwable();
    }

    public final e a(int r100, int r101) {
        e r102 = new e();
        r102.f194706b = r100;
        r102.f194705a = this.f194675k.instantiateItem(this, r100);
        r102.f194708d = this.f194675k.getPageWidth(r100);
        if (r101 >= 0) goto L5;
    L8:
        this.f194672h.add(r102);
    L9:
        return r102;
    L5:
        if (r101 >= this.f194672h.size()) goto L8;
        ListProtector.add(this.f194672h, r101, r102);
        goto L9
    }

    @Override // android.view.ViewGroup
    public final int getChildDrawingOrder(int r100, int r101) {
        return ((LayoutParams) ((View) ListProtector.get(null, r101)).getLayoutParams()).f194698f;
    }

    public final Rect i(Rect r100, View r101) {
        if (r100 != null) goto L4;
        r100 = new Rect();
    L4:
        if (r101 != null) goto L7;
        r100.set(0, 0, 0, 0);
        return r100;
    L7:
        r100.left = r101.getLeft();
        r100.right = r101.getRight();
        r100.top = r101.getTop();
        r100.bottom = r101.getBottom();
        ViewParent r102 = r101.getParent();
    L9:
        if ((r102 instanceof ViewGroup) == false) goto L12;
        if (r102 == this) goto L12;
        ViewGroup r103 = (ViewGroup) r102;
        r100.left += r103.getLeft();
        r100.right += r103.getRight();
        r100.top += r103.getTop();
        r100.bottom += r103.getBottom();
        r102 = r103.getParent();
    L12:
        return r100;
    }

    @Override // android.view.View
    public final void onMeasure(int r110, int r111) {
        int r100 = 0;
        setMeasuredDimension(ViewGroup.getDefaultSize(0, r110), ViewGroup.getDefaultSize(0, r111));
        int r112 = getMeasuredWidth();
        this.G = Math.min(r112 / 10, this.F);
        int r113 = (r112 - getPaddingLeft()) - getPaddingRight();
        int r114 = (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
        int r101 = getChildCount();
        int r102 = 0;
    L3:
        boolean r103 = true;
        int r104 = 1073741824;
        if (r102 >= r101) goto L49;
        View r105 = getChildAt(r102);
        if (r105.getVisibility() == 8) goto L48;
        LayoutParams r106 = (LayoutParams) r105.getLayoutParams();
        if (r106 == null) goto L48;
        if (r106.f194693a == false) goto L48;
        int r107 = r106.f194694b;
        int r108 = r107 & 7;
        int r109 = r107 & 112;
        if (r109 != 48) goto L14;
    L17:
        boolean r115 = true;
    L19:
        if (r108 != 3) goto L21;
    L24:
        int r116 = Integer.MIN_VALUE;
        if (r115 == false) goto L27;
        r116 = 1073741824;
    L29:
        int r117 = Integer.MIN_VALUE;
    L30:
        int r118 = ((ViewGroup.LayoutParams) r106).width;
        if (r118 == (-2)) goto L36;
        if (r118 != (-1)) goto L35;
        r118 = r113;
    L35:
        r116 = 1073741824;
    L37:
        int r119 = ((ViewGroup.LayoutParams) r106).height;
        if (r119 == (-2)) goto L42;
        if (r119 != (-1)) goto L43;
        r119 = r114;
    L43:
        r105.measure(View.MeasureSpec.makeMeasureSpec(r118, r116), View.MeasureSpec.makeMeasureSpec(r119, r104));
        if (r115 == false) goto L46;
        r114 = r114 - r105.getMeasuredHeight();
        goto L48
    L46:
        if (r103 == false) goto L48;
        r113 = r113 - r105.getMeasuredWidth();
        goto L48
    L42:
        r119 = r114;
        r104 = r117;
        goto L43
    L36:
        r118 = r113;
        goto L37
    L27:
        if (r103 == false) goto L29;
        r117 = 1073741824;
        goto L30
    L21:
        if (r108 == 5) goto L24;
        r103 = false;
        goto L24
    L14:
        if (r109 == 80) goto L17;
        r115 = false;
    L48:
        r102 = r102 + 1;
        goto L3
    L49:
        View.MeasureSpec.makeMeasureSpec(r113, 1073741824);
        this.f194691y = View.MeasureSpec.makeMeasureSpec(r114, 1073741824);
        this.f194692z = true;
        v();
        this.f194692z = false;
        int r120 = getChildCount();
    L50:
        if (r100 >= r120) goto L59;
        View r121 = getChildAt(r100);
        if (r121.getVisibility() == 8) goto L58;
        LayoutParams r122 = (LayoutParams) r121.getLayoutParams();
        if (r122 != null) goto L56;
    L57:
        r121.measure(View.MeasureSpec.makeMeasureSpec((int) (r113 * r122.f194695c), 1073741824), this.f194691y);
        goto L58
    L56:
        if (r122.f194693a == false) goto L57;
    L58:
        r100 = r100 + 1;
        goto L50
    }

    @Override // android.view.ViewGroup
    public final boolean onRequestFocusInDescendants(int r100, Rect r110) {
        int r101 = getChildCount();
        if ((r100 & 2) == 0) goto L5;
        int r102 = r101;
        int r103 = 0;
        int r104 = 1;
    L6:
        if (r103 == r102) goto L17;
        View r105 = getChildAt(r103);
        if (r105.getVisibility() != 0) goto L16;
        e r106 = j(r105);
        if (r106 == null) goto L16;
        if (r106.f194706b != this.f194677l) goto L16;
        if (r105.requestFocus(r100, r110) == false) goto L16;
        return true;
    L16:
        r103 = r103 + r104;
        goto L6
    L17:
        return false;
    L5:
        r103 = r101 - 1;
        r102 = -1;
        r104 = -1;
        goto L6
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void addFocusables(ArrayList<View> r100, int r101, int r102) {
        int r103 = r100.size();
        int r104 = getDescendantFocusability();
        if (r104 == 393216) goto L16;
        int r105 = 0;
    L6:
        if (r105 >= getChildCount()) goto L16;
        View r106 = getChildAt(r105);
        if (r106.getVisibility() != 0) goto L14;
        e r107 = j(r106);
        if (r107 == null) goto L14;
        if (r107.f194706b != this.f194677l) goto L14;
        r106.addFocusables(r100, r101, r102);
    L14:
        r105 = r105 + 1;
    L16:
        if (r104 != 262144) goto L20;
        if (r103 == r100.size()) goto L20;
        return;
    L20:
        if (isFocusable() == true) goto L23;
        return;
    L23:
        if ((r102 & 1) == 1) goto L25;
    L29:
        r100.add(this);
        return;
    L25:
        if (isInTouchMode() == false) goto L29;
        if (isFocusableInTouchMode() == true) goto L29;
    }

    @Override // android.view.ViewGroup
    public final void addView(View r100, int r101, ViewGroup.LayoutParams r102) {
        if (checkLayoutParams(r102) == true) goto L5;
        r102 = generateLayoutParams(r102);
    L5:
        LayoutParams r103 = (LayoutParams) r102;
        boolean r104 = r103.f194693a;
        if (r100.getClass().getAnnotation(DecorView.class) == null) goto L8;
        boolean r105 = true;
    L9:
        boolean r106 = r104 | r105;
        r103.f194693a = r106;
        if (this.f194692z == false) goto L15;
        if (r106 == true) goto L14;
        r103.f194696d = true;
        addViewInLayout(r100, r101, r102);
        return;
    L14:
        throw new IllegalStateException("Cannot add pager decor view during layout");
    L15:
        super.addView(r100, r101, r102);
        return;
    L8:
        r105 = false;
        goto L9
    }

    public void p(int r110, float r111, int r112) {
        int r100 = 0;
        if (this.W <= 0) goto L25;
        int r101 = getScrollX();
        int r102 = getPaddingLeft();
        int r103 = getPaddingRight();
        int r104 = getWidth();
        int r105 = getChildCount();
        int r106 = 0;
    L5:
        if (r106 >= r105) goto L25;
        View r107 = getChildAt(r106);
        LayoutParams r108 = (LayoutParams) r107.getLayoutParams();
        if (r108.f194693a == false) goto L24;
        int r109 = r108.f194694b & 7;
        if (r109 != 1) goto L12;
        int r113 = Math.max((r104 - r107.getMeasuredWidth()) / 2, r102);
    L19:
        int r114 = r113;
        int r115 = r102;
        r102 = r114;
    L20:
        int r116 = (r102 + r101) - r107.getLeft();
        if (r116 == 0) goto L23;
        r107.offsetLeftAndRight(r116);
    L23:
        r102 = r115;
        goto L24
    L12:
        if (r109 != 3) goto L14;
        r115 = r107.getWidth() + r102;
        goto L20
    L14:
        if (r109 == 5) goto L16;
        r115 = r102;
        goto L20
    L16:
        r113 = (r104 - r103) - r107.getMeasuredWidth();
        r103 = r103 + r107.getMeasuredWidth();
    L24:
        r106 = r106 + 1;
    L25:
        ViewPager.OnPageChangeListener r117 = this.f194682p0;
        if (r117 == null) goto L28;
        r117.onPageScrolled(r110, r111, r112);
    L28:
        List<ViewPager.OnPageChangeListener> r118 = this.f194676k0;
        if (r118 == null) goto L36;
        int r119 = ((ArrayList) r118).size();
    L31:
        if (r100 >= r119) goto L36;
        ViewPager.OnPageChangeListener r120 = (ViewPager.OnPageChangeListener) ListProtector.get(this.f194676k0, r100);
        if (r120 == null) goto L35;
        r120.onPageScrolled(r110, r111, r112);
    L35:
        r100 = r100 + 1;
    L36:
        this.V = true;
    }

    public final void B(int r100, boolean r101, boolean r102, int r103) {
        PagerAdapter r104 = this.f194675k;
        boolean r105 = false;
        if (r104 != null) goto L5;
    L47:
        setScrollingCacheEnabled(false);
        return;
    L5:
        if (r104.getCount() <= 0) goto L47;
        if (r102 == true) goto L15;
        if (this.f194677l != r100) goto L15;
        if (this.f194672h.size() == 0) goto L15;
        setScrollingCacheEnabled(false);
        return;
    L15:
        if (r100 >= 0) goto L18;
        r100 = 0;
    L20:
        int r106 = this.C;
        int r107 = this.f194677l;
        if (r100 <= (r107 + r106)) goto L23;
    L24:
        int r108 = 0;
    L26:
        if (r108 >= this.f194672h.size()) goto L29;
        ((e) ListProtector.get(this.f194672h, r108)).f194707c = true;
        r108 = r108 + 1;
    L29:
        if (this.f194677l == r100) goto L31;
    L34:
        boolean r109 = true;
    L36:
        if (this.f194666b == true) goto L38;
        if (r101 == false) goto L38;
    L39:
        this.f194665a = r105;
        if (this.U == false) goto L45;
        this.f194677l = r100;
        if (r109 == false) goto L44;
        h(r100);
    L44:
        requestLayout();
        return;
    L45:
        w(r100);
        z(r100, r101, r103, r109);
        return;
    L38:
        r105 = true;
        goto L39
    L31:
        if (n() == true) goto L34;
        r109 = false;
        goto L36
    L23:
        if (r100 >= (r107 - r106)) goto L29;
    L18:
        if (r100 < this.f194675k.getCount()) goto L20;
        r100 = this.f194675k.getCount() - 1;
        goto L20
    }

    @Override // android.view.View
    public final void onSizeChanged(int r100, int r101, int r102, int r103) {
        super.onSizeChanged(r100, r101, r102, r103);
        if (r100 == r102) goto L6;
        int r104 = this.f194685s;
        x(r100, r102, r104, r104);
        return;
    }

    public final void x(int r100, int r101, int r102, int r103) {
        if (r101 > 0) goto L4;
    L9:
        e r104 = l(this.f194677l);
        if (r104 == null) goto L12;
        float r105 = Math.min(r104.f194709e, this.f194690x);
    L13:
        int r106 = (int) (r105 * ((r100 - getPaddingLeft()) - getPaddingRight()));
        if (r106 == getScrollX()) goto L19;
        f(false);
        scrollTo(r106, getScrollY());
        return;
    L19:
        return;
    L12:
        r105 = 0.0f;
        goto L13
    L4:
        if (this.f194672h.isEmpty() == true) goto L9;
        if (this.f194681p.isFinished() == true) goto L8;
        this.f194681p.setFinalX(getCurrentItem() * getClientWidth());
        return;
    L8:
        scrollTo((int) ((getScrollX() / (((r101 - getPaddingLeft()) - getPaddingRight()) + r103)) * (((r100 - getPaddingLeft()) - getPaddingRight()) + r102)), getScrollY());
    }

    public final void z(int r110, boolean r111, int r112, boolean r113) {
        e r100 = l(r110);
        if (r100 == null) goto L5;
        int r101 = (int) (getClientWidth() * Math.max(this.f194689w, Math.min(r100.f194709e, this.f194690x)));
    L6:
        if (r111 == true) goto L8;
        if (r113 == false) goto L36;
        h(r110);
    L36:
        f(false);
        scrollTo(r101, 0);
        t(r101);
        return;
    L8:
        if (getChildCount() != 0) goto L10;
        setScrollingCacheEnabled(false);
    L32:
        if (r113 == false) goto L38;
        h(r110);
        return;
    L38:
        return;
    L10:
        Scroller r114 = this.f194681p;
        if (r114 != null) goto L13;
    L15:
        boolean r115 = false;
    L16:
        if (r115 == true) goto L18;
        int r116 = getScrollX();
    L23:
        int r102 = r116;
        int r103 = getScrollY();
        int r104 = r101 - r102;
        int r105 = 0 - r103;
        if (r104 != 0) goto L27;
        if (r105 != 0) goto L27;
        f(false);
        v();
        setScrollState(0);
    L27:
        setScrollingCacheEnabled(true);
        setScrollState(2);
        int r117 = getClientWidth();
        int r106 = r117 / 2;
        float r118 = r117;
        float r107 = r106;
        float r108 = r107 + (((float) Math.sin((Math.min(1.0f, (Math.abs(r104) * 1.0f) / r118) - 0.5f) * 0.47123894f)) * r107);
        int r119 = Math.abs(r112);
        if (r119 <= 0) goto L30;
        int r120 = Math.round(Math.abs(r108 / r119) * 1000.0f) * 4;
    L31:
        int r109 = Math.min(r120, 600);
        this.f194683q = false;
        this.f194681p.startScroll(r102, r103, r104, r105, r109);
        ViewCompat.postInvalidateOnAnimation(this);
        goto L32
    L30:
        r120 = (int) (((Math.abs(r104) / ((r118 * this.f194675k.getPageWidth(this.f194677l)) + this.f194685s)) + 1.0f) * 100.0f);
        goto L31
    L18:
        if (this.f194683q == false) goto L20;
        r116 = this.f194681p.getCurrX();
    L21:
        this.f194681p.abortAnimation();
        setScrollingCacheEnabled(false);
        goto L23
    L20:
        r116 = this.f194681p.getStartX();
        goto L21
    L13:
        if (r114.isFinished() == true) goto L15;
        r115 = true;
        goto L16
    L5:
        r101 = 0;
        goto L6
    }

    public final boolean c(View r110, boolean r111, int r112, int r113, int r114) {
        boolean r100 = true;
        if ((r110 instanceof ViewGroup) == false) goto L18;
        ViewGroup r101 = (ViewGroup) r110;
        int r102 = r110.getScrollX();
        int r103 = r110.getScrollY();
        int r104 = r101.getChildCount() - 1;
    L5:
        if (r104 < 0) goto L18;
        View r105 = r101.getChildAt(r104);
        int r106 = r113 + r102;
        if (r106 < r105.getLeft()) goto L17;
        if (r106 >= r105.getRight()) goto L17;
        int r107 = r114 + r103;
        if (r107 < r105.getTop()) goto L17;
        if (r107 >= r105.getBottom()) goto L17;
        if (c(r105, true, r112, r106 - r105.getLeft(), r107 - r105.getTop()) == false) goto L17;
        return true;
    L17:
        r104 = r104 - 1;
    L18:
        if (r111 == true) goto L20;
    L22:
        r100 = false;
    L23:
        d(r110);
        return r100;
    L20:
        if (r110.canScrollHorizontally(-r112) == false) goto L22;
        goto L22
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean r110, int r210, int r211, int r212, int r213) {
        int r100 = getChildCount();
        int r101 = r212 - r210;
        int r102 = r213 - r211;
        int r103 = getPaddingLeft();
        int r104 = getPaddingTop();
        int r105 = getPaddingRight();
        int r106 = getPaddingBottom();
        int r107 = getScrollX();
        int r111 = 0;
        int r112 = 0;
    L4:
        if (r111 >= r100) goto L33;
        View r113 = getChildAt(r111);
        if (r113.getVisibility() == 8) goto L32;
        LayoutParams r114 = (LayoutParams) r113.getLayoutParams();
        if (r114.f194693a == false) goto L32;
        int r115 = r114.f194694b;
        int r116 = r115 & 7;
        int r117 = r115 & 112;
        if (r116 != 1) goto L12;
        int r118 = Math.max((r101 - r113.getMeasuredWidth()) / 2, r103);
    L19:
        int r119 = r118;
        int r120 = r103;
        r103 = r119;
    L21:
        if (r117 != 16) goto L23;
        int r121 = Math.max((r102 - r113.getMeasuredHeight()) / 2, r104);
    L30:
        int r122 = r121;
        int r123 = r104;
        r104 = r122;
    L31:
        int r108 = r103 + r107;
        r113.layout(r108, r104, r113.getMeasuredWidth() + r108, r104 + r113.getMeasuredHeight());
        r112 = r112 + 1;
        r104 = r123;
        r103 = r120;
        goto L32
    L23:
        if (r117 != 48) goto L25;
        r123 = r113.getMeasuredHeight() + r104;
        goto L31
    L25:
        if (r117 == 80) goto L27;
        r123 = r104;
        goto L31
    L27:
        r121 = (r102 - r106) - r113.getMeasuredHeight();
        r106 = r106 + r113.getMeasuredHeight();
        goto L30
    L12:
        if (r116 != 3) goto L14;
        r120 = r113.getMeasuredWidth() + r103;
        goto L21
    L14:
        if (r116 == 5) goto L16;
        r120 = r103;
        goto L21
    L16:
        r118 = (r101 - r105) - r113.getMeasuredWidth();
        r105 = r105 + r113.getMeasuredWidth();
    L32:
        r111 = r111 + 1;
        goto L4
    L33:
        int r109 = (r101 - r103) - r105;
        int r124 = 0;
    L34:
        if (r124 >= r100) goto L46;
        View r125 = getChildAt(r124);
        if (r125.getVisibility() == 8) goto L45;
        LayoutParams r126 = (LayoutParams) r125.getLayoutParams();
        if (r126.f194693a == true) goto L45;
        e r127 = j(r125);
        if (r127 == null) goto L45;
        float r128 = r109;
        int r129 = ((int) (r127.f194709e * r128)) + r103;
        if (r126.f194696d == false) goto L44;
        r126.f194696d = false;
        r125.measure(View.MeasureSpec.makeMeasureSpec((int) (r128 * r126.f194695c), 1073741824), View.MeasureSpec.makeMeasureSpec((r102 - r104) - r106, 1073741824));
    L44:
        r125.layout(r129, r104, r125.getMeasuredWidth() + r129, r125.getMeasuredHeight() + r104);
    L45:
        r124 = r124 + 1;
        goto L34
    L46:
        this.f194687u = r104;
        this.f194688v = r102 - r106;
        this.W = r112;
        if (this.U == false) goto L49;
        boolean r130 = false;
        z(this.f194677l, false, 0, false);
    L50:
        this.U = r130;
        return;
    L49:
        r130 = false;
        goto L50
    }
}
