package com.larksuite.framework.callback;

import com.larksuite.framework.callback.ICallback;

/* JADX INFO: loaded from: classes24.dex */
public abstract class CancelableCallback<T extends ICallback> implements ICancelableCallback {
    protected T callback;
    private boolean isCanceled;

    @Override // com.larksuite.framework.callback.ICancelable
    public void cancel() {
        this.isCanceled = true;
        this.callback = null;
    }

    public CancelableCallback() {
        this.isCanceled = false;
    }

    @Override // com.larksuite.framework.callback.ICancelable
    public boolean isCanceled() {
        return this.isCanceled;
    }

    public CancelableCallback(T r100) {
        this.isCanceled = false;
        this.callback = r100;
    }
}
