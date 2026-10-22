package com.bytedance.ee.bear.office.list.adapter;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class m0 implements RequestListener<Bitmap> {
    public final /* synthetic */ ImageView a;
    public final /* synthetic */ String b;
    public final /* synthetic */ Function0<Unit> c;

    public m0(ImageView r1, String r2, Function0<Unit> r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final boolean onLoadFailed(GlideException r1, Object r2, Target<Bitmap> r3, boolean r4) {
        if (Intrinsics.areEqual(this.a.getTag(2131363734), this.b) == true) goto L6;
        return true;
    L6:
        this.c.invoke();
        return false;
    }

    public final boolean onResourceReady(Object r1, Object r2, Target r3, DataSource r4, boolean r5) {
        Bitmap r6 = (Bitmap) r1;
        return !Intrinsics.areEqual(this.a.getTag(2131363734), this.b);
    }
}
