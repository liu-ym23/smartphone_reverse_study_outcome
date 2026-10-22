package com.ivy.ivykit.plugin.impl.utils;

import com.bytedance.ies.xbridge.XBridgeMethod;
import com.bytedance.pia.core.api.bridge.PiaMethod;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes23.dex */
public final class v implements XBridgeMethod.Callback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ l47.a<Map<?, ?>> f278458a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ l47.a<PiaMethod.Error> f278459b;

    @Override // com.bytedance.ies.xbridge.XBridgeMethod.Callback
    public final void invoke(Map<String, Object> r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        l47.a<Map<?, ?>> r101 = this.f278458a;
        l47.a<PiaMethod.Error> r102 = this.f278459b;
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L16
        Object r104 = r100.get("code");     // Catch: Throwable -> L16
        Object r105 = r100.get("msg");     // Catch: Throwable -> L16
        Map<?, ?> r106 = null;
        if ((r105 instanceof String) == false) goto L6;
        String r107 = (String) r105;     // Catch: Throwable -> L16
    L8:
        if (Intrinsics.areEqual(r104, 1) == false) goto L13;
        Object r108 = r100.get("data");     // Catch: Throwable -> L16
        if ((r108 instanceof Map) == false) goto L12;
        r106 = (Map) r108;     // Catch: Throwable -> L16
    L12:
        r101.accept(r106);     // Catch: Throwable -> L16
    L14:
        Object r109 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L16
    L18:
        l47.a<PiaMethod.Error> r110 = this.f278459b;
        Throwable r111 = Result.m9452exceptionOrNullimpl(r109);
        if (r111 == null) goto L24;
        r110.accept(new PiaMethod.Error(r111.getMessage()));
        return;
    L24:
        return;
    L13:
        Intrinsics.checkNotNull(r104, "null cannot be cast to non-null type kotlin.Int");     // Catch: Throwable -> L16
        r102.accept(new PiaMethod.Error(((Integer) r104).intValue(), r107));     // Catch: Throwable -> L16
        goto L14
    L6:
        r107 = null;
    L16:
        th = move-exception;
        Result.Companion r112 = Result.Companion;
        r109 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L18
    }

    public v(m47.h r100, m47.i r101) {
        this.f278458a = r100;
        this.f278459b = r101;
    }
}
