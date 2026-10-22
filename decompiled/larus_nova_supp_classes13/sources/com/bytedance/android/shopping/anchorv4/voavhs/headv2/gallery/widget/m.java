package com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.widget;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
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
public final class m implements g {
    public static final int n = 0;
    public static final String o = null;
    public List<c0> a;
    public ViewGroup b;
    public View c;
    public com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.l d;
    public ImageView e;
    public boolean f;
    public boolean g;
    public com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.e h;
    public final TabIndicator$bubbleRunnable$1 i;
    public final Function0<Unit> j;
    public final Function1<Integer, Unit> k;
    public final com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.m l;
    public final f m;

    public static final class a {
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ c0 a;
        public final /* synthetic */ m b;
        public final /* synthetic */ ViewGroup c;

        public b(c0 r1, m r2, ViewGroup r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            this.b.l.e(this.a.d);
            this.b.k.invoke(Integer.valueOf(this.a.a));
        }
    }

    public static final class c implements View.OnClickListener {
        public final /* synthetic */ m a;

        public c(m r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r3) {
            m r4 = this.a;
            r4.l.d = true;
            r4.j.invoke();
        }
    }

    public static final class d implements View.OnClickListener {
        public final /* synthetic */ m a;

        public d(m r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            m r3 = this.a;
            com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.e r0 = r3.h;
            if (r0 == null) goto L5;
            r0.a();
        L5:
            f r4 = r3.m;
            if (r4 == null) goto L9;
            r4.k10("top_right_find_same");
            return;
        }
    }

    static {
        n = com.bytedance.android.shopping.extensions.b.a(44);
        o = "top_right_find_same";
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.widget.g
    public final void onDestroy() {
        ImageView r0 = this.e;
        if (r0 == null) goto L6;
        r0.removeCallbacks(this.i);
        return;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.widget.g
    public final boolean a() {
        return this.g;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.widget.g
    public final View b() {
        return this.c;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.widget.g
    public final void onPageSelected(int r13) {
        f r0 = this.m;
        ViewGroup.LayoutParams r1 = null;
        if (r0 == null) goto L5;
        Boolean r2 = Boolean.valueOf(r0.wW(o, Integer.valueOf(r13)));
    L6:
        Iterator<T> r3 = this.a.iterator();
        int r4 = 0;
    L8:
        if (r3.hasNext() == false) goto L54;
        Object r5 = r3.next();
        int r7 = r4 + 1;
        if (r4 >= 0) goto L12;
        CollectionsKt.throwIndexOverflow();
    L12:
        c0 r6 = (c0) r5;
        ViewGroup r8 = this.b;
        if (r8 == null) goto L15;
        View r9 = r8.getChildAt(r4);
    L17:
        if ((r9 instanceof com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.widget.a) == true) goto L19;
        r9 = null;
    L19:
        com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.widget.a r10 = (com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.widget.a) r9;
        if (r10 == null) goto L52;
        int r11 = r6.a;
        if (r11 <= r13) goto L24;
    L26:
        boolean r12 = false;
    L27:
        r10.setSelected(r12);
        if (this.a.size() <= 1) goto L30;
        r10.a = r12;
    L30:
        r10.setText(r6.a(r13));
        if (Intrinsics.areEqual(r2, Boolean.TRUE) == false) goto L42;
        ViewGroup.LayoutParams r14 = r10.getLayoutParams();
        if ((r14 instanceof ViewGroup.MarginLayoutParams) == true) goto L35;
        r14 = null;
    L35:
        ViewGroup.MarginLayoutParams r15 = (ViewGroup.MarginLayoutParams) r14;
        if (r15 != null) goto L38;
        r15 = new ViewGroup.MarginLayoutParams(-2, -2);
    L38:
        if (r4 != 0) goto L40;
        int r16 = 0;
    L41:
        r15.leftMargin = com.bytedance.android.shopping.extensions.b.b(r16);
        Unit r17 = Unit.INSTANCE;
        r10.setLayoutParams(r15);
        goto L52
    L40:
        r16 = 8;
        goto L41
    L42:
        ViewGroup.LayoutParams r18 = r10.getLayoutParams();
        if ((r18 instanceof ViewGroup.MarginLayoutParams) == true) goto L45;
        r18 = null;
    L45:
        ViewGroup.MarginLayoutParams r19 = (ViewGroup.MarginLayoutParams) r18;
        if (r19 != null) goto L48;
        r19 = new ViewGroup.MarginLayoutParams(-2, -2);
    L48:
        if (r4 != 0) goto L50;
        int r20 = 0;
    L51:
        r19.leftMargin = com.bytedance.android.shopping.extensions.b.b(r20);
        Unit r21 = Unit.INSTANCE;
        r10.setLayoutParams(r19);
        goto L52
    L50:
        r20 = 16;
        goto L51
    L24:
        if (r13 >= (r11 + r6.b)) goto L26;
        r12 = true;
    L52:
        r4 = r7;
        goto L8
    L15:
        r9 = null;
        goto L17
    L54:
        if (Intrinsics.areEqual(r2, Boolean.TRUE) == false) goto L76;
        f r110 = this.m;
        if (r110 == null) goto L58;
        r110.Bt(o);
    L58:
        ImageView r111 = this.e;
        if (r111 == null) goto L62;
        r111.setVisibility(0);
    L62:
        if (this.f == false) goto L66;
        this.f = false;
        ImageView r112 = this.e;
        if (r112 == null) goto L66;
        TabIndicator$bubbleRunnable$1 r22 = this.i;
        int r23 = com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.i.a;
        r112.postDelayed(r22, 2000);
    L66:
        ViewGroup r113 = this.b;
        if (r113 == null) goto L100;
        ViewGroup.LayoutParams r24 = r113.getLayoutParams();
        if ((r24 instanceof ViewGroup.MarginLayoutParams) == false) goto L72;
        r1 = r24;
    L72:
        ViewGroup.MarginLayoutParams r25 = (ViewGroup.MarginLayoutParams) r1;
        if (r25 != null) goto L75;
        r25 = new ViewGroup.MarginLayoutParams(-2, -2);
    L75:
        r25.rightMargin = com.bytedance.android.shopping.extensions.b.b(24);
        Unit r26 = Unit.INSTANCE;
        r113.setLayoutParams(r25);
        return;
    L100:
        return;
    L76:
        ImageView r114 = this.e;
        if (r114 == null) goto L79;
        r114.setVisibility(4);
    L79:
        ImageView r115 = this.e;
        if (r115 == null) goto L82;
        r115.removeCallbacks(this.i);
    L82:
        com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.e r116 = this.h;
        if (r116 == null) goto L85;
        r116.a();
    L85:
        ViewGroup r117 = this.b;
        if (r117 == null) goto L102;
        ViewGroup.LayoutParams r27 = r117.getLayoutParams();
        if ((r27 instanceof ViewGroup.MarginLayoutParams) == false) goto L91;
        r1 = r27;
    L91:
        ViewGroup.MarginLayoutParams r28 = (ViewGroup.MarginLayoutParams) r1;
        if (r28 != null) goto L94;
        r28 = new ViewGroup.MarginLayoutParams(-2, -2);
    L94:
        r28.rightMargin = com.bytedance.android.shopping.extensions.b.b(0);
        Unit r29 = Unit.INSTANCE;
        r117.setLayoutParams(r28);
        return;
    L102:
        return;
    L5:
        r2 = null;
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
        View r3 = th.a.c(r18.getContext(), 2131560495, r18, true);
        if (r3 == null) goto L77;
        FrameLayout r4 = (FrameLayout) r3;
        View r5 = r18.findViewById(2131374270);
        if (r5 == null) goto L75;
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
        r8.height = n;
        Unit r9 = Unit.INSTANCE;
        r6.setLayoutParams(r8);
    L22:
        this.c = r6;
        View r10 = r6.findViewById(2131376107);
        if (r10 == null) goto L25;
        r10.setOnClickListener(new c(this));
    L25:
        this.h = new com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.e();
        ImageView r11 = (ImageView) r6.findViewById(2131376242);
        this.e = r11;
        if (r11 == null) goto L28;
        r11.setOnClickListener(new d(this));
    L28:
        Lazy r12 = ECSettingKeys.a;
        ImageView r13 = this.e;
        if (r13 == null) goto L31;
        ViewGroup.LayoutParams r14 = r13.getLayoutParams();
    L33:
        if ((r14 instanceof FrameLayout.LayoutParams) == true) goto L35;
        r14 = null;
    L35:
        FrameLayout.LayoutParams r15 = (FrameLayout.LayoutParams) r14;
        if (r15 == null) goto L38;
        r15.setMarginEnd(com.bytedance.android.shopping.extensions.b.b(16));
    L38:
        if (r15 == null) goto L43;
        ImageView r16 = this.e;
        if (r16 == null) goto L43;
        r16.setLayoutParams(r15);
    L43:
        if (this.a.size() > 1) goto L48;
        if (r19 != null) goto L46;
        return;
    L46:
        if (r19.b() == true) goto L48;
        return;
    L48:
        ViewGroup r2 = (ViewGroup) r6.findViewById(2131390776);
        this.b = r2;
        if (r2 == null) goto L51;
        r2.removeAllViews();
    L51:
        Iterator<T> r17 = this.a.iterator();
        int r20 = 0;
    L53:
        if (r17.hasNext() == false) goto L73;
        Object r21 = r17.next();
        int r110 = r20 + 1;
        if (r20 >= 0) goto L57;
        CollectionsKt.throwIndexOverflow();
    L57:
        c0 r22 = (c0) r21;
        Context r111 = r18.getContext();
        com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.widget.a r112 = new com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.widget.a(r111);
        r112.setPadding(0, com.bytedance.android.shopping.extensions.b.b(8), 0, com.bytedance.android.shopping.extensions.b.b(8));
        r112.setText(r22.c);
        r112.setTextSize(17.0f);
        r112.setTextColor(new ColorStateList(new int[][]{new int[]{R.attr.state_selected}, new int[0]}, new int[]{-1, r111.getResources().getColor(2131105971)}));
        ViewGroup.LayoutParams r23 = r112.getLayoutParams();
        if ((r23 instanceof ViewGroup.MarginLayoutParams) == true) goto L60;
        r23 = null;
    L60:
        ViewGroup.MarginLayoutParams r24 = (ViewGroup.MarginLayoutParams) r23;
        if (r24 != null) goto L63;
        r24 = new ViewGroup.MarginLayoutParams(-2, -2);
    L63:
        if (r20 != 0) goto L65;
        int r25 = 0;
    L66:
        r24.leftMargin = com.bytedance.android.shopping.extensions.b.b(r25);
        Unit r26 = Unit.INSTANCE;
        r112.setLayoutParams(r24);
        ViewGroup.LayoutParams r27 = r112.getLayoutParams();
        if (r27 != null) goto L69;
        r27 = new ViewGroup.LayoutParams(-2, -2);
    L69:
        r27.width = -2;
        r27.height = -2;
        r112.setLayoutParams(r27);
        ViewGroup r28 = this.b;
        if (r28 == null) goto L72;
        r28.addView(r112);
    L72:
        r112.setOnClickListener(new b(r22, this, r18));
        this.l.f(r22.d);
        r20 = r110;
        goto L53
    L65:
        r25 = 16;
        goto L66
    L73:
        return;
    L31:
        r14 = null;
        goto L33
    L15:
        ViewGroup.LayoutParams r29 = r6.getLayoutParams();
        if ((r29 instanceof ViewGroup.MarginLayoutParams) == true) goto L18;
        r29 = null;
    L18:
        ViewGroup.MarginLayoutParams r30 = (ViewGroup.MarginLayoutParams) r29;
        if (r30 != null) goto L21;
        r30 = new ViewGroup.MarginLayoutParams(-2, -2);
    L21:
        r30.topMargin = eh.b.b(r18.getContext()) + com.bytedance.android.shopping.extensions.b.b(10);
        Unit r31 = Unit.INSTANCE;
        r6.setLayoutParams(r30);
        goto L22
    L75:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout");
    L77:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout");
    }

    /* JADX WARN: Type inference failed for: r1v3, types: [com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.widget.TabIndicator$bubbleRunnable$1] */
    public m(Function0 r1, Function1 r2, com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.m r3, i0 r4, GalleryFragment r5) {
        Intrinsics.checkNotNullParameter(r1, "onClose");
        Intrinsics.checkNotNullParameter(r2, "trySelectPage");
        Intrinsics.checkNotNullParameter(r3, "eventManager");
        this.j = r1;
        this.k = r2;
        this.l = r3;
        this.m = r5;
        this.a = CollectionsKt.emptyList();
        this.f = true;
        this.i = new TabIndicator$bubbleRunnable$1(this);
    }
}
