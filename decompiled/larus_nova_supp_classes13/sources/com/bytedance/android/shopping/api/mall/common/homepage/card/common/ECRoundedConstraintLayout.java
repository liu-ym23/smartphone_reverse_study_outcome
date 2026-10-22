package com.bytedance.android.shopping.api.mall.common.homepage.card.common;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/ECRoundedConstraintLayout;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "", "radius", "", "setRadius", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public class ECRoundedConstraintLayout extends ConstraintLayout {
    public float a;
    public float b;
    public float c;
    public float d;
    public Path e;
    public Function2<? super Integer, ? super Integer, Unit> f;

    public ECRoundedConstraintLayout(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public ECRoundedConstraintLayout(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void R5() {
        if (this.a != 0.0f) goto L13;
        if (this.b != 0.0f) goto L13;
        if (this.c != 0.0f) goto L13;
        if (this.d != 0.0f) goto L13;
        this.e = null;
        return;
    L13:
        if (this.e != null) goto L15;
        this.e = new Path();
    L15:
        Path r0 = this.e;
        if (r0 == null) goto L18;
        r0.reset();
    L18:
        RectF r1 = new RectF(0.0f, 0.0f, getWidth(), getHeight());
        float r2 = this.a;
        float r3 = this.b;
        float r4 = this.c;
        float r5 = this.d;
        float[] r6 = {r2, r2, r3, r3, r4, r4, r5, r5};
        Path r7 = this.e;
        if (r7 == null) goto L22;
        r7.addRoundRect(r1, r6, Path.Direction.CW);
        return;
    }

    public final void dispatchDraw(Canvas r2) {
        Intrinsics.checkNotNullParameter(r2, "canvas");
        if (this.e != null) goto L6;
        super.dispatchDraw(r2);
        return;
    L6:
        r2.save();
        Path r0 = this.e;
        if (r0 == null) goto L9;
        r2.clipPath(r0);
    L9:
        super.dispatchDraw(r2);
        r2.restore();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void draw(Canvas r2) {
        Intrinsics.checkNotNullParameter(r2, "canvas");
        if (this.e != null) goto L6;
        super/*android.view.ViewGroup*/.draw(r2);
        return;
    L6:
        r2.save();
        Path r0 = this.e;
        if (r0 == null) goto L9;
        r2.clipPath(r0);
    L9:
        super/*android.view.ViewGroup*/.draw(r2);
        r2.restore();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void setRadius(float r1) {
        this.a = r1;
        this.b = r1;
        this.c = r1;
        this.d = r1;
        R5();
        invalidate();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onMeasure(int r2, int r3) {
        super.onMeasure(r2, r3);
        Function2<? super Integer, ? super Integer, Unit> r4 = this.f;
        if (r4 == null) goto L6;
        Unit r5 = (Unit) r4.invoke(Integer.valueOf(getMeasuredWidth()), Integer.valueOf(getMeasuredHeight()));
        return;
    }

    public ECRoundedConstraintLayout(Context r3, AttributeSet r4, int r5) {
        Intrinsics.checkNotNullParameter(r3, "context");
        super(r3, r4, r5);
        TypedArray r6 = r3.getTheme().obtainStyledAttributes(r4, new int[]{2130972522, 2130973851}, r5, 0);
        if (r6.hasValue(1) == false) goto L5;
        float r7 = r6.getDimensionPixelOffset(1, 0);
        this.a = r7;
        this.b = r7;
        this.c = r7;
        this.d = r7;
    L5:
        r6.recycle();
    }

    public /* synthetic */ ECRoundedConstraintLayout(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onSizeChanged(int r1, int r2, int r3, int r4) {
        super/*android.view.ViewGroup*/.onSizeChanged(r1, r2, r3, r4);
        R5();
    }
}
