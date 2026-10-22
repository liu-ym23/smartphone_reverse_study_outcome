package io.ktor.utils.io.jvm.javaio;

import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.concurrent.locks.LockSupport;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes41.dex */
public final class a implements b<Thread> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f492124a = null;

    static {
        f492124a = new a();
    }

    public a() {
    }

    @Override // io.ktor.utils.io.jvm.javaio.b
    public final void a(Thread r100) {
        Thread r101 = r100;
        Intrinsics.checkNotNullParameter(r101, "token");
        LockSupport.unpark(ThreadMethodProxy.getAttachThread(r101));
    }

    @Override // io.ktor.utils.io.jvm.javaio.b
    public final void b(long r100) {
        if (r100 < 0) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == false) goto L10;
        LockSupport.parkNanos(r100);
        return;
    L10:
        throw new IllegalArgumentException("Failed requirement.".toString());
    L5:
        r101 = false;
        goto L6
    }
}
