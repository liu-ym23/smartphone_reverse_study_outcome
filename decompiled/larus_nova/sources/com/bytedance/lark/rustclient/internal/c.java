package com.bytedance.lark.rustclient.internal;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes20.dex */
public final class c implements com.bytedance.lark.rustclient.api.j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f253961a;

    public c(String r100) {
        Intrinsics.checkNotNullParameter(r100, "scopeUserId");
        this.f253961a = r100;
    }

    @Override // com.bytedance.lark.rustclient.api.j
    public final boolean a(com.bytedance.lark.sdk.refactor.q r100) {
        Intrinsics.checkNotNullParameter(r100, "push");
        return com.ss.android.lark.passportc.api.y.a(this.f253961a);
    }
}
