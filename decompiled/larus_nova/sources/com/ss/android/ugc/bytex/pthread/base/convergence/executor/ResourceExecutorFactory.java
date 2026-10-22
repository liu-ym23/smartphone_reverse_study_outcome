package com.ss.android.ugc.bytex.pthread.base.convergence.executor;

import com.ss.android.ugc.bytex.pthread.base.convergence.core.ExemptThreadFactory;
import com.ss.android.ugc.bytex.pthread.base.convergence.dredge.CommonDredgeHandler;
import com.ss.android.ugc.bytex.pthread.base.convergence.dredge.DredgeHandler;
import com.ss.android.ugc.bytex.pthread.base.convergence.dredge.IDredgeStrategy;
import com.ss.android.ugc.bytex.pthread.base.convergence.dredge.IntervalDredgeAbility;
import com.ss.android.ugc.bytex.pthread.base.convergence.external.IThreadExecutePolicy;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J>\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/ss/android/ugc/bytex/pthread/base/convergence/executor/ResourceExecutorFactory;", "Lcom/ss/android/ugc/bytex/pthread/base/convergence/executor/IResourceExecutorFactory;", "executor", "Ljava/util/concurrent/Executor;", "(Ljava/util/concurrent/Executor;)V", "create", "Lcom/ss/android/ugc/bytex/pthread/base/convergence/executor/IResourceExecutor;", "threadPrefix", "", "minSize", "", "maxSize", "dredgeStrategy", "Lcom/ss/android/ugc/bytex/pthread/base/convergence/dredge/IDredgeStrategy;", "threadExecutePolicy", "Lcom/ss/android/ugc/bytex/pthread/base/convergence/external/IThreadExecutePolicy;", "keepAliveTime", "", "Companion", "threadpool-plugin-base_release"}, k = 1, mv = {1, 1, 13})
public final class ResourceExecutorFactory implements IResourceExecutorFactory {
    public static final Companion Companion = null;
    private final Executor executor;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bJ\u0010\u0010\t\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¨\u0006\n"}, d2 = {"Lcom/ss/android/ugc/bytex/pthread/base/convergence/executor/ResourceExecutorFactory$Companion;", "", "()V", "newConcentratedFactory", "Lcom/ss/android/ugc/bytex/pthread/base/convergence/executor/IResourceExecutorFactory;", "namePrefix", "", "keepAliveTime", "", "newIsolationFactory", "threadpool-plugin-base_release"}, k = 1, mv = {1, 1, 13})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public static /* synthetic */ IResourceExecutorFactory newConcentratedFactory$default(Companion r100, String r101, long r102, int r103, Object r104) {
            if ((r103 & 2) == 0) goto L6;
            r102 = 10000;
        L6:
            return r100.newConcentratedFactory(r101, r102);
        }

        public final IResourceExecutorFactory newConcentratedFactory(String r110, long r111) {
            return new ResourceExecutorFactory(new PrestartThreadPoolExecutor(0, Integer.MAX_VALUE, r111, new ExemptThreadFactory(r110, false, true, 2, null), new ThreadPoolExecutor.AbortPolicy()));
        }

        public final IResourceExecutorFactory newIsolationFactory(String r110) {
            return new ResourceExecutorFactory(new ThreadExecutor(new ExemptThreadFactory(r110, false, true, 2, null)));
        }
    }

    static {
        Companion = new Companion(null);
    }

    public ResourceExecutorFactory(Executor r100) {
        this.executor = r100;
    }

    @Override // com.ss.android.ugc.bytex.pthread.base.convergence.executor.IResourceExecutorFactory
    public IResourceExecutor create(String r110, int r111, int r112, IDredgeStrategy r113, IThreadExecutePolicy r114, long r115) {
        ResourceExecutor r116 = new ResourceExecutor(this.executor, r111, r112, new LinkedBlockingQueue(), r115, r114, r110);
        if (r113 != null) goto L5;
        return r116;
    L5:
        return new AdaptiveExecutor(r116, new DredgeHandler(CommonDredgeHandler.INSTANCE.getHandler(), new IntervalDredgeAbility(r116, r113)));
    }
}
