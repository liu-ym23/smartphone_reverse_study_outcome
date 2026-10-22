package com.bytedance.ee.bear.middleground.like.executor;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes18.dex */
public final class a implements Consumer<AddLikeExecutor.AddLikeResult> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AddLikeExecutor f232781a;

    public a(AddLikeExecutor r100) {
        this.f232781a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(AddLikeExecutor.AddLikeResult r100) throws Exception {
        AddLikeExecutor.AddLikeResult r101 = r100;
        tt5.a.b("AddLikeExecutor", "AddLikeExecutor doAction accept  result=" + r101);
        if (this.f232781a.f232773a == null) goto L6;
        tt5.a.b("AddLikeExecutor", "AddLikeExecutor accept: ref is not null ");
        this.f232781a.f232773a.a(r101.getCode(), r101.msg, r101.getId());
        return;
    }
}
