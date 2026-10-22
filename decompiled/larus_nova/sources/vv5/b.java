package vv5;

import com.bytedance.flow.search.kmp.api.model.FlowSearchData;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<FlowSearchData> f557397a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f557398b;

    public b() {
        List r100 = null;
        boolean r101 = false;
        this(r100, r101, 3);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f557397a, r101.f557397a) == true) goto L12;
        return false;
    L12:
        if (this.f557398b == r101.f557398b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f557397a.hashCode() * 31;
        if (this.f557398b == false) goto L5;
        int r101 = 1231;
    L7:
        return r100 + r101;
    L5:
        r101 = 1237;
        goto L7
    }

    public final String toString() {
        return "ProviderResult(data=" + this.f557397a + ", loadFailed=" + this.f557398b + ')';
    }

    public b(List<FlowSearchData> r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "data");
        this.f557397a = r100;
        this.f557398b = r101;
    }

    public /* synthetic */ b(List r100, boolean r101, int r102) {
        if ((r102 & 1) == 0) goto L6;
        r100 = CollectionsKt.emptyList();
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = false;
    L8:
        this(r100, r101);
    }
}
