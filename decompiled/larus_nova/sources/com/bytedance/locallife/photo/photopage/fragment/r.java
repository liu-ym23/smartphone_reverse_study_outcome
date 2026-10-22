package com.bytedance.locallife.photo.photopage.fragment;

import android.view.View;
import com.bytedance.locallife.photo.album.model.AlbumViewModel;

/* JADX INFO: loaded from: classes21.dex */
public final class r implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PoiAlbumFragment f262219a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f262220b;

    public r(PoiAlbumFragment r100, String r101) {
        this.f262219a = r100;
        this.f262220b = r101;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        if (com.bytedance.locallife.common.utils.g.a(r100) == false) goto L5;
        return;
    L5:
        AlbumViewModel r101 = this.f262219a.f262179e;
        if (r101 == null) goto L9;
        r101.requestAlbumPage(this.f262220b, 1);
        return;
    }
}
