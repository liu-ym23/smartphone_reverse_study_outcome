package ztc;

import android.content.Context;
import android.graphics.Bitmap;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RSRuntimeException;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;

/* JADX INFO: loaded from: classes41.dex */
public final class a {
    public static void a(Context r100, Bitmap r101, int r102) throws RSRuntimeException {
        RenderScript r103 = null;
        ScriptIntrinsicBlur r104 = null;
        RenderScript r105 = RenderScript.create(r100);     // Catch: Throwable -> L16
        r105.setMessageHandler(new RenderScript.RSMessageHandler());     // Catch: Throwable -> L13
        Allocation r106 = Allocation.createFromBitmap(r105, r101, Allocation.MipmapControl.MIPMAP_NONE, 1);     // Catch: Throwable -> L13
        Allocation r107 = Allocation.createTyped(r105, r106.getType());     // Catch: Throwable -> L11
        r104 = ScriptIntrinsicBlur.create(r105, Element.U8_4(r105));     // Catch: Throwable -> L9
        r104.setInput(r106);     // Catch: Throwable -> L9
        r104.setRadius(r102);     // Catch: Throwable -> L9
        r104.forEach(r107);     // Catch: Throwable -> L9
        r107.copyTo(r101);     // Catch: Throwable -> L9
        r105.destroy();
        r106.destroy();
        r107.destroy();
        r104.destroy();
        return;
    L9:
        th = th;
        ScriptIntrinsicBlur r108 = r104;
        r103 = r105;
        ScriptIntrinsicBlur r109 = r108;
    L18:
        if (r103 == null) goto L20;
        r103.destroy();
    L20:
        if (r106 == null) goto L22;
        r106.destroy();
    L22:
        if (r107 == null) goto L24;
        r107.destroy();
    L24:
        if (r109 == null) goto L26;
        r109.destroy();
    L26:
        throw th;
    L11:
        th = th;
    L15:
        r107 = null;
        r103 = r105;
        r109 = null;
    L13:
        th = th;
        r106 = null;
    L16:
        th = th;
        r109 = null;
        r106 = null;
        r107 = null;
        goto L18
    }
}
