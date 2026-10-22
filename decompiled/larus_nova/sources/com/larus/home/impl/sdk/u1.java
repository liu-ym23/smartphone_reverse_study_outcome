package com.larus.home.impl.sdk;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public final class u1 implements yk9.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.larus.platform.api.z f346249a;

    public u1(com.larus.office.card.minutes.model.j r100) {
        this.f346249a = r100;
    }

    @Override // yk9.b
    public final void onSuccess(String r100) {
        Intrinsics.checkNotNullParameter(r100, "recordingId");
        this.f346249a.onSuccess(r100);
    }

    @Override // yk9.b
    public final void onFail(int r100, String r101) {
        this.f346249a.onFail(r100, r101);
    }
}
