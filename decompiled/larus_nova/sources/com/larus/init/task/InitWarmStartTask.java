package com.larus.init.task;

import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.network.http.ServiceType;
import com.larus.network.quota.AppStartState;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\nH\u0002R\u0014\u0010\u0005\u001a\u00020\u0006X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\f"}, d2 = {"Lcom/larus/init/task/InitWarmStartTask;", "Lcom/bytedance/lego/init/model/IInitTask;", "Lcom/larus/init/task/base/IFlowInitReportTask;", "<init>", "()V", "scene", "", "getScene", "()Ljava/lang/String;", "runInternal", "", "onWarmStart", "app_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class InitWarmStartTask extends bf6.d implements bg9.i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f351112a;

    @Override // bg9.i
    public final String v() {
        return "normal";
    }

    @Override // bg9.i
    public final void runInternal() {
        jm9.d r100 = jm9.d.f499704a;
        Function1<AppStartState, Unit> r101 = new r0(this);
        Intrinsics.checkNotNullParameter(r101, "listener");
        jm9.d.f499711h.add(r101);
    }

    public InitWarmStartTask() {
        this.f351112a = ServiceType.BASIC_TEC;
    }

    @Override // java.lang.Runnable, bg9.i
    public final void run() {
        bg9.i.a.a(this);     // Catch: Throwable -> L4
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
        return this.f351112a;
    }
}
