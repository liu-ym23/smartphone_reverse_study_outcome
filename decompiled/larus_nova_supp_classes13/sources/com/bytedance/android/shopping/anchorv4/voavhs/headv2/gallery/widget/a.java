package com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.widget.TextView;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class a extends TextView {
    public boolean a;
    public final Paint b;

    public a(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
        Paint r3 = new Paint(1);
        r3.setStyle(Paint.Style.FILL);
        r3.setColor(-1);
        Unit r0 = Unit.INSTANCE;
        this.b = r3;
    }

    @Override // android.widget.TextView, android.view.View
    public final void onDraw(Canvas r12) {
        Intrinsics.checkNotNullParameter(r12, "canvas");
        super.onDraw(r12);
        if (this.a == true) goto L5;
        return;
    L5:
        if (getWidth() <= com.bytedance.android.shopping.extensions.b.a(63)) goto L7;
        int r0 = com.bytedance.android.shopping.extensions.b.a(63);
    L8:
        float r1 = r0;
        float r9 = com.bytedance.android.shopping.extensions.b.a(2);
        float r2 = 2;
        r12.drawRoundRect((getWidth() - r1) / r2, getHeight() - r9, (getWidth() + r1) / r2, getHeight(), r9, r9, this.b);
        return;
    L7:
        r0 = com.bytedance.android.shopping.extensions.b.a(20);
        goto L8
    }
}
