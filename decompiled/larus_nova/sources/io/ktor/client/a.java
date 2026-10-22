package io.ktor.client;

import com.bytedance.pitaya.api.PTYSocketStateCallback;
import io.ktor.client.call.HttpClientCall;
import io.ktor.client.plugins.k;
import io.ktor.client.utils.b;
import java.io.Closeable;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes41.dex */
public final class a implements CoroutineScope, Closeable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f491619a = null;
    private volatile /* synthetic */ int closed;

    static {
        f491619a = AtomicIntegerFieldUpdater.newUpdater(a.class, PTYSocketStateCallback.CLOSED);
    }

    @Override // kotlinx.coroutines.CoroutineScope
    public final CoroutineContext getCoroutineContext() {
        return null;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        if (f491619a.compareAndSet(this, 0, 1) == true) goto L5;
        return;
    L5:
        int r100 = k.f491724a;
        throw null;
    }

    public final String toString() {
        return "HttpClient[null]";
    }

    public final HttpClientCall a(Continuation r100) {
        if ((r100 instanceof HttpClient$execute$1) == false) goto L7;
        HttpClient$execute$1 r101 = (HttpClient$execute$1) r100;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r103 = r101.result;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r101.label;
        if (r104 != 0) goto L11;
        ResultKt.throwOnFailure(r103);
        int r105 = b.f491797a;
        throw null;
    L11:
        if (r104 != 1) goto L15;
        ResultKt.throwOnFailure(r103);
        Intrinsics.checkNotNull(r103, "null cannot be cast to non-null type io.ktor.client.call.HttpClientCall");
        return (HttpClientCall) r103;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L7:
        r101 = new HttpClient$execute$1(this, r100);
        goto L8
    }
}
