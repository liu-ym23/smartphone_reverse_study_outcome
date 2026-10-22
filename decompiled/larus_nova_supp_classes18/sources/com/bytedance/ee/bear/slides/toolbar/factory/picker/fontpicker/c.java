package com.bytedance.ee.bear.slides.toolbar.factory.picker.fontpicker;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class c implements i {
    public final /* synthetic */ FontPickerAdapter.FontViewHolder a;
    public final /* synthetic */ FontItem b;

    public c(FontPickerAdapter.FontViewHolder r1, FontItem r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // com.bytedance.ee.bear.slides.toolbar.factory.picker.fontpicker.i
    public final void b(ImageView r2, String r3, Exception r4) {
        Intrinsics.checkNotNullParameter(r2, "imageView");
        Intrinsics.checkNotNullParameter(r3, "svgUrl");
        Intrinsics.checkNotNullParameter(r4, "error");
        FontPickerAdapter.FontViewHolder r5 = this.a;
        FontItem r6 = this.b;
        int r7 = FontPickerAdapter.FontViewHolder.g;
        r5.T3(r6);
    }

    @Override // com.bytedance.ee.bear.slides.toolbar.factory.picker.fontpicker.i
    public final void a(ImageView r7, String r8, Drawable r9, float r10) {
        Intrinsics.checkNotNullParameter(r7, "imageView");
        Intrinsics.checkNotNullParameter(r8, "svgUrl");
        Intrinsics.checkNotNullParameter(r9, "svgDrawable");
        FontPickerAdapter.FontViewHolder r4 = this.a;
        boolean r5 = Intrinsics.areEqual(this.b.isSupport(), Boolean.FALSE);
        int r11 = FontPickerAdapter.FontViewHolder.g;
        r4.getClass();
        r7.post(new e(r9, r7, r10, r4, r5));
    }
}
