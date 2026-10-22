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
import androidx.camera.video.AudioStats;
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
import com.alipay.sdk.m.u.i;
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

/* JADX INFO: loaded from: classes14.dex */
public class VerticalViewPager extends ViewGroup {
    public static final int[] V0 = null;

    /* JADX INFO: renamed from: b1, reason: collision with root package name */
    public static final a f193751b1 = null;

    /* JADX INFO: renamed from: g1, reason: collision with root package name */
    public static final b f193752g1 = null;

    /* JADX INFO: renamed from: h1, reason: collision with root package name */
    public static final Field f193753h1 = null;
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
    public float f193754J;
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

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f193755a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f193756b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public List<com.bytedance.awemeopen.apps.framework.base.view.verticalviewPager.b> f193757c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f193758d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public double f193759e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public double f193760f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f193761g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final ArrayList<e> f193762h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final e f193763i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Rect f193764j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public PagerAdapter f193765k;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public final List<ViewPager.OnPageChangeListener> f193766k0;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f193767l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f193768m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public Parcelable f193769n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public ClassLoader f193770o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public Scroller f193771p;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    public Method f193772p0;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f193773q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public h f193774r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f193775s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public Drawable f193776t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f193777u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f193778v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public float f193779w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public float f193780x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f193781y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public boolean f193782z;

    public static class LayoutParams extends ViewGroup.LayoutParams {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f193783a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f193784b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public float f193785c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f193786d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f193787e;

        public LayoutParams() {
            super(-1, -1);
            this.f193785c = 0.0f;
        }

        public LayoutParams(Context r100, AttributeSet r101) {
            super(r100, r101);
            this.f193785c = 0.0f;
            TypedArray r102 = r100.obtainStyledAttributes(r101, VerticalViewPager.V0);
            this.f193784b = r102.getInteger(0, 48);
            r102.recycle();
        }
    }

    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f193788a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Parcelable f193789b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final ClassLoader f193790c;

        public static class a implements ParcelableCompatCreatorCallbacks<SavedState> {
            public a() {
            }

            @Override // androidx.core.os.ParcelableCompatCreatorCallbacks
            public final SavedState[] newArray(int r100) {
                return new SavedState[r100];
            }

            @Override // androidx.core.os.ParcelableCompatCreatorCallbacks
            public final SavedState createFromParcel(Parcel r100, ClassLoader r101) {
                return new SavedState(r100, r101);
            }
        }

        static {
            CREATOR = ParcelableCompat.newCreator(new a());
        }

        public final String toString() {
            return "FragmentPager.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " position=" + this.f193788a + i.f25855d;
        }

        public SavedState(Parcelable r100) {
            super(r100);
        }

        public SavedState(Parcel r100, ClassLoader r101) {
            super(r100);
            if (r101 != null) goto L5;
            r101 = getClass().getClassLoader();
        L5:
            this.f193788a = r100.readInt();
            this.f193789b = r100.readParcelable(r101);
            this.f193790c = r101;
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public final void writeToParcel(Parcel r100, int r101) {
            super.writeToParcel(r100, r101);
            r100.writeInt(this.f193788a);
            r100.writeParcelable(this.f193789b, r101);
        }
    }

    public static class a implements Comparator<e> {
        public a() {
        }

        @Override // java.util.Comparator
        public final int compare(e r100, e r101) {
            return r100.f193795b - r101.f193795b;
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
        public final /* synthetic */ VerticalViewPager f193791a;

        @Override // java.lang.Runnable
        public final void run() {
            VerticalViewPager.a(this.f193791a);     // Catch: Throwable -> L4
            this.f193791a.s();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public c(VerticalViewPager r100) {
            this.f193791a = r100;
        }
    }

    public class d implements OnApplyWindowInsetsListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Rect f193792a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ VerticalViewPager f193793b;

        public d(VerticalViewPager r100) {
            this.f193793b = r100;
            this.f193792a = new Rect();
        }

        @Override // androidx.core.view.OnApplyWindowInsetsListener
        public final WindowInsetsCompat onApplyWindowInsets(View r100, WindowInsetsCompat r101) {
            WindowInsetsCompat r102 = ViewCompat.onApplyWindowInsets(r100, r101);
            if (r102.isConsumed() == false) goto L5;
            return r102;
        L5:
            Rect r103 = this.f193792a;
            r103.left = r102.getSystemWindowInsetLeft();
            r103.top = r102.getSystemWindowInsetTop();
            r103.right = r102.getSystemWindowInsetRight();
            r103.bottom = r102.getSystemWindowInsetBottom();
            int r104 = this.f193793b.getChildCount();
            int r105 = 0;
        L6:
            if (r105 >= r104) goto L9;
            WindowInsetsCompat r106 = ViewCompat.dispatchApplyWindowInsets(this.f193793b.getChildAt(r105), r102);
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
        public Object f193794a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f193795b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f193796c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public float f193797d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public float f193798e;

        public e() {
        }
    }

    public class f extends AccessibilityDelegateCompat {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ VerticalViewPager f193799a;

        public f(VerticalViewPager r100) {
            this.f193799a = r100;
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public final void onInitializeAccessibilityEvent(View r100, AccessibilityEvent r101) {
            super.onInitializeAccessibilityEvent(r100, r101);
            r101.setClassName(ViewPager.class.getName());
            AccessibilityRecordCompat r102 = AccessibilityRecordCompat.obtain();
            PagerAdapter r103 = this.f193799a.f193765k;
            if (r103 == null) goto L7;
            boolean r104 = true;
            if (r103.getCount() <= 1) goto L7;
        L8:
            r102.setScrollable(r104);
            if (r101.getEventType() != 4096) goto L14;
            PagerAdapter r105 = this.f193799a.f193765k;
            if (r105 == null) goto L15;
            r102.setItemCount(r105.getCount());
            r102.setFromIndex(this.f193799a.f193767l);
            r102.setToIndex(this.f193799a.f193767l);
            return;
        L15:
            return;
        L14:
            return;
        L7:
            r104 = false;
            goto L8
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public final void onInitializeAccessibilityNodeInfo(View r100, AccessibilityNodeInfoCompat r101) {
            super.onInitializeAccessibilityNodeInfo(r100, r101);
            r101.setClassName(ViewPager.class.getName());
            PagerAdapter r102 = this.f193799a.f193765k;
            if (r102 != null) goto L5;
        L7:
            boolean r103 = false;
        L8:
            r101.setScrollable(r103);
            if (this.f193799a.canScrollVertically(1) == false) goto L12;
            r101.addAction(4096);
        L12:
            if (this.f193799a.canScrollVertically(-1) == false) goto L15;
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
            if (this.f193799a.canScrollVertically(-1) == false) goto L14;
            VerticalViewPager r103 = this.f193799a;
            r103.setCurrentItem(r103.f193767l - 1);
            return true;
        L14:
            return false;
        L16:
            if (this.f193799a.canScrollVertically(1) == false) goto L19;
            VerticalViewPager r104 = this.f193799a;
            r104.setCurrentItem(r104.f193767l + 1);
            return true;
        L19:
            return false;
        }
    }

    public interface g {
    }

    public class h extends DataSetObserver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ VerticalViewPager f193800a;

        @Override // android.database.DataSetObserver
        public final void onChanged() {
            this.f193800a.g();
        }

        @Override // android.database.DataSetObserver
        public final void onInvalidated() {
            this.f193800a.g();
        }

        public h(VerticalViewPager r100) {
            this.f193800a = r100;
        }
    }

    static {
        V0 = new int[]{R.attr.layout_gravity};
        f193751b1 = new a();
        f193752g1 = new b();
        Field r100 = PagerAdapter.class.getDeclaredField("mViewPagerObserver");     // Catch: NoSuchFieldException -> L5
        f193753h1 = r100;     // Catch: NoSuchFieldException -> L5
        r100.setAccessible(true);     // Catch: NoSuchFieldException -> L5
        return;
    L5:
        e = move-exception;
        throw new RuntimeException(e);
    }

    @Override // android.view.View
    public final void computeScroll() {
        this.f193773q = true;
        if (this.f193771p.isFinished() == false) goto L5;
    L14:
        f(true);
        return;
    L5:
        if (this.f193771p.computeScrollOffset() == false) goto L14;
        int r100 = getScrollX();
        int r101 = getScrollY();
        int r102 = this.f193771p.getCurrX();
        int r103 = this.f193771p.getCurrY();
        if (r100 != r102) goto L9;
        if (r101 != r103) goto L9;
    L12:
        ViewCompat.postInvalidateOnAnimation(this);
        return;
    L9:
        scrollTo(r102, r103);
        if (q(r103) == true) goto L12;
        this.f193771p.abortAnimation();
        scrollTo(r102, 0);
        goto L12
    }

    public final void n() {
        this.f193756b = true;
        setWillNotDraw(false);
        setDescendantFocusability(262144);
        setFocusable(true);
        Context r100 = getContext();
        this.f193771p = new Scroller(r100, f193752g1);
        ViewConfiguration r101 = ViewConfiguration.get(r100);
        Resources r102 = r100.getResources();
        float r103 = WindowDisplayMetricsOverride.apply(r102, r102.getDisplayMetrics()).density;
        this.H = ViewConfigurationCompat.getScaledPagingTouchSlop(r101);
        this.O = (int) (400.0f * r103);
        this.P = r101.getScaledMaximumFlingVelocity();
        this.S = new EdgeEffectCompat(r100);
        this.T = new EdgeEffectCompat(r100);
        this.Q = (int) (25.0f * r103);
        this.R = (int) (2.0f * r103);
        this.F = (int) (r103 * 16.0f);
        ViewCompat.setAccessibilityDelegate(this, new f(this));
        if (ViewCompat.getImportantForAccessibility(this) != 0) goto L5;
        ViewCompat.setImportantForAccessibility(this, 1);
    L5:
        ViewCompat.setOnApplyWindowInsetsListener(this, new d(this));
    }

    public void setOnAdapterChangeListener(g r100) {
    }

    public final boolean w() {
        this.M = -1;
        this.D = false;
        this.E = false;
        VelocityTracker r100 = this.N;
        if (r100 == null) goto L6;
        r100.recycle();
        this.N = null;
    L6:
        return this.S.onRelease() | this.T.onRelease();
    }

    public final void g() {
        int r100 = this.f193765k.getCount();
        this.f193758d = r100;
        if (this.f193762h.size() < ((this.C * 2) + 1)) goto L5;
    L7:
        boolean r101 = false;
    L8:
        int r102 = this.f193767l;
        int r103 = 0;
        boolean r104 = false;
    L10:
        if (r103 >= this.f193762h.size()) goto L30;
        e r105 = (e) ListProtector.get(this.f193762h, r103);
        int r106 = this.f193765k.getItemPosition(r105.f193794a);
        if (r106 == (-1)) goto L29;
        if (r106 != (-2)) goto L22;
        ListProtector.remove(this.f193762h, r103);
        r103 = r103 - 1;
        if (r104 == true) goto L19;
        this.f193765k.startUpdate(this);
        r104 = true;
    L19:
        this.f193765k.destroyItem(this, r105.f193795b, r105.f193794a);
        int r107 = this.f193767l;
        if (r107 != r105.f193795b) goto L28;
        r102 = Math.max(0, Math.min(r107, (-1) + r100));
    L28:
        r101 = true;
        goto L29
    L22:
        int r108 = r105.f193795b;
        if (r108 == r106) goto L29;
        if (r108 != this.f193767l) goto L27;
        r102 = r106;
    L27:
        r105.f193795b = r106;
    L29:
        r103 = r103 + 1;
        goto L10
    L30:
        if (r104 == false) goto L32;
        this.f193765k.finishUpdate(this);
    L32:
        Collections.sort(this.f193762h, f193751b1);
        if (r101 == false) goto L49;
        int r109 = getChildCount();
        int r110 = 0;
    L35:
        if (r110 >= r109) goto L40;
        LayoutParams r111 = (LayoutParams) getChildAt(r110).getLayoutParams();
        if (r111.f193783a == true) goto L39;
        r111.f193785c = 0.0f;
    L39:
        r110 = r110 + 1;
        goto L35
    L40:
        z(r102, false, true, 0);
        requestLayout();
        return;
    L49:
        return;
    L5:
        if (this.f193762h.size() >= r100) goto L7;
        r101 = true;
        goto L8
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams();
    }

    public final void m() {
        JSONObject r100 = AoSettings.a("ao_interactive_gesture_config");
        if (r100 != null) goto L6;
        return;
    L6:
        if (r100.optBoolean("enable_config", false) == true) goto L8;
        return;
    L8:
        this.f193759e = r100.optInt("interactive_gesture_angle", -1);
        this.f193761g = (float) r100.optDouble("interactive_gesture_distance_percent", AudioStats.AUDIO_AMPLITUDE_NONE);
        setLivePreviewScrollableAngle(this.f193759e);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        removeCallbacks(this.H0);
        Scroller r100 = this.f193771p;
        if (r100 != null) goto L5;
    L7:
        super.onDetachedFromWindow();
        return;
    L5:
        if (r100.isFinished() == true) goto L7;
        this.f193771p.abortAnimation();
        goto L7
    }

    public final void s() {
        t(this.f193767l);
    }

    private int getClientHeight() {
        return (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable r100 = this.f193776t;
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.isStateful() == false) goto L9;
        r100.setState(getDrawableState());
        return;
    }

    public final e k() {
        int r100 = getClientHeight();
        float r101 = 0.0f;
        if (r100 <= 0) goto L5;
        float r102 = getScrollY() / r100;
    L6:
        if (r100 <= 0) goto L8;
        float r103 = this.f193775s / r100;
    L9:
        e r104 = null;
        float r105 = 0.0f;
        int r106 = -1;
        int r107 = 0;
        boolean r108 = true;
    L11:
        if (r107 >= this.f193762h.size()) goto L30;
        e r110 = (e) ListProtector.get(this.f193762h, r107);
        if (r108 == true) goto L17;
        int r109 = r106 + 1;
        if (r110.f193795b == r109) goto L17;
        r110 = this.f193763i;
        r110.f193798e = (r101 + r105) + r103;
        r110.f193795b = r109;
        r110.f193797d = this.f193765k.getPageWidth(r109);
        r107 = r107 - 1;
    L17:
        e r111 = r110;
        r101 = r111.f193798e;
        float r112 = (r111.f193797d + r101) + r103;
        if (r108 == true) goto L24;
        if (r102 >= r101) goto L24;
        return r104;
    L24:
        if (r102 < r112) goto L29;
        if (r107 == (this.f193762h.size() - 1)) goto L29;
        int r113 = r111.f193795b;
        float r114 = r111.f193797d;
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
        this.U = true;
    }

    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        Parcelable r100 = super.onSaveInstanceState();
        if (AoEnv.j() == false) goto L5;
        return r100;
    L5:
        SavedState r101 = new SavedState(r100);
        r101.f193788a = this.f193767l;
        PagerAdapter r102 = this.f193765k;
        if (r102 == null) goto L8;
        r101.f193789b = r102.saveState();
    L8:
        return r101;
    }

    public PagerAdapter getAdapter() {
        return this.f193765k;
    }

    public int getCurrentItem() {
        return this.f193767l;
    }

    public int getExpectedAdapterCount() {
        return this.f193758d;
    }

    public int getOffscreenPageLimit() {
        return this.C;
    }

    public int getPageMargin() {
        return this.f193775s;
    }

    public VerticalViewPager(Context r100) {
        super(r100);
        this.f193755a = com.bytedance.awemeopen.apps.framework.feed.ui.information.a.f196003o;
        this.f193757c = null;
        this.f193759e = -1.0d;
        this.f193760f = 1.0d;
        this.f193761g = 0.0f;
        this.f193762h = new ArrayList();
        this.f193763i = new e();
        this.f193764j = new Rect();
        this.f193768m = -1;
        this.f193769n = null;
        this.f193770o = null;
        this.f193779w = -3.4028235E38f;
        this.f193780x = Float.MAX_VALUE;
        this.C = 1;
        this.M = -1;
        this.U = true;
        this.f193766k0 = new CopyOnWriteArrayList();
        this.H0 = new c(this);
        this.L0 = 0;
        this.P0 = false;
        n();
        m();
    }

    public static /* synthetic */ void a(VerticalViewPager r100) {
        r100.setScrollState(0);
    }

    private void setScrollState(int r100) {
        if (this.L0 != r100) goto L5;
        return;
    L5:
        this.L0 = r100;
        List<ViewPager.OnPageChangeListener> r101 = this.f193766k0;
        if (r101 != null) goto L8;
        return;
    L8:
        if (r101.isEmpty() == true) goto L15;
        Iterator<ViewPager.OnPageChangeListener> r102 = this.f193766k0.iterator();
    L11:
        if (r102.hasNext() == false) goto L16;
        r102.next().onPageScrollStateChanged(r100);
        goto L11
    L16:
        return;
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
        if (r103.f193795b != this.f193767l) goto L12;
        r102.addTouchables(r100);
    L12:
        r101 = r101 + 1;
        goto L4
    }

    public final void c(ViewPager.OnPageChangeListener r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        this.f193766k0.add(r100);
    }

    @Override // android.view.View
    public final boolean canScrollVertically(int r100) {
        if (this.f193765k != null) goto L5;
        return false;
    L5:
        int r101 = getClientHeight();
        int r102 = getScrollY();
        if (r100 < 0) goto L8;
        if (r100 > 0) goto L13;
        return false;
    L13:
        if (r102 >= ((int) (r101 * this.f193780x))) goto L18;
        return true;
    L18:
        return false;
    L8:
        if (r102 <= ((int) (r101 * this.f193779w))) goto L16;
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

    public final boolean d(int r100) {
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
        if (r107 == null) goto L42;
        if (r107 == r101) goto L42;
        if (r100 != 33) goto L32;
        int r108 = i(this.f193764j, r107).top;
        int r109 = i(this.f193764j, r101).top;
        if (r101 == null) goto L30;
        if (r108 < r109) goto L30;
        int r110 = this.f193767l;
        if (r110 <= 0) goto L56;
        y(r110 - 1, true);
    L57:
        r103 = r102;
    L58:
        if (r103 == false) goto L60;
        playSoundEffect(SoundEffectConstants.getContantForFocusDirection(r100));
    L60:
        return r103;
    L56:
        r102 = false;
    L30:
        boolean r111 = r107.requestFocus();
    L31:
        r103 = r111;
        goto L58
    L32:
        if (r100 != 130) goto L58;
        int r112 = i(this.f193764j, r107).bottom;
        int r113 = i(this.f193764j, r101).bottom;
        if (r101 == null) goto L41;
        if (r112 > r113) goto L41;
        PagerAdapter r114 = this.f193765k;
        if (r114 == null) goto L56;
        if (this.f193767l >= (r114.getCount() - 1)) goto L56;
        y(this.f193767l + 1, true);
    L41:
        r111 = r107.requestFocus();
    L42:
        if (r100 == 33) goto L53;
        if (r100 == 1) goto L53;
        if (r100 != 130) goto L47;
    L48:
        PagerAdapter r115 = this.f193765k;
        if (r115 == null) goto L56;
        if (this.f193767l >= (r115.getCount() - 1)) goto L56;
        y(this.f193767l + 1, true);
        goto L57
    L47:
        if (r100 != 2) goto L58;
    L53:
        int r116 = this.f193767l;
        if (r116 <= 0) goto L56;
        y(r116 - 1, true);
    L19:
        r101 = null;
        goto L20
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchKeyEvent(KeyEvent r100) {
        if (super.dispatchKeyEvent(r100) == false) goto L5;
        return true;
    L5:
        if (r100.getAction() != 0) goto L21;
        int r101 = r100.getKeyCode();
        if (r101 != 21) goto L9;
        boolean r102 = d(17);
    L22:
        if (r102 == true) goto L27;
        return false;
    L27:
        return true;
    L9:
        if (r101 != 22) goto L11;
        r102 = d(66);
        goto L22
    L11:
        if (r101 != 61) goto L21;
        if (r100.hasNoModifiers() == false) goto L17;
        r102 = d(2);
        goto L22
    L17:
        if (r100.hasModifiers(1) == false) goto L21;
        r102 = d(1);
    L21:
        r102 = false;
        goto L22
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
        if (r104.f193795b != this.f193767l) goto L18;
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
    public final boolean dispatchTouchEvent(MotionEvent r100) {
        List<com.bytedance.awemeopen.apps.framework.base.view.verticalviewPager.b> r101 = this.f193757c;
        if (r101 == null) goto L9;
        Iterator r102 = ((ArrayList) r101).iterator();
    L6:
        if (r102.hasNext() == false) goto L9;
        ((com.bytedance.awemeopen.apps.framework.base.view.verticalviewPager.b) r102.next()).a();
    L9:
        if (this.f193756b == true) goto L11;
    L13:
        return false;
    L11:
        if (super.dispatchTouchEvent(r100) == false) goto L13;
        return true;
    }

    @Override // android.view.View
    public final void draw(Canvas r100) {
        super.draw(r100);     // Catch: Exception -> L4
    L5:
        int r101 = ViewCompat.getOverScrollMode(this);
        boolean r102 = false;
        if (r101 == 0) goto L16;
        if (r101 != 1) goto L14;
        PagerAdapter r103 = this.f193765k;
        if (r103 == null) goto L14;
        if (r103.getCount() > 1) goto L16;
    L14:
        this.S.finish();
        this.T.finish();
    L21:
        if (r102 == false) goto L26;
        ViewCompat.postInvalidateOnAnimation(this);
        return;
    L26:
        return;
    L16:
        if (this.S.isFinished() == true) goto L19;
        int r104 = r100.save();
        int r105 = getHeight();
        int r106 = (getWidth() - getPaddingLeft()) - getPaddingRight();
        r100.translate(getPaddingLeft(), this.f193779w * r105);
        this.S.setSize(r106, r105);
        r102 = false | this.S.draw(r100);
        r100.restoreToCount(r104);
    L19:
        if (this.T.isFinished() == true) goto L21;
        int r107 = r100.save();
        int r108 = getHeight();
        int r109 = (getWidth() - getPaddingLeft()) - getPaddingRight();
        r100.rotate(180.0f);
        r100.translate((-r109) - getPaddingLeft(), (-(this.f193780x + 1.0f)) * r108);
        this.T.setSize(r109, r108);
        r102 = r102 | this.T.draw(r100);
        r100.restoreToCount(r107);
        goto L21
    }

    public final void f(boolean r100) {
        if (this.L0 != 2) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == false) goto L15;
        setScrollingCacheEnabled(false);
        if ((!this.f193771p.isFinished()) == false) goto L15;
        this.f193771p.abortAnimation();
        int r102 = getScrollX();
        int r103 = getScrollY();
        int r104 = this.f193771p.getCurrX();
        int r105 = this.f193771p.getCurrY();
        if (r102 != r104) goto L12;
        if (r103 == r105) goto L15;
    L12:
        scrollTo(r104, r105);
        if (r105 == r103) goto L15;
        q(r105);
    L15:
        this.B = false;
        int r106 = 0;
    L17:
        if (r106 >= this.f193762h.size()) goto L22;
        e r107 = (e) ListProtector.get(this.f193762h, r106);
        if (r107.f193796c == false) goto L21;
        r107.f193796c = false;
        r101 = true;
    L21:
        r106 = r106 + 1;
        goto L17
    L22:
        if (r101 == false) goto L30;
        if (r100 == false) goto L25;
        ViewCompat.postOnAnimation(this, this.H0);
        return;
    L25:
        this.H0.run();
        return;
    L30:
        return;
    L5:
        r101 = false;
        goto L6
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet r100) {
        return new LayoutParams(getContext(), r100);
    }

    public final e j(View r100) {
        int r101 = 0;
    L4:
        if (r101 >= this.f193762h.size()) goto L9;
        e r102 = (e) ListProtector.get(this.f193762h, r101);
        if (this.f193765k.isViewFromObject(r100, r102.f193794a) == true) goto L7;
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
        if (r101 >= this.f193762h.size()) goto L9;
        e r102 = (e) ListProtector.get(this.f193762h, r101);
        if (r102.f193795b == r100) goto L7;
        r101 = r101 + 1;
        goto L4
    L7:
        return r102;
    L9:
        return null;
    }

    @Override // android.view.View
    public final void onDraw(Canvas r110) {
        super.onDraw(r110);
        if (this.f193775s > 0) goto L5;
        return;
    L5:
        if (this.f193776t != null) goto L7;
        return;
    L7:
        if (this.f193762h.size() > 0) goto L9;
        return;
    L9:
        if (this.f193765k == null) goto L34;
        int r100 = getScrollY();
        int r101 = getHeight();
        float r102 = r101;
        float r103 = this.f193775s / r102;
        int r104 = 0;
        e r105 = (e) ListProtector.get(this.f193762h, 0);
        float r106 = r105.f193798e;
        int r107 = this.f193762h.size();
        int r108 = r105.f193795b;
        int r111 = ((e) ListProtector.get(this.f193762h, r107 - 1)).f193795b;
    L11:
        if (r108 >= r111) goto L35;
    L12:
        int r112 = r105.f193795b;
        if (r108 <= r112) goto L16;
        if (r104 >= r107) goto L16;
        r104 = r104 + 1;
        r105 = (e) ListProtector.get(this.f193762h, r104);
    L16:
        if (r108 != r112) goto L18;
        float r109 = r105.f193798e;
        float r113 = r105.f193797d;
        float r114 = (r109 + r113) * r102;
        r106 = (r109 + r113) + r103;
    L19:
        int r115 = this.f193775s;
        if ((r115 + r114) <= r100) goto L24;
        this.f193776t.setBounds(this.f193777u, (int) r114, this.f193778v, (int) ((r115 + r114) + 0.5f));
        this.f193776t.draw(r110);
    L24:
        if (r114 > (r100 + r101)) goto L36;
        r108 = r108 + 1;
        r103 = r103;
        goto L11
    L36:
        return;
    L18:
        float r116 = this.f193765k.getPageWidth(r108);
        r114 = (r106 + r116) * r102;
        r106 = r106 + (r116 + r103);
        goto L19
    L35:
        return;
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r110) {
        if (this.P0 == false) goto L104;
        return false;
    L104:
        int r100 = r110.getAction() & 255;     // Catch: IllegalArgumentException -> L100
        if (r100 != 3) goto L8;
    L97:
        w();     // Catch: IllegalArgumentException -> L100
        return false;
    L8:
        if (r100 == 1) goto L97;
        if (r100 == 0) goto L18;
        if (this.D == false) goto L15;
        return true;
    L15:
        if (this.E == false) goto L18;
        return false;
    L18:
        if (r100 == 0) goto L84;
        if (r100 != 2) goto L21;
        int r101 = this.M;     // Catch: IllegalArgumentException -> L100
        if (r101 == (-1)) goto L94;
        int r102 = r110.findPointerIndex(r101);     // Catch: IllegalArgumentException -> L100
        float r103 = r110.getY(r102);     // Catch: IllegalArgumentException -> L100
        float r104 = r103 - this.f193754J;     // Catch: IllegalArgumentException -> L100
        float r105 = Math.abs(r104);     // Catch: IllegalArgumentException -> L100
        float r106 = r110.getX(r102);     // Catch: IllegalArgumentException -> L100
        float r107 = Math.abs(r106 - this.K);     // Catch: IllegalArgumentException -> L100
        if (r104 == 0.0f) goto L44;
        float r111 = this.f193754J;     // Catch: IllegalArgumentException -> L100
        if (r111 >= this.G) goto L33;
        if (r104 <= 0.0f) goto L33;
    L36:
        boolean r108 = true;
    L38:
        if (r108 == true) goto L44;
        if (e(this, false, (int) r104, (int) r106, (int) r103) == false) goto L44;
        this.I = r106;     // Catch: IllegalArgumentException -> L100
        this.f193754J = r103;     // Catch: IllegalArgumentException -> L100
        this.E = true;     // Catch: IllegalArgumentException -> L100
        return false;
    L33:
        if (r111 > (getHeight() - this.G)) goto L35;
    L37:
        r108 = false;
        goto L38
    L35:
        if (r104 >= 0.0f) goto L37;
    L44:
        if (this.f193759e <= AudioStats.AUDIO_AMPLITUDE_NONE) goto L56;
        float r109 = this.H;     // Catch: IllegalArgumentException -> L100
        if (r105 > r109) goto L48;
    L50:
        boolean r112 = false;
    L52:
        if (r107 > r109) goto L54;
    L67:
        boolean r113 = false;
    L68:
        if (r112 == false) goto L77;
        this.D = true;     // Catch: IllegalArgumentException -> L100
        ViewParent r114 = getParent();     // Catch: IllegalArgumentException -> L100
        if (r114 == null) goto L72;
        r114.requestDisallowInterceptTouchEvent(true);     // Catch: IllegalArgumentException -> L100
    L72:
        setScrollState(1);     // Catch: IllegalArgumentException -> L100
        if (r104 <= 0.0f) goto L75;
        float r115 = this.L + this.H;     // Catch: IllegalArgumentException -> L100
    L76:
        this.f193754J = r115;     // Catch: IllegalArgumentException -> L100
        this.I = r106;     // Catch: IllegalArgumentException -> L100
        setScrollingCacheEnabled(true);     // Catch: IllegalArgumentException -> L100
    L80:
        if (this.D == false) goto L94;
        if (r(r103) == false) goto L94;
        ViewCompat.postInvalidateOnAnimation(this);     // Catch: IllegalArgumentException -> L100
        goto L94
    L75:
        r115 = this.L - this.H;     // Catch: IllegalArgumentException -> L100
        goto L76
    L77:
        if (r113 == false) goto L80;
        this.E = true;     // Catch: IllegalArgumentException -> L100
        goto L80
    L54:
        if (r105 >= (((double) r107) * this.f193760f)) goto L67;
    L65:
        r113 = true;
        goto L68
    L48:
        if (r105 < (((double) r107) * this.f193760f)) goto L50;
        r112 = true;
        goto L52
    L56:
        float r116 = this.H;     // Catch: IllegalArgumentException -> L100
        if (r105 > r116) goto L59;
    L61:
        boolean r117 = false;
    L63:
        if (r107 <= r116) goto L66;
        r112 = r117;
        goto L65
    L66:
        r112 = r117;
        goto L67
    L59:
        if ((r105 * 0.5f) <= r107) goto L61;
        r117 = true;
    L94:
        if (this.N != null) goto L96;
        this.N = VelocityTracker.obtain();     // Catch: IllegalArgumentException -> L100
    L96:
        this.N.addMovement(r110);     // Catch: IllegalArgumentException -> L100
    L103:
        return this.D;
    L21:
        if (r100 != 6) goto L94;
        p(r110);     // Catch: IllegalArgumentException -> L100
        goto L94
    L84:
        this.I = r110.getX();     // Catch: IllegalArgumentException -> L100
        this.K = r110.getX();     // Catch: IllegalArgumentException -> L100
        this.f193754J = r110.getY();     // Catch: IllegalArgumentException -> L100
        this.L = r110.getY();     // Catch: IllegalArgumentException -> L100
        this.M = r110.getPointerId(0);     // Catch: IllegalArgumentException -> L100
        this.E = false;     // Catch: IllegalArgumentException -> L100
        this.f193773q = true;     // Catch: IllegalArgumentException -> L100
        this.f193771p.computeScrollOffset();     // Catch: IllegalArgumentException -> L100
        if (this.L0 == 2) goto L87;
    L92:
        f(false);     // Catch: IllegalArgumentException -> L100
        this.D = false;     // Catch: IllegalArgumentException -> L100
        goto L94
    L87:
        if (Math.abs(this.f193771p.getFinalY() - this.f193771p.getCurrY()) <= this.R) goto L92;
        this.f193771p.abortAnimation();     // Catch: IllegalArgumentException -> L100
        this.B = false;     // Catch: IllegalArgumentException -> L100
        s();     // Catch: IllegalArgumentException -> L100
        this.D = true;     // Catch: IllegalArgumentException -> L100
        ViewParent r118 = getParent();     // Catch: IllegalArgumentException -> L100
        if (r118 == null) goto L91;
        r118.requestDisallowInterceptTouchEvent(true);     // Catch: IllegalArgumentException -> L100
    L91:
        setScrollState(1);     // Catch: IllegalArgumentException -> L100
    L100:
        e = move-exception;
        e.printStackTrace();
        goto L103
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable r100) {
        if ((r100 instanceof SavedState) == true) goto L6;
        super.onRestoreInstanceState(r100);
        return;
    L6:
        SavedState r101 = (SavedState) r100;
        super.onRestoreInstanceState(r101.getSuperState());
        PagerAdapter r102 = this.f193765k;
        if (r102 == null) goto L9;
        r102.restoreState(r101.f193789b, r101.f193790c);
        z(r101.f193788a, false, true, 0);
        return;
    L9:
        this.f193768m = r101.f193788a;
        this.f193769n = r101.f193789b;
        this.f193770o = r101.f193790c;
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r110) {
        boolean r100 = false;
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
        if (this.f193765k.getCount() == this.f193758d) goto L81;
        this.f193765k.notifyDataSetChanged();
    L81:
        e.printStackTrace();
        goto L84
    L7:
        if (r110.getAction() == 0) goto L9;
    L11:
        PagerAdapter r101 = this.f193765k;     // Catch: IllegalStateException -> L77 IllegalArgumentException -> L82
        if (r101 != null) goto L14;
    L76:
        return false;
    L14:
        if (r101.getCount() == 0) goto L76;
        if (this.N != null) goto L19;
        this.N = VelocityTracker.obtain();     // Catch: IllegalStateException -> L77 IllegalArgumentException -> L82
    L19:
        this.N.addMovement(r110);     // Catch: IllegalStateException -> L77 IllegalArgumentException -> L82
        int r102 = r110.getAction() & 255;     // Catch: IllegalStateException -> L77 IllegalArgumentException -> L82
        if (r102 == 0) goto L72;
        if (r102 == 1) goto L67;
        if (r102 == 2) goto L37;
        if (r102 == 3) goto L34;
        if (r102 != 5) goto L29;
        int r103 = r110.getActionIndex();     // Catch: IllegalStateException -> L77 IllegalArgumentException -> L82
        this.f193754J = r110.getY(r103);     // Catch: IllegalStateException -> L77 IllegalArgumentException -> L82
        this.M = r110.getPointerId(r103);     // Catch: IllegalStateException -> L77 IllegalArgumentException -> L82
    L73:
        if (r100 == false) goto L84;
        ViewCompat.postInvalidateOnAnimation(this);     // Catch: IllegalStateException -> L77 IllegalArgumentException -> L82
    L29:
        if (r102 != 6) goto L73;
        p(r110);     // Catch: IllegalStateException -> L77 IllegalArgumentException -> L82
        this.f193754J = r110.getY(r110.findPointerIndex(this.M));     // Catch: IllegalStateException -> L77 IllegalArgumentException -> L82
        goto L73
    L34:
        if (this.D == false) goto L73;
        x(this.f193767l, true, 0, false);     // Catch: IllegalStateException -> L77 IllegalArgumentException -> L82
        r100 = w();     // Catch: IllegalStateException -> L77 IllegalArgumentException -> L82
        goto L73
    L37:
        if (this.D == true) goto L64;
        int r104 = r110.findPointerIndex(this.M);     // Catch: IllegalStateException -> L77 IllegalArgumentException -> L82
        if (r104 != (-1)) goto L41;
        r100 = w();     // Catch: IllegalStateException -> L77 IllegalArgumentException -> L82
        goto L73
    L41:
        float r105 = r110.getY(r104);     // Catch: IllegalStateException -> L77 IllegalArgumentException -> L82
        float r106 = Math.abs(r105 - this.f193754J);     // Catch: IllegalStateException -> L77 IllegalArgumentException -> L82
        float r107 = r110.getX(r104);     // Catch: IllegalStateException -> L77 IllegalArgumentException -> L82
        float r108 = Math.abs(r107 - this.I);     // Catch: IllegalStateException -> L77 IllegalArgumentException -> L82
        if (this.f193759e <= AudioStats.AUDIO_AMPLITUDE_NONE) goto L47;
        if (r106 >= (((double) r108) * this.f193760f)) goto L48;
    L49:
        boolean r109 = false;
    L51:
        if (r106 <= this.H) goto L64;
        if (r109 == false) goto L64;
        this.D = true;     // Catch: IllegalStateException -> L77 IllegalArgumentException -> L82
        ViewParent r111 = getParent();     // Catch: IllegalStateException -> L77 IllegalArgumentException -> L82
        if (r111 == null) goto L56;
        r111.requestDisallowInterceptTouchEvent(true);     // Catch: IllegalStateException -> L77 IllegalArgumentException -> L82
    L56:
        float r112 = this.L;     // Catch: IllegalStateException -> L77 IllegalArgumentException -> L82
        if ((r105 - r112) <= 0.0f) goto L59;
        float r113 = r112 + this.H;     // Catch: IllegalStateException -> L77 IllegalArgumentException -> L82
    L60:
        this.f193754J = r113;     // Catch: IllegalStateException -> L77 IllegalArgumentException -> L82
        this.I = r107;     // Catch: IllegalStateException -> L77 IllegalArgumentException -> L82
        setScrollState(1);     // Catch: IllegalStateException -> L77 IllegalArgumentException -> L82
        setScrollingCacheEnabled(true);     // Catch: IllegalStateException -> L77 IllegalArgumentException -> L82
        ViewParent r114 = getParent();     // Catch: IllegalStateException -> L77 IllegalArgumentException -> L82
        if (r114 == null) goto L64;
        r114.requestDisallowInterceptTouchEvent(true);     // Catch: IllegalStateException -> L77 IllegalArgumentException -> L82
        goto L64
    L59:
        r113 = r112 - this.H;     // Catch: IllegalStateException -> L77 IllegalArgumentException -> L82
    L48:
        r109 = true;
        goto L51
    L47:
        if (r106 <= r108) goto L49;
    L64:
        if (this.D == false) goto L73;
        r100 = false | r(r110.getY(r110.findPointerIndex(this.M)));     // Catch: IllegalStateException -> L77 IllegalArgumentException -> L82
        goto L73
    L67:
        if (this.D == false) goto L73;
        VelocityTracker r115 = this.N;     // Catch: IllegalStateException -> L77 IllegalArgumentException -> L82
        r115.computeCurrentVelocity(1000, this.P);     // Catch: IllegalStateException -> L77 IllegalArgumentException -> L82
        int r116 = (int) VelocityTrackerCompat.getYVelocity(r115, this.M);     // Catch: IllegalStateException -> L77 IllegalArgumentException -> L82
        this.B = true;     // Catch: IllegalStateException -> L77 IllegalArgumentException -> L82
        int r117 = getClientHeight();     // Catch: IllegalStateException -> L77 IllegalArgumentException -> L82
        int r118 = getScrollY();     // Catch: IllegalStateException -> L77 IllegalArgumentException -> L82
        e r119 = k();     // Catch: IllegalStateException -> L77 IllegalArgumentException -> L82
        if (r119 == null) goto L71;
        float r120 = r117;
        z(h(r119.f193795b, ((r118 / r120) - r119.f193798e) / (r119.f193797d + (this.f193775s / r120)), r116, (int) (r110.getY(r110.findPointerIndex(this.M)) - this.L)), true, true, r116);     // Catch: IllegalStateException -> L77 IllegalArgumentException -> L82
    L71:
        r100 = w();     // Catch: IllegalStateException -> L77 IllegalArgumentException -> L82
        goto L73
    L72:
        this.f193771p.abortAnimation();     // Catch: IllegalStateException -> L77 IllegalArgumentException -> L82
        this.B = false;     // Catch: IllegalStateException -> L77 IllegalArgumentException -> L82
        s();     // Catch: IllegalStateException -> L77 IllegalArgumentException -> L82
        this.I = r110.getX();     // Catch: IllegalStateException -> L77 IllegalArgumentException -> L82
        this.K = r110.getX();     // Catch: IllegalStateException -> L77 IllegalArgumentException -> L82
        this.f193754J = r110.getY();     // Catch: IllegalStateException -> L77 IllegalArgumentException -> L82
        this.L = r110.getY();     // Catch: IllegalStateException -> L77 IllegalArgumentException -> L82
        this.M = r110.getPointerId(0);     // Catch: IllegalStateException -> L77 IllegalArgumentException -> L82
        goto L73
    L9:
        if (r110.getEdgeFlags() == 0) goto L11;
        return false;
    }

    public final void p(MotionEvent r100) {
        int r101 = r100.getActionIndex();
        if (r100.getPointerId(r101) != this.M) goto L11;
        if (r101 != 0) goto L6;
        int r102 = 1;
    L7:
        this.f193754J = r100.getY(r102);
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

    public final boolean q(int r100) {
        if (this.f193762h.size() == 0) goto L5;
        e r101 = k();
        int r102 = getClientHeight();
        int r103 = this.f193775s;
        int r104 = r102 + r103;
        float r105 = r102;
        float r106 = r103 / r105;
        if (r101 != null) goto L15;
        return false;
    L15:
        int r107 = r101.f193795b;
        float r108 = ((r100 / r105) - r101.f193798e) / (r101.f193797d + r106);
        this.V = false;
        o(r107, r108, (int) (r104 * r108));
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

    public final boolean r(float r110) {
        float r100 = this.f193754J - r110;
        this.f193754J = r110;
        float r111 = getScrollY() + r100;
        float r101 = getClientHeight();
        float r102 = this.f193779w * r101;
        float r103 = this.f193780x * r101;
        boolean r104 = false;
        if (this.f193762h.size() > 0) goto L5;
        return false;
    L5:
        e r105 = (e) ListProtector.get(this.f193762h, 0);
        ArrayList<e> r106 = this.f193762h;
        boolean r107 = true;
        e r108 = (e) ListProtector.get(r106, r106.size() - 1);
        if (r105.f193795b == 0) goto L8;
        r102 = r105.f193798e * r101;
        boolean r109 = false;
    L10:
        if (r108.f193795b == (this.f193765k.getCount() - 1)) goto L13;
        r103 = r108.f193798e * r101;
        r107 = false;
    L13:
        if (r111 >= r102) goto L18;
        if (r109 == false) goto L16;
        r104 = this.S.onPull(Math.abs(r102 - r111) / r101);
    L16:
        r111 = r102;
    L22:
        this.I += r111 - ((int) r111);
        int r112 = (int) r111;
        scrollTo(getScrollX(), r112);
        q(r112);
        return r104;
    L18:
        if (r111 <= r103) goto L22;
        if (r107 == false) goto L21;
        r104 = this.T.onPull(Math.abs(r111 - r103) / r101);
    L21:
        r111 = r103;
        goto L22
    L8:
        r109 = true;
        goto L10
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public final void removeView(View r100) {
        if (this.f193782z == false) goto L5;
        removeViewInLayout(r100);
        return;
    L5:
        super.removeView(r100);
    }

    public void setAdapter(PagerAdapter r100) {
        PagerAdapter r101 = this.f193765k;
        if (r101 != null) goto L43;
    L22:
        this.f193765k = r100;
        this.f193758d = 0;
        if (r100 != null) goto L25;
        return;
    L25:
        if (this.f193774r != null) goto L27;
        this.f193774r = new h(this);
    L27:
        PagerAdapter r102 = this.f193765k;
        h r103 = this.f193774r;
        Field r104 = f193753h1;     // Catch: IllegalAccessException -> L37
        if (r104 == null) goto L31;
        r104.set(r102, r103);     // Catch: IllegalAccessException -> L37
    L31:
        this.B = false;
        boolean r105 = this.U;
        this.U = true;
        this.f193758d = this.f193765k.getCount();
        if (this.f193768m < 0) goto L34;
        this.f193765k.restoreState(this.f193769n, this.f193770o);
        z(this.f193768m, false, true, 0);
        this.f193768m = -1;
        this.f193769n = null;
        this.f193770o = null;
        return;
    L34:
        if (r105 == true) goto L36;
        s();
        return;
    L36:
        requestLayout();
        return;
    L37:
        e = move-exception;
        throw new RuntimeException(e);
    L43:
        Field r106 = f193753h1;     // Catch: IllegalAccessException -> L19
        if (r106 == null) goto L7;
        r106.set(r101, null);     // Catch: IllegalAccessException -> L19
    L7:
        this.f193765k.startUpdate(this);
        int r107 = 0;
    L9:
        if (r107 >= this.f193762h.size()) goto L11;
        e r108 = (e) ListProtector.get(this.f193762h, r107);
        this.f193765k.destroyItem(this, r108.f193795b, r108.f193794a);
        r107 = r107 + 1;
        goto L9
    L11:
        this.f193765k.finishUpdate(this);
        this.f193762h.clear();
        int r109 = 0;
    L13:
        if (r109 >= getChildCount()) goto L18;
        if (((LayoutParams) getChildAt(r109).getLayoutParams()).f193783a == true) goto L17;
        removeViewAt(r109);
        r109 = r109 - 1;
    L17:
        r109 = r109 + 1;
        goto L13
    L18:
        this.f193767l = 0;
        scrollTo(0, 0);
    L19:
        e = move-exception;
        throw new RuntimeException(e);
    }

    public void setCanTouch(boolean r100) {
        this.f193756b = r100;
    }

    public void setChildrenDrawingOrderEnabledCompat(boolean r100) {
        if (this.f193772p0 == null) goto L13;
    L11:
        Method r101 = this.f193772p0;     // Catch: Exception -> L10
        if (r101 == null) goto L15;
        r101.invoke(this, new Object[]{Boolean.valueOf(r100)});     // Catch: Exception -> L10
        return;
    L15:
        return;
    L16:
        return;
    L13:
        this.f193772p0 = ViewGroup.class.getDeclaredMethod("setChildrenDrawingOrderEnabled", new Class[]{Boolean.TYPE});     // Catch: NoSuchMethodException -> L9
        goto L11
    }

    public void setCurrentItem(int r100) {
        this.B = false;
        z(r100, !this.U, false, 0);
    }

    public void setCurrentItemWithDefaultVelocity(int r100) {
        this.B = false;
        z(r100, true, true, 1);
    }

    public void setDefaultItem(int r100) {
        this.f193767l = r100;
    }

    public void setDisableScroll(boolean r100) {
        this.P0 = r100;
    }

    public void setLivePreviewScrollableAngle(double r100) {
        if (r100 > AudioStats.AUDIO_AMPLITUDE_NONE) goto L5;
    L7:
        this.f193759e = -1.0d;
        this.f193760f = 1.0d;
        return;
    L5:
        if (r100 >= 180.0d) goto L7;
        this.f193759e = r100;
        this.f193760f = Math.tan(Math.toRadians(90.0d - (r100 / 2.0d)));
    }

    public void setOffscreenPageLimit(int r100) {
        if (r100 >= 1) goto L6;
        r100 = 1;
    L6:
        if (r100 == this.C) goto L9;
        this.C = r100;
        s();
        return;
    }

    public void setPageMargin(int r100) {
        int r101 = this.f193775s;
        this.f193775s = r100;
        int r102 = getHeight();
        u(r102, r102, r100, r101);
        requestLayout();
    }

    public void setPageMarginDrawable(Drawable r100) {
        this.f193776t = r100;
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

    public void setScroller(Scroller r100) {
        this.f193771p = r100;
    }

    public void setmRestoredCurItem(int r100) {
        this.f193768m = r100;
    }

    public final void t(int r110) {
        int r100 = this.f193767l;
        if (r100 == r110) goto L8;
        if (r100 >= r110) goto L6;
        int r101 = 130;
    L7:
        e r102 = l(r100);
        this.f193767l = r110;
    L10:
        if (this.f193765k != null) goto L13;
        return;
    L13:
        if (this.B == false) goto L16;
        return;
    L16:
        if (getWindowToken() != null) goto L18;
        return;
    L18:
        this.f193765k.startUpdate(this);
        int r111 = this.C;
        int r103 = Math.max(0, this.f193767l - r111);
        int r104 = this.f193765k.getCount();
        int r112 = Math.min(r104 - 1, this.f193767l + r111);
        if (r104 != this.f193758d) goto L211;
        int r105 = 0;
    L22:
        if (r105 >= this.f193762h.size()) goto L28;
        e r106 = (e) ListProtector.get(this.f193762h, r105);
        int r107 = r106.f193795b;
        int r108 = this.f193767l;
        if (r107 >= r108) goto L25;
        r105 = r105 + 1;
        goto L22
    L25:
        if (r107 != r108) goto L28;
    L29:
        if (r106 != null) goto L32;
        if (r104 <= 0) goto L32;
        r106 = b(this.f193767l, r105);
    L32:
        if (r106 == null) goto L164;
        int r109 = r105 - 1;
        if (r109 < 0) goto L36;
        e r113 = (e) ListProtector.get(this.f193762h, r109);
    L37:
        int r114 = getClientHeight();
        if (r114 > 0) goto L40;
        float r115 = 0.0f;
    L41:
        int r116 = this.f193767l - 1;
        float r117 = 0.0f;
    L42:
        if (r116 < 0) goto L66;
        if (r117 < r115) goto L55;
        if (r116 >= r103) goto L55;
        if (r113 == null) goto L66;
        if (r116 != r113.f193795b) goto L65;
        if (r113.f193796c == true) goto L65;
        ListProtector.remove(this.f193762h, r109);
        this.f193765k.destroyItem(this, r116, r113.f193794a);
        r109 = r109 - 1;
        r105 = r105 - 1;
        if (r109 < 0) goto L64;
        r113 = (e) ListProtector.get(this.f193762h, r109);
    L64:
        r113 = null;
    L65:
        r116 = r116 - 1;
    L55:
        if (r113 != null) goto L57;
    L61:
        r117 = r117 + b(r116, r109 + 1).f193797d;
        r105 = r105 + 1;
        if (r109 < 0) goto L64;
        r113 = (e) ListProtector.get(this.f193762h, r109);
        goto L65
    L57:
        if (r116 != r113.f193795b) goto L61;
        r117 = r117 + r113.f193797d;
        r109 = r109 - 1;
        if (r109 < 0) goto L64;
        r113 = (e) ListProtector.get(this.f193762h, r109);
    L66:
        float r118 = r106.f193797d;
        int r119 = r105 + 1;
        if (r118 < 2.0f) goto L69;
    L100:
        int r120 = this.f193765k.getCount();
        int r121 = getClientHeight();
        if (r121 <= 0) goto L103;
        float r122 = this.f193775s / r121;
    L104:
        if (r102 == null) goto L136;
        int r123 = r102.f193795b;
        int r124 = r106.f193795b;
        if (r123 >= r124) goto L122;
        float r125 = (r102.f193798e + r102.f193797d) + r122;
        int r126 = r123 + 1;
        int r127 = 0;
    L109:
        if (r126 > r106.f193795b) goto L136;
        if (r127 >= this.f193762h.size()) goto L136;
        Object r128 = ListProtector.get(this.f193762h, r127);
    L113:
        e r129 = (e) r128;
        if (r126 <= r129.f193795b) goto L119;
        if (r127 >= (this.f193762h.size() - 1)) goto L119;
        r127 = r127 + 1;
        r128 = ListProtector.get(this.f193762h, r127);
    L119:
        if (r126 >= r129.f193795b) goto L121;
        r125 = r125 + (this.f193765k.getPageWidth(r126) + r122);
        r126 = r126 + 1;
        goto L119
    L121:
        r129.f193798e = r125;
        r125 = r125 + (r129.f193797d + r122);
        r126 = r126 + 1;
        goto L109
    L122:
        if (r123 <= r124) goto L136;
        int r130 = this.f193762h.size() - 1;
        float r131 = r102.f193798e;
    L124:
        r123 = r123 - 1;
        if (r123 < r106.f193795b) goto L136;
        if (r130 < 0) goto L136;
        Object r132 = ListProtector.get(this.f193762h, r130);
    L128:
        e r133 = (e) r132;
        if (r123 >= r133.f193795b) goto L133;
        if (r130 <= 0) goto L133;
        r130 = r130 - 1;
        r132 = ListProtector.get(this.f193762h, r130);
    L133:
        if (r123 <= r133.f193795b) goto L135;
        r131 = r131 - (this.f193765k.getPageWidth(r123) + r122);
        r123 = r123 - 1;
        goto L133
    L135:
        r131 = r131 - (r133.f193797d + r122);
        r133.f193798e = r131;
    L136:
        int r134 = this.f193762h.size();
        float r135 = r106.f193798e;
        int r136 = r106.f193795b;
        int r137 = r136 - 1;
        if (r136 != 0) goto L139;
        float r138 = r135;
    L140:
        this.f193779w = r138;
        int r139 = r120 - 1;
        if (r136 != r139) goto L143;
        float r140 = (r106.f193797d + r135) - 1.0f;
    L144:
        this.f193780x = r140;
        int r141 = r105 - 1;
    L145:
        if (r141 < 0) goto L154;
        e r142 = (e) ListProtector.get(this.f193762h, r141);
    L147:
        int r143 = r142.f193795b;
        if (r137 <= r143) goto L150;
        r135 = r135 - (this.f193765k.getPageWidth(r137) + r122);
        r137 = r137 - 1;
        goto L147
    L150:
        r135 = r135 - (r142.f193797d + r122);
        r142.f193798e = r135;
        if (r143 != 0) goto L153;
        this.f193779w = r135;
    L153:
        r141 = r141 - 1;
        r137 = r137 - 1;
        goto L145
    L154:
        float r144 = (r106.f193798e + r106.f193797d) + r122;
        int r145 = r106.f193795b;
    L155:
        r145 = r145 + 1;
        if (r119 >= r134) goto L164;
        e r146 = (e) ListProtector.get(this.f193762h, r119);
    L158:
        int r147 = r146.f193795b;
        if (r145 >= r147) goto L161;
        r144 = r144 + (this.f193765k.getPageWidth(r145) + r122);
        r145 = r145 + 1;
        goto L158
    L161:
        if (r147 != r139) goto L163;
        this.f193780x = (r146.f193797d + r144) - 1.0f;
    L163:
        r146.f193798e = r144;
        r144 = r144 + (r146.f193797d + r122);
        r119 = r119 + 1;
        goto L155
    L143:
        r140 = Float.MAX_VALUE;
        goto L144
    L139:
        r138 = -3.4028235E38f;
        goto L140
    L103:
        r122 = 0.0f;
        goto L104
    L69:
        if (r119 >= this.f193762h.size()) goto L71;
        e r148 = (e) ListProtector.get(this.f193762h, r119);
    L72:
        if (r114 > 0) goto L74;
        float r149 = 0.0f;
    L75:
        int r150 = this.f193767l + 1;
        int r151 = r119;
    L76:
        if (r150 >= r104) goto L100;
        if (r118 < r149) goto L89;
        if (r150 <= r112) goto L89;
        if (r148 == null) goto L100;
        if (r150 != r148.f193795b) goto L99;
        if (r148.f193796c == true) goto L99;
        ListProtector.remove(this.f193762h, r151);
        this.f193765k.destroyItem(this, r150, r148.f193794a);
        if (r151 >= this.f193762h.size()) goto L98;
        r148 = (e) ListProtector.get(this.f193762h, r151);
    L98:
        r148 = null;
    L99:
        r150 = r150 + 1;
    L89:
        if (r148 != null) goto L91;
    L95:
        e r152 = b(r150, r151);
        r151 = r151 + 1;
        r118 = r118 + r152.f193797d;
        if (r151 >= this.f193762h.size()) goto L98;
        r148 = (e) ListProtector.get(this.f193762h, r151);
        goto L99
    L91:
        if (r150 != r148.f193795b) goto L95;
        r118 = r118 + r148.f193797d;
        r151 = r151 + 1;
        if (r151 >= this.f193762h.size()) goto L98;
        r148 = (e) ListProtector.get(this.f193762h, r151);
        goto L99
    L74:
        r149 = (getPaddingRight() / r114) + 2.0f;
        goto L75
    L71:
        r148 = null;
        goto L72
    L40:
        r115 = (2.0f - r106.f193797d) + (getPaddingLeft() / r114);
        goto L41
    L36:
        r113 = null;
    L164:
        PagerAdapter r153 = this.f193765k;
        int r154 = this.f193767l;
        if (r106 == null) goto L167;
        Object r155 = r106.f193794a;
    L168:
        r153.setPrimaryItem(this, r154, r155);
        this.f193765k.finishUpdate(this);
        int r156 = getChildCount();
        int r157 = 0;
    L169:
        if (r157 >= r156) goto L179;
        View r158 = getChildAt(r157);
        LayoutParams r159 = (LayoutParams) r158.getLayoutParams();
        r159.f193787e = r157;
        if (r159.f193783a == true) goto L177;
        if (r159.f193785c != 0.0f) goto L177;
        e r160 = j(r158);
        if (r160 == null) goto L177;
        r159.f193785c = r160.f193797d;
        int r161 = r160.f193795b;
        r159.getClass();
    L177:
        r157 = r157 + 1;
        goto L169
    L179:
        if (hasFocus() == false) goto L205;
        View r162 = findFocus();
        if (r162 == null) goto L190;
    L182:
        Object r163 = r162.getParent();
        if (r163 == this) goto L189;
        if (r163 == null) goto L190;
        if ((r163 instanceof View) == false) goto L190;
        r162 = (View) r163;
        goto L182
    L189:
        e r164 = j(r162);
    L191:
        if (r164 != null) goto L193;
    L194:
        int r165 = 0;
    L196:
        if (r165 >= getChildCount()) goto L265;
        View r166 = getChildAt(r165);
        e r167 = j(r166);
        if (r167 == null) goto L204;
        if (r167.f193795b != this.f193767l) goto L204;
        if (r166.requestFocus(r101) == false) goto L204;
        return;
    L204:
        r165 = r165 + 1;
        goto L196
    L265:
        return;
    L193:
        if (r164.f193795b != this.f193767l) goto L194;
        return;
    L190:
        r164 = null;
        goto L191
    L205:
        return;
    L167:
        r155 = null;
    L28:
        r106 = null;
        goto L29
    L211:
        String r168 = getResources().getResourceName(getId());     // Catch: Resources.NotFoundException -> L208
    L210:
        throw new IllegalStateException("The application's PagerAdapter changed the adapter's contents without calling PagerAdapter#notifyDataSetChanged! Expected adapter item count: " + this.f193758d + ", found: " + r104 + " Pager id: " + r168 + " Pager class: " + getClass() + " Problematic adapter: " + this.f193765k.getClass());
    L208:
        r168 = Integer.toHexString(getId());
        goto L210
    L6:
        r101 = 33;
        goto L7
    L8:
        r101 = 2;
        r102 = null;
        goto L10
    }

    public final void v(ViewPager.OnPageChangeListener r100) {
        List<ViewPager.OnPageChangeListener> r101 = this.f193766k0;
        if (r101 == null) goto L6;
        r101.remove(r100);
        return;
    }

    @Override // android.view.View
    public final boolean verifyDrawable(Drawable r100) {
        if (super.verifyDrawable(r100) == false) goto L5;
    L8:
        return true;
    L5:
        if (r100 == this.f193776t) goto L8;
        return false;
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams r100) {
        return generateDefaultLayoutParams();
    }

    public void setPageMarginDrawable(int r100) {
        setPageMarginDrawable(getContext().getResources().getDrawable(r100));
    }

    public VerticalViewPager(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.f193755a = com.bytedance.awemeopen.apps.framework.feed.ui.information.a.f196003o;
        this.f193757c = null;
        this.f193759e = -1.0d;
        this.f193760f = 1.0d;
        this.f193761g = 0.0f;
        this.f193762h = new ArrayList();
        this.f193763i = new e();
        this.f193764j = new Rect();
        this.f193768m = -1;
        this.f193769n = null;
        this.f193770o = null;
        this.f193779w = -3.4028235E38f;
        this.f193780x = Float.MAX_VALUE;
        this.C = 1;
        this.M = -1;
        this.U = true;
        this.f193766k0 = new CopyOnWriteArrayList();
        this.H0 = new c(this);
        this.L0 = 0;
        this.P0 = false;
        n();
        m();
    }

    public final e b(int r100, int r101) {
        e r102 = new e();
        r102.f193795b = r100;
        r102.f193794a = this.f193765k.instantiateItem(this, r100);
        r102.f193797d = this.f193765k.getPageWidth(r100);
        if (r101 >= 0) goto L5;
    L8:
        this.f193762h.add(r102);
    L9:
        return r102;
    L5:
        if (r101 >= this.f193762h.size()) goto L8;
        ListProtector.add(this.f193762h, r101, r102);
        goto L9
    }

    @Override // android.view.ViewGroup
    public final int getChildDrawingOrder(int r100, int r101) {
        return ((LayoutParams) ((View) ListProtector.get(null, r101)).getLayoutParams()).f193787e;
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
        int r112 = getMeasuredHeight();
        this.G = Math.min(r112 / 10, this.F);
        int r113 = (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
        int r114 = (r112 - getPaddingTop()) - getPaddingBottom();
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
        if (r106.f193783a == false) goto L48;
        int r107 = r106.f193784b;
        int r108 = r107 & 7;
        int r109 = r107 & 112;
        if (r109 != 48) goto L14;
    L17:
        boolean r115 = true;
    L19:
        if (r108 != 8388611) goto L21;
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
        if (r108 == 8388613) goto L24;
        r103 = false;
        goto L24
    L14:
        if (r109 == 80) goto L17;
        r115 = false;
    L48:
        r102 = r102 + 1;
        goto L3
    L49:
        this.f193781y = View.MeasureSpec.makeMeasureSpec(r113, 1073741824);
        View.MeasureSpec.makeMeasureSpec(r114, 1073741824);
        this.f193782z = true;
        s();
        this.f193782z = false;
        int r120 = getChildCount();
    L50:
        if (r100 >= r120) goto L59;
        View r121 = getChildAt(r100);
        if (r121.getVisibility() == 8) goto L58;
        LayoutParams r122 = (LayoutParams) r121.getLayoutParams();
        if (r122 != null) goto L56;
    L57:
        r121.measure(this.f193781y, View.MeasureSpec.makeMeasureSpec((int) (r114 * r122.f193785c), 1073741824));
        goto L58
    L56:
        if (r122.f193783a == false) goto L57;
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
        if (r106.f193795b != this.f193767l) goto L16;
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

    public final void y(int r100, boolean r101) {
        this.B = false;
        z(r100, r101, false, 0);
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
        if (r107.f193795b != this.f193767l) goto L14;
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
        boolean r104 = r103.f193783a | false;
        r103.f193783a = r104;
        if (this.f193782z == false) goto L11;
        if (r104 == true) goto L10;
        r103.f193786d = true;
        addViewInLayout(r100, r101, r102);
        return;
    L10:
        throw new IllegalStateException("Cannot add pager decor view during layout");
    L11:
        super.addView(r100, r101, r102);
    }

    public final void o(int r110, float r111, int r112) {
        if (this.W <= 0) goto L25;
        int r100 = getScrollY();
        int r101 = getPaddingTop();
        int r102 = getPaddingBottom();
        int r103 = getHeight();
        int r104 = getChildCount();
        int r105 = 0;
    L5:
        if (r105 >= r104) goto L25;
        View r106 = getChildAt(r105);
        LayoutParams r107 = (LayoutParams) r106.getLayoutParams();
        if (r107.f193783a == false) goto L24;
        int r108 = r107.f193784b & 112;
        if (r108 != 16) goto L12;
        int r109 = Math.max((r103 - r106.getMeasuredHeight()) / 2, r101);
    L19:
        int r113 = r109;
        int r114 = r101;
        r101 = r113;
    L20:
        int r115 = (r101 + r100) - r106.getTop();
        if (r115 == 0) goto L23;
        r106.offsetTopAndBottom(r115);
    L23:
        r101 = r114;
        goto L24
    L12:
        if (r108 != 48) goto L14;
        r114 = r106.getHeight() + r101;
        goto L20
    L14:
        if (r108 == 80) goto L16;
        r114 = r101;
        goto L20
    L16:
        r109 = (r103 - r102) - r106.getMeasuredHeight();
        r102 = r102 + r106.getMeasuredHeight();
    L24:
        r105 = r105 + 1;
    L25:
        List<ViewPager.OnPageChangeListener> r116 = this.f193766k0;
        if (r116 != null) goto L28;
    L33:
        this.V = true;
        return;
    L28:
        if (r116.isEmpty() == true) goto L33;
        Iterator<ViewPager.OnPageChangeListener> r117 = this.f193766k0.iterator();
    L31:
        if (r117.hasNext() == false) goto L33;
        r117.next().onPageScrolled(r110, r111, r112);
        goto L31
    }

    public final int h(int r100, float r101, int r102, int r103) {
        if (Math.abs(r103) <= this.Q) goto L10;
        if (Math.abs(r102) <= this.O) goto L10;
        if (r102 > 0) goto L21;
        r100 = r100 + 1;
    L21:
        if (this.f193762h.size() <= 0) goto L24;
        e r104 = (e) ListProtector.get(this.f193762h, 0);
        ArrayList<e> r105 = this.f193762h;
        return Math.max(r104.f193795b, Math.min(r100, ((e) ListProtector.get(r105, r105.size() - 1)).f193795b));
    L24:
        return r100;
    L10:
        if (r100 < this.f193767l) goto L12;
        float r106 = 0.6f;
    L14:
        if (Float.compare(this.f193761g, 0.0f) > 0) goto L16;
    L19:
        r100 = (int) ((r100 + r101) + r106);
        goto L21
    L16:
        if (r100 < this.f193767l) goto L18;
        r106 = 1.0f - this.f193761g;
        goto L19
    L18:
        r106 = this.f193761g;
        goto L19
    L12:
        r106 = 0.4f;
        goto L14
    }

    @Override // android.view.View
    public final void onSizeChanged(int r100, int r101, int r102, int r103) {
        super.onSizeChanged(r100, r101, r102, r103);
        if (r101 == r103) goto L6;
        int r104 = this.f193775s;
        u(r101, r103, r104, r104);
        return;
    }

    public final void u(int r100, int r110, int r111, int r112) {
        float r101 = 0.0f;
        if (r110 > 0) goto L5;
    L23:
        e r113 = l(this.f193767l);
        if (r113 == null) goto L26;
        r101 = Math.min(r113.f193798e, this.f193780x);
    L26:
        int r102 = (int) (r101 * ((r100 - getPaddingTop()) - getPaddingBottom()));
        if (r102 == getScrollY()) goto L34;
        f(false);
        scrollTo(getScrollX(), r102);
        return;
    L34:
        return;
    L5:
        if (this.f193762h.isEmpty() == true) goto L23;
        int r103 = ((r100 - getPaddingTop()) - getPaddingBottom()) + r111;
        int r114 = ((r110 - getPaddingTop()) - getPaddingBottom()) + r112;
        if (this.f193771p.isFinished() == false) goto L9;
        scrollTo(getScrollX(), (int) ((getScrollY() / r114) * r103));
        return;
    L9:
        if (this.f193755a == true) goto L11;
        this.f193771p.setFinalY(getCurrentItem() * getClientHeight());
        return;
    L11:
        int r115 = getScrollY();
        if (r114 <= 0) goto L14;
        r101 = r115 / r114;
    L14:
        float r104 = r103;
        int r105 = (int) (r101 * r104);
        int r116 = this.f193771p.getFinalY();
        if (r114 <= 0) goto L17;
        r116 = (int) ((r116 / r114) * r104);
    L17:
        int r106 = Math.max(0, this.f193771p.getDuration() - this.f193771p.timePassed());
        this.f193771p.abortAnimation();
        scrollTo(getScrollX(), r105);
        if (r106 <= 0) goto L21;
        if (r116 == r105) goto L21;
        this.f193773q = false;
        this.f193771p.startScroll(getScrollX(), r105, 0, r116 - r105, r106);
        ViewCompat.postInvalidateOnAnimation(this);
        return;
    L21:
        scrollTo(getScrollX(), r116);
    }

    public final void x(int r110, boolean r111, int r112, boolean r113) {
        e r100 = l(r110);
        if (r100 == null) goto L5;
        int r101 = (int) (getClientHeight() * Math.max(this.f193779w, Math.min(r100.f193798e, this.f193780x)));
    L6:
        if (r111 == true) goto L8;
        if (r113 == false) goto L50;
        List<ViewPager.OnPageChangeListener> r102 = this.f193766k0;
        if (r102 == null) goto L50;
        if (((CopyOnWriteArrayList) r102).isEmpty() == true) goto L50;
        Iterator r103 = ((CopyOnWriteArrayList) this.f193766k0).iterator();
    L48:
        if (r103.hasNext() == false) goto L50;
        ((ViewPager.OnPageChangeListener) r103.next()).onPageSelected(r110);
    L50:
        f(false);
        scrollTo(0, r101);
        q(r101);
        return;
    L8:
        if (getChildCount() != 0) goto L10;
        setScrollingCacheEnabled(false);
    L32:
        if (r113 == false) goto L54;
        List<ViewPager.OnPageChangeListener> r104 = this.f193766k0;
        if (r104 != null) goto L36;
        return;
    L36:
        if (((CopyOnWriteArrayList) r104).isEmpty() == true) goto L56;
        Iterator r105 = ((CopyOnWriteArrayList) this.f193766k0).iterator();
    L39:
        if (r105.hasNext() == false) goto L57;
        ((ViewPager.OnPageChangeListener) r105.next()).onPageSelected(r110);
        goto L39
    L57:
        return;
    L56:
        return;
    L54:
        return;
    L10:
        Scroller r106 = this.f193771p;
        if (r106 != null) goto L13;
    L15:
        boolean r107 = false;
    L16:
        if (r107 == true) goto L18;
        int r108 = getScrollY();
    L23:
        int r109 = r108;
        int r114 = getScrollX();
        int r115 = 0 - r114;
        int r116 = r101 - r109;
        if (r115 != 0) goto L27;
        if (r116 != 0) goto L27;
        f(false);
        s();
        setScrollState(0);
    L27:
        setScrollingCacheEnabled(true);
        setScrollState(2);
        int r117 = getClientHeight();
        int r118 = r117 / 2;
        float r119 = r117;
        float r120 = r118;
        float r121 = r120 + (((float) Math.sin((float) (((double) (Math.min(1.0f, (Math.abs(r115) * 1.0f) / r119) - 0.5f)) * 0.4712389167638204d))) * r120);
        int r122 = Math.abs(r112);
        if (r122 <= 0) goto L30;
        int r123 = Math.round(Math.abs(r121 / r122) * 1000.0f) * 4;
    L31:
        int r124 = Math.min(r123, 600);
        this.f193773q = false;
        this.f193771p.startScroll(r114, r109, r115, r116, r124);
        ViewCompat.postInvalidateOnAnimation(this);
        goto L32
    L30:
        r123 = (int) (((Math.abs(r115) / ((r119 * this.f193765k.getPageWidth(this.f193767l)) + this.f193775s)) + 1.0f) * 100.0f);
        goto L31
    L18:
        if (this.f193773q == false) goto L20;
        r108 = this.f193771p.getCurrY();
    L21:
        this.f193771p.abortAnimation();
        setScrollingCacheEnabled(false);
        goto L23
    L20:
        r108 = this.f193771p.getStartY();
        goto L21
    L13:
        if (r106.isFinished() == true) goto L15;
        r107 = true;
        goto L16
    L5:
        r101 = 0;
        goto L6
    }

    public final void z(int r100, boolean r101, boolean r102, int r103) {
        PagerAdapter r104 = this.f193765k;
        boolean r105 = false;
        if (r104 != null) goto L5;
    L46:
        setScrollingCacheEnabled(false);
        return;
    L5:
        if (r104.getCount() <= 0) goto L46;
        if (r102 == true) goto L15;
        if (this.f193767l != r100) goto L15;
        if (this.f193762h.size() == 0) goto L15;
        setScrollingCacheEnabled(false);
        return;
    L15:
        if (r100 >= 0) goto L18;
        r100 = 0;
    L20:
        int r106 = this.C;
        int r107 = this.f193767l;
        if (r100 <= (r107 + r106)) goto L23;
    L24:
        int r108 = 0;
    L26:
        if (r108 >= this.f193762h.size()) goto L29;
        ((e) ListProtector.get(this.f193762h, r108)).f193796c = true;
        r108 = r108 + 1;
    L29:
        if (this.f193767l == r100) goto L32;
        r105 = true;
    L32:
        if (this.U == false) goto L44;
        this.f193767l = r100;
        if (r105 == false) goto L43;
        List<ViewPager.OnPageChangeListener> r109 = this.f193766k0;
        if (r109 == null) goto L43;
        if (((CopyOnWriteArrayList) r109).isEmpty() == true) goto L43;
        Iterator r110 = ((CopyOnWriteArrayList) this.f193766k0).iterator();
    L41:
        if (r110.hasNext() == false) goto L43;
        ((ViewPager.OnPageChangeListener) r110.next()).onPageSelected(r100);
    L43:
        requestLayout();
        return;
    L44:
        t(r100);
        x(r100, r101, r103, r105);
        return;
    L23:
        if (r100 >= (r107 - r106)) goto L29;
    L18:
        if (r100 < this.f193765k.getCount()) goto L20;
        r100 = this.f193765k.getCount() - 1;
        goto L20
    }

    public static boolean e(View r100, boolean r110, int r111, int r112, int r113) {
        if ((r100 instanceof ViewGroup) == false) goto L18;
        ViewGroup r101 = (ViewGroup) r100;
        int r102 = r100.getScrollX();
        int r103 = r100.getScrollY();
        int r104 = r101.getChildCount() - 1;
    L5:
        if (r104 < 0) goto L18;
        View r105 = r101.getChildAt(r104);
        int r106 = r113 + r103;
        if (r106 < r105.getTop()) goto L17;
        if (r106 >= r105.getBottom()) goto L17;
        int r107 = r112 + r102;
        if (r107 < r105.getLeft()) goto L17;
        if (r107 >= r105.getRight()) goto L17;
        if (e(r105, true, r111, r107 - r105.getLeft(), r106 - r105.getTop()) == false) goto L17;
        return true;
    L17:
        r104 = r104 - 1;
    L18:
        if (r110 == true) goto L20;
    L22:
        return false;
    L20:
        if (ViewCompat.canScrollVertically(r100, -r111) == false) goto L22;
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
        int r107 = getScrollY();
        int r111 = 0;
        int r112 = 0;
    L4:
        if (r111 >= r100) goto L33;
        View r113 = getChildAt(r111);
        if (r113.getVisibility() == 8) goto L32;
        LayoutParams r114 = (LayoutParams) r113.getLayoutParams();
        if (r114.f193783a == false) goto L32;
        int r115 = r114.f193784b;
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
        int r108 = r104 + r107;
        r113.layout(r103, r108, r113.getMeasuredWidth() + r103, r108 + r113.getMeasuredHeight());
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
        if (r116 != 8388611) goto L14;
        r120 = r113.getMeasuredWidth() + r103;
        goto L21
    L14:
        if (r116 == 8388613) goto L16;
        r120 = r103;
        goto L21
    L16:
        r118 = (r101 - r105) - r113.getMeasuredWidth();
        r105 = r105 + r113.getMeasuredWidth();
    L32:
        r111 = r111 + 1;
        goto L4
    L33:
        int r109 = (r102 - r104) - r106;
        int r124 = 0;
    L34:
        if (r124 >= r100) goto L45;
        View r125 = getChildAt(r124);
        if (r125.getVisibility() == 8) goto L44;
        LayoutParams r126 = (LayoutParams) r125.getLayoutParams();
        e r127 = j(r125);
        if (r126.f193783a == true) goto L44;
        if (r127 == null) goto L44;
        float r128 = r109;
        int r129 = ((int) (r127.f193798e * r128)) + r104;
        if (r126.f193786d == false) goto L43;
        r126.f193786d = false;
        r125.measure(View.MeasureSpec.makeMeasureSpec((r101 - r103) - r105, 1073741824), View.MeasureSpec.makeMeasureSpec((int) (r128 * r126.f193785c), 1073741824));
    L43:
        r125.layout(r103, r129, r125.getMeasuredWidth() + r103, r125.getMeasuredHeight() + r129);
    L44:
        r124 = r124 + 1;
        goto L34
    L45:
        this.f193777u = r103;
        this.f193778v = r101 - r105;
        this.W = r112;
        if (this.U == false) goto L48;
        boolean r130 = false;
        x(this.f193767l, false, 0, false);
    L49:
        this.U = r130;
        return;
    L48:
        r130 = false;
        goto L49
    }
}
