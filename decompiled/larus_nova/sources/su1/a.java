package su1;

import com.bytedance.android.livesdk.dynamicstrategy.impl.express.exception.SimpleExpressException;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class a implements e {
    public a() {
    }

    public final boolean b(qu1.a r100) {
        if (r100.f534837a.isEmpty() == true) goto L11;
        Object r101 = ((LinkedList) r100.f534837a).pop();
        if ((r101 instanceof Boolean) == false) goto L9;
        return ((Boolean) r101).booleanValue();
    L9:
        throw new SimpleExpressException("express execute failed, and operation value is " + r101, null, 2, null);
    L11:
        throw new SimpleExpressException("express execute failed, and operation value is null", null, 2, null);
    }

    @Override // su1.e
    public final void a(qu1.a r100, Map<String, ? extends Object> r101) {
        Intrinsics.checkNotNullParameter(r100, "environment");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        boolean r102 = b(r100);
        boolean r103 = b(r100);
        Deque<Object> r104 = r100.f534837a;
        if (r103 == false) goto L6;
        if (r102 == false) goto L6;
        boolean r105 = true;
    L7:
        LinkedList r106 = (LinkedList) r104;
        r106.push(Boolean.valueOf(r105));
        return;
    L6:
        r105 = false;
        goto L7
    }
}
