package com.bytedance.android.shopping.api.mall.common.tools;

import android.graphics.Bitmap;
import android.view.PixelCopy;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class g implements PixelCopy.OnPixelCopyFinishedListener {
    public final /* synthetic */ DeliveryViewAnimHelper a;
    public final /* synthetic */ Bitmap b;

    public g(DeliveryViewAnimHelper r1, Bitmap r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.view.PixelCopy.OnPixelCopyFinishedListener
    public final void onPixelCopyFinished(int r2) {
        if (r2 != 0) goto L5;
        DeliveryViewAnimHelper r3 = this.a;
        Bitmap r0 = this.b;
        r3.getClass();
        DeliveryViewAnimHelper.g = r0;
        return;
    }
}
