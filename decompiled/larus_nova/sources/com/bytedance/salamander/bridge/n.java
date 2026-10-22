package com.bytedance.salamander.bridge;

import com.bytedance.salamander.anniex.h4;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseResultModel;
import java.util.LinkedHashMap;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes20.dex */
public final class n implements CompletionBlock<ve7.d.c> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function1<h4, Unit> f268576a;

    /* JADX WARN: Multi-variable type inference failed */
    public n(Function1<? super h4, Unit> r100) {
        this.f268576a = r100;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock
    public final /* bridge */ /* synthetic */ void onRawSuccess(XBaseResultModel r100) {
        ve7.d.c r101 = (ve7.d.c) r100;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock
    public final void onSuccess(XBaseResultModel r100, String r101) {
        ve7.d.c r102 = (ve7.d.c) r100;
        Intrinsics.checkNotNullParameter(r102, "result");
        Intrinsics.checkNotNullParameter(r101, "msg");
        if (r102.convert() != null) goto L5;
        new LinkedHashMap();
    L5:
        this.f268576a.invoke(new h4(r101));
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock
    public final void onFailure(int r100, String r101, XBaseResultModel r102) {
        ve7.d.c r103 = (ve7.d.c) r102;
        Intrinsics.checkNotNullParameter(r101, "msg");
        this.f268576a.invoke(new h4(r101, 0));
    }
}
