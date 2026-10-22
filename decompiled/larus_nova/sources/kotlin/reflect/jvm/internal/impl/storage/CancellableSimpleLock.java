package kotlin.reflect.jvm.internal.impl.storage;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes42.dex */
public final class CancellableSimpleLock extends DefaultSimpleLock {
    private final Runnable checkCancelled;
    private final Function1<InterruptedException, Unit> interruptedExceptionHandler;

    @Override // kotlin.reflect.jvm.internal.impl.storage.DefaultSimpleLock, kotlin.reflect.jvm.internal.impl.storage.SimpleLock
    public void lock() {
    L9:
    L6:
        e = move-exception;
        this.interruptedExceptionHandler.invoke(e);
        return;
    L3:
        if (getLock().tryLock(50, TimeUnit.MILLISECONDS) == true) goto L13;
        this.checkCancelled.run();     // Catch: InterruptedException -> L6
        goto L9
    }

    public CancellableSimpleLock(Runnable r100, Function1<? super InterruptedException, Unit> r101) {
        Intrinsics.checkNotNullParameter(r100, "checkCancelled");
        Intrinsics.checkNotNullParameter(r101, "interruptedExceptionHandler");
        this(new ReentrantLock(), r100, r101);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public CancellableSimpleLock(Lock r100, Runnable r101, Function1<? super InterruptedException, Unit> r102) {
        Intrinsics.checkNotNullParameter(r100, "lock");
        Intrinsics.checkNotNullParameter(r101, "checkCancelled");
        Intrinsics.checkNotNullParameter(r102, "interruptedExceptionHandler");
        super(r100);
        this.checkCancelled = r101;
        this.interruptedExceptionHandler = r102;
    }
}
