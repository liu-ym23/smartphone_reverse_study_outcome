package com.bytedance.android.shopping.orderlist.common.controller;

import android.content.Context;
import com.bytedance.android.ecom.arch.slice.render.SliceRender;
import com.bytedance.android.ecom.arch.slice.render.elements.ElementTypes;
import com.bytedance.android.ecom.slice.ext.template.gecko.SlcGeckoTemplateMgr;
import com.bytedance.android.ecom.slice.ext.template.gecko.SlcTemplateFetchType;
import com.bytedance.android.ecom.slice.ext.template.gecko.loader.SlcGeckoTemplateCache;
import com.bytedance.android.shopping.orderlist.common.utils.OrderCommonLog;
import com.bytedance.android.shopping.orderlist.list.container.OrderListFragment;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class OrderCommonTemplateManager {
    public static final AtomicBoolean a = null;
    public static WeakReference<OrderListFragment> b;
    public static final Function0<OrderListFragment> c = null;
    public static final Lazy d = null;

    static {
        a = new AtomicBoolean(false);
        c = OrderCommonTemplateManager$currentFragmentProvider$1.INSTANCE;
        d = LazyKt.lazy(OrderCommonTemplateManager$preloadInfo$2.INSTANCE);
    }

    public static void a() {
        if (a.compareAndSet(false, true) == true) goto L6;
        Lazy r0 = OrderCommonLog.a;
        OrderCommonLog.c("OrderCommonTemplateManager", OrderCommonTemplateManager$injectCustomWidget$1.INSTANCE);
        return;
    L6:
        Lazy r1 = OrderCommonLog.a;
        OrderCommonLog.c("OrderCommonTemplateManager", OrderCommonTemplateManager$injectCustomWidget$2.INSTANCE);
        SliceRender r2 = SliceRender.o;
        OrderCommonTemplateManager$injectCustomWidget$3 r3 = OrderCommonTemplateManager$injectCustomWidget$3.INSTANCE;
        r2.getClass();
        ElementTypes.b("ECOrderTabContainer", r3);
        ElementTypes.b("ECOrderOftenBuyList", OrderCommonTemplateManager$injectCustomWidget$4.INSTANCE);
        ElementTypes.b("ECOrderBanner", OrderCommonTemplateManager$injectCustomWidget$5.INSTANCE);
    }

    public static void b(String r4, Context r5) {
        Intrinsics.checkNotNullParameter(r4, "biz");
        Intrinsics.checkNotNullParameter(r5, "context");
        List r0 = ((com.bytedance.android.ecom.slice.ext.template.gecko.g) d.getValue()).c();
        if (r0 == null) goto L8;
        Iterator r1 = r0.iterator();
    L6:
        if (r1.hasNext() == false) goto L9;
        final com.bytedance.android.ecom.slice.ext.template.gecko.j r2 = (com.bytedance.android.ecom.slice.ext.template.gecko.j) r1.next();
        Lazy r3 = OrderCommonLog.a;
        OrderCommonLog.c("OrderCommonTemplateManager", new OrderCommonTemplateManager$preload$1$1(r2));
    L9:
        SlcGeckoTemplateMgr.f(SlcGeckoTemplateMgr.l, r4, "ecommerce_order_list_component", wh.a.b(r5), OrderCommonTemplateManager$preload$3.INSTANCE);
        boolean r6 = true;
        List r7 = CollectionsKt.listOf(new SlcTemplateFetchType[]{SlcTemplateFetchType.Gecko, SlcTemplateFetchType.CDN, SlcTemplateFetchType.Builtin});
        Map r8 = MapsKt.emptyMap();
        if ((!StringsKt.isBlank("ecommerce_order_list_component")) == false) goto L28;
        List r9 = r7;
        if (r9 != null) goto L14;
    L17:
        boolean r10 = true;
    L18:
        if (r10 == false) goto L25;
        if (r8 != null) goto L21;
    L24:
        if (r6 == false) goto L25;
        return;
    L21:
        if (r8.isEmpty() == true) goto L24;
        r6 = false;
    L25:
        SlcGeckoTemplateCache.i.getClass();
        Lazy r11 = SlcGeckoTemplateCache.h;
        KProperty r12 = SlcGeckoTemplateCache.a.a[0];
        ((ConcurrentHashMap) r11.getValue()).put("ecommerce_order_list_component", new com.bytedance.android.ecom.slice.ext.template.gecko.d(r7, r8));
        return;
    L14:
        if (r9.isEmpty() == true) goto L17;
        r10 = false;
        goto L18
    L28:
        return;
    L8:
        Lazy r13 = OrderCommonLog.a;
        OrderCommonLog.c("OrderCommonTemplateManager", OrderCommonTemplateManager$preload$2$1.INSTANCE);
        goto L9
    }
}
