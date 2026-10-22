package com.ttnet.org.chromium.net;

import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes6.dex */
public abstract class NetworkQualityRttListener {
    private final Executor mExecutor;

    public abstract void onRttObservation(int r100, long r101, int r102);

    public Executor getExecutor() {
        return this.mExecutor;
    }

    public NetworkQualityRttListener(Executor r100) {
        if (r100 == null) goto L7;
        this.mExecutor = r100;
        return;
    L7:
        throw new IllegalStateException("Executor must not be null");
    }
}
