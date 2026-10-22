package com.bytedance.locallife.bridge.common.method;

import com.bytedance.ies.xbridge.model.idl.CompletionBlock;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class i0 implements kt6.h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CompletionBlock<ko6.a0.c> f257072a;

    @Override // kt6.h
    public final void onPermissionGranted() {
        Intrinsics.checkNotNullParameter(ko6.a0.c.class, "<this>");
        ko6.a0.c r100 = (ko6.a0.c) com.bytedance.ies.xbridge.utils.g.c(ko6.a0.c.class);
        r100.setAllow(Boolean.TRUE);
        CompletionBlock.a.b(this.f257072a, r100);
    }

    public i0(v56.a r100) {
        this.f257072a = r100;
    }

    @Override // kt6.h
    public final void a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "errorMsg");
        Intrinsics.checkNotNullParameter(ko6.a0.f.class, "<this>");
        ko6.a0.f r101 = (ko6.a0.f) com.bytedance.ies.xbridge.utils.g.c(ko6.a0.f.class);
        r101.setErrorCode(0);
        r101.setErrorDesc(r100);
        Intrinsics.checkNotNullParameter(ko6.a0.c.class, "<this>");
        ko6.a0.c r102 = (ko6.a0.c) com.bytedance.ies.xbridge.utils.g.c(ko6.a0.c.class);
        r102.setAllow(Boolean.FALSE);
        r102.setError(r101);
        CompletionBlock.a.b(this.f257072a, r102);
    }
}
