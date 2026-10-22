package z6a;

import android.graphics.Paint;
import android.text.TextPaint;
import android.text.style.MetricAffectingSpan;
import java.text.DecimalFormat;

/* JADX INFO: loaded from: classes32.dex */
public final class j extends MetricAffectingSpan {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f570585a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f570586b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f570587c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f570588d;

    @Override // android.text.style.MetricAffectingSpan
    public final void updateMeasureState(TextPaint r100) {
    }

    public final int hashCode() {
        return this.f570585a + 31;
    }

    public j(int r100) {
        this.f570588d = false;
        this.f570585a = r100;
    }

    public final boolean equals(Object r100) {
        if ((r100 instanceof j) == true) goto L5;
        return false;
    L5:
        if (this.f570585a != ((j) r100).f570585a) goto L9;
        return true;
    L9:
        return false;
    }

    @Override // android.text.style.CharacterStyle
    public final void updateDrawState(TextPaint r100) {
        boolean r101 = this.f570588d;
        int r102 = this.f570585a;
        int r103 = this.f570586b;
        float r104 = this.f570587c;
        DecimalFormat r105 = com.lynx.tasm.behavior.shadow.text.b.f382275a;
        if (r101 == false) goto L5;
        r100.setStyle(Paint.Style.STROKE);
        r100.setStrokeWidth(r104);
        r100.setColor(r103);
        r100.bgColor = 0;
        return;
    L5:
        r100.setStyle(Paint.Style.FILL);
        r100.setColor(r102);
    }
}
