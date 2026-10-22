package io.ktor.client.call;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes41.dex */
public final class a extends HttpClientCall {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final byte[] f491625f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f491626g;

    @Override // io.ktor.client.call.HttpClientCall
    public final Object e() {
        return io.ktor.utils.io.c.a(this.f491625f);
    }

    @Override // io.ktor.client.call.HttpClientCall
    public final boolean b() {
        return this.f491626g;
    }

    public a(io.ktor.client.a r100, io.ktor.client.request.b r101, io.ktor.client.statement.b r102, byte[] r103) {
        Intrinsics.checkNotNullParameter(r100, "client");
        Intrinsics.checkNotNullParameter(r101, "request");
        Intrinsics.checkNotNullParameter(r102, "response");
        Intrinsics.checkNotNullParameter(r103, "responseBody");
        super(r100);
        this.f491625f = r103;
        b r104 = new b(this, r101);
        Intrinsics.checkNotNullParameter(r104, "<set-?>");
        this.f491623b = r104;
        c r105 = new c(this, r103, r102);
        Intrinsics.checkNotNullParameter(r105, "<set-?>");
        this.f491624c = r105;
        this.f491626g = true;
    }
}
