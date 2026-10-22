package com.bytedance.android.shopping.slice.elements.projectionview;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.ImageView;
import com.bytedance.android.ecom.arch.slice.render.elements.flexbox.SlcFlexElementView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class a extends SlcFlexElementView {
    public final ImageView e;

    public final ImageView getImageView() {
        return this.e;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public a(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        super(r4, null, 6, 0);
        ImageView r0 = new ImageView(r4);
        this.e = r0;
        addView(r0, -1, -1);
    }

    public final void setImageBitmap(Bitmap r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        this.e.setImageBitmap(r2);
        this.e.requestLayout();
    }
}
