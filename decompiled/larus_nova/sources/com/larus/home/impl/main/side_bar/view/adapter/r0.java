package com.larus.home.impl.main.side_bar.view.adapter;

import java.util.Set;
import kotlin.Unit;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes29.dex */
public final /* synthetic */ class r0 implements Function0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ boolean f345015a;

    public /* synthetic */ r0(boolean r100) {
        this.f345015a = r100;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        boolean r100 = this.f345015a;
        t0.f345027g++;
        t0.f345028h++;
        t0.f345029i = null;
        t0.f345030j = false;
        t0 r101 = t0.f345021a;
        Set r102 = SetsKt.emptySet();
        r101.getClass();
        t0.a(r102);
        if (r100 == false) goto L6;
        t0.d();
    L6:
        return Unit.INSTANCE;
    }
}
