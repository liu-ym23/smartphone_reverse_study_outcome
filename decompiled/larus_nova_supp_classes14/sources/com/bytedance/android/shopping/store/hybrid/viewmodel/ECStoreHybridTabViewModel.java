package com.bytedance.android.shopping.store.hybrid.viewmodel;

import com.bytedance.android.ec.core.utils.t0;
import com.bytedance.android.ec.hybrid.list.util.k;
import com.bytedance.android.ec.store.monitor.ErrorCode;
import com.bytedance.android.ec.store.monitor.ErrorDomain;
import com.bytedance.android.ec.store.setting.ECStoreSettings;
import com.bytedance.android.ec.store.shopping.paging.LoadStatus;
import com.bytedance.android.shopping.store.home.api.ECStoreParam;
import com.bytedance.android.shopping.store.home.entity.ECStoreDynamicTabConfig;
import com.bytedance.android.shopping.store.home.entity.ECStoreDynamicTabDTO;
import com.bytedance.android.shopping.store.home.entity.ECStoreDynamicTabData;
import com.bytedance.android.shopping.store.hybrid.StoreTabConfig;
import com.bytedance.android.shopping.store.hybrid.api.ECStoreHybridTabApi;
import com.bytedance.android.shopping.store.hybrid.entity.ComponentsWrapper;
import com.bytedance.android.shopping.store.hybrid.entity.ECStoreHybridTabInitialDataResponseDTO;
import com.bytedance.android.shopping.store.hybrid.entity.ECStoreHybridTabInitialDataResponseVO;
import com.bytedance.android.shopping.store.lifecycle.m;
import com.bytedance.android.shopping.store.settings.ECShopABSettings;
import com.bytedance.android.shopping.store.viewmodel.ECStoreBaseViewModel;
import com.bytedance.retrofit2.Call;
import com.bytedance.retrofit2.Callback;
import com.bytedance.retrofit2.SsResponse;
import com.google.gson.JsonObject;
import com.ss.android.ugc.aweme.kiwi.viewmodel.QLiveData;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u00002\u00020\u0001:\u00016B\u0007¢\u0006\u0004\b4\u00105J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002J\"\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0002J \u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0012H\u0002J.\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00102\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0014\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0015J\u000e\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006R\"\u0010\u0011\u001a\u00020\u00108\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b\u0011\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u0017\u0010\u001f\u001a\u00020\u001e8\u0006¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"R\u001d\u0010%\u001a\b\u0012\u0004\u0012\u00020$0#8\u0006¢\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(R\u001d\u0010*\u001a\b\u0012\u0004\u0012\u00020\u000b0)8\u0006¢\u0006\f\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-R\u001d\u0010.\u001a\b\u0012\u0004\u0012\u00020\r0#8\u0006¢\u0006\f\n\u0004\b.\u0010&\u001a\u0004\b.\u0010(R0\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00158\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010/\u001a\u0004\b0\u00101\"\u0004\b2\u00103¨\u00067"}, d2 = {"Lcom/bytedance/android/shopping/store/hybrid/viewmodel/ECStoreHybridTabViewModel;", "Lcom/bytedance/android/shopping/store/viewmodel/ECStoreBaseViewModel;", "", "entranceInfo", "", "initEventParams", "Lcom/bytedance/android/shopping/store/hybrid/StoreTabConfig;", "tabConfig", "Lcom/bytedance/android/shopping/store/home/entity/ECStoreDynamicTabDTO;", "dynamicTabVO", "prepareDynamicTabInitialData", "Lcom/bytedance/android/shopping/store/hybrid/entity/ECStoreHybridTabInitialDataResponseVO;", "responseVO", "", "needDynamicData", "checkAndReportResponseDataEmpty", "Lcom/bytedance/android/shopping/store/home/api/ECStoreParam;", "storeParam", "Lcom/bytedance/android/shopping/store/hybrid/viewmodel/ECStoreHybridTabViewModel$a;", "listener", "requestInitialData", "", "logExtra", "init", "loadInitialData", "Lcom/bytedance/android/shopping/store/home/api/ECStoreParam;", "getStoreParam", "()Lcom/bytedance/android/shopping/store/home/api/ECStoreParam;", "setStoreParam", "(Lcom/bytedance/android/shopping/store/home/api/ECStoreParam;)V", "Laj3/a;", "dataSource", "Laj3/a;", "getDataSource", "()Laj3/a;", "Lcom/ss/android/ugc/aweme/kiwi/viewmodel/QLiveData;", "Lcom/bytedance/android/ec/store/shopping/paging/LoadStatus;", "loadStatus", "Lcom/ss/android/ugc/aweme/kiwi/viewmodel/QLiveData;", "getLoadStatus", "()Lcom/ss/android/ugc/aweme/kiwi/viewmodel/QLiveData;", "Ljm/a;", "hybridInitialData", "Ljm/a;", "getHybridInitialData", "()Ljm/a;", "isVisible", "Ljava/util/Map;", "getLogExtra", "()Ljava/util/Map;", "setLogExtra", "(Ljava/util/Map;)V", "<init>", "()V", "a", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECStoreHybridTabViewModel extends ECStoreBaseViewModel {
    private final aj3.a dataSource;
    private final jm.a<ECStoreHybridTabInitialDataResponseVO> hybridInitialData;
    private final QLiveData<Boolean> isVisible;
    private final QLiveData<LoadStatus> loadStatus;
    private Map<String, String> logExtra;
    public ECStoreParam storeParam;

    public interface a {
        void a(boolean r1, ECStoreHybridTabInitialDataResponseVO r2);
    }

    public static final class b implements a {
        public final /* synthetic */ ECStoreHybridTabViewModel a;
        public final /* synthetic */ StoreTabConfig b;
        public final /* synthetic */ ECStoreDynamicTabConfig c;

        @Override // com.bytedance.android.shopping.store.hybrid.viewmodel.ECStoreHybridTabViewModel.a
        public final void a(boolean r5, ECStoreHybridTabInitialDataResponseVO r6) {
            boolean r0 = false;
            if (r5 == false) goto L17;
            if (r6 == null) goto L17;
            String r7 = r6.getBundleUrl();
            if (r7 != null) goto L8;
        L11:
            boolean r8 = true;
        L12:
            if (r8 == true) goto L17;
            LinkedHashMap r9 = new LinkedHashMap();
            String r2 = r6.getPassThrough2FE();
            if (r2 != null) goto L16;
            r2 = "";
        L16:
            r9.put("pass_through_fe", r2);
            this.b.setExternalMetaInfo(r9);
            this.a.getHybridInitialData().setValue(r6);
        L18:
            ECStoreHybridTabViewModel r10 = this.a;
            StoreTabConfig r3 = this.b;
            ECStoreDynamicTabConfig r4 = this.c;
            if (r4 != null) goto L21;
        L23:
            ECStoreHybridTabViewModel.access$checkAndReportResponseDataEmpty(r10, r3, r6, r0);
            return;
        L21:
            if (r4.getNeedDynamicData() != true) goto L23;
            r0 = true;
            goto L23
        L8:
            if (StringsKt.isBlank(r7) == true) goto L11;
            r8 = false;
        L17:
            this.a.getLoadStatus().g(LoadStatus.InitializeError);
            goto L18
        }

        public b(ECStoreHybridTabViewModel r1, StoreTabConfig r2, ECStoreDynamicTabConfig r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }
    }

    public static final class c implements Callback<String> {
        public final /* synthetic */ ECStoreParam a;
        public final /* synthetic */ StoreTabConfig b;
        public final /* synthetic */ a c;

        public final void onFailure(Call<String> r3, Throwable r4) {
            Intrinsics.checkNotNullParameter(r3, "call");
            Intrinsics.checkNotNullParameter(r4, "t");
            Map<Long, m> r5 = com.bytedance.android.shopping.store.lifecycle.a.a;
            if (com.bytedance.android.shopping.store.lifecycle.a.a(Long.valueOf(this.a.getLifecycleMonitorId())) == null) goto L5;
            ErrorDomain.NATIVE.getCode();
            ErrorCode.NATIVE_COMMON.getCode();
            r4.getMessage();
        L5:
            this.c.a(false, null);
        }

        public final void onResponse(Call<String> r6, SsResponse<String> r7) {
            Intrinsics.checkNotNullParameter(r6, "call");
            Intrinsics.checkNotNullParameter(r7, "response");
            Result.Companion r8 = Result.Companion;     // Catch: Throwable -> L5
            int r9 = t0.a;     // Catch: Throwable -> L5
            Object r10 = Result.constructor-impl((ECStoreHybridTabInitialDataResponseDTO) t0.a.a.fromJson((String) r7.body(), ECStoreHybridTabInitialDataResponseDTO.class));     // Catch: Throwable -> L5
        L7:
            String r1 = null;
            if (Result.isFailure-impl(r10) == false) goto L10;
            r10 = null;
        L10:
            ECStoreHybridTabInitialDataResponseDTO r11 = (ECStoreHybridTabInitialDataResponseDTO) r10;
            boolean r0 = false;
            if (r11 != null) goto L13;
        L29:
            Map<Long, m> r12 = com.bytedance.android.shopping.store.lifecycle.a.a;
            if (com.bytedance.android.shopping.store.lifecycle.a.a(Long.valueOf(this.a.getLifecycleMonitorId())) == null) goto L40;
            if (r11 == null) goto L33;
            ErrorDomain r13 = ErrorDomain.NET;
        L34:
            r13.getCode();
            if (r11 == null) goto L37;
            r11.getStatusCode();
        L38:
            if (r11 == null) goto L40;
            r11.getStatusMsg();
            goto L40
        L37:
            ErrorCode.NATIVE_COMMON.getCode();
            goto L38
        L33:
            r13 = ErrorDomain.NATIVE;
        L40:
            this.c.a(false, null);
            return;
        L13:
            if (r11.getStatusCode() != 0) goto L29;
            Map<Long, m> r2 = com.bytedance.android.shopping.store.lifecycle.a.a;
            m r3 = com.bytedance.android.shopping.store.lifecycle.a.a(Long.valueOf(this.a.getLifecycleMonitorId()));
            if (r3 == null) goto L18;
            r3.s(this.b);
        L18:
            ECStoreHybridTabInitialDataResponseVO.Companion.getClass();
            Intrinsics.checkNotNullParameter(r11, "dto");
            ECStoreHybridTabInitialDataResponseVO r4 = new ECStoreHybridTabInitialDataResponseVO();
            r4.setBundleUrl(r11.getBundleUrl());
            r4.setPassThrough2FE(r11.getPassThrough2FE());
            r4.setComponentsWrapper(new ComponentsWrapper(r11.getComponents(), r11.getBlock()));
            String r14 = r4.getBundleUrl();
            if (r14 != null) goto L21;
        L22:
            r0 = true;
        L23:
            if (r0 == false) goto L28;
            ECStoreDynamicTabDTO r15 = this.b.getDynamicTabVO();
            if (r15 == null) goto L27;
            r1 = r15.getBundleUrl();
        L27:
            r4.setBundleUrl(r1);
        L28:
            r4.setRaw((String) r7.body());
            this.c.a(true, r4);
            return;
        L21:
            if (StringsKt.isBlank(r14) == false) goto L23;
        L5:
            th = move-exception;
            Result.Companion r5 = Result.Companion;
            r10 = Result.constructor-impl(ResultKt.createFailure(th));
            goto L7
        }

        public c(ECStoreParam r1, StoreTabConfig r2, a r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }
    }

    public ECStoreHybridTabViewModel() {
        super(null, null, 3, null);
        this.dataSource = new aj3.a();
        this.loadStatus = new QLiveData();
        this.hybridInitialData = new jm.a(7);
        QLiveData<Boolean> r0 = new QLiveData();
        r0.g(Boolean.FALSE);
        Unit r1 = Unit.INSTANCE;
        this.isVisible = r0;
    }

    public final ECStoreParam getStoreParam() {
        ECStoreParam r0 = this.storeParam;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("storeParam");
    L5:
        return r0;
    }

    public final aj3.a getDataSource() {
        return this.dataSource;
    }

    public final jm.a<ECStoreHybridTabInitialDataResponseVO> getHybridInitialData() {
        return this.hybridInitialData;
    }

    public final QLiveData<LoadStatus> getLoadStatus() {
        return this.loadStatus;
    }

    public final Map<String, String> getLogExtra() {
        return this.logExtra;
    }

    public final QLiveData<Boolean> isVisible() {
        return this.isVisible;
    }

    private final void initEventParams(String r5) {
        Pair<String, String>[] r0 = new Pair[12];
        ECStoreParam r1 = this.storeParam;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("storeParam");
    L5:
        r0[0] = TuplesKt.to("author_id", r1.getStoreAccountParam().getUserId());
        ECStoreParam r2 = this.storeParam;
        if (r2 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("storeParam");
    L8:
        r0[1] = TuplesKt.to("shop_id", r2.getShopId());
        ECStoreParam r3 = this.storeParam;
        if (r3 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("storeParam");
    L11:
        r0[2] = TuplesKt.to("sec_shop_id", r3.getSecShopId());
        ECStoreParam r4 = this.storeParam;
        if (r4 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("storeParam");
    L14:
        r0[3] = TuplesKt.to("entrance_location", r4.getEntranceLocation());
        ECStoreParam r6 = this.storeParam;
        if (r6 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("storeParam");
    L17:
        r0[4] = TuplesKt.to("store_source_page", r6.getStoreSourcePage());
        ECStoreParam r7 = this.storeParam;
        if (r7 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("storeParam");
    L20:
        r0[5] = TuplesKt.to("store_source_method", r7.getStoreSourceMethod());
        ECStoreParam r8 = this.storeParam;
        if (r8 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("storeParam");
    L23:
        r0[6] = TuplesKt.to("store_group_type", r8.getStoreGroupType());
        ECStoreParam r9 = this.storeParam;
        if (r9 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("storeParam");
    L26:
        Integer r10 = r9.getFollowStatus();
        if (r10 == null) goto L29;
        String r11 = String.valueOf(r10.intValue());
    L30:
        r0[7] = TuplesKt.to("follow_status", r11);
        ECStoreParam r12 = this.storeParam;
        if (r12 != null) goto L33;
        Intrinsics.throwUninitializedPropertyAccessException("storeParam");
    L33:
        r0[8] = TuplesKt.to("which_account", r12.getWhichAccount());
        ECStoreParam r13 = this.storeParam;
        if (r13 != null) goto L36;
        Intrinsics.throwUninitializedPropertyAccessException("storeParam");
    L36:
        r0[9] = TuplesKt.to("page_name", r13.getPageName());
        ECStoreParam r14 = this.storeParam;
        if (r14 != null) goto L39;
        Intrinsics.throwUninitializedPropertyAccessException("storeParam");
    L39:
        r0[10] = TuplesKt.to("temp_id", r14.getTempId());
        r0[11] = TuplesKt.to("entrance_info", r5);
        initEventContext(r0);
        return;
    L29:
        r11 = null;
        goto L30
    }

    public final void loadInitialData(StoreTabConfig r3) {
        Intrinsics.checkNotNullParameter(r3, "tabConfig");
        ECStoreDynamicTabDTO r0 = r3.getDynamicTabVO();
        if (r0 != null) goto L5;
    L9:
        this.loadStatus.g(LoadStatus.InitializeError);
        return;
    L5:
        if (r3.isDynamicTabConfig() == false) goto L9;
        prepareDynamicTabInitialData(r3, r0);
    }

    public final void setLogExtra(Map<String, String> r1) {
        this.logExtra = r1;
    }

    public final void setStoreParam(ECStoreParam r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.storeParam = r2;
    }

    private final void prepareDynamicTabInitialData(StoreTabConfig r5, ECStoreDynamicTabDTO r6) {
        this.loadStatus.g(LoadStatus.Initialize);
        ECStoreDynamicTabConfig r0 = r6.getConfig();
        String r1 = r6.getBundleUrl();
        if (r1 != null) goto L5;
    L8:
        boolean r2 = true;
    L9:
        if (r2 == true) goto L30;
        if (r0 != null) goto L12;
    L18:
        r5.setFetchDynamicTabInitialData(false);
        ECStoreHybridTabInitialDataResponseVO r7 = new ECStoreHybridTabInitialDataResponseVO();
        r7.setBundleUrl(r6.getBundleUrl());
        ECStoreDynamicTabData r3 = r6.getData();
        String r4 = null;
        if (r3 == null) goto L21;
        List<HashMap<String, Object>> r8 = r3.getComponents();
    L22:
        ECStoreDynamicTabData r9 = r6.getData();
        if (r9 == null) goto L25;
        JsonObject r10 = r9.getBlock();
    L26:
        r7.setComponentsWrapper(new ComponentsWrapper(r8, r10));
        ECStoreDynamicTabData r11 = r6.getData();
        if (r11 == null) goto L29;
        r4 = r11.getRaw();
    L29:
        r7.setRaw(r4);
        this.hybridInitialData.setValue(r7);
        return;
    L25:
        r10 = null;
        goto L26
    L21:
        r8 = null;
        goto L22
    L12:
        if (r0.getNeedDynamicData() != true) goto L18;
        ECStoreDynamicTabData r12 = r6.getData();
        if (r12 == null) goto L30;
        if (r12.containsHybridTabData() == true) goto L18;
    L30:
        ECStoreParam r13 = this.storeParam;
        if (r13 != null) goto L33;
        Intrinsics.throwUninitializedPropertyAccessException("storeParam");
    L33:
        requestInitialData(r13, r5, new b(this, r5, r0));
        return;
    L5:
        if (StringsKt.isBlank(r1) == true) goto L8;
        r2 = false;
        goto L9
    }

    private final void checkAndReportResponseDataEmpty(StoreTabConfig r4, ECStoreHybridTabInitialDataResponseVO r5, boolean r6) {
        if (r5 == null) goto L30;
        String r0 = r5.getBundleUrl();
        boolean r1 = false;
        if (r0 != null) goto L7;
    L10:
        boolean r2 = true;
    L11:
        if (r2 == true) goto L30;
        if (r6 == true) goto L15;
        return;
    L15:
        if (r5.hasComponents() == true) goto L38;
        String r7 = r5.getRaw();
        if (r7 != null) goto L19;
    L20:
        r1 = true;
    L21:
        if (r1 == false) goto L23;
    L24:
        Map<Long, m> r8 = com.bytedance.android.shopping.store.lifecycle.a.a;
        ECStoreParam r9 = this.storeParam;
        if (r9 != null) goto L28;
        Intrinsics.throwUninitializedPropertyAccessException("storeParam");
    L28:
        if (com.bytedance.android.shopping.store.lifecycle.a.a(Long.valueOf(r9.getLifecycleMonitorId())) == null) goto L40;
        ErrorDomain.HYBRID_DATA_CHECK.getCode();
        ErrorCode.HYBRID_DATA_EMPTY.getCode();
        return;
    L40:
        return;
    L23:
        if ((!Intrinsics.areEqual(r5.getRaw(), "{}")) == false) goto L24;
        return;
    L19:
        if (StringsKt.isBlank(r7) == false) goto L21;
    L38:
        return;
    L7:
        if (StringsKt.isBlank(r0) == true) goto L10;
        r2 = false;
    L30:
        Map<Long, m> r10 = com.bytedance.android.shopping.store.lifecycle.a.a;
        ECStoreParam r11 = this.storeParam;
        if (r11 != null) goto L34;
        Intrinsics.throwUninitializedPropertyAccessException("storeParam");
    L34:
        if (com.bytedance.android.shopping.store.lifecycle.a.a(Long.valueOf(r11.getLifecycleMonitorId())) == null) goto L42;
        ErrorDomain.HYBRID_DATA_CHECK.getCode();
        ErrorCode.HYBRID_BUNDLE_URL_EMPTY.getCode();
        return;
    }

    private final void requestInitialData(ECStoreParam r12, StoreTabConfig r13, a r14) {
        boolean r0 = true;
        r13.setFetchDynamicTabInitialData(true);
        Map<Long, m> r1 = com.bytedance.android.shopping.store.lifecycle.a.a;
        m r2 = com.bytedance.android.shopping.store.lifecycle.a.a(Long.valueOf(r12.getLifecycleMonitorId()));
        if (r2 == null) goto L5;
        r2.k(r13);
    L5:
        this.dataSource.getClass();
        Intrinsics.checkNotNullParameter(r12, "storeParam");
        Intrinsics.checkNotNullParameter(r13, "tabConfig");
        ECStoreDynamicTabDTO r3 = r13.getDynamicTabVO();
        if (r3 == null) goto L10;
        ECStoreDynamicTabConfig r4 = r3.getConfig();
        if (r4 == null) goto L10;
        String r5 = r4.getApiPath();
    L12:
        if (r5 != null) goto L14;
    L17:
        if (r0 == true) goto L22;
        ECStoreHybridTabApi.a.getClass();
        ECStoreHybridTabApi r6 = ECStoreHybridTabApi.a.a;
        if (r6 == null) goto L22;
        Call<String> r7 = r6.getInitialDataRaw(r5, r12.getSecShopId(), r13.getTabType(), (String) r12.getPassThroughParam("pass_through_api"), ECStoreSettings.h(), k.d(ECShopABSettings.k.b()), r13.getApiExtraParamsWith(r12.getSchemaQueryMap()));
    L23:
        if (r7 == null) goto L25;
        r7.enqueue(new c(r12, r13, r14));
        return;
    L25:
        if (com.bytedance.android.shopping.store.lifecycle.a.a(Long.valueOf(r12.getLifecycleMonitorId())) == null) goto L27;
        ErrorDomain.NATIVE.getCode();
        ErrorCode.NATIVE_COMMON.getCode();
    L27:
        r14.a(false, null);
        return;
    L22:
        r7 = null;
        goto L23
    L14:
        if (StringsKt.isBlank(r5) == true) goto L17;
        r0 = false;
    L10:
        r5 = null;
        goto L12
    }

    public final void init(ECStoreParam r3, String r4, Map<String, String> r5) {
        Intrinsics.checkNotNullParameter(r3, "storeParam");
        this.storeParam = r3;
        this.logExtra = r5;
        bindMonitorId(Long.valueOf(r3.getLifecycleMonitorId()));
        initEventParams(r4);
    }

    public static final /* synthetic */ void access$checkAndReportResponseDataEmpty(ECStoreHybridTabViewModel r0, StoreTabConfig r1, ECStoreHybridTabInitialDataResponseVO r2, boolean r3) {
        r0.checkAndReportResponseDataEmpty(r1, r2, r3);
    }
}
