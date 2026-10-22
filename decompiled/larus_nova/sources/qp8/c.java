package qp8;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f534367a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f534368b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f534369c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f534370d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (Intrinsics.areEqual(this.f534367a, r101.f534367a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f534368b, r101.f534368b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f534369c, r101.f534369c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f534370d, r101.f534370d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        return (((((this.f534367a.hashCode() * 31) + this.f534368b.hashCode()) * 31) + this.f534369c.hashCode()) * 31) + this.f534370d.hashCode();
    }

    public final String toString() {
        return "OfficeMentionContact(id=" + this.f534367a + ", name=" + this.f534368b + ", avatarKey=" + this.f534369c + ", description=" + this.f534370d + ')';
    }

    public c(String r100, String r101, String r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, "id");
        Intrinsics.checkNotNullParameter(r101, "name");
        Intrinsics.checkNotNullParameter(r102, "avatarKey");
        Intrinsics.checkNotNullParameter(r103, "description");
        this.f534367a = r100;
        this.f534368b = r101;
        this.f534369c = r102;
        this.f534370d = r103;
    }
}
