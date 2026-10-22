package com.bytedance.ee.bear.notification;

import android.text.TextUtils;
import androidx.lifecycle.Observer;
import com.bytedance.ee.bear.contract.i0;
import com.bytedance.ee.bear.notification.bean.Notification;
import java.util.Locale;

/* JADX INFO: loaded from: classes18.dex */
public final class h implements Observer<Notification> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ g.a f235115a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ j f235116b;

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Notification r100) {
        Notification r101 = r100;
        if (r101 == null) goto L11;
        j r102 = this.f235116b;
        g.a r103 = this.f235115a;
        r102.getClass();
        tt5.a.b("NotificationServiceImpl", "onNotificationOnline, result = " + r101);
        String r104 = ((i0) org.koin.java.a.a(i0.class)).a();
        String r105 = r101.getContent().getEn();
        if (TextUtils.equals(r104, Locale.JAPAN.getLanguage()) == false) goto L8;
        r105 = r101.getContent().getJa();
    L10:
        r103.showNotification(r101.getId(), r101.getProducts(), r105);
        this.f235116b.f235121b = r101.getId();
        return;
    L8:
        if (TextUtils.equals(r104, Locale.CHINESE.getLanguage()) == false) goto L10;
        r105 = r101.getContent().getZh();
        goto L10
    L11:
        j r106 = this.f235116b;
        g.a r107 = this.f235115a;
        r106.getClass();
        tt5.a.b("NotificationServiceImpl", "onNotificationOffline, result = " + r106.f235121b);
        r107.closeNotification(r106.f235121b);
        this.f235116b.f235121b = "";
    }

    public h(j r100, f.b r101) {
        this.f235116b = r100;
        this.f235115a = r101;
    }
}
