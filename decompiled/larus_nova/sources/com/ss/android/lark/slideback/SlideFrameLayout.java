package com.ss.android.lark.slideback;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.widget.OverScroller;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.MotionEventCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.customview.widget.ViewDragHelper;
import com.larus.apm.impl.protector.RunnableProtector;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.log.Log;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes38.dex */
public class SlideFrameLayout extends ViewGroup {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static Field f440569v;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Drawable f440570a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f440571b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f440572c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f440573d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f440574e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f440575f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f440576g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f440577h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public float f440578i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public List<f> f440579j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final ViewDragHelper f440580k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f440581l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f440582m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Rect f440583n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final d f440584o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final ArrayList<b> f440585p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f440586q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f440587r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public Drawable f440588s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f440589t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f440590u;

    public static class LayoutParams extends ViewGroup.MarginLayoutParams {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final int[] f440591c = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final float f440592a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f440593b;

        static {
            f440591c = new int[]{R.attr.layout_weight};
        }

        public LayoutParams() {
            super(-1, -1);
            this.f440592a = 0.0f;
        }

        public LayoutParams(int r100) {
            super(-1, -1);
            this.f440592a = 0.0f;
        }

        public LayoutParams(ViewGroup.LayoutParams r100) {
            super(r100);
            this.f440592a = 0.0f;
        }

        public LayoutParams(ViewGroup.MarginLayoutParams r100) {
            super(r100);
            this.f440592a = 0.0f;
        }

        public LayoutParams(Context r100, AttributeSet r101) {
            super(r100, r101);
            this.f440592a = 0.0f;
            TypedArray r102 = r100.obtainStyledAttributes(r101, f440591c);
            this.f440592a = r102.getFloat(0, 0.0f);
            r102.recycle();
        }
    }

    public class a extends AccessibilityDelegateCompat {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Rect f440594a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ SlideFrameLayout f440595b;

        public a(SlideFrameLayout r100) {
            this.f440595b = r100;
            this.f440594a = new Rect();
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public final void onInitializeAccessibilityEvent(View r100, AccessibilityEvent r101) {
            super.onInitializeAccessibilityEvent(r100, r101);
            r101.setClassName(SlideFrameLayout.class.getName());
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public final void onInitializeAccessibilityNodeInfo(View r100, AccessibilityNodeInfoCompat r101) {
            AccessibilityNodeInfoCompat r102 = AccessibilityNodeInfoCompat.obtain(r101);
            super.onInitializeAccessibilityNodeInfo(r100, r102);
            Rect r103 = this.f440594a;
            r102.getBoundsInParent(r103);
            r101.setBoundsInParent(r103);
            r102.getBoundsInScreen(r103);
            r101.setBoundsInScreen(r103);
            r101.setVisibleToUser(r102.isVisibleToUser());
            r101.setPackageName(r102.getPackageName());
            r101.setClassName(r102.getClassName());
            r101.setContentDescription(r102.getContentDescription());
            r101.setEnabled(r102.isEnabled());
            r101.setClickable(r102.isClickable());
            r101.setFocusable(r102.isFocusable());
            r101.setFocused(r102.isFocused());
            r101.setAccessibilityFocused(r102.isAccessibilityFocused());
            r101.setSelected(r102.isSelected());
            r101.setLongClickable(r102.isLongClickable());
            r101.addAction(r102.getActions());
            r101.setMovementGranularities(r102.getMovementGranularities());
            r102.recycle();
            r101.setClassName(SlideFrameLayout.class.getName());
            r101.setSource(r100);
            Object r104 = ViewCompat.getParentForAccessibility(r100);
            if ((r104 instanceof View) == false) goto L5;
            r101.setParent((View) r104);
        L5:
            int r105 = this.f440595b.getChildCount();
            int r106 = 0;
        L6:
            if (r106 >= r105) goto L11;
            View r107 = this.f440595b.getChildAt(r106);
            if (r107.getVisibility() != 0) goto L10;
            ViewCompat.setImportantForAccessibility(r107, 1);
            r101.addChild(r107);
        L10:
            r106 = r106 + 1;
            goto L6
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public final boolean onRequestSendAccessibilityEvent(ViewGroup r100, View r101, AccessibilityEvent r102) {
            return super.onRequestSendAccessibilityEvent(r100, r101, r102);
        }
    }

    public class b implements Runnable {
        @Override // java.lang.Runnable
        public final void run() {
            throw null;     // Catch: Throwable -> L4
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public class c extends ViewDragHelper.Callback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SlideFrameLayout f440596a;

        public c(SlideFrameLayout r100) {
            this.f440596a = r100;
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public final int getViewHorizontalDragRange(View r100) {
            return this.f440596a.f440574e;
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public final void onViewDragStateChanged(int r100) {
            if (this.f440596a.f440580k.getViewDragState() != 0) goto L9;
            SlideFrameLayout r101 = this.f440596a;
            if (r101.f440573d != 0.0f) goto L7;
            r101.b(r101.f440572c);
            this.f440596a.f440581l = false;
            goto L9
        L7:
            r101.f440581l = true;
        L9:
            if (this.f440596a.f440579j == null) goto L14;
            Iterator r102 = new ArrayList(this.f440596a.f440579j).iterator();
        L12:
            if (r102.hasNext() == false) goto L14;
            ((f) r102.next()).c(this.f440596a.f440572c, r100);
        L14:
            WeakReference<View> r103 = this.f440596a.f440584o.f440597a;
            if (r103 != null) goto L17;
        L18:
            this.f440596a.getClass();
            return;
        L17:
            if (r103.get() == null) goto L18;
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public final void onEdgeDragStarted(int r100, int r101) {
            SlideFrameLayout r102 = this.f440596a;
            r102.f440580k.captureChildView(r102.f440572c, r101);
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public final void onViewCaptured(View r100, int r101) {
            SlideFrameLayout r102 = this.f440596a;
            Field r103 = SlideFrameLayout.f440569v;
            int r104 = r102.getChildCount();
            int r105 = 0;
        L3:
            if (r105 >= r104) goto L8;
            View r106 = r102.getChildAt(r105);
            if (r106.getVisibility() != 4) goto L7;
            r106.setVisibility(0);
        L7:
            r105 = r105 + 1;
            goto L3
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public final boolean tryCaptureView(View r100, int r101) {
            if (this.f440596a.f440575f == false) goto L7;
            return false;
        L7:
            return ((LayoutParams) r100.getLayoutParams()).f440593b;
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public final int clampViewPositionHorizontal(View r100, int r101, int r102) {
            LayoutParams r103 = (LayoutParams) this.f440596a.f440572c.getLayoutParams();
            int r104 = this.f440596a.getPaddingLeft() + ((ViewGroup.MarginLayoutParams) r103).leftMargin;
            int r105 = this.f440596a.f440574e + r104;
            return Math.min(Math.max(r101, r104), r105);
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public final int clampViewPositionVertical(View r100, int r101, int r102) {
            return r100.getTop();
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public final void onViewReleased(View r100, float r101, float r102) {
            LayoutParams r103 = (LayoutParams) r100.getLayoutParams();
            int r104 = this.f440596a.getPaddingLeft() + ((ViewGroup.MarginLayoutParams) r103).leftMargin;
            if (r101 > 0.0f) goto L7;
            if (r101 == 0.0f) goto L6;
        L8:
            this.f440596a.f440580k.settleCapturedViewAt(r104, r100.getTop());
            this.f440596a.invalidate();
            return;
        L6:
            if (this.f440596a.f440573d <= 0.5f) goto L8;
        L7:
            r104 = r104 + this.f440596a.f440574e;
            goto L8
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public final void onViewPositionChanged(View r100, int r101, int r102, int r103, int r104) {
            SlideFrameLayout r105 = this.f440596a;
            View r106 = r105.f440572c;
            if (r106 != null) goto L5;
            r105.f440573d = 0.0f;
            r105.getClass();
            r105.getClass();
        L19:
            this.f440596a.invalidate();
            return;
        L5:
            r105.f440573d = (r101 - (r105.getPaddingLeft() + ((ViewGroup.MarginLayoutParams) ((LayoutParams) r106.getLayoutParams())).leftMargin)) / r105.f440574e;
            List<f> r107 = r105.f440579j;
            if (r107 == null) goto L13;
            Iterator r108 = ((ArrayList) r107).iterator();
        L9:
            if (r108.hasNext() == false) goto L13;
            f r109 = (f) r108.next();
            r109.b(r105.f440573d);
            if ((r109 instanceof e) == false) goto L9;
            e r110 = (e) r109;
            r110.d();
            r110.a();
        L13:
            float r111 = r105.f440573d;
            if (r111 > 0.0f) goto L16;
        L18:
            r105.f440586q = false;
            goto L19
        L16:
            if (r111 >= 1.0f) goto L18;
            r105.f440586q = true;
            goto L19
        }
    }

    public class d extends View {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public WeakReference<View> f440597a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ SlideFrameLayout f440598b;

        public View getHostView() {
            return this.f440597a.get();
        }

        @Override // android.view.View
        public final void onDetachedFromWindow() {
            super.onDetachedFromWindow();
            if (this.f440597a.get() == null) goto L6;
            this.f440597a.clear();
            return;
        }

        @Override // android.view.View
        public final void draw(Canvas r100) {
            SlideFrameLayout r101 = this.f440598b;
            if (r101.f440573d <= 0.0f) goto L7;
            if (r101.f440571b == false) goto L7;
        L20:
            r101.getClass();     // Catch: Throwable -> L19
            View r102 = this.f440597a.get();     // Catch: Throwable -> L19
            if (r102 == null) goto L15;
            super.draw(r100);     // Catch: Throwable -> L19
            r100.save();     // Catch: Throwable -> L19
            r100.translate(0.0f, getHeight() - r102.getHeight());     // Catch: Throwable -> L19
            r102.draw(r100);     // Catch: Throwable -> L19
            r100.restore();     // Catch: Throwable -> L19
            return;
        L15:
            Drawable r103 = this.f440598b.f440588s;     // Catch: Throwable -> L19
            if (r103 == null) goto L23;
            r103.draw(r100);     // Catch: Throwable -> L19
            return;
        L23:
            return;
        L24:
            return;
        L7:
            if (r101.f440590u == true) goto L20;
            if (this.f440597a.get() == null) goto L21;
            this.f440597a.clear();
            return;
        }

        public void setHostView(View r100) {
            if (this.f440597a.get() != r100) goto L5;
            return;
        L5:
            this.f440597a.clear();
            this.f440597a = new WeakReference(r100);
        }

        public void setHostViewExplicitly(View r100) {
            if (this.f440597a.get() != r100) goto L5;
            return;
        L5:
            this.f440597a.clear();
            this.f440597a = new WeakReference(r100);
        }

        public d(SlideFrameLayout r100, Context r101) {
            this.f440598b = r100;
            super(r101);
            this.f440597a = new WeakReference(null);
            new Paint();
        }
    }

    public interface e extends f {
        void a();

        void d();
    }

    public interface f {
        void b(float r100);

        void c(View r100, int r101);

        void e(View r100);
    }

    public static class g {
        public g() {
        }
    }

    public static class h extends g {
        public h() {
        }
    }

    public f5c.a getBackgroundArtist() {
        return null;
    }

    public void setBackgroundArtist(f5c.a r100) {
    }

    public void setSlideable(boolean r100) {
    }

    static {
        new h();
    }

    private OverScroller getScroller() {
        if (this.f440580k != null) goto L5;
        return null;
    L5:
        Field r100 = getScrollerOfViewDragHelper();
        if (r100 != null) goto L14;
    L13:
        return null;
    L14:
        Object r101 = r100.get(this.f440580k);     // Catch: IllegalAccessException -> L11
        if ((r101 instanceof OverScroller) == false) goto L13;
        return (OverScroller) r101;
    L11:
        e = move-exception;
        e.printStackTrace();
        goto L13
    }

    private Field getScrollerOfViewDragHelper() {
        Field r100 = f440569v;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Field r101 = null;
        r101 = ViewDragHelper.class.getDeclaredField("scroller");     // Catch: NoSuchFieldException -> L8
        r101.setAccessible(true);     // Catch: NoSuchFieldException -> L8
    L9:
        if (r101 == null) goto L17;
    L13:
        if (r101 != null) goto L15;
        Log.e("SlideFrameLayout", "no scroller filed found");
    L15:
        f440569v = r101;
        return r101;
    L17:
        r101 = ViewDragHelper.class.getDeclaredField("mScroller");     // Catch: NoSuchFieldException -> L12
        r101.setAccessible(true);     // Catch: NoSuchFieldException -> L12
        goto L13
    }

    @Override // android.view.View
    public final void computeScroll() {
        boolean r100 = this.f440580k.continueSettling(true);
        List<f> r101 = this.f440579j;
        if (r101 == null) goto L8;
        Iterator r102 = ((ArrayList) r101).iterator();
    L6:
        if (r102.hasNext() == false) goto L8;
        ((f) r102.next()).e(this);
    L8:
        if (r100 == true) goto L10;
        return;
    L10:
        if (this.f440571b == false) goto L16;
        ViewCompat.postInvalidateOnAnimation(this);
        return;
    L16:
        this.f440580k.abort();     // Catch: Throwable -> L15
        return;
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f440582m = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f440582m = true;
        Iterator r100 = new ArrayList(this.f440585p).iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        ((b) r100.next()).run();
        goto L4
    L6:
        this.f440585p.clear();
    }

    public int getSlideRange() {
        return this.f440574e;
    }

    public SlideFrameLayout(Context r100) {
        this(r100, null);
    }

    private void setScroller(OverScroller r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (this.f440580k == null) goto L17;
        Field r101 = getScrollerOfViewDragHelper();
        if (r101 == null) goto L16;
        r101.set(this.f440580k, r100);     // Catch: IllegalAccessException -> L10
        return;
    L10:
        e = move-exception;
        e.printStackTrace();
        return;
    L16:
        return;
    }

    public final void a(f r100) {
        if (r100 != null) goto L5;
        return;
    L5:
        if (this.f440579j != null) goto L7;
        this.f440579j = new ArrayList();
    L7:
        this.f440579j.add(r100);
    }

    public final void b(View r110) {
        View r100 = r110;
        int r101 = getPaddingLeft();
        int r102 = getWidth() - getPaddingRight();
        int r103 = getPaddingTop();
        int r104 = getHeight() - getPaddingBottom();
        int r105 = 0;
        if (r100 != null) goto L5;
    L7:
        int r106 = 0;
        int r107 = 0;
        int r108 = 0;
        int r109 = 0;
    L8:
        int r111 = getChildCount();
        int r112 = 0;
    L10:
        if (r112 >= r111) goto L27;
        View r113 = getChildAt(r112);
        if (r113 == r100) goto L13;
        int r114 = Math.max(r101, r113.getLeft());
        int r115 = Math.max(r103, r113.getTop());
        int r116 = Math.min(r102, r113.getRight());
        int r117 = Math.min(r104, r113.getBottom());
        if (r114 < r106) goto L20;
        if (r115 < r108) goto L20;
        if (r116 > r107) goto L20;
        if (r117 > r109) goto L20;
        int r118 = 4;
    L21:
        r113.setVisibility(r118);
        r112 = r112 + 1;
        r100 = r110;
        r105 = 0;
    L20:
        r118 = 0;
        goto L21
    L13:
        r113.setVisibility(r105);
        return;
    L27:
        return;
    L5:
        if (ViewCompat.isOpaque(r110) == false) goto L7;
        r106 = r110.getLeft();
        r107 = r110.getRight();
        r108 = r110.getTop();
        r109 = r110.getBottom();
        goto L8
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

    @Override // android.view.View
    public final void draw(Canvas r100) {
        super.draw(r100);
        if (this.f440571b == true) goto L5;
        return;
    L5:
        if (this.f440587r == false) goto L8;
        return;
    L8:
        if (this.f440586q == true) goto L11;
        return;
    L11:
        if (this.f440570a != null) goto L14;
        return;
    L14:
        if (getChildCount() <= 1) goto L16;
        View r101 = getChildAt(1);
    L17:
        if (r101 == null) goto L25;
        int r102 = r101.getTop();
        int r103 = r101.getBottom();
        int r104 = this.f440570a.getIntrinsicWidth();
        int r105 = r101.getLeft();
        Drawable r106 = this.f440570a;
        r106.setBounds(r105 - r104, r102, r105, r103);
        this.f440570a.draw(r100);
        return;
    L25:
        return;
    L16:
        r101 = null;
        goto L17
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams r100) {
        if ((r100 instanceof ViewGroup.MarginLayoutParams) == false) goto L6;
        return new LayoutParams((ViewGroup.MarginLayoutParams) r100);
    L6:
        return new LayoutParams(r100);
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r100) {
        r100.getX();
        r100.getY();
        if (this.f440578i > 0.0f) goto L5;
    L16:
        int r101 = MotionEventCompat.getActionMasked(r100);
        if (this.f440571b == true) goto L25;
        if (r101 != 0) goto L25;
        if (getChildCount() <= 1) goto L25;
        View r102 = getChildAt(1);
        if (r102 == null) goto L25;
        this.f440581l = !this.f440580k.isViewUnder(r102, (int) r100.getX(), (int) r100.getY());
    L25:
        if (this.f440571b == true) goto L27;
    L72:
        this.f440580k.cancel();     // Catch: Throwable -> L63
    L58:
        return super.onInterceptTouchEvent(r100);
    L27:
        if (this.f440575f == false) goto L31;
        if (r101 != 0) goto L72;
    L31:
        if (r101 == 3) goto L68;
        if (r101 == 1) goto L68;
        if (r101 == 0) goto L44;
        if (r101 != 2) goto L66;
        float r103 = r100.getX();
        float r104 = r100.getY();
        float r105 = Math.abs(r103 - this.f440576g);
        float r106 = Math.abs(r104 - this.f440577h);
        if (r105 <= this.f440580k.getTouchSlop()) goto L66;
        if (r106 <= r105) goto L66;
        this.f440580k.cancel();     // Catch: Throwable -> L60
    L42:
        this.f440575f = true;
        return false;
    L66:
        return this.f440580k.shouldInterceptTouchEvent(r100);
    L74:
        return false;
    L44:
        this.f440575f = false;
        float r107 = r100.getX();
        float r108 = r100.getY();
        this.f440576g = r107;
        this.f440577h = r108;
        if (this.f440580k.isViewUnder(this.f440572c, (int) r107, (int) r108) == false) goto L66;
        View r109 = this.f440572c;
        if (r109 == null) goto L66;
        LayoutParams r110 = (LayoutParams) r109.getLayoutParams();
        if (this.f440571b == false) goto L66;
        r110.getClass();
    L68:
        this.f440580k.cancel();     // Catch: Throwable -> L62
    L55:
        return false;
    L5:
        if (r100.getAction() != 0) goto L16;
        if (r100.getX() <= this.f440578i) goto L16;
        int r111 = this.f440580k.getViewDragState();
        if (r111 == 1) goto L15;
        if (r111 == 2) goto L15;
        this.f440580k.abort();     // Catch: Throwable -> L59
    L13:
        this.f440575f = true;
        return false;
    L15:
        return true;
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r100) {
        r100.getX();
        r100.getY();
        if (this.f440578i <= 0.0f) goto L11;
        if (r100.getAction() != 0) goto L11;
        if (r100.getX() <= this.f440578i) goto L11;
        return false;
    L11:
        if (this.f440571b == false) goto L13;
        this.f440580k.processTouchEvent(r100);     // Catch: Throwable -> L16
    L18:
        if ((r100.getAction() & 255) != 0) goto L25;
        float r101 = r100.getX();
        float r102 = r100.getY();
        this.f440576g = r101;
        this.f440577h = r102;
        return true;
    L25:
        return true;
    L13:
        return super.onTouchEvent(r100);
    }

    public void setCustomPreviewDrawable(Drawable r100) {
        this.f440588s = r100;
    }

    public void setEdgeSize(int r100) {
        this.f440578i = r100;
    }

    public void setForceDrawPreview(boolean r100) {
        this.f440590u = r100;
    }

    public void setNeedClipRect(boolean r100) {
        this.f440589t = r100;
    }

    public void setShadowResource(int r100) {
        this.f440570a = getResources().getDrawable(r100);
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet r100) {
        return new LayoutParams(getContext(), r100);
    }

    public SlideFrameLayout(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    @Override // android.view.View
    public final void onMeasure(int r210, int r211) {
        int r100 = View.MeasureSpec.getMode(r210);
        int r101 = View.MeasureSpec.getSize(r210);
        int r102 = View.MeasureSpec.getMode(r211);
        int r103 = View.MeasureSpec.getSize(r211);
        if (r100 != 1073741824) goto L5;
        if (r102 == 0) goto L14;
    L19:
        if (r102 == Integer.MIN_VALUE) goto L23;
        if (r102 == 1073741824) goto L22;
        int r104 = 0;
        int r105 = 0;
    L24:
        int r106 = (r101 - getPaddingLeft()) - getPaddingRight();
        int r107 = getChildCount();
        if (r107 <= 2) goto L27;
        Log.e("SlideFrameLayout", "onMeasure: More than two child views are not supported.");
    L27:
        this.f440572c = null;
        float r110 = 0.0f;
        int r111 = r106;
        int r112 = 0;
        boolean r113 = false;
        float r114 = 0.0f;
    L28:
        int r115 = 8;
        if (r112 >= r107) goto L65;
        View r108 = getChildAt(r112);
        LayoutParams r109 = (LayoutParams) r108.getLayoutParams();
        if (r108.getVisibility() != 8) goto L33;
        r109.getClass();
    L64:
        r112 = r112 + 1;
        r110 = 0.0f;
        goto L28
    L33:
        float r116 = r109.f440592a;
        if (r116 <= r110) goto L38;
        r114 = r114 + r116;
        if (((ViewGroup.MarginLayoutParams) r109).width == 0) goto L64;
    L38:
        int r117 = ((ViewGroup.MarginLayoutParams) r109).leftMargin + ((ViewGroup.MarginLayoutParams) r109).rightMargin;
        int r118 = ((ViewGroup.MarginLayoutParams) r109).width;
        if (r118 != (-2)) goto L41;
        int r119 = View.MeasureSpec.makeMeasureSpec(r106 - r117, Integer.MIN_VALUE);
        float r120 = r114;
        int r121 = Integer.MIN_VALUE;
    L45:
        int r122 = ((ViewGroup.MarginLayoutParams) r109).height;
        if (r122 != (-2)) goto L49;
        int r123 = View.MeasureSpec.makeMeasureSpec(r105, r121);
    L52:
        r108.measure(r119, r123);
        int r124 = r108.getMeasuredWidth();
        int r125 = r108.getMeasuredHeight();
        if (r102 != r121) goto L56;
        if (r125 <= r104) goto L56;
        r104 = Math.min(r125, r105);
    L56:
        r111 = r111 - r124;
        if (r111 >= 0) goto L59;
        boolean r126 = true;
    L60:
        r109.f440593b = r126;
        r113 = r113 | r126;
        if (r126 == false) goto L63;
        this.f440572c = r108;
    L63:
        r114 = r120;
        goto L64
    L59:
        r126 = false;
        goto L60
    L49:
        if (r122 != (-1)) goto L51;
        r123 = View.MeasureSpec.makeMeasureSpec(r105, 1073741824);
        goto L52
    L51:
        r123 = View.MeasureSpec.makeMeasureSpec(r122, 1073741824);
        goto L52
    L41:
        r120 = r114;
        r121 = Integer.MIN_VALUE;
        if (r118 != (-1)) goto L44;
        r119 = View.MeasureSpec.makeMeasureSpec(r106 - r117, 1073741824);
        goto L45
    L44:
        r119 = View.MeasureSpec.makeMeasureSpec(r118, 1073741824);
        goto L45
    L65:
        if (r113 == false) goto L67;
    L68:
        int r127 = 0;
    L69:
        if (r127 >= r107) goto L121;
        View r128 = getChildAt(r127);
        if (r128.getVisibility() == r115) goto L120;
        LayoutParams r129 = (LayoutParams) r128.getLayoutParams();
        if (r128.getVisibility() == r115) goto L120;
        if (((ViewGroup.MarginLayoutParams) r129).width == 0) goto L79;
    L81:
        boolean r130 = false;
    L82:
        if (r130 == false) goto L84;
        int r131 = 0;
    L85:
        if (r113 == false) goto L104;
        if (r128 == this.f440572c) goto L104;
        if (((ViewGroup.MarginLayoutParams) r129).width >= 0) goto L120;
        if (r131 <= r106) goto L92;
    L93:
        if (r130 == false) goto L101;
        int r132 = ((ViewGroup.MarginLayoutParams) r129).height;
        if (r132 != (-2)) goto L98;
        int r133 = View.MeasureSpec.makeMeasureSpec(r105, Integer.MIN_VALUE);
        int r134 = 1073741824;
    L102:
        r128.measure(View.MeasureSpec.makeMeasureSpec(r106, r134), r133);
        goto L120
    L98:
        if (r132 != (-1)) goto L100;
        r134 = 1073741824;
        r133 = View.MeasureSpec.makeMeasureSpec(r105, 1073741824);
        goto L102
    L100:
        r134 = 1073741824;
        r133 = View.MeasureSpec.makeMeasureSpec(r132, 1073741824);
        goto L102
    L101:
        r134 = 1073741824;
        r133 = View.MeasureSpec.makeMeasureSpec(r128.getMeasuredHeight(), 1073741824);
        goto L102
    L92:
        if (r129.f440592a <= 0.0f) goto L120;
    L104:
        if (r129.f440592a <= 0.0f) goto L120;
        if (((ViewGroup.MarginLayoutParams) r129).width != 0) goto L114;
        int r135 = ((ViewGroup.MarginLayoutParams) r129).height;
        if (r135 != (-2)) goto L111;
        int r136 = View.MeasureSpec.makeMeasureSpec(r105, Integer.MIN_VALUE);
        int r137 = 1073741824;
    L115:
        if (r113 == false) goto L119;
        int r138 = r106 - (((ViewGroup.MarginLayoutParams) r129).leftMargin + ((ViewGroup.MarginLayoutParams) r129).rightMargin);
        int r139 = View.MeasureSpec.makeMeasureSpec(r138, r137);
        if (r131 == r138) goto L120;
        r128.measure(r139, r136);
        goto L120
    L119:
        r128.measure(View.MeasureSpec.makeMeasureSpec(r131 + ((int) ((r129.f440592a * Math.max(0, r111)) / r114)), 1073741824), r136);
        goto L120
    L111:
        if (r135 != (-1)) goto L113;
        r137 = 1073741824;
        r136 = View.MeasureSpec.makeMeasureSpec(r105, 1073741824);
        goto L115
    L113:
        r137 = 1073741824;
        r136 = View.MeasureSpec.makeMeasureSpec(r135, 1073741824);
        goto L115
    L114:
        r137 = 1073741824;
        r136 = View.MeasureSpec.makeMeasureSpec(r128.getMeasuredHeight(), 1073741824);
        goto L115
    L84:
        r131 = r128.getMeasuredWidth();
        goto L85
    L79:
        if (r129.f440592a <= 0.0f) goto L81;
        r130 = true;
    L120:
        r127 = r127 + 1;
        r115 = 8;
    L121:
        setMeasuredDimension(r101, (r104 + getPaddingTop()) + getPaddingBottom());
        this.f440571b &= r113;
        if (this.f440580k.getViewDragState() != 0) goto L124;
        return;
    L124:
        if (this.f440571b == true) goto L138;
        this.f440580k.abort();     // Catch: Throwable -> L127
        return;
    L139:
        return;
    L138:
        return;
    L67:
        if (r114 <= 0.0f) goto L121;
    L22:
        r104 = (r103 - getPaddingTop()) - getPaddingBottom();
        r105 = r104;
        goto L24
    L23:
        r105 = (r103 - getPaddingTop()) - getPaddingBottom();
        r104 = 0;
        goto L24
    L14:
        if (isInEditMode() == false) goto L18;
        if (r102 != 0) goto L19;
        r102 = Integer.MIN_VALUE;
        r103 = 300;
        goto L19
    L18:
        throw new IllegalStateException("Height must not be UNSPECIFIED");
    L5:
        if (isInEditMode() == false) goto L11;
        if (r100 == Integer.MIN_VALUE) goto L19;
        if (r100 != 0) goto L19;
        r101 = 300;
        goto L19
    L11:
        throw new IllegalStateException("Width must have an exact value or MATCH_PARENT");
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void requestChildFocus(View r100, View r101) {
        super.requestChildFocus(r100, r101);
        if (isInTouchMode() == false) goto L5;
        return;
    L5:
        if (this.f440571b == false) goto L7;
        return;
    L7:
        if (r100 != this.f440572c) goto L9;
        boolean r102 = true;
    L10:
        this.f440581l = r102;
        return;
    L9:
        r102 = false;
        goto L10
    }

    public SlideFrameLayout(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f440571b = false;
        this.f440582m = true;
        this.f440583n = new Rect();
        this.f440585p = new ArrayList();
        this.f440586q = false;
        this.f440587r = false;
        this.f440589t = true;
        this.f440590u = false;
        Resources r103 = r100.getResources();
        float r104 = WindowDisplayMetricsOverride.apply(r103, r103.getDisplayMetrics()).density;
        setWillNotDraw(false);
        ViewCompat.setAccessibilityDelegate(this, new a(this));
        ViewCompat.setImportantForAccessibility(this, 1);
        ViewDragHelper r105 = ViewDragHelper.create(this, 0.5f, new c(this));
        this.f440580k = r105;
        r105.setMinVelocity(r104 * 400.0f);
        Resources r106 = getResources();
        setEdgeSize(WindowDisplayMetricsOverride.apply(r106, r106.getDisplayMetrics()).widthPixels);
        setShadowResource(com.larus.nova.R.drawable.sliding_back_shadow);
        d r107 = new d(this, r100);
        this.f440584o = r107;
        addView(r107, new LayoutParams(0));
    }

    @Override // android.view.ViewGroup
    public final boolean drawChild(Canvas r100, View r101, long r102) {
        LayoutParams r103 = (LayoutParams) r101.getLayoutParams();
        int r104 = r100.save();
        if (this.f440571b == true) goto L5;
    L11:
        boolean r105 = super.drawChild(r100, r101, r102);
        r100.restoreToCount(r104);
        return r105;
    L5:
        if (r103.f440593b == true) goto L11;
        if (this.f440572c == null) goto L11;
        r100.getClipBounds(this.f440583n);
        Rect r106 = this.f440583n;
        r106.right = Math.min(r106.right, this.f440572c.getLeft());
        if (this.f440589t == false) goto L11;
        r100.clipRect(this.f440583n);
        goto L11
    }

    @Override // android.view.View
    public final void onSizeChanged(int r100, int r101, int r102, int r103) {
        super.onSizeChanged(r100, r101, r102, r103);
        if (r100 == r102) goto L6;
        this.f440582m = true;
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r110, int r111, int r112, int r113, int r114) {
        this.f440580k.setEdgeTrackingEnabled(1);
        int r115 = r113 - r111;
        int r116 = getPaddingLeft();
        int r117 = getPaddingRight();
        int r118 = getPaddingTop();
        int r119 = getChildCount();
        if (this.f440582m == true) goto L5;
    L11:
        int r100 = r116;
        int r101 = 0;
    L12:
        if (r101 >= r119) goto L23;
        View r102 = getChildAt(r101);
        if (r102.getVisibility() == 8) goto L21;
        LayoutParams r103 = (LayoutParams) r102.getLayoutParams();
        int r104 = r102.getMeasuredWidth();
        if (r103.f440593b == false) goto L19;
        int r105 = (Math.min(r116, r115 - r117) - r100) - (((ViewGroup.MarginLayoutParams) r103).leftMargin + ((ViewGroup.MarginLayoutParams) r103).rightMargin);
        this.f440574e = r105;
        int r106 = ((ViewGroup.MarginLayoutParams) r103).leftMargin;
        int r107 = (int) (r105 * this.f440573d);
        r100 = r100 + (r106 + r107);
        this.f440573d = r107 / r105;
    L20:
        int r108 = r100 + 0;
        r102.layout(r108, r118, r104 + r108, r102.getMeasuredHeight() + r118);
        r116 = r116 + r102.getWidth();
        goto L21
    L19:
        r100 = r116;
    L21:
        r101 = r101 + 1;
        goto L12
    L23:
        if (this.f440582m == false) goto L25;
        b(this.f440572c);
    L25:
        this.f440582m = false;
        return;
    L5:
        if (this.f440571b == true) goto L7;
    L9:
        float r109 = 0.0f;
    L10:
        this.f440573d = r109;
        goto L11
    L7:
        if (this.f440581l == false) goto L9;
        r109 = 1.0f;
        goto L10
    }
}
