package ncc;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.style.ReplacementSpan;
import com.ss.android.lark.utils.UIHelper;
import java.util.Objects;

/* JADX INFO: loaded from: classes38.dex */
public final class a extends ReplacementSpan {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f518707d = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f518708a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f518709b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f518710c;

    public final int hashCode() {
        return Objects.hash(new Object[]{Float.valueOf(this.f518708a), Boolean.valueOf(this.f518709b), Integer.valueOf(this.f518710c)});
    }

    static {
        f518707d = UIHelper.dp2px(4.0f);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Float.compare(r101.f518708a, this.f518708a) == 0) goto L11;
    L15:
        return false;
    L11:
        if (this.f518709b != r101.f518709b) goto L15;
        if (this.f518710c != r101.f518710c) goto L15;
        return true;
    }

    public a(float r100, boolean r101, int r102) {
        this.f518708a = r100;
        this.f518709b = r101;
        this.f518710c = r102;
    }

    @Override // android.text.style.ReplacementSpan
    public final int getSize(Paint r100, CharSequence r101, int r102, int r103, Paint.FontMetricsInt r104) {
        r100.setFakeBoldText(true);
        r100.setTextSize(this.f518708a);
        int r105 = (int) r100.measureText(r101, r102, r103);
        if (this.f518709b == true) goto L5;
        return r105;
    L5:
        return f518707d + r105;
    }

    @Override // android.text.style.ReplacementSpan
    public final void draw(Canvas r100, CharSequence r110, int r111, int r112, float r113, int r114, int r115, int r116, Paint r117) {
        r117.setFakeBoldText(true);
        r117.setTextSize(this.f518708a);
        r117.setColor(this.f518710c);
        if (this.f518709b == false) goto L5;
        float r101 = f518707d + r113;
    L6:
        r100.drawText(r110, r111, r112, r101, r115, r117);
        return;
    L5:
        r101 = r113;
        goto L6
    }
}
