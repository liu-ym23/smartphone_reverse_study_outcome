package e60;

import android.util.Pair;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.paging.PagedList;
import com.bytedance.android.live.core.cache.j;
import com.bytedance.android.live.core.network.NetworkStat;
import com.bytedance.android.live.core.paging.Listing;
import com.bytedance.android.live.core.paging.builder.DataBuilder;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import io.reactivex.subjects.PublishSubject;
import java.util.List;

/* JADX INFO: loaded from: classes45.dex */
public class a<T> implements Listing<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LiveData<PagedList<T>> f471104a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final MutableLiveData<NetworkStat> f471105b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final MutableLiveData<NetworkStat> f471106c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final MutableLiveData<NetworkStat> f471107d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final MutableLiveData<Boolean> f471108e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final PublishSubject<Object> f471109f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final PublishSubject<Object> f471110g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final PublishSubject<Object> f471111h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final MutableLiveData<Integer> f471112i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final MutableLiveData<Boolean> f471113j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final PublishSubject<Pair<String, String>> f471114k;

    @Override // com.bytedance.android.live.core.paging.Listing
    public final void refresh() {
        this.f471109f.onNext(RxUtil.__);
    }

    @Override // com.bytedance.android.live.core.paging.Listing
    public final void retry() {
        this.f471110g.onNext(RxUtil.__);
    }

    @Override // com.bytedance.android.live.core.paging.Listing
    public int size() {
        throw new RuntimeException("unsupported operation");
    }

    @Override // com.bytedance.android.live.core.paging.Listing
    public void update() {
        this.f471111h.onNext(RxUtil.__);
    }

    @Override // com.bytedance.android.live.core.paging.Listing
    public final LiveData<NetworkStat> getNetworkStat() {
        return this.f471105b;
    }

    @Override // com.bytedance.android.live.core.paging.Listing
    public final LiveData<PagedList<T>> getPageList() {
        return this.f471104a;
    }

    @Override // com.bytedance.android.live.core.paging.Listing
    public final LiveData<NetworkStat> getRefreshStat() {
        return this.f471106c;
    }

    @Override // com.bytedance.android.live.core.paging.Listing
    public final PublishSubject<Pair<String, String>> getReqFrom() {
        return this.f471114k;
    }

    @Override // com.bytedance.android.live.core.paging.Listing
    public final LiveData<NetworkStat> getUpdateStat() {
        return this.f471107d;
    }

    @Override // com.bytedance.android.live.core.paging.Listing
    public final LiveData<Boolean> hasMore() {
        return this.f471113j;
    }

    @Override // com.bytedance.android.live.core.paging.Listing
    public final LiveData<Boolean> isEmpty() {
        return this.f471108e;
    }

    @Override // com.bytedance.android.live.core.paging.Listing
    public final LiveData<Integer> updateAdapterItemEvent() {
        return this.f471112i;
    }

    @Override // com.bytedance.android.live.core.paging.Listing
    public T find(j<T> r100) {
        throw new RuntimeException("unsupported operation");
    }

    @Override // com.bytedance.android.live.core.paging.Listing
    public T get(int r100) {
        throw new RuntimeException("unsupported operation");
    }

    @Override // com.bytedance.android.live.core.paging.Listing
    public int indexOf(T r100) {
        throw new RuntimeException("unsupported operation");
    }

    @Override // com.bytedance.android.live.core.paging.Listing
    public void remove(int r100) {
        throw new RuntimeException("unsupported operation");
    }

    @Override // com.bytedance.android.live.core.paging.Listing
    public final void updateAdapterItem(int r100) {
        this.f471112i.setValue(Integer.valueOf(r100));
    }

    @Override // com.bytedance.android.live.core.paging.Listing
    public void remove(T r100) {
        throw new RuntimeException("unsupported operation");
    }

    public a(DataBuilder<T> r100, LiveData<PagedList<T>> r101) {
        this.f471114k = PublishSubject.create();
        this.f471105b = r100.networkState();
        this.f471106c = r100.refreshState();
        this.f471107d = r100.updateState();
        this.f471113j = r100.hasMore();
        this.f471109f = r100.refresh();
        this.f471110g = r100.retry();
        this.f471111h = r100.update();
        this.f471104a = r101;
        this.f471108e = r100.empty();
        this.f471112i = r100.updateAdapterItem();
    }

    @Override // com.bytedance.android.live.core.paging.Listing
    public void add(int r100, T r101) {
        throw new RuntimeException("unsupported operation");
    }

    @Override // com.bytedance.android.live.core.paging.Listing
    public void put(int r100, T r101) {
        throw new RuntimeException("unsupported operation");
    }

    @Override // com.bytedance.android.live.core.paging.Listing
    public final void setReqFrom(String r100, String r101) {
        this.f471114k.onNext(new Pair(r100, r101));
    }

    @Override // com.bytedance.android.live.core.paging.Listing
    public void add(int r100, List<T> r101) {
        throw new RuntimeException("unsupported operation");
    }
}
