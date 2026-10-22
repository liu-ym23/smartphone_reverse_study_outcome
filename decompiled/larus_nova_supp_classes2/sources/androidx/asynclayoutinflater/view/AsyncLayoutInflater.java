package androidx.asynclayoutinflater.view;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.util.Pools;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import java.util.Iterator;
import java.util.Objects;
import java.util.concurrent.ArrayBlockingQueue;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public final class AsyncLayoutInflater {
    private static final String TAG = "AsyncLayoutInflater";
    private static volatile boolean ignoreInflateAfterContextDestroy;
    private static LifecycleCallbacks lifecycleCallbacks;
    Handler mHandler;
    private Handler.Callback mHandlerCallback;
    InflateThread mInflateThread;
    LayoutInflater mInflater;

    public static class BasicInflater extends LayoutInflater {
        private static final String[] sClassPrefixList = null;

        static {
            sClassPrefixList = new String[]{"android.widget.", "android.webkit.", "android.app."};
        }

        public BasicInflater(Context r1) {
            super(r1);
        }

        @Override // android.view.LayoutInflater
        public LayoutInflater cloneInContext(Context r2) {
            return new BasicInflater(r2);
        }

        @Override // android.view.LayoutInflater
        public View onCreateView(String r5, AttributeSet r6) throws ClassNotFoundException {
            String[] r0 = sClassPrefixList;
            int r1 = r0.length;
            int r2 = 0;
        L3:
            if (r2 >= r1) goto L10;
            View r3 = createView(r5, r0[r2], r6);     // Catch: ClassNotFoundException -> L11
            if (r3 == null) goto L8;
            return r3;
        L8:
            r2 = r2 + 1;
            goto L3
        L10:
            return super.onCreateView(r5, r6);
        }
    }

    public static class InflateRequest {
        OnInflateFinishedListener callback;
        volatile AsyncLayoutInflater inflater;
        ViewGroup parent;
        int resid;
        View view;

        public InflateRequest() {
        }
    }

    public static class InflateThread extends PthreadThreadV2 {
        private static final InflateThread sInstance = null;
        private ArrayBlockingQueue<InflateRequest> mQueue;
        private Pools.SynchronizedPool<InflateRequest> mRequestPool;

        public void run() {
            androidx_asynclayoutinflater_view_AsyncLayoutInflater$InflateThread_com_larus_apm_impl_protector_RunnableLancet_run(this);
        }

        /* JADX WARN: Type inference failed for: r0v0, types: [androidx.asynclayoutinflater.view.AsyncLayoutInflater$InflateThread, java.lang.Thread] */
        static {
            ?? r0 = new InflateThread();
            sInstance = r0;
            ThreadMethodProxy.start(r0);
        }

        private InflateThread() {
            super("AsyncLayoutInflater$InflateThread");
            this.mQueue = new ArrayBlockingQueue(10);
            this.mRequestPool = new Pools.SynchronizedPool(10);
        }

        public InflateRequest obtainRequest() {
            InflateRequest r0 = (InflateRequest) this.mRequestPool.acquire();
            if (r0 == null) goto L5;
            return r0;
        L5:
            return new InflateRequest();
        }

        public void runInner() {
            InflateRequest r0 = this.mQueue.take();     // Catch: InterruptedException -> L18
            if (shouldInterceptInflateRequest(r0) == false) goto L8;
            OnInflateFinishedListener r1 = r0.callback;
            int r2 = r0.resid;
            releaseRequest(r0);
            AsyncLayoutInflater.access$300(r1, r2);
            return;
        L8:
            if (r0.inflater != null) goto L21;
            return;
        L21:
            r0.view = r0.inflater.mInflater.inflate(r0.resid, r0.parent, false);     // Catch: RuntimeException -> L13
        L16:
            Message.obtain(r0.inflater.mHandler, 0, r0).sendToTarget();
            return;
        L14:
            if (r0.inflater != null) goto L16;
            return;
        }

        public static InflateThread getInstance() {
            return sInstance;
        }

        public void androidx_asynclayoutinflater_view_AsyncLayoutInflater$InflateThread__run$___twin___() {
        L2:
            runInner();
            goto L2
        }

        public static /* synthetic */ ArrayBlockingQueue access$100(InflateThread r0) {
            return r0.mQueue;
        }

        @Skip({"com.ss.android.ugc.bytex.pthread+"})
        public static void androidx_asynclayoutinflater_view_AsyncLayoutInflater$InflateThread_com_larus_apm_impl_protector_RunnableLancet_run(InflateThread r1) {
            r1.androidx_asynclayoutinflater_view_AsyncLayoutInflater$InflateThread__run$___twin___();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        private boolean shouldInterceptInflateRequest(InflateRequest r5) {
            if (r5 != null) goto L6;
            return false;
        L6:
            if (AsyncLayoutInflater.access$400() == true) goto L8;
            return false;
        L8:
            AsyncLayoutInflater r6 = r5.inflater;
            if (r6 != null) goto L11;
            return false;
        L11:
            LayoutInflater r7 = r6.mInflater;
            if (r7 != null) goto L14;
            return false;
        L14:
            LifecycleOwner r8 = r7.getContext();
            Activity r1 = AsyncLayoutInflater.access$200(r8);
            if (r1 == null) goto L23;
            if (r1.isDestroyed() == false) goto L19;
        L20:
            r1.toString();
            return true;
        L19:
            if (r1.isFinishing() == true) goto L20;
        L23:
            if ((r8 instanceof LifecycleOwner) == false) goto L30;
            Lifecycle r2 = r8.getLifecycle();
            if (r2 == null) goto L30;
            if (r2.getCurrentState() != Lifecycle.State.DESTROYED) goto L30;
            Objects.toString(r8);
            return true;
        L30:
            return false;
        }

        public void enqueue(InflateRequest r3) {
            this.mQueue.put(r3);     // Catch: InterruptedException -> L4
            return;
        L4:
            e = move-exception;
            throw new RuntimeException("Failed to enqueue async inflate request", e);
        }

        public void releaseRequest(InflateRequest r3) {
            r3.callback = null;
            r3.inflater = null;
            r3.parent = null;
            r3.resid = 0;
            r3.view = null;
            this.mRequestPool.release(r3);     // Catch: IllegalStateException -> L5
            return;
        }
    }

    public static final class LifecycleCallbacks implements Application.ActivityLifecycleCallbacks {
        private LifecycleCallbacks() {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity r1, Bundle r2) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity r1) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity r1) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity r1, Bundle r2) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity r1) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity r1) {
        }

        public /* synthetic */ LifecycleCallbacks(AnonymousClass1 r1) {
            this();
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity r6) {
            SystemClock.uptimeMillis();     // Catch: Throwable -> L16
            InflateThread r0 = InflateThread.getInstance();     // Catch: Throwable -> L16
            Iterator r1 = InflateThread.access$100(r0).iterator();     // Catch: Throwable -> L16
        L4:
            if (r1.hasNext() == false) goto L14;
            InflateRequest r2 = (InflateRequest) r1.next();     // Catch: Throwable -> L16
            AsyncLayoutInflater r3 = r2.inflater;     // Catch: Throwable -> L16
            if (r3 == null) goto L4;
            LayoutInflater r4 = r3.mInflater;     // Catch: Throwable -> L16
            if (r4 == null) goto L4;
            if (AsyncLayoutInflater.access$200(r4.getContext()) != r6) goto L4;
            r1.remove();     // Catch: Throwable -> L16
            r2.inflater = null;     // Catch: Throwable -> L16
            OnInflateFinishedListener r5 = r2.callback;     // Catch: Throwable -> L16
            int r7 = r2.resid;     // Catch: Throwable -> L16
            r0.releaseRequest(r2);     // Catch: Throwable -> L16
            AsyncLayoutInflater.access$300(r5, r7);     // Catch: Throwable -> L16
            Objects.toString(r6);     // Catch: Throwable -> L16
            goto L4
        L14:
            SystemClock.uptimeMillis();     // Catch: Throwable -> L16
            return;
        }
    }

    public interface OnInflateFinishedListener {

        /* JADX INFO: renamed from: androidx.asynclayoutinflater.view.AsyncLayoutInflater$OnInflateFinishedListener$-CC, reason: invalid class name */
        public final /* synthetic */ class CC {
            public static void $default$onCancel(OnInflateFinishedListener r0, int r1) {
            }
        }

        void onCancel(int r1);

        void onInflateFinished(View r1, int r2, ViewGroup r3);
    }

    public static /* synthetic */ boolean access$400() {
        return ignoreInflateAfterContextDestroy;
    }

    public AsyncLayoutInflater(Context r2) {
        this.mHandlerCallback = new AnonymousClass1(this);
        this.mInflater = new BasicInflater(r2);
        this.mHandler = new Handler(this.mHandlerCallback);
        this.mInflateThread = InflateThread.getInstance();
    }

    public static /* synthetic */ Activity access$200(Context r0) {
        return asActivity(r0);
    }

    private static Activity asActivity(Context r1) {
        if ((r1 instanceof Activity) == false) goto L7;
        return (Activity) r1;
    L7:
        if ((r1 instanceof ContextWrapper) == true) goto L9;
        return null;
    L9:
        return asActivity(((ContextWrapper) r1).getBaseContext());
    }

    public static void setIgnoreInflateAfterContextDestroy(boolean r0) {
        ignoreInflateAfterContextDestroy = r0;
    }

    public static /* synthetic */ void access$300(OnInflateFinishedListener r0, int r1) {
        notifyCancel(r0, r1);
    }

    private static void notifyCancel(OnInflateFinishedListener r0, int r1) {
        if (r0 != null) goto L7;
        return;
    L7:
        r0.onCancel(r1);     // Catch: Throwable -> L6
        return;
    }

    public static void setClearRelatedInflateRequestAfterActivityDestroy(Application r2, boolean r3) {
        if (r2 != null) goto L5;
        return;
    L5:
        monitor-enter(AsyncLayoutInflater.class);
        AnonymousClass1 r1 = null;
        if (r3 == true) goto L9;
        Application.ActivityLifecycleCallbacks r4 = lifecycleCallbacks;     // Catch: Throwable -> L16
        if (r4 == null) goto L14;
        r2.unregisterActivityLifecycleCallbacks(r4);     // Catch: Throwable -> L16
        lifecycleCallbacks = null;     // Catch: Throwable -> L16
    L14:
        monitor-exit(AsyncLayoutInflater.class);     // Catch: Throwable -> L16
        return;
    L9:
        if (lifecycleCallbacks != null) goto L14;
        LifecycleCallbacks r5 = new LifecycleCallbacks(r1);     // Catch: Throwable -> L16
        lifecycleCallbacks = r5;     // Catch: Throwable -> L16
        r2.registerActivityLifecycleCallbacks(r5);     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        throw th;
    }

    public void inflate(int r2, ViewGroup r3, OnInflateFinishedListener r4) {
        if (r4 == null) goto L6;
        InflateRequest r0 = this.mInflateThread.obtainRequest();
        r0.inflater = this;
        r0.resid = r2;
        r0.parent = r3;
        r0.callback = r4;
        this.mInflateThread.enqueue(r0);
        return;
    L6:
        throw new NullPointerException("callback argument may not be null!");
    }
}
