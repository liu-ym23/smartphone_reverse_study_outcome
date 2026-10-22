package com.google.android.gms.tasks;

/* JADX INFO: loaded from: classes23.dex */
public abstract class CancellationToken {
    public CancellationToken() {
    }

    public abstract boolean isCancellationRequested();

    public abstract CancellationToken onCanceledRequested(OnTokenCanceledListener r100);
}
