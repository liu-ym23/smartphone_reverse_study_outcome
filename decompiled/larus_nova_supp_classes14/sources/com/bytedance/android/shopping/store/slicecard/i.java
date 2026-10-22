package com.bytedance.android.shopping.store.slicecard;

import com.bytedance.android.ec.core.utils.t0;
import com.bytedance.android.ec.model.ECUrlModel;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class i {
    public static final Map<String, Object> a(String r3) {
        if (r3 == null) goto L24;
        Object r0 = null;
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L12
        int r2 = t0.a;     // Catch: Throwable -> L12
        Object r4 = t0.a.a.fromJson(r3, Map.class);     // Catch: Throwable -> L12
        if ((r4 instanceof Map) == true) goto L7;
        r4 = null;
    L7:
        Map r5 = (Map) r4;     // Catch: Throwable -> L12
        if (r5 != null) goto L10;
        r5 = MapsKt.emptyMap();     // Catch: Throwable -> L12
    L10:
        Object r6 = Result.constructor-impl(r5);     // Catch: Throwable -> L12
    L15:
        if (Result.isFailure-impl(r6) == true) goto L18;
        r0 = r6;
    L18:
        Map r7 = (Map) r0;
        if (r7 != null) goto L21;
        r7 = MapsKt.emptyMap();
    L21:
        Map<String, Object> r8 = MapsKt.mapOf(TuplesKt.to("slice_item_actions", r7));
        if (r8 == null) goto L24;
        return r8;
    L12:
        th = move-exception;
        Result.Companion r9 = Result.Companion;
        r6 = Result.constructor-impl(ResultKt.createFailure(th));
    L24:
        return MapsKt.emptyMap();
    }

    public static final Map<String, Object> b(String r3) {
        if (r3 == null) goto L24;
        Object r0 = null;
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L12
        int r2 = t0.a;     // Catch: Throwable -> L12
        Object r4 = t0.a.a.fromJson(r3, Map.class);     // Catch: Throwable -> L12
        if ((r4 instanceof Map) == true) goto L7;
        r4 = null;
    L7:
        Map r5 = (Map) r4;     // Catch: Throwable -> L12
        if (r5 != null) goto L10;
        r5 = MapsKt.emptyMap();     // Catch: Throwable -> L12
    L10:
        Object r6 = Result.constructor-impl(r5);     // Catch: Throwable -> L12
    L15:
        if (Result.isFailure-impl(r6) == true) goto L18;
        r0 = r6;
    L18:
        Map r7 = (Map) r0;
        if (r7 != null) goto L21;
        r7 = MapsKt.emptyMap();
    L21:
        Map<String, Object> r8 = MapsKt.mapOf(TuplesKt.to("slice_item_extra", r7));
        if (r8 == null) goto L24;
        return r8;
    L12:
        th = move-exception;
        Result.Companion r9 = Result.Companion;
        r6 = Result.constructor-impl(ResultKt.createFailure(th));
    L24:
        return MapsKt.emptyMap();
    }

    public static final Map<String, Object> c(String r3) {
        if (r3 == null) goto L24;
        Object r0 = null;
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L12
        int r2 = t0.a;     // Catch: Throwable -> L12
        Object r4 = t0.a.a.fromJson(r3, Map.class);     // Catch: Throwable -> L12
        if ((r4 instanceof Map) == true) goto L7;
        r4 = null;
    L7:
        Map r5 = (Map) r4;     // Catch: Throwable -> L12
        if (r5 != null) goto L10;
        r5 = MapsKt.emptyMap();     // Catch: Throwable -> L12
    L10:
        Object r6 = Result.constructor-impl(r5);     // Catch: Throwable -> L12
    L15:
        if (Result.isFailure-impl(r6) == true) goto L18;
        r0 = r6;
    L18:
        Map r7 = (Map) r0;
        if (r7 != null) goto L21;
        r7 = MapsKt.emptyMap();
    L21:
        Map<String, Object> r8 = MapsKt.toMutableMap(r7);
        if (r8 == null) goto L24;
        return r8;
    L12:
        th = move-exception;
        Result.Companion r9 = Result.Companion;
        r6 = Result.constructor-impl(ResultKt.createFailure(th));
    L24:
        return new LinkedHashMap();
    }

    public static final ECUrlModel d(Map<String, ? extends Object> r5) {
        String r0 = null;
        if (r5 != null) goto L5;
        return null;
    L5:
        ECUrlModel r1 = new ECUrlModel();
        Object r2 = r5.get("uri");
        if (r2 == null) goto L8;
        String r3 = r2.toString();
    L9:
        r1.setUri(r3);
        Object r4 = r5.get("url_list");
        if ((r4 instanceof List) == true) goto L12;
        r4 = null;
    L12:
        r1.setUrlList((List) r4);
        Object r6 = r5.get("width");
        if ((r6 instanceof Number) == true) goto L15;
        r6 = null;
    L15:
        Number r7 = (Number) r6;
        int r8 = 0;
        if (r7 == null) goto L18;
        int r9 = r7.intValue();
    L19:
        r1.setWidth(r9);
        Object r10 = r5.get("height");
        if ((r10 instanceof Number) == true) goto L22;
        r10 = null;
    L22:
        Number r11 = (Number) r10;
        if (r11 == null) goto L25;
        r8 = r11.intValue();
    L25:
        r1.setHeight(r8);
        Object r12 = r5.get("url_key");
        if (r12 == null) goto L28;
        String r13 = r12.toString();
    L29:
        r1.setUrlKey(r13);
        Object r14 = r5.get("data_size");
        if ((r14 instanceof Number) == true) goto L32;
        r14 = null;
    L32:
        Number r15 = (Number) r14;
        if (r15 == null) goto L35;
        long r16 = r15.longValue();
    L36:
        r1.setSize(r16);
        Object r17 = r5.get("file_hash");
        if (r17 == null) goto L39;
        r0 = r17.toString();
    L39:
        r1.setFileHash(r0);
        return r1;
    L35:
        r16 = 0;
        goto L36
    L28:
        r13 = null;
        goto L29
    L18:
        r9 = 0;
        goto L19
    L8:
        r3 = null;
        goto L9
    }
}
