package com.bytedance.android.shopping.mall.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001\u0011B'\b\u0007\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0006¢\u0006\u0004\b\u000f\u0010\u0010J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0010\u0010\b\u001a\u00020\u00042\b\b\u0001\u0010\u0007\u001a\u00020\u0006J\u0010\u0010\t\u001a\u00020\u00042\b\b\u0001\u0010\u0007\u001a\u00020\u0006¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/shopping/mall/widget/GradientCircleBorderView;", "Landroid/view/View;", "", "width", "", "setStrokeWidth", "", "color", "setStartColor", "setEndColor", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyle", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "mall_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class GradientCircleBorderView extends View {
    public final Paint a;
    public float b;
    public float c;
    public float d;
    public int e;
    public int f;

    public static final class a {
    }

    static {
    }

    public GradientCircleBorderView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public GradientCircleBorderView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    @Override // android.view.View
    public final void onDraw(Canvas r5) {
        Intrinsics.checkNotNullParameter(r5, "canvas");
        super.onDraw(r5);
        r5.drawCircle(this.b, this.c, this.d, this.a);
    }

    public final void setEndColor(int r1) {
        this.f = r1;
    }

    public final void setStartColor(int r1) {
        this.e = r1;
    }

    public final void setStrokeWidth(float r2) {
        this.a.setStrokeWidth(r2);
    }

    public GradientCircleBorderView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        Paint r5 = new Paint(1);
        r5.setStyle(Paint.Style.STROKE);
        r5.setStrokeWidth(20.0f);
        Unit r6 = Unit.INSTANCE;
        this.a = r5;
        this.e = -65536;
        this.f = -16776961;
    }

    public /* synthetic */ GradientCircleBorderView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }

    @Override // android.view.View
    public final void onSizeChanged(int r9, int r10, int r11, int r12) {
        super.onSizeChanged(r9, r10, r11, r12);
        this.b = r9 / 2.0f;
        this.c = r10 / 2.0f;
        this.d = (float) ((Math.min(r9, r10) / ((double) 2.0f)) - ((double) (this.a.getStrokeWidth() / 2)));
        this.a.setShader(new LinearGradient(0.0f, 0.0f, 0.0f, getHeight(), new int[]{this.e, this.f}, null, Shader.TileMode.CLAMP));
    }
}
