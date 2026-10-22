package com.bytedance.android.shopping.card_list.slice.widgets;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.bytedance.android.ecom.arch.slice.render.context.SlcTemplateContext;
import com.bytedance.android.ecom.arch.slice.render.util.SlcDimensExtensionsKt;
import com.bytedance.android.ecom.arch.slice.render.widget.roundcorner.SlcRoundFrameLayout;
import com.bytedance.android.shopping.card_list.common_params.CardListContainerConfig;
import com.bytedance.android.shopping.card_list.components.CardListLoadMoreComponent;
import com.bytedance.android.shopping.card_list.components.CardListSliceCustomWidgetAdapterComponent;
import com.bytedance.android.shopping.card_list.components.CardListTrackerComponent;
import com.bytedance.android.shopping.card_list.components.s;
import com.bytedance.android.shopping.card_list.container.init.CardListObjectContainer;
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
public final class CardListHeaderTab extends SlcRoundFrameLayout {
    public Map<Integer, View> c;
    public final Set<Pair<String, String>> d;
    public final Lazy e;
    public final Lazy f;
    public final Lazy g;
    public final Lazy h;
    public final Lazy i;
    public final c j;
    public final SlcTemplateContext k;

    private final s getActions() {
        return (s) this.g.getValue();
    }

    private final CardListLoadMoreComponent getLoadMoreComponent() {
        return (CardListLoadMoreComponent) this.h.getValue();
    }

    private final CardListObjectContainer getObjectContainer() {
        return (CardListObjectContainer) this.f.getValue();
    }

    private final CardListSliceCustomWidgetAdapterComponent getProvider() {
        return (CardListSliceCustomWidgetAdapterComponent) this.e.getValue();
    }

    private final CardListTrackerComponent getTrackerComponent() {
        return (CardListTrackerComponent) this.i.getValue();
    }

    public final SlcTemplateContext getSlcTemplateContext() {
        return this.k;
    }

    public static final /* synthetic */ CardListLoadMoreComponent c(CardListHeaderTab r0) {
        return r0.getLoadMoreComponent();
    }

    public static final /* synthetic */ CardListObjectContainer d(CardListHeaderTab r0) {
        return r0.getObjectContainer();
    }

    public static final /* synthetic */ CardListSliceCustomWidgetAdapterComponent e(CardListHeaderTab r0) {
        return r0.getProvider();
    }

    public static final /* synthetic */ CardListTrackerComponent f(CardListHeaderTab r0) {
        return r0.getTrackerComponent();
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
    public final boolean dispatchTouchEvent(MotionEvent r3) {
        Intrinsics.checkNotNullParameter(r3, "ev");
        if (r3.getPointerCount() <= 1) goto L5;
        return true;
    L5:
        CardListObjectContainer r0 = getObjectContainer();
        if (r0 == null) goto L15;
        com.bytedance.android.shopping.card_list.common_params.a r1 = r0.e;
        if (r1 == null) goto L15;
        com.bytedance.android.shopping.card_list.container.b r2 = r1.h;
        if (r2 == null) goto L15;
        if (r2.a != true) goto L15;
        return true;
    L15:
        return super/*android.widget.FrameLayout*/.dispatchTouchEvent(r3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public CardListHeaderTab(Context r3, SlcTemplateContext r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "slcTemplateContext");
        super(r3, null, 0);
        this.k = r4;
        this.c = new LinkedHashMap();
        this.d = new LinkedHashSet();
        this.e = LazyKt.lazy(new CardListHeaderTab$provider$2(this));
        this.f = LazyKt.lazy(new CardListHeaderTab$objectContainer$2(this));
        this.g = LazyKt.lazy(new CardListHeaderTab$actions$2(this));
        this.h = LazyKt.lazy(new CardListHeaderTab$loadMoreComponent$2(this));
        this.i = LazyKt.lazy(new CardListHeaderTab$trackerComponent$2(this));
        this.j = new c(this);
        LayoutInflater.from(r3).inflate(2131559258, this, true);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void g(List<com.bytedance.android.shopping.card_list.slice.viewmanagers.i> r23, final String r24, final String r25) {
        Intrinsics.checkNotNullParameter(r23, "tabList");
        Intrinsics.checkNotNullParameter(r25, "tabColor");
        ArrayList r4 = (ArrayList) r23;
        if (r4.isEmpty() == false) goto L6;
        setVisibility(8);
        return;
    L6:
        int r5 = 0;
        setVisibility(0);
        Iterator<T> r6 = r23.iterator();
    L8:
        if (r6.hasNext() == false) goto L30;
        com.bytedance.android.shopping.card_list.slice.viewmanagers.i r7 = (com.bytedance.android.shopping.card_list.slice.viewmanagers.i) r6.next();
        CardListTrackerComponent r13 = getTrackerComponent();
        if (r13 == null) goto L8;
        CardListObjectContainer r14 = getObjectContainer();
        if (r14 == null) goto L16;
        CardListContainerConfig r15 = r14.f;
        if (r15 == null) goto L16;
        String r16 = r15.getStandardShowEventName();
    L17:
        if (r16 != null) goto L19;
        r16 = "";
    L19:
        Pair[] r11 = new Pair[4];
        r11[0] = TuplesKt.to("tab_name", r7.d());
        r11[1] = TuplesKt.to("btm", "c9319.d988420");
        r11[2] = TuplesKt.to("bcm_description", MapsKt.mapOf(TuplesKt.to("tab", r7.d())));
        com.bytedance.android.shopping.card_list.slice.viewmanagers.a r9 = r7.a();
        if (r9 == null) goto L22;
        Integer r10 = Integer.valueOf(r9.c());
    L23:
        r11[3] = TuplesKt.to("remind_type", r10);
        Map<String, ? extends Object> r8 = MapsKt.mapOf(r11);
        StringBuilder r12 = new StringBuilder();
        CardListObjectContainer r17 = getObjectContainer();
        if (r17 == null) goto L28;
        CardListContainerConfig r18 = r17.f;
        if (r18 == null) goto L28;
        String r19 = r18.getStandardShowEventName();
    L29:
        r12.append(r19);
        r12.append('_');
        r12.append(r7.d());
        r13.g(r16, r8, r12.toString());
    L28:
        r19 = null;
        goto L29
    L22:
        r10 = null;
    L16:
        r16 = null;
        goto L17
    L30:
        s r20 = getActions();
        if (r20 == null) goto L36;
        Function1<String, Unit> r21 = r20.c;
        if (r21 == null) goto L36;
        r21.invoke(r24);
    L36:
        if (b(2131388030).getTabCount() == r4.size()) goto L38;
    L58:
        b(2131388030).removeOnTabSelectedListener(this.j);
        if (r4.size() <= 2) goto L61;
        b(2131388030).setSelectedTabIndicator(2131232518);
    L62:
        b(2131388030).setSelectedTabIndicatorColor(ColorProtector.parseColor(r25));
        b(2131388030).removeAllTabs();
        Iterator<T> r1 = r23.iterator();
    L64:
        if (r1.hasNext() == false) goto L70;
        final com.bytedance.android.shopping.card_list.slice.viewmanagers.i r22 = (com.bytedance.android.shopping.card_list.slice.viewmanagers.i) r1.next();
        TabLayout r26 = b(2131388030);
        TabLayout.Tab r110 = b(2131388030).newTab();
        m r111 = new m(getContext(), this.k, new CardListHeaderTab$onBind$$inlined$forEach$lambda$1(r22, this, r25, r24), getActions(), getObjectContainer());
        r111.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        r111.d(r22, r25);
        if (Intrinsics.areEqual(r22.d(), r24) == false) goto L68;
        r111.e(true, null);
    L69:
        Unit r112 = Unit.INSTANCE;
        r110.setCustomView(r111);
        r26.addTab(r110, Intrinsics.areEqual(r22.d(), r24));
        goto L64
    L68:
        r111.e(false, null);
        goto L69
    L70:
        TabLayout.TabView r27 = null;
        b(2131388030).addOnTabSelectedListener(this.j);
    L72:
        if (b(2131388030).getTabCount() != 4) goto L93;
        Iterator r2 = CollectionsKt.listOf(new Integer[]{86, 97, 97, 64}).iterator();
    L75:
        if (r2.hasNext() == false) goto L93;
        Object r3 = r2.next();
        int r28 = r5 + 1;
        if (r5 >= 0) goto L79;
        CollectionsKt.throwIndexOverflow();
    L79:
        int r29 = ((Number) r3).intValue();
        TabLayout.Tab r30 = b(2131388030).getTabAt(r5);
        if (r30 == null) goto L82;
        TabLayout.TabView r31 = r30.view;
    L84:
        if ((r31 instanceof LinearLayout) == true) goto L86;
        r31 = r27;
    L86:
        if (r31 == null) goto L88;
        r31.setLayoutParams(new LinearLayout.LayoutParams(-2, -1));
    L88:
        if (r30 == null) goto L92;
        View r32 = r30.getCustomView();
        if (r32 == null) goto L92;
        r32.setLayoutParams(new LinearLayout.LayoutParams(SlcDimensExtensionsKt.a(Integer.valueOf(r29), this.k.m()), -1));
    L92:
        r5 = r28;
        goto L75
    L82:
        r31 = r27;
    L93:
        b(2131388030).requestLayout();
        return;
    L61:
        b(2131388030).setSelectedTabIndicator(2131232519);
        goto L62
    L38:
        if (b(2131388030).getTabCount() == 0) goto L58;
        Iterator<T> r33 = r23.iterator();
        int r34 = 0;
    L42:
        if (r33.hasNext() == false) goto L57;
        Object r35 = r33.next();
        int r36 = r34 + 1;
        if (r34 >= 0) goto L46;
        CollectionsKt.throwIndexOverflow();
    L46:
        com.bytedance.android.shopping.card_list.slice.viewmanagers.i r37 = (com.bytedance.android.shopping.card_list.slice.viewmanagers.i) r35;
        TabLayout.Tab r38 = b(2131388030).getTabAt(r34);
        if (r38 == null) goto L49;
        View r39 = r38.getCustomView();
    L51:
        if ((r39 instanceof m) == true) goto L53;
        r39 = null;
    L53:
        m r40 = (m) r39;
        if (r40 == null) goto L56;
        r40.d(r37, r25);
    L56:
        r34 = r36;
        goto L42
    L49:
        r39 = null;
        goto L51
    L57:
        r27 = null;
        goto L72
    }
}
