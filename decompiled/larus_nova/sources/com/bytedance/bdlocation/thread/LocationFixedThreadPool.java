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

/* JADX INFO: loaded from: classes10.dex */
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
        public static void com_bytedance_bdlocation_thread_LocationFixedThreadPool$LocationFixedThreadPoolRunnable_com_larus_apm_impl_protector_RunnableLancet_run(LocationFixedThreadPoolRunnable r100) {
            r100.com_bytedance_bdlocation_thread_LocationFixedThreadPool$LocationFixedThreadPoolRunnable__run$___twin___();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        private boolean doInterceptThrowable(Throwable r100) {
            if (r100 != null) goto L5;
            return false;
        L5:
            int r101 = Build.VERSION.SDK_INT;
            if (r101 == 29) goto L9;
            Logger.i("LocationFixedThreadPool versioncode:" + r101);
            return false;
        L9:
            StringBuilder r102 = new StringBuilder("LocationFixedThreadPool throwable instanceof NullPointerException:");
            boolean r103 = r100 instanceof NullPointerException;
            r102.append(r103);
            Logger.i(r102.toString());
            if (r103 == false) goto L30;
            StackTraceElement[] r104 = r100.getStackTrace();
            StringBuilder r105 = new StringBuilder("LocationFixedThreadPool elements:");
            if (r104 != null) goto L14;
            int r106 = 0;
        L15:
            r105.append(r106);
            Logger.i(r105.toString());
            if (r104 == null) goto L30;
            if (r104.length <= 0) goto L30;
            int r107 = r104.length;
            int r108 = 0;
        L20:
            if (r108 >= r107) goto L30;
            StackTraceElement r109 = r104[r108];
            if (r109 == null) goto L29;
            Logger.i("LocationFixedThreadPool element ClassName:" + r109.getClassName() + "--MethodName:" + r109.getMethodName());
            if (LocationFixedThreadPool.STACK_CLASS.equals(r109.getClassName()) == false) goto L29;
            if (LocationFixedThreadPool.STACK_METHOD.equals(r109.getMethodName()) == false) goto L29;
            Logger.i("LocationFixedThreadPool doInterceptThrowable return true");
            return true;
        L29:
            r108 = r108 + 1;
            goto L20
        L14:
            r106 = r104.length;
        L30:
            Logger.i("LocationFixedThreadPool doInterceptThrowable return false");
            return false;
        }

        public LocationFixedThreadPoolRunnable(LocationFixedThreadPool r100, Runnable r101) {
            this.this$0 = r100;
            this.mRunnable = r101;
        }
    }

    static {
        defaultHandler = new ThreadPoolExecutor.AbortPolicy();
    }

    public static ThreadPoolExecutor newFixedThreadPool(int r100) {
        return new LocationFixedThreadPool(r100, r100, 0, TimeUnit.MILLISECONDS, new LinkedBlockingQueue());
    }

    @Override // com.ss.android.ugc.bytex.pthread.base.proxy.PThreadPoolExecutor, java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.Executor
    public void execute(Runnable r100) {
        super.execute(new LocationFixedThreadPoolRunnable(this, r100));
    }

    public LocationFixedThreadPool(int r110, int r111, long r112, TimeUnit r113, BlockingQueue<Runnable> r114) {
        super(r110, r111, r112, r113, r114, Executors.defaultThreadFactory(), defaultHandler);
    }
}
