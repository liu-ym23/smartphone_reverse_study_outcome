package com.ss.android.ugc.bytex.pthread.base.convergence.executor;

import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\u0014\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003H&J\b\u0010\u0005\u001a\u00020\u0006H&J\b\u0010\u0007\u001a\u00020\u0004H&J\b\u0010\b\u001a\u00020\u0006H&J\b\u0010\t\u001a\u00020\u0006H&J\b\u0010\n\u001a\u00020\u0006H&J\b\u0010\u000b\u001a\u00020\u0006H&¨\u0006\f"}, d2 = {"Lcom/ss/android/ugc/bytex/pthread/base/convergence/executor/Instrumentation;", "", "extra", "", "", "getMaxThreadSize", "", "getName", "getPendingSize", "getReleaseSize", "getThreadSize", "getWaiterSize", "threadpool-plugin-base_release"}, k = 1, mv = {1, 1, 13})
public interface Instrumentation {
    Map<String, String> extra();

    int getMaxThreadSize();

    String getName();

    int getPendingSize();

    int getReleaseSize();

    int getThreadSize();

    int getWaiterSize();
}
