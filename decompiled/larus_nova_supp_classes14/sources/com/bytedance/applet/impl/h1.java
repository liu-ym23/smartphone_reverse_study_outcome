package com.bytedance.applet.impl;

import com.bytedance.ai.model.AppletRuntime;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final /* synthetic */ class h1 implements Function1 {
    public final /* synthetic */ Function0 a;

    public /* synthetic */ h1(Function0 r1) {
        this.a = r1;
    }

    public final Object invoke(Object r3) {
        Function0 r0 = this.a;
        AppletRuntime r4 = (AppletRuntime) r3;
        int r1 = MainlandAppletServiceImpl.d;
        if (r4 == null) goto L7;
        if (r0 == null) goto L7;
        r0.invoke();
    L7:
        return Unit.INSTANCE;
    }
}
