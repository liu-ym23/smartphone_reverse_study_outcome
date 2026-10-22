package com.bytedance.locallife.pdp.album;

import android.view.View;
import com.bytedance.locallife.pdp.album.model.CustomAlbumViewModel;

/* JADX INFO: loaded from: classes21.dex */
public final class d implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CustomAlbumActivity f260965a;

    public d(CustomAlbumActivity r100) {
        this.f260965a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        if (com.bytedance.locallife.common.utils.g.a(r100) == false) goto L5;
        return;
    L5:
        CustomAlbumViewModel r101 = this.f260965a.f260941l;
        if (r101 == null) goto L9;
        r101.requestTabData();
        return;
    }
}
