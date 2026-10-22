package com.bytedance.ee.bear.document.matermark;

import android.graphics.Bitmap;
import com.bytedance.ee.bear.p;
import com.ss.android.lark.watermark.core.IAttachToBitmapCallback;
import com.ss.android.lark.watermark.core.IGetWaterMarkResourceCallback;
import com.ss.android.lark.watermark.core.WatermarkPointContext;
import com.ss.android.lark.watermark.core.WatermarkType;
import java.util.concurrent.CountDownLatch;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class CCMWatermarkManager {
    public static final Lazy<zo5.b> a = null;

    public static final class a {
        @JvmStatic
        public static void a(String r1, IGetWaterMarkResourceCallback r2) {
            Intrinsics.checkNotNullParameter(r1, "filePath");
            Intrinsics.checkNotNullParameter(r2, "callback");
            ((zo5.b) CCMWatermarkManager.a.getValue()).i(r1, r2);
        }
    }

    public final class b implements IAttachToBitmapCallback {
        public final CountDownLatch a;
        public volatile Bitmap b;
        public volatile String c;

        public b(CountDownLatch r2) {
            Intrinsics.checkNotNullParameter(r2, "countDownLatch");
            this.a = r2;
        }

        public final void onAttachSuccess(Bitmap r1) {
            this.b = r1;
            this.a.countDown();
        }

        public final void onAttachFailed(Bitmap r1, String r2) {
            this.b = null;
            this.c = r2;
            this.a.countDown();
        }
    }

    public CCMWatermarkManager() {
    }

    static {
        a = LazyKt.lazy(CCMWatermarkManager$Companion$watermarkManger$2.INSTANCE);
    }

    public static p b(boolean r4, Bitmap r5, WatermarkType r6) throws InterruptedException {
        Intrinsics.checkNotNullParameter(r5, "bitmap");
        Intrinsics.checkNotNullParameter(r6, "watermarkType");
        CountDownLatch r0 = new CountDownLatch(1);
        b r1 = new b(r0);
        if (r4 == false) goto L5;
        ((zo5.b) org.koin.java.a.c(zo5.b.class, null, null, 6)).f(r5, r1, r6, WatermarkPointContext.CCM);
    L6:
        r0.await();
        Bitmap r7 = r1.b;
        if (r7 != null) goto L11;
        RuntimeException r8 = new RuntimeException("addWatermark fail: " + r1.c);
        int r9 = p.b;
        return p.a.a(r8);
    L11:
        return new p(r7);
    L5:
        ((zo5.b) org.koin.java.a.c(zo5.b.class, null, null, 6)).c(r5, r1);
        goto L6
    }

    public static void a(boolean r2, Bitmap r3, WatermarkType r4, IAttachToBitmapCallback r5) throws InterruptedException {
        Intrinsics.checkNotNullParameter(r3, "bitmap");
        Intrinsics.checkNotNullParameter(r4, "watermarkType");
        Intrinsics.checkNotNullParameter(r5, "callback");
        if (r2 == false) goto L5;
        ((zo5.b) org.koin.java.a.c(zo5.b.class, null, null, 6)).f(r3, r5, r4, WatermarkPointContext.CCM);
        return;
    L5:
        ((zo5.b) org.koin.java.a.c(zo5.b.class, null, null, 6)).c(r3, r5);
    }
}
