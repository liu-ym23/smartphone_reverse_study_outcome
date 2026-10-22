package com.bytedance.android.shopping.new_cart.slice.widgets;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.bytedance.android.ec.core.abtest.ECSettingKeys;
import com.bytedance.android.ecom.arch.slice.render.context.SlcTemplateContext;
import com.bytedance.android.ecom.arch.slice.render.util.SlcDimensExtensionsKt;
import com.bytedance.android.ecom.arch.slice.render.widget.roundcorner.SlcRoundFrameLayout;
import com.bytedance.android.shopping.new_cart.components.CartLoadMoreComponent;
import com.bytedance.android.shopping.new_cart.container.CartObjectContainer;
import com.bytedance.android.shopping.new_cart.container.b0;
import com.bytedance.android.shopping.new_cart.container.t;
import com.bytedance.android.shopping.new_cart.slice.viewmanagers.u;
import com.bytedance.android.shopping.new_cart.viewmodel.CartViewModel;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.google.android.material.tabs.TabLayout;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class CartHeaderTab extends SlcRoundFrameLayout {
    public Map<Integer, View> c;
    public final Set<Pair<String, String>> d;
    public final Lazy e;
    public final Lazy f;
    public final b g;
    public final SlcTemplateContext h;
    public final CartObjectContainer i;
    public final b0 j;

    private final CartLoadMoreComponent getCartLoadMoreComponent() {
        return (CartLoadMoreComponent) this.e.getValue();
    }

    private final CartViewModel getCartViewModel() {
        return (CartViewModel) this.f.getValue();
    }

    public final SlcTemplateContext getSlcTemplateContext() {
        return this.h;
    }

    public static final /* synthetic */ CartLoadMoreComponent c(CartHeaderTab r0) {
        return r0.getCartLoadMoreComponent();
    }

    public static final /* synthetic */ CartViewModel d(CartHeaderTab r0) {
        return r0.getCartViewModel();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final View b(int r3) {
        if (this.c != null) goto L5;
        this.c = new LinkedHashMap();
    L5:
        View r4 = (View) ((LinkedHashMap) this.c).get(2131388030);
        if (r4 != null) goto L12;
        View r5 = findViewById(2131388030);
        if (r5 == null) goto L10;
        this.c.put(2131388030, r5);
        return r5;
    L10:
        return null;
    L12:
        return r4;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean dispatchHoverEvent(MotionEvent r1) {
        return super/*android.widget.FrameLayout*/.dispatchHoverEvent(r1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean dispatchTouchEvent(MotionEvent r3) {
        Intrinsics.checkNotNullParameter(r3, "ev");
        if (r3.getPointerCount() <= 1) goto L5;
        return true;
    L5:
        CartObjectContainer r0 = this.i;
        if (r0 == null) goto L15;
        com.bytedance.android.shopping.new_cart.container.b r1 = r0.e;
        if (r1 == null) goto L15;
        t r2 = r1.l;
        if (r2 == null) goto L15;
        if (r2.a != true) goto L15;
        return true;
    L15:
        return super/*android.widget.FrameLayout*/.dispatchTouchEvent(r3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void e(List<u> r22, final String r23, final String r24) {
        Intrinsics.checkNotNullParameter(r22, "tabList");
        Intrinsics.checkNotNullParameter(r24, "tabColor");
        ArrayList r4 = (ArrayList) r22;
        if (r4.isEmpty() == false) goto L6;
        setVisibility(8);
        return;
    L6:
        int r5 = 0;
        setVisibility(0);
        Iterator<T> r6 = r22.iterator();
    L7:
        Integer r12 = null;
        if (r6.hasNext() == false) goto L15;
        u r7 = (u) r6.next();
        CartViewModel r13 = getCartViewModel();
        if (r13 == null) goto L7;
        Pair[] r8 = new Pair[4];
        r8[0] = TuplesKt.to("tab_name", r7.d());
        r8[1] = TuplesKt.to("btm", "c9319.d988420");
        r8[2] = TuplesKt.to("bcm_description", MapsKt.mapOf(TuplesKt.to("tab", r7.d())));
        com.bytedance.android.shopping.new_cart.slice.viewmanagers.a r9 = r7.a();
        if (r9 == null) goto L14;
        r12 = Integer.valueOf(r9.c());
    L14:
        r8[3] = TuplesKt.to("remind_type", r12);
        r13.doEventAction("cart_list_tab_show", MapsKt.mapOf(r8), "cart_list_tab_show_" + r7.d());
        goto L7
    L15:
        b0 r10 = this.j;
        if (r10 == null) goto L20;
        Function1<String, Unit> r11 = r10.c;
        if (r11 == null) goto L20;
        r11.invoke(r23);
    L20:
        int r14 = 2131388030;
        if (b(2131388030).getTabCount() == r4.size()) goto L23;
    L43:
        b(2131388030).removeOnTabSelectedListener(this.g);
        if (r4.size() <= 2) goto L46;
        b(2131388030).setSelectedTabIndicator(2131235408);
    L47:
        b(2131388030).setSelectedTabIndicatorColor(ColorProtector.parseColor(r24));
        b(2131388030).removeAllTabs();
        Iterator<T> r1 = r22.iterator();
    L49:
        if (r1.hasNext() == false) goto L55;
        final u r15 = (u) r1.next();
        TabLayout r16 = b(r14);
        TabLayout.Tab r17 = b(r14).newTab();
        o r18 = new o(getContext(), this.h, new CartHeaderTab$onBind$$inlined$forEach$lambda$1(r15, this, r24, r23), this.j, this.i);
        r18.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        r18.c(r15, r24);
        if (Intrinsics.areEqual(r15.d(), r23) == false) goto L53;
        r18.d(true, null);
    L54:
        Unit r19 = Unit.INSTANCE;
        r17.setCustomView(r18);
        r16.addTab(r17, Intrinsics.areEqual(r15.d(), r23));
        r14 = 2131388030;
        goto L49
    L53:
        r18.d(false, null);
        goto L54
    L55:
        int r20 = 2131388030;
        b(2131388030).addOnTabSelectedListener(this.g);
    L57:
        if (b(r20).getTabCount() != 4) goto L81;
        List r2 = ECSettingKeys.p().n();
        if (r2 != null) goto L61;
        r2 = CollectionsKt.listOf(new Integer[]{86, 97, 97, 64});
    L61:
        Iterator r3 = r2.iterator();
    L63:
        if (r3.hasNext() == false) goto L81;
        Object r21 = r3.next();
        int r25 = r5 + 1;
        if (r5 >= 0) goto L67;
        CollectionsKt.throwIndexOverflow();
    L67:
        int r26 = ((Number) r21).intValue();
        TabLayout.Tab r27 = b(2131388030).getTabAt(r5);
        if (r27 == null) goto L70;
        TabLayout.TabView r28 = r27.view;
    L72:
        if ((r28 instanceof LinearLayout) == true) goto L74;
        r28 = null;
    L74:
        if (r28 == null) goto L76;
        r28.setLayoutParams(new LinearLayout.LayoutParams(-2, -1));
    L76:
        if (r27 == null) goto L80;
        View r29 = r27.getCustomView();
        if (r29 == null) goto L80;
        r29.setLayoutParams(new LinearLayout.LayoutParams(SlcDimensExtensionsKt.a(Integer.valueOf(r26), this.h.m()), -1));
    L80:
        r5 = r25;
        goto L63
    L70:
        r28 = null;
    L81:
        b(2131388030).requestLayout();
        return;
    L46:
        b(2131388030).setSelectedTabIndicator(2131235495);
        goto L47
    L23:
        if (b(2131388030).getTabCount() == 0) goto L43;
        Iterator<T> r30 = r22.iterator();
        int r31 = 0;
    L27:
        if (r30.hasNext() == false) goto L42;
        Object r32 = r30.next();
        int r33 = r31 + 1;
        if (r31 >= 0) goto L31;
        CollectionsKt.throwIndexOverflow();
    L31:
        u r34 = (u) r32;
        TabLayout.Tab r35 = b(2131388030).getTabAt(r31);
        if (r35 == null) goto L34;
        View r36 = r35.getCustomView();
    L36:
        if ((r36 instanceof o) == true) goto L38;
        r36 = null;
    L38:
        o r37 = (o) r36;
        if (r37 == null) goto L41;
        r37.c(r34, r24);
    L41:
        r31 = r33;
        goto L27
    L34:
        r36 = null;
        goto L36
    L42:
        r20 = 2131388030;
        goto L57
    }

    /* JADX WARN: Multi-variable type inference failed */
    public CartHeaderTab(Context r3, SlcTemplateContext r4, CartObjectContainer r5, b0 r6) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "slcTemplateContext");
        super(r3, null, 0);
        this.h = r4;
        this.i = r5;
        this.j = r6;
        this.c = new LinkedHashMap();
        this.d = new LinkedHashSet();
        this.e = LazyKt.lazy(new CartHeaderTab$cartLoadMoreComponent$2(this));
        this.f = LazyKt.lazy(new CartHeaderTab$cartViewModel$2(this));
        this.g = new b(this);
        LayoutInflater.from(r3).inflate(2131559265, this, true);
    }
}
