package com.ss.android.lark.widget.span;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import com.bytedance.android.livesdkapi.player.resolution.PlayerResolution;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public class k extends Drawable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Drawable f448697a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f448698b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f448699c;

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicHeight() {
        return this.f448697a.getBounds().height();
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicWidth() {
        return (this.f448697a.getBounds().width() + this.f448698b) + this.f448699c;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        return this.f448697a.getOpacity();
    }

    public k(Drawable r100) {
        Intrinsics.checkNotNullParameter(r100, PlayerResolution.SDKKEY.ORIGIN);
        this.f448697a = r100;
    }

    public final void a(int r100) {
        this.f448698b = r100;
        Rect r101 = this.f448697a.getBounds();
        setBounds(0, 0, (r101.width() + this.f448698b) + this.f448699c, r101.height());
    }

    public final void b(int r100) {
        this.f448699c = r100;
        Rect r101 = this.f448697a.getBounds();
        setBounds(0, 0, (r101.width() + this.f448698b) + this.f448699c, r101.height());
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        r100.save();
        r100.translate(this.f448698b, 0.0f);
        this.f448697a.draw(r100);
        r100.restore();
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int r100) {
        this.f448697a.setAlpha(r100);
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter r100) {
        this.f448697a.setColorFilter(r100);
    }
}
