package com.ss.android.lark.chat.preview.components.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.TypedValue;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class g extends Drawable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Drawable f416201a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f416202b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Paint f416203c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float f416204d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final float f416205e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final GradientDrawable f416206f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final float f416207g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f416208h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f416209i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f416210j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int f416211k;

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        this.f416206f.setBounds(getBounds());
        this.f416206f.draw(r100);
        Drawable r101 = this.f416201a;
        if (r101 == null) goto L5;
        r101.setBounds(this.f416208h, this.f416209i, this.f416210j, this.f416211k);
        this.f416201a.draw(r100);
    L5:
        r100.drawText(this.f416202b, (this.f416204d / 2) + this.f416207g, getBounds().exactCenterY() + this.f416205e, this.f416203c);
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int r100) {
        this.f416203c.setAlpha(r100);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter r100) {
        this.f416203c.setColorFilter(r100);
        invalidateSelf();
    }

    public static float a(Context r100, float r101) {
        Resources r102 = r100.getResources();
        return TypedValue.applyDimension(1, r101, WindowDisplayMetricsOverride.apply(r102, r102.getDisplayMetrics()));
    }

    public g(Context r100, String r101, int r102, int r103, int r104, float r105, int r106) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "text");
        this.f416201a = null;
        this.f416202b = r101;
        Paint r107 = new Paint(1);
        r107.setColor(r103);
        r107.setTextSize(r105);
        r107.setTextAlign(Paint.Align.CENTER);
        this.f416203c = r107;
        float r108 = r107.measureText(r101);
        this.f416204d = r108;
        this.f416205e = (((r107.getFontMetrics().bottom - r107.getFontMetrics().top) / 2) - r107.getFontMetrics().bottom) - a(r100, 0.0f);
        GradientDrawable r109 = new GradientDrawable();
        r109.setColor(r102);
        r109.setCornerRadius(a(r100, 2));
        this.f416206f = r109;
        float r110 = r104;
        this.f416207g = a(r100, 4.0f) + a(r100, r110);
        this.f416208h = (int) a(r100, r110 + 4.0f);
        this.f416209i = (int) a(r100, 0.0f);
        float r111 = 12;
        this.f416210j = (int) a(r100, (4.0f + r111) + r110);
        this.f416211k = (int) a(r100, 0.0f + r111);
        setBounds(new Rect((int) a(r100, r110), 0, ((int) (a(r100, 8.0f) + r108)) + ((int) a(r100, r110)), (int) a(r100, r106)));
    }
}
