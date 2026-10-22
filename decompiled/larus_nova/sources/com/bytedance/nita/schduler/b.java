package com.bytedance.nita.schduler;

import android.os.MessageQueue;

/* JADX INFO: loaded from: classes21.dex */
public final class b implements MessageQueue.IdleHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a f266011a;

    public b(a r100) {
        this.f266011a = r100;
    }

    @Override // android.os.MessageQueue.IdleHandler
    public final boolean queueIdle() {
        this.f266011a.e();
        return true;
    }
}
