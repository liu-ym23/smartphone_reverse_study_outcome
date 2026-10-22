package com.bytedance.awemeopen.apps.framework.base.view.verticalviewPager;

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
import android.widget.Scroller;
import androidx.core.os.ParcelableCompat;
import androidx.core.os.ParcelableCompatCreatorCallbacks;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.VelocityTrackerCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewConfigurationCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityRecordCompat;
import androidx.core.widget.EdgeEffectCompat;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView;
import com.bytedance.awemeopen.infra.base.env.AoEnv;
import com.bytedance.awemeopen.infra.base.settings.AoSettings;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public class VerticalViewPager extends ViewGroup {
    public static final int[] V0 = null;
    public static final a b1 = null;
    public static final b g1 = null;
    public static final Field h1 = null;
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
    public float J;
    public float K;
    public float L;
    public int L0;
    public int M;
    public VelocityTracker N;
    public int O;
    public int P;
    public boolean P0;
    public int Q;
    public int R;
    public EdgeEffectCompat S;
    public EdgeEffectCompat T;
    public boolean U;
    public boolean V;
    public int W;
    public final boolean a;
    public boolean b;
    public List<com.bytedance.awemeopen.apps.framework.base.view.verticalviewPager.b> c;
    public int d;
    public double e;
    public double f;
    public float g;
    public final ArrayList<e> h;
    public final e i;
    public final Rect j;
    public PagerAdapter k;
    public final List<ViewPager.OnPageChangeListener> k0;
    public int l;
    public int m;
    public Parcelable n;
    public ClassLoader o;
    public Scroller p;
    public Method p0;
    public boolean q;
    public h r;
    public int s;
    public Drawable t;
    public int u;
    public int v;
    public float w;
    public float x;
    public int y;
    public boolean z;

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
            TypedArray r4 = r2.obtainStyledAttributes(r3, VerticalViewPager.V0);
            this.b = r4.getInteger(0, 48);
            r4.recycle();
        }
    }

    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = null;
        public int a;
        public Parcelable b;
        public final ClassLoader c;

        public static class a implements ParcelableCompatCreatorCallbacks<SavedState> {
            public a() {
            }

            public final Object[] newArray(int r1) {
                return new SavedState[r1];
            }

            public final Object createFromParcel(Parcel r2, ClassLoader r3) {
                return new SavedState(r2, r3);
            }
        }

        static {
            CREATOR = ParcelableCompat.newCreator(new a());
        }

        public final String toString() {
            return "FragmentPager.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " position=" + this.a + "}";
        }

        public SavedState(Parcelable r1) {
            super(r1);
        }

        public SavedState(Parcel r2, ClassLoader r3) {
            super(r2);
            if (r3 != null) goto L5;
            r3 = getClass().getClassLoader();
        L5:
            this.a = r2.readInt();
            this.b = r2.readParcelable(r3);
            this.c = r3;
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
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
        public final /* synthetic */ VerticalViewPager a;

        @Override // java.lang.Runnable
        public final void run() {
            VerticalViewPager.a(this.a);     // Catch: Throwable -> L4
            this.a.s();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public c(VerticalViewPager r1) {
            this.a = r1;
        }
    }

    public class d implements OnApplyWindowInsetsListener {
        public final Rect a;
        public final /* synthetic */ VerticalViewPager b;

        public d(VerticalViewPager r1) {
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
        public final /* synthetic */ VerticalViewPager a;

        public f(VerticalViewPager r1) {
            this.a = r1;
        }

        public final void onInitializeAccessibilityEvent(View r3, AccessibilityEvent r4) {
            super.onInitializeAccessibilityEvent(r3, r4);
            r4.setClassName(ViewPager.class.getName());
            AccessibilityRecordCompat r5 = AccessibilityRecordCompat.obtain();
            PagerAdapter r0 = this.a.k;
            if (r0 == null) goto L7;
            boolean r1 = true;
            if (r0.getCount() <= 1) goto L7;
        L8:
            r5.setScrollable(r1);
            if (r4.getEventType() != 4096) goto L14;
            PagerAdapter r6 = this.a.k;
            if (r6 == null) goto L15;
            r5.setItemCount(r6.getCount());
            r5.setFromIndex(this.a.l);
            r5.setToIndex(this.a.l);
            return;
        L15:
            return;
        L14:
            return;
        L7:
            r1 = false;
            goto L8
        }

        public final void onInitializeAccessibilityNodeInfo(View r2, AccessibilityNodeInfoCompat r3) {
            super.onInitializeAccessibilityNodeInfo(r2, r3);
            r3.setClassName(ViewPager.class.getName());
            PagerAdapter r4 = this.a.k;
            if (r4 != null) goto L5;
        L7:
            boolean r5 = false;
        L8:
            r3.setScrollable(r5);
            if (this.a.canScrollVertically(1) == false) goto L12;
            r3.addAction(4096);
        L12:
            if (this.a.canScrollVertically(-1) == false) goto L15;
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
            if (this.a.canScrollVertically(-1) == false) goto L14;
            VerticalViewPager r5 = this.a;
            r5.setCurrentItem(r5.l - 1);
            return true;
        L14:
            return false;
        L16:
            if (this.a.canScrollVertically(1) == false) goto L19;
            VerticalViewPager r6 = this.a;
            r6.setCurrentItem(r6.l + 1);
            return true;
        L19:
            return false;
        }
    }

    public interface g {
    }

    public class h extends DataSetObserver {
        public final /* synthetic */ VerticalViewPager a;

        @Override // android.database.DataSetObserver
        public final void onChanged() {
            this.a.g();
        }

        @Override // android.database.DataSetObserver
        public final void onInvalidated() {
            this.a.g();
        }

        public h(VerticalViewPager r1) {
            this.a = r1;
        }
    }

    static {
        V0 = new int[]{R.attr.layout_gravity};
        b1 = new a();
        g1 = new b();
        Field r1 = PagerAdapter.class.getDeclaredField("mViewPagerObserver");     // Catch: NoSuchFieldException -> L5
        h1 = r1;     // Catch: NoSuchFieldException -> L5
        r1.setAccessible(true);     // Catch: NoSuchFieldException -> L5
        return;
    L5:
        e = move-exception;
        throw new RuntimeException(e);
    }

    @Override // android.view.View
    public final void computeScroll() {
        this.q = true;
        if (this.p.isFinished() == false) goto L5;
    L14:
        f(true);
        return;
    L5:
        if (this.p.computeScrollOffset() == false) goto L14;
        int r0 = getScrollX();
        int r1 = getScrollY();
        int r2 = this.p.getCurrX();
        int r3 = this.p.getCurrY();
        if (r0 != r2) goto L9;
        if (r1 != r3) goto L9;
    L12:
        ViewCompat.postInvalidateOnAnimation(this);
        return;
    L9:
        scrollTo(r2, r3);
        if (q(r3) == true) goto L12;
        this.p.abortAnimation();
        scrollTo(r2, 0);
        goto L12
    }

    public final void n() {
        this.b = true;
        setWillNotDraw(false);
        setDescendantFocusability(262144);
        setFocusable(true);
        Context r1 = getContext();
        this.p = new Scroller(r1, g1);
        ViewConfiguration r2 = ViewConfiguration.get(r1);
        Resources r3 = r1.getResources();
        float r4 = WindowDisplayMetricsOverride.apply(r3, r3.getDisplayMetrics()).density;
        this.H = ViewConfigurationCompat.getScaledPagingTouchSlop(r2);
        this.O = (int) (400.0f * r4);
        this.P = r2.getScaledMaximumFlingVelocity();
        this.S = new EdgeEffectCompat(r1);
        this.T = new EdgeEffectCompat(r1);
        this.Q = (int) (25.0f * r4);
        this.R = (int) (2.0f * r4);
        this.F = (int) (r4 * 16.0f);
        ViewCompat.setAccessibilityDelegate(this, new f(this));
        if (ViewCompat.getImportantForAccessibility(this) != 0) goto L5;
        ViewCompat.setImportantForAccessibility(this, 1);
    L5:
        ViewCompat.setOnApplyWindowInsetsListener(this, new d(this));
    }

    public void setOnAdapterChangeListener(g r1) {
    }

    public final boolean w() {
        this.M = -1;
        this.D = false;
        this.E = false;
        VelocityTracker r0 = this.N;
        if (r0 == null) goto L6;
        r0.recycle();
        this.N = null;
    L6:
        return this.S.onRelease() | this.T.onRelease();
    }

    public final void g() {
        int r0 = this.k.getCount();
        this.d = r0;
        if (this.h.size() < ((this.C * 2) + 1)) goto L5;
    L7:
        boolean r1 = false;
    L8:
        int r2 = this.l;
        int r5 = 0;
        boolean r6 = false;
    L10:
        if (r5 >= this.h.size()) goto L30;
        e r7 = (e) ListProtector.get(this.h, r5);
        int r8 = this.k.getItemPosition(r7.a);
        if (r8 == (-1)) goto L29;
        if (r8 != (-2)) goto L22;
        ListProtector.remove(this.h, r5);
        r5 = r5 - 1;
        if (r6 == true) goto L19;
        this.k.startUpdate(this);
        r6 = true;
    L19:
        this.k.destroyItem(this, r7.b, r7.a);
        int r3 = this.l;
        if (r3 != r7.b) goto L28;
        r2 = Math.max(0, Math.min(r3, (-1) + r0));
    L28:
        r1 = true;
        goto L29
    L22:
        int r9 = r7.b;
        if (r9 == r8) goto L29;
        if (r9 != this.l) goto L27;
        r2 = r8;
    L27:
        r7.b = r8;
    L29:
        r5 = r5 + 1;
        goto L10
    L30:
        if (r6 == false) goto L32;
        this.k.finishUpdate(this);
    L32:
        Collections.sort(this.h, b1);
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
        z(r2, false, true, 0);
        requestLayout();
        return;
    L49:
        return;
    L5:
        if (this.h.size() >= r0) goto L7;
        r1 = true;
        goto L8
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams();
    }

    public final void m() {
        JSONObject r0 = AoSettings.a("ao_interactive_gesture_config");
        if (r0 != null) goto L6;
        return;
    L6:
        if (r0.optBoolean("enable_config", false) == true) goto L8;
        return;
    L8:
        this.e = r0.optInt("interactive_gesture_angle", -1);
        this.g = (float) r0.optDouble("interactive_gesture_distance_percent", 0.0d);
        setLivePreviewScrollableAngle(this.e);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        removeCallbacks(this.H0);
        Scroller r0 = this.p;
        if (r0 != null) goto L5;
    L7:
        super.onDetachedFromWindow();
        return;
    L5:
        if (r0.isFinished() == true) goto L7;
        this.p.abortAnimation();
        goto L7
    }

    public final void s() {
        t(this.l);
    }

    private int getClientHeight() {
        return (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable r0 = this.t;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.isStateful() == false) goto L9;
        r0.setState(getDrawableState());
        return;
    }

    public final e k() {
        int r0 = getClientHeight();
        float r1 = 0.0f;
        if (r0 <= 0) goto L5;
        float r2 = getScrollY() / r0;
    L6:
        if (r0 <= 0) goto L8;
        float r3 = this.s / r0;
    L9:
        e r7 = null;
        float r4 = 0.0f;
        int r6 = -1;
        int r8 = 0;
        boolean r9 = true;
    L11:
        if (r8 >= this.h.size()) goto L30;
        e r10 = (e) ListProtector.get(this.h, r8);
        if (r9 == true) goto L17;
        int r11 = r6 + 1;
        if (r10.b == r11) goto L17;
        r10 = this.i;
        r10.e = (r1 + r4) + r3;
        r10.b = r11;
        r10.d = this.k.getPageWidth(r11);
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
        if (r8 == (this.h.size() - 1)) goto L29;
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
        this.U = true;
    }

    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        Parcelable r0 = super.onSaveInstanceState();
        if (AoEnv.j() == false) goto L5;
        return r0;
    L5:
        SavedState r1 = new SavedState(r0);
        r1.a = this.l;
        PagerAdapter r2 = this.k;
        if (r2 == null) goto L8;
        r1.b = r2.saveState();
    L8:
        return r1;
    }

    public PagerAdapter getAdapter() {
        return this.k;
    }

    public int getCurrentItem() {
        return this.l;
    }

    public int getExpectedAdapterCount() {
        return this.d;
    }

    public int getOffscreenPageLimit() {
        return this.C;
    }

    public int getPageMargin() {
        return this.s;
    }

    public VerticalViewPager(Context r3) {
        super(r3);
        this.a = com.bytedance.awemeopen.apps.framework.feed.ui.information.a.o;
        this.c = null;
        this.e = -1.0d;
        this.f = 1.0d;
        this.g = 0.0f;
        this.h = new ArrayList();
        this.i = new e();
        this.j = new Rect();
        this.m = -1;
        this.n = null;
        this.o = null;
        this.w = -3.4028235E38f;
        this.x = Float.MAX_VALUE;
        this.C = 1;
        this.M = -1;
        this.U = true;
        this.k0 = new CopyOnWriteArrayList();
        this.H0 = new c(this);
        this.L0 = 0;
        this.P0 = false;
        n();
        m();
    }

    public static /* synthetic */ void a(VerticalViewPager r1) {
        r1.setScrollState(0);
    }

    private void setScrollState(int r3) {
        if (this.L0 != r3) goto L5;
        return;
    L5:
        this.L0 = r3;
        List<ViewPager.OnPageChangeListener> r0 = this.k0;
        if (r0 != null) goto L8;
        return;
    L8:
        if (r0.isEmpty() == true) goto L15;
        Iterator<ViewPager.OnPageChangeListener> r1 = this.k0.iterator();
    L11:
        if (r1.hasNext() == false) goto L16;
        r1.next().onPageScrollStateChanged(r3);
        goto L11
    L16:
        return;
    }

    private void setScrollingCacheEnabled(boolean r2) {
        if (this.A == r2) goto L6;
        this.A = r2;
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void addTouchables(ArrayList<View> r5) {
        int r0 = 0;
    L4:
        if (r0 >= getChildCount()) goto L13;
        View r1 = getChildAt(r0);
        if (r1.getVisibility() != 0) goto L12;
        e r2 = j(r1);
        if (r2 == null) goto L12;
        if (r2.b != this.l) goto L12;
        r1.addTouchables(r5);
    L12:
        r0 = r0 + 1;
        goto L4
    }

    public final void c(ViewPager.OnPageChangeListener r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        this.k0.add(r2);
    }

    @Override // android.view.View
    public final boolean canScrollVertically(int r5) {
        if (this.k != null) goto L5;
        return false;
    L5:
        int r0 = getClientHeight();
        int r2 = getScrollY();
        if (r5 < 0) goto L8;
        if (r5 > 0) goto L13;
        return false;
    L13:
        if (r2 >= ((int) (r0 * this.x))) goto L18;
        return true;
    L18:
        return false;
    L8:
        if (r2 <= ((int) (r0 * this.w))) goto L16;
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

    public final boolean d(int r7) {
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
        if (r6 == null) goto L42;
        if (r6 == r0) goto L42;
        if (r7 != 33) goto L32;
        int r8 = i(this.j, r6).top;
        int r9 = i(this.j, r0).top;
        if (r0 == null) goto L30;
        if (r8 < r9) goto L30;
        int r10 = this.l;
        if (r10 <= 0) goto L56;
        y(r10 - 1, true);
    L57:
        r2 = r1;
    L58:
        if (r2 == false) goto L60;
        playSoundEffect(SoundEffectConstants.getContantForFocusDirection(r7));
    L60:
        return r2;
    L56:
        r1 = false;
    L30:
        boolean r11 = r6.requestFocus();
    L31:
        r2 = r11;
        goto L58
    L32:
        if (r7 != 130) goto L58;
        int r12 = i(this.j, r6).bottom;
        int r13 = i(this.j, r0).bottom;
        if (r0 == null) goto L41;
        if (r12 > r13) goto L41;
        PagerAdapter r14 = this.k;
        if (r14 == null) goto L56;
        if (this.l >= (r14.getCount() - 1)) goto L56;
        y(this.l + 1, true);
    L41:
        r11 = r6.requestFocus();
    L42:
        if (r7 == 33) goto L53;
        if (r7 == 1) goto L53;
        if (r7 != 130) goto L47;
    L48:
        PagerAdapter r15 = this.k;
        if (r15 == null) goto L56;
        if (this.l >= (r15.getCount() - 1)) goto L56;
        y(this.l + 1, true);
        goto L57
    L47:
        if (r7 != 2) goto L58;
    L53:
        int r16 = this.l;
        if (r16 <= 0) goto L56;
        y(r16 - 1, true);
    L19:
        r0 = null;
        goto L20
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchKeyEvent(KeyEvent r5) {
        if (super.dispatchKeyEvent(r5) == false) goto L5;
        return true;
    L5:
        if (r5.getAction() != 0) goto L21;
        int r0 = r5.getKeyCode();
        if (r0 != 21) goto L9;
        boolean r6 = d(17);
    L22:
        if (r6 == true) goto L27;
        return false;
    L27:
        return true;
    L9:
        if (r0 != 22) goto L11;
        r6 = d(66);
        goto L22
    L11:
        if (r0 != 61) goto L21;
        if (r5.hasNoModifiers() == false) goto L17;
        r6 = d(2);
        goto L22
    L17:
        if (r5.hasModifiers(1) == false) goto L21;
        r6 = d(1);
    L21:
        r6 = false;
        goto L22
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
        e r4 = j(r3);
        if (r4 == null) goto L18;
        if (r4.b != this.l) goto L18;
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

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r3) {
        List<com.bytedance.awemeopen.apps.framework.base.view.verticalviewPager.b> r0 = this.c;
        if (r0 == null) goto L9;
        Iterator r1 = ((ArrayList) r0).iterator();
    L6:
        if (r1.hasNext() == false) goto L9;
        ((com.bytedance.awemeopen.apps.framework.base.view.verticalviewPager.b) r1.next()).a();
    L9:
        if (this.b == true) goto L11;
    L13:
        return false;
    L11:
        if (super.dispatchTouchEvent(r3) == false) goto L13;
        return true;
    }

    @Override // android.view.View
    public final void draw(Canvas r8) {
        super.draw(r8);     // Catch: Exception -> L4
    L5:
        int r0 = ViewCompat.getOverScrollMode(this);
        boolean r1 = false;
        if (r0 == 0) goto L16;
        if (r0 != 1) goto L14;
        PagerAdapter r2 = this.k;
        if (r2 == null) goto L14;
        if (r2.getCount() > 1) goto L16;
    L14:
        this.S.finish();
        this.T.finish();
    L21:
        if (r1 == false) goto L26;
        ViewCompat.postInvalidateOnAnimation(this);
        return;
    L26:
        return;
    L16:
        if (this.S.isFinished() == true) goto L19;
        int r3 = r8.save();
        int r4 = getHeight();
        int r5 = (getWidth() - getPaddingLeft()) - getPaddingRight();
        r8.translate(getPaddingLeft(), this.w * r4);
        this.S.setSize(r5, r4);
        r1 = false | this.S.draw(r8);
        r8.restoreToCount(r3);
    L19:
        if (this.T.isFinished() == true) goto L21;
        int r6 = r8.save();
        int r7 = getHeight();
        int r9 = (getWidth() - getPaddingLeft()) - getPaddingRight();
        r8.rotate(180.0f);
        r8.translate((-r9) - getPaddingLeft(), (-(this.x + 1.0f)) * r7);
        this.T.setSize(r9, r7);
        r1 = r1 | this.T.draw(r8);
        r8.restoreToCount(r6);
        goto L21
    }

    public final void f(boolean r8) {
        if (this.L0 != 2) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L15;
        setScrollingCacheEnabled(false);
        if ((!this.p.isFinished()) == false) goto L15;
        this.p.abortAnimation();
        int r1 = getScrollX();
        int r4 = getScrollY();
        int r5 = this.p.getCurrX();
        int r6 = this.p.getCurrY();
        if (r1 != r5) goto L12;
        if (r4 == r6) goto L15;
    L12:
        scrollTo(r5, r6);
        if (r6 == r4) goto L15;
        q(r6);
    L15:
        this.B = false;
        int r2 = 0;
    L17:
        if (r2 >= this.h.size()) goto L22;
        e r7 = (e) ListProtector.get(this.h, r2);
        if (r7.c == false) goto L21;
        r7.c = false;
        r0 = true;
    L21:
        r2 = r2 + 1;
        goto L17
    L22:
        if (r0 == false) goto L30;
        if (r8 == false) goto L25;
        ViewCompat.postOnAnimation(this, this.H0);
        return;
    L25:
        this.H0.run();
        return;
    L30:
        return;
    L5:
        r0 = false;
        goto L6
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet r3) {
        return new LayoutParams(getContext(), r3);
    }

    public final e j(View r5) {
        int r0 = 0;
    L4:
        if (r0 >= this.h.size()) goto L9;
        e r1 = (e) ListProtector.get(this.h, r0);
        if (this.k.isViewFromObject(r5, r1.a) == true) goto L7;
        r0 = r0 + 1;
        goto L4
    L7:
        return r1;
    L9:
        return null;
    }

    public final e l(int r4) {
        int r0 = 0;
    L4:
        if (r0 >= this.h.size()) goto L9;
        e r1 = (e) ListProtector.get(this.h, r0);
        if (r1.b == r4) goto L7;
        r0 = r0 + 1;
        goto L4
    L7:
        return r1;
    L9:
        return null;
    }

    @Override // android.view.View
    public final void onDraw(Canvas r19) {
        super.onDraw(r19);
        if (this.s > 0) goto L5;
        return;
    L5:
        if (this.t != null) goto L7;
        return;
    L7:
        if (this.h.size() > 0) goto L9;
        return;
    L9:
        if (this.k == null) goto L34;
        int r1 = getScrollY();
        int r2 = getHeight();
        float r4 = r2;
        float r3 = this.s / r4;
        int r6 = 0;
        e r5 = (e) ListProtector.get(this.h, 0);
        float r7 = r5.e;
        int r8 = this.h.size();
        int r9 = r5.b;
        int r10 = ((e) ListProtector.get(this.h, r8 - 1)).b;
    L11:
        if (r9 >= r10) goto L35;
    L12:
        int r11 = r5.b;
        if (r9 <= r11) goto L16;
        if (r6 >= r8) goto L16;
        r6 = r6 + 1;
        r5 = (e) ListProtector.get(this.h, r6);
    L16:
        if (r9 != r11) goto L18;
        float r12 = r5.e;
        float r13 = r5.d;
        float r14 = (r12 + r13) * r4;
        r7 = (r12 + r13) + r3;
    L19:
        int r15 = this.s;
        if ((r15 + r14) <= r1) goto L24;
        this.t.setBounds(this.u, (int) r14, this.v, (int) ((r15 + r14) + 0.5f));
        this.t.draw(r19);
    L24:
        if (r14 > (r1 + r2)) goto L36;
        r9 = r9 + 1;
        r3 = r3;
        goto L11
    L36:
        return;
    L18:
        float r16 = this.k.getPageWidth(r9);
        r14 = (r7 + r16) * r4;
        r7 = r7 + (r16 + r3);
        goto L19
    L35:
        return;
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r16) {
        if (this.P0 == false) goto L104;
        return false;
    L104:
        int r2 = r16.getAction() & 255;     // Catch: IllegalArgumentException -> L100
        if (r2 != 3) goto L8;
    L97:
        w();     // Catch: IllegalArgumentException -> L100
        return false;
    L8:
        if (r2 == 1) goto L97;
        if (r2 == 0) goto L18;
        if (this.D == false) goto L15;
        return true;
    L15:
        if (this.E == false) goto L18;
        return false;
    L18:
        if (r2 == 0) goto L84;
        if (r2 != 2) goto L21;
        int r3 = this.M;     // Catch: IllegalArgumentException -> L100
        if (r3 == (-1)) goto L94;
        int r4 = r16.findPointerIndex(r3);     // Catch: IllegalArgumentException -> L100
        float r5 = r16.getY(r4);     // Catch: IllegalArgumentException -> L100
        float r6 = r5 - this.J;     // Catch: IllegalArgumentException -> L100
        float r7 = Math.abs(r6);     // Catch: IllegalArgumentException -> L100
        float r8 = r16.getX(r4);     // Catch: IllegalArgumentException -> L100
        float r9 = Math.abs(r8 - this.K);     // Catch: IllegalArgumentException -> L100
        if (r6 == 0.0f) goto L44;
        float r11 = this.J;     // Catch: IllegalArgumentException -> L100
        if (r11 >= this.G) goto L33;
        if (r6 <= 0.0f) goto L33;
    L36:
        boolean r10 = true;
    L38:
        if (r10 == true) goto L44;
        if (e(this, false, (int) r6, (int) r8, (int) r5) == false) goto L44;
        this.I = r8;     // Catch: IllegalArgumentException -> L100
        this.J = r5;     // Catch: IllegalArgumentException -> L100
        this.E = true;     // Catch: IllegalArgumentException -> L100
        return false;
    L33:
        if (r11 > (getHeight() - this.G)) goto L35;
    L37:
        r10 = false;
        goto L38
    L35:
        if (r6 >= 0.0f) goto L37;
    L44:
        if (this.e <= 0.0d) goto L56;
        float r12 = this.H;     // Catch: IllegalArgumentException -> L100
        if (r7 > r12) goto L48;
    L50:
        boolean r13 = false;
    L52:
        if (r9 > r12) goto L54;
    L67:
        boolean r14 = false;
    L68:
        if (r13 == false) goto L77;
        this.D = true;     // Catch: IllegalArgumentException -> L100
        ViewParent r15 = getParent();     // Catch: IllegalArgumentException -> L100
        if (r15 == null) goto L72;
        r15.requestDisallowInterceptTouchEvent(true);     // Catch: IllegalArgumentException -> L100
    L72:
        setScrollState(1);     // Catch: IllegalArgumentException -> L100
        if (r6 <= 0.0f) goto L75;
        float r17 = this.L + this.H;     // Catch: IllegalArgumentException -> L100
    L76:
        this.J = r17;     // Catch: IllegalArgumentException -> L100
        this.I = r8;     // Catch: IllegalArgumentException -> L100
        setScrollingCacheEnabled(true);     // Catch: IllegalArgumentException -> L100
    L80:
        if (this.D == false) goto L94;
        if (r(r5) == false) goto L94;
        ViewCompat.postInvalidateOnAnimation(this);     // Catch: IllegalArgumentException -> L100
        goto L94
    L75:
        r17 = this.L - this.H;     // Catch: IllegalArgumentException -> L100
        goto L76
    L77:
        if (r14 == false) goto L80;
        this.E = true;     // Catch: IllegalArgumentException -> L100
        goto L80
    L54:
        if (r7 >= (((double) r9) * this.f)) goto L67;
    L65:
        r14 = true;
        goto L68
    L48:
        if (r7 < (((double) r9) * this.f)) goto L50;
        r13 = true;
        goto L52
    L56:
        float r18 = this.H;     // Catch: IllegalArgumentException -> L100
        if (r7 > r18) goto L59;
    L61:
        boolean r19 = false;
    L63:
        if (r9 <= r18) goto L66;
        r13 = r19;
        goto L65
    L66:
        r13 = r19;
        goto L67
    L59:
        if ((r7 * 0.5f) <= r9) goto L61;
        r19 = true;
    L94:
        if (this.N != null) goto L96;
        this.N = VelocityTracker.obtain();     // Catch: IllegalArgumentException -> L100
    L96:
        this.N.addMovement(r16);     // Catch: IllegalArgumentException -> L100
    L103:
        return this.D;
    L21:
        if (r2 != 6) goto L94;
        p(r16);     // Catch: IllegalArgumentException -> L100
        goto L94
    L84:
        this.I = r16.getX();     // Catch: IllegalArgumentException -> L100
        this.K = r16.getX();     // Catch: IllegalArgumentException -> L100
        this.J = r16.getY();     // Catch: IllegalArgumentException -> L100
        this.L = r16.getY();     // Catch: IllegalArgumentException -> L100
        this.M = r16.getPointerId(0);     // Catch: IllegalArgumentException -> L100
        this.E = false;     // Catch: IllegalArgumentException -> L100
        this.q = true;     // Catch: IllegalArgumentException -> L100
        this.p.computeScrollOffset();     // Catch: IllegalArgumentException -> L100
        if (this.L0 == 2) goto L87;
    L92:
        f(false);     // Catch: IllegalArgumentException -> L100
        this.D = false;     // Catch: IllegalArgumentException -> L100
        goto L94
    L87:
        if (Math.abs(this.p.getFinalY() - this.p.getCurrY()) <= this.R) goto L92;
        this.p.abortAnimation();     // Catch: IllegalArgumentException -> L100
        this.B = false;     // Catch: IllegalArgumentException -> L100
        s();     // Catch: IllegalArgumentException -> L100
        this.D = true;     // Catch: IllegalArgumentException -> L100
        ViewParent r20 = getParent();     // Catch: IllegalArgumentException -> L100
        if (r20 == null) goto L91;
        r20.requestDisallowInterceptTouchEvent(true);     // Catch: IllegalArgumentException -> L100
    L91:
        setScrollState(1);     // Catch: IllegalArgumentException -> L100
    L100:
        e = move-exception;
        e.printStackTrace();
        goto L103
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable r4) {
        if ((r4 instanceof SavedState) == true) goto L6;
        super.onRestoreInstanceState(r4);
        return;
    L6:
        SavedState r5 = (SavedState) r4;
        super.onRestoreInstanceState(r5.getSuperState());
        PagerAdapter r0 = this.k;
        if (r0 == null) goto L9;
        r0.restoreState(r5.b, r5.c);
        z(r5.a, false, true, 0);
        return;
    L9:
        this.m = r5.a;
        this.n = r5.b;
        this.o = r5.c;
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r13) {
        boolean r1 = false;
        if (this.P0 == false) goto L85;
        return false;
    L85:
    L82:
        e = move-exception;
        e.printStackTrace();
    L84:
        return true;
    L77:
        e = move-exception;
        if (this.k.getCount() == this.d) goto L81;
        this.k.notifyDataSetChanged();
    L81:
        e.printStackTrace();
        goto L84
    L7:
        if (r13.getAction() == 0) goto L9;
    L11:
        PagerAdapter r2 = this.k;     // Catch: IllegalStateException -> L77 IllegalArgumentException -> L82
        if (r2 != null) goto L14;
    L76:
        return false;
    L14:
        if (r2.getCount() == 0) goto L76;
        if (this.N != null) goto L19;
        this.N = VelocityTracker.obtain();     // Catch: IllegalStateException -> L77 IllegalArgumentException -> L82
    L19:
        this.N.addMovement(r13);     // Catch: IllegalStateException -> L77 IllegalArgumentException -> L82
        int r3 = r13.getAction() & 255;     // Catch: IllegalStateException -> L77 IllegalArgumentException -> L82
        if (r3 == 0) goto L72;
        if (r3 == 1) goto L67;
        if (r3 == 2) goto L37;
        if (r3 == 3) goto L34;
        if (r3 != 5) goto L29;
        int r4 = r13.getActionIndex();     // Catch: IllegalStateException -> L77 IllegalArgumentException -> L82
        this.J = r13.getY(r4);     // Catch: IllegalStateException -> L77 IllegalArgumentException -> L82
        this.M = r13.getPointerId(r4);     // Catch: IllegalStateException -> L77 IllegalArgumentException -> L82
    L73:
        if (r1 == false) goto L84;
        ViewCompat.postInvalidateOnAnimation(this);     // Catch: IllegalStateException -> L77 IllegalArgumentException -> L82
    L29:
        if (r3 != 6) goto L73;
        p(r13);     // Catch: IllegalStateException -> L77 IllegalArgumentException -> L82
        this.J = r13.getY(r13.findPointerIndex(this.M));     // Catch: IllegalStateException -> L77 IllegalArgumentException -> L82
        goto L73
    L34:
        if (this.D == false) goto L73;
        x(this.l, true, 0, false);     // Catch: IllegalStateException -> L77 IllegalArgumentException -> L82
        r1 = w();     // Catch: IllegalStateException -> L77 IllegalArgumentException -> L82
        goto L73
    L37:
        if (this.D == true) goto L64;
        int r5 = r13.findPointerIndex(this.M);     // Catch: IllegalStateException -> L77 IllegalArgumentException -> L82
        if (r5 != (-1)) goto L41;
        r1 = w();     // Catch: IllegalStateException -> L77 IllegalArgumentException -> L82
        goto L73
    L41:
        float r6 = r13.getY(r5);     // Catch: IllegalStateException -> L77 IllegalArgumentException -> L82
        float r7 = Math.abs(r6 - this.J);     // Catch: IllegalStateException -> L77 IllegalArgumentException -> L82
        float r8 = r13.getX(r5);     // Catch: IllegalStateException -> L77 IllegalArgumentException -> L82
        float r9 = Math.abs(r8 - this.I);     // Catch: IllegalStateException -> L77 IllegalArgumentException -> L82
        if (this.e <= 0.0d) goto L47;
        if (r7 >= (((double) r9) * this.f)) goto L48;
    L49:
        boolean r10 = false;
    L51:
        if (r7 <= this.H) goto L64;
        if (r10 == false) goto L64;
        this.D = true;     // Catch: IllegalStateException -> L77 IllegalArgumentException -> L82
        ViewParent r11 = getParent();     // Catch: IllegalStateException -> L77 IllegalArgumentException -> L82
        if (r11 == null) goto L56;
        r11.requestDisallowInterceptTouchEvent(true);     // Catch: IllegalStateException -> L77 IllegalArgumentException -> L82
    L56:
        float r12 = this.L;     // Catch: IllegalStateException -> L77 IllegalArgumentException -> L82
        if ((r6 - r12) <= 0.0f) goto L59;
        float r14 = r12 + this.H;     // Catch: IllegalStateException -> L77 IllegalArgumentException -> L82
    L60:
        this.J = r14;     // Catch: IllegalStateException -> L77 IllegalArgumentException -> L82
        this.I = r8;     // Catch: IllegalStateException -> L77 IllegalArgumentException -> L82
        setScrollState(1);     // Catch: IllegalStateException -> L77 IllegalArgumentException -> L82
        setScrollingCacheEnabled(true);     // Catch: IllegalStateException -> L77 IllegalArgumentException -> L82
        ViewParent r15 = getParent();     // Catch: IllegalStateException -> L77 IllegalArgumentException -> L82
        if (r15 == null) goto L64;
        r15.requestDisallowInterceptTouchEvent(true);     // Catch: IllegalStateException -> L77 IllegalArgumentException -> L82
        goto L64
    L59:
        r14 = r12 - this.H;     // Catch: IllegalStateException -> L77 IllegalArgumentException -> L82
    L48:
        r10 = true;
        goto L51
    L47:
        if (r7 <= r9) goto L49;
    L64:
        if (this.D == false) goto L73;
        r1 = false | r(r13.getY(r13.findPointerIndex(this.M)));     // Catch: IllegalStateException -> L77 IllegalArgumentException -> L82
        goto L73
    L67:
        if (this.D == false) goto L73;
        VelocityTracker r16 = this.N;     // Catch: IllegalStateException -> L77 IllegalArgumentException -> L82
        r16.computeCurrentVelocity(ECDraweeView.SQUARE, this.P);     // Catch: IllegalStateException -> L77 IllegalArgumentException -> L82
        int r17 = (int) VelocityTrackerCompat.getYVelocity(r16, this.M);     // Catch: IllegalStateException -> L77 IllegalArgumentException -> L82
        this.B = true;     // Catch: IllegalStateException -> L77 IllegalArgumentException -> L82
        int r18 = getClientHeight();     // Catch: IllegalStateException -> L77 IllegalArgumentException -> L82
        int r19 = getScrollY();     // Catch: IllegalStateException -> L77 IllegalArgumentException -> L82
        e r20 = k();     // Catch: IllegalStateException -> L77 IllegalArgumentException -> L82
        if (r20 == null) goto L71;
        float r21 = r18;
        z(h(r20.b, ((r19 / r21) - r20.e) / (r20.d + (this.s / r21)), r17, (int) (r13.getY(r13.findPointerIndex(this.M)) - this.L)), true, true, r17);     // Catch: IllegalStateException -> L77 IllegalArgumentException -> L82
    L71:
        r1 = w();     // Catch: IllegalStateException -> L77 IllegalArgumentException -> L82
        goto L73
    L72:
        this.p.abortAnimation();     // Catch: IllegalStateException -> L77 IllegalArgumentException -> L82
        this.B = false;     // Catch: IllegalStateException -> L77 IllegalArgumentException -> L82
        s();     // Catch: IllegalStateException -> L77 IllegalArgumentException -> L82
        this.I = r13.getX();     // Catch: IllegalStateException -> L77 IllegalArgumentException -> L82
        this.K = r13.getX();     // Catch: IllegalStateException -> L77 IllegalArgumentException -> L82
        this.J = r13.getY();     // Catch: IllegalStateException -> L77 IllegalArgumentException -> L82
        this.L = r13.getY();     // Catch: IllegalStateException -> L77 IllegalArgumentException -> L82
        this.M = r13.getPointerId(0);     // Catch: IllegalStateException -> L77 IllegalArgumentException -> L82
        goto L73
    L9:
        if (r13.getEdgeFlags() == 0) goto L11;
        return false;
    }

    public final void p(MotionEvent r4) {
        int r0 = r4.getActionIndex();
        if (r4.getPointerId(r0) != this.M) goto L11;
        if (r0 != 0) goto L6;
        int r1 = 1;
    L7:
        this.J = r4.getY(r1);
        this.M = r4.getPointerId(r1);
        VelocityTracker r5 = this.N;
        if (r5 == null) goto L12;
        r5.clear();
        return;
    L12:
        return;
    L6:
        r1 = 0;
        goto L7
    }

    public final boolean q(int r8) {
        if (this.h.size() == 0) goto L5;
        e r0 = k();
        int r3 = getClientHeight();
        int r4 = this.s;
        int r5 = r3 + r4;
        float r6 = r3;
        float r7 = r4 / r6;
        if (r0 != null) goto L15;
        return false;
    L15:
        int r9 = r0.b;
        float r10 = ((r8 / r6) - r0.e) / (r0.d + r7);
        this.V = false;
        o(r9, r10, (int) (r5 * r10));
        if (this.V == false) goto L20;
        return true;
    L20:
        throw new IllegalStateException("onPageScrolled did not call superclass implementation");
    L5:
        if (this.U == false) goto L7;
        return false;
    L7:
        this.V = false;
        o(0, 0.0f, 0);
        if (this.V == false) goto L11;
        return false;
    L11:
        throw new IllegalStateException("onPageScrolled did not call superclass implementation");
    }

    public final boolean r(float r10) {
        float r0 = this.J - r10;
        this.J = r10;
        float r11 = getScrollY() + r0;
        float r1 = getClientHeight();
        float r2 = this.w * r1;
        float r3 = this.x * r1;
        boolean r4 = false;
        if (this.h.size() > 0) goto L5;
        return false;
    L5:
        e r5 = (e) ListProtector.get(this.h, 0);
        ArrayList<e> r6 = this.h;
        boolean r7 = true;
        e r8 = (e) ListProtector.get(r6, r6.size() - 1);
        if (r5.b == 0) goto L8;
        r2 = r5.e * r1;
        boolean r9 = false;
    L10:
        if (r8.b == (this.k.getCount() - 1)) goto L13;
        r3 = r8.e * r1;
        r7 = false;
    L13:
        if (r11 >= r2) goto L18;
        if (r9 == false) goto L16;
        r4 = this.S.onPull(Math.abs(r2 - r11) / r1);
    L16:
        r11 = r2;
    L22:
        this.I += r11 - ((int) r11);
        int r12 = (int) r11;
        scrollTo(getScrollX(), r12);
        q(r12);
        return r4;
    L18:
        if (r11 <= r3) goto L22;
        if (r7 == false) goto L21;
        r4 = this.T.onPull(Math.abs(r11 - r3) / r1);
    L21:
        r11 = r3;
        goto L22
    L8:
        r9 = true;
        goto L10
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public final void removeView(View r2) {
        if (this.z == false) goto L5;
        removeViewInLayout(r2);
        return;
    L5:
        super.removeView(r2);
    }

    public void setAdapter(PagerAdapter r8) {
        PagerAdapter r0 = this.k;
        if (r0 != null) goto L43;
    L22:
        this.k = r8;
        this.d = 0;
        if (r8 != null) goto L25;
        return;
    L25:
        if (this.r != null) goto L27;
        this.r = new h(this);
    L27:
        PagerAdapter r9 = this.k;
        h r1 = this.r;
        Field r4 = h1;     // Catch: IllegalAccessException -> L37
        if (r4 == null) goto L31;
        r4.set(r9, r1);     // Catch: IllegalAccessException -> L37
    L31:
        this.B = false;
        boolean r10 = this.U;
        this.U = true;
        this.d = this.k.getCount();
        if (this.m < 0) goto L34;
        this.k.restoreState(this.n, this.o);
        z(this.m, false, true, 0);
        this.m = -1;
        this.n = null;
        this.o = null;
        return;
    L34:
        if (r10 == true) goto L36;
        s();
        return;
    L36:
        requestLayout();
        return;
    L37:
        e = move-exception;
        throw new RuntimeException(e);
    L43:
        Field r5 = h1;     // Catch: IllegalAccessException -> L19
        if (r5 == null) goto L7;
        r5.set(r0, null);     // Catch: IllegalAccessException -> L19
    L7:
        this.k.startUpdate(this);
        int r2 = 0;
    L9:
        if (r2 >= this.h.size()) goto L11;
        e r6 = (e) ListProtector.get(this.h, r2);
        this.k.destroyItem(this, r6.b, r6.a);
        r2 = r2 + 1;
        goto L9
    L11:
        this.k.finishUpdate(this);
        this.h.clear();
        int r3 = 0;
    L13:
        if (r3 >= getChildCount()) goto L18;
        if (((LayoutParams) getChildAt(r3).getLayoutParams()).a == true) goto L17;
        removeViewAt(r3);
        r3 = r3 - 1;
    L17:
        r3 = r3 + 1;
        goto L13
    L18:
        this.l = 0;
        scrollTo(0, 0);
    L19:
        e = move-exception;
        throw new RuntimeException(e);
    }

    public void setCanTouch(boolean r1) {
        this.b = r1;
    }

    public void setChildrenDrawingOrderEnabledCompat(boolean r7) {
        if (this.p0 == null) goto L13;
    L11:
        Method r0 = this.p0;     // Catch: Exception -> L10
        if (r0 == null) goto L15;
        r0.invoke(this, new Object[]{Boolean.valueOf(r7)});     // Catch: Exception -> L10
        return;
    L15:
        return;
    L16:
        return;
    L13:
        this.p0 = ViewGroup.class.getDeclaredMethod("setChildrenDrawingOrderEnabled", new Class[]{Boolean.TYPE});     // Catch: NoSuchMethodException -> L9
        goto L11
    }

    public void setCurrentItem(int r3) {
        this.B = false;
        z(r3, !this.U, false, 0);
    }

    public void setCurrentItemWithDefaultVelocity(int r2) {
        this.B = false;
        z(r2, true, true, 1);
    }

    public void setDefaultItem(int r1) {
        this.l = r1;
    }

    public void setDisableScroll(boolean r1) {
        this.P0 = r1;
    }

    public void setLivePreviewScrollableAngle(double r4) {
        if (r4 > 0.0d) goto L5;
    L7:
        this.e = -1.0d;
        this.f = 1.0d;
        return;
    L5:
        if (r4 >= 180.0d) goto L7;
        this.e = r4;
        this.f = Math.tan(Math.toRadians(90.0d - (r4 / 2.0d)));
    }

    public void setOffscreenPageLimit(int r2) {
        if (r2 >= 1) goto L6;
        r2 = 1;
    L6:
        if (r2 == this.C) goto L9;
        this.C = r2;
        s();
        return;
    }

    public void setPageMargin(int r3) {
        int r0 = this.s;
        this.s = r3;
        int r1 = getHeight();
        u(r1, r1, r3, r0);
        requestLayout();
    }

    public void setPageMarginDrawable(Drawable r1) {
        this.t = r1;
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

    public void setScroller(Scroller r1) {
        this.p = r1;
    }

    public void setmRestoredCurItem(int r1) {
        this.m = r1;
    }

    public final void t(int r15) {
        int r0 = this.l;
        if (r0 == r15) goto L8;
        if (r0 >= r15) goto L6;
        int r1 = 130;
    L7:
        e r2 = l(r0);
        this.l = r15;
    L10:
        if (this.k != null) goto L13;
        return;
    L13:
        if (this.B == false) goto L16;
        return;
    L16:
        if (getWindowToken() != null) goto L18;
        return;
    L18:
        this.k.startUpdate(this);
        int r16 = this.C;
        int r3 = Math.max(0, this.l - r16);
        int r4 = this.k.getCount();
        int r17 = Math.min(r4 - 1, this.l + r16);
        if (r4 != this.d) goto L211;
        int r5 = 0;
    L22:
        if (r5 >= this.h.size()) goto L28;
        e r6 = (e) ListProtector.get(this.h, r5);
        int r7 = r6.b;
        int r8 = this.l;
        if (r7 >= r8) goto L25;
        r5 = r5 + 1;
        goto L22
    L25:
        if (r7 != r8) goto L28;
    L29:
        if (r6 != null) goto L32;
        if (r4 <= 0) goto L32;
        r6 = b(this.l, r5);
    L32:
        if (r6 == null) goto L164;
        int r9 = r5 - 1;
        if (r9 < 0) goto L36;
        e r10 = (e) ListProtector.get(this.h, r9);
    L37:
        int r11 = getClientHeight();
        if (r11 > 0) goto L40;
        float r12 = 0.0f;
    L41:
        int r13 = this.l - 1;
        float r14 = 0.0f;
    L42:
        if (r13 < 0) goto L66;
        if (r14 < r12) goto L55;
        if (r13 >= r3) goto L55;
        if (r10 == null) goto L66;
        if (r13 != r10.b) goto L65;
        if (r10.c == true) goto L65;
        ListProtector.remove(this.h, r9);
        this.k.destroyItem(this, r13, r10.a);
        r9 = r9 - 1;
        r5 = r5 - 1;
        if (r9 < 0) goto L64;
        r10 = (e) ListProtector.get(this.h, r9);
    L64:
        r10 = null;
    L65:
        r13 = r13 - 1;
    L55:
        if (r10 != null) goto L57;
    L61:
        r14 = r14 + b(r13, r9 + 1).d;
        r5 = r5 + 1;
        if (r9 < 0) goto L64;
        r10 = (e) ListProtector.get(this.h, r9);
        goto L65
    L57:
        if (r13 != r10.b) goto L61;
        r14 = r14 + r10.d;
        r9 = r9 - 1;
        if (r9 < 0) goto L64;
        r10 = (e) ListProtector.get(this.h, r9);
    L66:
        float r18 = r6.d;
        int r19 = r5 + 1;
        if (r18 < 2.0f) goto L69;
    L100:
        int r110 = this.k.getCount();
        int r20 = getClientHeight();
        if (r20 <= 0) goto L103;
        float r21 = this.s / r20;
    L104:
        if (r2 == null) goto L136;
        int r22 = r2.b;
        int r23 = r6.b;
        if (r22 >= r23) goto L122;
        float r24 = (r2.e + r2.d) + r21;
        int r25 = r22 + 1;
        int r26 = 0;
    L109:
        if (r25 > r6.b) goto L136;
        if (r26 >= this.h.size()) goto L136;
        Object r27 = ListProtector.get(this.h, r26);
    L113:
        e r28 = (e) r27;
        if (r25 <= r28.b) goto L119;
        if (r26 >= (this.h.size() - 1)) goto L119;
        r26 = r26 + 1;
        r27 = ListProtector.get(this.h, r26);
    L119:
        if (r25 >= r28.b) goto L121;
        r24 = r24 + (this.k.getPageWidth(r25) + r21);
        r25 = r25 + 1;
        goto L119
    L121:
        r28.e = r24;
        r24 = r24 + (r28.d + r21);
        r25 = r25 + 1;
        goto L109
    L122:
        if (r22 <= r23) goto L136;
        int r29 = this.h.size() - 1;
        float r30 = r2.e;
    L124:
        r22 = r22 - 1;
        if (r22 < r6.b) goto L136;
        if (r29 < 0) goto L136;
        Object r31 = ListProtector.get(this.h, r29);
    L128:
        e r32 = (e) r31;
        if (r22 >= r32.b) goto L133;
        if (r29 <= 0) goto L133;
        r29 = r29 - 1;
        r31 = ListProtector.get(this.h, r29);
    L133:
        if (r22 <= r32.b) goto L135;
        r30 = r30 - (this.k.getPageWidth(r22) + r21);
        r22 = r22 - 1;
        goto L133
    L135:
        r30 = r30 - (r32.d + r21);
        r32.e = r30;
    L136:
        int r33 = this.h.size();
        float r34 = r6.e;
        int r35 = r6.b;
        int r36 = r35 - 1;
        if (r35 != 0) goto L139;
        float r37 = r34;
    L140:
        this.w = r37;
        int r111 = r110 - 1;
        if (r35 != r111) goto L143;
        float r38 = (r6.d + r34) - 1.0f;
    L144:
        this.x = r38;
        int r39 = r5 - 1;
    L145:
        if (r39 < 0) goto L154;
        e r40 = (e) ListProtector.get(this.h, r39);
    L147:
        int r112 = r40.b;
        if (r36 <= r112) goto L150;
        r34 = r34 - (this.k.getPageWidth(r36) + r21);
        r36 = r36 - 1;
        goto L147
    L150:
        r34 = r34 - (r40.d + r21);
        r40.e = r34;
        if (r112 != 0) goto L153;
        this.w = r34;
    L153:
        r39 = r39 - 1;
        r36 = r36 - 1;
        goto L145
    L154:
        float r41 = (r6.e + r6.d) + r21;
        int r42 = r6.b;
    L155:
        r42 = r42 + 1;
        if (r19 >= r33) goto L164;
        e r43 = (e) ListProtector.get(this.h, r19);
    L158:
        int r44 = r43.b;
        if (r42 >= r44) goto L161;
        r41 = r41 + (this.k.getPageWidth(r42) + r21);
        r42 = r42 + 1;
        goto L158
    L161:
        if (r44 != r111) goto L163;
        this.x = (r43.d + r41) - 1.0f;
    L163:
        r43.e = r41;
        r41 = r41 + (r43.d + r21);
        r19 = r19 + 1;
        goto L155
    L143:
        r38 = Float.MAX_VALUE;
        goto L144
    L139:
        r37 = -3.4028235E38f;
        goto L140
    L103:
        r21 = 0.0f;
        goto L104
    L69:
        if (r19 >= this.h.size()) goto L71;
        e r45 = (e) ListProtector.get(this.h, r19);
    L72:
        if (r11 > 0) goto L74;
        float r46 = 0.0f;
    L75:
        int r47 = this.l + 1;
        int r113 = r19;
    L76:
        if (r47 >= r4) goto L100;
        if (r18 < r46) goto L89;
        if (r47 <= r17) goto L89;
        if (r45 == null) goto L100;
        if (r47 != r45.b) goto L99;
        if (r45.c == true) goto L99;
        ListProtector.remove(this.h, r113);
        this.k.destroyItem(this, r47, r45.a);
        if (r113 >= this.h.size()) goto L98;
        r45 = (e) ListProtector.get(this.h, r113);
    L98:
        r45 = null;
    L99:
        r47 = r47 + 1;
    L89:
        if (r45 != null) goto L91;
    L95:
        e r48 = b(r47, r113);
        r113 = r113 + 1;
        r18 = r18 + r48.d;
        if (r113 >= this.h.size()) goto L98;
        r45 = (e) ListProtector.get(this.h, r113);
        goto L99
    L91:
        if (r47 != r45.b) goto L95;
        r18 = r18 + r45.d;
        r113 = r113 + 1;
        if (r113 >= this.h.size()) goto L98;
        r45 = (e) ListProtector.get(this.h, r113);
        goto L99
    L74:
        r46 = (getPaddingRight() / r11) + 2.0f;
        goto L75
    L71:
        r45 = null;
        goto L72
    L40:
        r12 = (2.0f - r6.d) + (getPaddingLeft() / r11);
        goto L41
    L36:
        r10 = null;
    L164:
        PagerAdapter r114 = this.k;
        int r49 = this.l;
        if (r6 == null) goto L167;
        Object r50 = r6.a;
    L168:
        r114.setPrimaryItem(this, r49, r50);
        this.k.finishUpdate(this);
        int r115 = getChildCount();
        int r51 = 0;
    L169:
        if (r51 >= r115) goto L179;
        View r52 = getChildAt(r51);
        LayoutParams r53 = (LayoutParams) r52.getLayoutParams();
        r53.e = r51;
        if (r53.a == true) goto L177;
        if (r53.c != 0.0f) goto L177;
        e r54 = j(r52);
        if (r54 == null) goto L177;
        r53.c = r54.d;
        int r55 = r54.b;
        r53.getClass();
    L177:
        r51 = r51 + 1;
        goto L169
    L179:
        if (hasFocus() == false) goto L205;
        View r116 = findFocus();
        if (r116 == null) goto L190;
    L182:
        Object r56 = r116.getParent();
        if (r56 == this) goto L189;
        if (r56 == null) goto L190;
        if ((r56 instanceof View) == false) goto L190;
        r116 = (View) r56;
        goto L182
    L189:
        e r117 = j(r116);
    L191:
        if (r117 != null) goto L193;
    L194:
        int r118 = 0;
    L196:
        if (r118 >= getChildCount()) goto L265;
        View r57 = getChildAt(r118);
        e r58 = j(r57);
        if (r58 == null) goto L204;
        if (r58.b != this.l) goto L204;
        if (r57.requestFocus(r1) == false) goto L204;
        return;
    L204:
        r118 = r118 + 1;
        goto L196
    L265:
        return;
    L193:
        if (r117.b != this.l) goto L194;
        return;
    L190:
        r117 = null;
        goto L191
    L205:
        return;
    L167:
        r50 = null;
    L28:
        r6 = null;
        goto L29
    L211:
        String r119 = getResources().getResourceName(getId());     // Catch: Resources.NotFoundException -> L208
    L210:
        throw new IllegalStateException("The application's PagerAdapter changed the adapter's contents without calling PagerAdapter#notifyDataSetChanged! Expected adapter item count: " + this.d + ", found: " + r4 + " Pager id: " + r119 + " Pager class: " + getClass() + " Problematic adapter: " + this.k.getClass());
    L208:
        r119 = Integer.toHexString(getId());
        goto L210
    L6:
        r1 = 33;
        goto L7
    L8:
        r1 = 2;
        r2 = null;
        goto L10
    }

    public final void v(ViewPager.OnPageChangeListener r2) {
        List<ViewPager.OnPageChangeListener> r0 = this.k0;
        if (r0 == null) goto L6;
        r0.remove(r2);
        return;
    }

    @Override // android.view.View
    public final boolean verifyDrawable(Drawable r2) {
        if (super.verifyDrawable(r2) == false) goto L5;
    L8:
        return true;
    L5:
        if (r2 == this.t) goto L8;
        return false;
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams r1) {
        return generateDefaultLayoutParams();
    }

    public void setPageMarginDrawable(int r2) {
        setPageMarginDrawable(getContext().getResources().getDrawable(r2));
    }

    public VerticalViewPager(Context r3, AttributeSet r4) {
        super(r3, r4);
        this.a = com.bytedance.awemeopen.apps.framework.feed.ui.information.a.o;
        this.c = null;
        this.e = -1.0d;
        this.f = 1.0d;
        this.g = 0.0f;
        this.h = new ArrayList();
        this.i = new e();
        this.j = new Rect();
        this.m = -1;
        this.n = null;
        this.o = null;
        this.w = -3.4028235E38f;
        this.x = Float.MAX_VALUE;
        this.C = 1;
        this.M = -1;
        this.U = true;
        this.k0 = new CopyOnWriteArrayList();
        this.H0 = new c(this);
        this.L0 = 0;
        this.P0 = false;
        n();
        m();
    }

    public final e b(int r3, int r4) {
        e r0 = new e();
        r0.b = r3;
        r0.a = this.k.instantiateItem(this, r3);
        r0.d = this.k.getPageWidth(r3);
        if (r4 >= 0) goto L5;
    L8:
        this.h.add(r0);
    L9:
        return r0;
    L5:
        if (r4 >= this.h.size()) goto L8;
        ListProtector.add(this.h, r4, r0);
        goto L9
    }

    @Override // android.view.ViewGroup
    public final int getChildDrawingOrder(int r1, int r2) {
        return ((LayoutParams) ((View) ListProtector.get(null, r2)).getLayoutParams()).e;
    }

    public final Rect i(Rect r3, View r4) {
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
        int r16 = getMeasuredHeight();
        this.G = Math.min(r16 / 10, this.F);
        int r17 = (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
        int r18 = (r16 - getPaddingTop()) - getPaddingBottom();
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
        if (r8 != 8388611) goto L21;
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
        if (r8 == 8388613) goto L24;
        r4 = false;
        goto L24
    L14:
        if (r9 == 80) goto L17;
        r10 = false;
    L48:
        r2 = r2 + 1;
        goto L3
    L49:
        this.y = View.MeasureSpec.makeMeasureSpec(r17, 1073741824);
        View.MeasureSpec.makeMeasureSpec(r18, 1073741824);
        this.z = true;
        s();
        this.z = false;
        int r110 = getChildCount();
    L50:
        if (r0 >= r110) goto L59;
        View r20 = getChildAt(r0);
        if (r20.getVisibility() == 8) goto L58;
        LayoutParams r21 = (LayoutParams) r20.getLayoutParams();
        if (r21 != null) goto L56;
    L57:
        r20.measure(this.y, View.MeasureSpec.makeMeasureSpec((int) (r18 * r21.c), 1073741824));
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
        e r6 = j(r5);
        if (r6 == null) goto L16;
        if (r6.b != this.l) goto L16;
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

    public final void y(int r2, boolean r3) {
        this.B = false;
        z(r2, r3, false, 0);
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
        e r4 = j(r3);
        if (r4 == null) goto L14;
        if (r4.b != this.l) goto L14;
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
    public final void addView(View r4, int r5, ViewGroup.LayoutParams r6) {
        if (checkLayoutParams(r6) == true) goto L5;
        r6 = generateLayoutParams(r6);
    L5:
        LayoutParams r0 = (LayoutParams) r6;
        boolean r1 = r0.a | false;
        r0.a = r1;
        if (this.z == false) goto L11;
        if (r1 == true) goto L10;
        r0.d = true;
        addViewInLayout(r4, r5, r6);
        return;
    L10:
        throw new IllegalStateException("Cannot add pager decor view during layout");
    L11:
        super.addView(r4, r5, r6);
    }

    public final void o(int r11, float r12, int r13) {
        if (this.W <= 0) goto L25;
        int r0 = getScrollY();
        int r1 = getPaddingTop();
        int r2 = getPaddingBottom();
        int r3 = getHeight();
        int r4 = getChildCount();
        int r5 = 0;
    L5:
        if (r5 >= r4) goto L25;
        View r6 = getChildAt(r5);
        LayoutParams r7 = (LayoutParams) r6.getLayoutParams();
        if (r7.a == false) goto L24;
        int r8 = r7.b & 112;
        if (r8 != 16) goto L12;
        int r9 = Math.max((r3 - r6.getMeasuredHeight()) / 2, r1);
    L19:
        int r10 = r9;
        int r14 = r1;
        r1 = r10;
    L20:
        int r15 = (r1 + r0) - r6.getTop();
        if (r15 == 0) goto L23;
        r6.offsetTopAndBottom(r15);
    L23:
        r1 = r14;
        goto L24
    L12:
        if (r8 != 48) goto L14;
        r14 = r6.getHeight() + r1;
        goto L20
    L14:
        if (r8 == 80) goto L16;
        r14 = r1;
        goto L20
    L16:
        r9 = (r3 - r2) - r6.getMeasuredHeight();
        r2 = r2 + r6.getMeasuredHeight();
    L24:
        r5 = r5 + 1;
    L25:
        List<ViewPager.OnPageChangeListener> r16 = this.k0;
        if (r16 != null) goto L28;
    L33:
        this.V = true;
        return;
    L28:
        if (r16.isEmpty() == true) goto L33;
        Iterator<ViewPager.OnPageChangeListener> r17 = this.k0.iterator();
    L31:
        if (r17.hasNext() == false) goto L33;
        r17.next().onPageScrolled(r11, r12, r13);
        goto L31
    }

    public final int h(int r2, float r3, int r4, int r5) {
        if (Math.abs(r5) <= this.Q) goto L10;
        if (Math.abs(r4) <= this.O) goto L10;
        if (r4 > 0) goto L21;
        r2 = r2 + 1;
    L21:
        if (this.h.size() <= 0) goto L24;
        e r6 = (e) ListProtector.get(this.h, 0);
        ArrayList<e> r7 = this.h;
        return Math.max(r6.b, Math.min(r2, ((e) ListProtector.get(r7, r7.size() - 1)).b));
    L24:
        return r2;
    L10:
        if (r2 < this.l) goto L12;
        float r8 = 0.6f;
    L14:
        if (Float.compare(this.g, 0.0f) > 0) goto L16;
    L19:
        r2 = (int) ((r2 + r3) + r8);
        goto L21
    L16:
        if (r2 < this.l) goto L18;
        r8 = 1.0f - this.g;
        goto L19
    L18:
        r8 = this.g;
        goto L19
    L12:
        r8 = 0.4f;
        goto L14
    }

    @Override // android.view.View
    public final void onSizeChanged(int r1, int r2, int r3, int r4) {
        super.onSizeChanged(r1, r2, r3, r4);
        if (r2 == r4) goto L6;
        int r5 = this.s;
        u(r2, r4, r5, r5);
        return;
    }

    public final void u(int r9, int r10, int r11, int r12) {
        float r0 = 0.0f;
        if (r10 > 0) goto L5;
    L23:
        e r13 = l(this.l);
        if (r13 == null) goto L26;
        r0 = Math.min(r13.e, this.x);
    L26:
        int r14 = (int) (r0 * ((r9 - getPaddingTop()) - getPaddingBottom()));
        if (r14 == getScrollY()) goto L34;
        f(false);
        scrollTo(getScrollX(), r14);
        return;
    L34:
        return;
    L5:
        if (this.h.isEmpty() == true) goto L23;
        int r15 = ((r9 - getPaddingTop()) - getPaddingBottom()) + r11;
        int r16 = ((r10 - getPaddingTop()) - getPaddingBottom()) + r12;
        if (this.p.isFinished() == false) goto L9;
        scrollTo(getScrollX(), (int) ((getScrollY() / r16) * r15));
        return;
    L9:
        if (this.a == true) goto L11;
        this.p.setFinalY(getCurrentItem() * getClientHeight());
        return;
    L11:
        int r17 = getScrollY();
        if (r16 <= 0) goto L14;
        r0 = r17 / r16;
    L14:
        float r18 = r15;
        int r4 = (int) (r0 * r18);
        int r19 = this.p.getFinalY();
        if (r16 <= 0) goto L17;
        r19 = (int) ((r19 / r16) * r18);
    L17:
        int r7 = Math.max(0, this.p.getDuration() - this.p.timePassed());
        this.p.abortAnimation();
        scrollTo(getScrollX(), r4);
        if (r7 <= 0) goto L21;
        if (r19 == r4) goto L21;
        this.q = false;
        this.p.startScroll(getScrollX(), r4, 0, r19 - r4, r7);
        ViewCompat.postInvalidateOnAnimation(this);
        return;
    L21:
        scrollTo(getScrollX(), r19);
    }

    public final void x(int r16, boolean r17, int r18, boolean r19) {
        e r2 = l(r16);
        if (r2 == null) goto L5;
        int r3 = (int) (getClientHeight() * Math.max(this.w, Math.min(r2.e, this.x)));
    L6:
        if (r17 == true) goto L8;
        if (r19 == false) goto L50;
        List<ViewPager.OnPageChangeListener> r4 = this.k0;
        if (r4 == null) goto L50;
        if (((CopyOnWriteArrayList) r4).isEmpty() == true) goto L50;
        Iterator r5 = ((CopyOnWriteArrayList) this.k0).iterator();
    L48:
        if (r5.hasNext() == false) goto L50;
        ((ViewPager.OnPageChangeListener) r5.next()).onPageSelected(r16);
    L50:
        f(false);
        scrollTo(0, r3);
        q(r3);
        return;
    L8:
        if (getChildCount() != 0) goto L10;
        setScrollingCacheEnabled(false);
    L32:
        if (r19 == false) goto L54;
        List<ViewPager.OnPageChangeListener> r6 = this.k0;
        if (r6 != null) goto L36;
        return;
    L36:
        if (((CopyOnWriteArrayList) r6).isEmpty() == true) goto L56;
        Iterator r7 = ((CopyOnWriteArrayList) this.k0).iterator();
    L39:
        if (r7.hasNext() == false) goto L57;
        ((ViewPager.OnPageChangeListener) r7.next()).onPageSelected(r16);
        goto L39
    L57:
        return;
    L56:
        return;
    L54:
        return;
    L10:
        Scroller r8 = this.p;
        if (r8 != null) goto L13;
    L15:
        boolean r9 = false;
    L16:
        if (r9 == true) goto L18;
        int r10 = getScrollY();
    L23:
        int r11 = r10;
        int r12 = getScrollX();
        int r13 = 0 - r12;
        int r14 = r3 - r11;
        if (r13 != 0) goto L27;
        if (r14 != 0) goto L27;
        f(false);
        s();
        setScrollState(0);
    L27:
        setScrollingCacheEnabled(true);
        setScrollState(2);
        int r15 = getClientHeight();
        int r20 = r15 / 2;
        float r21 = r15;
        float r22 = r20;
        float r23 = r22 + (((float) Math.sin((float) (((double) (Math.min(1.0f, (Math.abs(r13) * 1.0f) / r21) - 0.5f)) * 0.4712389167638204d))) * r22);
        int r24 = Math.abs(r18);
        if (r24 <= 0) goto L30;
        int r25 = Math.round(Math.abs(r23 / r24) * 1000.0f) * 4;
    L31:
        int r110 = Math.min(r25, 600);
        this.q = false;
        this.p.startScroll(r12, r11, r13, r14, r110);
        ViewCompat.postInvalidateOnAnimation(this);
        goto L32
    L30:
        r25 = (int) (((Math.abs(r13) / ((r21 * this.k.getPageWidth(this.l)) + this.s)) + 1.0f) * 100.0f);
        goto L31
    L18:
        if (this.q == false) goto L20;
        r10 = this.p.getCurrY();
    L21:
        this.p.abortAnimation();
        setScrollingCacheEnabled(false);
        goto L23
    L20:
        r10 = this.p.getStartY();
        goto L21
    L13:
        if (r8.isFinished() == true) goto L15;
        r9 = true;
        goto L16
    L5:
        r3 = 0;
        goto L6
    }

    public final void z(int r5, boolean r6, boolean r7, int r8) {
        PagerAdapter r0 = this.k;
        boolean r1 = false;
        if (r0 != null) goto L5;
    L46:
        setScrollingCacheEnabled(false);
        return;
    L5:
        if (r0.getCount() <= 0) goto L46;
        if (r7 == true) goto L15;
        if (this.l != r5) goto L15;
        if (this.h.size() == 0) goto L15;
        setScrollingCacheEnabled(false);
        return;
    L15:
        if (r5 >= 0) goto L18;
        r5 = 0;
    L20:
        int r2 = this.C;
        int r3 = this.l;
        if (r5 <= (r3 + r2)) goto L23;
    L24:
        int r4 = 0;
    L26:
        if (r4 >= this.h.size()) goto L29;
        ((e) ListProtector.get(this.h, r4)).c = true;
        r4 = r4 + 1;
    L29:
        if (this.l == r5) goto L32;
        r1 = true;
    L32:
        if (this.U == false) goto L44;
        this.l = r5;
        if (r1 == false) goto L43;
        List<ViewPager.OnPageChangeListener> r9 = this.k0;
        if (r9 == null) goto L43;
        if (((CopyOnWriteArrayList) r9).isEmpty() == true) goto L43;
        Iterator r10 = ((CopyOnWriteArrayList) this.k0).iterator();
    L41:
        if (r10.hasNext() == false) goto L43;
        ((ViewPager.OnPageChangeListener) r10.next()).onPageSelected(r5);
    L43:
        requestLayout();
        return;
    L44:
        t(r5);
        x(r5, r6, r8, r1);
        return;
    L23:
        if (r5 >= (r3 - r2)) goto L29;
    L18:
        if (r5 < this.k.getCount()) goto L20;
        r5 = this.k.getCount() - 1;
        goto L20
    }

    public static boolean e(View r9, boolean r10, int r11, int r12, int r13) {
        if ((r9 instanceof ViewGroup) == false) goto L18;
        ViewGroup r0 = (ViewGroup) r9;
        int r2 = r9.getScrollX();
        int r3 = r9.getScrollY();
        int r4 = r0.getChildCount() - 1;
    L5:
        if (r4 < 0) goto L18;
        View r5 = r0.getChildAt(r4);
        int r6 = r13 + r3;
        if (r6 < r5.getTop()) goto L17;
        if (r6 >= r5.getBottom()) goto L17;
        int r7 = r12 + r2;
        if (r7 < r5.getLeft()) goto L17;
        if (r7 >= r5.getRight()) goto L17;
        if (e(r5, true, r11, r7 - r5.getLeft(), r6 - r5.getTop()) == false) goto L17;
        return true;
    L17:
        r4 = r4 - 1;
    L18:
        if (r10 == true) goto L20;
    L22:
        return false;
    L20:
        if (ViewCompat.canScrollVertically(r9, -r11) == false) goto L22;
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
        int r8 = getScrollY();
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
        int r9 = r5 + r8;
        r13.layout(r4, r9, r13.getMeasuredWidth() + r4, r9 + r13.getMeasuredHeight());
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
        if (r15 != 8388611) goto L14;
        r110 = r13.getMeasuredWidth() + r4;
        goto L21
    L14:
        if (r15 == 8388613) goto L16;
        r110 = r4;
        goto L21
    L16:
        r17 = (r2 - r6) - r13.getMeasuredWidth();
        r6 = r6 + r13.getMeasuredWidth();
    L32:
        r10 = r10 + 1;
        goto L4
    L33:
        int r24 = (r3 - r5) - r7;
        int r25 = 0;
    L34:
        if (r25 >= r1) goto L45;
        View r26 = getChildAt(r25);
        if (r26.getVisibility() == 8) goto L44;
        LayoutParams r27 = (LayoutParams) r26.getLayoutParams();
        e r114 = j(r26);
        if (r27.a == true) goto L44;
        if (r114 == null) goto L44;
        float r115 = r24;
        int r116 = ((int) (r114.e * r115)) + r5;
        if (r27.d == false) goto L43;
        r27.d = false;
        r26.measure(View.MeasureSpec.makeMeasureSpec((r2 - r4) - r6, 1073741824), View.MeasureSpec.makeMeasureSpec((int) (r115 * r27.c), 1073741824));
    L43:
        r26.layout(r4, r116, r26.getMeasuredWidth() + r4, r26.getMeasuredHeight() + r116);
    L44:
        r25 = r25 + 1;
        goto L34
    L45:
        this.u = r4;
        this.v = r2 - r6;
        this.W = r11;
        if (this.U == false) goto L48;
        boolean r28 = false;
        x(this.l, false, 0, false);
    L49:
        this.U = r28;
        return;
    L48:
        r28 = false;
        goto L49
    }
}
