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
public final class f extends BaseBitmapDataSubscriber {
    public final /* synthetic */ i a;
    public final /* synthetic */ String b;

    public static final class a implements Runnable {
        public final /* synthetic */ Bitmap a;
        public final /* synthetic */ f b;

        public a(Bitmap r1, f r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            f r0 = this.b;     // Catch: Throwable -> L4
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

    public final void onNewResultImpl(Bitmap r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        if ((!r3.isRecycled()) == true) goto L7;
        r3 = null;
    L7:
        if (r3 == null) goto L16;
        Bitmap r4 = r3.copy(Bitmap.Config.ARGB_8888, false);
        if (r4 != null) goto L11;
        return;
    L11:
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == false) goto L13;
        i.i(this.a, this.b, r4);
        return;
    L13:
        i0.h(new a(r4, this));
        return;
    }

    public f(i r1, String r2) {
        this.a = r1;
        this.b = r2;
    }
}
