package pn0;

import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f529939a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f529940b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<Integer, List<Integer>> f529941c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof g) == false) goto L12;
        g r101 = (g) r100;
        if (this.f529939a == r101.f529939a) goto L8;
        return false;
    L8:
        if (this.f529940b == r101.f529940b) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f529941c, r101.f529941c) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        int r100 = ((this.f529939a * 31) + this.f529940b) * 31;
        Map<Integer, List<Integer>> r101 = this.f529941c;
        if (r101 == null) goto L5;
        int r102 = r101.hashCode();
    L7:
        return r100 + r102;
    L5:
        r102 = 0;
        goto L7
    }

    public final String toString() {
        StringBuilder r100 = new StringBuilder("{modifiedUILayout = ");
        r100.append(this.f529939a);
        r100.append(", modifiedOrientation = ");
        r100.append(this.f529940b);
        r100.append("}, modifyUIFeatureConfigOffsetMapSize = ");
        Map<Integer, List<Integer>> r101 = this.f529941c;
        if (r101 == null) goto L5;
        Integer r102 = Integer.valueOf(r101.size());
    L6:
        r100.append(r102);
        return r100.toString();
    L5:
        r102 = null;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    public g(int r100, int r101, Map<Integer, ? extends List<Integer>> r102) {
        this.f529939a = r100;
        this.f529940b = r101;
        this.f529941c = r102;
    }
}
