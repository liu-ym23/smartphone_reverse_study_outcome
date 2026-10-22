package com.larus.uaigc.createpage.component.instruction;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes31.dex */
public final /* synthetic */ class i2 implements Function1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function0 f371821a;

    public /* synthetic */ i2(Function0 r100) {
        this.f371821a = r100;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object r100) {
        Function0 r101 = this.f371821a;
        if (((Boolean) r100).booleanValue() == false) goto L6;
        r101.invoke();
    L6:
        return Unit.INSTANCE;
    }
}
