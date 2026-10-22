package com.bytedance.android.shopping.api.mall.common.tools;

import com.bytedance.android.ec.hybrid.list.ECHybridListEngine;
import com.bytedance.android.ec.hybrid.list.entity.ECHybridListItemVO;
import com.ss.android.common.lib.AppLogNewUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class t {
    public ECHybridListEngine a;
    public final Map<Integer, Integer> b;
    public Integer c;
    public String d;
    public final Function1<Integer, Integer> e;
    public final Function0<String> f;

    public static final class a {
    }

    static {
    }

    public static List a(com.bytedance.android.ec.hybrid.list.entity.k r5) {
        if (r5 == null) goto L4;
        List r6 = r5.c;
    L5:
        if (r6 != null) goto L7;
        r6 = CollectionsKt.emptyList();
    L7:
        ArrayList r0 = new ArrayList();
        Iterator r7 = r6.iterator();
    L9:
        if (r7.hasNext() == false) goto L23;
        Iterable r1 = ((com.bytedance.android.ec.hybrid.list.entity.i) r7.next()).i;
        if (r1 != null) goto L13;
        r1 = CollectionsKt.emptyList();
    L13:
        ArrayList r2 = new ArrayList();
        Iterator r3 = r1.iterator();
    L15:
        if (r3.hasNext() == false) goto L22;
        Object r4 = r3.next();
        if (((ECHybridListItemVO) r4).W == null) goto L19;
        boolean r8 = true;
    L20:
        if (r8 == false) goto L15;
        r2.add(r4);
        goto L15
    L19:
        r8 = false;
        goto L20
    L22:
        CollectionsKt.addAll(r0, r2);
        goto L9
    L23:
        return r0;
    L4:
        r6 = null;
        goto L5
    }

    public final int b(ECHybridListItemVO r3) {
        ECHybridListEngine r0 = this.a;
        if (r0 == null) goto L9;
        com.bytedance.android.ec.hybrid.list.ability.v r1 = (com.bytedance.android.ec.hybrid.list.ability.v) r0.getAbility(com.bytedance.android.ec.hybrid.list.ability.v.class);
        if (r1 != null) goto L8;
        return -1;
    L8:
        return r1.k40(r3);
    L9:
        return -1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public t(Function1<? super Integer, Integer> r2, Function0<String> r3) {
        Intrinsics.checkNotNullParameter(r2, "getSecTabId");
        Intrinsics.checkNotNullParameter(r3, "getCachedAddressInfo");
        this.e = r2;
        this.f = r3;
        this.b = new LinkedHashMap();
    }

    public final void c(int r4, int r5, int r6) {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L4
        JSONObject r1 = new JSONObject();     // Catch: Throwable -> L4
        r1.put("type", r4);     // Catch: Throwable -> L4
        r1.put("last_request_index", r5);     // Catch: Throwable -> L4
        r1.put("is_real_last", r6);     // Catch: Throwable -> L4
        r1.putOpt("address", this.d);     // Catch: Throwable -> L4
        Unit r7 = Unit.INSTANCE;     // Catch: Throwable -> L4
        AppLogNewUtils.onEventV3("gyl_next_day_arrive_request", r1);     // Catch: Throwable -> L4
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        Result.Companion r8 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
    }
}
