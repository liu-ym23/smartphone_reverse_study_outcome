package xf9;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f563535a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f563536b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f563535a, r101.f563535a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f563536b, r101.f563536b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f563535a.hashCode() * 31) + this.f563536b.hashCode();
    }

    public final String toString() {
        return "FlowWsChannelMsgHeader(key=" + this.f563535a + ", value=" + this.f563536b + ')';
    }

    public b(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "value");
        this.f563535a = r100;
        this.f563536b = r101;
    }
}
