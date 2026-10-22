package kotlinx.coroutines;

import java.io.Closeable;
import java.util.concurrent.Executor;
import kotlin.coroutines.AbstractCoroutineContextKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public abstract class ExecutorCoroutineDispatcher extends CoroutineDispatcher implements Closeable {

    public static final class Key extends AbstractCoroutineContextKey<CoroutineDispatcher, ExecutorCoroutineDispatcher> {
        public Key() {
            super(CoroutineDispatcher.Key, AnonymousClass1.INSTANCE);
        }
    }

    static {
        new Key();
    }

    public abstract void close();

    public abstract Executor d();

    public ExecutorCoroutineDispatcher() {
    }
}
