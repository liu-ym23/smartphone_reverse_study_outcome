package com.bytedance.salamander.bridge;

import com.bytedance.salamander.anniex.j4;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseResultModel;
import java.util.LinkedHashMap;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes20.dex */
public final class p implements CompletionBlock<af7.g.c> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function1<j4, Unit> f268578a;

    /* JADX WARN: Multi-variable type inference failed */
    public p(Function1<? super j4, Unit> r100) {
        this.f268578a = r100;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock
    public final /* bridge */ /* synthetic */ void onRawSuccess(XBaseResultModel r100) {
        af7.g.c r101 = (af7.g.c) r100;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock
    public final void onSuccess(XBaseResultModel r100, String r101) {
        af7.g.c r102 = (af7.g.c) r100;
        Intrinsics.checkNotNullParameter(r102, "result");
        Intrinsics.checkNotNullParameter(r101, "msg");
        if (r102.convert() != null) goto L5;
        new LinkedHashMap();
    L5:
        this.f268578a.invoke(new j4(r101));
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock
    public final void onFailure(int r100, String r101, XBaseResultModel r102) {
        af7.g.c r103 = (af7.g.c) r102;
        Intrinsics.checkNotNullParameter(r101, "msg");
        this.f268578a.invoke(new j4(r101, 0));
    }
}
