package am5;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;
import com.bytedance.ee.util.ui.n;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class a extends View {
    public static final int g = 0;
    public static final int h = 0;
    public static final int i = 0;
    public static final int j = 0;
    public final Paint a;
    public int b;
    public int c;
    public final Paint d;
    public final int e;
    public boolean f;

    public int getTouchSideSize() {
        return 0;
    }

    static {
        int r0 = n.d(18);
        g = r0;
        int r1 = n.d(40);
        h = r1;
        i = (r0 * 2) + r1;
        j = n.d(5);
    }

    public int getSideOffsetValue() {
        return this.e;
    }

    public int getSidePadding() {
        return this.e;
    }

    public a(Context r5) {
        super(r5);
        Paint r6 = new Paint();
        this.a = r6;
        Paint r0 = new Paint();
        this.d = r0;
        this.e = g;
        this.f = true;
        this.b = getResources().getColor(2131108617);
        this.c = getResources().getColor(2131106521);
        r6.setColor(this.b);
        r6.setAntiAlias(true);
        r6.setStyle(Paint.Style.STROKE);
        r6.setStrokeWidth(n.d(2));
        r0.setColor(this.b);
        r0.setAntiAlias(true);
        r0.setStyle(Paint.Style.STROKE);
        r0.setStrokeWidth(n.d(2));
    }

    @Override // android.view.View
    public final void onDraw(Canvas r20) {
        super.onDraw(r20);
        float r1 = this.e;
        float r2 = getWidth() - r1;
        float r3 = getHeight() - r1;
        int r9 = 0;
        float r4 = (r1 + r2) / 2.0f;
        float r5 = (r1 + r3) / 2.0f;
        float[] r8 = {r1, r1, r2, r1, r2, r3, r1, r3, r4, r1, r2, r5, r4, r3, r1, r5};
        float r17 = this.d.getStrokeWidth() / 2.0f;
        r20.drawLine(r8[0] - r17, r8[1], r8[2], r8[3], this.d);
        r20.drawLine(r8[2], r8[3] - r17, r8[4], r8[5] + r17, this.d);
        r20.drawLine(r8[4] - r17, r8[5], r8[6], r8[7], this.d);
        r20.drawLine(r8[6], r8[7] + r17, r8[0], r8[1] + r17, this.d);
        if (this.f == true) goto L5;
        return;
    L5:
        if (r9 >= 8) goto L9;
        this.a.setStyle(Paint.Style.FILL);
        this.a.setColor(this.c);
        int r6 = r9 * 2;
        float r7 = r8[r6];
        int r10 = r6 + 1;
        float r11 = r8[r10];
        int r12 = j;
        r20.drawCircle(r7, r11, r12, this.a);
        this.a.setStyle(Paint.Style.STROKE);
        this.a.setColor(this.b);
        r20.drawCircle(r8[r6], r8[r10], r12, this.a);
        r9 = r9 + 1;
        goto L5
    }
}
