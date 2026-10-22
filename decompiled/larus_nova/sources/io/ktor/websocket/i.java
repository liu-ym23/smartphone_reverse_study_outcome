package io.ktor.websocket;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.channels.SendChannel;

/* JADX INFO: loaded from: classes41.dex */
public final class i implements m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ KProperty<Object>[] f492179a = null;

    static {
        f492179a = new KProperty[]{Reflection.mutableProperty1(new MutablePropertyReference1Impl(i.class, "maxFrameSize", "getMaxFrameSize()J", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(i.class, "masking", "getMasking()Z", 0))};
    }

    @Override // kotlinx.coroutines.CoroutineScope
    public final CoroutineContext getCoroutineContext() {
        return null;
    }

    @Override // io.ktor.websocket.m
    public final ReceiveChannel<c> oT() {
        return null;
    }

    @Override // io.ktor.websocket.m
    public final long WH() {
        KProperty<Object> r100 = f492179a[0];
        throw null;
    }

    @Override // io.ktor.websocket.m
    public final SendChannel<c> Ec() {
        throw null;
    }

    @Override // io.ktor.websocket.m
    public final void XO(long r100) {
        KProperty<Object> r101 = f492179a[0];
        throw null;
    }

    @Override // io.ktor.websocket.m
    public final Object hW(Continuation<? super Unit> r100) {
        throw null;
    }

    @Override // io.ktor.websocket.m
    public final Object FQ(c.b r100, Continuation r101) {
        Ec();
        throw null;
    }
}
