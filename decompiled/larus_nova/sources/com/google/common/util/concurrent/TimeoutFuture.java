package com.google.common.util.concurrent;

import com.larus.apm.impl.protector.RunnableProtector;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import javax.annotation.CheckForNull;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes23.dex */
@ElementTypesAreNonnullByDefault
final class TimeoutFuture<V> extends FluentFuture.TrustedFuture<V> {

    @CheckForNull
    private ListenableFuture<V> delegateRef;

    @CheckForNull
    private ScheduledFuture<?> timer;

    /* JADX INFO: renamed from: com.google.common.util.concurrent.TimeoutFuture$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static final class Fire<V> implements Runnable {

        @CheckForNull
        TimeoutFuture<V> timeoutFutureRef;

        @Override // java.lang.Runnable
        public void run() {
            com_google_common_util_concurrent_TimeoutFuture$Fire_com_larus_apm_impl_protector_RunnableLancet_run(this);
        }

        public void com_google_common_util_concurrent_TimeoutFuture$Fire__run$___twin___() {
            TimeoutFuture<V> r100 = this.timeoutFutureRef;
            if (r100 != null) goto L5;
            return;
        L5:
            ListenableFuture<? extends V> r101 = TimeoutFuture.access$000(r100);
            if (r101 != null) goto L8;
            return;
        L8:
            AnonymousClass1 r102 = null;
            this.timeoutFutureRef = null;
            if (r101.isDone() == false) goto L27;
            r100.setFuture(r101);
            return;
        L27:
            ScheduledFuture r103 = TimeoutFuture.access$100(r100);     // Catch: Throwable -> L24
            TimeoutFuture.access$102(r100, null);     // Catch: Throwable -> L24
            String r104 = "Timed out";
            if (r103 != null) goto L28;
        L17:
            r100.setException(new TimeoutFutureException(r104 + ": " + r101, r102));     // Catch: Throwable -> L24
            r101.cancel(true);
            return;
        L21:
            th = move-exception;
            r100.setException(new TimeoutFutureException(r104, r102));     // Catch: Throwable -> L24
            throw th;     // Catch: Throwable -> L24
        L28:
            long r105 = Math.abs(r103.getDelay(TimeUnit.MILLISECONDS));     // Catch: Throwable -> L21
            if (r105 <= 10) goto L17;
            r104 = "Timed out (timeout delayed by " + r105 + " ms after scheduled time)";     // Catch: Throwable -> L21
        L24:
            th = move-exception;
            r101.cancel(true);
            throw th;
        }

        public Fire(TimeoutFuture<V> r100) {
            this.timeoutFutureRef = r100;
        }

        @Skip({"com.ss.android.ugc.bytex.pthread+"})
        public static void com_google_common_util_concurrent_TimeoutFuture$Fire_com_larus_apm_impl_protector_RunnableLancet_run(Fire r100) {
            r100.com_google_common_util_concurrent_TimeoutFuture$Fire__run$___twin___();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class TimeoutFutureException extends TimeoutException {
        @Override // java.lang.Throwable
        public synchronized Throwable fillInStackTrace() {
            monitor-enter(this);
            setStackTrace(new StackTraceElement[0]);     // Catch: Throwable -> L7
            monitor-exit(this);
            return this;
        L7:
            th = move-exception;
            throw th;
        }

        private TimeoutFutureException(String r100) {
            super(r100);
        }

        public /* synthetic */ TimeoutFutureException(String r100, AnonymousClass1 r101) {
            this(r100);
        }
    }

    @Override // com.google.common.util.concurrent.AbstractFuture
    public void afterDone() {
        maybePropagateCancellationTo(this.delegateRef);
        ScheduledFuture<?> r100 = this.timer;
        if (r100 == null) goto L5;
        r100.cancel(false);
    L5:
        this.delegateRef = null;
        this.timer = null;
    }

    @Override // com.google.common.util.concurrent.AbstractFuture
    @CheckForNull
    public String pendingToString() {
        ListenableFuture<V> r100 = this.delegateRef;
        ScheduledFuture<?> r101 = this.timer;
        if (r100 == null) goto L10;
        String r102 = "inputFuture=[" + r100 + "]";
        if (r101 == null) goto L12;
        long r103 = r101.getDelay(TimeUnit.MILLISECONDS);
        if (r103 > 0) goto L9;
        return r102;
    L9:
        return r102 + ", remaining delay=[" + r103 + " ms]";
    L12:
        return r102;
    L10:
        return null;
    }

    private TimeoutFuture(ListenableFuture<V> r100) {
        r100.getClass();
        this.delegateRef = r100;
    }

    public static /* synthetic */ ListenableFuture access$000(TimeoutFuture r100) {
        return r100.delegateRef;
    }

    public static /* synthetic */ ScheduledFuture access$100(TimeoutFuture r100) {
        return r100.timer;
    }

    public static /* synthetic */ ScheduledFuture access$102(TimeoutFuture r100, ScheduledFuture r101) {
        r100.timer = r101;
        return r101;
    }

    public static <V> ListenableFuture<V> create(ListenableFuture<V> r100, long r101, TimeUnit r102, ScheduledExecutorService r103) {
        TimeoutFuture r104 = new TimeoutFuture(r100);
        Fire r105 = new Fire(r104);
        r104.timer = r103.schedule(r105, r101, r102);
        r100.addListener(r105, MoreExecutors.directExecutor());
        return r104;
    }
}
