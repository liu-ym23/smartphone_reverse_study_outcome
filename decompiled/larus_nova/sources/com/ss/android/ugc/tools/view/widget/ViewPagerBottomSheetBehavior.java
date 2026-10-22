package com.ss.android.ugc.tools.view.widget;

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
import androidx.viewpager.widget.ViewPager;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;

/* JADX INFO: loaded from: classes40.dex */
public class ViewPagerBottomSheetBehavior<V extends View> extends CoordinatorLayout.Behavior<V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f455084a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f455085b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f455086c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f455087d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f455088e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f455089f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f455090g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f455091h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f455092i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f455093j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public ViewDragHelper f455094k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f455095l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f455096m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f455097n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f455098o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public WeakReference<V> f455099p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public WeakReference<View> f455100q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public c f455101r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public VelocityTracker f455102s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f455103t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f455104u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f455105v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final double f455106w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final b f455107x;

    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f455108a;

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
            this.f455108a = r100.readInt();
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public final void writeToParcel(Parcel r100, int r101) {
            super.writeToParcel(r100, r101);
            r100.writeInt(this.f455108a);
        }

        public SavedState(Parcelable r100, int r101) {
            super(r100);
            this.f455108a = r101;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface State {
    }

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f455109a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f455110b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ ViewPagerBottomSheetBehavior f455111c;

        @Override // java.lang.Runnable
        public final void run() {
            this.f455111c.startSettlingAnimation(this.f455109a, this.f455110b);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public a(ViewPagerBottomSheetBehavior r100, View r101, int r102) {
            this.f455111c = r100;
            this.f455109a = r101;
            this.f455110b = r102;
        }
    }

    public class b extends ViewDragHelper.Callback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ViewPagerBottomSheetBehavior f455112a;

        public b(ViewPagerBottomSheetBehavior r100) {
            this.f455112a = r100;
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public final int getViewVerticalDragRange(View r100) {
            ViewPagerBottomSheetBehavior r101 = this.f455112a;
            if (r101.f455091h == false) goto L7;
            int r102 = r101.f455098o;
            int r103 = r101.f455089f;
        L6:
            return r102 - r103;
        L7:
            r102 = r101.f455090g;
            r103 = r101.f455089f;
            goto L6
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public final void onViewDragStateChanged(int r100) {
            if (r100 != 1) goto L6;
            this.f455112a.setStateInternal(1);
            return;
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public final boolean tryCaptureView(View r100, int r101) {
            ViewPagerBottomSheetBehavior r102 = this.f455112a;
            int r103 = r102.f455093j;
            if (r103 != 1) goto L6;
            return false;
        L6:
            if (r102.f455105v == false) goto L9;
            return false;
        L9:
            if (r103 == 3) goto L11;
        L20:
            WeakReference<V> r104 = this.f455112a.f455099p;
            if (r104 != null) goto L23;
            return false;
        L23:
            if (r104.get() != r100) goto L27;
            return true;
        L27:
            return false;
        L11:
            if (r102.f455103t != r101) goto L20;
            WeakReference<View> r105 = r102.f455100q;
            if (r105 == null) goto L15;
            View r106 = r105.get();
        L16:
            if (r106 == null) goto L20;
            if (r106.canScrollVertically(-1) == false) goto L20;
            return false;
        L15:
            r106 = null;
            goto L16
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public final int clampViewPositionHorizontal(View r100, int r101, int r102) {
            return r100.getLeft();
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public final int clampViewPositionVertical(View r100, int r101, int r102) {
            ViewPagerBottomSheetBehavior r103 = this.f455112a;
            int r104 = r101 - ((int) (((double) r102) * (1.0d - r103.f455106w)));
            int r105 = r103.f455089f;
            if (r103.f455091h == false) goto L5;
            int r106 = r103.f455098o;
        L7:
            return MathUtils.clamp(r104, r105, r106);
        L5:
            r106 = r103.f455090g;
            goto L7
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public final void onViewReleased(View r100, float r101, float r102) {
            int r103 = 3;
            if (r102 >= 0.0f) goto L5;
            int r104 = this.f455112a.f455089f;
        L18:
            if (r103 != 5) goto L28;
            WeakReference<V> r105 = this.f455112a.f455099p;
            if (r105 != null) goto L22;
            V r106 = null;
        L23:
            if (r106 == null) goto L28;
            c r107 = this.f455112a.f455101r;
            if (r107 == null) goto L28;
            r107.a(r106);
            goto L28
        L22:
            r106 = r105.get();
        L28:
            if (this.f455112a.f455094k.settleCapturedViewAt(r100.getLeft(), r104) == false) goto L30;
            this.f455112a.setStateInternal(2);
            ViewCompat.postOnAnimation(r100, new e(this.f455112a, r100, r103));
            return;
        L30:
            this.f455112a.setStateInternal(r103);
            return;
        L5:
            ViewPagerBottomSheetBehavior r108 = this.f455112a;
            if (r108.f455091h == false) goto L11;
            if (r108.shouldHide(r100, r102) == false) goto L11;
            r104 = this.f455112a.f455098o;
            r103 = 5;
        L11:
            if (r102 != 0.0f) goto L16;
            int r109 = r100.getTop();
            if (Math.abs(r109 - this.f455112a.f455089f) >= Math.abs(r109 - this.f455112a.f455090g)) goto L15;
            r104 = this.f455112a.f455089f;
            goto L18
        L15:
            r104 = this.f455112a.f455090g;
        L17:
            r103 = 4;
            goto L18
        L16:
            r104 = this.f455112a.f455090g;
            goto L17
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public final void onViewPositionChanged(View r100, int r101, int r102, int r103, int r104) {
            this.f455112a.dispatchOnSlide(r102);
        }
    }

    public static abstract class c {
        public c() {
        }

        public void a(View r100) {
        }

        public abstract void b(View r100, float r101);

        public abstract void c(View r100, int r101);
    }

    public static class d extends ViewPager.SimpleOnPageChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ViewPager f455113a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final ViewPagerBottomSheetBehavior f455114b;

        public class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ d f455115a;

            @Override // java.lang.Runnable
            public final void run() {
                ViewPagerBottomSheetBehavior r100 = this.f455115a.f455114b;     // Catch: Throwable -> L7
                WeakReference<V> r101 = r100.f455099p;     // Catch: Throwable -> L7
                if (r101 == null) goto L10;
                r100.f455100q = new WeakReference(r100.findScrollingChild(r101.get()));     // Catch: Throwable -> L7
                return;
            L10:
                return;
            L7:
                th = move-exception;
                if (RunnableProtector.intercept(th) == true) goto L14;
                throw th;
            }

            public a(d r100) {
                this.f455115a = r100;
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.SimpleOnPageChangeListener, androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public final void onPageSelected(int r100) {
            this.f455113a.post(new a(this));
        }

        public d(ViewPager r100, ViewPagerBottomSheetBehavior r101) {
            this.f455113a = r100;
            this.f455114b = r101;
        }
    }

    public class e implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final View f455116a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f455117b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ ViewPagerBottomSheetBehavior f455118c;

        @Override // java.lang.Runnable
        public final void run() {
            ViewDragHelper r100 = this.f455118c.f455094k;     // Catch: Throwable -> L9
            if (r100 != null) goto L5;
        L7:
            this.f455118c.setStateInternal(this.f455117b);     // Catch: Throwable -> L9
        L14:
            return;
        L5:
            if (r100.continueSettling(true) == false) goto L7;
            ViewCompat.postOnAnimation(this.f455116a, this);     // Catch: Throwable -> L9
        L9:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L17;
            throw th;
        }

        public e(ViewPagerBottomSheetBehavior r100, View r101, int r102) {
            this.f455118c = r100;
            this.f455116a = r101;
            this.f455117b = r102;
        }
    }

    public final int getPeekHeight() {
        if (this.f455087d == false) goto L6;
        return -1;
    L6:
        return this.f455086c;
    }

    public ViewPagerBottomSheetBehavior() {
        this.f455084a = 0.5f;
        this.f455093j = 4;
        this.f455106w = 1.0d;
        this.f455107x = new b(this);
    }

    public ViewPagerBottomSheetBehavior(Context r100) {
        super(r100, null);
        this.f455084a = 0.5f;
        this.f455093j = 4;
        this.f455106w = 1.0d;
        this.f455107x = new b(this);
        setPeekHeight(-1);
        this.f455085b = ViewConfiguration.get(r100).getScaledMaximumFlingVelocity();
    }

    public static <V extends View> ViewPagerBottomSheetBehavior<V> a(V r100) {
        ViewGroup.LayoutParams r101 = r100.getLayoutParams();
        if ((r101 instanceof CoordinatorLayout.LayoutParams) == false) goto L11;
        CoordinatorLayout.Behavior r102 = ((CoordinatorLayout.LayoutParams) r101).getBehavior();
        if ((r102 instanceof ViewPagerBottomSheetBehavior) == false) goto L9;
        return (ViewPagerBottomSheetBehavior) r102;
    L9:
        throw new IllegalArgumentException("The view is not associated with ViewPagerBottomSheetBehavior");
    L11:
        throw new IllegalArgumentException("The view is not a child of CoordinatorLayout");
    }

    public final void dispatchOnSlide(int r100) {
        WeakReference<V> r101 = this.f455099p;
        if (r101 != null) goto L5;
        V r102 = null;
    L6:
        if (r102 == null) goto L18;
        c r103 = this.f455101r;
        if (r103 == null) goto L19;
        int r104 = this.f455090g;
        int r105 = r104 - r100;
        if (r105 != 0) goto L12;
        float r106 = 0.0f;
    L16:
        r103.b(r102, r106);
        return;
    L12:
        if (r100 <= r104) goto L14;
        float r107 = r105;
        float r108 = this.f455098o - r104;
    L15:
        r106 = r107 / r108;
        goto L16
    L14:
        r107 = r105;
        r108 = r104 - this.f455089f;
        goto L15
    L19:
        return;
    L18:
        return;
    L5:
        r102 = r101.get();
        goto L6
    }

    public final View findScrollingChild(View r100) {
        if (r100 != null) goto L6;
        return null;
    L6:
        if (ViewCompat.isNestedScrollingEnabled(r100) == false) goto L8;
        return r100;
    L8:
        int r101 = 0;
        if ((r100 instanceof ViewPager) == false) goto L27;
        ViewPager r102 = (ViewPager) r100;
        Field r103 = f.f455138a;
        int r104 = r102.getCurrentItem();
    L12:
        if (r101 >= r102.getChildCount()) goto L22;
        View r105 = r102.getChildAt(r101);
        ViewPager.LayoutParams r106 = (ViewPager.LayoutParams) r105.getLayoutParams();
        int r107 = ((Integer) f.f455138a.get(r106)).intValue();     // Catch: IllegalAccessException -> L19
        if (r106.isDecor == true) goto L18;
        if (r104 != r107) goto L18;
    L23:
        View r108 = findScrollingChild(r105);
        if (r108 == null) goto L36;
        return r108;
    L36:
        return null;
    L18:
        r101 = r101 + 1;
    L19:
        e = move-exception;
        throw new RuntimeException(e);
    L22:
        r105 = null;
        goto L23
    L27:
        if ((r100 instanceof ViewGroup) == false) goto L36;
        ViewGroup r109 = (ViewGroup) r100;
        if (r109.getVisibility() != 0) goto L36;
        int r110 = r109.getChildCount();
    L31:
        if (r101 >= r110) goto L36;
        View r111 = findScrollingChild(r109.getChildAt(r101));
        if (r111 != null) goto L34;
        r101 = r101 + 1;
        goto L31
    L34:
        return r111;
    }

    public final void setPeekHeight(int r100) {
        boolean r101 = true;
        if (r100 != (-1)) goto L8;
        if (this.f455087d == true) goto L12;
        this.f455087d = true;
    L14:
        if (r101 == true) goto L16;
        return;
    L16:
        if (this.f455093j != 4) goto L24;
        WeakReference<V> r102 = this.f455099p;
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
        if (this.f455087d == false) goto L10;
    L13:
        this.f455087d = false;
        this.f455086c = Math.max(0, r100);
        this.f455090g = this.f455098o - r100;
        goto L14
    L10:
        if (this.f455086c == r100) goto L12;
        goto L12
    }

    public final void setState(int r100) {
        if (r100 != this.f455093j) goto L5;
        return;
    L5:
        WeakReference<V> r101 = this.f455099p;
        if (r101 == null) goto L8;
        V r102 = r101.get();
        if (r102 != null) goto L20;
        return;
    L20:
        ViewParent r103 = r102.getParent();
        if (r103 != null) goto L23;
    L27:
        startSettlingAnimation(r102, r100);
        return;
    L23:
        if (r103.isLayoutRequested() == false) goto L27;
        if (ViewCompat.isAttachedToWindow(r102) == false) goto L27;
        r102.post(new a(this, r102, r100));
        return;
    L8:
        if (r100 != 4) goto L10;
    L15:
        this.f455093j = r100;
        return;
    L10:
        if (r100 == 3) goto L15;
        if (this.f455091h == true) goto L14;
        return;
    L14:
        if (r100 == 5) goto L15;
    }

    public final void setStateInternal(int r100) {
        if (this.f455093j != r100) goto L5;
        return;
    L5:
        this.f455093j = r100;
        WeakReference<V> r101 = this.f455099p;
        if (r101 != null) goto L8;
        V r102 = null;
    L9:
        if (r102 == null) goto L14;
        c r103 = this.f455101r;
        if (r103 == null) goto L15;
        r103.c(r102, r100);
        return;
    L15:
        return;
    L14:
        return;
    L8:
        r102 = r101.get();
        goto L9
    }

    public ViewPagerBottomSheetBehavior(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.f455084a = 0.5f;
        this.f455093j = 4;
        this.f455106w = 1.0d;
        this.f455107x = new b(this);
        TypedArray r102 = r100.obtainStyledAttributes(r101, new int[]{R.attr.behavior_fitToContents, R.attr.behavior_hideable, R.attr.behavior_peekHeight, R.attr.behavior_skipCollapsed});
        TypedValue r103 = r102.peekValue(2);
        if (r103 == null) goto L7;
        int r104 = r103.data;
        if (r104 != (-1)) goto L7;
        setPeekHeight(r104);
    L8:
        this.f455091h = r102.getBoolean(1, false);
        this.f455092i = r102.getBoolean(3, false);
        r102.recycle();
        this.f455085b = ViewConfiguration.get(r100).getScaledMaximumFlingVelocity();
        return;
    L7:
        setPeekHeight(r102.getDimensionPixelSize(2, -1));
        goto L8
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final Parcelable onSaveInstanceState(CoordinatorLayout r100, V r101) {
        return new SavedState(super.onSaveInstanceState(r100, r101), this.f455093j);
    }

    public final boolean shouldHide(View r100, float r101) {
        if (this.f455092i == false) goto L6;
        return true;
    L6:
        if (r100.getTop() >= this.f455090g) goto L9;
        return false;
    L9:
        if ((Math.abs((r100.getTop() + (r101 * 0.1f)) - this.f455090g) / this.f455086c) > this.f455084a) goto L13;
        return false;
    L13:
        return true;
    }

    public final void startSettlingAnimation(View r100, int r101) {
        if (r101 != 4) goto L6;
        int r102 = this.f455090g;
    L13:
        ViewDragHelper r103 = this.f455094k;
        if (r103 != null) goto L16;
    L18:
        setStateInternal(r101);
        return;
    L16:
        if (r103.smoothSlideViewTo(r100, r100.getLeft(), r102) == false) goto L18;
        setStateInternal(2);
        ViewCompat.postOnAnimation(r100, new e(this, r100, r101));
        return;
    L6:
        if (r101 != 3) goto L9;
        r102 = this.f455089f;
        goto L13
    L9:
        if (this.f455091h == false) goto L21;
        if (r101 != 5) goto L21;
        r102 = this.f455098o;
    L21:
        throw new IllegalArgumentException("Illegal state argument: " + r101);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final boolean onInterceptTouchEvent(CoordinatorLayout r100, V r110, MotionEvent r111) {
        if (r110.isShown() == true) goto L6;
        this.f455095l = true;
        return false;
    L6:
        int r101 = r111.getActionMasked();
        View r102 = null;
        if (r101 != 0) goto L12;
        this.f455103t = -1;
        VelocityTracker r103 = this.f455102s;
        if (r103 == null) goto L12;
        r103.recycle();
        this.f455102s = null;
    L12:
        if (this.f455102s != null) goto L14;
        this.f455102s = VelocityTracker.obtain();
    L14:
        this.f455102s.addMovement(r111);
        if (r101 == 0) goto L24;
        if (r101 != 1) goto L18;
    L20:
        this.f455105v = false;
        this.f455103t = -1;
        if (this.f455095l == false) goto L40;
        this.f455095l = false;
        return false;
    L40:
        if (this.f455094k != null) goto L43;
        this.f455094k = ViewDragHelper.create(r100, this.f455107x);
    L43:
        if (this.f455095l == false) goto L45;
    L47:
        WeakReference<View> r112 = this.f455100q;
        if (r112 == null) goto L51;
        r102 = r112.get();
    L51:
        if (r101 != 2) goto L63;
        if (r102 != null) goto L54;
        return false;
    L54:
        if (this.f455095l == false) goto L56;
        return false;
    L56:
        if (this.f455093j != 1) goto L58;
        return false;
    L58:
        if (r100.isPointInChildBounds(r102, (int) r111.getX(), (int) r111.getY()) == false) goto L60;
        return false;
    L60:
        if (Math.abs(this.f455104u - r111.getY()) <= this.f455094k.getTouchSlop()) goto L68;
        return true;
    L68:
        return false;
    L63:
        return false;
    L45:
        if (this.f455094k.shouldInterceptTouchEvent(r111) == false) goto L47;
        return true;
    L18:
        if (r101 == 3) goto L20;
    L24:
        int r104 = (int) r111.getX();
        this.f455104u = (int) r111.getY();
        WeakReference<View> r105 = this.f455100q;
        if (r105 == null) goto L27;
        View r106 = r105.get();
    L28:
        if (r106 == null) goto L33;
        if (r100.isPointInChildBounds(r106, r104, this.f455104u) == false) goto L33;
        this.f455103t = r111.getPointerId(r111.getActionIndex());
        this.f455105v = true;
    L33:
        if (this.f455103t == (-1)) goto L35;
    L37:
        boolean r113 = false;
    L38:
        this.f455095l = r113;
        goto L40
    L35:
        if (r100.isPointInChildBounds(r110, r104, this.f455104u) == true) goto L37;
        r113 = true;
        goto L38
    L27:
        r106 = null;
        goto L28
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final boolean onLayoutChild(CoordinatorLayout r100, V r101, int r102) {
        if (ViewCompat.getFitsSystemWindows(r100) == true) goto L5;
    L7:
        int r103 = r101.getTop();
        r100.onLayoutChild(r101, r102);
        this.f455098o = r100.getHeight();
        if (this.f455087d == true) goto L10;
        int r104 = this.f455086c;
    L14:
        int r105 = Math.max(0, this.f455098o - r101.getHeight());
        this.f455089f = r105;
        int r106 = Math.max(this.f455098o - r104, r105);
        this.f455090g = r106;
        int r107 = this.f455093j;
        if (r107 != 3) goto L20;
        int r108 = r101.getTop();
        int r109 = this.f455089f;
        if (r108 == r109) goto L32;
        ViewCompat.offsetTopAndBottom(r101, r109);
    L32:
        if (this.f455094k != null) goto L34;
        this.f455094k = ViewDragHelper.create(r100, this.f455107x);
    L34:
        this.f455099p = new WeakReference(r101);
        this.f455100q = new WeakReference(findScrollingChild(r101));
        return true;
    L20:
        if (this.f455091h == false) goto L25;
        if (r107 != 5) goto L25;
        ViewCompat.offsetTopAndBottom(r101, this.f455098o);
    L25:
        if (r107 != 4) goto L27;
        ViewCompat.offsetTopAndBottom(r101, r106);
        goto L32
    L27:
        if (r107 != 1) goto L29;
    L30:
        ViewCompat.offsetTopAndBottom(r101, r103 - r101.getTop());
        goto L32
    L29:
        if (r107 != 2) goto L32;
    L10:
        if (this.f455088e != 0) goto L12;
        this.f455088e = r100.getResources().getDimensionPixelSize(R.dimen.design_bottom_sheet_peek_height_min);
    L12:
        r104 = Math.max(this.f455088e, this.f455098o - ((r100.getWidth() * 9) / 16));
        goto L14
    L5:
        if (ViewCompat.getFitsSystemWindows(r101) == true) goto L7;
        ViewCompat.setFitsSystemWindows(r101, true);
        goto L7
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final void onRestoreInstanceState(CoordinatorLayout r100, V r101, Parcelable r102) {
        SavedState r103 = (SavedState) r102;
        super.onRestoreInstanceState(r100, r101, r103.getSuperState());
        int r104 = r103.f455108a;
        if (r104 != 1) goto L5;
    L8:
        this.f455093j = 4;
        return;
    L5:
        if (r104 == 2) goto L8;
        this.f455093j = r104;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final void onStopNestedScroll(CoordinatorLayout r100, V r101, View r102) {
        int r103 = 3;
        if (r101.getTop() != this.f455089f) goto L6;
        setStateInternal(3);
        return;
    L6:
        WeakReference<View> r104 = this.f455100q;
        if (r104 != null) goto L9;
        return;
    L9:
        if (r102 == r104.get()) goto L11;
        return;
    L11:
        if (this.f455097n == true) goto L14;
        return;
    L14:
        if (this.f455096m <= 0) goto L17;
        int r105 = this.f455089f;
    L29:
        if (r103 != 5) goto L38;
        WeakReference<V> r106 = this.f455099p;
        if (r106 != null) goto L33;
        V r107 = null;
    L34:
        if (r107 == null) goto L38;
        c r108 = this.f455101r;
        if (r108 == null) goto L38;
        r108.a(r107);
        goto L38
    L33:
        r107 = r106.get();
    L38:
        ViewDragHelper r109 = this.f455094k;
        if (r109 != null) goto L41;
    L43:
        setStateInternal(r103);
    L44:
        this.f455097n = false;
        return;
    L41:
        if (r109.smoothSlideViewTo(r101, r101.getLeft(), r105) == false) goto L43;
        setStateInternal(2);
        ViewCompat.postOnAnimation(r101, new e(this, r101, r103));
        goto L44
    L17:
        if (this.f455091h == false) goto L22;
        this.f455102s.computeCurrentVelocity(1000, this.f455085b);
        if (shouldHide(r101, this.f455102s.getYVelocity(this.f455103t)) == false) goto L22;
        r105 = this.f455098o;
        r103 = 5;
    L22:
        if (this.f455096m != 0) goto L27;
        int r110 = r101.getTop();
        if (Math.abs(r110 - this.f455089f) >= Math.abs(r110 - this.f455090g)) goto L26;
        r105 = this.f455089f;
        goto L29
    L26:
        r105 = this.f455090g;
    L28:
        r103 = 4;
        goto L29
    L27:
        r105 = this.f455090g;
        goto L28
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final boolean onTouchEvent(CoordinatorLayout r100, V r101, MotionEvent r102) {
        boolean r103 = false;
        if (r101.isShown() == true) goto L5;
        return false;
    L5:
        int r104 = r102.getActionMasked();
        if (this.f455093j != 1) goto L10;
        if (r104 != 0) goto L10;
        return true;
    L10:
        if (r102.getAction() != 2) goto L12;
    L13:
        ViewDragHelper r105 = this.f455094k;
        if (r105 != null) goto L16;
    L20:
        r103 = true;
    L21:
        ViewDragHelper r106 = this.f455094k;
        if (r106 == null) goto L25;
        if (r103 == false) goto L25;
        r106.processTouchEvent(r102);
    L25:
        if (r104 != 0) goto L30;
        this.f455103t = -1;
        VelocityTracker r107 = this.f455102s;
        if (r107 == null) goto L30;
        r107.recycle();
        this.f455102s = null;
    L30:
        if (this.f455102s != null) goto L32;
        this.f455102s = VelocityTracker.obtain();
    L32:
        this.f455102s.addMovement(r102);
        if (r104 != 2) goto L40;
        if (this.f455095l == true) goto L40;
        if (Math.abs(this.f455104u - r102.getY()) <= this.f455094k.getTouchSlop()) goto L40;
        this.f455094k.captureChildView(r101, r102.getPointerId(r102.getActionIndex()));
    L40:
        return !this.f455095l;
    L16:
        if (r105.getViewDragState() != 1) goto L20;
        if (r102.findPointerIndex(this.f455094k.getActivePointerId()) >= 0) goto L20;
    L12:
        if (r102.getAction() != 6) goto L20;
        goto L13
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final boolean onNestedPreFling(CoordinatorLayout r100, V r101, View r102, float r103, float r104) {
        WeakReference<View> r105 = this.f455100q;
        if (r105 == null) goto L5;
        View r106 = r105.get();
    L6:
        if (r102 == r106) goto L8;
    L12:
        return false;
    L8:
        if (this.f455093j == 3) goto L10;
    L11:
        return true;
    L10:
        if (super.onNestedPreFling(r100, r101, r102, r103, r104) == false) goto L12;
    L5:
        r106 = null;
        goto L6
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final boolean onStartNestedScroll(CoordinatorLayout r100, V r101, View r102, View r103, int r104) {
        this.f455096m = 0;
        this.f455097n = false;
        if ((r104 & 2) == 0) goto L6;
        return true;
    L6:
        return false;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final void onNestedPreScroll(CoordinatorLayout r100, V r101, View r102, int r103, int r104, int[] r105) {
        WeakReference<View> r106 = this.f455100q;
        if (r106 == null) goto L5;
        View r107 = r106.get();
    L6:
        if (r102 == r107) goto L8;
        return;
    L8:
        int r108 = r101.getTop();
        int r109 = r108 - r104;
        if (r104 <= 0) goto L14;
        int r110 = this.f455089f;
        if (r109 >= r110) goto L13;
        int r111 = r108 - r110;
        r105[1] = r111;
        ViewCompat.offsetTopAndBottom(r101, -r111);
        setStateInternal(3);
    L24:
        dispatchOnSlide(r101.getTop());
        this.f455096m = r104;
        this.f455097n = true;
        return;
    L13:
        r105[1] = r104;
        ViewCompat.offsetTopAndBottom(r101, -r104);
        setStateInternal(1);
        goto L24
    L14:
        if (r104 >= 0) goto L24;
        if (r102.canScrollVertically(-1) == true) goto L24;
        int r112 = this.f455090g;
        if (r109 > r112) goto L20;
    L23:
        r105[1] = r104;
        ViewCompat.offsetTopAndBottom(r101, -r104);
        setStateInternal(1);
        goto L24
    L20:
        if (this.f455091h == true) goto L23;
        int r113 = r108 - r112;
        r105[1] = r113;
        ViewCompat.offsetTopAndBottom(r101, -r113);
        setStateInternal(4);
        goto L24
    L5:
        r107 = null;
        goto L6
    }
}
