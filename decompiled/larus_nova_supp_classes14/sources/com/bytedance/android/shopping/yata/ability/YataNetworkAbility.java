package com.bytedance.android.shopping.yata.ability;

import com.bytedance.android.ec.core.utils.k0;
import com.bytedance.retrofit2.SsResponse;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.mime.FormUrlEncodedTypedOutput;
import com.bytedance.retrofit2.mime.TypedByteArray;
import com.bytedance.retrofit2.mime.TypedOutput;
import di.q;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import v96.d;
import v96.k;
import v96.l;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class YataNetworkAbility implements d {
    public final Lazy a;
    public final String b;
    public final com.bytedance.android.shopping.yata.ability.a c;

    public static final class a {
    }

    static {
    }

    public static l d(SsResponse r15) {
        List r0 = r15.headers();
        ArrayList r4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r0, 10));
        Iterator r1 = r0.iterator();
    L4:
        if (r1.hasNext() == false) goto L53;
        Header r2 = (Header) r1.next();
        r4.add(new k(r2.getName(), r2.getValue()));
        goto L4
    L53:
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L43
        long r5 = System.currentTimeMillis();     // Catch: Throwable -> L43
        di.d r6 = k0.a(com.bytedance.android.ec.hybrid.list.util.k.d(r15.raw().getExtraInfo()), Long.valueOf(System.currentTimeMillis()));     // Catch: Throwable -> L43
        if (r6 != null) goto L9;
        Map r7 = MapsKt.emptyMap();     // Catch: Throwable -> L43
    L41:
        Object r8 = Result.constructor-impl(r7);     // Catch: Throwable -> L43
    L46:
        if (Result.isFailure-impl(r8) == false) goto L48;
        r8 = null;
    L48:
        Map r9 = (Map) r8;
        if (r9 != null) goto L52;
        r9 = MapsKt.emptyMap();
    L52:
        return new l(r15.raw().getUrl(), r15.raw().getStatus(), r4, (String) r15.body(), r9);
    L9:
        q r10 = r6.b;     // Catch: Throwable -> L43
        di.b r11 = r6.c;     // Catch: Throwable -> L43
        Pair[] r12 = new Pair[14];     // Catch: Throwable -> L43
        r12[0] = TuplesKt.to("net_pre_request_timing_start", r10.g);     // Catch: Throwable -> L43
        r12[1] = TuplesKt.to("net_pre_request_timing_end", r10.a);     // Catch: Throwable -> L43
        Long r13 = r10.a;     // Catch: Throwable -> L43
        long r14 = 0;
        if (r13 == null) goto L12;
        long r16 = r13.longValue();     // Catch: Throwable -> L43
    L13:
        Long r17 = r10.g;     // Catch: Throwable -> L43
        if (r17 == null) goto L16;
        long r18 = r17.longValue();     // Catch: Throwable -> L43
    L17:
        r12[2] = TuplesKt.to("net_pre_request_duration", Long.valueOf(r16 - r18));     // Catch: Throwable -> L43
        r12[3] = TuplesKt.to("net_create_stream_timing_start", r10.b);     // Catch: Throwable -> L43
        r12[4] = TuplesKt.to("net_create_stream_timing_end", r10.c);     // Catch: Throwable -> L43
        Long r19 = r10.c;     // Catch: Throwable -> L43
        if (r19 == null) goto L20;
        long r110 = r19.longValue();     // Catch: Throwable -> L43
    L21:
        Long r20 = r10.b;     // Catch: Throwable -> L43
        if (r20 == null) goto L24;
        long r111 = r20.longValue();     // Catch: Throwable -> L43
    L25:
        r12[5] = TuplesKt.to("net_create_stream_timing_duration", Long.valueOf(r110 - r111));     // Catch: Throwable -> L43
        r12[6] = TuplesKt.to("net_request_response_timing_start", r10.a);     // Catch: Throwable -> L43
        r12[7] = TuplesKt.to("net_request_response_timing_end", r10.f);     // Catch: Throwable -> L43
        Long r21 = r10.f;     // Catch: Throwable -> L43
        if (r21 == null) goto L28;
        long r112 = r21.longValue();     // Catch: Throwable -> L43
    L29:
        Long r22 = r10.a;     // Catch: Throwable -> L43
        if (r22 == null) goto L32;
        long r113 = r22.longValue();     // Catch: Throwable -> L43
    L33:
        r12[8] = TuplesKt.to("net_request_response_timing_duration", Long.valueOf(r112 - r113));     // Catch: Throwable -> L43
        r12[9] = TuplesKt.to("net_after_request_timing_start", r10.f);     // Catch: Throwable -> L43
        r12[10] = TuplesKt.to("net_after_request_timing_end", r10.h);     // Catch: Throwable -> L43
        Long r23 = r10.h;     // Catch: Throwable -> L43
        if (r23 == null) goto L36;
        long r24 = r23.longValue();     // Catch: Throwable -> L43
    L37:
        Long r114 = r10.f;     // Catch: Throwable -> L43
        if (r114 == null) goto L40;
        r14 = r114.longValue();     // Catch: Throwable -> L43
    L40:
        r12[11] = TuplesKt.to("net_after_request_timing_duration", Long.valueOf(r24 - r14));     // Catch: Throwable -> L43
        r12[12] = TuplesKt.to("net_received_bytes", r11.d);     // Catch: Throwable -> L43
        r12[13] = TuplesKt.to("net_sent_bytes", r11.e);     // Catch: Throwable -> L43
        Map r25 = MapsKt.mutableMapOf(r12);     // Catch: Throwable -> L43
        LinkedHashMap r26 = new LinkedHashMap();     // Catch: Throwable -> L43
        r26.put("received_bytes", r11.d);     // Catch: Throwable -> L43
        r26.put("sent_bytes", r11.e);     // Catch: Throwable -> L43
        r26.put("socket_reused", r11.f);     // Catch: Throwable -> L43
        r26.put("net_thread_priority", r11.h);     // Catch: Throwable -> L43
        r26.put("priority_level", r11.j);     // Catch: Throwable -> L43
        r26.put("app_level_request_start", r10.i);     // Catch: Throwable -> L43
        r26.put("before_all_interceptors", r10.j);     // Catch: Throwable -> L43
        r25.put("net_info", r26);     // Catch: Throwable -> L43
        long r27 = System.currentTimeMillis();     // Catch: Throwable -> L43
        r25.put("net_monitor_info_build_start", Long.valueOf(r5));     // Catch: Throwable -> L43
        r25.put("net_monitor_info_build_end", Long.valueOf(r27));     // Catch: Throwable -> L43
        r25.put("net_monitor_info_build_duration", Long.valueOf(r27 - r5));     // Catch: Throwable -> L43
        r7 = r25;
        goto L41
    L36:
        r24 = 0;
        goto L37
    L32:
        r113 = 0;
        goto L33
    L28:
        r112 = 0;
        goto L29
    L24:
        r111 = 0;
        goto L25
    L20:
        r110 = 0;
        goto L21
    L16:
        r18 = 0;
        goto L17
    L12:
        r16 = 0;
    L43:
        th = move-exception;
        Result.Companion r28 = Result.Companion;
        r8 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L46
    }

    public static List e(List r4) {
        List r5 = r4;
        ArrayList r0 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r5, 10));
        Iterator r6 = r5.iterator();
    L4:
        if (r6.hasNext() == false) goto L6;
        k r1 = (k) r6.next();
        r0.add(new Header(r1.a, r1.b));
        goto L4
    L6:
        return r0;
    }

    public YataNetworkAbility(String r2, com.bytedance.android.shopping.yata.ability.a r3) {
        Intrinsics.checkNotNullParameter(r2, "host");
        this.b = r2;
        this.c = r3;
        this.a = LazyKt.lazy(new YataNetworkAbility$api$2(this));
    }

    public final l a(String r3, Map<String, ? extends Object> r4, List<k> r5) {
        Intrinsics.checkNotNullParameter(r3, "url");
        Intrinsics.checkNotNullParameter(r5, "headers");
        IYataNetworkAbilityApi r0 = (IYataNetworkAbilityApi) this.a.getValue();
        List<Header> r6 = e(r5);
        if (r4 != null) goto L5;
        r4 = MapsKt.emptyMap();
    L5:
        SsResponse<String> r7 = r0.get(r3, r6, r4, Integer.MAX_VALUE).execute();
        l r8 = d(r7);
        com.bytedance.android.shopping.yata.ability.a r1 = this.c;
        if (r1 == null) goto L8;
        r1.a(r3, r7);
    L8:
        return r8;
    }

    public final l b(String r4, String r5, List r6) {
        Intrinsics.checkNotNullParameter(r4, "url");
        Intrinsics.checkNotNullParameter(r5, "bodyJSONStr");
        Intrinsics.checkNotNullParameter(r6, "headers");
        TypedOutput r0 = new TypedByteArray("application/json; charset=UTF-8", r5.getBytes(Charsets.UTF_8), new String[0]);
        SsResponse<String> r7 = ((IYataNetworkAbilityApi) this.a.getValue()).postTypedByteOutput(r4, e(r6), r0, Integer.MAX_VALUE).execute();
        l r8 = d(r7);
        com.bytedance.android.shopping.yata.ability.a r1 = this.c;
        if (r1 == null) goto L5;
        r1.a(r4, r7);
    L5:
        return r8;
    }

    public final l c(String r5, Map<String, ? extends Object> r6, List<k> r7) {
        Intrinsics.checkNotNullParameter(r5, "url");
        Intrinsics.checkNotNullParameter(r7, "headers");
        TypedOutput r0 = new FormUrlEncodedTypedOutput();
        if (r6 == null) goto L21;
        Iterator<Map.Entry<String, ? extends Object>> r8 = r6.entrySet().iterator();
    L6:
        if (r8.hasNext() == false) goto L21;
        Map.Entry<String, ? extends Object> r1 = r8.next();
        Object r2 = r1.getValue();
        if ((r2 instanceof String) == true) goto L10;
        r2 = null;
    L10:
        String r3 = (String) r2;
        if (r3 != null) goto L12;
        Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L18
        if (r1.getValue() == null) goto L16;
        r0.addField(r1.getKey(), String.valueOf(r1.getValue()));     // Catch: Throwable -> L18
    L16:
        Object r9 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L18
    L20:
        Result.box-impl(r9);
    L18:
        th = move-exception;
        Result.Companion r10 = Result.Companion;
        r9 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L20
    L12:
        r0.addField(r1.getKey(), r3);
    L21:
        SsResponse<String> r11 = ((IYataNetworkAbilityApi) this.a.getValue()).postTypedByteOutput(r5, e(r7), r0, Integer.MAX_VALUE).execute();
        l r12 = d(r11);
        com.bytedance.android.shopping.yata.ability.a r13 = this.c;
        if (r13 == null) goto L24;
        r13.a(r5, r11);
    L24:
        return r12;
    }
}
