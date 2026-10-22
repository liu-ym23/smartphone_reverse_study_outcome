package io.ktor.utils.io.jvm.javaio;

import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.concurrent.locks.LockSupport;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes41.dex */
public final class d implements b<Thread> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f492126a = null;

    static {
        f492126a = new d();
    }

    public d() {
    }

    @Override // io.ktor.utils.io.jvm.javaio.b
    public final void a(Thread r100) {
        Thread r101 = r100;
        Intrinsics.checkNotNullParameter(r101, "token");
        a r102 = a.f492124a;
        Intrinsics.checkNotNullParameter(r101, "token");
        LockSupport.unpark(ThreadMethodProxy.getAttachThread(r101));
    }

    @Override // io.ktor.utils.io.jvm.javaio.b
    public final void b(long r100) {
        throw new UnsupportedOperationException("Parking is prohibited on this thread. Most likely you are using blocking operation on the wrong thread/dispatcher that doesn't allow blocking. Consider wrapping you blocking code withContext(Dispatchers.IO) {...}.");
    }
}
