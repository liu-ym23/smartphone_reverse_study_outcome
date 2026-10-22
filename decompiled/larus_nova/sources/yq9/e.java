package yq9;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f568873a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f568874b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f568875c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f568876d;

    public static final class a {
    }

    static {
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof e) == true) goto L8;
        return false;
    L8:
        e r101 = (e) r100;
        if (Intrinsics.areEqual(this.f568873a, r101.f568873a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f568874b, r101.f568874b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f568875c, r101.f568875c) == true) goto L18;
        return false;
    L18:
        if (this.f568876d == r101.f568876d) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f568873a.hashCode() * 31;
        String r101 = this.f568874b;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        String r105 = this.f568875c;
        if (r105 == null) goto L10;
        r102 = r105.hashCode();
    L10:
        long r106 = this.f568876d;
        return ((r104 + r102) * 31) + ((int) (r106 ^ (r106 >>> 32)));
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "FlowVideoEngineInfos(key=" + this.f568873a + ", usingMDLPlayTaskKey=" + this.f568874b + ", usingMDLPlayFilePath=" + this.f568875c + ", hitCacheSize=" + this.f568876d + ')';
    }

    public e(String r100, String r101, String r102, long r103) {
        Intrinsics.checkNotNullParameter(r100, "key");
        this.f568873a = r100;
        this.f568874b = r101;
        this.f568875c = r102;
        this.f568876d = r103;
    }
}
