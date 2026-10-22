package wx0;

import android.graphics.RectF;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes47.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Float f561755a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Float f561756b;

    public b() {
    }

    public final RectF b(float r100) {
        Float r101 = this.f561755a;
        if (r101 == null) goto L12;
        float r102 = r101.floatValue();
        Float r103 = this.f561756b;
        if (r103 == null) goto L12;
        float r104 = r103.floatValue() * 1.0f;
        float r105 = RangesKt.coerceAtMost(r100 * r104, r102);
        float r106 = r104 * 1.0f;
        if (r105 < r102) goto L9;
        float r107 = 0.0f;
    L11:
        return new RectF(r107, 0.0f, r105 + r107, r106);
    L9:
        r107 = (r102 - r105) / 2.0f;
    L12:
        return null;
    }

    public final RectF a(int r100, float r101, float r102) {
        Float r103 = this.f561755a;
        if (r103 == null) goto L8;
        float r104 = r103.floatValue();
        Float r105 = this.f561756b;
        if (r105 == null) goto L8;
        float r106 = r105.floatValue() * r101;
        float r107 = RangesKt.coerceAtMost(r102 * r106, r104);
        float r108 = (r104 - r107) / 2.0f;
        float r109 = r100;
        return new RectF(r108, r109, r107 + r108, (r106 * 1.0f) + r109);
    L8:
        return null;
    }
}
