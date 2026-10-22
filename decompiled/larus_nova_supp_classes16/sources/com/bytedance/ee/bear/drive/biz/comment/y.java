package com.bytedance.ee.bear.drive.biz.comment;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final /* synthetic */ class y implements Function1 {
    public final /* synthetic */ a1 a;

    public /* synthetic */ y(a1 r1) {
        this.a = r1;
    }

    public final Object invoke(Object r2) {
        Boolean r3 = (Boolean) r2;
        Function1<Boolean, Unit> r0 = this.a.d;
        if (r0 == null) goto L6;
        r0.invoke(r3);
    L6:
        return Unit.INSTANCE;
    }
}
