package com.ss.android.dypay.activity.f;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import vta.a;
import vta.b;

/* JADX INFO: loaded from: classes34.dex */
public final class g extends Lambda implements Function0<Unit> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ i f408410a;

    public g(i r100) {
        this.f408410a = r100;
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public Unit invoke() {
        i r100 = this.f408410a;
        e.a r101 = e.a.f408387b;
        b r102 = r100.f408424m.c();
        if (r102 == null) goto L5;
        a r103 = r102.f557255h;
    L6:
        i.g(r100, r101, r103);
        rta.b r104 = this.f408410a.f408420i;
        if (r104 == null) goto L10;
        r104.b();
    L10:
        return Unit.INSTANCE;
    L5:
        r103 = null;
        goto L6
    }
}
