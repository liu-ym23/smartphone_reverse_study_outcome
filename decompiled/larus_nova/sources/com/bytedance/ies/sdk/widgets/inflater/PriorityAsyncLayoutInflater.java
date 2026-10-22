package com.bytedance.ies.sdk.widgets.inflater;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.util.Pools;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.proxy.PThreadPoolExecutor;
import java.util.Objects;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes19.dex */
public class PriorityAsyncLayoutInflater implements IAsyncInflater {
    private static final String TAG = "PriorityAsyncInflater";
    private static volatile boolean ignoreInflateAfterContextDestroy;
    private static final ThreadPoolExecutor sExecutor = null;
    Handler mHandler;
    private final Handler.Callback mHandlerCallback;
    LayoutInflater mInflater;
    private final Pools.SynchronizedPool<InflateTask> mTaskPool;

    public static class BasicInflater extends LayoutInflater {
        private static final String[] sClassPrefixList = null;

        static {
            sClassPrefixList = new String[]{"android.widget.", "android.webkit.", "android.app."};
        }

        public BasicInflater(Context r100) {
            super(r100);
        }

        @Override // android.view.LayoutInflater
        public LayoutInflater cloneInContext(Context r100) {
            return new BasicInflater(r100);
        }

        @Override // android.view.LayoutInflater
        public View onCreateView(String r100, AttributeSet r101) throws ClassNotFoundException {
            String[] r102 = sClassPrefixList;
            int r103 = r102.length;
            int r104 = 0;
        L3:
            if (r104 >= r103) goto L10;
            View r105 = createView(r100, r102[r104], r101);     // Catch: ClassNotFoundException -> L11
            if (r105 == null) goto L8;
            return r105;
        L8:
            r104 = r104 + 1;
            goto L3
        L10:
            return super.onCreateView(r100, r101);
        }
    }

    public static class InflateTask implements Runnable {
        private InflateRequest mRequest;

        @Override // java.lang.Runnable
        public void run() {
            com_bytedance_ies_sdk_widgets_inflater_PriorityAsyncLayoutInflater$InflateTask_com_larus_apm_impl_protector_RunnableLancet_run(this);
        }

        private void insetAndSendMessage() {
            Message r100 = Message.obtain(this.mRequest.getInflater().mHandler, 0, this);
            this.mRequest.getInflater().mHandler.sendMessage(r100);
        }

        public void com_bytedance_ies_sdk_widgets_inflater_PriorityAsyncLayoutInflater$InflateTask__run$___twin___() {
            InflateRequest r100 = this.mRequest;
            if (r100 != null) goto L5;
            return;
        L5:
            if (r100.isValid() == false) goto L22;
        L15:
            e = move-exception;
            e.getMessage();
        L17:
            insetAndSendMessage();
            return;
        L8:
            if (shouldInterceptInflateRequest(this.mRequest) == false) goto L13;
            PriorityAsyncLayoutInflater r101 = this.mRequest.getInflater();     // Catch: RuntimeException -> L15
            if (r101 == null) goto L20;
            PriorityAsyncLayoutInflater.access$000(r101, this);     // Catch: RuntimeException -> L15
            return;
        L20:
            return;
        L13:
            View r102 = this.mRequest.getInflater().mInflater.inflate(this.mRequest.getResId(), this.mRequest.getParent(), false);     // Catch: RuntimeException -> L15
            this.mRequest.setView(r102);     // Catch: RuntimeException -> L15
            goto L17
        }

        public void release() {
            this.mRequest.release();
        }

        public InflateRequest getRequest() {
            return this.mRequest;
        }

        private static Activity asActivity(Context r100) {
            if ((r100 instanceof Activity) == false) goto L7;
            return (Activity) r100;
        L7:
            if ((r100 instanceof ContextWrapper) == true) goto L9;
            return null;
        L9:
            return asActivity(((ContextWrapper) r100).getBaseContext());
        }

        @Skip({"com.ss.android.ugc.bytex.pthread+"})
        public static void com_bytedance_ies_sdk_widgets_inflater_PriorityAsyncLayoutInflater$InflateTask_com_larus_apm_impl_protector_RunnableLancet_run(InflateTask r100) {
            r100.com_bytedance_ies_sdk_widgets_inflater_PriorityAsyncLayoutInflater$InflateTask__run$___twin___();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        /* JADX WARN: Multi-variable type inference failed */
        private boolean shouldInterceptInflateRequest(InflateRequest r100) {
            if (r100 != null) goto L6;
            return false;
        L6:
            if (PriorityAsyncLayoutInflater.access$100() == true) goto L8;
            return false;
        L8:
            PriorityAsyncLayoutInflater r101 = r100.getInflater();
            if (r101 != null) goto L11;
            return false;
        L11:
            LayoutInflater r102 = r101.mInflater;
            if (r102 != null) goto L14;
            return false;
        L14:
            Context r103 = r102.getContext();
            Activity r104 = asActivity(r103);
            if (r104 == null) goto L23;
            if (r104.isDestroyed() == false) goto L19;
        L20:
            r104.toString();
            r100.getResId();
            return true;
        L19:
            if (r104.isFinishing() == true) goto L20;
        L23:
            if ((r103 instanceof LifecycleOwner) == false) goto L30;
            Lifecycle r105 = ((LifecycleOwner) r103).getLifecycle();
            if (r105 == null) goto L30;
            if (r105.getCurrentState() != Lifecycle.State.DESTROYED) goto L30;
            Objects.toString(r103);
            r100.getResId();
            return true;
        L30:
            return false;
        }

        public InflateTask(PriorityAsyncLayoutInflater r100, int r101, ViewGroup r102, androidx.asynclayoutinflater.view.AsyncLayoutInflater.OnInflateFinishedListener r103) {
            this.mRequest = new InflateRequest(r100, r101, r102, r103);
        }

        public void reBindRequest(PriorityAsyncLayoutInflater r100, int r101, ViewGroup r102, androidx.asynclayoutinflater.view.AsyncLayoutInflater.OnInflateFinishedListener r103) {
            InflateRequest r104 = this.mRequest;
            if (r104 == null) goto L5;
            r104.reBind(r100, r101, r102, r103);
            return;
        L5:
            this.mRequest = new InflateRequest(r100, r101, r102, r103);
        }
    }

    static {
        sExecutor = new PThreadPoolExecutor(1, Runtime.getRuntime().availableProcessors(), 30, TimeUnit.SECONDS, new LinkedBlockingQueue(), new HighPriorityThreadFactory());
    }

    public static /* synthetic */ boolean access$100() {
        return ignoreInflateAfterContextDestroy;
    }

    public PriorityAsyncLayoutInflater(Context r100) {
        this.mTaskPool = new Pools.SynchronizedPool(10);
        Handler.Callback r101 = new AnonymousClass1(this);
        this.mHandlerCallback = r101;
        this.mInflater = new BasicInflater(r100);
        this.mHandler = new Handler(r101);
    }

    private void releaseTask(InflateTask r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        r100.release();
        this.mTaskPool.release(r100);     // Catch: IllegalStateException -> L7
        return;
    }

    public static void setIgnoreInflateAfterContextDestroy(boolean r100) {
        ignoreInflateAfterContextDestroy = r100;
    }

    public static /* synthetic */ void access$000(PriorityAsyncLayoutInflater r100, InflateTask r101) {
        r100.releaseTask(r101);
    }

    private InflateTask obtainTask(int r100, ViewGroup r101, androidx.asynclayoutinflater.view.AsyncLayoutInflater.OnInflateFinishedListener r102) {
        InflateTask r103 = this.mTaskPool.acquire();
        if (r103 == null) goto L7;
        r103.reBindRequest(this, r100, r101, r102);
        return r103;
    L7:
        return new InflateTask(this, r100, r101, r102);
    }

    @Override // com.bytedance.ies.sdk.widgets.inflater.IAsyncInflater
    public void inflate(int r100, ViewGroup r101, androidx.asynclayoutinflater.view.AsyncLayoutInflater.OnInflateFinishedListener r102) {
        if (r102 != null) goto L4;
        return;
    L4:
        InflateTask r103 = obtainTask(r100, r101, r102);
        sExecutor.submit(r103);
    }
}
