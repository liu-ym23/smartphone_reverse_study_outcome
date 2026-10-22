package zs7;

import android.content.res.Resources;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;

/* JADX INFO: loaded from: classes22.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f573487a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f573488b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f573489c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == false) goto L10;
        a r101 = (a) r100;
        if (Float.compare(this.f573488b, r101.f573488b) == 0) goto L8;
        return false;
    L8:
        if (this.f573489c == r101.f573489c) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        return (Float.floatToIntBits(this.f573488b) * 31) + this.f573489c;
    }

    public final String toString() {
        return "TexSize(size=" + this.f573488b + ", unit=" + this.f573489c + ")";
    }

    public a(float r100, int r101) {
        this.f573488b = r100;
        this.f573489c = r101;
        Resources r102 = xs7.a.f565005a;
        this.f573487a = WindowDisplayMetricsOverride.apply(r102, r102.getDisplayMetrics()).density;
    }
}
