package p43;

import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<?, ?> f527657a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f527658b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<Integer> f527659c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof b) == false) goto L12;
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f527657a, r101.f527657a) == true) goto L8;
        return false;
    L8:
        if (this.f527658b == r101.f527658b) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f527659c, r101.f527659c) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        Map<?, ?> r100 = this.f527657a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = ((r102 * 31) + this.f527658b) * 31;
        List<Integer> r104 = this.f527659c;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "CheckPayStatusParams(requestParams=" + this.f527657a + ", times=" + this.f527658b + ", gaps=" + this.f527659c + ")";
    }

    public b(Map<?, ?> r100, int r101, List<Integer> r102) {
        this.f527657a = r100;
        this.f527658b = r101;
        this.f527659c = r102;
    }
}
