package com.bytedance.ee.bear.notification;

import android.text.TextUtils;
import androidx.lifecycle.Observer;
import com.bytedance.ee.bear.contract.i0;
import com.bytedance.ee.bear.notification.bean.Notification;
import java.util.Locale;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class h implements Observer<Notification> {
    public final /* synthetic */ g.a a;
    public final /* synthetic */ j b;

    public final void onChanged(Object r5) {
        Notification r6 = (Notification) r5;
        if (r6 == null) goto L11;
        j r1 = this.b;
        g.a r2 = this.a;
        r1.getClass();
        tt5.a.b("NotificationServiceImpl", "onNotificationOnline, result = " + r6);
        String r0 = ((i0) org.koin.java.a.a(i0.class)).a();
        String r3 = r6.getContent().getEn();
        if (TextUtils.equals(r0, Locale.JAPAN.getLanguage()) == false) goto L8;
        r3 = r6.getContent().getJa();
    L10:
        r2.showNotification(r6.getId(), r6.getProducts(), r3);
        this.b.b = r6.getId();
        return;
    L8:
        if (TextUtils.equals(r0, Locale.CHINESE.getLanguage()) == false) goto L10;
        r3 = r6.getContent().getZh();
        goto L10
    L11:
        j r7 = this.b;
        g.a r4 = this.a;
        r7.getClass();
        tt5.a.b("NotificationServiceImpl", "onNotificationOffline, result = " + r7.b);
        r4.closeNotification(r7.b);
        this.b.b = "";
    }

    public h(j r1, f.b r2) {
        this.b = r1;
        this.a = r2;
    }
}
