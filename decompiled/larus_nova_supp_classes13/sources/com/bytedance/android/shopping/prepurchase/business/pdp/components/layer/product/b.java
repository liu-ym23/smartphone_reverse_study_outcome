package com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.product;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.view.PixelCopy;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class b implements PixelCopy.OnPixelCopyFinishedListener {
    public final /* synthetic */ BaseInfoServiceSnapshotTransitionController a;
    public final /* synthetic */ Rect b;
    public final /* synthetic */ boolean c;
    public final /* synthetic */ Function1 d;
    public final /* synthetic */ Bitmap e;
    public final /* synthetic */ Integer f;

    public b(BaseInfoServiceSnapshotTransitionController r1, Rect r2, boolean r3, Function1 r4, Bitmap r5, Integer r6) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
    }

    @Override // android.view.PixelCopy.OnPixelCopyFinishedListener
    public final void onPixelCopyFinished(int r8) {
        if (r8 != 0) goto L5;
        this.a.j = null;
        dm.a.a("PdpSnapshotTransition").b("capture success mode=pixel_copy bounds=" + this.b + " expanded=" + this.c, null);
        this.d.invoke(new BaseInfoServiceSnapshotTransitionController.c(this.a.q, new Rect(this.b), this.c, this.e, this.f));
        return;
    L5:
        this.a.g("capture_pixel_copy_failed:" + r8);
        this.d.invoke(null);
    }
}
