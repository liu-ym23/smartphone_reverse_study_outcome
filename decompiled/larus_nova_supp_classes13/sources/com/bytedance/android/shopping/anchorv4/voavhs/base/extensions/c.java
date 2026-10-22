package com.bytedance.android.shopping.anchorv4.voavhs.base.extensions;

import com.bytedance.android.ec.model.ECUrlModel;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class c {
    public static final ECUrlModel a(int r1, int r2, String r3) {
        Intrinsics.checkNotNullParameter(r3, "url");
        ECUrlModel r0 = new ECUrlModel();
        r0.setUrlList(CollectionsKt.listOf(r3));
        r0.setWidth(r1);
        r0.setHeight(r2);
        return r0;
    }
}
