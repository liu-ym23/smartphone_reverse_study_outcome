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
public abstract class a extends c implements com.bytedance.sdk.xbridge.cn.protocol.h {
    public final d c;

    public abstract void e(IBDXBridgeContext r1, d r2, Map<String, ? extends Object> r3, IDLXBridgeMethod.a r4);

    public final void release() {
    }

    public a(d r2) {
        Intrinsics.checkNotNullParameter(r2, "mallJsbContext");
        this.c = r2;
    }

    public final void c(IDLXBridgeMethod.a r5, Map<String, ? extends Object> r6) {
        Intrinsics.checkNotNullParameter(r5, "callback");
        Intrinsics.checkNotNullParameter(r6, "result");
        r5.invoke(MapsKt.mapOf(new Pair[]{TuplesKt.to("code", 0), TuplesKt.to("data", r6)}));
    }

    public final void f(IDLXBridgeMethod.a r5, Map<String, ? extends Object> r6) {
        Intrinsics.checkNotNullParameter(r5, "callback");
        Intrinsics.checkNotNullParameter(r6, "result");
        r5.invoke(MapsKt.mapOf(new Pair[]{TuplesKt.to("code", 1), TuplesKt.to("data", r6)}));
    }

    public final void realHandle(IBDXBridgeContext r2, Map<String, ? extends Object> r3, IDLXBridgeMethod.a r4) {
        Intrinsics.checkNotNullParameter(r2, "bridgeContext");
        Intrinsics.checkNotNullParameter(r3, "params");
        Intrinsics.checkNotNullParameter(r4, "callback");
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L5
        a(r3, MapsKt.emptyMap());     // Catch: Throwable -> L5
        e(r2, this.c, r3, r4);     // Catch: Throwable -> L5
        Object r5 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L5
    L7:
        Throwable r6 = Result.exceptionOrNull-impl(r5);
        if (r6 == null) goto L13;
        LinkedHashMap r7 = new LinkedHashMap();
        c.b(r7, r6.toString());
        c(r4, r7);
        return;
    L13:
        return;
    L5:
        th = move-exception;
        Result.Companion r8 = Result.Companion;
        r5 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L7
    }
}
