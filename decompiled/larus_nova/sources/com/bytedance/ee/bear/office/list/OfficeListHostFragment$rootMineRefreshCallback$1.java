package com.bytedance.ee.bear.office.list;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
public /* synthetic */ class OfficeListHostFragment$rootMineRefreshCallback$1 extends FunctionReferenceImpl implements Function0<Boolean> {
    public OfficeListHostFragment$rootMineRefreshCallback$1(Object r100) {
        super(0, r100, OfficeListHostFragment.class, "refreshCurrentListAfterSelectorResult", "refreshCurrentListAfterSelectorResult()Z", 0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final Boolean invoke() {
        OfficeListHostFragment r100 = (OfficeListHostFragment) this.receiver;
        int r101 = OfficeListHostFragment.f235527r;
        return Boolean.valueOf(r100.Y90());
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Boolean invoke() {
        return invoke();
    }
}
