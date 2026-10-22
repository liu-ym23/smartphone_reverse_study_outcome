package com.bytedance.android.shopping.searchsimilar.view;

import android.graphics.Bitmap;
import android.text.SpannableStringBuilder;
import android.widget.TextView;
import com.bytedance.android.ec.core.utils.y;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class b<T> implements y.c {
    public final /* synthetic */ SimilarProductCardView a;
    public final /* synthetic */ SpannableStringBuilder b;
    public final /* synthetic */ String c;

    public b(SimilarProductCardView r1, SpannableStringBuilder r2, String r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final void accept(Object r3) {
        Bitmap r4 = (Bitmap) r3;
        TextView r0 = this.a.c;
        if (r0 == null) goto L6;
        r0.post(new a(this, r4));
        return;
    }
}
