package com.bytedance.bdturing.livedetect.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public class DetectDebugView extends View {
    public Paint a;
    public Paint b;
    public List<List<PointF>> c;
    public List<RectF> d;
    public int e;
    public int f;
    public float g;

    public DetectDebugView(Context r2) {
        this(r2, null);
    }

    @Override // android.view.View
    public final void onDraw(Canvas r11) {
        super.onDraw(r11);
        List<List<PointF>> r0 = this.c;
        int r1 = 0;
        if (r0 != null) goto L5;
    L14:
        List<RectF> r2 = this.d;
        if (r2 != null) goto L17;
        return;
    L17:
        if (r2.size() > 0) goto L19;
        return;
    L19:
        if (r1 >= this.d.size()) goto L26;
        RectF r3 = (RectF) ListProtector.get(this.d, r1);
        float r4 = r3.left;
        float r5 = this.e;
        float r6 = r4 * r5;
        float r7 = r3.top;
        float r8 = this.f;
        r11.drawRect(r6, r7 * r8, r3.right * r5, r3.bottom * r8, this.a);
        r1 = r1 + 1;
        goto L19
    L26:
        return;
    L5:
        if (r0.size() <= 0) goto L14;
        int r9 = 0;
    L8:
        if (r9 >= this.c.size()) goto L14;
        List r10 = (List) ListProtector.get(this.c, r9);
        int r12 = 0;
    L11:
        if (r12 >= r10.size()) goto L13;
        PointF r13 = (PointF) ListProtector.get(r10, r12);
        r11.drawCircle(r13.x * this.e, r13.y * this.f, this.g, this.b);
        r12 = r12 + 1;
        goto L11
    L13:
        r9 = r9 + 1;
        goto L8
    }

    public DetectDebugView(Context r2, AttributeSet r3) {
        this(r2, r3, 0);
    }

    public DetectDebugView(Context r2, AttributeSet r3, int r4) {
        super(r2, r3, r4);
        Paint r5 = new Paint();
        this.a = r5;
        r5.setAntiAlias(true);
        this.a.setStyle(Paint.Style.STROKE);
        this.a.setColor(-16711936);
        this.a.setStrokeWidth(3.0f);
        Paint r6 = new Paint();
        this.b = r6;
        r6.setStyle(Paint.Style.FILL);
        this.b.setColor(-65536);
        this.b.setAntiAlias(true);
        this.g = 3.0f;
    }

    @Override // android.view.View
    public final void onSizeChanged(int r1, int r2, int r3, int r4) {
        super.onSizeChanged(r1, r2, r3, r4);
        if (this.e == r1) goto L5;
    L6:
        this.e = r1;
        this.f = r2;
        return;
    L5:
        if (this.f != r2) goto L6;
    }
}
