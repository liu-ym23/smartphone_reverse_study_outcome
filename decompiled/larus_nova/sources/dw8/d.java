package dw8;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<f> f470334a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final g f470335b;

    public d() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof d) == true) goto L8;
        return false;
    L8:
        d r101 = (d) r100;
        if (Intrinsics.areEqual(this.f470334a, r101.f470334a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f470335b, r101.f470335b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f470334a.hashCode() * 31;
        g r101 = this.f470335b;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return r100 + r102;
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public final String toString() {
        return "AIChatActionBarConfig(items=" + this.f470334a + ", itemEventCallback=" + this.f470335b + ')';
    }

    public /* synthetic */ d(int r100) {
        this(CollectionsKt.emptyList(), null);
    }

    public d(List<f> r100, g r101) {
        Intrinsics.checkNotNullParameter(r100, "items");
        this.f470334a = r100;
        this.f470335b = r101;
    }
}
