package com.ss.android.lark.widget.span;

import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;

/* JADX INFO: loaded from: classes38.dex */
public final class l {
    public static Drawable a(Drawable r100, int r101, int r102, BorderProperty r103) {
        if (r103 != null) goto L8;
        if ((r100 instanceof BitmapDrawable) == true) goto L6;
        return r100;
    L6:
        return new k0((BitmapDrawable) r100, r101, r102);
    L8:
        return new s(r100, r101, r102, r103);
    }
}
