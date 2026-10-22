package com.bytedance.android.shopping.deepfeed.ui.vh;

import android.graphics.Typeface;
import android.os.Build;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class i {
    public static final Typeface a(Typeface r2, int r3) {
        if (r2 != null) goto L5;
        r2 = Typeface.DEFAULT;
    L5:
        if (Build.VERSION.SDK_INT < 28) goto L8;
        return Typeface.create(r2, r3, true);
    L8:
        return Typeface.create(r2, 3);
    }
}
