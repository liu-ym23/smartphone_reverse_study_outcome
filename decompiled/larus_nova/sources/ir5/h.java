package ir5;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final f f495479a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f495480b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f495481c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof h) == true) goto L8;
        return false;
    L8:
        h r101 = (h) r100;
        if (Intrinsics.areEqual(this.f495479a, r101.f495479a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f495480b, r101.f495480b) == true) goto L15;
        return false;
    L15:
        if (this.f495481c == r101.f495481c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.f495479a.hashCode() * 31) + this.f495480b.hashCode()) * 31;
        if (this.f495481c == false) goto L5;
        int r101 = 1231;
    L7:
        return r100 + r101;
    L5:
        r101 = 1237;
        goto L7
    }

    public final String toString() {
        return "OfficeDrivePreviewSelection(pageRange=" + this.f495479a + ", text=" + this.f495480b + ", isTruncated=" + this.f495481c + ')';
    }

    public h(f r100, String r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "pageRange");
        Intrinsics.checkNotNullParameter(r101, "text");
        this.f495479a = r100;
        this.f495480b = r101;
        this.f495481c = r102;
    }
}
