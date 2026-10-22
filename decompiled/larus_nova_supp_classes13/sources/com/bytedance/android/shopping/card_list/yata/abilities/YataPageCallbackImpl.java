package com.bytedance.android.shopping.card_list.yata.abilities;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.ecom.arch.slice.render.context.SlcRenderContext;
import com.bytedance.android.shopping.card_list.abilities.CardMultiUpdateComponent;
import com.bytedance.android.shopping.card_list.components.CardListBodyComponent;
import com.bytedance.android.shopping.card_list.components.CardListPageCallBackComponent;
import com.bytedance.android.shopping.card_list.components.CardListPageCallBackComponent$onPopUpShow$2;
import com.bytedance.android.shopping.card_list.container.b;
import com.bytedance.android.shopping.card_list.container.init.CardListObjectContainer;
import com.bytedance.android.shopping.card_list.monitor.CardListYataMonitorManager;
import com.bytedance.android.shopping.card_list.monitor.firstScreen.CardListFirstScreenPoint;
import com.bytedance.android.shopping.card_list.monitor.firstScreen.CardListYataFirstScreenDurationMonitor;
import com.bytedance.android.shopping.card_list.params.CardPassThroughData;
import com.bytedance.android.shopping.card_list.params.CartPassThroughData;
import com.bytedance.android.shopping.card_list.utils.CardListExtentionsKt;
import com.bytedance.android.shopping.card_list.utils.g;
import com.bytedance.android.shopping.extensions.k;
import com.bytedance.kmp.ec.yata.AndroidYaTaInstance;
import com.bytedance.kmp.ec.yata.common.biz.callback.c;
import com.bytedance.kmp.ec.yata.common.biz.callback.d;
import com.bytedance.kmp.ec.yata.common.biz.callback.h;
import com.bytedance.kmp.ec.yata.common.biz.callback.i;
import com.bytedance.kmp.ec.yata.common.biz.callback.j;
import com.bytedance.kmp.ec.yata.common.protocol.data.p;
import com.bytedance.kmp.ec.yata.common.protocol.data.q;
import com.bytedance.kmp.ec.yata.event.ability.uplink.response.UplinkFailedException;
import com.bytedance.kmp.ec.yata.event.common.e;
import com.bytedance.kmp.ec.yata.store.core.YataStoreData;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import v96.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class YataPageCallbackImpl implements f.a, c, d, com.bytedance.kmp.ec.yata.common.biz.callback.f {
    public final Lazy a;
    public final Lazy b;
    public final Lazy c;
    public final Lazy d;
    public final HashSet<String> e;
    public final CardListObjectContainer f;

    public static final class a {
    }

    static {
    }

    public final void c(YataStoreData r2) {
        Intrinsics.checkNotNullParameter(r2, "storeData");
    }

    public final CardListPageCallBackComponent n() {
        return (CardListPageCallBackComponent) this.b.getValue();
    }

    public final void a() {
        YataViewHolderCallbackImpl r0 = (YataViewHolderCallbackImpl) this.a.getValue();
        boolean r2 = false;
        if (r0.b.compareAndSet(false, true) == false) goto L48;
        b r1 = r0.d.e.h;
        CardListYataMonitorManager r4 = r0.a();
        if (r4 == null) goto L11;
        CardListYataFirstScreenDurationMonitor r5 = r4.d;
        if (r5 == null) goto L11;
        CardListYataFirstScreenDurationMonitor.b(r5, CardListFirstScreenPoint.RENDER_END);
    L11:
        if (r1.a == false) goto L13;
    L14:
        r2 = true;
    L15:
        CardListYataMonitorManager r3 = r0.a();
        if (r3 == null) goto L20;
        CardListYataFirstScreenDurationMonitor r6 = r3.d;
        if (r6 == null) goto L20;
        r6.a("cache_used", Integer.valueOf(k.q(Boolean.valueOf(r2))));
    L20:
        CardListYataMonitorManager r7 = r0.a();
        if (r7 == null) goto L25;
        CardListYataFirstScreenDurationMonitor r8 = r7.d;
        if (r8 == null) goto L25;
        r8.a("cache_render_end", Long.valueOf(System.currentTimeMillis()));
    L25:
        CardListYataMonitorManager r9 = r0.a();
        if (r9 == null) goto L30;
        CardListYataFirstScreenDurationMonitor r10 = r9.d;
        if (r10 == null) goto L30;
        r10.a("query_used", Integer.valueOf(k.q(Boolean.valueOf(r1.c))));
    L30:
        CardPassThroughData r11 = r0.d.e.a;
        if (r11 == null) goto L41;
        CartPassThroughData r12 = r11.getCartSchemaData();
        if (r12 == null) goto L41;
        String r13 = r12.getNewSourceType();
        if (r13 == null) goto L41;
        CardListYataMonitorManager r14 = r0.a();
        if (r14 == null) goto L41;
        CardListYataFirstScreenDurationMonitor r15 = r14.d;
        if (r15 == null) goto L41;
        r15.a("new_source_type", r13);
    L41:
        CardListYataMonitorManager r16 = r0.a();
        if (r16 == null) goto L46;
        CardListYataFirstScreenDurationMonitor r17 = r16.d;
        if (r17 == null) goto L46;
        CardListYataFirstScreenDurationMonitor.b(r17, CardListFirstScreenPoint.END);
    L46:
        String r18 = com.bytedance.android.shopping.card_list.monitor.a.a;
        ConcurrentHashMap<String, String> r19 = com.bytedance.android.shopping.base.event.a.a;
        com.bytedance.android.shopping.base.event.a.d(com.bytedance.android.shopping.card_list.monitor.a.a, "render", "success", null, false, null, 56);
        return;
    L13:
        if (r1.b == false) goto L15;
    }

    public YataPageCallbackImpl(CardListObjectContainer r2) {
        Intrinsics.checkNotNullParameter(r2, "objectContainer");
        this.f = r2;
        this.a = LazyKt.lazy(new YataPageCallbackImpl$viewHolderCallback$2(this));
        this.b = LazyKt.lazy(new YataPageCallbackImpl$pageCallback$2(this));
        this.c = LazyKt.lazy(new YataPageCallbackImpl$trackerComponent$2(this));
        this.d = LazyKt.lazy(new YataPageCallbackImpl$cardMultiUpdateComponent$2(this));
        this.e = new HashSet();
    }

    public final void b(i r2) {
        Intrinsics.checkNotNullParameter(r2, "requestModel");
        Intrinsics.checkNotNullParameter(r2, "requestModel");
    }

    public final void e(com.bytedance.kmp.ec.yata.common.biz.callback.a r4) {
        Intrinsics.checkNotNullParameter(aa6.a.b.b.b, "source");
        Intrinsics.checkNotNullParameter(r4, "model");
        System.currentTimeMillis();
        CardListPageCallBackComponent r1 = n();
        if (r1 == null) goto L6;
        Intrinsics.checkNotNullParameter(r4, "model");
        r1.n(false, "yata_update", r4);
        return;
    }

    public final void l(com.bytedance.kmp.ec.yata.store.node.c r9) {
        Intrinsics.checkNotNullParameter(r9, "node");
        Map r0 = r9.s();
        if (this.e.contains(r9.getKey()) == false) goto L5;
        return;
    L5:
        Object r1 = g.a(r0, "fetch_recommend");
        if ((r1 instanceof Boolean) == true) goto L9;
        r1 = null;
    L9:
        if (Intrinsics.areEqual((Boolean) r1, Boolean.TRUE) == false) goto L12;
        AndroidYaTaInstance r2 = (AndroidYaTaInstance) this.f.e.c.invoke();
        this.e.add(r9.getKey());
        com.bytedance.kmp.ec.yata.event.common.f r10 = e.a.a(r2, null, r9.getKey(), "asyncFetch", null, "asyncFetch_onComponentExposure");
        r2.k().d(r10);
        return;
    }

    public final void f(YataStoreData r3, Object r4) {
        Intrinsics.checkNotNullParameter(r3, "storeData");
        aa6.a r5 = r3.c;
        CardListPageCallBackComponent r0 = n();
        if (r0 == null) goto L6;
        Result.isSuccess-impl(r4);
        r0.l(r5);
    L6:
        if ((!Intrinsics.areEqual(r5, aa6.a.a.b)) == false) goto L16;
        CardMultiUpdateComponent r6 = (CardMultiUpdateComponent) this.d.getValue();
        if (r6 == null) goto L17;
        com.bytedance.android.shopping.card_list.yata.interceptor.a r7 = r6.d;
        if (r7 == null) goto L18;
        aa6.b r8 = ((AndroidYaTaInstance) this.f.e.c.invoke()).h(2);
        dm.a.a("RollBackImpl").i("saveNewProtocol");
        if (r8 == null) goto L19;
        r7.b.getAndSet(r8);
        return;
    L19:
        return;
    L18:
        return;
    L17:
        return;
    }

    public final void g(com.bytedance.kmp.ec.yata.store.node.c r10, ga6.c r11) {
        Intrinsics.checkNotNullParameter(r10, "root");
        Intrinsics.checkNotNullParameter(r11, "config");
        c.a.e(r10, r11);
        int r2 = ((Number) r11.b("height", -1)).intValue();
        LinearLayout r6 = null;
        if (r2 > 0) goto L5;
    L22:
        CardListPageCallBackComponent r3 = n();
        if (r3 == null) goto L78;
        Intrinsics.checkNotNullParameter(r11, "config");
        p r12 = r10.b.b;
        if (r12 == null) goto L30;
        Object r13 = q.b(r12, Reflection.getOrCreateKotlinClass(Boolean.class), "should_below_footer");
        if ((r13 instanceof Boolean) == true) goto L29;
        r13 = null;
    L29:
        Boolean r14 = (Boolean) r13;
    L32:
        if (Intrinsics.areEqual(r14, Boolean.TRUE) == false) goto L69;
        if (((AndroidYaTaInstance) r3.w.e.c.invoke()).s.b().isEmpty() == false) goto L69;
        com.bytedance.android.shopping.card_list.components.i r15 = r3.j();
        if (r15 == null) goto L40;
        LinearLayout r16 = r15.d;
        if (r16 == null) goto L40;
        ViewParent r17 = r16.getParent();
    L42:
        if ((r17 instanceof ViewGroup) == true) goto L44;
        r17 = null;
    L44:
        ViewGroup r18 = (ViewGroup) r17;
        if (r18 == null) goto L47;
        Integer r0 = Integer.valueOf(r18.indexOfChild(r3.x));
    L48:
        if (r0 == null) goto L61;
        int r4 = r0.intValue();
        if (r0.intValue() == (-1)) goto L61;
        FrameLayout r1 = r3.x;
        if (r1 == null) goto L54;
        ViewParent r5 = r1.getParent();
    L56:
        if ((r5 instanceof ViewGroup) == true) goto L58;
        r5 = null;
    L58:
        ViewGroup r7 = (ViewGroup) r5;
        if (r7 == null) goto L61;
        r7.removeViewAt(r4);
        goto L61
    L54:
        r5 = null;
    L61:
        if (r18 == null) goto L69;
        com.bytedance.android.shopping.card_list.components.i r8 = r3.j();
        if (r8 == null) goto L65;
        r6 = r8.d;
    L65:
        int r9 = r18.indexOfChild(r6);
        if (r9 == (-1)) goto L69;
        r18.addView(r3.x, r9);
        goto L69
    L47:
        r0 = null;
    L40:
        r17 = null;
    L69:
        if (Intrinsics.areEqual(r11.f(), "DISCOUNT_DETAIL") == false) goto L71;
    L72:
        com.bytedance.android.shopping.card_list.components.i r19 = r3.j();
        if (r19 == null) goto L75;
        int r110 = r19.g();
    L76:
        r11.c("bottom_offset", Integer.valueOf(r110));
        return;
    L75:
        r110 = com.bytedance.android.shopping.extensions.b.b(64);
        goto L76
    L71:
        if (Intrinsics.areEqual(r11.f(), "SEARCH_PANEL") == true) goto L72;
        return;
    L30:
        r14 = null;
        goto L32
    L78:
        return;
    L5:
        if ((!Intrinsics.areEqual(r10.getNodeName(), "price_detail_popup")) == false) goto L22;
        CardListPageCallBackComponent r20 = n();
        if (r20 == null) goto L14;
        com.bytedance.android.shopping.card_list.components.i r21 = r20.j();
        if (r21 == null) goto L11;
        Integer r22 = Integer.valueOf(r21.g());
    L12:
        if (r22 == null) goto L14;
        int r23 = r22.intValue();
    L15:
        int r24 = r2 - r23;
        CardPassThroughData r25 = this.f.e.a;
        if (r25 == null) goto L20;
        HashMap<String, String> r26 = r25.getSchemaParams();
        if (r26 == null) goto L20;
        String r27 = r26.get("bottom_offset");
    L21:
        r11.c("height", Integer.valueOf(r24 - k.r(r27, 0)));
    L20:
        r27 = null;
        goto L21
    L11:
        r22 = null;
    L14:
        r23 = com.bytedance.android.shopping.extensions.b.b(64);
        goto L15
    }

    public final void h(i r3, j r4) {
        Intrinsics.checkNotNullParameter(r3, "requestModel");
        Intrinsics.checkNotNullParameter(r4, "result");
        Intrinsics.checkNotNullParameter(r3, "requestModel");
        Intrinsics.checkNotNullParameter(r4, "result");
    }

    public final void d(com.bytedance.kmp.ec.yata.store.node.c r2, ga6.c r3, Map<String, ? extends View> r4) {
        Intrinsics.checkNotNullParameter(r2, "root");
        Intrinsics.checkNotNullParameter(r3, "config");
        Intrinsics.checkNotNullParameter(r4, "containerMap");
        c.a.a(r2, r3, r4);
    }

    public final void i(com.bytedance.kmp.ec.yata.store.node.c r13, ga6.c r14, Map<String, ? extends View> r15) {
        Intrinsics.checkNotNullParameter(r13, "root");
        Intrinsics.checkNotNullParameter(r14, "config");
        Intrinsics.checkNotNullParameter(r15, "containerMap");
        c.a.c(r13, r14, r15);
        final CardListPageCallBackComponent r16 = n();
        if (r16 == null) goto L52;
        Intrinsics.checkNotNullParameter(r13, "root");
        Intrinsics.checkNotNullParameter(r15, "containerMap");
        Map r0 = r13.s();
        String r1 = null;
        if (r0 == null) goto L7;
        Object r2 = r0.get("popup_code");
    L9:
        if (Intrinsics.areEqual(r2, "DISCOUNT_DETAIL") == false) goto L12;
        r16.d.compareAndSet(false, true);
        return;
    L12:
        if (Intrinsics.areEqual(r2, "SEARCH_PANEL") == false) goto L54;
        r16.e.compareAndSet(false, true);
        View r17 = r15.get("body");
        if ((r17 instanceof RecyclerView) == true) goto L16;
        r17 = null;
    L16:
        RecyclerView r18 = (RecyclerView) r17;
        r16.h = r18;
        if (r18 == null) goto L19;
        ViewParent r19 = r18.getParent();
    L21:
        if ((r19 instanceof ViewGroup) == true) goto L23;
        r19 = null;
    L23:
        ViewGroup r6 = (ViewGroup) r19;
        if (r6 == null) goto L40;
        SlcRenderContext r8 = (SlcRenderContext) ((AndroidYaTaInstance) r16.w.e.c.invoke()).I(Reflection.getOrCreateKotlinClass(SlcRenderContext.class));
        com.bytedance.android.shopping.card_list.components.i r3 = r16.j();
        if (r3 == null) goto L28;
        Integer r7 = Integer.valueOf(r3.g());
    L29:
        Function0<Unit> r9 = r16.l;
        Function0<Unit> r10 = r16.m;
        CardPassThroughData r4 = r16.w.e.a;
        if (r4 == null) goto L34;
        HashMap<String, String> r5 = r4.getSchemaParams();
        if (r5 == null) goto L34;
        r1 = r5.get("bottom_offset");
    L34:
        com.bytedance.android.shopping.card_list.manager.d r110 = new com.bytedance.android.shopping.card_list.manager.d(r6, r7, r8, r9, r10, k.r(r1, 0));
        ViewTreeObserver r11 = r110.e.getViewTreeObserver();
        r110.c = r11;
        if (r11 != null) goto L37;
    L39:
        Unit r12 = Unit.INSTANCE;
        r16.g = r110;
        goto L40
    L37:
        if (r11.isAlive() == false) goto L39;
        r11.addOnGlobalLayoutListener(r110.a);
        goto L39
    L28:
        r7 = null;
    L40:
        RecyclerView r111 = r16.h;
        if (r111 == null) goto L43;
        r111.addOnScrollListener(new CardListPageCallBackComponent$onPopUpShow$2(r16));
    L43:
        r16.k(r13, "DidShow", "onSearchPopUpShow");
        CardListBodyComponent r112 = r16.i();
        if (r112 == null) goto L46;
        r112.g(false);
    L46:
        com.bytedance.android.shopping.card_list.components.j r113 = (com.bytedance.android.shopping.card_list.components.j) r16.t.getValue();
        if (r113 == null) goto L55;
        LinearLayout r114 = r113.d;
        if (r114 == null) goto L56;
        com.bytedance.android.ec.core.utils.a.a(r114, false);
        return;
    L56:
        return;
    L55:
        return;
    L19:
        r19 = null;
        goto L21
    L54:
        return;
    L7:
        r2 = null;
        goto L9
    }

    public final void k(com.bytedance.kmp.ec.yata.store.node.c r3, ga6.c r4, Map<String, ? extends View> r5) {
        Intrinsics.checkNotNullParameter(r3, "root");
        Intrinsics.checkNotNullParameter(r4, "config");
        Intrinsics.checkNotNullParameter(r5, "containerMap");
        c.a.d(r3, r4, r5);
        CardListPageCallBackComponent r6 = n();
        if (r6 == null) goto L8;
        Intrinsics.checkNotNullParameter(r3, "root");
        Intrinsics.checkNotNullParameter(r5, "containerMap");
        FrameLayout r7 = r6.x;
        if (r7 == null) goto L9;
        CardListExtentionsKt.h(r7);
        return;
    L9:
        return;
    }

    public final void m(com.bytedance.kmp.ec.yata.store.node.c r6, ga6.c r7, Map<String, ? extends View> r8) {
        Intrinsics.checkNotNullParameter(r6, "root");
        Intrinsics.checkNotNullParameter(r7, "config");
        Intrinsics.checkNotNullParameter(r8, "containerMap");
        c.a.b(r6, r7, r8);
        CardListPageCallBackComponent r9 = n();
        if (r9 == null) goto L62;
        Intrinsics.checkNotNullParameter(r6, "root");
        Intrinsics.checkNotNullParameter(r8, "containerMap");
        Map r10 = r6.s();
        Integer r0 = null;
        if (r10 == null) goto L7;
        Object r11 = r10.get("popup_code");
    L9:
        if (Intrinsics.areEqual(r11, "DISCOUNT_DETAIL") == false) goto L12;
        r9.d.compareAndSet(true, false);
        r9.k(r6, "DidDismiss", "onDiscountDetailPopUpDismiss");
    L22:
        com.bytedance.android.shopping.card_list.components.i r12 = r9.j();
        if (r12 == null) goto L27;
        LinearLayout r13 = r12.d;
        if (r13 == null) goto L27;
        ViewParent r14 = r13.getParent();
    L29:
        if ((r14 instanceof ViewGroup) == true) goto L31;
        r14 = null;
    L31:
        ViewGroup r15 = (ViewGroup) r14;
        if (r15 == null) goto L38;
        com.bytedance.android.shopping.card_list.components.i r16 = r9.j();
        if (r16 == null) goto L36;
        LinearLayout r17 = r16.d;
    L37:
        Integer r18 = Integer.valueOf(r15.indexOfChild(r17));
    L39:
        if (r15 == null) goto L41;
        r0 = Integer.valueOf(r15.indexOfChild(r9.x));
    L41:
        if (r0 == null) goto L52;
        if (r18 == null) goto L52;
        int r19 = r18.intValue();
        int r1 = r0.intValue();
        if (r1 == (-1)) goto L52;
        if (r19 == (-1)) goto L52;
        if (r1 >= r19) goto L52;
        if (r15 == null) goto L49;
        r15.removeView(r9.x);
    L49:
        if (r15 == null) goto L52;
        r15.addView(r9.x, r19);
    L52:
        if (((AndroidYaTaInstance) r9.w.e.c.invoke()).s.b().size() != 1) goto L63;
        CardListBodyComponent r20 = r9.i();
        if (r20 == null) goto L56;
        r20.g(true);
    L56:
        com.bytedance.android.shopping.card_list.components.j r21 = (com.bytedance.android.shopping.card_list.components.j) r9.t.getValue();
        if (r21 == null) goto L64;
        LinearLayout r22 = r21.d;
        if (r22 == null) goto L65;
        com.bytedance.android.ec.core.utils.a.a(r22, true);
        return;
    L65:
        return;
    L64:
        return;
    L63:
        return;
    L36:
        r17 = null;
        goto L37
    L38:
        r18 = null;
    L27:
        r14 = null;
        goto L29
    L12:
        if (Intrinsics.areEqual(r11, "SEARCH_PANEL") == false) goto L22;
        r9.e.compareAndSet(true, false);
        r9.h = null;
        com.bytedance.android.shopping.card_list.manager.d r23 = r9.g;
        if (r23 == null) goto L21;
        ViewTreeObserver r2 = r23.c;
        if (r2 != null) goto L18;
    L20:
        r23.c = null;
        goto L21
    L18:
        if (r2.isAlive() == false) goto L20;
        r2.removeOnGlobalLayoutListener(r23.a);
    L21:
        r9.k(r6, "DidDismiss", "onSearchPopUpDismiss");
        goto L22
    L7:
        r11 = null;
        goto L9
    }

    public final void j(aa6.a r1, Object r2, com.bytedance.kmp.ec.yata.common.biz.callback.a r3, com.bytedance.kmp.ec.yata.common.biz.callback.k r4, h r5, com.bytedance.kmp.ec.yata.event.ability.uplink.b r6) {
        Intrinsics.checkNotNullParameter(r1, "source");
        Intrinsics.checkNotNullParameter(r3, "model");
        Intrinsics.checkNotNullParameter(r5, "responseInfo");
        if (r6.a == true) goto L5;
        return;
    L5:
        CardListPageCallBackComponent r7 = n();
        if (r7 == null) goto L12;
        boolean r8 = Result.isSuccess-impl(r2);
        Throwable r9 = Result.exceptionOrNull-impl(r2);
        if ((r9 instanceof UplinkFailedException) == true) goto L10;
        r9 = null;
    L10:
        r7.m(r8, (UplinkFailedException) r9, r3);
        return;
    }
}
