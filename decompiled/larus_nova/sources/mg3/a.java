package mg3;

import androidx.lifecycle.LiveData;
import androidx.paging.PagedList;
import com.bytedance.android.ec.core.data.LoadingStatus;
import com.bytedance.android.ec.core.data.PagingLoadingStatus;
import com.ss.android.cert.manager.constants.EventConstant;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class a<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LiveData<PagedList<T>> f513717a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LiveData<PagingLoadingStatus> f513718b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final LiveData<LoadingStatus> f513719c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Function0<Unit> f513720d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Function0<Unit> f513721e;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == false) goto L16;
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f513717a, r101.f513717a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f513718b, r101.f513718b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f513719c, r101.f513719c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f513720d, r101.f513720d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f513721e, r101.f513721e) == true) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    public final int hashCode() {
        LiveData<PagedList<T>> r100 = this.f513717a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        LiveData<PagingLoadingStatus> r104 = this.f513718b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        LiveData<LoadingStatus> r107 = this.f513719c;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        Function0<Unit> r110 = this.f513720d;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        Function0<Unit> r113 = this.f513721e;
        if (r113 == null) goto L22;
        r101 = r113.hashCode();
    L22:
        return r112 + r101;
    L17:
        r111 = 0;
        goto L18
    L13:
        r108 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "Listing(pagedList=" + this.f513717a + ", pagingLoadingStatus=" + this.f513718b + ", refreshLoadingStatus=" + this.f513719c + ", refresh=" + this.f513720d + ", retry=" + this.f513721e + ")";
    }

    public a(LiveData<PagedList<T>> r100, LiveData<PagingLoadingStatus> r101, LiveData<LoadingStatus> r102, Function0<Unit> r103, Function0<Unit> r104) {
        Intrinsics.checkNotNullParameter(r100, "pagedList");
        Intrinsics.checkNotNullParameter(r101, "pagingLoadingStatus");
        Intrinsics.checkNotNullParameter(r102, "refreshLoadingStatus");
        Intrinsics.checkNotNullParameter(r103, "refresh");
        Intrinsics.checkNotNullParameter(r104, EventConstant.Value.RETRY);
        this.f513717a = r100;
        this.f513718b = r101;
        this.f513719c = r102;
        this.f513720d = r103;
        this.f513721e = r104;
    }
}
