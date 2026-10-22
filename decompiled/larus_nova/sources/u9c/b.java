package u9c;

import com.ss.android.lark.ug.scheduler.common.exception.RuleException;
import com.ss.android.lark.ug.scheduler.common.exception.RuleMetricErrorInfo;
import com.ss.android.lark.ug.scheduler.rule.entity.MetaRule;
import com.ss.android.lark.ug.scheduler.rule.entity.RuleExpression;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;
import v9c.e;

/* JADX INFO: loaded from: classes38.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f549222a = 0;

    static {
    }

    public static boolean a(RuleExpression r100, q9c.a r101) {
        RuleExpression r102 = r100.f444506c;
        if (r102 == null) goto L5;
    L8:
        if (r102 != null) goto L10;
    L16:
        if (r102 == null) goto L18;
        Intrinsics.checkNotNull(r102);
        return b(r102, r101);
    L18:
        RuleExpression r103 = r100.f444507d;
        Intrinsics.checkNotNull(r103);
        return b(r103, r101);
    L10:
        if (r100.f444507d == null) goto L16;
        Intrinsics.checkNotNull(r102);
        boolean r104 = a(r102, r101);
        RuleExpression r105 = r100.f444507d;
        Intrinsics.checkNotNull(r105);
        boolean r106 = a(r105, r101);
        RuleExpression.ConditionOperator r107 = r100.f444508e;
        if (r107 != null) goto L20;
        return false;
    L20:
        return r107.compare(r104, r106);
    L5:
        if (r100.f444507d != null) goto L8;
        return b(r100, r101);
    }

    public static boolean b(RuleExpression r100, q9c.a r101) {
        String r102 = r100.f444504a;
        if (r102 != null) goto L5;
    L8:
        boolean r103 = true;
    L10:
        if (r103 == true) goto L40;
        String r104 = r101.f532194a;
        String r105 = r100.f444504a;
        Intrinsics.checkNotNull(r105);
        q9c.a r106 = new q9c.a(r104, r105);
        Map<String, MetaRule> r107 = a.f549218a;
        Intrinsics.checkNotNullParameter(r106, "reachPointAction");
        MetaRule r108 = (MetaRule) ((ConcurrentHashMap) a.f549218a).get(r106.f532195b);
        if (r108 != null) goto L19;
        Map r109 = (Map) ((ConcurrentHashMap) a.f549219b).get(r106.f532194a);
        if (r109 == null) goto L16;
        r108 = (MetaRule) r109.get(r106.f532195b);
    L17:
        if (r108 != null) goto L19;
    L22:
        String r110 = null;
    L23:
        if (r110 == null) goto L25;
        String r111 = r100.f444505b;
        if (r111 == null) goto L38;
        RuleExpression.ExpressionOperator r112 = r100.f444509f;
        if (r112 == null) goto L36;
        return r112.compare(r110, r111);
    L36:
        throw new RuleException(RuleMetricErrorInfo.MISS_EXP_OPERATOR, null, 2, null);
    L38:
        throw new RuleException(RuleMetricErrorInfo.ILLEGAL_THRESHOLD, null, 2, null);
    L25:
        if (Intrinsics.areEqual(r100.f444504a, r101.f532195b) == true) goto L28;
        return false;
    L28:
        throw new RuleException(RuleMetricErrorInfo.MISS_CURRENT_VALUE, null, 2, null);
    L16:
        r108 = null;
    L19:
        e r113 = a.f549220c.get(r108);
        if (r113 == null) goto L22;
        r110 = r113.a(r106);
        goto L23
    L40:
        throw new RuleException(RuleMetricErrorInfo.MISS_LEFT_RULE_ACTION, null, 2, null);
    L5:
        if (r102.length() == 0) goto L8;
        r103 = false;
        goto L10
    }
}
