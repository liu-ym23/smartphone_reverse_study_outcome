package com.ss.android.lark.widget.span;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.larus.nova.R;
import com.ss.android.lark.utils.UIHelper;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class k0 extends Drawable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final BitmapDrawable f448700a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f448701b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f448702c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final RectF f448703d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final BorderProperty f448704e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Paint f448705f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Paint f448706g;

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int r100) {
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter r100) {
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicHeight() {
        return this.f448700a.getIntrinsicHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicWidth() {
        return this.f448700a.getIntrinsicWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas r110) {
        Intrinsics.checkNotNullParameter(r110, "canvas");
        r110.drawRoundRect(0.0f, 0.0f, this.f448701b, this.f448702c, this.f448704e.getBorderRadiusPx(), this.f448704e.getBorderRadiusPx(), this.f448706g);
        this.f448703d.set(0.0f, 0.0f, this.f448701b, this.f448702c);
        r110.drawBitmap(this.f448700a.getBitmap(), null, this.f448703d, this.f448705f);
    }

    public k0(BitmapDrawable r100, int r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "srcDrawable");
        this.f448700a = r100;
        this.f448701b = r101;
        this.f448702c = r102;
        this.f448703d = new RectF();
        this.f448704e = new BorderProperty(UIHelper.getColor(R.color.transparent), 0, 0);
        this.f448705f = new Paint(2);
        Paint r103 = new Paint();
        r103.setColor(UIHelper.getColor(R.color.bg_body));
        r103.setStyle(Paint.Style.FILL);
        this.f448706g = r103;
    }
}
