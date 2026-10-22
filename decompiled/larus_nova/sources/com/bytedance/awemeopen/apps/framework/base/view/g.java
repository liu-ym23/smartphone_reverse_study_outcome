package com.bytedance.awemeopen.apps.framework.base.view;

import android.graphics.Paint;
import android.graphics.drawable.Drawable;

/* JADX INFO: loaded from: classes14.dex */
public final class g extends b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f193243a;

    public g(Drawable r100, int r101) {
        super(r100);
        this.f193243a = r101;
    }

    @Override // com.bytedance.awemeopen.apps.framework.base.view.b, android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public final int getSize(Paint r100, CharSequence r101, int r102, int r103, Paint.FontMetricsInt r104) {
        return super.getSize(r100, r101, r102, r103, r104) + this.f193243a;
    }
}
