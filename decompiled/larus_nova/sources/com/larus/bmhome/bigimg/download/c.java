package com.larus.bmhome.bigimg.download;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes25.dex */
public final /* synthetic */ class c implements Function1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CommonDownLoadLayout f295971a;

    public /* synthetic */ c(CommonDownLoadLayout r100) {
        this.f295971a = r100;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object r100) {
        CommonDownLoadLayout r101 = this.f295971a;
        if (((Boolean) r100).booleanValue() == false) goto L5;
        r101.T5();
    L7:
        return Unit.INSTANCE;
    L5:
        r101.R5();
        goto L7
    }
}
