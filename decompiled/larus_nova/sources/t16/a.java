package t16;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f544151a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f544152b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f544153c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f544151a, r101.f544151a) == true) goto L12;
        return false;
    L12:
        if (this.f544152b == r101.f544152b) goto L15;
        return false;
    L15:
        if (this.f544153c == r101.f544153c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f544151a.hashCode() * 31;
        if (this.f544152b == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = (r100 + r101) * 31;
        long r103 = this.f544153c;
        return r102 + ((int) (r103 ^ (r103 >>> 32)));
    L5:
        r101 = 1237;
        goto L6
    }

    public final String toString() {
        return "JSFileCacheModel(filePath=" + this.f544151a + ", fromOffline=" + this.f544152b + ", loadDuration=" + this.f544153c + ')';
    }

    public a(String r100, boolean r101, long r102) {
        Intrinsics.checkNotNullParameter(r100, "filePath");
        this.f544151a = r100;
        this.f544152b = r101;
        this.f544153c = r102;
    }
}
