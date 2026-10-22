package com.bytedance.ee.bear.list.folderselect.command;

import android.content.Context;
import com.bytedance.ee.bear.quoto.SingleFileQuotaConfig;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes18.dex */
public final class o<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ n f228199a;

    public o(n r100) {
        this.f228199a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        com.bytedance.ee.bear.quoto.t r101 = (com.bytedance.ee.bear.quoto.t) org.koin.java.a.c(com.bytedance.ee.bear.quoto.t.class, null, null, 6);
        Context r102 = this.f228199a.getContext();
        SingleFileQuotaConfig r103 = SingleFileQuotaConfig.DUPLICATE;
        r101.f(r102, r103, (Long) r100);
    }
}
