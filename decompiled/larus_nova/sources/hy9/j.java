package hy9;

import kotlin.jvm.internal.Intrinsics;
import mr9.l;

/* JADX INFO: loaded from: classes31.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final l f487660a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f487661b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f487662c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f487663d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof j) == true) goto L8;
        return false;
    L8:
        j r101 = (j) r100;
        if (Intrinsics.areEqual(this.f487660a, r101.f487660a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f487661b, r101.f487661b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f487662c, r101.f487662c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f487663d, r101.f487663d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        return (((((this.f487660a.hashCode() * 31) + this.f487661b.hashCode()) * 31) + this.f487662c.hashCode()) * 31) + this.f487663d.hashCode();
    }

    public final String toString() {
        return "UploadSuccessData(result=" + this.f487660a + ", filePath=" + this.f487661b + ", localImageMsgId=" + this.f487662c + ", localTextMsgId=" + this.f487663d + ')';
    }

    public j(l r100, String r101, String r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, "result");
        Intrinsics.checkNotNullParameter(r101, "filePath");
        Intrinsics.checkNotNullParameter(r102, "localImageMsgId");
        Intrinsics.checkNotNullParameter(r103, "localTextMsgId");
        this.f487660a = r100;
        this.f487661b = r101;
        this.f487662c = r102;
        this.f487663d = r103;
    }
}
