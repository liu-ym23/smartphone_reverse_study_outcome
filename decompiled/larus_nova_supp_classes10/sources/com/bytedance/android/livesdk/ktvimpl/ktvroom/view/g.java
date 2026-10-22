package com.bytedance.android.livesdk.ktvimpl.ktvroom.view;

import android.graphics.Bitmap;
import android.os.Looper;
import com.bytedance.android.live.core.utils.i0;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.DataSource;
import com.facebook.imagepipeline.datasource.BaseBitmapDataSubscriber;
import com.facebook.imagepipeline.image.CloseableImage;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class g extends BaseBitmapDataSubscriber {
    public final /* synthetic */ i a;
    public final /* synthetic */ String b;

    public static final class a implements Runnable {
        public final /* synthetic */ Bitmap a;
        public final /* synthetic */ g b;

        public a(Bitmap r1, g r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            g r0 = this.b;     // Catch: Throwable -> L4
            i.i(r0.a, r0.b, this.a);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public final void onFailureImpl(DataSource<CloseableReference<CloseableImage>> r1) {
    }

    public final void onNewResultImpl(Bitmap r4) {
        if (r4 != null) goto L4;
        return;
    L4:
        if ((!r4.isRecycled()) == true) goto L7;
        r4 = null;
    L7:
        if (r4 == null) goto L16;
        Bitmap r5 = r4.copy(Bitmap.Config.ARGB_8888, false);
        if (r5 == null) goto L17;
        this.a.q.g = true;
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == false) goto L13;
        i.i(this.a, this.b, r5);
        return;
    L13:
        i0.h(new a(r5, this));
        return;
    L17:
        return;
    }

    public g(i r1, String r2) {
        this.a = r1;
        this.b = r2;
    }
}
