package com.bytedance.bdlocation.utils.background;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public class DefaultBackgroundProvider extends BackgroundProvider implements ActivityLifecycleUtil.ActivityNotification {
    public DefaultBackgroundProvider() {
    }

    @Override // com.bytedance.bdlocation.utils.background.ActivityLifecycleUtil.ActivityNotification
    public void onAppBackgroundNotify(boolean r1) {
        onAppBackgroundSwitch(r1);
    }
}
