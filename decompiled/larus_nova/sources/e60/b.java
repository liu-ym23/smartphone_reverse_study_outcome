package e60;

import androidx.lifecycle.LiveData;
import androidx.paging.PagedList;
import com.bytedance.android.live.core.cache.j;
import java.util.List;

/* JADX INFO: loaded from: classes45.dex */
public final class b<CacheKey, T> extends a<T> {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final com.bytedance.android.live.core.cache.a<CacheKey, T> f471115l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final CacheKey f471116m;

    @Override // e60.a, com.bytedance.android.live.core.paging.Listing
    public final int size() {
        return this.f471115l.size(this.f471116m);
    }

    @Override // e60.a, com.bytedance.android.live.core.paging.Listing
    public final T find(j<T> r100) {
        return this.f471115l.c(this.f471116m, r100);
    }

    @Override // e60.a, com.bytedance.android.live.core.paging.Listing
    public final T get(int r100) {
        return this.f471115l.get(this.f471116m, r100);
    }

    @Override // e60.a, com.bytedance.android.live.core.paging.Listing
    public final int indexOf(T r100) {
        return this.f471115l.a(this.f471116m, r100);
    }

    @Override // e60.a, com.bytedance.android.live.core.paging.Listing
    public final void remove(int r100) {
        this.f471115l.delete(this.f471116m, r100);
        update();
    }

    @Override // e60.a, com.bytedance.android.live.core.paging.Listing
    public final void remove(T r100) {
        this.f471115l.delete(this.f471116m, r100);
        update();
    }

    public b(f60.a<CacheKey, T> r100, LiveData<PagedList<T>> r101) {
        super(r100, r101);
        this.f471116m = r100.f475679n;
        this.f471115l = r100.f475680o;
    }

    @Override // e60.a, com.bytedance.android.live.core.paging.Listing
    public final void add(int r100, T r101) {
        this.f471115l.insert(this.f471116m, r100, r101);
        update();
    }

    @Override // e60.a, com.bytedance.android.live.core.paging.Listing
    public final void put(int r100, T r101) {
        this.f471115l.b(this.f471116m, r100, r101);
        update();
    }

    @Override // e60.a, com.bytedance.android.live.core.paging.Listing
    public final void add(int r100, List<T> r101) {
        this.f471115l.insert(this.f471116m, r100, r101);
        update();
    }
}
