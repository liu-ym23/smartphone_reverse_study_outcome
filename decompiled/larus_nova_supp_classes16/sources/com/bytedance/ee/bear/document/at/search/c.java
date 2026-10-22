package com.bytedance.ee.bear.document.at.search;

import io.reactivex.disposables.Disposable;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class c implements Disposable {
    public final /* synthetic */ Job a;

    public final void dispose() {
        Job.DefaultImpls.cancel$default(this.a, null, 1, null);
    }

    public final boolean isDisposed() {
        return !this.a.isActive();
    }

    public c(Job r1) {
        this.a = r1;
    }
}
