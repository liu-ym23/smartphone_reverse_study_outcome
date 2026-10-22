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
import com.alipay.sdk.m.u.i;
import com.bytedance.ee.bear.bitable.card.view.table.z;
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

/* JADX INFO: loaded from: classes18.dex */
public class FixPageTransformerViewPager extends ViewGroup {
    public static final op5.c H0 = null;
    public static final op5.d L0 = null;
    public static final h P0 = null;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    public static final int[] f240364p0 = null;
    public int A;
    public float B;
    public float C;
    public float D;
    public float E;
    public int F;
    public VelocityTracker G;
    public int H;
    public int I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public int f240365J;
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

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f240366a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayList<c> f240367b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final c f240368c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Rect f240369d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public op5.a f240370e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f240371f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f240372g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Parcelable f240373h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Scroller f240374i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f240375j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public g f240376k;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public int f240377k0;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f240378l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public Drawable f240379m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f240380n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f240381o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public float f240382p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public float f240383q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f240384r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f240385s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f240386t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f240387u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f240388v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f240389w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f240390x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f240391y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f240392z;

    @Target({ElementType.TYPE})
    @Inherited
    @Retention(RetentionPolicy.RUNTIME)
    public @interface DecorView {
    }

    public static class LayoutParams extends ViewGroup.LayoutParams {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f240393a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f240394b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public float f240395c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f240396d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f240397e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f240398f;

        public LayoutParams() {
            super(-1, -1);
            this.f240395c = 0.0f;
        }

        public LayoutParams(Context r100, AttributeSet r101) {
            super(r100, r101);
            this.f240395c = 0.0f;
            TypedArray r102 = r100.obtainStyledAttributes(r101, FixPageTransformerViewPager.f240364p0);
            this.f240394b = r102.getInteger(0, 48);
            r102.recycle();
        }
    }

    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f240399a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Parcelable f240400b;

        public class a implements Parcelable.ClassLoaderCreator<SavedState> {
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
            return "FragmentPager.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " position=" + this.f240399a + i.f25855d;
        }

        public SavedState(Parcelable r100) {
            super(r100);
        }

        public SavedState(Parcel r100, ClassLoader r101) {
            super(r100, r101);
            if (r101 != null) goto L5;
            r101 = getClass().getClassLoader();
        L5:
            this.f240399a = r100.readInt();
            this.f240400b = r100.readParcelable(r101);
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public final void writeToParcel(Parcel r100, int r101) {
            super.writeToParcel(r100, r101);
            r100.writeInt(this.f240399a);
            r100.writeParcelable(this.f240400b, r101);
        }
    }

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ FixPageTransformerViewPager f240401a;

        @Override // java.lang.Runnable
        public final void run() {
            this.f240401a.setScrollState(0);     // Catch: Throwable -> L4
            this.f240401a.r();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public a(FixPageTransformerViewPager r100) {
            this.f240401a = r100;
        }
    }

    public class b implements OnApplyWindowInsetsListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Rect f240402a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ FixPageTransformerViewPager f240403b;

        public b(FixPageTransformerViewPager r100) {
            this.f240403b = r100;
            this.f240402a = new Rect();
        }

        @Override // androidx.core.view.OnApplyWindowInsetsListener
        public final WindowInsetsCompat onApplyWindowInsets(View r100, WindowInsetsCompat r101) {
            WindowInsetsCompat r102 = ViewCompat.onApplyWindowInsets(r100, r101);
            if (r102.isConsumed() == false) goto L5;
            return r102;
        L5:
            Rect r103 = this.f240402a;
            r103.left = r102.getSystemWindowInsetLeft();
            r103.top = r102.getSystemWindowInsetTop();
            r103.right = r102.getSystemWindowInsetRight();
            r103.bottom = r102.getSystemWindowInsetBottom();
            int r104 = this.f240403b.getChildCount();
            int r105 = 0;
        L6:
            if (r105 >= r104) goto L9;
            WindowInsetsCompat r106 = ViewCompat.dispatchApplyWindowInsets(this.f240403b.getChildAt(r105), r102);
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

    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f240404a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f240405b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f240406c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public float f240407d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public float f240408e;

        public c() {
        }
    }

    public class d extends AccessibilityDelegateCompat {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ FixPageTransformerViewPager f240409a;

        public d(FixPageTransformerViewPager r100) {
            this.f240409a = r100;
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public final void onInitializeAccessibilityEvent(View r100, AccessibilityEvent r101) {
            super.onInitializeAccessibilityEvent(r100, r101);
            r101.setClassName(FixPageTransformerViewPager.class.getName());
            op5.a r102 = this.f240409a.f240370e;
            if (r102 == null) goto L7;
            boolean r103 = true;
            if (r102.b() <= 1) goto L7;
        L8:
            r101.setScrollable(r103);
            if (r101.getEventType() != 4096) goto L14;
            op5.a r104 = this.f240409a.f240370e;
            if (r104 == null) goto L15;
            r101.setItemCount(r104.b());
            r101.setFromIndex(this.f240409a.f240371f);
            r101.setToIndex(this.f240409a.f240371f);
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
            r101.setClassName(FixPageTransformerViewPager.class.getName());
            op5.a r102 = this.f240409a.f240370e;
            if (r102 != null) goto L5;
        L7:
            boolean r103 = false;
        L8:
            r101.setScrollable(r103);
            if (this.f240409a.canScrollHorizontally(1) == false) goto L12;
            r101.addAction(4096);
        L12:
            if (this.f240409a.canScrollHorizontally(-1) == false) goto L15;
            r101.addAction(8192);
            return;
        L15:
            return;
        L5:
            if (r102.b() <= 1) goto L7;
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
            if (this.f240409a.canScrollHorizontally(-1) == false) goto L14;
            FixPageTransformerViewPager r103 = this.f240409a;
            r103.setCurrentItem(r103.f240371f - 1);
            return true;
        L14:
            return false;
        L16:
            if (this.f240409a.canScrollHorizontally(1) == false) goto L19;
            FixPageTransformerViewPager r104 = this.f240409a;
            r104.setCurrentItem(r104.f240371f + 1);
            return true;
        L19:
            return false;
        }
    }

    public interface e {
        void a(int r100, float r101);

        void onPageScrollStateChanged(int r100);

        void onPageSelected(int r100);
    }

    public interface f {
        void a(View r100);
    }

    public class g extends DataSetObserver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ FixPageTransformerViewPager f240410a;

        @Override // android.database.DataSetObserver
        public final void onChanged() {
            this.f240410a.f();
        }

        @Override // android.database.DataSetObserver
        public final void onInvalidated() {
            this.f240410a.f();
        }

        public g(FixPageTransformerViewPager r100) {
            this.f240410a = r100;
        }
    }

    public static class h implements Comparator<View> {
        public h() {
        }

        @Override // java.util.Comparator
        public final int compare(View r100, View r101) {
            LayoutParams r102 = (LayoutParams) r100.getLayoutParams();
            LayoutParams r103 = (LayoutParams) r101.getLayoutParams();
            boolean r104 = r102.f240393a;
            if (r104 == r103.f240393a) goto L8;
            if (r104 == false) goto L6;
            return 1;
        L6:
            return -1;
        L8:
            return r102.f240397e - r103.f240397e;
        }
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [op5.c] */
    /* JADX WARN: Type inference failed for: r0v3, types: [op5.d] */
    static {
        f240364p0 = new int[]{R.attr.layout_gravity};
        H0 = new op5.c();
        L0 = new op5.d();
        P0 = new h();
    }

    @Override // android.view.View
    public final void computeScroll() {
        this.f240375j = true;
        if (this.f240374i.isFinished() == false) goto L5;
    L14:
        e(true);
        return;
    L5:
        if (this.f240374i.computeScrollOffset() == false) goto L14;
        int r100 = getScrollX();
        int r101 = getScrollY();
        int r102 = this.f240374i.getCurrX();
        int r103 = this.f240374i.getCurrY();
        if (r100 != r102) goto L9;
        if (r101 != r103) goto L9;
    L12:
        ViewCompat.postInvalidateOnAnimation(this);
        return;
    L9:
        scrollTo(r102, r103);
        if (p(r102) == true) goto L12;
        this.f240374i.abortAnimation();
        scrollTo(0, r103);
        goto L12
    }

    public final void l() {
        setWillNotDraw(false);
        setDescendantFocusability(262144);
        setFocusable(true);
        Context r100 = getContext();
        this.f240374i = new Scroller(r100, L0);
        ViewConfiguration r101 = ViewConfiguration.get(r100);
        Resources r102 = r100.getResources();
        float r103 = WindowDisplayMetricsOverride.apply(r102, r102.getDisplayMetrics()).density;
        this.A = r101.getScaledPagingTouchSlop();
        this.H = (int) (400.0f * r103);
        this.I = r101.getScaledMaximumFlingVelocity();
        this.L = new EdgeEffect(r100);
        this.M = new EdgeEffect(r100);
        this.f240365J = (int) (25.0f * r103);
        this.K = (int) (2.0f * r103);
        this.f240391y = (int) (r103 * 16.0f);
        ViewCompat.setAccessibilityDelegate(this, new d(this));
        if (ViewCompat.getImportantForAccessibility(this) != 0) goto L5;
        ViewCompat.setImportantForAccessibility(this, 1);
    L5:
        ViewCompat.setOnApplyWindowInsetsListener(this, new b(this));
    }

    public final boolean u() {
        this.F = -1;
        this.f240389w = false;
        this.f240390x = false;
        VelocityTracker r100 = this.G;
        if (r100 == null) goto L5;
        r100.recycle();
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
        int r100 = this.f240370e.b();
        this.f240366a = r100;
        if (this.f240367b.size() < ((this.f240388v * 2) + 1)) goto L5;
    L7:
        boolean r101 = false;
    L8:
        int r102 = this.f240371f;
        int r103 = 0;
        boolean r104 = false;
    L10:
        if (r103 >= this.f240367b.size()) goto L30;
        c r105 = (c) ListProtector.get(this.f240367b, r103);
        int r106 = this.f240370e.c(r105.f240404a);
        tt5.a.b("FixPageTransformerViewPager", "getItemPosition: object = " + r105.f240404a + ", newPos = " + r106);
        if (r106 == (-1)) goto L29;
        if (r106 != (-2)) goto L22;
        ListProtector.remove(this.f240367b, r103);
        r103 = r103 - 1;
        if (r104 == true) goto L19;
        this.f240370e.getClass();
        r104 = true;
    L19:
        this.f240370e.a(this, r105.f240405b, r105.f240404a);
        int r107 = this.f240371f;
        if (r107 != r105.f240405b) goto L28;
        r102 = Math.max(0, Math.min(r107, (-1) + r100));
    L28:
        r101 = true;
        goto L29
    L22:
        int r108 = r105.f240405b;
        if (r108 == r106) goto L29;
        if (r108 != this.f240371f) goto L27;
        r102 = r106;
    L27:
        r105.f240405b = r106;
    L29:
        r103 = r103 + 1;
        goto L10
    L30:
        if (r104 == false) goto L32;
        this.f240370e.getClass();
    L32:
        Collections.sort(this.f240367b, H0);
        if (r101 == false) goto L49;
        int r109 = getChildCount();
        int r110 = 0;
    L35:
        if (r110 >= r109) goto L40;
        LayoutParams r111 = (LayoutParams) getChildAt(r110).getLayoutParams();
        if (r111.f240393a == true) goto L39;
        r111.f240395c = 0.0f;
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
        if (this.f240367b.size() >= r100) goto L7;
        r101 = true;
        goto L8
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams();
    }

    public final boolean o() {
        op5.a r100 = this.f240370e;
        if (r100 != null) goto L5;
        return false;
    L5:
        if (this.f240371f >= (r100.b() - 1)) goto L10;
        w(this.f240371f + 1, true);
        return true;
    L10:
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        removeCallbacks(this.W);
        Scroller r100 = this.f240374i;
        if (r100 != null) goto L5;
    L7:
        super.onDetachedFromWindow();
        return;
    L5:
        if (r100.isFinished() == true) goto L7;
        this.f240374i.abortAnimation();
        goto L7
    }

    public final void r() {
        s(this.f240371f);
    }

    public final void z() {
        if (this.U == 0) goto L14;
        ArrayList<View> r100 = this.V;
        if (r100 != null) goto L7;
        this.V = new ArrayList();
    L8:
        int r101 = getChildCount();
        int r102 = 0;
    L9:
        if (r102 >= r101) goto L11;
        View r103 = getChildAt(r102);
        this.V.add(r103);
        r102 = r102 + 1;
        goto L9
    L11:
        Collections.sort(this.V, P0);
        return;
    L7:
        r100.clear();
        goto L8
    }

    private int getClientWidth() {
        return (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
    }

    public final void A() {
        getScrollX();
        int r100 = getChildCount();
        int r101 = 0;
    L3:
        if (r101 >= r100) goto L9;
        View r102 = getChildAt(r101);
        if (((LayoutParams) r102.getLayoutParams()).f240393a == true) goto L8;
        r102.getLeft();
        getClientWidth();
        this.S.a(r102);
    L8:
        r101 = r101 + 1;
        goto L3
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable r100 = this.f240379m;
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.isStateful() == false) goto L9;
        r100.setState(getDrawableState());
        return;
    }

    public final c j() {
        int r100 = getClientWidth();
        float r101 = 0.0f;
        if (r100 <= 0) goto L5;
        float r102 = getScrollX() / r100;
    L6:
        if (r100 <= 0) goto L8;
        float r103 = this.f240378l / r100;
    L9:
        c r104 = null;
        float r105 = 0.0f;
        int r106 = -1;
        int r107 = 0;
        boolean r108 = true;
    L11:
        if (r107 >= this.f240367b.size()) goto L30;
        c r110 = (c) ListProtector.get(this.f240367b, r107);
        if (r108 == true) goto L17;
        int r109 = r106 + 1;
        if (r110.f240405b == r109) goto L17;
        r110 = this.f240368c;
        r110.f240408e = (r101 + r105) + r103;
        r110.f240405b = r109;
        this.f240370e.getClass();
        r110.f240407d = 1.0f;
        r107 = r107 - 1;
    L17:
        c r111 = r110;
        r101 = r111.f240408e;
        float r112 = (r111.f240407d + r101) + r103;
        if (r108 == true) goto L24;
        if (r102 >= r101) goto L24;
        return r104;
    L24:
        if (r102 < r112) goto L29;
        if (r107 == (this.f240367b.size() - 1)) goto L29;
        int r113 = r111.f240405b;
        float r114 = r111.f240407d;
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
        this.N = true;
    }

    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        SavedState r100 = new SavedState(super.onSaveInstanceState());
        r100.f240399a = this.f240371f;
        op5.a r101 = this.f240370e;
        if (r101 == null) goto L5;
        r101.getClass();
        r100.f240400b = null;
    L5:
        return r100;
    }

    public op5.a getAdapter() {
        return this.f240370e;
    }

    public int getCurrentItem() {
        return this.f240371f;
    }

    public int getOffscreenPageLimit() {
        return this.f240388v;
    }

    public int getPageMargin() {
        return this.f240378l;
    }

    public FixPageTransformerViewPager(Context r100) {
        super(r100);
        this.f240367b = new ArrayList();
        this.f240368c = new c();
        this.f240369d = new Rect();
        this.f240372g = -1;
        this.f240373h = null;
        this.f240382p = -3.4028235E38f;
        this.f240383q = Float.MAX_VALUE;
        this.f240388v = 1;
        this.F = -1;
        this.N = true;
        this.W = new a(this);
        this.f240377k0 = 0;
        l();
    }

    private void setScrollingCacheEnabled(boolean r100) {
        if (this.f240386t == r100) goto L6;
        this.f240386t = r100;
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void addTouchables(ArrayList<View> r100) {
        int r101 = 0;
    L4:
        if (r101 >= getChildCount()) goto L13;
        View r102 = getChildAt(r101);
        if (r102.getVisibility() != 0) goto L12;
        c r103 = i(r102);
        if (r103 == null) goto L12;
        if (r103.f240405b != this.f240371f) goto L12;
        r102.addTouchables(r100);
    L12:
        r101 = r101 + 1;
        goto L4
    }

    public final void b(e r100) {
        if (this.Q != null) goto L5;
        this.Q = new ArrayList();
    L5:
        this.Q.add(r100);
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
        StringBuilder r106 = new StringBuilder();
        r106.append(r101.getClass().getSimpleName());
        ViewParent r107 = r101.getParent();
    L16:
        if ((r107 instanceof ViewGroup) == false) goto L18;
        r106.append(" => ");
        r106.append(r107.getClass().getSimpleName());
        r107 = r107.getParent();
        goto L16
    L18:
        tt5.a.d("FixPageTransformerViewPager", "arrowScroll tried to find focus based on non-child current focused view " + r106.toString());
        goto L19
    L12:
        r105 = false;
    L20:
        View r108 = FocusFinder.getInstance().findNextFocus(this, r101, r100);
        if (r108 == null) goto L38;
        if (r108 == r101) goto L38;
        if (r100 != 17) goto L32;
        int r109 = h(this.f240369d, r108).left;
        int r110 = h(this.f240369d, r101).left;
        if (r101 == null) goto L30;
        if (r109 < r110) goto L30;
        int r111 = this.f240371f;
        if (r111 <= 0) goto L48;
        w(r111 - 1, true);
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
        boolean r112 = r108.requestFocus();
    L31:
        r103 = r112;
        goto L50
    L32:
        if (r100 != 66) goto L50;
        int r113 = h(this.f240369d, r108).left;
        int r114 = h(this.f240369d, r101).left;
        if (r101 == null) goto L37;
        if (r113 > r114) goto L37;
        r112 = o();
    L37:
        r112 = r108.requestFocus();
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
        int r115 = this.f240371f;
        if (r115 <= 0) goto L48;
        w(r115 - 1, true);
    L19:
        r101 = null;
        goto L20
    }

    @Override // android.view.View
    public final boolean canScrollHorizontally(int r100) {
        if (this.f240370e != null) goto L5;
        return false;
    L5:
        int r101 = getClientWidth();
        int r102 = getScrollX();
        if (r100 < 0) goto L8;
        if (r100 > 0) goto L13;
        return false;
    L13:
        if (r102 >= ((int) (r101 * this.f240383q))) goto L18;
        return true;
    L18:
        return false;
    L8:
        if (r102 <= ((int) (r101 * this.f240382p))) goto L16;
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
        int r103 = this.f240371f;
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
        c r104 = i(r103);
        if (r104 == null) goto L18;
        if (r104.f240405b != this.f240371f) goto L18;
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
        op5.a r103 = this.f240370e;
        if (r103 == null) goto L11;
        if (r103.b() > 1) goto L13;
    L11:
        this.L.finish();
        this.M.finish();
    L18:
        if (r102 == false) goto L21;
        ViewCompat.postInvalidateOnAnimation(this);
        return;
    L21:
        return;
    L13:
        if (this.L.isFinished() == true) goto L16;
        int r104 = r100.save();
        int r105 = (getHeight() - getPaddingTop()) - getPaddingBottom();
        int r106 = getWidth();
        r100.rotate(270.0f);
        r100.translate((-r105) + getPaddingTop(), this.f240382p * r106);
        this.L.setSize(r105, r106);
        r102 = false | this.L.draw(r100);
        r100.restoreToCount(r104);
    L16:
        if (this.M.isFinished() == true) goto L18;
        int r107 = r100.save();
        int r108 = getWidth();
        int r109 = (getHeight() - getPaddingTop()) - getPaddingBottom();
        r100.rotate(90.0f);
        r100.translate(-getPaddingTop(), (-(this.f240383q + 1.0f)) * r108);
        this.M.setSize(r109, r108);
        r102 = r102 | this.M.draw(r100);
        r100.restoreToCount(r107);
        goto L18
    }

    public final void e(boolean r100) {
        if (this.f240377k0 != 2) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == false) goto L15;
        setScrollingCacheEnabled(false);
        if ((!this.f240374i.isFinished()) == false) goto L15;
        this.f240374i.abortAnimation();
        int r102 = getScrollX();
        int r103 = getScrollY();
        int r104 = this.f240374i.getCurrX();
        int r105 = this.f240374i.getCurrY();
        if (r102 != r104) goto L12;
        if (r103 == r105) goto L15;
    L12:
        scrollTo(r104, r105);
        if (r104 == r102) goto L15;
        p(r104);
    L15:
        this.f240387u = false;
        int r106 = 0;
    L17:
        if (r106 >= this.f240367b.size()) goto L22;
        c r107 = (c) ListProtector.get(this.f240367b, r106);
        if (r107.f240406c == false) goto L21;
        r107.f240406c = false;
        r101 = true;
    L21:
        r106 = r106 + 1;
        goto L17
    L22:
        if (r101 == false) goto L30;
        if (r100 == false) goto L25;
        ViewCompat.postOnAnimation(this, this.W);
        return;
    L25:
        this.W.run();
        return;
    L30:
        return;
    L5:
        r101 = false;
        goto L6
    }

    public final void g(int r100) {
        e r101 = this.R;
        if (r101 == null) goto L5;
        r101.onPageSelected(r100);
    L5:
        List<e> r102 = this.Q;
        if (r102 == null) goto L13;
        int r103 = ((ArrayList) r102).size();
        int r104 = 0;
    L8:
        if (r104 >= r103) goto L17;
        e r105 = (e) ListProtector.get(this.Q, r104);
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

    public final c i(View r100) {
        int r101 = 0;
    L4:
        if (r101 >= this.f240367b.size()) goto L9;
        c r102 = (c) ListProtector.get(this.f240367b, r101);
        if (this.f240370e.e(r100, r102.f240404a) == true) goto L7;
        r101 = r101 + 1;
        goto L4
    L7:
        return r102;
    L9:
        return null;
    }

    public final c k(int r100) {
        int r101 = 0;
    L4:
        if (r101 >= this.f240367b.size()) goto L9;
        c r102 = (c) ListProtector.get(this.f240367b, r101);
        if (r102.f240405b == r100) goto L7;
        r101 = r101 + 1;
        goto L4
    L7:
        return r102;
    L9:
        return null;
    }

    public final void n(MotionEvent r100) {
        int r101 = r100.getActionIndex();
        if (r100.getPointerId(r101) != this.F) goto L11;
        if (r101 != 0) goto L6;
        int r102 = 1;
    L7:
        this.B = r100.getX(r102);
        this.F = r100.getPointerId(r102);
        VelocityTracker r103 = this.G;
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
        if (this.f240378l > 0) goto L5;
        return;
    L5:
        if (this.f240379m != null) goto L7;
        return;
    L7:
        if (this.f240367b.size() > 0) goto L9;
        return;
    L9:
        if (this.f240370e == null) goto L34;
        int r100 = getScrollX();
        int r101 = getWidth();
        float r102 = r101;
        float r103 = this.f240378l / r102;
        int r104 = 0;
        c r105 = (c) ListProtector.get(this.f240367b, 0);
        float r106 = r105.f240408e;
        int r107 = this.f240367b.size();
        int r108 = r105.f240405b;
        int r111 = ((c) ListProtector.get(this.f240367b, r107 - 1)).f240405b;
    L11:
        if (r108 >= r111) goto L35;
    L12:
        int r112 = r105.f240405b;
        if (r108 <= r112) goto L16;
        if (r104 >= r107) goto L16;
        r104 = r104 + 1;
        r105 = (c) ListProtector.get(this.f240367b, r104);
    L16:
        if (r108 != r112) goto L18;
        float r109 = r105.f240408e;
        float r113 = r105.f240407d;
        float r114 = (r109 + r113) * r102;
        r106 = (r109 + r113) + r103;
    L20:
        if ((this.f240378l + r114) <= r100) goto L24;
        this.f240379m.setBounds(Math.round(r114), this.f240380n, Math.round(this.f240378l + r114), this.f240381o);
        this.f240379m.draw(r110);
    L24:
        if (r114 > (r100 + r101)) goto L36;
        r108 = r108 + 1;
        r103 = r103;
        goto L11
    L36:
        return;
    L18:
        this.f240370e.getClass();
        r114 = (r106 + 1.0f) * r102;
        r106 = r106 + (1.0f + r103);
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
        if (this.f240389w == false) goto L12;
        return true;
    L12:
        if (this.f240390x == false) goto L15;
        return false;
    L15:
        if (r100 == 0) goto L60;
        if (r100 != 2) goto L18;
        int r101 = this.F;
        if (r101 == (-1)) goto L70;
        int r102 = r110.findPointerIndex(r101);
        float r103 = r110.getX(r102);
        float r104 = r103 - this.B;
        float r105 = Math.abs(r104);
        float r106 = r110.getY(r102);
        float r107 = Math.abs(r106 - this.E);
        if (r104 == 0.0f) goto L40;
        float r108 = this.B;
        if (r108 >= this.f240392z) goto L30;
        if (r104 <= 0.0f) goto L30;
    L33:
        boolean r109 = true;
    L35:
        if (r109 == true) goto L40;
        if (d(this, false, (int) r104, (int) r103, (int) r106) == false) goto L40;
        this.B = r103;
        this.C = r106;
        this.f240390x = true;
        return false;
    L30:
        if (r108 > (getWidth() - this.f240392z)) goto L32;
    L34:
        r109 = false;
        goto L35
    L32:
        if (r104 >= 0.0f) goto L34;
    L40:
        float r111 = this.A;
        if (r105 <= r111) goto L53;
        if ((r105 * 0.5f) <= r107) goto L53;
        this.f240389w = true;
        ViewParent r112 = getParent();
        if (r112 == null) goto L47;
        r112.requestDisallowInterceptTouchEvent(true);
    L47:
        setScrollState(1);
        if (r104 <= 0.0f) goto L50;
        float r113 = this.D + this.A;
    L51:
        this.B = r113;
        this.C = r106;
        setScrollingCacheEnabled(true);
    L56:
        if (this.f240389w == false) goto L70;
        if (q(r103) == false) goto L70;
        ViewCompat.postInvalidateOnAnimation(this);
        goto L70
    L50:
        r113 = this.D - this.A;
    L53:
        if (r107 <= r111) goto L56;
        this.f240390x = true;
    L70:
        if (this.G != null) goto L72;
        this.G = VelocityTracker.obtain();
    L72:
        this.G.addMovement(r110);
        return this.f240389w;
    L18:
        if (r100 != 6) goto L70;
        n(r110);
        goto L70
    L60:
        float r114 = r110.getX();
        this.D = r114;
        this.B = r114;
        float r115 = r110.getY();
        this.E = r115;
        this.C = r115;
        this.F = r110.getPointerId(0);
        this.f240390x = false;
        this.f240375j = true;
        this.f240374i.computeScrollOffset();
        if (this.f240377k0 == 2) goto L63;
    L68:
        e(false);
        this.f240389w = false;
        goto L70
    L63:
        if (Math.abs(this.f240374i.getFinalX() - this.f240374i.getCurrX()) <= this.K) goto L68;
        this.f240374i.abortAnimation();
        this.f240387u = false;
        r();
        this.f240389w = true;
        ViewParent r116 = getParent();
        if (r116 == null) goto L67;
        r116.requestDisallowInterceptTouchEvent(true);
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
        if (this.f240370e == null) goto L9;
        x(r101.f240399a, false, true, 0);
        return;
    L9:
        this.f240372g = r101.f240399a;
        this.f240373h = r101.f240400b;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent r110) {
        boolean r100 = false;
        if (r110.getAction() == 0) goto L5;
    L7:
        op5.a r101 = this.f240370e;
        if (r101 != null) goto L10;
    L77:
        return false;
    L10:
        if (r101.b() == 0) goto L77;
        if (this.G != null) goto L15;
        this.G = VelocityTracker.obtain();
    L15:
        this.G.addMovement(r110);
        int r102 = r110.getAction() & 255;
        if (r102 != 0) goto L18;
        this.f240374i.abortAnimation();
        this.f240387u = false;
        r();
        float r103 = r110.getX();
        this.D = r103;
        this.B = r103;
        float r104 = r110.getY();
        this.E = r104;
        this.C = r104;
        this.F = r110.getPointerId(0);
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
        this.B = r110.getX(r105);
        this.F = r110.getPointerId(r105);
        goto L74
    L26:
        if (r102 != 6) goto L74;
        n(r110);
        this.B = r110.getX(r110.findPointerIndex(this.F));
        goto L74
    L31:
        if (this.f240389w == false) goto L74;
        v(this.f240371f, true, 0, false);
        r100 = u();
        goto L74
    L34:
        if (this.f240389w == true) goto L53;
        int r106 = r110.findPointerIndex(this.F);
        if (r106 != (-1)) goto L38;
        r100 = u();
        goto L74
    L38:
        float r107 = r110.getX(r106);
        float r108 = Math.abs(r107 - this.B);
        float r109 = r110.getY(r106);
        float r111 = Math.abs(r109 - this.C);
        if (r108 <= this.A) goto L53;
        if (r108 <= r111) goto L53;
        this.f240389w = true;
        ViewParent r112 = getParent();
        if (r112 == null) goto L45;
        r112.requestDisallowInterceptTouchEvent(true);
    L45:
        float r113 = this.D;
        if ((r107 - r113) <= 0.0f) goto L48;
        float r114 = r113 + this.A;
    L49:
        this.B = r114;
        this.C = r109;
        setScrollState(1);
        setScrollingCacheEnabled(true);
        ViewParent r115 = getParent();
        if (r115 == null) goto L53;
        r115.requestDisallowInterceptTouchEvent(true);
        goto L53
    L48:
        r114 = r113 - this.A;
    L53:
        if (this.f240389w == false) goto L74;
        r100 = false | q(r110.getX(r110.findPointerIndex(this.F)));
        goto L74
    L56:
        if (this.f240389w == false) goto L74;
        VelocityTracker r116 = this.G;
        r116.computeCurrentVelocity(1000, this.I);
        int r117 = (int) r116.getXVelocity(this.F);
        this.f240387u = true;
        int r118 = getClientWidth();
        int r119 = getScrollX();
        c r120 = j();
        float r121 = r118;
        float r122 = this.f240378l / r121;
        int r123 = r120.f240405b;
        float r124 = ((r119 / r121) - r120.f240408e) / (r120.f240407d + r122);
        if (Math.abs((int) (r110.getX(r110.findPointerIndex(this.F)) - this.D)) <= this.f240365J) goto L65;
        if (Math.abs(r117) <= this.H) goto L65;
        if (r117 > 0) goto L70;
        r123 = r123 + 1;
    L70:
        if (this.f240367b.size() <= 0) goto L72;
        c r125 = (c) ListProtector.get(this.f240367b, 0);
        ArrayList<c> r126 = this.f240367b;
        r123 = Math.max(r125.f240405b, Math.min(r123, ((c) ListProtector.get(r126, r126.size() - 1)).f240405b));
    L72:
        x(r123, true, true, r117);
        r100 = u();
    L65:
        if (r123 < this.f240371f) goto L67;
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
        if (this.f240367b.size() == 0) goto L5;
        c r101 = j();
        int r102 = getClientWidth();
        int r103 = this.f240378l;
        int r104 = r102 + r103;
        float r105 = r102;
        int r106 = r101.f240405b;
        float r107 = ((r100 / r105) - r101.f240408e) / (r101.f240407d + (r103 / r105));
        this.O = false;
        m(r106, r107, (int) (r104 * r107));
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

    public final boolean q(float r110) {
        float r100 = this.B - r110;
        this.B = r110;
        float r111 = getScrollX() + r100;
        float r101 = getClientWidth();
        float r102 = this.f240382p * r101;
        float r103 = this.f240383q * r101;
        boolean r104 = false;
        c r105 = (c) ListProtector.get(this.f240367b, 0);
        ArrayList<c> r106 = this.f240367b;
        c r107 = (c) ListProtector.get(r106, r106.size() - 1);
        if (r105.f240405b == 0) goto L5;
        r102 = r105.f240408e * r101;
        boolean r108 = false;
    L7:
        if (r107.f240405b == (this.f240370e.b() - 1)) goto L9;
        r103 = r107.f240408e * r101;
        boolean r109 = false;
    L11:
        if (r111 >= r102) goto L16;
        if (r108 == false) goto L14;
        this.L.onPull(Math.abs(r102 - r111) / r101);
        r104 = true;
    L14:
        r111 = r102;
    L20:
        int r112 = (int) r111;
        this.B += r111 - r112;
        scrollTo(r112, getScrollY());
        p(r112);
        return r104;
    L16:
        if (r111 <= r103) goto L20;
        if (r109 == false) goto L19;
        this.M.onPull(Math.abs(r111 - r103) / r101);
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
        if (this.f240385s == false) goto L5;
        removeViewInLayout(r100);
        return;
    L5:
        super.removeView(r100);
    }

    public final void s(int r110) {
        int r100 = this.f240371f;
        if (r100 == r110) goto L5;
        c r101 = k(r100);
        this.f240371f = r110;
    L7:
        if (this.f240370e != null) goto L11;
        z();
        return;
    L11:
        if (this.f240387u == false) goto L15;
        z();
        return;
    L15:
        if (getWindowToken() != null) goto L17;
        return;
    L17:
        this.f240370e.getClass();
        int r102 = this.f240388v;
        int r103 = Math.max(0, this.f240371f - r102);
        int r104 = this.f240370e.b();
        int r105 = Math.min(r104 - 1, this.f240371f + r102);
        if (r104 != this.f240366a) goto L210;
        int r106 = 0;
    L21:
        if (r106 >= this.f240367b.size()) goto L27;
        c r107 = (c) ListProtector.get(this.f240367b, r106);
        int r108 = r107.f240405b;
        int r111 = this.f240371f;
        if (r108 >= r111) goto L24;
        r106 = r106 + 1;
        goto L21
    L24:
        if (r108 != r111) goto L27;
    L28:
        if (r107 != null) goto L32;
        if (r104 <= 0) goto L32;
        r107 = a(this.f240371f, r106);
    L32:
        if (r107 == null) goto L167;
        int r112 = r106 - 1;
        if (r112 < 0) goto L36;
        c r113 = (c) ListProtector.get(this.f240367b, r112);
    L37:
        int r114 = getClientWidth();
        if (r114 > 0) goto L40;
        float r115 = 0.0f;
    L41:
        int r109 = this.f240371f - 1;
        float r116 = 0.0f;
    L42:
        if (r109 < 0) goto L67;
        if (r116 < r115) goto L55;
        if (r109 >= r103) goto L55;
        if (r113 == null) goto L67;
        if (r109 != r113.f240405b) goto L66;
        if (r113.f240406c == true) goto L66;
        ListProtector.remove(this.f240367b, r112);
        this.f240370e.a(this, r109, r113.f240404a);
        r112 = r112 - 1;
        r106 = r106 - 1;
        if (r112 < 0) goto L64;
        c r117 = (c) ListProtector.get(this.f240367b, r112);
    L65:
        r113 = r117;
    L64:
        r117 = null;
    L66:
        r109 = r109 - 1;
    L55:
        if (r113 != null) goto L57;
    L61:
        r116 = r116 + a(r109, r112 + 1).f240407d;
        r106 = r106 + 1;
        if (r112 < 0) goto L64;
        r117 = (c) ListProtector.get(this.f240367b, r112);
        goto L65
    L57:
        if (r109 != r113.f240405b) goto L61;
        r116 = r116 + r113.f240407d;
        r112 = r112 - 1;
        if (r112 < 0) goto L64;
        r117 = (c) ListProtector.get(this.f240367b, r112);
    L67:
        float r118 = r107.f240407d;
        int r119 = r106 + 1;
        if (r118 < 2.0f) goto L70;
    L101:
        int r120 = this.f240370e.b();
        int r121 = getClientWidth();
        if (r121 <= 0) goto L104;
        float r122 = this.f240378l / r121;
    L106:
        if (r101 == null) goto L138;
        int r123 = r101.f240405b;
        int r124 = r107.f240405b;
        if (r123 >= r124) goto L124;
        float r125 = (r101.f240408e + r101.f240407d) + r122;
        int r126 = r123 + 1;
        int r127 = 0;
    L111:
        if (r126 > r107.f240405b) goto L138;
        if (r127 >= this.f240367b.size()) goto L138;
        Object r128 = ListProtector.get(this.f240367b, r127);
    L115:
        c r129 = (c) r128;
        if (r126 <= r129.f240405b) goto L121;
        if (r127 >= (this.f240367b.size() - 1)) goto L121;
        r127 = r127 + 1;
        r128 = ListProtector.get(this.f240367b, r127);
    L121:
        if (r126 >= r129.f240405b) goto L123;
        this.f240370e.getClass();
        r125 = r125 + (1.0f + r122);
        r126 = r126 + 1;
        goto L121
    L123:
        r129.f240408e = r125;
        r125 = r125 + (r129.f240407d + r122);
        r126 = r126 + 1;
        goto L111
    L124:
        if (r123 <= r124) goto L138;
        int r130 = this.f240367b.size() - 1;
        float r131 = r101.f240408e;
    L126:
        r123 = r123 - 1;
        if (r123 < r107.f240405b) goto L138;
        if (r130 < 0) goto L138;
        Object r132 = ListProtector.get(this.f240367b, r130);
    L130:
        c r133 = (c) r132;
        if (r123 >= r133.f240405b) goto L135;
        if (r130 <= 0) goto L135;
        r130 = r130 - 1;
        r132 = ListProtector.get(this.f240367b, r130);
    L135:
        if (r123 <= r133.f240405b) goto L137;
        this.f240370e.getClass();
        r131 = r131 - (1.0f + r122);
        r123 = r123 - 1;
        goto L135
    L137:
        r131 = r131 - (r133.f240407d + r122);
        r133.f240408e = r131;
    L138:
        int r134 = this.f240367b.size();
        float r135 = r107.f240408e;
        int r136 = r107.f240405b;
        int r137 = r136 - 1;
        if (r136 != 0) goto L141;
        float r138 = r135;
    L142:
        this.f240382p = r138;
        int r139 = r120 - 1;
        if (r136 != r139) goto L145;
        float r140 = (r107.f240407d + r135) - 1.0f;
    L146:
        this.f240383q = r140;
        int r141 = r106 - 1;
    L147:
        if (r141 < 0) goto L156;
        c r142 = (c) ListProtector.get(this.f240367b, r141);
    L149:
        int r143 = r142.f240405b;
        if (r137 <= r143) goto L152;
        r137 = r137 - 1;
        this.f240370e.getClass();
        r135 = r135 - (1.0f + r122);
        goto L149
    L152:
        r135 = r135 - (r142.f240407d + r122);
        r142.f240408e = r135;
        if (r143 != 0) goto L155;
        this.f240382p = r135;
    L155:
        r141 = r141 - 1;
        r137 = r137 - 1;
        goto L147
    L156:
        float r144 = (r107.f240408e + r107.f240407d) + r122;
        int r145 = r107.f240405b;
    L157:
        r145 = r145 + 1;
        if (r119 >= r134) goto L166;
        c r146 = (c) ListProtector.get(this.f240367b, r119);
    L160:
        int r147 = r146.f240405b;
        if (r145 >= r147) goto L163;
        r145 = r145 + 1;
        this.f240370e.getClass();
        r144 = r144 + (1.0f + r122);
        goto L160
    L163:
        if (r147 != r139) goto L165;
        this.f240383q = (r146.f240407d + r144) - 1.0f;
    L165:
        r146.f240408e = r144;
        r144 = r144 + (r146.f240407d + r122);
        r119 = r119 + 1;
        goto L157
    L166:
        this.f240370e.g(this, this.f240371f, r107.f240404a);
        goto L167
    L145:
        r140 = Float.MAX_VALUE;
        goto L146
    L141:
        r138 = -3.4028235E38f;
        goto L142
    L104:
        r122 = 0.0f;
        goto L106
    L70:
        if (r119 >= this.f240367b.size()) goto L72;
        c r148 = (c) ListProtector.get(this.f240367b, r119);
    L73:
        if (r114 > 0) goto L75;
        float r149 = 0.0f;
    L76:
        int r150 = this.f240371f + 1;
        int r151 = r119;
    L77:
        if (r150 >= r104) goto L101;
        if (r118 < r149) goto L91;
        if (r150 <= r105) goto L91;
        if (r148 == null) goto L101;
        if (r150 != r148.f240405b) goto L100;
        if (r148.f240406c == true) goto L100;
        ListProtector.remove(this.f240367b, r151);
        this.f240370e.a(this, r150, r148.f240404a);
        if (r151 >= this.f240367b.size()) goto L90;
        r148 = (c) ListProtector.get(this.f240367b, r151);
    L90:
        r148 = null;
    L100:
        r150 = r150 + 1;
    L91:
        if (r148 != null) goto L93;
    L97:
        c r152 = a(r150, r151);
        r151 = r151 + 1;
        r118 = r118 + r152.f240407d;
        if (r151 >= this.f240367b.size()) goto L90;
        r148 = (c) ListProtector.get(this.f240367b, r151);
        goto L100
    L93:
        if (r150 != r148.f240405b) goto L97;
        r118 = r118 + r148.f240407d;
        r151 = r151 + 1;
        if (r151 >= this.f240367b.size()) goto L90;
        r148 = (c) ListProtector.get(this.f240367b, r151);
        goto L100
    L75:
        r149 = (getPaddingRight() / r114) + 2.0f;
        goto L76
    L72:
        r148 = null;
        goto L73
    L40:
        r115 = (2.0f - r107.f240407d) + (getPaddingLeft() / r114);
        goto L41
    L36:
        r113 = null;
    L167:
        this.f240370e.getClass();
        int r153 = getChildCount();
        int r154 = 0;
    L168:
        if (r154 >= r153) goto L177;
        View r155 = getChildAt(r154);
        LayoutParams r156 = (LayoutParams) r155.getLayoutParams();
        r156.f240398f = r154;
        if (r156.f240393a == true) goto L176;
        if (r156.f240395c != 0.0f) goto L176;
        c r157 = i(r155);
        if (r157 == null) goto L176;
        r156.f240395c = r157.f240407d;
        r156.f240397e = r157.f240405b;
    L176:
        r154 = r154 + 1;
        goto L168
    L177:
        z();
        if (hasFocus() == false) goto L204;
        View r158 = findFocus();
        if (r158 == null) goto L189;
    L181:
        Object r159 = r158.getParent();
        if (r159 == this) goto L188;
        if (r159 == null) goto L189;
        if ((r159 instanceof View) == false) goto L189;
        r158 = (View) r159;
        goto L181
    L188:
        c r160 = i(r158);
    L190:
        if (r160 != null) goto L192;
    L193:
        int r161 = 0;
    L195:
        if (r161 >= getChildCount()) goto L261;
        View r162 = getChildAt(r161);
        c r163 = i(r162);
        if (r163 == null) goto L203;
        if (r163.f240405b != this.f240371f) goto L203;
        if (r162.requestFocus(2) == false) goto L203;
        return;
    L203:
        r161 = r161 + 1;
        goto L195
    L261:
        return;
    L192:
        if (r160.f240405b != this.f240371f) goto L193;
        return;
    L189:
        r160 = null;
        goto L190
    L204:
        return;
    L27:
        r107 = null;
        goto L28
    L210:
        String r164 = getResources().getResourceName(getId());     // Catch: Resources.NotFoundException -> L207
    L209:
        throw new IllegalStateException("The application's PagerAdapter changed the adapter's contents without calling PagerAdapter#notifyDataSetChanged! Expected adapter item count: " + this.f240366a + ", found: " + r104 + " Pager id: " + r164 + " Pager class: " + getClass() + " Problematic adapter: " + this.f240370e.getClass());
    L207:
        r164 = Integer.toHexString(getId());
        goto L209
    L5:
        r101 = null;
        goto L7
    }

    public void setAdapter(op5.a r100) {
        op5.a r101 = this.f240370e;
        if (r101 == null) goto L22;
        monitor-enter(r101);
        r101.f524721b = null;     // Catch: Throwable -> L19
        monitor-exit(r101);     // Catch: Throwable -> L19
        this.f240370e.getClass();
        int r102 = 0;
    L9:
        if (r102 >= this.f240367b.size()) goto L11;
        c r103 = (c) ListProtector.get(this.f240367b, r102);
        this.f240370e.a(this, r103.f240405b, r103.f240404a);
        r102 = r102 + 1;
        goto L9
    L11:
        this.f240370e.getClass();
        this.f240367b.clear();
        int r104 = 0;
    L13:
        if (r104 >= getChildCount()) goto L18;
        if (((LayoutParams) getChildAt(r104).getLayoutParams()).f240393a == true) goto L17;
        removeViewAt(r104);
        r104 = r104 - 1;
    L17:
        r104 = r104 + 1;
        goto L13
    L18:
        this.f240371f = 0;
        scrollTo(0, 0);
    L19:
        th = move-exception;
        throw th;
    L22:
        this.f240370e = r100;
        this.f240366a = 0;
        if (r100 != null) goto L25;
        return;
    L25:
        if (this.f240376k != null) goto L27;
        this.f240376k = new g(this);
    L27:
        this.f240370e.h(this.f240376k);
        this.f240387u = false;
        boolean r105 = this.N;
        this.N = true;
        this.f240366a = this.f240370e.b();
        if (this.f240372g < 0) goto L30;
        this.f240370e.getClass();
        x(this.f240372g, false, true, 0);
        this.f240372g = -1;
        this.f240373h = null;
        return;
    L30:
        if (r105 == true) goto L32;
        r();
        return;
    L32:
        requestLayout();
    }

    public void setCurrentItem(int r100) {
        this.f240387u = false;
        x(r100, !this.N, false, 0);
    }

    public void setMinimumVelocity(int r100) {
        Resources r101 = getContext().getResources();
        float r102 = WindowDisplayMetricsOverride.apply(r101, r101.getDisplayMetrics()).density;
        this.H = (int) (r100 * r102);
        this.f240365J = (int) (r102 * 5.0f);
    }

    public void setOffscreenPageLimit(int r100) {
        if (r100 >= 1) goto L6;
        tt5.a.k("FixPageTransformerViewPager", "Requested offscreen page limit " + r100 + " too small; defaulting to 1");
        r100 = 1;
    L6:
        if (r100 == this.f240388v) goto L9;
        this.f240388v = r100;
        r();
        return;
    }

    public void setOnPageChangeListener(e r100) {
        this.R = r100;
    }

    public void setPageMargin(int r100) {
        int r101 = this.f240378l;
        this.f240378l = r100;
        int r102 = getWidth();
        t(r102, r102, r100, r101);
        requestLayout();
    }

    public void setPageMarginDrawable(Drawable r100) {
        this.f240379m = r100;
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
        if (this.f240377k0 != r100) goto L5;
        return;
    L5:
        this.f240377k0 = r100;
        int r101 = 0;
        if (this.S == null) goto L16;
        if (r100 == 0) goto L9;
        boolean r102 = true;
    L10:
        int r103 = getChildCount();
        int r104 = 0;
    L11:
        if (r104 >= r103) goto L16;
        if (r102 == false) goto L14;
        int r105 = this.T;
    L15:
        getChildAt(r104).setLayerType(r105, null);
        r104 = r104 + 1;
        goto L11
    L14:
        r105 = 0;
        goto L15
    L9:
        r102 = false;
    L16:
        e r106 = this.R;
        if (r106 == null) goto L19;
        r106.onPageScrollStateChanged(r100);
    L19:
        List<e> r107 = this.Q;
        if (r107 == null) goto L27;
        int r108 = ((ArrayList) r107).size();
    L22:
        if (r101 >= r108) goto L34;
        e r109 = (e) ListProtector.get(this.Q, r101);
        if (r109 == null) goto L26;
        r109.onPageScrollStateChanged(r100);
    L26:
        r101 = r101 + 1;
        goto L22
    L34:
        return;
    }

    @Override // android.view.View
    public final boolean verifyDrawable(Drawable r100) {
        if (super.verifyDrawable(r100) == false) goto L5;
    L8:
        return true;
    L5:
        if (r100 == this.f240379m) goto L8;
        return false;
    }

    public final void y(z r100) {
        boolean r101 = false;
        if (this.S == null) goto L5;
        boolean r102 = true;
    L6:
        if (true == r102) goto L8;
        r101 = true;
    L8:
        this.S = r100;
        setChildrenDrawingOrderEnabled(true);
        this.U = 2;
        this.T = 2;
        if (r101 == false) goto L12;
        r();
        return;
    L12:
        return;
    L5:
        r102 = false;
        goto L6
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams r100) {
        return generateDefaultLayoutParams();
    }

    public void setPageMarginDrawable(int r100) {
        setPageMarginDrawable(ContextCompat.getDrawable(getContext(), r100));
    }

    public FixPageTransformerViewPager(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.f240367b = new ArrayList();
        this.f240368c = new c();
        this.f240369d = new Rect();
        this.f240372g = -1;
        this.f240373h = null;
        this.f240382p = -3.4028235E38f;
        this.f240383q = Float.MAX_VALUE;
        this.f240388v = 1;
        this.F = -1;
        this.N = true;
        this.W = new a(this);
        this.f240377k0 = 0;
        l();
    }

    public final c a(int r100, int r101) {
        c r102 = new c();
        r102.f240405b = r100;
        r102.f240404a = this.f240370e.d(this, r100);
        this.f240370e.getClass();
        r102.f240407d = 1.0f;
        if (r101 >= 0) goto L5;
    L8:
        this.f240367b.add(r102);
    L9:
        return r102;
    L5:
        if (r101 >= this.f240367b.size()) goto L8;
        ListProtector.add(this.f240367b, r101, r102);
        goto L9
    }

    @Override // android.view.ViewGroup
    public final int getChildDrawingOrder(int r100, int r101) {
        if (this.U != 2) goto L6;
        r101 = (r100 - 1) - r101;
    L6:
        return ((LayoutParams) ((View) ListProtector.get(this.V, r101)).getLayoutParams()).f240398f;
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
        this.f240392z = Math.min(r112 / 10, this.f240391y);
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
        if (r106.f240393a == false) goto L48;
        int r107 = r106.f240394b;
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
        this.f240384r = View.MeasureSpec.makeMeasureSpec(r114, 1073741824);
        this.f240385s = true;
        r();
        this.f240385s = false;
        int r120 = getChildCount();
    L50:
        if (r100 >= r120) goto L59;
        View r121 = getChildAt(r100);
        if (r121.getVisibility() == 8) goto L58;
        LayoutParams r122 = (LayoutParams) r121.getLayoutParams();
        if (r122 != null) goto L56;
    L57:
        r121.measure(View.MeasureSpec.makeMeasureSpec((int) (r113 * r122.f240395c), 1073741824), this.f240384r);
        goto L58
    L56:
        if (r122.f240393a == false) goto L57;
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
        c r106 = i(r105);
        if (r106 == null) goto L16;
        if (r106.f240405b != this.f240371f) goto L16;
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
        this.f240387u = false;
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
        c r107 = i(r106);
        if (r107 == null) goto L14;
        if (r107.f240405b != this.f240371f) goto L14;
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
        boolean r104 = r103.f240393a;
        if (r100.getClass().getAnnotation(DecorView.class) == null) goto L8;
        boolean r105 = true;
    L9:
        boolean r106 = r104 | r105;
        r103.f240393a = r106;
        if (this.f240385s == false) goto L15;
        if (r106 == true) goto L14;
        r103.f240396d = true;
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
        if (this.P <= 0) goto L25;
        int r113 = getScrollX();
        int r101 = getPaddingLeft();
        int r102 = getPaddingRight();
        int r103 = getWidth();
        int r104 = getChildCount();
        int r105 = 0;
    L5:
        if (r105 >= r104) goto L25;
        View r106 = getChildAt(r105);
        LayoutParams r107 = (LayoutParams) r106.getLayoutParams();
        if (r107.f240393a == false) goto L24;
        int r108 = r107.f240394b & 7;
        if (r108 != 1) goto L12;
        int r109 = Math.max((r103 - r106.getMeasuredWidth()) / 2, r101);
    L19:
        int r114 = r109;
        int r115 = r101;
        r101 = r114;
    L20:
        int r116 = (r101 + r113) - r106.getLeft();
        if (r116 == 0) goto L23;
        r106.offsetLeftAndRight(r116);
    L23:
        r101 = r115;
        goto L24
    L12:
        if (r108 != 3) goto L14;
        r115 = r106.getWidth() + r101;
        goto L20
    L14:
        if (r108 == 5) goto L16;
        r115 = r101;
        goto L20
    L16:
        r109 = (r103 - r102) - r106.getMeasuredWidth();
        r102 = r102 + r106.getMeasuredWidth();
    L24:
        r105 = r105 + 1;
    L25:
        e r117 = this.R;
        if (r117 == null) goto L28;
        r117.a(r110, r111);
    L28:
        List<e> r118 = this.Q;
        if (r118 == null) goto L37;
        int r119 = ((ArrayList) r118).size();
    L31:
        if (r100 >= r119) goto L37;
        e r120 = (e) ListProtector.get(this.Q, r100);
        if (r120 == null) goto L35;
        r120.a(r110, r111);
    L35:
        r100 = r100 + 1;
    L37:
        if (this.S == null) goto L39;
        j.c(new op5.b(this));
    L39:
        this.O = true;
    }

    @Override // android.view.View
    public final void onSizeChanged(int r100, int r101, int r102, int r103) {
        super.onSizeChanged(r100, r101, r102, r103);
        if (r100 == r102) goto L6;
        int r104 = this.f240378l;
        t(r100, r102, r104, r104);
        return;
    }

    public final void t(int r100, int r101, int r102, int r103) {
        if (r101 > 0) goto L4;
    L9:
        c r104 = k(this.f240371f);
        if (r104 == null) goto L12;
        float r105 = Math.min(r104.f240408e, this.f240383q);
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
        if (this.f240367b.isEmpty() == true) goto L9;
        if (this.f240374i.isFinished() == true) goto L8;
        this.f240374i.setFinalX(getCurrentItem() * getClientWidth());
        return;
    L8:
        scrollTo((int) ((getScrollX() / (((r101 - getPaddingLeft()) - getPaddingRight()) + r103)) * (((r100 - getPaddingLeft()) - getPaddingRight()) + r102)), getScrollY());
    }

    public final void v(int r110, boolean r111, int r112, boolean r113) {
        c r100 = k(r110);
        if (r100 == null) goto L5;
        int r101 = (int) (getClientWidth() * Math.max(this.f240382p, Math.min(r100.f240408e, this.f240383q)));
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
        Scroller r114 = this.f240374i;
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
        this.f240375j = false;
        this.f240374i.startScroll(r102, r103, r104, r105, r109);
        ViewCompat.postInvalidateOnAnimation(this);
        goto L32
    L30:
        this.f240370e.getClass();
        r120 = (int) (((Math.abs(r104) / ((r118 * 1.0f) + this.f240378l)) + 1.0f) * 100.0f);
        goto L31
    L18:
        if (this.f240375j == false) goto L20;
        r116 = this.f240374i.getCurrX();
    L21:
        this.f240374i.abortAnimation();
        setScrollingCacheEnabled(false);
        goto L23
    L20:
        r116 = this.f240374i.getStartX();
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
        op5.a r104 = this.f240370e;
        boolean r105 = false;
        if (r104 != null) goto L5;
    L39:
        setScrollingCacheEnabled(false);
        return;
    L5:
        if (r104.b() <= 0) goto L39;
        if (r102 == true) goto L15;
        if (this.f240371f != r100) goto L15;
        if (this.f240367b.size() == 0) goto L15;
        setScrollingCacheEnabled(false);
        return;
    L15:
        if (r100 >= 0) goto L18;
        r100 = 0;
    L20:
        int r106 = this.f240388v;
        int r107 = this.f240371f;
        if (r100 <= (r107 + r106)) goto L23;
    L24:
        int r108 = 0;
    L26:
        if (r108 >= this.f240367b.size()) goto L29;
        ((c) ListProtector.get(this.f240367b, r108)).f240406c = true;
        r108 = r108 + 1;
    L29:
        if (this.f240371f == r100) goto L32;
        r105 = true;
    L32:
        if (this.N == false) goto L37;
        this.f240371f = r100;
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
        if (r100 < this.f240370e.b()) goto L20;
        r100 = this.f240370e.b() - 1;
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
        if (r114.f240393a == false) goto L32;
        int r115 = r114.f240394b;
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
        if (r126.f240393a == true) goto L45;
        c r127 = i(r125);
        if (r127 == null) goto L45;
        float r128 = r109;
        int r129 = ((int) (r127.f240408e * r128)) + r103;
        if (r126.f240396d == false) goto L44;
        r126.f240396d = false;
        r125.measure(View.MeasureSpec.makeMeasureSpec((int) (r128 * r126.f240395c), 1073741824), View.MeasureSpec.makeMeasureSpec((r102 - r104) - r106, 1073741824));
    L44:
        r125.layout(r129, r104, r125.getMeasuredWidth() + r129, r125.getMeasuredHeight() + r104);
    L45:
        r124 = r124 + 1;
        goto L34
    L46:
        this.f240380n = r104;
        this.f240381o = r102 - r106;
        this.P = r112;
        if (this.N == false) goto L49;
        boolean r130 = false;
        v(this.f240371f, false, 0, false);
    L50:
        this.N = r130;
        return;
    L49:
        r130 = false;
        goto L50
    }
}
