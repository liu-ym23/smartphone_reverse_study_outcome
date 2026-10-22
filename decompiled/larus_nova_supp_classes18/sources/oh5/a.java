package oh5;

import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.middleground.permission.escape.model.ApprovalDef;
import com.bytedance.ee.bear.middleground.permission.escape.model.ApprovalList;
import com.bytedance.ee.bear.middleground.permission.escape.model.EscapeApprovalInfo;
import com.bytedance.ee.bear.middleground.permission.escape.model.EscapeRuleBean;
import com.bytedance.ee.bear.middleground.permission.escape.request.EscapeRuleResult;
import com.bytedance.ee.bear.middleground.permission.escape.request.InstanceListResult;
import io.reactivex.functions.BiFunction;
import kotlin.Pair;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class a<T1, T2, R> implements BiFunction {
    public final /* synthetic */ String a;
    public final /* synthetic */ int b;
    public final /* synthetic */ String c;
    public final /* synthetic */ int d;
    public final /* synthetic */ String e;
    public final /* synthetic */ boolean f;
    public final /* synthetic */ int g;

    public a(String r1, int r2, String r3) {
        this.a = r1;
        this.b = r2;
        this.c = "external_access";
        this.d = 1;
        this.e = r3;
        this.f = false;
        this.g = 1;
    }

    public final Object apply(Object r11, Object r12) {
        EscapeRuleResult r13 = (EscapeRuleResult) r11;
        InstanceListResult r14 = (InstanceListResult) r12;
        Toast.cancelLoading();
        if (r13 == null) goto L7;
        if (r14 == null) goto L7;
        return new Pair(new EscapeRuleBean(this.a, this.b, this.c, new ApprovalDef(r13.getApprovalCode(), r13.getApprovalDetail(), r13.getReviewers(), r13.getCcUsers()), this.d, this.e, this.f, this.g), new EscapeApprovalInfo(this.a, this.b, new ApprovalList(r14.getInstances(), r14.getMyInstance())));
    L7:
        StringBuilder r1 = new StringBuilder("escapeRuleResult is null? ");
        boolean r2 = false;
        if (r13 != null) goto L10;
        boolean r15 = true;
    L11:
        r1.append(r15);
        r1.append(", instanceListResult is null? ");
        if (r14 != null) goto L14;
        r2 = true;
    L14:
        r1.append(r2);
        throw new Exception(r1.toString());
    L10:
        r15 = false;
        goto L11
    }
}
