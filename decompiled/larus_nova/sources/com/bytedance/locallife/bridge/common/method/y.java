package com.bytedance.locallife.bridge.common.method;

import com.bytedance.ies.xbridge.model.idl.CompletionBlock;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class y implements ut6.j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CompletionBlock<ko6.p.c> f257087a;

    public y(v56.a r100) {
        this.f257087a = r100;
    }

    @Override // ut6.j
    public final void onSuccess(String r100) {
        Intrinsics.checkNotNullParameter(r100, "msg");
        CompletionBlock.a.b(this.f257087a, new a(r100));
    }

    @Override // ut6.j
    public final void onFailure(int r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "msg");
        CompletionBlock.a.a(this.f257087a, r100, null, new a(r101), 2);
    }
}
