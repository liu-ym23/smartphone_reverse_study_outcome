package com.bytedance.ee.bear.wikiv2.home2.model;

import io.reactivex.Flowable;
import io.reactivex.functions.Function;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class e<T, R> implements Function {
    public final /* synthetic */ WikiSpaceFilterInfo a;

    public e(WikiSpaceFilterInfo r1) {
        this.a = r1;
    }

    public final Object apply(Object r7) {
        List r2 = (List) r7;
        Intrinsics.checkNotNullParameter(r2, "it");
        if (r2.isEmpty() == false) goto L6;
        return Flowable.empty();
    L6:
        return Flowable.just(new WikiSpacesResp(this.a, r2, false, null, WikiSpacesResp.Origin.Cache));
    }
}
