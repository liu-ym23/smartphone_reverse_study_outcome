package com.bytedance.android.shopping.commentv3.view;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import com.bytedance.android.ec.core.utils.y;
import com.bytedance.android.ec.model.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class a<T> implements y.c {
    public final /* synthetic */ CommentGalleryDialog a;
    public final /* synthetic */ cc3.c b;

    public a(CommentGalleryDialog r1, cc3.c r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r4) {
        Bitmap r5 = (Bitmap) r4;
        if (r5 == null) goto L6;
        k r0 = this.b.a;
        r0.i = new BitmapDrawable(this.a.getContext().getResources(), r5);
        return;
    }
}
