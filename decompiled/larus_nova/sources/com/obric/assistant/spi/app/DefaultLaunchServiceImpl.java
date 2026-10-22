package com.obric.assistant.spi.app;

import android.content.Intent;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u001a\u0010\t\u001a\u00020\b2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\bH\u0016J\b\u0010\r\u001a\u00020\u0005H\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u000bH\u0016J\b\u0010\u0011\u001a\u00020\u000bH\u0016J\n\u0010\u0012\u001a\u0004\u0018\u00010\u000fH\u0016¨\u0006\u0013"}, d2 = {"Lcom/obric/assistant/spi/app/DefaultLaunchServiceImpl;", "Lcom/obric/assistant/spi/app/IObricLaunchService;", "<init>", "()V", "init", "", "resumeOrLaunchNewTask", "doNotResumeWindow", "", "resumeAssistantTask", "targetActivityName", "", "ignoreWindow", "startLauncherIntent", "getLaunchBridgeIntent", "Landroid/content/Intent;", "getLaunchBridgeActivityName", "getBackgroundAppPkgName", "getPushClickIntent", "obric_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DefaultLaunchServiceImpl implements IObricLaunchService {
    public DefaultLaunchServiceImpl() {
    }

    @Override // com.obric.assistant.spi.app.IObricLaunchService
    public final String getBackgroundAppPkgName() {
        return "";
    }

    @Override // com.obric.assistant.spi.app.IObricLaunchService
    public final Intent getPushClickIntent() {
        return null;
    }

    @Override // com.obric.assistant.spi.app.IObricLaunchService
    public final void init() {
    }

    @Override // com.obric.assistant.spi.app.IObricLaunchService
    public final boolean resumeAssistantTask(String r100, boolean r101) {
        return false;
    }

    @Override // com.obric.assistant.spi.app.IObricLaunchService
    public final void resumeOrLaunchNewTask(boolean r100) {
    }

    @Override // com.obric.assistant.spi.app.IObricLaunchService
    public final void startLauncherIntent() {
    }
}
