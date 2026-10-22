package com.larus.xbridge.custom;

import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes32.dex */
public final /* synthetic */ class f0 implements Function1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CompletionBlock f379743a;

    public /* synthetic */ f0(CompletionBlock r100) {
        this.f379743a = r100;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object r100) {
        CompletionBlock r101 = this.f379743a;
        boolean r102 = ((Boolean) r100).booleanValue();
        g0.a r103 = (g0.a) ne7.e.b(g0.a.class);
        r103.setSuccess(r102);
        CompletionBlock.DefaultImpls.onSuccess$default(r101, r103, null, 2, null);
        return Unit.INSTANCE;
    }
}
