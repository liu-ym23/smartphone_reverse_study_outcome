package com.bytedance.android.shopping.buynow.controller;

import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.core.utils.t0;
import com.bytedance.android.ec.core.utils.z1;
import com.bytedance.android.ec.model.order.IOrderSchema;
import com.bytedance.android.shopping.searchsimilar.model.SimilarProductParam;
import com.bytedance.android.shopping.sku.inner.repo.model.SkuPassThroughItem;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class s {
    public static final Set<String> c = null;
    public static final a d = null;
    public Map<String, ? extends Object> a;
    public String b;

    public static final class a {
        public a() {
        }

        @JvmStatic
        public static void a(Map r11, Map r12, Map r13) {
            Intrinsics.checkNotNullParameter(r11, "result");
            Intrinsics.checkNotNullParameter(r12, "dst");
            Intrinsics.checkNotNullParameter(r13, "src");
            Iterator r14 = r13.entrySet().iterator();
        L4:
            if (r14.hasNext() == false) goto L69;
            Map.Entry r0 = (Map.Entry) r14.next();
            Object r1 = r12.get(r0.getKey());
            if (r1 != null) goto L7;
            r11.put(r0.getKey(), r0.getValue());
            goto L4
        L7:
            Object r3 = null;
            if ((r1 instanceof Map) == true) goto L10;
            Object r2 = null;
        L12:
            if (((Map) r2) != null) goto L13;
            if ((r1 instanceof List) == true) goto L28;
            Object r4 = null;
        L30:
            if (((List) r4) != null) goto L31;
            r11.put(r0.getKey(), r0.getValue());
            goto L4
        L31:
            List r5 = CollectionsKt.toMutableList((Collection) r1);
            Object r6 = r0.getValue();
            if ((r6 instanceof List) == true) goto L35;
            r6 = null;
        L35:
            if (((List) r6) != null) goto L36;
            r11.put(r0.getKey(), r0.getValue());
            goto L4
        L36:
            Object r7 = r0.getValue();
            if (r7 == null) goto L65;
            Iterator r8 = ((List) r7).iterator();
            int r9 = 0;
        L40:
            if (r8.hasNext() == false) goto L63;
            Object r10 = r8.next();
            int r15 = r9 + 1;
            if (r9 >= 0) goto L44;
            CollectionsKt.throwIndexOverflow();
        L44:
            List r16 = (List) r1;
            if (r16.size() > r9) goto L47;
            r5.add(r10);
        L62:
            r9 = r15;
            goto L40
        L47:
            if ((r10 instanceof Map) == true) goto L49;
            Object r17 = null;
        L51:
            if (((Map) r17) == null) goto L60;
            Object r18 = ListProtector.get(r16, r9);
            if ((r18 instanceof Map) == true) goto L55;
            Object r19 = null;
        L57:
            if (((Map) r19) == null) goto L59;
            Map r20 = (Map) r18;
            Map r21 = MapsKt.toMutableMap(r20);
            s.d.getClass();
            a(r21, r20, (Map) r10);
            ListProtector.set(r5, r9, r21);
            goto L62
        L59:
            ListProtector.set(r5, r9, r10);
            goto L62
        L55:
            r19 = r18;
            goto L57
        L60:
            ListProtector.set(r5, r9, r10);
            goto L62
        L49:
            r17 = r10;
            goto L51
        L63:
            r11.put(r0.getKey(), r5);
            goto L4
        L65:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
        L28:
            r4 = r1;
            goto L30
        L13:
            Object r22 = r0.getValue();
            if ((r22 instanceof Map) == false) goto L18;
            r3 = r22;
        L18:
            if (((Map) r3) != null) goto L19;
            r11.put(r0.getKey(), r0.getValue());
            goto L4
        L19:
            Map r23 = (Map) r1;
            Map r24 = MapsKt.toMutableMap(r23);
            a r25 = s.d;
            Object r26 = r0.getValue();
            if (r26 == null) goto L23;
            r25.getClass();
            a(r24, r23, (Map) r26);
            r11.put(r0.getKey(), r24);
            goto L4
        L23:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.Any?>");
        L10:
            r2 = r1;
            goto L12
        }
    }

    public s() {
    }

    static {
        d = new a();
        c = SetsKt.setOf(new String[]{"carrier_source", "channel_token", "creative_id", "ecom_scene_id", SimilarProductParam.ENTER_FROM, "is_package_sale", "market_channel_hot_fix", "previous_page", "scene", "verify_info"});
    }

    public static Map c(SkuPassThroughItem r2) {
        if (r2 == null) goto L5;
        Map<String, String> r1 = r2.getRawMap();
    L6:
        if (r1 == null) goto L12;
        if (r2 == null) goto L11;
        Map<String, String> r3 = r2.getRawMap();
        if (r3 == null) goto L11;
        Map<String, Object> r4 = MapsKt.toMutableMap(r3);
    L16:
        if (r4 == null) goto L18;
        r4.put("entrance_info", null);
    L18:
        return r4;
    L11:
        r4 = null;
        goto L16
    L12:
        if (r2 == null) goto L14;
        String r5 = r2.getData();
    L15:
        r4 = com.bytedance.android.shopping.extensions.k.z(r5);
        goto L16
    L14:
        r5 = null;
        goto L15
    L5:
        r1 = null;
        goto L6
    }

    public final void a(IOrderSchema r2) {
        Intrinsics.checkNotNullParameter(r2, "orderSchema");
        String r0 = r2.getQueryParam("pass_through");
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L15;
        JSONObject r3 = r2.u0();
        if (r3 == null) goto L13;
        Map<String, ? extends Object> r4 = z1.k(r3);
    L14:
        this.a = r4;
        r2.h0();
        return;
    L13:
        r4 = null;
        goto L14
    L15:
        b(r2);
        return;
    L5:
        if (r0.length() == 0) goto L8;
        r1 = false;
        goto L9
    }

    public final void b(nl.c r12) {
        Intrinsics.checkNotNullParameter(r12, "schemaQuery");
        String r1 = r12.getQueryParam("pass_through");
        int r3 = t0.a;     // Catch: Exception -> L5
        List r2 = (List) t0.a.a.fromJson(r1, new t().getType());     // Catch: Exception -> L5
    L7:
        if (r2 != null) goto L9;
        return;
    L9:
        ArrayList r4 = new ArrayList();
        Iterator r5 = r2.iterator();
        SkuPassThroughItem r6 = null;
    L11:
        if (r5.hasNext() == false) goto L43;
        SkuPassThroughItem r7 = (SkuPassThroughItem) r5.next();
        List<String> r8 = r7.getTo();
        if (r8 == null) goto L11;
        Iterator<T> r9 = r8.iterator();
    L16:
        if (r9.hasNext() == false) goto L11;
        String r10 = (String) r9.next();
        switch(r10.hashCode()) {
            case -2098840255: goto L40;
            case -1793220942: goto L33;
            case -613803836: goto L30;
            case 54623351: goto L27;
            case 1278258638: goto L24;
            case 1953935791: goto L21;
            default: goto L42;
        };
    L24:
        if (r10.equals("track.client") == false) goto L42;
        r6 = new SkuPassThroughItem(CollectionsKt.listOf("track.client"), r7.getData(), r7.getRawMap());
        goto L16
    L27:
        if (r10.equals("track.client.entrance_info") == false) goto L42;
    L30:
        if (r10.equals("url.order.log_data") == false) goto L42;
    L33:
        if (r10.equals("api.sku.entrance_info") == false) goto L42;
        List r11 = CollectionsKt.listOf("api.sku.entrance_info");
        String r13 = r7.getData();
        if (r13 == null) goto L37;
        String r14 = com.bytedance.android.shopping.sku.inner.repo.composer.a.a(r13);
    L38:
        r4.add(new SkuPassThroughItem(r11, r14, r7.getRawMap()));
        goto L16
    L37:
        r14 = null;
        goto L38
    L40:
        if (r10.equals("track.add_cart") == true) goto L16;
    L42:
        r4.add(r7);
        goto L16
    L21:
        if (r10.equals("api.add.extra") == false) goto L42;
    L43:
        this.a = c(r6);
        r12.replaceOrAppendParam("pass_through", com.bytedance.android.ec.hybrid.list.util.k.d(r4));
        return;
    L5:
        e = move-exception;
        ECExceptionMonitor.e(e);
        r2 = null;
        goto L7
    }
}
