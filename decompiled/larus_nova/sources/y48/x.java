package y48;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class x extends o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CharSequence f566143a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Integer f566144b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Integer f566145c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Float f566146d;

    public x() {
        this(null, null, 15);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof x) == true) goto L8;
        return false;
    L8:
        x r101 = (x) r100;
        if (Intrinsics.areEqual(this.f566143a, r101.f566143a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f566144b, r101.f566144b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f566145c, r101.f566145c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f566146d, r101.f566146d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        CharSequence r100 = this.f566143a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Integer r104 = this.f566144b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Integer r107 = this.f566145c;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        Float r110 = this.f566146d;
        if (r110 == null) goto L19;
        r101 = r110.hashCode();
    L19:
        return r109 + r101;
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "ChatSpeakerTipsStyle(text=" + this.f566143a + ", textColor=" + this.f566144b + ", backgroundRes=" + this.f566145c + ", alpha=" + this.f566146d + ')';
    }

    public x(CharSequence r100, Integer r101, int r102) {
        if ((r102 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = null;
    L8:
        this.f566143a = r100;
        this.f566144b = r101;
        this.f566145c = null;
        this.f566146d = null;
    }
}
