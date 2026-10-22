package io.ktor.client.statement;

import androidx.core.app.NotificationCompat;
import com.bytedance.sdk.account.platform.base.OnekeyLoginConstants;
import io.ktor.client.call.HttpClientCall;
import io.ktor.client.request.f;
import io.ktor.http.n;
import io.ktor.http.w;
import io.ktor.http.x;
import io.ktor.util.InternalAPI;
import io.ktor.utils.io.ByteReadChannel;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes41.dex */
@InternalAPI
public final class a extends b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HttpClientCall f491787a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CoroutineContext f491788b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final x f491789c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final w f491790d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final hsc.a f491791e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final hsc.a f491792f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ByteReadChannel f491793g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final n f491794h;

    @Override // io.ktor.client.statement.b
    public final ByteReadChannel a() {
        return this.f491793g;
    }

    @Override // io.ktor.client.statement.b
    public final HttpClientCall a80() {
        return this.f491787a;
    }

    @Override // io.ktor.client.statement.b
    public final hsc.a b() {
        return this.f491791e;
    }

    @Override // io.ktor.client.statement.b
    public final hsc.a c() {
        return this.f491792f;
    }

    @Override // io.ktor.client.statement.b
    public final x d() {
        return this.f491789c;
    }

    @Override // io.ktor.client.statement.b
    public final w e() {
        return this.f491790d;
    }

    @Override // kotlinx.coroutines.CoroutineScope
    public final CoroutineContext getCoroutineContext() {
        return this.f491788b;
    }

    @Override // io.ktor.http.s
    public final n getHeaders() {
        return this.f491794h;
    }

    public a(HttpClientCall r100, f r101) {
        Intrinsics.checkNotNullParameter(r100, NotificationCompat.CATEGORY_CALL);
        Intrinsics.checkNotNullParameter(r101, OnekeyLoginConstants.CT_KEY_RSP_DATA);
        this.f491787a = r100;
        this.f491788b = r101.f491783f;
        this.f491789c = r101.f491778a;
        this.f491790d = r101.f491781d;
        this.f491791e = r101.f491779b;
        this.f491792f = r101.f491784g;
        Object r102 = r101.f491782e;
        if ((r102 instanceof ByteReadChannel) == false) goto L5;
        io.ktor.utils.io.b r103 = (ByteReadChannel) r102;
    L6:
        if (r103 != null) goto L8;
        ByteReadChannel.f492010a.getClass();
        r103 = ByteReadChannel.Companion.f492012b.getValue();
    L8:
        this.f491793g = r103;
        this.f491794h = r101.f491780c;
        return;
    L5:
        r103 = null;
        goto L6
    }
}
