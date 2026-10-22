package com.bytedance.android.shopping.product.flow;

import com.bytedance.android.ec.model.ECUrlModel;
import java.util.List;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class a implements yg3.b {
    public final /* synthetic */ List a;

    @Override // yg3.b
    public final String a() {
        ECUrlModel r0 = (ECUrlModel) CollectionsKt.firstOrNull(this.a);
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getFirstUrl();
    }

    public a(List r1) {
        this.a = r1;
    }
}
