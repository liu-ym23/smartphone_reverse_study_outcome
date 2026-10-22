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
import com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public class DmtViewPager extends ViewGroup {
    public static final int[] V0 = null;
    public static final a b1 = null;
    public static final b g1 = null;
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
    public int P0;
    public int Q;
    public int R;
    public EdgeEffect S;
    public EdgeEffect T;
    public boolean U;
    public boolean V;
    public int W;
    public boolean a;
    public boolean b;
    public float c;
    public float d;
    public double e;
    public double f;
    public int g;
    public final ArrayList<e> h;
    public final e i;
    public final Rect j;
    public PagerAdapter k;
    public List<ViewPager.OnPageChangeListener> k0;
    public int l;
    public int m;
    public Parcelable n;
    public ClassLoader o;
    public Scroller p;
    public ViewPager.OnPageChangeListener p0;
    public boolean q;
    public g r;
    public int s;
    public Drawable t;
    public int u;
    public int v;
    public float w;
    public float x;
    public int y;
    public boolean z;

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
        public int f;

        public LayoutParams() {
            super(-1, -1);
            this.c = 0.0f;
        }

        public LayoutParams(Context r2, AttributeSet r3) {
            super(r2, r3);
            this.c = 0.0f;
            TypedArray r4 = r2.obtainStyledAttributes(r3, DmtViewPager.V0);
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
        public final /* synthetic */ DmtViewPager a;

        @Override // java.lang.Runnable
        public final void run() {
            this.a.setScrollState(0);     // Catch: Throwable -> L4
            this.a.v();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public c(DmtViewPager r1) {
            this.a = r1;
        }
    }

    public class d implements OnApplyWindowInsetsListener {
        public final Rect a;
        public final /* synthetic */ DmtViewPager b;

        public d(DmtViewPager r1) {
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
        public final /* synthetic */ DmtViewPager a;

        public f(DmtViewPager r1) {
            this.a = r1;
        }

        public final void onInitializeAccessibilityEvent(View r2, AccessibilityEvent r3) {
            super.onInitializeAccessibilityEvent(r2, r3);
            r3.setClassName(f.class.getName());
            PagerAdapter r4 = this.a.k;
            if (r4 == null) goto L7;
            boolean r0 = true;
            if (r4.getCount() <= 1) goto L7;
        L8:
            r3.setScrollable(r0);
            if (r3.getEventType() != 4096) goto L14;
            PagerAdapter r5 = this.a.k;
            if (r5 == null) goto L15;
            r3.setItemCount(r5.getCount());
            r3.setFromIndex(this.a.l);
            r3.setToIndex(this.a.l);
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
            r3.setClassName(f.class.getName());
            PagerAdapter r4 = this.a.k;
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
            DmtViewPager r5 = this.a;
            r5.setCurrentItem(r5.l - 1);
            return true;
        L14:
            return false;
        L16:
            if (this.a.canScrollHorizontally(1) == false) goto L19;
            DmtViewPager r6 = this.a;
            r6.setCurrentItem(r6.l + 1);
            return true;
        L19:
            return false;
        }
    }

    public class g extends DataSetObserver {
        public final /* synthetic */ DmtViewPager a;

        @Override // android.database.DataSetObserver
        public final void onChanged() {
            this.a.g();
        }

        @Override // android.database.DataSetObserver
        public final void onInvalidated() {
            this.a.g();
        }

        public g(DmtViewPager r1) {
            this.a = r1;
        }
    }

    static {
        V0 = new int[]{R.attr.layout_gravity};
        b1 = new a();
        g1 = new b();
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
        if (t(r2) == true) goto L12;
        this.p.abortAnimation();
        scrollTo(0, r3);
        goto L12
    }

    public void d(View r1) {
    }

    public int getCurrentDragLeftBoundPosition() {
        return 0;
    }

    public final void m() {
        setWillNotDraw(false);
        setDescendantFocusability(262144);
        setFocusable(true);
        Context r1 = getContext();
        this.p = new Scroller(r1, g1);
        ViewConfiguration r2 = ViewConfiguration.get(r1);
        Resources r3 = r1.getResources();
        float r4 = WindowDisplayMetricsOverride.apply(r3, r3.getDisplayMetrics()).density;
        this.H = r2.getScaledPagingTouchSlop();
        this.O = (int) (400.0f * r4);
        this.P = r2.getScaledMaximumFlingVelocity();
        this.S = new EdgeEffect(r1);
        this.T = new EdgeEffect(r1);
        this.Q = (int) (25.0f * r4);
        this.R = (int) (2.0f * r4);
        this.F = (int) (r4 * 16.0f);
        ViewCompat.setAccessibilityDelegate(this, new f(this));
        if (ViewCompat.getImportantForAccessibility(this) != 0) goto L5;
        ViewCompat.setImportantForAccessibility(this, 1);
    L5:
        ViewCompat.setOnApplyWindowInsetsListener(this, new d(this));
        if (r1.getResources() != null) goto L8;
        return;
    L8:
        if (r1.getResources().getConfiguration() == null) goto L12;
        this.P0 = r1.getResources().getConfiguration().screenWidthDp;
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
        VelocityTracker r1 = this.N;
        if (r1 == null) goto L5;
        r1.recycle();
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
        int r0 = this.k.getCount();
        this.g = r0;
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
        B(r2, false, true, 0);
        new Throwable();
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

    public final boolean s() {
        PagerAdapter r0 = this.k;
        if (r0 != null) goto L5;
        return false;
    L5:
        if (this.l >= (r0.getCount() - 1)) goto L10;
        A(this.l + 1, true);
        return true;
    L10:
        return false;
    }

    public final void v() {
        w(this.l);
    }

    private int getClientWidth() {
        return (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
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
        int r0 = getClientWidth();
        float r1 = 0.0f;
        if (r0 <= 0) goto L5;
        float r2 = getScrollX() / r0;
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

    public final void o() {
        PagerAdapter r0 = getAdapter();
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.getCount() != 3) goto L21;
        this.h.size();
        getScrollX();
        getX();
        getChildCount();
        int r1 = 0;
    L8:
        if (r1 >= this.h.size()) goto L22;
        ((e) ListProtector.get(this.h, r1)).a.getClass().toString();
        float r2 = ((e) ListProtector.get(this.h, r1)).e;
        if ((((e) ListProtector.get(this.h, r1)).a instanceof Fragment) == false) goto L15;
        View r3 = ((Fragment) ((e) ListProtector.get(this.h, r1)).a).getView();
        if (r3 == null) goto L15;
        LayoutParams r4 = (LayoutParams) r3.getLayoutParams();
        r3.getLeft();
        int r5 = r4.e;
    L15:
        r1 = r1 + 1;
        goto L8
    L22:
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.U = true;
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [android.os.Parcelable, com.bytedance.awemeopen.apps.framework.feed.follow.DmtViewPager$SavedState] */
    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        Parcelable r0 = super.onSaveInstanceState();
        if (AoEnv.j() == false) goto L5;
        return r0;
    L5:
        ?? r1 = new SavedState(r0);
        r1.a = getPositionForSaveInstanceState();
        PagerAdapter r2 = this.k;
        if (r2 == null) goto L8;
        r1.b = r2.saveState();
    L8:
        return r1;
    }

    public boolean e() {
        return this.B;
    }

    public PagerAdapter getAdapter() {
        return this.k;
    }

    public int getCurrentItem() {
        return this.l;
    }

    public int getOffscreenPageLimit() {
        return this.C;
    }

    public int getPageMargin() {
        return this.s;
    }

    public int getPositionForSaveInstanceState() {
        return this.l;
    }

    public DmtViewPager(Context r3) {
        super(r3);
        this.a = true;
        this.b = true;
        this.c = 0.5f;
        this.d = 0.5f;
        this.e = -1.0d;
        this.f = 1.0d;
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
        this.H0 = new c(this);
        this.L0 = 0;
        this.P0 = 0;
        m();
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

    public final boolean b(int r7) {
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
        int r8 = i(this.j, r6).left;
        int r9 = i(this.j, r0).left;
        if (r0 == null) goto L30;
        if (r8 < r9) goto L30;
        int r10 = this.l;
        if (r10 <= 0) goto L48;
        A(r10 - 1, true);
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
        int r12 = i(this.j, r6).left;
        int r13 = i(this.j, r0).left;
        if (r0 == null) goto L37;
        if (r12 > r13) goto L37;
        r11 = s();
    L37:
        r11 = r6.requestFocus();
    L38:
        if (r7 == 17) goto L45;
        if (r7 == 1) goto L45;
        if (r7 != 66) goto L43;
    L44:
        r2 = s();
        goto L50
    L43:
        if (r7 != 2) goto L50;
    L45:
        int r14 = this.l;
        if (r14 <= 0) goto L48;
        A(r14 - 1, true);
    L19:
        r0 = null;
        goto L20
    }

    @Override // android.view.View
    public boolean canScrollHorizontally(int r5) {
        if (this.k != null) goto L5;
        return false;
    L5:
        int r0 = getClientWidth();
        int r2 = getScrollX();
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
        boolean r7 = b(2);
    L30:
        if (r7 == true) goto L35;
        return false;
    L35:
        return true;
    L17:
        if (r6.hasModifiers(1) == false) goto L29;
        r7 = b(1);
        goto L30
    L20:
        if (r6.hasModifiers(2) == false) goto L22;
        r7 = s();
        goto L30
    L22:
        r7 = b(66);
        goto L30
    L24:
        if (r6.hasModifiers(2) == false) goto L28;
        int r8 = this.l;
        if (r8 <= 0) goto L29;
        A(r8 - 1, true);
        r7 = true;
        goto L30
    L28:
        r7 = b(17);
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
    public boolean dispatchTouchEvent(MotionEvent r3) {
        if (r3.getPointerCount() <= 1) goto L8;
        if (this.a == true) goto L8;
        r3.setAction(1);
    L8:
        if (this.a == true) goto L11;
        return true;
    L11:
        return super.dispatchTouchEvent(r3);
    }

    @Override // android.view.View
    public final void draw(Canvas r8) {
        super.draw(r8);
        int r0 = getOverScrollMode();
        boolean r1 = false;
        if (r0 == 0) goto L13;
        if (r0 != 1) goto L11;
        PagerAdapter r2 = this.k;
        if (r2 == null) goto L11;
        if (r2.getCount() > 1) goto L13;
    L11:
        this.S.finish();
        this.T.finish();
    L18:
        if (r1 == false) goto L21;
        ViewCompat.postInvalidateOnAnimation(this);
        return;
    L21:
        return;
    L13:
        if (this.S.isFinished() == true) goto L16;
        int r3 = r8.save();
        int r4 = (getHeight() - getPaddingTop()) - getPaddingBottom();
        int r5 = getWidth();
        r8.rotate(270.0f);
        r8.translate((-r4) + getPaddingTop(), this.w * r5);
        this.S.setSize(r4, r5);
        r1 = false | this.S.draw(r8);
        r8.restoreToCount(r3);
    L16:
        if (this.T.isFinished() == true) goto L18;
        int r6 = r8.save();
        int r7 = getWidth();
        int r9 = (getHeight() - getPaddingTop()) - getPaddingBottom();
        r8.rotate(90.0f);
        r8.translate(-getPaddingTop(), (-(this.x + 1.0f)) * r7);
        this.T.setSize(r9, r7);
        r1 = r1 | this.T.draw(r8);
        r8.restoreToCount(r6);
        goto L18
    }

    public final void f(boolean r8) {
        if (this.L0 != 2) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L20;
        setScrollingCacheEnabled(false);
        if ((!this.p.isFinished()) == false) goto L16;
        this.p.abortAnimation();
        int r1 = getScrollX();
        int r4 = getScrollY();
        int r5 = this.p.getCurrX();
        int r6 = this.p.getCurrY();
        if (r1 != r5) goto L12;
        if (r4 == r6) goto L20;
    L12:
        scrollTo(r5, r6);
        if (r5 == r1) goto L20;
        t(r5);
        goto L20
    L16:
        if (this.p.getCurrX() == getScrollX()) goto L20;
        if ((getScrollX() % getMeasuredWidth()) == 0) goto L20;
        scrollTo(this.p.getCurrX(), this.p.getCurrY());
    L20:
        this.B = false;
        int r2 = 0;
    L22:
        if (r2 >= this.h.size()) goto L27;
        e r7 = (e) ListProtector.get(this.h, r2);
        if (r7.c == false) goto L26;
        r7.c = false;
        r0 = true;
    L26:
        r2 = r2 + 1;
        goto L22
    L27:
        if (r0 == false) goto L35;
        if (r8 == false) goto L30;
        ViewCompat.postOnAnimation(this, this.H0);
        return;
    L30:
        this.H0.run();
        return;
    L35:
        return;
    L5:
        r0 = false;
        goto L6
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet r3) {
        return new LayoutParams(getContext(), r3);
    }

    public final void h(int r4) {
        ViewPager.OnPageChangeListener r0 = this.p0;
        if (r0 == null) goto L5;
        r0.onPageSelected(r4);
    L5:
        List<ViewPager.OnPageChangeListener> r1 = this.k0;
        if (r1 == null) goto L13;
        int r2 = ((ArrayList) r1).size();
        int r3 = 0;
    L8:
        if (r3 >= r2) goto L17;
        ViewPager.OnPageChangeListener r5 = (ViewPager.OnPageChangeListener) ListProtector.get(this.k0, r3);
        if (r5 == null) goto L12;
        r5.onPageSelected(r4);
    L12:
        r3 = r3 + 1;
        goto L8
    L17:
        return;
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
    public void onConfigurationChanged(Configuration r2) {
        super.onConfigurationChanged(r2);
        int r0 = this.P0;
        int r3 = r2.screenWidthDp;
        if (r0 == r3) goto L6;
        this.P0 = r3;
        q();
    L6:
        if (Build.BRAND.equalsIgnoreCase("VIVO") == true) goto L8;
        return;
    L8:
        if (Build.MODEL.equalsIgnoreCase("V2178A") == false) goto L12;
        z(this.l, false, 0, false);
        return;
    }

    @Override // android.view.View
    public final void onDraw(Canvas r18) {
        super.onDraw(r18);
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
        int r1 = getScrollX();
        int r2 = getWidth();
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
    L20:
        if ((this.s + r14) <= r1) goto L24;
        this.t.setBounds(Math.round(r14), this.u, Math.round(this.s + r14), this.v);
        this.t.draw(r18);
    L24:
        if (r14 > (r1 + r2)) goto L36;
        r9 = r9 + 1;
        r3 = r3;
        goto L11
    L36:
        return;
    L18:
        float r15 = this.k.getPageWidth(r9);
        r14 = (r7 + r15) * r4;
        r7 = r7 + (r15 + r3);
        goto L20
    L35:
        return;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent r17) {
        int r0 = r17.getAction() & 255;
        if (r0 != 3) goto L5;
    L82:
        y();
        return false;
    L5:
        if (r0 == 1) goto L82;
        if (r0 == 0) goto L15;
        if (this.D == false) goto L12;
        return true;
    L12:
        if (this.E == false) goto L15;
        return false;
    L15:
        if (r0 == 0) goto L68;
        if (r0 != 2) goto L18;
        int r1 = this.M;
        if (r1 == (-1)) goto L78;
        int r2 = r17.findPointerIndex(r1);
        float r10 = r17.getX(r2);
        float r3 = r10 - this.I;
        float r11 = Math.abs(r3);
        float r12 = r17.getY(r2);
        float r13 = Math.abs(r12 - this.L);
        if (this.e <= 0.0d) goto L29;
        float r4 = (float) this.f;
    L27:
        float r14 = r4;
        if (r3 == 0.0f) goto L48;
        float r5 = this.I;
        if (r5 >= this.G) goto L38;
        if (r3 <= 0.0f) goto L38;
    L41:
        boolean r6 = true;
    L43:
        if (r6 == true) goto L48;
        if (c(this, false, (int) r3, (int) r10, (int) r12) == false) goto L48;
        this.I = r10;
        this.J = r12;
        this.E = true;
        return false;
    L38:
        if (r5 > (getWidth() - this.G)) goto L40;
    L42:
        r6 = false;
        goto L43
    L40:
        if (r3 >= 0.0f) goto L42;
    L48:
        float r7 = this.H;
        if (r11 <= r7) goto L61;
        if ((r11 * r14) <= r13) goto L61;
        this.D = true;
        ViewParent r8 = getParent();
        if (r8 == null) goto L55;
        r8.requestDisallowInterceptTouchEvent(true);
    L55:
        setScrollState(1);
        float r9 = this.K;
        float r15 = this.H;
        if (r3 <= 0.0f) goto L58;
        float r16 = r9 + r15;
    L59:
        this.I = r16;
        this.J = r12;
        setScrollingCacheEnabled(true);
    L64:
        if (this.D == false) goto L78;
        if (u(r10) == false) goto L78;
        ViewCompat.postInvalidateOnAnimation(this);
        goto L78
    L58:
        r16 = r9 - r15;
    L61:
        if (r13 <= r7) goto L64;
        this.E = true;
        goto L64
    L29:
        if (r3 <= 0.0f) goto L31;
        r4 = this.c;
        goto L27
    L31:
        r4 = this.d;
    L78:
        if (this.N != null) goto L80;
        this.N = VelocityTracker.obtain();
    L80:
        this.N.addMovement(r17);
        return this.D;
    L18:
        if (r0 != 6) goto L78;
        r(r17);
        goto L78
    L68:
        float r18 = r17.getX();
        this.K = r18;
        this.I = r18;
        float r19 = r17.getY();
        this.L = r19;
        this.J = r19;
        this.M = r17.getPointerId(0);
        this.E = false;
        this.q = true;
        this.p.computeScrollOffset();
        if (this.L0 == 2) goto L71;
    L76:
        f(false);
        this.D = false;
        goto L78
    L71:
        if (Math.abs(this.p.getFinalX() - this.p.getCurrX()) <= this.R) goto L76;
        this.p.abortAnimation();
        this.B = false;
        v();
        this.D = true;
        ViewParent r20 = getParent();
        if (r20 == null) goto L75;
        r20.requestDisallowInterceptTouchEvent(true);
    L75:
        setScrollState(1);
        goto L78
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
        PagerAdapter r0 = this.k;
        if (r0 == null) goto L9;
        r0.restoreState(r5.b, r5.c);
        B(r5.a, false, true, 0);
        new Throwable();
        return;
    L9:
        this.m = r5.a;
        this.n = r5.b;
        this.o = r5.c;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent r13) {
        boolean r1 = false;
        if (r13.getAction() == 0) goto L5;
    L7:
        PagerAdapter r0 = this.k;
        if (r0 != null) goto L10;
    L84:
        return false;
    L10:
        if (r0.getCount() == 0) goto L84;
        if (this.N != null) goto L15;
        this.N = VelocityTracker.obtain();
    L15:
        this.N.addMovement(r13);
        int r2 = r13.getAction() & 255;
        if (r2 != 0) goto L18;
        this.p.abortAnimation();
        this.B = false;
        v();
        float r3 = r13.getX();
        this.K = r3;
        this.I = r3;
        float r4 = r13.getY();
        this.L = r4;
        this.J = r4;
        this.M = r13.getPointerId(0);
    L81:
        if (r1 == false) goto L83;
        ViewCompat.postInvalidateOnAnimation(this);
    L83:
        return true;
    L18:
        if (r2 == 1) goto L63;
        if (r2 == 2) goto L34;
        if (r2 == 3) goto L31;
        if (r2 != 5) goto L26;
        int r5 = r13.getActionIndex();
        this.I = r13.getX(r5);
        this.M = r13.getPointerId(r5);
        goto L81
    L26:
        if (r2 != 6) goto L81;
        r(r13);
        this.I = r13.getX(r13.findPointerIndex(this.M));
        goto L81
    L31:
        if (this.D == false) goto L81;
        z(this.l, true, 0, false);
        r1 = y();
        goto L81
    L34:
        if (this.D == true) goto L60;
        int r6 = r13.findPointerIndex(this.M);
        if (r6 != (-1)) goto L38;
        r1 = y();
        goto L81
    L38:
        float r7 = r13.getX(r6);
        float r8 = Math.abs(r7 - this.I);
        float r9 = r13.getY(r6);
        float r10 = Math.abs(r9 - this.J);
        if (this.e <= 0.0d) goto L42;
        float r11 = (float) this.f;
    L46:
        if (r8 <= this.H) goto L60;
        if ((r8 * r11) <= r10) goto L60;
        this.D = true;
        ViewParent r12 = getParent();
        if (r12 == null) goto L52;
        r12.requestDisallowInterceptTouchEvent(true);
    L52:
        float r14 = this.K;
        if ((r7 - r14) <= 0.0f) goto L55;
        float r15 = r14 + this.H;
    L56:
        this.I = r15;
        this.J = r9;
        setScrollState(1);
        setScrollingCacheEnabled(true);
        ViewParent r16 = getParent();
        if (r16 == null) goto L60;
        r16.requestDisallowInterceptTouchEvent(true);
        goto L60
    L55:
        r15 = r14 - this.H;
        goto L56
    L42:
        if ((r7 - this.I) <= 0.0f) goto L44;
        r11 = this.c;
        goto L46
    L44:
        r11 = this.d;
    L60:
        if (this.D == false) goto L81;
        r1 = false | u(r13.getX(r13.findPointerIndex(this.M)));
        goto L81
    L63:
        if (this.D == false) goto L81;
        VelocityTracker r17 = this.N;
        r17.computeCurrentVelocity(ECDraweeView.SQUARE, this.P);
        int r18 = (int) r17.getXVelocity(this.M);
        this.B = true;
        int r19 = getClientWidth();
        int r20 = getScrollX();
        e r21 = k();
        float r22 = r19;
        float r23 = this.s / r22;
        int r24 = r21.b;
        float r25 = ((r20 / r22) - r21.e) / (r21.d + r23);
        if (Math.abs((int) (r13.getX(r13.findPointerIndex(this.M)) - this.K)) <= this.Q) goto L72;
        if (Math.abs(r18) <= this.O) goto L72;
        if (r18 > 0) goto L77;
        r24 = r24 + 1;
    L77:
        if (this.h.size() <= 0) goto L79;
        e r110 = (e) ListProtector.get(this.h, 0);
        ArrayList<e> r26 = this.h;
        r24 = Math.max(r110.b, Math.min(r24, ((e) ListProtector.get(r26, r26.size() - 1)).b));
    L79:
        B(r24, true, true, r18);
        r1 = y();
    L72:
        if (r24 < this.l) goto L74;
        float r111 = 0.4f;
    L75:
        r24 = r24 + ((int) (r25 + r111));
        goto L77
    L74:
        r111 = 0.6f;
        goto L75
    L5:
        if (r13.getEdgeFlags() == 0) goto L7;
        return false;
    }

    public final void r(MotionEvent r4) {
        int r0 = r4.getActionIndex();
        if (r4.getPointerId(r0) != this.M) goto L11;
        if (r0 != 0) goto L6;
        int r1 = 1;
    L7:
        this.I = r4.getX(r1);
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

    @Override // android.view.ViewGroup, android.view.ViewManager
    public final void removeView(View r2) {
        if (this.z == false) goto L8;
        removeViewInLayout(r2);
        return;
    L8:
        super.removeView(r2);     // Catch: IllegalStateException -> L7
        return;
    }

    public void setAdapter(PagerAdapter r8) {
        PagerAdapter r0 = this.k;
        if (r0 == null) goto L16;
        C(r0, null);
        this.k.startUpdate(this);
        int r1 = 0;
    L6:
        if (r1 >= this.h.size()) goto L8;
        e r4 = (e) ListProtector.get(this.h, r1);
        this.k.destroyItem(this, r4.b, r4.a);
        r1 = r1 + 1;
        goto L6
    L8:
        this.k.finishUpdate(this);
        this.h.clear();
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
        this.l = 0;
        scrollTo(0, 0);
    L16:
        this.k = r8;
        this.g = 0;
        if (r8 != null) goto L19;
        return;
    L19:
        if (this.r != null) goto L21;
        this.r = new g(this);
    L21:
        C(this.k, this.r);
        this.B = false;
        boolean r9 = this.U;
        this.U = true;
        this.g = this.k.getCount();
        if (this.m < 0) goto L24;
        this.k.restoreState(this.n, this.o);
        B(this.m, false, true, 0);
        new Throwable();
        this.m = -1;
        this.n = null;
        this.o = null;
        return;
    L24:
        if (r9 == true) goto L26;
        v();
        return;
    L26:
        requestLayout();
    }

    public void setCanTouchBeforeScrollIdle(boolean r1) {
        this.b = r1;
    }

    public void setCurrentItem(int r3) {
        this.B = false;
        B(r3, !this.U, false, 0);
        new Throwable();
    }

    public void setCurrentItemWithoutScroll(int r1) {
        this.l = r1;
    }

    public void setDefaultGutterSize(int r1) {
        this.F = r1;
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
        v();
        return;
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener r1) {
        this.p0 = r1;
    }

    public void setOptPagerDegreeFraction(float r1) {
        this.c = r1;
        this.d = r1;
    }

    public void setPageMargin(int r3) {
        int r0 = this.s;
        this.s = r3;
        int r1 = getWidth();
        x(r1, r1, r3, r0);
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

    public void setScrollState(int r4) {
        if (this.L0 != r4) goto L5;
        return;
    L5:
        this.L0 = r4;
        if (r4 != 0) goto L8;
        this.a = true;
    L8:
        ViewPager.OnPageChangeListener r0 = this.p0;
        if (r0 == null) goto L11;
        r0.onPageScrollStateChanged(r4);
    L11:
        List<ViewPager.OnPageChangeListener> r1 = this.k0;
        if (r1 == null) goto L19;
        int r2 = ((ArrayList) r1).size();
        int r3 = 0;
    L14:
        if (r3 >= r2) goto L23;
        ViewPager.OnPageChangeListener r5 = (ViewPager.OnPageChangeListener) ListProtector.get(this.k0, r3);
        if (r5 == null) goto L18;
        r5.onPageScrollStateChanged(r4);
    L18:
        r3 = r3 + 1;
        goto L14
    L23:
        return;
    }

    public void setScroller(Scroller r1) {
        this.p = r1;
    }

    public final boolean t(int r8) {
        if (this.h.size() == 0) goto L5;
        e r0 = k();
        int r3 = getClientWidth();
        int r4 = this.s;
        int r5 = r3 + r4;
        float r6 = r3;
        int r7 = r0.b;
        float r9 = ((r8 / r6) - r0.e) / (r0.d + (r4 / r6));
        this.V = false;
        p(r7, r9, (int) (r5 * r9));
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

    public final boolean u(float r10) {
        float r0 = this.I - r10;
        this.I = r10;
        float r11 = getScrollX() + r0;
        int r1 = getClientWidth();
        float r2 = this.w;
        int r3 = getCurrentDragLeftBoundPosition();
        boolean r4 = false;
        if (r3 > 0) goto L5;
    L7:
        r3 = 0;
    L8:
        float r5 = r1;
        float r6 = r2 * r5;
        float r7 = this.x * r5;
        e r8 = (e) ListProtector.get(this.h, r3);
        ArrayList<e> r9 = this.h;
        e r12 = (e) ListProtector.get(r9, r9.size() - 1);
        if (r8.b == r3) goto L11;
        r6 = r8.e * r5;
        boolean r13 = false;
    L13:
        if (r12.b == (this.k.getCount() - 1)) goto L15;
        r7 = r12.e * r5;
        boolean r14 = false;
    L17:
        if (r11 >= r6) goto L22;
        if (r13 == false) goto L20;
        this.S.onPull(Math.abs(r6 - r11) / r5);
        r4 = true;
    L20:
        r11 = r6;
    L26:
        int r15 = (int) r11;
        this.I += r11 - r15;
        scrollTo(r15, getScrollY());
        t(r15);
        return r4;
    L22:
        if (r11 <= r7) goto L26;
        if (r14 == false) goto L25;
        this.T.onPull(Math.abs(r11 - r7) / r5);
        r4 = true;
    L25:
        r11 = r7;
        goto L26
    L15:
        r14 = true;
        goto L17
    L11:
        r13 = true;
        goto L13
    L5:
        if (r3 >= this.h.size()) goto L7;
        r2 = ((e) ListProtector.get(this.h, r3)).e;
        goto L8
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

    public final void w(int r18) {
        int r2 = this.l;
        if (r2 == r18) goto L5;
        e r3 = l(r2);
        this.l = r18;
    L7:
        if (this.k != null) goto L10;
        return;
    L10:
        if (e() == false) goto L13;
        return;
    L13:
        if (getWindowToken() != null) goto L15;
        return;
    L15:
        this.k.startUpdate(this);
        int r1 = this.C;
        int r4 = Math.max(0, this.l - r1);
        int r6 = this.k.getCount();
        int r5 = Math.min(r6 - 1, this.l + r1);
        if (r6 != this.g) goto L218;
        int r7 = 0;
    L19:
        if (r7 >= this.h.size()) goto L25;
        e r8 = (e) ListProtector.get(this.h, r7);
        int r9 = r8.b;
        int r10 = this.l;
        if (r9 >= r10) goto L22;
        r7 = r7 + 1;
        goto L19
    L22:
        if (r9 != r10) goto L25;
    L26:
        if (r8 != null) goto L29;
        if (r6 <= 0) goto L29;
        r8 = a(this.l, r7);
    L29:
        o();
        if (r8 == null) goto L170;
        int r11 = r7 - 1;
        if (r11 < 0) goto L34;
        e r12 = (e) ListProtector.get(this.h, r11);
    L35:
        int r13 = getClientWidth();
        if (r13 > 0) goto L38;
        float r14 = 0.0f;
    L39:
        int r15 = this.l - 1;
        float r16 = 0.0f;
    L40:
        if (r15 < 0) goto L65;
        if (r16 < r14) goto L53;
        if (r15 >= r4) goto L53;
        if (r12 == null) goto L65;
        if (r15 != r12.b) goto L64;
        if (r12.c == true) goto L64;
        ListProtector.remove(this.h, r11);
        this.k.destroyItem(this, r15, r12.a);
        r11 = r11 - 1;
        r7 = r7 - 1;
        if (r11 < 0) goto L62;
        e r17 = (e) ListProtector.get(this.h, r11);
    L63:
        r12 = r17;
    L62:
        r17 = null;
    L64:
        r15 = r15 - 1;
    L53:
        if (r12 != null) goto L55;
    L59:
        r16 = r16 + a(r15, r11 + 1).d;
        r7 = r7 + 1;
        if (r11 < 0) goto L62;
        r17 = (e) ListProtector.get(this.h, r11);
        goto L63
    L55:
        if (r15 != r12.b) goto L59;
        r16 = r16 + r12.d;
        r11 = r11 - 1;
        if (r11 < 0) goto L62;
        r17 = (e) ListProtector.get(this.h, r11);
    L65:
        float r19 = r8.d;
        int r20 = r7 + 1;
        if (r19 < 2.0f) goto L68;
    L99:
        o();
        int r21 = this.k.getCount();
        int r22 = getClientWidth();
        if (r22 <= 0) goto L102;
        float r23 = this.s / r22;
    L103:
        if (r3 == null) goto L135;
        int r24 = r3.b;
        int r25 = r8.b;
        if (r24 >= r25) goto L121;
        float r26 = (r3.e + r3.d) + r23;
        int r27 = r24 + 1;
        int r28 = 0;
    L108:
        if (r27 > r8.b) goto L135;
        if (r28 >= this.h.size()) goto L135;
        Object r110 = ListProtector.get(this.h, r28);
    L112:
        e r111 = (e) r110;
        if (r27 <= r111.b) goto L118;
        if (r28 >= (this.h.size() - 1)) goto L118;
        r28 = r28 + 1;
        r110 = ListProtector.get(this.h, r28);
    L118:
        if (r27 >= r111.b) goto L120;
        r26 = r26 + (this.k.getPageWidth(r27) + r23);
        r27 = r27 + 1;
        goto L118
    L120:
        r111.e = r26;
        r26 = r26 + (r111.d + r23);
        r27 = r27 + 1;
        goto L108
    L121:
        if (r24 <= r25) goto L135;
        int r29 = this.h.size() - 1;
        float r30 = r3.e;
    L123:
        r24 = r24 - 1;
        if (r24 < r8.b) goto L135;
        if (r29 < 0) goto L135;
        Object r112 = ListProtector.get(this.h, r29);
    L127:
        e r113 = (e) r112;
        if (r24 >= r113.b) goto L132;
        if (r29 <= 0) goto L132;
        r29 = r29 - 1;
        r112 = ListProtector.get(this.h, r29);
    L132:
        if (r24 <= r113.b) goto L134;
        r30 = r30 - (this.k.getPageWidth(r24) + r23);
        r24 = r24 - 1;
        goto L132
    L134:
        r30 = r30 - (r113.d + r23);
        r113.e = r30;
    L135:
        int r31 = this.h.size();
        float r32 = r8.e;
        int r33 = r8.b;
        int r114 = r33 - 1;
        if (r33 != 0) goto L138;
        float r115 = r32;
    L139:
        this.w = r115;
        int r34 = r21 - 1;
        if (r33 != r34) goto L142;
        float r35 = (r8.d + r32) - 1.0f;
    L143:
        this.x = r35;
        int r36 = r7 - 1;
    L144:
        if (r36 < 0) goto L153;
        e r37 = (e) ListProtector.get(this.h, r36);
    L146:
        int r116 = r37.b;
        if (r114 <= r116) goto L149;
        r32 = r32 - (this.k.getPageWidth(r114) + r23);
        r114 = r114 - 1;
        goto L146
    L149:
        r32 = r32 - (r37.d + r23);
        r37.e = r32;
        if (r116 != 0) goto L152;
        this.w = r32;
    L152:
        r36 = r36 - 1;
        r114 = r114 - 1;
        goto L144
    L153:
        float r38 = (r8.e + r8.d) + r23;
        int r39 = r8.b;
    L154:
        r39 = r39 + 1;
        if (r20 >= r31) goto L163;
        e r40 = (e) ListProtector.get(this.h, r20);
    L157:
        int r117 = r40.b;
        if (r39 >= r117) goto L160;
        r38 = r38 + (this.k.getPageWidth(r39) + r23);
        r39 = r39 + 1;
        goto L157
    L160:
        if (r117 != r34) goto L162;
        this.x = (r40.d + r38) - 1.0f;
    L162:
        r40.e = r38;
        r38 = r38 + (r40.d + r23);
        r20 = r20 + 1;
        goto L154
    L163:
        o();
        Object r41 = r8.a;
        if ((r41 instanceof Fragment) == false) goto L170;
        View r42 = ((Fragment) r41).getView();
        if (r42 == null) goto L170;
        if (r42.isLayoutRequested() == false) goto L170;
        requestLayout();
        goto L170
    L142:
        r35 = Float.MAX_VALUE;
        goto L143
    L138:
        r115 = -3.4028235E38f;
        goto L139
    L102:
        r23 = 0.0f;
        goto L103
    L68:
        if (r20 >= this.h.size()) goto L70;
        e r43 = (e) ListProtector.get(this.h, r20);
    L71:
        if (r13 > 0) goto L73;
        float r118 = 0.0f;
    L74:
        int r119 = this.l + 1;
        int r120 = r20;
    L75:
        if (r119 >= r6) goto L99;
        if (r19 < r118) goto L88;
        if (r119 <= r5) goto L88;
        if (r43 == null) goto L99;
        if (r119 != r43.b) goto L98;
        if (r43.c == true) goto L98;
        ListProtector.remove(this.h, r120);
        this.k.destroyItem(this, r119, r43.a);
        if (r120 >= this.h.size()) goto L97;
        r43 = (e) ListProtector.get(this.h, r120);
    L97:
        r43 = null;
    L98:
        r119 = r119 + 1;
    L88:
        if (r43 != null) goto L90;
    L94:
        e r44 = a(r119, r120);
        r120 = r120 + 1;
        r19 = r19 + r44.d;
        if (r120 >= this.h.size()) goto L97;
        r43 = (e) ListProtector.get(this.h, r120);
        goto L98
    L90:
        if (r119 != r43.b) goto L94;
        r19 = r19 + r43.d;
        r120 = r120 + 1;
        if (r120 >= this.h.size()) goto L97;
        r43 = (e) ListProtector.get(this.h, r120);
        goto L98
    L73:
        r118 = (getPaddingRight() / r13) + 2.0f;
        goto L74
    L70:
        r43 = null;
        goto L71
    L38:
        r14 = (2.0f - r8.d) + (getPaddingLeft() / r13);
        goto L39
    L34:
        r12 = null;
    L170:
        PagerAdapter r45 = this.k;
        int r46 = this.l;
        if (r8 == null) goto L173;
        Object r47 = r8.a;
    L174:
        r45.setPrimaryItem(this, r46, r47);
        this.k.finishUpdate(this);
        int r48 = getChildCount();
        int r49 = 0;
    L175:
        if (r49 >= r48) goto L186;
        View r50 = getChildAt(r49);
        LayoutParams r51 = (LayoutParams) r50.getLayoutParams();
        r51.f = r49;
        if (r51.a == true) goto L184;
        if (r51.c != 0.0f) goto L184;
        e r52 = j(r50);
        if (r52 == null) goto L184;
        r51.c = r52.d;
        r51.e = r52.b;
    L184:
        r49 = r49 + 1;
        goto L175
    L186:
        if (hasFocus() == false) goto L212;
        View r53 = findFocus();
        if (r53 == null) goto L197;
    L189:
        Object r54 = r53.getParent();
        if (r54 == this) goto L196;
        if (r54 == null) goto L197;
        if ((r54 instanceof View) == false) goto L197;
        r53 = (View) r54;
        goto L189
    L196:
        e r55 = j(r53);
    L198:
        if (r55 != null) goto L200;
    L201:
        int r56 = 0;
    L203:
        if (r56 >= getChildCount()) goto L270;
        View r57 = getChildAt(r56);
        e r58 = j(r57);
        if (r58 == null) goto L211;
        if (r58.b != this.l) goto L211;
        if (r57.requestFocus(2) == false) goto L211;
        return;
    L211:
        r56 = r56 + 1;
        goto L203
    L270:
        return;
    L200:
        if (r55.b != this.l) goto L201;
        return;
    L197:
        r55 = null;
        goto L198
    L212:
        return;
    L173:
        r47 = null;
    L25:
        r8 = null;
        goto L26
    L218:
        String r59 = getResources().getResourceName(getId());     // Catch: Resources.NotFoundException -> L215
    L217:
        throw new IllegalStateException("The application's PagerAdapter changed the adapter's contents without calling PagerAdapter#notifyDataSetChanged! Expected adapter item count: " + this.g + ", found: " + r6 + " Pager id: " + r59 + " Pager class: " + getClass() + " Problematic adapter: " + this.k.getClass());
    L215:
        r59 = Integer.toHexString(getId());
        goto L217
    L5:
        r3 = null;
        goto L7
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams r1) {
        return generateDefaultLayoutParams();
    }

    public void setPageMarginDrawable(int r2) {
        setPageMarginDrawable(ContextCompat.getDrawable(getContext(), r2));
    }

    public DmtViewPager(Context r3, AttributeSet r4) {
        super(r3, r4);
        this.a = true;
        this.b = true;
        this.c = 0.5f;
        this.d = 0.5f;
        this.e = -1.0d;
        this.f = 1.0d;
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
        this.H0 = new c(this);
        this.L0 = 0;
        this.P0 = 0;
        m();
    }

    public static void C(PagerAdapter r6, g r7) {
        Method r0 = PagerAdapter.class.getDeclaredMethod("setViewPagerObserver", new Class[]{DataSetObserver.class});     // Catch: Exception -> L4
        r0.setAccessible(true);     // Catch: Exception -> L4
        r0.invoke(r6, new Object[]{r7});     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
    }

    public void A(int r2, boolean r3) {
        this.B = false;
        B(r2, r3, false, 0);
        new Throwable();
    }

    public final e a(int r3, int r4) {
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
        return ((LayoutParams) ((View) ListProtector.get(null, r2)).getLayoutParams()).f;
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
        int r16 = getMeasuredWidth();
        this.G = Math.min(r16 / 10, this.F);
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
        this.y = View.MeasureSpec.makeMeasureSpec(r18, 1073741824);
        this.z = true;
        v();
        this.z = false;
        int r110 = getChildCount();
    L50:
        if (r0 >= r110) goto L59;
        View r20 = getChildAt(r0);
        if (r20.getVisibility() == 8) goto L58;
        LayoutParams r21 = (LayoutParams) r20.getLayoutParams();
        if (r21 != null) goto L56;
    L57:
        r20.measure(View.MeasureSpec.makeMeasureSpec((int) (r17 * r21.c), 1073741824), this.y);
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
        if (this.z == false) goto L15;
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

    public void p(int r13, float r14, int r15) {
        int r1 = 0;
        if (this.W <= 0) goto L25;
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
        ViewPager.OnPageChangeListener r2 = this.p0;
        if (r2 == null) goto L28;
        r2.onPageScrolled(r13, r14, r15);
    L28:
        List<ViewPager.OnPageChangeListener> r18 = this.k0;
        if (r18 == null) goto L36;
        int r19 = ((ArrayList) r18).size();
    L31:
        if (r1 >= r19) goto L36;
        ViewPager.OnPageChangeListener r20 = (ViewPager.OnPageChangeListener) ListProtector.get(this.k0, r1);
        if (r20 == null) goto L35;
        r20.onPageScrolled(r13, r14, r15);
    L35:
        r1 = r1 + 1;
    L36:
        this.V = true;
    }

    public final void B(int r5, boolean r6, boolean r7, int r8) {
        PagerAdapter r0 = this.k;
        boolean r1 = false;
        if (r0 != null) goto L5;
    L47:
        setScrollingCacheEnabled(false);
        return;
    L5:
        if (r0.getCount() <= 0) goto L47;
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
        if (this.l == r5) goto L31;
    L34:
        boolean r9 = true;
    L36:
        if (this.b == true) goto L38;
        if (r6 == false) goto L38;
    L39:
        this.a = r1;
        if (this.U == false) goto L45;
        this.l = r5;
        if (r9 == false) goto L44;
        h(r5);
    L44:
        requestLayout();
        return;
    L45:
        w(r5);
        z(r5, r6, r8, r9);
        return;
    L38:
        r1 = true;
        goto L39
    L31:
        if (n() == true) goto L34;
        r9 = false;
        goto L36
    L23:
        if (r5 >= (r3 - r2)) goto L29;
    L18:
        if (r5 < this.k.getCount()) goto L20;
        r5 = this.k.getCount() - 1;
        goto L20
    }

    @Override // android.view.View
    public final void onSizeChanged(int r1, int r2, int r3, int r4) {
        super.onSizeChanged(r1, r2, r3, r4);
        if (r1 == r3) goto L6;
        int r5 = this.s;
        x(r1, r3, r5, r5);
        return;
    }

    public final void x(int r2, int r3, int r4, int r5) {
        if (r3 > 0) goto L4;
    L9:
        e r6 = l(this.l);
        if (r6 == null) goto L12;
        float r7 = Math.min(r6.e, this.x);
    L13:
        int r8 = (int) (r7 * ((r2 - getPaddingLeft()) - getPaddingRight()));
        if (r8 == getScrollX()) goto L19;
        f(false);
        scrollTo(r8, getScrollY());
        return;
    L19:
        return;
    L12:
        r7 = 0.0f;
        goto L13
    L4:
        if (this.h.isEmpty() == true) goto L9;
        if (this.p.isFinished() == true) goto L8;
        this.p.setFinalX(getCurrentItem() * getClientWidth());
        return;
    L8:
        scrollTo((int) ((getScrollX() / (((r3 - getPaddingLeft()) - getPaddingRight()) + r5)) * (((r2 - getPaddingLeft()) - getPaddingRight()) + r4)), getScrollY());
    }

    public final void z(int r11, boolean r12, int r13, boolean r14) {
        e r0 = l(r11);
        if (r0 == null) goto L5;
        int r1 = (int) (getClientWidth() * Math.max(this.w, Math.min(r0.e, this.x)));
    L6:
        if (r12 == true) goto L8;
        if (r14 == false) goto L36;
        h(r11);
    L36:
        f(false);
        scrollTo(r1, 0);
        t(r1);
        return;
    L8:
        if (getChildCount() != 0) goto L10;
        setScrollingCacheEnabled(false);
    L32:
        if (r14 == false) goto L38;
        h(r11);
        return;
    L38:
        return;
    L10:
        Scroller r15 = this.p;
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
        f(false);
        v();
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
        this.q = false;
        this.p.startScroll(r4, r5, r6, r7, r9);
        ViewCompat.postInvalidateOnAnimation(this);
        goto L32
    L30:
        r111 = (int) (((Math.abs(r6) / ((r19 * this.k.getPageWidth(this.l)) + this.s)) + 1.0f) * 100.0f);
        goto L31
    L18:
        if (this.q == false) goto L20;
        r17 = this.p.getCurrX();
    L21:
        this.p.abortAnimation();
        setScrollingCacheEnabled(false);
        goto L23
    L20:
        r17 = this.p.getStartX();
        goto L21
    L13:
        if (r15.isFinished() == true) goto L15;
        r16 = true;
        goto L16
    L5:
        r1 = 0;
        goto L6
    }

    public final boolean c(View r13, boolean r14, int r15, int r16, int r17) {
        boolean r2 = true;
        if ((r13 instanceof ViewGroup) == false) goto L18;
        ViewGroup r1 = (ViewGroup) r13;
        int r3 = r13.getScrollX();
        int r4 = r13.getScrollY();
        int r5 = r1.getChildCount() - 1;
    L5:
        if (r5 < 0) goto L18;
        View r7 = r1.getChildAt(r5);
        int r6 = r16 + r3;
        if (r6 < r7.getLeft()) goto L17;
        if (r6 >= r7.getRight()) goto L17;
        int r8 = r17 + r4;
        if (r8 < r7.getTop()) goto L17;
        if (r8 >= r7.getBottom()) goto L17;
        if (c(r7, true, r15, r6 - r7.getLeft(), r8 - r7.getTop()) == false) goto L17;
        return true;
    L17:
        r5 = r5 - 1;
    L18:
        if (r14 == true) goto L20;
    L22:
        r2 = false;
    L23:
        d(r13);
        return r2;
    L20:
        if (r13.canScrollHorizontally(-r15) == false) goto L22;
        goto L22
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean r19, int r20, int r21, int r22, int r23) {
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
        e r114 = j(r26);
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
        this.u = r5;
        this.v = r3 - r7;
        this.W = r11;
        if (this.U == false) goto L49;
        boolean r28 = false;
        z(this.l, false, 0, false);
    L50:
        this.U = r28;
        return;
    L49:
        r28 = false;
        goto L50
    }
}
