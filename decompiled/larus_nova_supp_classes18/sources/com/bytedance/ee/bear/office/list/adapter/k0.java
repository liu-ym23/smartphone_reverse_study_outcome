package com.bytedance.ee.bear.office.list.adapter;

import android.graphics.Bitmap;
import androidx.appcompat.widget.AppCompatImageView;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class k0 implements RequestListener<Bitmap> {
    public final /* synthetic */ AppCompatImageView a;
    public final /* synthetic */ String b;
    public final /* synthetic */ AppCompatImageView c;

    public k0(AppCompatImageView r1, String r2, AppCompatImageView r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final boolean onLoadFailed(GlideException r1, Object r2, Target<Bitmap> r3, boolean r4) {
        if (Intrinsics.areEqual(this.a.getTag(2131363734), this.b) == true) goto L5;
        return true;
    L5:
        this.a.setVisibility(4);
        this.c.setVisibility(0);
        return true;
    }

    public final boolean onResourceReady(Object r1, Object r2, Target r3, DataSource r4, boolean r5) {
        Bitmap r6 = (Bitmap) r1;
        if (Intrinsics.areEqual(this.a.getTag(2131363734), this.b) == true) goto L5;
        return true;
    L5:
        this.a.setVisibility(0);
        this.c.setVisibility(8);
        return false;
    }
}
