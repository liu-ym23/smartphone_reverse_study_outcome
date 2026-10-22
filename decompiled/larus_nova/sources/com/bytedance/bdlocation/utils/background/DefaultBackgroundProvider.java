package com.bytedance.bdlocation.utils.background;

/* JADX INFO: loaded from: classes10.dex */
public class DefaultBackgroundProvider extends BackgroundProvider implements ActivityLifecycleUtil.ActivityNotification {
    public DefaultBackgroundProvider() {
    }

    @Override // com.bytedance.bdlocation.utils.background.ActivityLifecycleUtil.ActivityNotification
    public void onAppBackgroundNotify(boolean r100) {
        onAppBackgroundSwitch(r100);
    }
}
