package vz1;

import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int[] f557643a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int[] f557644b;

    public b() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof b) == false) goto L10;
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f557643a, r101.f557643a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f557644b, r101.f557644b) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        int[] r100 = this.f557643a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = Arrays.hashCode(r100);
    L6:
        int r103 = r102 * 31;
        int[] r104 = this.f557644b;
        if (r104 == null) goto L10;
        r101 = Arrays.hashCode(r104);
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "CounterBgColor(sectionBgStartColor=" + Arrays.toString(this.f557643a) + ", sectionBgEndColor=" + Arrays.toString(this.f557644b) + ")";
    }

    public /* synthetic */ b(int r100) {
        this(new int[0], new int[0]);
    }

    public b(int[] r100, int[] r101) {
        Intrinsics.checkNotNullParameter(r100, "sectionBgStartColor");
        Intrinsics.checkNotNullParameter(r101, "sectionBgEndColor");
        this.f557643a = r100;
        this.f557644b = r101;
    }
}
