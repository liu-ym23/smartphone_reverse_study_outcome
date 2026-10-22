package com.bytedance.android.shopping.new_cart.widgets.nest;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u00002\u00020\u0001:\u0001\u001eB'\b\u0007\u0012\u0006\u0010\u0018\u001a\u00020\u0017\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0019\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u0004¢\u0006\u0004\b\u001c\u0010\u001dJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016R$\u0010\r\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001e\u0010\u0013\u001a\u0004\u0018\u00010\u000e8B@\u0002X\u0082\u000e¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001e\u0010\u0016\u001a\u0004\u0018\u00010\u000e8B@\u0002X\u0082\u000e¢\u0006\f\n\u0004\b\u0014\u0010\u0010\u001a\u0004\b\u0015\u0010\u0012¨\u0006\u001f"}, d2 = {"Lcom/bytedance/android/shopping/new_cart/widgets/nest/CartTwoRevNestedScrollView;", "Landroidx/core/widget/NestedScrollView;", "", "getSessionId", "", "getMaxScrollRange", "Landroid/view/ViewGroup;", "i", "Landroid/view/ViewGroup;", "getInnerLayout", "()Landroid/view/ViewGroup;", "setInnerLayout", "(Landroid/view/ViewGroup;)V", "innerLayout", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "n", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "getFirstFpsHook", "()Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "firstFpsHook", "o", "getSecondFpsHook", "secondFpsHook", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class CartTwoRevNestedScrollView extends NestedScrollView {
    public final boolean a;
    public final boolean b;
    public final boolean c;
    public final boolean d;
    public RecyclerView e;
    public RecyclerView f;
    public g g;
    public g h;
    public ViewGroup i;
    public Pair<? extends Object, Integer> j;
    public final a k;
    public final CartTwoRevNestedScrollView$lockUpdateHook$1 l;
    public final CartTwoRevNestedScrollView$scrollListener$1 m;
    public RecyclerView.OnScrollListener n;
    public RecyclerView.OnScrollListener o;

    public final class a extends com.bytedance.android.shopping.new_cart.widgets.nest.a {
        public final Rect c;
        public final Rect d;
        public final /* synthetic */ CartTwoRevNestedScrollView e;

        /* JADX WARN: Multi-variable type inference failed */
        public a(CartTwoRevNestedScrollView r1) {
            this.e = r1;
            super(r1.getContext());
            this.c = new Rect();
            this.d = new Rect();
        }

        public final boolean a(RecyclerView r4) {
            if (r4 != null) goto L5;
            return false;
        L5:
            this.e.getGlobalVisibleRect(this.c);
            r4.getGlobalVisibleRect(this.d);
            Rect r5 = this.c;
            if (r5.top == this.d.top) goto L8;
            return false;
        L8:
            if (r5.height() != this.d.height()) goto L12;
            return true;
        L12:
            return false;
        }

        public final void b(RecyclerView r2) {
            RecyclerView.OnScrollListener r0 = CartTwoRevNestedScrollView.e(this.e);
            if (r0 == null) goto L6;
            if (r2 == null) goto L6;
            r2.removeOnScrollListener(r0);
        L6:
            RecyclerView.OnScrollListener r1 = CartTwoRevNestedScrollView.f(this.e);
            if (r1 == null) goto L10;
            if (r2 == null) goto L10;
            r2.removeOnScrollListener(r1);
        L10:
            if (r2 == null) goto L12;
            r2.removeOnScrollListener(this.e.l);
        L12:
            if (r2 == null) goto L15;
            r2.removeOnScrollListener(this.e.m);
            return;
        }
    }

    public CartTwoRevNestedScrollView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public CartTwoRevNestedScrollView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public void g(int r1) {
    }

    public String getSessionId() {
        return "";
    }

    public RecyclerView.OnScrollListener h(String r2) {
        Intrinsics.checkNotNullParameter(r2, "type");
        return null;
    }

    public void i(int r1) {
    }

    private final RecyclerView.OnScrollListener getFirstFpsHook() {
        if (this.n != null) goto L6;
        this.n = h("rev1");
    L6:
        return this.n;
    }

    private final RecyclerView.OnScrollListener getSecondFpsHook() {
        if (this.o != null) goto L6;
        this.o = h("rev2");
    L6:
        return this.o;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int getMaxScrollRange() {
        ViewGroup r0 = this.i;
        if (r0 == null) goto L5;
        int r1 = r0.getHeight();
    L7:
        return RangesKt.coerceAtLeast(r1 - getHeight(), 0);
    L5:
        r1 = 0;
        goto L7
    }

    public final ViewGroup getInnerLayout() {
        return this.i;
    }

    public static final /* synthetic */ RecyclerView.OnScrollListener e(CartTwoRevNestedScrollView r0) {
        return r0.getFirstFpsHook();
    }

    public static final /* synthetic */ RecyclerView.OnScrollListener f(CartTwoRevNestedScrollView r0) {
        return r0.getSecondFpsHook();
    }

    public final boolean onInterceptTouchEvent(MotionEvent r4) {
        Intrinsics.checkNotNullParameter(r4, "ev");
        if (this.b == false) goto L15;
        if (r4.getAction() != 0) goto L12;
        AtomicBoolean r0 = this.k.a;
        if (this.j == null) goto L9;
        boolean r2 = true;
    L10:
        r0.set(r2);
        goto L12
    L9:
        r2 = false;
    L12:
        if (this.k.b.onTouchEvent(r4) == false) goto L15;
        return true;
    L15:
        return super.onInterceptTouchEvent(r4);
    }

    public final void setInnerLayout(ViewGroup r1) {
        this.i = r1;
    }

    public final void j(@NestedRevType String r7, RecyclerView r8) {
        Intrinsics.checkNotNullParameter(r7, "revType");
        a r1 = this.k;
        r1.getClass();
        Intrinsics.checkNotNullParameter(r7, "revType");
        g r5 = null;
        switch(r7.hashCode()) {
            case 3496942: goto L13;
            case 3496943: goto L6;
            default: goto L19;
        };
    L19:
        a r2 = this.k;
        r2.getClass();
        Intrinsics.checkNotNullParameter(r7, "revType");
        if (r8 == null) goto L22;
        r8.setOverScrollMode(2);
    L22:
        if (r8 == null) goto L24;
        r8.addOnScrollListener(r2.e.l);
    L24:
        if (r8 == null) goto L27;
        r8.addOnScrollListener(r2.e.m);
    L27:
        switch(r7.hashCode()) {
            case 3496942: goto L36;
            case 3496943: goto L30;
            default: goto L42;
        };
    L30:
        if (r7.equals("rev2") == false) goto L42;
        RecyclerView.OnScrollListener r0 = r2.e.getSecondFpsHook();
        if (r0 == null) goto L42;
        if (r8 == null) goto L42;
        r8.addOnScrollListener(r0);
        goto L42
    L36:
        if (r7.equals("rev1") == false) goto L42;
        RecyclerView.OnScrollListener r3 = r2.e.getFirstFpsHook();
        if (r3 == null) goto L42;
        if (r8 == null) goto L42;
        r8.addOnScrollListener(r3);
    L42:
        switch(r7.hashCode()) {
            case 3496942: goto L52;
            case 3496943: goto L45;
            default: goto L62;
        };
    L62:
        return;
    L45:
        if (r7.equals("rev2") == false) goto L59;
        int r9 = g.c;
        if (r8 == null) goto L50;
        r5 = new g(r8);
    L50:
        this.h = r5;
        this.f = r8;
        return;
    L59:
        return;
    L52:
        if (r7.equals("rev1") == false) goto L61;
        int r10 = g.c;
        if (r8 == null) goto L57;
        r5 = new g(r8);
    L57:
        this.g = r5;
        this.e = r8;
        return;
    L61:
        return;
    L6:
        if (r7.equals("rev2") == false) goto L19;
        g r4 = r1.e.h;
        if (r4 == null) goto L10;
        RecyclerView r6 = r4.b;
    L11:
        r1.b(r6);
        r1.e.h = null;
        goto L19
    L10:
        r6 = null;
        goto L11
    L13:
        if (r7.equals("rev1") == false) goto L19;
        g r11 = r1.e.g;
        if (r11 == null) goto L17;
        RecyclerView r12 = r11.b;
    L18:
        r1.b(r12);
        r1.e.g = null;
        goto L19
    L17:
        r12 = null;
        goto L18
    }

    /* JADX WARN: Type inference failed for: r2v3, types: [com.bytedance.android.shopping.new_cart.widgets.nest.CartTwoRevNestedScrollView$lockUpdateHook$1] */
    public CartTwoRevNestedScrollView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.a = true;
        this.b = true;
        this.c = true;
        this.d = true;
        this.k = new a(this);
        this.l = new CartTwoRevNestedScrollView$lockUpdateHook$1(this);
        this.m = new CartTwoRevNestedScrollView$scrollListener$1(this);
    }

    public /* synthetic */ CartTwoRevNestedScrollView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }

    public final void onNestedScrollAccepted(View r4, View r5, int r6, int r7) {
        Intrinsics.checkNotNullParameter(r4, "child");
        Intrinsics.checkNotNullParameter(r5, "target");
        if (this.c == false) goto L26;
        if (r7 != 0) goto L26;
        Pair<? extends Object, Integer> r0 = this.j;
        if (r0 == null) goto L8;
        Object r1 = r0.getFirst();
    L10:
        if (Intrinsics.areEqual(r1, r5) == true) goto L26;
        Pair<? extends Object, Integer> r2 = this.j;
        if (r2 == null) goto L26;
        if (((Number) r2.getSecond()).intValue() != 2) goto L26;
        Pair<? extends Object, Integer> r3 = this.j;
        if (r3 == null) goto L18;
        Object r8 = r3.getFirst();
    L20:
        if ((r8 instanceof RecyclerView) == true) goto L22;
        r8 = null;
    L22:
        RecyclerView r9 = (RecyclerView) r8;
        if (r9 == null) goto L25;
        r9.stopScroll();
    L25:
        this.j = null;
        goto L26
    L18:
        r8 = null;
        goto L20
    L8:
        r1 = null;
    L26:
        super.onNestedScrollAccepted(r4, r5, r6, r7);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onNestedPreScroll(View r10, int r11, int r12, int[] r13, int r14) {
        Intrinsics.checkNotNullParameter(r10, "target");
        Intrinsics.checkNotNullParameter(r13, "consumed");
        Pair<? extends Object, Integer> r0 = this.j;
        if (r0 == null) goto L5;
        Object r1 = r0.getFirst();
    L7:
        if (Intrinsics.areEqual(r1, r10) == true) goto L15;
        r13[1] = r12;
        if ((r10 instanceof RecyclerView) == true) goto L11;
        r10 = null;
    L11:
        RecyclerView r15 = (RecyclerView) r10;
        if (r15 == null) goto L32;
        r15.stopScroll();
    L32:
        int r16 = r12 - r13[1];
        if (Math.abs(r12) >= Math.abs(r16)) goto L36;
        bg3.a r17 = com.bytedance.android.shopping.new_cart.utils.a.a;
        com.bytedance.android.shopping.new_cart.utils.a.j("dy error", "dy被放大了! " + r12 + " -> " + r16, null, 12);
        return;
    L36:
        return;
    L15:
        if (this.d == false) goto L17;
        i(r12);
    L17:
        super.onNestedPreScroll(r10, r11, r12 - r13[1], r13, r14);
        int r18 = r12 - r13[1];
        int r19 = f.a;
        if (r18 >= 0) goto L20;
        boolean r2 = true;
    L21:
        if (r2 == false) goto L28;
        if (Intrinsics.areEqual(r10, this.e) == false) goto L32;
        if (canScrollVertically(r18) == false) goto L32;
        int r110 = Math.max(-getScrollY(), r18);
        r13[1] = r13[1] + r110;
        scrollBy(0, r110);
        goto L32
    L28:
        if (Intrinsics.areEqual(r10, this.f) == false) goto L32;
        if (canScrollVertically(r18) == false) goto L32;
        int r111 = Math.min(getMaxScrollRange() - getScrollY(), r18);
        r13[1] = r13[1] + r111;
        scrollBy(0, r111);
        goto L32
    L20:
        r2 = false;
        goto L21
    L5:
        r1 = null;
        goto L7
    }

    public final void onNestedScroll(View r2, int r3, int r4, int r5, int r6, int r7, int[] r8) {
        Intrinsics.checkNotNullParameter(r2, "target");
        Intrinsics.checkNotNullParameter(r8, "consumed");
        if (this.d == true) goto L5;
        i(r4 + r6);
    L5:
        super.onNestedScroll(r2, r3, r4, r5, r6, r7, r8);
        if (this.a == false) goto L34;
        int r9 = r6 - r8[1];
        if (Intrinsics.areEqual(r2, this.e) == false) goto L21;
        if (r9 <= 0) goto L21;
        RecyclerView r10 = this.f;
        if (r10 == null) goto L21;
        if (r10.canScrollVertically(r9) != true) goto L21;
        if (this.k.a(this.f) == false) goto L21;
        RecyclerView r11 = this.f;
        if (r11 == null) goto L19;
        r11.scrollBy(0, r9);
    L19:
        r8[1] = r8[1] + r9;
        return;
    L21:
        if (Intrinsics.areEqual(r2, this.f) == false) goto L36;
        if (r9 >= 0) goto L37;
        RecyclerView r12 = this.e;
        if (r12 != null) goto L26;
        return;
    L26:
        if (r12.canScrollVertically(r9) == true) goto L28;
        return;
    L28:
        if (this.k.a(this.e) == false) goto L40;
        RecyclerView r13 = this.e;
        if (r13 == null) goto L32;
        r13.scrollBy(0, r9);
    L32:
        r8[1] = r8[1] + r9;
        return;
    L40:
        return;
    L37:
        return;
    L36:
        return;
    }
}
