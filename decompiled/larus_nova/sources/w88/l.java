package w88;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes23.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f558690a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f558691b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f558692c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof l) == true) goto L8;
        return false;
    L8:
        l r101 = (l) r100;
        if (Intrinsics.areEqual(this.f558690a, r101.f558690a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f558691b, r101.f558691b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f558692c, r101.f558692c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        return (((this.f558690a.hashCode() * 31) + this.f558691b.hashCode()) * 31) + this.f558692c.hashCode();
    }

    public final String toString() {
        return "DoraSimulSubtitleItem(id=" + this.f558690a + ", originalText=" + this.f558691b + ", translationText=" + this.f558692c + ')';
    }

    public l(String r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "id");
        Intrinsics.checkNotNullParameter(r101, "originalText");
        Intrinsics.checkNotNullParameter(r102, "translationText");
        this.f558690a = r100;
        this.f558691b = r101;
        this.f558692c = r102;
    }

    public static l a(l r100, String r101, String r102, int r103) {
        if ((r103 & 1) == 0) goto L5;
        String r104 = r100.f558690a;
    L7:
        if ((r103 & 2) == 0) goto L10;
        r101 = r100.f558691b;
    L10:
        if ((r103 & 4) == 0) goto L12;
        r102 = r100.f558692c;
    L12:
        Intrinsics.checkNotNullParameter(r104, "id");
        Intrinsics.checkNotNullParameter(r101, "originalText");
        Intrinsics.checkNotNullParameter(r102, "translationText");
        return new l(r104, r101, r102);
    L5:
        r104 = null;
        goto L7
    }
}
