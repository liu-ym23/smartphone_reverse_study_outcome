package com.bytedance.ee.bear.list.folderselect.command;

import android.content.Context;
import com.bytedance.ee.bear.quoto.SingleFileQuotaConfig;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class o<T> implements Consumer {
    public final /* synthetic */ n a;

    public o(n r1) {
        this.a = r1;
    }

    public final void accept(Object r4) {
        com.bytedance.ee.bear.quoto.t r0 = (com.bytedance.ee.bear.quoto.t) org.koin.java.a.c(com.bytedance.ee.bear.quoto.t.class, null, null, 6);
        Context r1 = this.a.getContext();
        SingleFileQuotaConfig r2 = SingleFileQuotaConfig.DUPLICATE;
        r0.f(r1, r2, (Long) r4);
    }
}
