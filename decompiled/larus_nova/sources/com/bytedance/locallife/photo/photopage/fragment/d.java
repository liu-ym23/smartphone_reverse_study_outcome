package com.bytedance.locallife.photo.photopage.fragment;

import androidx.lifecycle.Observer;
import com.bytedance.locallife.model.album.PoiAlbumParams;
import com.bytedance.locallife.photo.album.model.AlbumViewModel;

/* JADX INFO: loaded from: classes21.dex */
public final class d<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PoiAlbumContainerFragment f262201a;

    public d(PoiAlbumContainerFragment r100) {
        this.f262201a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        tv6.b r101 = (tv6.b) r100;
        AlbumViewModel r102 = this.f262201a.f262163d;
        if (r102 == null) goto L9;
        PoiAlbumParams r103 = r102.getAlbumParams();
        if (r103 == null) goto L9;
        boolean r104 = true;
        if (r103.getUseNewStyle() != true) goto L9;
    L10:
        if (r104 == true) goto L13;
        this.f262201a.getClass();
        return;
    L13:
        return;
    L9:
        r104 = false;
        goto L10
    }
}
