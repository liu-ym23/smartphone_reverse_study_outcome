package iub;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<n> f495810a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final n f495811b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final n f495812c;

    public c() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (Intrinsics.areEqual(this.f495810a, r101.f495810a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f495811b, r101.f495811b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f495812c, r101.f495812c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f495810a.hashCode() * 31;
        n r101 = this.f495811b;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        n r105 = this.f495812c;
        if (r105 == null) goto L11;
        r102 = r105.hashCode();
    L11:
        return r104 + r102;
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "MmAIInterpretationLanguageState(supportLanguages=" + this.f495810a + ", selectedLanguage=" + this.f495811b + ", activeLanguage=" + this.f495812c + ')';
    }

    public /* synthetic */ c(int r100) {
        this(CollectionsKt.emptyList(), null, null);
    }

    public c(List<n> r100, n r101, n r102) {
        Intrinsics.checkNotNullParameter(r100, "supportLanguages");
        this.f495810a = r100;
        this.f495811b = r101;
        this.f495812c = r102;
    }
}
