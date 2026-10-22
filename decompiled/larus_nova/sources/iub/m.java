package iub;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f495855a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final n f495856b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final n f495857c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<n> f495858d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List<n> f495859e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f495860f;

    public m() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof m) == true) goto L8;
        return false;
    L8:
        m r101 = (m) r100;
        if (Intrinsics.areEqual(this.f495855a, r101.f495855a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f495856b, r101.f495856b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f495857c, r101.f495857c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f495858d, r101.f495858d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f495859e, r101.f495859e) == true) goto L24;
        return false;
    L24:
        if (this.f495860f == r101.f495860f) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((((((this.f495855a.hashCode() * 31) + this.f495856b.hashCode()) * 31) + this.f495857c.hashCode()) * 31) + this.f495858d.hashCode()) * 31) + this.f495859e.hashCode()) * 31;
        if (this.f495860f == false) goto L5;
        int r101 = 1231;
    L7:
        return r100 + r101;
    L5:
        r101 = 1237;
        goto L7
    }

    public final String toString() {
        return "MmRecordingLanguageData(recordingId=" + this.f495855a + ", currSpokenLanguage=" + this.f495856b + ", currTranslateLanguage=" + this.f495857c + ", spokenLanguageList=" + this.f495858d + ", translateLanguageList=" + this.f495859e + ", isBilingual=" + this.f495860f + ')';
    }

    public /* synthetic */ m(int r100) {
        this("", new n(0), new n(0), CollectionsKt.emptyList(), CollectionsKt.emptyList(), false);
    }

    public m(String r100, n r101, n r102, List<n> r103, List<n> r104, boolean r105) {
        Intrinsics.checkNotNullParameter(r100, "recordingId");
        Intrinsics.checkNotNullParameter(r101, "currSpokenLanguage");
        Intrinsics.checkNotNullParameter(r102, "currTranslateLanguage");
        Intrinsics.checkNotNullParameter(r103, "spokenLanguageList");
        Intrinsics.checkNotNullParameter(r104, "translateLanguageList");
        this.f495855a = r100;
        this.f495856b = r101;
        this.f495857c = r102;
        this.f495858d = r103;
        this.f495859e = r104;
        this.f495860f = r105;
    }
}
