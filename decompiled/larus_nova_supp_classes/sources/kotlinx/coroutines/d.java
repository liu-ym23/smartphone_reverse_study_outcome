package kotlinx.coroutines;

import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.concurrent.locks.LockSupport;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public final class d<T> extends a<T> {
    public final Thread d;
    public final q0 e;

    @Override // kotlinx.coroutines.JobSupport
    public final void o(Object r2) {
        if (Intrinsics.areEqual(ThreadMethodProxy.currentThread(), this.d) == true) goto L6;
        LockSupport.unpark(ThreadMethodProxy.getAttachThread(this.d));
        return;
    }

    public d(CoroutineContext r2, Thread r3, q0 r4) {
        super(r2, true, true);
        this.d = r3;
        this.e = r4;
    }
}
