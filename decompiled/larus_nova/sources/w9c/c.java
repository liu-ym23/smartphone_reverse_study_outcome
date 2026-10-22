package w9c;

import com.alipay.sdk.m.u.i;
import com.bytedance.lark.pb.ugreach.v1.GetUGScenarioResponse;

/* JADX INFO: loaded from: classes38.dex */
public final class c {
    public static String a(GetUGScenarioResponse r100) {
        StringBuilder r101 = new StringBuilder();
        if (r100 == null) goto L12;
        int r102 = r101.length();
        if (r100.scenario_id == null) goto L8;
        r101.append(", scenario_id =");
        r101.append(r100.scenario_id);
    L8:
        if (r100.scenario_context == null) goto L10;
        r101.append(", scenario_context = ");
        f.a(r100.scenario_context, r101);
    L10:
        r101.replace(r102, r102 + 2, "GetUGScenarioResponse{ ").append(i.f25855d);
    L12:
        return r101.toString();
    }
}
