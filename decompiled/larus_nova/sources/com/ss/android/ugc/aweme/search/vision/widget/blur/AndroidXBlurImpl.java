package com.ss.android.ugc.aweme.search.vision.widget.blur;

import android.content.Context;
import android.graphics.Bitmap;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RSRuntimeException;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;

/* JADX INFO: loaded from: classes40.dex */
public class AndroidXBlurImpl implements BlurImpl {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static Boolean f454075e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public RenderScript f454076a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ScriptIntrinsicBlur f454077b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Allocation f454078c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Allocation f454079d;

    public AndroidXBlurImpl() {
    }

    @Override // com.ss.android.ugc.aweme.search.vision.widget.blur.BlurImpl
    public final void release() {
        Allocation r100 = this.f454078c;
        if (r100 == null) goto L5;
        r100.destroy();
        this.f454078c = null;
    L5:
        Allocation r101 = this.f454079d;
        if (r101 == null) goto L8;
        r101.destroy();
        this.f454079d = null;
    L8:
        ScriptIntrinsicBlur r102 = this.f454077b;
        if (r102 == null) goto L11;
        r102.destroy();
        this.f454077b = null;
    L11:
        RenderScript r103 = this.f454076a;
        if (r103 == null) goto L15;
        r103.destroy();
        this.f454076a = null;
        return;
    }

    @Override // com.ss.android.ugc.aweme.search.vision.widget.blur.BlurImpl
    public final void b(Bitmap r100, Bitmap r101) {
        this.f454078c.copyFrom(r100);
        this.f454077b.setInput(this.f454078c);
        this.f454077b.forEach(this.f454079d);
        this.f454079d.copyTo(r101);
    }

    @Override // com.ss.android.ugc.aweme.search.vision.widget.blur.BlurImpl
    public final boolean a(Context r100, Bitmap r101, float r102) {
        boolean r103 = true;
        if (this.f454076a == null) goto L25;
    L23:
        this.f454077b.setRadius(r102);
        Allocation r104 = Allocation.createFromBitmap(this.f454076a, r101, Allocation.MipmapControl.MIPMAP_NONE, 1);
        this.f454078c = r104;
        this.f454079d = Allocation.createTyped(this.f454076a, r104.getType());
        return true;
    L25:
        RenderScript r105 = RenderScript.create(r100);     // Catch: RSRuntimeException -> L6
        this.f454076a = r105;     // Catch: RSRuntimeException -> L6
        this.f454077b = ScriptIntrinsicBlur.create(r105, Element.U8_4(r105));     // Catch: RSRuntimeException -> L6
    L6:
        e = move-exception;
        if (f454075e != null) goto L16;
        if (r100 == null) goto L16;
        if ((r100.getApplicationInfo().flags & 2) == 0) goto L13;
        boolean r106 = true;
    L14:
        f454075e = Boolean.valueOf(r106);
        goto L16
    L13:
        r106 = false;
    L16:
        if (f454075e == Boolean.TRUE) goto L19;
        r103 = false;
    L19:
        if (r103 == true) goto L22;
        release();
        return false;
    L22:
        throw e;
    }
}
