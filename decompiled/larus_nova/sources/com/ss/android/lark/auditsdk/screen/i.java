package com.ss.android.lark.auditsdk.screen;

import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes34.dex */
public final class i implements Executor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ h f409591a;

    public i(h r100) {
        this.f409591a = r100;
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable r100) {
        this.f409591a.f409588e.post(r100);
    }
}
