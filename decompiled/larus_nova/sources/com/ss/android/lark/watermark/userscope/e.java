package com.ss.android.lark.watermark.userscope;

import android.graphics.Bitmap;
import androidx.lifecycle.Observer;
import com.facebook.imagepipeline.common.SimplayerImageStrategy;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.watermark.core.IAttachToBitmapCallback;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class e implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ UiThreadExecutionWatermarkImplV3 f445430a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Bitmap f445431b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ IAttachToBitmapCallback f445432c;

    public e(UiThreadExecutionWatermarkImplV3 r100, Bitmap r101, IAttachToBitmapCallback r102) {
        this.f445430a = r100;
        this.f445431b = r101;
        this.f445432c = r102;
    }

    @Override // java.lang.Runnable
    public final void run() {
        final WatermarkImplV3 r100 = this.f445430a.f445332a;     // Catch: Throwable -> L4
        final Bitmap r101 = this.f445431b;     // Catch: Throwable -> L4
        final IAttachToBitmapCallback r102 = this.f445432c;     // Catch: Throwable -> L4
        r100.getClass();     // Catch: Throwable -> L4
        Intrinsics.checkNotNullParameter(r101, SimplayerImageStrategy.RESULT_BITMAP);     // Catch: Throwable -> L4
        Observer<com.ss.android.lark.watermark.v2.v> r103 = new WatermarkImplV3$addWatermarkToBitmap$observer$1(r100, r101, r102);     // Catch: Throwable -> L4
        r100.f().b().observeForever(r103);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
