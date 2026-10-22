package com.ss.android.lark.usersetting.service.notification;

import aac.g;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.callback.IGetDataCallback;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.usersetting.base.UserSetting;
import com.ss.android.lark.usersetting.entity.NotificationSettingV2;

/* JADX INFO: loaded from: classes38.dex */
public final class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ IGetDataCallback f444644a;

    @Override // java.lang.Runnable
    public final void run() {
        UserSetting r100 = g.d.f2395a.a();     // Catch: Throwable -> L11
        if (r100 != null) goto L8;
        IGetDataCallback r101 = this.f444644a;     // Catch: Throwable -> L11
        if (r101 == null) goto L16;
        r101.onError(new ErrorResult("User setting is null"));     // Catch: Throwable -> L11
    L16:
        return;
    L8:
        if (this.f444644a == null) goto L16;
        NotificationSettingV2 r102 = r100.getNotificationSettingV2();     // Catch: Throwable -> L11
        this.f444644a.onSuccess(r102);     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L19;
        throw th;
    }

    public c(IGetDataCallback r100) {
        this.f444644a = r100;
    }
}
