package com.ss.android.lark.usersetting.entity;

import java.io.Serializable;

/* JADX INFO: loaded from: classes38.dex */
public class DriveNotificationSetting implements Serializable {
    private boolean isDriveOpen;

    public boolean isDriveOpen() {
        return this.isDriveOpen;
    }

    public DriveNotificationSetting(boolean r100) {
        this.isDriveOpen = r100;
    }

    public void setDriveOpen(boolean r100) {
        this.isDriveOpen = r100;
    }
}
