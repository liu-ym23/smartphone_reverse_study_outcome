package com.larus.audio.call.plugins;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes24.dex */
public final /* synthetic */ class a0 implements Function1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CommonCallTimingPlugin f289432a;

    public /* synthetic */ a0(CommonCallTimingPlugin r100) {
        this.f289432a = r100;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object r100) {
        this.f289432a.k3(((Long) r100).longValue());
        return Unit.INSTANCE;
    }
}
