package com.bytedance.awemeopen.apps.photo.presenter;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class s implements q24.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ q f198018a;

    public s(q r100) {
        this.f198018a = r100;
    }

    @Override // com.bytedance.awemeopen.domain.digg.f
    public final void a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "aid");
        if (Intrinsics.areEqual(r100, this.f198018a.f198005d.f1366a.c()) == false) goto L6;
        this.f198018a.n();
        return;
    }
}
