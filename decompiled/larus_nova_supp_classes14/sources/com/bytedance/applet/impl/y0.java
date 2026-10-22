package com.bytedance.applet.impl;

import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final /* synthetic */ class y0 implements Function2 {
    public final /* synthetic */ Function2 a;

    public /* synthetic */ y0(Function2 r1) {
        this.a = r1;
    }

    public final Object invoke(Object r3, Object r4) {
        Function2 r0 = this.a;
        boolean r5 = ((Boolean) r3).booleanValue();
        int r1 = AppletV2ServiceImpl.a;
        Boolean r6 = Boolean.valueOf(r5);
        r0.invoke(r6, (String) r4);
        return Unit.INSTANCE;
    }
}
