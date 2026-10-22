package com.ss.android.ugc.bytex.pthread.base.convergence.core;

import com.ss.android.ugc.bytex.pthread.base.convergence.SuperThreadPool;
import com.ss.android.ugc.bytex.pthread.base.convergence.executor.IThreadNameTransformer;
import com.ss.android.ugc.bytex.pthread.base.convergence.external.IThreadWorker;
import com.ss.android.ugc.bytex.pthread.base.convergence.external.ThreadLifecycleObserver;
import com.ss.android.ugc.bytex.pthread.base.convergence.scheduler.PriorityProvider;
import com.ss.android.ugc.bytex.pthread.base.convergence.scheduler.PriorityRunnable;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\b\u0018\u0000 \u00142\u00020\u00012\u00020\u0002:\u0001\u0014B;\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\r0\f¢\u0006\u0002\u0010\u000eJ\b\u0010\u000f\u001a\u00020\u0004H\u0016J\b\u0010\u0010\u001a\u00020\nH\u0016J\b\u0010\u0011\u001a\u00020\rH\u0016J\u0010\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u0006H\u0016R\u001a\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\r0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/ss/android/ugc/bytex/pthread/base/convergence/core/ThreadWorker;", "Lcom/ss/android/ugc/bytex/pthread/base/convergence/external/IThreadWorker;", "Lcom/ss/android/ugc/bytex/pthread/base/convergence/scheduler/PriorityRunnable;", "delegate", "Ljava/lang/Thread;", "skipSetPriority", "", "exitListener", "Lcom/ss/android/ugc/bytex/pthread/base/convergence/core/IThreadExitListener;", "type", "", "callback", "Lkotlin/Function1;", "", "(Ljava/lang/Thread;ZLcom/ss/android/ugc/bytex/pthread/base/convergence/core/IThreadExitListener;ILkotlin/jvm/functions/Function1;)V", "getDelegate", "priorityAffinity", "run", "setPriorityEnable", "enable", "Companion", "threadpool-plugin-base_release"}, k = 1, mv = {1, 1, 13})
public final class ThreadWorker implements IThreadWorker, PriorityRunnable {
    private static final int ASSOCIATE_TYPE = 5;
    public static final Companion Companion = null;
    private final Function1<Thread, Unit> callback;
    private final Thread delegate;
    private final IThreadExitListener exitListener;
    private boolean skipSetPriority;
    private final int type;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/ss/android/ugc/bytex/pthread/base/convergence/core/ThreadWorker$Companion;", "", "()V", "ASSOCIATE_TYPE", "", "threadpool-plugin-base_release"}, k = 1, mv = {1, 1, 13})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ThreadWorker(Thread r100, boolean r101, IThreadExitListener r102, int r103, Function1<? super Thread, Unit> r104) {
        this.delegate = r100;
        this.skipSetPriority = r101;
        this.exitListener = r102;
        this.type = r103;
        this.callback = r104;
    }

    public /* synthetic */ ThreadWorker(Thread r100, boolean r101, IThreadExitListener r102, int r110, Function1 r111, int r112, DefaultConstructorMarker r113) {
        if ((r112 & 2) == 0) goto L5;
        boolean r103 = false;
    L6:
        this(r100, r103, r102, r110, r111);
        return;
    L5:
        r103 = r101;
        goto L6
    }

    @Override // com.ss.android.ugc.bytex.pthread.base.convergence.external.IThreadWorker
    public Thread getDelegate() {
        return this.delegate;
    }

    @Override // com.ss.android.ugc.bytex.pthread.base.convergence.scheduler.PriorityProvider
    public int priorityAffinity() {
        Object r100 = this.delegate;
        if ((r100 instanceof PriorityProvider) == true) goto L5;
        r100 = null;
    L5:
        PriorityProvider r101 = (PriorityProvider) r100;
        if (r101 != null) goto L10;
        return 6;
    L10:
        return r101.priorityAffinity();
    }

    @Override // java.lang.Runnable
    public void run() {
        Thread r100 = Thread.currentThread();
        if (r100 == null) goto L32;
        ICoreThread r101 = (ICoreThread) r100;
    L28:
        th = move-exception;
        r101.resetThread();
        this.exitListener.onThreadExit();
        throw th;
    L6:
        if ((this.type & 5) <= 0) goto L8;
        r101.associateDelegateThread(this.delegate);     // Catch: Throwable -> L28
    L8:
        SuperThreadPool r102 = SuperThreadPool.INSTANCE;     // Catch: Throwable -> L28
        ThreadLifecycleObserver r103 = r102.getThreadLifecycleObserver();     // Catch: Throwable -> L28
        int r104 = this.delegate.getPriority();     // Catch: Throwable -> L28
        IThreadNameTransformer r105 = r102.getThreadNameTransformer();     // Catch: Throwable -> L28
        if (r105 == null) goto L13;
        String r106 = r105.transform(this.delegate.getName());     // Catch: Throwable -> L28
        if (r106 == null) goto L13;
    L14:
        r101.setName(r106);     // Catch: Throwable -> L28
        if (this.skipSetPriority == false) goto L17;
    L21:
        if (r103 == null) goto L23;
        r103.onAttach(r101, this.delegate);     // Catch: Throwable -> L28
    L23:
        this.callback.invoke(r101);     // Catch: Throwable -> L28
        if (r103 == null) goto L26;
        r103.onDetach(r101, this.delegate);     // Catch: Throwable -> L28
    L26:
        r101.resetThread();
        this.exitListener.onThreadExit();
        return;
    L17:
        if (r102.getEnablePriority() == false) goto L21;
        if (r101.getPriority() == r104) goto L21;
        r101.setPriority(r104);     // Catch: Throwable -> L28
    L13:
        r106 = this.delegate.getName();     // Catch: Throwable -> L28
        goto L14
    L32:
        throw new TypeCastException("null cannot be cast to non-null type com.ss.android.ugc.bytex.pthread.base.convergence.core.ICoreThread");
    }

    @Override // com.ss.android.ugc.bytex.pthread.base.convergence.external.IThreadWorker
    public void setPriorityEnable(boolean r100) {
        this.skipSetPriority = !r100;
    }
}
