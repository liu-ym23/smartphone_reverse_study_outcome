package com.bytedance.ee.bear.document.sharewords;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class f<T> implements Consumer {
    public final /* synthetic */ d.c a;

    public f(g.a.C0105a r1) {
        this.a = r1;
    }

    public final void accept(Object r3) {
        tt5.a.d("ShareWordsNetExecutor", "requestShareWordsThumbnailUrl err " + ((Throwable) r3).getMessage());
        this.a.a(null);
    }
}
