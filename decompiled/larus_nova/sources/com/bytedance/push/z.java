package com.bytedance.push;

import com.bytedance.android.service.manager.PushServiceManager;
import java.util.Observable;
import java.util.Observer;

/* JADX INFO: loaded from: classes21.dex */
public final class z implements Observer {
    public z() {
    }

    @Override // java.util.Observer
    public void update(Observable r100, Object r101) {
        boolean r102 = ((Boolean) r101).booleanValue();
        com.bytedance.push.utils.f.b("BDPush", "[startOnce]isInBackGround:" + r102);
        if (r102 == true) goto L6;
        s67.d.a().deleteObserver(this);
        PushServiceManager.get().getIPermissionBootExternalService().reportDefaultNotificationStatus();
        return;
    }
}
