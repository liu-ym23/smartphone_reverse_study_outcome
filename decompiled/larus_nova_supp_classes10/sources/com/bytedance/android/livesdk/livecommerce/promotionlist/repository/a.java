package com.bytedance.android.livesdk.livecommerce.promotionlist.repository;

import io.reactivex.functions.Consumer;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class a<T> implements Consumer {
    public final /* synthetic */ Function1 a;

    public a(Function1 r1) {
        this.a = r1;
    }

    public final void accept(Object r2) {
        Function1 r0 = this.a;
        r0.invoke((vj2.b) r2);
    }
}
