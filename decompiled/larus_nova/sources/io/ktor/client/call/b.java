package io.ktor.client.call;

import androidx.core.app.NotificationCompat;
import com.bytedance.android.livesdkapi.player.resolution.PlayerResolution;
import io.ktor.http.Url;
import io.ktor.http.n;
import io.ktor.http.v;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes41.dex */
public final class b implements io.ktor.client.request.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f491627a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ io.ktor.client.request.b f491628b;

    @Override // io.ktor.client.request.b
    public final io.ktor.util.b getAttributes() {
        return this.f491628b.getAttributes();
    }

    @Override // io.ktor.client.request.b
    public final io.ktor.http.content.c getContent() {
        return this.f491628b.getContent();
    }

    @Override // io.ktor.client.request.b, kotlinx.coroutines.CoroutineScope
    public final CoroutineContext getCoroutineContext() {
        return this.f491628b.getCoroutineContext();
    }

    @Override // io.ktor.http.s
    public final n getHeaders() {
        return this.f491628b.getHeaders();
    }

    @Override // io.ktor.client.request.b
    public final v getMethod() {
        return this.f491628b.getMethod();
    }

    @Override // io.ktor.client.request.b
    public final Url getUrl() {
        return this.f491628b.getUrl();
    }

    @Override // io.ktor.client.request.b
    public final HttpClientCall a80() {
        return this.f491627a;
    }

    public b(a r100, io.ktor.client.request.b r101) {
        Intrinsics.checkNotNullParameter(r100, NotificationCompat.CATEGORY_CALL);
        Intrinsics.checkNotNullParameter(r101, PlayerResolution.SDKKEY.ORIGIN);
        this.f491627a = r100;
        this.f491628b = r101;
    }
}
