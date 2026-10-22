package com.bytedance.android.shopping.prepurchase.business.pdp;

import com.bytedance.android.btm.api.model.PageFinder;
import com.google.gson.internal.LinkedTreeMap;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class d implements com.bytedance.android.shopping.prepurchase.arch.container.intf.h {
    public final com.bytedance.android.shopping.prepurchase.arch.container.intf.h a;

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.intf.h
    public final void appendEventParams(Pair<String, ? extends Object>... r2) {
        Intrinsics.checkNotNullParameter(r2, "params");
        this.a.appendEventParams(r2);
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.intf.h
    public final Map<String, Object> getEventParams() {
        return this.a.getEventParams();
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.intf.h
    public final void o(String r3) {
        Intrinsics.checkNotNullParameter("share_with_head", "key");
        Intrinsics.checkNotNullParameter(r3, "value");
        this.a.o(r3);
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.intf.h
    public final void p(LinkedTreeMap r2) {
        Intrinsics.checkNotNullParameter(r2, "paramsMap");
        this.a.p(r2);
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.intf.h
    public final void q(String r2, PageFinder r3, Map<String, ? extends Object> r4) {
        Intrinsics.checkNotNullParameter(r2, "actionName");
        Intrinsics.checkNotNullParameter(r4, "params");
        this.a.q(r2, r3, r4);
    }

    public d(boolean r3) {
        com.bytedance.android.shopping.prepurchase.arch.container.intf.d r0 = new com.bytedance.android.shopping.prepurchase.arch.container.intf.d();
        Intrinsics.checkNotNullParameter(r0, "base");
        this.a = r0;
        appendEventParams(new Pair[]{TuplesKt.to("is_from_restore", Integer.valueOf(r3 ? 1 : 0))});
    }
}
