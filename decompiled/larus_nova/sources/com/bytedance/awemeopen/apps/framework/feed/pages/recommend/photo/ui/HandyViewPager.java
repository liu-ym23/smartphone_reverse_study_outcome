package com.bytedance.awemeopen.apps.framework.feed.pages.recommend.photo.ui;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
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
import androidx.core.content.ContextCompat;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.customview.view.AbsSavedState;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.alipay.sdk.m.u.i;
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
public class HandyViewPager extends ViewGroup {
    public static final int[] W = null;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public static final a f195220k0 = null;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    public static final b f195221p0 = null;
    public int A;
    public int B;
    public float C;
    public float D;
    public float E;
    public float F;
    public int G;
    public VelocityTracker H;
    public int I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public int f195222J;
    public int K;
    public int L;
    public EdgeEffect M;
    public EdgeEffect N;
    public boolean O;
    public boolean P;
    public int Q;
    public List<ViewPager.OnPageChangeListener> R;
    public ViewPager.OnPageChangeListener S;
    public float T;
    public final c U;
    public int V;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f195223a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayList<e> f195224b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final e f195225c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Rect f195226d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public PagerAdapter f195227e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f195228f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f195229g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Parcelable f195230h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public ClassLoader f195231i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Scroller f195232j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f195233k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public g f195234l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f195235m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public Drawable f195236n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f195237o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f195238p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public float f195239q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public float f195240r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f195241s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f195242t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f195243u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f195244v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f195245w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f195246x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public boolean f195247y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f195248z;

    @Target({ElementType.TYPE})
    @Inherited
    @Retention(RetentionPolicy.RUNTIME)
    public @interface DecorView {
    }

    public static class LayoutParams extends ViewGroup.LayoutParams {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f195249a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f195250b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public float f195251c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f195252d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f195253e;

        public LayoutParams() {
            super(-1, -1);
            this.f195251c = 0.0f;
        }

        public LayoutParams(Context r100, AttributeSet r101) {
            super(r100, r101);
            this.f195251c = 0.0f;
            TypedArray r102 = r100.obtainStyledAttributes(r101, HandyViewPager.W);
            this.f195250b = r102.getInteger(0, 48);
            r102.recycle();
        }
    }

    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f195254a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Parcelable f195255b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final ClassLoader f195256c;

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
            return "FragmentPager.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " position=" + this.f195254a + i.f25855d;
        }

        public SavedState(Parcelable r100) {
            super(r100);
        }

        public SavedState(Parcel r100, ClassLoader r101) {
            super(r100, r101);
            if (r101 != null) goto L5;
            r101 = getClass().getClassLoader();
        L5:
            this.f195254a = r100.readInt();
            this.f195255b = r100.readParcelable(r101);
            this.f195256c = r101;
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public final void writeToParcel(Parcel r100, int r101) {
            super.writeToParcel(r100, r101);
            r100.writeInt(this.f195254a);
            r100.writeParcelable(this.f195255b, r101);
        }
    }

    public static class a implements Comparator<e> {
        public a() {
        }

        @Override // java.util.Comparator
        public final int compare(e r100, e r101) {
            return r100.f195261b - r101.f195261b;
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
        public final /* synthetic */ HandyViewPager f195257a;

        @Override // java.lang.Runnable
        public final void run() {
            this.f195257a.setScrollState(0);     // Catch: Throwable -> L4
            this.f195257a.r();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public c(HandyViewPager r100) {
            this.f195257a = r100;
        }
    }

    public class d implements OnApplyWindowInsetsListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Rect f195258a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ HandyViewPager f195259b;

        public d(HandyViewPager r100) {
            this.f195259b = r100;
            this.f195258a = new Rect();
        }

        @Override // androidx.core.view.OnApplyWindowInsetsListener
        public final WindowInsetsCompat onApplyWindowInsets(View r100, WindowInsetsCompat r101) {
            WindowInsetsCompat r102 = ViewCompat.onApplyWindowInsets(r100, r101);
            if (r102.isConsumed() == false) goto L5;
            return r102;
        L5:
            Rect r103 = this.f195258a;
            r103.left = r102.getSystemWindowInsetLeft();
            r103.top = r102.getSystemWindowInsetTop();
            r103.right = r102.getSystemWindowInsetRight();
            r103.bottom = r102.getSystemWindowInsetBottom();
            int r104 = this.f195259b.getChildCount();
            int r105 = 0;
        L6:
            if (r105 >= r104) goto L9;
            WindowInsetsCompat r106 = ViewCompat.dispatchApplyWindowInsets(this.f195259b.getChildAt(r105), r102);
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
        public Object f195260a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f195261b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f195262c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public float f195263d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public float f195264e;

        public e() {
        }
    }

    public class f extends AccessibilityDelegateCompat {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ HandyViewPager f195265a;

        public f(HandyViewPager r100) {
            this.f195265a = r100;
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public final void onInitializeAccessibilityEvent(View r100, AccessibilityEvent r101) {
            super.onInitializeAccessibilityEvent(r100, r101);
            r101.setClassName(ViewPager.class.getName());
            PagerAdapter r102 = this.f195265a.f195227e;
            if (r102 == null) goto L7;
            boolean r103 = true;
            if (r102.getCount() <= 1) goto L7;
        L8:
            r101.setScrollable(r103);
            if (r101.getEventType() != 4096) goto L14;
            PagerAdapter r104 = this.f195265a.f195227e;
            if (r104 == null) goto L15;
            r101.setItemCount(r104.getCount());
            r101.setFromIndex(this.f195265a.f195228f);
            r101.setToIndex(this.f195265a.f195228f);
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
            r101.setClassName(ViewPager.class.getName());
            PagerAdapter r102 = this.f195265a.f195227e;
            if (r102 != null) goto L5;
        L7:
            boolean r103 = false;
        L8:
            r101.setScrollable(r103);
            if (this.f195265a.canScrollHorizontally(1) == false) goto L12;
            r101.addAction(4096);
        L12:
            if (this.f195265a.canScrollHorizontally(-1) == false) goto L15;
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
            if (this.f195265a.canScrollHorizontally(-1) == false) goto L14;
            HandyViewPager r103 = this.f195265a;
            r103.setCurrentItem(r103.f195228f - 1);
            return true;
        L14:
            return false;
        L16:
            if (this.f195265a.canScrollHorizontally(1) == false) goto L19;
            HandyViewPager r104 = this.f195265a;
            r104.setCurrentItem(r104.f195228f + 1);
            return true;
        L19:
            return false;
        }
    }

    public class g extends DataSetObserver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ HandyViewPager f195266a;

        @Override // android.database.DataSetObserver
        public final void onChanged() {
            this.f195266a.f();
        }

        @Override // android.database.DataSetObserver
        public final void onInvalidated() {
            this.f195266a.f();
        }

        public g(HandyViewPager r100) {
            this.f195266a = r100;
        }
    }

    static {
        W = new int[]{R.attr.layout_gravity};
        f195220k0 = new a();
        f195221p0 = new b();
        PagerAdapter.class.getDeclaredField("mViewPagerObserver").setAccessible(true);     // Catch: NoSuchFieldException -> L5
        return;
    }

    @Override // android.view.View
    public final void computeScroll() {
        this.f195233k = true;
        if (this.f195232j.isFinished() == false) goto L5;
    L14:
        e(true);
        return;
    L5:
        if (this.f195232j.computeScrollOffset() == false) goto L14;
        int r100 = getScrollX();
        int r101 = getScrollY();
        int r102 = this.f195232j.getCurrX();
        int r103 = this.f195232j.getCurrY();
        if (r100 != r102) goto L9;
        if (r101 != r103) goto L9;
    L12:
        ViewCompat.postInvalidateOnAnimation(this);
        return;
    L9:
        scrollTo(r102, r103);
        if (p(r102) == true) goto L12;
        this.f195232j.abortAnimation();
        scrollTo(0, r103);
        goto L12
    }

    public final void l() {
        setWillNotDraw(false);
        setDescendantFocusability(262144);
        setFocusable(true);
        Context r100 = getContext();
        this.f195232j = new Scroller(r100, f195221p0);
        ViewConfiguration r101 = ViewConfiguration.get(r100);
        Resources r102 = r100.getResources();
        float r103 = WindowDisplayMetricsOverride.apply(r102, r102.getDisplayMetrics()).density;
        this.B = r101.getScaledPagingTouchSlop();
        this.I = (int) (400.0f * r103);
        this.f195222J = r101.getScaledMaximumFlingVelocity();
        this.M = new EdgeEffect(r100);
        this.N = new EdgeEffect(r100);
        this.K = (int) (25.0f * r103);
        this.L = (int) (2.0f * r103);
        this.f195248z = (int) (r103 * 16.0f);
        ViewCompat.setAccessibilityDelegate(this, new f(this));
        if (ViewCompat.getImportantForAccessibility(this) != 0) goto L5;
        ViewCompat.setImportantForAccessibility(this, 1);
    L5:
        ViewCompat.setOnApplyWindowInsetsListener(this, new d(this));
    }

    public final boolean u() {
        this.G = -1;
        this.f195246x = false;
        this.f195247y = false;
        VelocityTracker r100 = this.H;
        if (r100 == null) goto L5;
        r100.recycle();
        this.H = null;
    L5:
        this.M.onRelease();
        this.N.onRelease();
        if (this.M.isFinished() == false) goto L8;
    L9:
        return true;
    L8:
        if (this.N.isFinished() == true) goto L9;
        return false;
    }

    public final void f() {
        int r100 = this.f195227e.getCount();
        this.f195223a = r100;
        if (this.f195224b.size() < ((this.f195245w * 2) + 1)) goto L5;
    L7:
        boolean r101 = false;
    L8:
        int r102 = this.f195228f;
        int r103 = 0;
        boolean r104 = false;
    L10:
        if (r103 >= this.f195224b.size()) goto L30;
        e r105 = (e) ListProtector.get(this.f195224b, r103);
        int r106 = this.f195227e.getItemPosition(r105.f195260a);
        if (r106 == (-1)) goto L29;
        if (r106 != (-2)) goto L22;
        ListProtector.remove(this.f195224b, r103);
        r103 = r103 - 1;
        if (r104 == true) goto L19;
        this.f195227e.startUpdate(this);
        r104 = true;
    L19:
        this.f195227e.destroyItem(this, r105.f195261b, r105.f195260a);
        int r107 = this.f195228f;
        if (r107 != r105.f195261b) goto L28;
        r102 = Math.max(0, Math.min(r107, (-1) + r100));
    L28:
        r101 = true;
        goto L29
    L22:
        int r108 = r105.f195261b;
        if (r108 == r106) goto L29;
        if (r108 != this.f195228f) goto L27;
        r102 = r106;
    L27:
        r105.f195261b = r106;
    L29:
        r103 = r103 + 1;
        goto L10
    L30:
        if (r104 == false) goto L32;
        this.f195227e.finishUpdate(this);
    L32:
        Collections.sort(this.f195224b, f195220k0);
        if (r101 == false) goto L49;
        int r109 = getChildCount();
        int r110 = 0;
    L35:
        if (r110 >= r109) goto L40;
        LayoutParams r111 = (LayoutParams) getChildAt(r110).getLayoutParams();
        if (r111.f195249a == true) goto L39;
        r111.f195251c = 0.0f;
    L39:
        r110 = r110 + 1;
        goto L35
    L40:
        x(r102, false, true, 0);
        requestLayout();
        return;
    L49:
        return;
    L5:
        if (this.f195224b.size() >= r100) goto L7;
        r101 = true;
        goto L8
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams();
    }

    public final boolean o() {
        PagerAdapter r100 = this.f195227e;
        if (r100 != null) goto L5;
        return false;
    L5:
        if (this.f195228f >= (r100.getCount() - 1)) goto L10;
        w(this.f195228f + 1, true);
        return true;
    L10:
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        removeCallbacks(this.U);
        Scroller r100 = this.f195232j;
        if (r100 != null) goto L5;
    L7:
        super.onDetachedFromWindow();
        return;
    L5:
        if (r100.isFinished() == true) goto L7;
        this.f195232j.abortAnimation();
        goto L7
    }

    public final void r() {
        s(this.f195228f);
    }

    private int getClientWidth() {
        return (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable r100 = this.f195236n;
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.isStateful() == false) goto L9;
        r100.setState(getDrawableState());
        return;
    }

    public final e j() {
        int r100 = getClientWidth();
        float r101 = 0.0f;
        if (r100 <= 0) goto L5;
        float r102 = getScrollX() / r100;
    L6:
        if (r100 <= 0) goto L8;
        float r103 = this.f195235m / r100;
    L9:
        e r104 = null;
        float r105 = 0.0f;
        int r106 = -1;
        int r107 = 0;
        boolean r108 = true;
    L11:
        if (r107 >= this.f195224b.size()) goto L30;
        e r110 = (e) ListProtector.get(this.f195224b, r107);
        if (r108 == true) goto L17;
        int r109 = r106 + 1;
        if (r110.f195261b == r109) goto L17;
        r110 = this.f195225c;
        r110.f195264e = (r101 + r105) + r103;
        r110.f195261b = r109;
        r110.f195263d = this.f195227e.getPageWidth(r109);
        r107 = r107 - 1;
    L17:
        e r111 = r110;
        r101 = r111.f195264e;
        float r112 = (r111.f195263d + r101) + r103;
        if (r108 == true) goto L24;
        if (r102 >= r101) goto L24;
        return r104;
    L24:
        if (r102 < r112) goto L29;
        if (r107 == (this.f195224b.size() - 1)) goto L29;
        int r113 = r111.f195261b;
        float r114 = r111.f195263d;
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

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.O = true;
    }

    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        SavedState r100 = new SavedState(super.onSaveInstanceState());
        r100.f195254a = this.f195228f;
        PagerAdapter r101 = this.f195227e;
        if (r101 == null) goto L5;
        r100.f195255b = r101.saveState();
    L5:
        return r100;
    }

    public PagerAdapter getAdapter() {
        return this.f195227e;
    }

    public int getCurrentItem() {
        return this.f195228f;
    }

    public int getOffscreenPageLimit() {
        return this.f195245w;
    }

    public int getPageMargin() {
        return this.f195235m;
    }

    public HandyViewPager(Context r100) {
        super(r100);
        this.f195224b = new ArrayList();
        this.f195225c = new e();
        this.f195226d = new Rect();
        this.f195229g = -1;
        this.f195230h = null;
        this.f195231i = null;
        this.f195239q = -3.4028235E38f;
        this.f195240r = Float.MAX_VALUE;
        this.f195245w = 1;
        this.G = -1;
        this.O = true;
        this.T = 1.0f;
        this.U = new c(this);
        this.V = 0;
        l();
    }

    private void setScrollingCacheEnabled(boolean r100) {
        if (this.f195243u == r100) goto L6;
        this.f195243u = r100;
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void addTouchables(ArrayList<View> r100) {
        int r101 = 0;
    L4:
        if (r101 >= getChildCount()) goto L13;
        View r102 = getChildAt(r101);
        if (r102.getVisibility() != 0) goto L12;
        e r103 = i(r102);
        if (r103 == null) goto L12;
        if (r103.f195261b != this.f195228f) goto L12;
        r102.addTouchables(r100);
    L12:
        r101 = r101 + 1;
        goto L4
    }

    public final void b(ViewPager.OnPageChangeListener r100) {
        if (this.R != null) goto L5;
        this.R = new ArrayList();
    L5:
        this.R.add(r100);
    }

    public final boolean c(int r100) {
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
        int r108 = h(this.f195226d, r107).left;
        int r109 = h(this.f195226d, r101).left;
        if (r101 == null) goto L30;
        if (r108 < r109) goto L30;
        int r110 = this.f195228f;
        if (r110 <= 0) goto L48;
        w(r110 - 1, true);
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
        int r112 = h(this.f195226d, r107).left;
        int r113 = h(this.f195226d, r101).left;
        if (r101 == null) goto L37;
        if (r112 > r113) goto L37;
        r111 = o();
    L37:
        r111 = r107.requestFocus();
    L38:
        if (r100 == 17) goto L45;
        if (r100 == 1) goto L45;
        if (r100 != 66) goto L43;
    L44:
        r103 = o();
        goto L50
    L43:
        if (r100 != 2) goto L50;
    L45:
        int r114 = this.f195228f;
        if (r114 <= 0) goto L48;
        w(r114 - 1, true);
    L19:
        r101 = null;
        goto L20
    }

    @Override // android.view.View
    public boolean canScrollHorizontally(int r100) {
        if (this.f195227e != null) goto L5;
        return false;
    L5:
        int r101 = getClientWidth();
        int r102 = getScrollX();
        if (r100 < 0) goto L8;
        if (r100 > 0) goto L13;
        return false;
    L13:
        if (r102 >= ((int) (r101 * this.f195240r))) goto L18;
        return true;
    L18:
        return false;
    L8:
        if (r102 <= ((int) (r101 * this.f195239q))) goto L16;
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
        boolean r102 = c(2);
    L30:
        if (r102 == true) goto L35;
        return false;
    L35:
        return true;
    L17:
        if (r100.hasModifiers(1) == false) goto L29;
        r102 = c(1);
        goto L30
    L20:
        if (r100.hasModifiers(2) == false) goto L22;
        r102 = o();
        goto L30
    L22:
        r102 = c(66);
        goto L30
    L24:
        if (r100.hasModifiers(2) == false) goto L28;
        int r103 = this.f195228f;
        if (r103 <= 0) goto L29;
        w(r103 - 1, true);
        r102 = true;
        goto L30
    L28:
        r102 = c(17);
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
        e r104 = i(r103);
        if (r104 == null) goto L18;
        if (r104.f195261b != this.f195228f) goto L18;
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

    @Override // android.view.View
    public final void draw(Canvas r100) {
        super.draw(r100);
        int r101 = getOverScrollMode();
        boolean r102 = false;
        if (r101 == 0) goto L13;
        if (r101 != 1) goto L11;
        PagerAdapter r103 = this.f195227e;
        if (r103 == null) goto L11;
        if (r103.getCount() > 1) goto L13;
    L11:
        this.M.finish();
        this.N.finish();
    L18:
        if (r102 == false) goto L21;
        ViewCompat.postInvalidateOnAnimation(this);
        return;
    L21:
        return;
    L13:
        if (this.M.isFinished() == true) goto L16;
        int r104 = r100.save();
        int r105 = (getHeight() - getPaddingTop()) - getPaddingBottom();
        int r106 = getWidth();
        r100.rotate(270.0f);
        r100.translate((-r105) + getPaddingTop(), this.f195239q * r106);
        this.M.setSize(r105, r106);
        r102 = false | this.M.draw(r100);
        r100.restoreToCount(r104);
    L16:
        if (this.N.isFinished() == true) goto L18;
        int r107 = r100.save();
        int r108 = getWidth();
        int r109 = (getHeight() - getPaddingTop()) - getPaddingBottom();
        r100.rotate(90.0f);
        r100.translate(-getPaddingTop(), (-(this.f195240r + 1.0f)) * r108);
        this.N.setSize(r109, r108);
        r102 = r102 | this.N.draw(r100);
        r100.restoreToCount(r107);
        goto L18
    }

    public final void e(boolean r100) {
        if (this.V != 2) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == false) goto L15;
        setScrollingCacheEnabled(false);
        if ((!this.f195232j.isFinished()) == false) goto L15;
        this.f195232j.abortAnimation();
        int r102 = getScrollX();
        int r103 = getScrollY();
        int r104 = this.f195232j.getCurrX();
        int r105 = this.f195232j.getCurrY();
        if (r102 != r104) goto L12;
        if (r103 == r105) goto L15;
    L12:
        scrollTo(r104, r105);
        if (r104 == r102) goto L15;
        p(r104);
    L15:
        this.f195244v = false;
        int r106 = 0;
    L17:
        if (r106 >= this.f195224b.size()) goto L22;
        e r107 = (e) ListProtector.get(this.f195224b, r106);
        if (r107.f195262c == false) goto L21;
        r107.f195262c = false;
        r101 = true;
    L21:
        r106 = r106 + 1;
        goto L17
    L22:
        if (r101 == false) goto L30;
        if (r100 == false) goto L25;
        ViewCompat.postOnAnimation(this, this.U);
        return;
    L25:
        this.U.run();
        return;
    L30:
        return;
    L5:
        r101 = false;
        goto L6
    }

    public final void g(int r100) {
        ViewPager.OnPageChangeListener r101 = this.S;
        if (r101 == null) goto L5;
        r101.onPageSelected(r100);
    L5:
        List<ViewPager.OnPageChangeListener> r102 = this.R;
        if (r102 == null) goto L13;
        int r103 = ((ArrayList) r102).size();
        int r104 = 0;
    L8:
        if (r104 >= r103) goto L17;
        ViewPager.OnPageChangeListener r105 = (ViewPager.OnPageChangeListener) ListProtector.get(this.R, r104);
        if (r105 == null) goto L12;
        r105.onPageSelected(r100);
    L12:
        r104 = r104 + 1;
        goto L8
    L17:
        return;
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet r100) {
        return new LayoutParams(getContext(), r100);
    }

    public final e i(View r100) {
        int r101 = 0;
    L4:
        if (r101 >= this.f195224b.size()) goto L9;
        e r102 = (e) ListProtector.get(this.f195224b, r101);
        if (this.f195227e.isViewFromObject(r100, r102.f195260a) == true) goto L7;
        r101 = r101 + 1;
        goto L4
    L7:
        return r102;
    L9:
        return null;
    }

    public final e k(int r100) {
        int r101 = 0;
    L4:
        if (r101 >= this.f195224b.size()) goto L9;
        e r102 = (e) ListProtector.get(this.f195224b, r101);
        if (r102.f195261b == r100) goto L7;
        r101 = r101 + 1;
        goto L4
    L7:
        return r102;
    L9:
        return null;
    }

    public final void n(MotionEvent r100) {
        int r101 = r100.getActionIndex();
        if (r100.getPointerId(r101) != this.G) goto L11;
        if (r101 != 0) goto L6;
        int r102 = 1;
    L7:
        this.C = r100.getX(r102);
        this.G = r100.getPointerId(r102);
        VelocityTracker r103 = this.H;
        if (r103 == null) goto L12;
        r103.clear();
        return;
    L12:
        return;
    L6:
        r102 = 0;
        goto L7
    }

    @Override // android.view.View
    public final void onDraw(Canvas r110) {
        super.onDraw(r110);
        if (this.f195235m > 0) goto L5;
        return;
    L5:
        if (this.f195236n != null) goto L7;
        return;
    L7:
        if (this.f195224b.size() > 0) goto L9;
        return;
    L9:
        if (this.f195227e == null) goto L34;
        int r100 = getScrollX();
        int r101 = getWidth();
        float r102 = r101;
        float r103 = this.f195235m / r102;
        int r104 = 0;
        e r105 = (e) ListProtector.get(this.f195224b, 0);
        float r106 = r105.f195264e;
        int r107 = this.f195224b.size();
        int r108 = r105.f195261b;
        int r111 = ((e) ListProtector.get(this.f195224b, r107 - 1)).f195261b;
    L11:
        if (r108 >= r111) goto L35;
    L12:
        int r112 = r105.f195261b;
        if (r108 <= r112) goto L16;
        if (r104 >= r107) goto L16;
        r104 = r104 + 1;
        r105 = (e) ListProtector.get(this.f195224b, r104);
    L16:
        if (r108 != r112) goto L18;
        float r109 = r105.f195264e;
        float r113 = r105.f195263d;
        float r114 = (r109 + r113) * r102;
        r106 = (r109 + r113) + r103;
    L20:
        if ((this.f195235m + r114) <= r100) goto L24;
        this.f195236n.setBounds(Math.round(r114), this.f195237o, Math.round(this.f195235m + r114), this.f195238p);
        this.f195236n.draw(r110);
    L24:
        if (r114 > (r100 + r101)) goto L36;
        r108 = r108 + 1;
        r103 = r103;
        goto L11
    L36:
        return;
    L18:
        float r115 = this.f195227e.getPageWidth(r108);
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
    L74:
        u();
        return false;
    L5:
        if (r100 == 1) goto L74;
        if (r100 == 0) goto L15;
        if (this.f195246x == false) goto L12;
        return true;
    L12:
        if (this.f195247y == false) goto L15;
        return false;
    L15:
        if (r100 == 0) goto L60;
        if (r100 != 2) goto L18;
        int r101 = this.G;
        if (r101 == (-1)) goto L70;
        int r102 = r110.findPointerIndex(r101);
        float r103 = r110.getX(r102);
        float r104 = r103 - this.C;
        float r105 = Math.abs(r104);
        float r106 = r110.getY(r102);
        float r107 = Math.abs(r106 - this.F);
        if (r104 == 0.0f) goto L40;
        float r108 = this.C;
        if (r108 >= this.A) goto L30;
        if (r104 <= 0.0f) goto L30;
    L33:
        boolean r109 = true;
    L35:
        if (r109 == true) goto L40;
        if (d(this, false, (int) r104, (int) r103, (int) r106) == false) goto L40;
        this.C = r103;
        this.D = r106;
        this.f195247y = true;
        return false;
    L30:
        if (r108 > (getWidth() - this.A)) goto L32;
    L34:
        r109 = false;
        goto L35
    L32:
        if (r104 >= 0.0f) goto L34;
    L40:
        float r111 = this.B;
        if (r105 <= r111) goto L53;
        if ((r105 * this.T) <= r107) goto L53;
        this.f195246x = true;
        ViewParent r112 = getParent();
        if (r112 == null) goto L47;
        r112.requestDisallowInterceptTouchEvent(true);
    L47:
        setScrollState(1);
        float r113 = this.E;
        float r114 = this.B;
        if (r104 <= 0.0f) goto L50;
        float r115 = r113 + r114;
    L51:
        this.C = r115;
        this.D = r106;
        setScrollingCacheEnabled(true);
    L56:
        if (this.f195246x == false) goto L70;
        if (q(r103) == false) goto L70;
        ViewCompat.postInvalidateOnAnimation(this);
        goto L70
    L50:
        r115 = r113 - r114;
    L53:
        if (r107 <= r111) goto L56;
        this.f195247y = true;
    L70:
        if (this.H != null) goto L72;
        this.H = VelocityTracker.obtain();
    L72:
        this.H.addMovement(r110);
        return this.f195246x;
    L18:
        if (r100 != 6) goto L70;
        n(r110);
        goto L70
    L60:
        float r116 = r110.getX();
        this.E = r116;
        this.C = r116;
        float r117 = r110.getY();
        this.F = r117;
        this.D = r117;
        this.G = r110.getPointerId(0);
        this.f195247y = false;
        this.f195233k = true;
        this.f195232j.computeScrollOffset();
        if (this.V == 2) goto L63;
    L68:
        e(false);
        this.f195246x = false;
        goto L70
    L63:
        if (Math.abs(this.f195232j.getFinalX() - this.f195232j.getCurrX()) <= this.L) goto L68;
        this.f195232j.abortAnimation();
        this.f195244v = false;
        r();
        this.f195246x = true;
        ViewParent r118 = getParent();
        if (r118 == null) goto L67;
        r118.requestDisallowInterceptTouchEvent(true);
    L67:
        setScrollState(1);
        goto L70
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable r100) {
        if ((r100 instanceof SavedState) == true) goto L6;
        super.onRestoreInstanceState(r100);
        return;
    L6:
        SavedState r101 = (SavedState) r100;
        super.onRestoreInstanceState(r101.getSuperState());
        PagerAdapter r102 = this.f195227e;
        if (r102 == null) goto L9;
        r102.restoreState(r101.f195255b, r101.f195256c);
        x(r101.f195254a, false, true, 0);
        return;
    L9:
        this.f195229g = r101.f195254a;
        this.f195230h = r101.f195255b;
        this.f195231i = r101.f195256c;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent r110) {
        boolean r100 = false;
        if (r110.getAction() == 0) goto L5;
    L7:
        PagerAdapter r101 = this.f195227e;
        if (r101 != null) goto L10;
    L77:
        return false;
    L10:
        if (r101.getCount() == 0) goto L77;
        if (this.H != null) goto L15;
        this.H = VelocityTracker.obtain();
    L15:
        this.H.addMovement(r110);
        int r102 = r110.getAction() & 255;
        if (r102 != 0) goto L18;
        this.f195232j.abortAnimation();
        this.f195244v = false;
        r();
        float r103 = r110.getX();
        this.E = r103;
        this.C = r103;
        float r104 = r110.getY();
        this.F = r104;
        this.D = r104;
        this.G = r110.getPointerId(0);
    L74:
        if (r100 == false) goto L76;
        ViewCompat.postInvalidateOnAnimation(this);
    L76:
        return true;
    L18:
        if (r102 == 1) goto L56;
        if (r102 == 2) goto L34;
        if (r102 == 3) goto L31;
        if (r102 != 5) goto L26;
        int r105 = r110.getActionIndex();
        this.C = r110.getX(r105);
        this.G = r110.getPointerId(r105);
        goto L74
    L26:
        if (r102 != 6) goto L74;
        n(r110);
        this.C = r110.getX(r110.findPointerIndex(this.G));
        goto L74
    L31:
        if (this.f195246x == false) goto L74;
        v(this.f195228f, true, 0, false);
        r100 = u();
        goto L74
    L34:
        if (this.f195246x == true) goto L53;
        int r106 = r110.findPointerIndex(this.G);
        if (r106 != (-1)) goto L38;
        r100 = u();
        goto L74
    L38:
        float r107 = r110.getX(r106);
        float r108 = Math.abs(r107 - this.C);
        float r109 = r110.getY(r106);
        float r111 = Math.abs(r109 - this.D);
        if (r108 <= this.B) goto L53;
        if ((r108 * this.T) <= r111) goto L53;
        this.f195246x = true;
        ViewParent r112 = getParent();
        if (r112 == null) goto L45;
        r112.requestDisallowInterceptTouchEvent(true);
    L45:
        float r113 = this.E;
        if ((r107 - r113) <= 0.0f) goto L48;
        float r114 = r113 + this.B;
    L49:
        this.C = r114;
        this.D = r109;
        setScrollState(1);
        setScrollingCacheEnabled(true);
        ViewParent r115 = getParent();
        if (r115 == null) goto L53;
        r115.requestDisallowInterceptTouchEvent(true);
        goto L53
    L48:
        r114 = r113 - this.B;
    L53:
        if (this.f195246x == false) goto L74;
        r100 = false | q(r110.getX(r110.findPointerIndex(this.G)));
        goto L74
    L56:
        if (this.f195246x == false) goto L74;
        VelocityTracker r116 = this.H;
        r116.computeCurrentVelocity(1000, this.f195222J);
        int r117 = (int) r116.getXVelocity(this.G);
        this.f195244v = true;
        int r118 = getClientWidth();
        int r119 = getScrollX();
        e r120 = j();
        float r121 = r118;
        float r122 = this.f195235m / r121;
        int r123 = r120.f195261b;
        float r124 = ((r119 / r121) - r120.f195264e) / (r120.f195263d + r122);
        if (Math.abs((int) (r110.getX(r110.findPointerIndex(this.G)) - this.E)) <= this.K) goto L65;
        if (Math.abs(r117) <= this.I) goto L65;
        if (r117 > 0) goto L70;
        r123 = r123 + 1;
    L70:
        if (this.f195224b.size() <= 0) goto L72;
        e r125 = (e) ListProtector.get(this.f195224b, 0);
        ArrayList<e> r126 = this.f195224b;
        r123 = Math.max(r125.f195261b, Math.min(r123, ((e) ListProtector.get(r126, r126.size() - 1)).f195261b));
    L72:
        x(r123, true, true, r117);
        r100 = u();
    L65:
        if (r123 < this.f195228f) goto L67;
        float r127 = 0.4f;
    L68:
        r123 = r123 + ((int) (r124 + r127));
        goto L70
    L67:
        r127 = 0.6f;
        goto L68
    L5:
        if (r110.getEdgeFlags() == 0) goto L7;
        return false;
    }

    public final boolean p(int r100) {
        if (this.f195224b.size() == 0) goto L5;
        e r101 = j();
        int r102 = getClientWidth();
        int r103 = this.f195235m;
        int r104 = r102 + r103;
        float r105 = r102;
        int r106 = r101.f195261b;
        float r107 = ((r100 / r105) - r101.f195264e) / (r101.f195263d + (r103 / r105));
        this.P = false;
        m(r106, r107, (int) (r104 * r107));
        if (this.P == false) goto L17;
        return true;
    L17:
        throw new IllegalStateException("onPageScrolled did not call superclass implementation");
    L5:
        if (this.O == false) goto L7;
        return false;
    L7:
        this.P = false;
        m(0, 0.0f, 0);
        if (this.P == false) goto L11;
        return false;
    L11:
        throw new IllegalStateException("onPageScrolled did not call superclass implementation");
    }

    public final boolean q(float r110) {
        float r100 = this.C - r110;
        this.C = r110;
        float r111 = getScrollX() + r100;
        float r101 = getClientWidth();
        float r102 = this.f195239q * r101;
        float r103 = this.f195240r * r101;
        boolean r104 = false;
        e r105 = (e) ListProtector.get(this.f195224b, 0);
        ArrayList<e> r106 = this.f195224b;
        e r107 = (e) ListProtector.get(r106, r106.size() - 1);
        if (r105.f195261b == 0) goto L5;
        r102 = r105.f195264e * r101;
        boolean r108 = false;
    L7:
        if (r107.f195261b == (this.f195227e.getCount() - 1)) goto L9;
        r103 = r107.f195264e * r101;
        boolean r109 = false;
    L11:
        if (r111 >= r102) goto L16;
        if (r108 == false) goto L14;
        this.M.onPull(Math.abs(r102 - r111) / r101);
        r104 = true;
    L14:
        r111 = r102;
    L20:
        int r112 = (int) r111;
        this.C += r111 - r112;
        scrollTo(r112, getScrollY());
        p(r112);
        return r104;
    L16:
        if (r111 <= r103) goto L20;
        if (r109 == false) goto L19;
        this.N.onPull(Math.abs(r111 - r103) / r101);
        r104 = true;
    L19:
        r111 = r103;
        goto L20
    L9:
        r109 = true;
        goto L11
    L5:
        r108 = true;
        goto L7
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public final void removeView(View r100) {
        if (this.f195242t == false) goto L5;
        removeViewInLayout(r100);
        return;
    L5:
        super.removeView(r100);
    }

    public final void s(int r110) {
        int r100 = this.f195228f;
        if (r100 == r110) goto L5;
        e r101 = k(r100);
        this.f195228f = r110;
    L7:
        if (this.f195227e != null) goto L10;
        return;
    L10:
        if (this.f195244v == false) goto L13;
        return;
    L13:
        if (getWindowToken() != null) goto L15;
        return;
    L15:
        this.f195227e.startUpdate(this);
        int r111 = this.f195245w;
        int r102 = Math.max(0, this.f195228f - r111);
        int r103 = this.f195227e.getCount();
        int r112 = Math.min(r103 - 1, this.f195228f + r111);
        if (r103 != this.f195223a) goto L206;
        int r104 = 0;
    L19:
        if (r104 >= this.f195224b.size()) goto L25;
        e r105 = (e) ListProtector.get(this.f195224b, r104);
        int r106 = r105.f195261b;
        int r107 = this.f195228f;
        if (r106 >= r107) goto L22;
        r104 = r104 + 1;
        goto L19
    L22:
        if (r106 != r107) goto L25;
    L26:
        if (r105 != null) goto L30;
        if (r103 <= 0) goto L30;
        r105 = a(this.f195228f, r104);
    L30:
        if (r105 == null) goto L163;
        int r108 = r104 - 1;
        if (r108 < 0) goto L34;
        e r109 = (e) ListProtector.get(this.f195224b, r108);
    L35:
        int r113 = getClientWidth();
        if (r113 > 0) goto L38;
        float r114 = 0.0f;
    L39:
        int r115 = this.f195228f - 1;
        float r116 = 0.0f;
    L40:
        if (r115 < 0) goto L64;
        if (r116 < r114) goto L53;
        if (r115 >= r102) goto L53;
        if (r109 == null) goto L64;
        if (r115 != r109.f195261b) goto L63;
        if (r109.f195262c == true) goto L63;
        ListProtector.remove(this.f195224b, r108);
        this.f195227e.destroyItem(this, r115, r109.f195260a);
        r108 = r108 - 1;
        r104 = r104 - 1;
        if (r108 < 0) goto L62;
        r109 = (e) ListProtector.get(this.f195224b, r108);
    L62:
        r109 = null;
    L63:
        r115 = r115 - 1;
    L53:
        if (r109 != null) goto L55;
    L59:
        r116 = r116 + a(r115, r108 + 1).f195263d;
        r104 = r104 + 1;
        if (r108 < 0) goto L62;
        r109 = (e) ListProtector.get(this.f195224b, r108);
        goto L63
    L55:
        if (r115 != r109.f195261b) goto L59;
        r116 = r116 + r109.f195263d;
        r108 = r108 - 1;
        if (r108 < 0) goto L62;
        r109 = (e) ListProtector.get(this.f195224b, r108);
    L64:
        float r117 = r105.f195263d;
        int r118 = r104 + 1;
        if (r117 < 2.0f) goto L67;
    L98:
        int r119 = this.f195227e.getCount();
        int r120 = getClientWidth();
        if (r120 <= 0) goto L101;
        float r121 = this.f195235m / r120;
    L102:
        if (r101 == null) goto L134;
        int r122 = r101.f195261b;
        int r123 = r105.f195261b;
        if (r122 >= r123) goto L120;
        float r124 = (r101.f195264e + r101.f195263d) + r121;
        int r125 = r122 + 1;
        int r126 = 0;
    L107:
        if (r125 > r105.f195261b) goto L134;
        if (r126 >= this.f195224b.size()) goto L134;
        Object r127 = ListProtector.get(this.f195224b, r126);
    L111:
        e r128 = (e) r127;
        if (r125 <= r128.f195261b) goto L117;
        if (r126 >= (this.f195224b.size() - 1)) goto L117;
        r126 = r126 + 1;
        r127 = ListProtector.get(this.f195224b, r126);
    L117:
        if (r125 >= r128.f195261b) goto L119;
        r124 = r124 + (this.f195227e.getPageWidth(r125) + r121);
        r125 = r125 + 1;
        goto L117
    L119:
        r128.f195264e = r124;
        r124 = r124 + (r128.f195263d + r121);
        r125 = r125 + 1;
        goto L107
    L120:
        if (r122 <= r123) goto L134;
        int r129 = this.f195224b.size() - 1;
        float r130 = r101.f195264e;
    L122:
        r122 = r122 - 1;
        if (r122 < r105.f195261b) goto L134;
        if (r129 < 0) goto L134;
        Object r131 = ListProtector.get(this.f195224b, r129);
    L126:
        e r132 = (e) r131;
        if (r122 >= r132.f195261b) goto L131;
        if (r129 <= 0) goto L131;
        r129 = r129 - 1;
        r131 = ListProtector.get(this.f195224b, r129);
    L131:
        if (r122 <= r132.f195261b) goto L133;
        r130 = r130 - (this.f195227e.getPageWidth(r122) + r121);
        r122 = r122 - 1;
        goto L131
    L133:
        r130 = r130 - (r132.f195263d + r121);
        r132.f195264e = r130;
    L134:
        int r133 = this.f195224b.size();
        float r134 = r105.f195264e;
        int r135 = r105.f195261b;
        int r136 = r135 - 1;
        if (r135 != 0) goto L137;
        float r137 = r134;
    L138:
        this.f195239q = r137;
        int r138 = r119 - 1;
        if (r135 != r138) goto L141;
        float r139 = (r105.f195263d + r134) - 1.0f;
    L142:
        this.f195240r = r139;
        int r140 = r104 - 1;
    L143:
        if (r140 < 0) goto L152;
        e r141 = (e) ListProtector.get(this.f195224b, r140);
    L145:
        int r142 = r141.f195261b;
        if (r136 <= r142) goto L148;
        r134 = r134 - (this.f195227e.getPageWidth(r136) + r121);
        r136 = r136 - 1;
        goto L145
    L148:
        r134 = r134 - (r141.f195263d + r121);
        r141.f195264e = r134;
        if (r142 != 0) goto L151;
        this.f195239q = r134;
    L151:
        r140 = r140 - 1;
        r136 = r136 - 1;
        goto L143
    L152:
        float r143 = (r105.f195264e + r105.f195263d) + r121;
        int r144 = r105.f195261b;
    L153:
        r144 = r144 + 1;
        if (r118 >= r133) goto L162;
        e r145 = (e) ListProtector.get(this.f195224b, r118);
    L156:
        int r146 = r145.f195261b;
        if (r144 >= r146) goto L159;
        r143 = r143 + (this.f195227e.getPageWidth(r144) + r121);
        r144 = r144 + 1;
        goto L156
    L159:
        if (r146 != r138) goto L161;
        this.f195240r = (r145.f195263d + r143) - 1.0f;
    L161:
        r145.f195264e = r143;
        r143 = r143 + (r145.f195263d + r121);
        r118 = r118 + 1;
        goto L153
    L162:
        this.f195227e.setPrimaryItem(this, this.f195228f, r105.f195260a);
        goto L163
    L141:
        r139 = Float.MAX_VALUE;
        goto L142
    L137:
        r137 = -3.4028235E38f;
        goto L138
    L101:
        r121 = 0.0f;
        goto L102
    L67:
        if (r118 >= this.f195224b.size()) goto L69;
        e r147 = (e) ListProtector.get(this.f195224b, r118);
    L70:
        if (r113 > 0) goto L72;
        float r148 = 0.0f;
    L73:
        int r149 = this.f195228f + 1;
        int r150 = r118;
    L74:
        if (r149 >= r103) goto L98;
        if (r117 < r148) goto L87;
        if (r149 <= r112) goto L87;
        if (r147 == null) goto L98;
        if (r149 != r147.f195261b) goto L97;
        if (r147.f195262c == true) goto L97;
        ListProtector.remove(this.f195224b, r150);
        this.f195227e.destroyItem(this, r149, r147.f195260a);
        if (r150 >= this.f195224b.size()) goto L96;
        r147 = (e) ListProtector.get(this.f195224b, r150);
    L96:
        r147 = null;
    L97:
        r149 = r149 + 1;
    L87:
        if (r147 != null) goto L89;
    L93:
        e r151 = a(r149, r150);
        r150 = r150 + 1;
        r117 = r117 + r151.f195263d;
        if (r150 >= this.f195224b.size()) goto L96;
        r147 = (e) ListProtector.get(this.f195224b, r150);
        goto L97
    L89:
        if (r149 != r147.f195261b) goto L93;
        r117 = r117 + r147.f195263d;
        r150 = r150 + 1;
        if (r150 >= this.f195224b.size()) goto L96;
        r147 = (e) ListProtector.get(this.f195224b, r150);
        goto L97
    L72:
        r148 = (getPaddingRight() / r113) + 2.0f;
        goto L73
    L69:
        r147 = null;
        goto L70
    L38:
        r114 = (2.0f - r105.f195263d) + (getPaddingLeft() / r113);
        goto L39
    L34:
        r109 = null;
    L163:
        this.f195227e.finishUpdate(this);
        int r152 = getChildCount();
        int r153 = 0;
    L164:
        if (r153 >= r152) goto L174;
        View r154 = getChildAt(r153);
        LayoutParams r155 = (LayoutParams) r154.getLayoutParams();
        r155.f195253e = r153;
        if (r155.f195249a == true) goto L172;
        if (r155.f195251c != 0.0f) goto L172;
        e r156 = i(r154);
        if (r156 == null) goto L172;
        r155.f195251c = r156.f195263d;
        int r157 = r156.f195261b;
        r155.getClass();
    L172:
        r153 = r153 + 1;
        goto L164
    L174:
        if (hasFocus() == false) goto L200;
        View r158 = findFocus();
        if (r158 == null) goto L185;
    L177:
        Object r159 = r158.getParent();
        if (r159 == this) goto L184;
        if (r159 == null) goto L185;
        if ((r159 instanceof View) == false) goto L185;
        r158 = (View) r159;
        goto L177
    L184:
        e r160 = i(r158);
    L186:
        if (r160 != null) goto L188;
    L189:
        int r161 = 0;
    L191:
        if (r161 >= getChildCount()) goto L261;
        View r162 = getChildAt(r161);
        e r163 = i(r162);
        if (r163 == null) goto L199;
        if (r163.f195261b != this.f195228f) goto L199;
        if (r162.requestFocus(2) == false) goto L199;
        return;
    L199:
        r161 = r161 + 1;
        goto L191
    L261:
        return;
    L188:
        if (r160.f195261b != this.f195228f) goto L189;
        return;
    L185:
        r160 = null;
        goto L186
    L200:
        return;
    L25:
        r105 = null;
        goto L26
    L206:
        String r164 = getResources().getResourceName(getId());     // Catch: Resources.NotFoundException -> L203
    L205:
        throw new IllegalStateException("The application's PagerAdapter changed the adapter's contents without calling PagerAdapter#notifyDataSetChanged! Expected adapter item count: " + this.f195223a + ", found: " + r103 + " Pager id: " + r164 + " Pager class: " + getClass() + " Problematic adapter: " + this.f195227e.getClass());
    L203:
        r164 = Integer.toHexString(getId());
        goto L205
    L5:
        r101 = null;
        goto L7
    }

    public void setAdapter(PagerAdapter r100) {
        PagerAdapter r101 = this.f195227e;
        if (r101 == null) goto L16;
        y(r101, null);
        this.f195227e.startUpdate(this);
        int r102 = 0;
    L6:
        if (r102 >= this.f195224b.size()) goto L8;
        e r103 = (e) ListProtector.get(this.f195224b, r102);
        this.f195227e.destroyItem(this, r103.f195261b, r103.f195260a);
        r102 = r102 + 1;
        goto L6
    L8:
        this.f195227e.finishUpdate(this);
        this.f195224b.clear();
        int r104 = 0;
    L10:
        if (r104 >= getChildCount()) goto L15;
        if (((LayoutParams) getChildAt(r104).getLayoutParams()).f195249a == true) goto L14;
        removeViewAt(r104);
        r104 = r104 - 1;
    L14:
        r104 = r104 + 1;
        goto L10
    L15:
        this.f195228f = 0;
        scrollTo(0, 0);
    L16:
        this.f195227e = r100;
        this.f195223a = 0;
        if (r100 != null) goto L19;
        return;
    L19:
        if (this.f195234l != null) goto L21;
        this.f195234l = new g(this);
    L21:
        y(this.f195227e, this.f195234l);
        this.f195244v = false;
        boolean r105 = this.O;
        this.O = true;
        this.f195223a = this.f195227e.getCount();
        if (this.f195229g < 0) goto L24;
        this.f195227e.restoreState(this.f195230h, this.f195231i);
        x(this.f195229g, false, true, 0);
        this.f195229g = -1;
        this.f195230h = null;
        this.f195231i = null;
        return;
    L24:
        if (r105 == true) goto L26;
        r();
        return;
    L26:
        requestLayout();
    }

    public void setCurrentItem(int r100) {
        this.f195244v = false;
        x(r100, !this.O, false, 0);
    }

    public void setOffscreenPageLimit(int r100) {
        if (r100 >= 1) goto L6;
        r100 = 1;
    L6:
        if (r100 == this.f195245w) goto L9;
        this.f195245w = r100;
        r();
        return;
    }

    public void setOffscreenPageLimitNoPopulate(int r100) {
        if (r100 >= 0) goto L4;
        return;
    L4:
        this.f195245w = r100;
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener r100) {
        this.S = r100;
    }

    public void setPageMargin(int r100) {
        int r101 = this.f195235m;
        this.f195235m = r100;
        int r102 = getWidth();
        t(r102, r102, r100, r101);
        requestLayout();
    }

    public void setPageMarginDrawable(Drawable r100) {
        this.f195236n = r100;
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

    public void setPagerDegreeFraction(float r100) {
        if (r100 > 0.0f) goto L5;
        return;
    L5:
        this.T = r100;
    }

    public void setScrollState(int r100) {
        if (this.V != r100) goto L5;
        return;
    L5:
        this.V = r100;
        ViewPager.OnPageChangeListener r101 = this.S;
        if (r101 == null) goto L8;
        r101.onPageScrollStateChanged(r100);
    L8:
        List<ViewPager.OnPageChangeListener> r102 = this.R;
        if (r102 == null) goto L16;
        int r103 = ((ArrayList) r102).size();
        int r104 = 0;
    L11:
        if (r104 >= r103) goto L20;
        ViewPager.OnPageChangeListener r105 = (ViewPager.OnPageChangeListener) ListProtector.get(this.R, r104);
        if (r105 == null) goto L15;
        r105.onPageScrollStateChanged(r100);
    L15:
        r104 = r104 + 1;
        goto L11
    L20:
        return;
    }

    public void setScroller(Scroller r100) {
        this.f195232j = r100;
    }

    @Override // android.view.View
    public final boolean verifyDrawable(Drawable r100) {
        if (super.verifyDrawable(r100) == false) goto L5;
    L8:
        return true;
    L5:
        if (r100 == this.f195236n) goto L8;
        return false;
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams r100) {
        return generateDefaultLayoutParams();
    }

    public void setPageMarginDrawable(int r100) {
        setPageMarginDrawable(ContextCompat.getDrawable(getContext(), r100));
    }

    public HandyViewPager(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.f195224b = new ArrayList();
        this.f195225c = new e();
        this.f195226d = new Rect();
        this.f195229g = -1;
        this.f195230h = null;
        this.f195231i = null;
        this.f195239q = -3.4028235E38f;
        this.f195240r = Float.MAX_VALUE;
        this.f195245w = 1;
        this.G = -1;
        this.O = true;
        this.T = 1.0f;
        this.U = new c(this);
        this.V = 0;
        l();
    }

    public static void y(PagerAdapter r100, g r101) {
        Method r102 = PagerAdapter.class.getDeclaredMethod("setViewPagerObserver", new Class[]{DataSetObserver.class});     // Catch: Exception -> L4
        r102.setAccessible(true);     // Catch: Exception -> L4
        r102.invoke(r100, new Object[]{r101});     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
    }

    public final e a(int r100, int r101) {
        e r102 = new e();
        r102.f195261b = r100;
        r102.f195260a = this.f195227e.instantiateItem(this, r100);
        r102.f195263d = this.f195227e.getPageWidth(r100);
        if (r101 >= 0) goto L5;
    L8:
        this.f195224b.add(r102);
    L9:
        return r102;
    L5:
        if (r101 >= this.f195224b.size()) goto L8;
        ListProtector.add(this.f195224b, r101, r102);
        goto L9
    }

    @Override // android.view.ViewGroup
    public final int getChildDrawingOrder(int r100, int r101) {
        return ((LayoutParams) ((View) ListProtector.get(null, r101)).getLayoutParams()).f195253e;
    }

    public final Rect h(Rect r100, View r101) {
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
        this.A = Math.min(r112 / 10, this.f195248z);
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
        if (r106.f195249a == false) goto L48;
        int r107 = r106.f195250b;
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
        this.f195241s = View.MeasureSpec.makeMeasureSpec(r114, 1073741824);
        this.f195242t = true;
        r();
        this.f195242t = false;
        int r120 = getChildCount();
    L50:
        if (r100 >= r120) goto L59;
        View r121 = getChildAt(r100);
        if (r121.getVisibility() == 8) goto L58;
        LayoutParams r122 = (LayoutParams) r121.getLayoutParams();
        if (r122 != null) goto L56;
    L57:
        r121.measure(View.MeasureSpec.makeMeasureSpec((int) (r113 * r122.f195251c), 1073741824), this.f195241s);
        goto L58
    L56:
        if (r122.f195249a == false) goto L57;
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
        e r106 = i(r105);
        if (r106 == null) goto L16;
        if (r106.f195261b != this.f195228f) goto L16;
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

    public final void w(int r100, boolean r101) {
        this.f195244v = false;
        x(r100, r101, false, 0);
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
        e r107 = i(r106);
        if (r107 == null) goto L14;
        if (r107.f195261b != this.f195228f) goto L14;
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
        boolean r104 = r103.f195249a;
        if (r100.getClass().getAnnotation(DecorView.class) == null) goto L8;
        boolean r105 = true;
    L9:
        boolean r106 = r104 | r105;
        r103.f195249a = r106;
        if (this.f195242t == false) goto L15;
        if (r106 == true) goto L14;
        r103.f195252d = true;
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

    public final void m(int r110, float r111, int r112) {
        int r100 = 0;
        if (this.Q <= 0) goto L25;
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
        if (r108.f195249a == false) goto L24;
        int r109 = r108.f195250b & 7;
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
        ViewPager.OnPageChangeListener r117 = this.S;
        if (r117 == null) goto L28;
        r117.onPageScrolled(r110, r111, r112);
    L28:
        List<ViewPager.OnPageChangeListener> r118 = this.R;
        if (r118 == null) goto L36;
        int r119 = ((ArrayList) r118).size();
    L31:
        if (r100 >= r119) goto L36;
        ViewPager.OnPageChangeListener r120 = (ViewPager.OnPageChangeListener) ListProtector.get(this.R, r100);
        if (r120 == null) goto L35;
        r120.onPageScrolled(r110, r111, r112);
    L35:
        r100 = r100 + 1;
    L36:
        this.P = true;
    }

    @Override // android.view.View
    public final void onSizeChanged(int r100, int r101, int r102, int r103) {
        super.onSizeChanged(r100, r101, r102, r103);
        if (r100 == r102) goto L6;
        int r104 = this.f195235m;
        t(r100, r102, r104, r104);
        return;
    }

    public final void t(int r100, int r101, int r102, int r103) {
        if (r101 > 0) goto L4;
    L9:
        e r104 = k(this.f195228f);
        if (r104 == null) goto L12;
        float r105 = Math.min(r104.f195264e, this.f195240r);
    L13:
        int r106 = (int) (r105 * ((r100 - getPaddingLeft()) - getPaddingRight()));
        if (r106 == getScrollX()) goto L19;
        e(false);
        scrollTo(r106, getScrollY());
        return;
    L19:
        return;
    L12:
        r105 = 0.0f;
        goto L13
    L4:
        if (this.f195224b.isEmpty() == true) goto L9;
        if (this.f195232j.isFinished() == true) goto L8;
        this.f195232j.setFinalX(getCurrentItem() * getClientWidth());
        return;
    L8:
        scrollTo((int) ((getScrollX() / (((r101 - getPaddingLeft()) - getPaddingRight()) + r103)) * (((r100 - getPaddingLeft()) - getPaddingRight()) + r102)), getScrollY());
    }

    public final void v(int r110, boolean r111, int r112, boolean r113) {
        e r100 = k(r110);
        if (r100 == null) goto L5;
        int r101 = (int) (getClientWidth() * Math.max(this.f195239q, Math.min(r100.f195264e, this.f195240r)));
    L6:
        if (r111 == true) goto L8;
        if (r113 == false) goto L36;
        g(r110);
    L36:
        e(false);
        scrollTo(r101, 0);
        p(r101);
        return;
    L8:
        if (getChildCount() != 0) goto L10;
        setScrollingCacheEnabled(false);
    L32:
        if (r113 == false) goto L38;
        g(r110);
        return;
    L38:
        return;
    L10:
        Scroller r114 = this.f195232j;
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
        e(false);
        r();
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
        this.f195233k = false;
        this.f195232j.startScroll(r102, r103, r104, r105, r109);
        ViewCompat.postInvalidateOnAnimation(this);
        goto L32
    L30:
        r120 = (int) (((Math.abs(r104) / ((r118 * this.f195227e.getPageWidth(this.f195228f)) + this.f195235m)) + 1.0f) * 100.0f);
        goto L31
    L18:
        if (this.f195233k == false) goto L20;
        r116 = this.f195232j.getCurrX();
    L21:
        this.f195232j.abortAnimation();
        setScrollingCacheEnabled(false);
        goto L23
    L20:
        r116 = this.f195232j.getStartX();
        goto L21
    L13:
        if (r114.isFinished() == true) goto L15;
        r115 = true;
        goto L16
    L5:
        r101 = 0;
        goto L6
    }

    public final void x(int r100, boolean r101, boolean r102, int r103) {
        PagerAdapter r104 = this.f195227e;
        boolean r105 = false;
        if (r104 != null) goto L5;
    L39:
        setScrollingCacheEnabled(false);
        return;
    L5:
        if (r104.getCount() <= 0) goto L39;
        if (r102 == true) goto L15;
        if (this.f195228f != r100) goto L15;
        if (this.f195224b.size() == 0) goto L15;
        setScrollingCacheEnabled(false);
        return;
    L15:
        if (r100 >= 0) goto L18;
        r100 = 0;
    L20:
        int r106 = this.f195245w;
        int r107 = this.f195228f;
        if (r100 <= (r107 + r106)) goto L23;
    L24:
        int r108 = 0;
    L26:
        if (r108 >= this.f195224b.size()) goto L29;
        ((e) ListProtector.get(this.f195224b, r108)).f195262c = true;
        r108 = r108 + 1;
    L29:
        if (this.f195228f == r100) goto L32;
        r105 = true;
    L32:
        if (this.O == false) goto L37;
        this.f195228f = r100;
        if (r105 == false) goto L36;
        g(r100);
    L36:
        requestLayout();
        return;
    L37:
        s(r100);
        v(r100, r101, r103, r105);
        return;
    L23:
        if (r100 >= (r107 - r106)) goto L29;
    L18:
        if (r100 < this.f195227e.getCount()) goto L20;
        r100 = this.f195227e.getCount() - 1;
        goto L20
    }

    public static boolean d(View r100, boolean r110, int r111, int r112, int r113) {
        if ((r100 instanceof ViewGroup) == false) goto L18;
        ViewGroup r101 = (ViewGroup) r100;
        int r102 = r100.getScrollX();
        int r103 = r100.getScrollY();
        int r104 = r101.getChildCount() - 1;
    L5:
        if (r104 < 0) goto L18;
        View r105 = r101.getChildAt(r104);
        int r106 = r112 + r102;
        if (r106 < r105.getLeft()) goto L17;
        if (r106 >= r105.getRight()) goto L17;
        int r107 = r113 + r103;
        if (r107 < r105.getTop()) goto L17;
        if (r107 >= r105.getBottom()) goto L17;
        if (d(r105, true, r111, r106 - r105.getLeft(), r107 - r105.getTop()) == false) goto L17;
        return true;
    L17:
        r104 = r104 - 1;
    L18:
        if (r110 == true) goto L20;
    L22:
        return false;
    L20:
        if (r100.canScrollHorizontally(-r111) == false) goto L22;
        return true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r110, int r210, int r211, int r212, int r213) {
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
        if (r114.f195249a == false) goto L32;
        int r115 = r114.f195250b;
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
        if (r126.f195249a == true) goto L45;
        e r127 = i(r125);
        if (r127 == null) goto L45;
        float r128 = r109;
        int r129 = ((int) (r127.f195264e * r128)) + r103;
        if (r126.f195252d == false) goto L44;
        r126.f195252d = false;
        r125.measure(View.MeasureSpec.makeMeasureSpec((int) (r128 * r126.f195251c), 1073741824), View.MeasureSpec.makeMeasureSpec((r102 - r104) - r106, 1073741824));
    L44:
        r125.layout(r129, r104, r125.getMeasuredWidth() + r129, r125.getMeasuredHeight() + r104);
    L45:
        r124 = r124 + 1;
        goto L34
    L46:
        this.f195237o = r104;
        this.f195238p = r102 - r106;
        this.Q = r112;
        if (this.O == false) goto L49;
        boolean r130 = false;
        v(this.f195228f, false, 0, false);
    L50:
        this.O = r130;
        return;
    L49:
        r130 = false;
        goto L50
    }
}
