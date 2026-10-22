package com.bytedance.applet.impl;

import com.larus.platform.api.MusicOperateResult;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final /* synthetic */ class a1 implements Function1 {
    public final /* synthetic */ Function1 a;

    public /* synthetic */ a1(o1 r1) {
        this.a = r1;
    }

    public final Object invoke(Object r3) {
        Function1 r0 = this.a;
        MusicOperateResult r4 = (MusicOperateResult) r3;
        int r1 = AppletV2ServiceImpl.a;
        Intrinsics.checkNotNullParameter(r4, "it");
        r0.invoke(c1.a(r4));
        return Unit.INSTANCE;
    }
}
