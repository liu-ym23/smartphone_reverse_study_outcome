package com.bytedance.badger.network;

import com.bytedance.badger.data.ReportStage;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes47.dex */
final class E extends Lambda implements Function0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ F f199048a;

    public E(F r100) {
        this.f199048a = r100;
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public Object invoke() {
        z0 r100 = d0.f199093a;
        b r101 = this.f199048a.f199049a;
        ReportStage r102 = ReportStage.FINAL;
        boolean r103 = r101.f199077e;
        long r104 = r101.f199078f;
        d0.c(new b(r101.f199073a, r101.f199074b, r101.f199075c, r102, r103, r104, r101.f199079g, r101.f199080h, false, 256));
        return Unit.INSTANCE;
    }
}
