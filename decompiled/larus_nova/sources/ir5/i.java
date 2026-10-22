package ir5;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f495482a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f495483b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f495484c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f495485d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List<h> f495486e;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof i) == true) goto L8;
        return false;
    L8:
        i r101 = (i) r100;
        if (Intrinsics.areEqual(this.f495482a, r101.f495482a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f495483b, r101.f495483b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f495484c, r101.f495484c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f495485d, r101.f495485d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f495486e, r101.f495486e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.f495482a.hashCode() * 31) + this.f495483b.hashCode()) * 31;
        String r101 = this.f495484c;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return ((((r100 + r102) * 31) + this.f495485d.hashCode()) * 31) + this.f495486e.hashCode();
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public final String toString() {
        return "OfficeDrivePreviewSelectionContext(sessionId=" + this.f495482a + ", resourceKey=" + this.f495483b + ", resourceExt=" + this.f495484c + ", resourceVersion=" + this.f495485d + ", selections=" + this.f495486e + ')';
    }

    public i(String r100, String r101, String r102, String r103, List<h> r104) {
        Intrinsics.checkNotNullParameter(r100, "sessionId");
        Intrinsics.checkNotNullParameter(r101, "resourceKey");
        Intrinsics.checkNotNullParameter(r103, "resourceVersion");
        Intrinsics.checkNotNullParameter(r104, "selections");
        this.f495482a = r100;
        this.f495483b = r101;
        this.f495484c = r102;
        this.f495485d = r103;
        this.f495486e = r104;
    }
}
