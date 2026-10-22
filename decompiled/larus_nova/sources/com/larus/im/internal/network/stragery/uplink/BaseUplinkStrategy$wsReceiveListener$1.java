package com.larus.im.internal.network.stragery.uplink;

import com.larus.im.internal.protocol.bean.DownlinkMessage;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
public /* synthetic */ class BaseUplinkStrategy$wsReceiveListener$1 extends FunctionReferenceImpl implements Function1<DownlinkMessage, Unit> {
    public BaseUplinkStrategy$wsReceiveListener$1(Object r100) {
        super(1, r100, BaseUplinkStrategy.class, "onWsReceive", "onWsReceive(Lcom/larus/im/internal/protocol/bean/DownlinkMessage;)V", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(DownlinkMessage r100) {
        Intrinsics.checkNotNullParameter(r100, "p0");
        ((BaseUplinkStrategy) this.receiver).a(r100);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(DownlinkMessage r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }
}
