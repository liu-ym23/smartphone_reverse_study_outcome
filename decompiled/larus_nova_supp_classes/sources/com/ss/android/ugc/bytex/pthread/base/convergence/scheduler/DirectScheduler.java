package com.ss.android.ugc.bytex.pthread.base.convergence.scheduler;

import android.util.EventsUtils;
import com.ss.android.ugc.bytex.pthread.base.convergence.executor.DefaultThreadPoolExecutor;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0016\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0002\u001a\u00020\u0003R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0006X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0007¨\u0006\u0010"}, d2 = {"Lcom/ss/android/ugc/bytex/pthread/base/convergence/scheduler/DirectScheduler;", "Lcom/ss/android/ugc/bytex/pthread/base/convergence/scheduler/Scheduler;", "executor", "Ljava/util/concurrent/Executor;", "(Ljava/util/concurrent/Executor;)V", "executorOfType", XmlPullParser.NO_NAMESPACE, "[Ljava/util/concurrent/Executor;", "scheduling", XmlPullParser.NO_NAMESPACE, "type", XmlPullParser.NO_NAMESPACE, "runnable", "Lcom/ss/android/ugc/bytex/pthread/base/convergence/scheduler/PriorityRunnable;", "setExecutor", XmlPullParser.NO_NAMESPACE, "threadpool-plugin-base_release"}, k = 1, mv = {1, 1, EventsUtils.FEAT_TYPE_PERF_COMMON_DATA})
public final class DirectScheduler implements Scheduler {
    private final Executor executor;
    private final Executor[] executorOfType;

    /* JADX WARN: Multi-variable type inference failed */
    public DirectScheduler() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public DirectScheduler(Executor r1) {
        this.executor = r1;
        this.executorOfType = new Executor[9];
    }

    public /* synthetic */ DirectScheduler(Executor r1, int r2, DefaultConstructorMarker r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = new DefaultThreadPoolExecutor();
    L5:
        this(r1);
    }

    @Override // com.ss.android.ugc.bytex.pthread.base.convergence.scheduler.Scheduler
    public boolean scheduling(int r2, PriorityRunnable r3) {
        Executor r4 = this.executorOfType[r2];
        if (r4 != null) goto L6;
        r4 = this.executor;
    L6:
        r4.execute(r3);
        return true;
    }

    public final void setExecutor(int r2, Executor r3) {
        this.executorOfType[r2] = r3;
    }
}
