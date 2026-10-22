package com.bytedance.android.window.shop.widget.product;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0019\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\u000f\u0010\u0010R.\u0010\n\u001a\u0004\u0018\u00010\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/window/shop/widget/product/CouponVerticalDashView;", "Landroid/view/View;", "Lcom/bytedance/android/window/shop/widget/product/CouponVerticalDashView$a;", "value", "a", "Lcom/bytedance/android/window/shop/widget/product/CouponVerticalDashView$a;", "getConfig", "()Lcom/bytedance/android/window/shop/widget/product/CouponVerticalDashView$a;", "setConfig", "(Lcom/bytedance/android/window/shop/widget/product/CouponVerticalDashView$a;)V", "config", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CouponVerticalDashView extends View {
    public a a;
    public final Paint b;

    public static final class a {
        public final float a;
        public final float b;
        public final float c;

        public final boolean equals(Object r3) {
            if (this != r3) goto L4;
            return true;
        L4:
            if ((r3 instanceof a) == false) goto L12;
            a r4 = (a) r3;
            if (Float.compare(this.a, r4.a) == 0) goto L8;
            return false;
        L8:
            if (Float.compare(this.b, r4.b) == 0) goto L10;
            return false;
        L10:
            if (Float.compare(this.c, r4.c) == 0) goto L19;
            return false;
        L19:
            return true;
        L12:
            return false;
        }

        public final int hashCode() {
            return (((Float.floatToIntBits(this.a) * 31) + Float.floatToIntBits(this.b)) * 31) + Float.floatToIntBits(this.c);
        }

        public final String toString() {
            return "Config(dashHeight=" + this.a + ", dashGap=" + this.b + ", offset=" + this.c + ")";
        }

        public a(float r1, float r2, float r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }
    }

    public final a getConfig() {
        return this.a;
    }

    @Override // android.view.View
    public final void onDraw(Canvas r9) {
        Intrinsics.checkNotNullParameter(r9, "canvas");
        super.onDraw(r9);
        a r0 = this.a;
        if (r0 != null) goto L5;
        return;
    L5:
        float r1 = r0.c;
    L7:
        if (r1 >= getHeight()) goto L9;
        r9.drawRect(0.0f, r1, getWidth(), r1 + r0.a, this.b);
        r1 = r1 + (r0.a + r0.b);
        goto L7
    }

    public final void setConfig(a r1) {
        this.a = r1;
    }

    public CouponVerticalDashView(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        super(r3, r4);
        Paint r5 = new Paint();
        r5.setColor((int) 4294946745L);
        r5.setStyle(Paint.Style.FILL_AND_STROKE);
        Unit r6 = Unit.INSTANCE;
        this.b = r5;
    }
}
