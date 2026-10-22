package com.ss.android.ugc.aweme.search.common.saas.autoplay;

import android.graphics.Rect;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/ss/android/ugc/aweme/search/common/saas/autoplay/SearchGridCommodityHittingArea;", "Lcom/ss/android/ugc/aweme/search/common/saas/autoplay/SearchCommodityHittingArea;", "trade-search-impl_release"}, k = 1, mv = {1, 4, 3})
public class SearchGridCommodityHittingArea extends SearchCommodityHittingArea {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Rect f452032i;

    @Override // com.ss.android.ugc.aweme.search.common.saas.autoplay.SearchCommodityHittingArea
    public final void b() {
        super.b();
        this.f452024b.getGlobalVisibleRect(this.f452032i);
    }

    @Override // com.ss.android.ugc.aweme.search.common.saas.autoplay.SearchCommodityHittingArea
    public final boolean d(ScrollStateObserver r100) {
        if (r100 == null) goto L19;
        int r101 = r100.b().top;
        int r102 = r100.b().bottom;
        int r103 = r102 - r101;
        Rect r104 = this.f452032i;
        int r105 = r104.top;
        if (r105 <= r101) goto L7;
    L9:
        if (r101 >= r105) goto L15;
        if ((r103 * this.f452027e.getRollInAreaPercent()) >= (r102 - this.f452032i.top)) goto L13;
        return true;
    L13:
        return false;
    L15:
        if (r104.bottom >= r102) goto L19;
        if ((r103 * this.f452027e.getRollInAreaPercent()) >= (this.f452032i.bottom - r101)) goto L19;
        return true;
    L7:
        if (r104.bottom < r102) goto L9;
        return true;
    L19:
        return false;
    }

    @Override // com.ss.android.ugc.aweme.search.common.saas.autoplay.SearchCommodityHittingArea
    public final boolean e(ScrollStateObserver r100) {
        if (r100 == null) goto L15;
        int r101 = r100.b().top;
        int r102 = r100.b().bottom;
        int r103 = r102 - r101;
        Rect r104 = this.f452032i;
        if (r101 >= r104.top) goto L11;
        if ((r103 * this.f452027e.getRollOutAreaPercent()) <= (r102 - this.f452032i.top)) goto L9;
        return true;
    L9:
        return false;
    L11:
        if (r104.bottom >= r102) goto L15;
        if ((r103 * this.f452027e.getRollOutAreaPercent()) <= (this.f452032i.bottom - r101)) goto L15;
        return true;
    L15:
        return false;
    }

    public SearchGridCommodityHittingArea(FragmentActivity r100, RecyclerView r101) {
        Intrinsics.checkNotNullParameter(r101, "view");
        super(r100, r101);
        this.f452032i = new Rect();
    }
}
