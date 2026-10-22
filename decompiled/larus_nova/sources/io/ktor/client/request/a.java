package io.ktor.client.request;

import androidx.core.app.NotificationCompat;
import io.ktor.client.call.HttpClientCall;
import io.ktor.http.Url;
import io.ktor.http.n;
import io.ktor.http.v;
import io.ktor.util.InternalAPI;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes41.dex */
@InternalAPI
public final class a implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HttpClientCall f491764a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final v f491765b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Url f491766c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final io.ktor.http.content.c f491767d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final n f491768e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final io.ktor.util.b f491769f;

    @Override // io.ktor.client.request.b, kotlinx.coroutines.CoroutineScope
    public final CoroutineContext getCoroutineContext() {
        return this.f491764a.getCoroutineContext();
    }

    @Override // io.ktor.client.request.b
    public final HttpClientCall a80() {
        return this.f491764a;
    }

    @Override // io.ktor.client.request.b
    public final io.ktor.util.b getAttributes() {
        return this.f491769f;
    }

    @Override // io.ktor.client.request.b
    public final io.ktor.http.content.c getContent() {
        return this.f491767d;
    }

    @Override // io.ktor.http.s
    public final n getHeaders() {
        return this.f491768e;
    }

    @Override // io.ktor.client.request.b
    public final v getMethod() {
        return this.f491765b;
    }

    @Override // io.ktor.client.request.b
    public final Url getUrl() {
        return this.f491766c;
    }

    public a(HttpClientCall r100, c r101) {
        Intrinsics.checkNotNullParameter(r100, NotificationCompat.CATEGORY_CALL);
        Intrinsics.checkNotNullParameter(r101, "data");
        this.f491764a = r100;
        this.f491765b = r101.f491771b;
        this.f491766c = r101.f491770a;
        this.f491767d = r101.f491773d;
        this.f491768e = r101.f491772c;
        this.f491769f = r101.f491775f;
    }
}
