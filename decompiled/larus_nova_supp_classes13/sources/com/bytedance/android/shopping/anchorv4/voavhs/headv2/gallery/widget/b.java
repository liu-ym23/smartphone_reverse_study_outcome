package com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.widget.TextView;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class b extends TextView {
    public boolean a;
    public final Paint b;

    public b(Context r2) {
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
        if (this.a == false) goto L6;
        float r0 = com.bytedance.android.shopping.extensions.b.a(16);
        float r9 = com.bytedance.android.shopping.extensions.b.a(2);
        float r1 = 2;
        r12.drawRoundRect((getWidth() - r0) / r1, getHeight() - r9, (getWidth() + r0) / r1, getHeight(), r9, r9, this.b);
        return;
    }
}
