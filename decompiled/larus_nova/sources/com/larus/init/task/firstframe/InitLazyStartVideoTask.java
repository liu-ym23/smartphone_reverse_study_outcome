package com.larus.init.task.firstframe;

import com.larus.network.http.ServiceType;
import com.larus.utils.logger.FLogger;
import com.larus.video.api.VideoEngineInitServiceDelegate;
import kotlin.Metadata;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\b\u001a\u00020\tH\u0016J\r\u0010\n\u001a\u00020\tH\u0000¢\u0006\u0002\b\u000bR\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\f"}, d2 = {"Lcom/larus/init/task/firstframe/InitLazyStartVideoTask;", "Lcom/larus/init/task/firstframe/IFirstFrameTask;", "<init>", "()V", "scene", "", "getScene", "()Ljava/lang/String;", "runInternal", "", "runDeferredInit", "runDeferredInit$app_mainlandRelease", "app_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class InitLazyStartVideoTask implements m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f351291a;

    @Override // bg9.i
    public final String v() {
        return "normal";
    }

    @Override // bg9.i
    public final void runInternal() {
        com.larus.init.task.m.f351424a.getClass();
        if (com.larus.init.task.m.c("TTVideoEngine", ((Boolean) com.larus.init.task.m.f351429f.getValue()).booleanValue()) == false) goto L6;
        FLogger.f375446a.i("BackgroundLazyInit", "event=component_init_deferred, component=VideoEngine, trigger=startup, reason=background_cold_launch");
        return;
    L6:
        FLogger.f375446a.i("BackgroundLazyInit", "event=component_init_request, component=VideoEngine, trigger=startup");
        com.larus.platform.service.o r100 = com.larus.platform.service.o.f365780a;
        if (StringsKt.isBlank(r100.getDeviceId()) == false) goto L9;
        r100.e(new a0());
        return;
    L9:
        VideoEngineInitServiceDelegate.f375655a.a();
    }

    public InitLazyStartVideoTask() {
        this.f351291a = ServiceType.BASIC_SERVICE;
    }

    @Override // bg9.i
    public final String getScene() {
        return this.f351291a;
    }

    @Override // bg9.i, java.lang.Runnable
    public final void run() {
        bg9.i.a.a(this);
    }
}
