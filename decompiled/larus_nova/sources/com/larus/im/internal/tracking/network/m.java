package com.larus.im.internal.tracking.network;

import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: classes30.dex */
public final class m implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Job f350428a;

    @Override // com.larus.im.internal.tracking.network.d
    public final void cancel() {
        Job.DefaultImpls.cancel$default(this.f350428a, null, 1, null);
    }

    public m(Job r100) {
        this.f350428a = r100;
    }
}
