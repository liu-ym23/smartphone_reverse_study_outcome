package com.bytedance.android.shopping.card_list.components;

import android.widget.FrameLayout;
import androidx.core.widget.NestedScrollView;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.shopping.card_list.abilities.CardMultiUpdateComponent;
import com.bytedance.android.shopping.card_list.container.init.CardListObjectContainer;
import com.bytedance.android.shopping.card_list.monitor.error.CardListRunCatchExtKt;
import com.bytedance.android.shopping.card_list.params.CardPassThroughData;
import com.bytedance.android.shopping.card_list.widgets.nest.CardListLinkedScrollView;
import com.bytedance.kmp.ec.yata.AndroidYaTaInstance;
import com.bytedance.kmp.ec.yata.event.ability.uplink.response.UplinkFailedException;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class CardListPageCallBackComponent extends com.bytedance.android.shopping.card_list.components.b {
    public final AtomicBoolean d;
    public final AtomicBoolean e;
    public final AtomicLong f;
    public com.bytedance.android.shopping.card_list.manager.d g;
    public RecyclerView h;
    public final long i;
    public final String j;
    public final Lazy k;
    public final Function0<Unit> l;
    public final Function0<Unit> m;
    public final Lazy n;
    public final Lazy o;
    public final Lazy p;
    public final Lazy q;
    public final Lazy r;
    public final Lazy s;
    public final Lazy t;
    public final Lazy u;
    public final Lazy v;
    public final CardListObjectContainer w;
    public final FrameLayout x;

    public static final class a<T> implements Observer {
        public final /* synthetic */ CardListPageCallBackComponent a;

        public a(CardListPageCallBackComponent r1) {
            this.a = r1;
        }

        public final void onChanged(Object r4) {
            p r5 = (p) r4;
            CardListPageCallBackComponent r0 = this.a;
            boolean r1 = Intrinsics.areEqual(r5.a, "first_enter");
            String r6 = r5.a;
            r0.getClass();
            Intrinsics.checkNotNullParameter(r6, "scene");
            r0.n(r1, r6, null);
        }
    }

    public static final class b<T> implements Observer {
        public final /* synthetic */ CardListPageCallBackComponent a;

        public b(CardListPageCallBackComponent r1) {
            this.a = r1;
        }

        public final void onChanged(Object r5) {
            o r6 = (o) r5;
            final CardListPageCallBackComponent r0 = this.a;
            String r1 = r6.a;
            com.bytedance.kmp.ec.yata.common.protocol.data.e r2 = r6.b;
            if (r2 == null) goto L5;
            final boolean r3 = com.bytedance.kmp.ec.yata.common.protocol.data.f.d(r2);
        L6:
            final com.bytedance.kmp.ec.yata.common.protocol.data.e r7 = r6.b;
            r0.getClass();
            Intrinsics.checkNotNullParameter(r1, "queryScene");
            r0.o(r1, null);
            com.bytedance.android.shopping.card_list.utils.a.HandlerC0036a r4 = com.bytedance.android.shopping.card_list.utils.a.a;
            com.bytedance.android.shopping.card_list.utils.a.b(new CardListPageCallBackComponent$onQueryEnd$1(r0, r3, r7));
            CardMultiUpdateComponent r8 = (CardMultiUpdateComponent) r0.v.getValue();
            if (r8 == null) goto L10;
            r8.j(r3);
            return;
        L10:
            return;
        L5:
            r3 = false;
            goto L6
        }
    }

    public final CardListBodyComponent i() {
        return (CardListBodyComponent) this.p.getValue();
    }

    public final i j() {
        return (i) this.s.getValue();
    }

    @Override // com.bytedance.android.shopping.card_list.components.b, com.bytedance.android.shopping.card_list.components.a
    public final void onCreate() {
        super.onCreate();
        CardListQueryFetchComponent r0 = (CardListQueryFetchComponent) this.u.getValue();
        if (r0 == null) goto L7;
        MutableLiveData r1 = r0.e;
        if (r1 == null) goto L7;
        r1.observe(this.b, new a(this));
    L7:
        CardListQueryFetchComponent r2 = (CardListQueryFetchComponent) this.u.getValue();
        if (r2 == null) goto L13;
        MutableLiveData r3 = r2.g;
        if (r3 == null) goto L14;
        r3.observe(this.b, new b(this));
        return;
    L14:
        return;
    }

    public static final void g(CardListPageCallBackComponent r2) {
        CardListSliceCustomWidgetAdapterComponent r0 = (CardListSliceCustomWidgetAdapterComponent) r2.n.getValue();
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.g != true) goto L12;
        r2.w.e.l.a(Boolean.FALSE);
        CardListSliceCustomWidgetAdapterComponent r1 = (CardListSliceCustomWidgetAdapterComponent) r2.n.getValue();
        if (r1 == null) goto L9;
        r1.g = false;
    L9:
        ((AndroidYaTaInstance) r2.w.e.c.invoke()).x(null, aa6.a.a.b, null, null);
        return;
    }

    public static final k h(CardListPageCallBackComponent r0) {
        return (k) r0.o.getValue();
    }

    public final void l(aa6.a r8) {
        Intrinsics.checkNotNullParameter(r8, "strategy");
        if (this.w.e.h.a == false) goto L5;
        return;
    L5:
        CardListLoadMoreComponent r1 = (CardListLoadMoreComponent) this.q.getValue();
        if (r1 == null) goto L71;
        Intrinsics.checkNotNullParameter(r8, "strategy");
        if (r1.l.e.h.c == false) goto L71;
        if (Intrinsics.areEqual(r8, aa6.a.a.b) == true) goto L71;
        if (Intrinsics.areEqual(r8, aa6.a.b.b.b) == true) goto L18;
        if (Intrinsics.areEqual(r8, aa6.a.b.a.b) == true) goto L18;
    L49:
        CardListBodyComponent r0 = r1.g();
        if (r0 == null) goto L71;
        CardListLinkedScrollView r2 = r0.d;
        if (r2 == null) goto L54;
        RecyclerView r3 = r2.getYataBody();
    L55:
        if (r3 == null) goto L59;
        RecyclerView.LayoutManager r4 = r3.getLayoutManager();
        if (r4 == null) goto L59;
        int r5 = r4.getItemCount();
    L61:
        if (r5 >= 10) goto L71;
        int r6 = com.bytedance.android.shopping.card_list.utils.f.a;
        if (Intrinsics.areEqual(com.bytedance.android.shopping.card_list.utils.f.a((AndroidYaTaInstance) r1.l.e.c.invoke(), Boolean.FALSE), Boolean.TRUE) == false) goto L71;
        CardListBodyComponent r7 = r1.g();
        if (r7 == null) goto L67;
        r7.m.d.m.setValue(Integer.valueOf(com.bytedance.android.shopping.extensions.b.b(70)));
    L67:
        CardListTrackerComponent r9 = (CardListTrackerComponent) r1.h.getValue();
        if (r9 == null) goto L70;
        CardListTrackerComponent.h(r9, "card_list_load_more_event", MapsKt.mapOf(TuplesKt.to("event_type", "auto_load_more")), 4);
    L70:
        r1.h(false);
    L59:
        r5 = 0;
        goto L61
    L54:
        r3 = null;
    L18:
        if (r1.d == false) goto L49;
        if (r1.k == false) goto L24;
        CardListBodyComponent r10 = r1.g();
        if (r10 == null) goto L24;
        r10.m.d.j.setValue(Unit.INSTANCE);
    L24:
        r1.d = false;
        int r11 = com.bytedance.android.shopping.card_list.utils.f.a;
        AndroidYaTaInstance r12 = (AndroidYaTaInstance) r1.l.e.c.invoke();
        Boolean r13 = Boolean.FALSE;
        Boolean r14 = com.bytedance.android.shopping.card_list.utils.f.a(r12, r13);
        if (r14 == null) goto L49;
        if (r14.booleanValue() == false) goto L38;
        Boolean r15 = r1.j;
        Boolean r16 = Boolean.TRUE;
        if (Intrinsics.areEqual(r15, r16) == true) goto L37;
        r1.k = true;
        CardListBodyComponent r17 = r1.g();
        if (r17 == null) goto L34;
        r17.m.d.m.setValue(Integer.valueOf(com.bytedance.android.shopping.extensions.b.b(70)));
    L34:
        CardListBodyComponent r18 = r1.g();
        if (r18 == null) goto L37;
        r18.m.d.c.f.setValue(Unit.INSTANCE);
    L37:
        r1.j = r16;
        goto L49
    L38:
        r1.k = false;
        if ((!Intrinsics.areEqual(r1.j, r13)) == false) goto L43;
        CardListBodyComponent r19 = r1.g();
        if (r19 == null) goto L43;
        r19.m.d.m.setValue(0);
    L43:
        CardListBodyComponent r20 = r1.g();
        if (r20 != null) goto L46;
    L48:
        r1.j = r13;
        goto L49
    L46:
        if (r20.o.f.getNeedLoadGUL() == false) goto L48;
        r20.m.d.c.c.setValue(Unit.INSTANCE);
    L71:
        CardListBodyComponent r21 = i();
        if (r21 == null) goto L74;
        r21.m.d.h.setValue(Unit.INSTANCE);
    L74:
        CardListBodyComponent r22 = i();
        if (r22 == null) goto L80;
        NestedScrollView r23 = r22.d;
        if (r23 == null) goto L80;
        r23.post(new e(r22));
    L80:
        if (Intrinsics.areEqual(r8, aa6.a.a.b) == false) goto L82;
        return;
    L82:
        o("yata_upscreen", null);
    }

    public CardListPageCallBackComponent(CardListObjectContainer r3, FrameLayout r4) {
        Intrinsics.checkNotNullParameter(r3, "objectContainer");
        super(r3);
        this.w = r3;
        this.x = r4;
        this.d = new AtomicBoolean(false);
        this.e = new AtomicBoolean(false);
        this.f = new AtomicLong(-1);
        this.i = System.currentTimeMillis();
        CardPassThroughData r5 = r3.e.a;
        if (r5 == null) goto L5;
        String r6 = r5.getMonitorId();
    L6:
        this.j = r6;
        this.k = LazyKt.lazy(new CardListPageCallBackComponent$monitorManager$2(this));
        this.l = new CardListPageCallBackComponent$onPopupKeyBoardShow$1(this);
        this.m = new CardListPageCallBackComponent$onPopupKeyBoardHide$1(this);
        this.n = LazyKt.lazy(new CardListPageCallBackComponent$sliceCustomWidgetAdapterComponent$2(this));
        this.o = LazyKt.lazy(new CardListPageCallBackComponent$loadingComponent$2(this));
        this.p = LazyKt.lazy(new CardListPageCallBackComponent$bodyComponent$2(this));
        this.q = LazyKt.lazy(new CardListPageCallBackComponent$loadMoreComponent$2(this));
        this.r = LazyKt.lazy(new CardListPageCallBackComponent$errorComponent$2(this));
        this.s = LazyKt.lazy(new CardListPageCallBackComponent$footerComponent$2(this));
        this.t = LazyKt.lazy(new CardListPageCallBackComponent$headerComponent$2(this));
        this.u = LazyKt.lazy(new CardListPageCallBackComponent$queryFetchComponent$2(this));
        this.v = LazyKt.lazy(new CardListPageCallBackComponent$cardMultiUpdateComponent$2(this));
        return;
    L5:
        r6 = null;
        goto L6
    }

    public final void o(final String r2, final com.bytedance.kmp.ec.yata.common.biz.callback.a r3) {
        Intrinsics.checkNotNullParameter(r2, "callScene");
        com.bytedance.android.shopping.card_list.utils.a.HandlerC0036a r0 = com.bytedance.android.shopping.card_list.utils.a.a;
        com.bytedance.android.shopping.card_list.utils.a.b(new CardListPageCallBackComponent$stopLoadingOnUIThread$1(this, r2, r3));
    }

    public final void k(final com.bytedance.kmp.ec.yata.store.node.c r3, final String r4, final String r5) {
        CardListRunCatchExtKt.a(this.j, r5, new CardListPageCallBackComponent$handlePopUpEventChain$1(this, r3, r4, r5));
    }

    public final void m(boolean r5, UplinkFailedException r6, com.bytedance.kmp.ec.yata.common.biz.callback.a r7) {
        Intrinsics.checkNotNullParameter(r7, "model");
        o("yata_update", r7);
        com.bytedance.android.shopping.card_list.utils.a.HandlerC0036a r0 = com.bytedance.android.shopping.card_list.utils.a.a;
        com.bytedance.android.shopping.card_list.utils.a.b(new CardListPageCallBackComponent$onUpdateEnd$1(this));
        CardListLoadMoreComponent r1 = (CardListLoadMoreComponent) this.q.getValue();
        if (r1 == null) goto L17;
        Intrinsics.checkNotNullParameter(r7, "mode");
        if (r5 == false) goto L15;
        List<String> r3 = r1.m.a;
        if (r3 != null) goto L9;
    L10:
        List<String> r8 = r1.m.a;
        if (r8 == null) goto L15;
        if (r8.isEmpty() != true) goto L15;
    L14:
        boolean r9 = true;
    L16:
        r1.d = r9;
        goto L17
    L9:
        if (CollectionsKt.contains(r3, r7.b) == true) goto L14;
    L15:
        r9 = false;
    L17:
        CardMultiUpdateComponent r10 = (CardMultiUpdateComponent) this.v.getValue();
        if (r10 == null) goto L20;
        r10.k(r5);
    L20:
        if (r5 == true) goto L33;
        List<Integer> r11 = this.w.f.getUplinkCodesNeedReload();
        if (r11 == null) goto L34;
        List<Integer> r12 = r11;
        if (r6 == null) goto L26;
        Integer r13 = Integer.valueOf(r6.getStatusCode());
    L28:
        if (CollectionsKt.contains(r12, r13) != true) goto L35;
        CardListQueryFetchComponent r14 = (CardListQueryFetchComponent) this.u.getValue();
        if (r14 == null) goto L36;
        int r15 = CardListQueryFetchComponent.x;
        r14.i(false, "reload", null);
        return;
    L36:
        return;
    L35:
        return;
    L26:
        r13 = null;
        goto L28
    L34:
        return;
    }

    public final void n(final boolean r2, final String r3, final com.bytedance.kmp.ec.yata.common.biz.callback.a r4) {
        com.bytedance.android.shopping.card_list.utils.a.HandlerC0036a r0 = com.bytedance.android.shopping.card_list.utils.a.a;
        com.bytedance.android.shopping.card_list.utils.a.b(new CardListPageCallBackComponent$startLoadingOnUIThread$1(this, r3, r2, r4));
    }
}
