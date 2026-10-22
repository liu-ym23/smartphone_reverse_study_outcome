package tv3;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f547680a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f547681b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f547682c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f547683d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f547684e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f547685f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f547686g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final List<String> f547687h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final List<String> f547688i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final List<String> f547689j;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof d) == true) goto L8;
        return false;
    L8:
        d r101 = (d) r100;
        if (Intrinsics.areEqual(this.f547680a, r101.f547680a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f547681b, r101.f547681b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f547682c, r101.f547682c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f547683d, r101.f547683d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f547684e, r101.f547684e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f547685f, r101.f547685f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f547686g, r101.f547686g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f547687h, r101.f547687h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f547688i, r101.f547688i) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.f547689j, r101.f547689j) == true) goto L38;
        return false;
    L38:
        return true;
    }

    public final int hashCode() {
        return (((((((((((((((((this.f547680a.hashCode() * 31) + this.f547681b.hashCode()) * 31) + this.f547682c.hashCode()) * 31) + this.f547683d.hashCode()) * 31) + this.f547684e.hashCode()) * 31) + this.f547685f.hashCode()) * 31) + this.f547686g.hashCode()) * 31) + this.f547687h.hashCode()) * 31) + this.f547688i.hashCode()) * 31) + this.f547689j.hashCode();
    }

    public final String toString() {
        return "OutlinkSession(outlinkId=" + this.f547680a + ", startPoint=" + this.f547681b + ", endPoint=" + this.f547682c + ", transportMode=" + this.f547683d + ", outlinkMode=" + this.f547684e + ", fromDetail=" + this.f547685f + ", backup=" + this.f547686g + ", dialogAppList=" + this.f547687h + ", installedList=" + this.f547688i + ", allowedList=" + this.f547689j + ')';
    }

    public d(String r100, String r101, String r102, String r103, String r104, String r105, String r106, List<String> r107, List<String> r110, List<String> r111) {
        Intrinsics.checkNotNullParameter(r100, "outlinkId");
        Intrinsics.checkNotNullParameter(r101, "startPoint");
        Intrinsics.checkNotNullParameter(r102, "endPoint");
        Intrinsics.checkNotNullParameter(r103, "transportMode");
        Intrinsics.checkNotNullParameter(r104, "outlinkMode");
        Intrinsics.checkNotNullParameter(r105, "fromDetail");
        Intrinsics.checkNotNullParameter(r106, "backup");
        Intrinsics.checkNotNullParameter(r107, "dialogAppList");
        Intrinsics.checkNotNullParameter(r110, "installedList");
        Intrinsics.checkNotNullParameter(r111, "allowedList");
        this.f547680a = r100;
        this.f547681b = r101;
        this.f547682c = r102;
        this.f547683d = r103;
        this.f547684e = r104;
        this.f547685f = r105;
        this.f547686g = r106;
        this.f547687h = r107;
        this.f547688i = r110;
        this.f547689j = r111;
    }
}
