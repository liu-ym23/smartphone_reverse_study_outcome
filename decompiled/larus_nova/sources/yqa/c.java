package yqa;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f568879a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f568880b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f568881c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f568882d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f568883e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f568884f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f568885g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f568886h;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof c) == true) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(this.f568886h, ((c) r100).f568886h) == true) goto L13;
        return false;
    L13:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f568886h;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.hashCode();
    }

    public final String toString() {
        return "GetTokenResult(loginScene=" + this.f568886h + ")";
    }

    public c(String r100) {
        this.f568886h = r100;
        this.f568880b = "";
        this.f568881c = "";
    }
}
