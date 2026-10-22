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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class c implements com.bytedance.awemeopen.infra.base.image.c {
    public final /* synthetic */ FullVideoView a;
    public final /* synthetic */ Size b;
    public final /* synthetic */ int c;

    public final void onFail() {
        AoImageView r0 = this.a.getBackgroundImageView();
        com.bytedance.awemeopen.infra.base.image.b r1 = new com.bytedance.awemeopen.infra.base.image.b(this.a.getUrls());
        r1.q = 10;
        r1.m = ImageView.ScaleType.CENTER_CROP;
        r0.j(r1);
    }

    public final void onSuccess(Bitmap r18) {
        Intrinsics.checkNotNullParameter(r18, "result");
        this.a.getBackgroundImageView().setImageBitmap(r18);
        int r2 = d0.d(this.a.getContext());
        int r9 = d0.c(this.a.getContext());
        this.a.getTopMask().setBottomEdgeTransparent(true);     // Catch: Throwable -> L9
        Matrix r11 = new Matrix();     // Catch: Throwable -> L9
        float r6 = 0.0f;
        if ((r18.getWidth() * r9) <= (r18.getHeight() * r2)) goto L6;
        float r3 = r9 / r18.getHeight();     // Catch: Throwable -> L9
        r6 = (r2 - (r18.getWidth() * r3)) * 0.5f;     // Catch: Throwable -> L9
        float r12 = r3;
        float r4 = 0.0f;
    L7:
        float r5 = Math.abs(r6) / r12;     // Catch: Throwable -> L9
        float r13 = Math.abs(r4) / r12;     // Catch: Throwable -> L9
        r11.postScale(r12, r12);     // Catch: Throwable -> L9
        int r15 = (int) r5;     // Catch: Throwable -> L9
        this.a.getTopMask().setRealDrawBitmap(Bitmap.createBitmap(r18, r15, (int) ((((r9 - this.b.getHeight()) / 2.0f) / r12) + r13), r18.getWidth() - r15, MathKt.roundToInt(this.c / r12), r11, true));     // Catch: Throwable -> L9
        this.a.getBottomMask().setRealDrawBitmap(Bitmap.createBitmap(r18, r15, (int) (r13 + (((((r9 - this.b.getHeight()) / 2.0f) + this.b.getHeight()) - this.c) / r12)), r18.getWidth() - r15, MathKt.roundToInt(this.c / r12) + 1, r11, true));     // Catch: Throwable -> L9
        return;
    L6:
        float r7 = r2 / r18.getWidth();     // Catch: Throwable -> L9
        r4 = (r9 - (r18.getHeight() * r7)) * 0.5f;     // Catch: Throwable -> L9
        r12 = r7;
    L9:
        th = move-exception;
        AoLogger.c("FullVideoView", new Object[]{"tryShowBackground error, " + Log.getStackTraceString(th)});
    }

    public c(FullVideoView r1, Size r2, int r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
