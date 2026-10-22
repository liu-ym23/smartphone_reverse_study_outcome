package com.bytedance.locallife.photo.photopage.fragment;

import android.view.View;
import com.bytedance.locallife.photo.album.model.AlbumViewModel;

/* JADX INFO: loaded from: classes21.dex */
public final class s implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PoiAlbumFragment f262221a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f262222b;

    public s(PoiAlbumFragment r100, String r101) {
        this.f262221a = r100;
        this.f262222b = r101;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        if (com.bytedance.locallife.common.utils.g.a(r100) == false) goto L5;
        return;
    L5:
        AlbumViewModel r101 = this.f262221a.f262179e;
        if (r101 == null) goto L9;
        r101.requestAlbumPage(this.f262222b, 1);
        return;
    }
}
