package ea8;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f471658a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f471659b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f471660c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof w) == true) goto L8;
        return false;
    L8:
        w r101 = (w) r100;
        if (Intrinsics.areEqual(this.f471658a, r101.f471658a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f471659b, r101.f471659b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f471660c, r101.f471660c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        return (((this.f471658a.hashCode() * 31) + this.f471659b.hashCode()) * 31) + this.f471660c.hashCode();
    }

    public final String toString() {
        return "TranslationResultItem(id=" + this.f471658a + ", originalText=" + this.f471659b + ", translationText=" + this.f471660c + ')';
    }

    public w(String r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "id");
        Intrinsics.checkNotNullParameter(r101, "originalText");
        Intrinsics.checkNotNullParameter(r102, "translationText");
        this.f471658a = r100;
        this.f471659b = r101;
        this.f471660c = r102;
    }

    public static w a(w r100, String r101, String r102, int r103) {
        if ((r103 & 1) == 0) goto L5;
        String r104 = r100.f471658a;
    L7:
        if ((r103 & 2) == 0) goto L10;
        r101 = r100.f471659b;
    L10:
        if ((r103 & 4) == 0) goto L12;
        r102 = r100.f471660c;
    L12:
        r100.getClass();
        Intrinsics.checkNotNullParameter(r104, "id");
        Intrinsics.checkNotNullParameter(r101, "originalText");
        Intrinsics.checkNotNullParameter(r102, "translationText");
        return new w(r104, r101, r102);
    L5:
        r104 = null;
        goto L7
    }
}
