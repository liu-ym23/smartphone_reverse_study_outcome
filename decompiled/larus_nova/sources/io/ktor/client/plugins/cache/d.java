package io.ktor.client.plugins.cache;

import io.ktor.client.call.HttpClientCall;
import io.ktor.http.Url;
import io.ktor.http.n;
import io.ktor.http.v;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes41.dex */
public final class d implements io.ktor.client.request.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final v f491684a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Url f491685b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final io.ktor.util.b f491686c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final io.ktor.http.content.c f491687d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final n f491688e;

    @Override // io.ktor.client.request.b
    public final HttpClientCall a80() {
        throw new IllegalStateException("This request has no call");
    }

    @Override // io.ktor.client.request.b, kotlinx.coroutines.CoroutineScope
    public final CoroutineContext getCoroutineContext() {
        a80();
        throw null;
    }

    @Override // io.ktor.client.request.b
    public final io.ktor.util.b getAttributes() {
        return this.f491686c;
    }

    @Override // io.ktor.client.request.b
    public final io.ktor.http.content.c getContent() {
        return this.f491687d;
    }

    @Override // io.ktor.http.s
    public final n getHeaders() {
        return this.f491688e;
    }

    @Override // io.ktor.client.request.b
    public final v getMethod() {
        return this.f491684a;
    }

    @Override // io.ktor.client.request.b
    public final Url getUrl() {
        return this.f491685b;
    }

    public d(io.ktor.client.request.c r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        this.f491684a = r100.f491771b;
        this.f491685b = r100.f491770a;
        this.f491686c = r100.f491775f;
        this.f491687d = r100.f491773d;
        this.f491688e = r100.f491772c;
    }
}
