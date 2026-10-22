package com.bytedance.ee.bear.wikiv2.home.viewall_multitab;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class k implements gqa.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ WikiSpaceListView f240789a;

    public k(WikiSpaceListView r100) {
        this.f240789a = r100;
    }

    @Override // gqa.b
    public final void O0(cqa.h r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        WikiSpaceListViewModel r101 = this.f240789a.f240754f;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r101 = null;
    L5:
        r101.loadmore();
    }
}
