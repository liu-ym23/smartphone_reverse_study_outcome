package com.ss.android.ugc.bytex.pthread.base.convergence.external;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nH&¨\u0006\u000b"}, d2 = {"Lcom/ss/android/ugc/bytex/pthread/base/convergence/external/IThreadMonitor;", "", "afterLooperPrepared", "", "thread", "Ljava/lang/Thread;", "onThreadExit", "onThreadRunning", "onThreadStart", "type", "", "threadpool-plugin-base_release"}, k = 1, mv = {1, 1, 13})
public interface IThreadMonitor {

    /* JADX INFO: loaded from: classes40.dex */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 1, 13})
    public static final class DefaultImpls {
        public static void afterLooperPrepared(IThreadMonitor r100, Thread r101) {
        }
    }

    void afterLooperPrepared(Thread r100);

    void onThreadExit(Thread r100);

    void onThreadRunning(Thread r100);

    void onThreadStart(Thread r100, int r101);
}
