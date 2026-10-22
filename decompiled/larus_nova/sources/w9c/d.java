package w9c;

import com.alipay.sdk.m.u.i;
import com.bytedance.lark.pb.ugreach.v1.ReachPointConfig;
import com.bytedance.lark.pb.ugreach.v1.ReachPointEntity;
import com.bytedance.lark.pb.ugreach.v1.ReachPointMaterial;
import com.bytedance.lark.pb.ugreach.v1.ReachPointRelation;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes38.dex */
public final class d {
    public static void a(ReachPointEntity r100, StringBuilder r101) {
        int r102 = r101.length();
        if (r100.reach_point_id == null) goto L6;
        r101.append(", reach_point_id = ");
        r101.append(r100.reach_point_id);
    L6:
        if (r100.scenario_id == null) goto L9;
        r101.append(", scenario_id = ");
        r101.append(r100.scenario_id);
    L9:
        if (r100.type == null) goto L12;
        r101.append(", type = ");
        r101.append(r100.type);
    L12:
        if (r100.config == null) goto L44;
        r101.append(", config = ");
        ReachPointConfig r103 = r100.config;
        int r104 = r101.length();
        if (r103.relation == null) goto L38;
        r101.append(", relation = ");
        ReachPointRelation r105 = r103.relation;
        int r106 = r101.length();
        if (r105.parent_id == null) goto L19;
        r101.append(", parent_id=");
        r101.append(r105.parent_id);
    L19:
        if (r105.child_ids == null) goto L22;
        r101.append(", child_ids=");
        r101.append(r105.child_ids.toString());
    L22:
        if (r105.is_conflict == null) goto L25;
        r101.append(", is_conflict=");
        r101.append(r105.is_conflict);
    L25:
        if (r105.priority == null) goto L28;
        r101.append(", priority=");
        r101.append(r105.priority);
    L28:
        if (r105.need_grab == null) goto L31;
        r101.append(", need_grab=");
        r101.append(r105.need_grab);
    L31:
        if (r105.ttl == null) goto L34;
        r101.append(", ttl=");
        r101.append(r105.ttl);
    L34:
        if (r105.defense_strategy == null) goto L36;
        r101.append(", defense_strategy=");
        r101.append(r105.defense_strategy);
    L36:
        r101.replace(r106, r106 + 2, "ReachPointRelation{ ").append(i.f25855d);
    L38:
        if (r103.data_strategy == null) goto L41;
        r101.append(", data_strategy = ");
        r101.append(r103.data_strategy);
    L41:
        if (r103.cache_period == null) goto L43;
        r101.append(", cache_period = ");
        r101.append(r103.cache_period);
    L43:
        r101.replace(r104, r104 + 2, "ReachPointConfig{").append(i.f25855d);
    L44:
        List<ReachPointMaterial> r107 = r100.material;
        if (r107 == null) goto L62;
        r101.append("[");
        Iterator<ReachPointMaterial> r108 = r107.iterator();
    L48:
        if (r108.hasNext() == false) goto L61;
        ReachPointMaterial r109 = r108.next();
        if (r109 == null) goto L48;
        int r110 = r101.length();
        if (r109.material_id == null) goto L55;
        r101.append(", material_id = ");
        r101.append(r109.material_id);
    L55:
        if (r109.material_key == null) goto L58;
        r101.append(", material_key = ");
        r101.append(r109.material_key);
    L58:
        if (r109.material == null) goto L60;
        r101.append(", material = ");
        r101.append(r109.material);
    L60:
        r101.replace(r110, r110 + 2, "ReachPointMaterial{").append(i.f25855d);
        goto L48
    L61:
        r101.append("]");
    L62:
        r101.replace(r102, r102 + 2, "ReachPointEntity{").append(i.f25855d);
    }
}
