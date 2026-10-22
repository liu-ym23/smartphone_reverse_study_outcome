package com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.operate;

import com.bytedance.ee.bear.wikiv2.wikitreev2.notification.WikiTreeNotificationServiceImpl;
import io.reactivex.functions.Consumer;
import kotlin.Lazy;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class e<T> implements Consumer {
    public final /* synthetic */ a.C0218a a;

    public e(a.C0218a r1) {
        this.a = r1;
    }

    public final void accept(Object r4) {
        Throwable r5 = (Throwable) r4;
        tt5.a.d("WikiNodeOperationImpl", "IOperationDelete, deleteCurrentOnly fail. " + du5.b.f(r5));
        int r0 = rq5.a.a;
        a.C0218a r1 = this.a;
        rq5.a.C0302a.a(r5, r1.a, r1.b, false);
        this.a.d = r5;
        Lazy<WikiTreeNotificationServiceImpl> r2 = WikiTreeNotificationServiceImpl.b;
        WikiTreeNotificationServiceImpl.a.a().a(this.a);
        jw4.a.h("delete", r5, this.a.e);
    }
}
