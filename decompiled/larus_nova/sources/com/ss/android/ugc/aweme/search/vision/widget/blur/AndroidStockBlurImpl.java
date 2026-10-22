package com.ss.android.ugc.aweme.search.vision.widget.blur;

import android.content.Context;
import android.graphics.Bitmap;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RSRuntimeException;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;

/* JADX INFO: loaded from: classes40.dex */
public class AndroidStockBlurImpl implements BlurImpl {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static Boolean f454070e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public RenderScript f454071a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ScriptIntrinsicBlur f454072b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Allocation f454073c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Allocation f454074d;

    public AndroidStockBlurImpl() {
    }

    @Override // com.ss.android.ugc.aweme.search.vision.widget.blur.BlurImpl
    public final void release() {
        Allocation r100 = this.f454073c;
        if (r100 == null) goto L5;
        r100.destroy();
        this.f454073c = null;
    L5:
        Allocation r101 = this.f454074d;
        if (r101 == null) goto L8;
        r101.destroy();
        this.f454074d = null;
    L8:
        ScriptIntrinsicBlur r102 = this.f454072b;
        if (r102 == null) goto L11;
        r102.destroy();
        this.f454072b = null;
    L11:
        RenderScript r103 = this.f454071a;
        if (r103 == null) goto L15;
        r103.destroy();
        this.f454071a = null;
        return;
    }

    @Override // com.ss.android.ugc.aweme.search.vision.widget.blur.BlurImpl
    public final void b(Bitmap r100, Bitmap r101) {
        this.f454073c.copyFrom(r100);
        this.f454072b.setInput(this.f454073c);
        this.f454072b.forEach(this.f454074d);
        this.f454074d.copyTo(r101);
    }

    @Override // com.ss.android.ugc.aweme.search.vision.widget.blur.BlurImpl
    public final boolean a(Context r100, Bitmap r101, float r102) {
        boolean r103 = true;
        if (this.f454071a == null) goto L25;
    L23:
        this.f454072b.setRadius(r102);
        Allocation r104 = Allocation.createFromBitmap(this.f454071a, r101, Allocation.MipmapControl.MIPMAP_NONE, 1);
        this.f454073c = r104;
        this.f454074d = Allocation.createTyped(this.f454071a, r104.getType());
        return true;
    L25:
        RenderScript r105 = RenderScript.create(r100);     // Catch: RSRuntimeException -> L6
        this.f454071a = r105;     // Catch: RSRuntimeException -> L6
        this.f454072b = ScriptIntrinsicBlur.create(r105, Element.U8_4(r105));     // Catch: RSRuntimeException -> L6
    L6:
        e = move-exception;
        if (f454070e != null) goto L16;
        if (r100 == null) goto L16;
        if ((r100.getApplicationInfo().flags & 2) == 0) goto L13;
        boolean r106 = true;
    L14:
        f454070e = Boolean.valueOf(r106);
        goto L16
    L13:
        r106 = false;
    L16:
        if (f454070e == Boolean.TRUE) goto L19;
        r103 = false;
    L19:
        if (r103 == true) goto L22;
        release();
        return false;
    L22:
        throw e;
    }
}
