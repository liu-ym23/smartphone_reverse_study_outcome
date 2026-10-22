package com.bytedance.android.shopping.store.slicecard.viewmanager;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.widget.TextView;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001R*\u0010\n\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00028\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u0017\u0010\u0010\u001a\u00020\u000b8\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/shopping/store/slicecard/viewmanager/TextViewGradient;", "Landroid/widget/TextView;", "", "value", "a", "F", "getGradientScope", "()F", "setGradientScope", "(F)V", "gradientScope", "", "c", "I", "getLinearTextColor", "()I", "linearTextColor", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class TextViewGradient extends TextView {
    public float a;
    public Shader b;
    public final int c;

    public TextViewGradient(Context r7) {
        this(r7, null, 0, 14, 0);
    }

    public TextViewGradient(Context r7, AttributeSet r8) {
        this(r7, r8, 0, 12, 0);
    }

    public TextViewGradient(Context r7, AttributeSet r8, int r9) {
        this(r7, r8, r9, 8, 0);
    }

    public final float getGradientScope() {
        return this.a;
    }

    public final int getLinearTextColor() {
        return this.c;
    }

    @Override // android.widget.TextView, android.view.View
    public final void onDraw(Canvas r5) {
        Intrinsics.checkNotNullParameter(r5, "canvas");
        getPaint().setShader(this.b);
        Paint.FontMetrics r0 = getPaint().getFontMetrics();
        r5.drawText(getText().toString(), 0.0f, (getHeight() / 2) + ((-(r0.descent + r0.ascent)) / 2), getPaint());
    }

    public final void setGradientScope(float r1) {
        this.a = r1;
        invalidate();
    }

    public TextViewGradient(Context r2, AttributeSet r3, int r4, int r5) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.c = r5;
        this.a = 50.0f;
    }

    @Override // android.view.View
    public final void onSizeChanged(int r19, int r20, int r21, int r22) {
        super.onSizeChanged(r19, r20, r21, r22);
        if (getMeasuredWidth() <= this.a) goto L5;
        LinearGradient r1 = new LinearGradient(getMeasuredWidth() - this.a, 0.0f, getMeasuredWidth(), 0.0f, this.c, 0, Shader.TileMode.CLAMP);
    L6:
        this.b = r1;
        return;
    L5:
        r1 = new LinearGradient(getMeasuredWidth() - this.a, 0.0f, getMeasuredWidth(), 0.0f, this.c, 0, Shader.TileMode.CLAMP);
        goto L6
    }

    public /* synthetic */ TextViewGradient(Context r2, AttributeSet r3, int r4, int r5, int r6) {
        if ((r5 & 2) == 0) goto L5;
        r3 = null;
    L5:
        int r0 = 0;
        if ((r5 & 4) == 0) goto L9;
        r4 = 0;
    L9:
        if ((r5 & 8) == 0) goto L11;
        r0 = ColorProtector.parseColor("#FFFFFF");
    L11:
        this(r2, r3, r4, r0);
    }
}
