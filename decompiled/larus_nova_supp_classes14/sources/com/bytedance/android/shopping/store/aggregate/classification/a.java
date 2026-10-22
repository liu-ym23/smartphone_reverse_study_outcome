package com.bytedance.android.shopping.store.aggregate.classification;

import com.bytedance.android.ec.model.ECUrlModel;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class a {
    public static final ECUrlModel a(ECUrlModel r3) {
        Intrinsics.checkNotNullParameter(r3, "$this$copy");
        ECUrlModel r0 = new ECUrlModel();
        r0.setUri(r3.getUri());
        List r1 = r3.getUrlList();
        if (r1 == null) goto L5;
        List r2 = CollectionsKt.toList(r1);
    L6:
        r0.setUrlList(r2);
        r0.setWidth(r3.getWidth());
        r0.setHeight(r3.getHeight());
        r0.setUrlKey(r3.getUrlKey());
        r0.setSize(r3.getSize());
        r0.setFileHash(r3.getFileHash());
        return r0;
    L5:
        r2 = null;
        goto L6
    }
}
