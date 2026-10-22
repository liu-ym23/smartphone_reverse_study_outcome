package dib;

import com.ss.android.lark.forseti.widget.bean.ArrowDirection;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f468867a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f468868b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ArrowDirection f468869c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float f468870d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final float f468871e;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (this.f468867a == r101.f468867a) goto L12;
        return false;
    L12:
        if (this.f468868b == r101.f468868b) goto L15;
        return false;
    L15:
        if (this.f468869c == r101.f468869c) goto L18;
        return false;
    L18:
        if (Float.compare(this.f468870d, r101.f468870d) == 0) goto L21;
        return false;
    L21:
        if (Float.compare(this.f468871e, r101.f468871e) == 0) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        return (((((((this.f468867a * 31) + this.f468868b) * 31) + this.f468869c.hashCode()) * 31) + Float.floatToIntBits(this.f468870d)) * 31) + Float.floatToIntBits(this.f468871e);
    }

    public final String toString() {
        return "PopoverPosition(popoverLeft=" + this.f468867a + ", popoverTop=" + this.f468868b + ", arrowDirection=" + this.f468869c + ", arrowX=" + this.f468870d + ", arrowY=" + this.f468871e + ')';
    }

    public a(int r100, int r101, ArrowDirection r102, float r103, float r104) {
        Intrinsics.checkNotNullParameter(r102, "arrowDirection");
        this.f468867a = r100;
        this.f468868b = r101;
        this.f468869c = r102;
        this.f468870d = r103;
        this.f468871e = r104;
    }
}
