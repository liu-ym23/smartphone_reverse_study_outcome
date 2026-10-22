package un5;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Build;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ReplacementSpan;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class j extends ReplacementSpan {
    public String a;
    public final l b;

    public j(l r1) {
        this.b = r1;
        String r2 = r1.a();
        this.a = r2;
        if (TextUtils.isEmpty(r2) == false) goto L6;
        this.a = "";
        return;
    }

    @Override // android.text.style.ReplacementSpan
    public final int getSize(Paint r1, CharSequence r2, int r3, int r4, Paint.FontMetricsInt r5) {
        if (TextUtils.isEmpty(this.a) == false) goto L5;
        return 0;
    L5:
        String r6 = this.a;
        return (int) r1.measureText(r6, 0, r6.length());
    }

    @Override // android.text.style.ReplacementSpan
    public final void draw(Canvas r12, CharSequence r13, int r14, int r15, float r16, int r17, int r18, int r19, Paint r20) {
        if (r12.getWidth() > r16) goto L5;
        return;
    L5:
        int r2 = Math.max(1, (int) (r12.getWidth() - r16));
        int r9 = r20.getColor();
        r20.setAntiAlias(true);
        r20.setColor(this.b.b());
        if (Build.VERSION.SDK_INT < 23) goto L8;
        String r4 = this.a;
        StaticLayout r3 = StaticLayout.Builder.obtain(r4, 0, r4.length(), new TextPaint(r20), r2).setEllipsize(TextUtils.TruncateAt.END).setMaxLines(1).build();
        r12.save();
        r12.translate(r16, r17);
        r3.draw(r12);
        r12.restore();
    L12:
        r20.setColor(r9);
        return;
    L8:
        float r5 = r2;
        if (r20.measureText(this.a) <= r5) goto L11;
        this.a = this.a.substring(0, Math.min(((int) (r5 / r20.measureText("@"))) - 1, this.a.length())) + "...";
    L11:
        String r6 = this.a;
        r12.drawText(r6, 0, r6.length(), r16, r18, r20);
        goto L12
    }
}
