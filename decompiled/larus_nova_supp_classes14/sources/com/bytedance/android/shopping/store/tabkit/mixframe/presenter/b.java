package com.bytedance.android.shopping.store.tabkit.mixframe.presenter;

import com.bytedance.android.ec.hybrid.list.ECHybridListEngine;
import com.bytedance.android.shopping.store.moments.dto.HybridListDTO;
import com.bytedance.android.shopping.store.tabkit.mixframe.ECTabKitMixFrameResponse;
import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class b<T> implements Observer {
    public final /* synthetic */ ECTabKitMixEnginePresenter a;
    public final /* synthetic */ ECHybridListEngine b;

    public b(ECTabKitMixEnginePresenter r1, ECHybridListEngine r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void onChanged(Object r3) {
        ECTabKitMixFrameResponse r4 = (ECTabKitMixFrameResponse) r3;
        if (this.a.h0().isRefresh() == false) goto L7;
        HybridListDTO r5 = r4.getHybridList();
        if (r5 == null) goto L10;
        ECHybridListEngine r0 = this.b;
        HybridListDTO.Companion.getClass();
        r0.r(HybridListDTO.a.a(r5));
    L10:
        this.a.h0().setRefresh(false);
        return;
    L7:
        HybridListDTO r6 = r4.getHybridList();
        if (r6 == null) goto L10;
        ECHybridListEngine r1 = this.b;
        HybridListDTO.Companion.getClass();
        r1.c(HybridListDTO.a.a(r6));
        goto L10
    }
}
