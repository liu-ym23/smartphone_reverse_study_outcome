package kotlinx.coroutines;

import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.concurrent.locks.LockSupport;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public final class d<T> extends a<T> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Thread f504704d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final q0 f504705e;

    @Override // kotlinx.coroutines.JobSupport
    public final void o(Object r100) {
        if (Intrinsics.areEqual(ThreadMethodProxy.currentThread(), this.f504704d) == true) goto L6;
        LockSupport.unpark(ThreadMethodProxy.getAttachThread(this.f504704d));
        return;
    }

    public d(CoroutineContext r100, Thread r101, q0 r102) {
        super(r100, true, true);
        this.f504704d = r101;
        this.f504705e = r102;
    }
}
