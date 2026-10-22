package com.bytedance.badger;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes47.dex */
final class b extends Lambda implements Function1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ long f199026a;

    public b(long r100) {
        this.f199026a = r100;
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public Object invoke(Object r100) {
        long r101 = this.f199026a;
        ((com.bytedance.badger.t.c) r100).f199195a.b(r101);
        return Unit.INSTANCE;
    }
}
