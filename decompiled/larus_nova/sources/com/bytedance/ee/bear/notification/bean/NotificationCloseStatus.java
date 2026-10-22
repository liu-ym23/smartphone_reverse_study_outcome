package com.bytedance.ee.bear.notification.bean;

import com.bytedance.ee.util.io.NonProguard;

/* JADX INFO: loaded from: classes18.dex */
public class NotificationCloseStatus implements NonProguard {
    private boolean close;

    public NotificationCloseStatus() {
    }

    public boolean isClose() {
        return this.close;
    }

    public void setClose(boolean r100) {
        this.close = r100;
    }
}
