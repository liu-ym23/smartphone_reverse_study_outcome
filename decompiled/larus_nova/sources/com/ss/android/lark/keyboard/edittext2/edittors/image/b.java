package com.ss.android.lark.keyboard.edittext2.edittors.image;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class b extends BitmapDrawable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ UrlImageSpanView f429067a;

    @Override // android.graphics.drawable.BitmapDrawable, android.graphics.drawable.Drawable
    public final void draw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        r100.drawRect(0.0f, 0.0f, getIntrinsicWidth(), getIntrinsicHeight(), this.f429067a.f429062c);
        super.draw(r100);
    }

    public b(Bitmap r100, UrlImageSpanView r101, Resources r102) {
        this.f429067a = r101;
        super(r102, r100);
    }
}
