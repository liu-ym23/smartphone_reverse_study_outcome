package com.bytedance.android.shopping.anchorv4.widgets;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0010\u0010\u0011R$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\r\u001a\u0004\u0018\u00010\u00028\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u0004\u001a\u0004\b\u000b\u0010\u0006\"\u0004\b\f\u0010\b¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/widgets/BasePdpNestedScrollView;", "Landroidx/core/widget/NestedScrollView;", "Landroidx/recyclerview/widget/RecyclerView;", "b", "Landroidx/recyclerview/widget/RecyclerView;", "getRvTop", "()Landroidx/recyclerview/widget/RecyclerView;", "setRvTop", "(Landroidx/recyclerview/widget/RecyclerView;)V", "rvTop", "c", "getRvBottom", "setRvBottom", "rvBottom", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class BasePdpNestedScrollView extends NestedScrollView {
    public static final /* synthetic */ int g = 0;
    public final c a;
    public RecyclerView b;
    public RecyclerView c;
    public boolean d;
    public Pair<? extends Object, Integer> e;
    public final BasePdpNestedScrollView$onScrollChangeListener$1 f;

    public final boolean onInterceptTouchEvent(MotionEvent r2) {
        Intrinsics.checkNotNullParameter(r2, "ev");
        return false;
    }

    public final RecyclerView getRvBottom() {
        return this.c;
    }

    public final RecyclerView getRvTop() {
        return this.b;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [com.bytedance.android.shopping.anchorv4.widgets.BasePdpNestedScrollView$onScrollChangeListener$1] */
    public BasePdpNestedScrollView(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        super(r3);
        this.f = new BasePdpNestedScrollView$onScrollChangeListener$1(this);
        c r0 = new c(r3);
        this.a = r0;
        Unit r4 = Unit.INSTANCE;
        addView(r0, -1, -2);
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

    public final void e(RecyclerView r2) {
        if (r2 == null) goto L7;
        RecyclerView.Adapter r0 = r2.getAdapter();
        if (r0 == null) goto L8;
        r2.scrollToPosition(Integer.valueOf(r0.getItemCount() - 1).intValue());
        return;
    L8:
        return;
    }

    public final void setRvBottom(RecyclerView r1) {
        this.c = r1;
    }

    public final void setRvTop(RecyclerView r1) {
        this.b = r1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onMeasure(int r4, int r5) {
        c r0 = this.a;
        r0.a = Integer.valueOf((View.MeasureSpec.getSize(r5) - getPaddingTop()) - getPaddingBottom());
        super.onMeasure(r4, r5);
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
