package mj2;

import androidx.lifecycle.LiveData;
import androidx.paging.PagedList;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class i<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LiveData<PagedList<T>> f514207a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function1<Integer, Unit> f514208b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function1<Boolean, Unit> f514209c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof i) == false) goto L12;
        i r101 = (i) r100;
        if (Intrinsics.areEqual(this.f514207a, r101.f514207a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f514208b, r101.f514208b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f514209c, r101.f514209c) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        LiveData<PagedList<T>> r100 = this.f514207a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Function1<Integer, Unit> r104 = this.f514208b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        Function1<Boolean, Unit> r107 = this.f514209c;
        if (r107 == null) goto L14;
        r101 = r107.hashCode();
    L14:
        return r106 + r101;
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "PagingListing(pagedList=" + this.f514207a + ", refresh=" + this.f514208b + ", retryLoadMore=" + this.f514209c + ")";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public i(LiveData<PagedList<T>> r100, Function1<? super Integer, Unit> r101, Function1<? super Boolean, Unit> r102) {
        Intrinsics.checkNotNullParameter(r100, "pagedList");
        Intrinsics.checkNotNullParameter(r101, "refresh");
        Intrinsics.checkNotNullParameter(r102, "retryLoadMore");
        this.f514207a = r100;
        this.f514208b = r101;
        this.f514209c = r102;
    }
}
