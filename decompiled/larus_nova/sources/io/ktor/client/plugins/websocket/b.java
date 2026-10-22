package io.ktor.client.plugins.websocket;

import androidx.core.app.NotificationCompat;
import com.ss.android.lark.openplatform.common.constant.AppbrandHostConstants;
import io.ktor.client.call.HttpClientCall;
import io.ktor.websocket.m;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.channels.SendChannel;

/* JADX INFO: loaded from: classes41.dex */
public final class b implements m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ m f491750a;

    @Override // io.ktor.websocket.m
    public final SendChannel<io.ktor.websocket.c> Ec() {
        return this.f491750a.Ec();
    }

    @Override // io.ktor.websocket.m
    public final Object FQ(io.ktor.websocket.c.b r100, Continuation r101) {
        return this.f491750a.FQ(r100, r101);
    }

    @Override // io.ktor.websocket.m
    public final long WH() {
        return this.f491750a.WH();
    }

    @Override // io.ktor.websocket.m
    public final void XO(long r100) {
        this.f491750a.XO(r100);
    }

    @Override // kotlinx.coroutines.CoroutineScope
    public final CoroutineContext getCoroutineContext() {
        return this.f491750a.getCoroutineContext();
    }

    @Override // io.ktor.websocket.m
    public final Object hW(Continuation<? super Unit> r100) {
        return this.f491750a.hW(r100);
    }

    @Override // io.ktor.websocket.m
    public final ReceiveChannel<io.ktor.websocket.c> oT() {
        return this.f491750a.oT();
    }

    public b(HttpClientCall r100, m r101) {
        Intrinsics.checkNotNullParameter(r100, NotificationCompat.CATEGORY_CALL);
        Intrinsics.checkNotNullParameter(r101, AppbrandHostConstants.SCHEMA_INSPECT.SESSION);
        this.f491750a = r101;
    }
}
