package com.bytedance.ee.bear.middleground.comment.card;

import com.bytedance.ee.bear.middleground.comment.input.b2;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class p<T> implements Consumer {
    public final /* synthetic */ FloatCardComment a;

    public p(FloatCardComment r1) {
        this.a = r1;
    }

    public final void accept(Object r3) {
        FloatCardComment r0 = this.a;
        b2 r1 = r0.D;
        com.bytedance.ee.bear.middleground.comment.control.z r2 = r0.f;
        r1.g(r2, (Throwable) r3);
    }
}
