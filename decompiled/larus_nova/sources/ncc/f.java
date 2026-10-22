package ncc;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.style.ReplacementSpan;
import androidx.exifinterface.media.ExifInterface;
import com.ss.android.lark.utils.UIHelper;
import java.util.Objects;

/* JADX INFO: loaded from: classes38.dex */
public final class f extends ReplacementSpan {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int f518738d = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Paint.Style f518739a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f518740b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f518741c;

    public final int hashCode() {
        return Objects.hash(new Object[]{this.f518739a, Integer.valueOf(this.f518740b), Integer.valueOf(this.f518741c)});
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof f) == true) goto L8;
        return false;
    L8:
        f r101 = (f) r100;
        if (this.f518740b == r101.f518740b) goto L11;
    L15:
        return false;
    L11:
        if (this.f518741c != r101.f518741c) goto L15;
        if (this.f518739a != r101.f518739a) goto L15;
        return true;
    }

    public f(int r100, int r101, Paint.Style r102) {
        this.f518740b = r100;
        this.f518741c = r101;
        this.f518739a = r102;
    }

    @Override // android.text.style.ReplacementSpan
    public final int getSize(Paint r100, CharSequence r101, int r102, int r103, Paint.FontMetricsInt r104) {
        return ((int) r100.measureText(r101, r102, r103)) + (((UIHelper.dp2px(2.0f) * 2) + UIHelper.dp2px(3.0f)) + UIHelper.dp2px(2.0f));
    }

    @Override // android.text.style.ReplacementSpan
    public final void draw(Canvas r110, CharSequence r111, int r112, int r113, float r114, int r115, int r116, int r117, Paint r210) {
        float r118 = r210.measureText(r111, r112, r113);
        r210.setColor(this.f518741c);
        r110.drawText(r111, r112, r113, r114, r116, r210);
        int r100 = (int) (((r114 + r118) + UIHelper.dp2px(3.0f)) + UIHelper.dp2px(2.0f));
        Rect r101 = new Rect();
        r210.getTextBounds(ExifInterface.GPS_DIRECTION_TRUE, 0, 1, r101);
        float r102 = r100;
        float r103 = r116 - r101.height();
        Paint.Style r104 = this.f518739a;
        Paint.Style r105 = Paint.Style.STROKE;
        if (r104 != r105) goto L5;
        r210.setStyle(r105);
    L6:
        r210.setStrokeWidth(UIHelper.dp2px(1.0f));
        r210.setColor(this.f518740b);
        r110.drawCircle(r102, r103, UIHelper.dp2px(2.0f), r210);
        return;
    L5:
        r210.setStyle(Paint.Style.FILL_AND_STROKE);
        goto L6
    }
}
