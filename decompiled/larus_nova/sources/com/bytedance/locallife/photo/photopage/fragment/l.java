package com.bytedance.locallife.photo.photopage.fragment;

import androidx.lifecycle.Observer;
import com.bytedance.locallife.photo.album.model.AlbumPageStatus;
import com.bytedance.locallife.photo.photopage.adapter.PoiAlbumPageAdapter;

/* JADX INFO: loaded from: classes21.dex */
public final class l<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PoiAlbumFragment f262213a;

    public l(PoiAlbumFragment r100) {
        this.f262213a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        AlbumPageStatus r101 = (AlbumPageStatus) r100;
        PoiAlbumPageAdapter r102 = this.f262213a.f262182h;
        if (r102 == null) goto L6;
        r102.notifyDataSetChanged();
        return;
    }
}
