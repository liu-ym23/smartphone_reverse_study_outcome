package com.bytedance.android.livesdk.livecommerce.intro.card.widget.bg;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Shader;
import android.util.AttributeSet;
import com.bytedance.android.ec.core.utils.q;
import com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u000f\n\u0002\u0010\u0015\n\u0002\b\u0005\n\u0002\u0010\u0014\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u001f\u001a\u00020\u001e\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010 \u0012\b\b\u0002\u0010#\u001a\u00020\"¢\u0006\u0004\b$\u0010%R$\u0010\b\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00028\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R$\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00028\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b\t\u0010\u0005\u001a\u0004\b\n\u0010\u0007R$\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00028\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b\f\u0010\u0005\u001a\u0004\b\r\u0010\u0007R$\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00028\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b\u000f\u0010\u0005\u001a\u0004\b\u0010\u0010\u0007R$\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0003\u001a\u00020\u00128\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R$\u0010\u001d\u001a\u00020\u00182\u0006\u0010\u0003\u001a\u00020\u00188\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c¨\u0006&"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/intro/card/widget/bg/ECStrokedWaveDraweeView;", "Lcom/bytedance/android/ui/ec/widget/ecdraweeview/ECDraweeView;", "", "<set-?>", "a", "F", "getWaveWidth", "()F", "waveWidth", "b", "getWaveHeight", "waveHeight", "c", "getWaveLeftMargin", "waveLeftMargin", "d", "getStrokeWidth", "strokeWidth", "", "e", "[I", "getBorderColors", "()[I", "borderColors", "", "f", "[F", "getBorderPositions", "()[F", "borderPositions", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECStrokedWaveDraweeView extends ECDraweeView {
    public float a;
    public float b;
    public float c;
    public float d;
    public int[] e;
    public float[] f;
    public final Path g;
    public final Path h;
    public final Paint i;
    public float j;
    public float k;
    public float l;
    public float m;

    public ECStrokedWaveDraweeView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public ECStrokedWaveDraweeView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void j() {
        int r0 = getWidth();
        int r1 = getHeight();
        if (r0 == 0) goto L8;
        if (r1 == 0) goto L9;
        float r2 = r0;
        float r7 = r1;
        f(this.g, r2, r7, 0.0f);
        f(this.h, r2, r7, (this.d / 2.0f) - getDp(Double.valueOf(0.01d)));
        this.i.setStrokeWidth(this.d);
        float r6 = r2 / 2.0f;
        this.i.setShader(new LinearGradient(r6, r7 * 0.15f, r6, r7, this.e, this.f, Shader.TileMode.CLAMP));
        this.j = getTopLeftCornerRadius();
        this.k = getTopRightCornerRadius();
        this.l = getBottomRightCornerRadius();
        this.m = getBottomLeftCornerRadius();
        return;
    L9:
        return;
    }

    public final int[] getBorderColors() {
        return this.e;
    }

    public final float[] getBorderPositions() {
        return this.f;
    }

    public final float getStrokeWidth() {
        return this.d;
    }

    public final float getWaveHeight() {
        return this.b;
    }

    public final float getWaveLeftMargin() {
        return this.c;
    }

    public final float getWaveWidth() {
        return this.a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void draw(Canvas r3) {
        Intrinsics.checkNotNullParameter(r3, "canvas");
        if (this.j == getTopLeftCornerRadius()) goto L5;
    L10:
        j();
    L12:
        if (this.g.isEmpty() == false) goto L15;
        super/*android.widget.ImageView*/.draw(r3);
        return;
    L15:
        r3.save();
        r3.clipPath(this.g);
        super/*android.widget.ImageView*/.draw(r3);
        r3.restore();
        if (this.h.isEmpty() == true) goto L19;
        r3.drawPath(this.h, this.i);
        return;
    L19:
        return;
    L5:
        if (this.k != getTopRightCornerRadius()) goto L10;
        if (this.l != getBottomRightCornerRadius()) goto L10;
        if (this.m == getBottomLeftCornerRadius()) goto L12;
        goto L10
    }

    public ECStrokedWaveDraweeView(Context r5, AttributeSet r6, int r7) {
        Intrinsics.checkNotNullParameter(r5, "context");
        super(r5, r6, r7);
        this.c = -1.0f;
        this.d = q.a(Float.valueOf(0.75f));
        this.e = new int[]{Color.argb(38, 255, 255, 255), Color.argb(15, 255, 141, 230), Color.argb(61, 255, 141, 173)};
        this.f = new float[]{0.0f, 0.745f, 1.0f};
        this.g = new Path();
        this.h = new Path();
        Paint r8 = new Paint(1);
        r8.setStyle(Paint.Style.STROKE);
        Unit r9 = Unit.INSTANCE;
        this.i = r8;
        this.j = Float.NaN;
        this.k = Float.NaN;
        this.l = Float.NaN;
        this.m = Float.NaN;
    }

    public /* synthetic */ ECStrokedWaveDraweeView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }

    /* JADX WARN: Type inference failed for: r10v1, types: [com.bytedance.android.livesdk.livecommerce.intro.card.widget.bg.ECStrokedWaveDraweeView$appendWaveNotch$1] */
    /* JADX WARN: Type inference failed for: r11v2, types: [com.bytedance.android.livesdk.livecommerce.intro.card.widget.bg.ECStrokedWaveDraweeView$appendWaveNotch$2] */
    public final void f(Path r19, float r20, float r21, float r22) {
        r19.reset();
        float r1 = RangesKt.coerceAtLeast(getTopLeftCornerRadius(), 0.0f);
        float r11 = RangesKt.coerceAtLeast(getTopRightCornerRadius(), 0.0f);
        float r12 = RangesKt.coerceAtLeast(getBottomRightCornerRadius(), 0.0f);
        float r13 = RangesKt.coerceAtLeast(getBottomLeftCornerRadius(), 0.0f);
        float r14 = r20 - r22;
        final float r15 = (r21 - this.b) - r22;
        if ((r14 - r22) > Math.max(r1 + r11, r13 + r12)) goto L5;
        return;
    L5:
        if ((r15 - r22) <= Math.max(r1 + r13, r11 + r12)) goto L28;
        float r6 = r22 + r1;
        r19.moveTo(r22, r6);
        float r4 = r22 + (r1 * 0.448f);
        r19.cubicTo(r22, r4, r4, r22, r6, r22);
        r19.lineTo(r14 - r11, r22);
        float r2 = r11 * 0.448f;
        r19.cubicTo(r14 - r2, r22, r14, r22 + r2, r14, r22 + r11);
        r19.lineTo(r14, r15 - r12);
        float r3 = r12 * 0.448f;
        float r16 = r14 - r12;
        r19.cubicTo(r14, r15 - r3, r14 - r3, r15, r16, r15);
        float r5 = this.a;
        if (r5 > 0.0f) goto L10;
    L25:
        r19.lineTo(r22 + r13, r15);
        float r17 = 0.448f * r13;
        r19.cubicTo(r22 + r17, r15, r22, r15 - r17, r22, r15 - r13);
        r19.close();
        return;
    L10:
        if (this.b <= 0.0f) goto L25;
        float r7 = RangesKt.coerceAtLeast((r20 - r12) - r5, r13);
        float r8 = this.c;
        if (r8 >= 0.0f) goto L14;
        float r9 = (r20 - this.a) / 2.0f;
    L15:
        final float r18 = RangesKt.coerceAtLeast(r9 + r22, r22 + r13);
        float r10 = RangesKt.coerceAtMost((r9 + this.a) - r22, r16);
        float r23 = RangesKt.coerceAtLeast(this.b - r22, 0.0f);
        if (r10 <= r18) goto L25;
        if (r23 <= 0.0f) goto L25;
        r19.lineTo(r10, r15);
        float r24 = r10 - r18;
        if (r24 <= 0.0f) goto L25;
        if (r23 <= 0.0f) goto L25;
        final float r25 = r24 / 30.0f;
        ?? r110 = new ECStrokedWaveDraweeView$appendWaveNotch$1(r18, r25);
        ?? r111 = new ECStrokedWaveDraweeView$appendWaveNotch$2(r15, r25);
        r19.cubicTo(r110.invoke(28.0271f), r111.invoke(0.5f), r110.invoke(26.0813f), r111.invoke(0.959339f), r110.invoke(24.3167f), r111.invoke(1.84164f));
        r19.lineTo(r110.invoke(17.6833f), r111.invoke(5.15836f));
        r19.cubicTo(r110.invoke(15.9941f), r111.invoke(6.00294f), r110.invoke(14.0059f), r111.invoke(6.00294f), r110.invoke(12.3167f), r111.invoke(5.15836f));
        r19.lineTo(r110.invoke(5.68328f), r111.invoke(1.84164f));
        r19.cubicTo(r110.invoke(3.91868f), r111.invoke(0.959339f), r110.invoke(1.97289f), r111.invoke(0.5f), r18, r15);
        goto L25
    L14:
        r9 = RangesKt.coerceIn(r8, r13, r7);
        goto L15
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onSizeChanged(int r1, int r2, int r3, int r4) {
        super/*android.widget.ImageView*/.onSizeChanged(r1, r2, r3, r4);
        j();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void k(ECStrokedWaveDraweeView r1, float r2, int[] r3, float[] r4, int r5) {
        if ((r5 & 1) == 0) goto L6;
        r2 = r1.d;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r3 = r1.e;
    L9:
        if ((r5 & 4) == 0) goto L11;
        r4 = r1.f;
    L11:
        r1.getClass();
        Intrinsics.checkNotNullParameter(r3, "borderColors");
        Intrinsics.checkNotNullParameter(r4, "borderPositions");
        r1.d = r2;
        if (r3.length == r4.length) goto L14;
    L16:
        r1.j();
        r1.invalidate();
        return;
    L14:
        if (r3.length < 2) goto L16;
        r1.e = r3;
        r1.f = r4;
        goto L16
    }
}
