package com.ss.android.ugc.effectmanager.knadapt;

import bytekn.foundation.concurrent.executor.a;
import java.util.concurrent.Executor;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\n\u0010\u000bJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016R\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/ss/android/ugc/effectmanager/knadapt/KNExecutor;", "Lbytekn/foundation/concurrent/executor/a;", "", "shutdown", "Ljava/lang/Runnable;", "command", "execute", "Ljava/util/concurrent/Executor;", "iExecutor", "Ljava/util/concurrent/Executor;", "<init>", "(Ljava/util/concurrent/Executor;)V", "effectmanager_release"}, k = 1, mv = {1, 4, 0})
public final class KNExecutor implements a {
    private final Executor iExecutor;

    public void shutdown() {
    }

    public KNExecutor(Executor r100) {
        this.iExecutor = r100;
    }

    @Override // java.util.concurrent.Executor
    public void execute(final Runnable r100) {
        this.iExecutor.execute(new AnonymousClass1(r100));
    }
}
