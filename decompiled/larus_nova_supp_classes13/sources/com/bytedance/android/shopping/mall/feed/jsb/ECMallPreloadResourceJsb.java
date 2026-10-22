package com.bytedance.android.shopping.mall.feed.jsb;

import com.bytedance.android.shopping.api.mall.common.feed.jsb.ECMallPreloadResourceHelper;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class ECMallPreloadResourceJsb extends qf3.e {
    public static final /* synthetic */ int d = 0;

    public final String getName() {
        return "ec.preloadResource";
    }

    public static void g() {
        ECMallPreloadResourceHelper.c.set(1);
        ECMallPreloadResourceHelper.g.clear();
        ECMallPreloadResourceHelper.e.clear();
        ECMallPreloadResourceHelper.f.clear();
        ECMallPreloadResourceHelper.b.set(0);
        ECMallPreloadResourceHelper.d.set("success: all preload success");
    }

    public ECMallPreloadResourceJsb(qf3.d r2) {
        Intrinsics.checkNotNullParameter(r2, "mallJsbContext");
        super(r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v39, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r3v41, types: [java.util.ArrayList] */
    @Override // qf3.e
    public final void realHandle(IBDXBridgeContext r28, Map<String, ? extends Object> r29, IDLXBridgeMethod.a r30) {
        Intrinsics.checkNotNullParameter(r28, "bridgeContext");
        Intrinsics.checkNotNullParameter(r29, "params");
        Intrinsics.checkNotNullParameter(r30, "callback");
        String r2 = "data";
        Object r0 = r29.get("data");
        if (r0 != null) goto L5;
    L14:
        List r3 = CollectionsKt.emptyList();
    L15:
        final int r1 = r3.size();
        String r6 = "msg";
        if (r3.isEmpty() == false) goto L19;
        AtomicInteger r4 = ECMallPreloadResourceHelper.c;
        r4.set(0);
        AtomicReference<String> r5 = ECMallPreloadResourceHelper.d;
        r5.set("error: the data params is empty");
        ConcurrentHashMap<String, Object> r7 = ECMallPreloadResourceHelper.f;
        r7.put("details", CollectionsKt.toList(ECMallPreloadResourceHelper.g));
        ConcurrentHashMap<String, Object> r8 = ECMallPreloadResourceHelper.e;
        r8.put("code", r4);
        r8.put("msg", r5);
        r8.put("data", r7);
        r30.invoke(r8);
        g();
        return;
    L19:
        Ref.IntRef r9 = new Ref.IntRef();
        r9.element = 0;
        Iterator r10 = r3.iterator();
    L21:
        if (r10.hasNext() == false) goto L52;
        Map r11 = (Map) r10.next();
        String r13 = (String) r11.get("uri");
        String r12 = (String) r11.get("type");
        String r15 = (String) r11.get("bizTag");
        String r14 = (String) r11.get("sceneTag");
        Iterator r210 = r10;
        r9.element++;
        if (r13 != null) goto L25;
    L28:
        boolean r16 = true;
    L30:
        if (r16 == true) goto L47;
        if (r12 != null) goto L33;
    L36:
        boolean r17 = true;
    L37:
        if (r17 == true) goto L47;
        if ((!Intrinsics.areEqual(r12, "image")) == false) goto L45;
        AtomicInteger r18 = ECMallPreloadResourceHelper.b;
        r18.incrementAndGet();
        String r23 = r2;
        AtomicInteger r19 = ECMallPreloadResourceHelper.c;
        String r24 = r6;
        r19.set(0);
        AtomicReference<String> r20 = ECMallPreloadResourceHelper.d;
        r20.set("error: there are type that is not image");
        ConcurrentHashMap<String, Object> r21 = new ConcurrentHashMap(MapsKt.mapOf(new Pair[]{TuplesKt.to("uri", r13), TuplesKt.to("type", r12), TuplesKt.to("bizTag", r15), TuplesKt.to("sceneTag", r14), TuplesKt.to("status", 0), TuplesKt.to("errMsg", "error: the type is not image")}));
        ConcurrentLinkedQueue<ConcurrentHashMap<String, Object>> r22 = ECMallPreloadResourceHelper.g;
        r22.add(r21);
        if (r18.get() != r1) goto L44;
        ConcurrentHashMap<String, Object> r25 = ECMallPreloadResourceHelper.f;
        r25.put("details", CollectionsKt.toList(r22));
        ConcurrentHashMap<String, Object> r26 = ECMallPreloadResourceHelper.e;
        r26.put("code", r19);
        String r27 = r24;
        r26.put(r27, r20);
        String r31 = r23;
        r26.put(r31, r25);
        final IDLXBridgeMethod.a r32 = r30;
        r32.invoke(r26);
        g();
        final Ref.IntRef r33 = r9;
    L46:
        r9 = r33;
        String r34 = r31;
        String r211 = r27;
        IDLXBridgeMethod.a r35 = r32;
        String r36 = r211;
    L51:
        r6 = r36;
        r2 = r34;
        r9 = r9;
        r10 = r210;
        goto L21
    L44:
        r35 = r30;
        r34 = r23;
        r36 = r24;
        goto L51
    L45:
        r27 = r6;
        r31 = r2;
        r32 = r30;
        r33 = r9;
        ECMallPreloadResourceHelper.a.invoke(r13, r14, r15, Integer.valueOf(r33.element), Integer.valueOf(r1), new ECMallPreloadResourceJsb$realHandle$$inlined$forEach$lambda$1(this, r33, r1, r32));
        goto L46
    L33:
        if (r12.length() == 0) goto L36;
        r17 = false;
    L47:
        String r37 = r6;
        String r38 = r2;
        AtomicInteger r212 = ECMallPreloadResourceHelper.b;
        r212.incrementAndGet();
        AtomicInteger r39 = ECMallPreloadResourceHelper.c;
        r39.set(0);
        AtomicReference<String> r40 = ECMallPreloadResourceHelper.d;
        r40.set("error: there are empty or null uri | type");
        ConcurrentHashMap<String, Object> r41 = new ConcurrentHashMap(MapsKt.mapOf(new Pair[]{TuplesKt.to("uri", r13), TuplesKt.to("type", r12), TuplesKt.to("bizTag", r15), TuplesKt.to("sceneTag", r14), TuplesKt.to("status", 0), TuplesKt.to("errMsg", "error: the uri | type is empty or null")}));
        ConcurrentLinkedQueue<ConcurrentHashMap<String, Object>> r42 = ECMallPreloadResourceHelper.g;
        r42.add(r41);
        if (r212.get() != r1) goto L50;
        ConcurrentHashMap<String, Object> r43 = ECMallPreloadResourceHelper.f;
        r43.put("details", CollectionsKt.toList(r42));
        ConcurrentHashMap<String, Object> r44 = ECMallPreloadResourceHelper.e;
        r44.put("code", r39);
        r36 = r37;
        r44.put(r36, r40);
        r34 = r38;
        r44.put(r34, r43);
        r35 = r30;
        r35.invoke(r44);
        g();
        goto L51
    L50:
        r35 = r30;
        r34 = r38;
        r36 = r37;
        goto L51
    L25:
        if (r13.length() == 0) goto L28;
        r16 = false;
        goto L30
    L52:
        return;
    L5:
        if ((r0 instanceof List) == false) goto L12;
        r3 = new ArrayList();
        Iterator r45 = ((Iterable) r0).iterator();
    L8:
        if (r45.hasNext() == false) goto L13;
        Object r46 = r45.next();
        if ((r46 instanceof Map) == false) goto L8;
        r3.add(r46);
    L13:
        if (r3 != 0) goto L15;
    L12:
        r3 = CollectionsKt.emptyList();
        goto L13
    }

    @Override // qf3.e
    public final Pair<Boolean, String> e(qf3.d r2, IBDXBridgeContext r3, Map<String, ? extends Object> r4, Map<String, Object> r5) {
        Intrinsics.checkNotNullParameter(r2, "mallJsbContext");
        Intrinsics.checkNotNullParameter(r3, "bridgeContext");
        Intrinsics.checkNotNullParameter(r4, "params");
        Intrinsics.checkNotNullParameter(r5, "result");
        return qf3.e.f(this);
    }
}
