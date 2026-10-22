package com.bytedance.ee.bear.notification.bean;

import com.bytedance.ee.util.io.NonProguard;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class NotificationCloseStatus implements NonProguard {
    private boolean close;

    public NotificationCloseStatus() {
    }

    public boolean isClose() {
        return this.close;
    }

    public void setClose(boolean r1) {
        this.close = r1;
    }
}
