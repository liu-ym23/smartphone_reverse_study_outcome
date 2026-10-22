package com.bytedance.notification.supporter.impl;

import android.app.Notification;
import android.content.Context;
import android.media.AudioManager;
import android.net.Uri;
import com.bytedance.android.service.manager.push.notification.NotificationBody;
import com.bytedance.common.support.PushCommonSupport;
import com.bytedance.push.settings.PushOnlineSettings;
import j77.i;

/* JADX INFO: loaded from: classes21.dex */
public final class f implements w37.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f266101a;

    public f() {
        if (((PushOnlineSettings) i.a(PushCommonSupport.getInstance().getPushConfigurationService().getPushCommonConfiguration().mApplication, PushOnlineSettings.class)).A() <= 0) goto L5;
        boolean r100 = true;
    L6:
        this.f266101a = r100;
        return;
    L5:
        r100 = false;
        goto L6
    }

    public final void a(Context r100, Notification r101, NotificationBody r102) {
        if (r101 != null) goto L5;
        return;
    L5:
        if (r102.useSound == false) goto L8;
        r101.defaults |= 1;
    L8:
        if (r102.useVibrator == true) goto L21;
    L17:
        Uri r103 = r102.sound;
        if (r103 == null) goto L23;
        r101.sound = r103;
        return;
    L23:
        return;
    L21:
        int r104 = ((AudioManager) r100.getSystemService("audio")).getRingerMode();     // Catch: Throwable -> L15
        if (r104 == 1) goto L13;
        if (r104 != 2) goto L17;
    L13:
        r101.defaults |= 2;     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        th.printStackTrace();
        goto L17
    }
}
