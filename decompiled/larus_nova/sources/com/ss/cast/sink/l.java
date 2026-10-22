package com.ss.cast.sink;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes40.dex */
public final class l implements Executor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Handler f456477a;

    public l() {
        this.f456477a = new Handler(Looper.getMainLooper());
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable r100) {
        this.f456477a.post(r100);
    }
}
