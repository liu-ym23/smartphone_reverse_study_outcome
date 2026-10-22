package com.ss.android.ugc.bytex.pthread.base.convergence.executor;

import com.ss.android.ugc.bytex.pthread.base.convergence.dredge.IDredgeStrategy;
import com.ss.android.ugc.bytex.pthread.base.convergence.external.IThreadExecutePolicy;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\bf\u0018\u00002\u00020\u0001J>\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u000eH&¨\u0006\u000f"}, d2 = {"Lcom/ss/android/ugc/bytex/pthread/base/convergence/executor/IResourceExecutorFactory;", "", "create", "Lcom/ss/android/ugc/bytex/pthread/base/convergence/executor/IResourceExecutor;", "threadPrefix", "", "minSize", "", "maxSize", "dredgeStrategy", "Lcom/ss/android/ugc/bytex/pthread/base/convergence/dredge/IDredgeStrategy;", "threadExecutePolicy", "Lcom/ss/android/ugc/bytex/pthread/base/convergence/external/IThreadExecutePolicy;", "keepAliveTime", "", "threadpool-plugin-base_release"}, k = 1, mv = {1, 1, 13})
public interface IResourceExecutorFactory {
    IResourceExecutor create(String r100, int r101, int r102, IDredgeStrategy r103, IThreadExecutePolicy r104, long r105);
}
