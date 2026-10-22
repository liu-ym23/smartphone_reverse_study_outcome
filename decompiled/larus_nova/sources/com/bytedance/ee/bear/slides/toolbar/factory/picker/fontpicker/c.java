package com.bytedance.ee.bear.slides.toolbar.factory.picker.fontpicker;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class c implements i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ FontPickerAdapter.FontViewHolder f238703a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ FontItem f238704b;

    public c(FontPickerAdapter.FontViewHolder r100, FontItem r101) {
        this.f238703a = r100;
        this.f238704b = r101;
    }

    @Override // com.bytedance.ee.bear.slides.toolbar.factory.picker.fontpicker.i
    public final void b(ImageView r100, String r101, Exception r102) {
        Intrinsics.checkNotNullParameter(r100, "imageView");
        Intrinsics.checkNotNullParameter(r101, "svgUrl");
        Intrinsics.checkNotNullParameter(r102, "error");
        FontPickerAdapter.FontViewHolder r103 = this.f238703a;
        FontItem r104 = this.f238704b;
        int r105 = FontPickerAdapter.FontViewHolder.f238681g;
        r103.T3(r104);
    }

    @Override // com.bytedance.ee.bear.slides.toolbar.factory.picker.fontpicker.i
    public final void a(ImageView r100, String r101, Drawable r102, float r110) {
        Intrinsics.checkNotNullParameter(r100, "imageView");
        Intrinsics.checkNotNullParameter(r101, "svgUrl");
        Intrinsics.checkNotNullParameter(r102, "svgDrawable");
        FontPickerAdapter.FontViewHolder r103 = this.f238703a;
        boolean r104 = Intrinsics.areEqual(this.f238704b.isSupport(), Boolean.FALSE);
        int r105 = FontPickerAdapter.FontViewHolder.f238681g;
        r103.getClass();
        r100.post(new e(r102, r100, r110, r103, r104));
    }
}
