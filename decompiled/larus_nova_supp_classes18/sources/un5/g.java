package un5;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.text.style.ReplacementSpan;
import com.bytedance.ee.util.ui.n;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class g extends ReplacementSpan implements i {
    public int a;
    public final int b;
    public final int c;
    public final int d;
    public final RectF e;

    @Override // un5.i
    public final boolean E() {
        return false;
    }

    @Override // un5.i
    public final /* synthetic */ int F() {
        throw null;
    }

    public g(Context r3) {
        this.d = 11;
        this.e = new RectF();
        this.b = r3.getResources().getColor(2131105548);
        this.c = r3.getResources().getColor(2131106521);
    }

    @Override // android.text.style.ReplacementSpan
    public final int getSize(Paint r1, CharSequence r2, int r3, int r4, Paint.FontMetricsInt r5) {
        int r6 = ((int) r1.measureText(r2, r3, r4)) + n.d(this.d);
        this.a = r6;
        return r6;
    }

    @Override // android.text.style.ReplacementSpan
    public final void draw(Canvas r17, CharSequence r18, int r19, int r20, float r21, int r22, int r23, int r24, Paint r25) {
        int r10 = r25.getColor();
        r25.setColor(this.b);
        r25.setAntiAlias(true);
        RectF r3 = this.e;
        r3.left = r21;
        float r12 = r23;
        r3.top = r25.ascent() + r12;
        RectF r4 = this.e;
        r4.right = this.a + r21;
        r4.bottom = r25.descent() + r12;
        r17.drawRoundRect(this.e, n.d(this.d), n.d(this.d), r25);
        r25.setColor(this.c);
        float r15 = r25.measureText("@");
        r17.drawText("@", 0, 1, n.d(this.d / 2) + r21, r23 - n.d(1), r25);
        String r2 = r18.subSequence(r19, r20).toString();     // Catch: Exception -> L10
        if (r2.contains("@") == false) goto L8;
        String[] r5 = r2.split("@");     // Catch: Exception -> L10
        if (r5.length <= 1) goto L8;
        r2 = r5[1];     // Catch: Exception -> L10
    L8:
        r17.drawText(r2, 0, r2.length(), (r21 + r15) + n.d(this.d / 2), r12, r25);     // Catch: Exception -> L10
    L12:
        r25.setColor(r10);
        return;
    L10:
        e = move-exception;
        tt5.a.e("HighLightUserSpan", "draw: ", e, false);
        goto L12
    }
}
