package com.ttnet.org.chromium.net.impl;

import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ttnet.org.chromium.net.InlineExecutionProhibitedException;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.concurrent.Executor;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes41.dex */
public final class JavaUrlRequestUtils {

    /* JADX INFO: renamed from: com.ttnet.org.chromium.net.impl.JavaUrlRequestUtils$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public interface CheckedRunnable {
        void run() throws Exception;
    }

    public static final class DirectPreventingExecutor implements Executor {
        private final Executor mDelegate;

        public static final class InlineCheckingRunnable implements Runnable {
            private Thread mCallingThread;
            private final Runnable mCommand;
            private InlineExecutionProhibitedException mExecutedInline;

            @Override // java.lang.Runnable
            public void run() {
                com_ttnet_org_chromium_net_impl_JavaUrlRequestUtils$DirectPreventingExecutor$InlineCheckingRunnable_com_larus_apm_impl_protector_RunnableLancet_run(this);
            }

            public void com_ttnet_org_chromium_net_impl_JavaUrlRequestUtils$DirectPreventingExecutor$InlineCheckingRunnable__run$___twin___() {
                if (ThreadMethodProxy.currentThread() != this.mCallingThread) goto L6;
                this.mExecutedInline = new InlineExecutionProhibitedException();
                return;
            L6:
                this.mCommand.run();
            }

            public static /* synthetic */ InlineExecutionProhibitedException access$100(InlineCheckingRunnable r100) {
                return r100.mExecutedInline;
            }

            @Skip({"com.ss.android.ugc.bytex.pthread+"})
            public static void com_ttnet_org_chromium_net_impl_JavaUrlRequestUtils$DirectPreventingExecutor$InlineCheckingRunnable_com_larus_apm_impl_protector_RunnableLancet_run(InlineCheckingRunnable r100) {
                r100.com_ttnet_org_chromium_net_impl_JavaUrlRequestUtils$DirectPreventingExecutor$InlineCheckingRunnable__run$___twin___();     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }

            private InlineCheckingRunnable(Runnable r100, Thread r101) {
                this.mCommand = r100;
                this.mCallingThread = r101;
            }

            public static /* synthetic */ Thread access$202(InlineCheckingRunnable r100, Thread r101) {
                r100.mCallingThread = r101;
                return r101;
            }

            public /* synthetic */ InlineCheckingRunnable(Runnable r100, Thread r101, AnonymousClass1 r102) {
                this(r100, r101);
            }
        }

        public DirectPreventingExecutor(Executor r100) {
            this.mDelegate = r100;
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable r100) {
            InlineCheckingRunnable r101 = new InlineCheckingRunnable(r100, ThreadMethodProxy.currentThread(), null);
            this.mDelegate.execute(r101);
            if (InlineCheckingRunnable.access$100(r101) != null) goto L7;
            InlineCheckingRunnable.access$202(r101, null);
            return;
        L7:
            throw InlineCheckingRunnable.access$100(r101);
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface State {
        public static final int AWAITING_FOLLOW_REDIRECT = 3;
        public static final int AWAITING_READ = 4;
        public static final int CANCELLED = 8;
        public static final int COMPLETE = 7;
        public static final int ERROR = 6;
        public static final int NOT_STARTED = 0;
        public static final int READING = 5;
        public static final int REDIRECT_RECEIVED = 2;
        public static final int STARTED = 1;
    }

    public JavaUrlRequestUtils() {
    }
}
