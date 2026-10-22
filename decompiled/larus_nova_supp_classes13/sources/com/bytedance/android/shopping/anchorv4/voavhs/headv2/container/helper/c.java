package com.bytedance.android.shopping.anchorv4.voavhs.headv2.container.helper;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.shopping.anchorv4.experiment.h;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.s;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.container.HeadRecyclerView;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.item.w;
import com.bytedance.android.shopping.extensions.ViewExtensionsKt;
import com.bytedance.android.shopping.utils.x;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class c {
    public int a;
    public int b;
    public View c;
    public boolean d;
    public Integer e;
    public final s f;
    public final RecyclerView g;
    public final b h;
    public final PagerSnapHelper i;

    public final void a() {
        boolean r0 = false;
        this.a = 0;
        this.b = -1;
        this.c = null;
        this.e = null;
        final Ref.IntRef r2 = new Ref.IntRef();
        r2.element = -1;
        final Ref.IntRef r1 = new Ref.IntRef();
        r1.element = Integer.MAX_VALUE;
        final int r3 = this.g.getWidth() / 2;
        d(new TransitionManager$tryCaptureView$1(r3, r1, r2));
        if (r2.element != 1) goto L7;
        View r4 = this.g.getChildAt(0);
        if ((r4.getWidth() + r4.getX()) <= (r4.getWidth() * 0.75f)) goto L7;
        r2.element = 0;
    L7:
        int r5 = r2.element;
        if (r5 < 0) goto L16;
        View r6 = this.g.getChildAt(r5);
        if (r6 == null) goto L17;
        this.a = (int) r6.getX();
        this.c = r6;
        this.b = this.g.getChildAdapterPosition(r6);
        if (this.a != 0) goto L14;
        r0 = true;
    L14:
        this.d = r0;
        return;
    L17:
        return;
    }

    public final int b(float r8) {
        return e((int) b.k(this.h, this.b, null, Boolean.FALSE, null, 10), (int) b.k(this.h, this.b, null, Boolean.TRUE, null, 10), r8);
    }

    public final void c(boolean r5) {
        b r0 = this.h;
        r0.getClass();
        if (h.a() == false) goto L10;
        RecyclerView r1 = r0.j.getRecyclerView();
        if (r1 == null) goto L10;
        View r3 = ViewExtensionsKt.b(r1, SizeHelper$endTransition$1$1.INSTANCE);
        if (r3 == null) goto L10;
        r0.q(r1.getChildAdapterPosition(r3), r3, null);
    L10:
        if (r5 == false) goto L12;
        float r6 = 1.0f;
    L13:
        f(r6);
        this.a = 0;
        this.b = -1;
        this.c = null;
        this.e = null;
        return;
    L12:
        r6 = 0.0f;
        goto L13
    }

    public final void d(Function2<? super w, ? super Integer, Unit> r5) {
        int r0 = this.g.getChildCount();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L8;
        View r2 = this.g.getChildAt(r1);
        if ((r2 instanceof w) == false) goto L7;
        r5.invoke(r2, Integer.valueOf(r1));
    L7:
        r1 = r1 + 1;
        goto L3
    }

    public final void f(final float r20) {
        if (this.c != null) goto L5;
        return;
    L5:
        if (r20 < 0) goto L122;
        this.g.stopScroll();
        if (this.h.j.W4() <= 0) goto L10;
        boolean r0 = true;
    L11:
        ViewGroup.LayoutParams r12 = null;
        if (r0 == false) goto L61;
        if (this.b >= this.h.c()) goto L61;
        final int r14 = e(this.h.l(true, this.b), this.h.l(false, this.b), r20);
        final int r4 = -1;
        if (h.a() == false) goto L18;
        this.e = Integer.valueOf(b(r20));
    L18:
        final int r5 = e(this.h.j(true, this.b, null), this.h.j(false, this.b, null), r20);
        final int r6 = e(this.h.d(true, this.b, null), this.h.d(false, this.b, null), r20);
        final int r7 = e(this.h.i(true, this.b), this.h.i(false, this.b), r20);
        Function2<w, Integer, Unit> r15 = new TransitionManager$onTransitionSpecialForHalf$1(this, r20, r14, r4, r5, r6, r7);
        int r1 = this.g.getChildCount();
        int r2 = 0;
    L19:
        if (r2 >= r1) goto L31;
        View r3 = this.g.getChildAt(r2);
        if ((r3 instanceof w) == false) goto L30;
        RecyclerView.LayoutManager r8 = this.g.getLayoutManager();
        if (r8 == null) goto L25;
        Integer r9 = Integer.valueOf(r8.getPosition(r3));
    L26:
        if (r9 == null) goto L30;
        if (r9.intValue() >= this.h.c()) goto L30;
        r15.invoke(r3, Integer.valueOf(r2));
        goto L30
    L25:
        r9 = null;
    L30:
        r2 = r2 + 1;
        goto L19
    L31:
        this.f.rR().Y(r14);
        if (this.b < 0) goto L118;
        View r10 = this.c;
        if (r10 == null) goto L36;
        ViewGroup.LayoutParams r11 = r10.getLayoutParams();
    L38:
        if ((r11 instanceof RecyclerView.LayoutParams) == false) goto L41;
        r12 = r11;
    L41:
        RecyclerView.LayoutParams r13 = (RecyclerView.LayoutParams) r12;
        if (r13 == null) goto L44;
        int r16 = ((ViewGroup.MarginLayoutParams) r13).leftMargin;
    L46:
        if (this.d == true) goto L48;
        int r17 = this.a;
    L55:
        int r18 = (int) ((r17 + ((0 - r17) * r20)) - r16);
        LinearLayoutManager r19 = this.g.getLayoutManager();
        if (r19 == null) goto L59;
        r19.scrollToPositionWithOffset(this.b, r18);
        this.f.rR().l0(Integer.valueOf(this.b), r18);
        return;
    L59:
        throw new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
    L48:
        if (this.c != null) goto L50;
        r17 = this.a;
        goto L55
    L50:
        if (this.b != (this.h.c() - 1)) goto L52;
        r17 = this.g.getWidth() - this.h.l(true, this.b);
        goto L55
    L52:
        r17 = (this.g.getWidth() - this.h.l(true, this.b)) / 2;
        goto L55
    L44:
        r16 = 0;
        goto L46
    L36:
        r11 = null;
        goto L38
    L118:
        return;
    L61:
        if (this.h.o() == false) goto L100;
        int r21 = this.h.l(true, this.b);
        int r22 = this.h.l(false, this.b);
        int r23 = this.h.e(true, this.b);
        int r24 = this.h.e(false, this.b);
        final int r25 = e(r21, r22, r20);
        if (h.a() == false) goto L65;
        final int r26 = -1;
    L67:
        if (h.a() == false) goto L69;
        this.e = Integer.valueOf(b(r20));
    L69:
        final int r27 = e(this.h.j(true, this.b, null), this.h.j(false, this.b, null), r20);
        final int r28 = e(this.h.d(true, this.b, null), this.h.d(false, this.b, null), r20);
        final int r29 = e(this.h.i(true, this.b), this.h.i(false, this.b), r20);
        d(new TransitionManager$onTransitionSmallDevice$1(this, r25, r26, r20, r27, r28, r29));
        if (this.b < 0) goto L95;
        View r30 = this.c;
        if (r30 == null) goto L74;
        ViewGroup.LayoutParams r31 = r30.getLayoutParams();
    L76:
        if ((r31 instanceof RecyclerView.LayoutParams) == true) goto L78;
        r31 = null;
    L78:
        RecyclerView.LayoutParams r32 = (RecyclerView.LayoutParams) r31;
        if (r32 == null) goto L81;
        int r33 = ((ViewGroup.MarginLayoutParams) r32).leftMargin;
    L83:
        if (this.d == true) goto L85;
        int r34 = this.a;
    L89:
        int r35 = (int) ((r34 + ((0 - r34) * r20)) - r33);
        LinearLayoutManager r36 = this.g.getLayoutManager();
        if (r36 == null) goto L93;
        r36.scrollToPositionWithOffset(this.b, r35);
        goto L95
    L93:
        throw new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
    L85:
        if (this.c == null) goto L87;
        r34 = (this.g.getWidth() - this.h.l(true, this.b)) / 2;
        goto L89
    L87:
        r34 = this.a;
        goto L89
    L81:
        r33 = 0;
        goto L83
    L74:
        r31 = null;
    L95:
        if (r20 != 1.0f) goto L97;
        this.i.attachToRecyclerView(this.g);
    L98:
        this.g.requestLayout();
        return;
    L97:
        this.i.attachToRecyclerView(null);
        goto L98
    L65:
        r26 = e(r23, r24, r20);
        goto L67
    L100:
        if (b.k(this.h, this.b, null, Boolean.FALSE, null, 10) == b.k(this.h, this.b, null, Boolean.TRUE, null, 10)) goto L121;
        int r37 = e(this.h.j(true, this.b, null), this.h.j(false, this.b, null), r20);
        int r38 = e(this.h.d(true, this.b, null), this.h.d(false, this.b, null), r20);
        View r39 = this.c;
        if (r39 == null) goto L110;
        ViewGroup.LayoutParams r40 = r39.getLayoutParams();
        if ((r40 instanceof ViewGroup.MarginLayoutParams) == false) goto L107;
        r12 = r40;
    L107:
        ViewGroup.MarginLayoutParams r110 = (ViewGroup.MarginLayoutParams) r12;
        if (r110 == null) goto L110;
        r110.topMargin = r37;
        r110.bottomMargin = r38;
        r39.setLayoutParams(r110);
    L110:
        this.e = Integer.valueOf(b(r20));
        this.g.requestLayout();
        return;
    L121:
        return;
    L10:
        r0 = false;
        goto L11
    }

    public static int e(int r1, int r2, float r3) {
        int r0 = x.a;
        float r4 = r1;
        return (int) (r4 + ((r2 - r4) * r3));
    }

    public c(s r2, HeadRecyclerView r3, b r4, HeadPagerSnapHelper r5) {
        Intrinsics.checkNotNullParameter(r2, "headAbility");
        Intrinsics.checkNotNullParameter(r3, "recyclerView");
        Intrinsics.checkNotNullParameter(r4, "sizeHelper");
        Intrinsics.checkNotNullParameter(r5, "pagerSnapHelper");
        this.f = r2;
        this.g = r3;
        this.h = r4;
        this.i = r5;
        this.b = -1;
        Intrinsics.checkNotNullParameter(this, "transitionManager");
        r4.b = this;
    }
}
