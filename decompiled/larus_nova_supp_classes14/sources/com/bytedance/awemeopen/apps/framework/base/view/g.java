package com.bytedance.awemeopen.apps.framework.base.view;

import android.graphics.Paint;
import android.graphics.drawable.Drawable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class g extends b {
    public final int a;

    public g(Drawable r1, int r2) {
        super(r1);
        this.a = r2;
    }

    @Override // com.bytedance.awemeopen.apps.framework.base.view.b, android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public final int getSize(Paint r1, CharSequence r2, int r3, int r4, Paint.FontMetricsInt r5) {
        return super.getSize(r1, r2, r3, r4, r5) + this.a;
    }
}
