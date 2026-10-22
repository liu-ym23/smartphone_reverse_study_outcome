package com.bytedance.android.shopping.store.shopfeed.list;

import com.bytedance.android.ec.core.utils.t0;
import com.google.gson.Gson;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class c extends com.bytedance.android.shopping.store.shopfeed.list.a {
    public static final /* synthetic */ int h = 0;
    public Map<String, Object> b;
    public Map<String, Object> c;
    public Map<String, Object> d;
    public Map<String, Object> e;
    public String f;
    public int g;

    public static final class a {
        public static c a(ShopFeedItemCard r4, String r5) {
            Intrinsics.checkNotNullParameter(r4, "shopFlowShopCard");
            Intrinsics.checkNotNullParameter(r5, "passThroughParams");
            c r0 = new c(r4, r5);
            String r6 = null;
            Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L15
            int r2 = t0.a;     // Catch: Throwable -> L15
            Gson r3 = t0.a.a;     // Catch: Throwable -> L15
            Map<String, String> r7 = r4.getExtra();     // Catch: Throwable -> L15
            if (r7 == null) goto L6;
            String r8 = r7.get("slice_item_extra");     // Catch: Throwable -> L15
        L7:
            Object r9 = r3.fromJson(r8, Map.class);     // Catch: Throwable -> L15
            if (TypeIntrinsics.isMutableMap(r9) == true) goto L10;
            r9 = null;
        L10:
            Object r10 = (Map) r9;     // Catch: Throwable -> L15
            if (r10 != null) goto L13;
            r10 = new LinkedHashMap();     // Catch: Throwable -> L15
        L13:
            Object r11 = Result.constructor-impl(r10);     // Catch: Throwable -> L15
        L18:
            if (Result.isFailure-impl(r11) == false) goto L20;
            r11 = null;
        L20:
            r0.c = (Map) r11;
            int r12 = t0.a;     // Catch: Throwable -> L33
            Gson r13 = t0.a.a;     // Catch: Throwable -> L33
            Map<String, String> r14 = r4.getExtra();     // Catch: Throwable -> L33
            if (r14 == null) goto L24;
            String r15 = r14.get("slice_item_actions");     // Catch: Throwable -> L33
        L25:
            Object r16 = r13.fromJson(r15, Map.class);     // Catch: Throwable -> L33
            if (TypeIntrinsics.isMutableMap(r16) == true) goto L28;
            r16 = null;
        L28:
            Object r17 = (Map) r16;     // Catch: Throwable -> L33
            if (r17 != null) goto L31;
            r17 = new LinkedHashMap();     // Catch: Throwable -> L33
        L31:
            Object r18 = Result.constructor-impl(r17);     // Catch: Throwable -> L33
        L36:
            if (Result.isFailure-impl(r18) == false) goto L38;
            r18 = null;
        L38:
            r0.d = (Map) r18;
            int r19 = t0.a;     // Catch: Throwable -> L51
            Gson r20 = t0.a.a;     // Catch: Throwable -> L51
            Map<String, String> r21 = r4.getExtra();     // Catch: Throwable -> L51
            if (r21 == null) goto L42;
            String r22 = r21.get("slice_item_states");     // Catch: Throwable -> L51
        L43:
            Object r23 = r20.fromJson(r22, Map.class);     // Catch: Throwable -> L51
            if (TypeIntrinsics.isMutableMap(r23) == true) goto L46;
            r23 = null;
        L46:
            Object r24 = (Map) r23;     // Catch: Throwable -> L51
            if (r24 != null) goto L49;
            r24 = new LinkedHashMap();     // Catch: Throwable -> L51
        L49:
            Object r25 = Result.constructor-impl(r24);     // Catch: Throwable -> L51
        L54:
            if (Result.isFailure-impl(r25) == false) goto L56;
            r25 = null;
        L56:
            r0.e = (Map) r25;
            int r26 = t0.a;     // Catch: Throwable -> L65
            Object r27 = t0.a.a.fromJson(r4.getSliceCardData(), Map.class);     // Catch: Throwable -> L65
            if (TypeIntrinsics.isMutableMap(r27) == true) goto L60;
            r27 = null;
        L60:
            Object r28 = (Map) r27;     // Catch: Throwable -> L65
            if (r28 != null) goto L63;
            r28 = new LinkedHashMap();     // Catch: Throwable -> L65
        L63:
            Object r29 = Result.constructor-impl(r28);     // Catch: Throwable -> L65
        L68:
            if (Result.isFailure-impl(r29) == false) goto L70;
            r29 = null;
        L70:
            r0.b = (Map) r29;
            Map<String, String> r30 = r4.getExtra();
            if (r30 == null) goto L73;
            String r31 = r30.get("slice_item_type");
        L75:
            if ((r31 instanceof String) == false) goto L78;
            r6 = r31;
        L78:
            r0.f = r6;
            return r0;
        L73:
            r31 = null;
        L65:
            th = move-exception;
            Result.Companion r32 = Result.Companion;
            r29 = Result.constructor-impl(ResultKt.createFailure(th));
            goto L68
        L42:
            r22 = null;
        L51:
            th = move-exception;
            Result.Companion r33 = Result.Companion;
            r25 = Result.constructor-impl(ResultKt.createFailure(th));
            goto L54
        L24:
            r15 = null;
        L33:
            th = move-exception;
            Result.Companion r34 = Result.Companion;
            r18 = Result.constructor-impl(ResultKt.createFailure(th));
            goto L36
        L6:
            r8 = null;
        L15:
            th = move-exception;
            Result.Companion r35 = Result.Companion;
            r11 = Result.constructor-impl(ResultKt.createFailure(th));
            goto L18
        }
    }

    static {
    }

    public final Map<String, Object> b() {
        LinkedHashMap r0 = new LinkedHashMap();
        LinkedHashMap r1 = new LinkedHashMap();
        Map<String, Object> r2 = this.b;
        if (r2 == null) goto L5;
        r1.putAll(r2);
    L5:
        Map<String, Object> r3 = this.c;
        Map r4 = null;
        if (r3 == null) goto L8;
        Map r5 = MapsKt.toMutableMap(r3);
    L9:
        r1.put("slice_item_extra", r5);
        Map<String, Object> r6 = this.e;
        if (r6 == null) goto L12;
        Map r7 = MapsKt.toMutableMap(r6);
    L13:
        r1.put("slice_item_states", r7);
        Map<String, Object> r8 = this.d;
        if (r8 == null) goto L16;
        r4 = MapsKt.toMutableMap(r8);
    L16:
        r1.put("slice_item_actions", r4);
        Unit r9 = Unit.INSTANCE;
        r0.put("data", r1);
        return r0;
    L12:
        r7 = null;
        goto L13
    L8:
        r5 = null;
        goto L9
    }

    public final int modelType() {
        return ShopFeedItemType.SLICE_CARD.getTypeValue();
    }

    public c(ShopFeedItemCard r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "shopFlowShopCard");
        Intrinsics.checkNotNullParameter(r3, "passThroughParams");
        super(ShopFeedItemType.SLICE_CARD);
        this.b = new LinkedHashMap();
        this.c = new LinkedHashMap();
        this.d = new LinkedHashMap();
        this.e = new LinkedHashMap();
    }
}
