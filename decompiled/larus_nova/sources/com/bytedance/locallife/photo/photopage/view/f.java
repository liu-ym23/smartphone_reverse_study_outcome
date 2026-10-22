package com.bytedance.locallife.photo.photopage.view;

import androidx.lifecycle.Observer;
import com.bytedance.locallife.model.album.PhotoData;

/* JADX INFO: loaded from: classes21.dex */
public final class f<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PoiAlbumPageActivity f262334a;

    public f(PoiAlbumPageActivity r100) {
        this.f262334a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        PhotoData r101 = (PhotoData) r100;
        PoiAlbumPageActivity.z1(this.f262334a);
    }
}
