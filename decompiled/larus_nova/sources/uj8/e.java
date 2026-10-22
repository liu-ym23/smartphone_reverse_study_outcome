package uj8;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f550443a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f550444b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f550445c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f550446d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof e) == true) goto L8;
        return false;
    L8:
        e r101 = (e) r100;
        if (Intrinsics.areEqual(this.f550443a, r101.f550443a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f550444b, r101.f550444b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f550445c, r101.f550445c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f550446d, r101.f550446d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f550443a.hashCode() * 31;
        String r101 = this.f550444b;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        String r105 = this.f550445c;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r104 + r106) * 31;
        String r108 = this.f550446d;
        if (r108 == null) goto L15;
        r102 = r108.hashCode();
    L15:
        return r107 + r102;
    L9:
        r106 = r105.hashCode();
        goto L10
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "CommonButtonViewInput(id=" + this.f550443a + ", text=" + this.f550444b + ", iconUrlLight=" + this.f550445c + ", iconUrlDark=" + this.f550446d + ')';
    }

    public e(String r100, String r101, String r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, "id");
        this.f550443a = r100;
        this.f550444b = r101;
        this.f550445c = r102;
        this.f550446d = r103;
    }
}
