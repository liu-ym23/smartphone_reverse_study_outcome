package com.bytedance.android.shopping.sku.common.utils;

import kotlin.Lazy;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class SkuCommonTaskUtilsKt$newSkuTask$1 extends a {
    public final /* synthetic */ String b;
    public final /* synthetic */ Function1 c;

    @Override // com.bytedance.android.shopping.sku.common.utils.a
    public final void a() {
        Lazy r0 = SkuCommonLog.a;
        SkuCommonLog.a("SkuBaseTask", new SkuCommonTaskUtilsKt$newSkuTask$1$doTask$1(this));
        this.c.invoke(this.a);
    }

    public SkuCommonTaskUtilsKt$newSkuTask$1(String r1, Function1 r2) {
        this.b = r1;
        this.c = r2;
    }
}
