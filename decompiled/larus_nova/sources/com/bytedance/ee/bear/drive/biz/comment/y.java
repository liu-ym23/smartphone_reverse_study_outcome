package com.bytedance.ee.bear.drive.biz.comment;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes16.dex */
public final /* synthetic */ class y implements Function1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a1 f222833a;

    public /* synthetic */ y(a1 r100) {
        this.f222833a = r100;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object r100) {
        Boolean r101 = (Boolean) r100;
        Function1<Boolean, Unit> r102 = this.f222833a.f222675d;
        if (r102 == null) goto L6;
        r102.invoke(r101);
    L6:
        return Unit.INSTANCE;
    }
}
