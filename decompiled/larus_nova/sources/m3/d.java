package m3;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f511691a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f511692b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f511693c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<c> f511694d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final b f511695e;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof d) == true) goto L8;
        return false;
    L8:
        d r101 = (d) r100;
        if (Intrinsics.areEqual(this.f511691a, r101.f511691a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f511692b, r101.f511692b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f511693c, r101.f511693c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f511694d, r101.f511694d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f511695e, r101.f511695e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        a r100 = this.f511691a;
        if (r100 != null) goto L5;
        int r101 = 0;
    L7:
        return (((((((r101 * 31) + this.f511692b.hashCode()) * 31) + this.f511693c.hashCode()) * 31) + this.f511694d.hashCode()) * 31) + this.f511695e.hashCode();
    L5:
        r101 = r100.hashCode();
        goto L7
    }

    public final String toString() {
        return "DoubaoBottomSheetConfig(appInfo=" + this.f511691a + ", title=" + this.f511692b + ", content=" + this.f511693c + ", buttons=" + this.f511694d + ", behavior=" + this.f511695e + ')';
    }

    public d(a r100, String r101, String r102, List<c> r103, b r104) {
        Intrinsics.checkNotNullParameter(r101, "title");
        Intrinsics.checkNotNullParameter(r102, "content");
        Intrinsics.checkNotNullParameter(r103, "buttons");
        Intrinsics.checkNotNullParameter(r104, "behavior");
        this.f511691a = r100;
        this.f511692b = r101;
        this.f511693c = r102;
        this.f511694d = r103;
        this.f511695e = r104;
    }
}
