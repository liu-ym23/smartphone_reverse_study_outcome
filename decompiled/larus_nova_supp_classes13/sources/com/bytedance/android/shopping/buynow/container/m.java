package com.bytedance.android.shopping.buynow.container;

import android.view.View;
import com.bytedance.android.ec.base.api.ai.framework.component.BackComponent;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class m implements BackComponent.OnClickListener {
    public final /* synthetic */ BuyNowFragment a;

    public m(BuyNowFragment r1) {
        this.a = r1;
    }

    public final void onClick(View r3) {
        Intrinsics.checkNotNullParameter(r3, "it");
        com.bytedance.android.shopping.buynow.controller.f.b(this.a.getContext(), "click", this.a);
    }
}
