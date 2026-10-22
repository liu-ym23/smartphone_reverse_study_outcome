package f60;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.paging.DataSource;
import androidx.paging.LivePagedListBuilder;
import androidx.paging.PagedList;
import com.bytedance.android.live.base.model.feed.FeedExtra;
import com.bytedance.android.live.core.cache.Cache;
import com.bytedance.android.live.core.network.NetworkStat;
import com.bytedance.android.live.core.paging.Listing;
import com.bytedance.android.live.core.paging.builder.DataBuilder;
import com.bytedance.android.live.core.paging.builder.DefaultBoundaryCallback;
import com.bytedance.android.live.core.paging.datasource.DefaultRxCacheDataSource;
import com.bytedance.android.live.core.paging.datasource.PagingLoadCallback;
import e60.b;
import io.reactivex.subjects.PublishSubject;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes45.dex */
public final class a<CacheKey, V> implements DataBuilder<V> {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final PagedList.Config f475665s = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public MutableLiveData<NetworkStat> f475666a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public MutableLiveData<NetworkStat> f475667b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final MutableLiveData<NetworkStat> f475668c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public MutableLiveData<Boolean> f475669d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final MutableLiveData<Boolean> f475670e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public PublishSubject<Object> f475671f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public PublishSubject<Object> f475672g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final PublishSubject<Object> f475673h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public volatile boolean f475674i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public volatile boolean f475675j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public volatile boolean f475676k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final MutableLiveData<Integer> f475677l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final AtomicLong f475678m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public CacheKey f475679n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public com.bytedance.android.live.core.cache.a<CacheKey, V> f475680o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public Cache<CacheKey, FeedExtra> f475681p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public PagedList.Config f475682q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public PagingLoadCallback<V> f475683r;

    /* JADX INFO: renamed from: f60.a$a, reason: collision with other inner class name */
    public class C5860a extends DataSource.Factory<Long, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f475684a;

        @Override // androidx.paging.DataSource.Factory
        public final DataSource<Long, V> create() {
            return new DefaultRxCacheDataSource(this.f475684a);
        }

        public C5860a(a r100) {
            this.f475684a = r100;
        }
    }

    static {
        f475665s = new PagedList.Config.Builder().setEnablePlaceholders(false).setPageSize(12).setPrefetchDistance(12).build();
    }

    @Override // com.bytedance.android.live.core.paging.builder.DataBuilder
    public final Listing<V> build() {
        C5860a r100 = new C5860a(this);
        DefaultBoundaryCallback r101 = new DefaultBoundaryCallback(this.f475669d, this.f475670e);
        return new b(this, new LivePagedListBuilder(r100, this.f475682q).setBoundaryCallback(r101).build());
    }

    @Override // com.bytedance.android.live.core.paging.builder.DataBuilder
    public final long getGeneration() {
        return this.f475678m.get();
    }

    @Override // com.bytedance.android.live.core.paging.builder.DataBuilder
    public final long makeGeneration() {
        return this.f475678m.incrementAndGet();
    }

    public a() {
        this.f475666a = new MutableLiveData();
        this.f475667b = new MutableLiveData();
        this.f475668c = new MutableLiveData();
        this.f475669d = new MutableLiveData();
        this.f475670e = new MutableLiveData();
        this.f475671f = PublishSubject.create();
        this.f475672g = PublishSubject.create();
        this.f475673h = PublishSubject.create();
        this.f475674i = false;
        this.f475675j = false;
        this.f475676k = false;
        this.f475677l = new MutableLiveData();
        this.f475678m = new AtomicLong(0);
        this.f475682q = f475665s;
    }

    @Override // com.bytedance.android.live.core.paging.builder.DataBuilder
    public final PagingLoadCallback<V> callback() {
        return this.f475683r;
    }

    @Override // com.bytedance.android.live.core.paging.builder.DataBuilder
    public final MutableLiveData<Boolean> empty() {
        return this.f475670e;
    }

    @Override // com.bytedance.android.live.core.paging.builder.DataBuilder
    public final MutableLiveData<Boolean> hasMore() {
        return this.f475669d;
    }

    @Override // com.bytedance.android.live.core.paging.builder.DataBuilder
    public final boolean hasRefreshFlag() {
        return this.f475675j;
    }

    @Override // com.bytedance.android.live.core.paging.builder.DataBuilder
    public final boolean hasUpdateFlag() {
        return this.f475676k;
    }

    @Override // com.bytedance.android.live.core.paging.builder.DataBuilder
    public final MutableLiveData<NetworkStat> networkState() {
        return this.f475666a;
    }

    @Override // com.bytedance.android.live.core.paging.builder.DataBuilder
    public final PublishSubject<Object> refresh() {
        return this.f475671f;
    }

    @Override // com.bytedance.android.live.core.paging.builder.DataBuilder
    public final MutableLiveData<NetworkStat> refreshState() {
        return this.f475667b;
    }

    @Override // com.bytedance.android.live.core.paging.builder.DataBuilder
    public final boolean refreshing() {
        return this.f475674i;
    }

    @Override // com.bytedance.android.live.core.paging.builder.DataBuilder
    public final PublishSubject<Object> retry() {
        return this.f475672g;
    }

    @Override // com.bytedance.android.live.core.paging.builder.DataBuilder
    public PublishSubject<Object> update() {
        return this.f475673h;
    }

    @Override // com.bytedance.android.live.core.paging.builder.DataBuilder
    public final MutableLiveData<Integer> updateAdapterItem() {
        return this.f475677l;
    }

    @Override // com.bytedance.android.live.core.paging.builder.DataBuilder
    public final MutableLiveData<NetworkStat> updateState() {
        return this.f475668c;
    }

    @Override // com.bytedance.android.live.core.paging.builder.DataBuilder
    public final Listing<V> build(LiveData<PagedList<V>> r100) {
        return new b(this, r100);
    }

    @Override // com.bytedance.android.live.core.paging.builder.DataBuilder
    public final void setRefreshFlag(boolean r100) {
        this.f475675j = r100;
    }

    @Override // com.bytedance.android.live.core.paging.builder.DataBuilder
    public final void setRefreshing(boolean r100) {
        this.f475674i = r100;
    }

    @Override // com.bytedance.android.live.core.paging.builder.DataBuilder
    public final void setUpdateFlag(boolean r100) {
        this.f475676k = r100;
    }
}
