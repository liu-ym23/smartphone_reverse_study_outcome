package com.larus.init.task.obric;

import bf6.d;
import bg9.i;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.network.http.ServiceType;
import com.obric.activeness.IObricActivenessMonitorService;
import com.obric.assistant.common.spi.ObricFeatureServiceDelegate;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\t\u001a\u00020\nH\u0016R\u0014\u0010\u0005\u001a\u00020\u0006X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/larus/init/task/obric/InitObricActivenessTask;", "Lcom/bytedance/lego/init/model/IInitTask;", "Lcom/larus/init/task/base/IFlowInitReportTask;", "<init>", "()V", "scene", "", "getScene", "()Ljava/lang/String;", "runInternal", "", "app_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class InitObricActivenessTask extends d implements i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f351436a;

    @Override // bg9.i
    public final String v() {
        return "normal";
    }

    @Override // bg9.i
    public final void runInternal() {
        if (ObricFeatureServiceDelegate.f387839b.c() == false) goto L8;
        IObricActivenessMonitorService.f384390a.getClass();
        IObricActivenessMonitorService r100 = IObricActivenessMonitorService.a.f384392b.getValue();
        if (r100 == null) goto L9;
        r100.init();
        return;
    L9:
        return;
    }

    public InitObricActivenessTask() {
        this.f351436a = ServiceType.OBRIC;
    }

    @Override // java.lang.Runnable, bg9.i
    public final void run() {
        i.a.a(this);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    @Override // bg9.i
    public final String getScene() {
        return this.f351436a;
    }
}
