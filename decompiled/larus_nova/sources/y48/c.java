package y48;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class c extends o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CharSequence f566073a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Integer f566074b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Integer f566075c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Integer f566076d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Float f566077e;

    public c() {
        this(null, null, null, 31);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (Intrinsics.areEqual(this.f566073a, r101.f566073a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f566074b, r101.f566074b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f566075c, r101.f566075c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f566076d, r101.f566076d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f566077e, r101.f566077e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        CharSequence r100 = this.f566073a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Integer r104 = this.f566074b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Integer r107 = this.f566075c;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        Integer r110 = this.f566076d;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        Float r113 = this.f566077e;
        if (r113 == null) goto L23;
        r101 = r113.hashCode();
    L23:
        return r112 + r101;
    L17:
        r111 = r110.hashCode();
        goto L18
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
        return "ChatSpeakerActionAreaStyle(text=" + this.f566073a + ", textColor=" + this.f566074b + ", iconRes=" + this.f566075c + ", backgroundRes=" + this.f566076d + ", alpha=" + this.f566077e + ')';
    }

    public c(CharSequence r100, Integer r101, Integer r102, int r103) {
        if ((r103 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r103 & 4) == 0) goto L11;
        r102 = null;
    L11:
        this.f566073a = r100;
        this.f566074b = r101;
        this.f566075c = r102;
        this.f566076d = null;
        this.f566077e = null;
    }
}
