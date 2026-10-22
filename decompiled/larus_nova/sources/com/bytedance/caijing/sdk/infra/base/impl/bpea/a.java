package com.bytedance.caijing.sdk.infra.base.impl.bpea;

import com.bytedance.caijing.sdk.infra.base.api.bpea.BpeaService;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class a implements InvocationHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BpeaService.a f202369a;

    public a(BpeaService.a r100) {
        this.f202369a = r100;
    }

    @Override // java.lang.reflect.InvocationHandler
    public final Object invoke(Object r100, Method r101, Object[] r102) {
        Object r103 = r102[0];
        Intrinsics.checkNotNull(r103, "null cannot be cast to non-null type kotlin.Boolean");
        boolean r104 = ((Boolean) r103).booleanValue();
        Object r105 = r102[1];
        Intrinsics.checkNotNull(r105, "null cannot be cast to non-null type kotlin.collections.List<kotlin.String>");
        List<String> r106 = (List) r105;
        Object r107 = r102[2];
        Intrinsics.checkNotNull(r107, "null cannot be cast to non-null type kotlin.collections.List<kotlin.String>");
        List<String> r108 = (List) r107;
        BpeaService.a r109 = this.f202369a;
        if (r109 == null) goto L5;
        r109.onEzPermissionResult(r104, r106, r108);
        return Unit.INSTANCE;
    L5:
        return null;
    }
}
