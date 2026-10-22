package com.bytedance.timon_monitor_impl;

import com.bytedance.timon_monitor_api.IMonitorBusinessService;
import com.bytedance.timon_monitor_impl.pipeline.AsyncReportPipeline;
import com.bytedance.timonbase.pipeline.TimonPipeline;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/timon_monitor_impl/MonitorBusinessServiceImpl;", "Lcom/bytedance/timon_monitor_api/IMonitorBusinessService;", "<init>", "()V", "timon-monitor-impl_release"}, k = 1, mv = {1, 4, 0})
public final class MonitorBusinessServiceImpl implements IMonitorBusinessService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<Function1<TimonPipeline, Unit>> f270718a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<Function1<TimonPipeline, Unit>> f270719b;

    @Override // com.bytedance.timon_monitor_api.IMonitorBusinessService
    public final void execute() {
        List<Function1<TimonPipeline, Unit>> r100 = this.f270718a;
        monitor-enter(r100);
        Iterator<T> r101 = this.f270718a.iterator();     // Catch: Throwable -> L26
    L6:
        if (r101.hasNext() == false) goto L10;
        Function1 r102 = (Function1) r101.next();     // Catch: Throwable -> L26
        if (r102 == null) goto L6;
        Unit r103 = (Unit) r102.invoke(com.bytedance.timon_monitor_impl.pipeline.f.f270763a);     // Catch: Throwable -> L26
        goto L6
    L10:
        ((ArrayList) this.f270718a).clear();     // Catch: Throwable -> L26
        Unit r104 = Unit.INSTANCE;     // Catch: Throwable -> L26
        monitor-exit(r100);
        List<Function1<TimonPipeline, Unit>> r105 = this.f270719b;
        monitor-enter(r105);
        Iterator<T> r106 = this.f270719b.iterator();     // Catch: Throwable -> L23
    L16:
        if (r106.hasNext() == false) goto L20;
        Function1 r107 = (Function1) r106.next();     // Catch: Throwable -> L23
        if (r107 == null) goto L16;
        Unit r108 = (Unit) r107.invoke(AsyncReportPipeline.f270755a);     // Catch: Throwable -> L23
        goto L16
    L20:
        ((ArrayList) this.f270719b).clear();     // Catch: Throwable -> L23
        Unit r109 = Unit.INSTANCE;     // Catch: Throwable -> L23
        monitor-exit(r105);
        return;
    L23:
        th = move-exception;
        throw th;
    L26:
        th = move-exception;
        throw th;
    }

    public MonitorBusinessServiceImpl() {
        this.f270718a = new ArrayList();
        this.f270719b = new ArrayList();
    }
}
