package com.ss.android.lark.conditional.access.auth.v2.service;

import android.os.MessageQueue;

/* JADX INFO: loaded from: classes35.dex */
public final class l implements MessageQueue.IdleHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PolicyCacheService f417913a;

    public l(PolicyCacheService r100) {
        this.f417913a = r100;
    }

    @Override // android.os.MessageQueue.IdleHandler
    public final boolean queueIdle() {
        this.f417913a.i();
        return false;
    }
}
