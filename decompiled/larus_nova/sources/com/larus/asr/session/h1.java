package com.larus.asr.session;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes24.dex */
public final /* synthetic */ class h1 implements Function1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ i1 f287866a;

    public /* synthetic */ h1(i1 r100) {
        this.f287866a = r100;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object r100) {
        i1 r101 = this.f287866a;
        byte[] r102 = (byte[]) r100;
        if (r102 == null) goto L6;
        r101.f287874a.Ma(r101.f287875b, r102);
    L6:
        return Unit.INSTANCE;
    }
}
