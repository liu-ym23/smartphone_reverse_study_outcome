package com.bytedance.ee.bear.wikiv2.home2;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class n implements gqa.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ k f240942a;

    public n(k r100) {
        this.f240942a = r100;
    }

    @Override // gqa.d
    public final void d2(cqa.h r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        k.b r101 = this.f240942a.f240853m;
        if (r101 == null) goto L6;
        r101.onRefresh();
        return;
    }
}
