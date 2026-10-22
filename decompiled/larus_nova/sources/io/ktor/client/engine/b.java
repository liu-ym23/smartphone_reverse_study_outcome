package io.ktor.client.engine;

import com.bytedance.pitaya.api.PTYSocketStateCallback;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.coroutines.CoroutineContext;

/* JADX INFO: loaded from: classes41.dex */
public abstract class b implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f491643a = null;
    private volatile /* synthetic */ int closed;

    static {
        f491643a = AtomicIntegerFieldUpdater.newUpdater(b.class, PTYSocketStateCallback.CLOSED);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        if (f491643a.compareAndSet(this, 0, 1) == true) goto L6;
        return;
    L6:
        throw null;
    }

    @Override // kotlinx.coroutines.CoroutineScope
    public final CoroutineContext getCoroutineContext() {
        throw null;
    }
}
