package com.ss.android.lark.usersetting.entity;

import java.io.Serializable;

/* JADX INFO: loaded from: classes38.dex */
public class NotificationSettingWrapper implements Serializable {
    private NotificationSettingV2 notificationSettingV2;

    public NotificationSettingV2 getNotificationSettingV2() {
        return this.notificationSettingV2;
    }

    public NotificationSettingWrapper(NotificationSettingV2 r100) {
        this.notificationSettingV2 = r100;
    }

    public void setNotificationSettingV2(NotificationSettingV2 r100) {
        this.notificationSettingV2 = r100;
    }
}
