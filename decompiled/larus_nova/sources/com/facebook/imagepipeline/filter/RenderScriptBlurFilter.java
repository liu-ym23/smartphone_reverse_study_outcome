package com.facebook.imagepipeline.filter;

import android.content.Context;
import android.graphics.Bitmap;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;
import com.facebook.common.internal.Preconditions;

/* JADX INFO: loaded from: classes23.dex */
public abstract class RenderScriptBlurFilter {
    public static final int BLUR_MAX_RADIUS = 25;

    public RenderScriptBlurFilter() {
    }

    public static boolean canUseRenderScript() {
        return true;
    }

    public static void blurBitmap(Bitmap r100, Bitmap r101, Context r102, int r103) {
        Preconditions.checkNotNull(r100);
        Preconditions.checkNotNull(r101);
        Preconditions.checkNotNull(r102);
        if (r103 > 0) goto L5;
    L7:
        boolean r104 = false;
    L8:
        Preconditions.checkArgument(r104);
        RenderScript r105 = RenderScript.create(r102);     // Catch: Throwable -> L16
        ScriptIntrinsicBlur r106 = ScriptIntrinsicBlur.create(r105, Element.U8_4(r105));     // Catch: Throwable -> L14
        Allocation r107 = Allocation.createFromBitmap(r105, r101);     // Catch: Throwable -> L14
        Allocation r108 = Allocation.createFromBitmap(r105, r100);     // Catch: Throwable -> L14
        r106.setRadius(r103);     // Catch: Throwable -> L14
        r106.setInput(r107);     // Catch: Throwable -> L14
        r106.forEach(r108);     // Catch: Throwable -> L14
        r108.copyTo(r100);     // Catch: Throwable -> L14
        if (r105 == null) goto L25;
        r105.destroy();
        return;
    L25:
        return;
    L14:
        th = th;
    L18:
        if (r105 == null) goto L20;
        r105.destroy();
    L20:
        throw th;
    L16:
        th = th;
        r105 = null;
        goto L18
    L5:
        if (r103 > 25) goto L7;
        r104 = true;
        goto L8
    }
}
