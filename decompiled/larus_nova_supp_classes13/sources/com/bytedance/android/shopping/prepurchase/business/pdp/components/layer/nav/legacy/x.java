package com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.nav.legacy;

import com.bytedance.android.ec.model.ECUrlModel;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class x implements r73.c {
    public final /* synthetic */ TopNavigationComponentV1 a;

    public final List<ECUrlModel> c() {
        vg3.l r0 = (vg3.l) this.a.N1(vg3.l.class);
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.c();
    }

    public x(TopNavigationComponentV1 r1) {
        this.a = r1;
    }
}
