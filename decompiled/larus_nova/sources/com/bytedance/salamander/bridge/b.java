package com.bytedance.salamander.bridge;

import com.bytedance.salamander.anniex.o3;
import com.bytedance.salamander.anniex.p3;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseResultModel;
import java.util.LinkedHashMap;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes20.dex */
public final class b implements CompletionBlock<ve7.b.c> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function1<o3, Unit> f268550a;

    /* JADX WARN: Multi-variable type inference failed */
    public b(Function1<? super o3, Unit> r100) {
        this.f268550a = r100;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock
    public final /* bridge */ /* synthetic */ void onRawSuccess(XBaseResultModel r100) {
        ve7.b.c r101 = (ve7.b.c) r100;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock
    public final void onSuccess(XBaseResultModel r100, String r101) {
        ve7.b.c r102 = (ve7.b.c) r100;
        Intrinsics.checkNotNullParameter(r102, "result");
        Intrinsics.checkNotNullParameter(r101, "msg");
        if (r102.convert() != null) goto L5;
        new LinkedHashMap();
    L5:
        this.f268550a.invoke(new o3(1, r101, new p3(r102.getData())));
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock
    public final void onFailure(int r100, String r101, XBaseResultModel r102) {
        ve7.b.c r103 = (ve7.b.c) r102;
        Intrinsics.checkNotNullParameter(r101, "msg");
        this.f268550a.invoke(new o3(0, r101, null));
    }
}
