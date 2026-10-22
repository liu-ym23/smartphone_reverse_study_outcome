package com.bytedance.badger;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes47.dex */
final class h extends Lambda implements Function1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ z64.c f199033a;

    public h(z64.c r100) {
        this.f199033a = r100;
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public Object invoke(Object r100) {
        ((com.bytedance.badger.t.c) r100).c(this.f199033a.getDeviceId());
        return Unit.INSTANCE;
    }
}
