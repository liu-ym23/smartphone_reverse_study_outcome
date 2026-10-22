package ip0;

import com.bytedance.android.live.openplatform.impl.miniappanchor.choose.model.MiniAppEntranceCell;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<Long, List<MiniAppEntranceCell>> f495249a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<com.bytedance.android.live.openplatform.impl.miniappanchor.choose.model.a> f495250b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<com.bytedance.android.live.openplatform.impl.miniappanchor.choose.model.c> f495251c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof b) == false) goto L12;
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f495249a, r101.f495249a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f495250b, r101.f495250b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f495251c, r101.f495251c) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        Map<Long, List<MiniAppEntranceCell>> r100 = this.f495249a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        List<com.bytedance.android.live.openplatform.impl.miniappanchor.choose.model.a> r104 = this.f495250b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        List<com.bytedance.android.live.openplatform.impl.miniappanchor.choose.model.c> r107 = this.f495251c;
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
        return "MiniAppGroupedList(entranceCellGroupedList=" + this.f495249a + ", bannerList=" + this.f495250b + ", groupPropertyList=" + this.f495251c + ")";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public b(Map<Long, ? extends List<MiniAppEntranceCell>> r100, List<com.bytedance.android.live.openplatform.impl.miniappanchor.choose.model.a> r101, List<com.bytedance.android.live.openplatform.impl.miniappanchor.choose.model.c> r102) {
        Intrinsics.checkNotNullParameter(r100, "entranceCellGroupedList");
        Intrinsics.checkNotNullParameter(r101, "bannerList");
        Intrinsics.checkNotNullParameter(r102, "groupPropertyList");
        this.f495249a = r100;
        this.f495250b = r101;
        this.f495251c = r102;
    }
}
