package com.bytedance.android.shopping.orderlist.common.service;

import com.bytedance.android.ec.core.utils.z1;
import com.bytedance.android.ec.sdk.helper.g;
import com.bytedance.android.shopping.orderlist.common.monitor.error.b;
import com.bytedance.android.shopping.orderlist.common.utils.i;
import com.bytedance.android.shopping.orderlist.list.starter.NativeOrderListRouter;
import com.bytedance.android.shopping.orderlist.search.starter.NativeOrderSearchResultRouter;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import sc3.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class a implements h {

    /* JADX INFO: renamed from: com.bytedance.android.shopping.orderlist.common.service.a$a, reason: collision with other inner class name */
    public static final class C0143a implements b {
        public C0143a() {
        }

        @Override // com.bytedance.android.shopping.orderlist.common.monitor.error.b
        public final void b(String r4, Map<String, ? extends Object> r5) {
            Intrinsics.checkNotNullParameter("ies_ecommerce_fe_custom_log", "name");
            Intrinsics.checkNotNullParameter(r5, "params");
            g.a.logV3("ies_ecommerce_fe_custom_log", new JSONObject(GsonProtectorUtils.toJson(i.a(), r5)));
        }
    }

    public a() {
        Map r0 = bf.a.a;
        bf.a.a(new NativeOrderListRouter());
        bf.a.a(new NativeOrderSearchResultRouter());
    }

    @Override // sc3.h
    public final void a(JSONObject r5) {
        Intrinsics.checkNotNullParameter(r5, "params");
        HashMap r6 = (HashMap) z1.k(r5);
        Map r0 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("preload_tasks", r6.get("preloadTasks")), TuplesKt.to("preload_biz_scene_priority", r6.get("preloadBizScenePriority"))});
        hg3.b r1 = new hg3.b(null, new C0143a());
        Object r7 = r6.get("trackCommonParams");
        if ((r7 instanceof Map) == true) goto L5;
        r7 = null;
    L5:
        Map<? extends String, ? extends Object> r8 = (Map) r7;
        if (r8 == null) goto L9;
        r1.a.putAll(r8);
    L9:
        new com.bytedance.android.shopping.orderlist.common.controller.h(r0, new com.bytedance.android.shopping.orderlist.common.controller.g(r1, null), new ArrayList()).b();
    }
}
