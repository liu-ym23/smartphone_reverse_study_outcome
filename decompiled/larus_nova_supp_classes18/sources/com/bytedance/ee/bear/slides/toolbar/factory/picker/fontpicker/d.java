package com.bytedance.ee.bear.slides.toolbar.factory.picker.fontpicker;

import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class d implements View.OnClickListener {
    public final /* synthetic */ FontItem a;
    public final /* synthetic */ int b;
    public final /* synthetic */ FontPickerAdapter.FontViewHolder c;
    public final /* synthetic */ FontPickerAdapter d;

    public d(FontItem r1, int r2, FontPickerAdapter.FontViewHolder r3, FontPickerAdapter r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r4) {
        if (Intrinsics.areEqual(this.a.isSupport(), Boolean.FALSE) == false) goto L6;
        tt5.a.h("FontPickerAdapter", "click on position " + this.b + ", but not support");
        this.c.e.getContext();
        return;
    L6:
        int r5 = this.c.getAdapterPosition();
        tt5.a.h("FontPickerAdapter", "click on position " + r5);
        if (r5 == (-1)) goto L10;
        FontPickerAdapter r0 = this.d;
        int r1 = r0.b;
        r0.b = r5;
        r0.notifyItemChanged(r5);
        this.d.notifyItemChanged(r1);
        FontPickerAdapter r2 = this.d;
        r2.a.invoke((FontItem) r2.getItem(r5));
        return;
    }
}
