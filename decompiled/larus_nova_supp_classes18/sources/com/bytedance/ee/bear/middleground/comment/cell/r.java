package com.bytedance.ee.bear.middleground.comment.cell;

import com.bytedance.ee.bear.middleground.comment.export.Action;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class r<T> implements Consumer {
    public final /* synthetic */ com.bytedance.ee.bear.middleground.comment.control.t a;

    public r(com.bytedance.ee.bear.middleground.comment.control.t r1) {
        this.a = r1;
    }

    public final void accept(Object r3) {
        String r4 = (String) r3;
        com.bytedance.ee.bear.middleground.comment.control.t r0 = this.a;
        Intrinsics.checkNotNull(r4);
        r0.w(r4, Action.EDIT);
    }
}
