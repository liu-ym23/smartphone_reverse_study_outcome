package com.bytedance.ies.dmt.ui.sliding;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityEvent;
import androidx.core.content.ContextCompat;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.customview.view.AbsSavedState;
import androidx.customview.widget.ViewDragHelper;
import com.alibaba.gaiax.model.GXAnimation;
import com.bytedance.android.livesdk.end.LiveEndPageData;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes19.dex */
public class DmtSlidingPaneLayout extends ViewGroup {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static int f248348u = 1920;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f248349a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f248350b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Drawable f248351c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Drawable f248352d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f248353e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public View f248354f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f248355g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f248356h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f248357i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f248358j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f248359k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public float f248360l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public float f248361m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final ViewDragHelper f248362n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f248363o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f248364p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final Rect f248365q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final ArrayList<b> f248366r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f248367s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final Paint f248368t;

    public static final enum DragSettleStrategy extends Enum<DragSettleStrategy> {
        public static final DragSettleStrategy AUTO = null;
        public static final DragSettleStrategy END = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ DragSettleStrategy[] f248369a = null;
        int value;

        static {
            DragSettleStrategy r100 = new DragSettleStrategy("AUTO", 0, 0);
            AUTO = r100;
            DragSettleStrategy r101 = new DragSettleStrategy(GXAnimation.STATE_END, 1, 1);
            END = r101;
            f248369a = new DragSettleStrategy[]{r100, r101};
        }

        public static DragSettleStrategy[] values() {
            return (DragSettleStrategy[]) f248369a.clone();
        }

        public static DragSettleStrategy find(int r100) {
            if (r100 == 1) goto L7;
            return AUTO;
        L7:
            return END;
        }

        public static DragSettleStrategy valueOf(String r100) {
            return (DragSettleStrategy) r27.a.a(DragSettleStrategy.class, r100);
        }

        public DragSettleStrategy(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static class LayoutParams extends ViewGroup.MarginLayoutParams {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final int[] f248370e = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final float f248371a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f248372b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f248373c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Paint f248374d;

        static {
            f248370e = new int[]{R.attr.layout_weight};
        }

        public LayoutParams() {
            super(-1, -1);
            this.f248371a = 0.0f;
        }

        public LayoutParams(ViewGroup.LayoutParams r100) {
            super(r100);
            this.f248371a = 0.0f;
        }

        public LayoutParams(ViewGroup.MarginLayoutParams r100) {
            super(r100);
            this.f248371a = 0.0f;
        }

        public LayoutParams(Context r100, AttributeSet r101) {
            super(r100, r101);
            this.f248371a = 0.0f;
            TypedArray r102 = r100.obtainStyledAttributes(r101, f248370e);
            this.f248371a = r102.getFloat(0, 0.0f);
            r102.recycle();
        }
    }

    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f248375a;

        public class a implements Parcelable.ClassLoaderCreator<SavedState> {
            public a() {
            }

            @Override // android.os.Parcelable.Creator
            public final Object createFromParcel(Parcel r100) {
                return new SavedState(r100);
            }

            @Override // android.os.Parcelable.Creator
            public final Object[] newArray(int r100) {
                return new SavedState[r100];
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            public final SavedState createFromParcel(Parcel r100, ClassLoader r101) {
                return new SavedState(r100);
            }
        }

        static {
            CREATOR = new a();
        }

        public SavedState(Parcel r100) {
            super(r100, null);
            if (r100.readInt() == 0) goto L5;
            boolean r101 = true;
        L6:
            this.f248375a = r101;
            return;
        L5:
            r101 = false;
            goto L6
        }

        public SavedState(Parcelable r100) {
            super(r100);
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public final void writeToParcel(Parcel r100, int r101) {
            super.writeToParcel(r100, r101);
            r100.writeInt(this.f248375a ? 1 : 0);
        }
    }

    public class a extends AccessibilityDelegateCompat {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Rect f248376a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ DmtSlidingPaneLayout f248377b;

        public a(DmtSlidingPaneLayout r100) {
            this.f248377b = r100;
            this.f248376a = new Rect();
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public final void onInitializeAccessibilityEvent(View r100, AccessibilityEvent r101) {
            super.onInitializeAccessibilityEvent(r100, r101);
            r101.setClassName(DmtSlidingPaneLayout.class.getName());
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public final void onInitializeAccessibilityNodeInfo(View r100, AccessibilityNodeInfoCompat r101) {
            AccessibilityNodeInfoCompat r102 = AccessibilityNodeInfoCompat.obtain(r101);
            super.onInitializeAccessibilityNodeInfo(r100, r102);
            Rect r103 = this.f248376a;
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
            r101.setClassName(DmtSlidingPaneLayout.class.getName());
            r101.setSource(r100);
            Object r104 = ViewCompat.getParentForAccessibility(r100);
            if ((r104 instanceof View) == false) goto L5;
            r101.setParent((View) r104);
        L5:
            int r105 = this.f248377b.getChildCount();
            int r106 = 0;
        L6:
            if (r106 >= r105) goto L13;
            View r107 = this.f248377b.getChildAt(r106);
            if (this.f248377b.d(r107) == true) goto L12;
            if (r107.getVisibility() != 0) goto L12;
            ViewCompat.setImportantForAccessibility(r107, 1);
            r101.addChild(r107);
        L12:
            r106 = r106 + 1;
            goto L6
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public final boolean onRequestSendAccessibilityEvent(ViewGroup r100, View r101, AccessibilityEvent r102) {
            if (this.f248377b.d(r101) == false) goto L7;
            return false;
        L7:
            return super.onRequestSendAccessibilityEvent(r100, r101, r102);
        }
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final View f248378a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ DmtSlidingPaneLayout f248379b;

        @Override // java.lang.Runnable
        public final void run() {
        L7:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L11;
            return;
        L11:
            throw th;
        L3:
            if (this.f248378a.getParent() != this.f248379b) goto L5;
            this.f248378a.setLayerType(0, null);     // Catch: Throwable -> L7
            DmtSlidingPaneLayout r100 = this.f248379b;     // Catch: Throwable -> L7
            View r101 = this.f248378a;     // Catch: Throwable -> L7
            ViewCompat.setLayerPaint(r101, r100.b(r101).f248374d);     // Catch: Throwable -> L7
        L5:
            this.f248379b.f248366r.remove(this);     // Catch: Throwable -> L7
        }

        public b(DmtSlidingPaneLayout r100, View r101) {
            this.f248379b = r100;
            this.f248378a = r101;
        }
    }

    public class c extends ViewDragHelper.Callback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DmtSlidingPaneLayout f248380a;

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public final int getViewHorizontalDragRange(View r100) {
            return this.f248380a.f248357i;
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public final void onViewDragStateChanged(int r100) {
            if (this.f248380a.f248362n.getViewDragState() != 0) goto L9;
            DmtSlidingPaneLayout r101 = this.f248380a;
            if (r101.f248355g != 0.0f) goto L7;
            r101.h(r101.f248354f);
            DmtSlidingPaneLayout r102 = this.f248380a;
            View r103 = r102.f248354f;
            r102.sendAccessibilityEvent(32);
            this.f248380a.f248363o = false;
            return;
        L7:
            View r104 = r101.f248354f;
            r101.sendAccessibilityEvent(32);
            this.f248380a.f248363o = true;
            return;
        }

        public c(DmtSlidingPaneLayout r100, DragSettleStrategy r101) {
            this.f248380a = r100;
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public final void onEdgeDragStarted(int r100, int r101) {
            DmtSlidingPaneLayout r102 = this.f248380a;
            r102.f248362n.captureChildView(r102.f248354f, r101);
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public final void onViewCaptured(View r100, int r101) {
            DmtSlidingPaneLayout r102 = this.f248380a;
            int r103 = r102.getChildCount();
            int r104 = 0;
        L3:
            if (r104 >= r103) goto L8;
            View r105 = r102.getChildAt(r104);
            if (r105.getVisibility() != 4) goto L7;
            r105.setVisibility(0);
        L7:
            r104 = r104 + 1;
            goto L3
        L8:
            this.f248380a.getClass();
            throw null;
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public final boolean tryCaptureView(View r100, int r101) {
            DmtSlidingPaneLayout r102 = this.f248380a;
            int r103 = DmtSlidingPaneLayout.f248348u;
            LayoutParams r104 = r102.b(r100);
            if (this.f248380a.f248358j == false) goto L5;
        L7:
            return false;
        L5:
            if (r104.f248372b == false) goto L7;
            return true;
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public final int clampViewPositionHorizontal(View r100, int r101, int r102) {
            DmtSlidingPaneLayout r103 = this.f248380a;
            LayoutParams r104 = r103.b(r103.f248354f);
            if (this.f248380a.e() == false) goto L5;
            int r105 = this.f248380a.getWidth() - ((this.f248380a.getPaddingRight() + ((ViewGroup.MarginLayoutParams) r104).rightMargin) + this.f248380a.f248354f.getWidth());
            int r106 = r105 - this.f248380a.f248357i;
            return Math.max(Math.min(r101, r105), r106);
        L5:
            int r107 = this.f248380a.getPaddingLeft() + ((ViewGroup.MarginLayoutParams) r104).leftMargin;
            int r108 = this.f248380a.f248357i + r107;
            return Math.min(Math.max(r101, r107), r108);
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public final int clampViewPositionVertical(View r100, int r101, int r102) {
            return r100.getTop();
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public final void onViewReleased(View r100, float r101, float r102) {
            DmtSlidingPaneLayout r103 = this.f248380a;
            int r104 = DmtSlidingPaneLayout.f248348u;
            r103.getClass();
            throw null;
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public final void onViewPositionChanged(View r100, int r101, int r102, int r103, int r104) {
            DmtSlidingPaneLayout r105 = this.f248380a;
            if (r105.f248354f != null) goto L5;
            r105.f248355g = 0.0f;
        L20:
            this.f248380a.invalidate();
            return;
        L5:
            boolean r106 = r105.e();
            LayoutParams r107 = r105.b(r105.f248354f);
            int r108 = r105.f248354f.getWidth();
            if (r106 == false) goto L8;
            r101 = (r105.getWidth() - r101) - r108;
        L8:
            if (r106 == false) goto L10;
            int r109 = r105.getPaddingRight();
        L11:
            if (r106 == false) goto L13;
            int r110 = ((ViewGroup.MarginLayoutParams) r107).rightMargin;
        L14:
            float r111 = (r101 - (r109 + r110)) / r105.f248357i;
            r105.f248355g = r111;
            if (r105.f248359k == 0) goto L18;
            r105.f(r111);
        L18:
            if (r107.f248373c == false) goto L20;
            r105.a(r105.f248354f, r105.f248355g, r105.f248349a);
            goto L20
        L13:
            r110 = ((ViewGroup.MarginLayoutParams) r107).leftMargin;
            goto L14
        L10:
            r109 = r105.getPaddingLeft();
            goto L11
        }
    }

    public interface d {
    }

    public void setPanelSlideListener(d r100) {
    }

    @Override // android.view.View
    public final void computeScroll() {
        if (this.f248362n.continueSettling(true) == true) goto L5;
        return;
    L5:
        if (this.f248353e == true) goto L8;
        this.f248362n.abort();
        return;
    L8:
        ViewCompat.postInvalidateOnAnimation(this);
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams();
    }

    public final boolean e() {
        if (ViewCompat.getLayoutDirection(this) == 1) goto L7;
        return false;
    L7:
        return true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f248364p = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f248364p = true;
        int r100 = this.f248366r.size();
        int r101 = 0;
    L3:
        if (r101 >= r100) goto L5;
        ((b) ListProtector.get(this.f248366r, r101)).run();
        r101 = r101 + 1;
        goto L3
    L5:
        this.f248366r.clear();
    }

    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        SavedState r100 = new SavedState(super.onSaveInstanceState());
        boolean r101 = this.f248353e;
        if (r101 == false) goto L10;
        if (r101 == true) goto L6;
    L9:
        boolean r102 = true;
    L11:
        r100.f248375a = r102;
        return r100;
    L6:
        if (this.f248355g == 1.0f) goto L9;
        r102 = false;
        goto L11
    L10:
        r102 = this.f248363o;
        goto L11
    }

    public int getCoveredFadeColor() {
        return this.f248350b;
    }

    public DragSettleStrategy getDragSettleStrategy() {
        return DragSettleStrategy.AUTO;
    }

    public int getParallaxDistance() {
        return this.f248359k;
    }

    public int getSliderFadeColor() {
        return this.f248349a;
    }

    public DmtSlidingPaneLayout(Context r100) {
        this(r100, null);
    }

    public static int c(Activity r100) {
        Rect r101 = new Rect();
        View r102 = r100.getWindow().getDecorView();
        if (com.larus.home.impl.utils.c.f346345e == false) goto L7;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");
        Thread r103 = ThreadMethodProxy.currentThread();
        if (r103 == com.larus.home.impl.utils.c.f346341a) goto L7;
        com.larus.home.impl.utils.c.a(r103, "getDecorView");
    L7:
        r102.getWindowVisibleDisplayFrame(r101);
        return r101.height();
    }

    public static Activity getActivity(Context r100) {
    L3:
        if (r100 == null) goto L11;
        if ((r100 instanceof Activity) == true) goto L7;
        if ((r100 instanceof ContextWrapper) == false) goto L11;
        r100 = ((ContextWrapper) r100).getBaseContext();
        goto L3
    L7:
        return (Activity) r100;
    L11:
        return null;
    }

    public static void setHeight(int r100) {
        f248348u = r100;
    }

    public final LayoutParams b(View r100) {
        if (r100 == null) goto L13;
        if (r100.getParent() != this) goto L13;
        ViewGroup.LayoutParams r101 = r100.getLayoutParams();
        if ((r101 instanceof LayoutParams) == false) goto L11;
        return (LayoutParams) r101;
    L11:
        return (LayoutParams) generateLayoutParams(r101);
    L13:
        return (LayoutParams) generateDefaultLayoutParams();
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

    public final boolean d(View r100) {
        if (r100 != null) goto L5;
        return false;
    L5:
        LayoutParams r101 = b(r100);
        if (this.f248353e == true) goto L8;
        return false;
    L8:
        if (r101.f248373c == true) goto L10;
        return false;
    L10:
        if (this.f248355g <= 0.0f) goto L15;
        return true;
    L15:
        return false;
    }

    @Override // android.view.View
    public final void draw(Canvas r100) {
        super.draw(r100);
        if (e() == false) goto L5;
        Drawable r101 = this.f248352d;
    L7:
        if (getChildCount() <= 1) goto L9;
        View r102 = getChildAt(1);
    L10:
        if (r102 == null) goto L17;
        if (r101 == null) goto L17;
        int r103 = r102.getTop();
        int r104 = r102.getBottom();
        int r105 = r101.getIntrinsicWidth();
        if (e() == false) goto L15;
        int r106 = r102.getRight();
        int r107 = r105 + r106;
    L16:
        r101.setBounds(r106, r103, r107, r104);
        r101.draw(r100);
        goto L17
    L15:
        int r108 = r102.getLeft();
        r106 = r108 - r105;
        r107 = r108;
    L17:
        if (r102 != null) goto L19;
        return;
    L19:
        if (this.f248367s == false) goto L26;
        int r109 = Color.argb((int) ((1.0f - this.f248355g) * 87.0f), 0, 0, 0);
        this.f248368t.setColor(r109);
        int r110 = r102.getBottom();
        if (e() == false) goto L23;
        int r111 = r102.getRight();
        WindowManager r112 = (WindowManager) getContext().getSystemService(LiveEndPageData.TAG_WINDOW);
        DisplayMetrics r113 = new DisplayMetrics();
        r112.getDefaultDisplay().getMetrics(r113);
        r100.drawRect(new Rect(r111, 0, r113.widthPixels, r110), this.f248368t);
        return;
    L23:
        r100.drawRect(new Rect(0, 0, r102.getLeft(), r110), this.f248368t);
        return;
    L26:
        return;
    L9:
        r102 = null;
        goto L10
    L5:
        r101 = this.f248351c;
        goto L7
    }

    public final void f(float r110) {
        boolean r100 = e();
        LayoutParams r101 = b(this.f248354f);
        int r102 = 0;
        if (r101.f248373c == false) goto L9;
        if (r100 == false) goto L6;
        int r103 = ((ViewGroup.MarginLayoutParams) r101).rightMargin;
    L7:
        if (r103 > 0) goto L9;
        boolean r104 = true;
    L10:
        int r105 = getChildCount();
    L11:
        if (r102 >= r105) goto L25;
        View r106 = getChildAt(r102);
        if (r106 == this.f248354f) goto L24;
        float r107 = 1.0f - this.f248356h;
        int r108 = this.f248359k;
        this.f248356h = r110;
        int r109 = ((int) (r107 * r108)) - ((int) ((1.0f - r110) * r108));
        if (r100 == false) goto L17;
        r109 = -r109;
    L17:
        r106.offsetLeftAndRight(r109);
        if (r104 == false) goto L24;
        float r111 = this.f248356h;
        if (r100 == false) goto L22;
        float r112 = r111 - 1.0f;
    L23:
        a(r106, r112, this.f248350b);
        goto L24
    L22:
        r112 = 1.0f - r111;
    L24:
        r102 = r102 + 1;
        goto L11
    L25:
        return;
    L6:
        r103 = ((ViewGroup.MarginLayoutParams) r101).leftMargin;
    L9:
        r104 = false;
        goto L10
    }

    public final boolean g(float r100) {
        if (this.f248353e == true) goto L5;
        return false;
    L5:
        boolean r101 = e();
        LayoutParams r102 = b(this.f248354f);
        if (r101 == false) goto L8;
        int r103 = getPaddingRight() + ((ViewGroup.MarginLayoutParams) r102).rightMargin;
        int r104 = (int) (getWidth() - ((r103 + (r100 * this.f248357i)) + this.f248354f.getWidth()));
    L9:
        ViewDragHelper r105 = this.f248362n;
        View r106 = this.f248354f;
        if (r105.smoothSlideViewTo(r106, r104, r106.getTop()) == false) goto L19;
        int r107 = getChildCount();
        int r108 = 0;
    L12:
        if (r108 >= r107) goto L17;
        View r109 = getChildAt(r108);
        if (r109.getVisibility() != 4) goto L16;
        r109.setVisibility(0);
    L16:
        r108 = r108 + 1;
        goto L12
    L17:
        ViewCompat.postInvalidateOnAnimation(this);
        return true;
    L19:
        return false;
    L8:
        r104 = (int) ((getPaddingLeft() + ((ViewGroup.MarginLayoutParams) r102).leftMargin) + (r100 * this.f248357i));
        goto L9
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams r100) {
        if ((r100 instanceof ViewGroup.MarginLayoutParams) == false) goto L6;
        return new LayoutParams((ViewGroup.MarginLayoutParams) r100);
    L6:
        return new LayoutParams(r100);
    }

    public final void h(View r110) {
        View r100 = r110;
        getActivity(getContext());
        boolean r101 = e();
        if (r101 == false) goto L5;
        int r102 = getWidth() - getPaddingRight();
    L6:
        if (r101 == false) goto L8;
        int r103 = getPaddingLeft();
    L9:
        int r104 = getPaddingTop();
        int r105 = getHeight() - getPaddingBottom();
        if (r100 != null) goto L12;
    L14:
        int r106 = 0;
        int r107 = 0;
        int r108 = 0;
        int r111 = 0;
    L15:
        int r112 = getChildCount();
        int r113 = 0;
    L17:
        if (r113 >= r112) goto L40;
        View r114 = getChildAt(r113);
        if (r114 == r100) goto L45;
        if (r114.getVisibility() == 8) goto L39;
        if (r101 == false) goto L25;
        int r109 = r103;
    L26:
        int r115 = Math.max(r109, r114.getLeft());
        int r116 = Math.max(r104, r114.getTop());
        if (r101 == false) goto L29;
        int r117 = r102;
    L30:
        int r118 = Math.min(r117, r114.getRight());
        int r119 = Math.min(r105, r114.getBottom());
        if (r115 < r106) goto L36;
        if (r116 < r108) goto L36;
        if (r118 > r107) goto L36;
        if (r119 > r111) goto L36;
        int r120 = 4;
    L37:
        r114.setVisibility(r120);
    L36:
        r120 = 0;
        goto L37
    L29:
        r117 = r103;
        goto L30
    L25:
        r109 = r102;
    L39:
        r113 = r113 + 1;
        r100 = r110;
        r101 = r101;
        goto L17
    L45:
        return;
    L40:
        return;
    L12:
        if (r110.isOpaque() == false) goto L14;
        r106 = r110.getLeft();
        r107 = r110.getRight();
        r108 = r110.getTop();
        r111 = r110.getBottom();
        goto L15
    L8:
        r103 = getWidth() - getPaddingRight();
        goto L9
    L5:
        r102 = getPaddingLeft();
        goto L6
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r100) {
        int r101 = r100.getActionMasked();
        if (this.f248353e == true) goto L11;
        if (r101 != 0) goto L11;
        if (getChildCount() <= 1) goto L11;
        View r102 = getChildAt(1);
        if (r102 == null) goto L11;
        this.f248363o = !this.f248362n.isViewUnder(r102, (int) r100.getX(), (int) r100.getY());
    L11:
        if (this.f248353e == true) goto L13;
    L43:
        this.f248362n.cancel();
        return super.onInterceptTouchEvent(r100);
    L13:
        if (this.f248358j == false) goto L17;
        if (r101 != 0) goto L43;
    L17:
        if (r101 == 3) goto L41;
        if (r101 == 1) goto L41;
        if (r101 != 0) goto L21;
        this.f248358j = false;
        float r103 = r100.getX();
        float r104 = r100.getY();
        this.f248360l = r103;
        this.f248361m = r104;
        if (this.f248362n.isViewUnder(this.f248354f, (int) r103, (int) r104) == true) goto L32;
    L34:
        boolean r105 = false;
    L36:
        if (this.f248362n.shouldInterceptTouchEvent(r100) == true) goto L45;
        if (r105 == true) goto L46;
        return false;
    L46:
        return true;
    L45:
        return true;
    L32:
        if (d(this.f248354f) == false) goto L34;
        r105 = true;
        goto L36
    L21:
        if (r101 != 2) goto L34;
        float r106 = r100.getX();
        float r107 = r100.getY();
        float r108 = Math.abs(r106 - this.f248360l);
        float r109 = Math.abs(r107 - this.f248361m);
        if (r108 <= this.f248362n.getTouchSlop()) goto L34;
        if (r109 <= r108) goto L34;
        this.f248362n.cancel();
        this.f248358j = true;
        return false;
    L41:
        this.f248362n.cancel();
        return false;
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable r100) {
        if ((r100 instanceof SavedState) == true) goto L5;
        super.onRestoreInstanceState(r100);
        return;
    L5:
        SavedState r101 = (SavedState) r100;
        super.onRestoreInstanceState(r101.getSuperState());
        if (r101.f248375a == false) goto L14;
        if (this.f248364p == false) goto L10;
    L12:
        this.f248363o = true;
    L19:
        this.f248363o = r101.f248375a;
        return;
    L10:
        if (g(1.0f) == true) goto L12;
    L14:
        if (this.f248364p == false) goto L16;
    L18:
        this.f248363o = false;
        goto L19
    L16:
        if (g(0.0f) == true) goto L18;
        goto L18
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r100) {
        if (this.f248353e == false) goto L5;
        this.f248362n.processTouchEvent(r100);
        int r101 = r100.getActionMasked();
        if (r101 == 0) goto L22;
        if (r101 == 1) goto L11;
    L23:
        return true;
    L11:
        if (d(this.f248354f) == false) goto L23;
        float r102 = r100.getX();
        float r103 = r100.getY();
        float r104 = r102 - this.f248360l;
        float r105 = r103 - this.f248361m;
        int r106 = this.f248362n.getTouchSlop();
        if (((r104 * r104) + (r105 * r105)) >= (r106 * r106)) goto L23;
        if (this.f248362n.isViewUnder(this.f248354f, (int) r102, (int) r103) == false) goto L23;
        if (this.f248364p == false) goto L19;
    L21:
        this.f248363o = false;
        goto L23
    L19:
        if (g(0.0f) == true) goto L21;
    L22:
        float r107 = r100.getX();
        float r108 = r100.getY();
        this.f248360l = r107;
        this.f248361m = r108;
        goto L23
    L5:
        return super.onTouchEvent(r100);
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public final void removeView(View r100) {
        super.removeView(r100);
    }

    @Override // android.view.ViewGroup
    public final void removeViewAt(int r100) {
        super.removeViewAt(r100);
    }

    public void setCoveredFadeColor(int r100) {
        this.f248350b = r100;
    }

    public void setEnableMask(boolean r100) {
        this.f248367s = r100;
    }

    public void setParallaxDistance(int r100) {
        this.f248359k = r100;
        requestLayout();
    }

    public void setShadowDrawable(Drawable r100) {
        setShadowDrawableLeft(r100);
    }

    public void setShadowDrawableLeft(Drawable r100) {
        this.f248351c = r100;
    }

    public void setShadowDrawableRight(Drawable r100) {
        this.f248352d = r100;
    }

    public void setShadowResource(int r100) {
        setShadowDrawable(getResources().getDrawable(r100));
    }

    public void setShadowResourceLeft(int r100) {
        setShadowDrawableLeft(ContextCompat.getDrawable(getContext(), r100));
    }

    public void setShadowResourceRight(int r100) {
        setShadowDrawableRight(ContextCompat.getDrawable(getContext(), r100));
    }

    public void setSliderFadeColor(int r100) {
        this.f248349a = r100;
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet r100) {
        return new LayoutParams(getContext(), r100);
    }

    public DmtSlidingPaneLayout(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    @Override // android.view.View
    public final void onMeasure(int r210, int r211) {
        Activity r100 = getActivity(getContext());
        if (c(r100) != 0) goto L5;
        int r101 = f248348u;
    L6:
        int r102 = View.MeasureSpec.getMode(r210);
        int r103 = View.MeasureSpec.getSize(r210);
        int r104 = View.MeasureSpec.getMode(r211);
        Resources r105 = r100.getResources();
        int r106 = r105.getIdentifier("status_bar_height", "dimen", "android");
        boolean r107 = false;
        if (r106 <= 0) goto L9;
        int r108 = r105.getDimensionPixelSize(r106);
    L10:
        int r109 = r101 + r108;
        if (r102 != 1073741824) goto L13;
        if (r104 == 0) goto L22;
    L27:
        if (r104 == Integer.MIN_VALUE) goto L32;
        if (r104 == 1073741824) goto L31;
        int r110 = 0;
    L30:
        int r111 = 0;
    L33:
        int r112 = (r103 - getPaddingLeft()) - getPaddingRight();
        int r113 = getChildCount();
        this.f248354f = null;
        int r114 = r112;
        int r115 = 0;
        boolean r116 = false;
        float r117 = 0.0f;
    L34:
        int r118 = 8;
        if (r115 >= r113) goto L72;
        View r119 = getChildAt(r115);
        LayoutParams r120 = b(r119);
        if (r119.getVisibility() != 8) goto L39;
        r120.f248373c = r107;
    L71:
        r115 = r115 + 1;
        r107 = false;
        goto L34
    L39:
        float r121 = r120.f248371a;
        if (r121 <= 0.0f) goto L44;
        r117 = r117 + r121;
        if (((ViewGroup.MarginLayoutParams) r120).width == 0) goto L71;
    L44:
        int r122 = ((ViewGroup.MarginLayoutParams) r120).leftMargin + ((ViewGroup.MarginLayoutParams) r120).rightMargin;
        int r123 = ((ViewGroup.MarginLayoutParams) r120).width;
        if (r123 != (-2)) goto L47;
        int r124 = View.MeasureSpec.makeMeasureSpec(r112 - r122, Integer.MIN_VALUE);
        float r212 = r117;
        int r125 = Integer.MIN_VALUE;
    L51:
        int r126 = ((ViewGroup.MarginLayoutParams) r120).height;
        if (r126 != (-2)) goto L55;
        int r127 = View.MeasureSpec.makeMeasureSpec(r110, r125);
    L59:
        r119.measure(r124, r127);
        int r128 = r119.getMeasuredWidth();
        int r129 = r119.getMeasuredHeight();
        if (r104 != Integer.MIN_VALUE) goto L63;
        if (r129 <= r111) goto L63;
        r111 = Math.min(r129, r110);
    L63:
        r114 = r114 - r128;
        if (r114 >= 0) goto L66;
        boolean r130 = true;
    L67:
        r120.f248372b = r130;
        r116 = r116 | r130;
        if (r130 == false) goto L70;
        this.f248354f = r119;
    L70:
        r117 = r212;
        goto L71
    L66:
        r130 = false;
        goto L67
    L55:
        if (r126 != (-1)) goto L57;
        int r131 = View.MeasureSpec.makeMeasureSpec(r110, 1073741824);
    L58:
        r127 = r131;
        goto L59
    L57:
        r131 = View.MeasureSpec.makeMeasureSpec(r126, 1073741824);
        goto L58
    L47:
        r212 = r117;
        r125 = Integer.MIN_VALUE;
        if (r123 != (-1)) goto L50;
        r124 = View.MeasureSpec.makeMeasureSpec(r112 - r122, 1073741824);
        goto L51
    L50:
        r124 = View.MeasureSpec.makeMeasureSpec(r123, 1073741824);
        goto L51
    L72:
        if (r116 == false) goto L74;
    L75:
        int r132 = r112 + 0;
        int r133 = 0;
    L76:
        if (r133 >= r113) goto L128;
        View r134 = getChildAt(r133);
        if (r134.getVisibility() == r118) goto L125;
        LayoutParams r135 = b(r134);
        if (r134.getVisibility() == r118) goto L125;
        if (((ViewGroup.MarginLayoutParams) r135).width == 0) goto L84;
    L86:
        boolean r136 = false;
    L87:
        if (r136 == false) goto L89;
        int r137 = 0;
    L90:
        if (r116 == false) goto L109;
        if (r134 == this.f248354f) goto L109;
        if (((ViewGroup.MarginLayoutParams) r135).width >= 0) goto L125;
        if (r137 <= r132) goto L97;
    L98:
        if (r136 == false) goto L106;
        int r138 = ((ViewGroup.MarginLayoutParams) r135).height;
        if (r138 != (-2)) goto L103;
        int r139 = View.MeasureSpec.makeMeasureSpec(r110, Integer.MIN_VALUE);
        int r140 = 1073741824;
    L107:
        r134.measure(View.MeasureSpec.makeMeasureSpec(r132, r140), r139);
        goto L125
    L103:
        if (r138 != (-1)) goto L105;
        r140 = 1073741824;
        r139 = View.MeasureSpec.makeMeasureSpec(r110, 1073741824);
        goto L107
    L105:
        r140 = 1073741824;
        r139 = View.MeasureSpec.makeMeasureSpec(r138, 1073741824);
        goto L107
    L106:
        r140 = 1073741824;
        r139 = View.MeasureSpec.makeMeasureSpec(r134.getMeasuredHeight(), 1073741824);
        goto L107
    L97:
        if (r135.f248371a <= 0.0f) goto L125;
    L109:
        if (r135.f248371a <= 0.0f) goto L125;
        if (((ViewGroup.MarginLayoutParams) r135).width != 0) goto L119;
        int r141 = ((ViewGroup.MarginLayoutParams) r135).height;
        if (r141 != (-2)) goto L116;
        int r142 = View.MeasureSpec.makeMeasureSpec(r110, Integer.MIN_VALUE);
    L120:
        if (r116 == false) goto L124;
        int r143 = r112 - (((ViewGroup.MarginLayoutParams) r135).leftMargin + ((ViewGroup.MarginLayoutParams) r135).rightMargin);
        int r144 = r110;
        int r145 = View.MeasureSpec.makeMeasureSpec(r143, 1073741824);
        if (r137 == r143) goto L127;
        r134.measure(r145, r142);
    L127:
        r133 = r133 + 1;
        r110 = r144;
        r118 = 8;
        goto L76
    L124:
        r144 = r110;
        r134.measure(View.MeasureSpec.makeMeasureSpec(r137 + ((int) ((r135.f248371a * Math.max(0, r114)) / r117)), 1073741824), r142);
        goto L127
    L116:
        if (r141 != (-1)) goto L118;
        r142 = View.MeasureSpec.makeMeasureSpec(r110, 1073741824);
        goto L120
    L118:
        r142 = View.MeasureSpec.makeMeasureSpec(r141, 1073741824);
        goto L120
    L119:
        r142 = View.MeasureSpec.makeMeasureSpec(r134.getMeasuredHeight(), 1073741824);
        goto L120
    L89:
        r137 = r134.getMeasuredWidth();
        goto L90
    L84:
        if (r135.f248371a <= 0.0f) goto L86;
        r136 = true;
    L125:
        r144 = r110;
    L128:
        setMeasuredDimension(r103, (r111 + getPaddingTop()) + getPaddingBottom());
        this.f248353e = r116;
        if (this.f248362n.getViewDragState() == 0) goto L140;
        if (r116 == true) goto L141;
        this.f248362n.abort();
        return;
    L141:
        return;
    L140:
        return;
    L74:
        if (r117 <= 0.0f) goto L128;
    L31:
        r111 = (r109 - getPaddingTop()) - getPaddingBottom();
        r110 = r111;
        goto L33
    L32:
        r110 = (r109 - getPaddingTop()) - getPaddingBottom();
        goto L30
    L22:
        if (isInEditMode() == false) goto L26;
        if (r104 != 0) goto L27;
        r109 = 300;
        r104 = Integer.MIN_VALUE;
        goto L27
    L26:
        throw new IllegalStateException("Height must not be UNSPECIFIED");
    L13:
        if (isInEditMode() == false) goto L19;
        if (r102 == Integer.MIN_VALUE) goto L27;
        if (r102 != 0) goto L27;
        r103 = 300;
        goto L27
    L19:
        throw new IllegalStateException("Width must have an exact value or MATCH_PARENT");
    L9:
        r108 = 0;
        goto L10
    L5:
        r101 = c(r100);
        goto L6
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void requestChildFocus(View r100, View r101) {
        super.requestChildFocus(r100, r101);
        if (isInTouchMode() == false) goto L5;
        return;
    L5:
        if (this.f248353e == false) goto L7;
        return;
    L7:
        if (r100 != this.f248354f) goto L9;
        boolean r102 = true;
    L10:
        this.f248363o = r102;
        return;
    L9:
        r102 = false;
        goto L10
    }

    public DmtSlidingPaneLayout(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f248367s = false;
        this.f248368t = new Paint();
        this.f248349a = -858993460;
        this.f248364p = true;
        this.f248365q = new Rect();
        this.f248366r = new ArrayList();
        Resources r103 = r100.getResources();
        float r104 = WindowDisplayMetricsOverride.apply(r103, r103.getDisplayMetrics()).density;
        setWillNotDraw(false);
        ViewCompat.setAccessibilityDelegate(this, new a(this));
        ViewCompat.setImportantForAccessibility(this, 1);
        ViewDragHelper r105 = ViewDragHelper.create(this, 0.5f, new c(this, getDragSettleStrategy()));
        this.f248362n = r105;
        r105.setMinVelocity(r104 * 400.0f);
    }

    public final void a(View r100, float r101, int r102) {
        LayoutParams r103 = b(r100);
        if (r101 <= 0.0f) goto L13;
        if (r102 == 0) goto L13;
        int r104 = (((int) ((((-16777216) & r102) >>> 24) * r101)) << 24) | (r102 & 16777215);
        if (r103.f248374d != null) goto L8;
        r103.f248374d = new Paint();
    L8:
        r103.f248374d.setColorFilter(new PorterDuffColorFilter(r104, PorterDuff.Mode.SRC_OVER));
        if (r100.getLayerType() == 2) goto L11;
        r100.setLayerType(2, r103.f248374d);
    L11:
        ViewCompat.setLayerPaint(r100, b(r100).f248374d);
        return;
    L13:
        if (r100.getLayerType() == 0) goto L20;
        Paint r105 = r103.f248374d;
        if (r105 == null) goto L17;
        r105.setColorFilter(null);
    L17:
        b r106 = new b(this, r100);
        this.f248366r.add(r106);
        ViewCompat.postOnAnimation(this, r106);
        return;
    }

    @Override // android.view.ViewGroup
    public final boolean drawChild(Canvas r100, View r101, long r102) {
        LayoutParams r103 = b(r101);
        int r104 = r100.save();
        if (this.f248353e == true) goto L5;
    L13:
        boolean r105 = super.drawChild(r100, r101, r102);
        r100.restoreToCount(r104);
        return r105;
    L5:
        if (r103.f248372b == true) goto L13;
        if (this.f248354f == null) goto L13;
        r100.getClipBounds(this.f248365q);
        if (e() == false) goto L11;
        Rect r106 = this.f248365q;
        r106.left = Math.max(r106.left, this.f248354f.getRight());
    L12:
        r100.clipRect(this.f248365q);
        goto L13
    L11:
        Rect r107 = this.f248365q;
        r107.right = Math.min(r107.right, this.f248354f.getLeft());
        goto L12
    }

    @Override // android.view.View
    public final void onSizeChanged(int r100, int r101, int r102, int r103) {
        super.onSizeChanged(r100, r101, r102, r103);
        if (r100 == r102) goto L6;
        this.f248364p = true;
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r110, int r210, int r211, int r212, int r213) {
        boolean r100 = e();
        if (r100 == false) goto L5;
        this.f248362n.setEdgeTrackingEnabled(2);
    L6:
        int r101 = r212 - r210;
        if (r100 == false) goto L9;
        int r102 = getPaddingRight();
    L10:
        if (r100 == false) goto L12;
        int r103 = getPaddingLeft();
    L13:
        int r104 = getPaddingTop();
        int r105 = getChildCount();
        if (this.f248364p == true) goto L16;
    L22:
        int r111 = r102;
        int r112 = 0;
    L23:
        if (r112 >= r105) goto L50;
        View r113 = getChildAt(r112);
        if (r113.getVisibility() == 8) goto L48;
        LayoutParams r114 = b(r113);
        int r115 = r113.getMeasuredWidth();
        if (r114.f248372b == false) goto L38;
        int r106 = r101 - r103;
        int r116 = (Math.min(r102, r106 + 0) - r111) - (((ViewGroup.MarginLayoutParams) r114).leftMargin + ((ViewGroup.MarginLayoutParams) r114).rightMargin);
        this.f248357i = r116;
        if (r100 == false) goto L31;
        int r107 = ((ViewGroup.MarginLayoutParams) r114).rightMargin;
    L33:
        if ((((r111 + r107) + r116) + (r115 / 2)) <= r106) goto L35;
        boolean r108 = true;
    L36:
        r114.f248373c = r108;
        int r109 = (int) (r116 * this.f248355g);
        r111 = r111 + (r107 + r109);
        this.f248355g = r109 / r116;
        int r117 = 0;
    L43:
        if (r100 == false) goto L45;
        int r118 = (r101 - r111) + r117;
        int r119 = r118 - r115;
    L46:
        r113.layout(r119, r104, r118, r113.getMeasuredHeight() + r104);
        r102 = r102 + r113.getWidth();
        goto L48
    L45:
        r119 = r111 - r117;
        r118 = r119 + r115;
        goto L46
    L35:
        r108 = false;
        goto L36
    L31:
        r107 = ((ViewGroup.MarginLayoutParams) r114).leftMargin;
        goto L33
    L38:
        if (this.f248353e == false) goto L42;
        int r120 = this.f248359k;
        if (r120 == 0) goto L42;
        r117 = (int) ((1.0f - this.f248355g) * r120);
        r111 = r102;
    L42:
        r111 = r102;
        r117 = 0;
    L48:
        r112 = r112 + 1;
        goto L23
    L50:
        if (this.f248364p == true) goto L52;
    L63:
        this.f248364p = false;
        return;
    L52:
        if (this.f248353e == true) goto L54;
        int r121 = 0;
    L60:
        if (r121 >= r105) goto L62;
        a(getChildAt(r121), 0.0f, this.f248349a);
        r121 = r121 + 1;
    L62:
        h(this.f248354f);
        goto L63
    L54:
        if (this.f248359k == 0) goto L57;
        f(this.f248355g);
    L57:
        if (b(this.f248354f).f248373c == false) goto L62;
        a(this.f248354f, this.f248355g, this.f248349a);
        goto L62
    L16:
        if (this.f248353e == true) goto L18;
    L20:
        float r122 = 0.0f;
    L21:
        this.f248355g = r122;
        goto L22
    L18:
        if (this.f248363o == false) goto L20;
        r122 = 1.0f;
        goto L21
    L12:
        r103 = getPaddingRight();
        goto L13
    L9:
        r102 = getPaddingLeft();
        goto L10
    L5:
        this.f248362n.setEdgeTrackingEnabled(1);
        goto L6
    }
}
