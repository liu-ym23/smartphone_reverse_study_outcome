package com.bytedance.android.shopping.store.aggregate.viewmodel;

import com.bytedance.android.ec.core.arch.viewmodel.BaseViewModel;
import com.bytedance.android.ec.store.product.holder.LayoutTypes;
import com.bytedance.android.ec.store.shopping.paging.LoadStatus;
import com.bytedance.android.shopping.store.aggregate.ShopAggregateParam;
import com.bytedance.android.shopping.store.aggregate.classification.CategoryInfo;
import com.bytedance.android.shopping.store.home.api.ECStoreApi;
import com.bytedance.android.shopping.store.repository.dto.StoreModuleDetailDTO;
import com.bytedance.android.shopping.store.utils.x;
import com.bytedance.android.shopping.store.utils.z;
import com.google.gson.Gson;
import com.ss.android.ugc.aweme.kiwi.viewmodel.QLiveData;
import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference0Impl;
import kotlin.jvm.internal.SpreadBuilder;
import uj3.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b/\u00100J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\u0006\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0002H\u0002J\u0006\u0010\t\u001a\u00020\bJ\u0018\u0010\r\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\bR\"\u0010\u000b\u001a\u00020\n8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b\u000b\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001d\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u00138\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u001d\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00190\u00138\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u0016\u001a\u0004\b\u001b\u0010\u0018R\u001d\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00020\u001c8\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R\"\u0010\f\u001a\u00020\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\f\u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\"\u0010'\u001a\u00020&8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u0014\u0010-\u001a\u00020\u00048\u0002X\u0082D¢\u0006\u0006\n\u0004\b-\u0010.¨\u00061"}, d2 = {"Lcom/bytedance/android/shopping/store/aggregate/viewmodel/ShopAggregatePageViewModel;", "Lcom/bytedance/android/ec/core/arch/viewmodel/BaseViewModel;", "", "initStoreParam", "", "entranceInfo", "initEventBasicParams", "loadModuleDetail", "", "isStoreParamInit", "Lcom/bytedance/android/shopping/store/aggregate/ShopAggregateParam;", "storeParam", "doAddCarting", "init", "Lcom/bytedance/android/shopping/store/aggregate/ShopAggregateParam;", "getStoreParam", "()Lcom/bytedance/android/shopping/store/aggregate/ShopAggregateParam;", "setStoreParam", "(Lcom/bytedance/android/shopping/store/aggregate/ShopAggregateParam;)V", "Lcom/ss/android/ugc/aweme/kiwi/viewmodel/QLiveData;", "Lcom/bytedance/android/ec/store/shopping/paging/LoadStatus;", "loadStatus", "Lcom/ss/android/ugc/aweme/kiwi/viewmodel/QLiveData;", "getLoadStatus", "()Lcom/ss/android/ugc/aweme/kiwi/viewmodel/QLiveData;", "Luj3/e;", "storeModuleDetail", "getStoreModuleDetail", "Ljm/a;", "onPageSelect", "Ljm/a;", "getOnPageSelect", "()Ljm/a;", "Z", "getDoAddCarting", "()Z", "setDoAddCarting", "(Z)V", "Lcom/bytedance/android/ec/store/product/holder/LayoutTypes;", "layoutType", "Lcom/bytedance/android/ec/store/product/holder/LayoutTypes;", "getLayoutType", "()Lcom/bytedance/android/ec/store/product/holder/LayoutTypes;", "setLayoutType", "(Lcom/bytedance/android/ec/store/product/holder/LayoutTypes;)V", "TAG", "Ljava/lang/String;", "<init>", "()V", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ShopAggregatePageViewModel extends BaseViewModel {
    private final String TAG;
    private boolean doAddCarting;
    private LayoutTypes layoutType;
    private final QLiveData<LoadStatus> loadStatus;
    private final jm.a<Unit> onPageSelect;
    private final QLiveData<e> storeModuleDetail;
    public ShopAggregateParam storeParam;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ ShopAggregatePageViewModel a;

        public a(ShopAggregatePageViewModel r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            StoreModuleDetailDTO r4 = (StoreModuleDetailDTO) r3;
            if (r4.getStatusCode() != 0) goto L7;
            QLiveData<e> r0 = this.a.getStoreModuleDetail();
            int r1 = e.b;
            Intrinsics.checkNotNullParameter(r4, "dto");
            e r2 = new e();
            r2.a = r4.getBackgroundImg();
            r0.g(r2);
            return;
        }
    }

    public static final class b<T> implements Consumer {
        public static final b a = null;

        static {
            a = new b();
        }

        public b() {
        }

        public final /* bridge */ /* synthetic */ void accept(Object r1) {
            Throwable r2 = (Throwable) r1;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.shopping.store.aggregate.viewmodel.ShopAggregatePageViewModel$isStoreParamInit$1, reason: invalid class name */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
    final /* synthetic */ class AnonymousClass1 extends MutablePropertyReference0Impl {
        public AnonymousClass1(ShopAggregatePageViewModel r7) {
            super(r7, ShopAggregatePageViewModel.class, "storeParam", "getStoreParam()Lcom/bytedance/android/shopping/store/aggregate/ShopAggregateParam;", 0);
        }

        public Object get() {
            return ((ShopAggregatePageViewModel) ((CallableReference) this).receiver).getStoreParam();
        }

        public void set(Object r2) {
            ((ShopAggregatePageViewModel) ((CallableReference) this).receiver).setStoreParam((ShopAggregateParam) r2);
        }
    }

    public ShopAggregatePageViewModel() {
        super(null, null, 3, null);
        this.loadStatus = new QLiveData();
        this.storeModuleDetail = new QLiveData();
        this.onPageSelect = new jm.a(7);
        this.layoutType = LayoutTypes.RECYCLER_VIEW_ITEM_DOUBLE;
        this.TAG = "ShopAggregatePageViewModel";
    }

    private final void initStoreParam() {
        if (isStoreParamInit() == true) goto L20;
        return;
    L20:
        ShopAggregateParam r1 = this.storeParam;     // Catch: Exception -> L13
        if (r1 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("storeParam");     // Catch: Exception -> L13
    L8:
        Gson r2 = new Gson();     // Catch: Exception -> L13
        ShopAggregateParam r3 = this.storeParam;     // Catch: Exception -> L13
        if (r3 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("storeParam");     // Catch: Exception -> L13
    L11:
        r1.setCategoryInfo((CategoryInfo) r2.fromJson(r3.getCategoryInfoStr(), CategoryInfo.class));     // Catch: Exception -> L13
    L15:
        ShopAggregateParam r4 = this.storeParam;
        if (r4 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("storeParam");
    L18:
        r4.getCategoryInfoStr();
        return;
    L13:
        e = move-exception;
        dm.a.b r5 = dm.a.a;
        dm.a.a(this.TAG).b(e.toString(), null);
        goto L15
    }

    private final void loadModuleDetail() {
        int r0 = x.a;
        ShopAggregateParam r1 = this.storeParam;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("storeParam");
    L5:
        x.a("/aweme/v1/store/module/detail/", r1.getSecShopId());
        ECStoreApi.a.getClass();
        ECStoreApi r2 = ECStoreApi.a.a;
        if (r2 == null) goto L19;
        ShopAggregateParam r3 = this.storeParam;
        if (r3 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("storeParam");
    L10:
        String r4 = r3.getSecShopId();
        ShopAggregateParam r5 = this.storeParam;
        if (r5 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("storeParam");
    L13:
        Observable<StoreModuleDetailDTO> r6 = r2.getStoreModuleDetail(r4, (String) r5.getPassThroughParams().get("pass_through_api"));
        if (r6 == null) goto L20;
        Observable r7 = bg4.b.b(r6);
        if (r7 == null) goto L21;
        r7.subscribe(new a(this), b.a);
        return;
    L21:
        return;
    L20:
        return;
    }

    public final ShopAggregateParam getStoreParam() {
        ShopAggregateParam r0 = this.storeParam;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("storeParam");
    L5:
        return r0;
    }

    public final boolean isStoreParamInit() {
        if (this.storeParam == null) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean getDoAddCarting() {
        return this.doAddCarting;
    }

    public final LayoutTypes getLayoutType() {
        return this.layoutType;
    }

    public final QLiveData<LoadStatus> getLoadStatus() {
        return this.loadStatus;
    }

    public final jm.a<Unit> getOnPageSelect() {
        return this.onPageSelect;
    }

    public final QLiveData<e> getStoreModuleDetail() {
        return this.storeModuleDetail;
    }

    private final void initEventBasicParams(String r4) {
        if (isStoreParamInit() == true) goto L5;
        return;
    L5:
        SpreadBuilder r0 = new SpreadBuilder(2);
        ShopAggregateParam r1 = this.storeParam;
        if (r1 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("storeParam");
    L8:
        r0.addSpread(com.bytedance.android.shopping.store.aggregate.viewmodel.a.a(r1, r4));
        ShopAggregateParam r5 = this.storeParam;
        if (r5 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("storeParam");
    L11:
        Intrinsics.checkNotNullParameter(r5, "storeParam");
        r0.addSpread(z.b(r5.getShopId(), r5.getSecShopId()));
        initEventContext((Pair[]) r0.toArray(new Pair[r0.size()]));
    }

    public final void setDoAddCarting(boolean r1) {
        this.doAddCarting = r1;
    }

    public final void setLayoutType(LayoutTypes r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.layoutType = r2;
    }

    public final void setStoreParam(ShopAggregateParam r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.storeParam = r2;
    }

    public final void init(ShopAggregateParam r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "storeParam");
        this.storeParam = r2;
        initStoreParam();
        this.doAddCarting = r3;
        if (r2.getShowAddCart() == false) goto L5;
        loadModuleDetail();
    L5:
        initEventBasicParams(r2.getEntranceInfo());
    }

    public static /* synthetic */ void init$default(ShopAggregatePageViewModel r0, ShopAggregateParam r1, boolean r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = false;
    L5:
        r0.init(r1, r2);
    }
}
