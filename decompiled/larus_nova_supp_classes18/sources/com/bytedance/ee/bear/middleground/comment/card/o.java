package com.bytedance.ee.bear.middleground.comment.card;

import com.bytedance.ee.bear.middleground.comment.export.Action;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class o<T> implements Consumer {
    public final /* synthetic */ FloatCardComment a;

    public o(FloatCardComment r1) {
        this.a = r1;
    }

    public final void accept(Object r3) {
        String r4 = (String) r3;
        com.bytedance.ee.bear.middleground.comment.control.t r0 = this.a.g;
        Intrinsics.checkNotNull(r4);
        r0.w(r4, Action.PUBLISH);
    }
}
