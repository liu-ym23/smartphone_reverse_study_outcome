package com.bytedance.android.shopping.collect.custom_view;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.NestedScrollingParent3;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.shopping.collect.slice.CollectYataTemplateManager;
import com.bytedance.android.shopping.collect.slice.widgets.ProductCardContainerView;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u0001:\u0001!B'\b\u0007\u0012\u0006\u0010\u001a\u001a\u00020\u0019\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001b\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u001d¢\u0006\u0004\b\u001f\u0010 R$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\u0011\u001a\u00020\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0013\u001a\u0004\u0018\u00010\u00128B@\u0002X\u0082\u000e¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u001e\u0010\u0017\u001a\u0004\u0018\u00010\u00128B@\u0002X\u0082\u000e¢\u0006\f\n\u0004\b\u0017\u0010\u0014\u001a\u0004\b\u0018\u0010\u0016¨\u0006\""}, d2 = {"Lcom/bytedance/android/shopping/collect/custom_view/CollectGoodsTwoRevNestedScrollView;", "Landroidx/core/widget/NestedScrollView;", "Landroid/view/ViewGroup;", "h", "Landroid/view/ViewGroup;", "getInnerLayout", "()Landroid/view/ViewGroup;", "setInnerLayout", "(Landroid/view/ViewGroup;)V", "innerLayout", "", "j", "Z", "getNeedBlockLongClick", "()Z", "setNeedBlockLongClick", "(Z)V", "needBlockLongClick", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "firstFpsHook", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "getFirstFpsHook", "()Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "secondFpsHook", "getSecondFpsHook", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "b", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class CollectGoodsTwoRevNestedScrollView extends NestedScrollView {
    public final boolean a;
    public final boolean b;
    public final boolean c;
    public RecyclerView d;
    public RecyclerView e;
    public f f;
    public f g;
    public ViewGroup h;
    public Pair<? extends Object, Integer> i;
    public boolean j;
    public final b k;
    public final CollectGoodsTwoRevNestedScrollView$lockUpdateHook$1 l;

    public static final class a implements com.bytedance.android.shopping.collect.custom_view.a.InterfaceC0044a {
        public final /* synthetic */ CollectGoodsTwoRevNestedScrollView a;

        @Override // com.bytedance.android.shopping.collect.custom_view.a.InterfaceC0044a
        public final void b() {
            if (this.a.getNeedBlockLongClick() == false) goto L8;
            ProductCardContainerView r0 = CollectYataTemplateManager.a;
            NestedScrollingParent3 r1 = CollectYataTemplateManager.b;
            if (r1 == null) goto L9;
            r1.cancelLongPress();
            return;
        L9:
            return;
        }

        public a(CollectGoodsTwoRevNestedScrollView r1) {
            this.a = r1;
        }
    }

    public final class b extends com.bytedance.android.shopping.collect.custom_view.a {
        public final /* synthetic */ CollectGoodsTwoRevNestedScrollView d;

        /* JADX WARN: Multi-variable type inference failed */
        public b(CollectGoodsTwoRevNestedScrollView r1) {
            this.d = r1;
            super(r1.getContext());
            new Rect();
            new Rect();
        }

        public final void a(RecyclerView r2) {
            RecyclerView.OnScrollListener r0 = CollectGoodsTwoRevNestedScrollView.e(this.d);
            if (r0 == null) goto L6;
            if (r2 == null) goto L6;
            r2.removeOnScrollListener(r0);
        L6:
            RecyclerView.OnScrollListener r1 = CollectGoodsTwoRevNestedScrollView.f(this.d);
            if (r1 == null) goto L10;
            if (r2 == null) goto L10;
            r2.removeOnScrollListener(r1);
        L10:
            if (r2 == null) goto L13;
            r2.removeOnScrollListener(this.d.l);
            return;
        }
    }

    public CollectGoodsTwoRevNestedScrollView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public CollectGoodsTwoRevNestedScrollView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public void g(int r1) {
    }

    private final RecyclerView.OnScrollListener getFirstFpsHook() {
        Intrinsics.checkNotNullParameter("rev1", "type");
        return null;
    }

    private final RecyclerView.OnScrollListener getSecondFpsHook() {
        Intrinsics.checkNotNullParameter("rev2", "type");
        return null;
    }

    public final ViewGroup getInnerLayout() {
        return this.h;
    }

    public final boolean getNeedBlockLongClick() {
        return this.j;
    }

    public static final /* synthetic */ RecyclerView.OnScrollListener e(CollectGoodsTwoRevNestedScrollView r0) {
        return r0.getFirstFpsHook();
    }

    public static final /* synthetic */ RecyclerView.OnScrollListener f(CollectGoodsTwoRevNestedScrollView r0) {
        return r0.getSecondFpsHook();
    }

    public final boolean onInterceptTouchEvent(MotionEvent r4) {
        Intrinsics.checkNotNullParameter(r4, "ev");
        if (this.a == false) goto L15;
        if (r4.getAction() != 0) goto L12;
        AtomicBoolean r0 = this.k.a;
        if (this.i == null) goto L9;
        boolean r2 = true;
    L10:
        r0.set(r2);
        goto L12
    L9:
        r2 = false;
    L12:
        if (this.k.c.onTouchEvent(r4) == false) goto L15;
        return true;
    L15:
        return super.onInterceptTouchEvent(r4);
    }

    public final void setInnerLayout(ViewGroup r1) {
        this.h = r1;
    }

    public final void setNeedBlockLongClick(boolean r1) {
        this.j = r1;
    }

    public final void h(@NestedRevType String r7, RecyclerView r8) {
        Intrinsics.checkNotNullParameter(r7, "revType");
        b r1 = this.k;
        r1.getClass();
        Intrinsics.checkNotNullParameter(r7, "revType");
        f r5 = null;
        switch(r7.hashCode()) {
            case 3496942: goto L13;
            case 3496943: goto L6;
            default: goto L19;
        };
    L19:
        b r2 = this.k;
        r2.getClass();
        Intrinsics.checkNotNullParameter(r7, "revType");
        if (r8 == null) goto L22;
        r8.setOverScrollMode(2);
    L22:
        if (r8 == null) goto L25;
        r8.addOnScrollListener(r2.d.l);
    L25:
        switch(r7.hashCode()) {
            case 3496942: goto L34;
            case 3496943: goto L28;
            default: goto L40;
        };
    L28:
        if (r7.equals("rev2") == false) goto L40;
        RecyclerView.OnScrollListener r0 = r2.d.getSecondFpsHook();
        if (r0 == null) goto L40;
        if (r8 == null) goto L40;
        r8.addOnScrollListener(r0);
        goto L40
    L34:
        if (r7.equals("rev1") == false) goto L40;
        RecyclerView.OnScrollListener r3 = r2.d.getFirstFpsHook();
        if (r3 == null) goto L40;
        if (r8 == null) goto L40;
        r8.addOnScrollListener(r3);
    L40:
        switch(r7.hashCode()) {
            case 3496942: goto L50;
            case 3496943: goto L43;
            default: goto L60;
        };
    L60:
        return;
    L43:
        if (r7.equals("rev2") == false) goto L57;
        int r9 = f.c;
        if (r8 == null) goto L48;
        r5 = new f(r8);
    L48:
        this.g = r5;
        this.e = r8;
        return;
    L57:
        return;
    L50:
        if (r7.equals("rev1") == false) goto L59;
        int r10 = f.c;
        if (r8 == null) goto L55;
        r5 = new f(r8);
    L55:
        this.f = r5;
        this.d = r8;
        return;
    L59:
        return;
    L6:
        if (r7.equals("rev2") == false) goto L19;
        f r4 = r1.d.g;
        if (r4 == null) goto L10;
        RecyclerView r6 = r4.b;
    L11:
        r1.a(r6);
        r1.d.g = null;
        goto L19
    L10:
        r6 = null;
        goto L11
    L13:
        if (r7.equals("rev1") == false) goto L19;
        f r11 = r1.d.f;
        if (r11 == null) goto L17;
        RecyclerView r12 = r11.b;
    L18:
        r1.a(r12);
        r1.d.f = null;
        goto L19
    L17:
        r12 = null;
        goto L18
    }

    /* JADX WARN: Type inference failed for: r2v3, types: [com.bytedance.android.shopping.collect.custom_view.CollectGoodsTwoRevNestedScrollView$lockUpdateHook$1] */
    public CollectGoodsTwoRevNestedScrollView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.a = true;
        this.b = true;
        this.c = true;
        b r5 = new b(this);
        r5.b = new a(this);
        Unit r6 = Unit.INSTANCE;
        this.k = r5;
        this.l = new CollectGoodsTwoRevNestedScrollView$lockUpdateHook$1(this);
    }

    public /* synthetic */ CollectGoodsTwoRevNestedScrollView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }

    public final void onNestedScrollAccepted(View r4, View r5, int r6, int r7) {
        Intrinsics.checkNotNullParameter(r4, "child");
        Intrinsics.checkNotNullParameter(r5, "target");
        if (this.b == false) goto L26;
        if (r7 != 0) goto L26;
        Pair<? extends Object, Integer> r0 = this.i;
        if (r0 == null) goto L8;
        Object r1 = r0.getFirst();
    L10:
        if (Intrinsics.areEqual(r1, r5) == true) goto L26;
        Pair<? extends Object, Integer> r2 = this.i;
        if (r2 == null) goto L26;
        if (((Number) r2.getSecond()).intValue() != 2) goto L26;
        Pair<? extends Object, Integer> r3 = this.i;
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
        this.i = null;
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
        Pair<? extends Object, Integer> r0 = this.i;
        if (r0 == null) goto L5;
        Object r1 = r0.getFirst();
    L7:
        if (Intrinsics.areEqual(r1, r10) == true) goto L15;
        r13[1] = r12;
        if ((r10 instanceof RecyclerView) == true) goto L11;
        r10 = null;
    L11:
        RecyclerView r15 = (RecyclerView) r10;
        if (r15 == null) goto L36;
        r15.stopScroll();
    L36:
        int r16 = r13[1];
        return;
    L15:
        if (this.c == false) goto L17;
        g(r12);
    L17:
        super.onNestedPreScroll(r10, r11, r12 - r13[1], r13, r14);
        int r17 = r12 - r13[1];
        int r18 = com.bytedance.android.shopping.collect.custom_view.b.a;
        if (r17 >= 0) goto L20;
        boolean r19 = true;
    L21:
        if (r19 == false) goto L28;
        if (Intrinsics.areEqual(r10, this.d) == false) goto L36;
        if (canScrollVertically(r17) == false) goto L36;
        int r110 = Math.max(-getScrollY(), r17);
        r13[1] = r13[1] + r110;
        scrollBy(0, r110);
        goto L36
    L28:
        if (Intrinsics.areEqual(r10, this.e) == false) goto L36;
        if (canScrollVertically(r17) == false) goto L36;
        ViewGroup r111 = this.h;
        if (r111 == null) goto L34;
        int r112 = r111.getHeight();
    L35:
        int r113 = Math.min((r112 - getHeight()) - getScrollY(), r17);
        r13[1] = r13[1] + r113;
        scrollBy(0, r113);
        goto L36
    L34:
        r112 = 0;
        goto L35
    L20:
        r19 = false;
        goto L21
    L5:
        r1 = null;
        goto L7
    }

    public final void onNestedScroll(View r2, int r3, int r4, int r5, int r6, int r7, int[] r8) {
        Intrinsics.checkNotNullParameter(r2, "target");
        Intrinsics.checkNotNullParameter(r8, "consumed");
        if (this.c == true) goto L5;
        g(r4 + r6);
    L5:
        super.onNestedScroll(r2, r3, r4, r5, r6, r7, r8);
    }
}
