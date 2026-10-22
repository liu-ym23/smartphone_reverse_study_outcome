package com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.widget;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.bytedance.android.ec.core.abtest.ECSettingKeys;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.GalleryFragment;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.c0;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.i0;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class o implements g {
    public List<c0> a;
    public ViewGroup b;
    public TabIndicatorScrollView c;
    public com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.l d;
    public View e;
    public boolean f;
    public ImageView g;
    public ImageView h;
    public boolean i;
    public com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.e j;
    public final TabIndicatorV2$bubbleRunnable$1 k;
    public final Function0<Unit> l;
    public final Function1<Integer, Unit> m;
    public final com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.m n;
    public final f o;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ c0 a;
        public final /* synthetic */ o b;
        public final /* synthetic */ ViewGroup c;

        public a(c0 r1, o r2, ViewGroup r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            this.b.n.e(this.a.d);
            this.b.m.invoke(Integer.valueOf(this.a.a));
        }
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ o a;

        public b(o r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r3) {
            o r4 = this.a;
            r4.n.d = true;
            r4.l.invoke();
        }
    }

    public static final class c implements View.OnClickListener {
        public final /* synthetic */ o a;

        public c(o r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            o r3 = this.a;
            com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.e r0 = r3.j;
            if (r0 == null) goto L5;
            r0.a();
        L5:
            f r4 = r3.o;
            if (r4 == null) goto L9;
            r4.k10(m.o);
            return;
        }
    }

    public final void d() {
        ImageView r0 = this.g;
        ViewGroup.LayoutParams r1 = null;
        if (r0 == null) goto L5;
        ViewGroup.LayoutParams r2 = r0.getLayoutParams();
    L7:
        if ((r2 instanceof LinearLayout.LayoutParams) == false) goto L10;
        r1 = r2;
    L10:
        LinearLayout.LayoutParams r3 = (LinearLayout.LayoutParams) r1;
        if (r3 == null) goto L19;
        ImageView r4 = this.h;
        if (r4 != null) goto L15;
    L17:
        int r5 = 0;
    L18:
        r3.setMarginEnd(r5);
        goto L19
    L15:
        if (r4.getVisibility() != 0) goto L17;
        r5 = com.bytedance.android.shopping.extensions.b.b(20);
    L19:
        if (r3 == null) goto L24;
        ImageView r6 = this.g;
        if (r6 == null) goto L25;
        r6.setLayoutParams(r3);
        return;
    L25:
        return;
    L24:
        return;
    L5:
        r2 = null;
        goto L7
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.widget.g
    public final void onDestroy() {
        ImageView r0 = this.g;
        if (r0 == null) goto L6;
        r0.removeCallbacks(this.k);
        return;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.widget.g
    public final boolean a() {
        return this.f;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.widget.g
    public final View b() {
        return this.e;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.widget.g
    public final void onPageSelected(int r12) {
        f r0 = this.o;
        if (r0 == null) goto L5;
        Boolean r1 = Boolean.valueOf(r0.wW(m.o, Integer.valueOf(r12)));
    L6:
        Iterator<T> r2 = this.a.iterator();
        com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.widget.b r5 = null;
        int r4 = 0;
    L8:
        if (r2.hasNext() == false) goto L34;
        Object r6 = r2.next();
        int r7 = r4 + 1;
        if (r4 >= 0) goto L12;
        CollectionsKt.throwIndexOverflow();
    L12:
        c0 r8 = (c0) r6;
        ViewGroup r9 = this.b;
        if (r9 == null) goto L15;
        View r10 = r9.getChildAt(r4);
    L17:
        if ((r10 instanceof com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.widget.b) == true) goto L19;
        r10 = null;
    L19:
        com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.widget.b r11 = (com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.widget.b) r10;
        if (r11 == null) goto L33;
        int r13 = r8.a;
        if (r13 <= r12) goto L24;
    L26:
        boolean r14 = false;
    L27:
        r11.setSelected(r14);
        if (this.a.size() <= 1) goto L30;
        r11.a = r14;
    L30:
        r11.setText(r8.a(r12));
        if (r14 == false) goto L33;
        r5 = r11;
        goto L33
    L24:
        if (r12 >= (r13 + r8.b)) goto L26;
        r14 = true;
    L33:
        r4 = r7;
        goto L8
    L15:
        r10 = null;
        goto L17
    L34:
        TabIndicatorScrollView r15 = this.c;
        if (r15 == null) goto L38;
        r15.post(new n(r15, r5));
    L38:
        if (Intrinsics.areEqual(r1, Boolean.TRUE) == false) goto L50;
        f r16 = this.o;
        if (r16 == null) goto L42;
        r16.Bt(m.o);
    L42:
        ImageView r17 = this.g;
        if (r17 == null) goto L45;
        r17.setVisibility(0);
    L45:
        d();
        if (this.i == false) goto L64;
        this.i = false;
        ImageView r18 = this.g;
        if (r18 == null) goto L65;
        TabIndicatorV2$bubbleRunnable$1 r3 = this.k;
        int r19 = com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.i.a;
        r18.postDelayed(r3, 2000);
        return;
    L65:
        return;
    L64:
        return;
    L50:
        ImageView r110 = this.g;
        if (r110 == null) goto L53;
        r110.setVisibility(8);
    L53:
        ImageView r111 = this.g;
        if (r111 == null) goto L56;
        r111.removeCallbacks(this.k);
    L56:
        com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.e r112 = this.j;
        if (r112 == null) goto L67;
        r112.a();
        return;
    L67:
        return;
    L5:
        r1 = null;
        goto L6
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.widget.g
    public final void setData(List<c0> r2) {
        Intrinsics.checkNotNullParameter(r2, "tabList");
        this.a = r2;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.widget.g
    public final void c(ViewGroup r18, com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.l r19) {
        Intrinsics.checkNotNullParameter(r18, "parent");
        this.d = r19;
        View r3 = th.a.c(r18.getContext(), 2131560496, r18, true);
        if (r3 == null) goto L63;
        FrameLayout r4 = (FrameLayout) r3;
        View r5 = r18.findViewById(2131374270);
        if (r5 == null) goto L61;
        FrameLayout r6 = (FrameLayout) r5;
        if (com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.i.b() == false) goto L15;
        ViewGroup.LayoutParams r7 = r6.getLayoutParams();
        if ((r7 instanceof ViewGroup.MarginLayoutParams) == true) goto L11;
        r7 = null;
    L11:
        ViewGroup.MarginLayoutParams r8 = (ViewGroup.MarginLayoutParams) r7;
        if (r8 != null) goto L14;
        r8 = new ViewGroup.MarginLayoutParams(-2, -2);
    L14:
        r8.topMargin = eh.b.b(r18.getContext());
        r8.height = m.n;
        Unit r9 = Unit.INSTANCE;
        r6.setLayoutParams(r8);
    L22:
        this.e = r6;
        View r10 = r6.findViewById(2131376107);
        if (r10 == null) goto L25;
        r10.setOnClickListener(new b(this));
    L25:
        this.j = new com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.e();
        ImageView r11 = (ImageView) r6.findViewById(2131376242);
        this.g = r11;
        if (r11 == null) goto L28;
        r11.setOnClickListener(new c(this));
    L28:
        this.h = (ImageView) r6.findViewById(2131376601);
        Lazy r12 = ECSettingKeys.a;
        d();
        if (this.a.size() > 1) goto L34;
        if (r19 != null) goto L32;
        return;
    L32:
        if (r19.b() == true) goto L34;
        return;
    L34:
        this.c = (TabIndicatorScrollView) r6.findViewById(2131375244);
        ViewGroup r2 = (ViewGroup) r6.findViewById(2131390776);
        this.b = r2;
        if (r2 == null) goto L37;
        r2.removeAllViews();
    L37:
        Iterator<T> r13 = this.a.iterator();
        int r14 = 0;
    L39:
        if (r13.hasNext() == false) goto L59;
        Object r15 = r13.next();
        int r16 = r14 + 1;
        if (r14 >= 0) goto L43;
        CollectionsKt.throwIndexOverflow();
    L43:
        c0 r17 = (c0) r15;
        Context r110 = r18.getContext();
        com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.widget.b r111 = new com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.widget.b(r110);
        r111.setPadding(0, com.bytedance.android.shopping.extensions.b.b(8), 0, com.bytedance.android.shopping.extensions.b.b(8));
        r111.setText(r17.c);
        r111.setTextSize(17.0f);
        r111.setTextColor(new ColorStateList(new int[][]{new int[]{R.attr.state_selected}, new int[0]}, new int[]{-1, r110.getResources().getColor(2131105971)}));
        ViewGroup.LayoutParams r112 = r111.getLayoutParams();
        if ((r112 instanceof ViewGroup.MarginLayoutParams) == true) goto L46;
        r112 = null;
    L46:
        ViewGroup.MarginLayoutParams r113 = (ViewGroup.MarginLayoutParams) r112;
        if (r113 != null) goto L49;
        r113 = new ViewGroup.MarginLayoutParams(-2, -2);
    L49:
        if (r14 != 0) goto L51;
        int r20 = 0;
    L52:
        r113.leftMargin = com.bytedance.android.shopping.extensions.b.b(r20);
        Unit r21 = Unit.INSTANCE;
        r111.setLayoutParams(r113);
        ViewGroup.LayoutParams r22 = r111.getLayoutParams();
        if (r22 != null) goto L55;
        r22 = new ViewGroup.LayoutParams(-2, -2);
    L55:
        r22.width = -2;
        r22.height = -2;
        r111.setLayoutParams(r22);
        ViewGroup r23 = this.b;
        if (r23 == null) goto L58;
        r23.addView(r111);
    L58:
        r111.setOnClickListener(new a(r17, this, r18));
        this.n.f(r17.d);
        r14 = r16;
        goto L39
    L51:
        r20 = 20;
        goto L52
    L59:
        return;
    L15:
        ViewGroup.LayoutParams r24 = r6.getLayoutParams();
        if ((r24 instanceof ViewGroup.MarginLayoutParams) == true) goto L18;
        r24 = null;
    L18:
        ViewGroup.MarginLayoutParams r25 = (ViewGroup.MarginLayoutParams) r24;
        if (r25 != null) goto L21;
        r25 = new ViewGroup.MarginLayoutParams(-2, -2);
    L21:
        r25.topMargin = eh.b.b(r18.getContext()) + com.bytedance.android.shopping.extensions.b.b(10);
        Unit r26 = Unit.INSTANCE;
        r6.setLayoutParams(r25);
        goto L22
    L61:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout");
    L63:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout");
    }

    /* JADX WARN: Type inference failed for: r1v3, types: [com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.widget.TabIndicatorV2$bubbleRunnable$1] */
    public o(Function0 r1, Function1 r2, com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.m r3, i0 r4, GalleryFragment r5) {
        Intrinsics.checkNotNullParameter(r1, "onClose");
        Intrinsics.checkNotNullParameter(r2, "trySelectPage");
        Intrinsics.checkNotNullParameter(r3, "eventManager");
        this.l = r1;
        this.m = r2;
        this.n = r3;
        this.o = r5;
        this.a = CollectionsKt.emptyList();
        this.i = true;
        this.k = new TabIndicatorV2$bubbleRunnable$1(this);
    }
}
