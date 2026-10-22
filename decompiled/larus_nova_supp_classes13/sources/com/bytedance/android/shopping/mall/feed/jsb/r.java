package com.bytedance.android.shopping.mall.feed.jsb;

import com.bytedance.android.ec.hybrid.list.ECHybridListEngine;
import com.bytedance.android.ec.hybrid.list.entity.ECHybridListItemVO;
import com.bytedance.android.ec.hybrid.list.util.ECHybridGsonUtil;
import com.bytedance.common.utility.Logger;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class r extends qf3.e {
    public final String d;

    public static final class a {
    }

    static {
    }

    public final String getName() {
        return this.d;
    }

    public r(qf3.d r2) {
        Intrinsics.checkNotNullParameter(r2, "mallJsbContext");
        super(r2);
        this.d = "mall.getFeedData";
    }

    @Override // qf3.e
    public final void realHandle(IBDXBridgeContext r10, Map<String, ? extends Object> r11, IDLXBridgeMethod.a r12) {
        Intrinsics.checkNotNullParameter(r10, "bridgeContext");
        Intrinsics.checkNotNullParameter(r11, "params");
        Intrinsics.checkNotNullParameter(r12, "callback");
        if (r11.containsKey("section") == true) goto L5;
    L81:
        Logger.d("puffone-NativeCommerceHomePage.initListEngine()", "JSB_EC_GET_FEED_DATA error");
        r12.invoke(MapsKt.emptyMap());
        a(r11, MapsKt.emptyMap());
        return;
    L5:
        if (r11.containsKey("index") == false) goto L81;
        if (r11.containsKey("frontCount") == false) goto L81;
        if (r11.containsKey("followingCount") == false) goto L81;
        ArrayList r3 = new ArrayList();
        Object r13 = r11.get("section");
        if ((r13 instanceof Integer) == true) goto L14;
        r13 = null;
    L14:
        Integer r14 = (Integer) r13;
        if (r14 == null) goto L17;
        int r15 = r14.intValue();
    L18:
        ECHybridListEngine r4 = this.c.b.J;
        if (r4 == null) goto L37;
        com.bytedance.android.ec.hybrid.list.entity.k r5 = r4.c.g;
        if (r5 == null) goto L37;
        ArrayList r6 = r5.c;
        if (r6 == null) goto L37;
        int r8 = r6.size();
        if (r15 < 0) goto L29;
        if (r8 <= r15) goto L29;
        boolean r9 = true;
    L30:
        if (r9 == true) goto L33;
        r6 = null;
    L33:
        if (r6 == null) goto L37;
        com.bytedance.android.ec.hybrid.list.entity.i r16 = (com.bytedance.android.ec.hybrid.list.entity.i) ListProtector.get(r6, r15);
        if (r16 == null) goto L37;
        ArrayList r17 = r16.i;
    L38:
        if (r17 != null) goto L40;
    L80:
        Map<String, ? extends Object> r18 = MapsKt.mapOf(TuplesKt.to("data", MapsKt.mapOf(TuplesKt.to("data", r3))));
        r12.invoke(r18);
        a(r11, r18);
        return;
    L40:
        if ((!r17.isEmpty()) != true) goto L80;
        Object r0 = r11.get("index");
        if (r0 == null) goto L79;
        int r1 = ((Integer) r0).intValue();
        Object r2 = r11.get("frontCount");
        if (r2 == null) goto L77;
        int r7 = ((Integer) r2).intValue();
        Object r19 = r11.get("followingCount");
        if (r19 == null) goto L75;
        List r110 = r17.subList(Math.max(r1 - r7, 0), Math.min((r1 + 1) + ((Integer) r19).intValue(), r17.size() - 1));
        ArrayList r20 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r110, 10));
        Iterator r111 = r110.iterator();
    L49:
        if (r111.hasNext() == false) goto L80;
        ECHybridListItemVO r21 = (ECHybridListItemVO) r111.next();
        Map r22 = r21.V;
        if (r22 == null) goto L53;
    L68:
        if (r22 == null) goto L70;
        r22.putAll(r21.E);
    L70:
        Map r23 = r21.V;
    L71:
        if (r23 != null) goto L73;
        r23 = MapsKt.emptyMap();
    L73:
        r20.add(Boolean.valueOf(r3.add(r23)));
        goto L49
    L53:
        if (r21.U == true) goto L68;
        String r24 = r21.g();
        if (r24 != null) goto L83;
    L67:
        r21.U = true;
        r23 = r21.V;
        goto L71
    L83:
        Result.Companion r25 = Result.Companion;     // Catch: Throwable -> L59
        Object r26 = Result.constructor-impl(TypeIntrinsics.asMutableMap(ECHybridGsonUtil.a().fromJson(r24, Map.class)));     // Catch: Throwable -> L59
    L62:
        if (Result.isFailure-impl(r26) == false) goto L64;
        r26 = null;
    L64:
        Map r27 = (Map) r26;
        r21.V = r27;
        if (r27 == null) goto L67;
        r27.putAll(r21.E);
    L59:
        th = move-exception;
        Result.Companion r28 = Result.Companion;
        r26 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L62
    L75:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    L77:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    L79:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    L29:
        r9 = false;
    L37:
        r17 = null;
        goto L38
    L17:
        r15 = -1;
        goto L18
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
