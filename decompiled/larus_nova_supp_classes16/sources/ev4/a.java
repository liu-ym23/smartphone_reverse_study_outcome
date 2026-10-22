package ev4;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.style.ReplacementSpan;
import androidx.core.content.ContextCompat;
import com.bytedance.ee.util.ui.n;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a extends ReplacementSpan {
    public boolean a;
    public final String b;
    public final int c;
    public final int d;
    public final b e;

    public a(Context r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this.a = r4;
        this.b = r3.getString(2131886542);
        this.c = ContextCompat.getColor(r3, 2131106620);
        this.d = n.e(r3, 8.0f);
        b r5 = new b(r3);
        r5.setBounds(0, 0, r5.getIntrinsicWidth(), r5.getIntrinsicHeight());
        this.e = r5;
    }

    @Override // android.text.style.ReplacementSpan
    public final int getSize(Paint r1, CharSequence r2, int r3, int r4, Paint.FontMetricsInt r5) {
        Intrinsics.checkNotNullParameter(r1, "paint");
        if (r5 == null) goto L6;
        Paint.FontMetricsInt r6 = r1.getFontMetricsInt();
        r5.ascent = r6.ascent;
        r5.top = r6.top;
        r5.descent = r6.descent;
        r5.bottom = r6.bottom;
    L6:
        if (this.a == false) goto L8;
        float r7 = r1.measureText(this.b);
    L10:
        return (int) ((r7 + this.d) + this.e.getIntrinsicWidth());
    L8:
        r7 = 0.0f;
        goto L10
    }

    @Override // android.text.style.ReplacementSpan
    public final void draw(Canvas r1, CharSequence r2, int r3, int r4, float r5, int r6, int r7, int r8, Paint r9) {
        Intrinsics.checkNotNullParameter(r1, "canvas");
        Intrinsics.checkNotNullParameter(r9, "paint");
        if (this.a == false) goto L5;
        int r10 = r9.getColor();
        r9.setColor(this.c);
        r1.drawText(this.b, r5, r7, r9);
        r9.setColor(r10);
        r5 = r5 + r9.measureText(this.b);
    L5:
        float r11 = r5 + this.d;
        float r12 = ((r6 + r8) - this.e.getIntrinsicHeight()) / 2.0f;
        r1.save();
        r1.translate(r11, r12);
        this.e.draw(r1);
        r1.restore();
    }
}
