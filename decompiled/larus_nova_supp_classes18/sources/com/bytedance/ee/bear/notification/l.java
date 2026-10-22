package com.bytedance.ee.bear.notification;

import com.bytedance.ee.bear.notification.bean.Notification;
import java.util.Comparator;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class l implements Comparator<Notification> {
    public l() {
    }

    @Override // java.util.Comparator
    public final int compare(Notification r3, Notification r4) {
        return (int) (r3.getStart_time() - r4.getStart_time());
    }
}
