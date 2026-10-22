package io.ktor.websocket;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.channels.SendChannel;

/* JADX INFO: loaded from: classes41.dex */
public interface m extends CoroutineScope {
    SendChannel<c> Ec();

    Object FQ(c.b r100, Continuation r101);

    long WH();

    void XO(long r100);

    Object hW(Continuation<? super Unit> r100);

    ReceiveChannel<c> oT();
}
