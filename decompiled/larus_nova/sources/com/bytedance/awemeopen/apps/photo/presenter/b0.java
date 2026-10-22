package com.bytedance.awemeopen.apps.photo.presenter;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class b0 implements o24.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c0 f197942a;

    public b0(c0 r100) {
        this.f197942a = r100;
    }

    @Override // com.bytedance.awemeopen.domain.collect.e
    public final void onChange(String r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "aid");
        if (Intrinsics.areEqual(r100, this.f197942a.f197945d.f1366a.c()) == false) goto L6;
        this.f197942a.m();
        return;
    }
}
