package com.ss.android.lark.widget.photo.preview.video.cover;

import android.view.View;

/* JADX INFO: loaded from: classes38.dex */
public final class w implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ r f447261a;

    public w(r r100) {
        this.f447261a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        r r101 = this.f447261a;
        r101.f447237g.onOperate(r101.getContext(), "MORE", this.f447261a.f447236f, true);
    }
}
