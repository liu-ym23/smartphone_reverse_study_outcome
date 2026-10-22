package pi8;

import com.larus.im.bean.message.ItemData;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<? extends ItemData> f529386a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f529387b;

    public /* synthetic */ o() {
        throw null;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof o) == true) goto L8;
        return false;
    L8:
        o r101 = (o) r100;
        if (Intrinsics.areEqual(this.f529386a, r101.f529386a) == true) goto L12;
        return false;
    L12:
        if (this.f529387b == r101.f529387b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f529386a.hashCode() * 31;
        if (this.f529387b == false) goto L5;
        int r101 = 1231;
    L7:
        return r100 + r101;
    L5:
        r101 = 1237;
        goto L7
    }

    public final String toString() {
        return "SearchRecyclerData(list=" + this.f529386a + ", enableScroll=" + this.f529387b + ')';
    }

    public o(List<? extends ItemData> r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "list");
        this.f529386a = r100;
        this.f529387b = r101;
    }
}
