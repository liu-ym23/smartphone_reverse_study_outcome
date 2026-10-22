package com.bytedance.locallife.photo.album.model;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes21.dex */
public final class e<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f261982a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ AlbumViewModel f261983b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ AlbumPageModel f261984c;

    public e(String r100, AlbumViewModel r101, AlbumPageModel r102) {
        this.f261982a = r100;
        this.f261983b = r101;
        this.f261984c = r102;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Throwable r101 = (Throwable) r100;
        r101.getMessage();
        this.f261983b.getRequestStatusMap().put(this.f261982a, RequestStatus.FAIL);
        this.f261983b.getAlbumPageRequestStatus().setValue(this.f261982a);
        this.f261983b.setRequestFailMsg(String.valueOf(r101.getMessage()));
        this.f261984c.f261964a = false;
    }
}
