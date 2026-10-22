package com.larus.im.internal.network.link.impl.rtc.abs;

import ff9.s;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes30.dex */
public final /* synthetic */ class b implements Function0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ FlowRTCLinkSession f349272a;

    public /* synthetic */ b(FlowRTCLinkSession r100) {
        this.f349272a = r100;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        FlowRTCLinkSession r100 = this.f349272a;
        fe9.a.f476620a.e("FlowRTCLinkSession", "[handleSelfVideoCaptureStarted] lazy publish video executed");
        s r101 = r100.f349259w;
        if (r101 == null) goto L5;
        r101.d(true);
    L5:
        r100.f349256t = null;
        return Unit.INSTANCE;
    }
}
