package com.larus.im.internal.audio.session.omni;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public final /* synthetic */ class t implements Function1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.larus.im.service.audio.o f347384a;

    public /* synthetic */ t(com.larus.im.service.audio.o r100) {
        this.f347384a = r100;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object r100) {
        com.larus.im.service.audio.o r101 = this.f347384a;
        byte[] r102 = (byte[]) r100;
        Intrinsics.checkNotNullParameter(r102, "data");
        r101.j(r102);
        return Unit.INSTANCE;
    }
}
