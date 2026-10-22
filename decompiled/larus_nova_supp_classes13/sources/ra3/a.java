package ra3;

import di.d;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class a {
    static {
    }

    public static Map a(d r5) {
        if (r5 != null) goto L5;
        return null;
    L5:
        LinkedHashMap r0 = new LinkedHashMap();
        String r1 = com.bytedance.android.ecom.arch.slice.render.util.b.r(r5.a.a);
        String r2 = "";
        if (r1 != null) goto L8;
        r1 = "";
    L8:
        r0.put("before_stream", r1);
        String r3 = com.bytedance.android.ecom.arch.slice.render.util.b.r(r5.a.b);
        if (r3 != null) goto L11;
        r3 = "";
    L11:
        r0.put("body_recv", r3);
        String r4 = com.bytedance.android.ecom.arch.slice.render.util.b.r(r5.a.c);
        if (r4 != null) goto L14;
        r4 = "";
    L14:
        r0.put("connect_delay", r4);
        String r6 = com.bytedance.android.ecom.arch.slice.render.util.b.r(r5.a.d);
        if (r6 != null) goto L17;
        r6 = "";
    L17:
        r0.put("create_stream", r6);
        String r7 = com.bytedance.android.ecom.arch.slice.render.util.b.r(r5.a.e);
        if (r7 != null) goto L20;
        r7 = "";
    L20:
        r0.put("dispatch", r7);
        String r8 = com.bytedance.android.ecom.arch.slice.render.util.b.r(r5.a.f);
        if (r8 != null) goto L23;
        r8 = "";
    L23:
        r0.put("dns", r8);
        String r9 = com.bytedance.android.ecom.arch.slice.render.util.b.r(r5.a.g);
        if (r9 != null) goto L26;
        r9 = "";
    L26:
        r0.put("edge", r9);
        String r10 = com.bytedance.android.ecom.arch.slice.render.util.b.r(r5.a.h);
        if (r10 != null) goto L29;
        r10 = "";
    L29:
        r0.put("header_recv", r10);
        String r11 = com.bytedance.android.ecom.arch.slice.render.util.b.r(r5.a.i);
        if (r11 != null) goto L32;
        r11 = "";
    L32:
        r0.put("inner", r11);
        String r12 = com.bytedance.android.ecom.arch.slice.render.util.b.r(r5.a.j);
        if (r12 != null) goto L35;
        r12 = "";
    L35:
        r0.put("origin", r12);
        String r13 = com.bytedance.android.ecom.arch.slice.render.util.b.r(r5.a.k);
        if (r13 != null) goto L38;
        r13 = "";
    L38:
        r0.put("proxy", r13);
        String r14 = com.bytedance.android.ecom.arch.slice.render.util.b.r(r5.a.l);
        if (r14 != null) goto L41;
        r14 = "";
    L41:
        r0.put("rtt", r14);
        String r15 = com.bytedance.android.ecom.arch.slice.render.util.b.r(r5.a.m);
        if (r15 != null) goto L44;
        r15 = "";
    L44:
        r0.put("security_callback", r15);
        String r16 = com.bytedance.android.ecom.arch.slice.render.util.b.r(r5.a.n);
        if (r16 != null) goto L47;
        r16 = "";
    L47:
        r0.put("send", r16);
        String r17 = com.bytedance.android.ecom.arch.slice.render.util.b.r(r5.a.o);
        if (r17 != null) goto L50;
        r17 = "";
    L50:
        r0.put("ssl", r17);
        String r18 = com.bytedance.android.ecom.arch.slice.render.util.b.r(r5.a.p);
        if (r18 != null) goto L53;
        r18 = "";
    L53:
        r0.put("tcp", r18);
        String r19 = com.bytedance.android.ecom.arch.slice.render.util.b.r(r5.a.q);
        if (r19 != null) goto L56;
        r19 = "";
    L56:
        r0.put("ttfb", r19);
        String r20 = com.bytedance.android.ecom.arch.slice.render.util.b.r(Long.valueOf(r5.a.s));
        if (r20 != null) goto L59;
        r20 = "";
    L59:
        r0.put("pre_request_duration", r20);
        String r21 = com.bytedance.android.ecom.arch.slice.render.util.b.r(r5.a.t);
        if (r21 != null) goto L62;
        r21 = "";
    L62:
        r0.put("net_total_duration", r21);
        String r22 = com.bytedance.android.ecom.arch.slice.render.util.b.r(Long.valueOf(r5.a.u));
        if (r22 != null) goto L65;
        r22 = "";
    L65:
        r0.put("after_request_duration", r22);
        String r23 = com.bytedance.android.ecom.arch.slice.render.util.b.r(Long.valueOf(r5.a.v));
        if (r23 != null) goto L68;
        r23 = "";
    L68:
        r0.put("response_serializer_duration", r23);
        String r24 = com.bytedance.android.ecom.arch.slice.render.util.b.r(r5.b.a);
        if (r24 != null) goto L71;
        r24 = "";
    L71:
        r0.put("start_time", r24);
        String r25 = com.bytedance.android.ecom.arch.slice.render.util.b.r(r5.b.b);
        if (r25 != null) goto L74;
        r25 = "";
    L74:
        r0.put("create_stream_start", r25);
        String r26 = com.bytedance.android.ecom.arch.slice.render.util.b.r(r5.b.c);
        if (r26 != null) goto L77;
        r26 = "";
    L77:
        r0.put("create_stream_finish", r26);
        String r27 = com.bytedance.android.ecom.arch.slice.render.util.b.r(r5.b.d);
        if (r27 != null) goto L80;
        r27 = "";
    L80:
        r0.put("request_sent_time", r27);
        String r28 = com.bytedance.android.ecom.arch.slice.render.util.b.r(r5.b.e);
        if (r28 != null) goto L83;
        r28 = "";
    L83:
        r0.put("response_recv_time", r28);
        String r29 = com.bytedance.android.ecom.arch.slice.render.util.b.r(r5.b.f);
        if (r29 != null) goto L86;
        r29 = "";
    L86:
        r0.put("end_time", r29);
        String r30 = com.bytedance.android.ecom.arch.slice.render.util.b.r(r5.b.g);
        if (r30 != null) goto L89;
        r30 = "";
    L89:
        r0.put("ec_net_request_start", r30);
        String r31 = com.bytedance.android.ecom.arch.slice.render.util.b.r(r5.b.h);
        if (r31 != null) goto L92;
        r31 = "";
    L92:
        r0.put("ec_net_request_end", r31);
        String r32 = com.bytedance.android.ecom.arch.slice.render.util.b.r(r5.b.i);
        if (r32 != null) goto L95;
        r32 = "";
    L95:
        r0.put("app_level_request_start", r32);
        String r33 = com.bytedance.android.ecom.arch.slice.render.util.b.r(r5.b.j);
        if (r33 != null) goto L98;
        r33 = "";
    L98:
        r0.put("before_all_interceptors", r33);
        String r34 = com.bytedance.android.ecom.arch.slice.render.util.b.r(r5.c.d);
        if (r34 != null) goto L101;
        r34 = "";
    L101:
        r0.put("received_bytes", r34);
        String r35 = com.bytedance.android.ecom.arch.slice.render.util.b.r(r5.c.e);
        if (r35 != null) goto L104;
        r35 = "";
    L104:
        r0.put("sent_bytes", r35);
        String r36 = com.bytedance.android.ecom.arch.slice.render.util.b.r(r5.c.m);
        if (r36 != null) goto L107;
        r36 = "";
    L107:
        r0.put("downlink_throughput", r36);
        String r37 = com.bytedance.android.ecom.arch.slice.render.util.b.r(r5.c.o);
        if (r37 != null) goto L110;
        r37 = "";
    L110:
        r0.put("http_rtt", r37);
        String r38 = com.bytedance.android.ecom.arch.slice.render.util.b.r(r5.c.p);
        if (r38 == null) goto L114;
        r2 = r38;
    L114:
        r0.put("tcp_rtt", r2);
        return r0;
    }
}
