package com.bytedance.lark.policy.manager;

import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.lark.policy.model.ErrorCode;
import com.bytedance.lark.policy.model.m;
import com.bytedance.lark.policy.model.z;
import com.bytedance.lark.policy.network.NetworkService;
import com.bytedance.lark.policy.utils.EventTrace;
import com.bytedance.lark.policy.utils.Logger;
import com.bytedance.lark.policy.utils.e;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes20.dex */
public final class UserPointCutManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile long f253810a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile boolean f253811b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final z f253812c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static volatile z f253813d;

    static {
        z r100 = new z(CollectionsKt.emptyList(), null);
        f253812c = r100;
        f253813d = r100;
    }

    public static void b() {
        if (com.bytedance.lark.policy.utils.c.b() == true) goto L6;
        Logger.c("UserPointCutManager", "getUserPointCutDataFromNet:disable pointcut fetching,because policy engine is disabled,");
        return;
    L6:
        boolean r100 = false;
        if (com.bytedance.lark.policy.utils.c.c().f() == false) goto L13;
        ke6.d.f503032a.getClass();
        if (ke6.d.f() == false) goto L13;
        if (ke6.d.e() == true) goto L13;
        boolean r101 = true;
    L14:
        if (r101 == false) goto L25;
        long r102 = com.bytedance.lark.policy.utils.c.c().h() * 1000;
        long r103 = System.currentTimeMillis();
        int r104 = e.f253887a;
        Long r105 = (Long) e.a("KEY_LAST_POINTCUT_FETCH_SUCCESS_TIME", Long.TYPE);
        if (r105 == null) goto L19;
        long r110 = r105.longValue();
    L21:
        if (r110 <= 0) goto L25;
        if ((r103 - r110) >= r102) goto L25;
        int r106 = Logger.f253883a;
        Logger.c("UserPointCutManager", "getUserPointCutDataFromNet: skip by non-enterprise officesdk interval, lastFetchTime:" + r110 + ", intervalMs:" + r102);
        r100 = true;
        goto L25
    L19:
        r110 = 0;
    L25:
        if (r100 == false) goto L27;
        return;
    L27:
        f253811b = true;
        int r107 = NetworkService.f253874a;
        NetworkService.a("/lark/scs/guardian/policy_engine/pointcut/query", new JSONObject(), UserPointCutManager$getUserPointCutDataFromNet$1.INSTANCE);
        return;
    L13:
        r101 = false;
        goto L14
    }

    public static m a(String r110) {
        Intrinsics.checkNotNullParameter(r110, LocationMonitorConst.IDENTIFIER);
        Map<String, m> r100 = f253813d.a();
        if (r100 == null) goto L5;
        m r101 = r100.get(r110);
    L7:
        if (r101 != null) goto L9;
        int r102 = Logger.f253883a;
        Logger.b("UserPointCutManager", "can't find pointCut,pointKey:" + r110);
        int r103 = EventTrace.f253882a;
        EventTrace.e(ErrorCode.POINT_CUT_FIND_ERROR, "can't find pointCut,pointKey:" + r110, null, 12);
    L9:
        long r104 = com.bytedance.lark.policy.utils.c.c().k() * ((long) 1000);
        if (f253813d == f253812c) goto L12;
        boolean r111 = true;
    L13:
        if (r111 == false) goto L15;
    L19:
        return r101;
    L15:
        if ((System.currentTimeMillis() - f253810a) < r104) goto L19;
        if (f253811b == true) goto L19;
        int r112 = Logger.f253883a;
        String r113 = "findPointCut: retry fetch pointCut,lastUpdateTime:" + f253810a + ",interval:" + (System.currentTimeMillis() - f253810a);
        Intrinsics.checkNotNullParameter("UserPointCutManager", "eventName");
        Logger.a(1, "UserPointCutManager", r113);
        b();
        goto L19
    L12:
        r111 = false;
        goto L13
    L5:
        r101 = null;
        goto L7
    }
}
