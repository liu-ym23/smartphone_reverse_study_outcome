package com.bytedance.ee.bear.wikiv2.spacedetail;

import android.graphics.drawable.Drawable;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;

/* JADX INFO: loaded from: classes18.dex */
public final class l implements RequestListener<Drawable> {
    public l() {
    }

    @Override // com.bumptech.glide.request.RequestListener
    public final boolean onLoadFailed(GlideException r100, Object r101, Target<Drawable> r102, boolean r103) {
        tt5.a.d("WikiSpaceMemberAdapter", "bindImage glide onException");
        tt5.a.f("WikiSpaceMemberAdapter", r100, false);
        return false;
    }

    @Override // com.bumptech.glide.request.RequestListener
    public final /* bridge */ /* synthetic */ boolean onResourceReady(Drawable r100, Object r101, Target<Drawable> r102, DataSource r103, boolean r104) {
        return false;
    }
}
