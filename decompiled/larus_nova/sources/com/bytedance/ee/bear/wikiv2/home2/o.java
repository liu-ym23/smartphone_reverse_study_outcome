package com.bytedance.ee.bear.wikiv2.home2;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class o implements gqa.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ k f240943a;

    public o(k r100) {
        this.f240943a = r100;
    }

    @Override // gqa.b
    public final void O0(cqa.h r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        k.b r101 = this.f240943a.f240853m;
        if (r101 == null) goto L6;
        r101.onLoadMore();
        return;
    }
}
