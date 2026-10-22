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
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, com.ss.android.lark.ug.scheduler.rule.entity.a> f549224a;

    public static final class a {
    }

    static {
    }

    public d() {
        this.f549224a = new ConcurrentHashMap();
    }

    public final boolean a(q9c.a r100, com.ss.android.lark.ug.scheduler.rule.entity.a r101) {
        Intrinsics.checkNotNullParameter(r100, "reachPointAction");
        RuleExpression r102 = r101.f444517a;
        if (r102 != null) goto L6;
        com.ss.android.lark.ug.scheduler.common.service.a r103 = com.ss.android.lark.ug.scheduler.common.service.b.f444469a;
        com.ss.android.lark.ug.scheduler.common.service.b.f444469a.c("UGScheduler-RuleService", "handleEvent -> cannot find rule for " + r100.f532194a);
        return false;
    L6:
        int r104 = b.f549222a;
        Intrinsics.checkNotNullParameter(r102, "ruleExpression");
        Intrinsics.checkNotNullParameter(r100, "reachPointAction");
        Map<String, MetaRule> r105 = u9c.a.f549218a;
        Intrinsics.checkNotNullParameter(r100, "reachPointAction");
        MetaRule r106 = (MetaRule) ((ConcurrentHashMap) u9c.a.f549218a).get(r100.f532195b);
        if (r106 != null) goto L16;
        Map r107 = (Map) ((ConcurrentHashMap) u9c.a.f549219b).get(r100.f532194a);
        if (r107 == null) goto L11;
        r106 = (MetaRule) r107.get(r100.f532195b);
    L12:
        if (r106 != null) goto L16;
        throw new RuleException(RuleMetricErrorInfo.MISS_META_RULE, null, 2, null);
    L11:
        r106 = null;
    L16:
        e r108 = u9c.a.f549220c.get(r106);
        if (r108 == null) goto L20;
        r108.update(r100);
    L20:
        return b.a(r102, r100);
    }
}
