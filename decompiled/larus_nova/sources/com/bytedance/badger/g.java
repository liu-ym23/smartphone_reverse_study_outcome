package com.bytedance.badger;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes47.dex */
final class g extends Lambda implements Function1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ byte[] f199032a;

    public g(byte[] r100) {
        this.f199032a = r100;
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public Object invoke(Object r100) {
        byte[] r101 = this.f199032a;
        ((com.bytedance.badger.t.c) r100).f199195a.d(r101);
        return Unit.INSTANCE;
    }
}
