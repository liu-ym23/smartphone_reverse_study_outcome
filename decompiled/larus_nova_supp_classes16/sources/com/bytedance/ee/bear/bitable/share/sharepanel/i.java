package com.bytedance.ee.bear.bitable.share.sharepanel;

import android.graphics.Bitmap;
import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class i<T> implements Consumer {
    public final /* synthetic */ FormsQRCodePanelFragment a;

    public i(FormsQRCodePanelFragment r1) {
        this.a = r1;
    }

    public final void accept(Object r4) {
        Bitmap r5 = (Bitmap) r4;
        if (FormsQRCodePanelFragment.S90(this.a) == false) goto L12;
        FormsQRCodePanelFragment r0 = this.a;
        View r1 = r0.h;
        if (r1 != null) goto L11;
        View r2 = r0.getView();
        if (r2 == null) goto L9;
        r1 = r2.findViewById(2131373211);
    L10:
        r0.h = (AppCompatImageView) r1;
        goto L11
    L9:
        r1 = null;
    L11:
        ((AppCompatImageView) r1).setImageBitmap(r5);
        return;
    L12:
        tt5.a.h("FormsQRCodePanelFragment", "fragment invalid when set qrcodeBmp");
    }
}
