package com.bytedance.android.shopping.sku.inner.yata.abilities;

import com.bytedance.android.shopping.sku.common.utils.SkuCommonHandleSchemaUtils;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class SkuYataRouterAbility extends com.bytedance.android.shopping.yata.ability.b {
    public final com.bytedance.android.shopping.sku.inner.container.b c;

    public SkuYataRouterAbility(final com.bytedance.android.shopping.sku.inner.container.b r3) {
        Intrinsics.checkNotNullParameter(r3, "fragment");
        super(r3.context(), new AnonymousClass1(r3));
        this.c = r3;
    }

    public final void openSchema(String r5) {
        Intrinsics.checkNotNullParameter(r5, "schema");
        int r0 = SkuCommonHandleSchemaUtils.a;
        SkuCommonHandleSchemaUtils.b(getContext(), r5, this.c.qn().getSkuParams().isSplitScreen(), null, 112);
    }
}
