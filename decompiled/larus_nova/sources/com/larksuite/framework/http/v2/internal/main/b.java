package com.larksuite.framework.http.v2.internal.main;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.l;

/* JADX INFO: loaded from: classes24.dex */
public final class b implements com.larksuite.framework.http.v2.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final OkHttpClient f285594a;

    @Override // com.larksuite.framework.http.v2.c
    public final OkHttpClient getOriginal() {
        return this.f285594a;
    }

    @Override // com.larksuite.framework.http.v2.c
    public final a a(Request r100, Function1 r101) {
        Intrinsics.checkNotNullParameter(r100, "request");
        Intrinsics.checkNotNullParameter(r101, "spec");
        Call r102 = this.f285594a.newCall(r100);
        Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type okhttp3.RealCall");
        return new a((l) r102);
    }

    public b(OkHttpClient r100, com.larksuite.framework.http.v2.c.b r101, LarkHttpImpl r102) {
        Intrinsics.checkNotNullParameter(r100, "original");
        Intrinsics.checkNotNullParameter(r101, "spec");
        Intrinsics.checkNotNullParameter(r102, "http");
        this.f285594a = r100;
    }
}
