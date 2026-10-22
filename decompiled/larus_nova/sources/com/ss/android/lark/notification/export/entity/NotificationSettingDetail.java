package com.ss.android.lark.notification.export.entity;

import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\t\u001a\u00020\nH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/ss/android/lark/notification/export/entity/NotificationSettingDetail;", "Ljava/io/Serializable;", "isEnable", "", "isVibrationOn", "isSoundOn", "<init>", "(ZZZ)V", "()Z", "toString", "", "notification-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class NotificationSettingDetail implements Serializable {
    private final boolean isEnable;
    private final boolean isSoundOn;
    private final boolean isVibrationOn;

    public String toString() {
        return "NotificationSettingDetail{isEnable = " + this.isEnable + ", isVibrationOn = " + this.isVibrationOn + ", isSoundOn = " + this.isSoundOn + '}';
    }

    public final boolean isEnable() {
        return this.isEnable;
    }

    public final boolean isSoundOn() {
        return this.isSoundOn;
    }

    public final boolean isVibrationOn() {
        return this.isVibrationOn;
    }

    public NotificationSettingDetail(boolean r100, boolean r101, boolean r102) {
        this.isEnable = r100;
        this.isVibrationOn = r101;
        this.isSoundOn = r102;
    }
}
