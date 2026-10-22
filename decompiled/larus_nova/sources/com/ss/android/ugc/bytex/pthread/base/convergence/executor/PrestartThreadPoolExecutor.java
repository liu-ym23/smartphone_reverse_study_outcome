package com.ss.android.ugc.bytex.pthread.base.convergence.executor;

import androidx.exifinterface.media.ExifInterface;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0019B1\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\fJ\u0012\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\u0010\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u0004H\u0016R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/ss/android/ugc/bytex/pthread/base/convergence/executor/PrestartThreadPoolExecutor;", "Ljava/util/concurrent/Executor;", "Lcom/ss/android/ugc/bytex/pthread/base/convergence/executor/PrestartableExecutor;", "corePoolSize", "", "maximumPoolSize", "keepAliveTime", "", "threadFactory", "Ljava/util/concurrent/ThreadFactory;", "handler", "Ljava/util/concurrent/RejectedExecutionHandler;", "(IIJLjava/util/concurrent/ThreadFactory;Ljava/util/concurrent/RejectedExecutionHandler;)V", "executor", "Ljava/util/concurrent/ThreadPoolExecutor;", "prestartCount", "Ljava/util/concurrent/atomic/AtomicInteger;", "prestartRunnable", "Lcom/ss/android/ugc/bytex/pthread/base/convergence/executor/NothingRunnable;", "execute", "", "command", "Ljava/lang/Runnable;", "prestart", "count", "InterceptQueue", "threadpool-plugin-base_release"}, k = 1, mv = {1, 1, 13})
public final class PrestartThreadPoolExecutor implements PrestartableExecutor, Executor {
    private final ThreadPoolExecutor executor;
    private final AtomicInteger prestartCount;
    private final NothingRunnable prestartRunnable;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00028\u0000¢\u0006\u0002\u0010\u0004J\u0015\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\tR\u0010\u0010\u0003\u001a\u00028\u0000X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0005¨\u0006\n"}, d2 = {"Lcom/ss/android/ugc/bytex/pthread/base/convergence/executor/PrestartThreadPoolExecutor$InterceptQueue;", ExifInterface.LONGITUDE_EAST, "Ljava/util/concurrent/SynchronousQueue;", PickerReporterConstants.KEY.TARGET, "(Ljava/lang/Object;)V", "Ljava/lang/Object;", "offer", "", "e", "(Ljava/lang/Object;)Z", "threadpool-plugin-base_release"}, k = 1, mv = {1, 1, 13})
    public static final class InterceptQueue<E> extends SynchronousQueue<E> {
        private final E target;

        public InterceptQueue(E r100) {
            this.target = r100;
        }

        public int getSize() {
            return super.size();
        }

        @Override // java.util.concurrent.SynchronousQueue, java.util.Queue, java.util.concurrent.BlockingQueue
        public boolean offer(E r100) {
            if (r100 != this.target) goto L7;
            return false;
        L7:
            return super.offer(r100);
        }

        @Override // java.util.concurrent.SynchronousQueue, java.util.AbstractCollection, java.util.Collection
        public final int size() {
            return getSize();
        }
    }

    public PrestartThreadPoolExecutor(int r110, int r111, long r112, ThreadFactory r113, RejectedExecutionHandler r114) {
        this.prestartCount = new AtomicInteger();
        NothingRunnable r100 = new NothingRunnable();
        this.prestartRunnable = r100;
        this.executor = new ThreadPoolExecutor(r110, r111, r112, TimeUnit.MILLISECONDS, new InterceptQueue(r100), r113, r114);
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable r100) {
        this.executor.execute(r100);
    }

    @Override // com.ss.android.ugc.bytex.pthread.base.convergence.executor.PrestartableExecutor
    public void prestart(int r100) {
        this.prestartCount.addAndGet(r100);
        int r101 = 0;
    L3:
        if (r101 >= r100) goto L8;
        if (this.executor.getPoolSize() >= this.prestartCount.get()) goto L7;
        this.executor.execute(this.prestartRunnable);
    L7:
        r101 = r101 + 1;
        goto L3
    }
}
