package w9c;

import com.alipay.sdk.m.u.i;
import com.bytedance.lark.pb.ugreach.v1.ReachPointEntity;
import com.bytedance.lark.pb.ugreach.v1.ScenarioContext;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes38.dex */
public final class f {
    public static void a(ScenarioContext r100, StringBuilder r101) {
        int r102 = r101.length();
        if (r100.scenario_id == null) goto L6;
        r101.append(", scenario_id = ");
        r101.append(r100.scenario_id);
    L6:
        if (r100.local_rule == null) goto L9;
        r101.append(", local_rule = ");
        b.a(r100.local_rule, r101);
    L9:
        if (r100.priority == null) goto L12;
        r101.append(", priority = ");
        r101.append(r100.priority);
    L12:
        if (r100.share_scenario_ids == null) goto L15;
        r101.append(", share_scenario_ids = ");
        r101.append(r100.share_scenario_ids.toString());
    L15:
        if (r100.entities == null) goto L23;
        r101.append(", entities = ");
        List<ReachPointEntity> r103 = r100.entities;
        r101.append("[");
        Iterator<ReachPointEntity> r104 = r103.iterator();
    L18:
        if (r104.hasNext() == false) goto L22;
        ReachPointEntity r105 = r104.next();
        if (r105 == null) goto L18;
        d.a(r105, r101);
        goto L18
    L22:
        r101.append("]");
    L23:
        r101.replace(r102, r102 + 2, "ScenarioContext{ ").append(i.f25855d);
    }
}
