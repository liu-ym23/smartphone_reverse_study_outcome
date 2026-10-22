package com.bytedance.android.livesdk.ktvimpl.realtimechorus;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import com.bytedance.android.live.core.utils.s1;
import com.facebook.imagepipeline.image.CloseableStaticBitmap;
import com.facebook.imagepipeline.image.ImageInfo;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class y0 extends com.bytedance.android.live.core.utils.q0 {
    public final /* synthetic */ RealTimeChorusMainViewWidget a;
    public final /* synthetic */ com.bytedance.android.live.profit.dress.config.n b;

    public final void d(ImageInfo r4) {
        if ((r4 instanceof CloseableStaticBitmap) == false) goto L13;
        Bitmap r5 = ((CloseableStaticBitmap) r4).getUnderlyingBitmap();
        if (r5 != null) goto L7;
        return;
    L7:
        if (r5.isRecycled() == true) goto L15;
        Bitmap.Config r0 = r5.getConfig();
        if (r0 != null) goto L11;
        r0 = Bitmap.Config.ARGB_8888;
    L11:
        Bitmap r6 = r5.copy(r0, true);
        RealTimeChorusMainViewWidget r1 = this.a;
        r1.z = new BitmapDrawable(s1.getResources(), r6);
        return;
    L15:
        return;
    }

    public y0(RealTimeChorusMainViewWidget r1, com.bytedance.android.live.profit.dress.config.n r2) {
        this.a = r1;
        this.b = r2;
    }
}
