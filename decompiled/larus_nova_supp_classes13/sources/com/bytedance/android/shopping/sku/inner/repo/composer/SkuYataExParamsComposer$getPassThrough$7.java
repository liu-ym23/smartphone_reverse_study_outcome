package com.bytedance.android.shopping.sku.inner.repo.composer;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 4, 3})
public final class SkuYataExParamsComposer$getPassThrough$7 extends Lambda implements Function0<String> {
    final /* synthetic */ SkuYataExParamsComposer this$0;

    public SkuYataExParamsComposer$getPassThrough$7(SkuYataExParamsComposer r1) {
        this.this$0 = r1;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final String m2892invoke() {
        String r0 = this.this$0.a.getEntranceInfo();
        if ((r0 instanceof String) == true) goto L6;
        return null;
    L6:
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        return m2892invoke();
    }
}
