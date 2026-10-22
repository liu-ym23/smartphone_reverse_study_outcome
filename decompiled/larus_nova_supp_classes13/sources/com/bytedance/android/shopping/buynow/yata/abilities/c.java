package com.bytedance.android.shopping.buynow.yata.abilities;

import android.content.Context;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.shopping.sku.common.utils.SkuCommonHandleSchemaUtils;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class c extends com.bytedance.android.shopping.yata.ability.b {
    public final boolean c;

    public final void openSchema(String r5) {
        Intrinsics.checkNotNullParameter(r5, "schema");
        int r0 = SkuCommonHandleSchemaUtils.a;
        SkuCommonHandleSchemaUtils.b(getContext(), r5, this.c, null, 112);
    }

    public c(Context r2, boolean r3, Function0<? extends PageFinder> r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r4, "pageFinderMethod");
        super(r2, r4);
        this.c = r3;
    }
}
