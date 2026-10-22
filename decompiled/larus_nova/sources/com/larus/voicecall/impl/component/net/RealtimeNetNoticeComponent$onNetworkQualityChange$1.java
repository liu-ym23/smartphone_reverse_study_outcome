package com.larus.voicecall.impl.component.net;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
final /* synthetic */ class RealtimeNetNoticeComponent$onNetworkQualityChange$1 extends FunctionReferenceImpl implements Function1<a, Unit> {
    public RealtimeNetNoticeComponent$onNetworkQualityChange$1(Object r100) {
        super(1, r100, RealtimeNetNoticeComponent.class, "transitionTo", "transitionTo(Lcom/larus/voicecall/impl/component/net/INetworkViewState;)V", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(a r100) {
        Intrinsics.checkNotNullParameter(r100, "p0");
        RealtimeNetNoticeComponent r101 = (RealtimeNetNoticeComponent) this.receiver;
        int r102 = RealtimeNetNoticeComponent.f377543y;
        r101.B3(r100);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(a r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }
}
