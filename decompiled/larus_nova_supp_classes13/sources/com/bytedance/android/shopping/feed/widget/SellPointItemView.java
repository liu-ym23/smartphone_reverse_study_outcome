package com.bytedance.android.shopping.feed.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import androidx.appcompat.widget.AppCompatTextView;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0002¢\u0006\u0004\b\f\u0010\rJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/shopping/feed/widget/SellPointItemView;", "Landroidx/appcompat/widget/AppCompatTextView;", "", "color", "", "setBorderColor", "setBorderAndTextColor", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-biz-inner-flow-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SellPointItemView extends AppCompatTextView {
    public final RectF a;
    public final float b;
    public final Paint c;

    public SellPointItemView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public SellPointItemView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public static DisplayMetrics x(Resources r1) {
        return WindowDisplayMetricsOverride.apply(r1, r1.getDisplayMetrics());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onDraw(Canvas r6) {
        Intrinsics.checkNotNullParameter(r6, "canvas");
        super/*android.widget.TextView*/.onDraw(r6);
        RectF r0 = this.a;
        float r1 = this.b;
        r0.set(r1, r1, getWidth() - this.b, getHeight() - this.b);
        float r2 = 2;
        r6.drawRoundRect(this.a, MathKt.roundToInt(TypedValue.applyDimension(1, r2, x(Resources.getSystem()))), MathKt.roundToInt(TypedValue.applyDimension(1, r2, x(Resources.getSystem()))), this.c);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void setBorderAndTextColor(int r2) {
        this.c.setColor(r2);
        setTextColor(r2);
        invalidate();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void setBorderColor(int r2) {
        this.c.setColor(r2);
        invalidate();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SellPointItemView(Context r4, AttributeSet r5, int r6) {
        Intrinsics.checkNotNullParameter(r4, "context");
        super(r4, r5, r6);
        this.a = new RectF();
        new Path();
        float r7 = 2;
        this.b = MathKt.roundToInt(TypedValue.applyDimension(1, 1, x(Resources.getSystem()))) / r7;
        Paint r8 = new Paint(1);
        r8.setStyle(Paint.Style.STROKE);
        r8.setStrokeWidth(r8.getStrokeWidth());
        r8.setColor(-65536);
        Unit r0 = Unit.INSTANCE;
        this.c = r8;
        float r9 = 4;
        setPadding(MathKt.roundToInt(TypedValue.applyDimension(1, r9, x(Resources.getSystem()))), MathKt.roundToInt(TypedValue.applyDimension(1, r7, x(Resources.getSystem()))), MathKt.roundToInt(TypedValue.applyDimension(1, r9, x(Resources.getSystem()))), MathKt.roundToInt(TypedValue.applyDimension(1, r7, x(Resources.getSystem()))));
        setTextSize(1, 10.0f);
    }

    public /* synthetic */ SellPointItemView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
