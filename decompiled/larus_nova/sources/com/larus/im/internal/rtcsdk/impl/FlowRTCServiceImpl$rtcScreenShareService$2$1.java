package com.larus.im.internal.rtcsdk.impl;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
final /* synthetic */ class FlowRTCServiceImpl$rtcScreenShareService$2$1 extends FunctionReferenceImpl implements Function1<Boolean, Unit> {
    public FlowRTCServiceImpl$rtcScreenShareService$2$1(Object r100) {
        super(1, r100, s.class, "onScreenShareStateChanged", "onScreenShareStateChanged(Z)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Boolean r100) {
        invoke(r100.booleanValue());
        return Unit.INSTANCE;
    }

    public final void invoke(boolean r100) {
        df9.a r101 = ((s) this.receiver).f349988e;
        if (r101 == null) goto L6;
        r101.c(r100);
        return;
    }
}
