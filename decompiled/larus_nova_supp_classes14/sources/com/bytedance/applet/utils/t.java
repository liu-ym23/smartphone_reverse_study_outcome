package com.bytedance.applet.utils;

import android.os.Build;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.content.ContextCompat;
import com.larus.common.apphost.AppHost;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class t {
    static {
    }

    public static boolean a() {
        if (Build.VERSION.SDK_INT < 33) goto L9;
        if (ContextCompat.checkSelfPermission(AppHost.a.getApplication(), "android.permission.POST_NOTIFICATIONS") != 0) goto L7;
        return true;
    L7:
        return false;
    L9:
        return NotificationManagerCompat.from(AppHost.a.getApplication()).areNotificationsEnabled();
    }
}
