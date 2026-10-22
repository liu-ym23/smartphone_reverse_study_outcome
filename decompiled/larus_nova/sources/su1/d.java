package su1;

import com.bytedance.android.livesdk.dynamicstrategy.impl.express.exception.SimpleExpressException;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.LinkedList;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class d implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f543588a;

    public d(String r100) {
        Intrinsics.checkNotNullParameter(r100, "name");
        this.f543588a = r100;
    }

    @Override // su1.e
    public final void a(qu1.a r100, Map<String, ? extends Object> r101) {
        Intrinsics.checkNotNullParameter(r100, "environment");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        Object r102 = r101.get(this.f543588a);
        if (r102 == null) goto L7;
        ((LinkedList) r100.f534837a).push(r102);
        return;
    L7:
        throw new SimpleExpressException("express execute failed, param[" + this.f543588a + "] is null", null, 2, null);
    }
}
