package com.obric.assistant.spi.app;

import android.content.Intent;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\t\u0010\u0004\u001a\u00020\u0005H\u0096\u0001J\t\u0010\u0006\u001a\u00020\u0005H\u0096\u0001J\t\u0010\u0007\u001a\u00020\bH\u0096\u0001J\u000b\u0010\t\u001a\u0004\u0018\u00010\bH\u0096\u0001J\t\u0010\n\u001a\u00020\u000bH\u0096\u0001J\u001b\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000f\u001a\u00020\rH\u0096\u0001J\u0011\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\rH\u0096\u0001J\t\u0010\u0012\u001a\u00020\u000bH\u0096\u0001¨\u0006\u0013"}, d2 = {"Lcom/obric/assistant/spi/app/ObricLaunchServiceDelegate;", "Lcom/obric/assistant/spi/app/IObricLaunchService;", "<init>", "()V", "getBackgroundAppPkgName", "", "getLaunchBridgeActivityName", "getLaunchBridgeIntent", "Landroid/content/Intent;", "getPushClickIntent", "init", "", "resumeAssistantTask", "", "targetActivityName", "ignoreWindow", "resumeOrLaunchNewTask", "doNotResumeWindow", "startLauncherIntent", "obric_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricLaunchServiceDelegate implements IObricLaunchService {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ObricLaunchServiceDelegate f392826b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ IObricLaunchService f392827a;

    static {
        f392826b = new ObricLaunchServiceDelegate();
    }

    @Override // com.obric.assistant.spi.app.IObricLaunchService
    public final String getBackgroundAppPkgName() {
        return this.f392827a.getBackgroundAppPkgName();
    }

    @Override // com.obric.assistant.spi.app.IObricLaunchService
    public final Intent getPushClickIntent() {
        return this.f392827a.getPushClickIntent();
    }

    @Override // com.obric.assistant.spi.app.IObricLaunchService
    public final void init() {
        this.f392827a.init();
    }

    @Override // com.obric.assistant.spi.app.IObricLaunchService
    public final boolean resumeAssistantTask(String r100, boolean r101) {
        return this.f392827a.resumeAssistantTask(r100, r101);
    }

    @Override // com.obric.assistant.spi.app.IObricLaunchService
    public final void resumeOrLaunchNewTask(boolean r100) {
        this.f392827a.resumeOrLaunchNewTask(r100);
    }

    @Override // com.obric.assistant.spi.app.IObricLaunchService
    public final void startLauncherIntent() {
        this.f392827a.startLauncherIntent();
    }

    private ObricLaunchServiceDelegate() {
        IObricLaunchService r100 = (IObricLaunchService) ServiceManager.get().getService(IObricLaunchService.class);
        if (r100 != null) goto L5;
        r100 = new DefaultLaunchServiceImpl();
    L5:
        this.f392827a = r100;
    }
}
