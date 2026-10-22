package com.larus.dora.impl.ota;

import java.util.Map;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;

/* JADX INFO: loaded from: classes4.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final MutableSharedFlow<Map<String, c>> f337481a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final MutableSharedFlow f337482b;

    public d() {
        MutableSharedFlow<Map<String, c>> r100 = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7, null);
        this.f337481a = r100;
        this.f337482b = r100;
    }
}
