package kb8;

import com.larus.bmhome.chat.bean.DeepThinkFoldStatus;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f502239a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f502240b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<u> f502241c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final o f502242d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f502243e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f502244f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final DeepThinkFoldStatus f502245g;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof i) == true) goto L8;
        return false;
    L8:
        i r101 = (i) r100;
        if (this.f502239a == r101.f502239a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f502240b, r101.f502240b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f502241c, r101.f502241c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f502242d, r101.f502242d) == true) goto L21;
        return false;
    L21:
        if (this.f502243e == r101.f502243e) goto L24;
        return false;
    L24:
        if (this.f502244f == r101.f502244f) goto L27;
        return false;
    L27:
        if (this.f502245g == r101.f502245g) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        int r100 = 1231;
        if (this.f502239a == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = ((((r101 * 31) + this.f502240b.hashCode()) * 31) + this.f502241c.hashCode()) * 31;
        o r103 = this.f502242d;
        if (r103 != null) goto L9;
        int r104 = 0;
    L10:
        int r105 = (r102 + r104) * 31;
        if (this.f502243e == false) goto L13;
        int r106 = 1231;
    L14:
        int r107 = (r105 + r106) * 31;
        if (this.f502244f == true) goto L19;
        r100 = 1237;
    L19:
        return ((r107 + r100) * 31) + this.f502245g.hashCode();
    L13:
        r106 = 1237;
        goto L14
    L9:
        r104 = r103.hashCode();
        goto L10
    L5:
        r101 = 1237;
        goto L6
    }

    public final String toString() {
        return "QueryKeywordReferencesViewInput(needSetData=" + this.f502239a + ", queries=" + this.f502240b + ", referenceList=" + this.f502241c + ", referenceData=" + this.f502242d + ", needReferenceShowAnimation=" + this.f502243e + ", needNotifyLastItemChanged=" + this.f502244f + ", foldStatus=" + this.f502245g + ')';
    }

    public i(boolean r100, String r101, List<u> r102, o r103, boolean r104, boolean r105, DeepThinkFoldStatus r106) {
        Intrinsics.checkNotNullParameter(r101, "queries");
        Intrinsics.checkNotNullParameter(r102, "referenceList");
        Intrinsics.checkNotNullParameter(r106, "foldStatus");
        this.f502239a = r100;
        this.f502240b = r101;
        this.f502241c = r102;
        this.f502242d = r103;
        this.f502243e = r104;
        this.f502244f = r105;
        this.f502245g = r106;
    }
}
