package com.ss.android.lark.widget.slidingup;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.widget.ListView;
import android.widget.ScrollView;
import androidx.core.view.MotionEventCompat;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.log.Log;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes38.dex */
public class SlidingUpPanelLayout extends ViewGroup {
    public static final PanelState I = null;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public static final int[] f448516J = null;
    public float A;
    public float B;
    public boolean C;
    public final List<d> D;
    public View.OnClickListener E;
    public final com.ss.android.lark.widget.slidingup.a F;
    public boolean G;
    public final Rect H;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f448517a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f448518b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Paint f448519c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Drawable f448520d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f448521e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f448522f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f448523g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f448524h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f448525i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f448526j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public View f448527k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f448528l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public View f448529m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final int f448530n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public qec.a f448531o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public View f448532p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public View f448533q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public PanelState f448534r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public PanelState f448535s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public float f448536t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f448537u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public float f448538v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f448539w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f448540x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public float f448541y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public float f448542z;

    public static class LayoutParams extends ViewGroup.MarginLayoutParams {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final int[] f448543b = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final float f448544a;

        static {
            f448543b = new int[]{R.attr.layout_weight};
        }

        public LayoutParams() {
            super(-1, -1);
            this.f448544a = 0.0f;
        }

        public LayoutParams(ViewGroup.LayoutParams r100) {
            super(r100);
            this.f448544a = 0.0f;
        }

        public LayoutParams(ViewGroup.MarginLayoutParams r100) {
            super(r100);
            this.f448544a = 0.0f;
        }

        public LayoutParams(Context r100, AttributeSet r101) {
            super(r100, r101);
            this.f448544a = 0.0f;
            TypedArray r102 = r100.obtainStyledAttributes(r101, f448543b);
            if (r102 == null) goto L6;
            this.f448544a = r102.getFloat(0, 0.0f);
            r102.recycle();
            return;
        }
    }

    public static final enum PanelState extends Enum<PanelState> {
        public static final PanelState ANCHORED = null;
        public static final PanelState COLLAPSED = null;
        public static final PanelState DRAGGING = null;
        public static final PanelState EXPANDED = null;
        public static final PanelState HIDDEN = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ PanelState[] f448545a = null;

        static {
            PanelState r100 = new PanelState("EXPANDED", 0);
            EXPANDED = r100;
            PanelState r101 = new PanelState("COLLAPSED", 1);
            COLLAPSED = r101;
            PanelState r102 = new PanelState("ANCHORED", 2);
            ANCHORED = r102;
            PanelState r103 = new PanelState("HIDDEN", 3);
            HIDDEN = r103;
            PanelState r104 = new PanelState("DRAGGING", 4);
            DRAGGING = r104;
            f448545a = new PanelState[]{r100, r101, r102, r103, r104};
        }

        public static PanelState[] values() {
            return (PanelState[]) f448545a.clone();
        }

        public static PanelState valueOf(String r100) {
            return (PanelState) r27.a.a(PanelState.class, r100);
        }

        public PanelState(String r100, int r101) {
            super(r100, r101);
        }
    }

    public class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SlidingUpPanelLayout f448546a;

        public a(SlidingUpPanelLayout r100) {
            this.f448546a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            if (this.f448546a.isEnabled() == true) goto L5;
            return;
        L5:
            if (this.f448546a.e() == false) goto L20;
            SlidingUpPanelLayout r101 = this.f448546a;
            PanelState r102 = r101.f448534r;
            PanelState r103 = PanelState.EXPANDED;
            if (r102 == r103) goto L15;
            PanelState r104 = PanelState.ANCHORED;
            if (r102 == r104) goto L15;
            if (r101.f448538v >= 1.0f) goto L14;
            r101.setPanelState(r104);
            return;
        L14:
            r101.setPanelState(r103);
            return;
        L15:
            r101.setPanelState(PanelState.COLLAPSED);
            return;
        }
    }

    public static /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f448547a = null;

        static {
            int[] r100 = new int[PanelState.values().length];
            f448547a = r100;
            r100[PanelState.EXPANDED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L12:
            f448547a[PanelState.ANCHORED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L14:
            f448547a[PanelState.HIDDEN.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L18:
            f448547a[PanelState.COLLAPSED.ordinal()] = 4;     // Catch: NoSuchFieldError -> L11
            return;
        }
    }

    public class c extends com.ss.android.lark.widget.slidingup.a.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SlidingUpPanelLayout f448548a;

        public c(SlidingUpPanelLayout r100) {
            this.f448548a = r100;
        }
    }

    public interface d {
        void a();

        void b(PanelState r100, PanelState r101);
    }

    static {
        I = PanelState.COLLAPSED;
        f448516J = new int[]{R.attr.gravity};
    }

    @Override // android.view.View
    public final void computeScroll() {
        com.ss.android.lark.widget.slidingup.a r100 = this.F;
        if (r100 == null) goto L38;
        boolean r101 = false;
        if (r100.f448566q != null) goto L8;
    L31:
        if (r101 == true) goto L33;
        return;
    L33:
        if (isEnabled() == true) goto L36;
        this.F.a();
        return;
    L36:
        ViewCompat.postInvalidateOnAnimation(this);
        return;
    L8:
        if (r100.f448550a != 2) goto L29;
        boolean r102 = r100.f448564o.computeScrollOffset();
        int r103 = r100.f448564o.getCurrX();
        int r104 = r100.f448564o.getCurrY();
        int r105 = r103 - r100.f448566q.getLeft();
        int r106 = r104 - r100.f448566q.getTop();
        if (r102 == true) goto L13;
        if (r106 == 0) goto L13;
        r100.f448566q.setTop(0);
    L30:
        r101 = true;
    L13:
        if (r105 == 0) goto L15;
        r100.f448566q.offsetLeftAndRight(r105);
    L15:
        if (r106 == 0) goto L17;
        r100.f448566q.offsetTopAndBottom(r106);
    L17:
        if (r105 != 0) goto L19;
        if (r106 != 0) goto L19;
    L20:
        if (r102 == true) goto L22;
    L26:
        if (r102 == true) goto L29;
        r100.f448568s.post(r100.f448569t);
        goto L29
    L22:
        if (r103 != r100.f448564o.getFinalX()) goto L26;
        if (r104 != r100.f448564o.getFinalY()) goto L26;
        r100.f448564o.abortAnimation();
        r102 = r100.f448564o.isFinished();
    L19:
        c r107 = (c) r100.f448565p;
        a(r107.f448548a, r104);
        r107.f448548a.invalidate();
    L29:
        if (r100.f448550a != 2) goto L31;
    }

    public final boolean e() {
        if (this.f448540x == true) goto L5;
    L9:
        return false;
    L5:
        if (this.f448532p == null) goto L9;
        if (this.f448534r == PanelState.HIDDEN) goto L9;
        return true;
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams();
    }

    public int getCurrentParallaxOffset() {
        int r100 = (int) (this.f448523g * Math.max(this.f448536t, 0.0f));
        if (this.f448524h == true) goto L5;
        return r100;
    L5:
        return -r100;
    }

    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        Bundle r100 = new Bundle();
        r100.putParcelable("superState", super.onSaveInstanceState());
        PanelState r101 = this.f448534r;
        if (r101 != PanelState.DRAGGING) goto L6;
        r101 = this.f448535s;
    L6:
        r100.putSerializable("sliding_state", r101);
        return r100;
    }

    public final void h() {
        if (getChildCount() != 0) goto L5;
        return;
    L5:
        int r100 = getPaddingLeft();
        int r101 = getWidth() - getPaddingRight();
        int r102 = getPaddingTop();
        int r103 = getHeight() - getPaddingBottom();
        View r104 = this.f448532p;
        int r105 = 0;
        if (r104 == null) goto L15;
        Drawable r106 = r104.getBackground();
        if (r106 != null) goto L10;
    L12:
        boolean r107 = false;
    L13:
        if (r107 == false) goto L15;
        int r108 = this.f448532p.getLeft();
        int r109 = this.f448532p.getRight();
        int r110 = this.f448532p.getTop();
        int r111 = this.f448532p.getBottom();
    L16:
        View r112 = getChildAt(0);
        int r113 = Math.max(r100, r112.getLeft());
        int r114 = Math.max(r102, r112.getTop());
        int r115 = Math.min(r101, r112.getRight());
        int r116 = Math.min(r103, r112.getBottom());
        if (r113 < r108) goto L22;
        if (r114 < r110) goto L22;
        if (r115 > r109) goto L22;
        if (r116 > r111) goto L22;
        r105 = 4;
    L22:
        r112.setVisibility(r105);
        return;
    L10:
        if (r106.getOpacity() != (-1)) goto L12;
        r107 = true;
    L15:
        r108 = 0;
        r109 = 0;
        r110 = 0;
        r111 = 0;
        goto L16
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.G = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.G = true;
    }

    @Override // android.view.View
    public final void onFinishInflate() {
        super.onFinishInflate();
        int r100 = this.f448528l;
        if (r100 == (-1)) goto L5;
        setDragView(findViewById(r100));
    L5:
        int r101 = this.f448530n;
        if (r101 == (-1)) goto L9;
        setScrollableView(findViewById(r101));
        return;
    }

    public float getAnchorPoint() {
        return this.f448538v;
    }

    public int getCoveredFadeColor() {
        return this.f448518b;
    }

    public View getDragView() {
        return this.f448527k;
    }

    public int getMinFlingVelocity() {
        return this.f448517a;
    }

    public int getPanelHeight() {
        return this.f448521e;
    }

    public PanelState getPanelState() {
        return this.f448534r;
    }

    public int getShadowHeight() {
        return this.f448522f;
    }

    public SlidingUpPanelLayout(Context r100) {
        this(r100, null);
    }

    private void setPanelStateInternal(PanelState r100) {
        PanelState r101 = this.f448534r;
        if (r101 != r100) goto L5;
        return;
    L5:
        this.f448534r = r100;
        List<d> r102 = this.D;
        monitor-enter(r102);
        Iterator r103 = ((CopyOnWriteArrayList) this.D).iterator();     // Catch: Throwable -> L14
    L9:
        if (r103.hasNext() == false) goto L11;
        ((d) r103.next()).b(r101, r100);     // Catch: Throwable -> L14
        goto L9
    L11:
        monitor-exit(r102);     // Catch: Throwable -> L14
        sendAccessibilityEvent(32);
        return;
    L14:
        th = move-exception;
        throw th;
    }

    public final int c(float r100) {
        View r101 = this.f448532p;
        if (r101 == null) goto L5;
        int r102 = r101.getMeasuredHeight();
    L6:
        int r103 = (int) (r100 * this.f448537u);
        if (this.f448524h == false) goto L10;
        return ((getMeasuredHeight() - getPaddingBottom()) - this.f448521e) - r103;
    L10:
        return ((getPaddingTop() - r102) + this.f448521e) + r103;
    L5:
        r102 = 0;
        goto L6
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

    public final float d(int r100) {
        int r101 = c(0.0f);
        if (this.f448524h == false) goto L5;
        float r102 = r101 - r100;
        int r103 = this.f448537u;
    L7:
        return r102 / r103;
    L5:
        r102 = r100 - r101;
        r103 = this.f448537u;
        goto L7
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r100) {
        int r101 = MotionEventCompat.getActionMasked(r100);
        if (isEnabled() == true) goto L5;
    L91:
        this.F.a();
        return super.dispatchTouchEvent(r100);
    L5:
        if (e() == false) goto L91;
        if (this.f448539w == false) goto L10;
        if (r101 != 0) goto L91;
    L10:
        float r102 = r100.getX();
        float r103 = r100.getY();
        if (r101 != 0) goto L14;
        this.C = false;
        this.f448541y = r102;
        this.f448542z = r103;
    L90:
        return super.dispatchTouchEvent(r100);
    L14:
        if (r101 != 2) goto L85;
        float r104 = r102 - this.f448541y;
        float r105 = r103 - this.f448542z;
        this.f448541y = r102;
        this.f448542z = r103;
        if (Math.abs(r104) <= Math.abs(r105)) goto L20;
        return super.dispatchTouchEvent(r100);
    L20:
        if (f(this.f448529m, (int) this.A, (int) this.B) == false) goto L22;
        boolean r106 = this.f448524h;
        int r107 = -1;
        if (r106 == false) goto L26;
        int r108 = 1;
    L28:
        if ((r108 * r105) <= 0.0f) goto L67;
        qec.a r109 = this.f448531o;
        View r110 = this.f448529m;
        r109.getClass();
        if (r110 != null) goto L33;
    L58:
        int r111 = 0;
    L59:
        if (r111 <= 0) goto L63;
        this.C = true;
        return super.dispatchTouchEvent(r100);
    L63:
        if (this.C == false) goto L65;
        MotionEvent r112 = MotionEvent.obtain(r100);
        r112.setAction(3);
        super.dispatchTouchEvent(r112);
        r112.recycle();
        r100.setAction(0);
    L65:
        this.C = false;
        return onTouchEvent(r100);
    L33:
        if ((r110 instanceof ScrollView) == false) goto L38;
        if (r106 == false) goto L36;
        r111 = r110.getScrollY();
        goto L59
    L36:
        ScrollView r113 = (ScrollView) r110;
        r111 = r113.getChildAt(0).getBottom() - (r113.getHeight() + r113.getScrollY());
        goto L59
    L38:
        if ((r110 instanceof ListView) == false) goto L48;
        ListView r114 = (ListView) r110;
        if (r114.getChildCount() <= 0) goto L48;
        if (r114.getAdapter() == null) goto L58;
        if (r106 == false) goto L46;
        View r115 = r114.getChildAt(0);
        int r116 = r114.getFirstVisiblePosition() * r115.getHeight();
        int r117 = r115.getTop();
    L56:
        r111 = r116 - r117;
        goto L59
    L46:
        View r118 = r114.getChildAt(r114.getChildCount() - 1);
        r111 = ((((r114.getAdapter().getCount() - r114.getLastVisiblePosition()) - 1) * r118.getHeight()) + r118.getBottom()) - r114.getBottom();
    L48:
        if ((r110 instanceof RecyclerView) == false) goto L58;
        RecyclerView r119 = (RecyclerView) r110;
        if (r119.getChildCount() <= 0) goto L58;
        RecyclerView.LayoutManager r120 = r119.getLayoutManager();
        if (r119.getAdapter() == null) goto L58;
        if (r106 == false) goto L57;
        View r121 = r119.getChildAt(0);
        r116 = r119.getChildLayoutPosition(r121) * r120.getDecoratedMeasuredHeight(r121);
        r117 = r120.getDecoratedTop(r121);
        goto L56
    L57:
        View r122 = r119.getChildAt(r119.getChildCount() - 1);
        r111 = (((r119.getAdapter().getItemCount() - 1) * r120.getDecoratedMeasuredHeight(r122)) + r120.getDecoratedBottom(r122)) - r119.getBottom();
        goto L59
    L67:
        if (r106 == false) goto L70;
        r107 = 1;
    L70:
        if ((r105 * r107) >= 0.0f) goto L90;
        if (this.f448536t >= 1.0f) goto L76;
        this.C = false;
        return onTouchEvent(r100);
    L76:
        if (this.C == true) goto L83;
        com.ss.android.lark.widget.slidingup.a r123 = this.F;
        if (r123.f448550a != 1) goto L80;
        boolean r124 = true;
    L81:
        if (r124 == false) goto L83;
        r123.b();
        r100.setAction(0);
        goto L83
    L80:
        r124 = false;
    L83:
        this.C = true;
        return super.dispatchTouchEvent(r100);
    L26:
        r108 = -1;
        goto L28
    L22:
        return super.dispatchTouchEvent(r100);
    L85:
        if (r101 != 1) goto L90;
        if (this.C == false) goto L90;
        this.F.o(0);
        goto L90
    }

    @Override // android.view.View
    public final void draw(Canvas r100) {
        super.draw(r100);
        if (this.f448520d == null) goto L12;
        View r101 = this.f448532p;
        if (r101 == null) goto L13;
        int r102 = r101.getRight();
        if (this.f448524h == false) goto L9;
        int r103 = this.f448532p.getTop() - this.f448522f;
        int r104 = this.f448532p.getTop();
    L10:
        int r105 = this.f448532p.getLeft();
        this.f448520d.setBounds(r105, r103, r102, r104);
        this.f448520d.draw(r100);
        return;
    L9:
        r103 = this.f448532p.getBottom();
        r104 = this.f448532p.getBottom() + this.f448522f;
        goto L10
    L13:
        return;
    }

    public final void g(float r100) {
        if (isEnabled() == true) goto L5;
        return;
    L5:
        if (this.f448532p == null) goto L22;
        int r101 = c(r100);
        com.ss.android.lark.widget.slidingup.a r102 = this.F;
        View r103 = this.f448532p;
        int r104 = r103.getLeft();
        r102.f448566q = r103;
        r102.f448552c = -1;
        if (r102.i(r104, r101, 0, 0) == false) goto L21;
        int r105 = getChildCount();
        int r106 = 0;
    L10:
        if (r106 >= r105) goto L15;
        View r107 = getChildAt(r106);
        if (r107.getVisibility() != 4) goto L14;
        r107.setVisibility(0);
    L14:
        r106 = r106 + 1;
        goto L10
    L15:
        ViewCompat.postInvalidateOnAnimation(this);
        return;
    L21:
        return;
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams r100) {
        if ((r100 instanceof ViewGroup.MarginLayoutParams) == false) goto L6;
        return new LayoutParams((ViewGroup.MarginLayoutParams) r100);
    L6:
        return new LayoutParams(r100);
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r110) {
        if (this.C == false) goto L5;
    L104:
        this.F.a();
        return false;
    L5:
        if (e() == false) goto L104;
        int r100 = MotionEventCompat.getActionMasked(r110);
        float r101 = r110.getX();
        float r102 = r110.getY();
        float r103 = Math.abs(r101 - this.A);
        float r104 = Math.abs(r102 - this.B);
        com.ss.android.lark.widget.slidingup.a r105 = this.F;
        int r106 = r105.f448551b;
        if (r100 == 0) goto L38;
        if (r100 == 1) goto L20;
        if (r100 == 2) goto L14;
        if (r100 == 3) goto L20;
    L42:
        com.ss.android.lark.widget.slidingup.a r107 = this.F;
        r107.getClass();
        int r108 = MotionEventCompat.getActionMasked(r110);
        int r109 = MotionEventCompat.getActionIndex(r110);
        if (r108 != 0) goto L46;
        r107.b();
    L46:
        if (r107.f448560k != null) goto L48;
        r107.f448560k = VelocityTracker.obtain();
    L48:
        r107.f448560k.addMovement(r110);
        if (r108 == 0) goto L92;
        if (r108 == 1) goto L91;
        if (r108 == 2) goto L68;
        if (r108 == 3) goto L91;
        if (r108 != 5) goto L56;
        int r111 = MotionEventCompat.getPointerId(r110, r109);
        float r112 = MotionEventCompat.getX(r110, r109);
        float r113 = MotionEventCompat.getY(r110, r109);
        r107.m(r112, r113, r111);
        int r114 = r107.f448550a;
        if (r114 == 0) goto L62;
        if (r114 != 2) goto L101;
        View r115 = r107.h((int) r112, (int) r113);
        if (r115 != r107.f448566q) goto L101;
        r107.p(r115, r111);
    L101:
        if (r107.f448550a != 1) goto L116;
        return true;
    L116:
        return false;
    L62:
        if ((r107.f448557h[r111] & 0) == 0) goto L101;
        r107.f448565p.getClass();
        goto L101
    L56:
        if (r108 != 6) goto L101;
        r107.e(MotionEventCompat.getPointerId(r110, r109));
        goto L101
    L68:
        int r116 = MotionEventCompat.getPointerCount(r110);
        int r117 = 0;
    L69:
        if (r117 >= r116) goto L90;
        if (r107.f448553d == null) goto L90;
        if (r107.f448554e == null) goto L90;
        int r118 = MotionEventCompat.getPointerId(r110, r117);
        if (r118 >= r107.f448553d.length) goto L89;
        if (r118 >= r107.f448554e.length) goto L89;
        float r119 = MotionEventCompat.getX(r110, r117);
        float r120 = MotionEventCompat.getY(r110, r117);
        float r121 = r119 - r107.f448553d[r118];
        float r122 = r120 - r107.f448554e[r118];
        r107.l(r121, r122, r118);
        if (r107.f448550a == 1) goto L90;
        View r123 = r107.h((int) r107.f448553d[r118], (int) r107.f448554e[r118]);
        if (r123 == null) goto L89;
        if (r107.d(r123, r122) == false) goto L89;
        if (r107.p(r123, r118) == true) goto L90;
    L89:
        r117 = r117 + 1;
    L90:
        r107.n(r110);
    L91:
        r107.b();
        goto L101
    L92:
        float r124 = r110.getX();
        float r125 = r110.getY();
        int r126 = MotionEventCompat.getPointerId(r110, 0);
        r107.m(r124, r125, r126);
        View r127 = r107.h((int) r124, (int) r125);
        if (r127 != r107.f448566q) goto L98;
        if (r107.f448550a != 2) goto L98;
        r107.p(r127, r126);
    L98:
        if ((r107.f448557h[r126] & 0) == 0) goto L101;
        r107.f448565p.getClass();
        goto L101
    L14:
        if (r104 <= r106) goto L42;
        if (r103 <= r104) goto L42;
        r105.b();
        this.f448539w = true;
        return false;
    L20:
        if (r105.f448550a != 1) goto L22;
        boolean r128 = true;
    L23:
        if (r128 == false) goto L26;
        r105.j(r110);
        return true;
    L26:
        float r129 = r106;
        if (r104 > r129) goto L42;
        if (r103 > r129) goto L42;
        if (this.f448536t <= 0.0f) goto L42;
        if (f(this.f448532p, (int) this.A, (int) this.B) == true) goto L42;
        if (this.E == null) goto L42;
        playSoundEffect(0);
        this.E.onClick(this);
        return true;
    L22:
        r128 = false;
        goto L23
    L38:
        this.f448539w = false;
        this.A = r101;
        this.B = r102;
        if (f(this.f448527k, (int) r101, (int) r102) == true) goto L42;
        this.F.b();
        this.f448539w = true;
        return false;
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable r100) {
        if ((r100 instanceof Bundle) == false) goto L8;
        Bundle r101 = (Bundle) r100;
        PanelState r102 = (PanelState) r101.getSerializable("sliding_state");
        this.f448534r = r102;
        if (r102 != null) goto L7;
        r102 = I;
    L7:
        this.f448534r = r102;
        r100 = r101.getParcelable("superState");
    L8:
        super.onRestoreInstanceState(r100);
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r100) {
        if (isEnabled() == false) goto L14;
        if (e() == false) goto L14;
        this.F.j(r100);     // Catch: Exception -> L10
        return true;
    L10:
        e = move-exception;
        Log.w("SlidingUpPanelLayout", "exception in onInterceptTouchEvent", e);
        return false;
    L14:
        return super.onTouchEvent(r100);
    }

    public void setAnchorPoint(float r100) {
        if (r100 > 0.0f) goto L5;
        return;
    L5:
        if (r100 > 1.0f) goto L9;
        this.f448538v = r100;
        this.G = true;
        requestLayout();
        return;
    }

    public void setClipPanel(boolean r100) {
        this.f448526j = r100;
    }

    public void setCoveredFadeColor(int r100) {
        this.f448518b = r100;
        requestLayout();
    }

    public void setDragView(View r100) {
        View r101 = this.f448527k;
        if (r101 == null) goto L5;
        r101.setOnClickListener(null);
    L5:
        this.f448527k = r100;
        if (r100 == null) goto L9;
        r100.setClickable(true);
        this.f448527k.setFocusable(false);
        this.f448527k.setFocusableInTouchMode(false);
        this.f448527k.setOnClickListener(new a(this));
        return;
    }

    public void setFadeOnClickListener(View.OnClickListener r100) {
        this.E = r100;
    }

    public void setGravity(int r100) {
        if (r100 == 48) goto L8;
        if (r100 == 80) goto L8;
        throw new IllegalArgumentException("gravity must be set to either top or bottom");
    L8:
        if (r100 != 80) goto L10;
        boolean r101 = true;
    L11:
        this.f448524h = r101;
        if (this.G == true) goto L15;
        requestLayout();
        return;
    L15:
        return;
    L10:
        r101 = false;
        goto L11
    }

    public void setMinFlingVelocity(int r100) {
        this.f448517a = r100;
    }

    public void setOverlayed(boolean r100) {
        this.f448525i = r100;
    }

    public void setPanelHeight(int r100) {
        if (getPanelHeight() != r100) goto L5;
        return;
    L5:
        this.f448521e = r100;
        if (this.G == true) goto L9;
        requestLayout();
    L9:
        if (getPanelState() != PanelState.COLLAPSED) goto L12;
        g(0.0f);
        invalidate();
        return;
    }

    public void setPanelState(PanelState r100) {
        if (this.F.f448550a != 2) goto L5;
        Log.d("SlidingUpPanelLayout", "View is settling. Aborting animation.");
        this.F.a();
    L5:
        if (r100 == null) goto L41;
        PanelState r101 = PanelState.DRAGGING;
        if (r100 == r101) goto L41;
        if (isEnabled() == false) goto L42;
        boolean r102 = this.G;
        if (r102 == false) goto L13;
    L14:
        PanelState r103 = this.f448534r;
        if (r100 == r103) goto L44;
        if (r103 == r101) goto L49;
        if (r102 == false) goto L21;
        setPanelStateInternal(r100);
        return;
    L21:
        if (r103 != PanelState.HIDDEN) goto L23;
        this.f448532p.setVisibility(0);
        requestLayout();
    L23:
        int r104 = b.f448547a[r100.ordinal()];
        if (r104 == 1) goto L38;
        if (r104 != 2) goto L27;
        g(this.f448538v);
        return;
    L27:
        if (r104 != 3) goto L29;
        int r105 = c(0.0f);
        if (this.f448524h == false) goto L35;
        int r106 = this.f448521e;
    L36:
        g(d(r105 + r106));
        return;
    L35:
        r106 = -this.f448521e;
        goto L36
    L29:
        if (r104 != 4) goto L50;
        g(0.0f);
        return;
    L50:
        return;
    L38:
        g(1.0f);
        return;
    L49:
        return;
    L44:
        return;
    L13:
        if (this.f448532p != null) goto L14;
        return;
    L42:
        return;
    L41:
        throw new IllegalArgumentException("Panel state cannot be null or DRAGGING.");
    }

    public void setParallaxOffset(int r100) {
        this.f448523g = r100;
        if (this.G == true) goto L6;
        requestLayout();
        return;
    }

    public void setScrollableView(View r100) {
        this.f448529m = r100;
    }

    public void setScrollableViewHelper(qec.a r100) {
        this.f448531o = r100;
    }

    public void setShadowHeight(int r100) {
        this.f448522f = r100;
        if (this.G == true) goto L6;
        invalidate();
        return;
    }

    public void setTouchEnabled(boolean r100) {
        this.f448540x = r100;
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet r100) {
        return new LayoutParams(getContext(), r100);
    }

    public void setDragView(int r100) {
        this.f448528l = r100;
        setDragView(findViewById(r100));
    }

    public SlidingUpPanelLayout(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    public static void a(SlidingUpPanelLayout r100, int r101) {
        PanelState r102 = r100.f448534r;
        PanelState r103 = PanelState.DRAGGING;
        if (r102 == r103) goto L5;
        r100.f448535s = r102;
    L5:
        r100.setPanelStateInternal(r103);
        r100.f448536t = r100.d(r101);
        if (r100.f448523g <= 0) goto L8;
        ViewCompat.setTranslationY(r100.f448533q, r100.getCurrentParallaxOffset());
    L8:
        List<d> r104 = r100.D;
        monitor-enter(r104);
        Iterator r105 = ((CopyOnWriteArrayList) r100.D).iterator();     // Catch: Throwable -> L33
    L12:
        if (r105.hasNext() == false) goto L14;
        ((d) r105.next()).a();     // Catch: Throwable -> L33
        goto L12
    L14:
        monitor-exit(r104);     // Catch: Throwable -> L33
        LayoutParams r106 = (LayoutParams) r100.f448533q.getLayoutParams();
        int r107 = ((r100.getHeight() - r100.getPaddingBottom()) - r100.getPaddingTop()) - r100.f448521e;
        if (r100.f448536t > 0.0f) goto L28;
        if (r100.f448525i == true) goto L28;
        if (r100.f448524h == false) goto L22;
        int r108 = r101 - r100.getPaddingBottom();
    L23:
        ((ViewGroup.MarginLayoutParams) r106).height = r108;
        if (r108 != r107) goto L26;
        ((ViewGroup.MarginLayoutParams) r106).height = -1;
    L26:
        r100.f448533q.requestLayout();
        return;
    L22:
        r108 = ((r100.getHeight() - r100.getPaddingBottom()) - r100.f448532p.getMeasuredHeight()) - r101;
    L28:
        if (((ViewGroup.MarginLayoutParams) r106).height != (-1)) goto L30;
        return;
    L30:
        if (r100.f448525i == true) goto L41;
        ((ViewGroup.MarginLayoutParams) r106).height = -1;
        r100.f448533q.requestLayout();
        return;
    L41:
        return;
    L33:
        th = move-exception;
        throw th;
    }

    public static /* synthetic */ void b(SlidingUpPanelLayout r100, PanelState r101) {
        r100.setPanelStateInternal(r101);
    }

    @Override // android.view.View
    public final void onMeasure(int r110, int r111) {
        int r100 = View.MeasureSpec.getMode(r110);
        int r112 = View.MeasureSpec.getSize(r110);
        int r101 = View.MeasureSpec.getMode(r111);
        int r113 = View.MeasureSpec.getSize(r111);
        if (r100 == 1073741824) goto L8;
        if (r100 == Integer.MIN_VALUE) goto L8;
        throw new IllegalStateException("Width must have an exact value or MATCH_PARENT");
    L8:
        if (r101 == 1073741824) goto L13;
        if (r101 == Integer.MIN_VALUE) goto L13;
        throw new IllegalStateException("Height must have an exact value or MATCH_PARENT");
    L13:
        int r102 = getChildCount();
        if (r102 != 2) goto L65;
        int r103 = 0;
        this.f448533q = getChildAt(0);
        View r104 = getChildAt(1);
        this.f448532p = r104;
        if (this.f448527k != null) goto L19;
        setDragView(r104);
    L19:
        if (this.f448532p.getVisibility() == 0) goto L21;
        this.f448534r = PanelState.HIDDEN;
    L21:
        int r105 = (r113 - getPaddingTop()) - getPaddingBottom();
        int r106 = (r112 - getPaddingLeft()) - getPaddingRight();
    L22:
        if (r103 >= r102) goto L62;
        View r107 = getChildAt(r103);
        LayoutParams r108 = (LayoutParams) r107.getLayoutParams();
        if (r107.getVisibility() != 8) goto L28;
        if (r103 != 0) goto L28;
    L61:
        r103 = r103 + 1;
    L28:
        if (r107 != this.f448533q) goto L37;
        if (this.f448525i == false) goto L32;
    L34:
        int r109 = r105;
    L35:
        int r114 = r106 - (((ViewGroup.MarginLayoutParams) r108).leftMargin + ((ViewGroup.MarginLayoutParams) r108).rightMargin);
    L41:
        int r115 = ((ViewGroup.MarginLayoutParams) r108).width;
        if (r115 != (-2)) goto L44;
        int r116 = View.MeasureSpec.makeMeasureSpec(r114, Integer.MIN_VALUE);
    L47:
        int r117 = ((ViewGroup.MarginLayoutParams) r108).height;
        if (r117 != (-2)) goto L50;
        int r118 = View.MeasureSpec.makeMeasureSpec(r109, Integer.MIN_VALUE);
    L58:
        r107.measure(r116, r118);
        View r119 = this.f448532p;
        if (r107 != r119) goto L61;
        this.f448537u = r119.getMeasuredHeight() - this.f448521e;
        goto L61
    L50:
        float r120 = r108.f448544a;
        if (r120 > 0.0f) goto L53;
    L55:
        if (r117 == (-1)) goto L57;
        r109 = r117;
    L57:
        r118 = View.MeasureSpec.makeMeasureSpec(r109, 1073741824);
        goto L58
    L53:
        if (r120 >= 1.0f) goto L55;
        r109 = (int) (r109 * r120);
        goto L57
    L44:
        if (r115 != (-1)) goto L46;
        r116 = View.MeasureSpec.makeMeasureSpec(r114, 1073741824);
        goto L47
    L46:
        r116 = View.MeasureSpec.makeMeasureSpec(r115, 1073741824);
        goto L47
    L32:
        if (this.f448534r == PanelState.HIDDEN) goto L34;
        r109 = r105 - this.f448521e;
        goto L35
    L37:
        if (r107 != this.f448532p) goto L39;
        r109 = r105 - ((ViewGroup.MarginLayoutParams) r108).topMargin;
    L40:
        r114 = r106;
        goto L41
    L39:
        r109 = r105;
        goto L40
    L62:
        setMeasuredDimension(r112, r113);
        return;
    L65:
        throw new IllegalStateException("Sliding up panel layout must have exactly 2 children!");
    }

    public SlidingUpPanelLayout(Context r110, AttributeSet r111, int r112) {
        super(r110, r111, r112);
        this.f448517a = 400;
        this.f448518b = 1291845632;
        this.f448519c = new Paint();
        this.f448521e = -1;
        this.f448522f = -1;
        this.f448523g = -1;
        this.f448525i = false;
        this.f448526j = true;
        this.f448528l = -1;
        this.f448531o = new qec.a();
        PanelState r100 = I;
        this.f448534r = r100;
        this.f448535s = r100;
        this.f448538v = 1.0f;
        this.C = false;
        this.D = new CopyOnWriteArrayList();
        this.G = true;
        this.H = new Rect();
        if (isInEditMode() == false) goto L6;
        this.f448520d = null;
        this.F = null;
        return;
    L6:
        if (r111 == null) goto L17;
        TypedArray r101 = r110.obtainStyledAttributes(r111, f448516J);
        if (r101 == null) goto L10;
        setGravity(r101.getInt(0, 0));
        r101.recycle();
    L10:
        TypedArray r113 = r110.obtainStyledAttributes(r111, new int[]{com.larus.nova.R.attr.appAnchorPoint, com.larus.nova.R.attr.appClipPanel, com.larus.nova.R.attr.appDragView, com.larus.nova.R.attr.appFadeColor, com.larus.nova.R.attr.appFlingVelocity, com.larus.nova.R.attr.appInitialState, com.larus.nova.R.attr.appOverlay, com.larus.nova.R.attr.appPanelHeight, com.larus.nova.R.attr.appParallaxOffset, com.larus.nova.R.attr.appScrollInterpolator, com.larus.nova.R.attr.appScrollableView, com.larus.nova.R.attr.appShadowHeight});
        if (r113 == null) goto L17;
        this.f448521e = r113.getDimensionPixelSize(7, -1);
        this.f448522f = r113.getDimensionPixelSize(11, -1);
        this.f448523g = r113.getDimensionPixelSize(8, -1);
        this.f448517a = r113.getInt(4, 400);
        this.f448518b = r113.getColor(3, 1291845632);
        this.f448528l = r113.getResourceId(2, -1);
        this.f448530n = r113.getResourceId(10, -1);
        this.f448525i = r113.getBoolean(6, false);
        this.f448526j = r113.getBoolean(1, true);
        this.f448538v = r113.getFloat(0, 1.0f);
        this.f448534r = PanelState.values()[r113.getInt(5, r100.ordinal())];
        int r114 = r113.getResourceId(9, -1);
        if (r114 == (-1)) goto L15;
        Interpolator r115 = AnimationUtils.loadInterpolator(r110, r114);
    L16:
        r113.recycle();
    L18:
        Resources r116 = r110.getResources();
        float r117 = WindowDisplayMetricsOverride.apply(r116, r116.getDisplayMetrics()).density;
        if (this.f448521e != (-1)) goto L22;
        this.f448521e = (int) ((68.0f * r117) + 0.5f);
    L22:
        if (this.f448522f != (-1)) goto L25;
        this.f448522f = (int) ((4.0f * r117) + 0.5f);
    L25:
        if (this.f448523g != (-1)) goto L28;
        this.f448523g = (int) (0.0f * r117);
    L28:
        if (this.f448522f > 0) goto L30;
        this.f448520d = null;
    L34:
        setWillNotDraw(false);
        com.ss.android.lark.widget.slidingup.a r102 = new com.ss.android.lark.widget.slidingup.a(getContext(), this, r115, new c(this));
        r102.f448551b = (int) (r102.f448551b * 2.0f);
        this.F = r102;
        r102.f448562m = this.f448517a * r117;
        this.f448540x = true;
        return;
    L30:
        if (this.f448524h == false) goto L32;
        this.f448520d = getResources().getDrawable(com.larus.nova.R.drawable.above_shadow);
        goto L34
    L32:
        this.f448520d = getResources().getDrawable(com.larus.nova.R.drawable.below_shadow);
        goto L34
    L15:
        r115 = null;
    L17:
        r115 = null;
        goto L18
    }

    @Override // android.view.ViewGroup
    public final boolean drawChild(Canvas r100, View r101, long r102) {
        int r103 = r100.save();
        View r104 = this.f448532p;
        if (r104 == null) goto L19;
        if (r104 == r101) goto L19;
        r100.getClipBounds(this.H);
        if (this.f448525i == true) goto L12;
        if (this.f448524h == false) goto L10;
        Rect r105 = this.H;
        r105.bottom = Math.min(r105.bottom, this.f448532p.getTop());
        goto L12
    L10:
        Rect r106 = this.H;
        r106.top = Math.max(r106.top, this.f448532p.getBottom());
    L12:
        if (this.f448526j == false) goto L14;
        r100.clipRect(this.H);
    L14:
        boolean r107 = super.drawChild(r100, r101, r102);
        int r108 = this.f448518b;
        if (r108 == 0) goto L20;
        float r109 = this.f448536t;
        if (r109 <= 0.0f) goto L20;
        this.f448519c.setColor((r108 & 16777215) | (((int) ((((-16777216) & r108) >>> 24) * r109)) << 24));
        r100.drawRect(this.H, this.f448519c);
    L20:
        r100.restoreToCount(r103);
        return r107;
    L19:
        r107 = super.drawChild(r100, r101, r102);
        goto L20
    }

    public final boolean f(View r100, int r101, int r102) {
        if (r100 != null) goto L5;
        return false;
    L5:
        int[] r103 = new int[2];
        r100.getLocationOnScreen(r103);
        int[] r104 = new int[2];
        getLocationOnScreen(r104);
        int r105 = r104[0] + r101;
        int r106 = r104[1] + r102;
        int r107 = r103[0];
        if (r105 >= r107) goto L8;
        return false;
    L8:
        if (r105 >= (r107 + r100.getWidth())) goto L16;
        int r108 = r103[1];
        if (r106 >= r108) goto L12;
        return false;
    L12:
        if (r106 >= (r108 + r100.getHeight())) goto L18;
        return true;
    L18:
        return false;
    L16:
        return false;
    }

    @Override // android.view.View
    public final void onSizeChanged(int r100, int r101, int r102, int r103) {
        super.onSizeChanged(r100, r101, r102, r103);
        if (r101 == r103) goto L6;
        this.G = true;
        requestLayout();
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r100, int r101, int r102, int r103, int r110) {
        int r104 = getPaddingLeft();
        int r105 = getPaddingTop();
        int r106 = getChildCount();
        if (this.G == false) goto L18;
        int r107 = b.f448547a[this.f448534r.ordinal()];
        if (r107 != 1) goto L7;
        this.f448536t = 1.0f;
        goto L18
    L7:
        if (r107 != 2) goto L9;
        this.f448536t = this.f448538v;
        goto L18
    L9:
        if (r107 == 3) goto L11;
        this.f448536t = 0.0f;
        goto L18
    L11:
        int r108 = c(0.0f);
        if (this.f448524h == false) goto L14;
        int r111 = this.f448521e;
    L15:
        this.f448536t = d(r108 + r111);
        goto L18
    L14:
        r111 = -this.f448521e;
    L18:
        int r112 = 0;
    L19:
        if (r112 >= r106) goto L40;
        View r109 = getChildAt(r112);
        LayoutParams r113 = (LayoutParams) r109.getLayoutParams();
        if (r109.getVisibility() != 8) goto L26;
        if (r112 == 0) goto L38;
        if (this.G == false) goto L26;
    L38:
        r112 = r112 + 1;
    L26:
        int r114 = r109.getMeasuredHeight();
        if (r109 != this.f448532p) goto L29;
        int r115 = c(this.f448536t);
    L31:
        if (this.f448524h == false) goto L33;
    L37:
        int r116 = ((ViewGroup.MarginLayoutParams) r113).leftMargin + r104;
        r109.layout(r116, r115, r109.getMeasuredWidth() + r116, r114 + r115);
        goto L38
    L33:
        if (r109 != this.f448533q) goto L37;
        if (this.f448525i == true) goto L37;
        r115 = c(this.f448536t) + this.f448532p.getMeasuredHeight();
        goto L37
    L29:
        r115 = r105;
        goto L31
    L40:
        if (this.G == false) goto L43;
        h();
    L43:
        if (this.f448523g <= 0) goto L45;
        ViewCompat.setTranslationY(this.f448533q, getCurrentParallaxOffset());
    L45:
        this.G = false;
    }
}
