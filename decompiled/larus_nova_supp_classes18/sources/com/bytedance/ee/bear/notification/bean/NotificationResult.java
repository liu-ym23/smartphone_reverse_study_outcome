package com.bytedance.ee.bear.notification.bean;

import com.bytedance.ee.util.io.NonProguard;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class NotificationResult implements NonProguard {
    private Map<String, Notification> bulletins;

    public NotificationResult() {
    }

    public List<Notification> getNotificationResults() {
        return new ArrayList(this.bulletins.values());
    }

    public Map<String, Notification> getBulletins() {
        return this.bulletins;
    }

    public void setBulletins(Map<String, Notification> r1) {
        this.bulletins = r1;
    }
}
