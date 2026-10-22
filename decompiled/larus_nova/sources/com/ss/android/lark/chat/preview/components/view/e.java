package com.ss.android.lark.chat.preview.components.view;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BlendModeColorFilter;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuffColorFilter;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.widget.span.BorderProperty;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class e extends BitmapDrawable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final BitmapDrawable f416189a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final BorderProperty f416190b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f416191c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f416192d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final RectF f416193e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final RectF f416194f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final RectF f416195g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Path f416196h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Paint f416197i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f416198j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int f416199k;

    @Override // android.graphics.drawable.BitmapDrawable, android.graphics.drawable.Drawable
    public final void draw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        if (getBitmap().isRecycled() == true) goto L36;
        this.f416193e.set(0.0f, 0.0f, this.f416191c, this.f416192d);
        float r101 = (this.f416198j * 1.0f) / 2;
        this.f416195g.set(this.f416193e);
        this.f416195g.inset(r101, r101);
        this.f416194f.set(this.f416193e);
        RectF r102 = this.f416194f;
        float r103 = this.f416198j;
        r102.inset(r103, r103);
        BitmapDrawable r104 = this.f416189a;
        if ((r104 instanceof BitmapDrawable) == false) goto L34;
        Intrinsics.checkNotNull(r104, "null cannot be cast to non-null type android.graphics.drawable.BitmapDrawable");
        Bitmap r105 = r104.getBitmap();
        if (r105 != null) goto L10;
    L33:
        Log.i("ImageBorderUtils", "bitmap recycled");
        goto L34
    L10:
        if (r105.isRecycled() == true) goto L33;
        if (Build.VERSION.SDK_INT < 29) goto L21;
        Object r106 = com.ss.android.lark.image.utils.e.a(this.f416189a, "mBlendModeFilter");
        if (r106 != null) goto L17;
    L29:
        boolean r107 = false;
    L30:
        this.f416197i.setAntiAlias(true);
        int r108 = r100.getSaveCount();
        r100.save();
        this.f416196h.reset();
        Path r109 = this.f416196h;
        RectF r110 = this.f416194f;
        float r111 = this.f416199k;
        r109.addRoundRect(r110, r111, r111, Path.Direction.CW);
        r100.clipPath(this.f416196h);
        r100.drawBitmap(r105, null, this.f416193e, this.f416189a.getPaint());
        r100.restoreToCount(r108);
        if (r107 == false) goto L34;
        getPaint().setColorFilter(null);
        goto L34
    L17:
        if ((r106 instanceof BlendModeColorFilter) == false) goto L29;
        if (this.f416189a.getPaint().getColorFilter() != null) goto L29;
        this.f416189a.getPaint().setColorFilter((ColorFilter) r106);
    L28:
        r107 = true;
        goto L30
    L21:
        Object r112 = com.ss.android.lark.image.utils.e.a(this.f416189a, "mTintFilter");
        if (r112 == null) goto L29;
        if ((r112 instanceof PorterDuffColorFilter) == false) goto L29;
        if (this.f416189a.getPaint().getColorFilter() != null) goto L29;
        this.f416189a.getPaint().setColorFilter((ColorFilter) r112);
    L34:
        this.f416197i.setAntiAlias(true);
        this.f416197i.setStyle(Paint.Style.STROKE);
        this.f416197i.setColor(this.f416190b.getBorderColor());
        this.f416197i.setStrokeWidth(this.f416190b.getBorderWidthPx());
        this.f416196h.reset();
        Path r113 = this.f416196h;
        RectF r114 = this.f416195g;
        float r115 = this.f416199k;
        r113.addRoundRect(r114, r115, r115, Path.Direction.CW);
        r100.drawPath(this.f416196h, this.f416197i);
        return;
    }

    public e(Resources r100, BitmapDrawable r101, BorderProperty r102, int r103, int r104) {
        Intrinsics.checkNotNullParameter(r100, "res");
        Intrinsics.checkNotNullParameter(r101, "srcDrawable");
        Intrinsics.checkNotNullParameter(r102, "borderProperty");
        super(r100, r101.getBitmap());
        this.f416189a = r101;
        this.f416190b = r102;
        this.f416191c = r103;
        this.f416192d = r104;
        this.f416193e = new RectF();
        this.f416194f = new RectF();
        this.f416195g = new RectF();
        this.f416196h = new Path();
        this.f416197i = new Paint();
        this.f416198j = r102.getBorderWidthPx();
        this.f416199k = r102.getBorderRadiusPx();
    }
}
