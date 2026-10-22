package androidx.camera.core.impl.utils.futures;

import androidx.camera.core.Logger;
import androidx.core.util.Preconditions;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Delayed;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
abstract class ImmediateFuture<V> implements ListenableFuture<V> {
    private static final String TAG = "ImmediateFuture";

    public static class ImmediateFailedFuture<V> extends ImmediateFuture<V> {
        private final Throwable mCause;

        @Override // androidx.camera.core.impl.utils.futures.ImmediateFuture
        public V get() throws ExecutionException {
            throw new ExecutionException(this.mCause);
        }

        public String toString() {
            return super.toString() + "[status=FAILURE, cause=[" + this.mCause + "]]";
        }

        public ImmediateFailedFuture(Throwable r1) {
            this.mCause = r1;
        }
    }

    public static final class ImmediateFailedScheduledFuture<V> extends ImmediateFailedFuture<V> implements ScheduledFuture<V> {
        /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
        public int compareTo2(Delayed r1) {
            return -1;
        }

        @Override // java.util.concurrent.Delayed
        public long getDelay(TimeUnit r3) {
            return 0;
        }

        public ImmediateFailedScheduledFuture(Throwable r1) {
            super(r1);
        }

        @Override // java.lang.Comparable
        public /* bridge */ /* synthetic */ int compareTo(Delayed r1) {
            return compareTo2(r1);
        }
    }

    public static final class ImmediateSuccessfulFuture<V> extends ImmediateFuture<V> {
        static final ImmediateFuture<Object> NULL_FUTURE = null;
        private final V mValue;

        static {
            NULL_FUTURE = new ImmediateSuccessfulFuture(null);
        }

        public String toString() {
            return super.toString() + "[status=SUCCESS, result=[" + this.mValue + "]]";
        }

        @Override // androidx.camera.core.impl.utils.futures.ImmediateFuture
        public V get() {
            return this.mValue;
        }

        public ImmediateSuccessfulFuture(V r1) {
            this.mValue = r1;
        }
    }

    public ImmediateFuture() {
    }

    public boolean cancel(boolean r1) {
        return false;
    }

    public abstract V get() throws ExecutionException;

    public boolean isCancelled() {
        return false;
    }

    public boolean isDone() {
        return true;
    }

    public static <V> ListenableFuture<V> nullFuture() {
        return ImmediateSuccessfulFuture.NULL_FUTURE;
    }

    public void addListener(Runnable r4, Executor r5) {
        Preconditions.checkNotNull(r4);
        Preconditions.checkNotNull(r5);
        r5.execute(r4);     // Catch: RuntimeException -> L5
        return;
    L5:
        e = move-exception;
        Logger.e(TAG, "Experienced RuntimeException while attempting to notify " + r4 + " on Executor " + r5, e);
    }

    public V get(long r1, TimeUnit r3) throws ExecutionException {
        Preconditions.checkNotNull(r3);
        return get();
    }
}
