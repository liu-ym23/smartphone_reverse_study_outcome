package com.bytedance.android.shopping.store.moments.viewmodel;

import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.ec.core.arch.viewmodel.BaseViewModel;
import com.bytedance.android.ec.hybrid.list.util.l;
import com.bytedance.android.ec.store.shopping.paging.LoadStatus;
import com.bytedance.android.shopping.extensions.k;
import com.bytedance.android.shopping.store.home.api.ECStoreParam;
import com.bytedance.android.shopping.store.hybrid.StoreTabConfig;
import com.bytedance.android.shopping.store.lifecycle.m;
import com.bytedance.android.shopping.store.moments.dto.ECStoreMomentResponse;
import com.bytedance.android.shopping.store.moments.dto.HybridListDTO;
import com.bytedance.android.shopping.store.moments.dto.ItemDTO;
import com.bytedance.android.shopping.store.moments.dto.SectionDTO;
import com.bytedance.android.shopping.store.moments.vo.Aweme;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.ugc.aweme.kiwi.viewmodel.QLiveData;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010%\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 M2\u00020\u0001:\u0001NB\u0007¢\u0006\u0004\bK\u0010LJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\"\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tJ\u0006\u0010\f\u001a\u00020\u0002R$\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R$\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\b\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u0017\u0010\u0018\u001a\u00020\u00178\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u001d\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001c8\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b\u001e\u0010 R\"\u0010\"\u001a\u00020!8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u0017\u0010)\u001a\u00020(8\u0006¢\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,R\u001d\u0010.\u001a\b\u0012\u0004\u0012\u00020\t0-8\u0006¢\u0006\f\n\u0004\b.\u0010/\u001a\u0004\b0\u00101R\u0018\u0010\n\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\n\u00102R\u0016\u00103\u001a\u00020\u001d8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b3\u00104R\"\u00106\u001a\u0002058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b6\u00107\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R#\u0010?\u001a\u000e\u0012\u0004\u0012\u00020=\u0012\u0004\u0012\u00020>0<8\u0006¢\u0006\f\n\u0004\b?\u0010@\u001a\u0004\bA\u0010BR\"\u0010C\u001a\u00020\u001d8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bC\u00104\u001a\u0004\bD\u0010E\"\u0004\bF\u0010GR\u001d\u0010I\u001a\b\u0012\u0004\u0012\u00020H0-8\u0006¢\u0006\f\n\u0004\bI\u0010/\u001a\u0004\bJ\u00101¨\u0006O"}, d2 = {"Lcom/bytedance/android/shopping/store/moments/viewmodel/ECStoreMomentViewModel;", "Lcom/bytedance/android/ec/core/arch/viewmodel/BaseViewModel;", "", "firstFetch", "nextFetch", "Lcom/bytedance/android/shopping/store/home/api/ECStoreParam;", "storeParam", "Lcom/bytedance/android/shopping/store/hybrid/StoreTabConfig;", "tabConfig", "Lcom/bytedance/android/shopping/store/moments/dto/ECStoreMomentResponse;", "prefetchResponse", "init", "fetchMomentApi", "Lcom/bytedance/android/shopping/store/home/api/ECStoreParam;", "getStoreParam", "()Lcom/bytedance/android/shopping/store/home/api/ECStoreParam;", "setStoreParam", "(Lcom/bytedance/android/shopping/store/home/api/ECStoreParam;)V", "Lcom/bytedance/android/shopping/store/hybrid/StoreTabConfig;", "getTabConfig", "()Lcom/bytedance/android/shopping/store/hybrid/StoreTabConfig;", "setTabConfig", "(Lcom/bytedance/android/shopping/store/hybrid/StoreTabConfig;)V", "Lcom/bytedance/android/ec/hybrid/list/util/l;", "hybridListSession", "Lcom/bytedance/android/ec/hybrid/list/util/l;", "getHybridListSession", "()Lcom/bytedance/android/ec/hybrid/list/util/l;", "Landroidx/lifecycle/MutableLiveData;", "", "isMute", "Landroidx/lifecycle/MutableLiveData;", "()Landroidx/lifecycle/MutableLiveData;", "", "playVideoId", "Ljava/lang/String;", "getPlayVideoId", "()Ljava/lang/String;", "setPlayVideoId", "(Ljava/lang/String;)V", "Lti3/a;", "dataSource", "Lti3/a;", "getDataSource", "()Lti3/a;", "Lcom/ss/android/ugc/aweme/kiwi/viewmodel/QLiveData;", "response", "Lcom/ss/android/ugc/aweme/kiwi/viewmodel/QLiveData;", "getResponse", "()Lcom/ss/android/ugc/aweme/kiwi/viewmodel/QLiveData;", "Lcom/bytedance/android/shopping/store/moments/dto/ECStoreMomentResponse;", "fetchLock", "Z", "", "cursor", "J", "getCursor", "()J", "setCursor", "(J)V", "", "", "Lcom/bytedance/android/shopping/store/moments/vo/Aweme;", "awemeCacheMap", "Ljava/util/Map;", "getAwemeCacheMap", "()Ljava/util/Map;", "hasMore", "getHasMore", "()Z", "setHasMore", "(Z)V", "Lcom/bytedance/android/ec/store/shopping/paging/LoadStatus;", "loadStatus", "getLoadStatus", "<init>", "()V", "Companion", "a", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECStoreMomentViewModel extends BaseViewModel {
    private static final int API_SIZE = 20;
    public static final a Companion = null;
    private final Map<Integer, Aweme> awemeCacheMap;
    private long cursor;
    private final ti3.a dataSource;
    private boolean fetchLock;
    private boolean hasMore;
    private final l hybridListSession;
    private final MutableLiveData<Boolean> isMute;
    private final QLiveData<LoadStatus> loadStatus;
    private String playVideoId;
    private ECStoreMomentResponse prefetchResponse;
    private final QLiveData<ECStoreMomentResponse> response;
    private ECStoreParam storeParam;
    private StoreTabConfig tabConfig;

    public static final class a {
        public a() {
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ ECStoreParam a;
        public final /* synthetic */ ECStoreMomentViewModel b;

        public b(ECStoreParam r1, ECStoreMomentViewModel r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r5) {
            ECStoreMomentResponse r6 = (ECStoreMomentResponse) r5;
            if (r6.getStatusCode() == 0) goto L5;
            this.b.getLoadStatus().g(LoadStatus.InitializeError);
            this.b.setHasMore(false);
            return;
        L5:
            Map<Long, m> r0 = com.bytedance.android.shopping.store.lifecycle.a.a;
            m r1 = com.bytedance.android.shopping.store.lifecycle.a.a(Long.valueOf(this.a.getLifecycleMonitorId()));
            if (r1 == null) goto L8;
            r1.s(this.b.getTabConfig());
        L8:
            HybridListDTO r2 = r6.getHybridList();
            if (r2 == null) goto L28;
            List<SectionDTO> r3 = r2.getSections();
            if (r3 == null) goto L28;
            if ((!r3.isEmpty()) == true) goto L16;
            r3 = null;
        L16:
            if (r3 == null) goto L28;
            SectionDTO r4 = (SectionDTO) ListProtector.get(r3, 0);
            if (r4 == null) goto L28;
            ArrayList<ItemDTO> r7 = r4.getItems();
            if (r7 == null) goto L28;
            if (r7.isEmpty() == true) goto L28;
            this.b.getLoadStatus().g(LoadStatus.InitializeSuccess);
            this.b.setCursor(r6.getCursor());
            this.b.setHasMore(r6.getHasMore());
            this.b.getResponse().g(r6);
            if (this.b.getHasMore() == true) goto L33;
            this.b.getLoadStatus().g(LoadStatus.LoadMoreEnd);
            return;
        L33:
            return;
        L28:
            if (r6.getHasMore() == false) goto L30;
            this.b.setCursor(r6.getCursor());
            ECStoreMomentViewModel.access$firstFetch(this.b);
            return;
        L30:
            this.b.setHasMore(false);
            ECStoreMomentViewModel.access$setFetchLock$p(this.b, true);
            this.b.getLoadStatus().g(LoadStatus.InitializeEmpty);
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ ECStoreMomentViewModel a;

        public c(ECStoreMomentViewModel r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            Throwable r3 = (Throwable) r2;
            this.a.getLoadStatus().g(LoadStatus.InitializeError);
            ECStoreMomentViewModel.access$setFetchLock$p(this.a, true);
        }
    }

    public static final class d implements Action {
        public final /* synthetic */ ECStoreMomentViewModel a;

        public d(ECStoreMomentViewModel r1) {
            this.a = r1;
        }

        public final void run() {
            ECStoreMomentViewModel.access$setFetchLock$p(this.a, true);
            l r0 = this.a.getHybridListSession();
            r0.d = Long.valueOf(new Date().getTime());
        }
    }

    public static final class e<T> implements Consumer {
        public final /* synthetic */ ECStoreMomentViewModel a;

        public e(ECStoreMomentViewModel r1) {
            this.a = r1;
        }

        public final void accept(Object r4) {
            ECStoreMomentResponse r5 = (ECStoreMomentResponse) r4;
            if (r5.getStatusCode() == 0) goto L5;
            this.a.getLoadStatus().g(LoadStatus.LoadMoreError);
            this.a.setHasMore(false);
            return;
        L5:
            this.a.getLoadStatus().g(LoadStatus.LoadMoreSuccess);
            this.a.setCursor(r5.getCursor());
            this.a.setHasMore(r5.getHasMore());
            this.a.getResponse().g(r5);
            if (this.a.getHasMore() == true) goto L10;
            this.a.getLoadStatus().g(LoadStatus.LoadMoreEnd);
            return;
        }
    }

    public static final class f<T> implements Consumer {
        public final /* synthetic */ ECStoreMomentViewModel a;

        public f(ECStoreMomentViewModel r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            Throwable r3 = (Throwable) r2;
            this.a.getLoadStatus().g(LoadStatus.LoadMoreError);
            ECStoreMomentViewModel.access$setFetchLock$p(this.a, true);
        }
    }

    public static final class g implements Action {
        public final /* synthetic */ ECStoreMomentViewModel a;

        public g(ECStoreMomentViewModel r1) {
            this.a = r1;
        }

        public final void run() {
            ECStoreMomentViewModel.access$setFetchLock$p(this.a, true);
        }
    }

    static {
        Companion = new a();
    }

    public ECStoreMomentViewModel() {
        super(null, null, 3, null);
        this.hybridListSession = new l();
        this.isMute = new MutableLiveData(Boolean.TRUE);
        this.playVideoId = "";
        this.dataSource = new ti3.a();
        this.response = new QLiveData();
        this.fetchLock = true;
        this.awemeCacheMap = new LinkedHashMap();
        this.hasMore = true;
        this.loadStatus = new QLiveData();
    }

    private final void firstFetch() {
        this.loadStatus.g(LoadStatus.Initialize);
        ECStoreParam r0 = this.storeParam;
        if (r0 == null) goto L9;
        Map<Long, m> r1 = com.bytedance.android.shopping.store.lifecycle.a.a;
        m r2 = com.bytedance.android.shopping.store.lifecycle.a.a(Long.valueOf(r0.getLifecycleMonitorId()));
        if (r2 == null) goto L7;
        r2.k(this.tabConfig);
    L7:
        ti3.a r3 = this.dataSource;
        long r4 = this.cursor;
        r3.getClass();
        bg4.b.b(ti3.a.f(r0, r4)).subscribe(new b(r0, this), new c(this), new d(this));
        return;
    }

    private final void nextFetch() {
        this.loadStatus.g(LoadStatus.LoadMoreIn);
        ECStoreParam r0 = this.storeParam;
        if (r0 == null) goto L6;
        ti3.a r1 = this.dataSource;
        long r2 = this.cursor;
        r1.getClass();
        bg4.b.b(ti3.a.f(r0, r2)).subscribe(new e(this), new f(this), new g(this));
        return;
    }

    public final void fetchMomentApi() {
        if (this.fetchLock == true) goto L5;
        return;
    L5:
        this.fetchLock = false;
        if (this.storeParam != null) goto L9;
        this.loadStatus.g(LoadStatus.InitializeError);
        this.fetchLock = true;
        return;
    L9:
        ECStoreMomentResponse r0 = this.prefetchResponse;
        if (r0 == null) goto L21;
        this.response.g(r0);
        ECStoreMomentResponse r1 = this.prefetchResponse;
        if (r1 == null) goto L14;
        Long r2 = Long.valueOf(r1.getCursor());
    L15:
        this.cursor = k.h(r2);
        ECStoreMomentResponse r3 = this.prefetchResponse;
        if (r3 == null) goto L18;
        Boolean r4 = Boolean.valueOf(r3.getHasMore());
    L19:
        this.hasMore = k.i(r4);
        this.loadStatus.g(LoadStatus.InitializeSuccess);
        this.prefetchResponse = null;
        this.fetchLock = true;
        return;
    L18:
        r4 = null;
        goto L19
    L14:
        r2 = null;
        goto L15
    L21:
        this.hybridListSession.c = Long.valueOf(new Date().getTime());
        if (this.cursor != 0) goto L24;
        firstFetch();
        return;
    L24:
        nextFetch();
    }

    public final Map<Integer, Aweme> getAwemeCacheMap() {
        return this.awemeCacheMap;
    }

    public final long getCursor() {
        return this.cursor;
    }

    public final ti3.a getDataSource() {
        return this.dataSource;
    }

    public final boolean getHasMore() {
        return this.hasMore;
    }

    public final l getHybridListSession() {
        return this.hybridListSession;
    }

    public final QLiveData<LoadStatus> getLoadStatus() {
        return this.loadStatus;
    }

    public final String getPlayVideoId() {
        return this.playVideoId;
    }

    public final QLiveData<ECStoreMomentResponse> getResponse() {
        return this.response;
    }

    public final ECStoreParam getStoreParam() {
        return this.storeParam;
    }

    public final StoreTabConfig getTabConfig() {
        return this.tabConfig;
    }

    public final MutableLiveData<Boolean> isMute() {
        return this.isMute;
    }

    public static final /* synthetic */ void access$firstFetch(ECStoreMomentViewModel r0) {
        r0.firstFetch();
    }

    public static final /* synthetic */ boolean access$getFetchLock$p(ECStoreMomentViewModel r0) {
        return r0.fetchLock;
    }

    public final void setCursor(long r1) {
        this.cursor = r1;
    }

    public final void setHasMore(boolean r1) {
        this.hasMore = r1;
    }

    public final void setPlayVideoId(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.playVideoId = r2;
    }

    public final void setStoreParam(ECStoreParam r1) {
        this.storeParam = r1;
    }

    public final void setTabConfig(StoreTabConfig r1) {
        this.tabConfig = r1;
    }

    public static final /* synthetic */ void access$setFetchLock$p(ECStoreMomentViewModel r0, boolean r1) {
        r0.fetchLock = r1;
    }

    public final void init(ECStoreParam r4, StoreTabConfig r5, ECStoreMomentResponse r6) {
        Intrinsics.checkNotNullParameter(r4, "storeParam");
        l r0 = this.hybridListSession;
        r0.b = Long.valueOf(new Date().getTime());
        this.storeParam = r4;
        this.tabConfig = r5;
        this.prefetchResponse = r6;
        this.loadStatus.g(LoadStatus.Initialize);
        bindMonitorId(Long.valueOf(r4.getLifecycleMonitorId()));
    }
}
