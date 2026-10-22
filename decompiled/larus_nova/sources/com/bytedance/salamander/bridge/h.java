package com.bytedance.salamander.bridge;

import com.bytedance.salamander.anniex.x3;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseResultModel;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes20.dex */
public final class h implements CompletionBlock<oe7.a.c> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function1<x3, Unit> f268557a;

    /* JADX WARN: Multi-variable type inference failed */
    public h(Function1<? super x3, Unit> r100) {
        this.f268557a = r100;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock
    public final /* bridge */ /* synthetic */ void onRawSuccess(XBaseResultModel r100) {
        oe7.a.c r101 = (oe7.a.c) r100;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock
    public final void onSuccess(XBaseResultModel r100, String r101) {
        Intrinsics.checkNotNullParameter((oe7.a.c) r100, "result");
        Intrinsics.checkNotNullParameter(r101, "msg");
        this.f268557a.invoke(new x3(r101));
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock
    public final void onFailure(int r100, String r101, XBaseResultModel r102) {
        oe7.a.c r103 = (oe7.a.c) r102;
        Intrinsics.checkNotNullParameter(r101, "msg");
        this.f268557a.invoke(new x3(r101, 0));
    }
}
