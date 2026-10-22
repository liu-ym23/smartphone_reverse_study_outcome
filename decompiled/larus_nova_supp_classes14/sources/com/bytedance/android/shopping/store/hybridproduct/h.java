package com.bytedance.android.shopping.store.hybridproduct;

import com.bytedance.android.shopping.store.slicecard.dto.SliceConfig;
import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class h<T> implements Observer {
    public final /* synthetic */ ECShopHybridProductListPresenter a;

    public h(ECShopHybridProductListPresenter r1) {
        this.a = r1;
    }

    public final void onChanged(Object r2) {
        SliceConfig r3 = (SliceConfig) r2;
        if (r3 == null) goto L6;
        this.a.N.getSliceService().d(r3.getConfigs());
        String r4 = this.a.g.getLocalVersionWithoutContent();
        this.a.m0().getRequestParam().setLocalTemplateVersions(r4);
        return;
    }
}
