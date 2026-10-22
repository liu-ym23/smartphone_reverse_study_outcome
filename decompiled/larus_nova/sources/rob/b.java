package rob;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f538805a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f538806b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f538807c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f538808d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (this.f538805a == r101.f538805a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f538806b, r101.f538806b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f538807c, r101.f538807c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f538808d, r101.f538808d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f538805a * 31;
        String r101 = this.f538806b;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        String r105 = this.f538807c;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r104 + r106) * 31;
        String r108 = this.f538808d;
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
        return "AsrLanguageData(index=" + this.f538805a + ", chosenLanguageKey=" + this.f538806b + ", languageKey=" + this.f538807c + ", languageName=" + this.f538808d + ')';
    }

    public b(int r100, String r101, String r102, String r103) {
        this.f538805a = r100;
        this.f538806b = r101;
        this.f538807c = r102;
        this.f538808d = r103;
    }
}
