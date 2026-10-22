package com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.pendent.video;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.view.View;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class z extends View {
    public final Paint a;
    public final RectF b;
    public final Paint c;
    public final /* synthetic */ a0 d;

    @Override // android.view.View
    public final void dispatchDraw(Canvas r8) {
        Intrinsics.checkNotNullParameter(r8, "canvas");
        super.dispatchDraw(r8);
        r8.drawRect(this.b, this.a);
        if (this.d.h == false) goto L6;
        r8.drawRect(0.0f, 0.0f, getWidth(), getHeight(), this.c);
        return;
    }

    public z(a0 r1, Context r2) {
        this.d = r1;
        super(r2);
        r1.i = this;
        Paint r3 = new Paint();
        r3.setStyle(Paint.Style.FILL);
        Unit r4 = Unit.INSTANCE;
        this.a = r3;
        this.b = new RectF();
        Paint r5 = new Paint();
        r5.setStyle(Paint.Style.FILL);
        r5.setColor(504764451);
        this.c = r5;
    }

    @Override // android.view.View
    public final void onSizeChanged(int r9, int r10, int r11, int r12) {
        super.onSizeChanged(r9, r10, r11, r12);
        this.b.set(0.0f, r10 - com.bytedance.android.shopping.extensions.b.a(26), r9, r10);
        Paint r13 = this.a;
        RectF r14 = this.b;
        r13.setShader(new LinearGradient(0.0f, r14.top, 0.0f, r14.bottom, 0, 1711276032, Shader.TileMode.CLAMP));
    }
}
