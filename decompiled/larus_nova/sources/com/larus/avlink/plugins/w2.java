package com.larus.avlink.plugins;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes25.dex */
public final class w2 extends k4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function1<Boolean, Unit> f294107a;

    public w2(c3 r100) {
        this.f294107a = r100;
    }

    @Override // com.larus.avlink.plugins.k4, f49.b
    public final void d(int r100) {
        Function1<Boolean, Unit> r101 = this.f294107a;
        boolean r102 = true;
        if (r100 == 1) goto L6;
        r102 = false;
    L6:
        r101.invoke(Boolean.valueOf(r102));
    }
}
