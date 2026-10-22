package hn8;

import java.util.List;
import kc8.j0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<l> f486138a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final j0 f486139b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof h) == true) goto L8;
        return false;
    L8:
        h r101 = (h) r100;
        if (Intrinsics.areEqual(this.f486138a, r101.f486138a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f486139b, r101.f486139b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f486138a.hashCode() * 31;
        j0 r101 = this.f486139b;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return r100 + r102;
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public final String toString() {
        return "SearchListContainerInput(videoList=" + this.f486138a + ", columnGridDecorationConfig=" + this.f486139b + ')';
    }

    public h(List<l> r100, j0 r101) {
        Intrinsics.checkNotNullParameter(r100, "videoList");
        this.f486138a = r100;
        this.f486139b = r101;
    }
}
