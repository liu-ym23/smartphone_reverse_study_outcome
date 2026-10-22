package com.bytedance.salamander.bridge;

import com.bytedance.salamander.anniex.u3;
import com.bytedance.salamander.anniex.v3;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseResultModel;
import java.util.LinkedHashMap;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes20.dex */
public final class f implements CompletionBlock<jd7.b.c> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function1<u3, Unit> f268555a;

    /* JADX WARN: Multi-variable type inference failed */
    public f(Function1<? super u3, Unit> r100) {
        this.f268555a = r100;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock
    public final /* bridge */ /* synthetic */ void onRawSuccess(XBaseResultModel r100) {
        jd7.b.c r101 = (jd7.b.c) r100;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock
    public final void onSuccess(XBaseResultModel r100, String r101) {
        jd7.b.c r102 = (jd7.b.c) r100;
        Intrinsics.checkNotNullParameter(r102, "result");
        Intrinsics.checkNotNullParameter(r101, "msg");
        if (r102.convert() != null) goto L5;
        new LinkedHashMap();
    L5:
        Function1<u3, Unit> r103 = this.f268555a;
        r102.getAlreadyLoggedIn();
        r103.invoke(new u3(1, r101, new v3(r102.getStatus())));
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock
    public final void onFailure(int r100, String r101, XBaseResultModel r102) {
        jd7.b.c r103 = (jd7.b.c) r102;
        Intrinsics.checkNotNullParameter(r101, "msg");
        this.f268555a.invoke(new u3(0, r101, null));
    }
}
