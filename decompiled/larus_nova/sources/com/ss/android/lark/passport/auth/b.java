package com.ss.android.lark.passport.auth;

import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
@Singleton
public final class b implements e {
    @Inject
    public b() {
    }

    @Override // com.ss.android.lark.passport.auth.e
    public final a a(String r100, com.ss.android.lark.player.player.g r101, com.ss.android.lark.player.player.f r102) {
        Intrinsics.checkNotNullParameter(r100, "userId");
        Intrinsics.checkNotNullParameter(r101, "build");
        Intrinsics.checkNotNullParameter(r102, "onHeadersChanged");
        return new a(r101, r102);
    }
}
