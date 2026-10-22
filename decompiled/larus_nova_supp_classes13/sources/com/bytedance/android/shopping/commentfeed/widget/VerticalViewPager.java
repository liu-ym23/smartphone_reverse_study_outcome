package com.bytedance.android.shopping.commentfeed.widget;

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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public class VerticalViewPager extends ViewGroup {
    public static final b H0 = null;
    public static final Field L0 = null;
    public static final int[] k0 = null;
    public static final a p0 = null;
    public int A;
    public int B;
    public int C;
    public float D;
    public float E;
    public float F;
    public float G;
    public int H;
    public VelocityTracker I;
    public int J;
    public int K;
    public int L;
    public int M;
    public EdgeEffectCompat N;
    public EdgeEffectCompat O;
    public boolean P;
    public boolean Q;
    public int R;
    public final List<ViewPager.OnPageChangeListener> S;
    public Method T;
    public final c U;
    public int V;
    public boolean W;
    public boolean a;
    public int b;
    public final ArrayList<e> c;
    public final e d;
    public final Rect e;
    public PagerAdapter f;
    public int g;
    public int h;
    public Parcelable i;
    public ClassLoader j;
    public Scroller k;
    public boolean l;
    public h m;
    public int n;
    public Drawable o;
    public int p;
    public int q;
    public float r;
    public float s;
    public int t;
    public boolean u;
    public boolean v;
    public boolean w;
    public int x;
    public boolean y;
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
            TypedArray r4 = r2.obtainStyledAttributes(r3, VerticalViewPager.k0);
            this.b = r4.getInteger(0, 48);
            r4.recycle();
        }
    }

    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = null;
        public int a;
        public Parcelable b;
        public final ClassLoader c;

        public class a implements ParcelableCompatCreatorCallbacks<SavedState> {
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

    public class a implements Comparator<e> {
        public a() {
        }

        @Override // java.util.Comparator
        public final int compare(e r1, e r2) {
            return r1.b - r2.b;
        }
    }

    public class b implements Interpolator {
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
            this.a.q();     // Catch: Throwable -> L4
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
            PagerAdapter r0 = this.a.f;
            if (r0 == null) goto L7;
            boolean r1 = true;
            if (r0.getCount() <= 1) goto L7;
        L8:
            r5.setScrollable(r1);
            if (r4.getEventType() != 4096) goto L14;
            PagerAdapter r6 = this.a.f;
            if (r6 == null) goto L15;
            r5.setItemCount(r6.getCount());
            r5.setFromIndex(this.a.g);
            r5.setToIndex(this.a.g);
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
            PagerAdapter r4 = this.a.f;
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
            r5.setCurrentItem(r5.g - 1);
            return true;
        L14:
            return false;
        L16:
            if (this.a.canScrollVertically(1) == false) goto L19;
            VerticalViewPager r6 = this.a;
            r6.setCurrentItem(r6.g + 1);
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
            this.a.f();
        }

        @Override // android.database.DataSetObserver
        public final void onInvalidated() {
            this.a.f();
        }

        public h(VerticalViewPager r1) {
            this.a = r1;
        }
    }

    static {
        k0 = new int[]{R.attr.layout_gravity};
        p0 = new a();
        H0 = new b();
        Field r1 = PagerAdapter.class.getDeclaredField("mViewPagerObserver");     // Catch: NoSuchFieldException -> L5
        L0 = r1;     // Catch: NoSuchFieldException -> L5
        r1.setAccessible(true);     // Catch: NoSuchFieldException -> L5
        return;
    L5:
        e = move-exception;
        throw new RuntimeException(e);
    }

    @Override // android.view.View
    public final void computeScroll() {
        this.l = true;
        if (this.k.isFinished() == false) goto L5;
    L14:
        e(true);
        return;
    L5:
        if (this.k.computeScrollOffset() == false) goto L14;
        int r0 = getScrollX();
        int r1 = getScrollY();
        int r2 = this.k.getCurrX();
        int r3 = this.k.getCurrY();
        if (r0 != r2) goto L9;
        if (r1 != r3) goto L9;
    L12:
        ViewCompat.postInvalidateOnAnimation(this);
        return;
    L9:
        scrollTo(r2, r3);
        if (o(r3) == true) goto L12;
        this.k.abortAnimation();
        scrollTo(r2, 0);
        goto L12
    }

    public final void l() {
        this.a = true;
        setWillNotDraw(false);
        setDescendantFocusability(262144);
        setFocusable(true);
        Context r1 = getContext();
        this.k = new Scroller(r1, H0);
        ViewConfiguration r2 = ViewConfiguration.get(r1);
        Resources r3 = r1.getResources();
        float r4 = WindowDisplayMetricsOverride.apply(r3, r3.getDisplayMetrics()).density;
        this.C = ViewConfigurationCompat.getScaledPagingTouchSlop(r2);
        this.J = (int) (400.0f * r4);
        this.K = r2.getScaledMaximumFlingVelocity();
        this.N = new EdgeEffectCompat(r1);
        this.O = new EdgeEffectCompat(r1);
        this.L = (int) (25.0f * r4);
        this.M = (int) (2.0f * r4);
        this.A = (int) (r4 * 16.0f);
        ViewCompat.setAccessibilityDelegate(this, new f(this));
        if (ViewCompat.getImportantForAccessibility(this) != 0) goto L5;
        ViewCompat.setImportantForAccessibility(this, 1);
    L5:
        ViewCompat.setOnApplyWindowInsetsListener(this, new d(this));
    }

    public void setOnAdapterChangeListener(g r1) {
    }

    public final boolean t() {
        this.H = -1;
        this.y = false;
        this.z = false;
        VelocityTracker r0 = this.I;
        if (r0 == null) goto L6;
        r0.recycle();
        this.I = null;
    L6:
        return this.N.onRelease() | this.O.onRelease();
    }

    public final void f() {
        int r0 = this.f.getCount();
        this.b = r0;
        if (this.c.size() < ((this.x * 2) + 1)) goto L5;
    L7:
        boolean r1 = false;
    L8:
        int r2 = this.g;
        int r5 = 0;
        boolean r6 = false;
    L10:
        if (r5 >= this.c.size()) goto L30;
        e r7 = (e) ListProtector.get(this.c, r5);
        int r8 = this.f.getItemPosition(r7.a);
        if (r8 == (-1)) goto L29;
        if (r8 != (-2)) goto L22;
        ListProtector.remove(this.c, r5);
        r5 = r5 - 1;
        if (r6 == true) goto L19;
        this.f.startUpdate(this);
        r6 = true;
    L19:
        this.f.destroyItem(this, r7.b, r7.a);
        int r3 = this.g;
        if (r3 != r7.b) goto L28;
        r2 = Math.max(0, Math.min(r3, (-1) + r0));
    L28:
        r1 = true;
        goto L29
    L22:
        int r9 = r7.b;
        if (r9 == r8) goto L29;
        if (r9 != this.g) goto L27;
        r2 = r8;
    L27:
        r7.b = r8;
    L29:
        r5 = r5 + 1;
        goto L10
    L30:
        if (r6 == false) goto L32;
        this.f.finishUpdate(this);
    L32:
        Collections.sort(this.c, p0);
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
        v(r2, false, true, 0);
        requestLayout();
        return;
    L49:
        return;
    L5:
        if (this.c.size() >= r0) goto L7;
        r1 = true;
        goto L8
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        removeCallbacks(this.U);
        Scroller r0 = this.k;
        if (r0 != null) goto L5;
    L7:
        super.onDetachedFromWindow();
        return;
    L5:
        if (r0.isFinished() == true) goto L7;
        this.k.abortAnimation();
        goto L7
    }

    public final void q() {
        r(this.g);
    }

    private int getClientHeight() {
        return (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable r0 = this.o;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.isStateful() == false) goto L9;
        r0.setState(getDrawableState());
        return;
    }

    public final e j() {
        int r0 = getClientHeight();
        float r1 = 0.0f;
        if (r0 <= 0) goto L5;
        float r2 = getScrollY() / r0;
    L6:
        if (r0 <= 0) goto L8;
        float r3 = this.n / r0;
    L9:
        e r7 = null;
        float r4 = 0.0f;
        int r6 = -1;
        int r8 = 0;
        boolean r9 = true;
    L11:
        if (r8 >= this.c.size()) goto L30;
        e r10 = (e) ListProtector.get(this.c, r8);
        if (r9 == true) goto L17;
        int r11 = r6 + 1;
        if (r10.b == r11) goto L17;
        r10 = this.d;
        r10.e = (r1 + r4) + r3;
        r10.b = r11;
        r10.d = this.f.getPageWidth(r11);
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
        if (r8 == (this.c.size() - 1)) goto L29;
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
        this.P = true;
    }

    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        SavedState r1 = new SavedState(super.onSaveInstanceState());
        r1.a = this.g;
        PagerAdapter r0 = this.f;
        if (r0 == null) goto L5;
        r1.b = r0.saveState();
    L5:
        return r1;
    }

    public PagerAdapter getAdapter() {
        return this.f;
    }

    public int getCurrentItem() {
        return this.g;
    }

    public int getExpectedAdapterCount() {
        return this.b;
    }

    public int getOffscreenPageLimit() {
        return this.x;
    }

    public int getPageMargin() {
        return this.n;
    }

    public VerticalViewPager(Context r2) {
        super(r2);
        this.c = new ArrayList();
        this.d = new e();
        this.e = new Rect();
        this.h = -1;
        this.i = null;
        this.j = null;
        this.r = -3.4028235E38f;
        this.s = Float.MAX_VALUE;
        this.x = 1;
        this.H = -1;
        this.P = true;
        this.S = new ArrayList();
        this.U = new c(this);
        this.V = 0;
        this.W = false;
        l();
    }

    public static /* synthetic */ void a(VerticalViewPager r1) {
        r1.setScrollState(0);
    }

    private void setScrollState(int r3) {
        if (this.V != r3) goto L5;
        return;
    L5:
        this.V = r3;
        List<ViewPager.OnPageChangeListener> r0 = this.S;
        if (r0 != null) goto L8;
        return;
    L8:
        if (r0.isEmpty() == true) goto L15;
        Iterator<ViewPager.OnPageChangeListener> r1 = this.S.iterator();
    L11:
        if (r1.hasNext() == false) goto L16;
        r1.next().onPageScrollStateChanged(r3);
        goto L11
    L16:
        return;
    }

    private void setScrollingCacheEnabled(boolean r2) {
        if (this.v == r2) goto L6;
        this.v = r2;
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
        if (r2.b != this.g) goto L12;
        r1.addTouchables(r5);
    L12:
        r0 = r0 + 1;
        goto L4
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
        if (r6 == null) goto L42;
        if (r6 == r0) goto L42;
        if (r7 != 33) goto L32;
        int r8 = h(this.e, r6).top;
        int r9 = h(this.e, r0).top;
        if (r0 == null) goto L30;
        if (r8 < r9) goto L30;
        int r10 = this.g;
        if (r10 <= 0) goto L56;
        this.w = false;
        v(r10 - 1, true, false, 0);
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
        int r12 = h(this.e, r6).bottom;
        int r13 = h(this.e, r0).bottom;
        if (r0 == null) goto L41;
        if (r12 > r13) goto L41;
        PagerAdapter r14 = this.f;
        if (r14 == null) goto L56;
        if (this.g >= (r14.getCount() - 1)) goto L56;
        int r15 = this.g + 1;
        this.w = false;
        v(r15, true, false, 0);
    L41:
        r11 = r6.requestFocus();
    L42:
        if (r7 == 33) goto L53;
        if (r7 == 1) goto L53;
        if (r7 != 130) goto L47;
    L48:
        PagerAdapter r16 = this.f;
        if (r16 == null) goto L56;
        if (this.g >= (r16.getCount() - 1)) goto L56;
        int r17 = this.g + 1;
        this.w = false;
        v(r17, true, false, 0);
        goto L57
    L47:
        if (r7 != 2) goto L58;
    L53:
        int r18 = this.g;
        if (r18 <= 0) goto L56;
        this.w = false;
        v(r18 - 1, true, false, 0);
    L19:
        r0 = null;
        goto L20
    }

    @Override // android.view.View
    public final boolean canScrollVertically(int r5) {
        if (this.f != null) goto L5;
        return false;
    L5:
        int r0 = getClientHeight();
        int r2 = getScrollY();
        if (r5 < 0) goto L8;
        if (r5 > 0) goto L13;
        return false;
    L13:
        if (r2 >= ((int) (r0 * this.s))) goto L18;
        return true;
    L18:
        return false;
    L8:
        if (r2 <= ((int) (r0 * this.r))) goto L16;
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
    public final boolean dispatchKeyEvent(KeyEvent r5) {
        if (super.dispatchKeyEvent(r5) == false) goto L5;
        return true;
    L5:
        if (r5.getAction() != 0) goto L21;
        int r0 = r5.getKeyCode();
        if (r0 != 21) goto L9;
        boolean r6 = c(17);
    L22:
        if (r6 == true) goto L27;
        return false;
    L27:
        return true;
    L9:
        if (r0 != 22) goto L11;
        r6 = c(66);
        goto L22
    L11:
        if (r0 != 61) goto L21;
        if (r5.hasNoModifiers() == false) goto L17;
        r6 = c(2);
        goto L22
    L17:
        if (r5.hasModifiers(1) == false) goto L21;
        r6 = c(1);
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
        e r4 = i(r3);
        if (r4 == null) goto L18;
        if (r4.b != this.g) goto L18;
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
    public final boolean dispatchTouchEvent(MotionEvent r2) {
        if (this.a == true) goto L5;
    L7:
        return false;
    L5:
        if (super.dispatchTouchEvent(r2) == false) goto L7;
        return true;
    }

    @Override // android.view.View
    public final void draw(Canvas r8) {
        super.draw(r8);     // Catch: Exception -> L4
    L6:
        int r0 = ViewCompat.getOverScrollMode(this);
        boolean r1 = false;
        if (r0 == 0) goto L17;
        if (r0 != 1) goto L15;
        PagerAdapter r2 = this.f;
        if (r2 == null) goto L15;
        if (r2.getCount() > 1) goto L17;
    L15:
        this.N.finish();
        this.O.finish();
    L22:
        if (r1 == false) goto L27;
        ViewCompat.postInvalidateOnAnimation(this);
        return;
    L27:
        return;
    L17:
        if (this.N.isFinished() == true) goto L20;
        int r3 = r8.save();
        int r4 = getHeight();
        int r5 = (getWidth() - getPaddingLeft()) - getPaddingRight();
        r8.translate(getPaddingLeft(), this.r * r4);
        this.N.setSize(r5, r4);
        r1 = false | this.N.draw(r8);
        r8.restoreToCount(r3);
    L20:
        if (this.O.isFinished() == true) goto L22;
        int r6 = r8.save();
        int r7 = getHeight();
        int r9 = (getWidth() - getPaddingLeft()) - getPaddingRight();
        r8.rotate(180.0f);
        r8.translate((-r9) - getPaddingLeft(), (-(this.s + 1.0f)) * r7);
        this.O.setSize(r9, r7);
        r1 = r1 | this.O.draw(r8);
        r8.restoreToCount(r6);
    L4:
        e = move-exception;
        com.bytedance.article.common.monitor.stack.a.a(e, "VerticalViewPager");
        goto L6
    }

    public final void e(boolean r8) {
        if (this.V != 2) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L15;
        setScrollingCacheEnabled(false);
        if ((!this.k.isFinished()) == false) goto L15;
        this.k.abortAnimation();
        int r1 = getScrollX();
        int r4 = getScrollY();
        int r5 = this.k.getCurrX();
        int r6 = this.k.getCurrY();
        if (r1 != r5) goto L12;
        if (r4 == r6) goto L15;
    L12:
        scrollTo(r5, r6);
        if (r6 == r4) goto L15;
        o(r6);
    L15:
        this.w = false;
        int r2 = 0;
    L17:
        if (r2 >= this.c.size()) goto L22;
        e r7 = (e) ListProtector.get(this.c, r2);
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

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet r3) {
        return new LayoutParams(getContext(), r3);
    }

    public final e i(View r5) {
        int r0 = 0;
    L4:
        if (r0 >= this.c.size()) goto L9;
        e r1 = (e) ListProtector.get(this.c, r0);
        if (this.f.isViewFromObject(r5, r1.a) == true) goto L7;
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
        if (r0 >= this.c.size()) goto L9;
        e r1 = (e) ListProtector.get(this.c, r0);
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
        if (r4.getPointerId(r0) != this.H) goto L11;
        if (r0 != 0) goto L6;
        int r1 = 1;
    L7:
        this.E = r4.getY(r1);
        this.H = r4.getPointerId(r1);
        VelocityTracker r5 = this.I;
        if (r5 == null) goto L12;
        r5.clear();
        return;
    L12:
        return;
    L6:
        r1 = 0;
        goto L7
    }

    public final boolean o(int r8) {
        if (this.c.size() == 0) goto L5;
        e r0 = j();
        int r3 = getClientHeight();
        int r4 = this.n;
        int r5 = r3 + r4;
        float r6 = r3;
        float r7 = r4 / r6;
        if (r0 != null) goto L15;
        return false;
    L15:
        int r9 = r0.b;
        float r10 = ((r8 / r6) - r0.e) / (r0.d + r7);
        this.Q = false;
        m(r9, r10, (int) (r5 * r10));
        if (this.Q == false) goto L20;
        return true;
    L20:
        throw new IllegalStateException("onPageScrolled did not call superclass implementation");
    L5:
        if (this.P == false) goto L7;
        return false;
    L7:
        this.Q = false;
        m(0, 0.0f, 0);
        if (this.Q == false) goto L11;
        return false;
    L11:
        throw new IllegalStateException("onPageScrolled did not call superclass implementation");
    }

    @Override // android.view.View
    public final void onDraw(Canvas r19) {
        super.onDraw(r19);
        if (this.n > 0) goto L5;
        return;
    L5:
        if (this.o != null) goto L7;
        return;
    L7:
        if (this.c.size() > 0) goto L9;
        return;
    L9:
        if (this.f == null) goto L34;
        int r1 = getScrollY();
        int r2 = getHeight();
        float r4 = r2;
        float r3 = this.n / r4;
        int r6 = 0;
        e r5 = (e) ListProtector.get(this.c, 0);
        float r7 = r5.e;
        int r8 = this.c.size();
        int r9 = r5.b;
        int r10 = ((e) ListProtector.get(this.c, r8 - 1)).b;
    L11:
        if (r9 >= r10) goto L35;
    L12:
        int r11 = r5.b;
        if (r9 <= r11) goto L16;
        if (r6 >= r8) goto L16;
        r6 = r6 + 1;
        r5 = (e) ListProtector.get(this.c, r6);
    L16:
        if (r9 != r11) goto L18;
        float r12 = r5.e;
        float r13 = r5.d;
        float r14 = (r12 + r13) * r4;
        r7 = (r12 + r13) + r3;
    L19:
        int r15 = this.n;
        if ((r15 + r14) <= r1) goto L24;
        this.o.setBounds(this.p, (int) r14, this.q, (int) ((r15 + r14) + 0.5f));
        this.o.draw(r19);
    L24:
        if (r14 > (r1 + r2)) goto L36;
        r9 = r9 + 1;
        r3 = r3;
        goto L11
    L36:
        return;
    L18:
        float r16 = this.f.getPageWidth(r9);
        r14 = (r7 + r16) * r4;
        r7 = r7 + (r16 + r3);
        goto L19
    L35:
        return;
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r13) {
        if (this.W == false) goto L82;
        return false;
    L82:
        int r0 = r13.getAction() & 255;     // Catch: IllegalArgumentException -> L78
        if (r0 != 3) goto L8;
    L76:
        t();     // Catch: IllegalArgumentException -> L78
        return false;
    L8:
        if (r0 == 1) goto L76;
        if (r0 == 0) goto L18;
        if (this.y == false) goto L15;
        return true;
    L15:
        if (this.z == false) goto L18;
        return false;
    L18:
        if (r0 == 0) goto L63;
        if (r0 != 2) goto L21;
        int r1 = this.H;     // Catch: IllegalArgumentException -> L78
        if (r1 == (-1)) goto L73;
        int r2 = r13.findPointerIndex(r1);     // Catch: IllegalArgumentException -> L78
        float r3 = r13.getY(r2);     // Catch: IllegalArgumentException -> L78
        float r4 = r3 - this.E;     // Catch: IllegalArgumentException -> L78
        float r5 = Math.abs(r4);     // Catch: IllegalArgumentException -> L78
        float r6 = r13.getX(r2);     // Catch: IllegalArgumentException -> L78
        float r7 = Math.abs(r6 - this.F);     // Catch: IllegalArgumentException -> L78
        if (r4 == 0.0f) goto L43;
        float r9 = this.E;     // Catch: IllegalArgumentException -> L78
        if (r9 >= this.B) goto L33;
        if (r4 <= 0.0f) goto L33;
    L36:
        boolean r8 = true;
    L38:
        if (r8 == true) goto L43;
        if (d(this, false, (int) r4, (int) r6, (int) r3) == false) goto L43;
        this.D = r6;     // Catch: IllegalArgumentException -> L78
        this.E = r3;     // Catch: IllegalArgumentException -> L78
        this.z = true;     // Catch: IllegalArgumentException -> L78
        return false;
    L33:
        if (r9 > (getHeight() - this.B)) goto L35;
    L37:
        r8 = false;
        goto L38
    L35:
        if (r4 >= 0.0f) goto L37;
    L43:
        float r10 = this.C;     // Catch: IllegalArgumentException -> L78
        if (r5 <= r10) goto L56;
        if ((r5 * 1.0f) <= r7) goto L56;
        this.y = true;     // Catch: IllegalArgumentException -> L78
        ViewParent r11 = getParent();     // Catch: IllegalArgumentException -> L78
        if (r11 == null) goto L50;
        r11.requestDisallowInterceptTouchEvent(true);     // Catch: IllegalArgumentException -> L78
    L50:
        setScrollState(1);     // Catch: IllegalArgumentException -> L78
        if (r4 <= 0.0f) goto L53;
        float r12 = this.G + this.C;     // Catch: IllegalArgumentException -> L78
    L54:
        this.E = r12;     // Catch: IllegalArgumentException -> L78
        this.D = r6;     // Catch: IllegalArgumentException -> L78
        setScrollingCacheEnabled(true);     // Catch: IllegalArgumentException -> L78
    L59:
        if (this.y == false) goto L73;
        if (p(r3) == false) goto L73;
        ViewCompat.postInvalidateOnAnimation(this);     // Catch: IllegalArgumentException -> L78
        goto L73
    L53:
        r12 = this.G - this.C;     // Catch: IllegalArgumentException -> L78
    L56:
        if (r7 <= r10) goto L59;
        this.z = true;     // Catch: IllegalArgumentException -> L78
    L73:
        if (this.I != null) goto L75;
        this.I = VelocityTracker.obtain();     // Catch: IllegalArgumentException -> L78
    L75:
        this.I.addMovement(r13);     // Catch: IllegalArgumentException -> L78
    L81:
        return this.y;
    L21:
        if (r0 != 6) goto L73;
        n(r13);     // Catch: IllegalArgumentException -> L78
        goto L73
    L63:
        this.D = r13.getX();     // Catch: IllegalArgumentException -> L78
        this.F = r13.getX();     // Catch: IllegalArgumentException -> L78
        this.E = r13.getY();     // Catch: IllegalArgumentException -> L78
        this.G = r13.getY();     // Catch: IllegalArgumentException -> L78
        this.H = r13.getPointerId(0);     // Catch: IllegalArgumentException -> L78
        this.z = false;     // Catch: IllegalArgumentException -> L78
        this.l = true;     // Catch: IllegalArgumentException -> L78
        this.k.computeScrollOffset();     // Catch: IllegalArgumentException -> L78
        if (this.V == 2) goto L66;
    L71:
        e(false);     // Catch: IllegalArgumentException -> L78
        this.y = false;     // Catch: IllegalArgumentException -> L78
        goto L73
    L66:
        if (Math.abs(this.k.getFinalY() - this.k.getCurrY()) <= this.M) goto L71;
        this.k.abortAnimation();     // Catch: IllegalArgumentException -> L78
        this.w = false;     // Catch: IllegalArgumentException -> L78
        q();     // Catch: IllegalArgumentException -> L78
        this.y = true;     // Catch: IllegalArgumentException -> L78
        ViewParent r14 = getParent();     // Catch: IllegalArgumentException -> L78
        if (r14 == null) goto L70;
        r14.requestDisallowInterceptTouchEvent(true);     // Catch: IllegalArgumentException -> L78
    L70:
        setScrollState(1);     // Catch: IllegalArgumentException -> L78
    L78:
        e = move-exception;
        e.printStackTrace();
        goto L81
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable r4) {
        if ((r4 instanceof SavedState) == true) goto L6;
        super.onRestoreInstanceState(r4);
        return;
    L6:
        SavedState r5 = (SavedState) r4;
        super.onRestoreInstanceState(r5.getSuperState());
        PagerAdapter r0 = this.f;
        if (r0 == null) goto L9;
        r0.restoreState(r5.b, r5.c);
        v(r5.a, false, true, 0);
        return;
    L9:
        this.h = r5.a;
        this.i = r5.b;
        this.j = r5.c;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent r8) {
        boolean r1 = false;
        if (this.W == false) goto L77;
        return false;
    L77:
    L74:
        e = move-exception;
        e.printStackTrace();
    L76:
        return true;
    L69:
        e = move-exception;
        if (this.f.getCount() == this.b) goto L73;
        this.f.notifyDataSetChanged();
    L73:
        e.printStackTrace();
        goto L76
    L7:
        if (r8.getAction() == 0) goto L9;
    L11:
        PagerAdapter r2 = this.f;     // Catch: IllegalStateException -> L69 IllegalArgumentException -> L74
        if (r2 != null) goto L14;
    L68:
        return false;
    L14:
        if (r2.getCount() == 0) goto L68;
        if (this.I != null) goto L19;
        this.I = VelocityTracker.obtain();     // Catch: IllegalStateException -> L69 IllegalArgumentException -> L74
    L19:
        this.I.addMovement(r8);     // Catch: IllegalStateException -> L69 IllegalArgumentException -> L74
        int r3 = r8.getAction() & 255;     // Catch: IllegalStateException -> L69 IllegalArgumentException -> L74
        if (r3 == 0) goto L64;
        if (r3 == 1) goto L59;
        if (r3 == 2) goto L37;
        if (r3 == 3) goto L34;
        if (r3 != 5) goto L29;
        int r4 = r8.getActionIndex();     // Catch: IllegalStateException -> L69 IllegalArgumentException -> L74
        this.E = r8.getY(r4);     // Catch: IllegalStateException -> L69 IllegalArgumentException -> L74
        this.H = r8.getPointerId(r4);     // Catch: IllegalStateException -> L69 IllegalArgumentException -> L74
    L65:
        if (r1 == false) goto L76;
        ViewCompat.postInvalidateOnAnimation(this);     // Catch: IllegalStateException -> L69 IllegalArgumentException -> L74
    L29:
        if (r3 != 6) goto L65;
        n(r8);     // Catch: IllegalStateException -> L69 IllegalArgumentException -> L74
        this.E = r8.getY(r8.findPointerIndex(this.H));     // Catch: IllegalStateException -> L69 IllegalArgumentException -> L74
        goto L65
    L34:
        if (this.y == false) goto L65;
        u(this.g, true, 0, false);     // Catch: IllegalStateException -> L69 IllegalArgumentException -> L74
        r1 = t();     // Catch: IllegalStateException -> L69 IllegalArgumentException -> L74
        goto L65
    L37:
        if (this.y == true) goto L56;
        int r5 = r8.findPointerIndex(this.H);     // Catch: IllegalStateException -> L69 IllegalArgumentException -> L74
        if (r5 != (-1)) goto L41;
        r1 = t();     // Catch: IllegalStateException -> L69 IllegalArgumentException -> L74
        goto L65
    L41:
        float r6 = r8.getY(r5);     // Catch: IllegalStateException -> L69 IllegalArgumentException -> L74
        float r7 = Math.abs(r6 - this.E);     // Catch: IllegalStateException -> L69 IllegalArgumentException -> L74
        float r9 = r8.getX(r5);     // Catch: IllegalStateException -> L69 IllegalArgumentException -> L74
        float r10 = Math.abs(r9 - this.D);     // Catch: IllegalStateException -> L69 IllegalArgumentException -> L74
        if (r7 <= this.C) goto L56;
        if (r7 <= r10) goto L56;
        this.y = true;     // Catch: IllegalStateException -> L69 IllegalArgumentException -> L74
        ViewParent r11 = getParent();     // Catch: IllegalStateException -> L69 IllegalArgumentException -> L74
        if (r11 == null) goto L48;
        r11.requestDisallowInterceptTouchEvent(true);     // Catch: IllegalStateException -> L69 IllegalArgumentException -> L74
    L48:
        float r12 = this.G;     // Catch: IllegalStateException -> L69 IllegalArgumentException -> L74
        if ((r6 - r12) <= 0.0f) goto L51;
        float r13 = r12 + this.C;     // Catch: IllegalStateException -> L69 IllegalArgumentException -> L74
    L52:
        this.E = r13;     // Catch: IllegalStateException -> L69 IllegalArgumentException -> L74
        this.D = r9;     // Catch: IllegalStateException -> L69 IllegalArgumentException -> L74
        setScrollState(1);     // Catch: IllegalStateException -> L69 IllegalArgumentException -> L74
        setScrollingCacheEnabled(true);     // Catch: IllegalStateException -> L69 IllegalArgumentException -> L74
        ViewParent r14 = getParent();     // Catch: IllegalStateException -> L69 IllegalArgumentException -> L74
        if (r14 == null) goto L56;
        r14.requestDisallowInterceptTouchEvent(true);     // Catch: IllegalStateException -> L69 IllegalArgumentException -> L74
        goto L56
    L51:
        r13 = r12 - this.C;     // Catch: IllegalStateException -> L69 IllegalArgumentException -> L74
    L56:
        if (this.y == false) goto L65;
        r1 = false | p(r8.getY(r8.findPointerIndex(this.H)));     // Catch: IllegalStateException -> L69 IllegalArgumentException -> L74
        goto L65
    L59:
        if (this.y == false) goto L65;
        VelocityTracker r15 = this.I;     // Catch: IllegalStateException -> L69 IllegalArgumentException -> L74
        r15.computeCurrentVelocity(1000, this.K);     // Catch: IllegalStateException -> L69 IllegalArgumentException -> L74
        int r16 = (int) VelocityTrackerCompat.getYVelocity(r15, this.H);     // Catch: IllegalStateException -> L69 IllegalArgumentException -> L74
        this.w = true;     // Catch: IllegalStateException -> L69 IllegalArgumentException -> L74
        int r17 = getClientHeight();     // Catch: IllegalStateException -> L69 IllegalArgumentException -> L74
        int r18 = getScrollY();     // Catch: IllegalStateException -> L69 IllegalArgumentException -> L74
        e r19 = j();     // Catch: IllegalStateException -> L69 IllegalArgumentException -> L74
        if (r19 == null) goto L63;
        float r20 = r17;
        v(g(r19.b, ((r18 / r20) - r19.e) / (r19.d + (this.n / r20)), r16, (int) (r8.getY(r8.findPointerIndex(this.H)) - this.G)), true, true, r16);     // Catch: IllegalStateException -> L69 IllegalArgumentException -> L74
    L63:
        r1 = t();     // Catch: IllegalStateException -> L69 IllegalArgumentException -> L74
        goto L65
    L64:
        this.k.abortAnimation();     // Catch: IllegalStateException -> L69 IllegalArgumentException -> L74
        this.w = false;     // Catch: IllegalStateException -> L69 IllegalArgumentException -> L74
        q();     // Catch: IllegalStateException -> L69 IllegalArgumentException -> L74
        this.D = r8.getX();     // Catch: IllegalStateException -> L69 IllegalArgumentException -> L74
        this.F = r8.getX();     // Catch: IllegalStateException -> L69 IllegalArgumentException -> L74
        this.E = r8.getY();     // Catch: IllegalStateException -> L69 IllegalArgumentException -> L74
        this.G = r8.getY();     // Catch: IllegalStateException -> L69 IllegalArgumentException -> L74
        this.H = r8.getPointerId(0);     // Catch: IllegalStateException -> L69 IllegalArgumentException -> L74
        goto L65
    L9:
        if (r8.getEdgeFlags() == 0) goto L11;
        return false;
    }

    public final boolean p(float r10) {
        float r0 = this.E - r10;
        this.E = r10;
        float r11 = getScrollY() + r0;
        float r1 = getClientHeight();
        float r2 = this.r * r1;
        float r3 = this.s * r1;
        boolean r4 = false;
        if (this.c.size() > 0) goto L5;
        return false;
    L5:
        e r5 = (e) ListProtector.get(this.c, 0);
        ArrayList<e> r6 = this.c;
        boolean r7 = true;
        e r8 = (e) ListProtector.get(r6, r6.size() - 1);
        if (r5.b == 0) goto L8;
        r2 = r5.e * r1;
        boolean r9 = false;
    L10:
        if (r8.b == (this.f.getCount() - 1)) goto L13;
        r3 = r8.e * r1;
        r7 = false;
    L13:
        if (r11 >= r2) goto L18;
        if (r9 == false) goto L16;
        r4 = this.N.onPull(Math.abs(r2 - r11) / r1);
    L16:
        r11 = r2;
    L22:
        int r12 = (int) r11;
        this.D += r11 - r12;
        scrollTo(getScrollX(), r12);
        o(r12);
        return r4;
    L18:
        if (r11 <= r3) goto L22;
        if (r7 == false) goto L21;
        r4 = this.O.onPull(Math.abs(r11 - r3) / r1);
    L21:
        r11 = r3;
        goto L22
    L8:
        r9 = true;
        goto L10
    }

    public final void r(int r15) {
        int r0 = this.g;
        if (r0 == r15) goto L8;
        if (r0 >= r15) goto L6;
        int r1 = 130;
    L7:
        e r2 = k(r0);
        this.g = r15;
    L10:
        if (this.f != null) goto L13;
        return;
    L13:
        if (this.w == false) goto L16;
        return;
    L16:
        if (getWindowToken() != null) goto L18;
        return;
    L18:
        this.f.startUpdate(this);
        int r16 = this.x;
        int r3 = Math.max(0, this.g - r16);
        int r4 = this.f.getCount();
        int r17 = Math.min(r4 - 1, this.g + r16);
        if (r4 != this.b) goto L211;
        int r5 = 0;
    L22:
        if (r5 >= this.c.size()) goto L28;
        e r6 = (e) ListProtector.get(this.c, r5);
        int r7 = r6.b;
        int r8 = this.g;
        if (r7 >= r8) goto L25;
        r5 = r5 + 1;
        goto L22
    L25:
        if (r7 != r8) goto L28;
    L29:
        if (r6 != null) goto L32;
        if (r4 <= 0) goto L32;
        r6 = b(this.g, r5);
    L32:
        if (r6 == null) goto L164;
        int r9 = r5 - 1;
        if (r9 < 0) goto L36;
        e r10 = (e) ListProtector.get(this.c, r9);
    L37:
        int r11 = getClientHeight();
        if (r11 > 0) goto L40;
        float r12 = 0.0f;
    L41:
        int r13 = this.g - 1;
        float r14 = 0.0f;
    L42:
        if (r13 < 0) goto L66;
        if (r14 < r12) goto L55;
        if (r13 >= r3) goto L55;
        if (r10 == null) goto L66;
        if (r13 != r10.b) goto L65;
        if (r10.c == true) goto L65;
        ListProtector.remove(this.c, r9);
        this.f.destroyItem(this, r13, r10.a);
        r9 = r9 - 1;
        r5 = r5 - 1;
        if (r9 < 0) goto L64;
        r10 = (e) ListProtector.get(this.c, r9);
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
        r10 = (e) ListProtector.get(this.c, r9);
        goto L65
    L57:
        if (r13 != r10.b) goto L61;
        r14 = r14 + r10.d;
        r9 = r9 - 1;
        if (r9 < 0) goto L64;
        r10 = (e) ListProtector.get(this.c, r9);
    L66:
        float r18 = r6.d;
        int r19 = r5 + 1;
        if (r18 < 2.0f) goto L69;
    L100:
        int r110 = this.f.getCount();
        int r20 = getClientHeight();
        if (r20 <= 0) goto L103;
        float r21 = this.n / r20;
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
        if (r26 >= this.c.size()) goto L136;
        Object r27 = ListProtector.get(this.c, r26);
    L113:
        e r28 = (e) r27;
        if (r25 <= r28.b) goto L119;
        if (r26 >= (this.c.size() - 1)) goto L119;
        r26 = r26 + 1;
        r27 = ListProtector.get(this.c, r26);
    L119:
        if (r25 >= r28.b) goto L121;
        r24 = r24 + (this.f.getPageWidth(r25) + r21);
        r25 = r25 + 1;
        goto L119
    L121:
        r28.e = r24;
        r24 = r24 + (r28.d + r21);
        r25 = r25 + 1;
        goto L109
    L122:
        if (r22 <= r23) goto L136;
        int r29 = this.c.size() - 1;
        float r30 = r2.e;
    L124:
        r22 = r22 - 1;
        if (r22 < r6.b) goto L136;
        if (r29 < 0) goto L136;
        Object r31 = ListProtector.get(this.c, r29);
    L128:
        e r32 = (e) r31;
        if (r22 >= r32.b) goto L133;
        if (r29 <= 0) goto L133;
        r29 = r29 - 1;
        r31 = ListProtector.get(this.c, r29);
    L133:
        if (r22 <= r32.b) goto L135;
        r30 = r30 - (this.f.getPageWidth(r22) + r21);
        r22 = r22 - 1;
        goto L133
    L135:
        r30 = r30 - (r32.d + r21);
        r32.e = r30;
    L136:
        int r33 = this.c.size();
        float r34 = r6.e;
        int r35 = r6.b;
        int r36 = r35 - 1;
        if (r35 != 0) goto L139;
        float r37 = r34;
    L140:
        this.r = r37;
        int r111 = r110 - 1;
        if (r35 != r111) goto L143;
        float r38 = (r6.d + r34) - 1.0f;
    L144:
        this.s = r38;
        int r39 = r5 - 1;
    L145:
        if (r39 < 0) goto L154;
        e r40 = (e) ListProtector.get(this.c, r39);
    L147:
        int r112 = r40.b;
        if (r36 <= r112) goto L150;
        r34 = r34 - (this.f.getPageWidth(r36) + r21);
        r36 = r36 - 1;
        goto L147
    L150:
        r34 = r34 - (r40.d + r21);
        r40.e = r34;
        if (r112 != 0) goto L153;
        this.r = r34;
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
        e r43 = (e) ListProtector.get(this.c, r19);
    L158:
        int r44 = r43.b;
        if (r42 >= r44) goto L161;
        r41 = r41 + (this.f.getPageWidth(r42) + r21);
        r42 = r42 + 1;
        goto L158
    L161:
        if (r44 != r111) goto L163;
        this.s = (r43.d + r41) - 1.0f;
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
        if (r19 >= this.c.size()) goto L71;
        e r45 = (e) ListProtector.get(this.c, r19);
    L72:
        if (r11 > 0) goto L74;
        float r46 = 0.0f;
    L75:
        int r47 = this.g + 1;
        int r113 = r19;
    L76:
        if (r47 >= r4) goto L100;
        if (r18 < r46) goto L89;
        if (r47 <= r17) goto L89;
        if (r45 == null) goto L100;
        if (r47 != r45.b) goto L99;
        if (r45.c == true) goto L99;
        ListProtector.remove(this.c, r113);
        this.f.destroyItem(this, r47, r45.a);
        if (r113 >= this.c.size()) goto L98;
        r45 = (e) ListProtector.get(this.c, r113);
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
        if (r113 >= this.c.size()) goto L98;
        r45 = (e) ListProtector.get(this.c, r113);
        goto L99
    L91:
        if (r47 != r45.b) goto L95;
        r18 = r18 + r45.d;
        r113 = r113 + 1;
        if (r113 >= this.c.size()) goto L98;
        r45 = (e) ListProtector.get(this.c, r113);
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
        PagerAdapter r114 = this.f;
        int r49 = this.g;
        if (r6 == null) goto L167;
        Object r50 = r6.a;
    L168:
        r114.setPrimaryItem(this, r49, r50);
        this.f.finishUpdate(this);
        int r115 = getChildCount();
        int r51 = 0;
    L169:
        if (r51 >= r115) goto L179;
        View r52 = getChildAt(r51);
        LayoutParams r53 = (LayoutParams) r52.getLayoutParams();
        r53.e = r51;
        if (r53.a == true) goto L177;
        if (r53.c != 0.0f) goto L177;
        e r54 = i(r52);
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
        e r117 = i(r116);
    L191:
        if (r117 != null) goto L193;
    L194:
        int r118 = 0;
    L196:
        if (r118 >= getChildCount()) goto L265;
        View r57 = getChildAt(r118);
        e r58 = i(r57);
        if (r58 == null) goto L204;
        if (r58.b != this.g) goto L204;
        if (r57.requestFocus(r1) == false) goto L204;
        return;
    L204:
        r118 = r118 + 1;
        goto L196
    L265:
        return;
    L193:
        if (r117.b != this.g) goto L194;
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
        throw new IllegalStateException("The application's PagerAdapter changed the adapter's contents without calling PagerAdapter#notifyDataSetChanged! Expected adapter item count: " + this.b + ", found: " + r4 + " Pager id: " + r119 + " Pager class: " + getClass() + " Problematic adapter: " + this.f.getClass());
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

    @Override // android.view.ViewGroup, android.view.ViewManager
    public final void removeView(View r2) {
        if (this.u == false) goto L5;
        removeViewInLayout(r2);
        return;
    L5:
        super.removeView(r2);
    }

    public void setAdapter(PagerAdapter r8) {
        PagerAdapter r0 = this.f;
        if (r0 != null) goto L43;
    L22:
        this.f = r8;
        this.b = 0;
        if (r8 != null) goto L25;
        return;
    L25:
        if (this.m != null) goto L27;
        this.m = new h(this);
    L27:
        PagerAdapter r9 = this.f;
        h r1 = this.m;
        Field r4 = L0;     // Catch: IllegalAccessException -> L37
        if (r4 == null) goto L31;
        r4.set(r9, r1);     // Catch: IllegalAccessException -> L37
    L31:
        this.w = false;
        boolean r10 = this.P;
        this.P = true;
        this.b = this.f.getCount();
        if (this.h < 0) goto L34;
        this.f.restoreState(this.i, this.j);
        v(this.h, false, true, 0);
        this.h = -1;
        this.i = null;
        this.j = null;
        return;
    L34:
        if (r10 == true) goto L36;
        q();
        return;
    L36:
        requestLayout();
        return;
    L37:
        e = move-exception;
        throw new RuntimeException(e);
    L43:
        Field r5 = L0;     // Catch: IllegalAccessException -> L19
        if (r5 == null) goto L7;
        r5.set(r0, null);     // Catch: IllegalAccessException -> L19
    L7:
        this.f.startUpdate(this);
        int r2 = 0;
    L9:
        if (r2 >= this.c.size()) goto L11;
        e r6 = (e) ListProtector.get(this.c, r2);
        this.f.destroyItem(this, r6.b, r6.a);
        r2 = r2 + 1;
        goto L9
    L11:
        this.f.finishUpdate(this);
        this.c.clear();
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
        this.g = 0;
        scrollTo(0, 0);
    L19:
        e = move-exception;
        throw new RuntimeException(e);
    }

    public void setCanTouch(boolean r1) {
        this.a = r1;
    }

    public void setChildrenDrawingOrderEnabledCompat(boolean r7) {
        if (this.T == null) goto L13;
    L11:
        Method r0 = this.T;     // Catch: Exception -> L10
        if (r0 == null) goto L15;
        r0.invoke(this, new Object[]{Boolean.valueOf(r7)});     // Catch: Exception -> L10
        return;
    L15:
        return;
    L16:
        return;
    L13:
        this.T = ViewGroup.class.getDeclaredMethod("setChildrenDrawingOrderEnabled", new Class[]{Boolean.TYPE});     // Catch: NoSuchMethodException -> L9
        goto L11
    }

    public void setCurrentItem(int r3) {
        this.w = false;
        v(r3, !this.P, false, 0);
    }

    public void setCurrentItemWithDefaultVelocity(int r2) {
        this.w = false;
        v(r2, true, true, 1);
    }

    public void setDefaultItem(int r1) {
        this.g = r1;
    }

    public void setDisableScroll(boolean r1) {
        this.W = r1;
    }

    public void setOffscreenPageLimit(int r2) {
        if (r2 >= 1) goto L6;
        r2 = 1;
    L6:
        if (r2 == this.x) goto L9;
        this.x = r2;
        q();
        return;
    }

    public void setPageMargin(int r3) {
        int r0 = this.n;
        this.n = r3;
        int r1 = getHeight();
        s(r1, r1, r3, r0);
        requestLayout();
    }

    public void setPageMarginDrawable(Drawable r1) {
        this.o = r1;
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
        this.k = r1;
    }

    @Override // android.view.View
    public final boolean verifyDrawable(Drawable r2) {
        if (super.verifyDrawable(r2) == false) goto L5;
    L8:
        return true;
    L5:
        if (r2 == this.o) goto L8;
        return false;
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams r1) {
        return generateDefaultLayoutParams();
    }

    public void setPageMarginDrawable(int r2) {
        setPageMarginDrawable(getContext().getResources().getDrawable(r2));
    }

    public VerticalViewPager(Context r1, AttributeSet r2) {
        super(r1, r2);
        this.c = new ArrayList();
        this.d = new e();
        this.e = new Rect();
        this.h = -1;
        this.i = null;
        this.j = null;
        this.r = -3.4028235E38f;
        this.s = Float.MAX_VALUE;
        this.x = 1;
        this.H = -1;
        this.P = true;
        this.S = new ArrayList();
        this.U = new c(this);
        this.V = 0;
        this.W = false;
        l();
    }

    public final e b(int r3, int r4) {
        e r0 = new e();
        r0.b = r3;
        r0.a = this.f.instantiateItem(this, r3);
        r0.d = this.f.getPageWidth(r3);
        if (r4 >= 0) goto L5;
    L8:
        this.c.add(r0);
    L9:
        return r0;
    L5:
        if (r4 >= this.c.size()) goto L8;
        ListProtector.add(this.c, r4, r0);
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
        int r16 = getMeasuredHeight();
        this.B = Math.min(r16 / 10, this.A);
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
        this.t = View.MeasureSpec.makeMeasureSpec(r17, 1073741824);
        View.MeasureSpec.makeMeasureSpec(r18, 1073741824);
        this.u = true;
        q();
        this.u = false;
        int r110 = getChildCount();
    L50:
        if (r0 >= r110) goto L59;
        View r20 = getChildAt(r0);
        if (r20.getVisibility() == 8) goto L58;
        LayoutParams r21 = (LayoutParams) r20.getLayoutParams();
        if (r21 != null) goto L56;
    L57:
        r20.measure(this.t, View.MeasureSpec.makeMeasureSpec((int) (r18 * r21.c), 1073741824));
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
        if (r6.b != this.g) goto L16;
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
        if (r4.b != this.g) goto L14;
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
        if (this.u == false) goto L11;
        if (r1 == true) goto L10;
        r0.d = true;
        addViewInLayout(r4, r5, r6);
        return;
    L10:
        throw new IllegalStateException("Cannot add pager decor view during layout");
    L11:
        super.addView(r4, r5, r6);
    }

    public void m(int r11, float r12, int r13) {
        if (this.R <= 0) goto L25;
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
        List<ViewPager.OnPageChangeListener> r16 = this.S;
        if (r16 != null) goto L28;
    L33:
        this.Q = true;
        return;
    L28:
        if (((ArrayList) r16).isEmpty() == true) goto L33;
        Iterator r17 = ((ArrayList) this.S).iterator();
    L31:
        if (r17.hasNext() == false) goto L33;
        ((ViewPager.OnPageChangeListener) r17.next()).onPageScrolled(r11, r12, r13);
        goto L31
    }

    public final int g(int r2, float r3, int r4, int r5) {
        if (Math.abs(r5) <= this.L) goto L10;
        if (Math.abs(r4) <= this.J) goto L10;
        if (r4 > 0) goto L15;
        r2 = r2 + 1;
    L15:
        if (this.c.size() <= 0) goto L18;
        e r6 = (e) ListProtector.get(this.c, 0);
        ArrayList<e> r7 = this.c;
        return Math.max(r6.b, Math.min(r2, ((e) ListProtector.get(r7, r7.size() - 1)).b));
    L18:
        return r2;
    L10:
        if (r2 < this.g) goto L12;
        float r8 = 0.6f;
    L13:
        r2 = (int) ((r2 + r3) + r8);
        goto L15
    L12:
        r8 = 0.4f;
        goto L13
    }

    @Override // android.view.View
    public final void onSizeChanged(int r1, int r2, int r3, int r4) {
        super.onSizeChanged(r1, r2, r3, r4);
        if (r2 == r4) goto L6;
        int r5 = this.n;
        s(r2, r4, r5, r5);
        return;
    }

    public final void s(int r2, int r3, int r4, int r5) {
        if (r3 > 0) goto L4;
    L9:
        e r6 = k(this.g);
        if (r6 == null) goto L12;
        float r7 = Math.min(r6.e, this.s);
    L13:
        int r8 = (int) (r7 * ((r2 - getPaddingTop()) - getPaddingBottom()));
        if (r8 == getScrollY()) goto L19;
        e(false);
        scrollTo(getScrollX(), r8);
        return;
    L19:
        return;
    L12:
        r7 = 0.0f;
        goto L13
    L4:
        if (this.c.isEmpty() == true) goto L9;
        if (this.k.isFinished() == true) goto L8;
        this.k.setFinalY(getCurrentItem() * getClientHeight());
        return;
    L8:
        scrollTo(getScrollX(), (int) ((getScrollY() / (((r3 - getPaddingTop()) - getPaddingBottom()) + r5)) * (((r2 - getPaddingTop()) - getPaddingBottom()) + r4)));
    }

    public final void u(int r16, boolean r17, int r18, boolean r19) {
        e r2 = k(r16);
        if (r2 == null) goto L5;
        int r3 = (int) (getClientHeight() * Math.max(this.r, Math.min(r2.e, this.s)));
    L6:
        if (r17 == true) goto L8;
        if (r19 == false) goto L50;
        List<ViewPager.OnPageChangeListener> r4 = this.S;
        if (r4 == null) goto L50;
        if (((ArrayList) r4).isEmpty() == true) goto L50;
        Iterator r5 = ((ArrayList) this.S).iterator();
    L48:
        if (r5.hasNext() == false) goto L50;
        ((ViewPager.OnPageChangeListener) r5.next()).onPageSelected(r16);
    L50:
        e(false);
        scrollTo(0, r3);
        o(r3);
        return;
    L8:
        if (getChildCount() != 0) goto L10;
        setScrollingCacheEnabled(false);
    L32:
        if (r19 == false) goto L54;
        List<ViewPager.OnPageChangeListener> r6 = this.S;
        if (r6 != null) goto L36;
        return;
    L36:
        if (((ArrayList) r6).isEmpty() == true) goto L56;
        Iterator r7 = ((ArrayList) this.S).iterator();
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
        Scroller r8 = this.k;
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
        e(false);
        q();
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
        this.l = false;
        this.k.startScroll(r12, r11, r13, r14, r110);
        ViewCompat.postInvalidateOnAnimation(this);
        goto L32
    L30:
        r25 = (int) (((Math.abs(r13) / ((r21 * this.f.getPageWidth(this.g)) + this.n)) + 1.0f) * 100.0f);
        goto L31
    L18:
        if (this.l == false) goto L20;
        r10 = this.k.getCurrY();
    L21:
        this.k.abortAnimation();
        setScrollingCacheEnabled(false);
        goto L23
    L20:
        r10 = this.k.getStartY();
        goto L21
    L13:
        if (r8.isFinished() == true) goto L15;
        r9 = true;
        goto L16
    L5:
        r3 = 0;
        goto L6
    }

    public final void v(int r5, boolean r6, boolean r7, int r8) {
        PagerAdapter r0 = this.f;
        boolean r1 = false;
        if (r0 != null) goto L5;
    L46:
        setScrollingCacheEnabled(false);
        return;
    L5:
        if (r0.getCount() <= 0) goto L46;
        if (r7 == true) goto L15;
        if (this.g != r5) goto L15;
        if (this.c.size() == 0) goto L15;
        setScrollingCacheEnabled(false);
        return;
    L15:
        if (r5 >= 0) goto L18;
        r5 = 0;
    L20:
        int r2 = this.x;
        int r3 = this.g;
        if (r5 <= (r3 + r2)) goto L23;
    L24:
        int r4 = 0;
    L26:
        if (r4 >= this.c.size()) goto L29;
        ((e) ListProtector.get(this.c, r4)).c = true;
        r4 = r4 + 1;
    L29:
        if (this.g == r5) goto L32;
        r1 = true;
    L32:
        if (this.P == false) goto L44;
        this.g = r5;
        if (r1 == false) goto L43;
        List<ViewPager.OnPageChangeListener> r9 = this.S;
        if (r9 == null) goto L43;
        if (((ArrayList) r9).isEmpty() == true) goto L43;
        Iterator r10 = ((ArrayList) this.S).iterator();
    L41:
        if (r10.hasNext() == false) goto L43;
        ((ViewPager.OnPageChangeListener) r10.next()).onPageSelected(r5);
    L43:
        requestLayout();
        return;
    L44:
        r(r5);
        u(r5, r6, r8, r1);
        return;
    L23:
        if (r5 >= (r3 - r2)) goto L29;
    L18:
        if (r5 < this.f.getCount()) goto L20;
        r5 = this.f.getCount() - 1;
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
        int r6 = r13 + r3;
        if (r6 < r5.getTop()) goto L17;
        if (r6 >= r5.getBottom()) goto L17;
        int r7 = r12 + r2;
        if (r7 < r5.getLeft()) goto L17;
        if (r7 >= r5.getRight()) goto L17;
        if (d(r5, true, r11, r7 - r5.getLeft(), r6 - r5.getTop()) == false) goto L17;
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
        e r114 = i(r26);
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
        this.p = r4;
        this.q = r2 - r6;
        this.R = r11;
        if (this.P == false) goto L48;
        boolean r28 = false;
        u(this.g, false, 0, false);
    L49:
        this.P = r28;
        return;
    L48:
        r28 = false;
        goto L49
    }
}
