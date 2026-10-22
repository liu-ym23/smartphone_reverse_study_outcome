package kotlin.reflect.jvm.internal.impl.resolve.deprecation;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes42.dex */
public abstract class DeprecationInfo implements Comparable<DeprecationInfo> {
    public DeprecationInfo() {
    }

    public abstract DeprecationLevelValue getDeprecationLevel();

    public abstract boolean getPropagatesToOverrides();

    /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
    public int compareTo2(DeprecationInfo r100) {
        Intrinsics.checkNotNullParameter(r100, "other");
        int r101 = getDeprecationLevel().compareTo(r100.getDeprecationLevel());
        if (r101 == 0) goto L5;
        return r101;
    L5:
        if (getPropagatesToOverrides() == false) goto L7;
        return r101;
    L7:
        if (r100.getPropagatesToOverrides() == false) goto L12;
        return 1;
    L12:
        return r101;
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(DeprecationInfo r100) {
        return compareTo2(r100);
    }
}
