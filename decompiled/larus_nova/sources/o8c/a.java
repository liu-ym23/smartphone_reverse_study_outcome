package o8c;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f522425a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f522426b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f522427c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f522428d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f522425a, r101.f522425a) == true) goto L12;
        return false;
    L12:
        if (this.f522426b == r101.f522426b) goto L15;
        return false;
    L15:
        if (this.f522427c == r101.f522427c) goto L18;
        return false;
    L18:
        if (this.f522428d == r101.f522428d) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.f522425a.hashCode() * 31) + this.f522426b) * 31;
        int r101 = 1231;
        if (this.f522427c == false) goto L5;
        int r102 = 1231;
    L6:
        int r103 = (r100 + r102) * 31;
        if (this.f522428d == true) goto L11;
        r101 = 1237;
    L11:
        return r103 + r101;
    L5:
        r102 = 1237;
        goto L6
    }

    public final String toString() {
        return "TextAttributes(textStr=" + this.f522425a + ", textColor=" + this.f522426b + ", isEnable=" + this.f522427c + ", isHighlight=" + this.f522428d + ')';
    }

    public a(String r100, int r101, boolean r102, boolean r103) {
        Intrinsics.checkNotNullParameter(r100, "textStr");
        this.f522425a = r100;
        this.f522426b = r101;
        this.f522427c = r102;
        this.f522428d = r103;
    }
}
