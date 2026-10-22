package com.larus.init.task;

import com.larus.api.LocationService;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.common.apphost.AppHost;
import com.larus.network.http.ServiceType;
import com.larus.platform.model.LocateScene;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\u000bH\u0016J\b\u0010\r\u001a\u00020\u000bH\u0016J\b\u0010\u000e\u001a\u00020\u000bH\u0016R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u000f"}, d2 = {"Lcom/larus/init/task/InitStartLocationFeedShowTask;", "Lcom/bytedance/lego/init/model/BaseFeedShowTask;", "Lcom/larus/init/task/base/IFlowInitReportTask;", "Lcom/larus/common/apphost/lifecycle/ActivityStackManager$OnAppBackGroundListener;", "<init>", "()V", "scene", "", "getScene", "()Ljava/lang/String;", "runInternal", "", "onAppBackground", "onAppForeground", "onAllActivityDestroyed", "app_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class InitStartLocationFeedShowTask extends bf6.a implements bg9.i, f09.a.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f351093a;

    @Override // f09.a.b
    public final void onAllActivityDestroyed() {
    }

    @Override // f09.a.b
    public final void onAppBackground() {
    }

    @Override // bg9.i
    public final String v() {
        return "normal";
    }

    @Override // f09.a.b
    public final void onAppForeground() {
        LocationService.a.a(LocationService.f286873a, LocateScene.HOT_LAUNCH, null, null, 30);
    }

    @Override // bg9.i
    public final void runInternal() {
        LocationService.Companion r100 = LocationService.f286873a;
        r100.init();
        LocationService.a.a(r100, LocateScene.COLD_LAUNCH, null, null, 30);
        AppHost.f326268a.a().j(this);
    }

    public InitStartLocationFeedShowTask() {
        this.f351093a = ServiceType.BASIC_SERVICE;
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
        return this.f351093a;
    }
}
