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

/* JADX INFO: loaded from: classes18.dex */
public final class a<T1, T2, R> implements BiFunction {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f523301a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f523302b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f523303c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f523304d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ String f523305e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ boolean f523306f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final /* synthetic */ int f523307g;

    public a(String r100, int r101, String r102) {
        this.f523301a = r100;
        this.f523302b = r101;
        this.f523303c = "external_access";
        this.f523304d = 1;
        this.f523305e = r102;
        this.f523306f = false;
        this.f523307g = 1;
    }

    @Override // io.reactivex.functions.BiFunction
    public final Object apply(Object r110, Object r111) {
        EscapeRuleResult r112 = (EscapeRuleResult) r110;
        InstanceListResult r113 = (InstanceListResult) r111;
        Toast.cancelLoading();
        if (r112 == null) goto L7;
        if (r113 == null) goto L7;
        return new Pair(new EscapeRuleBean(this.f523301a, this.f523302b, this.f523303c, new ApprovalDef(r112.getApprovalCode(), r112.getApprovalDetail(), r112.getReviewers(), r112.getCcUsers()), this.f523304d, this.f523305e, this.f523306f, this.f523307g), new EscapeApprovalInfo(this.f523301a, this.f523302b, new ApprovalList(r113.getInstances(), r113.getMyInstance())));
    L7:
        StringBuilder r100 = new StringBuilder("escapeRuleResult is null? ");
        boolean r101 = false;
        if (r112 != null) goto L10;
        boolean r114 = true;
    L11:
        r100.append(r114);
        r100.append(", instanceListResult is null? ");
        if (r113 != null) goto L14;
        r101 = true;
    L14:
        r100.append(r101);
        throw new Exception(r100.toString());
    L10:
        r114 = false;
        goto L11
    }
}
