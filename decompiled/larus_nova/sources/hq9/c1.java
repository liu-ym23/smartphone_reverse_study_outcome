package hq9;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class c1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f486556a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f486557b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f486558c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f486559d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c1) == true) goto L8;
        return false;
    L8:
        c1 r101 = (c1) r100;
        if (Intrinsics.areEqual(this.f486556a, r101.f486556a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f486557b, r101.f486557b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f486558c, r101.f486558c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f486559d, r101.f486559d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        return (((((this.f486556a.hashCode() * 31) + this.f486557b.hashCode()) * 31) + this.f486558c.hashCode()) * 31) + this.f486559d.hashCode();
    }

    public final String toString() {
        return "FeedbackConfig(baseUrl=" + this.f486556a + ", sourceLogin=" + this.f486557b + ", sourceSetting=" + this.f486558c + ", sourcePayment=" + this.f486559d + ')';
    }

    public c1(String r100, String r101, String r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, "baseUrl");
        Intrinsics.checkNotNullParameter(r101, "sourceLogin");
        Intrinsics.checkNotNullParameter(r102, "sourceSetting");
        Intrinsics.checkNotNullParameter(r103, "sourcePayment");
        this.f486556a = r100;
        this.f486557b = r101;
        this.f486558c = r102;
        this.f486559d = r103;
    }
}
