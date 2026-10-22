package com.bytedance.ee.bear.bitable.pro;

import android.graphics.drawable.Drawable;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.larksuite.component.ui.imageview.LKUIRoundedImageView2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class g0 implements RequestListener<Drawable> {
    public final /* synthetic */ BitableProUpdateFragment a;

    public g0(BitableProUpdateFragment r1) {
        this.a = r1;
    }

    public final boolean onLoadFailed(GlideException r1, Object r2, Target<Drawable> r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r2, "o");
        Intrinsics.checkNotNullParameter(r3, "target");
        tt5.a.d("BitableProUpdateFragment", "onLoadFailed， error:" + r1);
        if (this.a.ya0() == null) goto L7;
        com.bytedance.ee.util.ui.l.c(this.a.ya0(), 2131102420);
        this.a.ya0().setBackgroundColor(this.a.getResources().getColor(2131100545));
        return false;
    L7:
        return false;
    }

    public final boolean onResourceReady(Object r1, Object r2, Target r3, DataSource r4, boolean r5) {
        Drawable r6 = (Drawable) r1;
        Intrinsics.checkNotNullParameter(r2, "o");
        Intrinsics.checkNotNullParameter(r3, "target");
        Intrinsics.checkNotNullParameter(r4, "dataSource");
        tt5.a.b("BitableProUpdateFragment", "success ");
        LKUIRoundedImageView2 r7 = this.a.ya0();
        if (r7 == null) goto L5;
        r7.setBackground(null);
    L5:
        LKUIRoundedImageView2 r8 = this.a.ya0();
        if (r8 == null) goto L10;
        r8.setImageTintList(null);
        return false;
    L10:
        return false;
    }
}
