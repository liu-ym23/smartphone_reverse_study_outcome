package com.bytedance.caijing.sdk.infra.base.impl.ttnet;

import com.android.ttcjpaysdk.base.network.ICJPayRequest;
import com.bytedance.retrofit2.Call;

/* JADX INFO: loaded from: classes3.dex */
public final class b implements ICJPayRequest {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Call f202749a;

    @Override // com.android.ttcjpaysdk.base.network.CancelAble
    public final void cancel() {
        Call r100 = this.f202749a;
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.isCanceled() == false) goto L7;
        return;
    L7:
        if (this.f202749a.isExecuted() == true) goto L12;
        this.f202749a.cancel();
        return;
    }

    public b(Call r100) {
        this.f202749a = r100;
    }
}
