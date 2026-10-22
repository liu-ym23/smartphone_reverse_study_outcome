package com.bytedance.android.shopping.feed.widget;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class d extends LayerDrawable {
    public final Drawable a;
    public final Drawable b;
    public final boolean c;

    public final void a(float r5) {
        if (r5 < 0) goto L16;
        float r0 = 1;
        if (r5 > r0) goto L19;
        Drawable r1 = this.a;
        if (r1 == null) goto L11;
        r1.setAlpha((int) ((r0 - r5) * 255));
    L11:
        if (this.c == true) goto L17;
        Drawable r2 = this.b;
        if (r2 == null) goto L18;
        r2.setAlpha((int) (r5 * 255));
        return;
    L18:
        return;
    L17:
        return;
    L19:
        return;
    }

    public d(Drawable r3, Drawable r4) {
        super(new Drawable[]{r4, r3});
        this.a = r3;
        this.b = r4;
        this.c = true;
        a(0.0f);
    }
}
