package com.bytedance.ee.bear.middleground.comment.uitls;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class m<T> implements Consumer {
    public static final m<T> a = null;

    static {
        a = new m();
    }

    public m() {
    }

    public final void accept(Object r4) {
        tt5.a.e("CommentTo", "get edit rich text error", (Throwable) r4, false);
    }
}
