package zv5;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<k> f573729a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f573730b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof l) == true) goto L8;
        return false;
    L8:
        l r101 = (l) r100;
        if (Intrinsics.areEqual(this.f573729a, r101.f573729a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f573730b, r101.f573730b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f573729a.hashCode() * 31;
        String r101 = this.f573730b;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return r100 + r102;
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public final String toString() {
        return "SearchMixedFeedResult(previews=" + this.f573729a + ", nextCursor=" + this.f573730b + ')';
    }

    public l() {
        this(CollectionsKt.emptyList(), null);
    }

    public l(List<k> r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "previews");
        this.f573729a = r100;
        this.f573730b = r101;
    }
}
