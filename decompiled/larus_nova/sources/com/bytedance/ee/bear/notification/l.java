package com.bytedance.ee.bear.notification;

import com.bytedance.ee.bear.notification.bean.Notification;
import java.util.Comparator;

/* JADX INFO: loaded from: classes18.dex */
public final class l implements Comparator<Notification> {
    public l() {
    }

    @Override // java.util.Comparator
    public final int compare(Notification r100, Notification r101) {
        return (int) (r100.getStart_time() - r101.getStart_time());
    }
}
