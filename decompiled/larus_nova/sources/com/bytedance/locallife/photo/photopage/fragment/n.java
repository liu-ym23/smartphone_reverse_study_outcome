package com.bytedance.locallife.photo.photopage.fragment;

import androidx.lifecycle.Observer;
import com.bytedance.locallife.photo.photopage.adapter.PoiAlbumPageAdapter;

/* JADX INFO: loaded from: classes21.dex */
public final class n<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PoiAlbumFragment f262215a;

    public n(PoiAlbumFragment r100) {
        this.f262215a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        if (((Boolean) r100).booleanValue() == false) goto L8;
        PoiAlbumPageAdapter r101 = this.f262215a.f262182h;
        if (r101 == null) goto L9;
        r101.notifyDataSetChanged();
        return;
    L9:
        return;
    }
}
