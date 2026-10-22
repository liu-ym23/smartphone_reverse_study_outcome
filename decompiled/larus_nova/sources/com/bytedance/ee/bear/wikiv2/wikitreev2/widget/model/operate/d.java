package com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.operate;

import com.bytedance.ee.bear.wikiv2.wikitreev2.notification.WikiTreeNotificationServiceImpl;
import io.reactivex.functions.Consumer;
import kotlin.Lazy;

/* JADX INFO: loaded from: classes18.dex */
public final class d<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a.C3465a f241993a;

    public d(a.C3465a r100) {
        this.f241993a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Boolean r101 = (Boolean) r100;
        Lazy<WikiTreeNotificationServiceImpl> r102 = WikiTreeNotificationServiceImpl.f241625b;
        WikiTreeNotificationServiceImpl.a.a().c(this.f241993a);
        jw4.a.g("delete", this.f241993a.f241982e);
    }
}
