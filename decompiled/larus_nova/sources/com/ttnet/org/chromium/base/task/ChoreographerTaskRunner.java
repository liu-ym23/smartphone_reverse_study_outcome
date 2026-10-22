package com.ttnet.org.chromium.base.task;

import android.view.Choreographer;

/* JADX INFO: loaded from: classes41.dex */
final class ChoreographerTaskRunner implements SingleThreadTaskRunner {
    private final Choreographer mChoreographer;

    @Override // com.ttnet.org.chromium.base.task.SingleThreadTaskRunner
    public boolean belongsToCurrentThread() {
        if (this.mChoreographer != Choreographer.getInstance()) goto L10;
        return true;
    L10:
        return false;
    L11:
        return false;
    }

    public ChoreographerTaskRunner(Choreographer r100) {
        this.mChoreographer = r100;
    }

    @Override // com.ttnet.org.chromium.base.task.TaskRunner
    public void postTask(final Runnable r100) {
        this.mChoreographer.postFrameCallback(new AnonymousClass1(this, r100));
    }

    @Override // com.ttnet.org.chromium.base.task.TaskRunner
    public void postDelayedTask(final Runnable r100, long r101) {
        this.mChoreographer.postFrameCallbackDelayed(new AnonymousClass2(this, r100), r101);
    }
}
