package com.bytedance.ies.xelement.reveal;

import android.content.Context;
import android.graphics.Rect;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.GestureDetectorCompat;
import androidx.core.view.ViewCompat;
import androidx.customview.widget.ViewDragHelper;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class RevealLayout extends ViewGroup {

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final /* synthetic */ int f250344y = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public View f250345a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public View f250346b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Rect f250347c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Rect f250348d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Rect f250349e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Rect f250350f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f250351g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f250352h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public volatile boolean f250353i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public volatile boolean f250354j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f250355k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f250356l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f250357m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f250358n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f250359o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f250360p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public float f250361q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public float f250362r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public float f250363s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public ViewDragHelper f250364t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public GestureDetectorCompat f250365u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public b f250366v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final RevealLayout$mDragHelperCallback$1 f250367w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final c f250368x;

    public static final class a {
    }

    public interface b {
        void a();

        void onClosed();

        void onSlide();
    }

    public static final class c extends GestureDetector.SimpleOnGestureListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f250369a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ RevealLayout f250370b;

        public c(RevealLayout r100) {
            this.f250370b = r100;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public final boolean onDown(MotionEvent r100) {
            this.f250370b.f250353i = false;
            this.f250369a = false;
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public final boolean onFling(MotionEvent r100, MotionEvent r101, float r102, float r103) {
            this.f250370b.f250353i = true;
            return false;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public final boolean onScroll(MotionEvent r100, MotionEvent r101, float r102, float r103) {
            boolean r104 = true;
            this.f250370b.f250353i = true;
            if (this.f250370b.getParent() != null) goto L5;
        L14:
            return false;
        L5:
            if (this.f250369a == false) goto L7;
        L13:
            this.f250370b.getParent().requestDisallowInterceptTouchEvent(r104);
            goto L14
        L7:
            if (RevealLayout.a(this.f250370b) < this.f250370b.f250351g) goto L9;
            boolean r105 = true;
        L10:
            if (r105 == false) goto L12;
            this.f250369a = true;
        L12:
            r104 = r105;
            goto L13
        L9:
            r105 = false;
            goto L10
        }
    }

    static {
    }

    private final int getClosestEdgeDistance() {
        int r100 = this.f250360p;
        if (r100 != 1) goto L5;
        int r101 = this.f250347c.left;
        View r102 = this.f250346b;
        if (r102 != null) goto L48;
        Intrinsics.throwNpe();
    L48:
        int r103 = r101 + r102.getWidth();
        View r104 = this.f250345a;
        if (r104 != null) goto L51;
        Intrinsics.throwNpe();
    L51:
        int r105 = r104.getLeft() - this.f250347c.left;
        View r106 = this.f250345a;
        if (r106 != null) goto L55;
        Intrinsics.throwNpe();
    L55:
        return Math.min(r105, r103 - r106.getLeft());
    L5:
        if (r100 != 2) goto L7;
        int r107 = this.f250347c.right;
        View r108 = this.f250346b;
        if (r108 != null) goto L37;
        Intrinsics.throwNpe();
    L37:
        int r109 = r107 - r108.getWidth();
        View r110 = this.f250345a;
        if (r110 != null) goto L40;
        Intrinsics.throwNpe();
    L40:
        int r111 = r110.getRight() - r109;
        int r112 = this.f250347c.right;
        View r113 = this.f250345a;
        if (r113 != null) goto L44;
        Intrinsics.throwNpe();
    L44:
        return Math.min(r111, r112 - r113.getRight());
    L7:
        if (r100 != 4) goto L9;
        int r114 = this.f250347c.top;
        View r115 = this.f250346b;
        if (r115 != null) goto L26;
        Intrinsics.throwNpe();
    L26:
        int r116 = r114 + r115.getHeight();
        View r117 = this.f250345a;
        if (r117 != null) goto L29;
        Intrinsics.throwNpe();
    L29:
        int r118 = r117.getBottom() - r116;
        View r119 = this.f250345a;
        if (r119 != null) goto L33;
        Intrinsics.throwNpe();
    L33:
        return Math.min(r118, r116 - r119.getTop());
    L9:
        if (r100 == 8) goto L12;
        return 0;
    L12:
        int r120 = this.f250347c.bottom;
        View r121 = this.f250346b;
        if (r121 != null) goto L15;
        Intrinsics.throwNpe();
    L15:
        int r122 = r120 - r121.getHeight();
        int r123 = this.f250347c.bottom;
        View r124 = this.f250345a;
        if (r124 != null) goto L18;
        Intrinsics.throwNpe();
    L18:
        int r125 = r123 - r124.getBottom();
        View r126 = this.f250345a;
        if (r126 != null) goto L22;
        Intrinsics.throwNpe();
    L22:
        return Math.min(r125, r126.getBottom() - r122);
    }

    private final int getHalfwayPivotHorizontal() {
        if (this.f250360p != 1) goto L8;
        int r100 = this.f250347c.left;
        View r101 = this.f250346b;
        if (r101 != null) goto L13;
        Intrinsics.throwNpe();
    L13:
        return r100 + (r101.getWidth() / 2);
    L8:
        int r102 = this.f250347c.right;
        View r103 = this.f250346b;
        if (r103 != null) goto L12;
        Intrinsics.throwNpe();
    L12:
        return r102 - (r103.getWidth() / 2);
    }

    private final int getHalfwayPivotVertical() {
        if (this.f250360p != 4) goto L8;
        int r100 = this.f250347c.top;
        View r101 = this.f250346b;
        if (r101 != null) goto L13;
        Intrinsics.throwNpe();
    L13:
        return r100 + (r101.getHeight() / 2);
    L8:
        int r102 = this.f250347c.bottom;
        View r103 = this.f250346b;
        if (r103 != null) goto L12;
        Intrinsics.throwNpe();
    L12:
        return r102 - (r103.getHeight() / 2);
    }

    private final int getMainOpenLeft() {
        int r100 = this.f250360p;
        if (r100 != 1) goto L5;
        int r101 = this.f250347c.left;
        View r102 = this.f250346b;
        if (r102 != null) goto L20;
        Intrinsics.throwNpe();
    L20:
        return r101 + r102.getWidth();
    L5:
        if (r100 != 2) goto L7;
        int r103 = this.f250347c.left;
        View r104 = this.f250346b;
        if (r104 != null) goto L23;
        Intrinsics.throwNpe();
    L23:
        return r103 - r104.getWidth();
    L7:
        if (r100 == 4) goto L22;
        if (r100 == 8) goto L22;
        return 0;
    L22:
        return this.f250347c.left;
    }

    private final int getMainOpenTop() {
        int r100 = this.f250360p;
        if (r100 == 1) goto L20;
        if (r100 == 2) goto L20;
        if (r100 != 4) goto L9;
        int r101 = this.f250347c.top;
        View r102 = this.f250346b;
        if (r102 != null) goto L23;
        Intrinsics.throwNpe();
    L23:
        return r101 + r102.getHeight();
    L9:
        if (r100 == 8) goto L11;
        return 0;
    L11:
        int r103 = this.f250347c.top;
        View r104 = this.f250346b;
        if (r104 != null) goto L22;
        Intrinsics.throwNpe();
    L22:
        return r103 - r104.getHeight();
    L20:
        return this.f250347c.top;
    }

    private final int getSecOpenLeft() {
        if (this.f250357m == 0) goto L21;
        int r100 = this.f250360p;
        if (r100 == 8) goto L21;
        if (r100 == 4) goto L21;
        if (r100 != 1) goto L15;
        int r101 = this.f250349e.left;
        View r102 = this.f250346b;
        if (r102 != null) goto L22;
        Intrinsics.throwNpe();
    L22:
        return r101 + r102.getWidth();
    L15:
        int r103 = this.f250349e.left;
        View r104 = this.f250346b;
        if (r104 != null) goto L19;
        Intrinsics.throwNpe();
    L19:
        return r103 - r104.getWidth();
    L21:
        return this.f250349e.left;
    }

    private final int getSecOpenTop() {
        if (this.f250357m == 0) goto L21;
        int r100 = this.f250360p;
        if (r100 == 1) goto L21;
        if (r100 == 2) goto L21;
        if (r100 != 4) goto L15;
        int r101 = this.f250349e.top;
        View r102 = this.f250346b;
        if (r102 != null) goto L22;
        Intrinsics.throwNpe();
    L22:
        return r101 + r102.getHeight();
    L15:
        int r103 = this.f250349e.top;
        View r104 = this.f250346b;
        if (r104 != null) goto L19;
        Intrinsics.throwNpe();
    L19:
        return r103 - r104.getHeight();
    L21:
        return this.f250349e.top;
    }

    @Override // android.view.View
    public final void computeScroll() {
        ViewDragHelper r100 = this.f250364t;
        if (r100 != null) goto L6;
        Intrinsics.throwNpe();
    L6:
        if (r100.continueSettling(true) == false) goto L9;
        ViewCompat.postInvalidateOnAnimation(this);
        return;
    }

    public final int getDragEdge() {
        return this.f250360p;
    }

    public final int getMinFlingVelocity() {
        return this.f250355k;
    }

    /* JADX WARN: Type inference failed for: r0v7, types: [com.bytedance.ies.xelement.reveal.RevealLayout$mDragHelperCallback$1] */
    public RevealLayout(final Context r100) {
        super(r100);
        this.f250347c = new Rect();
        this.f250348d = new Rect();
        this.f250349e = new Rect();
        this.f250350f = new Rect();
        this.f250355k = 300;
        this.f250357m = 1;
        this.f250360p = 1;
        this.f250362r = -1.0f;
        this.f250363s = -1.0f;
        this.f250367w = new RevealLayout$mDragHelperCallback$1(this, r100);
        this.f250368x = new c(this);
    }

    public static final /* synthetic */ int a(RevealLayout r100) {
        return r100.getClosestEdgeDistance();
    }

    public static final /* synthetic */ int b(RevealLayout r100) {
        return r100.getHalfwayPivotHorizontal();
    }

    public static final /* synthetic */ int c(RevealLayout r100) {
        return r100.getHalfwayPivotVertical();
    }

    public final void d(com.lynx.tasm.behavior.ui.view.a r100) {
        View r101 = this.f250346b;
        if (r101 == null) goto L5;
        removeView(r101);
    L5:
        this.f250346b = r100;
        addView(r100, 0);
    }

    public final void e(boolean r100) {
        this.f250352h = false;
        if (r100 == false) goto L11;
        this.f250356l = 1;
        ViewDragHelper r101 = this.f250364t;
        if (r101 != null) goto L7;
        Intrinsics.throwNpe();
    L7:
        View r102 = this.f250345a;
        if (r102 != null) goto L10;
        Intrinsics.throwNpe();
    L10:
        Rect r103 = this.f250347c;
        r101.smoothSlideViewTo(r102, r103.left, r103.top);
    L21:
        ViewCompat.postInvalidateOnAnimation(this);
        return;
    L11:
        this.f250356l = 0;
        ViewDragHelper r104 = this.f250364t;
        if (r104 != null) goto L14;
        Intrinsics.throwNpe();
    L14:
        r104.abort();
        View r105 = this.f250345a;
        if (r105 != null) goto L17;
        Intrinsics.throwNpe();
    L17:
        Rect r106 = this.f250347c;
        r105.layout(r106.left, r106.top, r106.right, r106.bottom);
        View r107 = this.f250346b;
        if (r107 != null) goto L20;
        Intrinsics.throwNpe();
    L20:
        Rect r108 = this.f250349e;
        r107.layout(r108.left, r108.top, r108.right, r108.bottom);
        goto L21
    }

    public final void f(boolean r100) {
        this.f250352h = true;
        if (r100 == false) goto L11;
        this.f250356l = 3;
        ViewDragHelper r101 = this.f250364t;
        if (r101 != null) goto L7;
        Intrinsics.throwNpe();
    L7:
        View r102 = this.f250345a;
        if (r102 != null) goto L10;
        Intrinsics.throwNpe();
    L10:
        Rect r103 = this.f250348d;
        r101.smoothSlideViewTo(r102, r103.left, r103.top);
    L21:
        ViewCompat.postInvalidateOnAnimation(this);
        return;
    L11:
        this.f250356l = 2;
        ViewDragHelper r104 = this.f250364t;
        if (r104 != null) goto L14;
        Intrinsics.throwNpe();
    L14:
        r104.abort();
        View r105 = this.f250345a;
        if (r105 != null) goto L17;
        Intrinsics.throwNpe();
    L17:
        Rect r106 = this.f250348d;
        r105.layout(r106.left, r106.top, r106.right, r106.bottom);
        View r107 = this.f250346b;
        if (r107 != null) goto L20;
        Intrinsics.throwNpe();
    L20:
        Rect r108 = this.f250350f;
        r107.layout(r108.left, r108.top, r108.right, r108.bottom);
        goto L21
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r100) {
        if (this.f250354j == true) goto L5;
        ViewDragHelper r101 = this.f250364t;
        if (r101 != null) goto L9;
        Intrinsics.throwNpe();
    L9:
        r101.processTouchEvent(r100);
        GestureDetectorCompat r102 = this.f250365u;
        if (r102 != null) goto L12;
        Intrinsics.throwNpe();
    L12:
        r102.onTouchEvent(r100);
        if (r100.getAction() != 0) goto L15;
        this.f250361q = 0.0f;
    L25:
        float r103 = r100.getX();
        float r104 = r100.getY();
        View r105 = this.f250345a;
        if (r105 != null) goto L29;
        Intrinsics.throwNpe();
    L29:
        if (r105.getTop() > r104) goto L36;
        View r106 = this.f250345a;
        if (r106 != null) goto L34;
        Intrinsics.throwNpe();
    L34:
        if (r104 > r106.getBottom()) goto L36;
        boolean r107 = true;
    L37:
        View r108 = this.f250345a;
        if (r108 != null) goto L41;
        Intrinsics.throwNpe();
    L41:
        if (r108.getLeft() > r103) goto L48;
        View r109 = this.f250345a;
        if (r109 != null) goto L46;
        Intrinsics.throwNpe();
    L46:
        if (r103 > r109.getRight()) goto L48;
        boolean r110 = true;
    L49:
        if (r107 == false) goto L52;
        if (r110 == false) goto L52;
        boolean r111 = true;
    L53:
        if (r111 == false) goto L63;
        ViewDragHelper r112 = this.f250364t;
        if (r112 != null) goto L58;
        Intrinsics.throwNpe();
    L58:
        if (this.f250361q < r112.getTouchSlop()) goto L60;
        boolean r113 = true;
    L61:
        if (r113 == true) goto L63;
        boolean r114 = true;
    L64:
        ViewDragHelper r115 = this.f250364t;
        if (r115 != null) goto L68;
        Intrinsics.throwNpe();
    L68:
        if (r115.getViewDragState() != 2) goto L70;
        boolean r116 = true;
    L71:
        ViewDragHelper r117 = this.f250364t;
        if (r117 != null) goto L75;
        Intrinsics.throwNpe();
    L75:
        if (r117.getViewDragState() == 0) goto L77;
    L79:
        boolean r118 = false;
    L80:
        this.f250362r = r100.getX();
        this.f250363s = r100.getY();
        if (r114 == true) goto L86;
        if (r116 == true) goto L84;
        if (r118 == true) goto L84;
        return false;
    L84:
        return true;
    L86:
        return false;
    L77:
        if (this.f250353i == false) goto L79;
        r118 = true;
        goto L80
    L70:
        r116 = false;
        goto L71
    L60:
        r113 = false;
    L63:
        r114 = false;
    L52:
        r111 = false;
    L48:
        r110 = false;
    L36:
        r107 = false;
        goto L37
    L15:
        int r119 = this.f250360p;
        if (r119 == 1) goto L20;
        if (r119 == 2) goto L20;
        boolean r120 = false;
    L21:
        if (r120 == false) goto L23;
        float r121 = Math.abs(r100.getX() - this.f250362r);
    L24:
        this.f250361q += r121;
        goto L25
    L23:
        r121 = Math.abs(r100.getY() - this.f250363s);
    L20:
        r120 = true;
        goto L21
    L5:
        return super.onInterceptTouchEvent(r100);
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r100) {
        GestureDetectorCompat r101 = this.f250365u;
        if (r101 != null) goto L5;
        Intrinsics.throwNpe();
    L5:
        r101.onTouchEvent(r100);
        ViewDragHelper r102 = this.f250364t;
        if (r102 != null) goto L8;
        Intrinsics.throwNpe();
    L8:
        r102.processTouchEvent(r100);
        return true;
    }

    public final void setDragEdge(int r100) {
        this.f250360p = r100;
    }

    public final void setLockDrag(boolean r100) {
        this.f250354j = r100;
    }

    public final void setMinFlingVelocity(int r100) {
        this.f250355k = r100;
    }

    public final void setMode$x_element_reveal_view_release(int r100) {
        this.f250357m = r100;
    }

    public final void setSwipeListener(b r100) {
        this.f250366v = r100;
    }

    @Override // android.view.View
    public final void onMeasure(int r110, int r111) {
        if (getChildCount() < 2) goto L39;
        ViewGroup.LayoutParams r100 = getLayoutParams();
        int r101 = View.MeasureSpec.getMode(r110);
        int r102 = View.MeasureSpec.getMode(r111);
        int r103 = getChildCount();
        int r104 = 0;
        int r105 = 0;
        int r106 = 0;
        int r107 = 0;
    L5:
        if (r105 >= r103) goto L7;
        View r108 = getChildAt(r105);
        measureChild(r108, r110, r111);
        r106 = Math.max(r108.getMeasuredWidth(), r106);
        r107 = Math.max(r108.getMeasuredHeight(), r107);
        r105 = r105 + 1;
        goto L5
    L7:
        int r112 = View.MeasureSpec.makeMeasureSpec(r106, r101);
        int r113 = View.MeasureSpec.makeMeasureSpec(r107, r102);
        int r109 = View.MeasureSpec.getSize(r112);
        int r114 = View.MeasureSpec.getSize(r113);
        int r115 = getChildCount();
    L9:
        if (r104 >= r115) goto L19;
        View r116 = getChildAt(r104);
        ViewGroup.LayoutParams r117 = r116.getLayoutParams();
        if (r117 == null) goto L18;
        if (r117.height != (-1)) goto L16;
        r116.setMinimumHeight(r114);
    L16:
        if (r117.width != (-1)) goto L18;
        r116.setMinimumWidth(r109);
    L18:
        measureChild(r116, r112, r113);
        r106 = Math.max(r116.getMeasuredWidth(), r106);
        r107 = Math.max(r116.getMeasuredHeight(), r107);
        r104 = r104 + 1;
        goto L9
    L19:
        int r118 = r106 + (getPaddingLeft() + getPaddingRight());
        int r119 = r107 + (getPaddingTop() + getPaddingBottom());
        if (r101 != 1073741824) goto L23;
    L28:
        if (r102 != 1073741824) goto L31;
    L36:
        setMeasuredDimension(r109, r114);
        return;
    L31:
        if (r100.height != (-1)) goto L33;
        r119 = r114;
    L33:
        if (r102 != Integer.MIN_VALUE) goto L35;
        r114 = Math.min(r119, r114);
        goto L36
    L35:
        r114 = r119;
        goto L36
    L23:
        if (r100.width != (-1)) goto L25;
        r118 = r109;
    L25:
        if (r101 != Integer.MIN_VALUE) goto L27;
        r109 = Math.min(r118, r109);
        goto L28
    L27:
        r109 = r118;
        goto L28
    L39:
        throw new RuntimeException("Layout must have two children");
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r110, int r111, int r112, int r210, int r211) {
        int r100 = getChildCount();
        int r101 = 0;
        int r102 = 0;
    L4:
        if (r102 >= r100) goto L39;
        View r103 = getChildAt(r102);
        int r104 = getPaddingLeft();
        int r113 = Math.max((r210 - getPaddingRight()) - r111, r101);
        int r114 = getPaddingTop();
        int r115 = Math.max((r211 - getPaddingBottom()) - r112, r101);
        int r116 = r103.getMeasuredHeight();
        int r117 = r103.getMeasuredWidth();
        ViewGroup.LayoutParams r118 = r103.getLayoutParams();
        if (r118 != null) goto L8;
        boolean r105 = false;
    L15:
        boolean r106 = false;
    L16:
        if (r105 == false) goto L21;
        r116 = r115 - r114;
        if (r118 != null) goto L20;
        Intrinsics.throwNpe();
    L20:
        r118.height = r116;
    L21:
        if (r106 == false) goto L26;
        r117 = r113 - r104;
        if (r118 != null) goto L25;
        Intrinsics.throwNpe();
    L25:
        r118.width = r117;
    L26:
        int r107 = this.f250360p;
        if (r107 == 1) goto L36;
        if (r107 != 2) goto L30;
        int r108 = Math.max(((r210 - r117) - getPaddingRight()) - r111, r104);
        int r109 = Math.min(getPaddingTop(), r115);
        int r119 = Math.max((r210 - getPaddingRight()) - r111, r104);
        int r120 = Math.min(r116 + getPaddingTop(), r115);
    L37:
        r103.layout(r108, r109, r119, r120);
        r102 = r102 + 1;
        r101 = 0;
        goto L4
    L30:
        if (r107 == 4) goto L36;
        if (r107 == 8) goto L34;
        r108 = 0;
        r109 = 0;
        r119 = 0;
        r120 = 0;
        goto L37
    L34:
        r108 = Math.min(getPaddingLeft(), r113);
        r109 = Math.max(((r211 - r116) - getPaddingBottom()) - r112, r114);
        r119 = Math.min(r117 + getPaddingLeft(), r113);
        r120 = Math.max((r211 - getPaddingBottom()) - r112, r114);
    L36:
        r108 = Math.min(getPaddingLeft(), r113);
        r109 = Math.min(getPaddingTop(), r115);
        r119 = Math.min(r117 + getPaddingLeft(), r113);
        r120 = Math.min(r116 + getPaddingTop(), r115);
        goto L37
    L8:
        if (r118.height != (-1)) goto L10;
        r105 = true;
    L12:
        if (r118.width != (-1)) goto L15;
        r106 = true;
        goto L16
    L10:
        r105 = false;
        goto L12
    L39:
        if (this.f250357m != 1) goto L76;
        int r121 = this.f250360p;
        if (r121 == 1) goto L69;
        if (r121 != 2) goto L44;
        View r122 = this.f250346b;
        if (r122 != null) goto L65;
        Intrinsics.throwNpe();
    L65:
        View r123 = this.f250346b;
        if (r123 != null) goto L68;
        Intrinsics.throwNpe();
    L68:
        r122.offsetLeftAndRight(r123.getWidth());
        goto L76
    L44:
        if (r121 != 4) goto L46;
        View r124 = this.f250346b;
        if (r124 != null) goto L58;
        Intrinsics.throwNpe();
    L58:
        View r125 = this.f250346b;
        if (r125 != null) goto L61;
        Intrinsics.throwNpe();
    L61:
        r124.offsetTopAndBottom(-r125.getHeight());
        goto L76
    L46:
        if (r121 != 8) goto L76;
        View r126 = this.f250346b;
        if (r126 != null) goto L51;
        Intrinsics.throwNpe();
    L51:
        View r127 = this.f250346b;
        if (r127 != null) goto L54;
        Intrinsics.throwNpe();
    L54:
        r126.offsetTopAndBottom(r127.getHeight());
        goto L76
    L69:
        View r128 = this.f250346b;
        if (r128 != null) goto L72;
        Intrinsics.throwNpe();
    L72:
        View r129 = this.f250346b;
        if (r129 != null) goto L75;
        Intrinsics.throwNpe();
    L75:
        r128.offsetLeftAndRight(-r129.getWidth());
    L76:
        Rect r130 = this.f250347c;
        View r131 = this.f250345a;
        if (r131 != null) goto L79;
        Intrinsics.throwNpe();
    L79:
        int r132 = r131.getLeft();
        View r133 = this.f250345a;
        if (r133 != null) goto L82;
        Intrinsics.throwNpe();
    L82:
        int r134 = r133.getTop();
        View r135 = this.f250345a;
        if (r135 != null) goto L85;
        Intrinsics.throwNpe();
    L85:
        int r136 = r135.getRight();
        View r137 = this.f250345a;
        if (r137 != null) goto L88;
        Intrinsics.throwNpe();
    L88:
        r130.set(r132, r134, r136, r137.getBottom());
        Rect r138 = this.f250349e;
        View r139 = this.f250346b;
        if (r139 != null) goto L91;
        Intrinsics.throwNpe();
    L91:
        int r140 = r139.getLeft();
        View r141 = this.f250346b;
        if (r141 != null) goto L94;
        Intrinsics.throwNpe();
    L94:
        int r142 = r141.getTop();
        View r143 = this.f250346b;
        if (r143 != null) goto L97;
        Intrinsics.throwNpe();
    L97:
        int r144 = r143.getRight();
        View r145 = this.f250346b;
        if (r145 != null) goto L100;
        Intrinsics.throwNpe();
    L100:
        r138.set(r140, r142, r144, r145.getBottom());
        Rect r146 = this.f250348d;
        int r147 = getMainOpenLeft();
        int r148 = getMainOpenTop();
        int r149 = getMainOpenLeft();
        View r150 = this.f250345a;
        if (r150 != null) goto L103;
        Intrinsics.throwNpe();
    L103:
        int r151 = r149 + r150.getWidth();
        int r152 = getMainOpenTop();
        View r153 = this.f250345a;
        if (r153 != null) goto L106;
        Intrinsics.throwNpe();
    L106:
        r146.set(r147, r148, r151, r152 + r153.getHeight());
        Rect r154 = this.f250350f;
        int r155 = getSecOpenLeft();
        int r156 = getSecOpenTop();
        int r157 = getSecOpenLeft();
        View r158 = this.f250346b;
        if (r158 != null) goto L109;
        Intrinsics.throwNpe();
    L109:
        int r159 = r157 + r158.getWidth();
        int r160 = getSecOpenTop();
        View r161 = this.f250346b;
        if (r161 != null) goto L112;
        Intrinsics.throwNpe();
    L112:
        r154.set(r155, r156, r159, r160 + r161.getHeight());
        if (this.f250352h == false) goto L115;
        f(false);
    L116:
        View r162 = this.f250345a;
        if (r162 != null) goto L119;
        Intrinsics.throwNpe();
    L119:
        this.f250358n = r162.getLeft();
        View r163 = this.f250345a;
        if (r163 != null) goto L122;
        Intrinsics.throwNpe();
    L122:
        this.f250359o = r163.getTop();
        return;
    L115:
        e(false);
        goto L116
    }
}
