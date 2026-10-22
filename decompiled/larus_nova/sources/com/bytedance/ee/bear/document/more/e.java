package com.bytedance.ee.bear.document.more;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes16.dex */
public final class e<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DocMoreProvider f220324a;

    public e(DocMoreProvider r100) {
        this.f220324a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Boolean r101 = (Boolean) r100;
        this.f220324a.g();
    }
}
