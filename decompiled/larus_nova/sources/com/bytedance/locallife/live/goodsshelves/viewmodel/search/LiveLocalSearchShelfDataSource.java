package com.bytedance.locallife.live.goodsshelves.viewmodel.search;

import androidx.lifecycle.LiveData;
import androidx.paging.PagedList;
import androidx.paging.PositionalDataSource;
import com.bytedance.locallife.live.goodsshelves.bean.b;
import com.bytedance.locallife.live.goodsshelves.repository.l;
import com.bytedance.locallife.live.goodsshelves.repository.m;
import com.bytedance.locallife.live.goodsshelves.viewmodel.LiveLocalLifeShelfDataSource;
import com.bytedance.locallife.live.goodsshelves.viewmodel.d;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/locallife/live/goodsshelves/viewmodel/search/LiveLocalSearchShelfDataSource;", "Lcom/bytedance/locallife/live/goodsshelves/viewmodel/LiveLocalLifeShelfDataSource;", "locallife-live-impl_release"}, k = 1, mv = {1, 4, 3})
public final class LiveLocalSearchShelfDataSource extends LiveLocalLifeShelfDataSource {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final LiveGoodsSearchShelvesViewModel f260494j;

    @Override // com.bytedance.locallife.live.goodsshelves.viewmodel.LiveLocalLifeShelfDataSource, androidx.paging.PositionalDataSource
    public final void loadInitial(PositionalDataSource.LoadInitialParams r110, PositionalDataSource.LoadInitialCallback<b> r111) {
        Intrinsics.checkNotNullParameter(r110, "params");
        Intrinsics.checkNotNullParameter(r111, "callback");
        this.f260468g = 0;
        this.f260463b.f259848o = 0;
        this.f260494j.getShowLoading().postValue(Boolean.TRUE);
        int r100 = this.f260463b.f259843j;
        m r101 = this.f260494j.getSearchShelvesRepository();
        l r102 = this.f260463b;
        int r103 = r102.f259840g;
        if (r103 != 0) goto L5;
    L8:
        int r104 = 0;
    L9:
        m.q(r101, 0, r100, true, r104, r102.f259847n, new a(this, r111));
        return;
    L5:
        if (r103 != 1) goto L8;
        r104 = 2;
        goto L9
    }

    @Override // com.bytedance.locallife.live.goodsshelves.viewmodel.LiveLocalLifeShelfDataSource, androidx.paging.PositionalDataSource
    public final void loadRange(final PositionalDataSource.LoadRangeParams r110, final PositionalDataSource.LoadRangeCallback<b> r111) {
        Intrinsics.checkNotNullParameter(r110, "params");
        Intrinsics.checkNotNullParameter(r111, "callback");
        int r100 = r110.startPosition;
        LiveData<PagedList<b>> r101 = this.f260494j.getLifeShelfPagedList();
        if (r101 == null) goto L7;
        PagedList<b> r102 = r101.getValue();
        if (r102 == null) goto L7;
        int r103 = r102.getPositionOffset();
    L8:
        if (r100 < r103) goto L10;
        final boolean r104 = true;
    L11:
        if (r104 == false) goto L17;
        int r105 = this.f260468g;
        if (r105 >= 0) goto L16;
        LiveLocalLifeShelfDataSource.g(r111, CollectionsKt.emptyList());
        return;
    L16:
        int r106 = r110.loadSize;
    L22:
        final int r107 = r105;
        int r108 = r106;
        m.q(this.f260494j.getSearchShelvesRepository(), r107, r108, false, 1, this.f260463b.f259847n, new LiveLocalSearchShelfDataSource$getSearchRangeLiveGoodsShelvesList$1(r104, this, r107, r111, r110));
        return;
    L17:
        int r109 = this.f260466e;
        if (r109 > 0) goto L21;
        LiveLocalLifeShelfDataSource.g(r111, CollectionsKt.emptyList());
        return;
    L21:
        r105 = RangesKt.coerceAtLeast(r109 - this.f260463b.f259842i, 0);
        r106 = RangesKt.coerceAtMost(this.f260463b.f259842i, this.f260466e);
        goto L22
    L10:
        r104 = false;
    L7:
        r103 = 0;
        goto L8
    }

    public LiveLocalSearchShelfDataSource(String r100, l r101, d r102, LiveGoodsSearchShelvesViewModel r103) {
        Intrinsics.checkNotNullParameter(r100, "uniqueKey");
        Intrinsics.checkNotNullParameter(r101, "requestParams");
        Intrinsics.checkNotNullParameter(r102, "localDataSource");
        Intrinsics.checkNotNullParameter(r103, "mGoodsSearchShelfViewModel");
        super(r100, r101, r102, r103);
        this.f260494j = r103;
    }
}
