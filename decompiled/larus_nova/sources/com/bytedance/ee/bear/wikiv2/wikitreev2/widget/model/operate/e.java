package com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.operate;

import com.bytedance.ee.bear.wikiv2.wikitreev2.notification.WikiTreeNotificationServiceImpl;
import io.reactivex.functions.Consumer;
import kotlin.Lazy;

/* JADX INFO: loaded from: classes18.dex */
public final class e<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a.C3465a f241994a;

    public e(a.C3465a r100) {
        this.f241994a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Throwable r101 = (Throwable) r100;
        tt5.a.d("WikiNodeOperationImpl", "IOperationDelete, deleteCurrentOnly fail. " + du5.b.f(r101));
        int r102 = rq5.a.f538926a;
        a.C3465a r103 = this.f241994a;
        rq5.a.C7519a.a(r101, r103.f241978a, r103.f241979b, false);
        this.f241994a.f241981d = r101;
        Lazy<WikiTreeNotificationServiceImpl> r104 = WikiTreeNotificationServiceImpl.f241625b;
        WikiTreeNotificationServiceImpl.a.a().a(this.f241994a);
        jw4.a.h("delete", r101, this.f241994a.f241982e);
    }
}
