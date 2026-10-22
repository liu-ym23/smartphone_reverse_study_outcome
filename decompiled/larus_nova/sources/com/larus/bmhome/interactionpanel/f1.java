package com.larus.bmhome.interactionpanel;

import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final /* synthetic */ class f1 implements Function1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ThreadInteractionPanelMessageSourceComponent f312347a;

    public /* synthetic */ f1(ThreadInteractionPanelMessageSourceComponent r100) {
        this.f312347a = r100;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object r100) {
        ThreadInteractionPanelMessageSourceComponent r101 = this.f312347a;
        List r102 = (List) r100;
        int r103 = ThreadInteractionPanelMessageSourceComponent.f312314t;
        Intrinsics.checkNotNullParameter(r102, "messages");
        r101.F2().post(new h1(r101, "messageSnapshotChanged", r102));
        return Unit.INSTANCE;
    }
}
