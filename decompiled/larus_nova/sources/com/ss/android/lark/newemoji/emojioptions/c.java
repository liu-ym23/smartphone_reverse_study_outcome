package com.ss.android.lark.newemoji.emojioptions;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;
import androidx.core.content.ContextCompat;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: classes36.dex */
public final class c extends Drawable implements i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f433000a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Paint f433001b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Paint f433002c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f433003d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f433004e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f433005f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f433006g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f433007h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f433008i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public float f433009j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f433010k;

    public static final class a {
    }

    static {
    }

    public final Path b() {
        float r100 = 2;
        float r101 = this.f433004e / r100;
        float r102 = d();
        RectF r103 = new RectF(getBounds().left + r101, (getBounds().top + this.f433006g) + r101, getBounds().right - r101, getBounds().bottom - r101);
        Path r104 = new Path();
        float r105 = this.f433003d;
        r104.addRoundRect(r103, r105, r105, Path.Direction.CCW);
        Path r106 = new Path();
        float r107 = r102 + r101;
        r106.moveTo(r107, r103.top);
        r106.lineTo((this.f433005f + r102) - r101, r103.top);
        r106.lineTo(r102 + (this.f433005f / r100), (r103.top - this.f433006g) - r101);
        r106.lineTo(r107, r103.top);
        r104.op(r106, Path.Op.UNION);
        return r104;
    }

    public final Path c() {
        float r100 = 2;
        float r101 = this.f433004e / r100;
        float r102 = d();
        RectF r103 = new RectF(getBounds().left + r101, getBounds().top + r101, getBounds().right - r101, (getBounds().bottom - this.f433006g) - r101);
        Path r104 = new Path();
        float r105 = this.f433003d;
        r104.addRoundRect(r103, r105, r105, Path.Direction.CCW);
        Path r106 = new Path();
        float r107 = r102 + r101;
        r106.moveTo(r107, r103.bottom);
        r106.lineTo((this.f433005f + r102) - r101, r103.bottom);
        r106.lineTo(r102 + (this.f433005f / r100), (r103.bottom + this.f433006g) + r101);
        r106.lineTo(r107, r103.bottom);
        r104.op(r106, Path.Op.UNION);
        return r104;
    }

    public final float d() {
        int r100 = getBounds().left + MathKt.roundToInt(i.a.a(this, 7));
        int r101 = getBounds().right - MathKt.roundToInt(i.a.a(this, 7));
        float r102 = this.f433009j;
        float r103 = r100;
        if (r102 < r103) goto L8;
        if (r102 > r101) goto L8;
        return r102;
    L8:
        return Math.min(Math.max(r103, r102), r101);
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        if (getAlpha() != 255) goto L5;
        return -1;
    L5:
        return -3;
    }

    @Override // com.ss.android.lark.newemoji.emojioptions.i
    public final Context a() {
        return this.f433000a;
    }

    public c(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f433000a = r100;
        Paint r101 = new Paint();
        r101.setStyle(Paint.Style.FILL);
        r101.setAntiAlias(true);
        this.f433001b = r101;
        Paint r102 = new Paint();
        r102.setStyle(Paint.Style.STROKE);
        r102.setAntiAlias(true);
        this.f433002c = r102;
        this.f433003d = i.a.a(this, 8);
        Resources r103 = r100.getResources();
        this.f433004e = TypedValue.applyDimension(1, 0.5f, WindowDisplayMetricsOverride.apply(r103, r103.getDisplayMetrics()));
        this.f433005f = i.a.a(this, 14);
        this.f433006g = i.a.a(this, 7);
        this.f433007h = ContextCompat.getColor(a(), R.color.line_border_card);
        this.f433008i = ContextCompat.getColor(a(), R.color.bg_float);
        this.f433010k = 80;
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        this.f433001b.setColor(this.f433008i);
        this.f433002c.setColor(this.f433007h);
        this.f433002c.setStrokeWidth(this.f433004e);
        if (this.f433010k != 48) goto L5;
        Path r101 = c();
    L7:
        if (this.f433010k != 48) goto L9;
        Path r102 = c();
    L10:
        r100.drawPath(r101, this.f433001b);
        r100.drawPath(r102, this.f433002c);
        return;
    L9:
        r102 = b();
        goto L10
    L5:
        r101 = b();
        goto L7
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int r100) {
        this.f433001b.setAlpha(r100);
        this.f433002c.setAlpha(r100);
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter r100) {
        this.f433001b.setColorFilter(r100);
        this.f433002c.setAlpha(getAlpha());
    }
}
