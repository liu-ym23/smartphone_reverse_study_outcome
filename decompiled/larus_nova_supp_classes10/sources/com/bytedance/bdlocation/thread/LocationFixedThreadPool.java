package com.bytedance.bdlocation.thread;

import android.os.Build;
import com.bytedance.bdlocation.log.Logger;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.proxy.PThreadPoolExecutor;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public class LocationFixedThreadPool extends PThreadPoolExecutor {
    private static final String STACK_CLASS = "android.telephony.TelephonyManager$1";
    private static final String STACK_METHOD = "lambda$onError$2";
    private static final RejectedExecutionHandler defaultHandler = null;

    public class LocationFixedThreadPoolRunnable implements Runnable {
        private Runnable mRunnable;
        final /* synthetic */ LocationFixedThreadPool this$0;

        @Override // java.lang.Runnable
        public void run() {
            com_bytedance_bdlocation_thread_LocationFixedThreadPool$LocationFixedThreadPoolRunnable_com_larus_apm_impl_protector_RunnableLancet_run(this);
        }

        public void com_bytedance_bdlocation_thread_LocationFixedThreadPool$LocationFixedThreadPoolRunnable__run$___twin___() {
            this.mRunnable.run();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (doInterceptThrowable(th) == false) goto L8;
            return;
        L8:
            Logger.i("LocationFixedThreadPool doInterceptThrowable throw throwable");
            throw th;
        }

        @Skip({"com.ss.android.ugc.bytex.pthread+"})
        public static void com_bytedance_bdlocation_thread_LocationFixedThreadPool$LocationFixedThreadPoolRunnable_com_larus_apm_impl_protector_RunnableLancet_run(LocationFixedThreadPoolRunnable r1) {
            r1.com_bytedance_bdlocation_thread_LocationFixedThreadPool$LocationFixedThreadPoolRunnable__run$___twin___();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        private boolean doInterceptThrowable(Throwable r7) {
            if (r7 != null) goto L5;
            return false;
        L5:
            int r1 = Build.VERSION.SDK_INT;
            if (r1 == 29) goto L9;
            Logger.i("LocationFixedThreadPool versioncode:" + r1);
            return false;
        L9:
            StringBuilder r2 = new StringBuilder("LocationFixedThreadPool throwable instanceof NullPointerException:");
            boolean r3 = r7 instanceof NullPointerException;
            r2.append(r3);
            Logger.i(r2.toString());
            if (r3 == false) goto L30;
            StackTraceElement[] r8 = r7.getStackTrace();
            StringBuilder r4 = new StringBuilder("LocationFixedThreadPool elements:");
            if (r8 != null) goto L14;
            int r5 = 0;
        L15:
            r4.append(r5);
            Logger.i(r4.toString());
            if (r8 == null) goto L30;
            if (r8.length <= 0) goto L30;
            int r6 = r8.length;
            int r9 = 0;
        L20:
            if (r9 >= r6) goto L30;
            StackTraceElement r10 = r8[r9];
            if (r10 == null) goto L29;
            Logger.i("LocationFixedThreadPool element ClassName:" + r10.getClassName() + "--MethodName:" + r10.getMethodName());
            if (LocationFixedThreadPool.STACK_CLASS.equals(r10.getClassName()) == false) goto L29;
            if (LocationFixedThreadPool.STACK_METHOD.equals(r10.getMethodName()) == false) goto L29;
            Logger.i("LocationFixedThreadPool doInterceptThrowable return true");
            return true;
        L29:
            r9 = r9 + 1;
            goto L20
        L14:
            r5 = r8.length;
        L30:
            Logger.i("LocationFixedThreadPool doInterceptThrowable return false");
            return false;
        }

        public LocationFixedThreadPoolRunnable(LocationFixedThreadPool r1, Runnable r2) {
            this.this$0 = r1;
            this.mRunnable = r2;
        }
    }

    static {
        defaultHandler = new ThreadPoolExecutor.AbortPolicy();
    }

    public static ThreadPoolExecutor newFixedThreadPool(int r8) {
        return new LocationFixedThreadPool(r8, r8, 0, TimeUnit.MILLISECONDS, new LinkedBlockingQueue());
    }

    public void execute(Runnable r2) {
        super.execute(new LocationFixedThreadPoolRunnable(this, r2));
    }

    public LocationFixedThreadPool(int r10, int r11, long r12, TimeUnit r14, BlockingQueue<Runnable> r15) {
        super(r10, r11, r12, r14, r15, Executors.defaultThreadFactory(), defaultHandler);
    }
}
