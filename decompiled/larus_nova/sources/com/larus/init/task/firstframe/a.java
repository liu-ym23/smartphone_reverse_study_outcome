package com.larus.init.task.firstframe;

import com.larus.account.base.api.IDouyinHeartBeatService;
import com.larus.account.base.model.GetOauthTokenTriggerScene;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;

/* JADX INFO: loaded from: classes4.dex */
public final class a implements f09.a.b {
    public a() {
    }

    @Override // f09.a.b
    public final void onAllActivityDestroyed() {
    }

    @Override // f09.a.b
    public final void onAppBackground() {
    }

    @Override // f09.a.b
    public final void onAppForeground() {
        IDouyinHeartBeatService r100 = (IDouyinHeartBeatService) ServiceManager.get().getService(IDouyinHeartBeatService.class);
        if (r100 == null) goto L6;
        IDouyinHeartBeatService.a.a(r100, 3000, false, GetOauthTokenTriggerScene.ForegroundSwitch, null, 10);
        return;
    }
}
