package com.bytedance.android.shopping.slice.elements.projectionview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.view.View;
import com.bytedance.android.ec.hybrid.list.util.c;
import com.bytedance.android.ecom.arch.slice.render.elements.flexbox.SlcFlexElementView;
import com.bytedance.android.ecom.arch.slice.render.elements.flexbox.b;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.p;
import java.util.Map;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class PdpProjectionViewManager extends b {

    public final class a implements p {
    }

    public final void H0(Map<String, ? extends Object> r2) {
        Intrinsics.checkNotNullParameter(r2, "props");
    }

    public final View A0(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        throw null;
    }

    public final SlcFlexElementView J1(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        throw null;
    }

    public static final Bitmap K1(PdpProjectionViewManager r9, View r10, Function1 r11) {
        r9.getClass();
        int r12 = r10.getWidth();
        int r4 = r10.getHeight();
        int r0 = c.a;
        c.d(80);
        if (r12 <= 0) goto L8;
        if (r4 <= 0) goto L8;
        Bitmap r8 = Bitmap.createBitmap(r12, r4, Bitmap.Config.RGB_565);     // Catch: Throwable -> L10
        Canvas r1 = new Canvas(r8);     // Catch: Throwable -> L10
        r11.invoke(Boolean.TRUE);     // Catch: Throwable -> L10
        r10.draw(r1);     // Catch: Throwable -> L10
        r11.invoke(Boolean.FALSE);     // Catch: Throwable -> L10
        Matrix r5 = new Matrix();     // Catch: Throwable -> L10
        r5.postScale(1.0f, -1.0f);     // Catch: Throwable -> L10
        r5.postTranslate(0.0f, r4);     // Catch: Throwable -> L10
        Bitmap r13 = Bitmap.createBitmap(r8, 0, 0, r12, r4, r5, true);     // Catch: Throwable -> L10
        r8.recycle();     // Catch: Throwable -> L10
        Bitmap r14 = Bitmap.createBitmap(r13, 0, 0, r12, c.d(80));     // Catch: Throwable -> L10
        r13.recycle();     // Catch: Throwable -> L10
        return r14;
    L8:
        return null;
    }
}
