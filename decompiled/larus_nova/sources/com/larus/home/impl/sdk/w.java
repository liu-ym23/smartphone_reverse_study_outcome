package com.larus.home.impl.sdk;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public final class w implements com.larus.e_commerce.api.h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ uq9.l f346255a;

    @Override // com.larus.e_commerce.api.h
    public final void a() {
        Intrinsics.checkNotNullParameter("ecommerce plugin init failed", "reason");
        this.f346255a.a();
    }

    @Override // com.larus.e_commerce.api.h
    public final void onInitSuccess() {
        this.f346255a.onInitSuccess();
    }

    public w(uq9.l r100) {
        this.f346255a = r100;
    }
}
