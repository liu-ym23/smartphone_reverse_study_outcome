package com.bytedance.android.shopping.deepfeed.ui.vh;

import android.graphics.Bitmap;
import android.util.LruCache;
import com.facebook.imagepipeline.request.BasePostprocessor;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class m extends BasePostprocessor {
    public final /* synthetic */ int a;
    public final /* synthetic */ String b;
    public final /* synthetic */ Integer c;

    public final void process(Bitmap r5) {
        if (r5 != null) goto L4;
        return;
    L4:
        if (com.bytedance.android.shopping.extensions.k.c(this.b) == true) goto L6;
        return;
    L6:
        if (this.a != 0) goto L21;
        Integer r0 = this.c;
        if (r0 != null) goto L11;
    L15:
        Bitmap.Config r1 = r5.getConfig();
        if (r1 == null) goto L22;
        LruCache<String, Bitmap> r2 = l.a;
        Bitmap r6 = l.a.put(this.b, r5.copy(r1, false));
        return;
    L22:
        return;
    L11:
        if (r0.intValue() != 0) goto L15;
        Bitmap.Config r3 = r5.getConfig();
        if (r3 == null) goto L15;
        LruCache<String, Bitmap> r4 = l.a;
        l.d = r5.copy(r3, false);
        goto L15
    }

    public m(int r1, String r2, Integer r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
