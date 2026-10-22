package com.google.common.util.concurrent;

import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes23.dex */
@ElementTypesAreNonnullByDefault
public final class JdkFutureAdapters {

    public static class ListenableFutureAdapter<V> extends ForwardingFuture<V> implements ListenableFuture<V> {
        private static final Executor defaultAdapterExecutor = null;
        private static final ThreadFactory threadFactory = null;
        private final Executor adapterExecutor;
        private final Future<V> delegate;
        private final ExecutionList executionList;
        private final AtomicBoolean hasListeners;

        public static /* synthetic */ void e(ListenableFutureAdapter r100) {
            r100.lambda$addListener$0();
        }

        static {
            ThreadFactory r100 = new ThreadFactoryBuilder().setDaemon(true).setNameFormat("ListenableFutureAdapter-thread-%d").build();
            threadFactory = r100;
            defaultAdapterExecutor = PThreadExecutorsUtils.newCachedThreadPool(r100);
        }

        private /* synthetic */ void lambda$addListener$0() {
            Uninterruptibles.getUninterruptibly(this.delegate);     // Catch: Throwable -> L5
        L3:
            this.executionList.execute();
        }

        @Override // com.google.common.util.concurrent.ForwardingFuture, com.google.common.collect.o0
        public /* bridge */ /* synthetic */ Object delegate() {
            return delegate();
        }

        @Override // com.google.common.util.concurrent.ForwardingFuture, com.google.common.collect.o0
        public Future<V> delegate() {
            return this.delegate;
        }

        public ListenableFutureAdapter(Future<V> r100) {
            this(r100, defaultAdapterExecutor);
        }

        public ListenableFutureAdapter(Future<V> r100, Executor r101) {
            this.executionList = new ExecutionList();
            this.hasListeners = new AtomicBoolean(false);
            r100.getClass();
            this.delegate = r100;
            r101.getClass();
            this.adapterExecutor = r101;
        }

        @Override // com.google.common.util.concurrent.ListenableFuture
        public void addListener(Runnable r100, Executor r101) {
            this.executionList.add(r100, r101);
            if (this.hasListeners.compareAndSet(false, true) == true) goto L5;
            return;
        L5:
            if (this.delegate.isDone() == false) goto L8;
            this.executionList.execute();
            return;
        L8:
            this.adapterExecutor.execute(new w(this));
        }
    }

    private JdkFutureAdapters() {
    }

    public static <V> ListenableFuture<V> listenInPoolThread(Future<V> r100) {
        if ((r100 instanceof ListenableFuture) == false) goto L7;
        return (ListenableFuture) r100;
    L7:
        return new ListenableFutureAdapter(r100);
    }

    public static <V> ListenableFuture<V> listenInPoolThread(Future<V> r100, Executor r101) {
        r101.getClass();
        if ((r100 instanceof ListenableFuture) == false) goto L7;
        return (ListenableFuture) r100;
    L7:
        return new ListenableFutureAdapter(r100, r101);
    }
}
