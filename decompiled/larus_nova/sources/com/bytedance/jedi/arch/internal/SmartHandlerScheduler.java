package com.bytedance.jedi.arch.internal;

import android.os.Handler;
import android.os.Message;
import com.bytedance.android.service.manager.pull.PullConfiguration;
import com.bytedance.crash.dumper.Scraps;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001:\u0002\u0011\u0012B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0007\u001a\u00020\bH\u0016J \u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/bytedance/jedi/arch/internal/SmartHandlerScheduler;", "Lio/reactivex/Scheduler;", "handler", "Landroid/os/Handler;", "async", "", "(Landroid/os/Handler;Z)V", "createWorker", "Lio/reactivex/Scheduler$Worker;", "scheduleDirect", "Lio/reactivex/disposables/Disposable;", "rawRunnable", "Ljava/lang/Runnable;", "delay", "", Scraps.INNER_UNIT, "Ljava/util/concurrent/TimeUnit;", "HandlerWorker", "ScheduledRunnable", "arch_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class SmartHandlerScheduler extends Scheduler {
    private final boolean async;
    private final Handler handler;

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\u0005H\u0016J \u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0017R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/bytedance/jedi/arch/internal/SmartHandlerScheduler$HandlerWorker;", "Lio/reactivex/Scheduler$Worker;", "handler", "Landroid/os/Handler;", "async", "", "(Landroid/os/Handler;Z)V", "disposed", "dispose", "", "isDisposed", MonitorConstants.SCHEDULE, "Lio/reactivex/disposables/Disposable;", "rawRunnable", "Ljava/lang/Runnable;", "delay", "", Scraps.INNER_UNIT, "Ljava/util/concurrent/TimeUnit;", "arch_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class HandlerWorker extends Scheduler.Worker {
        private final boolean async;
        private volatile boolean disposed;
        private final Handler handler;

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.disposed = true;
            this.handler.removeCallbacksAndMessages(this);
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.disposed;
        }

        public HandlerWorker(Handler r100, boolean r101) {
            Intrinsics.checkNotNullParameter(r100, "handler");
            this.handler = r100;
            this.async = r101;
        }

        @Override // io.reactivex.Scheduler.Worker
        public Disposable schedule(Runnable r100, long r101, TimeUnit r102) {
            Intrinsics.checkNotNullParameter(r100, "rawRunnable");
            Intrinsics.checkNotNullParameter(r102, Scraps.INNER_UNIT);
            if (this.disposed == true) goto L5;
            Runnable r103 = RxJavaPlugins.onSchedule(r100);
            boolean r104 = SmartHandlerSchedulerKt.getMain();
            ScheduledRunnable r105 = new ScheduledRunnable(this.handler, r103, r104);
            if (r104 == false) goto L10;
            r105.run();
            return r105;
        L10:
            Message r106 = Message.obtain(this.handler, r105);
            r106.obj = this;
            if (this.async == false) goto L13;
            r106.setAsynchronous(true);
        L13:
            this.handler.sendMessageDelayed(r106, r102.toMillis(r101));
            if (this.disposed == false) goto L17;
            this.handler.removeCallbacks(r105);
            return Disposables.disposed();
        L17:
            return r105;
        L5:
            return Disposables.disposed();
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0001\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\u0007H\u0016J\b\u0010\r\u001a\u00020\u000bH\u0016R\u000e\u0010\u0005\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/bytedance/jedi/arch/internal/SmartHandlerScheduler$ScheduledRunnable;", "Ljava/lang/Runnable;", "Lio/reactivex/disposables/Disposable;", "handler", "Landroid/os/Handler;", "delegate", PullConfiguration.PROCESS_NAME_MAIN, "", "(Landroid/os/Handler;Ljava/lang/Runnable;Z)V", "disposed", "dispose", "", "isDisposed", "run", "arch_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class ScheduledRunnable implements Runnable, Disposable {
        private final Runnable delegate;
        private volatile boolean disposed;
        private final Handler handler;
        private final boolean main;

        @Override // java.lang.Runnable
        public void run() {
            com_bytedance_jedi_arch_internal_SmartHandlerScheduler$ScheduledRunnable_com_larus_apm_impl_protector_RunnableLancet_run(this);
        }

        public void com_bytedance_jedi_arch_internal_SmartHandlerScheduler$ScheduledRunnable__run$___twin___() {
            this.delegate.run();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            RxJavaPlugins.onError(th);
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            if (this.main == true) goto L5;
            this.handler.removeCallbacks(this);
        L5:
            this.disposed = true;
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.disposed;
        }

        @Skip({"com.ss.android.ugc.bytex.pthread+"})
        public static void com_bytedance_jedi_arch_internal_SmartHandlerScheduler$ScheduledRunnable_com_larus_apm_impl_protector_RunnableLancet_run(ScheduledRunnable r100) {
            r100.com_bytedance_jedi_arch_internal_SmartHandlerScheduler$ScheduledRunnable__run$___twin___();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public ScheduledRunnable(Handler r100, Runnable r101, boolean r102) {
            Intrinsics.checkNotNullParameter(r100, "handler");
            Intrinsics.checkNotNullParameter(r101, "delegate");
            this.handler = r100;
            this.delegate = r101;
            this.main = r102;
        }
    }

    @Override // io.reactivex.Scheduler
    public Scheduler.Worker createWorker() {
        return new HandlerWorker(this.handler, this.async);
    }

    public SmartHandlerScheduler(Handler r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "handler");
        this.handler = r100;
        this.async = r101;
    }

    @Override // io.reactivex.Scheduler
    public Disposable scheduleDirect(Runnable r100, long r101, TimeUnit r102) {
        Intrinsics.checkNotNullParameter(r100, "rawRunnable");
        Intrinsics.checkNotNullParameter(r102, Scraps.INNER_UNIT);
        Runnable r103 = RxJavaPlugins.onSchedule(r100);
        boolean r104 = SmartHandlerSchedulerKt.getMain();
        ScheduledRunnable r105 = new ScheduledRunnable(this.handler, r103, r104);
        if (r104 == false) goto L6;
        r105.run();
        return r105;
    L6:
        this.handler.postDelayed(r105, r102.toMillis(r101));
        return r105;
    }
}
