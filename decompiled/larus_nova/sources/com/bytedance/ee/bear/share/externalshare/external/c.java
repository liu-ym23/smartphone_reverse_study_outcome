package com.bytedance.ee.bear.share.externalshare.external;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes18.dex */
public final class c<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DocShareExternalPresenter f237053a;

    public c(DocShareExternalPresenter r100) {
        this.f237053a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        this.f237053a.f237033r = false;
        tt5.a.e("DocShareExternalPresenter", "refreshPublicPermission failed", (Throwable) r100, false);
    }
}
