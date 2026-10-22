package com.bytedance.android.shopping.prepurchase.arch.container.intf;

import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.shopping.base.event.EventActionImpl;
import com.google.gson.internal.LinkedTreeMap;
import java.util.Arrays;
import java.util.Map;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class d implements h {
    public final EventActionImpl a;

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.intf.h
    public final Map<String, Object> getEventParams() {
        return this.a.c();
    }

    public d() {
        this.a = new EventActionImpl();
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.intf.h
    public final void appendEventParams(Pair<String, ? extends Object>... r3) {
        Intrinsics.checkNotNullParameter(r3, "params");
        this.a.appendEventParams((Pair[]) Arrays.copyOf(r3, r3.length));
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.intf.h
    public final void o(String r3) {
        Intrinsics.checkNotNullParameter("share_with_head", "key");
        Intrinsics.checkNotNullParameter(r3, "value");
        this.a.appendEventParamToEntranceInfo("share_with_head", r3);
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.intf.h
    public final void p(LinkedTreeMap r2) {
        Intrinsics.checkNotNullParameter(r2, "paramsMap");
        this.a.appendEventParams(r2);
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.intf.h
    public final void q(String r2, PageFinder r3, Map<String, ? extends Object> r4) {
        Intrinsics.checkNotNullParameter(r2, "actionName");
        Intrinsics.checkNotNullParameter(r4, "params");
        this.a.doEventAction(r2, r3, r4);
    }
}
