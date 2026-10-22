package com.ss.android.ugc.aweme.search.vision.widget.blur;

import android.content.Context;
import android.graphics.Bitmap;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RSRuntimeException;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;

/* JADX INFO: loaded from: classes40.dex */
public class SupportLibraryBlurImpl implements BlurImpl {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static Boolean f454099e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public RenderScript f454100a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ScriptIntrinsicBlur f454101b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Allocation f454102c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Allocation f454103d;

    public SupportLibraryBlurImpl() {
    }

    @Override // com.ss.android.ugc.aweme.search.vision.widget.blur.BlurImpl
    public final void release() {
        Allocation r100 = this.f454102c;
        if (r100 == null) goto L5;
        r100.destroy();
        this.f454102c = null;
    L5:
        Allocation r101 = this.f454103d;
        if (r101 == null) goto L8;
        r101.destroy();
        this.f454103d = null;
    L8:
        ScriptIntrinsicBlur r102 = this.f454101b;
        if (r102 == null) goto L11;
        r102.destroy();
        this.f454101b = null;
    L11:
        RenderScript r103 = this.f454100a;
        if (r103 == null) goto L15;
        r103.destroy();
        this.f454100a = null;
        return;
    }

    @Override // com.ss.android.ugc.aweme.search.vision.widget.blur.BlurImpl
    public final void b(Bitmap r100, Bitmap r101) {
        this.f454102c.copyFrom(r100);
        this.f454101b.setInput(this.f454102c);
        this.f454101b.forEach(this.f454103d);
        this.f454103d.copyTo(r101);
    }

    @Override // com.ss.android.ugc.aweme.search.vision.widget.blur.BlurImpl
    public final boolean a(Context r100, Bitmap r101, float r102) {
        boolean r103 = true;
        if (this.f454100a == null) goto L25;
    L23:
        this.f454101b.setRadius(r102);
        Allocation r104 = Allocation.createFromBitmap(this.f454100a, r101, Allocation.MipmapControl.MIPMAP_NONE, 1);
        this.f454102c = r104;
        this.f454103d = Allocation.createTyped(this.f454100a, r104.getType());
        return true;
    L25:
        RenderScript r105 = RenderScript.create(r100);     // Catch: RSRuntimeException -> L6
        this.f454100a = r105;     // Catch: RSRuntimeException -> L6
        this.f454101b = ScriptIntrinsicBlur.create(r105, Element.U8_4(r105));     // Catch: RSRuntimeException -> L6
    L6:
        e = move-exception;
        if (f454099e != null) goto L16;
        if (r100 == null) goto L16;
        if ((r100.getApplicationInfo().flags & 2) == 0) goto L13;
        boolean r106 = true;
    L14:
        f454099e = Boolean.valueOf(r106);
        goto L16
    L13:
        r106 = false;
    L16:
        if (f454099e == Boolean.TRUE) goto L19;
        r103 = false;
    L19:
        if (r103 == true) goto L22;
        release();
        return false;
    L22:
        throw e;
    }
}
