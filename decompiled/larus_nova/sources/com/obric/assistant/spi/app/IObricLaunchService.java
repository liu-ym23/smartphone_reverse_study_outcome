package com.obric.assistant.spi.app;

import android.content.Intent;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0012\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006H&J\u001e\u0010\u0007\u001a\u00020\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\n\u001a\u00020\u0006H&J\b\u0010\u000b\u001a\u00020\u0003H&J\b\u0010\f\u001a\u00020\rH&J\b\u0010\u000e\u001a\u00020\tH&J\b\u0010\u000f\u001a\u00020\tH&J\n\u0010\u0010\u001a\u0004\u0018\u00010\rH&¨\u0006\u0011"}, d2 = {"Lcom/obric/assistant/spi/app/IObricLaunchService;", "", "init", "", "resumeOrLaunchNewTask", "doNotResumeWindow", "", "resumeAssistantTask", "targetActivityName", "", "ignoreWindow", "startLauncherIntent", "getLaunchBridgeIntent", "Landroid/content/Intent;", "getLaunchBridgeActivityName", "getBackgroundAppPkgName", "getPushClickIntent", "obric_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IObricLaunchService {
    String getBackgroundAppPkgName();

    Intent getPushClickIntent();

    void init();

    boolean resumeAssistantTask(String r100, boolean r101);

    void resumeOrLaunchNewTask(boolean r100);

    void startLauncherIntent();
}
