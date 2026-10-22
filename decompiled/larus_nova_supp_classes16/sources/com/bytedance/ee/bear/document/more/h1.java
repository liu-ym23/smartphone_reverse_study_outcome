package com.bytedance.ee.bear.document.more;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class h1<T> implements Consumer {
    public final /* synthetic */ OfficeMoreProvider a;

    public h1(OfficeMoreProvider r1) {
        this.a = r1;
    }

    public final void accept(Object r1) {
        Boolean r2 = (Boolean) r1;
        this.a.g();
    }
}
