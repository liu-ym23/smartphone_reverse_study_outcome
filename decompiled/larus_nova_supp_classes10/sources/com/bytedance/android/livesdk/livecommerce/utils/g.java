package com.bytedance.android.livesdk.livecommerce.utils;

import io.reactivex.disposables.Disposable;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class g implements CoroutineScope, Disposable {
    public final CoroutineContext a;

    public final void dispose() {
        Job r0 = this.a.get(Job.Key);
        if (r0 == null) goto L6;
        JobKt.cancelChildren$default(r0, null, 1, null);
        return;
    }

    public final boolean isDisposed() {
        Job r0 = this.a.get(Job.Key);
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.isCancelled() != true) goto L7;
        return true;
    }

    public final CoroutineContext getCoroutineContext() {
        return this.a;
    }

    public g(CoroutineContext r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this.a = r2;
    }
}
