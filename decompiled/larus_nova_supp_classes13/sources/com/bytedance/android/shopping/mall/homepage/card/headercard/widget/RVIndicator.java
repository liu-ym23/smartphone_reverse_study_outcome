package com.bytedance.android.shopping.mall.homepage.card.headercard.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0015\u001a\u00020\u0014\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0016\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u0002R*\u0010\u000f\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00078\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR*\u0010\u0013\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00078\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\n\u001a\u0004\b\u0011\u0010\f\"\u0004\b\u0012\u0010\u000e¨\u0006\u001b"}, d2 = {"Lcom/bytedance/android/shopping/mall/homepage/card/headercard/widget/RVIndicator;", "Landroid/view/View;", "", "color", "", "setBgColor", "setIndicatorColor", "", "value", "i", "F", "getRatio", "()F", "setRatio", "(F)V", "ratio", "j", "getProgress", "setProgress", "progress", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mall_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class RVIndicator extends View {
    public final Paint a;
    public final RectF b;
    public float c;
    public final Paint d;
    public final RectF e;
    public int f;
    public final int g;
    public long h;
    public float i;
    public float j;

    public RVIndicator(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public RVIndicator(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public final float getProgress() {
        return this.j;
    }

    public final float getRatio() {
        return this.i;
    }

    @Override // android.view.View
    public final void onDraw(Canvas r6) {
        Intrinsics.checkNotNullParameter(r6, "canvas");
        super.onDraw(r6);
        RectF r0 = this.b;
        float r1 = this.c;
        r6.drawRoundRect(r0, r1, r1, this.a);
        int r2 = this.f;
        float r3 = this.i;
        float r4 = (r2 * (1.0f - r3)) * this.j;
        RectF r5 = this.b;
        float r7 = r5.left + r4;
        this.e.set(r7, r5.top, (r2 * r3) + r7, r5.bottom);
        RectF r8 = this.e;
        float r9 = this.c;
        r6.drawRoundRect(r8, r9, r9, this.d);
    }

    public final void setBgColor(int r2) {
        this.a.setColor(r2);
        invalidate();
    }

    public final void setIndicatorColor(int r2) {
        this.d.setColor(r2);
        invalidate();
    }

    public final void setProgress(float r1) {
        this.j = r1;
        invalidate();
    }

    public final void setRatio(float r1) {
        this.i = r1;
        invalidate();
    }

    public RVIndicator(Context r3, AttributeSet r4, int r5) {
        Intrinsics.checkNotNullParameter(r3, "context");
        super(r3, r4, r5);
        Paint r6 = new Paint(1);
        this.a = r6;
        this.b = new RectF();
        Paint r7 = new Paint(1);
        this.d = r7;
        this.e = new RectF();
        int r8 = ColorProtector.parseColor("#1F161823");
        int r0 = ColorProtector.parseColor("#BF161823");
        this.g = 10;
        this.i = 0.4f;
        r6.setColor(r8);
        r6.setStyle(Paint.Style.FILL);
        r7.setColor(r0);
        r7.setStyle(Paint.Style.FILL);
    }

    public /* synthetic */ RVIndicator(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }

    @Override // android.view.View
    public final void onSizeChanged(int r2, int r3, int r4, int r5) {
        super.onSizeChanged(r2, r3, r4, r5);
        this.f = r2;
        float r6 = r3;
        this.b.set(0.0f, 0.0f, r2 * 1.0f, 1.0f * r6);
        this.c = r6 / 2.0f;
    }
}
