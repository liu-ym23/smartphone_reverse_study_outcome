package com.bytedance.android.shopping.inflow.cardui.product.header.indicator;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.bytedance.android.shopping.extensions.b;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tc3.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\n\u001a\u00020\t\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\b\b\u0002\u0010\r\u001a\u00020\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/shopping/inflow/cardui/product/header/indicator/ProductCardProgressIndicator;", "Landroid/view/View;", "", "count", "", "setup", "", "fill", "setFillCurrent", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ProductCardProgressIndicator extends View {
    public final Paint a;
    public final Paint b;
    public final RectF c;
    public final RectF d;
    public final RectF e;
    public final int f;
    public float g;
    public int h;
    public int i;
    public float j;
    public boolean k;

    public ProductCardProgressIndicator(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public ProductCardProgressIndicator(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public final void a() {
        int r0 = this.h;
        if (r0 != 0) goto L5;
        return;
    L5:
        int r1 = (((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight()) - (this.f * (r0 - 1))) / this.h;
        int r2 = getMeasuredHeight();
        if (f.f() == false) goto L8;
        r2 = 2;
    L8:
        this.c.set(0.0f, getPaddingTop(), r1, r2 - getPaddingBottom());
        this.g = this.c.height() / 2.0f;
    }

    @Override // android.view.View
    public final void onDraw(Canvas r8) {
        Intrinsics.checkNotNullParameter(r8, "canvas");
        super.onDraw(r8);
        this.d.set(this.c);
        this.e.set(this.c);
        int r0 = this.h;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L15;
        int r2 = this.i;
        if (r1 < r2) goto L13;
        if (r1 == r2) goto L8;
    L10:
        if (r1 <= r2) goto L12;
        RectF r3 = this.d;
        float r4 = this.g;
        r8.drawRoundRect(r3, r4, r4, this.a);
    L14:
        float r5 = this.c.width();
        RectF r6 = this.d;
        float r7 = r6.right + this.f;
        r6.left = r7;
        r6.right = r7 + r5;
        this.e.set(r6);
        r1 = r1 + 1;
        goto L3
    L12:
        RectF r9 = this.d;
        float r10 = this.g;
        r8.drawRoundRect(r9, r10, r10, this.a);
        RectF r11 = this.e;
        r11.right -= r11.width() * (1 - this.j);
        RectF r12 = this.e;
        float r13 = this.g;
        r8.drawRoundRect(r12, r13, r13, this.b);
        goto L14
    L8:
        if (this.k == false) goto L10;
    L13:
        RectF r14 = this.e;
        float r15 = this.g;
        r8.drawRoundRect(r14, r15, r15, this.b);
        goto L14
    }

    public final void setFillCurrent(boolean r1) {
        this.k = r1;
        invalidate();
    }

    public final void setup(int r1) {
        if (r1 != 0) goto L4;
        return;
    L4:
        this.h = r1;
        a();
        invalidate();
    }

    public final void b(int r1, float r2) {
        this.i = r1;
        this.j = r2;
        invalidate();
    }

    @Override // android.view.View
    public final void onMeasure(int r1, int r2) {
        super.onMeasure(r1, r2);
        if (this.h == 0) goto L6;
        a();
        return;
    }

    public ProductCardProgressIndicator(Context r3, AttributeSet r4, int r5) {
        Intrinsics.checkNotNullParameter(r3, "context");
        super(r3, r4, r5);
        Paint r6 = new Paint();
        this.a = r6;
        Paint r7 = new Paint();
        this.b = r7;
        this.c = new RectF();
        this.d = new RectF();
        this.e = new RectF();
        this.f = b.b(2);
        r6.setAntiAlias(true);
        r6.setColor(Color.argb(122, 255, 255, 255));
        r7.setAntiAlias(true);
        r7.setColor(Color.argb(255, 255, 255, 255));
    }

    public /* synthetic */ ProductCardProgressIndicator(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
