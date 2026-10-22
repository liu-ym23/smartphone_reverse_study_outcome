package com.bytedance.locallife.photo.album.model;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes21.dex */
public final class i<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AlbumViewModel f261992a;

    public i(AlbumViewModel r100) {
        this.f261992a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Throwable r101 = (Throwable) r100;
        r101.getMessage();
        this.f261992a.getTabRequestStatus().setValue(RequestStatus.FAIL);
        this.f261992a.setRequestFailMsg(String.valueOf(r101.getMessage()));
    }
}
