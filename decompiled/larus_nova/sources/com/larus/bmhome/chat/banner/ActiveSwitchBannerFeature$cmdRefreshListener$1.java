package com.larus.bmhome.chat.banner;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
public /* synthetic */ class ActiveSwitchBannerFeature$cmdRefreshListener$1 extends FunctionReferenceImpl implements Function1<String, Unit> {
    public ActiveSwitchBannerFeature$cmdRefreshListener$1(Object r100) {
        super(1, r100, ActiveSwitchBannerFeature.class, "requestRemote", "requestRemote(Ljava/lang/String;)V", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(String r100) {
        Intrinsics.checkNotNullParameter(r100, "p0");
        ((ActiveSwitchBannerFeature) this.receiver).iw(r100);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(String r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }
}
