package com.obric.sva.framework.wrapper;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes34.dex */
public class NotificationWrapper {
    private Notification mNotification;

    @JvmStatic
    public static Class<?> getWrapperClazz() {
        return Notification.class;
    }

    public Notification getNotificationInstance() {
        return this.mNotification;
    }

    public NotificationWrapper(int r100, CharSequence r101, long r102) {
        this.mNotification = new Notification(r100, r101, r102);
    }

    public void setLatestEventInfo(Context r100, CharSequence r101, CharSequence r102, PendingIntent r103) {
        this.mNotification.setLatestEventInfo(r100, r101, r102, r103);
    }
}
