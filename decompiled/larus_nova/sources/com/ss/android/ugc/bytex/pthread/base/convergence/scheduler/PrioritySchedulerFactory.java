package com.ss.android.ugc.bytex.pthread.base.convergence.scheduler;

import com.ss.android.ugc.bytex.pthread.base.convergence.dredge.DredgeStrategies;
import com.ss.android.ugc.bytex.pthread.base.convergence.dredge.IDredgeStrategy;
import com.ss.android.ugc.bytex.pthread.base.convergence.executor.IResourceExecutor;
import com.ss.android.ugc.bytex.pthread.base.convergence.executor.IResourceExecutorFactory;
import com.ss.android.ugc.bytex.pthread.base.convergence.executor.MigrateExecutor;
import com.ss.android.ugc.bytex.pthread.base.convergence.external.IThreadExecutePolicy;
import com.ss.ttvideoengine.model.VideoThumbInfo;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TypeCastException;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0015\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J.\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00072\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00102\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013J,\u0010\u0014\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u00072\b\b\u0002\u0010\u0011\u001a\u00020\u00102\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013J$\u0010\u0016\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00072\b\b\u0002\u0010\u0011\u001a\u00020\u00102\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013J6\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u00072\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\b\u0002\u0010\u0011\u001a\u00020\u00102\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013J\u000e\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u000bJ\b\u0010\u001e\u001a\u00020\u000bH\u0016J\u0018\u0010\u001f\u001a\u00020\u001c*\u00020\u00072\n\u0010 \u001a\u00020!\"\u00020\u0007H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/ss/android/ugc/bytex/pthread/base/convergence/scheduler/PrioritySchedulerFactory;", "Lcom/ss/android/ugc/bytex/pthread/base/convergence/scheduler/SchedulerFactory;", "factory", "Lcom/ss/android/ugc/bytex/pthread/base/convergence/executor/IResourceExecutorFactory;", "(Lcom/ss/android/ugc/bytex/pthread/base/convergence/executor/IResourceExecutorFactory;)V", "priorityExecutorMap", "", "", "Lcom/ss/android/ugc/bytex/pthread/base/convergence/executor/MigrateExecutor;", "schedulers", "", "Lcom/ss/android/ugc/bytex/pthread/base/convergence/scheduler/Scheduler;", "addInferiorScheduler", "Lcom/ss/android/ugc/bytex/pthread/base/convergence/executor/IResourceExecutor;", "expectSize", VideoThumbInfo.KEY_INTERVAL, "", "keepAliveTime", "threadExecutePolicy", "Lcom/ss/android/ugc/bytex/pthread/base/convergence/external/IThreadExecutePolicy;", "addOrdinaryScheduler", "fusingSize", "addPivotalScheduler", "addPriorityScheduler", "level", "dredgeStrategy", "Lcom/ss/android/ugc/bytex/pthread/base/convergence/dredge/IDredgeStrategy;", "addScheduler", "", "scheduler", "createScheduler", "migrateTo", "recipientLevel", "", "threadpool-plugin-base_release"}, k = 1, mv = {1, 1, 13})
public final class PrioritySchedulerFactory implements SchedulerFactory {
    private final IResourceExecutorFactory factory;
    private final Map<Integer, MigrateExecutor> priorityExecutorMap;
    private final List<Scheduler> schedulers;

    public PrioritySchedulerFactory(IResourceExecutorFactory r100) {
        this.factory = r100;
        this.priorityExecutorMap = new LinkedHashMap();
        this.schedulers = new ArrayList();
    }

    public static /* synthetic */ IResourceExecutor addInferiorScheduler$default(PrioritySchedulerFactory r100, int r101, long r102, long r110, IThreadExecutePolicy r111, int r112, Object r113) {
        if ((r112 & 2) == 0) goto L5;
        r102 = 500;
    L5:
        long r103 = r102;
        if ((r112 & 4) == 0) goto L8;
        r110 = 30000;
    L8:
        long r104 = r110;
        if ((r112 & 8) == 0) goto L12;
        r111 = null;
    L12:
        return r100.addInferiorScheduler(r101, r103, r104, r111);
    }

    public static /* synthetic */ IResourceExecutor addOrdinaryScheduler$default(PrioritySchedulerFactory r100, int r101, int r102, long r103, IThreadExecutePolicy r110, int r111, Object r112) {
        if ((r111 & 4) == 0) goto L5;
        r103 = 30000;
    L5:
        long r104 = r103;
        if ((r111 & 8) == 0) goto L9;
        r110 = null;
    L9:
        return r100.addOrdinaryScheduler(r101, r102, r104, r110);
    }

    public static /* synthetic */ IResourceExecutor addPivotalScheduler$default(PrioritySchedulerFactory r100, int r101, long r102, IThreadExecutePolicy r103, int r104, Object r105) {
        if ((r104 & 2) == 0) goto L6;
        r102 = 30000;
    L6:
        if ((r104 & 4) == 0) goto L9;
        r103 = null;
    L9:
        return r100.addPivotalScheduler(r101, r102, r103);
    }

    public static /* synthetic */ IResourceExecutor addPriorityScheduler$default(PrioritySchedulerFactory r100, int r101, int r102, IDredgeStrategy r110, long r111, IThreadExecutePolicy r112, int r113, Object r114) {
        if ((r113 & 8) == 0) goto L5;
        r111 = 30000;
    L5:
        long r103 = r111;
        if ((r113 & 16) == 0) goto L9;
        r112 = null;
    L9:
        return r100.addPriorityScheduler(r101, r102, r110, r103, r112);
    }

    private final void migrateTo(int r100, int... r101) {
        MigrateExecutor r102 = this.priorityExecutorMap.get(Integer.valueOf(r100));
        if (r102 == null) goto L10;
        int r103 = r101.length;
        int r104 = 0;
    L5:
        if (r104 >= r103) goto L14;
        int r105 = r101[r104];
        MigrateExecutor r106 = this.priorityExecutorMap.get(Integer.valueOf(r105));
        if (r106 == null) goto L9;
        r102.migrateTo(r106);
    L9:
        r104 = r104 + 1;
        goto L5
    L14:
        return;
    }

    public final IResourceExecutor addInferiorScheduler(int r110, long r111, long r112, IThreadExecutePolicy r113) {
        return addPriorityScheduler(1, r110, DredgeStrategies.createLooseStrategy$default(DredgeStrategies.INSTANCE, r110, r111, 0.5f, 0, 0, 0, 56, null), r112, r113);
    }

    public final IResourceExecutor addOrdinaryScheduler(int r110, int r111, long r112, IThreadExecutePolicy r113) {
        return addPriorityScheduler(6, r110, DredgeStrategies.createFusingStrategy$default(DredgeStrategies.INSTANCE, r110, r111, 0, 0, 0, 28, null), r112, r113);
    }

    public final IResourceExecutor addPivotalScheduler(int r110, long r111, IThreadExecutePolicy r112) {
        return addPriorityScheduler(11, r110, DredgeStrategies.createLooseStrategy$default(DredgeStrategies.INSTANCE, r110, 0, 1.0f, 0, 0, 0, 58, null), r111, r112);
    }

    public final IResourceExecutor addPriorityScheduler(int r100, int r110, IDredgeStrategy r111, long r112, IThreadExecutePolicy r113) {
        IResourceExecutor r114 = this.factory.create("level-" + r100, 0, r110, r111, r113, r112);
        this.priorityExecutorMap.put(Integer.valueOf(r100), r114);
        addScheduler(new PriorityScheduler(r100, r114));
        return r114;
    }

    public final void addScheduler(Scheduler r100) {
        this.schedulers.add(r100);
    }

    @Override // com.ss.android.ugc.bytex.pthread.base.convergence.scheduler.SchedulerFactory
    public Scheduler createScheduler() {
        migrateTo(16, new int[]{11});
        migrateTo(11, new int[]{6});
        migrateTo(6, new int[]{11, 1});
        List<Scheduler> r100 = this.schedulers;
        if (r100 == null) goto L11;
        Object[] r101 = r100.toArray(new Scheduler[0]);
        if (r101 == null) goto L9;
        return new DispatchScheduler((Scheduler[]) r101);
    L9:
        throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
    L11:
        throw new TypeCastException("null cannot be cast to non-null type java.util.Collection<T>");
    }
}
