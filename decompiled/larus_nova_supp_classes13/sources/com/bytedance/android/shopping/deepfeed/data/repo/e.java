package com.bytedance.android.shopping.deepfeed.data.repo;

import io.reactivex.functions.Consumer;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class e<T> implements Consumer {
    public final /* synthetic */ Function1 a;

    public e(Function1 r1) {
        this.a = r1;
    }

    public final void accept(Object r2) {
        Throwable r3 = (Throwable) r2;
        this.a.invoke(null);
    }
}
