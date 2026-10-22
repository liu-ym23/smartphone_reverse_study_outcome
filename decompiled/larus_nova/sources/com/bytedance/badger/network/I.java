package com.bytedance.badger.network;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import z64.i;

/* JADX INFO: loaded from: classes47.dex */
final class I extends Lambda implements Function0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ J f199052a;

    public I(J r100) {
        this.f199052a = r100;
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public Object invoke() {
        b r100 = this.f199052a.f199053a;
        r100.f199075c.a(new i.b(r100.f199073a));
        return Unit.INSTANCE;
    }
}
