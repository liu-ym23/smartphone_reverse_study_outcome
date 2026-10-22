package com.bytedance.android.shopping.card_list.widgets.nest;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001:\u0001\u0005B'\b\u0007\u0012\u0006\u0010\u001d\u001a\u00020\u001c\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u001e\u0012\b\b\u0002\u0010!\u001a\u00020 ¢\u0006\u0004\b\"\u0010#J\b\u0010\u0003\u001a\u00020\u0002H\u0002R\"\u0010\u000b\u001a\u00020\u00048\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\"\u0010\u0013\u001a\u00020\f8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R$\u0010\u001b\u001a\u0004\u0018\u00010\u00148\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a¨\u0006$"}, d2 = {"Lcom/bytedance/android/shopping/card_list/widgets/nest/CardListTwoRevNestedScrollView;", "Landroidx/core/widget/NestedScrollView;", "", "getSessionId", "Lcom/bytedance/android/shopping/card_list/widgets/nest/d;", "a", "Lcom/bytedance/android/shopping/card_list/widgets/nest/d;", "getViewState", "()Lcom/bytedance/android/shopping/card_list/widgets/nest/d;", "setViewState", "(Lcom/bytedance/android/shopping/card_list/widgets/nest/d;)V", "viewState", "Lcom/bytedance/android/shopping/card_list/widgets/nest/CardListTwoRevViewAction;", "b", "Lcom/bytedance/android/shopping/card_list/widgets/nest/CardListTwoRevViewAction;", "getViewAction", "()Lcom/bytedance/android/shopping/card_list/widgets/nest/CardListTwoRevViewAction;", "setViewAction", "(Lcom/bytedance/android/shopping/card_list/widgets/nest/CardListTwoRevViewAction;)V", "viewAction", "Landroid/view/ViewGroup;", "g", "Landroid/view/ViewGroup;", "getInnerLayout", "()Landroid/view/ViewGroup;", "setInnerLayout", "(Landroid/view/ViewGroup;)V", "innerLayout", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class CardListTwoRevNestedScrollView extends NestedScrollView {
    public d a;
    public CardListTwoRevViewAction b;
    public RecyclerView c;
    public RecyclerView d;
    public e e;
    public e f;
    public ViewGroup g;
    public Pair<? extends Object, Integer> h;
    public final a i;
    public int j;
    public final CardListTwoRevNestedScrollView$lockUpdateHook$1 k;
    public final CardListTwoRevNestedScrollView$scrollListener$1 l;

    public final class a {
        public final AtomicBoolean a;
        public final GestureDetector b;
        public final Rect c;
        public final Rect d;
        public final /* synthetic */ CardListTwoRevNestedScrollView e;

        /* JADX INFO: renamed from: com.bytedance.android.shopping.card_list.widgets.nest.CardListTwoRevNestedScrollView$a$a, reason: collision with other inner class name */
        public static final class C0038a extends GestureDetector.SimpleOnGestureListener {
            public final /* synthetic */ a a;

            public C0038a(a r1) {
                this.a = r1;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public final boolean onSingleTapUp(MotionEvent r2) {
                Intrinsics.checkNotNullParameter(r2, "e");
                return this.a.a.get();
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public final boolean onScroll(MotionEvent r4, MotionEvent r5, float r6, float r7) {
                Intrinsics.checkNotNullParameter(r5, "e2");
                this.a.e.getViewAction().e.invoke(Float.valueOf(r6), Float.valueOf(r7));
                return super.onScroll(r4, r5, r6, r7);
            }
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

        public a(CardListTwoRevNestedScrollView r2, Context r3) {
            Intrinsics.checkNotNullParameter(r3, "context");
            this.e = r2;
            this.a = new AtomicBoolean(false);
            this.b = new GestureDetector(r3, new C0038a(this));
            this.c = new Rect();
            this.d = new Rect();
        }
    }

    public CardListTwoRevNestedScrollView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public CardListTwoRevNestedScrollView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    private final String getSessionId() {
        CardListTwoRevViewAction r0 = this.b;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("viewAction");
    L6:
        return (String) r0.b.invoke();
    }

    public final CardListTwoRevViewAction getViewAction() {
        CardListTwoRevViewAction r0 = this.b;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewAction");
    L5:
        return r0;
    }

    public final d getViewState() {
        d r0 = this.a;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewState");
    L5:
        return r0;
    }

    public final ViewGroup getInnerLayout() {
        return this.g;
    }

    public static final /* synthetic */ String e(CardListTwoRevNestedScrollView r0) {
        return r0.getSessionId();
    }

    public final boolean onInterceptTouchEvent(MotionEvent r4) {
        Intrinsics.checkNotNullParameter(r4, "ev");
        if (r4.getAction() != 0) goto L10;
        AtomicBoolean r0 = this.i.a;
        if (this.h == null) goto L7;
        boolean r2 = true;
    L8:
        r0.set(r2);
        goto L10
    L7:
        r2 = false;
    L10:
        if (this.i.b.onTouchEvent(r4) == false) goto L13;
        return true;
    L13:
        return super.onInterceptTouchEvent(r4);
    }

    public final void setInnerLayout(ViewGroup r1) {
        this.g = r1;
    }

    public final void setViewAction(CardListTwoRevViewAction r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.b = r2;
    }

    public final void setViewState(d r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.a = r2;
    }

    public final void f(@NestedRevType String r8, RecyclerView r9) {
        Intrinsics.checkNotNullParameter(r8, "revType");
        a r1 = this.i;
        r1.getClass();
        Intrinsics.checkNotNullParameter(r8, "revType");
        e r5 = null;
        switch(r8.hashCode()) {
            case 3496942: goto L17;
            case 3496943: goto L6;
            default: goto L27;
        };
    L27:
        a r2 = this.i;
        r2.getClass();
        Intrinsics.checkNotNullParameter(r8, "revType");
        if (r9 == null) goto L30;
        r9.setOverScrollMode(2);
    L30:
        if (r9 == null) goto L32;
        r9.addOnScrollListener(r2.e.k);
    L32:
        if (r9 == null) goto L35;
        r9.addOnScrollListener(r2.e.l);
    L35:
        switch(r8.hashCode()) {
            case 3496942: goto L45;
            case 3496943: goto L38;
            default: goto L55;
        };
    L55:
        return;
    L38:
        if (r8.equals("rev2") == false) goto L52;
        int r10 = e.c;
        if (r9 == null) goto L43;
        r5 = new e(r9);
    L43:
        this.f = r5;
        this.d = r9;
        return;
    L52:
        return;
    L45:
        if (r8.equals("rev1") == false) goto L54;
        int r11 = e.c;
        if (r9 == null) goto L50;
        r5 = new e(r9);
    L50:
        this.e = r5;
        this.c = r9;
        return;
    L54:
        return;
    L6:
        if (r8.equals("rev2") == false) goto L27;
        CardListTwoRevNestedScrollView r3 = r1.e;
        e r6 = r3.f;
        if (r6 == null) goto L10;
        RecyclerView r7 = r6.b;
    L11:
        if (r7 == null) goto L13;
        r7.removeOnScrollListener(r3.k);
    L13:
        if (r7 == null) goto L15;
        r7.removeOnScrollListener(r1.e.l);
    L15:
        r1.e.f = null;
        goto L27
    L10:
        r7 = null;
        goto L11
    L17:
        if (r8.equals("rev1") == false) goto L27;
        CardListTwoRevNestedScrollView r4 = r1.e;
        e r12 = r4.e;
        if (r12 == null) goto L21;
        RecyclerView r13 = r12.b;
    L22:
        if (r13 == null) goto L24;
        r13.removeOnScrollListener(r4.k);
    L24:
        if (r13 == null) goto L26;
        r13.removeOnScrollListener(r1.e.l);
    L26:
        r1.e.e = null;
        goto L27
    L21:
        r13 = null;
        goto L22
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [com.bytedance.android.shopping.card_list.widgets.nest.CardListTwoRevNestedScrollView$lockUpdateHook$1] */
    public CardListTwoRevNestedScrollView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.i = new a(this, r2);
        this.k = new CardListTwoRevNestedScrollView$lockUpdateHook$1(this);
        this.l = new CardListTwoRevNestedScrollView$scrollListener$1(this);
    }

    public /* synthetic */ CardListTwoRevNestedScrollView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }

    public final void onNestedScrollAccepted(View r4, View r5, int r6, int r7) {
        Intrinsics.checkNotNullParameter(r4, "child");
        Intrinsics.checkNotNullParameter(r5, "target");
        if (r7 != 0) goto L25;
        Pair<? extends Object, Integer> r0 = this.h;
        if (r0 == null) goto L7;
        Object r1 = r0.getFirst();
    L9:
        if (Intrinsics.areEqual(r1, r5) == true) goto L25;
        Pair<? extends Object, Integer> r2 = this.h;
        if (r2 == null) goto L25;
        if (((Number) r2.getSecond()).intValue() != 2) goto L25;
        Pair<? extends Object, Integer> r3 = this.h;
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
        this.h = null;
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
    public final void onNestedPreScroll(View r10, int r11, int r12, int[] r13, int r14) {
        Intrinsics.checkNotNullParameter(r10, "target");
        Intrinsics.checkNotNullParameter(r13, "consumed");
        Pair<? extends Object, Integer> r0 = this.h;
        if (r0 == null) goto L5;
        Object r1 = r0.getFirst();
    L7:
        if (Intrinsics.areEqual(r1, r10) == true) goto L14;
        r13[1] = r12;
        if ((r10 instanceof RecyclerView) == true) goto L11;
        r10 = null;
    L11:
        RecyclerView r15 = (RecyclerView) r10;
        if (r15 == null) goto L37;
        r15.stopScroll();
        return;
    L37:
        return;
    L14:
        CardListTwoRevViewAction r2 = this.b;
        if (r2 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("viewAction");
    L17:
        r2.a.invoke(Integer.valueOf(r12));
        super.onNestedPreScroll(r10, r11, r12 - r13[1], r13, r14);
        int r16 = r12 - r13[1];
        int r17 = c.a;
        if (r16 >= 0) goto L20;
        boolean r18 = true;
    L21:
        if (r18 == false) goto L28;
        if (Intrinsics.areEqual(r10, this.c) == true) goto L25;
        return;
    L25:
        if (canScrollVertically(r16) == false) goto L40;
        int r19 = Math.max(-getScrollY(), r16);
        r13[1] = r13[1] + r19;
        scrollBy(0, r19);
        return;
    L40:
        return;
    L28:
        if (Intrinsics.areEqual(r10, this.d) == true) goto L30;
        return;
    L30:
        if (canScrollVertically(r16) == false) goto L43;
        ViewGroup r110 = this.g;
        if (r110 == null) goto L34;
        int r111 = r110.getHeight();
    L35:
        int r112 = Math.min((r111 - getHeight()) - getScrollY(), r16);
        r13[1] = r13[1] + r112;
        scrollBy(0, r112);
        return;
    L34:
        r111 = 0;
        goto L35
    L43:
        return;
    L20:
        r18 = false;
        goto L21
    L5:
        r1 = null;
        goto L7
    }

    public final void onNestedScroll(View r2, int r3, int r4, int r5, int r6, int r7, int[] r8) {
        Intrinsics.checkNotNullParameter(r2, "target");
        Intrinsics.checkNotNullParameter(r8, "consumed");
        super.onNestedScroll(r2, r3, r4, r5, r6, r7, r8);
        int r9 = r6 - r8[1];
        if (Intrinsics.areEqual(r2, this.c) == false) goto L16;
        if (r9 <= 0) goto L16;
        RecyclerView r10 = this.d;
        if (r10 == null) goto L16;
        if (r10.canScrollVertically(r9) != true) goto L16;
        if (this.i.a(this.d) == false) goto L16;
        RecyclerView r11 = this.d;
        if (r11 == null) goto L14;
        r11.scrollBy(0, r9);
    L14:
        r8[1] = r8[1] + r9;
        return;
    L16:
        if (Intrinsics.areEqual(r2, this.d) == false) goto L30;
        if (r9 >= 0) goto L31;
        RecyclerView r12 = this.c;
        if (r12 != null) goto L21;
        return;
    L21:
        if (r12.canScrollVertically(r9) == true) goto L23;
        return;
    L23:
        if (this.i.a(this.c) == false) goto L34;
        RecyclerView r13 = this.c;
        if (r13 == null) goto L27;
        r13.scrollBy(0, r9);
    L27:
        r8[1] = r8[1] + r9;
        return;
    L34:
        return;
    L31:
        return;
    }
}
