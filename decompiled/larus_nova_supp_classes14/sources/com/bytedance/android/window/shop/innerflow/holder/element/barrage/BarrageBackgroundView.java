package com.bytedance.android.window.shop.innerflow.holder.element.barrage;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;
import com.bytedance.android.shopping.extensions.b;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/android/window/shop/innerflow/holder/element/barrage/BarrageBackgroundView;", "Landroid/view/View;", "Landroid/content/Context;", "ctx", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class BarrageBackgroundView extends View {
    public final ConcurrentHashMap<Integer, LinearGradient> a;
    public final ConcurrentHashMap<Integer, Path> b;
    public final ConcurrentHashMap<Integer, LinearGradient> c;
    public final ConcurrentHashMap<Integer, Path> d;
    public final Paint e;
    public final float f;
    public final float g;

    @Override // android.view.View
    public final void onDraw(Canvas r25) {
        Intrinsics.checkNotNullParameter(r25, "canvas");
        super.onDraw(r25);
        this.e.setColor(2147483392);
        Paint r2 = this.e;
        int r3 = getWidth();
        int r4 = getHeight();
        LinearGradient r5 = this.a.get(Integer.valueOf(r3));
        if (r5 != null) goto L6;
        int r12 = (int) 2151346943L;
        r5 = new LinearGradient(0.0f, 0.0f, r3, r4, r12, r12, Shader.TileMode.CLAMP);
        this.a.put(Integer.valueOf(r3), r5);
    L6:
        r2.setShader(r5);
        int r6 = getWidth();
        int r7 = getHeight();
        Path r8 = this.b.get(Integer.valueOf(r6));
        if (r8 != null) goto L10;
        float r9 = r6;
        float r10 = r7;
        float r11 = r10 / 2;
        RectF r13 = new RectF(0.0f, 0.0f, r10, r10);
        RectF r14 = new RectF(r9 - r10, 0.0f, r9, r10);
        RectF r15 = new RectF(this.f, this.g, r10, r10);
        RectF r16 = new RectF(r9 - (r10 - this.g), this.f, r9, r10);
        Path r17 = new Path();
        r17.moveTo(r11, r10);
        r17.arcTo(r13, 90.0f, 180.0f);
        r17.lineTo(r9 - r11, 0.0f);
        r17.arcTo(r14, 270.0f, 180.0f);
        r17.arcTo(r16, 90.0f, -180.0f);
        r17.lineTo(r15.centerX(), r15.top);
        r17.arcTo(r15, 270.0f, -180.0f);
        r17.lineTo(r11, r10);
        this.b.put(Integer.valueOf(r6), r17);
        r8 = r17;
    L10:
        r25.drawPath(r8, this.e);
        this.e.setColor(2147418112);
        Paint r18 = this.e;
        int r19 = getWidth();
        int r20 = getHeight();
        LinearGradient r21 = this.c.get(Integer.valueOf(r19));
        if (r21 != null) goto L14;
        LinearGradient r22 = new LinearGradient(0.0f, 0.0f, r19 - this.g, r20 - this.f, (int) 2147483648L, 251658240, Shader.TileMode.CLAMP);
        this.c.put(Integer.valueOf(r19), r22);
        r21 = r22;
    L14:
        r18.setShader(r21);
        int r23 = getWidth();
        int r24 = getHeight();
        Path r26 = this.d.get(Integer.valueOf(r23));
        if (r26 != null) goto L18;
        float r27 = r23;
        float r28 = r24;
        float r29 = r28 / 2;
        RectF r30 = new RectF(this.f, this.g, r28, r28);
        RectF r110 = new RectF(r27 - (r28 - this.g), this.f, r27, r28);
        Path r111 = new Path();
        r111.moveTo(r29, r28);
        r111.arcTo(r30, 90.0f, 180.0f);
        r111.lineTo(r27 - r29, this.f);
        r111.arcTo(r110, 270.0f, 180.0f);
        r111.close();
        this.d.put(Integer.valueOf(r23), r111);
        r26 = r111;
    L18:
        r25.drawPath(r26, this.e);
    }

    public BarrageBackgroundView(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "ctx");
        super(r2, r3);
        this.a = new ConcurrentHashMap();
        this.b = new ConcurrentHashMap();
        this.c = new ConcurrentHashMap();
        this.d = new ConcurrentHashMap();
        Paint r4 = new Paint();
        r4.setStyle(Paint.Style.FILL_AND_STROKE);
        Unit r5 = Unit.INSTANCE;
        this.e = r4;
        this.f = b.b(2);
        this.g = b.b(2);
    }
}
