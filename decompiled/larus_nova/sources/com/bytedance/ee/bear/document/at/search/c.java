package com.bytedance.ee.bear.document.at.search;

import io.reactivex.disposables.Disposable;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: classes16.dex */
public final class c implements Disposable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Job f219124a;

    @Override // io.reactivex.disposables.Disposable
    public final void dispose() {
        Job.DefaultImpls.cancel$default(this.f219124a, null, 1, null);
    }

    @Override // io.reactivex.disposables.Disposable
    public final boolean isDisposed() {
        return !this.f219124a.isActive();
    }

    public c(Job r100) {
        this.f219124a = r100;
    }
}
