package com.bytedance.locallife.live.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.math.MathUtils;
import androidx.core.view.ViewCompat;
import androidx.customview.view.AbsSavedState;
import androidx.customview.widget.ViewDragHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: loaded from: classes21.dex */
public class BottomSheetBehavior<V extends View> extends CoordinatorLayout.Behavior<V> {
    public boolean A;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f260740a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f260741b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f260742c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f260743d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f260744e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f260745f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f260746g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f260747h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f260748i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f260749j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f260750k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f260751l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public ViewDragHelper f260752m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f260753n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f260754o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f260755p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f260756q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public WeakReference<V> f260757r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public WeakReference<View> f260758s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public b f260759t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public VelocityTracker f260760u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f260761v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f260762w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f260763x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public Map<View, Integer> f260764y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final c f260765z;

    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f260766a;

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

        public SavedState(Parcel r100, ClassLoader r101) {
            super(r100, r101);
            this.f260766a = r100.readInt();
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public final void writeToParcel(Parcel r100, int r101) {
            super.writeToParcel(r100, r101);
            r100.writeInt(this.f260766a);
        }

        public SavedState(Parcelable r100, int r101) {
            super(r100);
            this.f260766a = r101;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface State {
    }

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f260767a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f260768b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ BottomSheetBehavior f260769c;

        @Override // java.lang.Runnable
        public final void run() {
            this.f260769c.startSettlingAnimation(this.f260767a, this.f260768b);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public a(BottomSheetBehavior r100, View r101, int r102) {
            this.f260769c = r100;
            this.f260767a = r101;
            this.f260768b = r102;
        }
    }

    public static abstract class b {
        public abstract void a(View r100);

        public abstract void b(View r100, int r101);

        public b() {
        }
    }

    public class c extends ViewDragHelper.Callback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BottomSheetBehavior f260770a;

        public c(BottomSheetBehavior r100) {
            this.f260770a = r100;
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public final int getViewVerticalDragRange(View r100) {
            BottomSheetBehavior r101 = this.f260770a;
            if (r101.f260749j == false) goto L6;
            return r101.f260756q;
        L6:
            return r101.f260748i;
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public final void onViewDragStateChanged(int r100) {
            if (r100 != 1) goto L6;
            this.f260770a.setStateInternal(1);
            return;
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public final boolean tryCaptureView(View r100, int r101) {
            BottomSheetBehavior r102 = this.f260770a;
            int r103 = r102.f260751l;
            if (r103 != 1) goto L6;
            return false;
        L6:
            if (r102.f260763x == false) goto L9;
            return false;
        L9:
            if (r103 == 3) goto L11;
        L17:
            WeakReference<V> r104 = this.f260770a.f260757r;
            if (r104 != null) goto L20;
            return false;
        L20:
            if (r104.get() != r100) goto L24;
            return true;
        L24:
            return false;
        L11:
            if (r102.f260761v != r101) goto L17;
            View r105 = r102.f260758s.get();
            if (r105 == null) goto L17;
            if (r105.canScrollVertically(-1) == false) goto L17;
            return false;
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public final int clampViewPositionHorizontal(View r100, int r101, int r102) {
            return r100.getLeft();
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public final int clampViewPositionVertical(View r100, int r101, int r102) {
            int r103 = this.f260770a.getExpandedOffset();
            BottomSheetBehavior r104 = this.f260770a;
            if (r104.f260749j == false) goto L5;
            int r105 = r104.f260756q;
        L7:
            return MathUtils.clamp(r101, r103, r105);
        L5:
            r105 = r104.f260748i;
            goto L7
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public final void onViewReleased(View r100, float r101, float r102) {
            int r103 = 0;
            int r104 = 6;
            if (r102 >= 0.0f) goto L11;
            BottomSheetBehavior r105 = this.f260770a;
            if (r105.f260740a == false) goto L8;
            r103 = r105.f260746g;
        L7:
            r104 = 3;
        L44:
            if (this.f260770a.f260752m.settleCapturedViewAt(r100.getLeft(), r103) == false) goto L46;
            this.f260770a.setStateInternal(2);
            BottomSheetBehavior r106 = this.f260770a;
            Objects.requireNonNull(r106);
            ViewCompat.postOnAnimation(r100, new d(r106, r100, r104));
            return;
        L46:
            this.f260770a.setStateInternal(r104);
            return;
        L8:
            int r107 = r100.getTop();
            int r108 = this.f260770a.f260747h;
            if (r107 <= r108) goto L7;
            r103 = r108;
            goto L44
        L11:
            BottomSheetBehavior r109 = this.f260770a;
            if (r109.f260749j == false) goto L22;
            if (r109.shouldHide(r100, r102) == false) goto L22;
            if (r100.getTop() <= this.f260770a.f260748i) goto L18;
        L20:
            r103 = this.f260770a.f260756q;
            r104 = 5;
            goto L44
        L18:
            if (Math.abs(r101) < Math.abs(r102)) goto L20;
        L22:
            if (r102 != 0.0f) goto L24;
        L27:
            int r110 = r100.getTop();
            BottomSheetBehavior r111 = this.f260770a;
            if (r111.f260740a == true) goto L30;
            int r112 = r111.f260747h;
            if (r110 >= r112) goto L40;
            if (r110 < Math.abs(r110 - r111.f260748i)) goto L7;
            r103 = this.f260770a.f260747h;
            goto L44
        L40:
            if (Math.abs(r110 - r112) >= Math.abs(r110 - this.f260770a.f260748i)) goto L42;
            r103 = this.f260770a.f260747h;
            goto L44
        L42:
            r103 = this.f260770a.f260748i;
        L26:
            r104 = 4;
            goto L44
        L30:
            if (Math.abs(r110 - r111.f260746g) >= Math.abs(r110 - this.f260770a.f260748i)) goto L32;
            r103 = this.f260770a.f260746g;
            goto L7
        L32:
            r103 = this.f260770a.f260748i;
            goto L26
        L24:
            if (Math.abs(r101) > Math.abs(r102)) goto L27;
            r103 = this.f260770a.f260748i;
            goto L26
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public final void onViewPositionChanged(View r100, int r101, int r102, int r103, int r104) {
            this.f260770a.dispatchOnSlide(r102);
        }
    }

    public class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final View f260771a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f260772b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ BottomSheetBehavior f260773c;

        @Override // java.lang.Runnable
        public final void run() {
            ViewDragHelper r100 = this.f260773c.f260752m;     // Catch: Throwable -> L9
            if (r100 != null) goto L5;
        L7:
            this.f260773c.setStateInternal(this.f260772b);     // Catch: Throwable -> L9
        L14:
            return;
        L5:
            if (r100.continueSettling(true) == false) goto L7;
            ViewCompat.postOnAnimation(this.f260771a, this);     // Catch: Throwable -> L9
        L9:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L17;
            throw th;
        }

        public d(BottomSheetBehavior r100, View r101, int r102) {
            this.f260773c = r100;
            this.f260771a = r101;
            this.f260772b = r102;
        }
    }

    public final int getExpandedOffset() {
        if (this.f260740a == true) goto L7;
        return 0;
    L7:
        return this.f260746g;
    }

    public BottomSheetBehavior() {
        this.f260740a = true;
        this.f260751l = 4;
        this.A = true;
        this.f260765z = new c(this);
    }

    public final void dispatchOnSlide(int r100) {
        V r101 = this.f260757r.get();
        if (r101 == null) goto L11;
        b r102 = this.f260759t;
        if (r102 != null) goto L7;
        return;
    L7:
        if (r100 <= this.f260748i) goto L9;
        r102.a(r101);
        return;
    L9:
        r102.a(r101);
        return;
    }

    public final View findScrollingChild(View r100) {
        if (ViewCompat.isNestedScrollingEnabled(r100) == false) goto L8;
        if ((r100 instanceof RecyclerView) == false) goto L8;
        return r100;
    L8:
        if ((r100 instanceof ViewGroup) == false) goto L15;
        ViewGroup r101 = (ViewGroup) r100;
        int r102 = r101.getChildCount();
        int r103 = 0;
    L10:
        if (r103 >= r102) goto L19;
        View r104 = findScrollingChild(r101.getChildAt(r103));
        if (r104 != null) goto L13;
        r103 = r103 + 1;
        goto L10
    L13:
        return r104;
    L19:
        return null;
    L15:
        return null;
    }

    public final void setPeekHeight(int r100) {
        boolean r101 = true;
        if (r100 != (-1)) goto L8;
        if (this.f260743d == true) goto L12;
        this.f260743d = true;
    L14:
        if (r101 == true) goto L16;
        return;
    L16:
        if (this.f260751l != 4) goto L24;
        WeakReference<V> r102 = this.f260757r;
        if (r102 == null) goto L25;
        V r103 = r102.get();
        if (r103 == null) goto L26;
        r103.requestLayout();
        return;
    L26:
        return;
    L25:
        return;
    L24:
        return;
    L12:
        r101 = false;
        goto L14
    L8:
        if (this.f260743d == false) goto L10;
    L13:
        this.f260743d = false;
        this.f260742c = Math.max(0, r100);
        this.f260748i = this.f260756q - r100;
        goto L14
    L10:
        if (this.f260742c == r100) goto L12;
        goto L12
    }

    public final void setState(int r100) {
        if (r100 == this.f260751l) goto L28;
        WeakReference<V> r101 = this.f260757r;
        if (r101 == null) goto L7;
        V r102 = r101.get();
        if (r102 == null) goto L32;
        ViewParent r103 = r102.getParent();
        if (r103 != null) goto L22;
    L26:
        startSettlingAnimation(r102, r100);
        return;
    L22:
        if (r103.isLayoutRequested() == false) goto L26;
        if (ViewCompat.isAttachedToWindow(r102) == false) goto L26;
        r102.post(new a(this, r102, r100));
        return;
    L32:
        return;
    L7:
        if (r100 != 4) goto L9;
    L16:
        this.f260751l = r100;
        return;
    L9:
        if (r100 == 3) goto L16;
        if (r100 == 6) goto L16;
        if (this.f260749j == true) goto L15;
        return;
    L15:
        if (r100 == 5) goto L16;
        return;
    }

    public final void setStateInternal(int r100) {
        if (this.f260751l == r100) goto L20;
        this.f260751l = r100;
        if (r100 != 6) goto L7;
    L13:
        updateImportantForAccessibility(true);
    L14:
        V r101 = this.f260757r.get();
        if (r101 == null) goto L21;
        b r102 = this.f260759t;
        if (r102 == null) goto L22;
        r102.b(r101, r100);
        return;
    L22:
        return;
    L21:
        return;
    L7:
        if (r100 == 3) goto L13;
        if (r100 != 5) goto L11;
    L12:
        updateImportantForAccessibility(false);
        goto L14
    L11:
        if (r100 != 4) goto L14;
    }

    public final void updateImportantForAccessibility(boolean r100) {
        WeakReference<V> r101 = this.f260757r;
        if (r101 == null) goto L33;
        ViewParent r102 = r101.get().getParent();
        if ((r102 instanceof CoordinatorLayout) == false) goto L34;
        CoordinatorLayout r103 = (CoordinatorLayout) r102;
        int r104 = r103.getChildCount();
        if (r100 == true) goto L9;
    L12:
        int r105 = 0;
    L13:
        if (r105 >= r104) goto L24;
        View r106 = r103.getChildAt(r105);
        if (r106 == this.f260757r.get()) goto L23;
        if (r100 == true) goto L22;
        Map<View, Integer> r107 = this.f260764y;
        if (r107 == null) goto L23;
        if (r107.containsKey(r106) == false) goto L23;
        ViewCompat.setImportantForAccessibility(r106, this.f260764y.get(r106).intValue());
        goto L23
    L22:
        this.f260764y.put(r106, Integer.valueOf(r106.getImportantForAccessibility()));
        ViewCompat.setImportantForAccessibility(r106, 4);
    L23:
        r105 = r105 + 1;
        goto L13
    L24:
        if (r100 == true) goto L35;
        this.f260764y = null;
        return;
    L35:
        return;
    L9:
        if (this.f260764y == null) goto L11;
        return;
    L11:
        this.f260764y = new HashMap(r104);
        goto L12
    L34:
        return;
    }

    public BottomSheetBehavior(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.f260740a = true;
        this.f260751l = 4;
        this.A = true;
        this.f260765z = new c(this);
        TypedArray r102 = r100.obtainStyledAttributes(r101, new int[]{R.attr.behavior_fitToContents, R.attr.behavior_hideable, R.attr.behavior_peekHeight, R.attr.behavior_skipCollapsed});
        TypedValue r103 = r102.peekValue(2);
        if (r103 == null) goto L7;
        int r104 = r103.data;
        if (r104 != (-1)) goto L7;
        setPeekHeight(r104);
    L8:
        this.f260749j = r102.getBoolean(1, false);
        boolean r105 = r102.getBoolean(0, true);
        if (this.f260740a == r105) goto L22;
        this.f260740a = r105;
        if (this.f260757r == null) goto L16;
        if (r105 == false) goto L14;
        this.f260748i = Math.max(this.f260756q - this.f260745f, this.f260746g);
        goto L16
    L14:
        this.f260748i = this.f260756q - this.f260745f;
    L16:
        if (this.f260740a == true) goto L18;
    L20:
        int r106 = this.f260751l;
    L21:
        setStateInternal(r106);
        goto L22
    L18:
        if (this.f260751l != 6) goto L20;
        r106 = 3;
    L22:
        this.f260750k = r102.getBoolean(3, false);
        r102.recycle();
        this.f260741b = ViewConfiguration.get(r100).getScaledMaximumFlingVelocity();
        return;
    L7:
        setPeekHeight(r102.getDimensionPixelSize(2, -1));
        goto L8
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final Parcelable onSaveInstanceState(CoordinatorLayout r100, V r101) {
        return new SavedState(super.onSaveInstanceState(r100, r101), this.f260751l);
    }

    public final boolean shouldHide(View r100, float r101) {
        if (this.f260750k == false) goto L6;
        return true;
    L6:
        if (r100.getTop() >= this.f260748i) goto L9;
        return false;
    L9:
        if ((Math.abs((r100.getTop() + (r101 * 0.1f)) - this.f260748i) / this.f260742c) > 0.5f) goto L13;
        return false;
    L13:
        return true;
    }

    public final void startSettlingAnimation(View r100, int r101) {
        if (r101 != 4) goto L6;
        int r102 = this.f260748i;
    L20:
        if (this.f260752m.smoothSlideViewTo(r100, r100.getLeft(), r102) == false) goto L22;
        setStateInternal(2);
        ViewCompat.postOnAnimation(r100, new d(this, r100, r101));
        return;
    L22:
        setStateInternal(r101);
        return;
    L6:
        if (r101 != 6) goto L12;
        r102 = this.f260747h;
        if (this.f260740a == false) goto L20;
        int r103 = this.f260746g;
        if (r102 > r103) goto L20;
        r102 = r103;
        r101 = 3;
        goto L20
    L12:
        if (r101 != 3) goto L15;
        r102 = getExpandedOffset();
        goto L20
    L15:
        if (this.f260749j == false) goto L25;
        if (r101 != 5) goto L25;
        r102 = this.f260756q;
    L25:
        throw new IllegalArgumentException("Illegal state argument: " + r101);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final boolean onInterceptTouchEvent(CoordinatorLayout r100, V r110, MotionEvent r111) {
        if (this.A == true) goto L6;
        return false;
    L6:
        if (r110.isShown() == true) goto L9;
        this.f260753n = true;
        return false;
    L9:
        int r101 = r111.getActionMasked();
        View r102 = null;
        if (r101 != 0) goto L15;
        this.f260761v = -1;
        VelocityTracker r103 = this.f260760u;
        if (r103 == null) goto L15;
        r103.recycle();
        this.f260760u = null;
    L15:
        if (this.f260760u != null) goto L17;
        this.f260760u = VelocityTracker.obtain();
    L17:
        this.f260760u.addMovement(r111);
        if (r101 == 0) goto L27;
        if (r101 != 1) goto L21;
    L23:
        this.f260763x = false;
        this.f260761v = -1;
        if (this.f260753n == false) goto L43;
        this.f260753n = false;
        return false;
    L43:
        if (this.f260753n == true) goto L49;
        ViewDragHelper r112 = this.f260752m;
        if (r112 == null) goto L49;
        if (r112.shouldInterceptTouchEvent(r111) == false) goto L49;
        return true;
    L49:
        WeakReference<View> r113 = this.f260758s;
        if (r113 == null) goto L52;
        r102 = r113.get();
    L52:
        boolean r104 = r100.isPointInChildBounds(r102, (int) r111.getX(), (int) r111.getY());
        if (r101 != 2) goto L66;
        if (r102 != null) goto L56;
        return false;
    L56:
        if (this.f260753n == false) goto L58;
        return false;
    L58:
        if (this.f260751l == 1) goto L69;
        if (r104 == false) goto L61;
        return false;
    L61:
        if (this.f260752m != null) goto L63;
        return false;
    L63:
        if (Math.abs(this.f260762w - r111.getY()) <= this.f260752m.getTouchSlop()) goto L72;
        return true;
    L72:
        return false;
    L69:
        return false;
    L66:
        return false;
    L21:
        if (r101 == 3) goto L23;
    L27:
        int r105 = (int) r111.getX();
        this.f260762w = (int) r111.getY();
        WeakReference<View> r106 = this.f260758s;
        if (r106 == null) goto L30;
        View r107 = r106.get();
    L31:
        if (r107 == null) goto L36;
        if (r100.isPointInChildBounds(r107, r105, this.f260762w) == false) goto L36;
        this.f260761v = r111.getPointerId(r111.getActionIndex());
        this.f260763x = true;
    L36:
        if (this.f260761v == (-1)) goto L38;
    L40:
        boolean r114 = false;
    L41:
        this.f260753n = r114;
        goto L43
    L38:
        if (r100.isPointInChildBounds(r110, r105, this.f260762w) == true) goto L40;
        r114 = true;
        goto L41
    L30:
        r107 = null;
        goto L31
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final boolean onLayoutChild(CoordinatorLayout r100, V r101, int r102) {
        if (ViewCompat.getFitsSystemWindows(r100) == true) goto L5;
    L7:
        int r103 = r101.getTop();
        r100.onLayoutChild(r101, r102);
        this.f260756q = r100.getHeight();
        if (this.f260743d == true) goto L10;
        this.f260745f = this.f260742c;
    L14:
        int r104 = Math.max(0, this.f260756q - r101.getHeight());
        this.f260746g = r104;
        int r105 = this.f260756q;
        this.f260747h = r105 / 2;
        if (this.f260740a == false) goto L17;
        this.f260748i = Math.max(r105 - this.f260745f, r104);
    L18:
        int r106 = this.f260751l;
        if (r106 != 3) goto L22;
        ViewCompat.offsetTopAndBottom(r101, getExpandedOffset());
    L37:
        if (this.f260752m != null) goto L39;
        this.f260752m = ViewDragHelper.create(r100, this.f260765z);
    L39:
        this.f260757r = new WeakReference(r101);
        this.f260758s = new WeakReference(findScrollingChild(r101));
        return true;
    L22:
        if (r106 != 6) goto L25;
        ViewCompat.offsetTopAndBottom(r101, this.f260747h);
        goto L37
    L25:
        if (this.f260749j == false) goto L30;
        if (r106 != 5) goto L30;
        ViewCompat.offsetTopAndBottom(r101, this.f260756q);
    L30:
        if (r106 != 4) goto L32;
        ViewCompat.offsetTopAndBottom(r101, this.f260748i);
        goto L37
    L32:
        if (r106 != 1) goto L34;
    L35:
        ViewCompat.offsetTopAndBottom(r101, r103 - r101.getTop());
        goto L37
    L34:
        if (r106 != 2) goto L37;
    L17:
        this.f260748i = r105 - this.f260745f;
        goto L18
    L10:
        if (this.f260744e != 0) goto L12;
        this.f260744e = r100.getResources().getDimensionPixelSize(R.dimen.design_bottom_sheet_peek_height_min);
    L12:
        this.f260745f = Math.max(this.f260744e, this.f260756q - ((r100.getWidth() * 9) / 16));
        goto L14
    L5:
        if (ViewCompat.getFitsSystemWindows(r101) == true) goto L7;
        r101.setFitsSystemWindows(true);
        goto L7
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final void onRestoreInstanceState(CoordinatorLayout r100, V r101, Parcelable r102) {
        SavedState r103 = (SavedState) r102;
        super.onRestoreInstanceState(r100, r101, r103.getSuperState());
        int r104 = r103.f260766a;
        if (r104 != 1) goto L5;
    L7:
        this.f260751l = 4;
        return;
    L5:
        if (r104 == 2) goto L7;
        this.f260751l = r104;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final boolean onTouchEvent(CoordinatorLayout r100, V r101, MotionEvent r102) {
        if (this.A == true) goto L6;
        return false;
    L6:
        if (r101.isShown() == true) goto L8;
        return false;
    L8:
        int r103 = r102.getActionMasked();
        if (this.f260751l != 1) goto L12;
        if (r103 != 0) goto L12;
        return true;
    L12:
        ViewDragHelper r104 = this.f260752m;
        if (r104 == null) goto L15;
        r104.processTouchEvent(r102);
    L15:
        if (r103 != 0) goto L20;
        this.f260761v = -1;
        VelocityTracker r105 = this.f260760u;
        if (r105 == null) goto L20;
        r105.recycle();
        this.f260760u = null;
    L20:
        if (this.f260760u != null) goto L22;
        this.f260760u = VelocityTracker.obtain();
    L22:
        this.f260760u.addMovement(r102);
        if (r103 != 2) goto L30;
        if (this.f260753n == true) goto L30;
        if (Math.abs(this.f260762w - r102.getY()) <= this.f260752m.getTouchSlop()) goto L30;
        this.f260752m.captureChildView(r101, r102.getPointerId(r102.getActionIndex()));
    L30:
        return !this.f260753n;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final void onStopNestedScroll(CoordinatorLayout r100, V r101, View r102, int r103) {
        if (this.A == true) goto L5;
        return;
    L5:
        int r104 = 3;
        if (r101.getTop() != getExpandedOffset()) goto L9;
        setStateInternal(3);
        return;
    L9:
        if (r102 == this.f260758s.get()) goto L11;
        return;
    L11:
        if (this.f260755p == true) goto L13;
        return;
    L13:
        if (this.f260754o <= 0) goto L16;
        int r105 = getExpandedOffset();
    L46:
        if (this.f260752m.smoothSlideViewTo(r101, r101.getLeft(), r105) == false) goto L48;
        setStateInternal(2);
        ViewCompat.postOnAnimation(r101, new d(this, r101, r104));
    L49:
        this.f260755p = false;
        return;
    L48:
        setStateInternal(r104);
        goto L49
    L16:
        if (this.f260749j == false) goto L25;
        VelocityTracker r106 = this.f260760u;
        if (r106 != null) goto L20;
        float r107 = 0.0f;
    L22:
        if (shouldHide(r101, r107) == false) goto L25;
        r105 = this.f260756q;
        r104 = 5;
        goto L46
    L20:
        r106.computeCurrentVelocity(1000, this.f260741b);
        r107 = this.f260760u.getYVelocity(this.f260761v);
    L25:
        if (this.f260754o != 0) goto L43;
        int r108 = r101.getTop();
        if (this.f260740a == true) goto L29;
        int r109 = this.f260747h;
        if (r108 >= r109) goto L39;
        if (r108 >= Math.abs(r108 - this.f260748i)) goto L37;
        r105 = 0;
        goto L46
    L37:
        r105 = this.f260747h;
    L41:
        r104 = 6;
        goto L46
    L39:
        if (Math.abs(r108 - r109) >= Math.abs(r108 - this.f260748i)) goto L42;
        r105 = this.f260747h;
        goto L41
    L42:
        r105 = this.f260748i;
    L44:
        r104 = 4;
        goto L46
    L29:
        if (Math.abs(r108 - this.f260746g) >= Math.abs(r108 - this.f260748i)) goto L31;
        r105 = this.f260746g;
        goto L46
    L31:
        r105 = this.f260748i;
        goto L44
    L43:
        r105 = this.f260748i;
        goto L44
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final boolean onNestedPreFling(CoordinatorLayout r100, V r101, View r102, float r103, float r104) {
        if (this.A == true) goto L6;
        return false;
    L6:
        if (r102 == this.f260758s.get()) goto L8;
        return false;
    L8:
        if (this.f260751l == 3) goto L10;
    L11:
        return true;
    L10:
        if (super.onNestedPreFling(r100, r101, r102, r103, r104) == true) goto L11;
        return false;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final boolean onStartNestedScroll(CoordinatorLayout r100, V r101, View r102, View r103, int r104, int r105) {
        if (this.A == true) goto L5;
        return false;
    L5:
        this.f260754o = 0;
        this.f260755p = false;
        if ((r104 & 2) == 0) goto L9;
        return true;
    L9:
        return false;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final void onNestedPreScroll(CoordinatorLayout r100, V r101, View r102, int r103, int r104, int[] r105, int r106) {
        if (this.A == true) goto L6;
        return;
    L6:
        if (r106 != 1) goto L8;
        return;
    L8:
        if (r102 != this.f260758s.get()) goto L27;
        int r107 = r101.getTop();
        int r108 = r107 - r104;
        if (r104 > 0) goto L12;
        if (r104 < 0) goto L17;
    L24:
        dispatchOnSlide(r101.getTop());
        this.f260754o = r104;
        this.f260755p = true;
        return;
    L17:
        if (r102.canScrollVertically(-1) == true) goto L24;
        int r109 = this.f260748i;
        if (r108 > r109) goto L21;
    L23:
        r105[1] = r104;
        ViewCompat.offsetTopAndBottom(r101, -r104);
        setStateInternal(1);
        goto L24
    L21:
        if (this.f260749j == true) goto L23;
        int r110 = r107 - r109;
        r105[1] = r110;
        ViewCompat.offsetTopAndBottom(r101, -r110);
        setStateInternal(4);
        goto L24
    L12:
        if (r108 >= getExpandedOffset()) goto L14;
        int r111 = r107 - getExpandedOffset();
        r105[1] = r111;
        ViewCompat.offsetTopAndBottom(r101, -r111);
        setStateInternal(3);
        goto L24
    L14:
        r105[1] = r104;
        ViewCompat.offsetTopAndBottom(r101, -r104);
        setStateInternal(1);
        goto L24
    }
}
