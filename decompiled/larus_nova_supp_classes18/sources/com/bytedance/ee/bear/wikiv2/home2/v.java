package com.bytedance.ee.bear.wikiv2.home2;

import android.graphics.drawable.Drawable;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class v implements RequestListener<Drawable> {
    public v() {
    }

    public final boolean onLoadFailed(GlideException r1, Object r2, Target<Drawable> r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r2, "model");
        Intrinsics.checkNotNullParameter(r3, "target");
        tt5.a.e("WikiHomeTopSpaceView", "bindImage glide onException", r1, false);
        return false;
    }

    public final boolean onResourceReady(Object r1, Object r2, Target r3, DataSource r4, boolean r5) {
        Drawable r6 = (Drawable) r1;
        Intrinsics.checkNotNullParameter(r2, "model");
        Intrinsics.checkNotNullParameter(r3, "target");
        Intrinsics.checkNotNullParameter(r4, "dataSource");
        return false;
    }
}
