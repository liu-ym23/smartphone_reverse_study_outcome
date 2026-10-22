package com.ss.android.lark.passportc.api;

import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class u implements p {
    @Inject
    public u() {
    }

    @Override // com.ss.android.lark.passportc.api.n
    public final void afterUserChanged(f0c.g r100, f0c.b r101) {
        Intrinsics.checkNotNullParameter(r101, "currentState");
    }

    @Override // com.ss.android.lark.passportc.api.n
    public final void afterUserOffline(f0c.e r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
    }

    @Override // com.ss.android.lark.passportc.api.n
    public final void afterUserOnline(f0c.f r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
    }

    @Override // com.ss.android.lark.passportc.api.n
    public final void onUserChanged(f0c.g r100, f0c.b r101) {
        Intrinsics.checkNotNullParameter(r101, "currentState");
    }

    @Override // com.ss.android.lark.passportc.api.n
    public final void onUserOffline(f0c.e r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
    }

    @Override // com.ss.android.lark.passportc.api.n
    public final void onUserOnline(f0c.f r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
    }
}
