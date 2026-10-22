package com.larus.init.task.firstframe;

import com.larus.login.api.LoginService;
import com.larus.network.http.ServiceType;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\b\u001a\u00020\tH\u0016R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/larus/init/task/firstframe/InitLazyAccountRiskTask;", "Lcom/larus/init/task/firstframe/IFirstFrameTask;", "<init>", "()V", "scene", "", "getScene", "()Ljava/lang/String;", "runInternal", "", "app_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class InitLazyAccountRiskTask implements m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f351269a;

    @Override // bg9.i
    public final String v() {
        return "normal";
    }

    @Override // bg9.i
    public final void runInternal() {
        LoginService.f356989a.A().setup();
    }

    public InitLazyAccountRiskTask() {
        this.f351269a = ServiceType.BASIC_SERVICE;
    }

    @Override // bg9.i
    public final String getScene() {
        return this.f351269a;
    }

    @Override // bg9.i, java.lang.Runnable
    public final void run() {
        bg9.i.a.a(this);
    }
}
