package io.ktor.client.plugins.websocket;

import androidx.core.app.NotificationCompat;
import io.ktor.client.call.HttpClientCall;
import io.ktor.util.InternalAPI;
import io.ktor.websocket.j;
import io.ktor.websocket.m;
import java.util.List;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.channels.SendChannel;

/* JADX INFO: loaded from: classes41.dex */
public final class a implements m, io.ktor.websocket.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ io.ktor.websocket.a f491749a;

    @Override // io.ktor.websocket.m
    public final SendChannel<io.ktor.websocket.c> Ec() {
        return this.f491749a.Ec();
    }

    @Override // io.ktor.websocket.m
    public final Object FQ(io.ktor.websocket.c.b r100, Continuation r101) {
        return this.f491749a.FQ(r100, r101);
    }

    @Override // io.ktor.websocket.a
    @InternalAPI
    public final void Ja(List<? extends j<?>> r100) {
        Intrinsics.checkNotNullParameter(r100, "negotiatedExtensions");
        this.f491749a.Ja(r100);
    }

    @Override // io.ktor.websocket.m
    public final long WH() {
        return this.f491749a.WH();
    }

    @Override // io.ktor.websocket.m
    public final void XO(long r100) {
        this.f491749a.XO(r100);
    }

    @Override // kotlinx.coroutines.CoroutineScope
    public final CoroutineContext getCoroutineContext() {
        return this.f491749a.getCoroutineContext();
    }

    @Override // io.ktor.websocket.m
    public final Object hW(Continuation<? super Unit> r100) {
        return this.f491749a.hW(r100);
    }

    @Override // io.ktor.websocket.m
    public final ReceiveChannel<io.ktor.websocket.c> oT() {
        return this.f491749a.oT();
    }

    public a(HttpClientCall r100, io.ktor.websocket.a r101) {
        Intrinsics.checkNotNullParameter(r100, NotificationCompat.CATEGORY_CALL);
        Intrinsics.checkNotNullParameter(r101, "delegate");
        this.f491749a = r101;
    }
}
