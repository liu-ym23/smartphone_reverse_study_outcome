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

/* JADX INFO: loaded from: classes13.dex */
public abstract class a extends c implements com.bytedance.sdk.xbridge.cn.protocol.h {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final d f532719c;

    public abstract void e(IBDXBridgeContext r100, d r101, Map<String, ? extends Object> r102, IDLXBridgeMethod.a r103);

    @Override // com.bytedance.sdk.xbridge.cn.protocol.h
    public final void release() {
    }

    public a(d r100) {
        Intrinsics.checkNotNullParameter(r100, "mallJsbContext");
        this.f532719c = r100;
    }

    public final void c(IDLXBridgeMethod.a r100, Map<String, ? extends Object> r101) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        Intrinsics.checkNotNullParameter(r101, "result");
        r100.invoke(MapsKt.mapOf(new Pair[]{TuplesKt.to("code", 0), TuplesKt.to("data", r101)}));
    }

    public final void f(IDLXBridgeMethod.a r100, Map<String, ? extends Object> r101) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        Intrinsics.checkNotNullParameter(r101, "result");
        r100.invoke(MapsKt.mapOf(new Pair[]{TuplesKt.to("code", 1), TuplesKt.to("data", r101)}));
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final void realHandle(IBDXBridgeContext r100, Map<String, ? extends Object> r101, IDLXBridgeMethod.a r102) {
        Intrinsics.checkNotNullParameter(r100, "bridgeContext");
        Intrinsics.checkNotNullParameter(r101, "params");
        Intrinsics.checkNotNullParameter(r102, "callback");
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L5
        a(r101, MapsKt.emptyMap());     // Catch: Throwable -> L5
        e(r100, this.f532719c, r101, r102);     // Catch: Throwable -> L5
        Object r104 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L5
    L7:
        Throwable r105 = Result.m9452exceptionOrNullimpl(r104);
        if (r105 == null) goto L13;
        LinkedHashMap r106 = new LinkedHashMap();
        c.b(r106, r105.toString());
        c(r102, r106);
        return;
    L13:
        return;
    L5:
        th = move-exception;
        Result.Companion r107 = Result.Companion;
        r104 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L7
    }
}
