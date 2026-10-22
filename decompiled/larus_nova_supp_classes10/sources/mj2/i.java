package mj2;

import androidx.lifecycle.LiveData;
import androidx.paging.PagedList;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class i<T> {
    public final LiveData<PagedList<T>> a;
    public final Function1<Integer, Unit> b;
    public final Function1<Boolean, Unit> c;

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof i) == false) goto L12;
        i r4 = (i) r3;
        if (Intrinsics.areEqual(this.a, r4.a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.b, r4.b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.c, r4.c) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        LiveData<PagedList<T>> r0 = this.a;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        Function1<Integer, Unit> r4 = this.b;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        Function1<Boolean, Unit> r7 = this.c;
        if (r7 == null) goto L14;
        r1 = r7.hashCode();
    L14:
        return r6 + r1;
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "PagingListing(pagedList=" + this.a + ", refresh=" + this.b + ", retryLoadMore=" + this.c + ")";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public i(LiveData<PagedList<T>> r2, Function1<? super Integer, Unit> r3, Function1<? super Boolean, Unit> r4) {
        Intrinsics.checkNotNullParameter(r2, "pagedList");
        Intrinsics.checkNotNullParameter(r3, "refresh");
        Intrinsics.checkNotNullParameter(r4, "retryLoadMore");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
