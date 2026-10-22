package com.ss.android.lark.auditsdk.screen;

import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes34.dex */
public final class f implements Executor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e f409582a;

    public f(e r100) {
        this.f409582a = r100;
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable r100) {
        this.f409582a.f409578c.post(r100);
    }
}
