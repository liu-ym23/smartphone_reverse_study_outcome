package io.ktor.client.plugins.observer;

import androidx.core.app.NotificationCompat;
import com.bytedance.android.livesdkapi.player.resolution.PlayerResolution;
import io.ktor.client.call.HttpClientCall;
import io.ktor.http.n;
import io.ktor.http.w;
import io.ktor.http.x;
import io.ktor.util.InternalAPI;
import io.ktor.utils.io.ByteReadChannel;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes41.dex */
@InternalAPI
public final class d extends io.ktor.client.statement.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HttpClientCall f491732a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ByteReadChannel f491733b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final io.ktor.client.statement.b f491734c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final CoroutineContext f491735d;

    @Override // io.ktor.client.statement.b
    public final hsc.a b() {
        return this.f491734c.b();
    }

    @Override // io.ktor.client.statement.b
    public final hsc.a c() {
        return this.f491734c.c();
    }

    @Override // io.ktor.client.statement.b
    public final x d() {
        return this.f491734c.d();
    }

    @Override // io.ktor.client.statement.b
    public final w e() {
        return this.f491734c.e();
    }

    @Override // io.ktor.http.s
    public final n getHeaders() {
        return this.f491734c.getHeaders();
    }

    @Override // io.ktor.client.statement.b
    public final ByteReadChannel a() {
        return this.f491733b;
    }

    @Override // io.ktor.client.statement.b
    public final HttpClientCall a80() {
        return this.f491732a;
    }

    @Override // kotlinx.coroutines.CoroutineScope
    public final CoroutineContext getCoroutineContext() {
        return this.f491735d;
    }

    public d(HttpClientCall r100, ByteReadChannel r101, io.ktor.client.statement.b r102) {
        Intrinsics.checkNotNullParameter(r100, NotificationCompat.CATEGORY_CALL);
        Intrinsics.checkNotNullParameter(r101, "content");
        Intrinsics.checkNotNullParameter(r102, PlayerResolution.SDKKEY.ORIGIN);
        this.f491732a = r100;
        this.f491733b = r101;
        this.f491734c = r102;
        this.f491735d = r102.getCoroutineContext();
    }
}
