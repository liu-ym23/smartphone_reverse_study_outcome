package com.lark.kmp.rustclient.internal;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class b implements com.lark.kmp.rustclient.api.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f282548a;

    public b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "scopeUserId");
        this.f282548a = r100;
    }

    @Override // com.lark.kmp.rustclient.api.c
    public final boolean a(rpc.c r100) {
        Intrinsics.checkNotNullParameter(r100, "push");
        String r101 = this.f282548a;
        rpc.a r102 = a.f282546a;
        Intrinsics.checkNotNullParameter(r101, "userId");
        return Intrinsics.areEqual(r101, "absent_user");
    }
}
