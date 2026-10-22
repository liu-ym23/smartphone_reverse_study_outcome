package com.bytedance.ies.bullet.web.pia;

import com.bytedance.pia.core.api.bridge.PiaMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes19.dex */
public final class n implements IDLXBridgeMethod.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ l47.a<Object> f248335a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ k f248336b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ k.b f248337c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ l47.a<PiaMethod.Error> f248338d;

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod.a
    public final void invoke(Map<String, ? extends Object> r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        l47.a<Object> r101 = this.f248335a;
        k r102 = this.f248336b;
        k.b r103 = this.f248337c;
        Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L21
        Object r105 = r100.get("__jsb2__data__");     // Catch: Throwable -> L21
        if ((r105 instanceof JSONObject) == false) goto L7;
        JSONObject r106 = (JSONObject) r105;     // Catch: Throwable -> L21
    L9:
        if (r106 == null) goto L13;
        boolean r107 = true;
        if (r106.has("__data") != true) goto L13;
    L14:
        if (r107 == false) goto L16;
        JSONObject r108 = new JSONObject();     // Catch: Throwable -> L21
        r108.put("data", r106.get("__data"));     // Catch: Throwable -> L21
        r101.accept(r108);     // Catch: Throwable -> L21
    L19:
        Object r109 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L21
    L23:
        l47.a<PiaMethod.Error> r110 = this.f248338d;
        Throwable r111 = Result.m9452exceptionOrNullimpl(r109);
        if (r111 == null) goto L29;
        r110.accept(new PiaMethod.Error(r111.getMessage()));
        return;
    L29:
        return;
    L16:
        if (r106 == null) goto L18;
        r101.accept(r106);     // Catch: Throwable -> L21
        goto L19
    L18:
        Map<String, Boolean> r112 = be7.a.f18743a;     // Catch: Throwable -> L21
        r101.accept(be7.a.a(r102.f248324b, r103, r100));     // Catch: Throwable -> L21
    L13:
        r107 = false;
        goto L14
    L7:
        r106 = null;
    L21:
        th = move-exception;
        Result.Companion r113 = Result.Companion;
        r109 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L23
    }

    public n(m47.h r100, k r101, k.b r102, m47.i r103) {
        this.f248335a = r100;
        this.f248336b = r101;
        this.f248337c = r102;
        this.f248338d = r103;
    }
}
