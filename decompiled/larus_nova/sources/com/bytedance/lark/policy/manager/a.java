package com.bytedance.lark.policy.manager;

import com.bytedance.lark.policy.model.ErrorCode;
import com.bytedance.lark.policy.model.n;
import com.bytedance.lark.policy.model.o;
import com.bytedance.lark.policy.model.y;
import com.bytedance.lark.policy.network.NetworkService;
import com.bytedance.lark.policy.utils.EventTrace;
import com.bytedance.lark.policy.utils.Logger;
import com.bytedance.lark.policy.utils.e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes20.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final y f253814a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final AtomicBoolean f253815b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile o f253816c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static volatile y f253817d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static int f253818e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static volatile long f253819f;

    static {
        y r100 = new y(null);
        f253814a = r100;
        f253815b = new AtomicBoolean(false);
        f253816c = new o(MapsKt.emptyMap(), MapsKt.emptyMap());
        f253817d = r100;
    }

    public static void a() {
        boolean r100 = com.bytedance.lark.policy.utils.c.b();
        boolean r101 = com.bytedance.lark.policy.utils.c.c().b();
        if (r100 == true) goto L5;
        Logger.c("PolicyManager", "getPolicyFromNet:disable tenant list fetching,because policy engine is disabled");
    L28:
        boolean r102 = d.f253827a;
        boolean r103 = c(d.f253829c);
        if (r100 == false) goto L40;
        if (r101 == false) goto L40;
        if (r103 == false) goto L40;
        if (f253815b.getAndSet(true) == true) goto L46;
        JSONObject r104 = new JSONObject();
        r104.put("version", "1.0.0");     // Catch: JSONException -> L38
        int r105 = NetworkService.f253874a;
        NetworkService.a("/lark/scs/guardian/policy_engine/client_policy_pair/query", r104, PolicyManager$fetchPolicyList$1.INSTANCE);
        return;
    L38:
        e = move-exception;
        int r106 = Logger.f253883a;
        Logger.b("PolicyManager", "getPolicyPairFromNet:jsonObject put error, " + e.getMessage());
        int r107 = EventTrace.f253882a;
        EventTrace.e(ErrorCode.POLICY_FETCH_ERROR, "fetch policy error, jsonObject put error", null, 12);
        f253815b.set(false);
        return;
    L46:
        return;
    L40:
        int r108 = Logger.f253883a;
        Logger.c("PolicyManager", "getPolicyFromNet:disable policy fetching,enablePolicyEngine:" + r100 + ",enableLocalValidate" + r101 + ",tenantHasDeployPolicy = " + r103);
        return;
    L5:
        if (com.bytedance.lark.policy.utils.c.c().f() == false) goto L11;
        ke6.d.f503032a.getClass();
        if (ke6.d.f() == false) goto L11;
        if (ke6.d.e() == true) goto L11;
        boolean r109 = true;
    L12:
        if (r109 == false) goto L23;
        long r110 = com.bytedance.lark.policy.utils.c.c().h() * 1000;
        long r111 = System.currentTimeMillis();
        int r112 = e.f253887a;
        Long r113 = (Long) e.a("KEY_LAST_TENANT_LIST_FETCH_SUCCESS_TIME", Long.TYPE);
        if (r113 == null) goto L17;
        long r114 = r113.longValue();
    L19:
        if (r114 <= 0) goto L23;
        if ((r111 - r114) >= r110) goto L23;
        int r115 = Logger.f253883a;
        Logger.c("PolicyManager", "fetchTenantList: skip by non-enterprise officesdk interval, lastFetchTime:" + r114 + ", intervalMs:" + r110);
        boolean r116 = true;
    L24:
        if (r116 == true) goto L28;
        int r117 = NetworkService.f253874a;
        NetworkService.a("/lark/scs/guardian/policy_engine/policy_type_tenants/query", new JSONObject(), PolicyManager$fetchTenantList$1.INSTANCE);
        goto L28
    L17:
        r114 = 0;
    L23:
        r116 = false;
    L11:
        r109 = false;
        goto L12
    }

    public static boolean c(String r100) {
        Intrinsics.checkNotNullParameter(r100, "tenantId");
        if (f253817d == f253814a) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == false) goto L21;
        Long r102 = StringsKt.toLongOrNull(r100);
        if (r102 == null) goto L10;
        long r103 = r102.longValue();
    L12:
        if (r103 < 0) goto L21;
        Iterator<Map.Entry<String, List<String>>> r104 = f253817d.b().entrySet().iterator();
    L16:
        if (r104.hasNext() == false) goto L20;
        if (r104.next().getValue().contains(r100) == false) goto L16;
        return true;
    L20:
        return false;
    L10:
        r103 = -1;
    L21:
        int r105 = Logger.f253883a;
        Logger.b("PolicyManager", " tenantHasDeployPolicy error,tenantID= " + r100 + ", tenantID<=0 or tenantWithPolicyData is empty");
        return true;
    L5:
        r101 = false;
        goto L6
    }

    public static boolean d(String r100) {
        Intrinsics.checkNotNullParameter(r100, "tenantId");
        boolean r101 = com.bytedance.lark.policy.utils.c.b();
        boolean r102 = com.bytedance.lark.policy.utils.c.c().b();
        boolean r103 = c(r100);
        if (r101 == false) goto L7;
        if (r102 == false) goto L7;
        if (r103 == false) goto L7;
        return true;
    L7:
        return false;
    }

    public static List b(List r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "idList");
        Intrinsics.checkNotNullParameter(r101, "policyType");
        ArrayList r102 = new ArrayList();
        Iterator r103 = r100.iterator();
    L4:
        if (r103.hasNext() == false) goto L10;
        String r104 = (String) r103.next();
        n r105 = f253816c.a().get(r104);
        if (r105 == null) goto L4;
        if (Intrinsics.areEqual(r105.getType(), r101) == false) goto L4;
        r102.add(r105);
        goto L4
    L10:
        return r102;
    }
}
