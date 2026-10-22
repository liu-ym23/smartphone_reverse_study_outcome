package com.facebook.imagepipeline.request;

/* JADX INFO: loaded from: classes23.dex */
public abstract class BaseRepeatedPostProcessor extends BasePostprocessor implements RepeatedPostprocessor {
    private RepeatedPostprocessorRunner mCallback;

    private synchronized RepeatedPostprocessorRunner getCallback() {
        monitor-enter(this);
        RepeatedPostprocessorRunner r100 = this.mCallback;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r100;
    L6:
        th = move-exception;
        throw th;
    }

    public void update() {
        RepeatedPostprocessorRunner r100 = getCallback();
        if (r100 == null) goto L6;
        r100.update();
        return;
    }

    public BaseRepeatedPostProcessor() {
    }

    @Override // com.facebook.imagepipeline.request.RepeatedPostprocessor
    public synchronized void setCallback(RepeatedPostprocessorRunner r100) {
        monitor-enter(this);
        this.mCallback = r100;     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }
}
