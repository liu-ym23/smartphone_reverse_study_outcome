package dw8;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f470336a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f470337b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f470338c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f470339d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final b f470340e;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof e) == true) goto L8;
        return false;
    L8:
        e r101 = (e) r100;
        if (Intrinsics.areEqual(this.f470336a, r101.f470336a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f470337b, r101.f470337b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f470338c, r101.f470338c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f470339d, r101.f470339d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f470340e, r101.f470340e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.f470336a.hashCode() * 31) + this.f470337b.hashCode()) * 31;
        String r101 = this.f470338c;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        String r105 = this.f470339d;
        if (r105 == null) goto L11;
        r102 = r105.hashCode();
    L11:
        return ((r104 + r102) * 31) + this.f470340e.hashCode();
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "AIChatActionBarGroupItem(id=" + this.f470336a + ", title=" + this.f470337b + ", iconUrl=" + this.f470338c + ", darkModeIconUrl=" + this.f470339d + ", action=" + this.f470340e + ')';
    }

    public e(String r100, String r101, String r102, String r103, b r104) {
        Intrinsics.checkNotNullParameter(r100, "id");
        Intrinsics.checkNotNullParameter(r101, "title");
        Intrinsics.checkNotNullParameter(r104, "action");
        this.f470336a = r100;
        this.f470337b = r101;
        this.f470338c = r102;
        this.f470339d = r103;
        this.f470340e = r104;
    }
}
