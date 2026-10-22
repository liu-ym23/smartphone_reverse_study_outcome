package com.larus.navigation.impl;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
final /* synthetic */ class BaiduNavigationEngine$doStartNavigation$bridge$1 extends FunctionReferenceImpl implements Function0<Unit> {
    public BaiduNavigationEngine$doStartNavigation$bridge$1(Object r100) {
        super(0, r100, BaiduNavigationEngine.class, "onNavigationStopped", "onNavigationStopped()V", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        BaiduNavigationEngine r100 = (BaiduNavigationEngine) this.receiver;
        int r101 = BaiduNavigationEngine.f359725h;
        r100.i();
        r100.f359730e = false;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }
}
