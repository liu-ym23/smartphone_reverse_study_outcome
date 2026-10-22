package com.obric.sva.sdk.utils;

import android.os.Handler;
import android.os.Looper;
import android.os.Trace;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes6.dex */
public class ThreadUtil {

    /* JADX INFO: loaded from: classes34.dex */
    public static class HandlerHolder {
        public static final Handler sInstance = null;

        static {
            sInstance = new Handler(Looper.getMainLooper());
        }

        private HandlerHolder() {
        }
    }

    /* JADX INFO: loaded from: classes34.dex */
    public static abstract class TraceTask implements Runnable {
        private final String mTraceName;

        @Override // java.lang.Runnable
        public void run() {
            com_obric_sva_sdk_utils_ThreadUtil$TraceTask_com_larus_apm_impl_protector_RunnableLancet_run(this);
        }

        public abstract void runTask();

        public void com_obric_sva_sdk_utils_ThreadUtil$TraceTask__run$___twin___() {
            Trace.beginSection(this.mTraceName);
            runTask();
            Trace.endSection();
        }

        public TraceTask(String r100) {
            this.mTraceName = r100;
        }

        @Skip({"com.ss.android.ugc.bytex.pthread+"})
        public static void com_obric_sva_sdk_utils_ThreadUtil$TraceTask_com_larus_apm_impl_protector_RunnableLancet_run(TraceTask r100) {
            r100.com_obric_sva_sdk_utils_ThreadUtil$TraceTask__run$___twin___();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static class WorkHandlerHolder {
        public static Handler INSTANCE;
        public static Handler MD_INSTANCE;

        private static Handler getHandler() {
            PthreadHandlerThreadV2 r100 = new PthreadHandlerThreadV2("Work-thread");
            ThreadMethodProxy.start(r100);
            return new Handler(r100.getLooper());
        }

        private static Handler getMDHandler() {
            PthreadHandlerThreadV2 r100 = new PthreadHandlerThreadV2("MD-Work-thread");
            ThreadMethodProxy.start(r100);
            return new Handler(r100.getLooper());
        }

        static {
            INSTANCE = getHandler();
            MD_INSTANCE = getMDHandler();
        }

        private WorkHandlerHolder() {
        }
    }

    public ThreadUtil() {
    }

    public static Handler getMDWorkHandler() {
        return WorkHandlerHolder.MD_INSTANCE;
    }

    public static Handler getUiThreadHandler() {
        return HandlerHolder.sInstance;
    }

    public static Handler getWorkHandler() {
        return WorkHandlerHolder.INSTANCE;
    }

    public static void checkAndRunOnUiThread(Runnable r100) {
        if (Looper.myLooper() != Looper.getMainLooper()) goto L5;
        r100.run();
        return;
    L5:
        postOnUiThread(r100);
    }

    public static void postOnUiThread(Runnable r100) {
        getUiThreadHandler().post(r100);
    }

    public static void postOnWorkThread(Runnable r100) {
        getWorkHandler().post(r100);
    }

    public static void removeCallbacksOnWorkThread(Runnable r100) {
        getWorkHandler().removeCallbacks(r100);
    }

    public static void postDelayedOnUiThread(Runnable r100, long r101) {
        getUiThreadHandler().postDelayed(r100, r101);
    }

    public static void postDelayedOnWorkThread(Runnable r100, long r101) {
        getWorkHandler().postDelayed(r100, r101);
    }
}
