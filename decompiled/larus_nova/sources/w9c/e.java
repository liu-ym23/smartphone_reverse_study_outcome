package w9c;

import com.alipay.sdk.m.u.i;
import com.bytedance.lark.pb.ugreach.v1.RuleExpression;

/* JADX INFO: loaded from: classes38.dex */
public final class e {
    public static void a(RuleExpression r100, StringBuilder r101) {
        int r102 = r101.length();
        if (r100.left == null) goto L6;
        r101.append(", left = ");
        a(r100.left, r101);
    L6:
        if (r100.right == null) goto L9;
        r101.append(", right = ");
        a(r100.right, r101);
    L9:
        if (r100.rule_action == null) goto L12;
        r101.append(", rule_action = ");
        r101.append(r100.rule_action);
    L12:
        if (r100.value == null) goto L15;
        r101.append(", value = ");
        r101.append(r100.value);
    L15:
        if (r100.exp_operator == null) goto L18;
        r101.append(", exp_operator=");
        r101.append(r100.exp_operator);
    L18:
        if (r100.cond_operator == null) goto L20;
        r101.append(", cond_operator=");
        r101.append(r100.cond_operator);
    L20:
        r101.replace(r102, r102 + 2, "RuleExpression{ ").append(i.f25855d);
    }
}
