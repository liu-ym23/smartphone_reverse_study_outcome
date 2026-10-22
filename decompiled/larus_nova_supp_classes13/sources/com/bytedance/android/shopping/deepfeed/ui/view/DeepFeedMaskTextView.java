package com.bytedance.android.shopping.deepfeed.ui.view;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.util.TypedValue;
import androidx.appcompat.widget.AppCompatTextView;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0013\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\u000e\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bJ\u000e\u0010\u000b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bJ\u000e\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\fJ\u000e\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\f¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/shopping/deepfeed/ui/view/DeepFeedMaskTextView;", "Landroidx/appcompat/widget/AppCompatTextView;", "", "color", "", "setTextColor", "Landroid/content/res/ColorStateList;", "colors", "", "enabled", "setMaskEnabled", "setArrowEnabled", "", "lengthPx", "setMaskLengthPx", "lengthDp", "setMaskLengthDp", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class DeepFeedMaskTextView extends AppCompatTextView {
    public boolean a;
    public boolean b;
    public float c;
    public LinearGradient d;
    public float e;
    public int f;
    public final Paint g;
    public int h;
    public int i;
    public int j;
    public int k;

    public DeepFeedMaskTextView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public DeepFeedMaskTextView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void y() {
        this.d = null;
        this.e = -1.0f;
        this.f = 0;
        invalidate();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void x() {
        int r0 = this.h;
        int r1 = this.i;
        int r2 = this.j;
        if (this.b == true) goto L5;
        int r3 = 0;
    L6:
        super/*android.widget.TextView*/.setPadding(r0, r1, r2 + r3, this.k);
        return;
    L5:
        Resources r4 = getResources();
        float r5 = TypedValue.applyDimension(1, 12.0f, WindowDisplayMetricsOverride.apply(r4, r4.getDisplayMetrics()));
        Resources r6 = getResources();
        r3 = (int) (r5 + TypedValue.applyDimension(1, 6.0f, WindowDisplayMetricsOverride.apply(r6, r6.getDisplayMetrics())));
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onDraw(Canvas r18) {
        Intrinsics.checkNotNullParameter(r18, "canvas");
        float r1 = RangesKt.coerceAtLeast((getWidth() - getPaddingLeft()) - getPaddingRight(), 0.0f);
        int r3 = getCurrentTextColor();
        if (this.a == true) goto L5;
    L17:
        this.d = null;
    L18:
        Shader r2 = getPaint().getShader();
        if (this.a == true) goto L21;
    L23:
        super/*android.widget.TextView*/.onDraw(r18);
        getPaint().setShader(r2);
        if (this.b == true) goto L26;
        return;
    L26:
        if (getWidth() > 0) goto L28;
        return;
    L28:
        if (getHeight() <= 0) goto L34;
        Resources r4 = getResources();
        float r5 = TypedValue.applyDimension(1, 12.0f, WindowDisplayMetricsOverride.apply(r4, r4.getDisplayMetrics()));
        float r9 = getWidth() - this.j;
        float r10 = r9 - r5;
        float r11 = getHeight() / 2.0f;
        float r6 = r5 / 2.0f;
        this.g.setColor(getCurrentTextColor());
        Paint r7 = this.g;
        Resources r8 = getResources();
        r7.setStrokeWidth(TypedValue.applyDimension(1, 1.5f, WindowDisplayMetricsOverride.apply(r8, r8.getDisplayMetrics())));
        r18.drawLine(r10, r11 - r6, r9, r11, this.g);
        r18.drawLine(r10, r11 + r6, r9, r11, this.g);
        return;
    L34:
        return;
    L21:
        if (this.d == null) goto L23;
        getPaint().setShader(this.d);
        goto L23
    L5:
        if (r1 <= 0.0f) goto L17;
        if (this.c <= 0.0f) goto L17;
        if (this.d != null) goto L12;
    L16:
        this.d = new LinearGradient(getPaddingLeft(), 0.0f, getWidth() - getPaddingRight(), 0.0f, new int[]{r3, r3, Color.argb(0, Color.red(r3), Color.green(r3), Color.blue(r3))}, new float[]{0.0f, RangesKt.coerceIn((r1 - RangesKt.coerceAtMost(this.c, r1)) / r1, 0.0f, 1.0f), 1.0f}, Shader.TileMode.CLAMP);
        this.e = r1;
        this.f = r3;
        goto L18
    L12:
        if (this.e != r1) goto L16;
        if (this.f != r3) goto L16;
        goto L16
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void setArrowEnabled(boolean r2) {
        if (this.b != r2) goto L5;
        return;
    L5:
        this.b = r2;
        x();
        y();
        requestLayout();
    }

    public final void setMaskEnabled(boolean r2) {
        if (this.a != r2) goto L5;
        return;
    L5:
        this.a = r2;
        y();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void setMaskLengthDp(float r3) {
        Resources r0 = getResources();
        setMaskLengthPx(TypedValue.applyDimension(1, r3, WindowDisplayMetricsOverride.apply(r0, r0.getDisplayMetrics())));
    }

    public final void setMaskLengthPx(float r2) {
        float r3 = RangesKt.coerceAtLeast(r2, 0.0f);
        if (this.c != r3) goto L5;
        return;
    L5:
        this.c = r3;
        y();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setTextColor(int r1) {
        super/*android.widget.TextView*/.setTextColor(r1);
        y();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setTextColor(ColorStateList r1) {
        super/*android.widget.TextView*/.setTextColor(r1);
        y();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public DeepFeedMaskTextView(Context r4, AttributeSet r5, int r6) {
        Intrinsics.checkNotNullParameter(r4, "context");
        super(r4, r5, r6);
        Resources r7 = getResources();
        this.c = TypedValue.applyDimension(1, 48.0f, WindowDisplayMetricsOverride.apply(r7, r7.getDisplayMetrics()));
        this.e = -1.0f;
        Paint r8 = new Paint(1);
        r8.setStyle(Paint.Style.STROKE);
        r8.setStrokeCap(Paint.Cap.ROUND);
        r8.setStrokeJoin(Paint.Join.ROUND);
        Unit r2 = Unit.INSTANCE;
        this.g = r8;
        this.h = getPaddingLeft();
        this.i = getPaddingTop();
        this.j = getPaddingRight();
        this.k = getPaddingBottom();
        TypedArray r9 = r4.obtainStyledAttributes(r5, new int[]{2130969913, 2130969914});
        this.a = r9.getBoolean(0, false);
        Resources r10 = getResources();
        this.c = r9.getDimension(1, TypedValue.applyDimension(1, 48.0f, WindowDisplayMetricsOverride.apply(r10, r10.getDisplayMetrics())));
        r9.recycle();
    }

    public /* synthetic */ DeepFeedMaskTextView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }

    public final void setPadding(int r1, int r2, int r3, int r4) {
        this.h = r1;
        this.i = r2;
        this.j = r3;
        this.k = r4;
        x();
    }
}
