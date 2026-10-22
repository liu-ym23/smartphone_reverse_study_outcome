package io.reactivex.internal.schedulers;

import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import io.reactivex.plugins.RxJavaPlugins;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes41.dex */
public final class ScheduledDirectPeriodicTask extends AbstractDirectTask implements Runnable {
    private static final long serialVersionUID = 1811839108042568751L;

    @Override // java.lang.Runnable
    public void run() {
        io_reactivex_internal_schedulers_ScheduledDirectPeriodicTask_com_larus_apm_impl_protector_RunnableLancet_run(this);
    }

    @Override // io.reactivex.internal.schedulers.AbstractDirectTask
    public /* bridge */ /* synthetic */ Runnable getWrappedRunnable() {
        return super.getWrappedRunnable();
    }

    public void io_reactivex_internal_schedulers_ScheduledDirectPeriodicTask__run$___twin___() {
        this.runner = ThreadMethodProxy.currentThread();
        this.runnable.run();     // Catch: Throwable -> L5
        this.runner = null;     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        this.runner = null;
        lazySet(AbstractDirectTask.FINISHED);
        RxJavaPlugins.onError(th);
    }

    public ScheduledDirectPeriodicTask(Runnable r100) {
        super(r100);
    }

    @Skip({"com.ss.android.ugc.bytex.pthread+"})
    public static void io_reactivex_internal_schedulers_ScheduledDirectPeriodicTask_com_larus_apm_impl_protector_RunnableLancet_run(ScheduledDirectPeriodicTask r100) {
        r100.io_reactivex_internal_schedulers_ScheduledDirectPeriodicTask__run$___twin___();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
