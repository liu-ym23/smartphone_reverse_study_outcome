package com.bytedance.ee.bear.middleground.like.executor;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes18.dex */
public final class d implements Consumer<Throwable> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f232786a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f232787b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ ClearLikeExecutor f232788c;

    @Override // io.reactivex.functions.Consumer
    public final void accept(Throwable r100) throws Exception {
        Throwable r101 = r100;
        tt5.a.d("ClearLikeExecutor", String.format("ClearLikeExecutor.doAction() error, msg: %s, params: { token: %s, type: %s }", new Object[]{r101, du5.b.g(this.f232786a), String.valueOf(this.f232787b)}));
        hg5.d r102 = this.f232788c.f232777a;
        if (r102 == null) goto L6;
        r102.onError(r101);
        return;
    }

    public d(ClearLikeExecutor r100, String r101) {
        this.f232788c = r100;
        this.f232786a = r101;
        this.f232787b = 6;
    }
}
