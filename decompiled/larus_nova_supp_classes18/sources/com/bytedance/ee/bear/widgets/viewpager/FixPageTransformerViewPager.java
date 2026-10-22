package com.bytedance.ee.bear.widgets.viewpager;

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
import android.widget.EdgeEffect;
import android.widget.Scroller;
import androidx.core.content.ContextCompat;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.customview.view.AbsSavedState;
import com.bytedance.ee.bear.bitable.card.view.table.z;
import com.bytedance.ee.bear.lynx.api.CCMLynxCardView;
import com.bytedance.ee.bear.middleground.permission.permission.doc.DocUserPermission;
import com.bytedance.ee.util.ui.j;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class FixPageTransformerViewPager extends ViewGroup {
    public static final op5.c H0 = null;
    public static final op5.d L0 = null;
    public static final h P0 = null;
    public static final int[] p0 = null;
    public int A;
    public float B;
    public float C;
    public float D;
    public float E;
    public int F;
    public VelocityTracker G;
    public int H;
    public int I;
    public int J;
    public int K;
    public EdgeEffect L;
    public EdgeEffect M;
    public boolean N;
    public boolean O;
    public int P;
    public List<e> Q;
    public e R;
    public f S;
    public int T;
    public int U;
    public ArrayList<View> V;
    public final a W;
    public int a;
    public final ArrayList<c> b;
    public final c c;
    public final Rect d;
    public op5.a e;
    public int f;
    public int g;
    public Parcelable h;
    public Scroller i;
    public boolean j;
    public g k;
    public int k0;
    public int l;
    public Drawable m;
    public int n;
    public int o;
    public float p;
    public float q;
    public int r;
    public boolean s;
    public boolean t;
    public boolean u;
    public int v;
    public boolean w;
    public boolean x;
    public int y;
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
        public int f;

        public LayoutParams() {
            super(-1, -1);
            this.c = 0.0f;
        }

        public LayoutParams(Context r2, AttributeSet r3) {
            super(r2, r3);
            this.c = 0.0f;
            TypedArray r4 = r2.obtainStyledAttributes(r3, FixPageTransformerViewPager.p0);
            this.b = r4.getInteger(0, 48);
            r4.recycle();
        }
    }

    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = null;
        public int a;
        public Parcelable b;

        public class a implements Parcelable.ClassLoaderCreator<SavedState> {
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
        }

        public final void writeToParcel(Parcel r2, int r3) {
            super.writeToParcel(r2, r3);
            r2.writeInt(this.a);
            r2.writeParcelable(this.b, r3);
        }
    }

    public class a implements Runnable {
        public final /* synthetic */ FixPageTransformerViewPager a;

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

        public a(FixPageTransformerViewPager r1) {
            this.a = r1;
        }
    }

    public class b implements OnApplyWindowInsetsListener {
        public final Rect a;
        public final /* synthetic */ FixPageTransformerViewPager b;

        public b(FixPageTransformerViewPager r1) {
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

    public static class c {
        public Object a;
        public int b;
        public boolean c;
        public float d;
        public float e;

        public c() {
        }
    }

    public class d extends AccessibilityDelegateCompat {
        public final /* synthetic */ FixPageTransformerViewPager a;

        public d(FixPageTransformerViewPager r1) {
            this.a = r1;
        }

        public final void onInitializeAccessibilityEvent(View r2, AccessibilityEvent r3) {
            super.onInitializeAccessibilityEvent(r2, r3);
            r3.setClassName(FixPageTransformerViewPager.class.getName());
            op5.a r4 = this.a.e;
            if (r4 == null) goto L7;
            boolean r0 = true;
            if (r4.b() <= 1) goto L7;
        L8:
            r3.setScrollable(r0);
            if (r3.getEventType() != 4096) goto L14;
            op5.a r5 = this.a.e;
            if (r5 == null) goto L15;
            r3.setItemCount(r5.b());
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
            r3.setClassName(FixPageTransformerViewPager.class.getName());
            op5.a r4 = this.a.e;
            if (r4 != null) goto L5;
        L7:
            boolean r5 = false;
        L8:
            r3.setScrollable(r5);
            if (this.a.canScrollHorizontally(1) == false) goto L12;
            r3.addAction(DocUserPermission.USER_PERCEIVE);
        L12:
            if (this.a.canScrollHorizontally(-1) == false) goto L15;
            r3.addAction(8192);
            return;
        L15:
            return;
        L5:
            if (r4.b() <= 1) goto L7;
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
            FixPageTransformerViewPager r5 = this.a;
            r5.setCurrentItem(r5.f - 1);
            return true;
        L14:
            return false;
        L16:
            if (this.a.canScrollHorizontally(1) == false) goto L19;
            FixPageTransformerViewPager r6 = this.a;
            r6.setCurrentItem(r6.f + 1);
            return true;
        L19:
            return false;
        }
    }

    public interface e {
        void a(int r1, float r2);

        void onPageScrollStateChanged(int r1);

        void onPageSelected(int r1);
    }

    public interface f {
        void a(View r1);
    }

    public class g extends DataSetObserver {
        public final /* synthetic */ FixPageTransformerViewPager a;

        @Override // android.database.DataSetObserver
        public final void onChanged() {
            this.a.f();
        }

        @Override // android.database.DataSetObserver
        public final void onInvalidated() {
            this.a.f();
        }

        public g(FixPageTransformerViewPager r1) {
            this.a = r1;
        }
    }

    public static class h implements Comparator<View> {
        public h() {
        }

        @Override // java.util.Comparator
        public final int compare(View r3, View r4) {
            LayoutParams r5 = (LayoutParams) r3.getLayoutParams();
            LayoutParams r6 = (LayoutParams) r4.getLayoutParams();
            boolean r0 = r5.a;
            if (r0 == r6.a) goto L8;
            if (r0 == false) goto L6;
            return 1;
        L6:
            return -1;
        L8:
            return r5.e - r6.e;
        }
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [op5.c] */
    /* JADX WARN: Type inference failed for: r0v3, types: [op5.d] */
    static {
        p0 = new int[]{R.attr.layout_gravity};
        H0 = new op5.c();
        L0 = new op5.d();
        P0 = new h();
    }

    @Override // android.view.View
    public final void computeScroll() {
        this.j = true;
        if (this.i.isFinished() == false) goto L5;
    L14:
        e(true);
        return;
    L5:
        if (this.i.computeScrollOffset() == false) goto L14;
        int r0 = getScrollX();
        int r1 = getScrollY();
        int r2 = this.i.getCurrX();
        int r3 = this.i.getCurrY();
        if (r0 != r2) goto L9;
        if (r1 != r3) goto L9;
    L12:
        ViewCompat.postInvalidateOnAnimation(this);
        return;
    L9:
        scrollTo(r2, r3);
        if (p(r2) == true) goto L12;
        this.i.abortAnimation();
        scrollTo(0, r3);
        goto L12
    }

    public final void l() {
        setWillNotDraw(false);
        setDescendantFocusability(262144);
        setFocusable(true);
        Context r1 = getContext();
        this.i = new Scroller(r1, L0);
        ViewConfiguration r2 = ViewConfiguration.get(r1);
        Resources r3 = r1.getResources();
        float r4 = WindowDisplayMetricsOverride.apply(r3, r3.getDisplayMetrics()).density;
        this.A = r2.getScaledPagingTouchSlop();
        this.H = (int) (400.0f * r4);
        this.I = r2.getScaledMaximumFlingVelocity();
        this.L = new EdgeEffect(r1);
        this.M = new EdgeEffect(r1);
        this.J = (int) (25.0f * r4);
        this.K = (int) (2.0f * r4);
        this.y = (int) (r4 * 16.0f);
        ViewCompat.setAccessibilityDelegate(this, new d(this));
        if (ViewCompat.getImportantForAccessibility(this) != 0) goto L5;
        ViewCompat.setImportantForAccessibility(this, 1);
    L5:
        ViewCompat.setOnApplyWindowInsetsListener(this, new b(this));
    }

    public final boolean u() {
        this.F = -1;
        this.w = false;
        this.x = false;
        VelocityTracker r1 = this.G;
        if (r1 == null) goto L5;
        r1.recycle();
        this.G = null;
    L5:
        this.L.onRelease();
        this.M.onRelease();
        if (this.L.isFinished() == false) goto L8;
    L9:
        return true;
    L8:
        if (this.M.isFinished() == true) goto L9;
        return false;
    }

    public final void f() {
        int r0 = this.e.b();
        this.a = r0;
        if (this.b.size() < ((this.v * 2) + 1)) goto L5;
    L7:
        boolean r1 = false;
    L8:
        int r2 = this.f;
        int r5 = 0;
        boolean r6 = false;
    L10:
        if (r5 >= this.b.size()) goto L30;
        c r7 = (c) ListProtector.get(this.b, r5);
        int r8 = this.e.c(r7.a);
        tt5.a.b("FixPageTransformerViewPager", "getItemPosition: object = " + r7.a + ", newPos = " + r8);
        if (r8 == (-1)) goto L29;
        if (r8 != (-2)) goto L22;
        ListProtector.remove(this.b, r5);
        r5 = r5 - 1;
        if (r6 == true) goto L19;
        this.e.getClass();
        r6 = true;
    L19:
        this.e.a(this, r7.b, r7.a);
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
        this.e.getClass();
    L32:
        Collections.sort(this.b, H0);
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
        op5.a r0 = this.e;
        if (r0 != null) goto L5;
        return false;
    L5:
        if (this.f >= (r0.b() - 1)) goto L10;
        w(this.f + 1, true);
        return true;
    L10:
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        removeCallbacks(this.W);
        Scroller r0 = this.i;
        if (r0 != null) goto L5;
    L7:
        super.onDetachedFromWindow();
        return;
    L5:
        if (r0.isFinished() == true) goto L7;
        this.i.abortAnimation();
        goto L7
    }

    public final void r() {
        s(this.f);
    }

    public final void z() {
        if (this.U == 0) goto L14;
        ArrayList<View> r0 = this.V;
        if (r0 != null) goto L7;
        this.V = new ArrayList();
    L8:
        int r1 = getChildCount();
        int r2 = 0;
    L9:
        if (r2 >= r1) goto L11;
        View r3 = getChildAt(r2);
        this.V.add(r3);
        r2 = r2 + 1;
        goto L9
    L11:
        Collections.sort(this.V, P0);
        return;
    L7:
        r0.clear();
        goto L8
    }

    private int getClientWidth() {
        return (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
    }

    public final void A() {
        getScrollX();
        int r0 = getChildCount();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L9;
        View r2 = getChildAt(r1);
        if (((LayoutParams) r2.getLayoutParams()).a == true) goto L8;
        r2.getLeft();
        getClientWidth();
        this.S.a(r2);
    L8:
        r1 = r1 + 1;
        goto L3
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable r0 = this.m;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.isStateful() == false) goto L9;
        r0.setState(getDrawableState());
        return;
    }

    public final c j() {
        int r0 = getClientWidth();
        float r1 = 0.0f;
        if (r0 <= 0) goto L5;
        float r2 = getScrollX() / r0;
    L6:
        if (r0 <= 0) goto L8;
        float r3 = this.l / r0;
    L9:
        c r7 = null;
        float r4 = 0.0f;
        int r6 = -1;
        int r8 = 0;
        boolean r9 = true;
    L11:
        if (r8 >= this.b.size()) goto L30;
        c r10 = (c) ListProtector.get(this.b, r8);
        if (r9 == true) goto L17;
        int r11 = r6 + 1;
        if (r10.b == r11) goto L17;
        r10 = this.c;
        r10.e = (r1 + r4) + r3;
        r10.b = r11;
        this.e.getClass();
        r10.d = 1.0f;
        r8 = r8 - 1;
    L17:
        c r12 = r10;
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
        this.N = true;
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [android.os.Parcelable, com.bytedance.ee.bear.widgets.viewpager.FixPageTransformerViewPager$SavedState] */
    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        ?? r1 = new SavedState(super.onSaveInstanceState());
        r1.a = this.f;
        op5.a r0 = this.e;
        if (r0 == null) goto L5;
        r0.getClass();
        r1.b = null;
    L5:
        return r1;
    }

    public op5.a getAdapter() {
        return this.e;
    }

    public int getCurrentItem() {
        return this.f;
    }

    public int getOffscreenPageLimit() {
        return this.v;
    }

    public int getPageMargin() {
        return this.l;
    }

    public FixPageTransformerViewPager(Context r2) {
        super(r2);
        this.b = new ArrayList();
        this.c = new c();
        this.d = new Rect();
        this.g = -1;
        this.h = null;
        this.p = -3.4028235E38f;
        this.q = Float.MAX_VALUE;
        this.v = 1;
        this.F = -1;
        this.N = true;
        this.W = new a(this);
        this.k0 = 0;
        l();
    }

    private void setScrollingCacheEnabled(boolean r2) {
        if (this.t == r2) goto L6;
        this.t = r2;
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void addTouchables(ArrayList<View> r5) {
        int r0 = 0;
    L4:
        if (r0 >= getChildCount()) goto L13;
        View r1 = getChildAt(r0);
        if (r1.getVisibility() != 0) goto L12;
        c r2 = i(r1);
        if (r2 == null) goto L12;
        if (r2.b != this.f) goto L12;
        r1.addTouchables(r5);
    L12:
        r0 = r0 + 1;
        goto L4
    }

    public final void b(e r2) {
        if (this.Q != null) goto L5;
        this.Q = new ArrayList();
    L5:
        this.Q.add(r2);
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
        StringBuilder r5 = new StringBuilder();
        r5.append(r0.getClass().getSimpleName());
        ViewParent r6 = r0.getParent();
    L16:
        if ((r6 instanceof ViewGroup) == false) goto L18;
        r5.append(" => ");
        r5.append(r6.getClass().getSimpleName());
        r6 = r6.getParent();
        goto L16
    L18:
        tt5.a.d("FixPageTransformerViewPager", "arrowScroll tried to find focus based on non-child current focused view " + r5.toString());
        goto L19
    L12:
        r4 = false;
    L20:
        View r8 = FocusFinder.getInstance().findNextFocus(this, r0, r7);
        if (r8 == null) goto L38;
        if (r8 == r0) goto L38;
        if (r7 != 17) goto L32;
        int r9 = h(this.d, r8).left;
        int r10 = h(this.d, r0).left;
        if (r0 == null) goto L30;
        if (r9 < r10) goto L30;
        int r11 = this.f;
        if (r11 <= 0) goto L48;
        w(r11 - 1, true);
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
        boolean r12 = r8.requestFocus();
    L31:
        r2 = r12;
        goto L50
    L32:
        if (r7 != 66) goto L50;
        int r13 = h(this.d, r8).left;
        int r14 = h(this.d, r0).left;
        if (r0 == null) goto L37;
        if (r13 > r14) goto L37;
        r12 = o();
    L37:
        r12 = r8.requestFocus();
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
        int r15 = this.f;
        if (r15 <= 0) goto L48;
        w(r15 - 1, true);
    L19:
        r0 = null;
        goto L20
    }

    @Override // android.view.View
    public final boolean canScrollHorizontally(int r5) {
        if (this.e != null) goto L5;
        return false;
    L5:
        int r0 = getClientWidth();
        int r2 = getScrollX();
        if (r5 < 0) goto L8;
        if (r5 > 0) goto L13;
        return false;
    L13:
        if (r2 >= ((int) (r0 * this.q))) goto L18;
        return true;
    L18:
        return false;
    L8:
        if (r2 <= ((int) (r0 * this.p))) goto L16;
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
        c r4 = i(r3);
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
        op5.a r2 = this.e;
        if (r2 == null) goto L11;
        if (r2.b() > 1) goto L13;
    L11:
        this.L.finish();
        this.M.finish();
    L18:
        if (r1 == false) goto L21;
        ViewCompat.postInvalidateOnAnimation(this);
        return;
    L21:
        return;
    L13:
        if (this.L.isFinished() == true) goto L16;
        int r3 = r8.save();
        int r4 = (getHeight() - getPaddingTop()) - getPaddingBottom();
        int r5 = getWidth();
        r8.rotate(270.0f);
        r8.translate((-r4) + getPaddingTop(), this.p * r5);
        this.L.setSize(r4, r5);
        r1 = false | this.L.draw(r8);
        r8.restoreToCount(r3);
    L16:
        if (this.M.isFinished() == true) goto L18;
        int r6 = r8.save();
        int r7 = getWidth();
        int r9 = (getHeight() - getPaddingTop()) - getPaddingBottom();
        r8.rotate(90.0f);
        r8.translate(-getPaddingTop(), (-(this.q + 1.0f)) * r7);
        this.M.setSize(r9, r7);
        r1 = r1 | this.M.draw(r8);
        r8.restoreToCount(r6);
        goto L18
    }

    public final void e(boolean r8) {
        if (this.k0 != 2) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L15;
        setScrollingCacheEnabled(false);
        if ((!this.i.isFinished()) == false) goto L15;
        this.i.abortAnimation();
        int r1 = getScrollX();
        int r4 = getScrollY();
        int r5 = this.i.getCurrX();
        int r6 = this.i.getCurrY();
        if (r1 != r5) goto L12;
        if (r4 == r6) goto L15;
    L12:
        scrollTo(r5, r6);
        if (r5 == r1) goto L15;
        p(r5);
    L15:
        this.u = false;
        int r2 = 0;
    L17:
        if (r2 >= this.b.size()) goto L22;
        c r7 = (c) ListProtector.get(this.b, r2);
        if (r7.c == false) goto L21;
        r7.c = false;
        r0 = true;
    L21:
        r2 = r2 + 1;
        goto L17
    L22:
        if (r0 == false) goto L30;
        if (r8 == false) goto L25;
        ViewCompat.postOnAnimation(this, this.W);
        return;
    L25:
        this.W.run();
        return;
    L30:
        return;
    L5:
        r0 = false;
        goto L6
    }

    public final void g(int r4) {
        e r0 = this.R;
        if (r0 == null) goto L5;
        r0.onPageSelected(r4);
    L5:
        List<e> r1 = this.Q;
        if (r1 == null) goto L13;
        int r2 = ((ArrayList) r1).size();
        int r3 = 0;
    L8:
        if (r3 >= r2) goto L17;
        e r5 = (e) ListProtector.get(this.Q, r3);
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

    public final c i(View r5) {
        int r0 = 0;
    L4:
        if (r0 >= this.b.size()) goto L9;
        c r1 = (c) ListProtector.get(this.b, r0);
        if (this.e.e(r5, r1.a) == true) goto L7;
        r0 = r0 + 1;
        goto L4
    L7:
        return r1;
    L9:
        return null;
    }

    public final c k(int r4) {
        int r0 = 0;
    L4:
        if (r0 >= this.b.size()) goto L9;
        c r1 = (c) ListProtector.get(this.b, r0);
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
        if (r4.getPointerId(r0) != this.F) goto L11;
        if (r0 != 0) goto L6;
        int r1 = 1;
    L7:
        this.B = r4.getX(r1);
        this.F = r4.getPointerId(r1);
        VelocityTracker r5 = this.G;
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
        if (this.l > 0) goto L5;
        return;
    L5:
        if (this.m != null) goto L7;
        return;
    L7:
        if (this.b.size() > 0) goto L9;
        return;
    L9:
        if (this.e == null) goto L34;
        int r1 = getScrollX();
        int r2 = getWidth();
        float r4 = r2;
        float r3 = this.l / r4;
        int r6 = 0;
        c r5 = (c) ListProtector.get(this.b, 0);
        float r7 = r5.e;
        int r8 = this.b.size();
        int r9 = r5.b;
        int r10 = ((c) ListProtector.get(this.b, r8 - 1)).b;
    L11:
        if (r9 >= r10) goto L35;
    L12:
        int r11 = r5.b;
        if (r9 <= r11) goto L16;
        if (r6 >= r8) goto L16;
        r6 = r6 + 1;
        r5 = (c) ListProtector.get(this.b, r6);
    L16:
        if (r9 != r11) goto L18;
        float r12 = r5.e;
        float r13 = r5.d;
        float r14 = (r12 + r13) * r4;
        r7 = (r12 + r13) + r3;
    L20:
        if ((this.l + r14) <= r1) goto L24;
        this.m.setBounds(Math.round(r14), this.n, Math.round(this.l + r14), this.o);
        this.m.draw(r18);
    L24:
        if (r14 > (r1 + r2)) goto L36;
        r9 = r9 + 1;
        r3 = r3;
        goto L11
    L36:
        return;
    L18:
        this.e.getClass();
        r14 = (r7 + 1.0f) * r4;
        r7 = r7 + (1.0f + r3);
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
        if (this.w == false) goto L12;
        return true;
    L12:
        if (this.x == false) goto L15;
        return false;
    L15:
        if (r0 == 0) goto L60;
        if (r0 != 2) goto L18;
        int r1 = this.F;
        if (r1 == (-1)) goto L70;
        int r2 = r13.findPointerIndex(r1);
        float r3 = r13.getX(r2);
        float r4 = r3 - this.B;
        float r5 = Math.abs(r4);
        float r6 = r13.getY(r2);
        float r7 = Math.abs(r6 - this.E);
        if (r4 == 0.0f) goto L40;
        float r9 = this.B;
        if (r9 >= this.z) goto L30;
        if (r4 <= 0.0f) goto L30;
    L33:
        boolean r8 = true;
    L35:
        if (r8 == true) goto L40;
        if (d(this, false, (int) r4, (int) r3, (int) r6) == false) goto L40;
        this.B = r3;
        this.C = r6;
        this.x = true;
        return false;
    L30:
        if (r9 > (getWidth() - this.z)) goto L32;
    L34:
        r8 = false;
        goto L35
    L32:
        if (r4 >= 0.0f) goto L34;
    L40:
        float r10 = this.A;
        if (r5 <= r10) goto L53;
        if ((r5 * 0.5f) <= r7) goto L53;
        this.w = true;
        ViewParent r11 = getParent();
        if (r11 == null) goto L47;
        r11.requestDisallowInterceptTouchEvent(true);
    L47:
        setScrollState(1);
        if (r4 <= 0.0f) goto L50;
        float r12 = this.D + this.A;
    L51:
        this.B = r12;
        this.C = r6;
        setScrollingCacheEnabled(true);
    L56:
        if (this.w == false) goto L70;
        if (q(r3) == false) goto L70;
        ViewCompat.postInvalidateOnAnimation(this);
        goto L70
    L50:
        r12 = this.D - this.A;
    L53:
        if (r7 <= r10) goto L56;
        this.x = true;
    L70:
        if (this.G != null) goto L72;
        this.G = VelocityTracker.obtain();
    L72:
        this.G.addMovement(r13);
        return this.w;
    L18:
        if (r0 != 6) goto L70;
        n(r13);
        goto L70
    L60:
        float r14 = r13.getX();
        this.D = r14;
        this.B = r14;
        float r15 = r13.getY();
        this.E = r15;
        this.C = r15;
        this.F = r13.getPointerId(0);
        this.x = false;
        this.j = true;
        this.i.computeScrollOffset();
        if (this.k0 == 2) goto L63;
    L68:
        e(false);
        this.w = false;
        goto L70
    L63:
        if (Math.abs(this.i.getFinalX() - this.i.getCurrX()) <= this.K) goto L68;
        this.i.abortAnimation();
        this.u = false;
        r();
        this.w = true;
        ViewParent r16 = getParent();
        if (r16 == null) goto L67;
        r16.requestDisallowInterceptTouchEvent(true);
    L67:
        setScrollState(1);
        goto L70
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable r3) {
        if ((r3 instanceof SavedState) == true) goto L6;
        super.onRestoreInstanceState(r3);
        return;
    L6:
        SavedState r4 = (SavedState) r3;
        super.onRestoreInstanceState(r4.getSuperState());
        if (this.e == null) goto L9;
        x(r4.a, false, true, 0);
        return;
    L9:
        this.g = r4.a;
        this.h = r4.b;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent r10) {
        boolean r1 = false;
        if (r10.getAction() == 0) goto L5;
    L7:
        op5.a r0 = this.e;
        if (r0 != null) goto L10;
    L77:
        return false;
    L10:
        if (r0.b() == 0) goto L77;
        if (this.G != null) goto L15;
        this.G = VelocityTracker.obtain();
    L15:
        this.G.addMovement(r10);
        int r2 = r10.getAction() & 255;
        if (r2 != 0) goto L18;
        this.i.abortAnimation();
        this.u = false;
        r();
        float r3 = r10.getX();
        this.D = r3;
        this.B = r3;
        float r4 = r10.getY();
        this.E = r4;
        this.C = r4;
        this.F = r10.getPointerId(0);
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
        this.B = r10.getX(r5);
        this.F = r10.getPointerId(r5);
        goto L74
    L26:
        if (r2 != 6) goto L74;
        n(r10);
        this.B = r10.getX(r10.findPointerIndex(this.F));
        goto L74
    L31:
        if (this.w == false) goto L74;
        v(this.f, true, 0, false);
        r1 = u();
        goto L74
    L34:
        if (this.w == true) goto L53;
        int r6 = r10.findPointerIndex(this.F);
        if (r6 != (-1)) goto L38;
        r1 = u();
        goto L74
    L38:
        float r7 = r10.getX(r6);
        float r8 = Math.abs(r7 - this.B);
        float r9 = r10.getY(r6);
        float r11 = Math.abs(r9 - this.C);
        if (r8 <= this.A) goto L53;
        if (r8 <= r11) goto L53;
        this.w = true;
        ViewParent r12 = getParent();
        if (r12 == null) goto L45;
        r12.requestDisallowInterceptTouchEvent(true);
    L45:
        float r13 = this.D;
        if ((r7 - r13) <= 0.0f) goto L48;
        float r14 = r13 + this.A;
    L49:
        this.B = r14;
        this.C = r9;
        setScrollState(1);
        setScrollingCacheEnabled(true);
        ViewParent r15 = getParent();
        if (r15 == null) goto L53;
        r15.requestDisallowInterceptTouchEvent(true);
        goto L53
    L48:
        r14 = r13 - this.A;
    L53:
        if (this.w == false) goto L74;
        r1 = false | q(r10.getX(r10.findPointerIndex(this.F)));
        goto L74
    L56:
        if (this.w == false) goto L74;
        VelocityTracker r16 = this.G;
        r16.computeCurrentVelocity(CCMLynxCardView.ViewType.BANNER, this.I);
        int r17 = (int) r16.getXVelocity(this.F);
        this.u = true;
        int r18 = getClientWidth();
        int r19 = getScrollX();
        c r20 = j();
        float r21 = r18;
        float r22 = this.l / r21;
        int r23 = r20.b;
        float r24 = ((r19 / r21) - r20.e) / (r20.d + r22);
        if (Math.abs((int) (r10.getX(r10.findPointerIndex(this.F)) - this.D)) <= this.J) goto L65;
        if (Math.abs(r17) <= this.H) goto L65;
        if (r17 > 0) goto L70;
        r23 = r23 + 1;
    L70:
        if (this.b.size() <= 0) goto L72;
        c r110 = (c) ListProtector.get(this.b, 0);
        ArrayList<c> r25 = this.b;
        r23 = Math.max(r110.b, Math.min(r23, ((c) ListProtector.get(r25, r25.size() - 1)).b));
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
        c r0 = j();
        int r3 = getClientWidth();
        int r4 = this.l;
        int r5 = r3 + r4;
        float r6 = r3;
        int r7 = r0.b;
        float r9 = ((r8 / r6) - r0.e) / (r0.d + (r4 / r6));
        this.O = false;
        m(r7, r9, (int) (r5 * r9));
        if (this.O == false) goto L17;
        return true;
    L17:
        throw new IllegalStateException("onPageScrolled did not call superclass implementation");
    L5:
        if (this.N == false) goto L7;
        return false;
    L7:
        this.O = false;
        m(0, 0.0f, 0);
        if (this.O == false) goto L11;
        return false;
    L11:
        throw new IllegalStateException("onPageScrolled did not call superclass implementation");
    }

    public final boolean q(float r10) {
        float r0 = this.B - r10;
        this.B = r10;
        float r11 = getScrollX() + r0;
        float r1 = getClientWidth();
        float r2 = this.p * r1;
        float r3 = this.q * r1;
        boolean r4 = false;
        c r5 = (c) ListProtector.get(this.b, 0);
        ArrayList<c> r6 = this.b;
        c r7 = (c) ListProtector.get(r6, r6.size() - 1);
        if (r5.b == 0) goto L5;
        r2 = r5.e * r1;
        boolean r8 = false;
    L7:
        if (r7.b == (this.e.b() - 1)) goto L9;
        r3 = r7.e * r1;
        boolean r9 = false;
    L11:
        if (r11 >= r2) goto L16;
        if (r8 == false) goto L14;
        this.L.onPull(Math.abs(r2 - r11) / r1);
        r4 = true;
    L14:
        r11 = r2;
    L20:
        int r12 = (int) r11;
        this.B += r11 - r12;
        scrollTo(r12, getScrollY());
        p(r12);
        return r4;
    L16:
        if (r11 <= r3) goto L20;
        if (r9 == false) goto L19;
        this.M.onPull(Math.abs(r11 - r3) / r1);
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
        if (this.s == false) goto L5;
        removeViewInLayout(r2);
        return;
    L5:
        super.removeView(r2);
    }

    public final void s(int r18) {
        int r2 = this.f;
        if (r2 == r18) goto L5;
        c r3 = k(r2);
        this.f = r18;
    L7:
        if (this.e != null) goto L11;
        z();
        return;
    L11:
        if (this.u == false) goto L15;
        z();
        return;
    L15:
        if (getWindowToken() != null) goto L17;
        return;
    L17:
        this.e.getClass();
        int r1 = this.v;
        int r4 = Math.max(0, this.f - r1);
        int r6 = this.e.b();
        int r5 = Math.min(r6 - 1, this.f + r1);
        if (r6 != this.a) goto L210;
        int r7 = 0;
    L21:
        if (r7 >= this.b.size()) goto L27;
        c r8 = (c) ListProtector.get(this.b, r7);
        int r9 = r8.b;
        int r10 = this.f;
        if (r9 >= r10) goto L24;
        r7 = r7 + 1;
        goto L21
    L24:
        if (r9 != r10) goto L27;
    L28:
        if (r8 != null) goto L32;
        if (r6 <= 0) goto L32;
        r8 = a(this.f, r7);
    L32:
        if (r8 == null) goto L167;
        int r11 = r7 - 1;
        if (r11 < 0) goto L36;
        c r12 = (c) ListProtector.get(this.b, r11);
    L37:
        int r13 = getClientWidth();
        if (r13 > 0) goto L40;
        float r14 = 0.0f;
    L41:
        int r15 = this.f - 1;
        float r16 = 0.0f;
    L42:
        if (r15 < 0) goto L67;
        if (r16 < r14) goto L55;
        if (r15 >= r4) goto L55;
        if (r12 == null) goto L67;
        if (r15 != r12.b) goto L66;
        if (r12.c == true) goto L66;
        ListProtector.remove(this.b, r11);
        this.e.a(this, r15, r12.a);
        r11 = r11 - 1;
        r7 = r7 - 1;
        if (r11 < 0) goto L64;
        c r17 = (c) ListProtector.get(this.b, r11);
    L65:
        r12 = r17;
    L64:
        r17 = null;
    L66:
        r15 = r15 - 1;
    L55:
        if (r12 != null) goto L57;
    L61:
        r16 = r16 + a(r15, r11 + 1).d;
        r7 = r7 + 1;
        if (r11 < 0) goto L64;
        r17 = (c) ListProtector.get(this.b, r11);
        goto L65
    L57:
        if (r15 != r12.b) goto L61;
        r16 = r16 + r12.d;
        r11 = r11 - 1;
        if (r11 < 0) goto L64;
        r17 = (c) ListProtector.get(this.b, r11);
    L67:
        float r19 = r8.d;
        int r20 = r7 + 1;
        if (r19 < 2.0f) goto L70;
    L101:
        int r21 = this.e.b();
        int r22 = getClientWidth();
        if (r22 <= 0) goto L104;
        float r23 = this.l / r22;
    L106:
        if (r3 == null) goto L138;
        int r24 = r3.b;
        int r110 = r8.b;
        if (r24 >= r110) goto L124;
        float r111 = (r3.e + r3.d) + r23;
        int r25 = r24 + 1;
        int r26 = 0;
    L111:
        if (r25 > r8.b) goto L138;
        if (r26 >= this.b.size()) goto L138;
        Object r112 = ListProtector.get(this.b, r26);
    L115:
        c r113 = (c) r112;
        if (r25 <= r113.b) goto L121;
        if (r26 >= (this.b.size() - 1)) goto L121;
        r26 = r26 + 1;
        r112 = ListProtector.get(this.b, r26);
    L121:
        if (r25 >= r113.b) goto L123;
        this.e.getClass();
        r111 = r111 + (1.0f + r23);
        r25 = r25 + 1;
        goto L121
    L123:
        r113.e = r111;
        r111 = r111 + (r113.d + r23);
        r25 = r25 + 1;
        goto L111
    L124:
        if (r24 <= r110) goto L138;
        int r114 = this.b.size() - 1;
        float r27 = r3.e;
    L126:
        r24 = r24 - 1;
        if (r24 < r8.b) goto L138;
        if (r114 < 0) goto L138;
        Object r115 = ListProtector.get(this.b, r114);
    L130:
        c r116 = (c) r115;
        if (r24 >= r116.b) goto L135;
        if (r114 <= 0) goto L135;
        r114 = r114 - 1;
        r115 = ListProtector.get(this.b, r114);
    L135:
        if (r24 <= r116.b) goto L137;
        this.e.getClass();
        r27 = r27 - (1.0f + r23);
        r24 = r24 - 1;
        goto L135
    L137:
        r27 = r27 - (r116.d + r23);
        r116.e = r27;
    L138:
        int r28 = this.b.size();
        float r29 = r8.e;
        int r117 = r8.b;
        int r118 = r117 - 1;
        if (r117 != 0) goto L141;
        float r119 = r29;
    L142:
        this.p = r119;
        int r30 = r21 - 1;
        if (r117 != r30) goto L145;
        float r120 = (r8.d + r29) - 1.0f;
    L146:
        this.q = r120;
        int r31 = r7 - 1;
    L147:
        if (r31 < 0) goto L156;
        c r121 = (c) ListProtector.get(this.b, r31);
    L149:
        int r122 = r121.b;
        if (r118 <= r122) goto L152;
        r118 = r118 - 1;
        this.e.getClass();
        r29 = r29 - (1.0f + r23);
        goto L149
    L152:
        r29 = r29 - (r121.d + r23);
        r121.e = r29;
        if (r122 != 0) goto L155;
        this.p = r29;
    L155:
        r31 = r31 - 1;
        r118 = r118 - 1;
        goto L147
    L156:
        float r32 = (r8.e + r8.d) + r23;
        int r33 = r8.b;
    L157:
        r33 = r33 + 1;
        if (r20 >= r28) goto L166;
        c r123 = (c) ListProtector.get(this.b, r20);
    L160:
        int r124 = r123.b;
        if (r33 >= r124) goto L163;
        r33 = r33 + 1;
        this.e.getClass();
        r32 = r32 + (1.0f + r23);
        goto L160
    L163:
        if (r124 != r30) goto L165;
        this.q = (r123.d + r32) - 1.0f;
    L165:
        r123.e = r32;
        r32 = r32 + (r123.d + r23);
        r20 = r20 + 1;
        goto L157
    L166:
        this.e.g(this, this.f, r8.a);
        goto L167
    L145:
        r120 = Float.MAX_VALUE;
        goto L146
    L141:
        r119 = -3.4028235E38f;
        goto L142
    L104:
        r23 = 0.0f;
        goto L106
    L70:
        if (r20 >= this.b.size()) goto L72;
        c r34 = (c) ListProtector.get(this.b, r20);
    L73:
        if (r13 > 0) goto L75;
        float r125 = 0.0f;
    L76:
        int r126 = this.f + 1;
        int r127 = r20;
    L77:
        if (r126 >= r6) goto L101;
        if (r19 < r125) goto L91;
        if (r126 <= r5) goto L91;
        if (r34 == null) goto L101;
        if (r126 != r34.b) goto L100;
        if (r34.c == true) goto L100;
        ListProtector.remove(this.b, r127);
        this.e.a(this, r126, r34.a);
        if (r127 >= this.b.size()) goto L90;
        r34 = (c) ListProtector.get(this.b, r127);
    L90:
        r34 = null;
    L100:
        r126 = r126 + 1;
    L91:
        if (r34 != null) goto L93;
    L97:
        c r35 = a(r126, r127);
        r127 = r127 + 1;
        r19 = r19 + r35.d;
        if (r127 >= this.b.size()) goto L90;
        r34 = (c) ListProtector.get(this.b, r127);
        goto L100
    L93:
        if (r126 != r34.b) goto L97;
        r19 = r19 + r34.d;
        r127 = r127 + 1;
        if (r127 >= this.b.size()) goto L90;
        r34 = (c) ListProtector.get(this.b, r127);
        goto L100
    L75:
        r125 = (getPaddingRight() / r13) + 2.0f;
        goto L76
    L72:
        r34 = null;
        goto L73
    L40:
        r14 = (2.0f - r8.d) + (getPaddingLeft() / r13);
        goto L41
    L36:
        r12 = null;
    L167:
        this.e.getClass();
        int r36 = getChildCount();
        int r37 = 0;
    L168:
        if (r37 >= r36) goto L177;
        View r38 = getChildAt(r37);
        LayoutParams r39 = (LayoutParams) r38.getLayoutParams();
        r39.f = r37;
        if (r39.a == true) goto L176;
        if (r39.c != 0.0f) goto L176;
        c r40 = i(r38);
        if (r40 == null) goto L176;
        r39.c = r40.d;
        r39.e = r40.b;
    L176:
        r37 = r37 + 1;
        goto L168
    L177:
        z();
        if (hasFocus() == false) goto L204;
        View r41 = findFocus();
        if (r41 == null) goto L189;
    L181:
        Object r42 = r41.getParent();
        if (r42 == this) goto L188;
        if (r42 == null) goto L189;
        if ((r42 instanceof View) == false) goto L189;
        r41 = (View) r42;
        goto L181
    L188:
        c r43 = i(r41);
    L190:
        if (r43 != null) goto L192;
    L193:
        int r44 = 0;
    L195:
        if (r44 >= getChildCount()) goto L261;
        View r45 = getChildAt(r44);
        c r46 = i(r45);
        if (r46 == null) goto L203;
        if (r46.b != this.f) goto L203;
        if (r45.requestFocus(2) == false) goto L203;
        return;
    L203:
        r44 = r44 + 1;
        goto L195
    L261:
        return;
    L192:
        if (r43.b != this.f) goto L193;
        return;
    L189:
        r43 = null;
        goto L190
    L204:
        return;
    L27:
        r8 = null;
        goto L28
    L210:
        String r47 = getResources().getResourceName(getId());     // Catch: Resources.NotFoundException -> L207
    L209:
        throw new IllegalStateException("The application's PagerAdapter changed the adapter's contents without calling PagerAdapter#notifyDataSetChanged! Expected adapter item count: " + this.a + ", found: " + r6 + " Pager id: " + r47 + " Pager class: " + getClass() + " Problematic adapter: " + this.e.getClass());
    L207:
        r47 = Integer.toHexString(getId());
        goto L209
    L5:
        r3 = null;
        goto L7
    }

    public void setAdapter(op5.a r8) {
        op5.a r0 = this.e;
        if (r0 == null) goto L22;
        monitor-enter(r0);
        r0.b = null;     // Catch: Throwable -> L19
        monitor-exit(r0);     // Catch: Throwable -> L19
        this.e.getClass();
        int r1 = 0;
    L9:
        if (r1 >= this.b.size()) goto L11;
        c r4 = (c) ListProtector.get(this.b, r1);
        this.e.a(this, r4.b, r4.a);
        r1 = r1 + 1;
        goto L9
    L11:
        this.e.getClass();
        this.b.clear();
        int r2 = 0;
    L13:
        if (r2 >= getChildCount()) goto L18;
        if (((LayoutParams) getChildAt(r2).getLayoutParams()).a == true) goto L17;
        removeViewAt(r2);
        r2 = r2 - 1;
    L17:
        r2 = r2 + 1;
        goto L13
    L18:
        this.f = 0;
        scrollTo(0, 0);
    L19:
        th = move-exception;
        throw th;
    L22:
        this.e = r8;
        this.a = 0;
        if (r8 != null) goto L25;
        return;
    L25:
        if (this.k != null) goto L27;
        this.k = new g(this);
    L27:
        this.e.h(this.k);
        this.u = false;
        boolean r9 = this.N;
        this.N = true;
        this.a = this.e.b();
        if (this.g < 0) goto L30;
        this.e.getClass();
        x(this.g, false, true, 0);
        this.g = -1;
        this.h = null;
        return;
    L30:
        if (r9 == true) goto L32;
        r();
        return;
    L32:
        requestLayout();
    }

    public void setCurrentItem(int r3) {
        this.u = false;
        x(r3, !this.N, false, 0);
    }

    public void setMinimumVelocity(int r3) {
        Resources r0 = getContext().getResources();
        float r1 = WindowDisplayMetricsOverride.apply(r0, r0.getDisplayMetrics()).density;
        this.H = (int) (r3 * r1);
        this.J = (int) (r1 * 5.0f);
    }

    public void setOffscreenPageLimit(int r4) {
        if (r4 >= 1) goto L6;
        tt5.a.k("FixPageTransformerViewPager", "Requested offscreen page limit " + r4 + " too small; defaulting to 1");
        r4 = 1;
    L6:
        if (r4 == this.v) goto L9;
        this.v = r4;
        r();
        return;
    }

    public void setOnPageChangeListener(e r1) {
        this.R = r1;
    }

    public void setPageMargin(int r3) {
        int r0 = this.l;
        this.l = r3;
        int r1 = getWidth();
        t(r1, r1, r3, r0);
        requestLayout();
    }

    public void setPageMarginDrawable(Drawable r1) {
        this.m = r1;
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

    public void setScrollState(int r8) {
        if (this.k0 != r8) goto L5;
        return;
    L5:
        this.k0 = r8;
        int r1 = 0;
        if (this.S == null) goto L16;
        if (r8 == 0) goto L9;
        boolean r0 = true;
    L10:
        int r2 = getChildCount();
        int r3 = 0;
    L11:
        if (r3 >= r2) goto L16;
        if (r0 == false) goto L14;
        int r4 = this.T;
    L15:
        getChildAt(r3).setLayerType(r4, null);
        r3 = r3 + 1;
        goto L11
    L14:
        r4 = 0;
        goto L15
    L9:
        r0 = false;
    L16:
        e r5 = this.R;
        if (r5 == null) goto L19;
        r5.onPageScrollStateChanged(r8);
    L19:
        List<e> r6 = this.Q;
        if (r6 == null) goto L27;
        int r7 = ((ArrayList) r6).size();
    L22:
        if (r1 >= r7) goto L34;
        e r9 = (e) ListProtector.get(this.Q, r1);
        if (r9 == null) goto L26;
        r9.onPageScrollStateChanged(r8);
    L26:
        r1 = r1 + 1;
        goto L22
    L34:
        return;
    }

    @Override // android.view.View
    public final boolean verifyDrawable(Drawable r2) {
        if (super.verifyDrawable(r2) == false) goto L5;
    L8:
        return true;
    L5:
        if (r2 == this.m) goto L8;
        return false;
    }

    public final void y(z r4) {
        boolean r1 = false;
        if (this.S == null) goto L5;
        boolean r0 = true;
    L6:
        if (true == r0) goto L8;
        r1 = true;
    L8:
        this.S = r4;
        setChildrenDrawingOrderEnabled(true);
        this.U = 2;
        this.T = 2;
        if (r1 == false) goto L12;
        r();
        return;
    L12:
        return;
    L5:
        r0 = false;
        goto L6
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams r1) {
        return generateDefaultLayoutParams();
    }

    public void setPageMarginDrawable(int r2) {
        setPageMarginDrawable(ContextCompat.getDrawable(getContext(), r2));
    }

    public FixPageTransformerViewPager(Context r1, AttributeSet r2) {
        super(r1, r2);
        this.b = new ArrayList();
        this.c = new c();
        this.d = new Rect();
        this.g = -1;
        this.h = null;
        this.p = -3.4028235E38f;
        this.q = Float.MAX_VALUE;
        this.v = 1;
        this.F = -1;
        this.N = true;
        this.W = new a(this);
        this.k0 = 0;
        l();
    }

    public final c a(int r3, int r4) {
        c r0 = new c();
        r0.b = r3;
        r0.a = this.e.d(this, r3);
        this.e.getClass();
        r0.d = 1.0f;
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
    public final int getChildDrawingOrder(int r3, int r4) {
        if (this.U != 2) goto L6;
        r4 = (r3 - 1) - r4;
    L6:
        return ((LayoutParams) ((View) ListProtector.get(this.V, r4)).getLayoutParams()).f;
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
        this.z = Math.min(r16 / 10, this.y);
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
        this.r = View.MeasureSpec.makeMeasureSpec(r18, 1073741824);
        this.s = true;
        r();
        this.s = false;
        int r110 = getChildCount();
    L50:
        if (r0 >= r110) goto L59;
        View r20 = getChildAt(r0);
        if (r20.getVisibility() == 8) goto L58;
        LayoutParams r21 = (LayoutParams) r20.getLayoutParams();
        if (r21 != null) goto L56;
    L57:
        r20.measure(View.MeasureSpec.makeMeasureSpec((int) (r17 * r21.c), 1073741824), this.r);
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
        c r6 = i(r5);
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
        this.u = false;
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
        c r4 = i(r3);
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
        if (this.s == false) goto L15;
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

    public final void m(int r12, float r13, int r14) {
        int r0 = 0;
        if (this.P <= 0) goto L25;
        int r15 = getScrollX();
        int r2 = getPaddingLeft();
        int r3 = getPaddingRight();
        int r4 = getWidth();
        int r5 = getChildCount();
        int r6 = 0;
    L5:
        if (r6 >= r5) goto L25;
        View r7 = getChildAt(r6);
        LayoutParams r8 = (LayoutParams) r7.getLayoutParams();
        if (r8.a == false) goto L24;
        int r9 = r8.b & 7;
        if (r9 != 1) goto L12;
        int r10 = Math.max((r4 - r7.getMeasuredWidth()) / 2, r2);
    L19:
        int r11 = r10;
        int r16 = r2;
        r2 = r11;
    L20:
        int r17 = (r2 + r15) - r7.getLeft();
        if (r17 == 0) goto L23;
        r7.offsetLeftAndRight(r17);
    L23:
        r2 = r16;
        goto L24
    L12:
        if (r9 != 3) goto L14;
        r16 = r7.getWidth() + r2;
        goto L20
    L14:
        if (r9 == 5) goto L16;
        r16 = r2;
        goto L20
    L16:
        r10 = (r4 - r3) - r7.getMeasuredWidth();
        r3 = r3 + r7.getMeasuredWidth();
    L24:
        r6 = r6 + 1;
    L25:
        e r18 = this.R;
        if (r18 == null) goto L28;
        r18.a(r12, r13);
    L28:
        List<e> r19 = this.Q;
        if (r19 == null) goto L37;
        int r110 = ((ArrayList) r19).size();
    L31:
        if (r0 >= r110) goto L37;
        e r20 = (e) ListProtector.get(this.Q, r0);
        if (r20 == null) goto L35;
        r20.a(r12, r13);
    L35:
        r0 = r0 + 1;
    L37:
        if (this.S == null) goto L39;
        j.c(new op5.b(this));
    L39:
        this.O = true;
    }

    @Override // android.view.View
    public final void onSizeChanged(int r1, int r2, int r3, int r4) {
        super.onSizeChanged(r1, r2, r3, r4);
        if (r1 == r3) goto L6;
        int r5 = this.l;
        t(r1, r3, r5, r5);
        return;
    }

    public final void t(int r2, int r3, int r4, int r5) {
        if (r3 > 0) goto L4;
    L9:
        c r6 = k(this.f);
        if (r6 == null) goto L12;
        float r7 = Math.min(r6.e, this.q);
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
        if (this.i.isFinished() == true) goto L8;
        this.i.setFinalX(getCurrentItem() * getClientWidth());
        return;
    L8:
        scrollTo((int) ((getScrollX() / (((r3 - getPaddingLeft()) - getPaddingRight()) + r5)) * (((r2 - getPaddingLeft()) - getPaddingRight()) + r4)), getScrollY());
    }

    public final void v(int r11, boolean r12, int r13, boolean r14) {
        c r0 = k(r11);
        if (r0 == null) goto L5;
        int r1 = (int) (getClientWidth() * Math.max(this.p, Math.min(r0.e, this.q)));
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
        Scroller r15 = this.i;
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
        this.j = false;
        this.i.startScroll(r4, r5, r6, r7, r9);
        ViewCompat.postInvalidateOnAnimation(this);
        goto L32
    L30:
        this.e.getClass();
        r111 = (int) (((Math.abs(r6) / ((r19 * 1.0f) + this.l)) + 1.0f) * 100.0f);
        goto L31
    L18:
        if (this.j == false) goto L20;
        r17 = this.i.getCurrX();
    L21:
        this.i.abortAnimation();
        setScrollingCacheEnabled(false);
        goto L23
    L20:
        r17 = this.i.getStartX();
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
        op5.a r0 = this.e;
        boolean r1 = false;
        if (r0 != null) goto L5;
    L39:
        setScrollingCacheEnabled(false);
        return;
    L5:
        if (r0.b() <= 0) goto L39;
        if (r7 == true) goto L15;
        if (this.f != r5) goto L15;
        if (this.b.size() == 0) goto L15;
        setScrollingCacheEnabled(false);
        return;
    L15:
        if (r5 >= 0) goto L18;
        r5 = 0;
    L20:
        int r2 = this.v;
        int r3 = this.f;
        if (r5 <= (r3 + r2)) goto L23;
    L24:
        int r4 = 0;
    L26:
        if (r4 >= this.b.size()) goto L29;
        ((c) ListProtector.get(this.b, r4)).c = true;
        r4 = r4 + 1;
    L29:
        if (this.f == r5) goto L32;
        r1 = true;
    L32:
        if (this.N == false) goto L37;
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
        if (r5 < this.e.b()) goto L20;
        r5 = this.e.b() - 1;
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
        c r114 = i(r26);
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
        this.n = r5;
        this.o = r3 - r7;
        this.P = r11;
        if (this.N == false) goto L49;
        boolean r28 = false;
        v(this.f, false, 0, false);
    L50:
        this.N = r28;
        return;
    L49:
        r28 = false;
        goto L50
    }
}
