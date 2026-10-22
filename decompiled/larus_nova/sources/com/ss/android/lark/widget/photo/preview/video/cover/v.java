package com.ss.android.lark.widget.photo.preview.video.cover;

import android.view.View;

/* JADX INFO: loaded from: classes38.dex */
public final class v implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ r f447260a;

    public v(r r100) {
        this.f447260a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        r r101 = this.f447260a;
        r101.f447237g.onOperate(r101.getContext(), "CHAT_ALBUM", this.f447260a.f447236f, true);
    }
}
