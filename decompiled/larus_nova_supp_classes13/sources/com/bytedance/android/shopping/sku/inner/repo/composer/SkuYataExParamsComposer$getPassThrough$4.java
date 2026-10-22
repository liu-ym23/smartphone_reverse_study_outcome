package com.bytedance.android.shopping.sku.inner.repo.composer;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 4, 3})
public final class SkuYataExParamsComposer$getPassThrough$4 extends Lambda implements Function0<String> {
    final /* synthetic */ String $trackClientEntranceInfo;

    public SkuYataExParamsComposer$getPassThrough$4(String r1) {
        this.$trackClientEntranceInfo = r1;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final String m2889invoke() {
        String r0 = this.$trackClientEntranceInfo;
        if ((r0 instanceof String) == true) goto L6;
        return null;
    L6:
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        return m2889invoke();
    }
}
