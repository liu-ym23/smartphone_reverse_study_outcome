package com.bytedance.ee.bear.bitable.share.sharepanel;

import android.graphics.Bitmap;
import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import com.larus.nova.R;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes16.dex */
public final class i<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ FormsQRCodePanelFragment f215448a;

    public i(FormsQRCodePanelFragment r100) {
        this.f215448a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Bitmap r101 = (Bitmap) r100;
        if (FormsQRCodePanelFragment.S90(this.f215448a) == false) goto L12;
        FormsQRCodePanelFragment r102 = this.f215448a;
        View r103 = r102.f215380h;
        if (r103 != null) goto L11;
        View r104 = r102.getView();
        if (r104 == null) goto L9;
        r103 = r104.findViewById(R.id.formsShareLinkQRCode);
    L10:
        r102.f215380h = (AppCompatImageView) r103;
        goto L11
    L9:
        r103 = null;
    L11:
        ((AppCompatImageView) r103).setImageBitmap(r101);
        return;
    L12:
        tt5.a.h("FormsQRCodePanelFragment", "fragment invalid when set qrcodeBmp");
    }
}
