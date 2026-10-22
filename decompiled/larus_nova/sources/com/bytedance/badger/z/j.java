package com.bytedance.badger.z;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes47.dex */
final class j extends Lambda implements Function1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Long f199473a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ long f199474b;

    public j(Long r100, long r101) {
        this.f199473a = r100;
        this.f199474b = r101;
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public Object invoke(Object r100) {
        com.bytedance.badger.t.c r101 = (com.bytedance.badger.t.c) r100;
        long r102 = this.f199473a.longValue();
        r101.f199195a.b(r102);
        long r103 = this.f199474b;
        r101.f199195a.b(r103);
        return Unit.INSTANCE;
    }
}
