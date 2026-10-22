package bu7;

import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import eu7.b;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public final class a {
    public static final Map<String, b> a = null;

    public a() {
    }

    static {
        a = new LinkedHashMap();
    }

    public static void b(String r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "info");
        Intrinsics.checkNotNullParameter(r4, "extra");
        FLogger.a.i("Performance-infra", a(r3, -1, r4).toString());
    }

    public static eu7.a a(String r12, long r13, String r15) {
        String r4 = ThreadMethodProxy.currentThread().getName();
        com.flow.performance.perflog.scenario.b.a.getClass();
        return new eu7.a(r12, r13, r4, com.flow.performance.perflog.scenario.b.f, com.flow.performance.perflog.scenario.b.d, com.flow.performance.perflog.scenario.b.c, com.flow.performance.perflog.scenario.b.g, r15);
    }
}
