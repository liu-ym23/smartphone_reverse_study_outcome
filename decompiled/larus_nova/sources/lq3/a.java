package lq3;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class a<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f510290a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Class<T> f510291b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == false) goto L10;
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f510290a, r101.f510290a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f510291b, r101.f510291b) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        String r100 = this.f510290a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Class<T> r104 = this.f510291b;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "ComponentScene(name=" + this.f510290a + ", sceneClass=" + this.f510291b + ")";
    }

    public a(String r100, Class<T> r101) {
        Intrinsics.checkNotNullParameter(r100, "name");
        Intrinsics.checkNotNullParameter(r101, "sceneClass");
        this.f510290a = r100;
        this.f510291b = r101;
    }
}
