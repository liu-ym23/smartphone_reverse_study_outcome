package com.bytedance.ee.bear.document.matermark;

import android.graphics.Bitmap;
import com.bytedance.ee.bear.p;
import com.facebook.imagepipeline.common.SimplayerImageStrategy;
import com.ss.android.lark.watermark.core.IAttachToBitmapCallback;
import com.ss.android.lark.watermark.core.IGetWaterMarkResourceCallback;
import com.ss.android.lark.watermark.core.WatermarkPointContext;
import com.ss.android.lark.watermark.core.WatermarkType;
import java.util.concurrent.CountDownLatch;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class CCMWatermarkManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy<zo5.b> f220231a = null;

    public static final class a {
        @JvmStatic
        public static void a(String r100, IGetWaterMarkResourceCallback r101) {
            Intrinsics.checkNotNullParameter(r100, "filePath");
            Intrinsics.checkNotNullParameter(r101, "callback");
            CCMWatermarkManager.f220231a.getValue().i(r100, r101);
        }
    }

    public final class b implements IAttachToBitmapCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final CountDownLatch f220232a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public volatile Bitmap f220233b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public volatile String f220234c;

        public b(CountDownLatch r100) {
            Intrinsics.checkNotNullParameter(r100, "countDownLatch");
            this.f220232a = r100;
        }

        @Override // com.ss.android.lark.watermark.core.IAttachToBitmapCallback
        public final void onAttachSuccess(Bitmap r100) {
            this.f220233b = r100;
            this.f220232a.countDown();
        }

        @Override // com.ss.android.lark.watermark.core.IAttachToBitmapCallback
        public final void onAttachFailed(Bitmap r100, String r101) {
            this.f220233b = null;
            this.f220234c = r101;
            this.f220232a.countDown();
        }
    }

    public CCMWatermarkManager() {
    }

    static {
        f220231a = LazyKt.lazy(CCMWatermarkManager$Companion$watermarkManger$2.INSTANCE);
    }

    public static p b(boolean r100, Bitmap r101, WatermarkType r102) throws InterruptedException {
        Intrinsics.checkNotNullParameter(r101, SimplayerImageStrategy.RESULT_BITMAP);
        Intrinsics.checkNotNullParameter(r102, "watermarkType");
        CountDownLatch r103 = new CountDownLatch(1);
        b r104 = new b(r103);
        if (r100 == false) goto L5;
        ((zo5.b) org.koin.java.a.c(zo5.b.class, null, null, 6)).f(r101, r104, r102, WatermarkPointContext.CCM);
    L6:
        r103.await();
        Bitmap r105 = r104.f220233b;
        if (r105 != null) goto L11;
        RuntimeException r106 = new RuntimeException("addWatermark fail: " + r104.f220234c);
        int r107 = p.f236228b;
        return p.a.a(r106);
    L11:
        return new p(r105);
    L5:
        ((zo5.b) org.koin.java.a.c(zo5.b.class, null, null, 6)).c(r101, r104);
        goto L6
    }

    public static void a(boolean r100, Bitmap r101, WatermarkType r102, IAttachToBitmapCallback r103) throws InterruptedException {
        Intrinsics.checkNotNullParameter(r101, SimplayerImageStrategy.RESULT_BITMAP);
        Intrinsics.checkNotNullParameter(r102, "watermarkType");
        Intrinsics.checkNotNullParameter(r103, "callback");
        if (r100 == false) goto L5;
        ((zo5.b) org.koin.java.a.c(zo5.b.class, null, null, 6)).f(r101, r103, r102, WatermarkPointContext.CCM);
        return;
    L5:
        ((zo5.b) org.koin.java.a.c(zo5.b.class, null, null, 6)).c(r101, r103);
    }
}
