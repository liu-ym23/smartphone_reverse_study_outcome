package com.bytedance.awemeopen.apps.framework.player;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.util.Log;
import android.util.Size;
import android.widget.ImageView;
import com.bytedance.awemeopen.apps.framework.utils.d0;
import com.bytedance.awemeopen.infra.base.image.AoImageView;
import com.bytedance.awemeopen.infra.base.log.AoLogger;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: classes14.dex */
public final class c implements com.bytedance.awemeopen.infra.base.image.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ FullVideoView f197273a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Size f197274b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f197275c;

    @Override // com.bytedance.awemeopen.infra.base.image.c
    public final void onFail() {
        AoImageView r100 = this.f197273a.getBackgroundImageView();
        com.bytedance.awemeopen.infra.base.image.b r101 = new com.bytedance.awemeopen.infra.base.image.b(this.f197273a.getUrls());
        r101.f198636q = 10;
        r101.f198632m = ImageView.ScaleType.CENTER_CROP;
        r100.j(r101);
    }

    @Override // com.bytedance.awemeopen.infra.base.image.c
    public final void onSuccess(Bitmap r110) {
        Intrinsics.checkNotNullParameter(r110, "result");
        this.f197273a.getBackgroundImageView().setImageBitmap(r110);
        int r100 = d0.d(this.f197273a.getContext());
        int r101 = d0.c(this.f197273a.getContext());
        this.f197273a.getTopMask().setBottomEdgeTransparent(true);     // Catch: Throwable -> L9
        Matrix r111 = new Matrix();     // Catch: Throwable -> L9
        float r102 = 0.0f;
        if ((r110.getWidth() * r101) <= (r110.getHeight() * r100)) goto L6;
        float r103 = r101 / r110.getHeight();     // Catch: Throwable -> L9
        r102 = (r100 - (r110.getWidth() * r103)) * 0.5f;     // Catch: Throwable -> L9
        float r112 = r103;
        float r104 = 0.0f;
    L7:
        float r105 = Math.abs(r102) / r112;     // Catch: Throwable -> L9
        float r113 = Math.abs(r104) / r112;     // Catch: Throwable -> L9
        r111.postScale(r112, r112);     // Catch: Throwable -> L9
        int r114 = (int) r105;     // Catch: Throwable -> L9
        this.f197273a.getTopMask().setRealDrawBitmap(Bitmap.createBitmap(r110, r114, (int) ((((r101 - this.f197274b.getHeight()) / 2.0f) / r112) + r113), r110.getWidth() - r114, MathKt.roundToInt(this.f197275c / r112), r111, true));     // Catch: Throwable -> L9
        this.f197273a.getBottomMask().setRealDrawBitmap(Bitmap.createBitmap(r110, r114, (int) (r113 + (((((r101 - this.f197274b.getHeight()) / 2.0f) + this.f197274b.getHeight()) - this.f197275c) / r112)), r110.getWidth() - r114, MathKt.roundToInt(this.f197275c / r112) + 1, r111, true));     // Catch: Throwable -> L9
        return;
    L6:
        float r106 = r100 / r110.getWidth();     // Catch: Throwable -> L9
        r104 = (r101 - (r110.getHeight() * r106)) * 0.5f;     // Catch: Throwable -> L9
        r112 = r106;
    L9:
        th = move-exception;
        AoLogger.c("FullVideoView", new Object[]{"tryShowBackground error, " + Log.getStackTraceString(th)});
    }

    public c(FullVideoView r100, Size r101, int r102) {
        this.f197273a = r100;
        this.f197274b = r101;
        this.f197275c = r102;
    }
}
