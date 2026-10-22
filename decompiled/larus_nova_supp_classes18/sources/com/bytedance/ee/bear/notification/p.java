package com.bytedance.ee.bear.notification;

import io.reactivex.functions.Consumer;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class p implements Consumer<List<String>> {
    public final /* synthetic */ o a;

    public p(o r1) {
        this.a = r1;
    }

    public final void accept(Object r3) throws Exception {
        List<String> r4 = (List) r3;
        tt5.a.b("NotificationViewModel", "loadUnSyncNotification: " + r4);
        this.a.c.clear();
        this.a.c.addAll(r4);
        this.a.e.a(r4);
    }
}
