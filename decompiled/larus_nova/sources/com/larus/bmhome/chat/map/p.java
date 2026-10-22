package com.larus.bmhome.chat.map;

import com.larus.platform.service.t1;
import com.larus.utils.t0;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes25.dex */
public final /* synthetic */ class p implements Function1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ r f306913a;

    public /* synthetic */ p(r r100) {
        this.f306913a = r100;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object r100) {
        final r r101 = this.f306913a;
        if (((Boolean) r100).booleanValue() == false) goto L8;
        if (t1.f365807a.d() == false) goto L8;
        t0.c(new q(r101));
    L8:
        return Unit.INSTANCE;
    }
}
