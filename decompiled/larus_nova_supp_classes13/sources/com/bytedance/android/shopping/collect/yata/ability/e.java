package com.bytedance.android.shopping.collect.yata.ability;

import com.bytedance.android.btm.api.BtmSDK;
import com.bytedance.android.btm.api.model.BtmItemBuilder;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.shopping.collect.container.CollectYataFragment;
import com.bytedance.android.shopping.collect.container.CollectYataViewModel;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import v96.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class e implements h {
    public final CollectYataFragment a;

    public e(CollectYataFragment r2) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        this.a = r2;
    }

    public final void b(String r4) {
        Intrinsics.checkNotNullParameter(r4, "btm");
        BtmSDK.INSTANCE.createBtmChain(new BtmItemBuilder(r4, Boolean.TRUE).withPageFinder((PageFinder) this.a.m.getValue()).build());
    }

    public final void c(Map<String, ? extends Object> r2) {
        com.bytedance.android.bcm.api.b.f((PageFinder) this.a.m.getValue(), r2);
    }

    public final void a(String r8, Map<String, Object> r9) {
        Intrinsics.checkNotNullParameter(r8, "eventName");
        Intrinsics.checkNotNullParameter(r9, "params");
        CollectYataViewModel.doEventAction$default(this.a.V90(), r8, r9, null, 4, null);
    }
}
