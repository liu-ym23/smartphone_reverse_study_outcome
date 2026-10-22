package com.bytedance.locallife.photo.photopage.view;

import android.view.View;

/* JADX INFO: loaded from: classes21.dex */
public final class m implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PoiAlbumPageActivity f262341a;

    public m(PoiAlbumPageActivity r100) {
        this.f262341a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        this.f262341a.finish();
    }
}
