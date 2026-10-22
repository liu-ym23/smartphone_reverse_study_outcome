package com.ss.android.ugc.bytex.pthread.base.convergence.scheduler;

import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\u0005\u001a\u00020\u0006H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/ss/android/ugc/bytex/pthread/base/convergence/scheduler/PriorityThread;", "Lcom/ss/android/ugc/bytex/pthread/base/proxy/PthreadThreadV2;", "Lcom/ss/android/ugc/bytex/pthread/base/convergence/scheduler/PriorityProvider;", "runnable", "Ljava/lang/Runnable;", "priorityAffinity", "", "(Ljava/lang/Runnable;I)V", "threadpool-plugin-base_release"}, k = 1, mv = {1, 1, 13})
public final class PriorityThread extends PthreadThreadV2 {
    private final int priorityAffinity;

    public PriorityThread(Runnable r100, int r101) {
        super(r100);
        this.priorityAffinity = r101;
    }

    @Override // com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadProxyWrapper, com.ss.android.ugc.bytex.pthread.base.convergence.scheduler.PriorityProvider
    public int priorityAffinity() {
        return this.priorityAffinity;
    }
}
