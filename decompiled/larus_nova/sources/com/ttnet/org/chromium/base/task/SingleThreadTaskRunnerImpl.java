package com.ttnet.org.chromium.base.task;

import android.os.Handler;
import android.os.Message;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ttnet.org.chromium.base.annotations.JNINamespace;
import com.ttnet.org.chromium.base.metrics.RecordHistogram;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes41.dex */
@JNINamespace("base")
public class SingleThreadTaskRunnerImpl extends TaskRunnerImpl implements SingleThreadTaskRunner {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final Handler mHandler;
    private final boolean mPostPreNativeTasksAtFrontOfQueue;

    @Retention(RetentionPolicy.SOURCE)
    public @interface PreNativeTaskPostType {
        public static final int DEFERRED_TO_NATIVE_INIT = 2;
        public static final int NUM_ENTRIES = 3;
        public static final int POSTED_AT_BACK_OF_QUEUE = 0;
        public static final int POSTED_AT_FRONT_OF_QUEUE = 1;
    }

    private void postAtFrontOfQueue() {
        Message r100 = Message.obtain(this.mHandler, this.mRunPreNativeTaskClosure);
        r100.setAsynchronous(true);
        this.mHandler.sendMessageAtFrontOfQueue(r100);
    }

    @Override // com.ttnet.org.chromium.base.task.TaskRunnerImpl
    public void schedulePreNativeTask() {
        if (this.mHandler != null) goto L7;
        RecordHistogram.recordEnumeratedHistogram("Android.TaskScheduling.PreNativeTaskPostType", 2, 3);
        return;
    L7:
        if (this.mPostPreNativeTasksAtFrontOfQueue == false) goto L9;
        RecordHistogram.recordEnumeratedHistogram("Android.TaskScheduling.PreNativeTaskPostType", 1, 3);
        postAtFrontOfQueue();
        return;
    L9:
        RecordHistogram.recordEnumeratedHistogram("Android.TaskScheduling.PreNativeTaskPostType", 0, 3);
        this.mHandler.post(this.mRunPreNativeTaskClosure);
    }

    @Override // com.ttnet.org.chromium.base.task.SingleThreadTaskRunner
    public boolean belongsToCurrentThread() {
        Boolean r100 = belongsToCurrentThreadInternal();
        if (r100 == null) goto L7;
        return r100.booleanValue();
    L7:
        if (ThreadMethodProxy.getLooperThread(this.mHandler.getLooper()) != ThreadMethodProxy.currentThread()) goto L9;
        return true;
    L9:
        return false;
    }

    static {
    }

    public SingleThreadTaskRunnerImpl(Handler r100, TaskTraits r101) {
        this(r100, r101, false);
    }

    public SingleThreadTaskRunnerImpl(Handler r100, TaskTraits r101, boolean r102) {
        super(r101, "SingleThreadTaskRunnerImpl", 2);
        this.mHandler = r100;
        this.mPostPreNativeTasksAtFrontOfQueue = r102;
    }
}
