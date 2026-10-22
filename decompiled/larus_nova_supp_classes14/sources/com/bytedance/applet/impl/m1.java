package com.bytedance.applet.impl;

import com.bytedance.ai.applet.douyinAuth.DouyinGeneralAuthHelper;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final /* synthetic */ class m1 implements Function2 {
    public final /* synthetic */ Function2 a;

    public /* synthetic */ m1(DouyinGeneralAuthHelper.a r1) {
        this.a = r1;
    }

    public final Object invoke(Object r2, Object r3) {
        Function2 r0 = this.a;
        Boolean r4 = Boolean.valueOf(((Boolean) r2).booleanValue());
        r0.invoke(r4, (String) r3);
        return Unit.INSTANCE;
    }
}
