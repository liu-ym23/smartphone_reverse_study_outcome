package com.bytedance.android.shopping.mall.homepage.pagecard.dynamicparams;

import com.bytedance.android.ec.hybrid.log.mall.ECMallLogUtil;
import com.bytedance.android.ec.hybrid.log.mall.k;
import com.bytedance.android.shopping.api.mall.common.tools.b0;
import com.bytedance.android.shopping.api.mall.common.tools.p;
import com.bytedance.android.shopping.slice.action.entity.PdpOpenThirdParam;
import com.bytedance.services.apm.api.EnsureManager;
import com.google.gson.Gson;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public class DynamicParamsController {
    public final ConcurrentHashMap<String, ConcurrentHashMap<String, Map<String, Object>>> a;
    public final ConcurrentHashMap<String, Map<String, Object>> b;
    public final ConcurrentHashMap<String, Object> c;
    public final Lazy d;

    public DynamicParamsController() {
        this.a = new ConcurrentHashMap();
        this.b = new ConcurrentHashMap();
        this.c = new ConcurrentHashMap();
        this.d = LazyKt.lazy(DynamicParamsController$filterSetting$2.INSTANCE);
    }

    public final void b(Map<String, ? extends Object> r6) {
        Intrinsics.checkNotNullParameter(r6, "jsbData");
        Lazy r0 = ECMallLogUtil.a;
        k.b r1 = k.b.b;
        ECMallLogUtil.c(r1, "pagecard syncLocalDynamicParams jsbData: " + b0.m(r6));
        int r2 = b0.g(r6, "paramsType", -1);
        if (r2 >= 0) goto L43;
        ECMallLogUtil.b(r1, "pagecard syncLocalDynamicParams params_type miss");
        return;
    L43:
        Object r7 = r6.get("params");     // Catch: Exception -> L40
        if ((r7 instanceof Map) == true) goto L9;
        r7 = null;
    L9:
        Map<String, ? extends Object> r8 = (Map) r7;     // Catch: Exception -> L40
        if (r8 != null) goto L13;
        ECMallLogUtil.b(r1, "pagecard syncLocalDynamicParams params miss");     // Catch: Exception -> L40
        return;
    L13:
        DynamicParamsController$syncLocalDynamicParams$1 r3 = DynamicParamsController$syncLocalDynamicParams$1.INSTANCE;
    L37:
        e = move-exception;
        EnsureManager.ensureNotReachHere(e, "pagecard syncLocalDynamicParams handle error");
        return;
    L15:
        if (r2 != DynamicParamsType.API_PARAMS_WITH_TAB.getValue()) goto L31;
        this.a.clear();     // Catch: Exception -> L37
        Iterator<Map.Entry<String, ? extends Object>> r9 = r8.entrySet().iterator();     // Catch: Exception -> L37
    L18:
        if (r9.hasNext() == false) goto L51;
        Map.Entry<String, ? extends Object> r4 = r9.next();     // Catch: Exception -> L37
        String r5 = r4.getKey();     // Catch: Exception -> L37
        Object r10 = r4.getValue();     // Catch: Exception -> L37
        if ((r10 instanceof Map) == true) goto L22;
        r10 = null;
    L22:
        Map<String, ? extends Object> r11 = (Map) r10;     // Catch: Exception -> L37
        if (r11 == null) goto L24;
        this.a.put(r5, new ConcurrentHashMap());     // Catch: Exception -> L37
        DynamicParamsController$syncLocalDynamicParams$1 r12 = DynamicParamsController$syncLocalDynamicParams$1.INSTANCE;     // Catch: Exception -> L37
        ConcurrentHashMap<String, Map<String, Object>> r13 = this.a.get(r5);     // Catch: Exception -> L37
        if (r13 == null) goto L29;
        r12.invoke(r11, r13);     // Catch: Exception -> L37
        goto L18
    L29:
        throw new IllegalArgumentException("Required value was null.".toString());     // Catch: Exception -> L37
    L24:
        return;
    L51:
        return;
    L31:
        if (r2 != DynamicParamsType.API_PARAMS.getValue()) goto L34;
        this.b.clear();     // Catch: Exception -> L37
        r3.invoke(r8, this.b);     // Catch: Exception -> L37
        return;
    L34:
        if (r2 != DynamicParamsType.COMMON_PARAMS.getValue()) goto L50;
        this.c.clear();     // Catch: Exception -> L37
        this.c.putAll(r8);     // Catch: Exception -> L37
        return;
    L50:
        return;
    L40:
        e = move-exception;
        EnsureManager.ensureNotReachHere(e, "pagecard syncLocalDynamicParams with error params");
    }

    public final Map<String, Object> a(String r6, String r7, Map<String, ? extends Object> r8) {
        Intrinsics.checkNotNullParameter(r6, "tabId");
        Intrinsics.checkNotNullParameter(r7, "apiKey");
        Intrinsics.checkNotNullParameter(r8, "paramsContext");
        LinkedHashMap r1 = new LinkedHashMap();
        r1.putAll(this.c);
        Map<String, Object> r2 = this.b.get(r7);
        if (r2 == null) goto L5;
        r1.putAll(r2);
    L5:
        ConcurrentHashMap<String, Map<String, Object>> r9 = this.a.get(r6);
        if (r9 == null) goto L16;
        LinkedHashMap r3 = new LinkedHashMap();
        Iterator<Map.Entry<String, Map<String, Object>>> r10 = r9.entrySet().iterator();
    L9:
        if (r10.hasNext() == false) goto L13;
        Map.Entry<String, Map<String, Object>> r4 = r10.next();
        if (Intrinsics.areEqual(r4.getKey(), r7) == false) goto L9;
        r3.put(r4.getKey(), r4.getValue());
        goto L9
    L13:
        Map r11 = (Map) r3.get(r7);
        if (r11 == null) goto L16;
        r1.putAll(r11);
    L16:
        Object r12 = null;
        Gson r13 = p.a;     // Catch: Exception -> L25
        Object r14 = r8.get("log_extra");     // Catch: Exception -> L25
        if ((r14 instanceof String) == true) goto L20;
        r14 = null;
    L20:
        Object r15 = p.a((String) r14, Map.class);     // Catch: Exception -> L25
        if ((r15 instanceof Map) == true) goto L23;
        r15 = null;
    L23:
        Map r16 = (Map) r15;     // Catch: Exception -> L25
    L26:
        Object r5 = r1.get("log_extra");
        if ((r5 instanceof Map) == true) goto L29;
        r5 = null;
    L29:
        Map r17 = (Map) r5;
        if (r16 == null) goto L32;
        r1.put("log_extra", r16);
    L32:
        if (r17 == null) goto L45;
        Object r18 = r1.get("log_extra");
        if (TypeIntrinsics.isMutableMap(r18) == false) goto L37;
        r12 = r18;
    L37:
        Map r19 = (Map) r12;
        if (r19 == null) goto L45;
        Object r20 = r17.get("tab_name");
        if (r20 == null) goto L42;
        r19.put("tab_name", r20);
    L42:
        Object r21 = r17.get("tab_order");
        if (r21 == null) goto L45;
        r19.put("tab_order", r21);
    L45:
        Object r22 = r1.get("log_extra");
        if (r22 == null) goto L48;
        r1.put("log_extra", com.bytedance.android.ec.hybrid.list.util.k.b(r22));
    L48:
        Object r23 = r8.get(PdpOpenThirdParam.KEY_PAGE_NAME);
        if (r23 != null) goto L51;
    L53:
        return r1;
    L51:
        if (CollectionsKt.contains((List) this.d.getValue(), r23) == false) goto L53;
        r1.remove("filters");
    L25:
        r16 = null;
        goto L26
    }
}
