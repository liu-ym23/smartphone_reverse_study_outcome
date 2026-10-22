package com.facebook.common.executors;

/* JADX INFO: loaded from: classes22.dex */
public abstract class AbstractPriorityRunnable implements PriorityRunnable {
    private int mPriority;

    public AbstractPriorityRunnable() {
        this.mPriority = 1;
    }

    @Override // com.facebook.common.executors.PriorityRunnable
    public int getPriority() {
        return this.mPriority;
    }

    public AbstractPriorityRunnable(int r100) {
        this.mPriority = r100;
    }
}
