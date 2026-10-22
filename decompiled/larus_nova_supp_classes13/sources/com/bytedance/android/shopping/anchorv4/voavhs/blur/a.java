package com.bytedance.android.shopping.anchorv4.voavhs.blur;

import android.content.Context;
import android.graphics.Bitmap;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RSRuntimeException;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class a implements e {
    public static Boolean e;
    public RenderScript a;
    public ScriptIntrinsicBlur b;
    public Allocation c;
    public Allocation d;

    public a() {
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.blur.e
    public final void release() {
        Allocation r0 = this.c;
        if (r0 == null) goto L5;
        r0.destroy();
        this.c = null;
    L5:
        Allocation r1 = this.d;
        if (r1 == null) goto L8;
        r1.destroy();
        this.d = null;
    L8:
        ScriptIntrinsicBlur r2 = this.b;
        if (r2 == null) goto L11;
        r2.destroy();
        this.b = null;
    L11:
        RenderScript r3 = this.a;
        if (r3 == null) goto L15;
        r3.destroy();
        this.a = null;
        return;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.blur.e
    public final void b(Bitmap r2, Bitmap r3) {
        this.c.copyFrom(r2);
        this.b.setInput(this.c);
        this.b.forEach(this.d);
        this.d.copyTo(r3);
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.blur.e
    public final boolean a(Context r4, Bitmap r5, float r6) {
        boolean r1 = true;
        if (this.a == null) goto L25;
    L23:
        this.b.setRadius(r6);
        Allocation r7 = Allocation.createFromBitmap(this.a, r5, Allocation.MipmapControl.MIPMAP_NONE, 1);
        this.c = r7;
        this.d = Allocation.createTyped(this.a, r7.getType());
        return true;
    L25:
        RenderScript r0 = RenderScript.create(r4);     // Catch: RSRuntimeException -> L6
        this.a = r0;     // Catch: RSRuntimeException -> L6
        this.b = ScriptIntrinsicBlur.create(r0, Element.U8_4(r0));     // Catch: RSRuntimeException -> L6
    L6:
        e = move-exception;
        if (e != null) goto L16;
        if (r4 == null) goto L16;
        if ((r4.getApplicationInfo().flags & 2) == 0) goto L13;
        boolean r8 = true;
    L14:
        e = Boolean.valueOf(r8);
        goto L16
    L13:
        r8 = false;
    L16:
        if (e == Boolean.TRUE) goto L19;
        r1 = false;
    L19:
        if (r1 == true) goto L22;
        release();
        return false;
    L22:
        throw e;
    }
}
