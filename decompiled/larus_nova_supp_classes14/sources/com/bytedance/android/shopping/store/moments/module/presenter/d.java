package com.bytedance.android.shopping.store.moments.module.presenter;

import com.bytedance.android.ec.hybrid.list.ECHybridListEngine;
import com.bytedance.android.shopping.store.moments.dto.ECStoreMomentResponse;
import com.bytedance.android.shopping.store.moments.dto.HybridListDTO;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import kotlin.Unit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class d<T> implements Observer {
    public final /* synthetic */ ECStoreMomentPresenter a;

    public d(ECStoreMomentPresenter r1) {
        this.a = r1;
    }

    public final void onChanged(Object r4) {
        HybridListDTO r5 = ((ECStoreMomentResponse) r4).getHybridList();
        if (r5 == null) goto L13;
        ECHybridListEngine r0 = this.a.g;
        if (r0 == null) goto L14;
        HybridListDTO.Companion.getClass();
        com.bytedance.android.ec.hybrid.list.entity.k r6 = HybridListDTO.a.a(r5);
        if (this.a.i.isWhiteBrand() == false) goto L11;
        com.bytedance.android.ec.hybrid.list.entity.j r1 = r6.a;
        if (r1 == null) goto L11;
        r1.i = "#00000000";
    L11:
        Unit r2 = Unit.INSTANCE;
        r0.c(r6);
        return;
    L14:
        return;
    }
}
