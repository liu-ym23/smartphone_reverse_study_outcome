package qf3;

import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public abstract class e extends c implements com.bytedance.sdk.xbridge.cn.protocol.h {
    public final d c;

    public abstract Pair<Boolean, String> e(d r1, IBDXBridgeContext r2, Map<String, ? extends Object> r3, Map<String, Object> r4);

    public void release() {
    }

    public e(d r2) {
        Intrinsics.checkNotNullParameter(r2, "mallJsbContext");
        this.c = r2;
    }

    public static Pair c(String r1) {
        return TuplesKt.to(Boolean.FALSE, r1);
    }

    public static Pair f(e r1) {
        r1.getClass();
        return TuplesKt.to(Boolean.TRUE, null);
    }

    public void realHandle(IBDXBridgeContext r6, Map<String, ? extends Object> r7, IDLXBridgeMethod.a r8) {
        Intrinsics.checkNotNullParameter(r6, "bridgeContext");
        Intrinsics.checkNotNullParameter(r7, "params");
        Intrinsics.checkNotNullParameter(r8, "callback");
        LinkedHashMap r0 = new LinkedHashMap();
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L5
        Object r9 = Result.constructor-impl(e(this.c, r6, r7, r0));     // Catch: Throwable -> L5
    L7:
        Throwable r2 = Result.exceptionOrNull-impl(r9);
        if (r2 == null) goto L10;
        String r3 = r2.toString();
    L12:
        if (Result.isFailure-impl(r9) == false) goto L14;
        r9 = null;
    L14:
        Pair r10 = (Pair) r9;
        if (r10 != null) goto L17;
        r10 = new Pair(Boolean.FALSE, "ECMallStatefulJsb Error: " + r3);
    L17:
        boolean r4 = ((Boolean) r10.component1()).booleanValue();
        String r11 = (String) r10.component2();
        Pair[] r5 = new Pair[3];
        r5[0] = TuplesKt.to("code", Integer.valueOf(r4 ? 1 : 0));
        if (r11 != null) goto L20;
        r11 = "";
    L20:
        r5[1] = TuplesKt.to("msg", r11);
        r5[2] = TuplesKt.to("data", r0);
        Map<String, ? extends Object> r12 = MapsKt.mapOf(r5);
        a(r7, r12);
        r8.invoke(r12);
        return;
    L10:
        r3 = null;
    L5:
        th = move-exception;
        Result.Companion r13 = Result.Companion;
        r9 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L7
    }
}
