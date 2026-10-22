package qf3;

import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public abstract class b extends c {
    public abstract void c(IBDXBridgeContext r1, Map<String, ? extends Object> r2, IDLXBridgeMethod.a r3);

    public b() {
    }

    public final void realHandle(IBDXBridgeContext r4, Map<String, ? extends Object> r5, IDLXBridgeMethod.a r6) {
        Intrinsics.checkNotNullParameter(r4, "bridgeContext");
        Intrinsics.checkNotNullParameter(r5, "params");
        Intrinsics.checkNotNullParameter(r6, "callback");
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L5
        a(r5, MapsKt.emptyMap());     // Catch: Throwable -> L5
        c(r4, r5, r6);     // Catch: Throwable -> L5
        Object r7 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L5
    L7:
        Throwable r8 = Result.exceptionOrNull-impl(r7);
        if (r8 == null) goto L13;
        LinkedHashMap r9 = new LinkedHashMap();
        c.b(r9, r8.toString());
        Intrinsics.checkNotNullParameter(r6, "callback");
        Intrinsics.checkNotNullParameter(r9, "result");
        r6.invoke(MapsKt.mapOf(new Pair[]{TuplesKt.to("code", 0), TuplesKt.to("data", r9)}));
        return;
    L13:
        return;
    L5:
        th = move-exception;
        Result.Companion r10 = Result.Companion;
        r7 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L7
    }
}
