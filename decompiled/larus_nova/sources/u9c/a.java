package u9c;

import com.ss.android.lark.ug.scheduler.rule.entity.DefaultAction;
import com.ss.android.lark.ug.scheduler.rule.entity.MetaRule;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import v9c.e;

/* JADX INFO: loaded from: classes38.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<String, MetaRule> f549218a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Map<String, Map<String, MetaRule>> f549219b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Map<MetaRule, e> f549220c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final s9c.a f549221d = null;

    static {
        f549218a = new ConcurrentHashMap();
        f549219b = new ConcurrentHashMap();
        f549221d = new s9c.a();
        DefaultAction[] r100 = DefaultAction.values();
        int r101 = r100.length;
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L5;
        DefaultAction r103 = r100[r102];
        ((ConcurrentHashMap) f549218a).put(r103.getEvent(), r103.getMetaRule());
        r102 = r102 + 1;
        goto L3
    L5:
        MetaRule r104 = MetaRule.COUNT;
        s9c.a r105 = f549221d;
        f549220c = MapsKt.mapOf(new Pair[]{TuplesKt.to(r104, new v9c.c(r105)), TuplesKt.to(MetaRule.DURATION, new v9c.d(r105)), TuplesKt.to(MetaRule.CONTENT, new v9c.b(r105))});
    }
}
