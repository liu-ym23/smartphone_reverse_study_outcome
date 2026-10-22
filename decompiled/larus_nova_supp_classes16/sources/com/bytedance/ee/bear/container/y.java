package com.bytedance.ee.bear.container;

import io.reactivex.functions.Consumer;
import kotlin.Result;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class y<T> implements Consumer {
    public final /* synthetic */ bk5.a a;
    public final /* synthetic */ kotlinx.coroutines.i<WikiInitNode.b> b;

    public y(bk5.a r1, kotlinx.coroutines.j r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r4) {
        tt5.a.e("MockWikiInitNode", this.a.getTAG() + ", pull wiki info error", (Throwable) r4, false);
        if (this.b.isActive() == false) goto L6;
        this.b.resumeWith(Result.constructor-impl(null));
        return;
    }
}
