package ts9;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function0<String> f547422a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function0<List<String>> f547423b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f547424c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f547425d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List<String> f547426e;

    public a() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f547422a, r101.f547422a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f547423b, r101.f547423b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f547424c, r101.f547424c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f547425d, r101.f547425d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f547426e, r101.f547426e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        Function0<String> r100 = this.f547422a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Function0<List<String>> r104 = this.f547423b;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return ((((((r103 + r101) * 31) + this.f547424c.hashCode()) * 31) + this.f547425d.hashCode()) * 31) + this.f547426e.hashCode();
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "SearchModel(xTTToken=" + this.f547422a + ", websiteHostWhiteList=" + this.f547423b + ", boeHost=" + this.f547424c + ", onlineHost=" + this.f547425d + ", webWhiteList=" + this.f547426e + ')';
    }

    public /* synthetic */ a(int r100) {
        this(null, null, "", "", CollectionsKt.emptyList());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public a(Function0<String> r100, Function0<? extends List<String>> r101, String r102, String r103, List<String> r104) {
        Intrinsics.checkNotNullParameter(r102, "boeHost");
        Intrinsics.checkNotNullParameter(r103, "onlineHost");
        Intrinsics.checkNotNullParameter(r104, "webWhiteList");
        this.f547422a = r100;
        this.f547423b = r101;
        this.f547424c = r102;
        this.f547425d = r103;
        this.f547426e = r104;
    }
}
