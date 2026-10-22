package com.bytedance.ee.bear.notification;

import io.reactivex.functions.Consumer;
import java.util.List;

/* JADX INFO: loaded from: classes18.dex */
public final class p implements Consumer<List<String>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ o f235143a;

    public p(o r100) {
        this.f235143a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(List<String> r100) throws Exception {
        List<String> r101 = r100;
        tt5.a.b("NotificationViewModel", "loadUnSyncNotification: " + r101);
        this.f235143a.f235133c.clear();
        this.f235143a.f235133c.addAll(r101);
        this.f235143a.f235135e.a(r101);
    }
}
