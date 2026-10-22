package s37;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import com.bytedance.android.service.manager.push.notification.NotificationBody;
import com.bytedance.notification.extra.PushNotificationExtra;

/* JADX INFO: loaded from: classes21.dex */
public final class d implements t37.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f540499a;

    @Override // t37.a
    public final PendingIntent a(Context r100) {
        a r101 = this.f540499a;
        if (r101 != null) goto L5;
        return null;
    L5:
        return r101.a(r100);
    }

    public d(Context r100, Notification.Builder r110, Intent r111, PushNotificationExtra r112, NotificationBody r113) {
        int r101 = r112.f266056p;
        if (r101 != 0) goto L5;
        this.f540499a = new e(r100, r110, r111, r112, r113);
        return;
    L5:
        if (r101 != 1) goto L11;
        this.f540499a = new f(r100, r110, r111, r112, r113);
        return;
    }
}
