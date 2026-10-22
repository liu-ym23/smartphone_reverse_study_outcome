package com.bytedance.ee.bear.middleground.comment.input;

import io.reactivex.functions.Consumer;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class s0<T> implements Consumer {
    public final /* synthetic */ InputComment a;

    public s0(InputComment r1) {
        this.a = r1;
    }

    public final void accept(Object r4) {
        tt5.a.e("Comment#InputComment", "Failed to insertImages2Local...", (Throwable) r4, false);
        InputComment.w(this.a, CollectionsKt.emptyList());
    }
}
