package com.bytedance.locallife.photo.album.model;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes21.dex */
public final class g<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AlbumPageModel f261988a;

    public g(String r100, AlbumPageModel r101) {
        this.f261988a = r101;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Throwable r101 = (Throwable) r100;
        r101.getMessage();
        vn6.b.a(new a(RequestStatus.FAIL, r101.getMessage()));
        this.f261988a.f261964a = false;
    }
}
