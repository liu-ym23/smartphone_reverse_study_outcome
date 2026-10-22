package com.bytedance.ee.bear.document.more;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a<T> implements Consumer {
    public final /* synthetic */ BitableAppMoreProvider a;

    public a(BitableAppMoreProvider r1) {
        this.a = r1;
    }

    public final void accept(Object r1) {
        Boolean r2 = (Boolean) r1;
        this.a.g();
    }
}
