package com.ss.android.ugc.aweme.framework.services.dyext;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\u00020\u0003B\u0005¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"Lcom/ss/android/ugc/aweme/framework/services/dyext/DeferredCancellableJob;", "R", "Lcom/ss/android/ugc/aweme/framework/services/dyext/DeferredJob;", "Lcom/ss/android/ugc/aweme/framework/services/dyext/CancellableJob;", "()V", "cancel", "", "dy-ext-spi_release"}, k = 1, mv = {1, 1, 15})
public final class DeferredCancellableJob<R> extends DeferredJob<R> implements CancellableJob {
    @Override // com.ss.android.ugc.aweme.framework.services.dyext.CancellableJob
    public void cancel() {
        getDeferred().cancel();
    }

    public DeferredCancellableJob() {
    }
}
