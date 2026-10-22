package com.bytedance.common.jato.memory.gcblocker;

/* JADX INFO: loaded from: classes3.dex */
public abstract class AbsGcBlocker {
    protected boolean mDisabled;

    public abstract void requestBlockGc(long r100);

    public abstract void setHeapLimit(boolean r100, int r101, int r102);

    public abstract void setMaxGcBlockDuration(int r100);

    public abstract void startBlockGc(String r100);

    public abstract void stopBlockGc(String r100);

    public AbsGcBlocker() {
        this.mDisabled = false;
    }

    public void setDisabled(boolean r100) {
        this.mDisabled = r100;
    }
}
