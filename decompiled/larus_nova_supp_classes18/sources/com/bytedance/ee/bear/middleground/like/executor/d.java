package com.bytedance.ee.bear.middleground.like.executor;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class d implements Consumer<Throwable> {
    public final /* synthetic */ String a;
    public final /* synthetic */ int b;
    public final /* synthetic */ ClearLikeExecutor c;

    public final void accept(Object r4) throws Exception {
        Throwable r5 = (Throwable) r4;
        tt5.a.d("ClearLikeExecutor", String.format("ClearLikeExecutor.doAction() error, msg: %s, params: { token: %s, type: %s }", new Object[]{r5, du5.b.g(this.a), String.valueOf(this.b)}));
        hg5.d r0 = this.c.a;
        if (r0 == null) goto L6;
        r0.onError(r5);
        return;
    }

    public d(ClearLikeExecutor r1, String r2) {
        this.c = r1;
        this.a = r2;
        this.b = 6;
    }
}
