package w49;

import com.larus.dora.impl.device.settings.lab.headcontrol.HeadControlActionOption;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HeadControlActionOption f558269a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HeadControlActionOption f558270b;

    public c() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (this.f558269a == r101.f558269a) goto L12;
        return false;
    L12:
        if (this.f558270b == r101.f558270b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f558269a.hashCode() * 31) + this.f558270b.hashCode();
    }

    public final String toString() {
        return "HeadControlOptionState(nodOption=" + this.f558269a + ", shakeOption=" + this.f558270b + ')';
    }

    public /* synthetic */ c(int r100) {
        HeadControlActionOption r101 = HeadControlActionOption.NONE;
        this(r101, r101);
    }

    public c(HeadControlActionOption r100, HeadControlActionOption r101) {
        Intrinsics.checkNotNullParameter(r100, "nodOption");
        Intrinsics.checkNotNullParameter(r101, "shakeOption");
        this.f558269a = r100;
        this.f558270b = r101;
    }

    public static c a(c r100, HeadControlActionOption r101, HeadControlActionOption r102, int r103) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.f558269a;
    L6:
        if ((r103 & 2) == 0) goto L8;
        r102 = r100.f558270b;
    L8:
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, "nodOption");
        Intrinsics.checkNotNullParameter(r102, "shakeOption");
        return new c(r101, r102);
    }
}
