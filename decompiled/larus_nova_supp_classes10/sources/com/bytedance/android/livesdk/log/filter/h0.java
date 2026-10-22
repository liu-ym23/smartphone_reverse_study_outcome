package com.bytedance.android.livesdk.log.filter;

import android.text.TextUtils;
import com.bytedance.android.livehostapi.business.IBcmSearchTrack;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class h0 extends a<am2.t> implements s {
    public am2.t c;
    public final Map<String, String> d;

    public h0() {
        this.d = Collections.synchronizedMap(new LinkedHashMap());
    }

    @Override // com.bytedance.android.livesdk.log.filter.s
    public final am2.t getData() {
        return this.c;
    }

    @Override // com.bytedance.android.livesdk.log.filter.a, com.bytedance.android.livesdk.log.filter.o
    public final void setData(am2.t r1) {
        this.c = r1;
    }

    @Override // com.bytedance.android.livesdk.log.filter.a, com.bytedance.android.livesdk.log.filter.o
    public final void u(Map r12, am2.t r13) {
        am2.t r14 = r13;
        if (r14 == null) goto L5;
        long r0 = r14.a;
    L6:
        am2.t r2 = this.c;
        String r5 = "";
        if (r2 == null) goto L19;
        Map<Long, String> r3 = r2.c;
        if (r3 == null) goto L19;
        if (r3.containsKey(Long.valueOf(r0)) != true) goto L19;
        am2.t r4 = this.c;
        if (r4 == null) goto L25;
        Map<Long, String> r6 = r4.c;
        if (r6 == null) goto L25;
        String r7 = r6.get(Long.valueOf(r0));
        if (r7 == null) goto L25;
    L26:
        am2.t r8 = this.c;
        if (r8 == null) goto L39;
        Map<Long, String> r9 = r8.b;
        if (r9 == null) goto L39;
        if (r9.containsKey(Long.valueOf(r0)) != true) goto L39;
        am2.t r10 = this.c;
        if (r10 == null) goto L45;
        Map<Long, String> r11 = r10.b;
        if (r11 == null) goto L45;
        String r15 = r11.get(Long.valueOf(r0));
        if (r15 == null) goto L45;
    L46:
        am2.t r16 = this.c;
        if (r16 == null) goto L59;
        Map<Long, String> r17 = r16.e;
        if (r17 == null) goto L59;
        if (r17.containsKey(Long.valueOf(r0)) != true) goto L59;
        am2.t r18 = this.c;
        if (r18 == null) goto L65;
        Map<Long, String> r19 = r18.e;
        if (r19 == null) goto L65;
        String r20 = r19.get(Long.valueOf(r0));
        if (r20 == null) goto L65;
    L66:
        am2.t r110 = this.c;
        if (r110 == null) goto L72;
        Map<Long, String> r111 = r110.d;
        if (r111 == null) goto L72;
        String r1 = r111.get(Long.valueOf(r0));
        if (r1 == null) goto L72;
    L77:
        am2.t r21 = this.c;
        if (r21 == null) goto L84;
        String r22 = r21.h;
        if (r22 == null) goto L84;
        r5 = r22;
    L84:
        if (TextUtils.isEmpty(r7) == true) goto L88;
        if (r12 == null) goto L88;
        String r23 = (String) r12.put("search_id", r7);
    L88:
        if (TextUtils.isEmpty(r15) == true) goto L92;
        if (r12 == null) goto L92;
        String r24 = (String) r12.put("search_result_id", r15);
    L92:
        if (TextUtils.isEmpty(r20) == true) goto L96;
        if (r12 == null) goto L96;
        String r25 = (String) r12.put("search_jump", r20);
    L96:
        if (TextUtils.isEmpty(r1) == true) goto L100;
        if (r12 == null) goto L100;
        String r26 = (String) r12.put("search_params", r1);
    L100:
        if (TextUtils.isEmpty(r5) == true) goto L103;
        if (r12 == null) goto L103;
        String r27 = (String) r12.put("log_extra", r5);
    L103:
        if (r14 == null) goto L105;
        String r28 = r14.g;
    L106:
        if (r28 == null) goto L122;
        if (r12 == null) goto L122;
        IBcmSearchTrack r29 = jc1.k.f(IBcmSearchTrack.class);
        if (r29 == null) goto L122;
        Map r30 = r29.appendSearchParams(r28, MapsKt.toMutableMap(r12));
        if (r30 == null) goto L122;
        Iterator r31 = r30.entrySet().iterator();
    L114:
        if (r31.hasNext() == false) goto L122;
        Map.Entry r32 = (Map.Entry) r31.next();
        String r33 = (String) r32.getKey();
        Object r34 = r32.getValue();
        if (r33.length() <= 0) goto L118;
        boolean r35 = true;
    L119:
        if (r35 == false) goto L114;
        String r36 = (String) r12.put(r33, String.valueOf(r34));
        goto L114
    L118:
        r35 = false;
    L122:
        if (TextUtils.isEmpty(r7) == true) goto L130;
        super.u(r12, r14);
        return;
    L130:
        return;
    L105:
        r28 = null;
    L72:
        am2.t r37 = this.c;
        if (r37 == null) goto L76;
        r1 = r37.f;
        if (r1 != null) goto L77;
    L76:
        r1 = "";
    L65:
        r20 = "";
    L59:
        am2.t r38 = this.c;
        if (r38 == null) goto L65;
        Map<String, String> r39 = r38.b();
        if (r39 == null) goto L65;
        r20 = r39.get("search_jump");
        if (r20 != null) goto L66;
    L45:
        r15 = "";
    L39:
        am2.t r40 = this.c;
        if (r40 == null) goto L45;
        Map<String, String> r41 = r40.b();
        if (r41 == null) goto L45;
        r15 = r41.get("search_result_id");
        if (r15 != null) goto L46;
    L25:
        r7 = "";
    L19:
        am2.t r42 = this.c;
        if (r42 == null) goto L25;
        Map<String, String> r43 = r42.b();
        if (r43 == null) goto L25;
        r7 = r43.get("search_id");
        if (r7 != null) goto L26;
    L5:
        r0 = 0;
        goto L6
    }
}
