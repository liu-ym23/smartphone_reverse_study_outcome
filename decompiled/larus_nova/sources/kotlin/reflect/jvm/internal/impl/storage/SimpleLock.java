package kotlin.reflect.jvm.internal.impl.storage;

import java.util.concurrent.locks.Lock;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes5.dex */
public interface SimpleLock {
    public static final Companion Companion = null;

    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = null;

        static {
            $$INSTANCE = new Companion();
        }

        private Companion() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final DefaultSimpleLock simpleLock(Runnable r100, Function1<? super InterruptedException, Unit> r101) {
            if (r100 == null) goto L5;
            if (r101 == null) goto L5;
            return new CancellableSimpleLock(r100, r101);
        L5:
            Lock r102 = null;
            return new DefaultSimpleLock(r102, 1, 0 == true ? 1 : 0);
        }
    }

    static {
        Companion = Companion.$$INSTANCE;
    }

    void lock();

    void unlock();
}
