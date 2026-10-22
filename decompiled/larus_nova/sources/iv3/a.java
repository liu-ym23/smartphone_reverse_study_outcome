package iv3;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f495928a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<String> f495929b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final CharSequence f495930c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float f495931d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Integer f495932e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Integer f495933f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Integer f495934g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f495935h;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (this.f495928a == r101.f495928a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f495929b, r101.f495929b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f495930c, r101.f495930c) == true) goto L18;
        return false;
    L18:
        if (Float.compare(this.f495931d, r101.f495931d) == 0) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f495932e, r101.f495932e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f495933f, r101.f495933f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f495934g, r101.f495934g) == true) goto L30;
        return false;
    L30:
        if (this.f495935h == r101.f495935h) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(null, null) == true) goto L35;
        return false;
    L35:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.f495928a * 31) + this.f495929b.hashCode()) * 31;
        CharSequence r101 = this.f495930c;
        if (r101 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = (((r100 + r102) * 31) + Float.floatToIntBits(this.f495931d)) * 31;
        Integer r104 = this.f495932e;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Integer r107 = this.f495933f;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        Integer r110 = this.f495934g;
        if (r110 != null) goto L17;
        int r111 = 0;
    L19:
        return ((((r109 + r111) * 31) + this.f495935h) * 31) + 0;
    L17:
        r111 = r110.hashCode();
        goto L19
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "Reel(id=" + this.f495928a + ", entries=" + this.f495929b + ", tag=" + this.f495930c + ", widthWeight=" + this.f495931d + ", width=" + this.f495932e + ", minWidth=" + this.f495933f + ", tagGap=" + this.f495934g + ", selectedIndex=" + this.f495935h + ", reelChangedListener=null)";
    }

    public a(int r100, List r101, Integer r102, int r103) {
        Intrinsics.checkNotNullParameter(r101, "entries");
        this.f495928a = r100;
        this.f495929b = r101;
        this.f495930c = null;
        this.f495931d = 1.0f;
        this.f495932e = null;
        this.f495933f = r102;
        this.f495934g = null;
        this.f495935h = r103;
    }
}
