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

/* JADX INFO: loaded from: classes13.dex */
public abstract class e extends c implements com.bytedance.sdk.xbridge.cn.protocol.h {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final d f532724c;

    public abstract Pair<Boolean, String> e(d r100, IBDXBridgeContext r101, Map<String, ? extends Object> r102, Map<String, Object> r103);

    public void release() {
    }

    public e(d r100) {
        Intrinsics.checkNotNullParameter(r100, "mallJsbContext");
        this.f532724c = r100;
    }

    public static Pair c(String r100) {
        return TuplesKt.to(Boolean.FALSE, r100);
    }

    public static Pair f(e r100) {
        r100.getClass();
        return TuplesKt.to(Boolean.TRUE, null);
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public void realHandle(IBDXBridgeContext r100, Map<String, ? extends Object> r101, IDLXBridgeMethod.a r102) {
        Intrinsics.checkNotNullParameter(r100, "bridgeContext");
        Intrinsics.checkNotNullParameter(r101, "params");
        Intrinsics.checkNotNullParameter(r102, "callback");
        LinkedHashMap r103 = new LinkedHashMap();
        Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L5
        Object r105 = Result.m9449constructorimpl(e(this.f532724c, r100, r101, r103));     // Catch: Throwable -> L5
    L7:
        Throwable r106 = Result.m9452exceptionOrNullimpl(r105);
        if (r106 == null) goto L10;
        String r107 = r106.toString();
    L12:
        if (Result.m9455isFailureimpl(r105) == false) goto L14;
        r105 = null;
    L14:
        Pair r108 = (Pair) r105;
        if (r108 != null) goto L17;
        r108 = new Pair(Boolean.FALSE, "ECMallStatefulJsb Error: " + r107);
    L17:
        boolean r109 = ((Boolean) r108.component1()).booleanValue();
        String r110 = (String) r108.component2();
        Pair[] r111 = new Pair[3];
        r111[0] = TuplesKt.to("code", Integer.valueOf(r109 ? 1 : 0));
        if (r110 != null) goto L20;
        r110 = "";
    L20:
        r111[1] = TuplesKt.to("msg", r110);
        r111[2] = TuplesKt.to("data", r103);
        Map<String, ? extends Object> r112 = MapsKt.mapOf(r111);
        a(r101, r112);
        r102.invoke(r112);
        return;
    L10:
        r107 = null;
    L5:
        th = move-exception;
        Result.Companion r113 = Result.Companion;
        r105 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L7
    }
}
