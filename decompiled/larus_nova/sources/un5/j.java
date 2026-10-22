package un5;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Build;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ReplacementSpan;

/* JADX INFO: loaded from: classes18.dex */
public final class j extends ReplacementSpan {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f550806a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final l f550807b;

    public j(l r100) {
        this.f550807b = r100;
        String r101 = r100.a();
        this.f550806a = r101;
        if (TextUtils.isEmpty(r101) == false) goto L6;
        this.f550806a = "";
        return;
    }

    @Override // android.text.style.ReplacementSpan
    public final int getSize(Paint r100, CharSequence r101, int r102, int r103, Paint.FontMetricsInt r104) {
        if (TextUtils.isEmpty(this.f550806a) == false) goto L5;
        return 0;
    L5:
        String r105 = this.f550806a;
        return (int) r100.measureText(r105, 0, r105.length());
    }

    @Override // android.text.style.ReplacementSpan
    public final void draw(Canvas r110, CharSequence r111, int r112, int r113, float r114, int r115, int r116, int r117, Paint r210) {
        if (r110.getWidth() > r114) goto L5;
        return;
    L5:
        int r100 = Math.max(1, (int) (r110.getWidth() - r114));
        int r101 = r210.getColor();
        r210.setAntiAlias(true);
        r210.setColor(this.f550807b.b());
        if (Build.VERSION.SDK_INT < 23) goto L8;
        String r102 = this.f550806a;
        StaticLayout r103 = StaticLayout.Builder.obtain(r102, 0, r102.length(), new TextPaint(r210), r100).setEllipsize(TextUtils.TruncateAt.END).setMaxLines(1).build();
        r110.save();
        r110.translate(r114, r115);
        r103.draw(r110);
        r110.restore();
    L12:
        r210.setColor(r101);
        return;
    L8:
        float r104 = r100;
        if (r210.measureText(this.f550806a) <= r104) goto L11;
        this.f550806a = this.f550806a.substring(0, Math.min(((int) (r104 / r210.measureText("@"))) - 1, this.f550806a.length())) + "...";
    L11:
        String r105 = this.f550806a;
        r110.drawText(r105, 0, r105.length(), r114, r116, r210);
        goto L12
    }
}
