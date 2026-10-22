package com.larus.office.base.plugins.toolbar.fontpicker;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.larus.office.base.utils.q;
import gn9.f;
import in9.g;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public final class a implements q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ FontPickerAdapter.FontViewHolder f360887a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ g f360888b;

    public a(FontPickerAdapter.FontViewHolder r100, g r101) {
        this.f360887a = r100;
        this.f360888b = r101;
    }

    @Override // com.larus.office.base.utils.q
    public final void b(ImageView r100, String r101, Exception r102) {
        Intrinsics.checkNotNullParameter(r100, "imageView");
        Intrinsics.checkNotNullParameter(r101, "svgUrl");
        Intrinsics.checkNotNullParameter(r102, "error");
        FontPickerAdapter.FontViewHolder r103 = this.f360887a;
        g r104 = this.f360888b;
        int r105 = FontPickerAdapter.FontViewHolder.f360871g;
        r103.T3(r104);
    }

    @Override // com.larus.office.base.utils.q
    public final void a(final ImageView r100, String r101, final Drawable r102, final float r110) {
        Intrinsics.checkNotNullParameter(r100, "imageView");
        Intrinsics.checkNotNullParameter(r101, "svgUrl");
        Intrinsics.checkNotNullParameter(r102, "svgDrawable");
        final FontPickerAdapter.FontViewHolder r103 = this.f360887a;
        final boolean r104 = Intrinsics.areEqual(this.f360888b.d(), Boolean.FALSE);
        int r105 = FontPickerAdapter.FontViewHolder.f360871g;
        r103.getClass();
        r100.post(new f(r102, r100, r110, r104, r103));
    }
}
