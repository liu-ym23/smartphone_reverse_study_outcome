package com.ss.android.ugc.bytex.pthread.base.convergence.hook;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0002\u0010\bJ\n\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/ss/android/ugc/bytex/pthread/base/convergence/hook/DirectThreadWrapper;", "Lcom/ss/android/ugc/bytex/pthread/base/convergence/hook/ThreadProxyWrapper;", "Lcom/ss/android/ugc/bytex/pthread/base/convergence/scheduler/PriorityProvider;", "delegate", "Ljava/lang/Thread;", "type", "", "priorityAffinity", "(Ljava/lang/Thread;II)V", "threadProxy", "Lcom/ss/android/ugc/bytex/pthread/base/convergence/hook/IThreadProxy;", "getProxy", "threadpool-plugin-base_release"}, k = 1, mv = {1, 1, 13})
public final class DirectThreadWrapper extends ThreadProxyWrapper {
    private final int priorityAffinity;
    private final IThreadProxy threadProxy;

    public DirectThreadWrapper(Thread r100, int r101, int r102) {
        super(null, r100, r100.getName());
        this.priorityAffinity = r102;
        setEnable(true);
        if (getPriority() == r100.getPriority()) goto L5;
        setPriority(r100.getPriority());
    L5:
        this.threadProxy = new ThreadProxy(this, false, r101, 2, null);
    }

    @Override // com.ss.android.ugc.bytex.pthread.base.convergence.hook.IThreadProxyProvider
    public IThreadProxy getProxy() {
        if (isEnable$threadpool_plugin_base_release() == true) goto L7;
        return null;
    L7:
        return this.threadProxy;
    }

    @Override // com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadProxyWrapper, com.ss.android.ugc.bytex.pthread.base.convergence.scheduler.PriorityProvider
    public int priorityAffinity() {
        return this.priorityAffinity;
    }
}
