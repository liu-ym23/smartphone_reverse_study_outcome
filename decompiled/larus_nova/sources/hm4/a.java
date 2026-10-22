package hm4;

import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: classes15.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f485914a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f485915b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f485916c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f485917d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Float.compare(this.f485914a, r101.f485914a) == 0) goto L12;
        return false;
    L12:
        if (Float.compare(this.f485915b, r101.f485915b) == 0) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (Float.floatToIntBits(this.f485914a) * 31) + Float.floatToIntBits(this.f485915b);
    }

    public final String toString() {
        return "AvailableWindowSize(width=" + this.f485914a + ", height=" + this.f485915b + ')';
    }

    public static DisplayMetrics a(Resources r100) {
        return WindowDisplayMetricsOverride.apply(r100, r100.getDisplayMetrics());
    }

    public a(float r100, float r101) {
        this.f485914a = r100;
        this.f485915b = r101;
        this.f485916c = MathKt.roundToInt(TypedValue.applyDimension(1, r100, a(Resources.getSystem())));
        this.f485917d = MathKt.roundToInt(TypedValue.applyDimension(1, r101, a(Resources.getSystem())));
    }
}
