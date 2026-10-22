package com.bytedance.ee.bear.middleground.like.executor;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes18.dex */
public final class c implements Consumer<ClearLikeExecutor.ClearLikeResult> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ClearLikeExecutor f232785a;

    public c(ClearLikeExecutor r100) {
        this.f232785a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(ClearLikeExecutor.ClearLikeResult r100) throws Exception {
        ClearLikeExecutor.ClearLikeResult r101 = r100;
        tt5.a.b("ClearLikeExecutor", "ClearLikeExecutor doAction accept  result=" + r101);
        if (this.f232785a.f232777a == null) goto L6;
        tt5.a.b("ClearLikeExecutor", "ClearLikeExecutor accept: ref is not null ");
        this.f232785a.f232777a.a(r101.getCode(), r101.msg, r101.getId());
        return;
    }
}
