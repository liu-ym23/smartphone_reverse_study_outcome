package com.larus.init.task.feed;

import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.network.http.ServiceType;
import com.larus.platform.api.creation.IBachService;
import com.larus.platform.api.creation.PreLoadScene;
import com.larus.utils.logger.FLogger;
import com.larus.vesdk.api.IVeSDK;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\n\u001a\u00020\u000bH\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082D¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u00020\u0006X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/larus/init/task/feed/InitEffectPlatformTask;", "Lcom/bytedance/lego/init/model/BaseFeedShowTask;", "Lcom/larus/init/task/base/IFlowInitReportTask;", "<init>", "()V", "TAG", "", "scene", "getScene", "()Ljava/lang/String;", "runInternal", "", "app_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class InitEffectPlatformTask extends bf6.a implements bg9.i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f351234a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f351235b;

    @Override // bg9.i
    public final String v() {
        return "normal";
    }

    @Override // bg9.i
    public final void runInternal() {
        FLogger.f375446a.i(this.f351234a, "effect platform task run");
        IVeSDK r100 = (IVeSDK) ServiceManager.get().getService(IVeSDK.class);
        if (r100 == null) goto L5;
        r100.e();
    L5:
        IBachService r101 = (IBachService) ServiceManager.get().getService(IBachService.class);
        if (r101 == null) goto L9;
        r101.c(PreLoadScene.DIGITAL_AVTAR);
        return;
    }

    public InitEffectPlatformTask() {
        this.f351234a = "InitEffectPlatformTask";
        this.f351235b = ServiceType.UGC;
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
        return this.f351235b;
    }
}
