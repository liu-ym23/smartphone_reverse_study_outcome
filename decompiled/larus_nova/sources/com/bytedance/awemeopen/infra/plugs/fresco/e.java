package com.bytedance.awemeopen.infra.plugs.fresco;

import android.graphics.Bitmap;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.DataSource;
import com.facebook.imagepipeline.datasource.BaseBitmapDataSubscriber;
import com.facebook.imagepipeline.image.CloseableImage;

/* JADX INFO: loaded from: classes46.dex */
public final class e extends BaseBitmapDataSubscriber {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ l64.b f198861a;

    public e(l64.b r100) {
        this.f198861a = r100;
    }

    @Override // com.facebook.datasource.BaseDataSubscriber
    public final void onFailureImpl(DataSource<CloseableReference<CloseableImage>> r100) {
        com.bytedance.awemeopen.infra.base.image.c r101 = this.f198861a.f507686u.f198642a.f198630k;
        if (r101 == null) goto L6;
        r101.onFail();
        return;
    }

    @Override // com.facebook.imagepipeline.datasource.BaseBitmapDataSubscriber
    public final void onNewResultImpl(Bitmap r100) {
        int r101 = r100.getWidth();
        int r102 = r100.getHeight();
        int r103 = r101 * r102;
        if (r103 <= 262144) goto L5;
        double r104 = Math.sqrt((r103 * 1.0f) / 262144);
        r101 = (int) Math.ceil(((double) r101) / r104);
        r102 = (int) Math.ceil(((double) r102) / r104);
    L5:
        Bitmap r105 = Bitmap.createBitmap(r100, 0, 0, r101, r102);
        com.bytedance.awemeopen.infra.base.image.c r106 = this.f198861a.f507686u.f198642a.f198630k;
        if (r106 == null) goto L9;
        r106.onSuccess(r105);
        return;
    }
}
