package com.bytedance.bdlocation.notification;

import com.bytedance.bdlocation.callback.LightLocationSubmitNotification;
import com.bytedance.bdlocation.log.Logger;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public class SubmitNotification {
    private static volatile SubmitNotification mInstance;
    private List<LightLocationSubmitNotification> mLightSubmitNotifications;

    public static SubmitNotification getInstance() {
        if (mInstance != null) goto L15;
        monitor-enter(SubmitNotification.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (mInstance != null) goto L9;
        mInstance = new SubmitNotification();     // Catch: Throwable -> L11
    L9:
        monitor-exit(SubmitNotification.class);     // Catch: Throwable -> L11
    L15:
        return mInstance;
    }

    public void executeLightLocationSubmitNotification() {
        if (this.mLightSubmitNotifications.size() != 0) goto L5;
        return;
    L5:
        Iterator<LightLocationSubmitNotification> r0 = this.mLightSubmitNotifications.iterator();
    L7:
        if (r0.hasNext() == false) goto L9;
        LightLocationSubmitNotification r1 = r0.next();
        Logger.i("LightLocationSubmitNotification#onSubmitListener");
        r1.onSubmitListener();
        goto L7
    }

    public SubmitNotification() {
        this.mLightSubmitNotifications = new CopyOnWriteArrayList();
    }

    public List<LightLocationSubmitNotification> getLightLocationSubmitNotification() {
        return this.mLightSubmitNotifications;
    }

    public void addLightLocationSubmitNotification(LightLocationSubmitNotification r2) {
        if (r2 != null) goto L8;
        return;
    L8:
        this.mLightSubmitNotifications.add(r2);     // Catch: IndexOutOfBoundsException -> L6
        return;
    L6:
        Logger.i("add IndexOutOfBoundsException");
    }

    public void removeLightLocationSubmitNotification(LightLocationSubmitNotification r2) {
        if (r2 != null) goto L8;
        return;
    L8:
        this.mLightSubmitNotifications.remove(r2);     // Catch: IndexOutOfBoundsException -> L6
        return;
    L6:
        Logger.i(" remove IndexOutOfBoundsException");
    }
}
