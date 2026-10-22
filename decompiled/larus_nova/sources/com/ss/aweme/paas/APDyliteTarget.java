package com.ss.aweme.paas;

import aj9.b;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/ss/aweme/paas/APDyliteTarget;", "Lcom/ss/aweme/paas/IAwemePaasTarget;", "<init>", "()V", "aweme_paas_kit_release"}, k = 1, mv = {1, 4, 3})
public final class APDyliteTarget implements IAwemePaasTarget {
    public APDyliteTarget() {
    }

    @Override // com.ss.aweme.paas.IAwemePaasTarget
    public final int a() {
        if (b.a() == false) goto L5;
        return 0;
    L5:
        Integer r100 = 2;
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type kotlin.Int");
        return r100.intValue();
    }
}
