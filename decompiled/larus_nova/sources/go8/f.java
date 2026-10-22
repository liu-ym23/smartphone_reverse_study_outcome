package go8;

import com.larus.bmhome.chat.layout.widget.u;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f481940a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f481941b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final u f481942c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float f481943d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof f) == true) goto L8;
        return false;
    L8:
        f r101 = (f) r100;
        if (this.f481940a == r101.f481940a) goto L12;
        return false;
    L12:
        if (this.f481941b == r101.f481941b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f481942c, r101.f481942c) == true) goto L18;
        return false;
    L18:
        if (Float.compare(this.f481943d, r101.f481943d) == 0) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f481940a * 31;
        if (this.f481941b == false) goto L5;
        int r101 = 1231;
    L7:
        return ((((r100 + r101) * 31) + this.f481942c.hashCode()) * 31) + Float.floatToIntBits(this.f481943d);
    L5:
        r101 = 1237;
        goto L7
    }

    public final String toString() {
        return "WidgetViewInput(maxWidth=" + this.f481940a + ", needAdjustCorner=" + this.f481941b + ", widgetRenderData=" + this.f481942c + ", radius=" + this.f481943d + ')';
    }

    public f(int r100, boolean r101, u r102, float r103) {
        Intrinsics.checkNotNullParameter(r102, "widgetRenderData");
        this.f481940a = r100;
        this.f481941b = r101;
        this.f481942c = r102;
        this.f481943d = r103;
    }
}
