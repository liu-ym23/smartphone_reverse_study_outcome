package com.bytedance.ee.bear.notification;

import com.bytedance.ee.bear.notification.bean.Notification;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes18.dex */
public final class t implements Consumer<List<Notification>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ o f235144a;

    public t(o r100) {
        this.f235144a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(List<Notification> r100) throws Exception {
        ArrayList r101 = new ArrayList();
        Iterator<Notification> r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L9;
        Notification r103 = r102.next();
        if (this.f235144a.f235133c.contains(r103.getId()) == true) goto L7;
        r101.add(r103);
        goto L4
    L7:
        tt5.a.b("NotificationViewModel", "result " + du5.b.f(r103) + " has closed but unsync, ignore it");
        goto L4
    L9:
        tt5.a.h("NotificationViewModel", "loadValidNotificationFromNet, result = " + du5.b.f(r101));
        dk5.e r104 = this.f235144a.f235135e;
        r104.getClass();
        fo5.d.b().scheduleDirect(new dk5.h(r104, r101));
    }
}
