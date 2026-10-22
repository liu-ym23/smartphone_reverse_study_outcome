package com.larus.init.task;

import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.audio.autotest.api.IAudioAutotestService;
import com.larus.common.apphost.AppHost;
import com.larus.network.http.ServiceType;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \u000b2\u00020\u00012\u00020\u0002:\u0001\u000bB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\t\u001a\u00020\nH\u0016R\u0014\u0010\u0005\u001a\u00020\u0006X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\f"}, d2 = {"Lcom/larus/init/task/InitAudioAutotestService;", "Lcom/bytedance/lego/init/model/IInitTask;", "Lcom/larus/init/task/base/IFlowInitReportTask;", "<init>", "()V", "scene", "", "getScene", "()Ljava/lang/String;", "runInternal", "", "Companion", "app_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class InitAudioAutotestService extends bf6.d implements bg9.i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f351023a;

    public static final class a {
    }

    static {
    }

    @Override // bg9.i
    public final String v() {
        return "normal";
    }

    @Override // bg9.i
    public final void runInternal() {
        FLogger r100 = FLogger.f375446a;
        StringBuilder r101 = new StringBuilder("runInternal fun, buildChannel: ");
        AppHost.Companion r102 = AppHost.f326268a;
        r101.append(r102.getBuildChannel());
        r100.i("InitAudioAutotestService", r101.toString());
        if (r102.isDebug() == false) goto L5;
    L8:
        IAudioAutotestService r103 = (IAudioAutotestService) ServiceManager.get().getService(IAudioAutotestService.class);
        if (r103 == null) goto L11;
        r102.getApplication();
        r103.init();
        r100.i("InitAudioAutotestService", "start service success");
        return;
    L11:
        r100.e("InitAudioAutotestService", "start service fail");
        return;
    L5:
        if (r102.isTestChannel() == true) goto L8;
        if (Intrinsics.areEqual(r102.getBuildChannel(), "auto_test") == true) goto L8;
    }

    public InitAudioAutotestService() {
        this.f351023a = ServiceType.AUDIO;
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
        return this.f351023a;
    }
}
