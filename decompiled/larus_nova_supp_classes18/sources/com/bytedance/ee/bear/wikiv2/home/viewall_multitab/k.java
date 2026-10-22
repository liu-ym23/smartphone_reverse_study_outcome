package com.bytedance.ee.bear.wikiv2.home.viewall_multitab;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class k implements gqa.b {
    public final /* synthetic */ WikiSpaceListView a;

    public k(WikiSpaceListView r1) {
        this.a = r1;
    }

    public final void O0(cqa.h r2) {
        Intrinsics.checkNotNullParameter(r2, "it");
        WikiSpaceListViewModel r3 = this.a.f;
        if (r3 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r3 = null;
    L5:
        r3.loadmore();
    }
}
