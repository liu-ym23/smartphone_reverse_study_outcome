package com.bytedance.ee.bear.slides.toolbar.factory.picker.fontpicker;

import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class d implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ FontItem f238705a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f238706b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ FontPickerAdapter.FontViewHolder f238707c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ FontPickerAdapter f238708d;

    public d(FontItem r100, int r101, FontPickerAdapter.FontViewHolder r102, FontPickerAdapter r103) {
        this.f238705a = r100;
        this.f238706b = r101;
        this.f238707c = r102;
        this.f238708d = r103;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        if (Intrinsics.areEqual(this.f238705a.isSupport(), Boolean.FALSE) == false) goto L6;
        tt5.a.h("FontPickerAdapter", "click on position " + this.f238706b + ", but not support");
        this.f238707c.f238686e.getContext();
        return;
    L6:
        int r101 = this.f238707c.getAdapterPosition();
        tt5.a.h("FontPickerAdapter", "click on position " + r101);
        if (r101 == (-1)) goto L10;
        FontPickerAdapter r102 = this.f238708d;
        int r103 = r102.f238680b;
        r102.f238680b = r101;
        r102.notifyItemChanged(r101);
        this.f238708d.notifyItemChanged(r103);
        FontPickerAdapter r104 = this.f238708d;
        r104.f238679a.invoke(r104.getItem(r101));
        return;
    }
}
