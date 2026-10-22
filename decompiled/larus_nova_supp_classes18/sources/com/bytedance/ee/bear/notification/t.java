package com.bytedance.ee.bear.notification;

import com.bytedance.ee.bear.notification.bean.Notification;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class t implements Consumer<List<Notification>> {
    public final /* synthetic */ o a;

    public t(o r1) {
        this.a = r1;
    }

    public final void accept(Object r6) throws Exception {
        ArrayList r0 = new ArrayList();
        Iterator r7 = ((List) r6).iterator();
    L4:
        if (r7.hasNext() == false) goto L9;
        Notification r1 = (Notification) r7.next();
        if (this.a.c.contains(r1.getId()) == true) goto L7;
        r0.add(r1);
        goto L4
    L7:
        tt5.a.b("NotificationViewModel", "result " + du5.b.f(r1) + " has closed but unsync, ignore it");
        goto L4
    L9:
        tt5.a.h("NotificationViewModel", "loadValidNotificationFromNet, result = " + du5.b.f(r0));
        dk5.e r8 = this.a.e;
        r8.getClass();
        fo5.d.b().scheduleDirect(new dk5.h(r8, r0));
    }
}
