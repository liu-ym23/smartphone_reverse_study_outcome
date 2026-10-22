package com.bytedance.ee.bear.document.offline.sync;

import com.alibaba.fastjson.JSONObject;
import com.bytedance.ee.bear.document.offline.sync.preloadtask.EmbedDocList;
import io.reactivex.functions.Function;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class k<T, R> implements Function {
    public final /* synthetic */ List<EmbedDocList> a;
    public final /* synthetic */ DocxPreloadStrategyV2 b;

    public k(List<EmbedDocList> r1, DocxPreloadStrategyV2 r2) {
        this.a = r1;
        this.b = r2;
    }

    public final Object apply(Object r10) {
        Intrinsics.checkNotNullParameter((String) r10, "it");
        ArrayList r11 = new ArrayList();
        ArrayList r0 = new ArrayList();
        ArrayList r1 = new ArrayList();
        ArrayList r2 = new ArrayList();
        q r3 = l0.a(sbb.e.n.b);
        Iterator<EmbedDocList> r4 = this.a.iterator();
    L4:
        if (r4.hasNext() == false) goto L39;
        EmbedDocList r5 = r4.next();
        Integer r6 = r5.getFileType();
        int r7 = sbb.e.n.b;
        k25.m0 r8 = null;
        if (r6 == null) goto L18;
        if (r6.intValue() != r7) goto L18;
        String r9 = r5.getToken();
        if (r9 == null) goto L4;
        if (r3 == null) goto L14;
        r8 = r3.g(r9, new HashMap());
    L14:
        if (r8 == null) goto L4;
        if (r8.c == null) goto L4;
        r2.add(r9);
    L18:
        Integer r12 = r5.getFileType();
        int r13 = sbb.e.h.b;
        if (r12 == null) goto L26;
        if (r12.intValue() != r13) goto L26;
        String r14 = r5.getToken();
        if (r14 == null) goto L4;
        r0.add(r14);
    L26:
        Integer r16 = r5.getFileType();
        int r17 = sbb.e.l.b;
        if (r16 == null) goto L36;
        if (r16.intValue() != r17) goto L36;
        String r18 = r5.getToken();
        if (r18 == null) goto L4;
        if (((com.bytedance.ee.bear.drive.services.c) org.koin.java.a.c(com.bytedance.ee.bear.drive.services.c.class, null, null, 6)).y9(r18) == false) goto L4;
        r1.add(r18);
    L36:
        String r19 = r5.getToken();
        if (r19 == null) goto L4;
        r11.add(r19);
        goto L4
    L39:
        ArrayList r20 = new ArrayList();
        r20.addAll(r2);
        if (r11.size() <= 0) goto L50;
        k25.e0 r21 = k25.e0.m();
        String r22 = this.b.f;
        r21.getClass();
        List<String> r110 = r21.q().e().e(r11, r22);     // Catch: Exception -> L44
    L47:
        if (((ArrayList) r110).size() <= 0) goto L50;
        Intrinsics.checkNotNull(r110);
        r20.addAll(r110);
    L44:
        e = move-exception;
        iu5.d.c(e);
        r110 = new ArrayList();
    L50:
        if (r0.size() <= 0) goto L60;
        k25.e0 r111 = k25.e0.m();
        String r23 = this.b.z;
        r111.getClass();
        List<String> r112 = r111.q().e().e(r0, r23);     // Catch: Exception -> L54
    L57:
        if (((ArrayList) r112).size() <= 0) goto L60;
        Intrinsics.checkNotNull(r112);
        r20.addAll(r112);
    L54:
        e = move-exception;
        iu5.d.c(e);
        r112 = new ArrayList();
    L60:
        if (r1.size() <= 0) goto L62;
        r20.addAll(r1);
    L62:
        tt5.a.h(this.b.a, "embedDocTokens tokens size : " + r20.size());
        JSONObject r113 = new JSONObject();
        if (r20.size() <= 0) goto L65;
        r113.put("preloadedEmbedTokens", r20);
    L65:
        return r113;
    }
}
