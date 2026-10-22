package i02;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f487866a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<e> f487867b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f487868c;

    public d() {
        this(null, null, 0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof d) == false) goto L12;
        d r101 = (d) r100;
        if (Intrinsics.areEqual(this.f487866a, r101.f487866a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f487867b, r101.f487867b) == true) goto L10;
        return false;
    L10:
        if (this.f487868c == r101.f487868c) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        String r100 = this.f487866a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        List<e> r104 = this.f487867b;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return ((r103 + r101) * 31) + this.f487868c;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "SlotChangeEvent(sendTogetherId=" + this.f487866a + ", slotList=" + this.f487867b + ", currentCount=" + this.f487868c + ")";
    }

    public d(String r100, List<e> r101, int r102) {
        this.f487866a = r100;
        this.f487867b = r101;
        this.f487868c = r102;
    }
}
