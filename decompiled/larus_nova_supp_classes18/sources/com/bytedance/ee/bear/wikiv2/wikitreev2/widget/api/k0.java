package com.bytedance.ee.bear.wikiv2.wikitreev2.widget.api;

import com.bytedance.ee.bear.contract.NetService;
import io.reactivex.functions.Function;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final /* synthetic */ class k0 implements Function {
    public final /* synthetic */ NetService a;

    public /* synthetic */ k0(NetService r1) {
        this.a = r1;
    }

    public final Object apply(Object r5) {
        NetService r0 = this.a;
        return l0.e((String) r5, System.currentTimeMillis(), 0, r0);
    }
}
