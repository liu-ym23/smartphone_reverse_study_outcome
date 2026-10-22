package com.larus.account.saas.security.internal;

import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.larus.account.saas.runtime.internal.delegate.SaasTracking;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes24.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f286510a = 0;

    static {
    }

    public static void a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "path");
        SaasTracking r101 = SaasTracking.f286464a;
        JSONObject r102 = new JSONObject();
        r102.put("path", r100);
        Unit r103 = Unit.INSTANCE;
        r101.reportEvent("doubao_account_network_request", r102);
    }

    public static void b(String r100, boolean r101, Integer r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, "path");
        SaasTracking r104 = SaasTracking.f286464a;
        JSONObject r105 = new JSONObject();
        r105.put("path", r100);
        r105.put("success", r101 ? 1 : 0);
        if (r102 == null) goto L5;
        r105.put("err_code", r102.intValue());
    L5:
        if (r103 == null) goto L7;
        r105.put(LocationMonitorConst.ERR_MSG, r103);
    L7:
        Unit r106 = Unit.INSTANCE;
        r104.reportEvent("doubao_account_network_result", r105);
    }
}
