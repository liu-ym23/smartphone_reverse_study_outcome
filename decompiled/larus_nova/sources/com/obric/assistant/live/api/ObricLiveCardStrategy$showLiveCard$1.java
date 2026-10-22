package com.obric.assistant.live.api;

import com.obric.assistant.audio.service.ObricLiveServiceDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
public /* synthetic */ class ObricLiveCardStrategy$showLiveCard$1 extends FunctionReferenceImpl implements Function0<Unit> {
    public ObricLiveCardStrategy$showLiveCard$1(Object r100) {
        super(0, r100, ObricLiveServiceDelegate.class, "updateComplexTaskLiveCard", "updateComplexTaskLiveCard()V", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        ((ObricLiveServiceDelegate) this.receiver).i();
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }
}
