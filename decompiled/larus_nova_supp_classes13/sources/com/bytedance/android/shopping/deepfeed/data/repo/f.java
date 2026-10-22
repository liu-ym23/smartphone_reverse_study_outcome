package com.bytedance.android.shopping.deepfeed.data.repo;

import he3.y0;
import io.reactivex.functions.Consumer;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class f<T> implements Consumer {
    public final /* synthetic */ Function1 a;

    public f(Function1 r1) {
        this.a = r1;
    }

    public final void accept(Object r2) {
        Function1 r0 = this.a;
        r0.invoke((y0) r2);
    }
}
