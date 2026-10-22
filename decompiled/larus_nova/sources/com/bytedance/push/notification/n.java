package com.bytedance.push.notification;

import android.app.NotificationManager;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.bytedance.common.push.ThreadPlus;
import v67.u;

/* JADX INFO: loaded from: classes3.dex */
public final class n implements v67.h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final u f266983a;

    public n(u r100) {
        this.f266983a = r100;
    }

    public final void b(Context r100) {
        com.bytedance.push.utils.f.b("NoticeStateSync", "[trySyncNoticeStateOnce]");
        com.ss.android.pushmanager.setting.b.b().getClass();
        if (com.ss.android.pushmanager.setting.b.c().u() == false) goto L6;
        ThreadPlus.submitRunnable(new l(this, r100, ""));
        return;
    }

    public static boolean a(Context r100, String r101) {
    L15:
        e = move-exception;
        e.printStackTrace();
        return false;
    L4:
        if (Build.VERSION.SDK_INT < 26) goto L14;
        NotificationManager r102 = (NotificationManager) r100.getSystemService("notification");     // Catch: Exception -> L15
        if (r102 != null) goto L8;
        return false;
    L8:
        if (TextUtils.isEmpty(r101) == true) goto L21;
        if (r102.getNotificationChannel(r101) == null) goto L22;
        return true;
    L22:
        return false;
    L21:
        return false;
    L14:
        return true;
    }

    public final void c(Context r100, String r101) {
        com.bytedance.push.utils.f.b("NoticeStateSync", "[trySyncNoticeStateOnce]");
        com.ss.android.pushmanager.setting.b.b().getClass();
        if (com.ss.android.pushmanager.setting.b.c().u() == false) goto L6;
        ThreadPlus.submitRunnable(new l(this, r100, r101));
        return;
    }
}
