package com.larus.common.account.bdauth.repository;

import kotlin.Result;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class j implements n38.k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ kotlinx.coroutines.i<n38.b> f325951a;

    public j(kotlinx.coroutines.j r100) {
        this.f325951a = r100;
    }

    @Override // n38.k
    public final void a(n38.b r100) {
        Intrinsics.checkNotNullParameter(r100, "result");
        if (this.f325951a.isActive() == false) goto L6;
        this.f325951a.resumeWith(Result.m9449constructorimpl(r100));
        return;
    }

    @Override // n38.k
    public final void b(n38.b r100) {
        Intrinsics.checkNotNullParameter(r100, "result");
        if (this.f325951a.isActive() == false) goto L6;
        this.f325951a.resumeWith(Result.m9449constructorimpl(r100));
        return;
    }
}
