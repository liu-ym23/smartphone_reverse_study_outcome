package com.ss.android.lark.widget.light.span;

import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.style.DynamicDrawableSpan;

/* JADX INFO: loaded from: classes38.dex */
public final class o extends DynamicDrawableSpan implements k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Drawable f446279a;

    public o() {
        BitmapDrawable r100 = new BitmapDrawable();
        this.f446279a = r100;
        r100.setBounds(0, 0, 0, 0);
    }

    @Override // android.text.style.DynamicDrawableSpan
    public final Drawable getDrawable() {
        return this.f446279a;
    }

    @Override // com.ss.android.lark.widget.light.span.k
    public final void b(int r100) {
        this.f446279a.setBounds(0, 0, r100, 1);
    }
}
