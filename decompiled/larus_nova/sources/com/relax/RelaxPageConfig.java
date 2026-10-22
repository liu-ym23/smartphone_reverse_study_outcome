package com.relax;

/* JADX INFO: loaded from: classes34.dex */
public class RelaxPageConfig {
    private boolean mEnableFlatten;
    private boolean mEnableLayoutOnly;
    private boolean mForceImageAsyncRequest;

    public RelaxPageConfig() {
    }

    public boolean isEnableFlatten() {
        return this.mEnableFlatten;
    }

    public boolean isEnableLayoutOnly() {
        return this.mEnableLayoutOnly;
    }

    public boolean isForceImageAsyncRequest() {
        return this.mForceImageAsyncRequest;
    }

    public void setEnableFlatten(boolean r100) {
        this.mEnableFlatten = r100;
    }

    public void setEnableLayoutOnly(boolean r100) {
        this.mEnableLayoutOnly = r100;
    }

    public void setForceImageAsyncRequest(boolean r100) {
        this.mForceImageAsyncRequest = r100;
    }
}
