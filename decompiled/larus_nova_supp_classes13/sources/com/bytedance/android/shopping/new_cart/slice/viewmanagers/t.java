package com.bytedance.android.shopping.new_cart.slice.viewmanagers;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class t extends View {
    public final Paint a;

    public t(Context r6) {
        Intrinsics.checkNotNullParameter(r6, "context");
        super(r6);
        Paint r7 = new Paint(1);
        this.a = r7;
        r7.setShadowLayer(10.0f, 0.0f, -com.bytedance.android.shopping.extensions.b.a(4), com.bytedance.android.shopping.extensions.k.o("#0D161823"));
        setLayerType(1, r7);
    }

    @Override // android.view.View
    public final void onDraw(Canvas r9) {
        Intrinsics.checkNotNullParameter(r9, "canvas");
        super.onDraw(r9);
        this.a.setStyle(Paint.Style.FILL);
        this.a.setColor(0);
        r9.drawRect(0.0f, 0.0f, getWidth(), getHeight(), this.a);
    }
}
