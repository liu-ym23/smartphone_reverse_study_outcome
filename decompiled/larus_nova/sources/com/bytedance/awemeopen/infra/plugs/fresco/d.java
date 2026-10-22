package com.bytedance.awemeopen.infra.plugs.fresco;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory;
import com.facebook.imagepipeline.request.BasePostprocessor;

/* JADX INFO: loaded from: classes46.dex */
public final class d extends BasePostprocessor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ l64.b f198860a;

    public d(l64.b r100) {
        this.f198860a = r100;
    }

    @Override // com.facebook.imagepipeline.request.BasePostprocessor, com.facebook.imagepipeline.request.Postprocessor
    public final CloseableReference<Bitmap> process(Bitmap r100, PlatformBitmapFactory r101) {
        l64.b r102 = this.f198860a;
        int r103 = r102.f507678m;
        int r104 = r102.f507677l;
        if (r102.f507676k != ImageView.ScaleType.CENTER_INSIDE) goto L13;
        float r105 = r100.getWidth() / r100.getHeight();
        if (r100.getHeight() <= r100.getWidth()) goto L7;
        r103 = this.f198860a.f507678m;
    L9:
        if (r100.getHeight() <= r100.getWidth()) goto L11;
        int r106 = (int) (this.f198860a.f507678m * r105);
    L12:
        r104 = r106;
        goto L13
    L11:
        r106 = this.f198860a.f507677l;
        goto L12
    L7:
        r103 = (int) (this.f198860a.f507677l / r105);
    L13:
        CloseableReference<Bitmap> r107 = r101.createBitmap(r104, r103);
        Bitmap r108 = r107.get();     // Catch: Throwable -> L21
        l64.b r109 = this.f198860a;     // Catch: Throwable -> L21
        if (r109.f507676k != ImageView.ScaleType.CENTER_CROP) goto L17;
        c.b(c.a(r100, r109), r108, this.f198860a);     // Catch: Throwable -> L21
    L18:
        CloseableReference<Bitmap> r110 = CloseableReference.cloneOrNull(r107);     // Catch: Throwable -> L21
        CloseableReference.closeSafely(r107);
        return r110;
    L17:
        c.c(r100, r108, r103, r104, r109);     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        CloseableReference.closeSafely(r107);
        throw th;
    }

    @Override // com.facebook.imagepipeline.request.BasePostprocessor
    public final void process(Bitmap r100, Bitmap r101) {
        super.process(r100, r101);
    }
}
