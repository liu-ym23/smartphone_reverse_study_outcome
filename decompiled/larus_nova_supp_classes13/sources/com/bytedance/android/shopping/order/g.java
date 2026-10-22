package com.bytedance.android.shopping.order;

import io.reactivex.functions.Consumer;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class g implements Consumer {
    public final /* synthetic */ Function1 a;

    public g(Function1 r1) {
        this.a = r1;
    }

    public final /* synthetic */ void accept(Object r2) {
        this.a.invoke(r2);
    }
}
