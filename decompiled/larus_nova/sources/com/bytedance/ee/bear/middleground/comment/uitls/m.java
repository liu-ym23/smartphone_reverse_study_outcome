package com.bytedance.ee.bear.middleground.comment.uitls;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes18.dex */
public final class m<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final m<T> f232214a = null;

    static {
        f232214a = new m();
    }

    public m() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        tt5.a.e("CommentTo", "get edit rich text error", (Throwable) r100, false);
    }
}
