package com.lynx.tasm.behavior.ui.utils;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.RectF;
import com.lynx.tasm.behavior.LynxContext;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes32.dex */
public final class i extends d<a7a.l> {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f383145h;

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter r100) {
    }

    @Override // com.lynx.tasm.behavior.ui.utils.d
    public final a7a.k a() {
        return new a7a.l(this.f383138f, this, this.f383139g);
    }

    @Override // android.graphics.drawable.Drawable
    public final int getAlpha() {
        return this.f383145h;
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas r110) {
        if ((!((ArrayList) ((a7a.l) this.f383137e).f2094a).isEmpty()) == true) goto L5;
        return;
    L5:
        if (getBounds().isEmpty() == true) goto L13;
        RectF r100 = new RectF(getBounds());
        RectF r101 = new RectF(this.f383135c);
        RectF r102 = new RectF(this.f383136d);
        a7a.l r103 = (a7a.l) this.f383137e;
        if (this.f383133a == null) goto L9;
        boolean r111 = true;
    L10:
        r103.a(r110, r100, r101, r102, r100, null, null, r111);
        return;
    L9:
        r111 = false;
        goto L10
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int r100) {
        if (r100 == this.f383145h) goto L6;
        this.f383145h = r100;
        invalidateSelf();
        return;
    }

    public i(LynxContext r100, float r101) {
        super(r100, r101);
        this.f383145h = 255;
    }
}
