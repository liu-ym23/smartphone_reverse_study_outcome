package com.ss.android.ugc.aweme.framework.services.dyext;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Deferred;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003R)\u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00060\u0005X\u0086.ø\u0001\u0000¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u000b"}, d2 = {"Lcom/ss/android/ugc/aweme/framework/services/dyext/DeferredJob;", "R", "", "()V", "deferred", "Lkotlinx/coroutines/Deferred;", "Lkotlin/Result;", "getDeferred", "()Lkotlinx/coroutines/Deferred;", "setDeferred", "(Lkotlinx/coroutines/Deferred;)V", "dy-ext-spi_release"}, k = 1, mv = {1, 1, 15})
public class DeferredJob<R> {
    public Deferred<? extends Result<? extends R>> deferred;

    public DeferredJob() {
    }

    public final Deferred<Result<R>> getDeferred() {
        Deferred<? extends Result<? extends R>> r100 = this.deferred;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("deferred");
    L5:
        return r100;
    }

    public final void setDeferred(Deferred<? extends Result<? extends R>> r100) {
        this.deferred = r100;
    }
}
