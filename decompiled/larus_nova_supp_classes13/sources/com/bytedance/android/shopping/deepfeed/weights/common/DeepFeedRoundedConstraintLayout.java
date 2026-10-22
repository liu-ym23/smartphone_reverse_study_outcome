package com.bytedance.android.shopping.deepfeed.weights.common;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/shopping/deepfeed/weights/common/DeepFeedRoundedConstraintLayout;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class DeepFeedRoundedConstraintLayout extends ConstraintLayout {
    public final float a;
    public final float b;
    public final float c;
    public final float d;
    public Path e;

    public DeepFeedRoundedConstraintLayout(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public DeepFeedRoundedConstraintLayout(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
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

    public DeepFeedRoundedConstraintLayout(Context r3, AttributeSet r4, int r5) {
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

    public /* synthetic */ DeepFeedRoundedConstraintLayout(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onSizeChanged(int r1, int r2, int r3, int r4) {
        super/*android.view.ViewGroup*/.onSizeChanged(r1, r2, r3, r4);
        if (this.a != 0.0f) goto L12;
        if (this.b != 0.0f) goto L12;
        if (this.c != 0.0f) goto L12;
        if (this.d != 0.0f) goto L12;
        this.e = null;
        return;
    L12:
        if (this.e != null) goto L14;
        this.e = new Path();
    L14:
        Path r5 = this.e;
        if (r5 == null) goto L17;
        r5.reset();
    L17:
        RectF r6 = new RectF(0.0f, 0.0f, getWidth(), getHeight());
        float r7 = this.a;
        float r8 = this.b;
        float r9 = this.c;
        float r10 = this.d;
        float[] r11 = {r7, r7, r8, r8, r9, r9, r10, r10};
        Path r12 = this.e;
        if (r12 == null) goto L22;
        r12.addRoundRect(r6, r11, Path.Direction.CW);
        return;
    }
}
