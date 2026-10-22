package com.bytedance.ee.bear.slides.toolbar.factory.picker.colorpicker;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;
import com.bytedance.ee.bear.slides.toolbar.factory.picker.colorpicker.model.ColorValueItem;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u000eJ\u0010\u0010\u001b\u001a\u00020\u00102\b\b\u0001\u0010\u001c\u001a\u00020\u0007J\u0010\u0010\u001b\u001a\u00020\u00102\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eJ\u000e\u0010!\u001a\u00020\u00102\u0006\u0010\u001f\u001a\u00020 J\b\u0010\"\u001a\u00020\u0010H\u0002J$\u0010#\u001a\u00020\u00102\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00070%2\f\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00160%H\u0002J$\u0010'\u001a\u00020\u00102\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00070%2\f\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00160%H\u0002J\u0018\u0010(\u001a\u00020\u00102\u0006\u0010)\u001a\u00020\u00072\u0006\u0010*\u001a\u00020\u0007H\u0014J(\u0010+\u001a\u00020\u00102\u0006\u0010,\u001a\u00020\u00072\u0006\u0010-\u001a\u00020\u00072\u0006\u0010.\u001a\u00020\u00072\u0006\u0010/\u001a\u00020\u0007H\u0014J\u0010\u00100\u001a\u00020\u00102\u0006\u00101\u001a\u000202H\u0014R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0019\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u001aR\u0010\u0010\u001f\u001a\u0004\u0018\u00010 X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00063"}, d2 = {"Lcom/bytedance/ee/bear/slides/toolbar/factory/picker/colorpicker/CircleColorView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "paint", "Landroid/graphics/Paint;", "boardPaint", "showBoard", "", "setBoard", "", "isShow", "currentColor", "gradient", "Landroid/graphics/Shader;", "gradientAlpha", "", "gradientBaseColorString", "", "gradientOffset", "Ljava/lang/Float;", "setColor", "color", "colorValue", "Lcom/bytedance/ee/bear/slides/toolbar/factory/picker/colorpicker/model/ColorValueItem;", "gradientDetail", "Lcom/bytedance/ee/bear/slides/toolbar/factory/picker/colorpicker/GradientDetail;", "setGradientColor", "updateGradient", "createRadialGradient", "colors", "", "positions", "updateMultiColorGradient", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "onSizeChanged", "w", "h", "oldw", "oldh", "onDraw", "canvas", "Landroid/graphics/Canvas;", "docs-slide_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CircleColorView extends View {
    public final Paint a;
    public final Paint b;
    public boolean c;
    public e d;

    public CircleColorView(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public CircleColorView(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    public final void a() {
        e r1 = this.d;
        float[] r2 = null;
        if (r1 == null) goto L5;
        List<d> r3 = r1.c;
    L6:
        List<d> r4 = r3;
        if (r4 != null) goto L9;
    L12:
        boolean r5 = true;
    L13:
        if (r5 == false) goto L15;
        return;
    L15:
        if (getWidth() > 0) goto L17;
        return;
    L17:
        if (getHeight() <= 0) goto L72;
        ArrayList r6 = new ArrayList();
        ArrayList r7 = new ArrayList();
        e r8 = this.d;
        if (r8 == null) goto L31;
        List<d> r9 = r8.c;
        if (r9 == null) goto L31;
        Iterator<T> r10 = r9.iterator();
    L25:
        if (r10.hasNext() == false) goto L31;
        d r11 = (d) r10.next();
        int r12 = Color.parseColor(r11.b);     // Catch: IllegalArgumentException -> L29
        r6.add(Integer.valueOf(Color.argb((int) (r11.a * 255), Color.red(r12), Color.green(r12), Color.blue(r12))));     // Catch: IllegalArgumentException -> L29
        r7.add(Float.valueOf(r11.c));     // Catch: IllegalArgumentException -> L29
    L31:
        if (r6.size() < 2) goto L70;
        e r13 = this.d;
        if (r13 == null) goto L35;
        String r14 = r13.b;
    L37:
        if (Intrinsics.areEqual(r14, "linear") == false) goto L46;
        e r15 = this.d;
        if (r15 == null) goto L41;
        double r16 = r15.a;
    L42:
        float r17 = (float) Math.toRadians(r16);
        float r18 = getWidth() / 2.0f;
        float r19 = getHeight() / 2.0f;
        float r20 = Math.max(getWidth(), getHeight()) / 2.0f;
        double r21 = r17;
        float r110 = r18 - (((float) Math.cos(r21)) * r20);
        float r111 = r19 - (((float) Math.sin(r21)) * r20);
        float r112 = r18 + (((float) Math.cos(r21)) * r20);
        float r113 = r19 + (((float) Math.sin(r21)) * r20);
        int[] r114 = CollectionsKt.toIntArray(r6);
        if (r7.size() != r6.size()) goto L45;
        r2 = CollectionsKt.toFloatArray(r7);
    L45:
        this.a.setShader(new LinearGradient(r110, r111, r112, r113, r114, r2, Shader.TileMode.CLAMP));
        return;
    L41:
        r16 = 0.0d;
        goto L42
    L46:
        float r22 = getWidth();
        e r23 = this.d;
        float r24 = 0.5f;
        if (r23 == null) goto L49;
        float r25 = r23.d;
    L50:
        float r26 = r22 * r25;
        float r27 = getHeight();
        e r28 = this.d;
        if (r28 == null) goto L53;
        r24 = r28.e;
    L53:
        float r115 = r27 * r24;
        float r29 = RangesKt.coerceAtMost(getWidth(), getHeight()) / 2.0f;
        e r30 = this.d;
        if (r30 == null) goto L56;
        float r31 = r30.f;
    L57:
        float r116 = r29 * r31;
        int[] r117 = CollectionsKt.toIntArray(r6);
        if (r7.size() != r6.size()) goto L60;
        r2 = CollectionsKt.toFloatArray(r7);
    L60:
        this.a.setShader(new RadialGradient(r26, r115, r116, r117, r2, Shader.TileMode.CLAMP));
        return;
    L56:
        r31 = 1.0f;
        goto L57
    L49:
        r25 = 0.5f;
        goto L50
    L35:
        r14 = null;
        goto L37
    L70:
        return;
    L72:
        return;
    L9:
        if (r4.isEmpty() == true) goto L12;
        r5 = false;
        goto L13
    L5:
        r3 = null;
        goto L6
    }

    @Override // android.view.View
    public final void onDraw(Canvas r6) {
        Intrinsics.checkNotNullParameter(r6, "canvas");
        super.onDraw(r6);
        float r0 = getWidth() / 2.0f;
        float r2 = getHeight() / 2.0f;
        float r3 = RangesKt.coerceAtMost(getWidth(), getHeight()) / 2.0f;
        r6.drawCircle(r0, r2, r3, this.a);
        if (this.c == false) goto L6;
        r6.drawCircle(r0, r2, r3 - (this.b.getStrokeWidth() / 2), this.b);
        return;
    }

    public final void setBoard(boolean r1) {
        this.c = r1;
        invalidate();
    }

    public final void setColor(int r2) {
        this.a.setColor(r2);
        this.a.setShader(null);
        invalidate();
    }

    public final void setGradientColor(e r2) {
        Intrinsics.checkNotNullParameter(r2, "gradientDetail");
        this.d = r2;
        a();
        invalidate();
    }

    public final void setColor(ColorValueItem r2) {
        c.a.getClass();
        c.a(this, r2);
    }

    @Override // android.view.View
    public final void onMeasure(int r1, int r2) {
        super.onMeasure(r1, r2);
        int r3 = RangesKt.coerceAtMost(getMeasuredWidth(), getMeasuredHeight());
        setMeasuredDimension(r3, r3);
    }

    public CircleColorView(Context r3, AttributeSet r4, int r5) {
        Intrinsics.checkNotNullParameter(r3, "context");
        super(r3, r4, r5);
        Paint r6 = new Paint(1);
        r6.setAntiAlias(true);
        r6.setStyle(Paint.Style.FILL);
        this.a = r6;
        Paint r7 = new Paint(1);
        r7.setAntiAlias(true);
        r7.setStyle(Paint.Style.STROKE);
        r7.setColor(r3.getResources().getColor(2131106275));
        r7.setStrokeWidth(j08.b.a(r3, 1.5f));
        r7.setFilterBitmap(true);
        this.b = r7;
    }

    public /* synthetic */ CircleColorView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }

    @Override // android.view.View
    public final void onSizeChanged(int r1, int r2, int r3, int r4) {
        super.onSizeChanged(r1, r2, r3, r4);
        if (this.d == null) goto L8;
        if (r1 <= 0) goto L9;
        if (r2 <= 0) goto L10;
        a();
        return;
    L10:
        return;
    L9:
        return;
    }
}
