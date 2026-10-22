package com.bytedance.lark.policy.manager;

import com.bytedance.lark.policy.model.ErrorCode;
import com.bytedance.lark.policy.network.NetworkService;
import com.bytedance.lark.policy.utils.EventTrace;
import com.bytedance.lark.policy.utils.Logger;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import ne6.e;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes20.dex */
public final class DecisionLogManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static List<oe6.a> f253805a;

    static {
        f253805a = new ArrayList();
    }

    public static void b() {
        ke6.d.f503032a.getClass();
        e r100 = ke6.d.d();
        if (r100 == null) goto L6;
        r100.c(DecisionLogManager$getEvaluateInfoFromSP$1.INSTANCE);
        return;
    }

    public static void e() {
        if (f253805a.size() <= 0) goto L15;
        List<oe6.a> r100 = f253805a;
        JSONObject r101 = new JSONObject();
        r101.put("evaluateInfos", new JSONArray(com.bytedance.lark.policy.utils.b.f253886a.toJson(r100)));     // Catch: Exception -> L7
        JSONObject r102 = NetworkService.b("/lark/scs/guardian/policy_engine/evaluate_uk/report", r101);
    L9:
        if (r102 == null) goto L11;
        Logger.c("DecisionLogManager", "reportEvaluateInfoList success");
        f253805a.clear();
        int r103 = com.bytedance.lark.policy.utils.e.f253887a;
        com.bytedance.lark.policy.utils.e.d("KEY_USER_EVALUATE_INFO_DATA", new oe6.b(f253805a));
        return;
    L11:
        Logger.c("DecisionLogManager", "reportEvaluateInfoList failed");
        return;
    L7:
        e = move-exception;
        int r104 = Logger.f253883a;
        Logger.b("DecisionLogManager", "reportEvaluateInfoList :jsonObject put error, " + e.getMessage());
        int r105 = EventTrace.f253882a;
        EventTrace.e(ErrorCode.UNKNOWN_ERROR, "report client log error, jsonObject put error", null, 12);
        r102 = null;
        goto L9
    }

    public static void a(final List r100) {
        Intrinsics.checkNotNullParameter(r100, "evaluateInfoSet");
        ke6.d.f503032a.getClass();
        e r101 = ke6.d.d();
        if (r101 == null) goto L6;
        r101.c(new DecisionLogManager$deleteDecisionLog$1(r100));
        return;
    }

    public static void c(List r100) {
        Intrinsics.checkNotNullParameter(r100, "newEvaluateInfoList");
        JSONObject r101 = new JSONObject();
        r101.put("evaluateInfos", new JSONArray(com.bytedance.lark.policy.utils.b.f253886a.toJson(r100)));     // Catch: Exception -> L6
        int r102 = NetworkService.f253874a;
        NetworkService.a("/lark/scs/guardian/policy_engine/evaluate_log/delete", r101, DecisionLogManager$realDeleteDecisionLog$1.INSTANCE);
        return;
    L6:
        e = move-exception;
        int r103 = Logger.f253883a;
        Logger.b("DecisionLogManager", "realDeleteDecisionLog :jsonObject put error, " + e.getMessage());
        int r104 = EventTrace.f253882a;
        EventTrace.e(ErrorCode.UNKNOWN_ERROR, "report client log error, jsonObject put error", null, 12);
    }

    public static void f(final List r100) {
        Intrinsics.checkNotNullParameter(r100, "addEvaluateInfoList");
        ke6.d.f503032a.getClass();
        e r101 = ke6.d.d();
        if (r101 == null) goto L6;
        r101.c(new DecisionLogManager$reportRealLog$1(r100));
        return;
    }

    public static void d(oe6.c r100, boolean r101) {
        if (r100 != null) goto L4;
        return;
    L4:
        JSONObject r102 = new JSONObject();
        r102.put("policyLog", new JSONObject(com.bytedance.lark.policy.utils.b.f253886a.toJson(r100)));     // Catch: Exception -> L8
        r102.put("isPreEvaluate", r101);     // Catch: Exception -> L8
        int r103 = NetworkService.f253874a;
        NetworkService.a("/lark/scs/guardian/policy_engine/policy_log/report/v2", r102, DecisionLogManager$reportClientPolicyLog$1.INSTANCE);
        return;
    L8:
        e = move-exception;
        int r104 = Logger.f253883a;
        Logger.b("DecisionLogManager", "reportClientPolicyLog :jsonObject put error, " + e.getMessage());
        int r105 = EventTrace.f253882a;
        EventTrace.e(ErrorCode.UNKNOWN_ERROR, "report client log error, jsonObject put error", null, 12);
    }
}
