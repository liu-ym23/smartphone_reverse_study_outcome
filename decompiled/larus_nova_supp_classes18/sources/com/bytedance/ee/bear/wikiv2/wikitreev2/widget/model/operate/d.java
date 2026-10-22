package com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.operate;

import com.bytedance.ee.bear.wikiv2.wikitreev2.notification.WikiTreeNotificationServiceImpl;
import io.reactivex.functions.Consumer;
import kotlin.Lazy;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class d<T> implements Consumer {
    public final /* synthetic */ a.C0218a a;

    public d(a.C0218a r1) {
        this.a = r1;
    }

    public final void accept(Object r2) {
        Boolean r3 = (Boolean) r2;
        Lazy<WikiTreeNotificationServiceImpl> r4 = WikiTreeNotificationServiceImpl.b;
        WikiTreeNotificationServiceImpl.a.a().c(this.a);
        jw4.a.g("delete", this.a.e);
    }
}
