package com.ss.android.ugc.bytex.pthread.base.convergence.executor;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H&¨\u0006\u0007"}, d2 = {"Lcom/ss/android/ugc/bytex/pthread/base/convergence/executor/IAdaptiveExecutor;", "Lcom/ss/android/ugc/bytex/pthread/base/convergence/executor/IResourceExecutor;", "updateAdaptiveRange", "", "minSize", "", "maxSize", "threadpool-plugin-base_release"}, k = 1, mv = {1, 1, 13})
public interface IAdaptiveExecutor extends IResourceExecutor {
    void updateAdaptiveRange(int r100, int r101);
}
