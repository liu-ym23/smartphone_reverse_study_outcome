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
import com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public class HandyViewPager extends ViewGroup {
    public static final int[] W = null;
    public static final a k0 = null;
    public static final b p0 = null;
    public int A;
    public int B;
    public float C;
    public float D;
    public float E;
    public float F;
    public int G;
    public VelocityTracker H;
    public int I;
    public int J;
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
    public int a;
    public final ArrayList<e> b;
    public final e c;
    public final Rect d;
    public PagerAdapter e;
    public int f;
    public int g;
    public Parcelable h;
    public ClassLoader i;
    public Scroller j;
    public boolean k;
    public g l;
    public int m;
    public Drawable n;
    public int o;
    public int p;
    public float q;
    public float r;
    public int s;
    public boolean t;
    public boolean u;
    public boolean v;
    public int w;
    public boolean x;
    public boolean y;
    public int z;

    @Target({ElementType.TYPE})
    @Inherited
    @Retention(RetentionPolicy.RUNTIME)
    public @interface DecorView {
    }

    public static class LayoutParams extends ViewGroup.LayoutParams {
        public boolean a;
        public final int b;
        public float c;
        public boolean d;
        public int e;

        public LayoutParams() {
            super(-1, -1);
            this.c = 0.0f;
        }

        public LayoutParams(Context r2, AttributeSet r3) {
            super(r2, r3);
            this.c = 0.0f;
            TypedArray r4 = r2.obtainStyledAttributes(r3, HandyViewPager.W);
            this.b = r4.getInteger(0, 48);
            r4.recycle();
        }
    }

    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = null;
        public int a;
        public Parcelable b;
        public final ClassLoader c;

        public static class a implements Parcelable.ClassLoaderCreator<SavedState> {
            public a() {
            }

            @Override // android.os.Parcelable.Creator
            public final Object createFromParcel(Parcel r3) {
                return new SavedState(r3, null);
            }

            @Override // android.os.Parcelable.Creator
            public final Object[] newArray(int r1) {
                return new SavedState[r1];
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            public final SavedState createFromParcel(Parcel r2, ClassLoader r3) {
                return new SavedState(r2, r3);
            }
        }

        static {
            CREATOR = new a();
        }

        public final String toString() {
            return "FragmentPager.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " position=" + this.a + "}";
        }

        public SavedState(Parcelable r1) {
            super(r1);
        }

        public SavedState(Parcel r2, ClassLoader r3) {
            super(r2, r3);
            if (r3 != null) goto L5;
            r3 = getClass().getClassLoader();
        L5:
            this.a = r2.readInt();
            this.b = r2.readParcelable(r3);
            this.c = r3;
        }

        public final void writeToParcel(Parcel r2, int r3) {
            super.writeToParcel(r2, r3);
            r2.writeInt(this.a);
            r2.writeParcelable(this.b, r3);
        }
    }

    public static class a implements Comparator<e> {
        public a() {
        }

        @Override // java.util.Comparator
        public final int compare(e r1, e r2) {
            return r1.b - r2.b;
        }
    }

    public static class b implements Interpolator {
        public b() {
        }

        @Override // android.animation.TimeInterpolator
        public final float getInterpolation(float r3) {
            float r4 = r3 - 1.0f;
            return ((((r4 * r4) * r4) * r4) * r4) + 1.0f;
        }
    }

    public class c implements Runnable {
        public final /* synthetic */ HandyViewPager a;

        @Override // java.lang.Runnable
        public final void run() {
            this.a.setScrollState(0);     // Catch: Throwable -> L4
            this.a.r();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public c(HandyViewPager r1) {
            this.a = r1;
        }
    }

    public class d implements OnApplyWindowInsetsListener {
        public final Rect a;
        public final /* synthetic */ HandyViewPager b;

        public d(HandyViewPager r1) {
            this.b = r1;
            this.a = new Rect();
        }

        public final WindowInsetsCompat onApplyWindowInsets(View r6, WindowInsetsCompat r7) {
            WindowInsetsCompat r8 = ViewCompat.onApplyWindowInsets(r6, r7);
            if (r8.isConsumed() == false) goto L5;
            return r8;
        L5:
            Rect r9 = this.a;
            r9.left = r8.getSystemWindowInsetLeft();
            r9.top = r8.getSystemWindowInsetTop();
            r9.right = r8.getSystemWindowInsetRight();
            r9.bottom = r8.getSystemWindowInsetBottom();
            int r0 = this.b.getChildCount();
            int r1 = 0;
        L6:
            if (r1 >= r0) goto L9;
            WindowInsetsCompat r2 = ViewCompat.dispatchApplyWindowInsets(this.b.getChildAt(r1), r8);
            r9.left = Math.min(r2.getSystemWindowInsetLeft(), r9.left);
            r9.top = Math.min(r2.getSystemWindowInsetTop(), r9.top);
            r9.right = Math.min(r2.getSystemWindowInsetRight(), r9.right);
            r9.bottom = Math.min(r2.getSystemWindowInsetBottom(), r9.bottom);
            r1 = r1 + 1;
            goto L6
        L9:
            return r8.replaceSystemWindowInsets(r9.left, r9.top, r9.right, r9.bottom);
        }
    }

    public static class e {
        public Object a;
        public int b;
        public boolean c;
        public float d;
        public float e;

        public e() {
        }
    }

    public class f extends AccessibilityDelegateCompat {
        public final /* synthetic */ HandyViewPager a;

        public f(HandyViewPager r1) {
            this.a = r1;
        }

        public final void onInitializeAccessibilityEvent(View r2, AccessibilityEvent r3) {
            super.onInitializeAccessibilityEvent(r2, r3);
            r3.setClassName(ViewPager.class.getName());
            PagerAdapter r4 = this.a.e;
            if (r4 == null) goto L7;
            boolean r0 = true;
            if (r4.getCount() <= 1) goto L7;
        L8:
            r3.setScrollable(r0);
            if (r3.getEventType() != 4096) goto L14;
            PagerAdapter r5 = this.a.e;
            if (r5 == null) goto L15;
            r3.setItemCount(r5.getCount());
            r3.setFromIndex(this.a.f);
            r3.setToIndex(this.a.f);
            return;
        L15:
            return;
        L14:
            return;
        L7:
            r0 = false;
            goto L8
        }

        public final void onInitializeAccessibilityNodeInfo(View r2, AccessibilityNodeInfoCompat r3) {
            super.onInitializeAccessibilityNodeInfo(r2, r3);
            r3.setClassName(ViewPager.class.getName());
            PagerAdapter r4 = this.a.e;
            if (r4 != null) goto L5;
        L7:
            boolean r5 = false;
        L8:
            r3.setScrollable(r5);
            if (this.a.canScrollHorizontally(1) == false) goto L12;
            r3.addAction(4096);
        L12:
            if (this.a.canScrollHorizontally(-1) == false) goto L15;
            r3.addAction(8192);
            return;
        L15:
            return;
        L5:
            if (r4.getCount() <= 1) goto L7;
            r5 = true;
            goto L8
        }

        public final boolean performAccessibilityAction(View r2, int r3, Bundle r4) {
            if (super.performAccessibilityAction(r2, r3, r4) == false) goto L6;
            return true;
        L6:
            if (r3 == 4096) goto L16;
            if (r3 == 8192) goto L11;
            return false;
        L11:
            if (this.a.canScrollHorizontally(-1) == false) goto L14;
            HandyViewPager r5 = this.a;
            r5.setCurrentItem(r5.f - 1);
            return true;
        L14:
            return false;
        L16:
            if (this.a.canScrollHorizontally(1) == false) goto L19;
            HandyViewPager r6 = this.a;
            r6.setCurrentItem(r6.f + 1);
            return true;
        L19:
            return false;
        }
    }

    public class g extends DataSetObserver {
        public final /* synthetic */ HandyViewPager a;

        @Override // android.database.DataSetObserver
        public final void onChanged() {
            this.a.f();
        }

        @Override // android.database.DataSetObserver
        public final void onInvalidated() {
            this.a.f();
        }

        public g(HandyViewPager r1) {
            this.a = r1;
        }
    }

    static {
        W = new int[]{R.attr.layout_gravity};
        k0 = new a();
        p0 = new b();
        PagerAdapter.class.getDeclaredField("mViewPagerObserver").setAccessible(true);     // Catch: NoSuchFieldException -> L5
        return;
    }

    @Override // android.view.View
    public final void computeScroll() {
        this.k = true;
        if (this.j.isFinished() == false) goto L5;
    L14:
        e(true);
        return;
    L5:
        if (this.j.computeScrollOffset() == false) goto L14;
        int r0 = getScrollX();
        int r1 = getScrollY();
        int r2 = this.j.getCurrX();
        int r3 = this.j.getCurrY();
        if (r0 != r2) goto L9;
        if (r1 != r3) goto L9;
    L12:
        ViewCompat.postInvalidateOnAnimation(this);
        return;
    L9:
        scrollTo(r2, r3);
        if (p(r2) == true) goto L12;
        this.j.abortAnimation();
        scrollTo(0, r3);
        goto L12
    }

    public final void l() {
        setWillNotDraw(false);
        setDescendantFocusability(262144);
        setFocusable(true);
        Context r1 = getContext();
        this.j = new Scroller(r1, p0);
        ViewConfiguration r2 = ViewConfiguration.get(r1);
        Resources r3 = r1.getResources();
        float r4 = WindowDisplayMetricsOverride.apply(r3, r3.getDisplayMetrics()).density;
        this.B = r2.getScaledPagingTouchSlop();
        this.I = (int) (400.0f * r4);
        this.J = r2.getScaledMaximumFlingVelocity();
        this.M = new EdgeEffect(r1);
        this.N = new EdgeEffect(r1);
        this.K = (int) (25.0f * r4);
        this.L = (int) (2.0f * r4);
        this.z = (int) (r4 * 16.0f);
        ViewCompat.setAccessibilityDelegate(this, new f(this));
        if (ViewCompat.getImportantForAccessibility(this) != 0) goto L5;
        ViewCompat.setImportantForAccessibility(this, 1);
    L5:
        ViewCompat.setOnApplyWindowInsetsListener(this, new d(this));
    }

    public final boolean u() {
        this.G = -1;
        this.x = false;
        this.y = false;
        VelocityTracker r1 = this.H;
        if (r1 == null) goto L5;
        r1.recycle();
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
        int r0 = this.e.getCount();
        this.a = r0;
        if (this.b.size() < ((this.w * 2) + 1)) goto L5;
    L7:
        boolean r1 = false;
    L8:
        int r2 = this.f;
        int r5 = 0;
        boolean r6 = false;
    L10:
        if (r5 >= this.b.size()) goto L30;
        e r7 = (e) ListProtector.get(this.b, r5);
        int r8 = this.e.getItemPosition(r7.a);
        if (r8 == (-1)) goto L29;
        if (r8 != (-2)) goto L22;
        ListProtector.remove(this.b, r5);
        r5 = r5 - 1;
        if (r6 == true) goto L19;
        this.e.startUpdate(this);
        r6 = true;
    L19:
        this.e.destroyItem(this, r7.b, r7.a);
        int r3 = this.f;
        if (r3 != r7.b) goto L28;
        r2 = Math.max(0, Math.min(r3, (-1) + r0));
    L28:
        r1 = true;
        goto L29
    L22:
        int r9 = r7.b;
        if (r9 == r8) goto L29;
        if (r9 != this.f) goto L27;
        r2 = r8;
    L27:
        r7.b = r8;
    L29:
        r5 = r5 + 1;
        goto L10
    L30:
        if (r6 == false) goto L32;
        this.e.finishUpdate(this);
    L32:
        Collections.sort(this.b, k0);
        if (r1 == false) goto L49;
        int r4 = getChildCount();
        int r10 = 0;
    L35:
        if (r10 >= r4) goto L40;
        LayoutParams r11 = (LayoutParams) getChildAt(r10).getLayoutParams();
        if (r11.a == true) goto L39;
        r11.c = 0.0f;
    L39:
        r10 = r10 + 1;
        goto L35
    L40:
        x(r2, false, true, 0);
        requestLayout();
        return;
    L49:
        return;
    L5:
        if (this.b.size() >= r0) goto L7;
        r1 = true;
        goto L8
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams();
    }

    public final boolean o() {
        PagerAdapter r0 = this.e;
        if (r0 != null) goto L5;
        return false;
    L5:
        if (this.f >= (r0.getCount() - 1)) goto L10;
        w(this.f + 1, true);
        return true;
    L10:
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        removeCallbacks(this.U);
        Scroller r0 = this.j;
        if (r0 != null) goto L5;
    L7:
        super.onDetachedFromWindow();
        return;
    L5:
        if (r0.isFinished() == true) goto L7;
        this.j.abortAnimation();
        goto L7
    }

    public final void r() {
        s(this.f);
    }

    private int getClientWidth() {
        return (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable r0 = this.n;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.isStateful() == false) goto L9;
        r0.setState(getDrawableState());
        return;
    }

    public final e j() {
        int r0 = getClientWidth();
        float r1 = 0.0f;
        if (r0 <= 0) goto L5;
        float r2 = getScrollX() / r0;
    L6:
        if (r0 <= 0) goto L8;
        float r3 = this.m / r0;
    L9:
        e r7 = null;
        float r4 = 0.0f;
        int r6 = -1;
        int r8 = 0;
        boolean r9 = true;
    L11:
        if (r8 >= this.b.size()) goto L30;
        e r10 = (e) ListProtector.get(this.b, r8);
        if (r9 == true) goto L17;
        int r11 = r6 + 1;
        if (r10.b == r11) goto L17;
        r10 = this.c;
        r10.e = (r1 + r4) + r3;
        r10.b = r11;
        r10.d = this.e.getPageWidth(r11);
        r8 = r8 - 1;
    L17:
        e r12 = r10;
        r1 = r12.e;
        float r5 = (r12.d + r1) + r3;
        if (r9 == true) goto L24;
        if (r2 >= r1) goto L24;
        return r7;
    L24:
        if (r2 < r5) goto L29;
        if (r8 == (this.b.size() - 1)) goto L29;
        int r13 = r12.b;
        float r14 = r12.d;
        r8 = r8 + 1;
        r9 = false;
        r6 = r13;
        r4 = r14;
        r7 = r12;
    L29:
        return r12;
    L30:
        return r7;
    L8:
        r3 = 0.0f;
        goto L9
    L5:
        r2 = 0.0f;
        goto L6
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.O = true;
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [android.os.Parcelable, com.bytedance.awemeopen.apps.framework.feed.pages.recommend.photo.ui.HandyViewPager$SavedState] */
    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        ?? r1 = new SavedState(super.onSaveInstanceState());
        r1.a = this.f;
        PagerAdapter r0 = this.e;
        if (r0 == null) goto L5;
        r1.b = r0.saveState();
    L5:
        return r1;
    }

    public PagerAdapter getAdapter() {
        return this.e;
    }

    public int getCurrentItem() {
        return this.f;
    }

    public int getOffscreenPageLimit() {
        return this.w;
    }

    public int getPageMargin() {
        return this.m;
    }

    public HandyViewPager(Context r2) {
        super(r2);
        this.b = new ArrayList();
        this.c = new e();
        this.d = new Rect();
        this.g = -1;
        this.h = null;
        this.i = null;
        this.q = -3.4028235E38f;
        this.r = Float.MAX_VALUE;
        this.w = 1;
        this.G = -1;
        this.O = true;
        this.T = 1.0f;
        this.U = new c(this);
        this.V = 0;
        l();
    }

    private void setScrollingCacheEnabled(boolean r2) {
        if (this.u == r2) goto L6;
        this.u = r2;
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void addTouchables(ArrayList<View> r5) {
        int r0 = 0;
    L4:
        if (r0 >= getChildCount()) goto L13;
        View r1 = getChildAt(r0);
        if (r1.getVisibility() != 0) goto L12;
        e r2 = i(r1);
        if (r2 == null) goto L12;
        if (r2.b != this.f) goto L12;
        r1.addTouchables(r5);
    L12:
        r0 = r0 + 1;
        goto L4
    }

    public final void b(ViewPager.OnPageChangeListener r2) {
        if (this.R != null) goto L5;
        this.R = new ArrayList();
    L5:
        this.R.add(r2);
    }

    public final boolean c(int r7) {
        View r0 = findFocus();
        boolean r1 = true;
        boolean r2 = false;
        if (r0 == this) goto L19;
        if (r0 == null) goto L20;
        ViewParent r3 = r0.getParent();
    L8:
        if ((r3 instanceof ViewGroup) == false) goto L12;
        if (r3 == this) goto L10;
        r3 = r3.getParent();
        goto L8
    L10:
        boolean r4 = true;
    L13:
        if (r4 == true) goto L20;
        ViewParent r5 = r0.getParent();
    L16:
        if ((r5 instanceof ViewGroup) == false) goto L19;
        r5.getClass();
        r5 = r5.getParent();
        goto L16
    L12:
        r4 = false;
    L20:
        View r6 = FocusFinder.getInstance().findNextFocus(this, r0, r7);
        if (r6 == null) goto L38;
        if (r6 == r0) goto L38;
        if (r7 != 17) goto L32;
        int r8 = h(this.d, r6).left;
        int r9 = h(this.d, r0).left;
        if (r0 == null) goto L30;
        if (r8 < r9) goto L30;
        int r10 = this.f;
        if (r10 <= 0) goto L48;
        w(r10 - 1, true);
    L49:
        r2 = r1;
    L50:
        if (r2 == false) goto L52;
        playSoundEffect(SoundEffectConstants.getContantForFocusDirection(r7));
    L52:
        return r2;
    L48:
        r1 = false;
    L30:
        boolean r11 = r6.requestFocus();
    L31:
        r2 = r11;
        goto L50
    L32:
        if (r7 != 66) goto L50;
        int r12 = h(this.d, r6).left;
        int r13 = h(this.d, r0).left;
        if (r0 == null) goto L37;
        if (r12 > r13) goto L37;
        r11 = o();
    L37:
        r11 = r6.requestFocus();
    L38:
        if (r7 == 17) goto L45;
        if (r7 == 1) goto L45;
        if (r7 != 66) goto L43;
    L44:
        r2 = o();
        goto L50
    L43:
        if (r7 != 2) goto L50;
    L45:
        int r14 = this.f;
        if (r14 <= 0) goto L48;
        w(r14 - 1, true);
    L19:
        r0 = null;
        goto L20
    }

    @Override // android.view.View
    public boolean canScrollHorizontally(int r5) {
        if (this.e != null) goto L5;
        return false;
    L5:
        int r0 = getClientWidth();
        int r2 = getScrollX();
        if (r5 < 0) goto L8;
        if (r5 > 0) goto L13;
        return false;
    L13:
        if (r2 >= ((int) (r0 * this.r))) goto L18;
        return true;
    L18:
        return false;
    L8:
        if (r2 <= ((int) (r0 * this.q))) goto L16;
        return true;
    L16:
        return false;
    }

    @Override // android.view.ViewGroup
    public final boolean checkLayoutParams(ViewGroup.LayoutParams r2) {
        if ((r2 instanceof LayoutParams) == true) goto L5;
    L7:
        return false;
    L5:
        if (super.checkLayoutParams(r2) == false) goto L7;
        return true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchKeyEvent(KeyEvent r6) {
        if (super.dispatchKeyEvent(r6) == false) goto L5;
        return true;
    L5:
        if (r6.getAction() != 0) goto L29;
        int r0 = r6.getKeyCode();
        if (r0 == 21) goto L24;
        if (r0 == 22) goto L20;
        if (r0 != 61) goto L29;
        if (r6.hasNoModifiers() == false) goto L17;
        boolean r7 = c(2);
    L30:
        if (r7 == true) goto L35;
        return false;
    L35:
        return true;
    L17:
        if (r6.hasModifiers(1) == false) goto L29;
        r7 = c(1);
        goto L30
    L20:
        if (r6.hasModifiers(2) == false) goto L22;
        r7 = o();
        goto L30
    L22:
        r7 = c(66);
        goto L30
    L24:
        if (r6.hasModifiers(2) == false) goto L28;
        int r8 = this.f;
        if (r8 <= 0) goto L29;
        w(r8 - 1, true);
        r7 = true;
        goto L30
    L28:
        r7 = c(17);
    L29:
        r7 = false;
        goto L30
    }

    @Override // android.view.View
    public final boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent r7) {
        if (r7.getEventType() == 4096) goto L5;
        int r0 = getChildCount();
        int r2 = 0;
    L7:
        if (r2 >= r0) goto L19;
        View r3 = getChildAt(r2);
        if (r3.getVisibility() != 0) goto L18;
        e r4 = i(r3);
        if (r4 == null) goto L18;
        if (r4.b != this.f) goto L18;
        if (r3.dispatchPopulateAccessibilityEvent(r7) == false) goto L18;
        return true;
    L18:
        r2 = r2 + 1;
        goto L7
    L19:
        return false;
    L5:
        return super.dispatchPopulateAccessibilityEvent(r7);
    }

    @Override // android.view.View
    public final void draw(Canvas r8) {
        super.draw(r8);
        int r0 = getOverScrollMode();
        boolean r1 = false;
        if (r0 == 0) goto L13;
        if (r0 != 1) goto L11;
        PagerAdapter r2 = this.e;
        if (r2 == null) goto L11;
        if (r2.getCount() > 1) goto L13;
    L11:
        this.M.finish();
        this.N.finish();
    L18:
        if (r1 == false) goto L21;
        ViewCompat.postInvalidateOnAnimation(this);
        return;
    L21:
        return;
    L13:
        if (this.M.isFinished() == true) goto L16;
        int r3 = r8.save();
        int r4 = (getHeight() - getPaddingTop()) - getPaddingBottom();
        int r5 = getWidth();
        r8.rotate(270.0f);
        r8.translate((-r4) + getPaddingTop(), this.q * r5);
        this.M.setSize(r4, r5);
        r1 = false | this.M.draw(r8);
        r8.restoreToCount(r3);
    L16:
        if (this.N.isFinished() == true) goto L18;
        int r6 = r8.save();
        int r7 = getWidth();
        int r9 = (getHeight() - getPaddingTop()) - getPaddingBottom();
        r8.rotate(90.0f);
        r8.translate(-getPaddingTop(), (-(this.r + 1.0f)) * r7);
        this.N.setSize(r9, r7);
        r1 = r1 | this.N.draw(r8);
        r8.restoreToCount(r6);
        goto L18
    }

    public final void e(boolean r8) {
        if (this.V != 2) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L15;
        setScrollingCacheEnabled(false);
        if ((!this.j.isFinished()) == false) goto L15;
        this.j.abortAnimation();
        int r1 = getScrollX();
        int r4 = getScrollY();
        int r5 = this.j.getCurrX();
        int r6 = this.j.getCurrY();
        if (r1 != r5) goto L12;
        if (r4 == r6) goto L15;
    L12:
        scrollTo(r5, r6);
        if (r5 == r1) goto L15;
        p(r5);
    L15:
        this.v = false;
        int r2 = 0;
    L17:
        if (r2 >= this.b.size()) goto L22;
        e r7 = (e) ListProtector.get(this.b, r2);
        if (r7.c == false) goto L21;
        r7.c = false;
        r0 = true;
    L21:
        r2 = r2 + 1;
        goto L17
    L22:
        if (r0 == false) goto L30;
        if (r8 == false) goto L25;
        ViewCompat.postOnAnimation(this, this.U);
        return;
    L25:
        this.U.run();
        return;
    L30:
        return;
    L5:
        r0 = false;
        goto L6
    }

    public final void g(int r4) {
        ViewPager.OnPageChangeListener r0 = this.S;
        if (r0 == null) goto L5;
        r0.onPageSelected(r4);
    L5:
        List<ViewPager.OnPageChangeListener> r1 = this.R;
        if (r1 == null) goto L13;
        int r2 = ((ArrayList) r1).size();
        int r3 = 0;
    L8:
        if (r3 >= r2) goto L17;
        ViewPager.OnPageChangeListener r5 = (ViewPager.OnPageChangeListener) ListProtector.get(this.R, r3);
        if (r5 == null) goto L12;
        r5.onPageSelected(r4);
    L12:
        r3 = r3 + 1;
        goto L8
    L17:
        return;
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet r3) {
        return new LayoutParams(getContext(), r3);
    }

    public final e i(View r5) {
        int r0 = 0;
    L4:
        if (r0 >= this.b.size()) goto L9;
        e r1 = (e) ListProtector.get(this.b, r0);
        if (this.e.isViewFromObject(r5, r1.a) == true) goto L7;
        r0 = r0 + 1;
        goto L4
    L7:
        return r1;
    L9:
        return null;
    }

    public final e k(int r4) {
        int r0 = 0;
    L4:
        if (r0 >= this.b.size()) goto L9;
        e r1 = (e) ListProtector.get(this.b, r0);
        if (r1.b == r4) goto L7;
        r0 = r0 + 1;
        goto L4
    L7:
        return r1;
    L9:
        return null;
    }

    public final void n(MotionEvent r4) {
        int r0 = r4.getActionIndex();
        if (r4.getPointerId(r0) != this.G) goto L11;
        if (r0 != 0) goto L6;
        int r1 = 1;
    L7:
        this.C = r4.getX(r1);
        this.G = r4.getPointerId(r1);
        VelocityTracker r5 = this.H;
        if (r5 == null) goto L12;
        r5.clear();
        return;
    L12:
        return;
    L6:
        r1 = 0;
        goto L7
    }

    @Override // android.view.View
    public final void onDraw(Canvas r18) {
        super.onDraw(r18);
        if (this.m > 0) goto L5;
        return;
    L5:
        if (this.n != null) goto L7;
        return;
    L7:
        if (this.b.size() > 0) goto L9;
        return;
    L9:
        if (this.e == null) goto L34;
        int r1 = getScrollX();
        int r2 = getWidth();
        float r4 = r2;
        float r3 = this.m / r4;
        int r6 = 0;
        e r5 = (e) ListProtector.get(this.b, 0);
        float r7 = r5.e;
        int r8 = this.b.size();
        int r9 = r5.b;
        int r10 = ((e) ListProtector.get(this.b, r8 - 1)).b;
    L11:
        if (r9 >= r10) goto L35;
    L12:
        int r11 = r5.b;
        if (r9 <= r11) goto L16;
        if (r6 >= r8) goto L16;
        r6 = r6 + 1;
        r5 = (e) ListProtector.get(this.b, r6);
    L16:
        if (r9 != r11) goto L18;
        float r12 = r5.e;
        float r13 = r5.d;
        float r14 = (r12 + r13) * r4;
        r7 = (r12 + r13) + r3;
    L20:
        if ((this.m + r14) <= r1) goto L24;
        this.n.setBounds(Math.round(r14), this.o, Math.round(this.m + r14), this.p);
        this.n.draw(r18);
    L24:
        if (r14 > (r1 + r2)) goto L36;
        r9 = r9 + 1;
        r3 = r3;
        goto L11
    L36:
        return;
    L18:
        float r15 = this.e.getPageWidth(r9);
        r14 = (r7 + r15) * r4;
        r7 = r7 + (r15 + r3);
        goto L20
    L35:
        return;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent r13) {
        int r0 = r13.getAction() & 255;
        if (r0 != 3) goto L5;
    L74:
        u();
        return false;
    L5:
        if (r0 == 1) goto L74;
        if (r0 == 0) goto L15;
        if (this.x == false) goto L12;
        return true;
    L12:
        if (this.y == false) goto L15;
        return false;
    L15:
        if (r0 == 0) goto L60;
        if (r0 != 2) goto L18;
        int r1 = this.G;
        if (r1 == (-1)) goto L70;
        int r2 = r13.findPointerIndex(r1);
        float r3 = r13.getX(r2);
        float r4 = r3 - this.C;
        float r5 = Math.abs(r4);
        float r6 = r13.getY(r2);
        float r7 = Math.abs(r6 - this.F);
        if (r4 == 0.0f) goto L40;
        float r9 = this.C;
        if (r9 >= this.A) goto L30;
        if (r4 <= 0.0f) goto L30;
    L33:
        boolean r8 = true;
    L35:
        if (r8 == true) goto L40;
        if (d(this, false, (int) r4, (int) r3, (int) r6) == false) goto L40;
        this.C = r3;
        this.D = r6;
        this.y = true;
        return false;
    L30:
        if (r9 > (getWidth() - this.A)) goto L32;
    L34:
        r8 = false;
        goto L35
    L32:
        if (r4 >= 0.0f) goto L34;
    L40:
        float r10 = this.B;
        if (r5 <= r10) goto L53;
        if ((r5 * this.T) <= r7) goto L53;
        this.x = true;
        ViewParent r11 = getParent();
        if (r11 == null) goto L47;
        r11.requestDisallowInterceptTouchEvent(true);
    L47:
        setScrollState(1);
        float r12 = this.E;
        float r14 = this.B;
        if (r4 <= 0.0f) goto L50;
        float r15 = r12 + r14;
    L51:
        this.C = r15;
        this.D = r6;
        setScrollingCacheEnabled(true);
    L56:
        if (this.x == false) goto L70;
        if (q(r3) == false) goto L70;
        ViewCompat.postInvalidateOnAnimation(this);
        goto L70
    L50:
        r15 = r12 - r14;
    L53:
        if (r7 <= r10) goto L56;
        this.y = true;
    L70:
        if (this.H != null) goto L72;
        this.H = VelocityTracker.obtain();
    L72:
        this.H.addMovement(r13);
        return this.x;
    L18:
        if (r0 != 6) goto L70;
        n(r13);
        goto L70
    L60:
        float r16 = r13.getX();
        this.E = r16;
        this.C = r16;
        float r17 = r13.getY();
        this.F = r17;
        this.D = r17;
        this.G = r13.getPointerId(0);
        this.y = false;
        this.k = true;
        this.j.computeScrollOffset();
        if (this.V == 2) goto L63;
    L68:
        e(false);
        this.x = false;
        goto L70
    L63:
        if (Math.abs(this.j.getFinalX() - this.j.getCurrX()) <= this.L) goto L68;
        this.j.abortAnimation();
        this.v = false;
        r();
        this.x = true;
        ViewParent r18 = getParent();
        if (r18 == null) goto L67;
        r18.requestDisallowInterceptTouchEvent(true);
    L67:
        setScrollState(1);
        goto L70
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable r4) {
        if ((r4 instanceof SavedState) == true) goto L6;
        super.onRestoreInstanceState(r4);
        return;
    L6:
        SavedState r5 = (SavedState) r4;
        super.onRestoreInstanceState(r5.getSuperState());
        PagerAdapter r0 = this.e;
        if (r0 == null) goto L9;
        r0.restoreState(r5.b, r5.c);
        x(r5.a, false, true, 0);
        return;
    L9:
        this.g = r5.a;
        this.h = r5.b;
        this.i = r5.c;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent r10) {
        boolean r1 = false;
        if (r10.getAction() == 0) goto L5;
    L7:
        PagerAdapter r0 = this.e;
        if (r0 != null) goto L10;
    L77:
        return false;
    L10:
        if (r0.getCount() == 0) goto L77;
        if (this.H != null) goto L15;
        this.H = VelocityTracker.obtain();
    L15:
        this.H.addMovement(r10);
        int r2 = r10.getAction() & 255;
        if (r2 != 0) goto L18;
        this.j.abortAnimation();
        this.v = false;
        r();
        float r3 = r10.getX();
        this.E = r3;
        this.C = r3;
        float r4 = r10.getY();
        this.F = r4;
        this.D = r4;
        this.G = r10.getPointerId(0);
    L74:
        if (r1 == false) goto L76;
        ViewCompat.postInvalidateOnAnimation(this);
    L76:
        return true;
    L18:
        if (r2 == 1) goto L56;
        if (r2 == 2) goto L34;
        if (r2 == 3) goto L31;
        if (r2 != 5) goto L26;
        int r5 = r10.getActionIndex();
        this.C = r10.getX(r5);
        this.G = r10.getPointerId(r5);
        goto L74
    L26:
        if (r2 != 6) goto L74;
        n(r10);
        this.C = r10.getX(r10.findPointerIndex(this.G));
        goto L74
    L31:
        if (this.x == false) goto L74;
        v(this.f, true, 0, false);
        r1 = u();
        goto L74
    L34:
        if (this.x == true) goto L53;
        int r6 = r10.findPointerIndex(this.G);
        if (r6 != (-1)) goto L38;
        r1 = u();
        goto L74
    L38:
        float r7 = r10.getX(r6);
        float r8 = Math.abs(r7 - this.C);
        float r9 = r10.getY(r6);
        float r11 = Math.abs(r9 - this.D);
        if (r8 <= this.B) goto L53;
        if ((r8 * this.T) <= r11) goto L53;
        this.x = true;
        ViewParent r12 = getParent();
        if (r12 == null) goto L45;
        r12.requestDisallowInterceptTouchEvent(true);
    L45:
        float r13 = this.E;
        if ((r7 - r13) <= 0.0f) goto L48;
        float r14 = r13 + this.B;
    L49:
        this.C = r14;
        this.D = r9;
        setScrollState(1);
        setScrollingCacheEnabled(true);
        ViewParent r15 = getParent();
        if (r15 == null) goto L53;
        r15.requestDisallowInterceptTouchEvent(true);
        goto L53
    L48:
        r14 = r13 - this.B;
    L53:
        if (this.x == false) goto L74;
        r1 = false | q(r10.getX(r10.findPointerIndex(this.G)));
        goto L74
    L56:
        if (this.x == false) goto L74;
        VelocityTracker r16 = this.H;
        r16.computeCurrentVelocity(ECDraweeView.SQUARE, this.J);
        int r17 = (int) r16.getXVelocity(this.G);
        this.v = true;
        int r18 = getClientWidth();
        int r19 = getScrollX();
        e r20 = j();
        float r21 = r18;
        float r22 = this.m / r21;
        int r23 = r20.b;
        float r24 = ((r19 / r21) - r20.e) / (r20.d + r22);
        if (Math.abs((int) (r10.getX(r10.findPointerIndex(this.G)) - this.E)) <= this.K) goto L65;
        if (Math.abs(r17) <= this.I) goto L65;
        if (r17 > 0) goto L70;
        r23 = r23 + 1;
    L70:
        if (this.b.size() <= 0) goto L72;
        e r110 = (e) ListProtector.get(this.b, 0);
        ArrayList<e> r25 = this.b;
        r23 = Math.max(r110.b, Math.min(r23, ((e) ListProtector.get(r25, r25.size() - 1)).b));
    L72:
        x(r23, true, true, r17);
        r1 = u();
    L65:
        if (r23 < this.f) goto L67;
        float r111 = 0.4f;
    L68:
        r23 = r23 + ((int) (r24 + r111));
        goto L70
    L67:
        r111 = 0.6f;
        goto L68
    L5:
        if (r10.getEdgeFlags() == 0) goto L7;
        return false;
    }

    public final boolean p(int r8) {
        if (this.b.size() == 0) goto L5;
        e r0 = j();
        int r3 = getClientWidth();
        int r4 = this.m;
        int r5 = r3 + r4;
        float r6 = r3;
        int r7 = r0.b;
        float r9 = ((r8 / r6) - r0.e) / (r0.d + (r4 / r6));
        this.P = false;
        m(r7, r9, (int) (r5 * r9));
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

    public final boolean q(float r10) {
        float r0 = this.C - r10;
        this.C = r10;
        float r11 = getScrollX() + r0;
        float r1 = getClientWidth();
        float r2 = this.q * r1;
        float r3 = this.r * r1;
        boolean r4 = false;
        e r5 = (e) ListProtector.get(this.b, 0);
        ArrayList<e> r6 = this.b;
        e r7 = (e) ListProtector.get(r6, r6.size() - 1);
        if (r5.b == 0) goto L5;
        r2 = r5.e * r1;
        boolean r8 = false;
    L7:
        if (r7.b == (this.e.getCount() - 1)) goto L9;
        r3 = r7.e * r1;
        boolean r9 = false;
    L11:
        if (r11 >= r2) goto L16;
        if (r8 == false) goto L14;
        this.M.onPull(Math.abs(r2 - r11) / r1);
        r4 = true;
    L14:
        r11 = r2;
    L20:
        int r12 = (int) r11;
        this.C += r11 - r12;
        scrollTo(r12, getScrollY());
        p(r12);
        return r4;
    L16:
        if (r11 <= r3) goto L20;
        if (r9 == false) goto L19;
        this.N.onPull(Math.abs(r11 - r3) / r1);
        r4 = true;
    L19:
        r11 = r3;
        goto L20
    L9:
        r9 = true;
        goto L11
    L5:
        r8 = true;
        goto L7
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public final void removeView(View r2) {
        if (this.t == false) goto L5;
        removeViewInLayout(r2);
        return;
    L5:
        super.removeView(r2);
    }

    public final void s(int r15) {
        int r0 = this.f;
        if (r0 == r15) goto L5;
        e r1 = k(r0);
        this.f = r15;
    L7:
        if (this.e != null) goto L10;
        return;
    L10:
        if (this.v == false) goto L13;
        return;
    L13:
        if (getWindowToken() != null) goto L15;
        return;
    L15:
        this.e.startUpdate(this);
        int r16 = this.w;
        int r2 = Math.max(0, this.f - r16);
        int r3 = this.e.getCount();
        int r17 = Math.min(r3 - 1, this.f + r16);
        if (r3 != this.a) goto L206;
        int r4 = 0;
    L19:
        if (r4 >= this.b.size()) goto L25;
        e r5 = (e) ListProtector.get(this.b, r4);
        int r6 = r5.b;
        int r7 = this.f;
        if (r6 >= r7) goto L22;
        r4 = r4 + 1;
        goto L19
    L22:
        if (r6 != r7) goto L25;
    L26:
        if (r5 != null) goto L30;
        if (r3 <= 0) goto L30;
        r5 = a(this.f, r4);
    L30:
        if (r5 == null) goto L163;
        int r8 = r4 - 1;
        if (r8 < 0) goto L34;
        e r9 = (e) ListProtector.get(this.b, r8);
    L35:
        int r10 = getClientWidth();
        if (r10 > 0) goto L38;
        float r11 = 0.0f;
    L39:
        int r12 = this.f - 1;
        float r13 = 0.0f;
    L40:
        if (r12 < 0) goto L64;
        if (r13 < r11) goto L53;
        if (r12 >= r2) goto L53;
        if (r9 == null) goto L64;
        if (r12 != r9.b) goto L63;
        if (r9.c == true) goto L63;
        ListProtector.remove(this.b, r8);
        this.e.destroyItem(this, r12, r9.a);
        r8 = r8 - 1;
        r4 = r4 - 1;
        if (r8 < 0) goto L62;
        r9 = (e) ListProtector.get(this.b, r8);
    L62:
        r9 = null;
    L63:
        r12 = r12 - 1;
    L53:
        if (r9 != null) goto L55;
    L59:
        r13 = r13 + a(r12, r8 + 1).d;
        r4 = r4 + 1;
        if (r8 < 0) goto L62;
        r9 = (e) ListProtector.get(this.b, r8);
        goto L63
    L55:
        if (r12 != r9.b) goto L59;
        r13 = r13 + r9.d;
        r8 = r8 - 1;
        if (r8 < 0) goto L62;
        r9 = (e) ListProtector.get(this.b, r8);
    L64:
        float r14 = r5.d;
        int r18 = r4 + 1;
        if (r14 < 2.0f) goto L67;
    L98:
        int r19 = this.e.getCount();
        int r20 = getClientWidth();
        if (r20 <= 0) goto L101;
        float r21 = this.m / r20;
    L102:
        if (r1 == null) goto L134;
        int r22 = r1.b;
        int r23 = r5.b;
        if (r22 >= r23) goto L120;
        float r24 = (r1.e + r1.d) + r21;
        int r25 = r22 + 1;
        int r26 = 0;
    L107:
        if (r25 > r5.b) goto L134;
        if (r26 >= this.b.size()) goto L134;
        Object r27 = ListProtector.get(this.b, r26);
    L111:
        e r28 = (e) r27;
        if (r25 <= r28.b) goto L117;
        if (r26 >= (this.b.size() - 1)) goto L117;
        r26 = r26 + 1;
        r27 = ListProtector.get(this.b, r26);
    L117:
        if (r25 >= r28.b) goto L119;
        r24 = r24 + (this.e.getPageWidth(r25) + r21);
        r25 = r25 + 1;
        goto L117
    L119:
        r28.e = r24;
        r24 = r24 + (r28.d + r21);
        r25 = r25 + 1;
        goto L107
    L120:
        if (r22 <= r23) goto L134;
        int r29 = this.b.size() - 1;
        float r30 = r1.e;
    L122:
        r22 = r22 - 1;
        if (r22 < r5.b) goto L134;
        if (r29 < 0) goto L134;
        Object r31 = ListProtector.get(this.b, r29);
    L126:
        e r32 = (e) r31;
        if (r22 >= r32.b) goto L131;
        if (r29 <= 0) goto L131;
        r29 = r29 - 1;
        r31 = ListProtector.get(this.b, r29);
    L131:
        if (r22 <= r32.b) goto L133;
        r30 = r30 - (this.e.getPageWidth(r22) + r21);
        r22 = r22 - 1;
        goto L131
    L133:
        r30 = r30 - (r32.d + r21);
        r32.e = r30;
    L134:
        int r33 = this.b.size();
        float r34 = r5.e;
        int r35 = r5.b;
        int r36 = r35 - 1;
        if (r35 != 0) goto L137;
        float r37 = r34;
    L138:
        this.q = r37;
        int r110 = r19 - 1;
        if (r35 != r110) goto L141;
        float r38 = (r5.d + r34) - 1.0f;
    L142:
        this.r = r38;
        int r39 = r4 - 1;
    L143:
        if (r39 < 0) goto L152;
        e r40 = (e) ListProtector.get(this.b, r39);
    L145:
        int r111 = r40.b;
        if (r36 <= r111) goto L148;
        r34 = r34 - (this.e.getPageWidth(r36) + r21);
        r36 = r36 - 1;
        goto L145
    L148:
        r34 = r34 - (r40.d + r21);
        r40.e = r34;
        if (r111 != 0) goto L151;
        this.q = r34;
    L151:
        r39 = r39 - 1;
        r36 = r36 - 1;
        goto L143
    L152:
        float r41 = (r5.e + r5.d) + r21;
        int r42 = r5.b;
    L153:
        r42 = r42 + 1;
        if (r18 >= r33) goto L162;
        e r43 = (e) ListProtector.get(this.b, r18);
    L156:
        int r44 = r43.b;
        if (r42 >= r44) goto L159;
        r41 = r41 + (this.e.getPageWidth(r42) + r21);
        r42 = r42 + 1;
        goto L156
    L159:
        if (r44 != r110) goto L161;
        this.r = (r43.d + r41) - 1.0f;
    L161:
        r43.e = r41;
        r41 = r41 + (r43.d + r21);
        r18 = r18 + 1;
        goto L153
    L162:
        this.e.setPrimaryItem(this, this.f, r5.a);
        goto L163
    L141:
        r38 = Float.MAX_VALUE;
        goto L142
    L137:
        r37 = -3.4028235E38f;
        goto L138
    L101:
        r21 = 0.0f;
        goto L102
    L67:
        if (r18 >= this.b.size()) goto L69;
        e r45 = (e) ListProtector.get(this.b, r18);
    L70:
        if (r10 > 0) goto L72;
        float r46 = 0.0f;
    L73:
        int r47 = this.f + 1;
        int r112 = r18;
    L74:
        if (r47 >= r3) goto L98;
        if (r14 < r46) goto L87;
        if (r47 <= r17) goto L87;
        if (r45 == null) goto L98;
        if (r47 != r45.b) goto L97;
        if (r45.c == true) goto L97;
        ListProtector.remove(this.b, r112);
        this.e.destroyItem(this, r47, r45.a);
        if (r112 >= this.b.size()) goto L96;
        r45 = (e) ListProtector.get(this.b, r112);
    L96:
        r45 = null;
    L97:
        r47 = r47 + 1;
    L87:
        if (r45 != null) goto L89;
    L93:
        e r48 = a(r47, r112);
        r112 = r112 + 1;
        r14 = r14 + r48.d;
        if (r112 >= this.b.size()) goto L96;
        r45 = (e) ListProtector.get(this.b, r112);
        goto L97
    L89:
        if (r47 != r45.b) goto L93;
        r14 = r14 + r45.d;
        r112 = r112 + 1;
        if (r112 >= this.b.size()) goto L96;
        r45 = (e) ListProtector.get(this.b, r112);
        goto L97
    L72:
        r46 = (getPaddingRight() / r10) + 2.0f;
        goto L73
    L69:
        r45 = null;
        goto L70
    L38:
        r11 = (2.0f - r5.d) + (getPaddingLeft() / r10);
        goto L39
    L34:
        r9 = null;
    L163:
        this.e.finishUpdate(this);
        int r113 = getChildCount();
        int r49 = 0;
    L164:
        if (r49 >= r113) goto L174;
        View r50 = getChildAt(r49);
        LayoutParams r51 = (LayoutParams) r50.getLayoutParams();
        r51.e = r49;
        if (r51.a == true) goto L172;
        if (r51.c != 0.0f) goto L172;
        e r52 = i(r50);
        if (r52 == null) goto L172;
        r51.c = r52.d;
        int r53 = r52.b;
        r51.getClass();
    L172:
        r49 = r49 + 1;
        goto L164
    L174:
        if (hasFocus() == false) goto L200;
        View r114 = findFocus();
        if (r114 == null) goto L185;
    L177:
        Object r54 = r114.getParent();
        if (r54 == this) goto L184;
        if (r54 == null) goto L185;
        if ((r54 instanceof View) == false) goto L185;
        r114 = (View) r54;
        goto L177
    L184:
        e r115 = i(r114);
    L186:
        if (r115 != null) goto L188;
    L189:
        int r116 = 0;
    L191:
        if (r116 >= getChildCount()) goto L261;
        View r55 = getChildAt(r116);
        e r56 = i(r55);
        if (r56 == null) goto L199;
        if (r56.b != this.f) goto L199;
        if (r55.requestFocus(2) == false) goto L199;
        return;
    L199:
        r116 = r116 + 1;
        goto L191
    L261:
        return;
    L188:
        if (r115.b != this.f) goto L189;
        return;
    L185:
        r115 = null;
        goto L186
    L200:
        return;
    L25:
        r5 = null;
        goto L26
    L206:
        String r117 = getResources().getResourceName(getId());     // Catch: Resources.NotFoundException -> L203
    L205:
        throw new IllegalStateException("The application's PagerAdapter changed the adapter's contents without calling PagerAdapter#notifyDataSetChanged! Expected adapter item count: " + this.a + ", found: " + r3 + " Pager id: " + r117 + " Pager class: " + getClass() + " Problematic adapter: " + this.e.getClass());
    L203:
        r117 = Integer.toHexString(getId());
        goto L205
    L5:
        r1 = null;
        goto L7
    }

    public void setAdapter(PagerAdapter r8) {
        PagerAdapter r0 = this.e;
        if (r0 == null) goto L16;
        y(r0, null);
        this.e.startUpdate(this);
        int r1 = 0;
    L6:
        if (r1 >= this.b.size()) goto L8;
        e r4 = (e) ListProtector.get(this.b, r1);
        this.e.destroyItem(this, r4.b, r4.a);
        r1 = r1 + 1;
        goto L6
    L8:
        this.e.finishUpdate(this);
        this.b.clear();
        int r2 = 0;
    L10:
        if (r2 >= getChildCount()) goto L15;
        if (((LayoutParams) getChildAt(r2).getLayoutParams()).a == true) goto L14;
        removeViewAt(r2);
        r2 = r2 - 1;
    L14:
        r2 = r2 + 1;
        goto L10
    L15:
        this.f = 0;
        scrollTo(0, 0);
    L16:
        this.e = r8;
        this.a = 0;
        if (r8 != null) goto L19;
        return;
    L19:
        if (this.l != null) goto L21;
        this.l = new g(this);
    L21:
        y(this.e, this.l);
        this.v = false;
        boolean r9 = this.O;
        this.O = true;
        this.a = this.e.getCount();
        if (this.g < 0) goto L24;
        this.e.restoreState(this.h, this.i);
        x(this.g, false, true, 0);
        this.g = -1;
        this.h = null;
        this.i = null;
        return;
    L24:
        if (r9 == true) goto L26;
        r();
        return;
    L26:
        requestLayout();
    }

    public void setCurrentItem(int r3) {
        this.v = false;
        x(r3, !this.O, false, 0);
    }

    public void setOffscreenPageLimit(int r2) {
        if (r2 >= 1) goto L6;
        r2 = 1;
    L6:
        if (r2 == this.w) goto L9;
        this.w = r2;
        r();
        return;
    }

    public void setOffscreenPageLimitNoPopulate(int r1) {
        if (r1 >= 0) goto L4;
        return;
    L4:
        this.w = r1;
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener r1) {
        this.S = r1;
    }

    public void setPageMargin(int r3) {
        int r0 = this.m;
        this.m = r3;
        int r1 = getWidth();
        t(r1, r1, r3, r0);
        requestLayout();
    }

    public void setPageMarginDrawable(Drawable r1) {
        this.n = r1;
        if (r1 == null) goto L5;
        refreshDrawableState();
    L5:
        if (r1 != null) goto L7;
        boolean r2 = true;
    L8:
        setWillNotDraw(r2);
        invalidate();
        return;
    L7:
        r2 = false;
        goto L8
    }

    public void setPagerDegreeFraction(float r2) {
        if (r2 > 0.0f) goto L5;
        return;
    L5:
        this.T = r2;
    }

    public void setScrollState(int r4) {
        if (this.V != r4) goto L5;
        return;
    L5:
        this.V = r4;
        ViewPager.OnPageChangeListener r0 = this.S;
        if (r0 == null) goto L8;
        r0.onPageScrollStateChanged(r4);
    L8:
        List<ViewPager.OnPageChangeListener> r1 = this.R;
        if (r1 == null) goto L16;
        int r2 = ((ArrayList) r1).size();
        int r3 = 0;
    L11:
        if (r3 >= r2) goto L20;
        ViewPager.OnPageChangeListener r5 = (ViewPager.OnPageChangeListener) ListProtector.get(this.R, r3);
        if (r5 == null) goto L15;
        r5.onPageScrollStateChanged(r4);
    L15:
        r3 = r3 + 1;
        goto L11
    L20:
        return;
    }

    public void setScroller(Scroller r1) {
        this.j = r1;
    }

    @Override // android.view.View
    public final boolean verifyDrawable(Drawable r2) {
        if (super.verifyDrawable(r2) == false) goto L5;
    L8:
        return true;
    L5:
        if (r2 == this.n) goto L8;
        return false;
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams r1) {
        return generateDefaultLayoutParams();
    }

    public void setPageMarginDrawable(int r2) {
        setPageMarginDrawable(ContextCompat.getDrawable(getContext(), r2));
    }

    public HandyViewPager(Context r1, AttributeSet r2) {
        super(r1, r2);
        this.b = new ArrayList();
        this.c = new e();
        this.d = new Rect();
        this.g = -1;
        this.h = null;
        this.i = null;
        this.q = -3.4028235E38f;
        this.r = Float.MAX_VALUE;
        this.w = 1;
        this.G = -1;
        this.O = true;
        this.T = 1.0f;
        this.U = new c(this);
        this.V = 0;
        l();
    }

    public static void y(PagerAdapter r6, g r7) {
        Method r0 = PagerAdapter.class.getDeclaredMethod("setViewPagerObserver", new Class[]{DataSetObserver.class});     // Catch: Exception -> L4
        r0.setAccessible(true);     // Catch: Exception -> L4
        r0.invoke(r6, new Object[]{r7});     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
    }

    public final e a(int r3, int r4) {
        e r0 = new e();
        r0.b = r3;
        r0.a = this.e.instantiateItem(this, r3);
        r0.d = this.e.getPageWidth(r3);
        if (r4 >= 0) goto L5;
    L8:
        this.b.add(r0);
    L9:
        return r0;
    L5:
        if (r4 >= this.b.size()) goto L8;
        ListProtector.add(this.b, r4, r0);
        goto L9
    }

    @Override // android.view.ViewGroup
    public final int getChildDrawingOrder(int r1, int r2) {
        return ((LayoutParams) ((View) ListProtector.get(null, r2)).getLayoutParams()).e;
    }

    public final Rect h(Rect r3, View r4) {
        if (r3 != null) goto L4;
        r3 = new Rect();
    L4:
        if (r4 != null) goto L7;
        r3.set(0, 0, 0, 0);
        return r3;
    L7:
        r3.left = r4.getLeft();
        r3.right = r4.getRight();
        r3.top = r4.getTop();
        r3.bottom = r4.getBottom();
        ViewParent r5 = r4.getParent();
    L9:
        if ((r5 instanceof ViewGroup) == false) goto L12;
        if (r5 == this) goto L12;
        ViewGroup r6 = (ViewGroup) r5;
        r3.left += r6.getLeft();
        r3.right += r6.getRight();
        r3.top += r6.getTop();
        r3.bottom += r6.getBottom();
        r5 = r6.getParent();
    L12:
        return r3;
    }

    @Override // android.view.View
    public final void onMeasure(int r14, int r15) {
        int r0 = 0;
        setMeasuredDimension(ViewGroup.getDefaultSize(0, r14), ViewGroup.getDefaultSize(0, r15));
        int r16 = getMeasuredWidth();
        this.A = Math.min(r16 / 10, this.z);
        int r17 = (r16 - getPaddingLeft()) - getPaddingRight();
        int r18 = (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
        int r1 = getChildCount();
        int r2 = 0;
    L3:
        boolean r4 = true;
        int r5 = 1073741824;
        if (r2 >= r1) goto L49;
        View r6 = getChildAt(r2);
        if (r6.getVisibility() == 8) goto L48;
        LayoutParams r3 = (LayoutParams) r6.getLayoutParams();
        if (r3 == null) goto L48;
        if (r3.a == false) goto L48;
        int r7 = r3.b;
        int r8 = r7 & 7;
        int r9 = r7 & 112;
        if (r9 != 48) goto L14;
    L17:
        boolean r10 = true;
    L19:
        if (r8 != 3) goto L21;
    L24:
        int r11 = Integer.MIN_VALUE;
        if (r10 == false) goto L27;
        r11 = 1073741824;
    L29:
        int r12 = Integer.MIN_VALUE;
    L30:
        int r13 = ((ViewGroup.LayoutParams) r3).width;
        if (r13 == (-2)) goto L36;
        if (r13 != (-1)) goto L35;
        r13 = r17;
    L35:
        r11 = 1073741824;
    L37:
        int r19 = ((ViewGroup.LayoutParams) r3).height;
        if (r19 == (-2)) goto L42;
        if (r19 != (-1)) goto L43;
        r19 = r18;
    L43:
        r6.measure(View.MeasureSpec.makeMeasureSpec(r13, r11), View.MeasureSpec.makeMeasureSpec(r19, r5));
        if (r10 == false) goto L46;
        r18 = r18 - r6.getMeasuredHeight();
        goto L48
    L46:
        if (r4 == false) goto L48;
        r17 = r17 - r6.getMeasuredWidth();
        goto L48
    L42:
        r19 = r18;
        r5 = r12;
        goto L43
    L36:
        r13 = r17;
        goto L37
    L27:
        if (r4 == false) goto L29;
        r12 = 1073741824;
        goto L30
    L21:
        if (r8 == 5) goto L24;
        r4 = false;
        goto L24
    L14:
        if (r9 == 80) goto L17;
        r10 = false;
    L48:
        r2 = r2 + 1;
        goto L3
    L49:
        View.MeasureSpec.makeMeasureSpec(r17, 1073741824);
        this.s = View.MeasureSpec.makeMeasureSpec(r18, 1073741824);
        this.t = true;
        r();
        this.t = false;
        int r110 = getChildCount();
    L50:
        if (r0 >= r110) goto L59;
        View r20 = getChildAt(r0);
        if (r20.getVisibility() == 8) goto L58;
        LayoutParams r21 = (LayoutParams) r20.getLayoutParams();
        if (r21 != null) goto L56;
    L57:
        r20.measure(View.MeasureSpec.makeMeasureSpec((int) (r17 * r21.c), 1073741824), this.s);
        goto L58
    L56:
        if (r21.a == false) goto L57;
    L58:
        r0 = r0 + 1;
        goto L50
    }

    @Override // android.view.ViewGroup
    public final boolean onRequestFocusInDescendants(int r9, Rect r10) {
        int r0 = getChildCount();
        if ((r9 & 2) == 0) goto L5;
        int r1 = r0;
        int r2 = 0;
        int r4 = 1;
    L6:
        if (r2 == r1) goto L17;
        View r5 = getChildAt(r2);
        if (r5.getVisibility() != 0) goto L16;
        e r6 = i(r5);
        if (r6 == null) goto L16;
        if (r6.b != this.f) goto L16;
        if (r5.requestFocus(r9, r10) == false) goto L16;
        return true;
    L16:
        r2 = r2 + r4;
        goto L6
    L17:
        return false;
    L5:
        r2 = r0 - 1;
        r1 = -1;
        r4 = -1;
        goto L6
    }

    public final void w(int r2, boolean r3) {
        this.v = false;
        x(r2, r3, false, 0);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void addFocusables(ArrayList<View> r7, int r8, int r9) {
        int r0 = r7.size();
        int r1 = getDescendantFocusability();
        if (r1 == 393216) goto L16;
        int r2 = 0;
    L6:
        if (r2 >= getChildCount()) goto L16;
        View r3 = getChildAt(r2);
        if (r3.getVisibility() != 0) goto L14;
        e r4 = i(r3);
        if (r4 == null) goto L14;
        if (r4.b != this.f) goto L14;
        r3.addFocusables(r7, r8, r9);
    L14:
        r2 = r2 + 1;
    L16:
        if (r1 != 262144) goto L20;
        if (r0 == r7.size()) goto L20;
        return;
    L20:
        if (isFocusable() == true) goto L23;
        return;
    L23:
        if ((r9 & 1) == 1) goto L25;
    L29:
        r7.add(this);
        return;
    L25:
        if (isInTouchMode() == false) goto L29;
        if (isFocusableInTouchMode() == true) goto L29;
    }

    @Override // android.view.ViewGroup
    public final void addView(View r5, int r6, ViewGroup.LayoutParams r7) {
        if (checkLayoutParams(r7) == true) goto L5;
        r7 = generateLayoutParams(r7);
    L5:
        LayoutParams r0 = (LayoutParams) r7;
        boolean r1 = r0.a;
        if (r5.getClass().getAnnotation(DecorView.class) == null) goto L8;
        boolean r2 = true;
    L9:
        boolean r3 = r1 | r2;
        r0.a = r3;
        if (this.t == false) goto L15;
        if (r3 == true) goto L14;
        r0.d = true;
        addViewInLayout(r5, r6, r7);
        return;
    L14:
        throw new IllegalStateException("Cannot add pager decor view during layout");
    L15:
        super.addView(r5, r6, r7);
        return;
    L8:
        r2 = false;
        goto L9
    }

    public final void m(int r13, float r14, int r15) {
        int r1 = 0;
        if (this.Q <= 0) goto L25;
        int r0 = getScrollX();
        int r3 = getPaddingLeft();
        int r4 = getPaddingRight();
        int r5 = getWidth();
        int r6 = getChildCount();
        int r7 = 0;
    L5:
        if (r7 >= r6) goto L25;
        View r8 = getChildAt(r7);
        LayoutParams r9 = (LayoutParams) r8.getLayoutParams();
        if (r9.a == false) goto L24;
        int r10 = r9.b & 7;
        if (r10 != 1) goto L12;
        int r11 = Math.max((r5 - r8.getMeasuredWidth()) / 2, r3);
    L19:
        int r12 = r11;
        int r16 = r3;
        r3 = r12;
    L20:
        int r17 = (r3 + r0) - r8.getLeft();
        if (r17 == 0) goto L23;
        r8.offsetLeftAndRight(r17);
    L23:
        r3 = r16;
        goto L24
    L12:
        if (r10 != 3) goto L14;
        r16 = r8.getWidth() + r3;
        goto L20
    L14:
        if (r10 == 5) goto L16;
        r16 = r3;
        goto L20
    L16:
        r11 = (r5 - r4) - r8.getMeasuredWidth();
        r4 = r4 + r8.getMeasuredWidth();
    L24:
        r7 = r7 + 1;
    L25:
        ViewPager.OnPageChangeListener r2 = this.S;
        if (r2 == null) goto L28;
        r2.onPageScrolled(r13, r14, r15);
    L28:
        List<ViewPager.OnPageChangeListener> r18 = this.R;
        if (r18 == null) goto L36;
        int r19 = ((ArrayList) r18).size();
    L31:
        if (r1 >= r19) goto L36;
        ViewPager.OnPageChangeListener r20 = (ViewPager.OnPageChangeListener) ListProtector.get(this.R, r1);
        if (r20 == null) goto L35;
        r20.onPageScrolled(r13, r14, r15);
    L35:
        r1 = r1 + 1;
    L36:
        this.P = true;
    }

    @Override // android.view.View
    public final void onSizeChanged(int r1, int r2, int r3, int r4) {
        super.onSizeChanged(r1, r2, r3, r4);
        if (r1 == r3) goto L6;
        int r5 = this.m;
        t(r1, r3, r5, r5);
        return;
    }

    public final void t(int r2, int r3, int r4, int r5) {
        if (r3 > 0) goto L4;
    L9:
        e r6 = k(this.f);
        if (r6 == null) goto L12;
        float r7 = Math.min(r6.e, this.r);
    L13:
        int r8 = (int) (r7 * ((r2 - getPaddingLeft()) - getPaddingRight()));
        if (r8 == getScrollX()) goto L19;
        e(false);
        scrollTo(r8, getScrollY());
        return;
    L19:
        return;
    L12:
        r7 = 0.0f;
        goto L13
    L4:
        if (this.b.isEmpty() == true) goto L9;
        if (this.j.isFinished() == true) goto L8;
        this.j.setFinalX(getCurrentItem() * getClientWidth());
        return;
    L8:
        scrollTo((int) ((getScrollX() / (((r3 - getPaddingLeft()) - getPaddingRight()) + r5)) * (((r2 - getPaddingLeft()) - getPaddingRight()) + r4)), getScrollY());
    }

    public final void v(int r11, boolean r12, int r13, boolean r14) {
        e r0 = k(r11);
        if (r0 == null) goto L5;
        int r1 = (int) (getClientWidth() * Math.max(this.q, Math.min(r0.e, this.r)));
    L6:
        if (r12 == true) goto L8;
        if (r14 == false) goto L36;
        g(r11);
    L36:
        e(false);
        scrollTo(r1, 0);
        p(r1);
        return;
    L8:
        if (getChildCount() != 0) goto L10;
        setScrollingCacheEnabled(false);
    L32:
        if (r14 == false) goto L38;
        g(r11);
        return;
    L38:
        return;
    L10:
        Scroller r15 = this.j;
        if (r15 != null) goto L13;
    L15:
        boolean r16 = false;
    L16:
        if (r16 == true) goto L18;
        int r17 = getScrollX();
    L23:
        int r4 = r17;
        int r5 = getScrollY();
        int r6 = r1 - r4;
        int r7 = 0 - r5;
        if (r6 != 0) goto L27;
        if (r7 != 0) goto L27;
        e(false);
        r();
        setScrollState(0);
    L27:
        setScrollingCacheEnabled(true);
        setScrollState(2);
        int r18 = getClientWidth();
        int r2 = r18 / 2;
        float r19 = r18;
        float r3 = r2;
        float r8 = r3 + (((float) Math.sin((Math.min(1.0f, (Math.abs(r6) * 1.0f) / r19) - 0.5f) * 0.47123894f)) * r3);
        int r110 = Math.abs(r13);
        if (r110 <= 0) goto L30;
        int r111 = Math.round(Math.abs(r8 / r110) * 1000.0f) * 4;
    L31:
        int r9 = Math.min(r111, 600);
        this.k = false;
        this.j.startScroll(r4, r5, r6, r7, r9);
        ViewCompat.postInvalidateOnAnimation(this);
        goto L32
    L30:
        r111 = (int) (((Math.abs(r6) / ((r19 * this.e.getPageWidth(this.f)) + this.m)) + 1.0f) * 100.0f);
        goto L31
    L18:
        if (this.k == false) goto L20;
        r17 = this.j.getCurrX();
    L21:
        this.j.abortAnimation();
        setScrollingCacheEnabled(false);
        goto L23
    L20:
        r17 = this.j.getStartX();
        goto L21
    L13:
        if (r15.isFinished() == true) goto L15;
        r16 = true;
        goto L16
    L5:
        r1 = 0;
        goto L6
    }

    public final void x(int r5, boolean r6, boolean r7, int r8) {
        PagerAdapter r0 = this.e;
        boolean r1 = false;
        if (r0 != null) goto L5;
    L39:
        setScrollingCacheEnabled(false);
        return;
    L5:
        if (r0.getCount() <= 0) goto L39;
        if (r7 == true) goto L15;
        if (this.f != r5) goto L15;
        if (this.b.size() == 0) goto L15;
        setScrollingCacheEnabled(false);
        return;
    L15:
        if (r5 >= 0) goto L18;
        r5 = 0;
    L20:
        int r2 = this.w;
        int r3 = this.f;
        if (r5 <= (r3 + r2)) goto L23;
    L24:
        int r4 = 0;
    L26:
        if (r4 >= this.b.size()) goto L29;
        ((e) ListProtector.get(this.b, r4)).c = true;
        r4 = r4 + 1;
    L29:
        if (this.f == r5) goto L32;
        r1 = true;
    L32:
        if (this.O == false) goto L37;
        this.f = r5;
        if (r1 == false) goto L36;
        g(r5);
    L36:
        requestLayout();
        return;
    L37:
        s(r5);
        v(r5, r6, r8, r1);
        return;
    L23:
        if (r5 >= (r3 - r2)) goto L29;
    L18:
        if (r5 < this.e.getCount()) goto L20;
        r5 = this.e.getCount() - 1;
        goto L20
    }

    public static boolean d(View r9, boolean r10, int r11, int r12, int r13) {
        if ((r9 instanceof ViewGroup) == false) goto L18;
        ViewGroup r0 = (ViewGroup) r9;
        int r2 = r9.getScrollX();
        int r3 = r9.getScrollY();
        int r4 = r0.getChildCount() - 1;
    L5:
        if (r4 < 0) goto L18;
        View r5 = r0.getChildAt(r4);
        int r6 = r12 + r2;
        if (r6 < r5.getLeft()) goto L17;
        if (r6 >= r5.getRight()) goto L17;
        int r7 = r13 + r3;
        if (r7 < r5.getTop()) goto L17;
        if (r7 >= r5.getBottom()) goto L17;
        if (d(r5, true, r11, r6 - r5.getLeft(), r7 - r5.getTop()) == false) goto L17;
        return true;
    L17:
        r4 = r4 - 1;
    L18:
        if (r10 == true) goto L20;
    L22:
        return false;
    L20:
        if (r9.canScrollHorizontally(-r11) == false) goto L22;
        return true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r19, int r20, int r21, int r22, int r23) {
        int r1 = getChildCount();
        int r2 = r22 - r20;
        int r3 = r23 - r21;
        int r4 = getPaddingLeft();
        int r5 = getPaddingTop();
        int r6 = getPaddingRight();
        int r7 = getPaddingBottom();
        int r8 = getScrollX();
        int r10 = 0;
        int r11 = 0;
    L4:
        if (r10 >= r1) goto L33;
        View r13 = getChildAt(r10);
        if (r13.getVisibility() == 8) goto L32;
        LayoutParams r12 = (LayoutParams) r13.getLayoutParams();
        if (r12.a == false) goto L32;
        int r14 = r12.b;
        int r15 = r14 & 7;
        int r16 = r14 & 112;
        if (r15 != 1) goto L12;
        int r17 = Math.max((r2 - r13.getMeasuredWidth()) / 2, r4);
    L19:
        int r18 = r17;
        int r110 = r4;
        r4 = r18;
    L21:
        if (r16 != 16) goto L23;
        int r111 = Math.max((r3 - r13.getMeasuredHeight()) / 2, r5);
    L30:
        int r112 = r111;
        int r113 = r5;
        r5 = r112;
    L31:
        int r9 = r4 + r8;
        r13.layout(r9, r5, r13.getMeasuredWidth() + r9, r5 + r13.getMeasuredHeight());
        r11 = r11 + 1;
        r5 = r113;
        r4 = r110;
        goto L32
    L23:
        if (r16 != 48) goto L25;
        r113 = r13.getMeasuredHeight() + r5;
        goto L31
    L25:
        if (r16 == 80) goto L27;
        r113 = r5;
        goto L31
    L27:
        r111 = (r3 - r7) - r13.getMeasuredHeight();
        r7 = r7 + r13.getMeasuredHeight();
        goto L30
    L12:
        if (r15 != 3) goto L14;
        r110 = r13.getMeasuredWidth() + r4;
        goto L21
    L14:
        if (r15 == 5) goto L16;
        r110 = r4;
        goto L21
    L16:
        r17 = (r2 - r6) - r13.getMeasuredWidth();
        r6 = r6 + r13.getMeasuredWidth();
    L32:
        r10 = r10 + 1;
        goto L4
    L33:
        int r24 = (r2 - r4) - r6;
        int r25 = 0;
    L34:
        if (r25 >= r1) goto L46;
        View r26 = getChildAt(r25);
        if (r26.getVisibility() == 8) goto L45;
        LayoutParams r27 = (LayoutParams) r26.getLayoutParams();
        if (r27.a == true) goto L45;
        e r114 = i(r26);
        if (r114 == null) goto L45;
        float r115 = r24;
        int r116 = ((int) (r114.e * r115)) + r4;
        if (r27.d == false) goto L44;
        r27.d = false;
        r26.measure(View.MeasureSpec.makeMeasureSpec((int) (r115 * r27.c), 1073741824), View.MeasureSpec.makeMeasureSpec((r3 - r5) - r7, 1073741824));
    L44:
        r26.layout(r116, r5, r26.getMeasuredWidth() + r116, r26.getMeasuredHeight() + r5);
    L45:
        r25 = r25 + 1;
        goto L34
    L46:
        this.o = r5;
        this.p = r3 - r7;
        this.Q = r11;
        if (this.O == false) goto L49;
        boolean r28 = false;
        v(this.f, false, 0, false);
    L50:
        this.O = r28;
        return;
    L49:
        r28 = false;
        goto L50
    }
}
