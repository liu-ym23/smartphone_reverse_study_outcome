package com.bytedance.locallife.photo.photopage.view;

import android.view.View;
import com.bytedance.locallife.photo.view.RoundedRelativeLayout;

/* JADX INFO: loaded from: classes21.dex */
public final class k implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PoiAlbumPageActivity f262339a;

    public k(PoiAlbumPageActivity r100) {
        this.f262339a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        RoundedRelativeLayout r101 = this.f262339a.f262262k;
        if (r101 == null) goto L6;
        r101.setVisibility(8);
        return;
    }
}
