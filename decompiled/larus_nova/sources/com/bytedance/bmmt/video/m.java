package com.bytedance.bmmt.video;

import java.util.concurrent.CountDownLatch;

/* JADX INFO: loaded from: classes8.dex */
public final /* synthetic */ class m implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CountDownLatch f202161a;

    public /* synthetic */ m(CountDownLatch r100) {
        this.f202161a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f202161a.countDown();
    }
}
