package com.larus.init.task;

import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.btm.api.IBTMService;
import com.larus.network.http.ServiceType;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\t\u001a\u00020\nH\u0016R\u0014\u0010\u0005\u001a\u00020\u0006X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/larus/init/task/InitMinimizeBtmTask;", "Lcom/bytedance/lego/init/model/IInitTask;", "Lcom/larus/init/task/base/IFlowInitReportTask;", "<init>", "()V", "scene", "", "getScene", "()Ljava/lang/String;", "runInternal", "", "app_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class InitMinimizeBtmTask extends bf6.d implements bg9.i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f351059a;

    @Override // bg9.i
    public final String v() {
        return "normal";
    }

    @Override // bg9.i
    public final void runInternal() {
        IBTMService r100 = (IBTMService) ServiceManager.get().getService(IBTMService.class);
        if (r100 == null) goto L6;
        r100.o();
        return;
    }

    public InitMinimizeBtmTask() {
        this.f351059a = ServiceType.MAIN_BOT;
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
        return this.f351059a;
    }
}
