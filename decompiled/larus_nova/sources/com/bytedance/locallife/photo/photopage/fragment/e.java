package com.bytedance.locallife.photo.photopage.fragment;

import android.view.View;
import com.bytedance.locallife.photo.album.model.AlbumViewModel;

/* JADX INFO: loaded from: classes21.dex */
public final class e implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PoiAlbumContainerFragment f262202a;

    public e(PoiAlbumContainerFragment r100) {
        this.f262202a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        if (com.bytedance.locallife.common.utils.g.a(r100) == false) goto L5;
        return;
    L5:
        AlbumViewModel r101 = this.f262202a.f262163d;
        if (r101 == null) goto L9;
        r101.requestTabInfo();
        return;
    }
}
