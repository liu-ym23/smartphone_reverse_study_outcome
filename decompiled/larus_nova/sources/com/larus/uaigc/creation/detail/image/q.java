package com.larus.uaigc.creation.detail.image;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes31.dex */
public final /* synthetic */ class q implements Function1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BigImageDetailFragment f372839a;

    public /* synthetic */ q(BigImageDetailFragment r100) {
        this.f372839a = r100;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object r100) {
        int r101 = BigImageDetailFragment.I;
        this.f372839a.ha0((Throwable) r100, "saveBitmapWithCheckWatermark");
        return Unit.INSTANCE;
    }
}
