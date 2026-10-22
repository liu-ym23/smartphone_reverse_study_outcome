package com.bytedance.android.shopping.store.home.view;

import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.LinearLayout;
import android.widget.Scroller;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.ec.hybrid.list.view.ECHybridRecyclerView;
import com.bytedance.android.ec.store.setting.ECStoreSettings;
import com.bytedance.android.shopping.store.utils.CommonUtils;
import com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0002\u0006\rB'\b\u0007\u0012\u0006\u0010A\u001a\u00020@\u0012\n\b\u0002\u0010C\u001a\u0004\u0018\u00010B\u0012\b\b\u0002\u0010D\u001a\u00020<¢\u0006\u0004\bE\u0010FJ\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002R2\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\u00020\u0004j\b\u0012\u0004\u0012\u00020\u0002`\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR$\u0010\u0013\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R$\u0010\u001b\u001a\u0004\u0018\u00010\u00148\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\"\u0010#\u001a\u00020\u001c8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\"\u0010'\u001a\u00020\u001c8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b$\u0010\u001e\u001a\u0004\b%\u0010 \"\u0004\b&\u0010\"R\"\u0010+\u001a\u00020\u001c8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b(\u0010\u001e\u001a\u0004\b)\u0010 \"\u0004\b*\u0010\"R$\u00103\u001a\u0004\u0018\u00010,8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b-\u0010.\u001a\u0004\b/\u00100\"\u0004\b1\u00102R$\u00107\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b4\u0010\u000e\u001a\u0004\b5\u0010\u0010\"\u0004\b6\u0010\u0012R\"\u0010;\u001a\u00020\u001c8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b8\u0010\u001e\u001a\u0004\b9\u0010 \"\u0004\b:\u0010\"R\u0014\u0010?\u001a\u00020<8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b=\u0010>¨\u0006G"}, d2 = {"Lcom/bytedance/android/shopping/store/home/view/TopSheetLayout;", "Landroid/widget/LinearLayout;", "Landroid/view/View;", "getCurrentSheetView", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "a", "Ljava/util/ArrayList;", "getTopSheetViews", "()Ljava/util/ArrayList;", "setTopSheetViews", "(Ljava/util/ArrayList;)V", "topSheetViews", "b", "Landroid/view/View;", "getContentView", "()Landroid/view/View;", "setContentView", "(Landroid/view/View;)V", "contentView", "Lcom/bytedance/android/shopping/store/home/view/TopSheetLayout$b;", "e", "Lcom/bytedance/android/shopping/store/home/view/TopSheetLayout$b;", "getOnTopSheetOffsetChangeListener", "()Lcom/bytedance/android/shopping/store/home/view/TopSheetLayout$b;", "setOnTopSheetOffsetChangeListener", "(Lcom/bytedance/android/shopping/store/home/view/TopSheetLayout$b;)V", "onTopSheetOffsetChangeListener", "", "m", "Z", "getEnableSheetScroll", "()Z", "setEnableSheetScroll", "(Z)V", "enableSheetScroll", "n", "getEnableInternalScroll", "setEnableInternalScroll", "enableInternalScroll", "p", "getEnableSetNestedScrollView", "setEnableSetNestedScrollView", "enableSetNestedScrollView", "Lcom/bytedance/android/shopping/store/home/view/TopSheetLayout$a;", "q", "Lcom/bytedance/android/shopping/store/home/view/TopSheetLayout$a;", "getScrollListener", "()Lcom/bytedance/android/shopping/store/home/view/TopSheetLayout$a;", "setScrollListener", "(Lcom/bytedance/android/shopping/store/home/view/TopSheetLayout$a;)V", "scrollListener", "t", "getTargetChild", "setTargetChild", "targetChild", "w", "getSlideByHand", "setSlideByHand", "slideByHand", "", "getTopSheetViewHeight", "()I", "topSheetViewHeight", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class TopSheetLayout extends LinearLayout {
    public ArrayList<View> a;
    public View b;
    public final Scroller c;
    public WeakReference<View> d;
    public b e;
    public boolean f;
    public boolean g;
    public int h;
    public int i;
    public int j;
    public final VelocityTracker k;
    public int l;
    public boolean m;
    public boolean n;
    public final ArrayList<Integer> o;
    public boolean p;
    public a q;
    public RecyclerView r;
    public int s;
    public View t;
    public final TopSheetLayout$nestedScrollViewListener$1 u;
    public final int v;
    public boolean w;
    public final int[] x;
    public int y;
    public boolean z;

    public interface a {
        void onScrollStateChanged(int r1);
    }

    public interface b {
        void a(View r1);

        void b(float r1, boolean r2);
    }

    public TopSheetLayout(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public TopSheetLayout(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    private final View getCurrentSheetView() {
        int r0 = this.a.size();
        int r1 = 0;
        int r2 = 0;
    L3:
        if (r1 >= r0) goto L10;
        View r3 = getChildAt(r1);
        int r4 = f(getChildAt(r1)) + r2;
        int r5 = getScrollY();
        if (r2 > r5) goto L9;
        if (r4 < r5) goto L9;
        return r3;
    L9:
        r1 = r1 + 1;
        r2 = r4;
        goto L3
    L10:
        return null;
    }

    private final int getTopSheetViewHeight() {
        Iterator<T> r0 = this.a.iterator();
        int r1 = 0;
    L4:
        if (r0.hasNext() == false) goto L6;
        r1 = r1 + f((View) r0.next());
        goto L4
    L6:
        return r1;
    }

    public final void b() {
        this.c.abortAnimation();
        this.y = getScrollY();
        this.w = false;
        scrollTo(0, getTopSheetViewHeight());
        c();
    }

    public final void h() {
        if (this.c.isFinished() == true) goto L5;
        return;
    L5:
        View r0 = getCurrentSheetView();
        if (r0 != null) goto L8;
        return;
    L8:
        int r1 = f(r0);
        View r2 = r0;
    L10:
        if (CollectionsKt.contains(this.o, g(r2)) == false) goto L20;
        Integer r3 = g(r2);
        if (r3 == null) goto L16;
        int r4 = r3.intValue() + 1;
        if (r4 >= getChildCount()) goto L16;
        r2 = getChildAt(r4);
    L17:
        if (r2 == null) goto L20;
        r1 = r1 + f(r2);
    L16:
        r2 = null;
    L20:
        int r5 = (int) (getScrollY() - r0.getY());
        int r6 = r1 / 2;
        if (1 > r5) goto L25;
        if (r6 <= r5) goto L25;
        int r7 = -r5;
    L30:
        if (r7 == 0) goto L35;
        this.y = getScrollY();
        this.c.startScroll(0, getScrollY(), 0, r7);
        invalidate();
        return;
    L35:
        return;
    L25:
        if (r6 > r5) goto L29;
        if (r1 <= r5) goto L29;
        r7 = r1 - r5;
    L29:
        r7 = 0;
        goto L30
    }

    public final void c() {
        if (getTopSheetViewHeight() > 0.0f) goto L5;
        return;
    L5:
        if (getScrollY() > getTopSheetViewHeight()) goto L22;
        b r0 = this.e;
        if (r0 == null) goto L9;
        r0.b(getScrollY() / getTopSheetViewHeight(), this.w);
    L9:
        View r1 = getCurrentSheetView();
        if (r1 != null) goto L12;
        return;
    L12:
        getScrollY();
        r1.getY();
        if (f(r1) == 0) goto L15;
        f(r1);
    L15:
        Integer r2 = g(r1);
        if (r2 == null) goto L23;
        r2.intValue();
        b r3 = this.e;
        if (r3 == null) goto L24;
        r3.a(r1);
        return;
    L24:
        return;
    L23:
        return;
    }

    @Override // android.view.View
    public final void computeScroll() {
        super.computeScroll();
        if (this.c.computeScrollOffset() == false) goto L18;
        this.z = true;
        int r3 = this.c.getCurrY() - this.y;
        this.y = this.c.getCurrY();
        WeakReference<View> r4 = this.d;
        if (r4 == null) goto L7;
        View r5 = r4.get();
    L8:
        int[] r6 = this.x;
        r6[0] = 0;
        r6[1] = 0;
        i(r3, r5, r6);
        if (r5 == null) goto L16;
        int r7 = r3 - this.x[1];
        if (r5.canScrollVertically(r7) == false) goto L16;
        r5.scrollBy(0, r7);     // Catch: Exception -> L14
    L14:
        e = move-exception;
        dm.a.b r8 = dm.a.a;
        dm.a.a("shop.topsheetlayout").b(e.getMessage(), e);
    L16:
        invalidate();
        goto L18
    L7:
        r5 = null;
    L18:
        if (this.z == true) goto L20;
        return;
    L20:
        if (this.c.isFinished() == false) goto L30;
        this.z = false;
        this.d = null;
        h();
        if (this.r != null) goto L24;
        return;
    L24:
        if (this.s == 0) goto L32;
        d(0);
        return;
    L32:
        return;
    }

    public final View getContentView() {
        return this.b;
    }

    public final boolean getEnableInternalScroll() {
        return this.n;
    }

    public final boolean getEnableSetNestedScrollView() {
        return this.p;
    }

    public final boolean getEnableSheetScroll() {
        return this.m;
    }

    public final b getOnTopSheetOffsetChangeListener() {
        return this.e;
    }

    public final a getScrollListener() {
        return this.q;
    }

    public final boolean getSlideByHand() {
        return this.w;
    }

    public final View getTargetChild() {
        return this.t;
    }

    public final ArrayList<View> getTopSheetViews() {
        return this.a;
    }

    public static int f(View r2) {
        int r0 = r2.getHeight();
        ViewGroup.LayoutParams r3 = r2.getLayoutParams();
        if ((r3 instanceof ViewGroup.MarginLayoutParams) == true) goto L5;
        r3 = null;
    L5:
        ViewGroup.MarginLayoutParams r4 = (ViewGroup.MarginLayoutParams) r3;
        if (r4 == null) goto L8;
        int r1 = r4.topMargin + r4.bottomMargin;
    L10:
        return r0 + r1;
    L8:
        r1 = 0;
        goto L10
    }

    public final void a(boolean r8) {
        this.c.abortAnimation();
        this.y = getScrollY();
        this.c.startScroll(0, getScrollY(), 0, getTopSheetViewHeight() - getScrollY(), this.v);
        invalidate();
        this.w = r8;
        c();
    }

    @Override // android.view.View
    public final boolean canScrollVertically(int r1) {
        if (r1 >= 0) goto L6;
        if (getScrollY() != 0) goto L6;
    L8:
        return false;
    L6:
        if (this.m == false) goto L8;
        return true;
    }

    public final void d(int r2) {
        this.s = r2;
        a r0 = this.q;
        if (r0 == null) goto L6;
        r0.onScrollStateChanged(r2);
        return;
    }

    public final Integer g(View r4) {
        int r0 = getChildCount();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L9;
        if (Intrinsics.areEqual(getChildAt(r1), r4) == true) goto L7;
        r1 = r1 + 1;
        goto L3
    L7:
        return Integer.valueOf(r1);
    L9:
        return null;
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r6) {
        Intrinsics.checkNotNullParameter(r6, "ev");
        if (r6.getAction() != 0) goto L8;
        this.t = null;
        this.c.abortAnimation();
        this.d = null;
        if (this.s != 2) goto L8;
        d(1);
    L8:
        if (this.g == false) goto L10;
        return false;
    L10:
        int r0 = r6.getAction();
        if (r0 != 2) goto L16;
        if (this.f == false) goto L16;
        return true;
    L16:
        if (super.onInterceptTouchEvent(r6) == false) goto L19;
        return true;
    L19:
        if (getScrollY() == 0) goto L21;
    L23:
        if (r0 == 0) goto L47;
        if (r0 != 2) goto L49;
        this.k.addMovement(r6);
        int r7 = (int) r6.getY();
        int r1 = this.i - r7;
        if (getScrollY() != getTopSheetViewHeight()) goto L29;
        boolean r2 = true;
    L30:
        if (r2 == false) goto L37;
        View r3 = this.t;
        if (r3 == null) goto L37;
        if (r3.canScrollVertically(r1) != true) goto L37;
        this.f = false;
    L40:
        if (this.s != 1) goto L42;
    L46:
        this.j = r7;
        goto L49
    L42:
        if (this.f == false) goto L46;
        if (canScrollVertically(r1) == false) goto L46;
        d(1);
    L37:
        if (Math.abs(r1) <= this.h) goto L40;
        this.f = true;
        goto L40
    L29:
        r2 = false;
    L49:
        return this.f;
    L47:
        this.i = (int) r6.getY();
        this.j = (int) r6.getY();
        this.f = false;
        this.k.clear();
        this.k.addMovement(r6);
        goto L49
    L21:
        if (canScrollVertically(1) == true) goto L23;
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onStopNestedScroll(View r2) {
        Intrinsics.checkNotNullParameter(r2, "child");
        super.onStopNestedScroll(r2);
        this.g = false;
        h();
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r7) {
        Intrinsics.checkNotNullParameter(r7, "ev");
        dm.a.a("TopSheetLayout").a("onTouchEvent lastMoveEventY = " + this.j + ",ev.y = " + r7.getY());
        if (this.m == false) goto L24;
        int r0 = r7.getAction();
        this.k.addMovement(r7);
        if (r0 != 1) goto L7;
        this.k.computeCurrentVelocity(ECDraweeView.SQUARE, this.l);
        e(-this.k.getYVelocity(), this.t);
    L20:
        if (r0 != 1) goto L24;
        if (this.c.isFinished() == false) goto L24;
        h();
        goto L24
    L7:
        if (r0 != 2) goto L20;
        int r3 = (int) (this.j - r7.getY());
        int[] r4 = this.x;
        r4[0] = 0;
        r4[1] = 0;
        i(r3, this.t, r4);
        View r5 = this.t;
        if (r5 == null) goto L12;
        r5.scrollBy(0, r3 - this.x[1]);
    L12:
        this.j = (int) r7.getY();
        if (this.s == 1) goto L20;
        if (Math.abs(r3) <= this.h) goto L20;
        if (canScrollVertically(r3) == false) goto L20;
        d(1);
    L24:
        this.w = true;
        if (super.onTouchEvent(r7) == false) goto L27;
    L28:
        return true;
    L27:
        if (this.m == true) goto L28;
        return false;
    }

    public final void setContentView(View r1) {
        this.b = r1;
    }

    public final void setEnableInternalScroll(boolean r1) {
        this.n = r1;
    }

    public final void setEnableSetNestedScrollView(boolean r1) {
        this.p = r1;
    }

    public final void setEnableSheetScroll(boolean r1) {
        this.m = r1;
    }

    public final void setOnTopSheetOffsetChangeListener(b r1) {
        this.e = r1;
    }

    public final void setScrollListener(a r1) {
        this.q = r1;
    }

    public final void setSlideByHand(boolean r1) {
        this.w = r1;
    }

    public final void setTargetChild(View r1) {
        this.t = r1;
    }

    public final void setTopSheetViews(ArrayList<View> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.a = r2;
    }

    public final void e(float r11, View r12) {
        if (r12 == null) goto L4;
        this.d = new WeakReference(r12);
    L4:
        int r5 = (int) r11;
        if (canScrollVertically(r5) == false) goto L12;
        this.c.abortAnimation();
        this.c.fling(0, getScrollY(), 0, r5, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE);
        this.y = getScrollY();
        invalidate();
        if (this.r != null) goto L9;
        return;
    L9:
        if (this.s == 2) goto L14;
        d(2);
        return;
    L14:
        return;
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int r5, int r6) {
        if (getChildCount() < 2) goto L14;
        this.a.clear();
        int r0 = getChildCount();
        int r1 = 0;
    L5:
        if (r1 >= r0) goto L11;
        View r2 = getChildAt(r1);
        if (r1 >= (getChildCount() - 1)) goto L9;
        this.a.add(r2);
    L10:
        measureChild(r2, r5, r6);
        r1 = r1 + 1;
        goto L5
    L9:
        this.b = r2;
        goto L10
    L11:
        setMeasuredDimension(View.MeasureSpec.getSize(r5), View.MeasureSpec.getSize(r6));
        return;
    L14:
        throw new IllegalArgumentException("child count must >= 2");
    }

    /* JADX WARN: Type inference failed for: r3v6, types: [com.bytedance.android.shopping.store.home.view.TopSheetLayout$nestedScrollViewListener$1] */
    public TopSheetLayout(final Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.a = new ArrayList();
        this.c = new Scroller(r2, new AccelerateDecelerateInterpolator());
        this.k = VelocityTracker.obtain();
        this.m = true;
        this.n = true;
        this.o = new ArrayList();
        this.u = new TopSheetLayout$nestedScrollViewListener$1(this);
        com.bytedance.android.ec.store.setting.e r5 = ECStoreSettings.g();
        if (r5 == null) goto L5;
        long r6 = r5.a();
    L6:
        this.v = (int) r6;
        Handler r7 = CommonUtils.a;
        CommonUtils.c(false, new AnonymousClass1(this, r2));
        this.x = new int[2];
        return;
    L5:
        r6 = 500;
        goto L6
    }

    public final void i(int r5, View r6, int[] r7) {
        if (getTopSheetViewHeight() <= 0) goto L31;
        if (r5 != 0) goto L6;
        return;
    L6:
        if (this.n == true) goto L9;
        return;
    L9:
        if (getScrollY() < getTopSheetViewHeight()) goto L19;
        if (getScrollY() != getTopSheetViewHeight()) goto L13;
        boolean r0 = true;
    L14:
        if (r0 == false) goto L33;
        if (r6 == null) goto L19;
        if (r6.canScrollVertically(r5) != true) goto L19;
        return;
    L33:
        return;
    L13:
        r0 = false;
    L19:
        if ((getScrollY() + r5) <= getTopSheetViewHeight()) goto L21;
        int r8 = getTopSheetViewHeight() - getScrollY();
    L23:
        if ((r5 + getScrollY()) >= 0) goto L25;
        r8 = -getScrollY();
    L25:
        scrollBy(0, r8);
        if (r7 == null) goto L28;
        r7[1] = r8;
    L28:
        if (r8 == 0) goto L35;
        this.w = true;
        c();
        return;
    L35:
        return;
    L21:
        r8 = r5;
        goto L23
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean onNestedPreFling(View r1, float r2, float r3) {
        Intrinsics.checkNotNullParameter(r1, "target");
        if (this.m == true) goto L6;
        return false;
    L6:
        e(r3, r1);
        return true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean onStartNestedScroll(View r2, View r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "child");
        Intrinsics.checkNotNullParameter(r3, "target");
        if (this.m == true) goto L6;
        return false;
    L6:
        if (r4 != 2) goto L9;
        this.g = true;
        return true;
    L9:
        return false;
    }

    public /* synthetic */ TopSheetLayout(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onNestedPreScroll(View r2, int r3, int r4, int[] r5) {
        Intrinsics.checkNotNullParameter(r2, "target");
        Intrinsics.checkNotNullParameter(r5, "consumed");
        if ((r2 instanceof ECHybridRecyclerView) == true) goto L5;
    L9:
        RecyclerView r6 = this.r;
        if (r6 == null) goto L12;
        r6.removeOnScrollListener(this.u);
    L12:
        this.r = null;
    L13:
        i(r4, r2, r5);
        return;
    L5:
        if (this.p == false) goto L9;
        if ((!Intrinsics.areEqual(r2, this.r)) == false) goto L13;
        ((ECHybridRecyclerView) r2).addOnScrollListener(this.u);
        Unit r7 = Unit.INSTANCE;
        this.r = (RecyclerView) r2;
        goto L13
    }
}
