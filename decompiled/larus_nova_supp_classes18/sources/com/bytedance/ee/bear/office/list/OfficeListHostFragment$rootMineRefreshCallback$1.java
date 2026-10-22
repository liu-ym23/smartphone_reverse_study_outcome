package com.bytedance.ee.bear.office.list;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
public /* synthetic */ class OfficeListHostFragment$rootMineRefreshCallback$1 extends FunctionReferenceImpl implements Function0<Boolean> {
    public OfficeListHostFragment$rootMineRefreshCallback$1(Object r8) {
        super(0, r8, OfficeListHostFragment.class, "refreshCurrentListAfterSelectorResult", "refreshCurrentListAfterSelectorResult()Z", 0);
    }

    public final Boolean invoke() {
        OfficeListHostFragment r0 = (OfficeListHostFragment) ((CallableReference) this).receiver;
        int r1 = OfficeListHostFragment.r;
        return Boolean.valueOf(r0.Y90());
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m373invoke() {
        return invoke();
    }
}
