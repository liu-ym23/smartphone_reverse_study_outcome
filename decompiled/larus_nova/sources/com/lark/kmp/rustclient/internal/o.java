package com.lark.kmp.rustclient.internal;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class o extends BaseRustClient implements com.lark.kmp.rustclient.api.b {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final gy7.f f282555e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final p f282556f;

    @Override // com.lark.kmp.rustclient.internal.BaseRustClient
    public final s c() {
        return this.f282556f;
    }

    public o(r r100, com.lark.kmp.rustclient.api.f r101, com.lark.kmp.rustclient.api.e r102, t r103, List<? extends com.lark.kmp.rustclient.api.g> r104, List<? extends com.lark.kmp.rustclient.api.c> r105, gy7.f r106) {
        Intrinsics.checkNotNullParameter(r100, "definition");
        Intrinsics.checkNotNullParameter(r101, "rustSDK");
        Intrinsics.checkNotNullParameter(r102, "containerHolder");
        Intrinsics.checkNotNullParameter(r103, "receiverRegistry");
        Intrinsics.checkNotNullParameter(r104, "invokeInterceptors");
        Intrinsics.checkNotNullParameter(r105, "pushInterceptors");
        Intrinsics.checkNotNullParameter(r100, "clientDef");
        super(r101, r102, CollectionsKt.plus(r104, CollectionsKt.listOf(new VerifyDataInterceptor(r100))));
        this.f282555e = r106;
        p r107 = new p(r105, r100);
        this.f282556f = r107;
        r103.b(r107);
    }
}
