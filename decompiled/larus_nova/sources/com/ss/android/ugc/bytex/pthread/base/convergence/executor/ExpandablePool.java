package com.ss.android.ugc.bytex.pthread.base.convergence.executor;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0005H&J\b\u0010\u0007\u001a\u00020\u0005H&J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0005H&¨\u0006\u000b"}, d2 = {"Lcom/ss/android/ugc/bytex/pthread/base/convergence/executor/ExpandablePool;", "", "getConsumeCount", "", "getMaxPoolSize", "", "getPendingCount", "getPoolSize", "setMaxPoolSize", "", "maxPoolSize", "threadpool-plugin-base_release"}, k = 1, mv = {1, 1, 13})
public interface ExpandablePool {
    long getConsumeCount();

    int getMaxPoolSize();

    int getPendingCount();

    int getPoolSize();

    void setMaxPoolSize(int r100);
}
