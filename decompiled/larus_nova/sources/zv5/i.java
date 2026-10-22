package zv5;

import com.bytedance.flow.search.kmp.api.spi.SearchDriveItem;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<SearchDriveItem> f573701a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f573702b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f573703c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f573704d;

    public i() {
        this(null, null, false, false, 15);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof i) == true) goto L8;
        return false;
    L8:
        i r101 = (i) r100;
        if (Intrinsics.areEqual(this.f573701a, r101.f573701a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f573702b, r101.f573702b) == true) goto L15;
        return false;
    L15:
        if (this.f573703c == r101.f573703c) goto L18;
        return false;
    L18:
        if (this.f573704d == r101.f573704d) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f573701a.hashCode() * 31;
        String r101 = this.f573702b;
        if (r101 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = (r100 + r102) * 31;
        int r104 = 1231;
        if (this.f573703c == false) goto L9;
        int r105 = 1231;
    L10:
        int r106 = (r103 + r105) * 31;
        if (this.f573704d == true) goto L15;
        r104 = 1237;
    L15:
        return r106 + r104;
    L9:
        r105 = 1237;
        goto L10
    L5:
        r102 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "SearchDriveResult(items=" + this.f573701a + ", loadMoreLabel=" + this.f573702b + ", hasMore=" + this.f573703c + ", loadFailed=" + this.f573704d + ')';
    }

    public i(List r100, String r101, boolean r102, boolean r103, int r104) {
        if ((r104 & 1) == 0) goto L6;
        r100 = CollectionsKt.emptyList();
    L6:
        if ((r104 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r102 = false;
    L12:
        if ((r104 & 8) == 0) goto L14;
        r103 = false;
    L14:
        Intrinsics.checkNotNullParameter(r100, "items");
        this.f573701a = r100;
        this.f573702b = r101;
        this.f573703c = r102;
        this.f573704d = r103;
    }
}
