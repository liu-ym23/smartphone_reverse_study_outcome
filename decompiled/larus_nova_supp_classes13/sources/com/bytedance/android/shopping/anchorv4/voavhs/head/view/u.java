package com.bytedance.android.shopping.anchorv4.voavhs.head.view;

import io.reactivex.functions.Predicate;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class u<T> implements Predicate {
    public final /* synthetic */ AnchorV4VideoView a;

    public u(AnchorV4VideoView r1) {
        this.a = r1;
    }

    public final boolean test(Object r2) {
        Intrinsics.checkNotNullParameter((Long) r2, "it");
        return !this.a.n;
    }
}
