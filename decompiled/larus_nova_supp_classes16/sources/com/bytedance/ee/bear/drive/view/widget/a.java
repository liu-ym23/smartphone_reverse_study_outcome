package com.bytedance.ee.bear.drive.view.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;
import androidx.core.content.ContextCompat;
import com.ss.android.lark.utils.UIHelper;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a extends View {
    public final boolean a;
    public final Paint b;

    /* JADX INFO: renamed from: com.bytedance.ee.bear.drive.view.widget.a$a, reason: collision with other inner class name */
    public static final class C0188a {
    }

    static {
    }

    @Override // android.view.View
    public final void onDraw(Canvas r8) {
        Intrinsics.checkNotNullParameter(r8, "canvas");
        float r1 = ((getWidth() - getPaddingStart()) - getPaddingEnd()) / 2.0f;
        float r3 = ((getHeight() - getPaddingTop()) - getPaddingBottom()) / 2.0f;
        float r4 = Math.min(r3, r3);
        r8.translate(getPaddingStart() + r1, getPaddingTop() + r3);
        r8.drawCircle(0.0f, 0.0f, r4, this.b);
        if (this.a == false) goto L5;
        r8.drawRect(0.0f, -r4, r4, 0.0f, this.b);
        return;
    L5:
        float r2 = -r4;
        r8.drawRect(r2, r2, 0.0f, 0.0f, this.b);
    }

    public a(Context r3, boolean r4) {
        int r0 = ContextCompat.getColor(r3, 2131108619);
        Intrinsics.checkNotNullParameter(r3, "context");
        super(r3);
        this.a = r4;
        Paint r5 = new Paint(1);
        this.b = r5;
        r5.setColor(r0);
        invalidate();
    }

    @Override // android.view.View
    public final void onMeasure(int r5, int r6) {
        int r0 = View.MeasureSpec.getMode(r5);
        int r1 = View.MeasureSpec.getMode(r6);
        if (r0 != 1073741824) goto L5;
        int r7 = View.MeasureSpec.getSize(r5);
    L6:
        if (r1 != 1073741824) goto L8;
        int r8 = View.MeasureSpec.getSize(r6);
    L9:
        setMeasuredDimension(r7, r8);
        return;
    L8:
        r8 = (UIHelper.dp2px(20.0f) + getPaddingTop()) + getPaddingBottom();
        goto L9
    L5:
        r7 = (UIHelper.dp2px(20.0f) + getPaddingStart()) + getPaddingEnd();
        goto L6
    }
}
