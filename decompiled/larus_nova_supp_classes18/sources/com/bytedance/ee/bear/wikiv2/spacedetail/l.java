package com.bytedance.ee.bear.wikiv2.spacedetail;

import android.graphics.drawable.Drawable;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class l implements RequestListener<Drawable> {
    public l() {
    }

    public final boolean onLoadFailed(GlideException r1, Object r2, Target<Drawable> r3, boolean r4) {
        tt5.a.d("WikiSpaceMemberAdapter", "bindImage glide onException");
        tt5.a.f("WikiSpaceMemberAdapter", r1, false);
        return false;
    }

    public final /* bridge */ /* synthetic */ boolean onResourceReady(Object r1, Object r2, Target r3, DataSource r4, boolean r5) {
        Drawable r6 = (Drawable) r1;
        return false;
    }
}
