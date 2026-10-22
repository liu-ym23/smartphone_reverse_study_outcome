package com.ss.android.dypay.activity.f;

import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import rta.b;
import vta.a;

/* JADX INFO: loaded from: classes34.dex */
public final class h extends Lambda implements Function2<e.a, a, Unit> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ i f408411a;

    public h(i r100) {
        this.f408411a = r100;
        super(2);
    }

    @Override // kotlin.jvm.functions.Function2
    public Unit invoke(e.a r100, a r101) {
        i r102 = this.f408411a;
        i.g(r102, r100, r101);
        b r103 = this.f408411a.f408420i;
        if (r103 == null) goto L6;
        r103.b();
    L6:
        return Unit.INSTANCE;
    }
}
