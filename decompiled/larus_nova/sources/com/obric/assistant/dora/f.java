package com.obric.assistant.dora;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public final /* synthetic */ class f implements Function1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ IDoraPrivateProtocolCallback f389115a;

    public /* synthetic */ f(IDoraPrivateProtocolCallback r100) {
        this.f389115a = r100;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object r100) {
        IDoraPrivateProtocolCallback r101 = this.f389115a;
        int r102 = DoraPrivateProtocolService.f389092e;
        return Boolean.valueOf(Intrinsics.areEqual(((DoraPrivateProtocolService.a) r100).f389099a.asBinder(), r101.asBinder()));
    }
}
