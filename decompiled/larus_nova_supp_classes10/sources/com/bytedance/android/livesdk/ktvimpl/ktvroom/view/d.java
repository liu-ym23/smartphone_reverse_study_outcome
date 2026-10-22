package com.bytedance.android.livesdk.ktvimpl.ktvroom.view;

import android.animation.AnimatorSet;
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
public final class d extends BaseBitmapDataSubscriber {
    public final /* synthetic */ i a;
    public final /* synthetic */ String b;

    public static final class a implements Runnable {
        public final /* synthetic */ Bitmap a;
        public final /* synthetic */ d b;

        public a(Bitmap r1, d r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            d r0 = this.b;     // Catch: Throwable -> L6
            i r1 = r0.a;     // Catch: Throwable -> L6
            String r2 = r0.b;     // Catch: Throwable -> L6
            Bitmap r3 = this.a;     // Catch: Throwable -> L6
            c r4 = r1.o;     // Catch: Throwable -> L6
            r4.o = r2;     // Catch: Throwable -> L6
            r4.d(r3);     // Catch: Throwable -> L6
            r1.o.g = true;     // Catch: Throwable -> L6
            AnimatorSet r5 = r1.u;     // Catch: Throwable -> L6
            if (r5 == null) goto L9;
            r5.start();     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }
    }

    public final void onFailureImpl(DataSource<CloseableReference<CloseableImage>> r1) {
    }

    public final void onNewResultImpl(Bitmap r5) {
        if (r5 != null) goto L4;
        return;
    L4:
        if ((!r5.isRecycled()) == true) goto L7;
        r5 = null;
    L7:
        if (r5 == null) goto L18;
        Bitmap r6 = r5.copy(Bitmap.Config.ARGB_8888, false);
        if (r6 != null) goto L11;
        return;
    L11:
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == false) goto L15;
        i r0 = this.a;
        String r2 = this.b;
        c r3 = r0.o;
        r3.o = r2;
        r3.d(r6);
        r0.o.g = true;
        AnimatorSet r7 = r0.u;
        if (r7 == null) goto L20;
        r7.start();
        return;
    L20:
        return;
    L15:
        i0.h(new a(r6, this));
        return;
    }

    public d(i r1, String r2) {
        this.a = r1;
        this.b = r2;
    }
}
