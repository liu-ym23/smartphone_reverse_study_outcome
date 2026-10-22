package com.ss.android.lark.usersetting.service.notification;

import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.usersetting.base.UserSetting;
import com.ss.android.lark.usersetting.entity.NotificationSettingWrapper;
import java.util.Iterator;

/* JADX INFO: loaded from: classes38.dex */
public final class d implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ UserSetting f444645a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ b f444646b;

    public final void a() {
        UserSetting r100 = this.f444645a;
        if (r100 != null) goto L6;
        return;
    L6:
        if (r100.getNotificationSettingV2() != null) goto L9;
        Log.e("NotificationSetting", "notificationSettingV2 in newUserSetting is null");
        return;
    L9:
        NotificationSettingWrapper r101 = new NotificationSettingWrapper(this.f444645a.getNotificationSettingV2());
        Iterator<a> r102 = this.f444646b.f444641a.keySet().iterator();
    L11:
        if (r102.hasNext() == false) goto L13;
        r102.next().a(r101);
        goto L11
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public d(b r100, UserSetting r101) {
        this.f444646b = r100;
        this.f444645a = r101;
    }
}
