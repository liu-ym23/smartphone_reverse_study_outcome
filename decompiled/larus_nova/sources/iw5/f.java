package iw5;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f496233a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f496234b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f496235c;

    public f() {
        this("", "", true);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof f) == true) goto L8;
        return false;
    L8:
        f r101 = (f) r100;
        if (Intrinsics.areEqual(this.f496233a, r101.f496233a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f496234b, r101.f496234b) == true) goto L15;
        return false;
    L15:
        if (this.f496235c == r101.f496235c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.f496233a.hashCode() * 31) + this.f496234b.hashCode()) * 31;
        if (this.f496235c == false) goto L5;
        int r101 = 1231;
    L7:
        return r100 + r101;
    L5:
        r101 = 1237;
        goto L7
    }

    public final String toString() {
        return "FlowAsrStreamSentence(streamingSentence=" + this.f496233a + ", definiteSentence=" + this.f496234b + ", isInterim=" + this.f496235c + ')';
    }

    public f(String r100, String r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "streamingSentence");
        Intrinsics.checkNotNullParameter(r101, "definiteSentence");
        this.f496233a = r100;
        this.f496234b = r101;
        this.f496235c = r102;
    }
}
