package w9c;

import com.alipay.sdk.m.u.i;
import com.bytedance.lark.pb.ugreach.v1.LocalRule;

/* JADX INFO: loaded from: classes38.dex */
public final class b {
    public static void a(LocalRule r100, StringBuilder r101) {
        int r102 = r101.length();
        if (r100.rule_id == null) goto L6;
        r101.append(", rule_id=");
        r101.append(r100.rule_id);
    L6:
        if (r100.root_exp_node == null) goto L8;
        r101.append(", root_exp_node=");
        e.a(r100.root_exp_node, r101);
    L8:
        r101.replace(r102, r102 + 2, "LocalRule{ ").append(i.f25855d);
    }
}
