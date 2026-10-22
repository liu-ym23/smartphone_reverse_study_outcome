package com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.operate;

import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.api.DelSingleNodePuller;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.api.a0;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.api.k0;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class c<T, R> implements Function {
    public final /* synthetic */ a.C0218a a;
    public final /* synthetic */ ce5.a b;

    public c(a.C0218a r1, ce5.a r2) {
        this.a = r1;
        this.b = r2;
    }

    public final Object apply(Object r4) {
        Intrinsics.checkNotNullParameter((String) r4, "it");
        a.C0218a r0 = this.a;
        DelSingleNodePuller.Params r5 = new DelSingleNodePuller.Params(r0.a, r0.b, r0.chainPushUUid);
        NetService r1 = this.b.c;
        return new DelSingleNodePuller(r1).c(r5).map(new a0()).flatMap(new k0(r1));
    }
}
