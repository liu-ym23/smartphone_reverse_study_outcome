package com.huawei.hmf.tasks;

/* JADX INFO: loaded from: classes23.dex */
public abstract class CancellationToken {
    public CancellationToken() {
    }

    public abstract boolean isCancellationRequested();

    public abstract CancellationToken register(Runnable r100);
}
