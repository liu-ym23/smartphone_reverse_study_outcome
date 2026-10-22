package com.bytedance.ee.bear.middleground.like.executor;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes18.dex */
public final class b implements Consumer<Throwable> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f232782a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f232783b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ AddLikeExecutor f232784c;

    @Override // io.reactivex.functions.Consumer
    public final void accept(Throwable r100) throws Exception {
        Throwable r101 = r100;
        tt5.a.d("AddLikeExecutor", String.format("AddLikeExecutor.doAction() error,  msg: %s, params: { token: %s, type: %s }", new Object[]{r101, du5.b.g(this.f232782a), String.valueOf(this.f232783b)}));
        hg5.d r102 = this.f232784c.f232773a;
        if (r102 == null) goto L6;
        r102.onError(r101);
        return;
    }

    public b(AddLikeExecutor r100, String r101) {
        this.f232784c = r100;
        this.f232782a = r101;
        this.f232783b = 6;
    }
}
