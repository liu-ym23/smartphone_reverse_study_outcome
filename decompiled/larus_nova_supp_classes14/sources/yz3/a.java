package yz3;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.view.View;
import com.bytedance.awemeopen.infra.util.e;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class a extends View {
    public final Paint a;
    public final Paint b;
    public final float c;
    public int d;
    public int e;
    public float f;
    public float g;
    public float h;
    public final int i;
    public int j;
    public final float k;
    public final float l;

    public a(Context r11) {
        Intrinsics.checkNotNullParameter(r11, "context");
        new LinkedHashMap();
        super(r11);
        Paint r0 = new Paint();
        r0.setShader(new LinearGradient(0.0f, 0.0f, 100.0f, 100.0f, ColorProtector.parseColor("#FF1764"), ColorProtector.parseColor("#ED3495"), Shader.TileMode.MIRROR));
        r0.setAntiAlias(true);
        r0.setDither(true);
        r0.setStyle(Paint.Style.STROKE);
        r0.setStrokeWidth(e.a(getContext(), 1.5f));
        this.a = r0;
        this.b = new Paint(r0);
        this.c = e.a(r11, 1.2f);
        this.i = 255;
        this.k = 1.08f;
        this.l = 1.2f;
    }

    @Override // android.view.View
    public final void onDraw(Canvas r5) {
        Intrinsics.checkNotNullParameter(r5, "canvas");
        super.onDraw(r5);
        r5.drawCircle(this.d, this.e, this.f, this.a);
        r5.drawCircle(this.d, this.e, this.g, this.b);
    }

    public final void setFractionWithAlpha(float r10) {
        float r0 = (this.f + (this.j * r10)) * this.k;
        float r2 = 1;
        float r1 = (this.c * (r2 - r10)) * this.l;
        if (Math.abs(r0 - this.g) >= 0.5f) goto L8;
        if (Math.abs(this.h - r1) >= 0.5f) goto L8;
        return;
    L8:
        if (r10 < 0.5d) goto L11;
        r10 = Math.abs(r10 - r2);
    L11:
        this.g = r0;
        this.a.setAlpha((int) (((double) this.i) * (((double) r10) + 0.5d)));
        this.h = r1;
        this.b.setAlpha((int) (this.i * r10));
        this.b.setStrokeWidth(r1);
        postInvalidate();
    }

    @Override // android.view.View
    public final void onMeasure(int r1, int r2) {
        super.onMeasure(r1, r2);
        this.d = getMeasuredWidth() / 2;
        this.e = getMeasuredHeight() / 2;
        float r3 = (getMeasuredHeight() / 2) - getPaddingBottom();
        this.f = r3;
        this.g = r3;
        this.j = getPaddingBottom();
    }
}
