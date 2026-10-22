package no9;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f519976a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f519977b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f519978c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f519976a, r101.f519976a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f519977b, r101.f519977b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f519978c, r101.f519978c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        return (((this.f519976a.hashCode() * 31) + this.f519977b.hashCode()) * 31) + this.f519978c.hashCode();
    }

    public final String toString() {
        return "FeishuFlowAILarkDoc(token=" + this.f519976a + ", title=" + this.f519977b + ", url=" + this.f519978c + ')';
    }

    public a(String r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "token");
        Intrinsics.checkNotNullParameter(r101, "title");
        Intrinsics.checkNotNullParameter(r102, "url");
        this.f519976a = r100;
        this.f519977b = r101;
        this.f519978c = r102;
    }
}
