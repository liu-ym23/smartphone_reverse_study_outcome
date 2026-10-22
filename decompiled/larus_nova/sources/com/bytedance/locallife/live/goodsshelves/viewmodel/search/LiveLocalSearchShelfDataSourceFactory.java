package com.bytedance.locallife.live.goodsshelves.viewmodel.search;

import androidx.lifecycle.MutableLiveData;
import androidx.paging.DataSource;
import com.bytedance.locallife.live.goodsshelves.bean.b;
import com.bytedance.locallife.live.goodsshelves.repository.l;
import com.bytedance.locallife.live.goodsshelves.viewmodel.d;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001¨\u0006\u0004"}, d2 = {"Lcom/bytedance/locallife/live/goodsshelves/viewmodel/search/LiveLocalSearchShelfDataSourceFactory;", "Landroidx/paging/DataSource$Factory;", "", "Lcom/bytedance/locallife/live/goodsshelves/bean/b;", "locallife-live-impl_release"}, k = 1, mv = {1, 4, 3})
public final class LiveLocalSearchShelfDataSourceFactory extends DataSource.Factory<Integer, b> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f260500a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final l f260501b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final d f260502c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final LiveGoodsSearchShelvesViewModel f260503d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final MutableLiveData<LiveLocalSearchShelfDataSource> f260504e;

    @Override // androidx.paging.DataSource.Factory
    public final DataSource<Integer, b> create() {
        LiveLocalSearchShelfDataSource r100 = new LiveLocalSearchShelfDataSource(this.f260500a, this.f260501b, this.f260502c, this.f260503d);
        this.f260504e.postValue(r100);
        return r100;
    }

    public LiveLocalSearchShelfDataSourceFactory(String r100, l r101, d r102, LiveGoodsSearchShelvesViewModel r103) {
        Intrinsics.checkNotNullParameter(r100, "uniqueKey");
        Intrinsics.checkNotNullParameter(r101, "requestParams");
        Intrinsics.checkNotNullParameter(r102, "localDataSource");
        Intrinsics.checkNotNullParameter(r103, "shelfViewModel");
        this.f260500a = r100;
        this.f260501b = r101;
        this.f260502c = r102;
        this.f260503d = r103;
        this.f260504e = new MutableLiveData();
    }
}
