package com.bytedance.awemeopen.domain.user.login;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class b implements u64.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ u64.a f198512a;

    public b(f.b r100) {
        this.f198512a = r100;
    }

    @Override // u64.a
    public final void a(u64.b r100) {
        Intrinsics.checkNotNullParameter(r100, "result");
        u64.a r101 = this.f198512a;
        if (r101 == null) goto L5;
        r101.a(r100);
    L5:
        LoginHelper r102 = LoginHelper.f198497a;
        LoginHelper.b();
    }

    @Override // u64.a
    public final void onFail(int r100) {
        u64.a r101 = this.f198512a;
        if (r101 == null) goto L6;
        r101.onFail(r100);
        return;
    }
}
