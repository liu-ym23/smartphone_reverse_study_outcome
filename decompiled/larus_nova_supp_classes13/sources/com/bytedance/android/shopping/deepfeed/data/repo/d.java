package com.bytedance.android.shopping.deepfeed.data.repo;

import com.bytedance.android.shopping.infeed.data.idl.InFeedProductResponse;
import io.reactivex.functions.Consumer;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class d<T> implements Consumer {
    public final /* synthetic */ Function1 a;

    public d(Function1 r1) {
        this.a = r1;
    }

    public final void accept(Object r2) {
        Function1 r0 = this.a;
        r0.invoke((InFeedProductResponse) r2);
    }
}
