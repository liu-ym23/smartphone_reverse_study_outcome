package com.bytedance.salamander.bridge;

import com.bytedance.salamander.anniex.z3;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseResultModel;
import java.util.LinkedHashMap;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes20.dex */
public final class j implements CompletionBlock<wd7.c.InterfaceC8096c> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function1<z3, Unit> f268559a;

    /* JADX WARN: Multi-variable type inference failed */
    public j(Function1<? super z3, Unit> r100) {
        this.f268559a = r100;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock
    public final /* bridge */ /* synthetic */ void onRawSuccess(XBaseResultModel r100) {
        wd7.c.InterfaceC8096c r101 = (wd7.c.InterfaceC8096c) r100;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock
    public final void onSuccess(XBaseResultModel r100, String r101) {
        wd7.c.InterfaceC8096c r102 = (wd7.c.InterfaceC8096c) r100;
        Intrinsics.checkNotNullParameter(r102, "result");
        Intrinsics.checkNotNullParameter(r101, "msg");
        if (r102.convert() != null) goto L5;
        new LinkedHashMap();
    L5:
        this.f268559a.invoke(new z3(r101));
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock
    public final void onFailure(int r100, String r101, XBaseResultModel r102) {
        wd7.c.InterfaceC8096c r103 = (wd7.c.InterfaceC8096c) r102;
        Intrinsics.checkNotNullParameter(r101, "msg");
        this.f268559a.invoke(new z3(r101, 0));
    }
}
