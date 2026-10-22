package com.bytedance.android.shopping.sku.inner.yata.abilities;

import com.bytedance.android.btm.api.BtmSDK;
import com.bytedance.android.btm.api.model.BtmItemBuilder;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.shopping.base.event.EventActionImpl;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import v96.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class e implements h {
    public final EventActionImpl a;
    public final com.bytedance.android.shopping.sku.inner.container.b b;

    public e(com.bytedance.android.shopping.sku.inner.container.b r2) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        this.b = r2;
        this.a = new EventActionImpl();
    }

    public final void b(String r4) {
        Intrinsics.checkNotNullParameter(r4, "btm");
        BtmSDK.INSTANCE.createBtmChain(new BtmItemBuilder(r4, Boolean.TRUE).withPageFinder(this.b.tS()).build());
    }

    public final void c(Map<String, ? extends Object> r2) {
        com.bytedance.android.bcm.api.b.f(this.b.tS(), r2);
    }

    public final void a(String r3, Map<String, Object> r4) {
        Intrinsics.checkNotNullParameter(r3, "eventName");
        Intrinsics.checkNotNullParameter(r4, "params");
        if (Intrinsics.areEqual(r3, "yata_client_sdk_perf") == false) goto L5;
        LinkedHashMap r0 = new LinkedHashMap();
        r0.putAll(this.b.qn().getTracker().d);
        r0.putAll(this.b.qn().getTracker().f);
        r0.putAll(this.b.qn().getTracker().e);
        r0.putAll(r4);
        this.a.doEventAction(r3, PageFinder.via(this.b), r0);
        return;
    L5:
        this.b.qn().getTracker().b(PageFinder.via(this.b), r3, r4);
    }
}
