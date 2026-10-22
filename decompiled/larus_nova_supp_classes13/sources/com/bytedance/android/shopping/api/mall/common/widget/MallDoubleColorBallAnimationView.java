package com.bytedance.android.shopping.api.mall.common.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.content.ContextCompat;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0014\u001a\u00020\u0013\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015\u0012\u0006\u0010\u0017\u001a\u00020\u0002¢\u0006\u0004\b\u0018\u0010\u0019B\u0011\b\u0016\u0012\u0006\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u0018\u0010\u001aB\u001b\b\u0016\u0012\u0006\u0010\u0014\u001a\u00020\u0013\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015¢\u0006\u0004\b\u0018\u0010\u001bJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002J\u000e\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bJ\u000e\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0002R\u001b\u0010\u0012\u001a\u00020\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001c"}, d2 = {"Lcom/bytedance/android/shopping/api/mall/common/widget/MallDoubleColorBallAnimationView;", "Landroid/view/View;", "", "visibility", "", "setVisibility", "size", "setProgressBarInfo", "", "progress", "setProgress", "cycleBias", "setCycleBias", "", "v", "Lkotlin/Lazy;", "getMExpDelay", "()J", "mExpDelay", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "(Landroid/content/Context;)V", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class MallDoubleColorBallAnimationView extends View {
    public final float a;
    public final float b;
    public final float c;
    public final float d;
    public final float e;
    public final long f;
    public int g;
    public int h;
    public Paint i;
    public final PorterDuffXfermode j;
    public float k;
    public boolean l;
    public boolean m;
    public int n;
    public boolean o;
    public long p;
    public int q;
    public float r;
    public float s;
    public float t;
    public float u;
    public final Lazy v;

    private final long getMExpDelay() {
        return ((Number) this.v.getValue()).longValue();
    }

    public final void a() {
        this.p = -1;
        if (this.q > 0) goto L5;
        setProgressBarInfo(getContext().getResources().getDimensionPixelSize(2131168168));
    L5:
        int r0 = Math.min(getMeasuredHeight(), getMeasuredWidth());
        if (this.q <= r0) goto L10;
        if (r0 <= 0) goto L10;
        setProgressBarInfo(r0);
    L10:
        if (this.i != null) goto L12;
        Paint r1 = new Paint();
        r1.setAntiAlias(true);
        r1.setDither(true);
        r1.setStyle(Paint.Style.FILL);
        this.i = r1;
    L12:
        this.m = true;
    }

    @Override // android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.o = false;
        this.m = false;
        this.k = 0.0f;
    }

    public MallDoubleColorBallAnimationView(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, null);
        b(r2);
    }

    public final void b(Context r2) {
        this.g = ContextCompat.getColor(r2, 2131106131);
        this.h = ContextCompat.getColor(r2, 2131106132);
    }

    @Override // android.view.View
    public final void onDraw(Canvas r17) {
        Intrinsics.checkNotNullParameter(r17, "canvas");
        super.onDraw(r17);
        if (this.o == true) goto L7;
        if (this.l == false) goto L7;
        return;
    L7:
        if (this.m == false) goto L40;
        boolean r2 = false;
        if (this.l == false) goto L18;
        long r4 = System.nanoTime() / ((long) 1000000);
        if (this.p >= 0) goto L14;
        this.p = r4;
    L14:
        float r1 = (r4 - this.p) / this.e;
        this.k = r1;
        int r5 = (int) r1;
        if (((this.n + r5) & 1) != 1) goto L17;
        r2 = true;
    L17:
        this.k = r1 - r5;
        boolean r11 = r2;
    L19:
        float r3 = this.k;
        if (r3 >= 0.5d) goto L22;
        float r6 = (2 * r3) * r3;
    L23:
        float r15 = r6;
        int r7 = this.q;
        int r8 = r17.saveLayer(0.0f, 0.0f, r7, r7, this.i, 31);
        float r9 = (this.u * r15) + this.t;
        if (r15 >= 0.5d) goto L26;
        float r16 = r15 * 2.0f;
    L27:
        float r10 = this.a * r16;
        float r12 = this.s;
        float r13 = (r10 * r12) + r12;
        Paint r14 = this.i;
        Intrinsics.checkNotNull(r14);
        if (r11 == false) goto L30;
        int r18 = this.h;
    L31:
        r14.setColor(r18);
        float r19 = this.r;
        Paint r20 = this.i;
        Intrinsics.checkNotNull(r20);
        r17.drawCircle(r9, r19, r13, r20);
        float r21 = this.q - r9;
        float r22 = this.s;
        float r23 = r22 - ((r16 * this.b) * r22);
        Paint r24 = this.i;
        Intrinsics.checkNotNull(r24);
        if (r11 == false) goto L34;
        int r25 = this.g;
    L35:
        r24.setColor(r25);
        Paint r26 = this.i;
        Intrinsics.checkNotNull(r26);
        r26.setXfermode(this.j);
        float r27 = this.r;
        Paint r28 = this.i;
        Intrinsics.checkNotNull(r28);
        r17.drawCircle(r21, r27, r23, r28);
        Paint r29 = this.i;
        Intrinsics.checkNotNull(r29);
        r29.setXfermode(null);
        r17.restoreToCount(r8);
        if (getMExpDelay() <= 0) goto L38;
        postInvalidateDelayed(getMExpDelay());
        return;
    L38:
        postInvalidateDelayed(this.f);
        return;
    L34:
        r25 = this.h;
        goto L35
    L30:
        r18 = this.g;
        goto L31
    L26:
        float r30 = 2;
        r16 = r30 - (r15 * r30);
        goto L27
    L22:
        float r31 = 2;
        r6 = ((r31 * r3) * (r31 - r3)) - 1;
        goto L23
    L18:
        r11 = false;
        goto L19
    }

    public final void setCycleBias(int r1) {
        this.n = r1;
    }

    public final void setProgress(float r2) {
        if (this.m == true) goto L5;
        a();
    L5:
        this.k = r2;
        this.o = false;
        this.l = false;
        postInvalidate();
    }

    public final void setProgressBarInfo(int r4) {
        if (r4 <= 0) goto L5;
        this.q = r4;
        this.r = r4 / 2.0f;
        float r0 = (r4 >> 1) * this.d;
        this.s = r0;
        float r1 = (this.c * r4) + r0;
        this.t = r1;
        this.u = r4 - (r1 * 2);
        return;
    }

    @Override // android.view.View
    public void setVisibility(int r1) {
        super.setVisibility(r1);
        if (r1 != 0) goto L5;
        a();
        this.o = true;
        this.l = true;
        postInvalidate();
        return;
    L5:
        this.o = false;
        this.m = false;
        this.k = 0.0f;
    }

    public MallDoubleColorBallAnimationView(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, r3, 0);
        b(r2);
    }

    @Override // android.view.View
    public final void onMeasure(int r1, int r2) {
        super.onMeasure(r1, r2);
        int r3 = Math.min(View.MeasureSpec.getSize(r1), View.MeasureSpec.getSize(r2));
        if (this.q <= r3) goto L7;
        if (r3 <= 0) goto L8;
        setProgressBarInfo(r3);
        return;
    L8:
        return;
    }

    public MallDoubleColorBallAnimationView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.a = 0.25f;
        this.b = 0.375f;
        this.c = 0.16f;
        this.d = 0.32f;
        this.e = 400.0f;
        this.f = 17;
        this.j = new PorterDuffXfermode(PorterDuff.Mode.XOR);
        this.p = -1;
        this.q = -1;
        this.v = LazyKt.lazy(MallDoubleColorBallAnimationView$mExpDelay$2.INSTANCE);
        b(r2);
    }
}
