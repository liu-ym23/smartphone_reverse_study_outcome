package com.larus.dora.obric.device_management.device_bind;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
final /* synthetic */ class DoraObricDeviceBindFragment$buildContentView$2 extends FunctionReferenceImpl implements Function0<Unit> {
    public DoraObricDeviceBindFragment$buildContentView$2(Object r100) {
        super(0, r100, DoraObricDeviceBindFragment.class, "startBind", "startBind()V", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        DoraObricDeviceBindFragment r100 = (DoraObricDeviceBindFragment) this.receiver;
        int[] r101 = DoraObricDeviceBindFragment.f338938o;
        r100.getClass();
        r100.W90("check_from_MAIN", new j(r100));
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }
}
