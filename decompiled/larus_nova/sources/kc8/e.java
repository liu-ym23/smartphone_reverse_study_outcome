package kc8;

import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HashMap<String, Boolean> f502473a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HashMap<String, i0> f502474b;

    public e() {
        this(null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof e) == true) goto L8;
        return false;
    L8:
        e r101 = (e) r100;
        if (Intrinsics.areEqual(this.f502473a, r101.f502473a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f502474b, r101.f502474b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f502473a.hashCode() * 31) + this.f502474b.hashCode();
    }

    public final String toString() {
        return "BlockPipeTransferConfig(deepThinkHideSplitHashMap=" + this.f502473a + ", promotedBlockSourceContextMap=" + this.f502474b + ')';
    }

    public e(Object r100) {
        HashMap<String, Boolean> r101 = new HashMap();
        HashMap<String, i0> r102 = new HashMap();
        Intrinsics.checkNotNullParameter(r101, "deepThinkHideSplitHashMap");
        Intrinsics.checkNotNullParameter(r102, "promotedBlockSourceContextMap");
        this.f502473a = r101;
        this.f502474b = r102;
    }
}
