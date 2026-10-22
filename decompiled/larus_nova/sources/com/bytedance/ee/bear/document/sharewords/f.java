package com.bytedance.ee.bear.document.sharewords;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes16.dex */
public final class f<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d.c f221796a;

    public f(g.a.C3161a r100) {
        this.f221796a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        tt5.a.d("ShareWordsNetExecutor", "requestShareWordsThumbnailUrl err " + ((Throwable) r100).getMessage());
        this.f221796a.a(null);
    }
}
