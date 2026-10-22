package com.ss.android.lark.flow.notification.online.process;

import android.app.Application;
import androidx.core.app.NotificationManagerCompat;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.notification.export.entity.Notice;
import com.ss.android.lark.utils.LarkContext;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Notice f423754a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ b f423755b;

    public final void a() {
        Notice r100 = this.f423754a;     // Catch: Throwable -> L16
        if (r100 != null) goto L6;
    L8:
        boolean r101 = false;
    L9:
        if (r101 == true) goto L14;
        iac.a r102 = iac.a.b(LarkContext.getApplication());     // Catch: Throwable -> L16
        Application r103 = LarkContext.getApplication();     // Catch: Throwable -> L16
        r102.getClass();     // Catch: Throwable -> L16
        if (NotificationManagerCompat.from(r103).areNotificationsEnabled() == true) goto L14;
        thb.a.b("FlowNotificationDispatcher", "Notification is disabled");     // Catch: Throwable -> L16
        return;
    L14:
        b.a(this.f423755b, this.f423754a);     // Catch: Throwable -> L16
        return;
    L6:
        if (r100.type != 20002) goto L8;
        r101 = true;
    L16:
        th = move-exception;
        int r104 = thb.a.f545987a;
        Intrinsics.checkNotNullParameter("FlowNotificationDispatcher", "tag");
        Log.e("FlowNotificationDispatcher", "[FlowNotificationLog] pushNotice", th, true);
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

    public a(b r100, Notice r101) {
        this.f423755b = r100;
        this.f423754a = r101;
    }
}
