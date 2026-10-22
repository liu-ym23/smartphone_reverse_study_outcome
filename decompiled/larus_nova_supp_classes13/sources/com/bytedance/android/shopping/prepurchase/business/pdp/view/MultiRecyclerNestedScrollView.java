package com.bytedance.android.shopping.prepurchase.business.pdp.view;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u0014B\u000f\u0012\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0012\u0010\u0013J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u001a\u0010\u0007\u001a\u00020\u00052\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00050\u0004R*\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/shopping/prepurchase/business/pdp/view/MultiRecyclerNestedScrollView;", "Landroidx/core/widget/NestedScrollView;", "", "getMainFeedDefaultVisibleHeight", "Lkotlin/Function1;", "", "listener", "setOnScrollDistanceChangeListener", "Lkotlin/Function0;", "f", "Lkotlin/jvm/functions/Function0;", "getCoverAreaHeight", "()Lkotlin/jvm/functions/Function0;", "setCoverAreaHeight", "(Lkotlin/jvm/functions/Function0;)V", "coverAreaHeight", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "b", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class MultiRecyclerNestedScrollView extends NestedScrollView {
    public static final /* synthetic */ int n = 0;
    public final m a;
    public RecyclerView b;
    public RecyclerView c;
    public boolean d;
    public Pair<? extends Object, Integer> e;
    public Function0<Integer> f;
    public int g;
    public int h;
    public int i;
    public final MultiRecyclerNestedScrollView$topViewScrollChangeListener$1 j;
    public final int[] k;
    public Function1<? super Integer, Unit> l;
    public final MultiRecyclerNestedScrollView$bottomViewScrollChangeListener$1 m;

    public static final class a implements NestedScrollView.OnScrollChangeListener {
        public final /* synthetic */ MultiRecyclerNestedScrollView a;

        public a(MultiRecyclerNestedScrollView r1) {
            this.a = r1;
        }

        public final void onScrollChange(NestedScrollView r1, int r2, int r3, int r4, int r5) {
            MultiRecyclerNestedScrollView r6 = this.a;
            r6.g = r3;
            MultiRecyclerNestedScrollView.f(r6);
        }
    }

    public static final class b {
    }

    public static final class c implements View.OnLayoutChangeListener {
        public final /* synthetic */ RecyclerView a;
        public final /* synthetic */ MultiRecyclerNestedScrollView b;

        public c(RecyclerView r1, MultiRecyclerNestedScrollView r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.view.View.OnLayoutChangeListener
        public final void onLayoutChange(View r1, int r2, int r3, int r4, int r5, int r6, int r7, int r8, int r9) {
            if (this.a.getHeight() <= 0) goto L10;
            this.a.removeOnLayoutChangeListener(this);
            MultiRecyclerNestedScrollView r10 = this.b;
            r10.smoothScrollTo(0, MultiRecyclerNestedScrollView.e(r10));
            RecyclerView r11 = this.b.b;
            if (r11 != null) goto L7;
            return;
        L7:
            if (r11.canScrollVertically(1) != true) goto L12;
            MultiRecyclerNestedScrollView r12 = this.b;
            r12.j(r12.b);
            return;
        L12:
            return;
        }
    }

    static {
    }

    public final boolean onInterceptTouchEvent(MotionEvent r2) {
        Intrinsics.checkNotNullParameter(r2, "ev");
        return false;
    }

    private final int getMainFeedDefaultVisibleHeight() {
        RecyclerView r0 = this.b;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.getHeight();
    L6:
        Function0<Integer> r3 = this.f;
        if (r3 == null) goto L12;
        Integer r4 = (Integer) r3.invoke();
        if (r4 == null) goto L12;
        r1 = r4.intValue();
    L12:
        return r2 - r1;
    L5:
        r2 = 0;
        goto L6
    }

    public final boolean h() {
        RecyclerView r0 = this.b;
        if (r0 != null) goto L5;
    L6:
        RecyclerView r1 = this.b;
        if (r1 != null) goto L9;
    L11:
        return false;
    L9:
        if (r1.canScrollVertically(-1) != true) goto L11;
        return true;
    L5:
        if (r0.canScrollVertically(1) != true) goto L6;
        return true;
    }

    public final void k() {
        RecyclerView r0 = this.b;
        if (r0 == null) goto L5;
        r0.stopScroll();
    L5:
        RecyclerView r1 = this.c;
        if (r1 == null) goto L8;
        r1.stopScroll();
    L8:
        j(this.b);
        RecyclerView r2 = this.c;
        if (r2 == null) goto L12;
        r2.scrollToPosition(0);
    L12:
        if (Intrinsics.areEqual(r2, this.b) == false) goto L15;
        this.h = 0;
    L15:
        if (Intrinsics.areEqual(r2, this.c) == false) goto L17;
        this.i = 0;
    L17:
        RecyclerView r3 = this.c;
        if (r3 != null) goto L20;
        return;
    L20:
        if (r3.getHeight() <= 0) goto L22;
        scrollTo(0, getMainFeedDefaultVisibleHeight());
        return;
    L22:
        r3.addOnLayoutChangeListener(new c(r3, this));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean i() {
        if (getScrollY() >= getMainFeedDefaultVisibleHeight()) goto L5;
        return true;
    L5:
        return false;
    }

    public final Function0<Integer> getCoverAreaHeight() {
        return this.f;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [com.bytedance.android.shopping.prepurchase.business.pdp.view.MultiRecyclerNestedScrollView$topViewScrollChangeListener$1] */
    /* JADX WARN: Type inference failed for: r0v4, types: [com.bytedance.android.shopping.prepurchase.business.pdp.view.MultiRecyclerNestedScrollView$bottomViewScrollChangeListener$1] */
    public MultiRecyclerNestedScrollView(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        super(r3);
        this.j = new MultiRecyclerNestedScrollView$topViewScrollChangeListener$1(this);
        this.k = new int[2];
        this.m = new MultiRecyclerNestedScrollView$bottomViewScrollChangeListener$1(this);
        m r0 = new m(r3);
        this.a = r0;
        Unit r4 = Unit.INSTANCE;
        addView(r0, -1, -2);
        setOnScrollChangeListener(new a(this));
    }

    public static final /* synthetic */ int e(MultiRecyclerNestedScrollView r0) {
        return r0.getMainFeedDefaultVisibleHeight();
    }

    public static final void f(MultiRecyclerNestedScrollView r4) {
        RecyclerView r0 = r4.b;
        RecyclerView.LayoutManager r1 = null;
        if (r0 == null) goto L5;
        RecyclerView.LayoutManager r2 = r0.getLayoutManager();
    L7:
        if ((r2 instanceof StaggeredGridLayoutManager) == false) goto L10;
        r1 = r2;
    L10:
        StaggeredGridLayoutManager r3 = (StaggeredGridLayoutManager) r1;
        Intrinsics.checkNotNull(r3);
        int r5 = r3.findFirstVisibleItemPositions(r4.k)[0];
        if (r5 == 0) goto L13;
    L19:
        int r6 = (r4.g + r4.h) + r4.i;
        Function1<? super Integer, Unit> r7 = r4.l;
        if (r7 == null) goto L23;
        Unit r8 = (Unit) r7.invoke(Integer.valueOf(r6));
        return;
    L23:
        return;
    L13:
        if (r4.h() == true) goto L15;
        r4.h = 0;
    L18:
        r4.i = 0;
        goto L19
    L15:
        View r9 = r3.findViewByPosition(r5);
        if (r9 == null) goto L18;
        r4.h = Math.abs(r9.getTop());
        goto L18
    L5:
        r2 = null;
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean canScrollVertically(int r4) {
        boolean r0 = super/*android.widget.FrameLayout*/.canScrollVertically(r4);
        if (r4 >= 0) goto L17;
        if (r0 == false) goto L6;
        return r0;
    L6:
        if (this.d == false) goto L19;
        RecyclerView r1 = this.c;
        if (r1 != null) goto L10;
    L11:
        RecyclerView r2 = this.b;
        if (r2 != null) goto L14;
        return r0;
    L14:
        if (r2.canScrollVertically(r4) != true) goto L21;
    L15:
        return true;
    L21:
        return r0;
    L10:
        if (r1.canScrollVertically(r4) == true) goto L15;
    L19:
        return r0;
    L17:
        return r0;
    }

    public final void j(RecyclerView r3) {
        if (r3 == null) goto L16;
        RecyclerView.Adapter r0 = r3.getAdapter();
        if (r0 == null) goto L17;
        r3.scrollToPosition(Integer.valueOf(r0.getItemCount() - 1).intValue());
        if (r3.canScrollVertically(-1) == false) goto L8;
        int r1 = 100000;
    L10:
        if (Intrinsics.areEqual(r3, this.c) == false) goto L13;
        this.i = r1;
    L13:
        if (Intrinsics.areEqual(r3, this.b) == false) goto L18;
        this.h = r1;
        return;
    L18:
        return;
    L8:
        r1 = 0;
        goto L10
    L17:
        return;
    }

    public final void setCoverAreaHeight(Function0<Integer> r1) {
        this.f = r1;
    }

    public final void setOnScrollDistanceChangeListener(Function1<? super Integer, Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.l = r2;
    }

    public final void l(int r5, int r6) {
        int r0 = 0;
        scrollTo(0, 0);
        RecyclerView r1 = this.b;
        RecyclerView.LayoutManager r2 = null;
        if (r1 == null) goto L5;
        RecyclerView.LayoutManager r3 = r1.getLayoutManager();
    L7:
        if ((r3 instanceof StaggeredGridLayoutManager) == false) goto L10;
        r2 = r3;
    L10:
        StaggeredGridLayoutManager r4 = (StaggeredGridLayoutManager) r2;
        if (r4 == null) goto L13;
        r4.scrollToPositionWithOffset(r5, r6);
    L13:
        RecyclerView r7 = this.c;
        if (r7 == null) goto L17;
        r7.scrollToPosition(0);
    L17:
        if (Intrinsics.areEqual(r7, this.b) == false) goto L20;
        this.h = 0;
    L20:
        if (Intrinsics.areEqual(r7, this.c) == false) goto L22;
        this.i = 0;
    L22:
        if (r5 == 0) goto L25;
        r0 = 100000;
    L25:
        this.h = r0;
        return;
    L5:
        r3 = null;
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onMeasure(int r4, int r5) {
        this.a.setChildMaxHeight(Integer.valueOf((View.MeasureSpec.getSize(r5) - getPaddingTop()) - getPaddingBottom()));
        super.onMeasure(r4, r5);
    }

    public static final void g(MultiRecyclerNestedScrollView r4, View r5, int r6) {
        Pair<? extends Object, Integer> r0 = r4.e;
        if (r0 == null) goto L5;
        Object r1 = r0.getFirst();
    L6:
        Pair<? extends Object, Integer> r2 = r4.e;
        if (r2 == null) goto L9;
        Integer r3 = (Integer) r2.getSecond();
    L11:
        if (r6 == 0) goto L27;
        if (r6 != 1) goto L14;
        if (r3 != null) goto L24;
    L25:
        r4.e = new Pair(r5, Integer.valueOf(r6));
        return;
    L24:
        if (r3.intValue() != 1) goto L25;
        return;
    L14:
        if (r6 == 2) goto L17;
        return;
    L17:
        if (Intrinsics.areEqual(r1, r5) == false) goto L19;
    L20:
        r4.e = new Pair(r5, Integer.valueOf(r6));
        return;
    L19:
        if (r4.e == null) goto L20;
        return;
    L27:
        if ((!Intrinsics.areEqual(r1, r5)) == true) goto L36;
        r4.e = null;
        return;
    L36:
        return;
    L9:
        r3 = null;
        goto L11
    L5:
        r1 = null;
        goto L6
    }

    public final void onNestedScrollAccepted(View r4, View r5, int r6, int r7) {
        Intrinsics.checkNotNullParameter(r4, "child");
        Intrinsics.checkNotNullParameter(r5, "target");
        if (r7 != 0) goto L25;
        Pair<? extends Object, Integer> r0 = this.e;
        if (r0 == null) goto L7;
        Object r1 = r0.getFirst();
    L9:
        if ((!Intrinsics.areEqual(r1, r5)) == false) goto L25;
        Pair<? extends Object, Integer> r2 = this.e;
        if (r2 == null) goto L25;
        if (((Number) r2.getSecond()).intValue() != 2) goto L25;
        Pair<? extends Object, Integer> r3 = this.e;
        if (r3 == null) goto L17;
        Object r8 = r3.getFirst();
    L19:
        if ((r8 instanceof RecyclerView) == true) goto L21;
        r8 = null;
    L21:
        RecyclerView r9 = (RecyclerView) r8;
        if (r9 == null) goto L24;
        r9.stopScroll();
    L24:
        this.e = null;
        goto L25
    L17:
        r8 = null;
        goto L19
    L7:
        r1 = null;
    L25:
        super.onNestedScrollAccepted(r4, r5, r6, r7);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onNestedPreScroll(View r4, int r5, int r6, int[] r7, int r8) {
        Intrinsics.checkNotNullParameter(r4, "target");
        Intrinsics.checkNotNullParameter(r7, "consumed");
        Pair<? extends Object, Integer> r0 = this.e;
        if (r0 == null) goto L5;
        Object r1 = r0.getFirst();
    L7:
        if ((!Intrinsics.areEqual(r1, r4)) == false) goto L15;
        r7[1] = r6;
        if ((r4 instanceof RecyclerView) == true) goto L11;
        r4 = null;
    L11:
        RecyclerView r9 = (RecyclerView) r4;
        if (r9 == null) goto L28;
        r9.stopScroll();
        return;
    L28:
        return;
    L15:
        this.d = true;
        super.onNestedPreScroll(r4, r5, r6, r7, r8);
        this.d = false;
        int r10 = r6 - r7[1];
        if (r10 >= 0) goto L23;
        if (Intrinsics.areEqual(r4, this.b) == true) goto L20;
        return;
    L20:
        if (canScrollVertically(-1) == false) goto L30;
        int r11 = getScrollY();
        scrollBy(0, r10);
        r7[1] = r7[1] + (getScrollY() - r11);
        return;
    L30:
        return;
    L23:
        if (Intrinsics.areEqual(r4, this.c) == true) goto L25;
        return;
    L25:
        if (canScrollVertically(1) == false) goto L33;
        int r12 = getScrollY();
        scrollBy(0, r10);
        r7[1] = r7[1] + (getScrollY() - r12);
        return;
    L33:
        return;
    L5:
        r1 = null;
        goto L7
    }

    public final void onNestedScroll(View r2, int r3, int r4, int r5, int r6, int r7, int[] r8) {
        Intrinsics.checkNotNullParameter(r2, "target");
        Intrinsics.checkNotNullParameter(r8, "consumed");
        super.onNestedScroll(r2, r3, r4, r5, r6, r7, r8);
        int r9 = r6 - r8[1];
        if (Intrinsics.areEqual(r2, this.b) == false) goto L14;
        if (r9 <= 0) goto L14;
        RecyclerView r10 = this.c;
        if (r10 == null) goto L14;
        if (r10.canScrollVertically(r9) != true) goto L14;
        RecyclerView r11 = this.c;
        if (r11 == null) goto L12;
        r11.scrollBy(0, r9);
    L12:
        r8[1] = r8[1] + r9;
        return;
    L14:
        if (Intrinsics.areEqual(r2, this.c) == false) goto L26;
        if (r9 >= 0) goto L27;
        RecyclerView r12 = this.b;
        if (r12 != null) goto L19;
        return;
    L19:
        if (r12.canScrollVertically(r9) != true) goto L29;
        RecyclerView r13 = this.b;
        if (r13 == null) goto L23;
        r13.scrollBy(0, r9);
    L23:
        r8[1] = r8[1] + r9;
        return;
    L29:
        return;
    L27:
        return;
    }
}
