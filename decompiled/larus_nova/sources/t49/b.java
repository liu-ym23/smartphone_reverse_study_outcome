package t49;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f544603a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<String> f544604b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final CharSequence f544605c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float f544606d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f544607e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final c f544608f;

    public b() {
        throw null;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (this.f544603a == r101.f544603a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f544604b, r101.f544604b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f544605c, r101.f544605c) == true) goto L18;
        return false;
    L18:
        if (Float.compare(this.f544606d, r101.f544606d) == 0) goto L21;
        return false;
    L21:
        if (this.f544607e == r101.f544607e) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f544608f, r101.f544608f) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.f544603a * 31) + this.f544604b.hashCode()) * 31;
        CharSequence r101 = this.f544605c;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (((((r100 + r103) * 31) + Float.floatToIntBits(this.f544606d)) * 31) + this.f544607e) * 31;
        c r105 = this.f544608f;
        if (r105 == null) goto L11;
        r102 = r105.hashCode();
    L11:
        return r104 + r102;
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "Reel(id=" + this.f544603a + ", entries=" + this.f544604b + ", tag=" + this.f544605c + ", widthWeight=" + this.f544606d + ", selectedIndex=" + this.f544607e + ", reelChangedListener=" + this.f544608f + ')';
    }

    public b(int r100, List r101, int r102, c r103) {
        Intrinsics.checkNotNullParameter(r101, "entries");
        this.f544603a = r100;
        this.f544604b = r101;
        this.f544605c = "";
        this.f544606d = 1.0f;
        this.f544607e = r102;
        this.f544608f = r103;
    }
}
